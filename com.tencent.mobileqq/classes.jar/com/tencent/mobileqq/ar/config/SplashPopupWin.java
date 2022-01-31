package com.tencent.mobileqq.ar.config;

import aajq;
import aajs;
import aajv;
import aajw;
import aajx;
import aajy;
import aajz;
import aaka;
import aakb;
import aakc;
import aakd;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class SplashPopupWin
{
  public static int a;
  public static int b;
  public aakd a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  boolean jdField_a_of_type_Boolean = false;
  private ImageView b;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  public SplashPopupWin()
  {
    this.jdField_a_of_type_Aakd = new aakd();
  }
  
  private Point a(AppInterface paramAppInterface, View paramView, aakd paramaakd)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setBackgroundDrawable((Drawable)paramaakd.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)));
    paramAppInterface = (ImageView)this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().findViewById(2131364642);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramAppInterface.getLayoutParams();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11);
    Point localPoint = a(false, paramaakd.jdField_a_of_type_Int, paramaakd.jdField_b_of_type_Int, paramView.getWidth(), paramView.getHeight());
    int i = (paramView.getWidth() - localPoint.x) / 2;
    int j = (paramView.getHeight() - localPoint.y) / 2;
    QLog.w("WorldCupMgr", 1, "SplashPopupWin.setImage, Image[" + paramaakd.jdField_a_of_type_Int + ", " + paramaakd.jdField_b_of_type_Int + "], anchorView[" + paramView.getWidth() + ", " + paramView.getHeight() + "], New[" + localPoint.x + ", " + localPoint.y + "], offset_x[" + i + "], offset_y[" + j + "]");
    localLayoutParams.setMargins(i, j, i, j);
    paramAppInterface.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setLayoutParams(localLayoutParams);
    paramAppInterface.setImageDrawable((Drawable)paramaakd.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)));
    return new Point(i, j);
  }
  
  static Point a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2) {
      if (paramBoolean) {
        paramInt3 = paramInt4 * paramInt1 / paramInt2;
      }
    }
    for (;;)
    {
      return new Point(paramInt3, paramInt4);
      paramInt4 = paramInt3 * paramInt2 / paramInt1;
      continue;
      if (paramBoolean) {
        paramInt4 = paramInt3 * paramInt2 / paramInt1;
      } else {
        paramInt3 = paramInt4 * paramInt1 / paramInt2;
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  private void a(Activity paramActivity, View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = ImmersiveUtils.a(BaseApplicationImpl.getApplication());
    }
    QLog.w("WorldCupMgr", 1, "setSystemUiVisibility, isSupporImmersive[" + ImmersiveUtils.isSupporImmersive() + "], statusBarHeight[" + i + "]");
    paramView = (FragmentActivity)paramActivity;
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramBoolean)
      {
        paramActivity.getWindow().addFlags(128);
        this.c = this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().getSystemUiVisibility();
        i = c();
        a(paramActivity);
        QLog.w("WorldCupMgr", 1, "setSystemUiVisibility, enable, uiOptions[" + i + "], mPopupWindow[" + this.c + "->" + this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().getSystemUiVisibility() + "]");
      }
    }
    else {
      return;
    }
    paramActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setSystemUiVisibility(this.c);
    b(paramActivity);
    QLog.w("WorldCupMgr", 1, "setSystemUiVisibility, disable, mSystemUiVisibility[" + this.c + "], getSystemUiVisibility[" + this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().getSystemUiVisibility() + "]");
    paramView.setImmersiveStatus();
  }
  
  static void a(ImageView paramImageView)
  {
    paramImageView.setClickable(true);
    paramImageView.setOnTouchListener(new aaka(paramImageView));
  }
  
  private boolean a(ImageView paramImageView, aakd paramaakd)
  {
    Object localObject2 = paramaakd.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.a(0) + "splash/";
    Object localObject1 = new File((String)localObject2, "button.json");
    if (!((File)localObject1).exists())
    {
      QLog.i("WorldCupMgr", 1, "loadBtnAnimation, json文件不存在");
      return false;
    }
    localObject2 = new File((String)localObject2, "images");
    if (!((File)localObject2).exists())
    {
      QLog.i("WorldCupMgr", 1, "loadBtnAnimation, image不存在");
      return false;
    }
    localObject2 = ((File)localObject2).getAbsolutePath() + "/";
    try
    {
      localObject1 = new FileInputStream((File)localObject1);
      paramaakd = new aajs(this, new WeakReference(paramImageView), paramaakd, (String)localObject2);
      LottieComposition.Factory.fromInputStream(paramImageView.getContext(), (InputStream)localObject1, paramaakd);
      return true;
    }
    catch (Exception paramImageView)
    {
      QLog.i("WorldCupMgr", 1, "loadRollAnimation, 读取json失败", paramImageView);
    }
    return false;
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(1024);
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin.innerShow, 已经取消展示");
      return false;
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramBaseActivity).inflate(2130968996, null));
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
      localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      TextureVideoView localTextureVideoView = new TextureVideoView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11);
      localTextureVideoView.setOnPreparedListener(new aajq(this, (PopupWindow)localObject, localTextureVideoView));
      localTextureVideoView.setOnErrorListener(new aajv(this));
      localTextureVideoView.setOnInfoListener(new aajw(this, (PopupWindow)localObject, localTextureVideoView));
      localTextureVideoView.setOnCompletionListener(new aajx(this, (PopupWindow)localObject, paramQQAppInterface, localTextureVideoView));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localTextureVideoView, localLayoutParams);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = localTextureVideoView;
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BFFFFFFF")));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new aajy(this, paramBaseActivity, paramView));
    }
    if (!a())
    {
      b();
      return false;
    }
    Object localObject = a(paramQQAppInterface, paramView, this.jdField_a_of_type_Aakd);
    a(paramQQAppInterface, paramBaseActivity, this.jdField_a_of_type_Aakd, (Point)localObject);
    a(8);
    WorldCupStaticInstance.a().c = true;
    a(paramBaseActivity, paramView, true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, 0, 0);
    WorldCupConfigInfo.b(this.jdField_a_of_type_Aakd.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.l, WorldCupConfigInfo.a());
    WorldCupReport.c();
    WorldCup.a(paramQQAppInterface);
    return true;
  }
  
  int a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setSystemUiVisibility(5894);
    QLog.w("WorldCupMgr", 1, "setSystemUiVisibility_1");
    return 5894;
  }
  
  void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        if (paramInt != 0) {
          break label49;
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      }
      return;
      label49:
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
    }
  }
  
  void a(AppInterface paramAppInterface, BaseActivity paramBaseActivity, aakd paramaakd, Point paramPoint)
  {
    int i;
    int j;
    int k;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources();
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localImageView.setVisibility(4);
      i = paramaakd.c;
      j = paramaakd.d;
      k = AIOUtils.a(30, (Resources)localObject);
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, k);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(localImageView);
      a(localImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aakb(this, paramaakd, paramAppInterface, paramBaseActivity));
      a(this.jdField_a_of_type_AndroidWidgetImageView, paramaakd);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      paramBaseActivity = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources();
      paramAppInterface = new ImageView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      this.jdField_b_of_type_AndroidWidgetImageView = paramAppInterface;
      paramAppInterface.setVisibility(4);
      paramAppInterface.setImageDrawable(paramaakd.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      i = paramaakd.e;
      j = paramaakd.f;
      k = AIOUtils.a(12, paramBaseActivity);
      int m = paramPoint.y;
      int n = AIOUtils.a(12, paramBaseActivity);
      paramBaseActivity = new RelativeLayout.LayoutParams(i, j);
      paramBaseActivity.addRule(10, -1);
      paramBaseActivity.addRule(11, -1);
      paramBaseActivity.setMargins(0, k + m, n, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramAppInterface, paramBaseActivity);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(paramAppInterface);
      a(paramAppInterface);
      paramAppInterface.setOnClickListener(new aakc(this));
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin, 取消展示[" + paramString + "]");
      this.jdField_a_of_type_Boolean = false;
    }
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin 关闭闪屏[" + paramString + "]");
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  boolean a()
  {
    String str = this.jdField_a_of_type_Aakd.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.a(0);
    str = str + "splash/splash.mp4";
    if (!FileUtil.a(str))
    {
      QLog.w("WorldCupMgr", 1, "setVideo, 文件不存在");
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(str);
    return true;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin, 正在运行中");
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aakd.b())
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin, 图片加载中");
      return true;
    }
    if (this.jdField_a_of_type_Aakd.a())
    {
      this.jdField_a_of_type_Aakd.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = WorldCup.a(paramQQAppInterface);
      QLog.w("WorldCupMgr", 1, "SplashPopupWin, 请求异步加载图片");
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(this.jdField_a_of_type_Aakd);
      WorldCupMgr.a(paramBaseActivity.getResources(), localArrayList, new aajz(this, paramQQAppInterface, paramBaseActivity, paramView));
      return false;
    }
    return b(paramQQAppInterface, paramBaseActivity, paramView);
  }
  
  int b()
  {
    QLog.w("WorldCupMgr", 1, "setSystemUiVisibility_OK");
    this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setSystemUiVisibility(4870);
    return 4870;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WorldCupMgr", 1, "释放闪屏资源");
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnCompletionListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnErrorListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnInfoListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnPreparedListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aakd.c();
    WorldCupStaticInstance.a().c = false;
  }
  
  int c()
  {
    switch (jdField_a_of_type_Int)
    {
    default: 
      return 0;
    case 0: 
      return b();
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.SplashPopupWin
 * JD-Core Version:    0.7.0.1
 */