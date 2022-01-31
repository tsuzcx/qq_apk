package com.tencent.mobileqq.avatar.dynamicavatar;

import abkd;
import abke;
import abkf;
import abkg;
import abkh;
import abki;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
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
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.OnProgressChangedListener;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.OnGetFrameListener;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;

public class SelectCoverActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, DrawableSeekbar.OnProgressChangedListener, VideoDrawableHandler.OnGetFrameListener
{
  float jdField_a_of_type_Float = 0.0F;
  public int a;
  abki jdField_a_of_type_Abki;
  public Animator a;
  Rect jdField_a_of_type_AndroidGraphicsRect = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public DynamicAvatarManager a;
  DrawableSeekbar jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar;
  VideoDrawable jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable;
  VideoDrawableHandler jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = null;
  public Handler b;
  View jdField_b_of_type_AndroidViewView;
  VideoDrawable jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable;
  public String b;
  public volatile boolean b;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  VideoDrawable jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  View d;
  public String d;
  public int e;
  View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString;
  public int f;
  
  public SelectCoverActivity()
  {
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidAnimationAnimator = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private int a()
  {
    int i = 1;
    if (this.jdField_d_of_type_Int == 1) {
      i = 0;
    }
    return i;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(7, paramInt1, paramInt2, paramString).sendToTarget();
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable(paramBitmap, getResources());
    this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable(paramBitmap, getResources());
    this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable(paramBitmap, getResources());
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setOnProgressChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumb(a(this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setMax((int)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a());
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumbSize(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  private boolean b()
  {
    boolean bool = false;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if (str.equalsIgnoreCase("Xiaomi-MI NOTE Pro")) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "isxiaomi:" + bool + " deviceinfo:" + str);
    }
    return bool;
  }
  
  @TargetApi(11)
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)findViewById(2131363511));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363063);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131362841);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371211);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364057);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar = ((DrawableSeekbar)findViewById(2131367158));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371213));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131371210);
    int k = ImmersiveUtils.a();
    int j = ImmersiveUtils.b();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = k;
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int m = (int)(0.125D * j);
    int i = (int)(0.125F * k);
    j = (int)(j - (getTitleBarHeight() + m + this.mDensity * 100.0F + ImmersiveUtils.a(this)));
    int n = k - i * 2;
    float f1 = j / n;
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "remainHeight:" + j + " remainWidth:" + n + " scale:" + f1);
    }
    if (f1 < 1.229437F)
    {
      j = (int)(0.5F * (k - j / 1.229437F));
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("SelectCoverActivity", 2, "recalc margin margin:" + j);
        i = j;
      }
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (Build.VERSION.SDK_INT <= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setVisibility(8);
      findViewById(2131371212).setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (b())
      {
        ((RelativeLayout.LayoutParams)localObject).rightMargin += 10;
        ((RelativeLayout.LayoutParams)localObject).topMargin += 50;
        ((RelativeLayout.LayoutParams)localObject).height = 154;
        ((RelativeLayout.LayoutParams)localObject).width = 154;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131559340));
      this.jdField_c_of_type_Int = ((int)getResources().getDimension(2131559339));
      localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = m;
      this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i = (int)getResources().getDimension(2131559342);
      this.jdField_a_of_type_Int = ((k - i * 2) / this.jdField_b_of_type_Int);
      if ((k - i * 2) % this.jdField_b_of_type_Int != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      localObject = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-2147483648);
      }
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        CustomImgView localCustomImgView = new CustomImgView(this);
        localCustomImgView.a.setScaleType(ImageView.ScaleType.FIT_XY);
        localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject);
        i += 1;
      }
    }
  }
  
  private void c(View paramView1, View paramView2)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    Point localPoint = new Point();
    paramView1.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_d_of_type_AndroidViewView.getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect, localPoint);
    paramView2.getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsRect.offset(-localPoint.x, -localPoint.y);
    this.jdField_b_of_type_AndroidGraphicsRect.offset(-localPoint.x, -localPoint.y);
    if (this.jdField_b_of_type_AndroidGraphicsRect.width() / this.jdField_b_of_type_AndroidGraphicsRect.height() > this.jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_a_of_type_AndroidGraphicsRect.height())
    {
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / this.jdField_b_of_type_AndroidGraphicsRect.height());
      f1 = (this.jdField_a_of_type_Float * this.jdField_b_of_type_AndroidGraphicsRect.width() - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2.0F;
      paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView1.left = ((int)(paramView1.left - f1));
      paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView1.right = ((int)(f1 + paramView1.right));
      return;
    }
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_b_of_type_AndroidGraphicsRect.width());
    float f1 = (this.jdField_a_of_type_Float * this.jdField_b_of_type_AndroidGraphicsRect.height() - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2.0F;
    paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView1.top = ((int)(paramView1.top - f1));
    paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView1.bottom = ((int)(f1 + paramView1.bottom));
  }
  
  private void d()
  {
    setRightButton(2131434534, this);
    setTitle("设置静态头像");
    this.leftView.setTextColor(getResources().getColorStateList(2131494134));
    this.rightViewText.setTextColor(getResources().getColorStateList(2131494134));
    int i = Color.parseColor("#1a1a1a");
    getTitleBarView().setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(i);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  private void e()
  {
    String str = DynamicUtils.a(this.jdField_a_of_type_JavaLangString, 200);
    DynamicUtils.a(this.jdField_a_of_type_JavaLangString, str, 200, this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_a_of_type_JavaLangString = str;
    str = DynamicUtils.a(this.jdField_a_of_type_JavaLangString, 100);
    DynamicUtils.a(this.jdField_a_of_type_JavaLangString, str, 100, this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b = str;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_a_of_type_JavaLangString)) || (!new File(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_a_of_type_JavaLangString).exists()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b)) || (!new File(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b).exists())) {
          break;
        }
        h();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    a(2, "处理失败，请重新拍摄", 0);
  }
  
  private void f()
  {
    if (VersionUtils.d())
    {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentWidgetCustomImgView);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g()
  {
    if (VersionUtils.d())
    {
      b(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentWidgetCustomImgView);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Abki.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.app.a().a(this.jdField_a_of_type_Abki);
    this.jdField_e_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
    DynamicUtils.a(this.app, this.jdField_a_of_type_JavaLangString, 36, this.jdField_e_of_type_Int, 640);
    ProfileCardUtil.a(this.jdField_a_of_type_JavaLangString);
  }
  
  Drawable a(Drawable paramDrawable)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { paramDrawable, (GradientDrawable)getResources().getDrawable(2130843121) });
    int i = (int)(1.0F * ImmersiveUtils.a());
    paramDrawable.setLayerInset(0, i, i, i, i);
    return paramDrawable;
  }
  
  /* Error */
  public String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 497	java/io/File
    //   3: dup
    //   4: getstatic 591	com/tencent/mobileqq/app/AppConstants:bI	Ljava/lang/String;
    //   7: invokespecial 500	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 594	java/io/File:mkdirs	()Z
    //   15: pop
    //   16: new 497	java/io/File
    //   19: dup
    //   20: aload_2
    //   21: new 171	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 596
    //   31: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokestatic 547	java/lang/System:currentTimeMillis	()J
    //   37: invokevirtual 599	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   40: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 602	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 503	java/io/File:exists	()Z
    //   53: ifeq +9 -> 62
    //   56: aload 6
    //   58: invokevirtual 605	java/io/File:delete	()Z
    //   61: pop
    //   62: new 607	java/io/FileOutputStream
    //   65: dup
    //   66: aload 6
    //   68: invokespecial 610	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: astore_2
    //   72: new 612	java/io/BufferedOutputStream
    //   75: dup
    //   76: aload_2
    //   77: sipush 4096
    //   80: invokespecial 615	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   83: astore 5
    //   85: aload 5
    //   87: astore 4
    //   89: aload_2
    //   90: astore_3
    //   91: aload_1
    //   92: getstatic 621	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   95: bipush 100
    //   97: aload 5
    //   99: invokevirtual 627	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   102: pop
    //   103: aload 5
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: aload 5
    //   111: invokevirtual 630	java/io/BufferedOutputStream:flush	()V
    //   114: aload 5
    //   116: astore 4
    //   118: aload_2
    //   119: astore_3
    //   120: aload 6
    //   122: invokevirtual 633	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   125: astore 6
    //   127: aload 6
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   138: aload_3
    //   139: astore_2
    //   140: aload 5
    //   142: ifnull +10 -> 152
    //   145: aload 5
    //   147: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   150: aload_3
    //   151: astore_2
    //   152: aload_0
    //   153: getfield 165	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:jdField_c_of_type_Boolean	Z
    //   156: ifeq +148 -> 304
    //   159: new 497	java/io/File
    //   162: dup
    //   163: getstatic 640	com/tencent/mobileqq/app/AppConstants:cu	Ljava/lang/String;
    //   166: invokespecial 500	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore_3
    //   170: aload_3
    //   171: invokevirtual 503	java/io/File:exists	()Z
    //   174: ifne +8 -> 182
    //   177: aload_3
    //   178: invokevirtual 594	java/io/File:mkdirs	()Z
    //   181: pop
    //   182: new 497	java/io/File
    //   185: dup
    //   186: aload_3
    //   187: ldc_w 642
    //   190: invokespecial 602	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   193: astore 6
    //   195: aload 6
    //   197: invokevirtual 503	java/io/File:exists	()Z
    //   200: ifeq +9 -> 209
    //   203: aload 6
    //   205: invokevirtual 605	java/io/File:delete	()Z
    //   208: pop
    //   209: new 607	java/io/FileOutputStream
    //   212: dup
    //   213: aload 6
    //   215: invokespecial 610	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   218: astore_3
    //   219: new 612	java/io/BufferedOutputStream
    //   222: dup
    //   223: aload_3
    //   224: invokespecial 645	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   227: astore 7
    //   229: aload 7
    //   231: astore 5
    //   233: aload_3
    //   234: astore 4
    //   236: aload_1
    //   237: sipush 200
    //   240: sipush 200
    //   243: iconst_1
    //   244: invokestatic 649	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   247: getstatic 621	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   250: bipush 100
    //   252: aload 7
    //   254: invokevirtual 627	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   257: pop
    //   258: aload 7
    //   260: astore 5
    //   262: aload_3
    //   263: astore 4
    //   265: aload 7
    //   267: invokevirtual 630	java/io/BufferedOutputStream:flush	()V
    //   270: aload 7
    //   272: astore 5
    //   274: aload_3
    //   275: astore 4
    //   277: aload_0
    //   278: aload 6
    //   280: invokevirtual 633	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   283: putfield 78	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   294: aload 7
    //   296: ifnull +8 -> 304
    //   299: aload 7
    //   301: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   304: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +29 -> 336
    //   310: ldc 205
    //   312: iconst_2
    //   313: new 171	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 651
    //   323: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_2
    //   337: areturn
    //   338: astore_2
    //   339: aload_2
    //   340: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   343: goto -205 -> 138
    //   346: astore_2
    //   347: aload_2
    //   348: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   351: aload_3
    //   352: astore_2
    //   353: goto -201 -> 152
    //   356: astore 6
    //   358: aconst_null
    //   359: astore 5
    //   361: aconst_null
    //   362: astore_2
    //   363: aload 5
    //   365: astore 4
    //   367: aload_2
    //   368: astore_3
    //   369: aload 6
    //   371: invokevirtual 655	java/io/FileNotFoundException:printStackTrace	()V
    //   374: aload_2
    //   375: ifnull +7 -> 382
    //   378: aload_2
    //   379: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   382: aload 5
    //   384: ifnull +303 -> 687
    //   387: aload 5
    //   389: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   392: aconst_null
    //   393: astore_2
    //   394: goto -242 -> 152
    //   397: astore_2
    //   398: aload_2
    //   399: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   402: goto -20 -> 382
    //   405: astore_2
    //   406: aload_2
    //   407: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   410: aconst_null
    //   411: astore_2
    //   412: goto -260 -> 152
    //   415: astore 6
    //   417: aconst_null
    //   418: astore 5
    //   420: aconst_null
    //   421: astore_2
    //   422: aload 5
    //   424: astore 4
    //   426: aload_2
    //   427: astore_3
    //   428: aload 6
    //   430: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   433: aload_2
    //   434: ifnull +7 -> 441
    //   437: aload_2
    //   438: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   441: aload 5
    //   443: ifnull +244 -> 687
    //   446: aload 5
    //   448: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   451: aconst_null
    //   452: astore_2
    //   453: goto -301 -> 152
    //   456: astore_2
    //   457: aload_2
    //   458: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   461: goto -20 -> 441
    //   464: astore_2
    //   465: aload_2
    //   466: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   469: aconst_null
    //   470: astore_2
    //   471: goto -319 -> 152
    //   474: astore_1
    //   475: aconst_null
    //   476: astore 4
    //   478: aconst_null
    //   479: astore_2
    //   480: aload_2
    //   481: ifnull +7 -> 488
    //   484: aload_2
    //   485: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   488: aload 4
    //   490: ifnull +8 -> 498
    //   493: aload 4
    //   495: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   498: aload_1
    //   499: athrow
    //   500: astore_2
    //   501: aload_2
    //   502: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   505: goto -17 -> 488
    //   508: astore_2
    //   509: aload_2
    //   510: invokevirtual 654	java/io/IOException:printStackTrace	()V
    //   513: goto -15 -> 498
    //   516: astore 6
    //   518: aconst_null
    //   519: astore_3
    //   520: aconst_null
    //   521: astore_1
    //   522: aload_1
    //   523: astore 5
    //   525: aload_3
    //   526: astore 4
    //   528: ldc 205
    //   530: iconst_1
    //   531: ldc_w 657
    //   534: aload 6
    //   536: invokestatic 660	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   539: aload_1
    //   540: astore 5
    //   542: aload_3
    //   543: astore 4
    //   545: aload_0
    //   546: aconst_null
    //   547: putfield 78	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   550: aload_3
    //   551: ifnull +7 -> 558
    //   554: aload_3
    //   555: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   558: aload_1
    //   559: ifnull -255 -> 304
    //   562: aload_1
    //   563: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   566: goto -262 -> 304
    //   569: astore_1
    //   570: goto -266 -> 304
    //   573: astore_1
    //   574: aconst_null
    //   575: astore 5
    //   577: aconst_null
    //   578: astore_3
    //   579: aload_3
    //   580: ifnull +7 -> 587
    //   583: aload_3
    //   584: invokevirtual 636	java/io/FileOutputStream:close	()V
    //   587: aload 5
    //   589: ifnull +8 -> 597
    //   592: aload 5
    //   594: invokevirtual 637	java/io/BufferedOutputStream:close	()V
    //   597: aload_1
    //   598: athrow
    //   599: astore_1
    //   600: goto -306 -> 294
    //   603: astore_1
    //   604: goto -300 -> 304
    //   607: astore_3
    //   608: goto -50 -> 558
    //   611: astore_2
    //   612: goto -25 -> 587
    //   615: astore_2
    //   616: goto -19 -> 597
    //   619: astore_1
    //   620: aconst_null
    //   621: astore 5
    //   623: goto -44 -> 579
    //   626: astore_1
    //   627: aload 4
    //   629: astore_3
    //   630: goto -51 -> 579
    //   633: astore 6
    //   635: aconst_null
    //   636: astore_1
    //   637: goto -115 -> 522
    //   640: astore 6
    //   642: aload 7
    //   644: astore_1
    //   645: goto -123 -> 522
    //   648: astore_1
    //   649: aconst_null
    //   650: astore 4
    //   652: goto -172 -> 480
    //   655: astore_1
    //   656: aload_3
    //   657: astore_2
    //   658: goto -178 -> 480
    //   661: astore 6
    //   663: aconst_null
    //   664: astore 5
    //   666: goto -244 -> 422
    //   669: astore 6
    //   671: goto -249 -> 422
    //   674: astore 6
    //   676: aconst_null
    //   677: astore 5
    //   679: goto -316 -> 363
    //   682: astore 6
    //   684: goto -321 -> 363
    //   687: aconst_null
    //   688: astore_2
    //   689: goto -537 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	this	SelectCoverActivity
    //   0	692	1	paramBitmap	Bitmap
    //   10	327	2	localObject1	Object
    //   338	2	2	localIOException1	java.io.IOException
    //   346	2	2	localIOException2	java.io.IOException
    //   352	42	2	localObject2	Object
    //   397	2	2	localIOException3	java.io.IOException
    //   405	2	2	localIOException4	java.io.IOException
    //   411	42	2	localObject3	Object
    //   456	2	2	localIOException5	java.io.IOException
    //   464	2	2	localIOException6	java.io.IOException
    //   470	15	2	localObject4	Object
    //   500	2	2	localIOException7	java.io.IOException
    //   508	2	2	localIOException8	java.io.IOException
    //   611	1	2	localException1	Exception
    //   615	1	2	localException2	Exception
    //   657	32	2	localObject5	Object
    //   90	494	3	localObject6	Object
    //   607	1	3	localException3	Exception
    //   629	28	3	localObject7	Object
    //   87	564	4	localObject8	Object
    //   83	595	5	localObject9	Object
    //   46	233	6	localObject10	Object
    //   356	14	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   415	14	6	localIOException9	java.io.IOException
    //   516	19	6	localException4	Exception
    //   633	1	6	localException5	Exception
    //   640	1	6	localException6	Exception
    //   661	1	6	localIOException10	java.io.IOException
    //   669	1	6	localIOException11	java.io.IOException
    //   674	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   682	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   227	416	7	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   134	138	338	java/io/IOException
    //   145	150	346	java/io/IOException
    //   62	72	356	java/io/FileNotFoundException
    //   378	382	397	java/io/IOException
    //   387	392	405	java/io/IOException
    //   62	72	415	java/io/IOException
    //   437	441	456	java/io/IOException
    //   446	451	464	java/io/IOException
    //   62	72	474	finally
    //   484	488	500	java/io/IOException
    //   493	498	508	java/io/IOException
    //   209	219	516	java/lang/Exception
    //   562	566	569	java/lang/Exception
    //   209	219	573	finally
    //   290	294	599	java/lang/Exception
    //   299	304	603	java/lang/Exception
    //   554	558	607	java/lang/Exception
    //   583	587	611	java/lang/Exception
    //   592	597	615	java/lang/Exception
    //   219	229	619	finally
    //   236	258	626	finally
    //   265	270	626	finally
    //   277	286	626	finally
    //   528	539	626	finally
    //   545	550	626	finally
    //   219	229	633	java/lang/Exception
    //   236	258	640	java/lang/Exception
    //   265	270	640	java/lang/Exception
    //   277	286	640	java/lang/Exception
    //   72	85	648	finally
    //   91	103	655	finally
    //   109	114	655	finally
    //   120	127	655	finally
    //   369	374	655	finally
    //   428	433	655	finally
    //   72	85	661	java/io/IOException
    //   91	103	669	java/io/IOException
    //   109	114	669	java/io/IOException
    //   120	127	669	java/io/IOException
    //   72	85	674	java/io/FileNotFoundException
    //   91	103	682	java/io/FileNotFoundException
    //   109	114	682	java/io/FileNotFoundException
    //   120	127	682	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekStart");
    }
    DynamicUtils.a(this.app, "0X800710B", a());
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    }
    f();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(5)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(5);
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, paramInt1, paramInt2);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 300L);
  }
  
  @TargetApi(14)
  public void a(View paramView1, View paramView2)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_Float <= 0.0F)) {
      c(paramView1, paramView2);
    }
    paramView2.setVisibility(0);
    paramView1.setAlpha(0.0F);
    paramView2.setPivotX(0.0F);
    paramView2.setPivotY(0.0F);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    paramView1 = new AnimatorSet();
    paramView1.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.jdField_a_of_type_Float, 1.0F })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.jdField_a_of_type_Float, 1.0F }));
    paramView1.setDuration(250L);
    paramView1.setInterpolator(new DecelerateInterpolator());
    paramView1.addListener(new abkg(this));
    paramView1.start();
    this.jdField_a_of_type_AndroidAnimationAnimator = paramView1;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler = new VideoDrawableHandler(this.app, this);
    if (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "doOnCreate return file error");
      }
      finish();
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int - 1) {
      return true;
    }
    int i = (int)(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a() / (this.jdField_a_of_type_Int - 1));
    if (paramInt == this.jdField_a_of_type_Int - 1) {
      i = (int)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a();
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(i);
        if (localObject1 == null) {
          continue;
        }
        localBitmap = DynamicUtils.a((Bitmap)localObject1, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        if ((localObject1 == null) || (localObject1 == localBitmap) || (((Bitmap)localObject1).isRecycled())) {
          continue;
        }
        ((Bitmap)localObject1).recycle();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject1;
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          break label278;
        }
        QLog.i("SelectCoverActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label278;
        }
        localException.printStackTrace();
        break label278;
        continue;
      }
      if (paramInt == 0) {
        this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1, localBitmap).sendToTarget();
      }
      localObject1 = null;
      try
      {
        localObject2 = AnimationUtils.loadAnimation(this, 2131034324);
        localObject1 = localObject2;
        ((Animation)localObject2).setInterpolator(new DecelerateInterpolator(2.0F));
        localObject1 = localObject2;
        ((Animation)localObject2).setFillAfter(false);
        localObject1 = localObject2;
        ((Animation)localObject2).setDuration(50L);
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SelectCoverActivity", 2, localThrowable.getMessage(), localThrowable);
        localObject2 = localObject1;
        continue;
      }
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(0, paramInt, i, new Object[] { localBitmap, localObject2 }).sendToTarget();
      break label278;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a();
      continue;
      label278:
      return false;
      i *= paramInt;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekEnd");
    }
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 400L);
  }
  
  @TargetApi(14)
  public void b(View paramView1, View paramView2)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_Float <= 0.0F)) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.jdField_a_of_type_Float })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.jdField_a_of_type_Float }));
    localAnimatorSet.setDuration(250L);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.addListener(new abkh(this, paramView1, paramView2));
    localAnimatorSet.start();
    this.jdField_a_of_type_AndroidAnimationAnimator = localAnimatorSet;
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("param_source", 0);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("param_from_newer_guide", false);
    if (this.jdField_d_of_type_Int == 0) {
      throw new IllegalArgumentException("source must not be null");
    }
    this.f = getIntent().getIntExtra("key_video_duration", 0);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_video_has_voice");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_camera_id");
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)this.app.getManager(179));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b = null;
    setContentView(getLayoutInflater().inflate(2130970574, null));
    d();
    getWindow().setBackgroundDrawable(null);
    c();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_video_file_path");
    if (!FileUtils.a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "doOnCreate return filepath:" + this.jdField_a_of_type_JavaLangString);
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_Abki = new abki(this.app, this);
    if (Build.VERSION.SDK_INT <= 9) {
      ThreadManager.postImmediately(new abkd(this), null, true);
    }
    for (;;)
    {
      return true;
      ThreadManager.postImmediately(new abke(this), null, true);
    }
  }
  
  @TargetApi(11)
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.c();
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if (this.jdField_a_of_type_Abki != null) {
      this.app.a().b(this.jdField_a_of_type_Abki);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      int i;
      int j;
      do
      {
        do
        {
          Object localObject;
          CustomImgView localCustomImgView;
          do
          {
            return true;
            i = paramMessage.arg1;
            j = paramMessage.arg2;
            localObject = (Object[])paramMessage.obj;
            paramMessage = (Bitmap)localObject[0];
            localObject = (Animation)localObject[1];
            localCustomImgView = (CustomImgView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
            localCustomImgView.setImageBitmap(paramMessage);
            localCustomImgView.setTag(Integer.valueOf(j));
            localCustomImgView.setOnTouchListener(this);
          } while (localObject == null);
          localCustomImgView.startAnimation((Animation)localObject);
          return true;
          a((Bitmap)paramMessage.obj);
          a(0);
          return true;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.b();
          a(paramMessage.arg1);
          return true;
          this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable((Bitmap)paramMessage.obj, getResources());
          this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable.a(true);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return true;
          i = paramMessage.arg1;
        } while (paramMessage.arg2 == 0);
        QQToast.a(this, String.format("获取%.3fms处图片帧失败。", new Object[] { Float.valueOf(i / 1000.0F) }), 0).a();
        return true;
        QQToast.a(this, "获取封面失败。", 0).a();
        return true;
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        paramMessage = (String)paramMessage.obj;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(i, paramMessage, j);
      return true;
    }
    g();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    DynamicUtils.a(this.app, "0X800710C", a());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      DynamicUtils.a(this.app, "0X800710D", a());
      if (ProfileCardUtil.a()) {
        a(2, "正在上传视频", 0);
      }
    }
    else
    {
      return;
    }
    if (!NetworkUtil.g(this))
    {
      QQToast.a(this, 1, getString(2131434811), 0).b(getTitleBarHeight());
      return;
    }
    paramView = this.jdField_a_of_type_AndroidViewView.getBackground();
    if ((paramView != null) && ((paramView instanceof BitmapDrawable))) {
      paramView = ((BitmapDrawable)paramView).getBitmap();
    }
    for (;;)
    {
      if (paramView == null)
      {
        QQToast.a(this, "选取帧失败。", 0).a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SelectCoverActivity", 2, "android version:" + Build.VERSION.SDK_INT);
        return;
        if ((paramView == null) || (!(paramView instanceof VideoDrawable))) {
          break label210;
        }
        paramView = ((VideoDrawable)paramView).a();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      a(0, "正在处理图片", 0);
      ThreadManager.postImmediately(new abkf(this, paramView), null, true);
      return;
      label210:
      paramView = null;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!(paramView instanceof CustomImgView)) {}
    do
    {
      return false;
      paramView = (CustomImgView)paramView;
    } while (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.a());
    int i = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, i, 0).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumbOffset(paramView.getLeft());
    DynamicUtils.a(this.app, "0X800710A", a());
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onTouchDown");
    }
    f();
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 400L);
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity
 * JD-Core Version:    0.7.0.1
 */