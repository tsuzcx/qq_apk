package com.tencent.mobileqq.avatar.dynamicavatar;

import agpv;
import ajyc;
import alyz;
import alzl;
import alzm;
import alzn;
import alzo;
import alzp;
import alzq;
import alzr;
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
import ayst;
import ayvv;
import bazo;
import bbdj;
import bbev;
import bcpt;
import bcpw;
import bfni;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;

public class SelectCoverActivity
  extends IphoneTitleBarActivity
  implements alzp, alzr, Handler.Callback, View.OnClickListener, View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  alyz jdField_a_of_type_Alyz;
  alzo jdField_a_of_type_Alzo;
  alzq jdField_a_of_type_Alzq;
  public Animator a;
  Rect jdField_a_of_type_AndroidGraphicsRect = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bcpt jdField_a_of_type_Bcpt;
  DrawableSeekbar jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar;
  VideoDrawableHandler jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  int jdField_b_of_type_Int;
  alzq jdField_b_of_type_Alzq;
  Rect jdField_b_of_type_AndroidGraphicsRect = null;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  View jdField_b_of_type_AndroidViewView;
  public String b;
  volatile boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  alzq jdField_c_of_type_Alzq;
  View jdField_c_of_type_AndroidViewView;
  public String c;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  View d;
  public String d;
  int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString;
  public int f;
  
  public SelectCoverActivity()
  {
    this.jdField_a_of_type_AndroidAnimationAnimator = null;
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
    this.jdField_a_of_type_Alzq = new alzq(paramBitmap, getResources());
    this.jdField_b_of_type_Alzq = new alzq(paramBitmap, getResources());
    this.jdField_c_of_type_Alzq = new alzq(paramBitmap, getResources());
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(this.jdField_a_of_type_Alzq);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_c_of_type_Alzq);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_Alzq);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_b_of_type_Alzq);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_c_of_type_Alzq);
    this.jdField_c_of_type_Alzq.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setOnProgressChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumb(a(this.jdField_b_of_type_Alzq));
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
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)findViewById(2131371906));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367376);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131364657);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367383);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367408);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar = ((DrawableSeekbar)findViewById(2131375780));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369458));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131378206);
    int k = ImmersiveUtils.a();
    int j = ImmersiveUtils.b();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = k;
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int m = (int)(0.125D * j);
    int i = (int)(0.125F * k);
    j = (int)(j - (getTitleBarHeight() + m + this.mDensity * 100.0F + ImmersiveUtils.getStatusBarHeight(this)));
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
      findViewById(2131377241).setVisibility(8);
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
      this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131298851));
      this.jdField_c_of_type_Int = ((int)getResources().getDimension(2131298855));
      localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = m;
      this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i = (int)getResources().getDimension(2131298850);
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
    setRightButton(2131692600, this);
    if (this.jdField_d_of_type_Int == 3) {
      setTitle("设置QQ动态头像");
    }
    for (;;)
    {
      if (ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        this.leftView.setBackgroundResource(2130849540);
        this.rightViewText.setTextColor(getResources().getColorStateList(2131166218));
        this.centerView.setTextColor(getResources().getColorStateList(2131166218));
      }
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
      return;
      setTitle(ajyc.a(2131713708));
    }
  }
  
  private void e()
  {
    String str = alzl.a(this.jdField_a_of_type_JavaLangString, 200);
    alzl.a(this.jdField_a_of_type_JavaLangString, str, 200, this);
    this.jdField_a_of_type_Alyz.jdField_a_of_type_JavaLangString = str;
    str = alzl.a(this.jdField_a_of_type_JavaLangString, 100);
    alzl.a(this.jdField_a_of_type_JavaLangString, str, 100, this);
    this.jdField_a_of_type_Alyz.b = str;
    if ((this.jdField_a_of_type_Bcpt != null) && (this.jdField_a_of_type_Bcpt.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_Alyz.jdField_a_of_type_JavaLangString)) || (!new File(this.jdField_a_of_type_Alyz.jdField_a_of_type_JavaLangString).exists()) || (TextUtils.isEmpty(this.jdField_a_of_type_Alyz.b)) || (!new File(this.jdField_a_of_type_Alyz.b).exists())) {
          break;
        }
        h();
      }
      return;
    }
    this.jdField_a_of_type_Bcpt.b();
    a(2, ajyc.a(2131713710), 0);
  }
  
  private void f()
  {
    if (bfni.d())
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
    if (bfni.d())
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
    this.jdField_a_of_type_Alzo.addFilter(new Class[] { ayst.class });
    this.app.a().a(this.jdField_a_of_type_Alzo);
    this.jdField_e_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
    alzl.a(this.app, this.jdField_a_of_type_JavaLangString, 36, this.jdField_e_of_type_Int, 640);
    bazo.a(this.jdField_a_of_type_JavaLangString);
  }
  
  Drawable a(Drawable paramDrawable)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { paramDrawable, (GradientDrawable)getResources().getDrawable(2130845022) });
    int i = (int)(1.0F * ImmersiveUtils.a());
    paramDrawable.setLayerInset(0, i, i, i, i);
    return paramDrawable;
  }
  
  /* Error */
  String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 521	java/io/File
    //   3: dup
    //   4: getstatic 611	ajsf:cf	Ljava/lang/String;
    //   7: invokestatic 616	bbuv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 524	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 619	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 521	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: new 171	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 621
    //   34: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokestatic 567	java/lang/System:currentTimeMillis	()J
    //   40: invokevirtual 624	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 627	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 6
    //   51: aload 6
    //   53: invokevirtual 527	java/io/File:exists	()Z
    //   56: ifeq +9 -> 65
    //   59: aload 6
    //   61: invokevirtual 630	java/io/File:delete	()Z
    //   64: pop
    //   65: new 632	java/io/FileOutputStream
    //   68: dup
    //   69: aload 6
    //   71: invokespecial 635	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_2
    //   75: new 637	java/io/BufferedOutputStream
    //   78: dup
    //   79: aload_2
    //   80: sipush 4096
    //   83: invokespecial 640	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   86: astore 5
    //   88: aload 5
    //   90: astore 4
    //   92: aload_2
    //   93: astore_3
    //   94: aload_1
    //   95: getstatic 646	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload 5
    //   102: invokevirtual 652	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   105: pop
    //   106: aload 5
    //   108: astore 4
    //   110: aload_2
    //   111: astore_3
    //   112: aload 5
    //   114: invokevirtual 655	java/io/BufferedOutputStream:flush	()V
    //   117: aload 5
    //   119: astore 4
    //   121: aload_2
    //   122: astore_3
    //   123: aload 6
    //   125: invokevirtual 658	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: astore 6
    //   130: aload 6
    //   132: astore_3
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   141: aload_3
    //   142: astore_2
    //   143: aload 5
    //   145: ifnull +10 -> 155
    //   148: aload 5
    //   150: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 165	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:jdField_c_of_type_Boolean	Z
    //   159: ifeq +148 -> 307
    //   162: new 521	java/io/File
    //   165: dup
    //   166: getstatic 665	ajsf:cN	Ljava/lang/String;
    //   169: invokespecial 524	java/io/File:<init>	(Ljava/lang/String;)V
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 527	java/io/File:exists	()Z
    //   177: ifne +8 -> 185
    //   180: aload_3
    //   181: invokevirtual 619	java/io/File:mkdirs	()Z
    //   184: pop
    //   185: new 521	java/io/File
    //   188: dup
    //   189: aload_3
    //   190: ldc_w 667
    //   193: invokespecial 627	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   196: astore 6
    //   198: aload 6
    //   200: invokevirtual 527	java/io/File:exists	()Z
    //   203: ifeq +9 -> 212
    //   206: aload 6
    //   208: invokevirtual 630	java/io/File:delete	()Z
    //   211: pop
    //   212: new 632	java/io/FileOutputStream
    //   215: dup
    //   216: aload 6
    //   218: invokespecial 635	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   221: astore_3
    //   222: new 637	java/io/BufferedOutputStream
    //   225: dup
    //   226: aload_3
    //   227: invokespecial 670	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   230: astore 7
    //   232: aload 7
    //   234: astore 5
    //   236: aload_3
    //   237: astore 4
    //   239: aload_1
    //   240: sipush 200
    //   243: sipush 200
    //   246: iconst_1
    //   247: invokestatic 674	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   250: getstatic 646	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   253: bipush 100
    //   255: aload 7
    //   257: invokevirtual 652	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   260: pop
    //   261: aload 7
    //   263: astore 5
    //   265: aload_3
    //   266: astore 4
    //   268: aload 7
    //   270: invokevirtual 655	java/io/BufferedOutputStream:flush	()V
    //   273: aload 7
    //   275: astore 5
    //   277: aload_3
    //   278: astore 4
    //   280: aload_0
    //   281: aload 6
    //   283: invokevirtual 658	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   286: putfield 78	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   297: aload 7
    //   299: ifnull +8 -> 307
    //   302: aload 7
    //   304: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   307: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +29 -> 339
    //   313: ldc 205
    //   315: iconst_2
    //   316: new 171	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 676
    //   326: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_2
    //   330: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_2
    //   340: areturn
    //   341: astore_2
    //   342: aload_2
    //   343: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   346: goto -205 -> 141
    //   349: astore_2
    //   350: aload_2
    //   351: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   354: aload_3
    //   355: astore_2
    //   356: goto -201 -> 155
    //   359: astore 6
    //   361: aconst_null
    //   362: astore 5
    //   364: aconst_null
    //   365: astore_2
    //   366: aload 5
    //   368: astore 4
    //   370: aload_2
    //   371: astore_3
    //   372: aload 6
    //   374: invokevirtual 680	java/io/FileNotFoundException:printStackTrace	()V
    //   377: aload_2
    //   378: ifnull +7 -> 385
    //   381: aload_2
    //   382: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   385: aload 5
    //   387: ifnull +303 -> 690
    //   390: aload 5
    //   392: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   395: aconst_null
    //   396: astore_2
    //   397: goto -242 -> 155
    //   400: astore_2
    //   401: aload_2
    //   402: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   405: goto -20 -> 385
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   413: aconst_null
    //   414: astore_2
    //   415: goto -260 -> 155
    //   418: astore 6
    //   420: aconst_null
    //   421: astore 5
    //   423: aconst_null
    //   424: astore_2
    //   425: aload 5
    //   427: astore 4
    //   429: aload_2
    //   430: astore_3
    //   431: aload 6
    //   433: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   436: aload_2
    //   437: ifnull +7 -> 444
    //   440: aload_2
    //   441: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   444: aload 5
    //   446: ifnull +244 -> 690
    //   449: aload 5
    //   451: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   454: aconst_null
    //   455: astore_2
    //   456: goto -301 -> 155
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   464: goto -20 -> 444
    //   467: astore_2
    //   468: aload_2
    //   469: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   472: aconst_null
    //   473: astore_2
    //   474: goto -319 -> 155
    //   477: astore_1
    //   478: aconst_null
    //   479: astore 4
    //   481: aconst_null
    //   482: astore_2
    //   483: aload_2
    //   484: ifnull +7 -> 491
    //   487: aload_2
    //   488: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   491: aload 4
    //   493: ifnull +8 -> 501
    //   496: aload 4
    //   498: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   501: aload_1
    //   502: athrow
    //   503: astore_2
    //   504: aload_2
    //   505: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   508: goto -17 -> 491
    //   511: astore_2
    //   512: aload_2
    //   513: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   516: goto -15 -> 501
    //   519: astore 6
    //   521: aconst_null
    //   522: astore_3
    //   523: aconst_null
    //   524: astore_1
    //   525: aload_1
    //   526: astore 5
    //   528: aload_3
    //   529: astore 4
    //   531: ldc 205
    //   533: iconst_1
    //   534: ldc_w 682
    //   537: aload 6
    //   539: invokestatic 685	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   542: aload_1
    //   543: astore 5
    //   545: aload_3
    //   546: astore 4
    //   548: aload_0
    //   549: aconst_null
    //   550: putfield 78	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   553: aload_3
    //   554: ifnull +7 -> 561
    //   557: aload_3
    //   558: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   561: aload_1
    //   562: ifnull -255 -> 307
    //   565: aload_1
    //   566: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   569: goto -262 -> 307
    //   572: astore_1
    //   573: goto -266 -> 307
    //   576: astore_1
    //   577: aconst_null
    //   578: astore 5
    //   580: aconst_null
    //   581: astore_3
    //   582: aload_3
    //   583: ifnull +7 -> 590
    //   586: aload_3
    //   587: invokevirtual 661	java/io/FileOutputStream:close	()V
    //   590: aload 5
    //   592: ifnull +8 -> 600
    //   595: aload 5
    //   597: invokevirtual 662	java/io/BufferedOutputStream:close	()V
    //   600: aload_1
    //   601: athrow
    //   602: astore_1
    //   603: goto -306 -> 297
    //   606: astore_1
    //   607: goto -300 -> 307
    //   610: astore_3
    //   611: goto -50 -> 561
    //   614: astore_2
    //   615: goto -25 -> 590
    //   618: astore_2
    //   619: goto -19 -> 600
    //   622: astore_1
    //   623: aconst_null
    //   624: astore 5
    //   626: goto -44 -> 582
    //   629: astore_1
    //   630: aload 4
    //   632: astore_3
    //   633: goto -51 -> 582
    //   636: astore 6
    //   638: aconst_null
    //   639: astore_1
    //   640: goto -115 -> 525
    //   643: astore 6
    //   645: aload 7
    //   647: astore_1
    //   648: goto -123 -> 525
    //   651: astore_1
    //   652: aconst_null
    //   653: astore 4
    //   655: goto -172 -> 483
    //   658: astore_1
    //   659: aload_3
    //   660: astore_2
    //   661: goto -178 -> 483
    //   664: astore 6
    //   666: aconst_null
    //   667: astore 5
    //   669: goto -244 -> 425
    //   672: astore 6
    //   674: goto -249 -> 425
    //   677: astore 6
    //   679: aconst_null
    //   680: astore 5
    //   682: goto -316 -> 366
    //   685: astore 6
    //   687: goto -321 -> 366
    //   690: aconst_null
    //   691: astore_2
    //   692: goto -537 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	this	SelectCoverActivity
    //   0	695	1	paramBitmap	Bitmap
    //   13	327	2	localObject1	Object
    //   341	2	2	localIOException1	java.io.IOException
    //   349	2	2	localIOException2	java.io.IOException
    //   355	42	2	localObject2	Object
    //   400	2	2	localIOException3	java.io.IOException
    //   408	2	2	localIOException4	java.io.IOException
    //   414	42	2	localObject3	Object
    //   459	2	2	localIOException5	java.io.IOException
    //   467	2	2	localIOException6	java.io.IOException
    //   473	15	2	localObject4	Object
    //   503	2	2	localIOException7	java.io.IOException
    //   511	2	2	localIOException8	java.io.IOException
    //   614	1	2	localException1	Exception
    //   618	1	2	localException2	Exception
    //   660	32	2	localObject5	Object
    //   93	494	3	localObject6	Object
    //   610	1	3	localException3	Exception
    //   632	28	3	localObject7	Object
    //   90	564	4	localObject8	Object
    //   86	595	5	localObject9	Object
    //   49	233	6	localObject10	Object
    //   359	14	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   418	14	6	localIOException9	java.io.IOException
    //   519	19	6	localException4	Exception
    //   636	1	6	localException5	Exception
    //   643	1	6	localException6	Exception
    //   664	1	6	localIOException10	java.io.IOException
    //   672	1	6	localIOException11	java.io.IOException
    //   677	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   685	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   230	416	7	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   137	141	341	java/io/IOException
    //   148	153	349	java/io/IOException
    //   65	75	359	java/io/FileNotFoundException
    //   381	385	400	java/io/IOException
    //   390	395	408	java/io/IOException
    //   65	75	418	java/io/IOException
    //   440	444	459	java/io/IOException
    //   449	454	467	java/io/IOException
    //   65	75	477	finally
    //   487	491	503	java/io/IOException
    //   496	501	511	java/io/IOException
    //   212	222	519	java/lang/Exception
    //   565	569	572	java/lang/Exception
    //   212	222	576	finally
    //   293	297	602	java/lang/Exception
    //   302	307	606	java/lang/Exception
    //   557	561	610	java/lang/Exception
    //   586	590	614	java/lang/Exception
    //   595	600	618	java/lang/Exception
    //   222	232	622	finally
    //   239	261	629	finally
    //   268	273	629	finally
    //   280	289	629	finally
    //   531	542	629	finally
    //   548	553	629	finally
    //   222	232	636	java/lang/Exception
    //   239	261	643	java/lang/Exception
    //   268	273	643	java/lang/Exception
    //   280	289	643	java/lang/Exception
    //   75	88	651	finally
    //   94	106	658	finally
    //   112	117	658	finally
    //   123	130	658	finally
    //   372	377	658	finally
    //   431	436	658	finally
    //   75	88	664	java/io/IOException
    //   94	106	672	java/io/IOException
    //   112	117	672	java/io/IOException
    //   123	130	672	java/io/IOException
    //   75	88	677	java/io/FileNotFoundException
    //   94	106	685	java/io/FileNotFoundException
    //   112	117	685	java/io/FileNotFoundException
    //   123	130	685	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekStart");
    }
    alzl.a(this.app, "0X800710B", a());
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
    paramView1.addListener(new alzm(this));
    paramView1.start();
    this.jdField_a_of_type_AndroidAnimationAnimator = paramView1;
  }
  
  boolean a()
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
  
  boolean a(int paramInt)
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
        localBitmap = alzl.a((Bitmap)localObject1, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
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
        localObject2 = AnimationUtils.loadAnimation(this, 2130772214);
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
    localAnimatorSet.addListener(new alzn(this, paramView1, paramView2));
    localAnimatorSet.start();
    this.jdField_a_of_type_AndroidAnimationAnimator = localAnimatorSet;
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
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
    this.jdField_a_of_type_Alyz = ((alyz)this.app.getManager(180));
    this.jdField_a_of_type_Alyz.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Alyz.b = null;
    setContentView(getLayoutInflater().inflate(2131561018, null));
    d();
    getWindow().setBackgroundDrawable(null);
    c();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_video_file_path");
    if (!bbdj.a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "doOnCreate return filepath:" + this.jdField_a_of_type_JavaLangString);
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_Alzo = new alzo(this.app, this);
    if (Build.VERSION.SDK_INT <= 9) {
      ThreadManager.postImmediately(new SelectCoverActivity.1(this), null, true);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 3) {
        agpv.a(this, this.jdField_a_of_type_JavaLangString);
      }
      return true;
      ThreadManager.postImmediately(new SelectCoverActivity.2(this), null, true);
    }
  }
  
  @TargetApi(11)
  public void doOnDestroy()
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
    if (this.jdField_a_of_type_Alzo != null) {
      this.app.a().b(this.jdField_a_of_type_Alzo);
    }
  }
  
  public void doOnResume()
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
          this.jdField_c_of_type_Alzq = new alzq((Bitmap)paramMessage.obj, getResources());
          this.jdField_c_of_type_Alzq.a(true);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_c_of_type_Alzq);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return true;
          i = paramMessage.arg1;
        } while (paramMessage.arg2 == 0);
        float f1 = i / 1000.0F;
        bcpw.a(this, String.format(ajyc.a(2131713703), new Object[] { Float.valueOf(f1) }), 0).a();
        return true;
        bcpw.a(this, ajyc.a(2131713714), 0).a();
        return true;
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        paramMessage = (String)paramMessage.obj;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Bcpt == null));
      this.jdField_a_of_type_Bcpt.a(i, paramMessage, j);
      return true;
    }
    g();
    return true;
  }
  
  public boolean onBackEvent()
  {
    alzl.a(this.app, "0X800710C", a());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      alzl.a(this.app, "0X800710D", a());
      if (bazo.a()) {
        a(2, ajyc.a(2131713712), 0);
      }
    }
    else
    {
      return;
    }
    if (!bbev.g(this))
    {
      bcpw.a(this, 1, getString(2131694609), 0).b(getTitleBarHeight());
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
        bcpw.a(this, ajyc.a(2131713709), 0).a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SelectCoverActivity", 2, "android version:" + Build.VERSION.SDK_INT);
        return;
        if ((paramView == null) || (!(paramView instanceof alzq))) {
          break label219;
        }
        paramView = ((alzq)paramView).a();
        continue;
      }
      if (this.jdField_a_of_type_Bcpt == null) {
        this.jdField_a_of_type_Bcpt = new bcpt(this);
      }
      a(0, ajyc.a(2131713705), 0);
      ThreadManager.postImmediately(new SelectCoverActivity.3(this, paramView), null, true);
      return;
      label219:
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
    alzl.a(this.app, "0X800710A", a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity
 * JD-Core Version:    0.7.0.1
 */