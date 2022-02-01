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
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleReportController;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.DataReport.ScreenShot;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public abstract class VideoControlUI
{
  public static boolean n;
  static boolean jdField_o_of_type_Boolean = false;
  static int x = -1;
  public final int A = 256;
  public final int B = 257;
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new VideoControlUI.10(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = null;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new VideoControlUI.9(this);
  View jdField_a_of_type_AndroidViewView = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  public VideoController a;
  public VideoAppInterface a;
  AvTipsView jdField_a_of_type_ComTencentAvTipsAvTipsView;
  private DeviceTipsController jdField_a_of_type_ComTencentAvUiDeviceTipsController;
  QavPanel.onReciveQavPanelStatusChangeListener jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  private VideoControlUI.CameraAvailabilityReceiver jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver = null;
  private VideoControlUI.DelayTipsHandler jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler;
  VideoControlUI.QAVButtonOnTouchListener jdField_a_of_type_ComTencentAvUiVideoControlUI$QAVButtonOnTouchListener;
  VideoControlUI.ShowSharpInfoRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = null;
  VideoControlUI.SubControlUIObserver jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver;
  VideoControlUI.TimmerRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
  VideoControlUI.ToolbarAnimationListener jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener = null;
  VideoControlUI.ToolbarAnimationRunnable jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable = new VideoControlUI.ToolbarAnimationRunnable(this);
  VideoNetStateBar jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
  QQAnimationListener jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = new VideoControlUI.3(this);
  QQFrameByFrameAnimation jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
  RingAnimator jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
  SensorHelper jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_a_of_type_Boolean = false;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  ControlUIObserver jdField_b_of_type_ComTencentAvUiControlUIObserver;
  VideoControlUI.ToolbarAnimationListener jdField_b_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener = null;
  private boolean jdField_b_of_type_Boolean = true;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  private boolean jdField_c_of_type_Boolean = false;
  public final long d;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout = null;
  final String jdField_d_of_type_JavaLangString = getClass().getSimpleName() + "_" + AudioHelper.b();
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_e_of_type_AndroidWidgetTextView = null;
  String jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  TextView f;
  public String f;
  TextView jdField_g_of_type_AndroidWidgetTextView = null;
  public String g;
  boolean jdField_g_of_type_Boolean = false;
  Runnable h;
  public String h;
  public boolean h;
  protected boolean i = false;
  boolean j;
  public boolean k = false;
  public boolean l = false;
  int jdField_m_of_type_Int = 0;
  boolean jdField_m_of_type_Boolean = true;
  int n;
  int jdField_o_of_type_Int = 0;
  int jdField_p_of_type_Int = 0;
  boolean jdField_p_of_type_Boolean = false;
  public int q = 0;
  int r = 0;
  int s = 0;
  int t = 0;
  int u = 0;
  int v = 0;
  int w = 0;
  public int y = 0;
  public int z = 0;
  
  static
  {
    jdField_n_of_type_Boolean = false;
  }
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangRunnable = new VideoControlUI.4(this);
    this.jdField_h_of_type_JavaLangString = (Build.MANUFACTURER + "." + Build.MODEL);
    this.jdField_d_of_type_Long = 1500L;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "VideoControlUI");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver = new VideoControlUI.SubControlUIObserver(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler = new VideoControlUI.DelayTipsHandler(this, Looper.getMainLooper());
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
      AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "mRes is null. exit video progress");
      paramAVActivity = paramVideoAppInterface.getString(2131720499) + " 0x08";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = this.jdField_a_of_type_AndroidContentResResources.getString(2131720499) + " 0x09";
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
    this.u = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298003);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131298005);
    this.v = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298006);
    this.w = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298021);
  }
  
  public static int a(SessionInfo paramSessionInfo, int paramInt)
  {
    int i2 = 2131695818;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = 2131695814;
    }
    for (;;)
    {
      if (paramSessionInfo.jdField_j_of_type_Int == 1011)
      {
        if (paramInt != 9) {
          break;
        }
        i1 = 2131720501;
      }
      return i1;
      i1 = 2131720519;
      continue;
      i1 = i2;
      if (!paramSessionInfo.s)
      {
        i1 = 2131695816;
        continue;
        i1 = 2131695692;
        continue;
        i1 = 2131695815;
        continue;
        i1 = 2131695813;
        continue;
        i1 = 2131695817;
        continue;
        i1 = 2131695814;
        continue;
        i1 = 2131695735;
      }
    }
    return 2131695420;
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
          localObject = ((AVActivity)localObject).findViewById(2131373789);
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
        str2 = ImmersiveUtils.TAG;
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
        QLog.w(ImmersiveUtils.TAG, 1, "setSystemStatusBar, Exception", localException);
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
    return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297684);
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
  
  protected void A(long paramLong) {}
  
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
  
  public void D(long paramLong)
  {
    if (h()) {}
    for (;;)
    {
      return;
      boolean bool1 = QLog.isDevelopLevel();
      String str = "";
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i1 = localSessionInfo.d;
      boolean bool2 = localSessionInfo.A();
      Object localObject = a();
      if (bool2)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 6000L);
        localObject = str;
        if (bool1) {
          localObject = HardCodeUtil.a(2131715946);
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
            if ((i1 == 2) && (!localSessionInfo.l()))
            {
              localObject = str;
              if (bool1) {
                localObject = "not Connected";
              }
            }
            else if ((i1 == 4) && (localSessionInfo.s()))
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
                localObject = HardCodeUtil.a(2131715946);
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
  
  public void E(long paramLong)
  {
    boolean bool3 = true;
    OperationBtnItem localOperationBtnItem = a(2131695335, paramLong);
    if (localOperationBtnItem == null) {
      return;
    }
    boolean bool4 = EffectsRenderController.b();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2;
    if ((AVUtil.a()) || (WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)))
    {
      bool1 = false;
      bool2 = false;
      label54:
      if (!localSessionInfo.jdField_j_of_type_Boolean) {
        break label220;
      }
      if (!bool2)
      {
        label67:
        localOperationBtnItem.b(bool3);
        localOperationBtnItem.a(bool2);
        localOperationBtnItem.c(bool1);
        label87:
        if (!QLog.isDevelopLevel()) {
          break label229;
        }
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_VirtualBackground, visible[" + bool1 + "], enable[" + bool2 + "], enableAE[" + bool4 + "], localHasVideo[" + localSessionInfo.jdField_j_of_type_Boolean + "]");
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
      localOperationBtnItem.c(false);
      bool1 = false;
      break label87;
      break;
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onPauseAudio");
    }
  }
  
  void F(long paramLong)
  {
    int i2 = 8;
    if (h()) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    if (!EffectsRenderController.b())
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
      if (!localSessionInfo.jdField_j_of_type_Boolean)
      {
        i1 = i2;
        if (jdField_o_of_type_Boolean)
        {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Beauty, !localHasVideo, seq[" + paramLong + "]");
          i1 = i2;
        }
      }
      else if (!PtuResChecker.a().a())
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onResumeAudio");
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
    if ((((SessionInfo)localObject).d == 1) && (!((SessionInfo)localObject).l()))
    {
      i2 = 8;
      i1 = i2;
      if (jdField_o_of_type_Boolean) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_More, !isConnected, seq[" + paramLong + "]");
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131374081);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374081, i1);
      localObject = a();
      if ((i2 != i1) && (localObject != null))
      {
        if (i1 == 0) {
          bool = true;
        }
        ((AVActivity)localObject).a(bool);
        ((AVActivity)localObject).a(paramLong, 2131374081, i2, i1);
      }
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_More, show[" + i1 + "], lastvisibility[" + i2 + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.removeMessages(256);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.removeMessages(257);
    }
  }
  
  void H(long paramLong)
  {
    if (h()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (this.q > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374085, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374085, 8);
  }
  
  void I()
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
  
  void I(long paramLong)
  {
    if (h()) {}
    OperationBtnItem localOperationBtnItem;
    do
    {
      return;
      localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695334);
      if (localOperationBtnItem != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_VideoMode, null, seq[" + paramLong + "]");
    return;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = 2130842382;
    if (localSessionInfo.N == 4) {
      i1 = 2130842381;
    }
    localOperationBtnItem.a(i1);
    if ((!localSessionInfo.jdField_j_of_type_Boolean) && (!localSessionInfo.k)) {}
    for (boolean bool = false;; bool = true)
    {
      localOperationBtnItem.c(bool);
      if (!jdField_o_of_type_Boolean) {
        break;
      }
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_VideoMode, bShow[" + bool + "], screenStyle[" + localSessionInfo.N + "], seq[" + paramLong + "]");
      return;
    }
  }
  
  void J()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(100);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.b(8);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(new int[] { 2130842152, 2130842153 });
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
  
  protected void J(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131695333, paramLong);
    if (localOperationBtnItem == null) {
      return;
    }
    if (!WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      localOperationBtnItem.c(bool);
      return;
    }
  }
  
  void K()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
  }
  
  protected void K(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131695324, paramLong);
    if (localOperationBtnItem == null) {}
    boolean bool;
    do
    {
      return;
      bool = true;
      if (SessionMgr.a().a().A()) {
        bool = false;
      }
      localOperationBtnItem.c(bool);
    } while (!QLog.isDevelopLevel());
    QLog.i(this.jdField_d_of_type_JavaLangString, 4, "updateBtn_ChatRoom, visible[" + bool + "]");
  }
  
  public void L()
  {
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
      OperationBtnItem localOperationBtnItem;
      do
      {
        return;
        localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695331);
        if (localOperationBtnItem != null) {
          break;
        }
      } while (!jdField_o_of_type_Boolean);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShot, null, seq[" + paramLong + "]");
      return;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      bool3 = localSessionInfo.A();
      int i2 = 8;
      i1 = i2;
      if (!localSessionInfo.x)
      {
        i1 = i2;
        if (!bool3) {
          if (localSessionInfo.d != 4)
          {
            i1 = i2;
            if (localSessionInfo.d != 2) {}
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
      localOperationBtnItem.c(bool1);
    } while (!jdField_o_of_type_Boolean);
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ScreenShot, visible[" + i1 + "], seq[" + paramLong + "], watch[" + bool3 + "], isBlackMachine[" + bool4 + "]");
  }
  
  public void M()
  {
    TipsUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  void M(long paramLong)
  {
    if (h()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, true);
  }
  
  public void N()
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
  
  void N(long paramLong)
  {
    boolean bool3 = false;
    if (h()) {}
    OperationBtnItem localOperationBtnItem;
    do
    {
      return;
      localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695325);
      if (localOperationBtnItem != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ControlMember, null, seq[" + paramLong + "]");
    return;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1;
    boolean bool1;
    if ((localSessionInfo.d == 1) || (localSessionInfo.d == 2))
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
        localOperationBtnItem.b(bool2);
        localOperationBtnItem.a(bool1);
        bool2 = bool3;
        if (i1 == 0) {
          bool2 = true;
        }
        localOperationBtnItem.c(bool2);
        if (!jdField_o_of_type_Boolean) {
          break;
        }
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_ControlMember, enable[" + bool1 + "], visible[" + i1 + "], seq[" + paramLong + "]");
        return;
        if ((localSessionInfo.d != 3) && (localSessionInfo.d != 4)) {
          break label288;
        }
        if ((!localSessionInfo.ad) && (!localSessionInfo.jdField_ae_of_type_Boolean))
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (localSessionInfo.w())
        {
          i1 = 8;
          bool1 = false;
          break label102;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.d) {
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
  
  void O()
  {
    if (h()) {}
    while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373779, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373776, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373773, false);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373774, false);
  }
  
  public void P()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.h();
    }
  }
  
  void Q() {}
  
  public void R()
  {
    a(i(), true);
  }
  
  void S()
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
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299272);
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131374074) == null) || (!this.jdField_h_of_type_Boolean))
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
  
  protected long a()
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
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {}
    while (!(localWeakReference.get() instanceof AVActivity)) {
      return null;
    }
    return (AVActivity)localWeakReference.get();
  }
  
  EffectSettingUi a()
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
  
  public OperationBtnItem a(int paramInt, long paramLong)
  {
    Object localObject;
    if (h()) {
      localObject = null;
    }
    OperationBtnItem localOperationBtnItem;
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
      localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramInt);
      localObject = localOperationBtnItem;
    } while (localOperationBtnItem != null);
    if (jdField_o_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "getOperationBtnItem, null, seq[" + paramLong + "], menuItemId[" + paramInt + "]");
    }
    return null;
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
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.removeMessages(paramInt);
        paramString = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.obtainMessage(paramInt, paramString);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.sendMessageDelayed(paramString, 1500L);
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
  
  void a(long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(paramLong, paramFloat);
    }
    if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController != null) {
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController.a(paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClose, type[" + paramInt + "], sessionInfo[" + localSessionInfo + "], seq[" + paramLong + "]");
    }
    if (localSessionInfo.o()) {
      j(paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
      }
      if ((!SmallScreenUtils.f()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373779, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373776, false);
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
    paramString1 = DialogUtil.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690800, new VideoControlUI.6(this, paramLong));
    if (UITools.a(localAVActivity)) {}
    for (int i1 = 2131695644;; i1 = 2131695645)
    {
      paramString1.setPositiveButton(i1, new VideoControlUI.5(this, paramLong)).show();
      return;
    }
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean) {}
  
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
          paramView = new VideoControlUI.13(this, paramString, paramLong, paramView);
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
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374073));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131374074));
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373982));
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$QAVButtonOnTouchListener = new VideoControlUI.QAVButtonOnTouchListener(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$QAVButtonOnTouchListener);
      this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener = new VideoControlUI.1(this);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new VideoControlUI.2(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370278));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370277));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localAVActivity = a();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
    return;
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)localAVActivity.findViewById(2131374038));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373974) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373975) != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
    }
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365705));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374080));
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
    }
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    ViewGroup localViewGroup = (ViewGroup)localAVActivity.findViewById(2131373749);
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView = new AvTipsView();
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localViewGroup);
    this.jdField_a_of_type_ComTencentAvUiDeviceTipsController = new DeviceTipsController(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiDeviceTipsController.a(localViewGroup);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131374077).setBackgroundColor(2145838842);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131374078).setBackgroundColor(2145838842);
    }
    new VideoControlUI.QavStatusBar(this.jdField_a_of_type_AndroidViewViewGroup).a(localAVActivity);
  }
  
  void b(int paramInt) {}
  
  void b(int paramInt, boolean paramBoolean)
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
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373771, paramBoolean);
        return;
      } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373779, paramBoolean);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131374085, paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.jdField_m_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.e();
      }
      if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView != null) {
        this.jdField_a_of_type_ComTencentAvTipsAvTipsView.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController != null) {
        this.jdField_a_of_type_ComTencentAvUiDeviceTipsController.c();
      }
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localSessionInfo.l()) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      }
    } while ((!localSessionInfo.h()) || (localSessionInfo.e) || (localSessionInfo.l()) || (!localSessionInfo.t()) || ((NetworkUtil.h(null)) && (AudioHelper.a(0) != 1)));
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
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
    paramString1 = DialogUtil.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690800, new VideoControlUI.8(this, paramLong));
    if (UITools.a(localAVActivity)) {}
    for (int i1 = 2131695644;; i1 = 2131695645)
    {
      paramString1 = paramString1.setPositiveButton(i1, new VideoControlUI.7(this, paramLong));
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
    OperationBtnItem localOperationBtnItem;
    do
    {
      return false;
      localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695327);
      if (localOperationBtnItem != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_InviteMember, null, seq[" + paramLong + "]");
    return false;
    int i1;
    boolean bool1;
    if (WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
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
        localOperationBtnItem.b(bool2);
        if (i1 != 0) {
          break label353;
        }
      }
      label353:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        localOperationBtnItem.c(bool2);
        return bool1;
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (localSessionInfo.jdField_j_of_type_Int == 1044)
        {
          i1 = 8;
          bool1 = false;
          break;
        }
        if ((localSessionInfo.d == 3) || (localSessionInfo.d == 4))
        {
          if (localSessionInfo.w())
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
    i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299254);
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
      return i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297983);
      i1 = i2;
      if (i2 <= 0)
      {
        i1 = e();
        continue;
        if (this.jdField_h_of_type_Boolean) {
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320)) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297679) + i2;
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
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
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
      str2 = localAVActivity.getString(2131695632);
      str1 = localAVActivity.getString(2131695633);
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
        ReportController.b(null, "CliOper", "", "", this.jdField_f_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
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
        str2 = localAVActivity.getString(2131695632);
        str1 = localAVActivity.getString(2131695633);
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
        str2 = localAVActivity.getString(2131695642);
        str1 = localAVActivity.getString(2131695643);
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
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3004);
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
          ReportController.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
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
  
  protected void c(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {}
    int i1;
    int i2;
    float f1;
    do
    {
      return;
      i1 = UITools.b(localAVActivity);
      i2 = UITools.a(localAVActivity);
      f1 = UITools.a(localAVActivity);
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "adaptScreens[" + paramString + "], bottomBarHeight[" + c() + "], topBarHeight[" + a(paramLong) + "], density[" + f1 + "], screenSize[" + i2 + ", " + i1 + "], hasSmartBar[" + j() + "]");
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 11)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1015);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 16)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1061);
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
  }
  
  public void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  boolean c(long paramLong)
  {
    if (h()) {}
    OperationBtnItem localOperationBtnItem;
    do
    {
      return false;
      localOperationBtnItem = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695323);
      if (localOperationBtnItem != null) {
        break;
      }
    } while (!jdField_o_of_type_Boolean);
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, null, seq[" + paramLong + "]");
    return false;
    boolean bool1;
    if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
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
        localOperationBtnItem.b(bool2);
        if (jdField_o_of_type_Boolean) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, enable[" + bool1 + "], seq[" + paramLong + "]");
        }
        return bool1;
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (localSessionInfo.jdField_j_of_type_Int == 1044)
        {
          localOperationBtnItem.c(false);
          bool1 = false;
          break;
        }
        if ((localSessionInfo.d == 1) || (localSessionInfo.d == 2))
        {
          if ((localSessionInfo.h()) || (localSessionInfo.o()) || (localSessionInfo.p()))
          {
            if (!jdField_o_of_type_Boolean) {
              break label688;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, state[" + localSessionInfo.g + "], seq[" + paramLong + "]");
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
        if ((localSessionInfo.d == 3) || (localSessionInfo.d == 4))
        {
          if (localSessionInfo.J)
          {
            if (localSessionInfo.K) {
              break label511;
            }
            if (!jdField_o_of_type_Boolean) {
              break label688;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, not enter room for meeting, seq[" + paramLong + "]");
            bool1 = false;
            break;
          }
          if (!this.jdField_a_of_type_ComTencentAvVideoController.d)
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
        if (!localSessionInfo.jdField_o_of_type_Boolean)
        {
          if (!jdField_o_of_type_Boolean) {
            break label688;
          }
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_Camera, cameraPermission, seq[" + paramLong + "]");
          bool1 = false;
          break;
        }
        if (localSessionInfo.aa == 0)
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
    if ((new VideoControlUI.QavStatusBar(this.jdField_a_of_type_AndroidViewViewGroup).a()) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    return 0;
  }
  
  public void d()
  {
    this.jdField_m_of_type_Int = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver == null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver = new VideoControlUI.CameraAvailabilityReceiver(this);
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
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver, localIntentFilter);
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
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView != null)
    {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController != null)
    {
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController.e();
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler = null;
    }
    C(paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver = null;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver != null))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label394;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
      }
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver = null;
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
      this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = null;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
      this.jdField_a_of_type_AndroidWidgetToast = null;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener = null;
      this.jdField_b_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener = null;
      this.jdField_c_of_type_AndroidWidgetImageView = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
      this.jdField_b_of_type_ComTencentAvUiControlUIObserver = null;
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      this.jdField_f_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_ComTencentAvUtilsRingAnimator = null;
      this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
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
  
  abstract void d(long paramLong, View paramView);
  
  void d(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setConnectInfo, str[" + paramString + "], seq[" + paramLong + "]");
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
      UITools.a(this.jdField_e_of_type_AndroidWidgetTextView, paramString);
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
    OperationBtnItem localOperationBtnItem1;
    OperationBtnItem localOperationBtnItem2;
    SessionInfo localSessionInfo;
    do
    {
      do
      {
        return false;
        localOperationBtnItem1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695326);
        localOperationBtnItem2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695336);
      } while ((localOperationBtnItem1 == null) && (localOperationBtnItem2 == null));
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!localSessionInfo.A()) {
        break;
      }
      if (localOperationBtnItem1 != null) {
        localOperationBtnItem1.c(false);
      }
    } while (localOperationBtnItem2 == null);
    localOperationBtnItem2.c(false);
    return false;
    boolean bool4 = EffectsRenderController.b();
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
      if (localSessionInfo.jdField_j_of_type_Boolean) {
        if (localOperationBtnItem1 != null)
        {
          if (!bool1)
          {
            bool2 = true;
            label139:
            localOperationBtnItem1.b(bool2);
            localOperationBtnItem1.a(bool1);
            localOperationBtnItem1.c(bool4);
          }
        }
        else if (localOperationBtnItem2 != null)
        {
          bool2 = bool3;
          if (!bool4) {
            bool2 = true;
          }
          localOperationBtnItem2.c(bool2);
        }
      }
      for (;;)
      {
        if (localOperationBtnItem2 != null) {
          localOperationBtnItem2.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().v);
        }
        if (jdField_o_of_type_Boolean) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 1, "updateBtn_EffectAndVoice, enable[" + bool1 + "], enableAE[" + bool4 + "], seq[" + paramLong + "]");
        }
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label139;
        if (localOperationBtnItem2 != null)
        {
          localOperationBtnItem2.b(false);
          localOperationBtnItem2.a(true);
          localOperationBtnItem2.c(true);
        }
        if (localOperationBtnItem1 != null) {
          localOperationBtnItem1.c(false);
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
      SessionInfo localSessionInfo;
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
            localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
          } while (((localSessionInfo.jdField_j_of_type_Int == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_o_of_type_Boolean)) || (this.jdField_j_of_type_Boolean) || ((!localSessionInfo.l()) && (localSessionInfo.d == 2)));
          bool2 = this.jdField_h_of_type_Boolean;
          if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mRootView is null Why");
        return;
        if (!localSessionInfo.A()) {
          break label545;
        }
        if (this.jdField_h_of_type_Boolean) {
          break label540;
        }
        bool1 = true;
        o(bool1);
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "switchToolBar, ToolbarDisplay[" + bool2 + "->" + this.jdField_h_of_type_Boolean + "], type[" + paramInt + "]");
        SmallScreenUtils.a();
        if (!this.jdField_h_of_type_Boolean) {
          break label704;
        }
        TipsUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
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
          ((MultiVideoCtrlLayerUIBase)this).w();
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener == null) {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener = new VideoControlUI.ToolbarAnimationListener(this, 2);
        }
        if (this.jdField_b_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener == null) {
          this.jdField_b_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener = new VideoControlUI.ToolbarAnimationListener(this, 1);
        }
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener);
        if (VcSystemInfo.isLowLevelDevice()) {
          break label793;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        bool1 = false;
        break;
        if ((!localSessionInfo.jdField_j_of_type_Boolean) && (!localSessionInfo.k) && (!localSessionInfo.J))
        {
          o(true);
          break label149;
        }
        if (localSessionInfo.d == 1)
        {
          o(true);
          break label149;
        }
        if ((localSessionInfo.d == 3) && (!localSessionInfo.J))
        {
          o(true);
          break label149;
        }
        if (DoodleLogic.a().a.jdField_a_of_type_Boolean)
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
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772153);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772190);
        continue;
        ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373870)).setVisibility(4);
        if (paramInt == 1)
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = a(false);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = a(false);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772152);
          this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772189);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(true), Long.valueOf(0L) });
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener.onAnimationEnd(null);
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    label793:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
  }
  
  public void e(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 4, "onConnected");
    }
  }
  
  abstract void e(long paramLong, View paramView);
  
  void e(long paramLong, String paramString)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAVActivity.getString(2131695632);
      paramString = localAVActivity.getString(2131695633);
    }
    for (;;)
    {
      a(paramLong, str, paramString);
      return;
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        str = localAVActivity.getString(2131695642);
        paramString = localAVActivity.getString(2131695643);
      }
      else
      {
        if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
          break;
        }
        str = localAVActivity.getString(2131695640);
        paramString = localAVActivity.getString(2131695641);
      }
    }
  }
  
  void e(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController != null) {
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController.d();
    }
  }
  
  public void f(int paramInt) {}
  
  public void f(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131695337, paramLong);
    if (localOperationBtnItem != null) {
      localOperationBtnItem.c(false);
    }
  }
  
  @TargetApi(21)
  public void f(long paramLong, View paramView)
  {
    paramView = SessionMgr.a().a();
    if (!paramView.z())
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
      }
      ScreenShareCtrl.a(7);
      return;
    }
    ScreenShareReportHelper.a(paramView.c, 2, "onClick_ScreenShare");
    l(paramLong, 2131695329);
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramView != null) {
      paramView.a(a(), paramLong);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.post(new VideoControlUI.11(this));
  }
  
  public void f(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, this.jdField_e_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.jdField_e_of_type_JavaLangString + "], deviceName[" + str + "], seq[" + paramLong + "]");
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, str);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void f(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  public void g() {}
  
  public void g(int paramInt) {}
  
  protected void g(long paramLong) {}
  
  public void g(long paramLong, View paramView)
  {
    if (h()) {
      return;
    }
    D(paramLong);
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
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
    if ((localAVActivity != null) && (localAVActivity.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null)) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i1 = 2;; i1 = 0)
    {
      localAVActivity.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(i1);
      return;
    }
  }
  
  protected boolean g()
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new VideoControlUI.12(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(l1);
    }
    DataReport.ScreenShot.a();
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
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364590);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!UITools.jdField_a_of_type_Boolean);
    if (TextUtils.isEmpty(paramString))
    {
      UITools.a(localTextView, "");
      return;
    }
    UITools.a(localTextView, UITools.a(paramString));
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
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.removeMessages(paramInt);
      }
      return;
    }
  }
  
  protected void i(long paramLong) {}
  
  public void i(long paramLong, int paramInt)
  {
    if ((h()) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {}
    do
    {
      return;
      jdField_o_of_type_Boolean = AudioHelper.e();
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
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "updateBtn, sessionInfo[" + localSessionInfo + "], screenStyle[" + localSessionInfo.N + "], remoteHasVideo[" + localSessionInfo.k + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
  }
  
  void i(long paramLong, View paramView)
  {
    DataReport.f();
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 1);
    paramView.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Voice, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695326);
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
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Effect, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695326);
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, this.jdField_a_of_type_AndroidContentResResources.getString(2131692875));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, true);
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
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    if (paramView.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_VirtualBackground, mBlockName[" + paramView.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
    for (;;)
    {
      l(paramLong, 2131695335);
      AVUtil.a("0X800ADA9", 0, 0, "", "", "", "");
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
          return QQUtils.a(localContext);
        }
      }
      return QQUtils.a(localContext);
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
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, this.jdField_a_of_type_AndroidContentResResources.getString(2131692867));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373779, false);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
  }
  
  public void l(long paramLong)
  {
    if ((QLog.isColorLevel()) && (paramLong == -1052L)) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_ScreenShare");
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    OperationBtnItem localOperationBtnItem = a(2131695329, paramLong);
    if ((localOperationBtnItem == null) || (localContext == null)) {
      return;
    }
    if (!QAVConfigUtils.k())
    {
      localOperationBtnItem.c(false);
      return;
    }
    if ((Build.VERSION.SDK_INT < 21) || (WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))) {
      localOperationBtnItem.c(false);
    }
    SessionInfo localSessionInfo;
    for (;;)
    {
      localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo.jdField_j_of_type_Int != 1044) {
        break;
      }
      localOperationBtnItem.c(false);
      localOperationBtnItem.a(false);
      return;
      localOperationBtnItem.c(true);
    }
    if ((localSessionInfo.jdField_ae_of_type_Int == 2) || (localSessionInfo.jdField_ae_of_type_Int == 1))
    {
      localOperationBtnItem.a(2130842192);
      localOperationBtnItem.a(localContext.getResources().getString(2131695330));
      return;
    }
    localOperationBtnItem.a(2130842191);
    localOperationBtnItem.a(localContext.getResources().getString(2131695329));
  }
  
  void l(long paramLong, int paramInt)
  {
    if ((2131695328 != paramInt) && (2131695326 != paramInt) && (2131695335 != paramInt)) {
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
      bool = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    }
    return bool;
  }
  
  void m() {}
  
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
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374092);
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
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, 3000L);
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
  
  protected void z(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */