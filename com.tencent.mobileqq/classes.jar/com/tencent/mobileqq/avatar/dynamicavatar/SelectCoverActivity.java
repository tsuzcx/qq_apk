package com.tencent.mobileqq.avatar.dynamicavatar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.OnProgressChangedListener;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.OnGetFrameListener;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;

public class SelectCoverActivity
  extends IphoneTitleBarActivity
  implements DialogInterface.OnCancelListener, Handler.Callback, View.OnClickListener, View.OnTouchListener, DrawableSeekbar.OnProgressChangedListener, VideoDrawableHandler.OnGetFrameListener
{
  String A;
  int B;
  String C;
  String D;
  boolean E;
  volatile boolean F = false;
  DynamicAvatarManager G;
  SelectCoverActivity.CoverTransProcessorHandler H;
  private boolean I;
  private String J;
  private final Object K = new Object();
  private boolean L;
  CustomImgView a;
  DrawableSeekbar b;
  VideoDrawableHandler c;
  LinearLayout d;
  Drawable e;
  VideoDrawable f;
  VideoDrawable g;
  VideoDrawable h;
  Handler i = new Handler(ThreadManager.getFileThreadLooper(), this);
  Handler j = new Handler(Looper.getMainLooper(), this);
  int k;
  int l;
  int m;
  String n;
  Animator o = null;
  float p = 0.0F;
  Rect q = null;
  Rect r = null;
  View s;
  View t;
  View u;
  View v;
  View w;
  int x;
  int y;
  QQProgressNotifier z;
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    this.j.obtainMessage(7, paramInt1, paramInt2, paramString).sendToTarget();
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.K)
    {
      this.L = paramBoolean;
      return;
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.f = new VideoDrawable(paramBitmap, getResources());
    this.g = new VideoDrawable(paramBitmap, getResources());
    this.h = new VideoDrawable(paramBitmap, getResources());
    this.a.setImageDrawable(this.f);
    this.s.setBackgroundDrawable(this.h);
    this.c.a(this.f);
    this.c.a(this.g);
    this.c.a(this.h);
    this.h.a(true);
    this.b.setOnProgressChangedListener(this);
    this.b.setThumb(a(this.g));
    this.b.setMax((int)this.c.a());
    paramBitmap = this.b;
    int i1 = this.m;
    paramBitmap.setThumbSize(i1, i1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity, FileMsg paramFileMsg)
  {
    if (paramSelectCoverActivity.l())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage upload canceled.");
      }
      FaceUtil.e(null);
      return;
    }
    if (paramFileMsg.fileType == 48)
    {
      f(paramQQAppInterface, paramSelectCoverActivity, paramFileMsg);
      return;
    }
    if (paramFileMsg.fileType == 36)
    {
      e(paramQQAppInterface, paramSelectCoverActivity, paramFileMsg);
      return;
    }
    if (paramFileMsg.fileType == 37)
    {
      d(paramQQAppInterface, paramSelectCoverActivity, paramFileMsg);
      return;
    }
    if (paramFileMsg.fileType == 38) {
      c(paramQQAppInterface, paramSelectCoverActivity, paramFileMsg);
    }
  }
  
  private static void b(SelectCoverActivity paramSelectCoverActivity, FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, String.format("mPhotoUploadHandler.handleMessage() upload photo failed, errorCode=%s", new Object[] { Integer.valueOf(paramFileMsg.errorCode) }));
    }
    if (paramFileMsg.errorCode == 1503)
    {
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131897181, 0).show(paramSelectCoverActivity.getTitleBarHeight());
      paramSelectCoverActivity = paramSelectCoverActivity.z;
      if (paramSelectCoverActivity != null) {
        paramSelectCoverActivity.b();
      }
    }
    else
    {
      paramSelectCoverActivity.a(2, paramSelectCoverActivity.getString(2131911165), 0);
    }
    FaceUtil.e(null);
  }
  
  private void c(View paramView1, View paramView2)
  {
    this.q = new Rect();
    this.r = new Rect();
    Point localPoint = new Point();
    paramView1.getGlobalVisibleRect(this.q);
    this.v.getGlobalVisibleRect(this.r, localPoint);
    paramView2.getGlobalVisibleRect(this.r);
    this.q.offset(-localPoint.x, -localPoint.y);
    this.r.offset(-localPoint.x, -localPoint.y);
    if (this.r.width() / this.r.height() > this.q.width() / this.q.height())
    {
      this.p = (this.q.height() / this.r.height());
      f1 = (this.p * this.r.width() - this.q.width()) / 2.0F;
      paramView1 = this.q;
      paramView1.left = ((int)(paramView1.left - f1));
      paramView1 = this.q;
      paramView1.right = ((int)(paramView1.right + f1));
      return;
    }
    this.p = (this.q.width() / this.r.width());
    float f1 = (this.p * this.r.height() - this.q.height()) / 2.0F;
    paramView1 = this.q;
    paramView1.top = ((int)(paramView1.top - f1));
    paramView1 = this.q;
    paramView1.bottom = ((int)(paramView1.bottom + f1));
  }
  
  private static void c(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity, FileMsg paramFileMsg)
  {
    paramFileMsg = ((NearbyPeoplePhotoUploadProcessor)paramFileMsg.processor).mVideoId;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPhotoUploadHandler.handleMessage(), small video upload success. videoId = ");
      localStringBuilder.append(paramFileMsg);
      QLog.i("SelectCoverActivity", 2, localStringBuilder.toString());
    }
    DynamicUtils.a(paramQQAppInterface, paramSelectCoverActivity.A);
    FaceUtil.e(paramSelectCoverActivity.A);
  }
  
  @TargetApi(11)
  private void d()
  {
    this.a = ((CustomImgView)findViewById(2131440610));
    this.s = findViewById(2131434878);
    this.v = findViewById(2131431280);
    this.t = findViewById(2131434886);
    this.u = findViewById(2131434917);
    this.b = ((DrawableSeekbar)findViewById(2131445507));
    this.d = ((LinearLayout)findViewById(2131437576));
    this.w = findViewById(2131448510);
    int i3 = ImmersiveUtils.getScreenWidth();
    int i2 = ImmersiveUtils.getScreenHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = i3;
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    double d1 = i2;
    Double.isNaN(d1);
    int i4 = (int)(d1 * 0.125D);
    float f1 = i3;
    int i1 = (int)(0.125F * f1);
    i2 = (int)(i2 - (getTitleBarHeight() + i4 + this.mDensity * 100.0F + ImmersiveUtils.getStatusBarHeight(this)));
    int i5 = i3 - i1 * 2;
    float f2 = i2;
    float f3 = f2 / i5;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remainHeight:");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" remainWidth:");
      ((StringBuilder)localObject).append(i5);
      ((StringBuilder)localObject).append(" scale:");
      ((StringBuilder)localObject).append(f3);
      QLog.i("SelectCoverActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (f3 < 1.229437F)
    {
      i2 = (int)((f1 - f2 / 1.229437F) * 0.5F);
      i1 = i2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recalc margin margin:");
        ((StringBuilder)localObject).append(i2);
        QLog.i("SelectCoverActivity", 2, ((StringBuilder)localObject).toString());
        i1 = i2;
      }
    }
    localObject = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i1;
    this.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (Build.VERSION.SDK_INT <= 9)
    {
      this.b.setVisibility(8);
      findViewById(2131447316).setVisibility(8);
      this.w.setVisibility(8);
    }
    else
    {
      this.l = ((int)getResources().getDimension(2131299903));
      this.m = ((int)getResources().getDimension(2131299907));
      localObject = (RelativeLayout.LayoutParams)this.w.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = i4;
      this.w.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i1 = i3 - (int)getResources().getDimension(2131299902) * 2;
      i2 = this.l;
      this.k = (i1 / i2);
      if (i1 % i2 != 0) {
        this.k += 1;
      }
      i1 = this.l;
      localObject = new LinearLayout.LayoutParams(i1, i1);
      if (this.e == null) {
        this.e = new ColorDrawable(-2147483648);
      }
      i1 = 0;
      while (i1 < this.k)
      {
        CustomImgView localCustomImgView = new CustomImgView(this);
        localCustomImgView.a.setScaleType(ImageView.ScaleType.FIT_XY);
        localCustomImgView.setBackgroundDrawable(this.e);
        this.d.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject);
        i1 += 1;
      }
    }
    localObject = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
    if (k())
    {
      ((RelativeLayout.LayoutParams)localObject).rightMargin += 10;
      ((RelativeLayout.LayoutParams)localObject).topMargin += 50;
      ((RelativeLayout.LayoutParams)localObject).height = 154;
      ((RelativeLayout.LayoutParams)localObject).width = 154;
      this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity, FileMsg paramFileMsg)
  {
    paramFileMsg = ((NearbyPeoplePhotoUploadProcessor)paramFileMsg.processor).mVideoId;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPhotoUploadHandler.handleMessage(), medium video upload success. videoId = ");
      localStringBuilder.append(paramFileMsg);
      QLog.i("SelectCoverActivity", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new SelectCoverActivity.4(paramSelectCoverActivity, paramQQAppInterface), 8, null, true);
  }
  
  private void e()
  {
    setRightButton(2131889474, this);
    if (this.x == 3) {
      setTitle("设置QQ动态头像");
    } else {
      setTitle(HardCodeUtil.a(2131911166));
    }
    if (ThemeUtil.isNowThemeIsSimple(this.app, false, null))
    {
      this.leftView.setBackgroundResource(2130853299);
      this.rightViewText.setTextColor(getResources().getColorStateList(2131167219));
      this.centerView.setTextColor(getResources().getColorStateList(2131167219));
    }
    int i1 = Color.parseColor("#1a1a1a");
    getTitleBarView().setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(i1);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
    }
  }
  
  private static void e(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity, FileMsg paramFileMsg)
  {
    paramFileMsg = ((NearbyPeoplePhotoUploadProcessor)paramFileMsg.processor).mVideoId;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPhotoUploadHandler.handleMessage(), big video upload success. videoId = ");
      localStringBuilder.append(paramFileMsg);
      QLog.i("SelectCoverActivity", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new SelectCoverActivity.5(paramSelectCoverActivity, paramQQAppInterface), 8, null, true);
  }
  
  private void f()
  {
    Object localObject = DynamicUtils.a(this.n, 200);
    DynamicUtils.a(this.n, (String)localObject, 200, this);
    this.G.b = ((String)localObject);
    localObject = DynamicUtils.a(this.n, 100);
    DynamicUtils.a(this.n, (String)localObject, 100, this);
    this.G.c = ((String)localObject);
    localObject = this.z;
    int i1;
    if ((localObject != null) && (((QQProgressNotifier)localObject).c())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if ((!TextUtils.isEmpty(this.G.b)) && (new File(this.G.b).exists()) && (!TextUtils.isEmpty(this.G.c)) && (new File(this.G.c).exists()))
      {
        j();
        return;
      }
      this.z.b();
      a(2, HardCodeUtil.a(2131911168), 0);
    }
  }
  
  private static void f(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity, FileMsg paramFileMsg)
  {
    paramFileMsg = ((NearbyPeoplePhotoUploadProcessor)paramFileMsg.processor).mPhotoUrl;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = ");
      ((StringBuilder)localObject).append(paramFileMsg);
      QLog.i("SelectCoverActivity", 2, ((StringBuilder)localObject).toString());
    }
    paramFileMsg = (CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramFileMsg != null) {
      paramFileMsg.a(true, paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    FaceUtil.e(null);
    if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
    }
    if (paramSelectCoverActivity.x != 3)
    {
      int i1 = paramSelectCoverActivity.B;
      localObject = paramSelectCoverActivity.C;
      String str = paramSelectCoverActivity.D;
      if (paramSelectCoverActivity.E) {
        paramFileMsg = "1";
      } else {
        paramFileMsg = "0";
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800711D", "0X800711D", 0, 0, String.valueOf(i1), (String)localObject, str, paramFileMsg);
    }
    if (paramSelectCoverActivity.I)
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("key_photo_file_path", paramSelectCoverActivity.J);
      paramSelectCoverActivity.setResult(-1, paramQQAppInterface);
    }
    else if (paramSelectCoverActivity.x == 3)
    {
      paramFileMsg = new Intent(paramSelectCoverActivity, AvatarPendantActivity.class);
      localObject = paramSelectCoverActivity.getIntent();
      paramFileMsg.putExtra("fromThirdApp", true);
      paramFileMsg.putExtra("pkg_name", ((Intent)localObject).getStringExtra("pkg_name"));
      paramFileMsg.putExtra("app_name", ((Intent)localObject).getStringExtra("app_name"));
      localObject = ((Intent)localObject).getStringExtra("share_id");
      paramFileMsg.putExtra("share_id", (String)localObject);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009DFA", "0X8009DFA", 0, 0, (String)localObject, "", "", "");
      paramFileMsg.putExtra("AllInOne", new AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0));
      paramSelectCoverActivity.startActivity(paramFileMsg);
    }
    else
    {
      paramSelectCoverActivity.setResult(-1);
    }
    paramSelectCoverActivity.finish();
  }
  
  private void g()
  {
    if (VersionUtils.d())
    {
      a(this.s, this.a);
      return;
    }
    this.a.setVisibility(0);
    this.s.setVisibility(8);
    this.t.setVisibility(8);
    this.w.setVisibility(8);
  }
  
  private void h()
  {
    if (VersionUtils.d())
    {
      b(this.s, this.a);
      return;
    }
    this.a.setVisibility(8);
    this.s.setVisibility(0);
    this.t.setVisibility(0);
    this.w.setVisibility(0);
  }
  
  private int i()
  {
    int i2 = this.x;
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    return i1;
  }
  
  private void j()
  {
    this.y = ((int)(System.currentTimeMillis() / 1000L));
    DynamicUtils.a(this.app, this.n, 36, this.y, 640);
    FaceUtil.e(this.n);
    a(false);
  }
  
  private boolean k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = ((String)localObject).equalsIgnoreCase("Xiaomi-MI NOTE Pro");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isxiaomi:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" deviceinfo:");
      localStringBuilder.append((String)localObject);
      QLog.i("SelectCoverActivity", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean l()
  {
    synchronized (this.K)
    {
      boolean bool = this.L;
      return bool;
    }
  }
  
  Drawable a(Drawable paramDrawable)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { paramDrawable, (GradientDrawable)getResources().getDrawable(2130847527) });
    int i1 = (int)(ImmersiveUtils.getDensity() * 1.0F);
    paramDrawable.setLayerInset(0, i1, i1, i1, i1);
    return paramDrawable;
  }
  
  /* Error */
  String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 636	java/io/File
    //   3: dup
    //   4: getstatic 855	com/tencent/mobileqq/app/AppConstants:DYNAMIC_PROFILE	Ljava/lang/String;
    //   7: invokestatic 860	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 638	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 863	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 340	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   26: astore_3
    //   27: aload_3
    //   28: ldc_w 865
    //   31: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: invokestatic 791	java/lang/System:currentTimeMillis	()J
    //   39: invokevirtual 868	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 636	java/io/File
    //   46: dup
    //   47: aload_2
    //   48: aload_3
    //   49: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 871	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 641	java/io/File:exists	()Z
    //   62: ifeq +9 -> 71
    //   65: aload 6
    //   67: invokevirtual 874	java/io/File:delete	()Z
    //   70: pop
    //   71: new 876	java/io/FileOutputStream
    //   74: dup
    //   75: aload 6
    //   77: invokespecial 879	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_2
    //   81: new 881	java/io/BufferedOutputStream
    //   84: dup
    //   85: aload_2
    //   86: sipush 4096
    //   89: invokespecial 884	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   92: astore 5
    //   94: aload_2
    //   95: astore_3
    //   96: aload 5
    //   98: astore 4
    //   100: aload_1
    //   101: getstatic 890	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   104: bipush 100
    //   106: aload 5
    //   108: invokevirtual 896	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_2
    //   113: astore_3
    //   114: aload 5
    //   116: astore 4
    //   118: aload 5
    //   120: invokevirtual 899	java/io/BufferedOutputStream:flush	()V
    //   123: aload_2
    //   124: astore_3
    //   125: aload 5
    //   127: astore 4
    //   129: aload 6
    //   131: invokevirtual 902	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   134: astore 6
    //   136: aload_2
    //   137: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   140: goto +8 -> 148
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   148: aload 5
    //   150: invokevirtual 909	java/io/BufferedOutputStream:close	()V
    //   153: goto +177 -> 330
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   161: goto +169 -> 330
    //   164: astore 6
    //   166: aload_2
    //   167: astore 7
    //   169: aload 5
    //   171: astore_2
    //   172: goto +62 -> 234
    //   175: astore 6
    //   177: aload_2
    //   178: astore 7
    //   180: aload 5
    //   182: astore_2
    //   183: goto +99 -> 282
    //   186: astore_1
    //   187: aconst_null
    //   188: astore 4
    //   190: goto +442 -> 632
    //   193: astore 6
    //   195: aconst_null
    //   196: astore_3
    //   197: aload_2
    //   198: astore 7
    //   200: aload_3
    //   201: astore_2
    //   202: goto +32 -> 234
    //   205: astore 6
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_2
    //   210: astore 7
    //   212: aload_3
    //   213: astore_2
    //   214: goto +68 -> 282
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_2
    //   220: aload_2
    //   221: astore 4
    //   223: goto +409 -> 632
    //   226: astore 6
    //   228: aconst_null
    //   229: astore 7
    //   231: aload 7
    //   233: astore_2
    //   234: aload 7
    //   236: astore_3
    //   237: aload_2
    //   238: astore 4
    //   240: aload 6
    //   242: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   245: aload 7
    //   247: ifnull +16 -> 263
    //   250: aload 7
    //   252: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   255: goto +8 -> 263
    //   258: astore_3
    //   259: aload_3
    //   260: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   263: aload_2
    //   264: ifnull +63 -> 327
    //   267: aload_2
    //   268: invokevirtual 909	java/io/BufferedOutputStream:close	()V
    //   271: goto +56 -> 327
    //   274: astore 6
    //   276: aconst_null
    //   277: astore 7
    //   279: aload 7
    //   281: astore_2
    //   282: aload 7
    //   284: astore_3
    //   285: aload_2
    //   286: astore 4
    //   288: aload 6
    //   290: invokevirtual 910	java/io/FileNotFoundException:printStackTrace	()V
    //   293: aload 7
    //   295: ifnull +16 -> 311
    //   298: aload 7
    //   300: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   303: goto +8 -> 311
    //   306: astore_3
    //   307: aload_3
    //   308: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   311: aload_2
    //   312: ifnull +15 -> 327
    //   315: aload_2
    //   316: invokevirtual 909	java/io/BufferedOutputStream:close	()V
    //   319: goto +8 -> 327
    //   322: astore_2
    //   323: aload_2
    //   324: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   327: aconst_null
    //   328: astore 6
    //   330: aload_0
    //   331: getfield 717	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:I	Z
    //   334: ifeq +253 -> 587
    //   337: new 636	java/io/File
    //   340: dup
    //   341: getstatic 913	com/tencent/mobileqq/app/AppConstants:PATH_NEWER_GUIDE_DIR_NAME	Ljava/lang/String;
    //   344: invokespecial 638	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: astore_2
    //   348: aload_2
    //   349: invokevirtual 641	java/io/File:exists	()Z
    //   352: ifne +8 -> 360
    //   355: aload_2
    //   356: invokevirtual 863	java/io/File:mkdirs	()Z
    //   359: pop
    //   360: new 636	java/io/File
    //   363: dup
    //   364: aload_2
    //   365: ldc_w 915
    //   368: invokespecial 871	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   371: astore 7
    //   373: aload 7
    //   375: invokevirtual 641	java/io/File:exists	()Z
    //   378: ifeq +9 -> 387
    //   381: aload 7
    //   383: invokevirtual 874	java/io/File:delete	()Z
    //   386: pop
    //   387: new 876	java/io/FileOutputStream
    //   390: dup
    //   391: aload 7
    //   393: invokespecial 879	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   396: astore_3
    //   397: new 881	java/io/BufferedOutputStream
    //   400: dup
    //   401: aload_3
    //   402: invokespecial 918	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   405: astore 5
    //   407: aload_3
    //   408: astore_2
    //   409: aload 5
    //   411: astore 4
    //   413: aload_1
    //   414: sipush 200
    //   417: sipush 200
    //   420: iconst_1
    //   421: invokestatic 922	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   424: getstatic 890	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   427: bipush 100
    //   429: aload 5
    //   431: invokevirtual 896	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   434: pop
    //   435: aload_3
    //   436: astore_2
    //   437: aload 5
    //   439: astore 4
    //   441: aload 5
    //   443: invokevirtual 899	java/io/BufferedOutputStream:flush	()V
    //   446: aload_3
    //   447: astore_2
    //   448: aload 5
    //   450: astore 4
    //   452: aload_0
    //   453: aload 7
    //   455: invokevirtual 902	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   458: putfield 724	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:J	Ljava/lang/String;
    //   461: aload_3
    //   462: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   465: aload 5
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 909	java/io/BufferedOutputStream:close	()V
    //   472: goto +115 -> 587
    //   475: goto +112 -> 587
    //   478: astore_2
    //   479: aload 5
    //   481: astore_1
    //   482: aload_2
    //   483: astore 5
    //   485: goto +34 -> 519
    //   488: astore_1
    //   489: aconst_null
    //   490: astore 4
    //   492: aload_3
    //   493: astore_2
    //   494: goto +70 -> 564
    //   497: astore 5
    //   499: aconst_null
    //   500: astore_1
    //   501: goto +18 -> 519
    //   504: astore_1
    //   505: aconst_null
    //   506: astore_2
    //   507: aload_2
    //   508: astore 4
    //   510: goto +54 -> 564
    //   513: astore 5
    //   515: aconst_null
    //   516: astore_3
    //   517: aload_3
    //   518: astore_1
    //   519: aload_3
    //   520: astore_2
    //   521: aload_1
    //   522: astore 4
    //   524: ldc 212
    //   526: iconst_1
    //   527: ldc_w 924
    //   530: aload 5
    //   532: invokestatic 927	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: aload_3
    //   536: astore_2
    //   537: aload_1
    //   538: astore 4
    //   540: aload_0
    //   541: aconst_null
    //   542: putfield 724	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:J	Ljava/lang/String;
    //   545: aload_3
    //   546: ifnull +10 -> 556
    //   549: aload_3
    //   550: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   553: goto +3 -> 556
    //   556: aload_1
    //   557: ifnull +30 -> 587
    //   560: goto -92 -> 468
    //   563: astore_1
    //   564: aload_2
    //   565: ifnull +10 -> 575
    //   568: aload_2
    //   569: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   572: goto +3 -> 575
    //   575: aload 4
    //   577: ifnull +8 -> 585
    //   580: aload 4
    //   582: invokevirtual 909	java/io/BufferedOutputStream:close	()V
    //   585: aload_1
    //   586: athrow
    //   587: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +36 -> 626
    //   593: new 340	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   600: astore_1
    //   601: aload_1
    //   602: ldc_w 929
    //   605: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload_1
    //   610: aload 6
    //   612: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: ldc 212
    //   618: iconst_2
    //   619: aload_1
    //   620: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 256	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: aload 6
    //   628: areturn
    //   629: astore_1
    //   630: aload_3
    //   631: astore_2
    //   632: aload_2
    //   633: ifnull +15 -> 648
    //   636: aload_2
    //   637: invokevirtual 905	java/io/FileOutputStream:close	()V
    //   640: goto +8 -> 648
    //   643: astore_2
    //   644: aload_2
    //   645: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   648: aload 4
    //   650: ifnull +16 -> 666
    //   653: aload 4
    //   655: invokevirtual 909	java/io/BufferedOutputStream:close	()V
    //   658: goto +8 -> 666
    //   661: astore_2
    //   662: aload_2
    //   663: invokevirtual 908	java/io/IOException:printStackTrace	()V
    //   666: goto +5 -> 671
    //   669: aload_1
    //   670: athrow
    //   671: goto -2 -> 669
    //   674: astore_1
    //   675: aload 5
    //   677: astore_1
    //   678: goto -210 -> 468
    //   681: astore_1
    //   682: goto -207 -> 475
    //   685: astore_2
    //   686: goto -130 -> 556
    //   689: astore_2
    //   690: goto -115 -> 575
    //   693: astore_2
    //   694: goto -109 -> 585
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	SelectCoverActivity
    //   0	697	1	paramBitmap	Bitmap
    //   13	124	2	localObject1	Object
    //   143	2	2	localIOException1	java.io.IOException
    //   156	11	2	localIOException2	java.io.IOException
    //   171	145	2	localObject2	Object
    //   322	2	2	localIOException3	java.io.IOException
    //   347	101	2	localObject3	Object
    //   478	5	2	localException1	Exception
    //   493	144	2	localObject4	Object
    //   643	2	2	localIOException4	java.io.IOException
    //   661	2	2	localIOException5	java.io.IOException
    //   685	1	2	localException2	Exception
    //   689	1	2	localException3	Exception
    //   693	1	2	localException4	Exception
    //   26	211	3	localObject5	Object
    //   258	2	3	localIOException6	java.io.IOException
    //   284	1	3	localObject6	Object
    //   306	2	3	localIOException7	java.io.IOException
    //   396	235	3	localFileOutputStream	java.io.FileOutputStream
    //   98	556	4	localObject7	Object
    //   92	392	5	localObject8	Object
    //   497	1	5	localException5	Exception
    //   513	163	5	localException6	Exception
    //   55	80	6	localObject9	Object
    //   164	1	6	localIOException8	java.io.IOException
    //   175	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   193	1	6	localIOException9	java.io.IOException
    //   205	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   226	15	6	localIOException10	java.io.IOException
    //   274	15	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   328	299	6	str	String
    //   167	287	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   136	140	143	java/io/IOException
    //   148	153	156	java/io/IOException
    //   100	112	164	java/io/IOException
    //   118	123	164	java/io/IOException
    //   129	136	164	java/io/IOException
    //   100	112	175	java/io/FileNotFoundException
    //   118	123	175	java/io/FileNotFoundException
    //   129	136	175	java/io/FileNotFoundException
    //   81	94	186	finally
    //   81	94	193	java/io/IOException
    //   81	94	205	java/io/FileNotFoundException
    //   71	81	217	finally
    //   71	81	226	java/io/IOException
    //   250	255	258	java/io/IOException
    //   71	81	274	java/io/FileNotFoundException
    //   298	303	306	java/io/IOException
    //   267	271	322	java/io/IOException
    //   315	319	322	java/io/IOException
    //   413	435	478	java/lang/Exception
    //   441	446	478	java/lang/Exception
    //   452	461	478	java/lang/Exception
    //   397	407	488	finally
    //   397	407	497	java/lang/Exception
    //   387	397	504	finally
    //   387	397	513	java/lang/Exception
    //   413	435	563	finally
    //   441	446	563	finally
    //   452	461	563	finally
    //   524	535	563	finally
    //   540	545	563	finally
    //   100	112	629	finally
    //   118	123	629	finally
    //   129	136	629	finally
    //   240	245	629	finally
    //   288	293	629	finally
    //   636	640	643	java/io/IOException
    //   653	658	661	java/io/IOException
    //   461	465	674	java/lang/Exception
    //   468	472	681	java/lang/Exception
    //   549	553	685	java/lang/Exception
    //   568	572	689	java/lang/Exception
    //   580	585	693	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    this.c.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.j.hasMessages(5)) {
      this.j.removeMessages(5);
    }
    Message localMessage = this.j.obtainMessage(5, paramInt1, paramInt2);
    this.j.sendMessageDelayed(localMessage, 300L);
  }
  
  @TargetApi(14)
  public void a(View paramView1, View paramView2)
  {
    Animator localAnimator = this.o;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    if ((this.q == null) || (this.r == null) || (this.p <= 0.0F)) {
      c(paramView1, paramView2);
    }
    paramView2.setVisibility(0);
    paramView1.setAlpha(0.0F);
    paramView2.setPivotX(0.0F);
    paramView2.setPivotY(0.0F);
    this.t.setVisibility(8);
    this.w.setVisibility(8);
    paramView1 = new AnimatorSet();
    paramView1.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.q.left, this.r.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.q.top, this.r.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.p, 1.0F })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.p, 1.0F }));
    paramView1.setDuration(250L);
    paramView1.setInterpolator(new DecelerateInterpolator());
    paramView1.addListener(new SelectCoverActivity.6(this));
    paramView1.start();
    this.o = paramView1;
  }
  
  boolean a()
  {
    this.c = new VideoDrawableHandler(this.app, this);
    if (!this.c.a(this.n))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "doOnCreate return file error");
      }
      finish();
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekStart");
    }
    DynamicUtils.a(this.app, "0X800710B", i());
    if (this.j.hasMessages(8)) {
      this.j.removeMessages(8);
    }
    g();
    this.E = true;
  }
  
  @TargetApi(14)
  public void b(View paramView1, View paramView2)
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if ((this.q != null) && (this.r != null))
    {
      if (this.p <= 0.0F) {
        return;
      }
      this.t.setVisibility(0);
      this.w.setVisibility(0);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.q.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.q.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.p })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.p }));
      ((AnimatorSet)localObject).setDuration(250L);
      ((AnimatorSet)localObject).setInterpolator(new DecelerateInterpolator());
      ((AnimatorSet)localObject).addListener(new SelectCoverActivity.7(this, paramView1, paramView2));
      ((AnimatorSet)localObject).start();
      this.o = ((Animator)localObject);
    }
  }
  
  boolean b(int paramInt)
  {
    if (paramInt > this.k - 1) {
      return true;
    }
    long l1 = this.c.a();
    int i1 = this.k;
    int i2 = (int)(l1 / (i1 - 1));
    if (paramInt == i1 - 1) {
      i1 = (int)this.c.a();
    } else {
      i1 = paramInt * i2;
    }
    try
    {
      Object localObject3 = this.c.a(i1);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject1 = DynamicUtils.a((Bitmap)localObject3, this.l, this.l);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (localObject3 != localObject1)
          {
            localObject2 = localObject1;
            if (!((Bitmap)localObject3).isRecycled())
            {
              ((Bitmap)localObject3).recycle();
              localObject2 = localObject1;
            }
          }
        }
      }
      else
      {
        localObject2 = this.c.c();
      }
      if (paramInt == 0) {
        this.j.obtainMessage(1, localObject2).sendToTarget();
      }
      Object localObject1 = null;
      try
      {
        localObject3 = AnimationUtils.loadAnimation(this, 2130772364);
        localObject1 = localObject3;
        ((Animation)localObject3).setInterpolator(new DecelerateInterpolator(2.0F));
        localObject1 = localObject3;
        ((Animation)localObject3).setFillAfter(false);
        localObject1 = localObject3;
        ((Animation)localObject3).setDuration(50L);
      }
      catch (Throwable localThrowable)
      {
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("SelectCoverActivity", 2, localThrowable.getMessage(), localThrowable);
          localObject3 = localObject1;
        }
      }
      this.j.obtainMessage(0, paramInt, i1, new Object[] { localObject2, localObject3 }).sendToTarget();
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localException.printStackTrace();
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
      }
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekEnd");
    }
    if (this.j.hasMessages(8)) {
      this.j.removeMessages(8);
    }
    this.j.sendEmptyMessageDelayed(8, 400L);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.x = getIntent().getIntExtra("param_source", 0);
    this.I = getIntent().getBooleanExtra("param_from_newer_guide", false);
    if (this.x != 0)
    {
      this.B = getIntent().getIntExtra("key_video_duration", 0);
      this.C = getIntent().getStringExtra("key_video_has_voice");
      this.D = getIntent().getStringExtra("key_camera_id");
      this.G = ((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
      paramBundle = this.G;
      paramBundle.b = null;
      paramBundle.c = null;
      setContentView(getLayoutInflater().inflate(2131627735, null));
      e();
      getWindow().setBackgroundDrawable(null);
      d();
      this.n = getIntent().getStringExtra("key_video_file_path");
      if (!FileUtils.fileExists(this.n))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("doOnCreate return filepath:");
          paramBundle.append(this.n);
          QLog.i("SelectCoverActivity", 2, paramBundle.toString());
        }
        finish();
        return false;
      }
      this.H = new SelectCoverActivity.CoverTransProcessorHandler(this.app, this);
      this.H.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.H);
      if (Build.VERSION.SDK_INT <= 9) {
        ThreadManager.postImmediately(new SelectCoverActivity.1(this), null, true);
      } else {
        ThreadManager.postImmediately(new SelectCoverActivity.2(this), null, true);
      }
      if (this.x == 3) {
        SdkDynamicAvatarSettingHelper.a(this, this.n);
      }
      return true;
    }
    throw new IllegalArgumentException("source must not be null");
  }
  
  @TargetApi(11)
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.F = true;
    this.i.removeCallbacksAndMessages(null);
    this.j.removeCallbacksAndMessages(null);
    Object localObject = this.c;
    if (localObject != null) {
      ((VideoDrawableHandler)localObject).e();
    }
    localObject = this.o;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (this.H != null)
    {
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.H);
      FaceUtil.e(null);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1;
    int i2;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 8: 
      h();
      return true;
    case 7: 
      i1 = paramMessage.arg1;
      i2 = paramMessage.arg2;
      paramMessage = (String)paramMessage.obj;
      if (!this.F)
      {
        localObject = this.z;
        if (localObject != null)
        {
          ((QQProgressNotifier)localObject).a(i1, paramMessage, i2, this);
          return true;
        }
      }
      break;
    case 6: 
      QQToast.makeText(this, HardCodeUtil.a(2131911172), 0).show();
      return true;
    case 5: 
      i1 = paramMessage.arg1;
      if (paramMessage.arg2 != 0)
      {
        float f1 = i1 / 1000.0F;
        QQToast.makeText(this, String.format(HardCodeUtil.a(2131911161), new Object[] { Float.valueOf(f1) }), 0).show();
        return true;
      }
      break;
    case 4: 
      this.h = new VideoDrawable((Bitmap)paramMessage.obj, getResources());
      this.h.a(true);
      this.s.setBackgroundDrawable(this.h);
      this.s.setVisibility(0);
      return true;
    case 2: 
      this.c.d();
      a(paramMessage.arg1);
      return true;
    case 1: 
      b((Bitmap)paramMessage.obj);
      a(0);
      return true;
    case 0: 
      i1 = paramMessage.arg1;
      i2 = paramMessage.arg2;
      localObject = (Object[])paramMessage.obj;
      paramMessage = (Bitmap)localObject[0];
      localObject = (Animation)localObject[1];
      CustomImgView localCustomImgView = (CustomImgView)this.d.getChildAt(i1);
      localCustomImgView.setImageBitmap(paramMessage);
      localCustomImgView.setTag(Integer.valueOf(i2));
      localCustomImgView.setOnTouchListener(this);
      if (localObject != null) {
        localCustomImgView.startAnimation((Animation)localObject);
      }
      break;
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    DynamicUtils.a(this.app, "0X800710C", i());
    return super.onBackEvent();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectCoverActivity", 2, "onCancel notify dialog canceled.");
    }
    a(true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      DynamicUtils.a(this.app, "0X800710D", i());
      if (FaceUtil.b())
      {
        a(2, HardCodeUtil.a(2131911170), 0);
      }
      else if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.makeText(this, 1, getString(2131892104), 0).show(getTitleBarHeight());
      }
      else
      {
        Object localObject = this.s.getBackground();
        if ((localObject != null) && ((localObject instanceof BitmapDrawable))) {
          localObject = ((BitmapDrawable)localObject).getBitmap();
        } else if ((localObject != null) && ((localObject instanceof VideoDrawable))) {
          localObject = ((VideoDrawable)localObject).a();
        } else {
          localObject = null;
        }
        if (localObject == null)
        {
          QQToast.makeText(this, HardCodeUtil.a(2131911167), 0).show();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("android version:");
            ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
            QLog.i("SelectCoverActivity", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          if (this.z == null) {
            this.z = new QQProgressNotifier(this);
          }
          a(0, HardCodeUtil.a(2131911163), 0);
          ThreadManager.postImmediately(new SelectCoverActivity.3(this, (Bitmap)localObject), null, true);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!(paramView instanceof CustomImgView)) {
      return false;
    }
    paramView = (CustomImgView)paramView;
    if (!this.b.a()) {
      return false;
    }
    int i1 = ((Integer)paramView.getTag()).intValue();
    this.i.obtainMessage(2, i1, 0).sendToTarget();
    this.b.setThumbOffset(paramView.getLeft());
    DynamicUtils.a(this.app, "0X800710A", i());
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onTouchDown");
    }
    g();
    if (this.j.hasMessages(8)) {
      this.j.removeMessages(8);
    }
    this.j.sendEmptyMessageDelayed(8, 400L);
    this.E = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity
 * JD-Core Version:    0.7.0.1
 */