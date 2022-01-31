package com.tencent.av.ui;

import alud;
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
import azqs;
import bdgm;
import bdin;
import bdjz;
import bdmh;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import lek;
import lfb;
import lid;
import llg;
import lnz;
import loc;
import lof;
import lsa;
import lux;
import mbt;
import mcv;
import mdd;
import meu;
import mew;
import mey;
import mfb;
import mlv;
import mlw;
import mlx;
import mly;
import mlz;
import mma;
import mmb;
import mmc;
import mmd;
import mme;
import mmf;
import mmg;
import mmh;
import mmi;
import mmj;
import mmk;
import mpe;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mrt;
import msp;
import mtb;
import mtq;
import mtr;
import mvo;
import mvp;
import mvr;
import mvw;
import mwk;
import mww;

public abstract class VideoControlUI
{
  public static boolean o;
  static boolean jdField_p_of_type_Boolean;
  static int v = -1;
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext = null;
  public Resources a;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new mme(this);
  public GestureDetector a;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mmd(this);
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
  mcv jdField_a_of_type_Mcv;
  private mfb jdField_a_of_type_Mfb;
  private mmf jdField_a_of_type_Mmf;
  private mmg jdField_a_of_type_Mmg;
  mmh jdField_a_of_type_Mmh;
  mmj jdField_a_of_type_Mmj;
  mmk jdField_a_of_type_Mmk = null;
  mvo jdField_a_of_type_Mvo = new mly(this);
  mvp jdField_a_of_type_Mvp = null;
  mvr jdField_a_of_type_Mvr = null;
  public mvw a;
  mwk jdField_a_of_type_Mwk = null;
  private boolean jdField_a_of_type_Boolean;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public meu b;
  mmk jdField_b_of_type_Mmk = null;
  private boolean jdField_b_of_type_Boolean = true;
  public RelativeLayout c;
  private boolean c;
  public final long d;
  public RelativeLayout d;
  public TextView d;
  public final String d;
  TextView jdField_e_of_type_AndroidWidgetTextView = null;
  String jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public TextView f;
  public String f;
  public String g;
  Runnable jdField_h_of_type_JavaLangRunnable = new VideoControlUI.3(this);
  public String h;
  boolean jdField_h_of_type_Boolean = false;
  public boolean i = true;
  protected boolean j;
  int k;
  public boolean k;
  int l;
  public boolean l;
  int m;
  public boolean m;
  int n;
  public boolean n;
  public int o;
  int jdField_p_of_type_Int = 0;
  int q;
  public boolean q;
  public int r = 0;
  int s = 0;
  int t = 0;
  int u = 0;
  public int w;
  public int x = 0;
  public final int y = 256;
  public final int z = 257;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, meu parammeu)
  {
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Mvw = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable = new VideoControlUI.ToolbarAnimationRunnable(this);
    this.jdField_n_of_type_Boolean = true;
    this.jdField_h_of_type_JavaLangString = (Build.MANUFACTURER + "." + Build.MODEL);
    this.jdField_d_of_type_Long = 1500L;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "VideoControlUI");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Mmj = new mmj(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mmj);
    this.jdField_a_of_type_Mmg = new mmg(this, Looper.getMainLooper());
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
      lek.d(this.jdField_d_of_type_JavaLangString, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131721302) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      lek.d(this.jdField_d_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131721302) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_Meu = parammeu;
    this.s = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297785);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131297787);
    this.t = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297788);
    this.u = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297803);
  }
  
  public static int a(lid paramlid, int paramInt)
  {
    int i2 = 2131696298;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = 2131696294;
    }
    for (;;)
    {
      if (paramlid.i == 1011)
      {
        if (paramInt != 9) {
          break;
        }
        i1 = 2131721304;
      }
      return i1;
      i1 = 2131721322;
      continue;
      i1 = i2;
      if (!paramlid.s)
      {
        i1 = 2131696296;
        continue;
        i1 = 2131696172;
        continue;
        i1 = 2131696295;
        continue;
        i1 = 2131696293;
        continue;
        i1 = 2131696297;
        continue;
        i1 = 2131696294;
        continue;
        i1 = 2131696215;
      }
    }
    return 2131695903;
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
          localObject = ((AVActivity)localObject).findViewById(2131372607);
          i2 = i1;
          if (localObject != null)
          {
            i2 = i1;
            if (((View)localObject).isShown()) {
              i2 = 1;
            }
          }
          if (jdField_o_of_type_Boolean) {
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
    if ((!this.jdField_m_of_type_Boolean) && (!this.i)) {}
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
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "enableCameraRelatedBtn, cameraAvailable[" + paramInt + "], already opening or opened");
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a().Z = paramInt;
    f(paramLong, 65535);
  }
  
  private int e()
  {
    return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297470);
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
  
  public void A(long paramLong)
  {
    if (this.jdField_h_of_type_Boolean) {}
    while ((this.jdField_k_of_type_Int < 2) || (this.jdField_k_of_type_Int > 4) || ((VideoLayerUIBase.a(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (!b()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "startTimer, seq[" + paramLong + "]");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable == null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = new VideoControlUI.TimmerRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable, 0L);
    d(paramLong, null);
  }
  
  public void B(long paramLong)
  {
    if (!this.jdField_h_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "stopTimer, seq[" + paramLong + "]");
    }
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    }
    h(null);
  }
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPauseAudio");
    }
  }
  
  public void C(long paramLong)
  {
    if (g()) {}
    for (;;)
    {
      return;
      boolean bool = QLog.isDevelopLevel();
      String str = "";
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
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
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "resetToolBarTimer, mToolbarDisplay[" + this.i + "], SessionType[" + locallid.d + "], log[" + (String)localObject + "], seq[" + paramLong + "]");
        return;
        if ((locallid.d == 2) || (locallid.d == 4))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (this.i) {
            if ((locallid.d == 2) && (!locallid.k()))
            {
              localObject = str;
              if (bool) {
                localObject = "not Connected";
              }
            }
            else if ((locallid.d == 4) && (locallid.r()))
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
                localObject = alud.a(2131716512);
              }
            }
          }
        }
        else if (locallid.d != 1)
        {
          localObject = str;
          if (locallid.d != 3) {}
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          localObject = str;
          if (!this.i)
          {
            e(0);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onResumeAudio");
    }
  }
  
  void D(long paramLong)
  {
    int i2 = 8;
    if (g()) {
      return;
    }
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    if (!lsa.a())
    {
      i1 = i2;
      if (jdField_p_of_type_Boolean)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !isEnableAEModuleManager, seq[" + paramLong + "]");
        i1 = i2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(i1);
      if (!jdField_p_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, show[" + i1 + "], seq[" + paramLong + "]");
      return;
      if (!locallid.j)
      {
        i1 = i2;
        if (jdField_p_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !localHasVideo, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if (!llg.b())
      {
        i1 = i2;
        if (jdField_p_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if ((AEFilterSupport.a()) && (!AEFilterSupport.a(2)))
      {
        i1 = i2;
        if (jdField_p_of_type_Boolean)
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
  
  public void E()
  {
    if (this.jdField_a_of_type_Mmg != null)
    {
      this.jdField_a_of_type_Mmg.removeMessages(256);
      this.jdField_a_of_type_Mmg.removeMessages(257);
    }
  }
  
  void E(long paramLong)
  {
    boolean bool = false;
    if (g()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2;
    if ((((lid)localObject).d == 1) && (!((lid)localObject).k()))
    {
      i2 = 8;
      i1 = i2;
      if (jdField_p_of_type_Boolean) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_More, !isConnected, seq[" + paramLong + "]");
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372899);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372899, i1);
      localObject = a();
      if ((i2 != i1) && (localObject != null))
      {
        if (i1 == 0) {
          bool = true;
        }
        ((AVActivity)localObject).a(bool);
        ((AVActivity)localObject).a(paramLong, 2131372899, i2, i1);
      }
      if (!jdField_p_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_More, show[" + i1 + "], lastvisibility[" + i2 + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void F()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setScreenDarken");
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (this.jdField_o_of_type_Int > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372903, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372903, 8);
  }
  
  void G()
  {
    this.jdField_a_of_type_Mvp = new mvp();
    this.jdField_a_of_type_Mvp.a(100);
    this.jdField_a_of_type_Mvp.b(8);
    this.jdField_a_of_type_Mvp.a(new int[] { 2130841639, 2130841640 });
    this.jdField_a_of_type_Mvp.a(this.jdField_a_of_type_Mvo);
  }
  
  void G(long paramLong)
  {
    if (g()) {}
    mtb localmtb;
    do
    {
      return;
      localmtb = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695820);
      if (localmtb != null) {
        break;
      }
    } while (!jdField_p_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_VideoMode, null, seq[" + paramLong + "]");
    return;
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = 2130841864;
    if (locallid.M == 4) {
      i1 = 2130841863;
    }
    localmtb.a(i1);
    if ((!locallid.j) && (!locallid.jdField_k_of_type_Boolean)) {}
    for (boolean bool = false;; bool = true)
    {
      localmtb.c(bool);
      if (!jdField_p_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_VideoMode, bShow[" + bool + "], screenStyle[" + locallid.M + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void H()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
  }
  
  void H(long paramLong)
  {
    boolean bool = false;
    if (g()) {}
    int i1;
    do
    {
      mtb localmtb;
      do
      {
        return;
        localmtb = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695817);
        if (localmtb != null) {
          break;
        }
      } while (!jdField_p_of_type_Boolean);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShot, null, seq[" + paramLong + "]");
      return;
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i2 = 8;
      i1 = i2;
      if (!locallid.x) {
        if (locallid.d != 4)
        {
          i1 = i2;
          if (locallid.d != 2) {}
        }
        else
        {
          i1 = 0;
        }
      }
      if (i1 == 0) {
        bool = true;
      }
      localmtb.c(bool);
    } while (!jdField_p_of_type_Boolean);
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShot, visible[" + i1 + "], seq[" + paramLong + "]");
  }
  
  public void I()
  {
    mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  void I(long paramLong)
  {
    if (g()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372589, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372589, true);
  }
  
  public void J()
  {
    mdd.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  void J(long paramLong)
  {
    boolean bool3 = false;
    if (g()) {}
    mtb localmtb;
    do
    {
      return;
      localmtb = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695811);
      if (localmtb != null) {
        break;
      }
    } while (!jdField_p_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ControlMember, null, seq[" + paramLong + "]");
    return;
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((locallid.d == 1) || (locallid.d == 2))
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
        localmtb.b(bool2);
        localmtb.a(bool1);
        bool2 = bool3;
        if (i1 == 0) {
          bool2 = true;
        }
        localmtb.c(bool2);
        if (!jdField_p_of_type_Boolean) {
          break;
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ControlMember, enable[" + bool1 + "], visible[" + i1 + "], seq[" + paramLong + "]");
        return;
        if ((locallid.d != 3) && (locallid.d != 4)) {
          break label288;
        }
        if ((!locallid.ab) && (!locallid.ac))
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (locallid.v())
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
  
  public void K()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372597, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372589, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372594, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372591, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372592, false);
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
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299013);
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372892) == null) || (!this.i))
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "getTopToolbarHeight, topToolbarHeight[" + i1 + "], margin[" + i2 + "], mInToolBarAnimation[" + this.jdField_m_of_type_Boolean + "], mToolbarDisplayFrameNow[" + this.w + "], seq[" + paramLong + "]");
      return i1;
    }
    if (this.jdField_m_of_type_Boolean) {
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
      if (this.jdField_a_of_type_Mmg != null)
      {
        this.jdField_a_of_type_Mmg.removeMessages(paramInt);
        paramString = this.jdField_a_of_type_Mmg.obtainMessage(paramInt, paramString);
        this.jdField_a_of_type_Mmg.sendMessageDelayed(paramString, 1500L);
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
    this.jdField_l_of_type_Boolean = false;
  }
  
  public void a(long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Mcv != null) {
      this.jdField_a_of_type_Mcv.a(paramLong, paramFloat);
    }
    if (this.jdField_a_of_type_Mfb != null) {
      this.jdField_a_of_type_Mfb.a(paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (g()) {
      return;
    }
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], sessionInfo[" + locallid + "], seq[" + paramLong + "]");
    }
    if (locallid.n()) {
      j(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mvw != null) {
        this.jdField_a_of_type_Mvw.a(false);
      }
      if ((!mbt.f()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372597, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372589, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372594, false);
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
          this.jdField_l_of_type_Boolean = true;
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
            this.jdField_l_of_type_Boolean = true;
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
    if (g()) {
      return;
    }
    AVActivity localAVActivity = a();
    paramString1 = bdgm.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690648, new mma(this, paramLong));
    if (mww.a(localAVActivity)) {}
    for (int i1 = 2131696126;; i1 = 2131696127)
    {
      paramString1.setPositiveButton(i1, new mlz(this, paramLong)).show();
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
          paramView = new mlx(this, paramString, paramLong, paramView);
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.jdField_q_of_type_Boolean + "], seq[" + paramLong + "]");
          this.jdField_q_of_type_Boolean = true;
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
  
  public int b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return i2;
    }
    int i1 = d();
    i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298995);
    if (this.jdField_m_of_type_Boolean)
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
      return i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297765);
      i1 = i2;
      if (i2 <= 0)
      {
        i1 = e();
        continue;
        if (this.i) {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320)) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297465) + i2;
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
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372891));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372892));
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372799));
      this.jdField_a_of_type_Mmh = new mmh(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_Mmh);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new mlv(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369359));
      localAVActivity = a();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
    return;
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localAVActivity.findViewById(2131372856));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372792) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372793) != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365136));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372898));
    this.jdField_a_of_type_Mwk = mwk.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mwk);
    if (this.jdField_a_of_type_Mvw != null) {
      this.jdField_a_of_type_Mvw.a(false);
    }
    this.jdField_a_of_type_Mvw = mvw.a(this.jdField_a_of_type_Mvw, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Mwk);
    this.jdField_a_of_type_Mvw.a(true);
    this.jdField_a_of_type_Mwk.a();
    ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131372566);
    this.jdField_a_of_type_Mcv = new mcv();
    this.jdField_a_of_type_Mcv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localViewGroup);
    this.jdField_a_of_type_Mfb = new mfb(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_Mfb.a(localViewGroup);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131372895).setBackgroundColor(2145838842);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131372896).setBackgroundColor(2145838842);
    }
    new mmi(this.jdField_a_of_type_AndroidViewViewGroup).a(localAVActivity);
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372589, paramBoolean);
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372597, paramBoolean);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372903, paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.jdField_k_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lid locallid;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
      }
      if (this.jdField_a_of_type_Mcv != null) {
        this.jdField_a_of_type_Mcv.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      if (this.jdField_a_of_type_Mfb != null) {
        this.jdField_a_of_type_Mfb.c();
      }
      locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallid.k()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      }
    } while ((!locallid.g()) || (locallid.e) || (locallid.k()) || (!locallid.s()) || ((bdin.h(null)) && (AudioHelper.a(0) != 1)));
    mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
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
    paramString1 = bdgm.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690648, new mmc(this, paramLong));
    if (mww.a(localAVActivity)) {}
    for (int i1 = 2131696126;; i1 = 2131696127)
    {
      paramString1 = paramString1.setPositiveButton(i1, new mmb(this, paramLong));
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
    if (g()) {}
    mtb localmtb;
    do
    {
      return false;
      localmtb = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695813);
      if (localmtb != null) {
        break;
      }
    } while (!jdField_p_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, null, seq[" + paramLong + "]");
    return false;
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if (locallid.i == 1044)
    {
      i1 = 8;
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool2 = true;
        label105:
        localmtb.b(bool2);
        if (i1 != 0) {
          break label334;
        }
      }
      label334:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        localmtb.c(bool2);
        return bool1;
        if ((locallid.d == 3) || (locallid.d == 4))
        {
          if (locallid.v())
          {
            if (!jdField_p_of_type_Boolean) {
              break label356;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, isHrConf, seq[" + paramLong + "]");
            i1 = 8;
            bool1 = false;
            break;
          }
          if (((this instanceof MultiVideoCtrlLayerUIBase)) && (((MultiVideoCtrlLayerUIBase)this).c()))
          {
            if (!jdField_p_of_type_Boolean) {
              break label348;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, isFull, seq[" + paramLong + "]");
            i1 = 0;
            bool1 = false;
            break;
          }
        }
        if (!j()) {
          break label340;
        }
        if (jdField_p_of_type_Boolean) {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, isKeyguardLock, seq[" + paramLong + "]");
        }
        i1 = 0;
        bool1 = false;
        break;
        bool2 = false;
        break label105;
      }
      label340:
      i1 = 0;
      bool1 = true;
      continue;
      label348:
      i1 = 0;
      bool1 = false;
      continue;
      label356:
      i1 = 8;
      bool1 = false;
    }
  }
  
  public int c()
  {
    if ((new mmi(this.jdField_a_of_type_AndroidViewViewGroup).a()) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return 0;
  }
  
  public abstract void c(int paramInt);
  
  public void c(long paramLong)
  {
    this.jdField_k_of_type_Int = 5;
    B(paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.g();
    }
    if (this.jdField_a_of_type_Mvw != null) {
      this.jdField_a_of_type_Mvw.b(false);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDetectNoDevicePermission, issueType[" + this.x + "->" + paramInt + "], isRequestCameraPermission[" + this.jdField_l_of_type_Boolean + "], seq[" + paramLong + "]");
    }
    this.x = paramInt;
    this.jdField_f_of_type_JavaLangString = "";
    AVActivity localAVActivity = a();
    String str2;
    String str1;
    if (paramInt == 1)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求相机权限.2");
      str2 = localAVActivity.getString(2131696114);
      str1 = localAVActivity.getString(2131696115);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
      {
        this.jdField_f_of_type_JavaLangString = "0X8004892";
        this.g = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1)
        {
          this.jdField_f_of_type_JavaLangString = "0X8004898";
          this.g = "0X8004899";
        }
      }
    }
    do
    {
      for (;;)
      {
        this.jdField_n_of_type_Boolean = true;
        azqs.b(null, "CliOper", "", "", this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
        if (!a(localAVActivity)) {
          break label753;
        }
        if ((paramInt != 2) || (!this.jdField_l_of_type_Boolean)) {
          break;
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
        {
          this.jdField_f_of_type_JavaLangString = "0X800488C";
          this.g = "0X800488D";
        }
      }
      if (paramInt == 2)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求相机权限.3");
        str2 = localAVActivity.getString(2131696114);
        str1 = localAVActivity.getString(2131696115);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
        {
          this.jdField_f_of_type_JavaLangString = "0X80049D3";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
            this.jdField_f_of_type_JavaLangString = "0X80049D4";
          }
        }
        for (;;)
        {
          this.jdField_n_of_type_Boolean = false;
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
        str2 = localAVActivity.getString(2131696124);
        str1 = localAVActivity.getString(2131696125);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
        {
          this.jdField_f_of_type_JavaLangString = "0X800488F";
          this.g = "0X8004890";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004895";
            this.g = "0X8004896";
          }
        }
        for (;;)
        {
          this.jdField_n_of_type_Boolean = true;
          break;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004889";
            this.g = "0X800488A";
          }
          else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004885";
            this.g = "0X8004886";
          }
        }
      }
      if ((paramInt == 4) && (localAVActivity != null))
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
          mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3004);
        }
        str1 = "";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().q())
        {
          str1 = "0X8004891";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1) {
            str1 = "0X8004897";
          }
        }
        for (;;)
        {
          azqs.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
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
      i1 = mww.b(localAVActivity);
      i2 = mww.a(localAVActivity);
      f1 = mww.a(localAVActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + b() + "], topBarHeight[" + a(paramLong) + "], density[" + f1 + "], screenSize[" + i2 + ", " + i1 + "], hasSmartBar[" + i() + "]");
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h == 11)
    {
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1015);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h == 16)
    {
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1061);
      return;
    }
    mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
  }
  
  public void c(boolean paramBoolean) {}
  
  boolean c(long paramLong)
  {
    if (g()) {}
    mtb localmtb;
    do
    {
      return false;
      localmtb = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695809);
      if (localmtb != null) {
        break;
      }
    } while (!jdField_p_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, null, seq[" + paramLong + "]");
    return false;
    boolean bool1;
    if (lux.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      if (!jdField_p_of_type_Boolean) {
        break label627;
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, GLVersion, seq[" + paramLong + "]");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        localmtb.b(bool2);
        if (jdField_p_of_type_Boolean) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, enable[" + bool1 + "], seq[" + paramLong + "]");
        }
        return bool1;
        lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (locallid.i == 1044)
        {
          localmtb.c(false);
          bool1 = false;
          break;
        }
        if ((locallid.d == 1) || (locallid.d == 2))
        {
          if ((locallid.g()) || (locallid.n()) || (locallid.o()))
          {
            if (!jdField_p_of_type_Boolean) {
              break label627;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, state[" + locallid.g + "], seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.f()) {
            break label450;
          }
          if (!jdField_p_of_type_Boolean) {
            break label627;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, !canAVShift, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (((locallid.d == 3) || (locallid.d == 4)) && (!this.jdField_a_of_type_ComTencentAvVideoController.e))
        {
          if (!jdField_p_of_type_Boolean) {
            break label627;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, 没有进入房间, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        label450:
        if (!locallid.jdField_o_of_type_Boolean)
        {
          if (!jdField_p_of_type_Boolean) {
            break label627;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, cameraPermission, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (locallid.Z == 0)
        {
          if (!jdField_p_of_type_Boolean) {
            break label627;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, mCameraAvailable, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (!CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramLong)) {
          break label632;
        }
        if (!jdField_p_of_type_Boolean) {
          break label627;
        }
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, isCameraOpening, seq[" + paramLong + "]");
        bool1 = false;
        break;
      }
      label627:
      bool1 = false;
      continue;
      label632:
      bool1 = true;
    }
  }
  
  public void d()
  {
    this.jdField_k_of_type_Int = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Mmf == null))
    {
      this.jdField_a_of_type_Mmf = new mmf(this);
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
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Mmf, localIntentFilter);
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
    this.jdField_k_of_type_Int = 6;
    if (this.jdField_a_of_type_Mcv != null)
    {
      this.jdField_a_of_type_Mcv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_Mcv = null;
    }
    if (this.jdField_a_of_type_Mfb != null)
    {
      this.jdField_a_of_type_Mfb.e();
      this.jdField_a_of_type_Mfb = null;
    }
    if (this.jdField_a_of_type_Mmg != null)
    {
      this.jdField_a_of_type_Mmg.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Mmg = null;
    }
    B(paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      if (this.jdField_a_of_type_Mmj != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mmj);
        this.jdField_a_of_type_Mmj = null;
      }
    }
    if (this.jdField_a_of_type_Mvw != null) {
      this.jdField_a_of_type_Mvw.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_Mmf != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label394;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Mmf);
      this.jdField_a_of_type_Mmf = null;
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
      this.jdField_a_of_type_Mvp = null;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_Mmk = null;
      this.jdField_b_of_type_Mmk = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
      this.jdField_b_of_type_Meu = null;
      this.jdField_d_of_type_AndroidWidgetTextView = null;
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_Mvr = null;
      this.jdField_a_of_type_Mvo = null;
      this.jdField_a_of_type_Mvw = null;
      this.jdField_a_of_type_Mwk = null;
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
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      mww.a(this.jdField_d_of_type_AndroidWidgetTextView, paramString);
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
    mtb localmtb1;
    mtb localmtb2;
    do
    {
      return false;
      localmtb1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695812);
      localmtb2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695821);
    } while ((localmtb1 == null) && (localmtb2 == null));
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (lsa.a()) {
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
      if (locallid.j)
      {
        if (localmtb1 != null) {
          if (bool2) {
            break label225;
          }
        }
        label225:
        for (bool3 = true;; bool3 = false)
        {
          localmtb1.b(bool3);
          localmtb1.a(bool2);
          localmtb1.c(bool1);
          if (localmtb2 != null) {
            localmtb2.c(false);
          }
          if (localmtb2 != null) {
            localmtb2.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().v);
          }
          if (jdField_p_of_type_Boolean) {
            QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_EffectAndVoice, enable[" + bool2 + "], seq[" + paramLong + "]");
          }
          return true;
          bool1 = false;
          bool2 = false;
          break;
        }
      }
      if (localmtb2 != null) {
        if (bool2) {
          break label278;
        }
      }
      for (bool3 = true;; bool3 = false)
      {
        localmtb2.b(bool3);
        localmtb2.a(bool2);
        localmtb2.c(bool1);
        if (localmtb1 == null) {
          break;
        }
        localmtb1.c(false);
        break;
      }
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
    label568:
    label710:
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
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mVideoController is null, Why???");
            return;
          } while (((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_p_of_type_Boolean)) || (this.jdField_k_of_type_Boolean) || ((!this.jdField_a_of_type_ComTencentAvVideoController.a().k()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)));
          bool2 = this.i;
          if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mRootView is null Why");
        return;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().J)) {
          break label568;
        }
        o(true);
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "switchToolBar, ToolbarDisplay[" + bool2 + "->" + this.i + "], type[" + paramInt + "]");
        mbt.a();
        if (!this.i) {
          break label710;
        }
        mdd.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar mQavPanel.isShown()[" + this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown() + "], mTopToolbar.isShown()[" + this.jdField_c_of_type_AndroidWidgetRelativeLayout.isShown() + "]");
        }
      } while ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.isShown()));
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_q_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "WL_DEBUG switchToolBar type=" + paramInt + ", toolbarShowTimes: " + this.jdField_q_of_type_Int);
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
        if (this.jdField_a_of_type_Mmk == null) {
          this.jdField_a_of_type_Mmk = new mmk(this, 2);
        }
        if (this.jdField_b_of_type_Mmk == null) {
          this.jdField_b_of_type_Mmk = new mmk(this, 1);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_Mmk);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_Mmk);
        if (lnz.a()) {
          break label799;
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
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 3) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().J))
        {
          o(true);
          break;
        }
        if (loc.a().a.jdField_a_of_type_Boolean)
        {
          o(true);
          break;
        }
        if (!this.i) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          o(bool1);
          break;
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772126);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772163);
        continue;
        ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131372689)).setVisibility(4);
        if (paramInt == 1)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = a(false);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = a(false);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772125);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772162);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.i), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_a_of_type_Mmk != null) {
        this.jdField_a_of_type_Mmk.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    label799:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.i), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void e(long paramLong)
  {
    if (this.jdField_a_of_type_Mvw != null) {
      this.jdField_a_of_type_Mvw.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 4, "onConnected");
    }
  }
  
  @TargetApi(21)
  public void e(long paramLong, View paramView)
  {
    if (!lfb.a().a().y())
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
      }
      ScreenShareCtrl.a(7);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (paramView == null);
    paramView.a(a(), paramLong);
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
      str = localAVActivity.getString(2131696114);
      paramString = localAVActivity.getString(2131696115);
    }
    for (;;)
    {
      a(paramLong, str, paramString);
      return;
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        str = localAVActivity.getString(2131696124);
        paramString = localAVActivity.getString(2131696125);
      }
      else
      {
        if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
          break;
        }
        str = localAVActivity.getString(2131696122);
        paramString = localAVActivity.getString(2131696123);
      }
    }
  }
  
  void e(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Mcv != null) {
      this.jdField_a_of_type_Mcv.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_Mfb != null) {
      this.jdField_a_of_type_Mfb.d();
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
      jdField_p_of_type_Boolean = AudioHelper.e();
      if ((paramInt & 0x1) == 1) {
        E(paramLong);
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
        I(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        F(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        b(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        J(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        D(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        G(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        H(paramLong);
      }
      if ((paramInt & 0x1000) == 4096) {
        k(paramLong);
      }
      g(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
    } while (!jdField_p_of_type_Boolean);
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn, sessionInfo[" + locallid + "], screenStyle[" + locallid.M + "], remoteHasVideo[" + locallid.jdField_k_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
  }
  
  public void f(long paramLong, View paramView)
  {
    if (g()) {
      return;
    }
    C(paramLong);
    paramView = new mey(paramView);
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
  
  public void f(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Mwk.c();
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
      this.jdField_a_of_type_Mwk.a(paramLong, this.jdField_e_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.jdField_e_of_type_JavaLangString + "], deviceName[" + str + "], seq[" + paramLong + "]");
      }
      this.jdField_a_of_type_Mwk.a(paramLong, str);
      return;
    }
    this.jdField_a_of_type_Mwk.a(this.jdField_e_of_type_JavaLangString);
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
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_ScreenShot, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mlw(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(l1);
    }
    mtr.a();
  }
  
  public void g(String paramString)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "hideToolBar[" + paramString + "], isToolBarDisplay[" + h() + "], mToolbarDisplay[" + this.i + "]");
    if (this.i) {
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  public void g(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity != null) && (localAVActivity.jdField_a_of_type_Mpe != null)) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i1 = 2;; i1 = 0)
    {
      localAVActivity.jdField_a_of_type_Mpe.c(i1);
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
  
  void h(long paramLong, int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_MiddleCenter, visibility[" + this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void h(long paramLong, View paramView)
  {
    mtq.f();
    paramView = new mew(paramView, 1);
    paramView.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Voice, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695812);
      return;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Voice, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
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
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setChatTime, time[" + paramString + "]");
        }
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364130);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!mww.jdField_a_of_type_Boolean);
    if (TextUtils.isEmpty(paramString))
    {
      mww.a(localTextView, "");
      return;
    }
    mww.a(localTextView, mww.a(paramString));
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
      if (this.jdField_a_of_type_Mmg != null) {
        this.jdField_a_of_type_Mmg.removeMessages(paramInt);
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
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void i(long paramLong, View paramView)
  {
    paramView = new mew(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Effect, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      j(paramLong, 2131695812);
      return;
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Effect, mEffectBtnID[" + paramView.jdField_b_of_type_Int + "], seq[" + paramLong + "]");
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
  
  public void j() {}
  
  void j(int paramInt)
  {
    b(a(this.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt));
  }
  
  public abstract void j(long paramLong);
  
  void j(long paramLong, int paramInt)
  {
    if ((2131695814 != paramInt) && (2131695812 != paramInt)) {
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
          return bdmh.a(localContext);
        }
      }
      return bdmh.a(localContext);
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372597, this.jdField_a_of_type_AndroidContentResResources.getString(2131693060));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372597, true);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
  }
  
  public void k(long paramLong)
  {
    if (g()) {}
    mtb localmtb;
    Context localContext;
    do
    {
      do
      {
        return;
        localmtb = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695815);
        if (localmtb != null) {
          break;
        }
      } while (!jdField_p_of_type_Boolean);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShare, null, seq[" + paramLong + "]");
      return;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("normal_2_meeting", 2, "updateBtn_ScreenShare context is null.");
    return;
    if (Build.VERSION.SDK_INT < 21) {
      localmtb.c(false);
    }
    lid locallid;
    for (;;)
    {
      locallid = lfb.a().a();
      if (locallid.i != 1044) {
        break;
      }
      localmtb.c(false);
      localmtb.a(false);
      return;
      localmtb.c(true);
    }
    if ((locallid.a == VideoConstants.EmShareState.START_SUC) || (locallid.a == VideoConstants.EmShareState.REQUESTING_START))
    {
      localmtb.a(2130841679);
      localmtb.a(localContext.getResources().getString(2131695816));
      return;
    }
    localmtb.a(2130841678);
    localmtb.a(localContext.getResources().getString(2131695815));
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
      bool = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372597, this.jdField_a_of_type_AndroidContentResResources.getString(2131693052));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372597, false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
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
  
  public void m(long paramLong)
  {
    this.jdField_k_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.f();
    }
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
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(170), Boolean.valueOf(this.i) });
    }
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372910);
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
      mdd.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, 3000L);
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
  
  public void y(long paramLong) {}
  
  public void z(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */