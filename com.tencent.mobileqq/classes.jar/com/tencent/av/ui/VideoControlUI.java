package com.tencent.av.ui;

import ajya;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import axqy;
import bbdj;
import bbfj;
import bbgu;
import bbjc;
import bcql;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import lcg;
import lga;
import ljd;
import llw;
import llz;
import lmc;
import lpu;
import lsq;
import lze;
import mag;
import mao;
import mcf;
import mch;
import mcj;
import mcm;
import mjb;
import mjc;
import mjd;
import mje;
import mjf;
import mjg;
import mjh;
import mji;
import mjj;
import mjk;
import mjl;
import mjm;
import mjn;
import mjo;
import mjp;
import mjq;
import mmk;
import moz;
import mpv;
import mqh;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqw;
import mqx;
import msu;
import msv;
import msx;
import mtc;
import mtq;
import muc;

public abstract class VideoControlUI
{
  public static boolean n;
  static boolean o;
  static int v = -1;
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  public Resources a;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new mjk(this);
  public GestureDetector a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mjj(this);
  public View a;
  public ViewGroup a;
  public Animation a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  public VideoController a;
  public VideoAppInterface a;
  public QavPanel a;
  VideoControlUI.ShowSharpInfoRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = null;
  VideoControlUI.TimmerRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
  public VideoControlUI.ToolbarAnimationRunnable a;
  public VideoNetStateBar a;
  public WeakReference<Context> a;
  mag jdField_a_of_type_Mag;
  private mcm jdField_a_of_type_Mcm;
  private mjl jdField_a_of_type_Mjl;
  private mjm jdField_a_of_type_Mjm;
  mjn jdField_a_of_type_Mjn;
  mjp jdField_a_of_type_Mjp;
  mjq jdField_a_of_type_Mjq = null;
  msu jdField_a_of_type_Msu = new mje(this);
  msv jdField_a_of_type_Msv = null;
  msx jdField_a_of_type_Msx = null;
  public mtc a;
  mtq jdField_a_of_type_Mtq = null;
  private boolean jdField_a_of_type_Boolean;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public mcf b;
  mjq jdField_b_of_type_Mjq = null;
  private boolean jdField_b_of_type_Boolean = true;
  public RelativeLayout c;
  public final String c;
  private boolean c;
  public final long d;
  public RelativeLayout d;
  public TextView d;
  String d;
  TextView e;
  public String e;
  public TextView f;
  public String f;
  public String g;
  boolean g;
  Runnable h;
  public boolean h;
  protected boolean i;
  public boolean j = false;
  int k;
  public boolean k;
  int l;
  public boolean l;
  int m;
  public boolean m;
  int n;
  public int o;
  int p;
  public boolean p;
  int q = 0;
  public int r = 0;
  int s = 0;
  int t = 0;
  int u = 0;
  public int w;
  public int x = 0;
  public final int y = 256;
  public final int z = 257;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcf parammcf)
  {
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Mtc = null;
    this.jdField_h_of_type_JavaLangRunnable = new VideoControlUI.3(this);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable = new VideoControlUI.ToolbarAnimationRunnable(this);
    this.jdField_m_of_type_Boolean = true;
    this.jdField_g_of_type_JavaLangString = (Build.MANUFACTURER + "." + Build.MODEL);
    this.jdField_d_of_type_Long = 1500L;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "VideoControlUI");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Mjp = new mjp(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mjp);
    this.jdField_a_of_type_Mjm = new mjm(this, Looper.getMainLooper());
    paramVideoAppInterface = a();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResResources = paramVideoAppInterface.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      lcg.d(this.jdField_c_of_type_JavaLangString, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131720749) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      lcg.d(this.jdField_c_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131720749) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_Mcf = parammcf;
    this.s = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297764);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131297766);
    this.t = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297767);
    this.u = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297782);
  }
  
  public static int a(lga paramlga, int paramInt)
  {
    int i2 = 2131696134;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = 2131696130;
    }
    for (;;)
    {
      if (paramlga.i == 1011)
      {
        if (paramInt != 9) {
          break;
        }
        i1 = 2131720751;
      }
      return i1;
      i1 = 2131720769;
      continue;
      i1 = i2;
      if (!paramlga.r)
      {
        i1 = 2131696132;
        continue;
        i1 = 2131696009;
        continue;
        i1 = 2131696131;
        continue;
        i1 = 2131696129;
        continue;
        i1 = 2131696133;
        continue;
        i1 = 2131696130;
        continue;
        i1 = 2131696051;
      }
    }
    return 2131695741;
  }
  
  private void a(int paramInt)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.getLayoutInflater().inflate(paramInt, this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a();
    Window localWindow;
    if ((Build.VERSION.SDK_INT >= 19) && (localObject != null))
    {
      localWindow = ((AVActivity)localObject).getWindow();
      if (localWindow != null) {
        if ((!paramBoolean1) || (!paramBoolean2)) {
          break label272;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (k()) {
          break label272;
        }
        i1 = 1;
        int i2 = i1;
        if (i1 == 0)
        {
          localObject = ((AVActivity)localObject).findViewById(2131372225);
          i2 = i1;
          if (localObject != null)
          {
            i2 = i1;
            if (((View)localObject).isShown()) {
              i2 = 1;
            }
          }
          if (jdField_n_of_type_Boolean) {
            i2 = 1;
          }
        }
        if (i2 == 0) {
          continue;
        }
        localWindow.setFlags(2048, 1024);
        if (!QLog.isDevelopLevel()) {
          break label271;
        }
        str2 = ImmersiveUtils.a;
        localStringBuilder = new StringBuilder().append("setSystemStatusBar, ");
        if (i2 == 0) {
          continue;
        }
        localObject = "显示";
      }
      catch (Exception localException)
      {
        String str2;
        StringBuilder localStringBuilder;
        if (!QLog.isDevelopLevel()) {
          break label271;
        }
        QLog.w(ImmersiveUtils.a, 1, "setSystemStatusBar, Exception", localException);
        return;
        String str1 = "隐藏";
        continue;
      }
      QLog.w(str2, 1, (String)localObject + "状态栏, isToolBarDisplay[" + paramBoolean1 + "], recordNeedShowBar[" + paramBoolean2 + "], SystemUiVisibility[0x" + Integer.toHexString(localWindow.getDecorView().getSystemUiVisibility()) + "], flags[0x" + Integer.toHexString(localWindow.getAttributes().flags) + "]");
      return;
      localWindow.addFlags(1024);
      continue;
      label271:
      return;
      label272:
      int i1 = 0;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (!VideoController.a(paramContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int d()
  {
    if ((!this.jdField_l_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return e();
    }
    return f();
  }
  
  private void d(long paramLong, int paramInt)
  {
    if (g()) {}
    do
    {
      return;
      if ((!CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong)) && (!CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "enableCameraRelatedBtn, cameraAvailable[" + paramInt + "], already opening or opened");
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a().Z = paramInt;
    f(paramLong, 65535);
  }
  
  private int e()
  {
    return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297451);
  }
  
  private int f()
  {
    int i1 = 0;
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(99);
    if (localRelativeLayout != null)
    {
      localRelativeLayout.measure(0, 0);
      i1 = localRelativeLayout.getMeasuredHeight();
    }
    return i1;
  }
  
  protected static boolean i()
  {
    if (v == -1)
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break label32;
      }
      v = 0;
    }
    for (;;)
    {
      if (v == 1)
      {
        return true;
        try
        {
          label32:
          bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
          if (Build.DEVICE.equals("mx2"))
          {
            bool = true;
            if (!bool) {
              break label125;
            }
            i1 = 1;
            v = i1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i1;
            boolean bool = false;
            continue;
            if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9")))
            {
              bool = false;
              continue;
              label125:
              i1 = 0;
            }
          }
        }
      }
    }
    return false;
  }
  
  void A(long paramLong)
  {
    int i2 = 8;
    if (g()) {
      return;
    }
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    if (!lpu.a())
    {
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Beauty, !isEnableAEModuleManager, seq[" + paramLong + "]");
        i1 = i2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(i1);
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Beauty, show[" + i1 + "], seq[" + paramLong + "]");
      return;
      if (!locallga.j)
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Beauty, !localHasVideo, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if (!ljd.b())
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if ((AEFilterSupport.a()) && (!AEFilterSupport.a(2)))
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Beauty, AEKitSo not ready, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  void B(long paramLong)
  {
    boolean bool = false;
    if (g()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2;
    if ((((lga)localObject).d == 1) && (!((lga)localObject).j()))
    {
      i2 = 8;
      i1 = i2;
      if (jdField_o_of_type_Boolean) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_More, !isConnected, seq[" + paramLong + "]");
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372517);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372517, i1);
      localObject = a();
      if ((i2 != i1) && (localObject != null))
      {
        if (i1 == 0) {
          bool = true;
        }
        ((AVActivity)localObject).a(bool);
        ((AVActivity)localObject).a(paramLong, 2131372517, i2, i1);
      }
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_More, show[" + i1 + "], lastvisibility[" + i2 + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPauseAudio");
    }
  }
  
  void C(long paramLong)
  {
    if (g()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (this.jdField_o_of_type_Int > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372521, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372521, 8);
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onResumeAudio");
    }
  }
  
  void D(long paramLong)
  {
    if (g()) {}
    mqh localmqh;
    do
    {
      return;
      localmqh = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695658);
      if (localmqh != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_VideoMode, null, seq[" + paramLong + "]");
    return;
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = 2130841700;
    if (locallga.M == 4) {
      i1 = 2130841699;
    }
    localmqh.a(i1);
    if ((!locallga.j) && (!locallga.jdField_k_of_type_Boolean)) {}
    for (boolean bool = false;; bool = true)
    {
      localmqh.c(bool);
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_VideoMode, bShow[" + bool + "], screenStyle[" + locallga.M + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void E()
  {
    if (this.jdField_a_of_type_Mjm != null)
    {
      this.jdField_a_of_type_Mjm.removeMessages(256);
      this.jdField_a_of_type_Mjm.removeMessages(257);
    }
  }
  
  void E(long paramLong)
  {
    boolean bool = false;
    if (g()) {}
    int i1;
    do
    {
      mqh localmqh;
      do
      {
        return;
        localmqh = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695655);
        if (localmqh != null) {
          break;
        }
      } while (!jdField_o_of_type_Boolean);
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ScreenShot, null, seq[" + paramLong + "]");
      return;
      lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i2 = 8;
      i1 = i2;
      if (!locallga.w) {
        if (locallga.d != 4)
        {
          i1 = i2;
          if (locallga.d != 2) {}
        }
        else
        {
          i1 = 0;
        }
      }
      if (i1 == 0) {
        bool = true;
      }
      localmqh.c(bool);
    } while (!jdField_o_of_type_Boolean);
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ScreenShot, visible[" + i1 + "], seq[" + paramLong + "]");
  }
  
  public void F()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
  }
  
  void F(long paramLong)
  {
    if (g()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.d())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372208, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372208, true);
  }
  
  void G()
  {
    this.jdField_a_of_type_Msv = new msv();
    this.jdField_a_of_type_Msv.a(100);
    this.jdField_a_of_type_Msv.b(8);
    this.jdField_a_of_type_Msv.a(new int[] { 2130841477, 2130841478 });
    this.jdField_a_of_type_Msv.a(this.jdField_a_of_type_Msu);
  }
  
  void G(long paramLong)
  {
    boolean bool3 = false;
    if (g()) {}
    mqh localmqh;
    do
    {
      return;
      localmqh = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695651);
      if (localmqh != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ControlMember, null, seq[" + paramLong + "]");
    return;
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((locallga.d == 1) || (locallga.d == 2))
    {
      i1 = 8;
      bool1 = false;
    }
    for (;;)
    {
      label102:
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        localmqh.b(bool2);
        localmqh.a(bool1);
        bool2 = bool3;
        if (i1 == 0) {
          bool2 = true;
        }
        localmqh.c(bool2);
        if (!jdField_o_of_type_Boolean) {
          break;
        }
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ControlMember, enable[" + bool1 + "], visible[" + i1 + "], seq[" + paramLong + "]");
        return;
        if ((locallga.d != 3) && (locallga.d != 4)) {
          break label288;
        }
        if ((!locallga.aa) && (!locallga.ab))
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (locallga.u())
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
          break label288;
        }
        i1 = 0;
        bool1 = false;
        break label102;
      }
      label288:
      i1 = 0;
      bool1 = true;
    }
  }
  
  public void H()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
  }
  
  public void I()
  {
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public void J()
  {
    mao.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public void K()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_c_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("displayToolBar, isToolBarDisplay[").append(h()).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break;
      }
      return;
    }
    if (!h())
    {
      o(false);
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  public void L()
  {
    if (g()) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372216, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372208, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372213, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372210, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372211, false);
  }
  
  public void M()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.h();
    }
  }
  
  public void N() {}
  
  public void O()
  {
    a(h(), true);
  }
  
  void P()
  {
    if (this.jdField_l_of_type_Int - this.jdField_n_of_type_Int > 2)
    {
      this.jdField_n_of_type_Int = this.jdField_l_of_type_Int;
      this.jdField_m_of_type_Int = 0;
    }
    this.jdField_m_of_type_Int += 1;
    if (this.jdField_m_of_type_Int > 5)
    {
      this.jdField_m_of_type_Int = 0;
      this.jdField_n_of_type_Int = 0;
      r(true);
    }
  }
  
  protected abstract int a();
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(long paramLong)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    while (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
      return 0;
    }
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298958);
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372510) == null) || (!this.jdField_h_of_type_Boolean))
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "getTopToolbarHeight, topToolbarHeight[" + i1 + "], margin[" + i2 + "], mInToolBarAnimation[" + this.jdField_l_of_type_Boolean + "], mToolbarDisplayFrameNow[" + this.w + "], seq[" + paramLong + "]");
      return i1;
    }
    if (this.jdField_l_of_type_Boolean) {
      i1 = i2 / 5;
    }
    for (i1 = Math.max(this.w, 0) * i1;; i1 = i2)
    {
      i1 += c();
      break;
    }
  }
  
  public AlphaAnimation a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setFillEnabled(true);
      localAlphaAnimation.setStartOffset(0L);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      return localAlphaAnimation;
    }
  }
  
  public AVActivity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)) {
      return null;
    }
    return (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public EffectSettingUi a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      return (EffectSettingUi)this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2);
    }
    return null;
  }
  
  public QavPanel a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanel;
  }
  
  String a(String paramString)
  {
    return paramString;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i1 = Build.VERSION.SDK_INT;
      if ((i1 != 14) && (i1 != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      if (paramInt3 == 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetToast = bcql.a(localContext, paramInt1, paramInt2).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = bcql.a(localContext, paramInt1, paramInt2).b(paramInt3);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null)
    {
      int i1 = Build.VERSION.SDK_INT;
      if ((i1 != 14) && (i1 != 15)) {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
      }
    }
    this.jdField_a_of_type_AndroidWidgetToast = null;
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      if (paramInt4 == 0) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetToast = bcql.a(localContext, paramInt2, paramInt1, paramInt3).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = bcql.a(localContext, paramInt2, paramInt1, paramInt3).b(paramInt4);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramInt1, paramInt2, paramInt3, paramString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 1037) {}
    for (paramInt = 256;; paramInt = 257)
    {
      if (this.jdField_a_of_type_Mjm != null)
      {
        this.jdField_a_of_type_Mjm.removeMessages(paramInt);
        paramString = this.jdField_a_of_type_Mjm.obtainMessage(paramInt, paramString);
        this.jdField_a_of_type_Mjm.sendMessageDelayed(paramString, 1500L);
      }
      return;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_k_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d();
    }
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void a(long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Mag != null) {
      this.jdField_a_of_type_Mag.a(paramLong, paramFloat);
    }
    if (this.jdField_a_of_type_Mcm != null) {
      this.jdField_a_of_type_Mcm.a(paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (g()) {
      return;
    }
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], sessionInfo[" + locallga + "], seq[" + paramLong + "]");
    }
    if (locallga.m()) {
      j(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mtc != null) {
        this.jdField_a_of_type_Mtc.a(false);
      }
      if ((!lze.f()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372216, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372208, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372213, false);
      return;
      if ((paramInt == 25) || (paramInt == 56)) {
        j(paramInt);
      }
      l();
    }
  }
  
  void a(long paramLong, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {}
    label210:
    label216:
    do
    {
      boolean bool2;
      do
      {
        return;
        if (!localAVActivity.isResume())
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog, no isResume, seq[" + paramLong + "]");
          return;
        }
        boolean bool1;
        if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0)
        {
          bool1 = true;
          if (localAVActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label210;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog, issueType[" + paramInt + "], showNormalDialog[" + paramBoolean + "], checkCameraResult[" + bool1 + "], checkRecordResult[" + bool2 + "], seq[" + paramLong + "]");
          if ((bool1) || (bool2) || (paramInt != 2)) {
            break label216;
          }
          localAVActivity.requestPermissions(this, 0, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
          this.jdField_k_of_type_Boolean = true;
          return;
          bool1 = false;
          break;
        }
        switch (paramInt)
        {
        default: 
          return;
        case 2: 
          if (!bool1)
          {
            localAVActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
            this.jdField_k_of_type_Boolean = true;
            return;
          }
          break;
        }
      } while (!paramBoolean);
      b(paramLong, paramString1, paramString2);
      return;
      if (!bool2)
      {
        localAVActivity.requestPermissions(this, 2, new String[] { "android.permission.RECORD_AUDIO" });
        return;
      }
    } while (!paramBoolean);
    b(paramLong, paramString1, paramString2);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    int i1;
    if (!this.jdField_c_of_type_Boolean)
    {
      if (paramLong1 != 0L) {
        break label63;
      }
      i1 = 2968;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "doUpdateAudioVolumeChange nexValue:=" + i1);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAudioVolumeValue(i1);
      return;
      label63:
      if (paramLong1 == 100L) {
        i1 = 7187;
      } else {
        i1 = (int)(2968.75F + 4218.75F * (float)paramLong1 / 100.0F);
      }
    }
  }
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (g()) {
      return;
    }
    AVActivity localAVActivity = a();
    paramString1 = bbdj.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690596, new mjg(this, paramLong));
    if (muc.a(localAVActivity)) {}
    for (int i1 = 2131695963;; i1 = 2131695964)
    {
      paramString1.setPositiveButton(i1, new mjf(this, paramLong)).show();
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  public abstract void a(long paramLong, boolean paramBoolean, int paramInt);
  
  void a(Boolean paramBoolean)
  {
    p(paramBoolean.booleanValue());
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a() != null)
    {
      bool1 = bool2;
      if (a().isShown()) {
        bool1 = a().a();
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  boolean a(long paramLong, String paramString, View paramView)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return false;
    }
    label54:
    int i3;
    int i2;
    if (localAVActivity.checkSelfPermission(paramString) == 0)
    {
      i1 = 1;
      if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
        break label269;
      }
      if ((i1 == 0) || (localAVActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
        break label183;
      }
      i1 = 1;
      i3 = 1;
      i2 = i1;
    }
    for (int i1 = i3;; i1 = 0)
    {
      if (i2 == 0)
      {
        if (a(localAVActivity))
        {
          paramView = new mjd(this, paramString, paramLong, paramView);
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
          this.jdField_p_of_type_Boolean = true;
          if (i1 == 0)
          {
            localAVActivity.requestPermissions(paramView, 0, new String[] { paramString });
            return false;
            i1 = 0;
            break;
            label183:
            i1 = 0;
            break label54;
          }
          localAVActivity.requestPermissions(paramView, 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return false;
        }
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
        e(paramLong, paramString);
        return false;
      }
      return true;
      label269:
      i2 = i1;
    }
  }
  
  public int b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return i2;
    }
    int i1 = d();
    i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298940);
    if (this.jdField_l_of_type_Boolean)
    {
      i2 = i1 / 5;
      i2 = Math.max(this.w, 0) * i2;
      if (i2 <= i1) {}
    }
    for (;;)
    {
      i2 = i1;
      if (!i()) {
        break;
      }
      return i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297744);
      i1 = i2;
      if (i2 <= 0)
      {
        i1 = e();
        continue;
        if (this.jdField_h_of_type_Boolean) {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (muc.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320)) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297446) + i2;
          } else {}
        }
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    AVActivity localAVActivity;
    do
    {
      return;
      a(a());
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372509));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372510));
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372417));
      this.jdField_a_of_type_Mjn = new mjn(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_Mjn);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mjb(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369109));
      localAVActivity = a();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
    return;
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localAVActivity.findViewById(2131372474));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372410) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372411) != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365049));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372516));
    this.jdField_a_of_type_Mtq = mtq.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtq);
    if (this.jdField_a_of_type_Mtc != null) {
      this.jdField_a_of_type_Mtc.a(false);
    }
    this.jdField_a_of_type_Mtc = mtc.a(this.jdField_a_of_type_Mtc, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Mtq);
    this.jdField_a_of_type_Mtc.a(true);
    this.jdField_a_of_type_Mtq.a();
    ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131372187);
    this.jdField_a_of_type_Mag = new mag();
    this.jdField_a_of_type_Mag.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localViewGroup);
    this.jdField_a_of_type_Mcm = new mcm(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_Mcm.a(localViewGroup);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131372513).setBackgroundColor(2145838842);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131372514).setBackgroundColor(2145838842);
    }
    new mjo(this.jdField_a_of_type_AndroidViewViewGroup).a(localAVActivity);
  }
  
  void b(int paramInt) {}
  
  public void b(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372208, paramBoolean);
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372216, paramBoolean);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372521, paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.jdField_k_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lga locallga;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
      }
      if (this.jdField_a_of_type_Mag != null) {
        this.jdField_a_of_type_Mag.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      if (this.jdField_a_of_type_Mcm != null) {
        this.jdField_a_of_type_Mcm.c();
      }
      locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallga.j()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      }
    } while ((!locallga.f()) || (locallga.e) || (locallga.j()) || (!locallga.r()) || ((bbfj.h(null)) && (AudioHelper.a(0) != 1)));
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
  }
  
  public void b(long paramLong, int paramInt) {}
  
  protected void b(long paramLong, View paramView) {}
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog, msg[" + paramString1 + "], title[" + paramString2 + "], seq[" + paramLong + "]");
    AVActivity localAVActivity = a();
    paramString1 = bbdj.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690596, new mji(this, paramLong));
    if (muc.a(localAVActivity)) {}
    for (int i1 = 2131695963;; i1 = 2131695964)
    {
      paramString1 = paramString1.setPositiveButton(i1, new mjh(this, paramLong));
      if (!localAVActivity.isResume()) {
        break;
      }
      try
      {
        paramString1.show();
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog, crash", paramString1);
        return;
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected abstract boolean b();
  
  boolean b(int paramInt)
  {
    if (a() != null) {
      return a().a(paramInt);
    }
    return false;
  }
  
  boolean b(long paramLong)
  {
    boolean bool3 = true;
    if (g()) {}
    mqh localmqh;
    do
    {
      return false;
      localmqh = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695653);
      if (localmqh != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_InviteMember, null, seq[" + paramLong + "]");
    return false;
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((locallga.d == 3) || (locallga.d == 4)) {
      if (locallga.u())
      {
        if (!jdField_o_of_type_Boolean) {
          break label336;
        }
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_InviteMember, isHrConf, seq[" + paramLong + "]");
        i1 = 8;
        bool1 = false;
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        bool2 = true;
        label160:
        localmqh.b(bool2);
        if (i1 != 0) {
          break label314;
        }
      }
      label314:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        localmqh.c(bool2);
        return bool1;
        if (((this instanceof MultiVideoCtrlLayerUIBase)) && (((MultiVideoCtrlLayerUIBase)this).c()))
        {
          if (!jdField_o_of_type_Boolean) {
            break label328;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_InviteMember, isFull, seq[" + paramLong + "]");
          i1 = 0;
          bool1 = false;
          break;
        }
        if (!j()) {
          break label320;
        }
        if (jdField_o_of_type_Boolean) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_InviteMember, isKeyguardLock, seq[" + paramLong + "]");
        }
        i1 = 0;
        bool1 = false;
        break;
        bool2 = false;
        break label160;
      }
      label320:
      i1 = 0;
      bool1 = true;
      continue;
      label328:
      i1 = 0;
      bool1 = false;
      continue;
      label336:
      i1 = 8;
      bool1 = false;
    }
  }
  
  public int c()
  {
    if ((new mjo(this.jdField_a_of_type_AndroidViewViewGroup).a()) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return 0;
  }
  
  public abstract void c(int paramInt);
  
  public void c(long paramLong)
  {
    this.jdField_k_of_type_Int = 5;
    y(paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.g();
    }
    if (this.jdField_a_of_type_Mtc != null) {
      this.jdField_a_of_type_Mtc.b(false);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDetectNoDevicePermission, issueType[" + this.x + "->" + paramInt + "], isRequestCameraPermission[" + this.jdField_k_of_type_Boolean + "], seq[" + paramLong + "]");
    }
    this.x = paramInt;
    this.jdField_e_of_type_JavaLangString = "";
    AVActivity localAVActivity = a();
    String str2;
    String str1;
    if (paramInt == 1)
    {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "请求相机权限.2");
      str2 = localAVActivity.getString(2131695951);
      str1 = localAVActivity.getString(2131695952);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
      {
        this.jdField_e_of_type_JavaLangString = "0X8004892";
        this.jdField_f_of_type_JavaLangString = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1)
        {
          this.jdField_e_of_type_JavaLangString = "0X8004898";
          this.jdField_f_of_type_JavaLangString = "0X8004899";
        }
      }
    }
    do
    {
      for (;;)
      {
        this.jdField_m_of_type_Boolean = true;
        axqy.b(null, "CliOper", "", "", this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, 0, 0, "", "", this.jdField_g_of_type_JavaLangString, "");
        if (!a(localAVActivity)) {
          break label753;
        }
        if ((paramInt != 2) || (!this.jdField_k_of_type_Boolean)) {
          break;
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
        {
          this.jdField_e_of_type_JavaLangString = "0X800488C";
          this.jdField_f_of_type_JavaLangString = "0X800488D";
        }
      }
      if (paramInt == 2)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "请求相机权限.3");
        str2 = localAVActivity.getString(2131695951);
        str1 = localAVActivity.getString(2131695952);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
        {
          this.jdField_e_of_type_JavaLangString = "0X80049D3";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
            this.jdField_e_of_type_JavaLangString = "0X80049D4";
          }
        }
        for (;;)
        {
          this.jdField_m_of_type_Boolean = false;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
            this.jdField_e_of_type_JavaLangString = "0X80049D1";
          } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
            this.jdField_e_of_type_JavaLangString = "0X80049D2";
          }
        }
      }
      if (paramInt == 3)
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "请求麦克风权限.1");
        str2 = localAVActivity.getString(2131695961);
        str1 = localAVActivity.getString(2131695962);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
        {
          this.jdField_e_of_type_JavaLangString = "0X800488F";
          this.jdField_f_of_type_JavaLangString = "0X8004890";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1)
          {
            this.jdField_e_of_type_JavaLangString = "0X8004895";
            this.jdField_f_of_type_JavaLangString = "0X8004896";
          }
        }
        for (;;)
        {
          this.jdField_m_of_type_Boolean = true;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
          {
            this.jdField_e_of_type_JavaLangString = "0X8004889";
            this.jdField_f_of_type_JavaLangString = "0X800488A";
          }
          else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
          {
            this.jdField_e_of_type_JavaLangString = "0X8004885";
            this.jdField_f_of_type_JavaLangString = "0X8004886";
          }
        }
      }
      if ((paramInt == 4) && (localAVActivity != null))
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
          mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3004);
        }
        str1 = "";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
        {
          str1 = "0X8004891";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
            str1 = "0X8004897";
          }
        }
        for (;;)
        {
          axqy.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.jdField_g_of_type_JavaLangString, "");
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
            str1 = "0X800488B";
          } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
            str1 = "0X8004887";
          }
        }
      }
    } while (paramInt != 2048);
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_o_of_type_Boolean = true;
    return;
    a(paramLong, paramInt, str2, str1, true);
    return;
    label753:
    b(paramLong, str2, str1);
  }
  
  public abstract void c(long paramLong, View paramView);
  
  public void c(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {}
    int i1;
    int i2;
    float f1;
    do
    {
      return;
      i1 = muc.b(localAVActivity);
      i2 = muc.a(localAVActivity);
      f1 = muc.a(localAVActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + b() + "], topBarHeight[" + a(paramLong) + "], density[" + f1 + "], screenSize[" + i2 + ", " + i1 + "], hasSmartBar[" + i() + "]");
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h == 11)
    {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1015);
      return;
    }
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
  }
  
  public void c(boolean paramBoolean) {}
  
  boolean c(long paramLong)
  {
    if (g()) {}
    mqh localmqh;
    do
    {
      return false;
      localmqh = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695649);
      if (localmqh != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, null, seq[" + paramLong + "]");
    return false;
    boolean bool1;
    if (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      if (!jdField_o_of_type_Boolean) {
        break label605;
      }
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, GLVersion, seq[" + paramLong + "]");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        localmqh.b(bool2);
        if (jdField_o_of_type_Boolean) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, enable[" + bool1 + "], seq[" + paramLong + "]");
        }
        return bool1;
        lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((locallga.d == 1) || (locallga.d == 2))
        {
          if ((locallga.f()) || (locallga.m()) || (locallga.n()))
          {
            if (!jdField_o_of_type_Boolean) {
              break label605;
            }
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, state[" + locallga.g + "], seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.e()) {
            break label428;
          }
          if (!jdField_o_of_type_Boolean) {
            break label605;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, !canAVShift, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (((locallga.d == 3) || (locallga.d == 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.e))
        {
          if (!jdField_o_of_type_Boolean) {
            break label605;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, 没有进入房间, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        label428:
        if (!locallga.jdField_n_of_type_Boolean)
        {
          if (!jdField_o_of_type_Boolean) {
            break label605;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, cameraPermission, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (locallga.Z == 0)
        {
          if (!jdField_o_of_type_Boolean) {
            break label605;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, mCameraAvailable, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (!CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramLong)) {
          break label610;
        }
        if (!jdField_o_of_type_Boolean) {
          break label605;
        }
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, isCameraOpening, seq[" + paramLong + "]");
        bool1 = false;
        break;
      }
      label605:
      bool1 = false;
      continue;
      label610:
      bool1 = true;
    }
  }
  
  public void d()
  {
    this.jdField_k_of_type_Int = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Mjl == null))
    {
      this.jdField_a_of_type_Mjl = new mjl(this);
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "register camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Mjl, localIntentFilter);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      IntentFilter localIntentFilter;
      return;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "CANNOT register camera availability change receiver!");
  }
  
  public abstract void d(int paramInt);
  
  public void d(long paramLong)
  {
    this.jdField_k_of_type_Int = 6;
    if (this.jdField_a_of_type_Mag != null)
    {
      this.jdField_a_of_type_Mag.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Mag = null;
    }
    if (this.jdField_a_of_type_Mcm != null)
    {
      this.jdField_a_of_type_Mcm.e();
      this.jdField_a_of_type_Mcm = null;
    }
    if (this.jdField_a_of_type_Mjm != null)
    {
      this.jdField_a_of_type_Mjm.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Mjm = null;
    }
    y(paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      if (this.jdField_a_of_type_Mjp != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mjp);
        this.jdField_a_of_type_Mjp = null;
      }
    }
    if (this.jdField_a_of_type_Mtc != null) {
      this.jdField_a_of_type_Mtc.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Mjl != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label394;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Mjl);
      this.jdField_a_of_type_Mjl = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong);
        this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
      }
      this.jdField_a_of_type_AndroidContentResResources = null;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
      this.jdField_a_of_type_Msv = null;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_Mjq = null;
      this.jdField_b_of_type_Mjq = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
      this.jdField_b_of_type_Mcf = null;
      this.jdField_d_of_type_AndroidWidgetTextView = null;
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_Msx = null;
      this.jdField_a_of_type_Msu = null;
      this.jdField_a_of_type_Mtc = null;
      this.jdField_a_of_type_Mtq = null;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c();
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
      }
      return;
      label394:
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
  }
  
  public abstract void d(long paramLong, View paramView);
  
  void d(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setConnectInfo, str[" + paramString + "], seq[" + paramLong + "]");
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      muc.a(this.jdField_d_of_type_AndroidWidgetTextView, paramString);
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramString);
    }
  }
  
  public boolean d(long paramLong)
  {
    if (g()) {}
    mqh localmqh1;
    mqh localmqh2;
    do
    {
      return false;
      localmqh1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695652);
      localmqh2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695659);
    } while ((localmqh1 == null) && (localmqh2 == null));
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (lpu.a()) {
      if (!CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramLong)) {
        break label284;
      }
    }
    label278:
    label284:
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool3 = true;
      boolean bool2 = bool1;
      bool1 = bool3;
      if (locallga.j)
      {
        if (localmqh1 != null) {
          if (bool2) {
            break label225;
          }
        }
        label225:
        for (bool3 = true;; bool3 = false)
        {
          localmqh1.b(bool3);
          localmqh1.a(bool2);
          localmqh1.c(bool1);
          if (localmqh2 != null) {
            localmqh2.c(false);
          }
          if (localmqh2 != null) {
            localmqh2.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().v);
          }
          if (jdField_o_of_type_Boolean) {
            QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_EffectAndVoice, enable[" + bool2 + "], seq[" + paramLong + "]");
          }
          return true;
          bool1 = false;
          bool2 = false;
          break;
        }
      }
      if (localmqh2 != null) {
        if (bool2) {
          break label278;
        }
      }
      for (bool3 = true;; bool3 = false)
      {
        localmqh2.b(bool3);
        localmqh2.a(bool2);
        localmqh2.c(bool1);
        if (localmqh1 == null) {
          break;
        }
        localmqh1.c(false);
        break;
      }
    }
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog deniedForAudioRecord(2) 04");
  }
  
  @QQPermissionDenied(1)
  public void deniedForCamera()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog deniedForCamera(1) 02");
  }
  
  @QQPermissionDenied(0)
  public void deniedForCameraAudio()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog deniedForCameraAudio(1) 00");
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.isPressed())) {}
    label551:
    label693:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "switchToolBar-->mVideoController is null, Why???");
            return;
          } while (((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) || (this.j) || ((!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)));
          bool2 = this.jdField_h_of_type_Boolean;
          if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "switchToolBar-->mRootView is null Why");
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().I)) {
          break label551;
        }
        o(true);
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "switchToolBar, ToolbarDisplay[" + bool2 + "->" + this.jdField_h_of_type_Boolean + "], type[" + paramInt + "]");
        lze.a();
        if (!this.jdField_h_of_type_Boolean) {
          break label693;
        }
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar mQavPanel.isShown()[" + this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown() + "], mTopToolbar.isShown()[" + this.jdField_c_of_type_AndroidWidgetRelativeLayout.isShown() + "]");
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.isShown()));
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.q += 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar type=" + paramInt + ", toolbarShowTimes: " + this.q);
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = a(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = a(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Mjq == null) {
          this.jdField_a_of_type_Mjq = new mjq(this, 2);
        }
        if (this.jdField_b_of_type_Mjq == null) {
          this.jdField_b_of_type_Mjq = new mjq(this, 1);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_Mjq);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_Mjq);
        if (llw.a()) {
          break label782;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        }
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
        {
          o(true);
          break;
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 3) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().I))
        {
          o(true);
          break;
        }
        if (llz.a().a.jdField_a_of_type_Boolean)
        {
          o(true);
          break;
        }
        if (!this.jdField_h_of_type_Boolean) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          o(bool1);
          break;
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772124);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772161);
        continue;
        ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372307)).setVisibility(4);
        if (paramInt == 1)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = a(false);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = a(false);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772123);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772160);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_a_of_type_Mjq != null) {
        this.jdField_a_of_type_Mjq.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    label782:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void e(long paramLong)
  {
    if (this.jdField_a_of_type_Mtc != null) {
      this.jdField_a_of_type_Mtc.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_c_of_type_JavaLangString, 4, "onConnected");
    }
  }
  
  public void e(long paramLong, View paramView)
  {
    if (g()) {
      return;
    }
    z(paramLong);
    paramView = new mcj(paramView);
    paramView.a(paramLong, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9005), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_More, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq" + paramLong + "]");
    }
    for (;;)
    {
      a().g(paramLong);
      return;
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, true);
      } else {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 1, true);
      }
    }
  }
  
  public void e(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAVActivity.getString(2131695951);
      paramString = localAVActivity.getString(2131695952);
    }
    for (;;)
    {
      a(paramLong, str, paramString);
      return;
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        str = localAVActivity.getString(2131695961);
        paramString = localAVActivity.getString(2131695962);
      }
      else
      {
        if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
          break;
        }
        str = localAVActivity.getString(2131695959);
        paramString = localAVActivity.getString(2131695960);
      }
    }
  }
  
  void e(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Mag != null) {
      this.jdField_a_of_type_Mag.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_Mcm != null) {
      this.jdField_a_of_type_Mcm.d();
    }
  }
  
  public void f(int paramInt) {}
  
  public void f(long paramLong) {}
  
  public void f(long paramLong, int paramInt)
  {
    if (g()) {}
    do
    {
      return;
      jdField_o_of_type_Boolean = AudioHelper.e();
      if ((paramInt & 0x1) == 1) {
        B(paramLong);
      }
      if ((paramInt & 0x2) == 2) {
        c(paramLong);
      }
      if ((paramInt & 0x4) == 4) {
        h(paramLong);
      }
      if ((paramInt & 0x8) == 8) {
        d(paramLong);
      }
      if ((paramInt & 0x10) == 16) {
        F(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        C(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        b(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        G(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        A(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        D(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        E(paramLong);
      }
      g(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
    } while (!jdField_o_of_type_Boolean);
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn, sessionInfo[" + locallga + "], screenStyle[" + locallga.M + "], remoteHasVideo[" + locallga.jdField_k_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
  }
  
  void f(long paramLong, View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_ScreenShot, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mjc(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(l1);
    }
    mqx.a();
  }
  
  public void f(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  public void g() {}
  
  public void g(int paramInt) {}
  
  protected void g(long paramLong) {}
  
  void g(long paramLong, int paramInt)
  {
    if (paramInt > 0)
    {
      d(paramLong, this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
      return;
    }
    d(paramLong, null);
  }
  
  void g(long paramLong, View paramView)
  {
    mqw.f();
    paramView = new mch(paramView, 1);
    paramView.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Voice, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695652);
      return;
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Voice, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, paramView.jdField_b_of_type_Int);
    }
  }
  
  public void g(String paramString)
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "hideToolBar[" + paramString + "], isToolBarDisplay[" + h() + "], mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "]");
    if (this.jdField_h_of_type_Boolean) {
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  public void g(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity != null) && (localAVActivity.jdField_a_of_type_Mmk != null)) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i1 = 2;; i1 = 0)
    {
      localAVActivity.jdField_a_of_type_Mmk.c(i1);
      return;
    }
  }
  
  public boolean g()
  {
    return this.jdField_k_of_type_Int == 6;
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog grantForAudioRecord(2) 03");
  }
  
  @QQPermissionGrant(1)
  public void grantForCamera()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog grantForCamera(1) 01");
  }
  
  @QQPermissionGrant(0)
  public void grantForCameraAudio()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog grantForCameraAudio(1) 0");
  }
  
  public void h() {}
  
  protected void h(long paramLong) {}
  
  void h(long paramLong, int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_MiddleCenter, visibility[" + this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void h(long paramLong, View paramView)
  {
    paramView = new mch(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Effect, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695652);
      return;
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Effect, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, paramView.jdField_b_of_type_Int);
    }
  }
  
  void h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    TextView localTextView;
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setChatTime, time[" + paramString + "]");
        }
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364066);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!muc.jdField_a_of_type_Boolean);
    if (TextUtils.isEmpty(paramString))
    {
      muc.a(localTextView, "");
      return;
    }
    muc.a(localTextView, muc.a(paramString));
  }
  
  void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
  }
  
  public boolean h()
  {
    return (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.getVisibility() == 0);
  }
  
  public void i() {}
  
  public void i(int paramInt)
  {
    if (paramInt == 1037) {}
    for (paramInt = 256;; paramInt = 257)
    {
      if (this.jdField_a_of_type_Mjm != null) {
        this.jdField_a_of_type_Mjm.removeMessages(paramInt);
      }
      return;
    }
  }
  
  public abstract void i(long paramLong);
  
  void i(long paramLong, int paramInt)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable == null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = new VideoControlUI.ShowSharpInfoRunnable(this);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable);
  }
  
  public void j() {}
  
  void j(int paramInt)
  {
    b(a(this.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt));
  }
  
  public abstract void j(long paramLong);
  
  void j(long paramLong, int paramInt)
  {
    if ((2131695654 != paramInt) && (2131695652 != paramInt)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, true);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(paramBoolean);
    }
  }
  
  @TargetApi(16)
  public boolean j()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
          }
          if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
          {
            boolean bool = localKeyguardManager.isKeyguardSecure();
            if (bool) {
              return true;
            }
          }
          return false;
        }
        catch (SecurityException localSecurityException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "isKeyguardLocked() = " + localSecurityException);
          }
          return bbjc.a(localContext);
        }
      }
      return bbjc.a(localContext);
    }
    return true;
  }
  
  public void k() {}
  
  void k(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, this.jdField_a_of_type_AndroidContentResResources.getString(2131692964));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, true);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(paramBoolean);
    }
  }
  
  protected boolean k()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = mpv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    }
    return bool;
  }
  
  void l() {}
  
  void l(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, this.jdField_a_of_type_AndroidContentResResources.getString(2131692956));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372216, false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
  }
  
  public void l(long paramLong)
  {
    this.jdField_k_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.f();
    }
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramBoolean);
    }
  }
  
  public void m() {}
  
  public void m(int paramInt)
  {
    this.jdField_o_of_type_Int = paramInt;
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(paramBoolean);
    }
  }
  
  public void n() {}
  
  public void n(boolean paramBoolean)
  {
    a(h(), paramBoolean);
  }
  
  public void o() {}
  
  public void o(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(170), Boolean.valueOf(this.jdField_h_of_type_Boolean) });
    }
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372528);
    } while (localView == null);
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  protected void q(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 1)
    {
      mao.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, 3000L);
      return;
    }
  }
  
  public void r(boolean paramBoolean)
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      AudioHelper.jdField_b_of_type_Boolean = paramBoolean;
      f(paramBoolean);
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void t() {}
  
  public void u() {}
  
  public void x(long paramLong)
  {
    if (this.jdField_g_of_type_Boolean) {}
    while ((this.jdField_k_of_type_Int < 2) || (this.jdField_k_of_type_Int > 4) || ((VideoLayerUIBase.a(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (!b()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "startTimer, seq[" + paramLong + "]");
    }
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable == null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = new VideoControlUI.TimmerRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable, 0L);
    d(paramLong, null);
  }
  
  public void y(long paramLong)
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "stopTimer, seq[" + paramLong + "]");
    }
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    }
    h(null);
  }
  
  public void z(long paramLong)
  {
    if (g()) {}
    for (;;)
    {
      return;
      boolean bool = QLog.isDevelopLevel();
      String str = "";
      lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      Object localObject = a();
      if ((localObject != null) && (((AVActivity)localObject).b()))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        localObject = str;
        if (bool) {
          localObject = "isKeepToolBar";
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "resetToolBarTimer, mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "], SessionType[" + locallga.d + "], log[" + (String)localObject + "], seq[" + paramLong + "]");
        return;
        if ((locallga.d == 2) || (locallga.d == 4))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (this.jdField_h_of_type_Boolean) {
            if ((locallga.d == 2) && (!locallga.j()))
            {
              localObject = str;
              if (bool) {
                localObject = "not Connected";
              }
            }
            else if ((locallga.d == 4) && (locallga.q()))
            {
              localObject = str;
              if (bool) {
                localObject = "not Recv Data";
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 6000L);
              localObject = str;
              if (bool) {
                localObject = ajya.a(2131716128);
              }
            }
          }
        }
        else if (locallga.d != 1)
        {
          localObject = str;
          if (locallga.d != 3) {}
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (!this.jdField_h_of_type_Boolean)
          {
            e(0);
            localObject = str;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */