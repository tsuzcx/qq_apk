package com.tencent.av.ui;

import ajjy;
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
import awqx;
import babr;
import badq;
import bafb;
import bahj;
import bbmy;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import krx;
import kvq;
import kys;
import lbk;
import lbn;
import lbq;
import lfi;
import lie;
import lor;
import lpt;
import lqb;
import lru;
import lrw;
import lry;
import lyn;
import lyo;
import lyp;
import lyq;
import lyr;
import lys;
import lyt;
import lyu;
import lyv;
import lyw;
import lyx;
import lyy;
import lyz;
import lza;
import lzb;
import lzc;
import mbo;
import med;
import mez;
import mfl;
import mga;
import mgb;
import mhy;
import mhz;
import mib;
import mig;
import miu;
import mjg;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public abstract class VideoControlUI
{
  public static boolean n;
  static boolean o;
  static int v = -1;
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  public Resources a;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new lyw(this);
  public GestureDetector a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new lyv(this);
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
  lpt jdField_a_of_type_Lpt;
  private lyx jdField_a_of_type_Lyx;
  private lyy jdField_a_of_type_Lyy;
  lyz jdField_a_of_type_Lyz;
  lzb jdField_a_of_type_Lzb;
  lzc jdField_a_of_type_Lzc = null;
  mhy jdField_a_of_type_Mhy = new lyq(this);
  mhz jdField_a_of_type_Mhz = null;
  mib jdField_a_of_type_Mib = null;
  public mig a;
  miu jdField_a_of_type_Miu = null;
  private boolean jdField_a_of_type_Boolean;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public lru b;
  lzc jdField_b_of_type_Lzc = null;
  public RelativeLayout c;
  public final String c;
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
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, lru paramlru)
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
    this.jdField_a_of_type_Mig = null;
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
    this.jdField_a_of_type_Lzb = new lzb(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lzb);
    this.jdField_a_of_type_Lyy = new lyy(this, Looper.getMainLooper());
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
      krx.d(this.jdField_c_of_type_JavaLangString, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131654840) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      krx.d(this.jdField_c_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131654840) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_Lru = paramlru;
    this.s = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166675);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131166677);
    this.t = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166678);
    this.u = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166693);
  }
  
  public static int a(kvq paramkvq, int paramInt)
  {
    int i2 = 2131630433;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = 2131630429;
    }
    for (;;)
    {
      if (paramkvq.i == 1011)
      {
        if (paramInt != 9) {
          break;
        }
        i1 = 2131654842;
      }
      return i1;
      i1 = 2131654860;
      continue;
      i1 = i2;
      if (!paramkvq.r)
      {
        i1 = 2131630431;
        continue;
        i1 = 2131630313;
        continue;
        i1 = 2131630430;
        continue;
        i1 = 2131630428;
        continue;
        i1 = 2131630432;
        continue;
        i1 = 2131630429;
        continue;
        i1 = 2131630353;
      }
    }
    return 2131630053;
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
          localObject = ((AVActivity)localObject).findViewById(2131306526);
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
    this.jdField_a_of_type_ComTencentAvVideoController.a().X = paramInt;
    f(paramLong, 65535);
  }
  
  private int e()
  {
    return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166362);
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
    boolean bool = false;
    if (g()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2;
    if ((((kvq)localObject).d == 1) && (!((kvq)localObject).j()))
    {
      i2 = 8;
      i1 = i2;
      if (jdField_o_of_type_Boolean) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_More, !isConnected, seq[" + paramLong + "]");
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306805);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131306805, i1);
      localObject = a();
      if ((i2 != i1) && (localObject != null))
      {
        if (i1 == 0) {
          bool = true;
        }
        ((AVActivity)localObject).a(bool);
        ((AVActivity)localObject).a(paramLong, 2131306805, i2, i1);
      }
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_More, show[" + i1 + "], lastvisibility[" + i2 + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  void B(long paramLong)
  {
    if (g()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (this.jdField_o_of_type_Int > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131306809, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131306809, 8);
  }
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPauseAudio");
    }
  }
  
  void C(long paramLong)
  {
    if (g()) {}
    mfl localmfl;
    do
    {
      return;
      localmfl = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629976);
      if (localmfl != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_VideoMode, null, seq[" + paramLong + "]");
    return;
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = 2130841608;
    if (localkvq.K == 4) {
      i1 = 2130841607;
    }
    localmfl.a(i1);
    if ((!localkvq.j) && (!localkvq.jdField_k_of_type_Boolean)) {}
    for (boolean bool = false;; bool = true)
    {
      localmfl.c(bool);
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_VideoMode, bShow[" + bool + "], screenStyle[" + localkvq.K + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onResumeAudio");
    }
  }
  
  void D(long paramLong)
  {
    boolean bool = false;
    if (g()) {}
    int i1;
    do
    {
      mfl localmfl;
      do
      {
        return;
        localmfl = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629973);
        if (localmfl != null) {
          break;
        }
      } while (!jdField_o_of_type_Boolean);
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ScreenShot, null, seq[" + paramLong + "]");
      return;
      kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i2 = 8;
      i1 = i2;
      if (!localkvq.w) {
        if (localkvq.d != 4)
        {
          i1 = i2;
          if (localkvq.d != 2) {}
        }
        else
        {
          i1 = 0;
        }
      }
      if (i1 == 0) {
        bool = true;
      }
      localmfl.c(bool);
    } while (!jdField_o_of_type_Boolean);
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ScreenShot, visible[" + i1 + "], seq[" + paramLong + "]");
  }
  
  public void E()
  {
    if (this.jdField_a_of_type_Lyy != null)
    {
      this.jdField_a_of_type_Lyy.removeMessages(256);
      this.jdField_a_of_type_Lyy.removeMessages(257);
    }
  }
  
  void E(long paramLong)
  {
    if (g()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.d())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306509, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306509, true);
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
    boolean bool3 = false;
    if (g()) {}
    mfl localmfl;
    do
    {
      return;
      localmfl = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629969);
      if (localmfl != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ControlMember, null, seq[" + paramLong + "]");
    return;
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((localkvq.d == 1) || (localkvq.d == 2))
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
        localmfl.b(bool2);
        localmfl.a(bool1);
        bool2 = bool3;
        if (i1 == 0) {
          bool2 = true;
        }
        localmfl.c(bool2);
        if (!jdField_o_of_type_Boolean) {
          break;
        }
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_ControlMember, enable[" + bool1 + "], visible[" + i1 + "], seq[" + paramLong + "]");
        return;
        if ((localkvq.d != 3) && (localkvq.d != 4)) {
          break label288;
        }
        if ((!localkvq.aa) && (!localkvq.ab))
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (localkvq.u())
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
  
  void G()
  {
    this.jdField_a_of_type_Mhz = new mhz();
    this.jdField_a_of_type_Mhz.a(100);
    this.jdField_a_of_type_Mhz.b(8);
    this.jdField_a_of_type_Mhz.a(new int[] { 2130841399, 2130841400 });
    this.jdField_a_of_type_Mhz.a(this.jdField_a_of_type_Mhy);
  }
  
  public void H()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
  }
  
  public void I()
  {
    lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public void J()
  {
    lqb.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306517, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306509, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306514, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306511, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306512, false);
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
      q(true);
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
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131167859);
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131306798) == null) || (!this.jdField_h_of_type_Boolean))
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
        this.jdField_a_of_type_AndroidWidgetToast = bbmy.a(localContext, paramInt1, paramInt2).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = bbmy.a(localContext, paramInt1, paramInt2).b(paramInt3);
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
        this.jdField_a_of_type_AndroidWidgetToast = bbmy.a(localContext, paramInt2, paramInt1, paramInt3).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = bbmy.a(localContext, paramInt2, paramInt1, paramInt3).b(paramInt4);
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
      if (this.jdField_a_of_type_Lyy != null)
      {
        this.jdField_a_of_type_Lyy.removeMessages(paramInt);
        paramString = this.jdField_a_of_type_Lyy.obtainMessage(paramInt, paramString);
        this.jdField_a_of_type_Lyy.sendMessageDelayed(paramString, 1500L);
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
    if (this.jdField_a_of_type_Lpt != null) {
      this.jdField_a_of_type_Lpt.a(paramLong, paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (g()) {
      return;
    }
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], sessionInfo[" + localkvq + "], seq[" + paramLong + "]");
    }
    if (localkvq.m()) {
      j(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mig != null) {
        this.jdField_a_of_type_Mig.a(false);
      }
      if ((!lor.f()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306517, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306509, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306514, false);
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
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (g()) {
      return;
    }
    AVActivity localAVActivity = a();
    paramString1 = babr.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131625035, new lys(this, paramLong));
    if (mjg.a(localAVActivity)) {}
    for (int i1 = 2131630267;; i1 = 2131630268)
    {
      paramString1.setPositiveButton(i1, new lyr(this, paramLong)).show();
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
    int i1;
    if (localAVActivity.checkSelfPermission(paramString) == 0) {
      i1 = 1;
    }
    while (i1 == 0) {
      if (a(localAVActivity))
      {
        paramView = new lyp(this, paramString, paramLong, paramView);
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
        this.jdField_p_of_type_Boolean = true;
        localAVActivity.requestPermissions(paramView, 0, new String[] { paramString });
        return false;
        i1 = 0;
      }
      else
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
        e(paramLong, paramString);
        return false;
      }
    }
    return true;
  }
  
  public int b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return i2;
    }
    int i1 = d();
    i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131167841);
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
      return i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166655);
      i1 = i2;
      if (i2 <= 0)
      {
        i1 = e();
        continue;
        if (this.jdField_h_of_type_Boolean) {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (mjg.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320)) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131166357) + i2;
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
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306797));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131306798));
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306713));
      this.jdField_a_of_type_Lyz = new lyz(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_Lyz);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new lyn(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303441));
      localAVActivity = a();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
    return;
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localAVActivity.findViewById(2131306777));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306706) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306707) != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299482));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306804));
    this.jdField_a_of_type_Miu = miu.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Miu);
    if (this.jdField_a_of_type_Mig != null) {
      this.jdField_a_of_type_Mig.a(false);
    }
    this.jdField_a_of_type_Mig = mig.a(this.jdField_a_of_type_Mig, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Miu);
    this.jdField_a_of_type_Mig.a(true);
    this.jdField_a_of_type_Miu.a();
    ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131306488);
    this.jdField_a_of_type_Lpt = new lpt();
    this.jdField_a_of_type_Lpt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localViewGroup);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131306801).setBackgroundColor(2145838842);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131306802).setBackgroundColor(2145838842);
    }
    new lza(this.jdField_a_of_type_AndroidViewViewGroup).a(localAVActivity);
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306509, paramBoolean);
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306517, paramBoolean);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131306809, paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.jdField_k_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    kvq localkvq;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
      }
      if (this.jdField_a_of_type_Lpt != null) {
        this.jdField_a_of_type_Lpt.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localkvq.j()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      }
    } while ((!localkvq.f()) || (localkvq.e) || (localkvq.j()) || (!localkvq.r()) || ((badq.h(null)) && (AudioHelper.a(0) != 1)));
    lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
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
    paramString1 = babr.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131625035, new lyu(this, paramLong));
    if (mjg.a(localAVActivity)) {}
    for (int i1 = 2131630267;; i1 = 2131630268)
    {
      paramString1 = paramString1.setPositiveButton(i1, new lyt(this, paramLong));
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
    mfl localmfl;
    do
    {
      return false;
      localmfl = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629971);
      if (localmfl != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_InviteMember, null, seq[" + paramLong + "]");
    return false;
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((localkvq.d == 3) || (localkvq.d == 4)) {
      if (localkvq.u())
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
        localmfl.b(bool2);
        if (i1 != 0) {
          break label314;
        }
      }
      label314:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        localmfl.c(bool2);
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
    if ((new lza(this.jdField_a_of_type_AndroidViewViewGroup).a()) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return 0;
  }
  
  public abstract void c(int paramInt);
  
  public void c(long paramLong)
  {
    this.jdField_k_of_type_Int = 5;
    x(paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.g();
    }
    if (this.jdField_a_of_type_Mig != null) {
      this.jdField_a_of_type_Mig.b(false);
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
      str2 = localAVActivity.getString(2131630257);
      str1 = localAVActivity.getString(2131630258);
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
        awqx.b(null, "CliOper", "", "", this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, 0, 0, "", "", this.jdField_g_of_type_JavaLangString, "");
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
        str2 = localAVActivity.getString(2131630257);
        str1 = localAVActivity.getString(2131630258);
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
        str2 = localAVActivity.getString(2131630265);
        str1 = localAVActivity.getString(2131630266);
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
          lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3004);
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
          awqx.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.jdField_g_of_type_JavaLangString, "");
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
      i1 = mjg.b(localAVActivity);
      i2 = mjg.a(localAVActivity);
      f1 = mjg.a(localAVActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + b() + "], topBarHeight[" + a(paramLong) + "], density[" + f1 + "], screenSize[" + i2 + ", " + i1 + "], hasSmartBar[" + i() + "]");
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h == 11)
    {
      lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1015);
      return;
    }
    lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
  }
  
  public void c(boolean paramBoolean) {}
  
  boolean c(long paramLong)
  {
    if (g()) {}
    mfl localmfl;
    do
    {
      return false;
      localmfl = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629967);
      if (localmfl != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, null, seq[" + paramLong + "]");
    return false;
    boolean bool1;
    if (lie.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
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
        localmfl.b(bool2);
        if (jdField_o_of_type_Boolean) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, enable[" + bool1 + "], seq[" + paramLong + "]");
        }
        return bool1;
        kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((localkvq.d == 1) || (localkvq.d == 2))
        {
          if ((localkvq.f()) || (localkvq.m()) || (localkvq.n()))
          {
            if (!jdField_o_of_type_Boolean) {
              break label605;
            }
            QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, state[" + localkvq.g + "], seq[" + paramLong + "]");
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
        if (((localkvq.d == 3) || (localkvq.d == 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.e))
        {
          if (!jdField_o_of_type_Boolean) {
            break label605;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, 没有进入房间, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        label428:
        if (!localkvq.jdField_n_of_type_Boolean)
        {
          if (!jdField_o_of_type_Boolean) {
            break label605;
          }
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Camera, cameraPermission, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (localkvq.X == 0)
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
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Lyx == null))
    {
      this.jdField_a_of_type_Lyx = new lyx(this);
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
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Lyx, localIntentFilter);
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
    if (this.jdField_a_of_type_Lpt != null)
    {
      this.jdField_a_of_type_Lpt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Lpt = null;
    }
    if (this.jdField_a_of_type_Lyy != null)
    {
      this.jdField_a_of_type_Lyy.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Lyy = null;
    }
    x(paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      if (this.jdField_a_of_type_Lzb != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lzb);
        this.jdField_a_of_type_Lzb = null;
      }
    }
    if (this.jdField_a_of_type_Mig != null) {
      this.jdField_a_of_type_Mig.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Lyx != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label375;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Lyx);
      this.jdField_a_of_type_Lyx = null;
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
      this.jdField_a_of_type_Mhz = null;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_Lzc = null;
      this.jdField_b_of_type_Lzc = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
      this.jdField_b_of_type_Lru = null;
      this.jdField_d_of_type_AndroidWidgetTextView = null;
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_Mib = null;
      this.jdField_a_of_type_Mhy = null;
      this.jdField_a_of_type_Mig = null;
      this.jdField_a_of_type_Miu = null;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c();
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
      }
      return;
      label375:
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
      mjg.a(this.jdField_d_of_type_AndroidWidgetTextView, paramString);
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
    mfl localmfl1;
    mfl localmfl2;
    do
    {
      return false;
      localmfl1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629970);
      localmfl2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131629977);
    } while ((localmfl1 == null) && (localmfl2 == null));
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (lfi.a()) {
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
      if (localkvq.j)
      {
        if (localmfl1 != null) {
          if (bool2) {
            break label225;
          }
        }
        label225:
        for (bool3 = true;; bool3 = false)
        {
          localmfl1.b(bool3);
          localmfl1.a(bool2);
          localmfl1.c(bool1);
          if (localmfl2 != null) {
            localmfl2.c(false);
          }
          if (localmfl2 != null) {
            localmfl2.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().u);
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
      if (localmfl2 != null) {
        if (bool2) {
          break label278;
        }
      }
      for (bool3 = true;; bool3 = false)
      {
        localmfl2.b(bool3);
        localmfl2.a(bool2);
        localmfl2.c(bool1);
        if (localmfl1 == null) {
          break;
        }
        localmfl1.c(false);
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
    label762:
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
        lor.a();
        if (!this.jdField_h_of_type_Boolean) {
          break label693;
        }
        lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
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
        if (this.jdField_a_of_type_Lzc == null) {
          this.jdField_a_of_type_Lzc = new lzc(this, 2);
        }
        if (this.jdField_b_of_type_Lzc == null) {
          this.jdField_b_of_type_Lzc = new lzc(this, 1);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_Lzc);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_Lzc);
        if (lbk.a()) {
          break label762;
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
        if (lbn.a().a.jdField_a_of_type_Boolean)
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
      if (this.jdField_a_of_type_Lzc != null) {
        this.jdField_a_of_type_Lzc.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void e(long paramLong)
  {
    if (this.jdField_a_of_type_Mig != null) {
      this.jdField_a_of_type_Mig.a();
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
    y(paramLong);
    paramView = new lry(paramView);
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
    if ("android.permission.CAMERA".equals(paramString)) {
      str = localAVActivity.getString(2131630257);
    }
    for (paramString = localAVActivity.getString(2131630258);; paramString = localAVActivity.getString(2131630266))
    {
      a(paramLong, str, paramString);
      return;
      if (!"android.permission.RECORD_AUDIO".equals(paramString)) {
        break;
      }
      str = localAVActivity.getString(2131630265);
    }
  }
  
  void e(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Lpt != null) {
      this.jdField_a_of_type_Lpt.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
  }
  
  public void f(int paramInt) {}
  
  public void f(long paramLong, int paramInt)
  {
    if (g()) {}
    do
    {
      return;
      jdField_o_of_type_Boolean = AudioHelper.e();
      if ((paramInt & 0x1) == 1) {
        A(paramLong);
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
        E(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        B(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        b(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        F(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        z(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        C(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        D(paramLong);
      }
      g(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
    } while (!jdField_o_of_type_Boolean);
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn, sessionInfo[" + localkvq + "], screenStyle[" + localkvq.K + "], remoteHasVideo[" + localkvq.jdField_k_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
  }
  
  void f(long paramLong, View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_ScreenShot, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new lyo(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(l1);
    }
    mgb.a();
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
    mga.f();
    paramView = new lrw(paramView, 1);
    paramView.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Voice, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131629970);
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
    if ((localAVActivity != null) && (localAVActivity.jdField_a_of_type_Mbo != null)) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i1 = 2;; i1 = 0)
    {
      localAVActivity.jdField_a_of_type_Mbo.c(i1);
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
    paramView = new lrw(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Effect, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131629970);
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
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131298509);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!mjg.jdField_a_of_type_Boolean);
    if (TextUtils.isEmpty(paramString))
    {
      mjg.a(localTextView, "");
      return;
    }
    mjg.a(localTextView, mjg.a(paramString));
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
      if (this.jdField_a_of_type_Lyy != null) {
        this.jdField_a_of_type_Lyy.removeMessages(paramInt);
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
    if ((2131629972 != paramInt) && (2131629970 != paramInt)) {
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
          return bahj.a(localContext);
        }
      }
      return bahj.a(localContext);
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306517, this.jdField_a_of_type_AndroidContentResResources.getString(2131627325));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306517, true);
  }
  
  public void k(long paramLong)
  {
    this.jdField_k_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.f();
    }
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
      bool = mez.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306517, this.jdField_a_of_type_AndroidContentResResources.getString(2131627317));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131306517, false);
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
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306816);
    } while (localView == null);
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void q(boolean paramBoolean)
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
  
  public void w(long paramLong)
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
  
  public void x(long paramLong)
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
  
  public void y(long paramLong)
  {
    if (g()) {}
    for (;;)
    {
      return;
      boolean bool = QLog.isDevelopLevel();
      String str = "";
      kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
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
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "resetToolBarTimer, mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "], SessionType[" + localkvq.d + "], log[" + (String)localObject + "], seq[" + paramLong + "]");
        return;
        if ((localkvq.d == 2) || (localkvq.d == 4))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (this.jdField_h_of_type_Boolean) {
            if ((localkvq.d == 2) && (!localkvq.j()))
            {
              localObject = str;
              if (bool) {
                localObject = "not Connected";
              }
            }
            else if ((localkvq.d == 4) && (localkvq.q()))
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
                localObject = ajjy.a(2131650326);
              }
            }
          }
        }
        else if (localkvq.d != 1)
        {
          localObject = str;
          if (localkvq.d != 3) {}
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
  
  void z(long paramLong)
  {
    int i2 = 8;
    if (g()) {
      return;
    }
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    if (!lfi.a())
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
      if (!localkvq.j)
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "updateBtn_Beauty, !localHasVideo, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if (!kys.b())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */