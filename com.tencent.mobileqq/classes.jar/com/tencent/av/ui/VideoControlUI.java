package com.tencent.av.ui;

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
import anvx;
import bdla;
import bhdj;
import bhgy;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import lbd;
import lbz;
import lfe;
import lir;
import llq;
import lls;
import llv;
import lph;
import lsq;
import lzr;
import max;
import mbf;
import mcx;
import mcz;
import mdb;
import mdf;
import mjd;
import mjz;
import mka;
import mkb;
import mkc;
import mkd;
import mke;
import mkf;
import mkg;
import mkh;
import mki;
import mkj;
import mkk;
import mkl;
import mkm;
import mkn;
import mko;
import mkp;
import mnm;
import mqb;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqx;
import mrj;
import mrr;
import msa;
import msb;
import mty;
import mtz;
import muf;
import muk;
import muy;
import mvk;
import mxd;

public abstract class VideoControlUI
{
  public static boolean n;
  static boolean jdField_o_of_type_Boolean;
  static int x = -1;
  public final int A = 256;
  public final int B = 257;
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  public Resources a;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new mka(this);
  public GestureDetector a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mkj(this);
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
  max jdField_a_of_type_Max;
  private mdf jdField_a_of_type_Mdf;
  mjd jdField_a_of_type_Mjd;
  private mkk jdField_a_of_type_Mkk;
  private mkl jdField_a_of_type_Mkl;
  mkm jdField_a_of_type_Mkm;
  mko jdField_a_of_type_Mko;
  mkp jdField_a_of_type_Mkp = null;
  mty jdField_a_of_type_Mty = new mke(this);
  mtz jdField_a_of_type_Mtz = null;
  muf jdField_a_of_type_Muf = null;
  public muk a;
  muy jdField_a_of_type_Muy = null;
  private boolean jdField_a_of_type_Boolean;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public mcx b;
  mkp jdField_b_of_type_Mkp = null;
  private boolean jdField_b_of_type_Boolean = true;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  private boolean jdField_c_of_type_Boolean;
  public final long d;
  public RelativeLayout d;
  public final String d;
  public RelativeLayout e;
  public TextView e;
  String e;
  TextView f;
  public String f;
  public TextView g;
  public String g;
  boolean g;
  Runnable h;
  public String h;
  public boolean h;
  protected boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  int m;
  public boolean m;
  int n;
  int jdField_o_of_type_Int = 0;
  int p;
  public boolean p;
  public int q;
  int r = 0;
  int s = 0;
  public int t = 0;
  int u = 0;
  int v = 0;
  int w = 0;
  public int y;
  public int z = 0;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcx parammcx)
  {
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_e_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Muk = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangRunnable = new VideoControlUI.4(this);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable = new VideoControlUI.ToolbarAnimationRunnable(this);
    this.jdField_m_of_type_Boolean = true;
    this.jdField_h_of_type_JavaLangString = (Build.MANUFACTURER + "." + Build.MODEL);
    this.jdField_d_of_type_Long = 1500L;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "VideoControlUI");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Mko = new mko(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mko);
    this.jdField_a_of_type_Mkl = new mkl(this, Looper.getMainLooper());
    paramVideoAppInterface = a();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResResources = paramVideoAppInterface.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      lbd.g(this.jdField_d_of_type_JavaLangString, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131719926) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      lbd.g(this.jdField_d_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131719926) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_Mcx = parammcx;
    this.u = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297936);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131297938);
    this.v = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297939);
    this.w = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297954);
  }
  
  public static int a(lfe paramlfe, int paramInt)
  {
    int i2 = 2131695577;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = 2131695573;
    }
    for (;;)
    {
      if (paramlfe.jdField_j_of_type_Int == 1011)
      {
        if (paramInt != 9) {
          break;
        }
        i1 = 2131719928;
      }
      return i1;
      i1 = 2131719946;
      continue;
      i1 = i2;
      if (!paramlfe.s)
      {
        i1 = 2131695575;
        continue;
        i1 = 2131695451;
        continue;
        i1 = 2131695574;
        continue;
        i1 = 2131695572;
        continue;
        i1 = 2131695576;
        continue;
        i1 = 2131695573;
        continue;
        i1 = 2131695494;
      }
    }
    return 2131695177;
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
        if (l()) {
          break label272;
        }
        i1 = 1;
        int i2 = i1;
        if (i1 == 0)
        {
          localObject = ((AVActivity)localObject).findViewById(2131373475);
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
  
  private int b()
  {
    if ((!this.l) && (!this.jdField_h_of_type_Boolean)) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return e();
    }
    return f();
  }
  
  private boolean c()
  {
    return Build.MODEL.equalsIgnoreCase("Redmi Note 4");
  }
  
  private int e()
  {
    return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297617);
  }
  
  private void e(long paramLong, int paramInt)
  {
    if (h()) {}
    do
    {
      return;
      if ((!CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong)) && (!CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "enableCameraRelatedBtn, cameraAvailable[" + paramInt + "], already opening or opened");
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a().aa = paramInt;
    i(paramLong, 16777215);
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
  
  protected static boolean j()
  {
    if (x == -1)
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break label32;
      }
      x = 0;
    }
    for (;;)
    {
      if (x == 1)
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
            x = i1;
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
  
  public void A(long paramLong) {}
  
  public void B(long paramLong)
  {
    if (this.jdField_g_of_type_Boolean) {}
    while ((this.jdField_m_of_type_Int < 2) || (this.jdField_m_of_type_Int > 4) || ((VideoLayerUIBase.a(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (!b()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "startTimer, seq[" + paramLong + "]");
    }
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable == null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = new VideoControlUI.TimmerRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable, 0L);
    d(paramLong, null);
  }
  
  public void C(long paramLong)
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "stopTimer, seq[" + paramLong + "]");
    }
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    }
    h(null);
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPauseAudio");
    }
  }
  
  public void D(long paramLong)
  {
    if (h()) {}
    for (;;)
    {
      return;
      boolean bool1 = QLog.isDevelopLevel();
      String str = "";
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i1 = locallfe.d;
      boolean bool2 = locallfe.A();
      Object localObject = a();
      if (bool2)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 6000L);
        localObject = str;
        if (bool1) {
          localObject = anvx.a(2131715480);
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 4, "resetToolBarTimer, mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "], SessionType[" + i1 + "], watch[" + bool2 + "], log[" + (String)localObject + "], seq[" + paramLong + "]");
        return;
        if ((localObject != null) && (((AVActivity)localObject).b()))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (bool1) {
            localObject = "isKeepToolBar";
          }
        }
        else if ((i1 == 2) || (i1 == 4))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (this.jdField_h_of_type_Boolean) {
            if ((i1 == 2) && (!locallfe.l()))
            {
              localObject = str;
              if (bool1) {
                localObject = "not Connected";
              }
            }
            else if ((i1 == 4) && (locallfe.s()))
            {
              localObject = str;
              if (bool1) {
                localObject = "not Recv Data";
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 6000L);
              localObject = str;
              if (bool1) {
                localObject = anvx.a(2131715480);
              }
            }
          }
        }
        else if (i1 != 1)
        {
          localObject = str;
          if (i1 != 3) {}
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
  
  public void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onResumeAudio");
    }
  }
  
  public void E(long paramLong)
  {
    boolean bool3 = true;
    mrj localmrj = a(2131695092, paramLong);
    if (localmrj == null) {
      return;
    }
    boolean bool4 = lph.b();
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2;
    if ((mrr.a()) || (mxd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)))
    {
      bool1 = false;
      bool2 = false;
      label54:
      if (!locallfe.jdField_j_of_type_Boolean) {
        break label220;
      }
      if (!bool2)
      {
        label67:
        localmrj.b(bool3);
        localmrj.a(bool2);
        localmrj.c(bool1);
        label87:
        if (!QLog.isDevelopLevel()) {
          break label229;
        }
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_VirtualBackground, visible[" + bool1 + "], enable[" + bool2 + "], enableAE[" + bool4 + "], localHasVideo[" + locallfe.jdField_j_of_type_Boolean + "]");
      }
    }
    else if ((bool4) && (AEFilterSupport.a() > 3))
    {
      if (!CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramLong)) {
        break label231;
      }
    }
    label220:
    label229:
    label231:
    for (boolean bool1 = false;; bool1 = true)
    {
      bool2 = bool1;
      bool1 = true;
      break label54;
      bool1 = false;
      bool2 = false;
      break label54;
      bool3 = false;
      break label67;
      localmrj.c(false);
      bool1 = false;
      break label87;
      break;
    }
  }
  
  public void F()
  {
    if (this.jdField_a_of_type_Mkl != null)
    {
      this.jdField_a_of_type_Mkl.removeMessages(256);
      this.jdField_a_of_type_Mkl.removeMessages(257);
    }
  }
  
  void F(long paramLong)
  {
    int i2 = 8;
    if (h()) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    if (!lph.b())
    {
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !isEnableAEModuleManager, seq[" + paramLong + "]");
        i1 = i2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(i1);
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, show[" + i1 + "], seq[" + paramLong + "]");
      return;
      if (!locallfe.jdField_j_of_type_Boolean)
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !localHasVideo, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if (!lir.b())
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if (!AEFilterSupport.a(2))
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, AEKitSo not ready, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public void G()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
  }
  
  void G(long paramLong)
  {
    boolean bool = false;
    if (h()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2;
    if ((((lfe)localObject).d == 1) && (!((lfe)localObject).l()))
    {
      i2 = 8;
      i1 = i2;
      if (jdField_o_of_type_Boolean) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_More, !isConnected, seq[" + paramLong + "]");
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373767);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373767, i1);
      localObject = a();
      if ((i2 != i1) && (localObject != null))
      {
        if (i1 == 0) {
          bool = true;
        }
        ((AVActivity)localObject).a(bool);
        ((AVActivity)localObject).a(paramLong, 2131373767, i2, i1);
      }
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_More, show[" + i1 + "], lastvisibility[" + i2 + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  void H()
  {
    this.jdField_a_of_type_Mtz = new mtz();
    this.jdField_a_of_type_Mtz.a(100);
    this.jdField_a_of_type_Mtz.b(8);
    this.jdField_a_of_type_Mtz.a(new int[] { 2130842009, 2130842010 });
    this.jdField_a_of_type_Mtz.a(this.jdField_a_of_type_Mty);
  }
  
  void H(long paramLong)
  {
    if (h()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (this.q > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373771, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373771, 8);
  }
  
  public void I()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
  }
  
  void I(long paramLong)
  {
    if (h()) {}
    mrj localmrj;
    do
    {
      return;
      localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695091);
      if (localmrj != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_VideoMode, null, seq[" + paramLong + "]");
    return;
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = 2130842239;
    if (locallfe.N == 4) {
      i1 = 2130842238;
    }
    localmrj.a(i1);
    if ((!locallfe.jdField_j_of_type_Boolean) && (!locallfe.k)) {}
    for (boolean bool = false;; bool = true)
    {
      localmrj.c(bool);
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_VideoMode, bShow[" + bool + "], screenStyle[" + locallfe.N + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void J()
  {
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  protected void J(long paramLong)
  {
    mrj localmrj = a(2131695090, paramLong);
    if (localmrj == null) {
      return;
    }
    if (!mxd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      localmrj.c(bool);
      return;
    }
  }
  
  public void K()
  {
    mbf.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  protected void K(long paramLong)
  {
    mrj localmrj = a(2131695081, paramLong);
    if (localmrj == null) {}
    boolean bool;
    do
    {
      return;
      bool = true;
      if (lbz.a().a().A()) {
        bool = false;
      }
      localmrj.c(bool);
    } while (!QLog.isDevelopLevel());
    QLog.i(this.jdField_d_of_type_JavaLangString, 4, "updateBtn_ChatRoom, visible[" + bool + "]");
  }
  
  public void L()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("displayToolBar, isToolBarDisplay[").append(i()).append("], mApp[");
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
    if (!i())
    {
      o(false);
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  void L(long paramLong)
  {
    boolean bool2 = false;
    if (h()) {}
    boolean bool3;
    int i1;
    boolean bool4;
    do
    {
      mrj localmrj;
      do
      {
        return;
        localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695088);
        if (localmrj != null) {
          break;
        }
      } while (!jdField_o_of_type_Boolean);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShot, null, seq[" + paramLong + "]");
      return;
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      bool3 = locallfe.A();
      int i2 = 8;
      i1 = i2;
      if (!locallfe.x)
      {
        i1 = i2;
        if (!bool3) {
          if (locallfe.d != 4)
          {
            i1 = i2;
            if (locallfe.d != 2) {}
          }
          else
          {
            i1 = 0;
          }
        }
      }
      bool4 = c();
      boolean bool1 = bool2;
      if (!bool4)
      {
        bool1 = bool2;
        if (i1 == 0) {
          bool1 = true;
        }
      }
      localmrj.c(bool1);
    } while (!jdField_o_of_type_Boolean);
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShot, visible[" + i1 + "], seq[" + paramLong + "], watch[" + bool3 + "], isBlackMachine[" + bool4 + "]");
  }
  
  public void M()
  {
    if (h()) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373465, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373457, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373462, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373459, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373460, false);
  }
  
  void M(long paramLong)
  {
    if (h()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373457, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373457, true);
  }
  
  public void N()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.h();
    }
  }
  
  void N(long paramLong)
  {
    boolean bool3 = false;
    if (h()) {}
    mrj localmrj;
    do
    {
      return;
      localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695082);
      if (localmrj != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ControlMember, null, seq[" + paramLong + "]");
    return;
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((locallfe.d == 1) || (locallfe.d == 2))
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
        localmrj.b(bool2);
        localmrj.a(bool1);
        bool2 = bool3;
        if (i1 == 0) {
          bool2 = true;
        }
        localmrj.c(bool2);
        if (!jdField_o_of_type_Boolean) {
          break;
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ControlMember, enable[" + bool1 + "], visible[" + i1 + "], seq[" + paramLong + "]");
        return;
        if ((locallfe.d != 3) && (locallfe.d != 4)) {
          break label288;
        }
        if ((!locallfe.ac) && (!locallfe.ad))
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (locallfe.w())
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
  
  public void O() {}
  
  public void P()
  {
    a(i(), true);
  }
  
  void Q()
  {
    if (this.jdField_n_of_type_Int - this.jdField_p_of_type_Int > 2)
    {
      this.jdField_p_of_type_Int = this.jdField_n_of_type_Int;
      this.jdField_o_of_type_Int = 0;
    }
    this.jdField_o_of_type_Int += 1;
    if (this.jdField_o_of_type_Int > 5)
    {
      this.jdField_o_of_type_Int = 0;
      this.jdField_p_of_type_Int = 0;
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
    while (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null) {
      return 0;
    }
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299186);
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373760) == null) || (!this.jdField_h_of_type_Boolean))
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "getTopToolbarHeight, topToolbarHeight[" + i1 + "], margin[" + i2 + "], mInToolBarAnimation[" + this.l + "], mToolbarDisplayFrameNow[" + this.y + "], seq[" + paramLong + "]");
      return i1;
    }
    if (this.l) {
      i1 = i2 / 5;
    }
    for (i1 = Math.max(this.y, 0) * i1;; i1 = i2)
    {
      i1 += d();
      break;
    }
  }
  
  public long a()
  {
    return 0L;
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
  
  public mrj a(int paramInt, long paramLong)
  {
    Object localObject;
    if (h()) {
      localObject = null;
    }
    mrj localmrj;
    do
    {
      return localObject;
      if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
      {
        if (jdField_o_of_type_Boolean) {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "getOperationBtnItem, context is null, seq[" + paramLong + "], menuItemId[" + paramInt + "]");
        }
        return null;
      }
      localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramInt);
      localObject = localmrj;
    } while (localmrj != null);
    if (jdField_o_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "getOperationBtnItem, null, seq[" + paramLong + "], menuItemId[" + paramInt + "]");
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
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
        this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt1, paramInt2).b(paramInt3);
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
        this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).a();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "showToast-->can not show toast-->e=" + localException.getMessage());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).b(paramInt4);
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
      if (this.jdField_a_of_type_Mkl != null)
      {
        this.jdField_a_of_type_Mkl.removeMessages(paramInt);
        paramString = this.jdField_a_of_type_Mkl.obtainMessage(paramInt, paramString);
        this.jdField_a_of_type_Mkl.sendMessageDelayed(paramString, 1500L);
      }
      return;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_m_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d();
    }
    this.k = false;
  }
  
  public void a(long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Max != null) {
      this.jdField_a_of_type_Max.a(paramLong, paramFloat);
    }
    if (this.jdField_a_of_type_Mdf != null) {
      this.jdField_a_of_type_Mdf.a(paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], sessionInfo[" + locallfe + "], seq[" + paramLong + "]");
    }
    if (locallfe.o()) {
      j(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Muk != null) {
        this.jdField_a_of_type_Muk.a(false);
      }
      if ((!lzr.f()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373465, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373457, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373462, false);
      return;
      if ((paramInt == 25) || (paramInt == 56)) {
        j(paramInt);
      }
      l();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
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
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog, no isResume, seq[" + paramLong + "]");
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
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog, issueType[" + paramInt + "], showNormalDialog[" + paramBoolean + "], checkCameraResult[" + bool1 + "], checkRecordResult[" + bool2 + "], seq[" + paramLong + "]");
          if ((bool1) || (bool2) || (paramInt != 2)) {
            break label216;
          }
          localAVActivity.requestPermissions(this, 0, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
          this.k = true;
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
            this.k = true;
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
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "doUpdateAudioVolumeChange nexValue:=" + i1);
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
    if (h()) {
      return;
    }
    AVActivity localAVActivity = a();
    paramString1 = bhdj.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690697, new mkg(this, paramLong));
    if (mvk.a(localAVActivity)) {}
    for (int i1 = 2131695404;; i1 = 2131695405)
    {
      paramString1.setPositiveButton(i1, new mkf(this, paramLong)).show();
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
          paramView = new mkc(this, paramString, paramLong, paramView);
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.jdField_p_of_type_Boolean + "], seq[" + paramLong + "]");
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
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
        e(paramLong, paramString);
        return false;
      }
      return true;
      label269:
      i2 = i1;
    }
  }
  
  void a_(long paramLong, int paramInt)
  {
    if (paramInt > 0)
    {
      d(paramLong, this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
      return;
    }
    d(paramLong, null);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    AVActivity localAVActivity;
    do
    {
      return;
      a(a());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373759));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373760));
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373668));
      this.jdField_a_of_type_Mkm = new mkm(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_Mkm);
      this.jdField_a_of_type_Mjd = new mjz(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mjd);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mkd(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370007));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370006));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localAVActivity = a();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
    return;
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)localAVActivity.findViewById(2131373724));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373660) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373661) != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
    }
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365544));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373766));
    this.jdField_a_of_type_Muy = muy.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Muy);
    if (this.jdField_a_of_type_Muk != null) {
      this.jdField_a_of_type_Muk.a(false);
    }
    this.jdField_a_of_type_Muk = muk.a(this.jdField_a_of_type_Muk, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Muy);
    this.jdField_a_of_type_Muk.a(true);
    this.jdField_a_of_type_Muy.a();
    ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131373435);
    this.jdField_a_of_type_Max = new max();
    this.jdField_a_of_type_Max.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localViewGroup);
    this.jdField_a_of_type_Mdf = new mdf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_Mdf.a(localViewGroup);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131373763).setBackgroundColor(2145838842);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131373764).setBackgroundColor(2145838842);
    }
    new mkn(this.jdField_a_of_type_AndroidViewViewGroup).a(localAVActivity);
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373457, paramBoolean);
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373465, paramBoolean);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.jdField_m_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lfe locallfe;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
      }
      if (this.jdField_a_of_type_Max != null) {
        this.jdField_a_of_type_Max.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      if (this.jdField_a_of_type_Mdf != null) {
        this.jdField_a_of_type_Mdf.c();
      }
      locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallfe.l()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      }
    } while ((!locallfe.h()) || (locallfe.e) || (locallfe.l()) || (!locallfe.t()) || ((NetworkUtil.isWifiConnected(null)) && (AudioHelper.a(0) != 1)));
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
  }
  
  public void b(long paramLong, int paramInt) {}
  
  protected void b(long paramLong, View paramView) {}
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog, msg[" + paramString1 + "], title[" + paramString2 + "], seq[" + paramLong + "]");
    AVActivity localAVActivity = a();
    paramString1 = bhdj.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690697, new mki(this, paramLong));
    if (mvk.a(localAVActivity)) {}
    for (int i1 = 2131695404;; i1 = 2131695405)
    {
      paramString1 = paramString1.setPositiveButton(i1, new mkh(this, paramLong));
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
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog, crash", paramString1);
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
    if (h()) {}
    mrj localmrj;
    do
    {
      return false;
      localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695084);
      if (localmrj != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, null, seq[" + paramLong + "]");
    return false;
    int i1;
    boolean bool1;
    if (mxd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      i1 = 8;
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool2 = true;
        label95:
        localmrj.b(bool2);
        if (i1 != 0) {
          break label353;
        }
      }
      label353:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        localmrj.c(bool2);
        return bool1;
        lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (locallfe.jdField_j_of_type_Int == 1044)
        {
          i1 = 8;
          bool1 = false;
          break;
        }
        if ((locallfe.d == 3) || (locallfe.d == 4))
        {
          if (locallfe.w())
          {
            if (!jdField_o_of_type_Boolean) {
              break label375;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, isHrConf, seq[" + paramLong + "]");
            i1 = 8;
            bool1 = false;
            break;
          }
          if (((this instanceof MultiVideoCtrlLayerUIBase)) && (((MultiVideoCtrlLayerUIBase)this).c()))
          {
            if (!jdField_o_of_type_Boolean) {
              break label367;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, isFull, seq[" + paramLong + "]");
            i1 = 0;
            bool1 = false;
            break;
          }
        }
        if (!k()) {
          break label359;
        }
        if (jdField_o_of_type_Boolean) {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, isKeyguardLock, seq[" + paramLong + "]");
        }
        i1 = 0;
        bool1 = false;
        break;
        bool2 = false;
        break label95;
      }
      label359:
      i1 = 0;
      bool1 = true;
      continue;
      label367:
      i1 = 0;
      bool1 = false;
      continue;
      label375:
      i1 = 8;
      bool1 = false;
    }
  }
  
  public int c()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return i2;
    }
    int i1 = b();
    i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168);
    if (this.l)
    {
      i2 = i1 / 5;
      i2 = Math.max(this.y, 0) * i2;
      if (i2 <= i1) {}
    }
    for (;;)
    {
      i2 = i1;
      if (!j()) {
        break;
      }
      return i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297916);
      i1 = i2;
      if (i2 <= 0)
      {
        i1 = e();
        continue;
        if (this.jdField_h_of_type_Boolean) {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (mvk.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320)) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297612) + i2;
          } else {}
        }
      }
    }
  }
  
  public abstract void c(int paramInt);
  
  public void c(long paramLong)
  {
    this.jdField_m_of_type_Int = 5;
    C(paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.g();
    }
    if (this.jdField_a_of_type_Muk != null) {
      this.jdField_a_of_type_Muk.b(false);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission, issueType[" + this.z + "->" + paramInt + "], isRequestCameraPermission[" + this.k + "], seq[" + paramLong + "]");
    }
    this.z = paramInt;
    this.jdField_f_of_type_JavaLangString = "";
    AVActivity localAVActivity = a();
    String str2;
    String str1;
    if (paramInt == 1)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求相机权限.2");
      str2 = localAVActivity.getString(2131695392);
      str1 = localAVActivity.getString(2131695393);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
      {
        this.jdField_f_of_type_JavaLangString = "0X8004892";
        this.jdField_g_of_type_JavaLangString = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1)
        {
          this.jdField_f_of_type_JavaLangString = "0X8004898";
          this.jdField_g_of_type_JavaLangString = "0X8004899";
        }
      }
    }
    do
    {
      for (;;)
      {
        this.jdField_m_of_type_Boolean = true;
        bdla.b(null, "CliOper", "", "", this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
        if (!a(localAVActivity)) {
          break label753;
        }
        if ((paramInt != 2) || (!this.k)) {
          break;
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
        {
          this.jdField_f_of_type_JavaLangString = "0X800488C";
          this.jdField_g_of_type_JavaLangString = "0X800488D";
        }
      }
      if (paramInt == 2)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求相机权限.3");
        str2 = localAVActivity.getString(2131695392);
        str1 = localAVActivity.getString(2131695393);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
        {
          this.jdField_f_of_type_JavaLangString = "0X80049D3";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1) {
            this.jdField_f_of_type_JavaLangString = "0X80049D4";
          }
        }
        for (;;)
        {
          this.jdField_m_of_type_Boolean = false;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().f == 1) {
            this.jdField_f_of_type_JavaLangString = "0X80049D1";
          } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
            this.jdField_f_of_type_JavaLangString = "0X80049D2";
          }
        }
      }
      if (paramInt == 3)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求麦克风权限.1");
        str2 = localAVActivity.getString(2131695402);
        str1 = localAVActivity.getString(2131695403);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
        {
          this.jdField_f_of_type_JavaLangString = "0X800488F";
          this.jdField_g_of_type_JavaLangString = "0X8004890";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004895";
            this.jdField_g_of_type_JavaLangString = "0X8004896";
          }
        }
        for (;;)
        {
          this.jdField_m_of_type_Boolean = true;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004889";
            this.jdField_g_of_type_JavaLangString = "0X800488A";
          }
          else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004885";
            this.jdField_g_of_type_JavaLangString = "0X8004886";
          }
        }
      }
      if ((paramInt == 4) && (localAVActivity != null))
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
          mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3004);
        }
        str1 = "";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
        {
          str1 = "0X8004891";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1) {
            str1 = "0X8004897";
          }
        }
        for (;;)
        {
          bdla.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
            str1 = "0X800488B";
          } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
            str1 = "0X8004887";
          }
        }
      }
    } while (paramInt != 2048);
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean = true;
    return;
    a(paramLong, paramInt, str2, str1, true);
    return;
    label753:
    b(paramLong, str2, str1);
  }
  
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
      i1 = mvk.b(localAVActivity);
      i2 = mvk.a(localAVActivity);
      f1 = mvk.a(localAVActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + c() + "], topBarHeight[" + a(paramLong) + "], density[" + f1 + "], screenSize[" + i2 + ", " + i1 + "], hasSmartBar[" + j() + "]");
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 11)
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1015);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 16)
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1061);
      return;
    }
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  boolean c(long paramLong)
  {
    if (h()) {}
    mrj localmrj;
    do
    {
      return false;
      localmrj = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695080);
      if (localmrj != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, null, seq[" + paramLong + "]");
    return false;
    boolean bool1;
    if (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      if (!jdField_o_of_type_Boolean) {
        break label688;
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, GLVersion, seq[" + paramLong + "]");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        localmrj.b(bool2);
        if (jdField_o_of_type_Boolean) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, enable[" + bool1 + "], seq[" + paramLong + "]");
        }
        return bool1;
        lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (locallfe.jdField_j_of_type_Int == 1044)
        {
          localmrj.c(false);
          bool1 = false;
          break;
        }
        if ((locallfe.d == 1) || (locallfe.d == 2))
        {
          if ((locallfe.h()) || (locallfe.o()) || (locallfe.p()))
          {
            if (!jdField_o_of_type_Boolean) {
              break label688;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, state[" + locallfe.g + "], seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.f()) {
            break label511;
          }
          if (!jdField_o_of_type_Boolean) {
            break label688;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, !canAVShift, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if ((locallfe.d == 3) || (locallfe.d == 4))
        {
          if (locallfe.J)
          {
            if (locallfe.K) {
              break label511;
            }
            if (!jdField_o_of_type_Boolean) {
              break label688;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, not enter room for meeting, seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
          if (!this.jdField_a_of_type_ComTencentAvVideoController.e)
          {
            if (!jdField_o_of_type_Boolean) {
              break label688;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, 没有进入房间, seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
        }
        label511:
        if (!locallfe.jdField_o_of_type_Boolean)
        {
          if (!jdField_o_of_type_Boolean) {
            break label688;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, cameraPermission, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (locallfe.aa == 0)
        {
          if (!jdField_o_of_type_Boolean) {
            break label688;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, mCameraAvailable, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (!CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramLong)) {
          break label693;
        }
        if (!jdField_o_of_type_Boolean) {
          break label688;
        }
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, isCameraOpening, seq[" + paramLong + "]");
        bool1 = false;
        break;
      }
      label688:
      bool1 = false;
      continue;
      label693:
      bool1 = true;
    }
  }
  
  public int d()
  {
    if ((new mkn(this.jdField_a_of_type_AndroidViewViewGroup).a()) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return 0;
  }
  
  public void d()
  {
    this.jdField_m_of_type_Int = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Mkk == null))
    {
      this.jdField_a_of_type_Mkk = new mkk(this);
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "register camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Mkk, localIntentFilter);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      IntentFilter localIntentFilter;
      return;
    }
    QLog.d(this.jdField_d_of_type_JavaLangString, 2, "CANNOT register camera availability change receiver!");
  }
  
  public abstract void d(int paramInt);
  
  public void d(long paramLong)
  {
    this.jdField_m_of_type_Int = 6;
    if (this.jdField_a_of_type_Max != null)
    {
      this.jdField_a_of_type_Max.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Max = null;
    }
    if (this.jdField_a_of_type_Mdf != null)
    {
      this.jdField_a_of_type_Mdf.e();
      this.jdField_a_of_type_Mdf = null;
    }
    if (this.jdField_a_of_type_Mkl != null)
    {
      this.jdField_a_of_type_Mkl.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Mkl = null;
    }
    C(paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      if (this.jdField_a_of_type_Mko != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mko);
        this.jdField_a_of_type_Mko = null;
      }
    }
    if (this.jdField_a_of_type_Muk != null) {
      this.jdField_a_of_type_Muk.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Mkk != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label394;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Mkk);
      this.jdField_a_of_type_Mkk = null;
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
      this.jdField_a_of_type_Mtz = null;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_Mkp = null;
      this.jdField_b_of_type_Mkp = null;
      this.jdField_c_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
      this.jdField_b_of_type_Mcx = null;
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_f_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_Muf = null;
      this.jdField_a_of_type_Mty = null;
      this.jdField_a_of_type_Muk = null;
      this.jdField_a_of_type_Muy = null;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c();
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
      }
      return;
      label394:
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
  }
  
  public abstract void d(long paramLong, View paramView);
  
  void d(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setConnectInfo, str[" + paramString + "], seq[" + paramLong + "]");
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
      mvk.a(this.jdField_e_of_type_AndroidWidgetTextView, paramString);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramString);
    }
  }
  
  public boolean d(long paramLong)
  {
    boolean bool3 = false;
    if (h()) {}
    mrj localmrj1;
    mrj localmrj2;
    lfe locallfe;
    do
    {
      do
      {
        return false;
        localmrj1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695083);
        localmrj2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695093);
      } while ((localmrj1 == null) && (localmrj2 == null));
      locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!locallfe.A()) {
        break;
      }
      if (localmrj1 != null) {
        localmrj1.c(false);
      }
    } while (localmrj2 == null);
    localmrj2.c(false);
    return false;
    boolean bool4 = lph.b();
    boolean bool1;
    if (bool4)
    {
      if (!CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramLong)) {
        break label317;
      }
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2;
      if (locallfe.jdField_j_of_type_Boolean) {
        if (localmrj1 != null)
        {
          if (!bool1)
          {
            bool2 = true;
            label139:
            localmrj1.b(bool2);
            localmrj1.a(bool1);
            localmrj1.c(bool4);
          }
        }
        else if (localmrj2 != null)
        {
          bool2 = bool3;
          if (!bool4) {
            bool2 = true;
          }
          localmrj2.c(bool2);
        }
      }
      for (;;)
      {
        if (localmrj2 != null) {
          localmrj2.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().v);
        }
        if (jdField_o_of_type_Boolean) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_EffectAndVoice, enable[" + bool1 + "], enableAE[" + bool4 + "], seq[" + paramLong + "]");
        }
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label139;
        if (localmrj2 != null)
        {
          localmrj2.b(false);
          localmrj2.a(true);
          localmrj2.c(true);
        }
        if (localmrj1 != null) {
          localmrj1.c(false);
        }
      }
      label317:
      bool1 = true;
    }
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog deniedForAudioRecord(2) 04");
  }
  
  @QQPermissionDenied(1)
  public void deniedForCamera()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog deniedForCamera(1) 02");
  }
  
  @QQPermissionDenied(0)
  public void deniedForCameraAudio()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog deniedForCameraAudio(1) 00");
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.isPressed())) {}
    label149:
    label540:
    label545:
    label704:
    do
    {
      lfe locallfe;
      boolean bool1;
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
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mVideoController is null, Why???");
            return;
            locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
          } while (((locallfe.jdField_j_of_type_Int == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean)) || (this.jdField_j_of_type_Boolean) || ((!locallfe.l()) && (locallfe.d == 2)));
          bool2 = this.jdField_h_of_type_Boolean;
          if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mRootView is null Why");
        return;
        if (!locallfe.A()) {
          break label545;
        }
        if (this.jdField_h_of_type_Boolean) {
          break label540;
        }
        bool1 = true;
        o(bool1);
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "switchToolBar, ToolbarDisplay[" + bool2 + "->" + this.jdField_h_of_type_Boolean + "], type[" + paramInt + "]");
        lzr.a();
        if (!this.jdField_h_of_type_Boolean) {
          break label704;
        }
        mbf.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar mQavPanel.isShown()[" + this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown() + "], mTopToolbar.isShown()[" + this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown() + "]");
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown()));
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.s += 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar type=" + paramInt + ", toolbarShowTimes: " + this.s);
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = a(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = a(true);
      }
      for (;;)
      {
        if ((this instanceof MultiVideoCtrlLayerUIBase)) {
          ((MultiVideoCtrlLayerUIBase)this).s();
        }
        if (this.jdField_a_of_type_Mkp == null) {
          this.jdField_a_of_type_Mkp = new mkp(this, 2);
        }
        if (this.jdField_b_of_type_Mkp == null) {
          this.jdField_b_of_type_Mkp = new mkp(this, 1);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_Mkp);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_Mkp);
        if (llq.a()) {
          break label793;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        bool1 = false;
        break;
        if ((!locallfe.jdField_j_of_type_Boolean) && (!locallfe.k) && (!locallfe.J))
        {
          o(true);
          break label149;
        }
        if (locallfe.d == 1)
        {
          o(true);
          break label149;
        }
        if ((locallfe.d == 3) && (!locallfe.J))
        {
          o(true);
          break label149;
        }
        if (lls.a().a.jdField_a_of_type_Boolean)
        {
          o(true);
          break label149;
        }
        if (!this.jdField_h_of_type_Boolean) {}
        for (bool1 = true;; bool1 = false)
        {
          o(bool1);
          break;
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772138);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772175);
        continue;
        ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373556)).setVisibility(4);
        if (paramInt == 1)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = a(false);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = a(false);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772137);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772174);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_a_of_type_Mkp != null) {
        this.jdField_a_of_type_Mkp.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    label793:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void e(long paramLong)
  {
    if (this.jdField_a_of_type_Muk != null) {
      this.jdField_a_of_type_Muk.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 4, "onConnected");
    }
  }
  
  public abstract void e(long paramLong, View paramView);
  
  public void e(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAVActivity.getString(2131695392);
      paramString = localAVActivity.getString(2131695393);
    }
    for (;;)
    {
      a(paramLong, str, paramString);
      return;
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        str = localAVActivity.getString(2131695402);
        paramString = localAVActivity.getString(2131695403);
      }
      else
      {
        if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
          break;
        }
        str = localAVActivity.getString(2131695400);
        paramString = localAVActivity.getString(2131695401);
      }
    }
  }
  
  void e(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Max != null) {
      this.jdField_a_of_type_Max.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_Mdf != null) {
      this.jdField_a_of_type_Mdf.d();
    }
  }
  
  public void f(int paramInt) {}
  
  public void f(long paramLong)
  {
    mrj localmrj = a(2131695094, paramLong);
    if (localmrj != null) {
      localmrj.c(false);
    }
  }
  
  @TargetApi(21)
  public void f(long paramLong, View paramView)
  {
    if (!lbz.a().a().z())
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
      }
      ScreenShareCtrl.a(7);
      return;
    }
    l(paramLong, 2131695086);
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramView != null) {
      paramView.a(a(), paramLong);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.post(new VideoControlUI.11(this));
  }
  
  public void f(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Muy.c();
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
      this.jdField_a_of_type_Muy.a(paramLong, this.jdField_e_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.jdField_e_of_type_JavaLangString + "], deviceName[" + str + "], seq[" + paramLong + "]");
      }
      this.jdField_a_of_type_Muy.a(paramLong, str);
      return;
    }
    this.jdField_a_of_type_Muy.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void f(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  public void g() {}
  
  public void g(int paramInt) {}
  
  public void g(long paramLong) {}
  
  public void g(long paramLong, View paramView)
  {
    if (h()) {
      return;
    }
    D(paramLong);
    paramView = new mdb(paramView);
    paramView.a(paramLong, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9005), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_More, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq" + paramLong + "]");
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
  
  public void g(String paramString)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "hideToolBar[" + paramString + "], isToolBarDisplay[" + i() + "], mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "]");
    if (this.jdField_h_of_type_Boolean) {
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  public void g(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity != null) && (localAVActivity.jdField_a_of_type_Mnm != null)) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i1 = 2;; i1 = 0)
    {
      localAVActivity.jdField_a_of_type_Mnm.c(i1);
      return;
    }
  }
  
  public boolean g()
  {
    return true;
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog grantForAudioRecord(2) 03");
  }
  
  @QQPermissionGrant(1)
  public void grantForCamera()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog grantForCamera(1) 01");
  }
  
  @QQPermissionGrant(0)
  public void grantForCameraAudio()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog grantForCameraAudio(1) 0");
  }
  
  public void h() {}
  
  protected void h(long paramLong) {}
  
  void h(long paramLong, View paramView)
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_ScreenShot, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mkb(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(l1);
    }
    msb.a();
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
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setChatTime, time[" + paramString + "]");
        }
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364480);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!mvk.jdField_a_of_type_Boolean);
    if (TextUtils.isEmpty(paramString))
    {
      mvk.a(localTextView, "");
      return;
    }
    mvk.a(localTextView, mvk.a(paramString));
  }
  
  void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
  }
  
  public boolean h()
  {
    return this.jdField_m_of_type_Int == 6;
  }
  
  public void i() {}
  
  public void i(int paramInt)
  {
    if (paramInt == 1037) {}
    for (paramInt = 256;; paramInt = 257)
    {
      if (this.jdField_a_of_type_Mkl != null) {
        this.jdField_a_of_type_Mkl.removeMessages(paramInt);
      }
      return;
    }
  }
  
  protected void i(long paramLong) {}
  
  public void i(long paramLong, int paramInt)
  {
    if (h()) {}
    do
    {
      return;
      jdField_o_of_type_Boolean = AudioHelper.f();
      if ((paramInt & 0x1) == 1) {
        G(paramLong);
      }
      if ((paramInt & 0x2) == 2) {
        c(paramLong);
      }
      if ((paramInt & 0x4) == 4) {
        i(paramLong);
      }
      if ((paramInt & 0x8) == 8) {
        d(paramLong);
      }
      if ((paramInt & 0x10) == 16) {
        M(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        H(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        b(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        N(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        F(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        I(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        L(paramLong);
      }
      if ((paramInt & 0x1000) == 4096) {
        l(paramLong);
      }
      if ((paramInt & 0x2000) == 8192) {
        E(paramLong);
      }
      if ((paramInt & 0x4000) == 16384) {
        f(paramLong);
      }
      if ((0x8000 & paramInt) == 32768) {
        J(paramLong);
      }
      if ((0x10000 & paramInt) == 65536) {
        K(paramLong);
      }
      h(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
    } while (!jdField_o_of_type_Boolean);
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn, sessionInfo[" + locallfe + "], screenStyle[" + locallfe.N + "], remoteHasVideo[" + locallfe.k + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
  }
  
  void i(long paramLong, View paramView)
  {
    msa.f();
    paramView = new mcz(paramView, 1);
    paramView.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Voice, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695083);
      return;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Voice, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, paramView.jdField_b_of_type_Int);
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
  
  public boolean i()
  {
    return (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel.getVisibility() == 0);
  }
  
  public void j() {}
  
  void j(int paramInt)
  {
    b(a(this.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt));
  }
  
  public abstract void j(long paramLong);
  
  void j(long paramLong, int paramInt)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_MiddleCenter, visibility[" + this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void j(long paramLong, View paramView)
  {
    paramView = new mcz(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Effect, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695083);
      return;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Effect, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, paramView.jdField_b_of_type_Int);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(paramBoolean);
    }
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, this.jdField_a_of_type_AndroidContentResResources.getString(2131692731));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, true);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
  }
  
  public abstract void k(long paramLong);
  
  void k(long paramLong, int paramInt)
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  public void k(long paramLong, View paramView)
  {
    paramView = new mcz(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_VirtualBackground, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695092);
      mrr.a("0X800ADA9", 0, 0, "", "", "", "");
      return;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_VirtualBackground, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 4, true);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.c(paramBoolean);
    }
  }
  
  @TargetApi(16)
  public boolean k()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
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
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "isKeyguardLocked() = " + localSecurityException);
          }
          return bhgy.a(localContext);
        }
      }
      return bhgy.a(localContext);
    }
    return true;
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, this.jdField_a_of_type_AndroidContentResResources.getString(2131692723));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
  }
  
  public void l(long paramLong)
  {
    if ((QLog.isColorLevel()) && (paramLong == -1052L)) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_ScreenShare");
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    mrj localmrj = a(2131695086, paramLong);
    if ((localmrj == null) || (localContext == null)) {
      return;
    }
    if ((Build.VERSION.SDK_INT < 21) || (mxd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))) {
      localmrj.c(false);
    }
    lfe locallfe;
    for (;;)
    {
      locallfe = lbz.a().a();
      if (locallfe.jdField_j_of_type_Int != 1044) {
        break;
      }
      localmrj.c(false);
      localmrj.a(false);
      return;
      localmrj.c(true);
    }
    if ((locallfe.ae == 2) || (locallfe.ae == 1))
    {
      localmrj.a(2130842049);
      localmrj.a(localContext.getResources().getString(2131695087));
      return;
    }
    localmrj.a(2130842048);
    localmrj.a(localContext.getResources().getString(2131695086));
  }
  
  void l(long paramLong, int paramInt)
  {
    if ((2131695085 != paramInt) && (2131695083 != paramInt) && (2131695092 != paramInt)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, true);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(paramBoolean);
    }
  }
  
  protected boolean l()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    }
    return bool;
  }
  
  public void m() {}
  
  public void m(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(paramBoolean);
    }
  }
  
  public void n() {}
  
  public void n(long paramLong)
  {
    this.jdField_m_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.f();
    }
  }
  
  public void n(boolean paramBoolean)
  {
    a(i(), paramBoolean);
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
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373778);
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
      mbf.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, 3000L);
      return;
    }
  }
  
  public void r(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      AudioHelper.jdField_b_of_type_Boolean = paramBoolean;
      f(paramBoolean);
      return;
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void t() {}
  
  public void u() {}
  
  public void z(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */