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
import com.tencent.av.camera.api.ICameraManagerApi;
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
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
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
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Observer;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public abstract class VideoControlUI
{
  public static boolean n = false;
  static boolean jdField_o_of_type_Boolean = false;
  static int x = -1;
  public final int A;
  public final int B;
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = null;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
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
  private VideoControlUI.CameraAvailabilityReceiver jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver;
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
  final String jdField_d_of_type_JavaLangString;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_e_of_type_AndroidWidgetTextView = null;
  String jdField_e_of_type_JavaLangString = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  TextView f;
  public String f;
  TextView jdField_g_of_type_AndroidWidgetTextView = null;
  public String g;
  boolean jdField_g_of_type_Boolean = false;
  Runnable h;
  public String h;
  public boolean h;
  protected boolean i = false;
  boolean j = false;
  public boolean k;
  public boolean l = false;
  int jdField_m_of_type_Int = 0;
  boolean jdField_m_of_type_Boolean = true;
  int n;
  int jdField_o_of_type_Int = 0;
  int jdField_p_of_type_Int = 0;
  boolean jdField_p_of_type_Boolean;
  public int q = 0;
  int r = 0;
  int s = 0;
  int t = 0;
  int u = 0;
  int v = 0;
  int w = 0;
  public int y = 0;
  public int z = 0;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_f_of_type_AndroidWidgetTextView = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangRunnable = new VideoControlUI.4(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(".");
    localStringBuilder.append(Build.MODEL);
    this.jdField_h_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new VideoControlUI.9(this);
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new VideoControlUI.10(this);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver = null;
    this.A = 256;
    this.B = 257;
    this.jdField_d_of_type_Long = 1500L;
    this.jdField_p_of_type_Boolean = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
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
      paramAVActivity = new StringBuilder();
      paramAVActivity.append(paramVideoAppInterface.getString(2131720211));
      paramAVActivity.append(" 0x08");
      paramAVActivity = paramAVActivity.toString();
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.printAllUserLog(this.jdField_d_of_type_JavaLangString, "mVideoController is null. exit video progress");
      paramAVActivity = new StringBuilder();
      paramAVActivity.append(this.jdField_a_of_type_AndroidContentResResources.getString(2131720211));
      paramAVActivity.append(" 0x09");
      paramAVActivity = paramAVActivity.toString();
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
    this.u = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297997);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131297999);
    this.v = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298000);
    this.w = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298015);
  }
  
  public static int a(SessionInfo paramSessionInfo, int paramInt)
  {
    int i1 = 2131695832;
    if (paramInt != 3)
    {
      if (paramInt != 12)
      {
        if (paramInt != 25)
        {
          if (paramInt != 42)
          {
            if (paramInt != 43)
            {
              if (paramInt != 64)
              {
                if (paramInt == 65) {}
              }
              else {
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  case 56: 
                  default: 
                    i1 = 2131695828;
                    break;
                  case 54: 
                    i1 = 2131695827;
                  }
                  break;
                case 50: 
                case 51: 
                case 52: 
                  i1 = 2131695831;
                  break;
                }
              }
              i1 = 2131695749;
            }
          }
          else {
            i1 = 2131695829;
          }
        }
        else {
          i1 = 2131695706;
        }
      }
      else if (!paramSessionInfo.r) {
        i1 = 2131695830;
      }
    }
    else {
      i1 = 2131720232;
    }
    if (paramSessionInfo.jdField_k_of_type_Int == 1011)
    {
      if (paramInt == 9) {
        return 2131720213;
      }
      i1 = 2131695430;
    }
    return i1;
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
    int i1;
    int i2;
    if ((Build.VERSION.SDK_INT >= 19) && (localObject != null))
    {
      localWindow = ((AVActivity)localObject).getWindow();
      if (localWindow != null)
      {
        if ((paramBoolean1) && (paramBoolean2)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        i2 = i1;
        if (i1 != 0) {}
      }
    }
    try
    {
      localObject = ((AVActivity)localObject).findViewById(2131373361);
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
      if (i2 != 0) {
        localWindow.setFlags(2048, 1024);
      } else {
        localWindow.addFlags(1024);
      }
      if (!QLog.isDevelopLevel()) {
        break label297;
      }
      str2 = ImmersiveUtils.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSystemStatusBar, ");
      if (i2 == 0) {
        break label303;
      }
      localObject = "显示";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        StringBuilder localStringBuilder;
        continue;
        String str1 = "隐藏";
      }
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("状态栏, isToolBarDisplay[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], recordNeedShowBar[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], SystemUiVisibility[0x");
    localStringBuilder.append(Integer.toHexString(localWindow.getDecorView().getSystemUiVisibility()));
    localStringBuilder.append("], flags[0x");
    localStringBuilder.append(Integer.toHexString(localWindow.getAttributes().flags));
    localStringBuilder.append("]");
    QLog.w(str2, 1, localStringBuilder.toString());
    return;
    if (QLog.isDevelopLevel()) {
      QLog.w(ImmersiveUtils.TAG, 1, "setSystemStatusBar, Exception", (Throwable)localObject);
    }
    label297:
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return VideoController.a(paramContext) ^ true;
    }
    return false;
  }
  
  private int b()
  {
    int i1;
    if ((!this.l) && (!this.jdField_h_of_type_Boolean)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
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
    return this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297675);
  }
  
  private void e(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    if ((!CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isCameraOpening(paramLong)) && (!CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isCameraOpened(paramLong)))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().aa = paramInt;
      i(paramLong, 16777215);
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableCameraRelatedBtn, cameraAvailable[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], already opening or opened");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  private int f()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(99);
    if (localRelativeLayout != null)
    {
      localRelativeLayout.measure(0, 0);
      return localRelativeLayout.getMeasuredHeight();
    }
    return 0;
  }
  
  protected static boolean j()
  {
    if (x == -1) {
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        x = 0;
      }
    }
    try
    {
      bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
    }
    catch (Exception localException)
    {
      boolean bool;
      label60:
      int i1;
      break label60;
    }
    bool = false;
    if (Build.DEVICE.equals("mx2")) {
      bool = true;
    } else if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
      bool = false;
    }
    if (bool) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    x = i1;
    return x == 1;
  }
  
  public void A(long paramLong)
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    int i1 = this.jdField_m_of_type_Int;
    if (i1 >= 2)
    {
      if (i1 > 4) {
        return;
      }
      if ((VideoLayerUIBase.a(this.jdField_a_of_type_ComTencentAvVideoController.a())) && (!b())) {
        return;
      }
      if (QLog.isColorLevel())
      {
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startTimer, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.jdField_g_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable == null) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = new VideoControlUI.TimmerRunnable(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable, 0L);
      d(paramLong, null);
    }
  }
  
  public void B(long paramLong)
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopTimer, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable = null;
    }
    h(null);
  }
  
  public void C(long paramLong)
  {
    if (h()) {
      return;
    }
    boolean bool1 = QLog.isDevelopLevel();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = ((SessionInfo)localObject1).d;
    boolean bool2 = ((SessionInfo)localObject1).r();
    Object localObject2 = a();
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 6000L);
      if (bool1)
      {
        localObject1 = HardCodeUtil.a(2131715869);
        break label298;
      }
    }
    else if ((localObject2 != null) && (((AVActivity)localObject2).b()))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      if (bool1)
      {
        localObject1 = "isKeepToolBar";
        break label298;
      }
    }
    else if ((i1 != 2) && (i1 != 4))
    {
      if ((i1 == 1) || (i1 == 3))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        if (!this.jdField_h_of_type_Boolean) {
          e(0);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      if (this.jdField_h_of_type_Boolean) {
        if ((i1 == 2) && (!((SessionInfo)localObject1).j()))
        {
          if (bool1)
          {
            localObject1 = "not Connected";
            break label298;
          }
        }
        else if ((i1 == 4) && (((SessionInfo)localObject1).q()))
        {
          if (bool1)
          {
            localObject1 = "not Recv Data";
            break label298;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 6000L);
          if (bool1)
          {
            localObject1 = HardCodeUtil.a(2131715869);
            break label298;
          }
        }
      }
    }
    localObject1 = "";
    label298:
    if (QLog.isDevelopLevel())
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetToolBarTimer, mToolbarDisplay[");
      localStringBuilder.append(this.jdField_h_of_type_Boolean);
      localStringBuilder.append("], SessionType[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], watch[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], log[");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 4, localStringBuilder.toString());
    }
  }
  
  public void D(long paramLong)
  {
    Object localObject = a(2131695345, paramLong);
    if (localObject == null) {
      return;
    }
    boolean bool3 = EffectsRenderController.b();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = AVUtil.a();
    boolean bool1 = true;
    if ((!bool2) && (!WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) && (bool3) && (AEFilterSupport.a() > 3))
    {
      bool2 = CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isCameraOpening(paramLong) ^ true;
    }
    else
    {
      bool2 = false;
      bool1 = false;
    }
    if (localSessionInfo.j)
    {
      ((OperationBtnItem)localObject).b(bool2 ^ true);
      ((OperationBtnItem)localObject).a(bool2);
      ((OperationBtnItem)localObject).c(bool1);
    }
    else
    {
      ((OperationBtnItem)localObject).c(false);
      bool1 = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_VirtualBackground, visible[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], enable[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], enableAE[");
      localStringBuilder.append(bool3);
      localStringBuilder.append("], localHasVideo[");
      localStringBuilder.append(localSessionInfo.j);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  void E(long paramLong)
  {
    if (h()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool = EffectsRenderController.b();
    int i2 = 8;
    int i1;
    StringBuilder localStringBuilder;
    if (!bool)
    {
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, !isEnableAEModuleManager, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i1 = i2;
      }
    }
    else if (!((SessionInfo)localObject).j)
    {
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, !localHasVideo, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i1 = i2;
      }
    }
    else if (!PtuResChecker.a().a())
    {
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i1 = i2;
      }
    }
    else if (!AEFilterSupport.a(2))
    {
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, AEKitSo not ready, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i1 = i2;
      }
    }
    else
    {
      i1 = 0;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(i1);
    if (jdField_o_of_type_Boolean)
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_Beauty, show[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 1, localStringBuilder.toString());
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
    if (h()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = ((SessionInfo)localObject).d;
    boolean bool = false;
    StringBuilder localStringBuilder;
    if ((i1 == 1) && (!((SessionInfo)localObject).j()))
    {
      i2 = 8;
      i1 = i2;
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_More, !isConnected, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i1 = i2;
      }
    }
    else
    {
      i1 = 0;
    }
    int i2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373636);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373636, i1);
    localObject = a();
    if ((i2 != i1) && (localObject != null))
    {
      if (i1 == 0) {
        bool = true;
      }
      ((AVActivity)localObject).a(bool);
      ((AVActivity)localObject).a(paramLong, 2131373636, i2, i1);
    }
    if (jdField_o_of_type_Boolean)
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_More, show[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], lastvisibility[");
      localStringBuilder.append(i2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 1, localStringBuilder.toString());
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
    if (h()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (this.q > 1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373640, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373640, 8);
  }
  
  public void H()
  {
    VideoControlUI.DelayTipsHandler localDelayTipsHandler = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler;
    if (localDelayTipsHandler != null)
    {
      localDelayTipsHandler.removeMessages(256);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.removeMessages(257);
    }
  }
  
  void H(long paramLong)
  {
    if (h()) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695344);
    if (localObject2 == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_VideoMode, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i1 = 2130842280;
    if (((SessionInfo)localObject1).L == 4) {
      i1 = 2130842279;
    }
    ((OperationBtnItem)localObject2).a(i1);
    boolean bool;
    if ((!((SessionInfo)localObject1).j) && (!((SessionInfo)localObject1).jdField_k_of_type_Boolean)) {
      bool = false;
    } else {
      bool = true;
    }
    ((OperationBtnItem)localObject2).c(bool);
    if (jdField_o_of_type_Boolean)
    {
      localObject2 = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_VideoMode, bShow[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], screenStyle[");
      localStringBuilder.append(((SessionInfo)localObject1).L);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
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
  
  protected void I(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131695343, paramLong);
    if (localOperationBtnItem == null) {
      return;
    }
    localOperationBtnItem.c(WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) ^ true);
  }
  
  void J()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation = new QQFrameByFrameAnimation();
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(100);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.b(8);
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(new int[] { 2130842050, 2130842051 });
    this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation.a(this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener);
  }
  
  protected void J(long paramLong)
  {
    Object localObject = a(2131695334, paramLong);
    if (localObject == null) {
      return;
    }
    boolean bool = SessionMgr.a().a().r() ^ true;
    ((OperationBtnItem)localObject).c(bool);
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_ChatRoom, visible[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 4, localStringBuilder.toString());
    }
  }
  
  void K()
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_n_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    }
  }
  
  void K(long paramLong)
  {
    if (h()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695341);
    if (localObject1 == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_ScreenShot, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool3 = ((SessionInfo)localObject2).r();
    int i2 = 8;
    boolean bool1 = ((SessionInfo)localObject2).w;
    boolean bool2 = false;
    int i1 = i2;
    if (!bool1)
    {
      i1 = i2;
      if (!bool3) {
        if (((SessionInfo)localObject2).d != 4)
        {
          i1 = i2;
          if (((SessionInfo)localObject2).d != 2) {}
        }
        else
        {
          i1 = 0;
        }
      }
    }
    boolean bool4 = c();
    bool1 = bool2;
    if (!bool4)
    {
      bool1 = bool2;
      if (i1 == 0) {
        bool1 = true;
      }
    }
    ((OperationBtnItem)localObject1).c(bool1);
    if (jdField_o_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_ScreenShot, visible[");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], watch[");
      ((StringBuilder)localObject2).append(bool3);
      ((StringBuilder)localObject2).append("], isBlackMachine[");
      ((StringBuilder)localObject2).append(bool4);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void L()
  {
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  void L(long paramLong)
  {
    if (h()) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.f())
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373343, false);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373343, true);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695335);
    if (localObject1 == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_ControlMember, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = ((SessionInfo)localObject2).d;
    int i1 = 8;
    boolean bool2 = false;
    if ((i2 != 1) && (((SessionInfo)localObject2).d != 2))
    {
      if ((((SessionInfo)localObject2).d == 3) || (((SessionInfo)localObject2).d == 4))
      {
        if (((!((SessionInfo)localObject2).S) && (!((SessionInfo)localObject2).T)) || (QAVHrMeeting.a((SessionInfo)localObject2))) {
          break label195;
        }
        if (!this.jdField_a_of_type_ComTencentAvVideoController.d)
        {
          bool1 = false;
          break label190;
        }
      }
      bool1 = true;
      label190:
      i1 = 0;
      break label198;
    }
    label195:
    boolean bool1 = false;
    label198:
    ((OperationBtnItem)localObject1).b(bool1 ^ true);
    ((OperationBtnItem)localObject1).a(bool1);
    if (i1 == 0) {
      bool2 = true;
    }
    ((OperationBtnItem)localObject1).c(bool2);
    if (jdField_o_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_ControlMember, enable[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], visible[");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void N()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("displayToolBar, isToolBarDisplay[");
      localStringBuilder.append(i());
      localStringBuilder.append("], mApp[");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (!i())
    {
      p(false);
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  void O()
  {
    if (h()) {
      return;
    }
    QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localQavPanel != null)
    {
      localQavPanel.setViewEnable(2131373351, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373343, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373348, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373345, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373346, false);
    }
  }
  
  public void P()
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.h();
    }
  }
  
  void Q() {}
  
  public void R()
  {
    a(i(), true);
  }
  
  void S()
  {
    int i1 = this.jdField_n_of_type_Int;
    if (i1 - this.jdField_p_of_type_Int > 2)
    {
      this.jdField_p_of_type_Int = i1;
      this.jdField_o_of_type_Int = 0;
    }
    this.jdField_o_of_type_Int += 1;
    if (this.jdField_o_of_type_Int > 5)
    {
      this.jdField_o_of_type_Int = 0;
      this.jdField_p_of_type_Int = 0;
      s(true);
    }
  }
  
  protected abstract int a();
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    int i1 = 0;
    if (localObject == null) {
      return 0;
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null) {
      return 0;
    }
    int i2 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299275);
    this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373629);
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.l)
      {
        i1 = i2 / 5;
        i1 = Math.max(this.y, 0) * i1;
      }
      else
      {
        i1 = i2;
      }
      i1 += d();
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTopToolbarHeight, topToolbarHeight[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], margin[");
    localStringBuilder.append(i2);
    localStringBuilder.append("], mInToolBarAnimation[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], mToolbarDisplayFrameNow[");
    localStringBuilder.append(this.y);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    return i1;
  }
  
  protected long a()
  {
    return 0L;
  }
  
  public AlphaAnimation a(boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation;
    if (paramBoolean) {
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    } else {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    }
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setStartOffset(0L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  public AVActivity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    if ((localWeakReference.get() instanceof AVActivity)) {
      return (AVActivity)localWeakReference.get();
    }
    return null;
  }
  
  EffectSettingUi a()
  {
    QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localQavPanel != null) {
      return (EffectSettingUi)localQavPanel.a(2);
    }
    return null;
  }
  
  public QavPanel a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanel;
  }
  
  public OperationBtnItem a(int paramInt, long paramLong)
  {
    if (h()) {
      return null;
    }
    StringBuilder localStringBuilder;
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOperationBtnItem, context is null, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], menuItemId[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramInt);
    if (localObject == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOperationBtnItem, null, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], menuItemId[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      return null;
    }
    return localObject;
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
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showToast-->can not show toast-->e=");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
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
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showToast-->can not show toast-->e=");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidWidgetToast = QQToast.a(localContext, paramInt2, paramInt1, paramInt3).b(paramInt4);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.a(paramInt1, paramInt2, paramInt3, paramString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 1037) {
      paramInt = 256;
    } else {
      paramInt = 257;
    }
    VideoControlUI.DelayTipsHandler localDelayTipsHandler = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler;
    if (localDelayTipsHandler != null)
    {
      localDelayTipsHandler.removeMessages(paramInt);
      paramString = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.obtainMessage(paramInt, paramString);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler.sendMessageDelayed(paramString, 1500L);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_m_of_type_Int = 2;
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.d();
    }
    this.jdField_k_of_type_Boolean = false;
  }
  
  void a(long paramLong, float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject != null) {
      ((AvTipsView)localObject).a(paramLong, paramFloat);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiDeviceTipsController;
    if (localObject != null) {
      ((DeviceTipsController)localObject).a(paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (h()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClose, type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], sessionInfo[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (((SessionInfo)localObject).m())
    {
      j(paramInt);
    }
    else
    {
      if ((paramInt == 25) || (paramInt == 56)) {
        j(paramInt);
      }
      l();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    if (localObject != null) {
      ((SensorHelper)localObject).a(false);
    }
    if (SmallScreenUtils.f())
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (localObject != null)
      {
        ((QavPanel)localObject).setViewEnable(2131373351, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373343, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373348, false);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void a(long paramLong, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null) {
      return;
    }
    if (!localAVActivity.isResume())
    {
      paramString1 = this.jdField_d_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append("showPermissionDialog, no isResume, seq[");
      paramString2.append(paramLong);
      paramString2.append("]");
      QLog.w(paramString1, 1, paramString2.toString());
      return;
    }
    boolean bool1;
    if (localAVActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (localAVActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionDialog, issueType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], showNormalDialog[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], checkCameraResult[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("], checkRecordResult[");
    localStringBuilder.append(bool2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((!bool1) && (!bool2) && (paramInt == 2))
    {
      localAVActivity.requestPermissions(this, 0, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      this.jdField_k_of_type_Boolean = true;
      return;
    }
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return;
      }
      if (!bool2)
      {
        localAVActivity.requestPermissions(this, 2, new String[] { "android.permission.RECORD_AUDIO" });
        return;
      }
      if (paramBoolean) {
        b(paramLong, paramString1, paramString2);
      }
    }
    else
    {
      if (!bool1)
      {
        localAVActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
        this.jdField_k_of_type_Boolean = true;
        return;
      }
      if (paramBoolean) {
        b(paramLong, paramString1, paramString2);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      int i1;
      if (paramLong1 == 0L) {
        i1 = 2968;
      } else if (paramLong1 == 100L) {
        i1 = 7187;
      } else {
        i1 = (int)((float)paramLong1 * 4218.75F / 100.0F + 2968.75F);
      }
      if (QLog.isColorLevel())
      {
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doUpdateAudioVolumeChange nexValue:=");
        localStringBuilder.append(i1);
        QLog.d(str, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setAudioVolumeValue(i1);
    }
  }
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (h()) {
      return;
    }
    AVActivity localAVActivity = a();
    paramString1 = DialogUtil.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690728, new VideoControlUI.6(this, paramLong));
    int i1;
    if (UITools.a(localAVActivity)) {
      i1 = 2131695658;
    } else {
      i1 = 2131695659;
    }
    paramString1.setPositiveButton(i1, new VideoControlUI.5(this, paramLong)).show();
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  public abstract void a(long paramLong, boolean paramBoolean, int paramInt);
  
  void a(Boolean paramBoolean)
  {
    q(paramBoolean.booleanValue());
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a()
  {
    if ((a() != null) && (a().isShown())) {
      return a().a();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  boolean a(long paramLong, String paramString, View paramView)
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    int i1;
    if (((AVActivity)localObject).checkSelfPermission(paramString) == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString))
    {
      if ((i1 != 0) && (((AVActivity)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      i2 = 1;
    }
    else
    {
      i2 = 0;
    }
    if (i1 == 0)
    {
      if (a((Context)localObject))
      {
        paramView = new VideoControlUI.13(this, paramString, paramLong, paramView);
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSelfPermission, begin, permission[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mRequestPermissionIng[");
        localStringBuilder.append(this.jdField_p_of_type_Boolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
        this.jdField_p_of_type_Boolean = true;
        if (i2 == 0) {
          ((AVActivity)localObject).requestPermissions(paramView, 0, new String[] { paramString });
        } else {
          ((AVActivity)localObject).requestPermissions(paramView, 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
      }
      else
      {
        paramView = this.jdField_d_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkSelfPermission, fail, permission[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w(paramView, 1, ((StringBuilder)localObject).toString());
        e(paramLong, paramString);
      }
      return false;
    }
    return true;
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
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    a(a());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373628));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373629));
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373554));
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$QAVButtonOnTouchListener = new VideoControlUI.QAVButtonOnTouchListener(this);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setBtnOnTouchListener(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$QAVButtonOnTouchListener);
    this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener = new VideoControlUI.1(this);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new VideoControlUI.2(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369946));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369945));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    AVActivity localAVActivity = a();
    if (localAVActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)localAVActivity.findViewById(2131373595));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373546) != null) && (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373547) != null))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = new VideoNetStateBar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localAVActivity, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a();
    }
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365542));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373635));
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    Object localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    if (localObject != null) {
      ((SensorHelper)localObject).a(false);
    }
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, localAVActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    localObject = (ViewGroup)localAVActivity.findViewById(2131373321);
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView = new AvTipsView();
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (ViewGroup)localObject);
    this.jdField_a_of_type_ComTencentAvUiDeviceTipsController = new DeviceTipsController(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiDeviceTipsController.a((View)localObject);
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(2147475117);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131373632).setBackgroundColor(2145838842);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131373633).setBackgroundColor(2145838842);
    }
    new VideoControlUI.QavStatusBar(this.jdField_a_of_type_AndroidViewViewGroup).a(localAVActivity);
  }
  
  void b(int paramInt) {}
  
  void b(int paramInt, boolean paramBoolean)
  {
    QavPanel localQavPanel;
    if (paramInt != 2131373343)
    {
      if (paramInt != 2131373351)
      {
        if (paramInt != 2131373640) {
          return;
        }
        localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (localQavPanel != null) {
          localQavPanel.setViewEnable(2131373640, paramBoolean);
        }
      }
      else
      {
        localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
        if (localQavPanel != null)
        {
          localQavPanel.setViewEnable(2131373351, paramBoolean);
          this.jdField_b_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
        }
      }
    }
    else
    {
      localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (localQavPanel != null) {
        localQavPanel.setViewEnable(2131373343, paramBoolean);
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_m_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localObject != null) {
      ((VideoNetStateBar)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject != null) {
      ((AvTipsView)localObject).c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiDeviceTipsController;
    if (localObject != null) {
      ((DeviceTipsController)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).j())
    {
      QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (localQavPanel != null) {
        localQavPanel.setWaveVisibility(8);
      }
    }
    if ((((SessionInfo)localObject).f()) && (!((SessionInfo)localObject).jdField_e_of_type_Boolean) && (!((SessionInfo)localObject).j()) && (((SessionInfo)localObject).t()) && ((!NetworkUtil.isWifiConnected(null)) || (AudioHelper.a(0) == 1))) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1050);
    }
  }
  
  public void b(long paramLong, int paramInt) {}
  
  protected void b(long paramLong, View paramView) {}
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    Object localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionDialog, msg[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], title[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = a();
    paramString1 = DialogUtil.a((Context)localObject, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690728, new VideoControlUI.8(this, paramLong));
    int i1;
    if (UITools.a((Activity)localObject)) {
      i1 = 2131695658;
    } else {
      i1 = 2131695659;
    }
    paramString1 = paramString1.setPositiveButton(i1, new VideoControlUI.7(this, paramLong));
    if (((AVActivity)localObject).isResume()) {
      try
      {
        paramString1.show();
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog, crash", paramString1);
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
    boolean bool1 = h();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695337);
    Object localObject2;
    if (localObject1 == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_InviteMember, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    bool1 = WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = 8;
    if (bool1) {}
    StringBuilder localStringBuilder;
    for (;;)
    {
      bool1 = false;
      break label379;
      localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (((SessionInfo)localObject2).jdField_k_of_type_Int != 1044)
      {
        if ((((SessionInfo)localObject2).d != 3) && (((SessionInfo)localObject2).d != 4)) {
          break label307;
        }
        if (!QAVHrMeeting.a((SessionInfo)localObject2)) {
          break;
        }
        if (jdField_o_of_type_Boolean)
        {
          localObject2 = this.jdField_d_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBtn_InviteMember, isHrConf, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w((String)localObject2, 1, localStringBuilder.toString());
        }
      }
    }
    if (((this instanceof MultiVideoCtrlLayerUIBase)) && (((MultiVideoCtrlLayerUIBase)this).c())) {
      if (jdField_o_of_type_Boolean)
      {
        localObject2 = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_InviteMember, isFull, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
      }
    }
    for (;;)
    {
      bool1 = false;
      break label377;
      label307:
      if (!k()) {
        break;
      }
      if (jdField_o_of_type_Boolean)
      {
        localObject2 = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_InviteMember, isKeyguardLock, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
      }
    }
    bool1 = true;
    label377:
    i1 = 0;
    label379:
    ((OperationBtnItem)localObject1).b(bool1 ^ true);
    if (i1 == 0) {
      bool2 = true;
    }
    ((OperationBtnItem)localObject1).c(bool2);
    return bool1;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return 0;
    }
    int i2 = b();
    int i3 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299257);
    int i1;
    if (this.l)
    {
      i1 = i2 / 5;
      i1 = Math.max(this.y, 0) * i1;
      if (i1 > i2) {
        i1 = i2;
      } else if (i1 <= 0) {
        i1 = e();
      }
    }
    else
    {
      i1 = i2;
      if (this.jdField_h_of_type_Boolean)
      {
        i1 = i2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          i1 = i2;
          if (UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()) <= 320) {
            i1 = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297670) + i3;
          }
        }
      }
    }
    i2 = i1;
    if (j()) {
      i2 = i1 + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297977);
    }
    return i2;
  }
  
  public abstract void c(int paramInt);
  
  public void c(long paramLong)
  {
    this.jdField_m_of_type_Int = 5;
    B(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localObject != null) {
      ((VideoNetStateBar)localObject).g();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    if (localObject != null) {
      ((SensorHelper)localObject).b(false);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_d_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDetectNoDevicePermission, issueType[");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], isRequestCameraPermission[");
      ((StringBuilder)localObject).append(this.jdField_k_of_type_Boolean);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w(str1, 1, ((StringBuilder)localObject).toString());
    }
    this.z = paramInt;
    String str1 = "";
    this.jdField_f_of_type_JavaLangString = "";
    AVActivity localAVActivity = a();
    if (paramInt == 1)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求相机权限.2");
      str1 = localAVActivity.getString(2131695646);
      localObject = localAVActivity.getString(2131695647);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
      {
        this.jdField_f_of_type_JavaLangString = "0X8004892";
        this.jdField_g_of_type_JavaLangString = "0X8004893";
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1)
        {
          this.jdField_f_of_type_JavaLangString = "0X8004898";
          this.jdField_g_of_type_JavaLangString = "0X8004899";
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
      {
        this.jdField_f_of_type_JavaLangString = "0X800488C";
        this.jdField_g_of_type_JavaLangString = "0X800488D";
      }
      this.jdField_m_of_type_Boolean = true;
    }
    for (;;)
    {
      break;
      if (paramInt == 2)
      {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求相机权限.3");
        str1 = localAVActivity.getString(2131695646);
        localObject = localAVActivity.getString(2131695647);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
        {
          this.jdField_f_of_type_JavaLangString = "0X80049D3";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1) {
            this.jdField_f_of_type_JavaLangString = "0X80049D4";
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int == 1)
        {
          this.jdField_f_of_type_JavaLangString = "0X80049D1";
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
        {
          this.jdField_f_of_type_JavaLangString = "0X80049D2";
        }
        this.jdField_m_of_type_Boolean = false;
      }
      else
      {
        if (paramInt != 3) {
          break label639;
        }
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "请求麦克风权限.1");
        str1 = localAVActivity.getString(2131695656);
        localObject = localAVActivity.getString(2131695657);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().p())
        {
          this.jdField_f_of_type_JavaLangString = "0X800488F";
          this.jdField_g_of_type_JavaLangString = "0X8004890";
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1)
          {
            this.jdField_f_of_type_JavaLangString = "0X8004895";
            this.jdField_g_of_type_JavaLangString = "0X8004896";
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
        {
          this.jdField_f_of_type_JavaLangString = "0X8004889";
          this.jdField_g_of_type_JavaLangString = "0X800488A";
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
        {
          this.jdField_f_of_type_JavaLangString = "0X8004885";
          this.jdField_g_of_type_JavaLangString = "0X8004886";
        }
        this.jdField_m_of_type_Boolean = true;
      }
    }
    String str2 = this.jdField_f_of_type_JavaLangString;
    ReportController.b(null, "CliOper", "", "", str2, str2, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
    if (a(localAVActivity))
    {
      if ((paramInt == 2) && (this.jdField_k_of_type_Boolean)) {
        return;
      }
      a(paramLong, paramInt, str1, (String)localObject, true);
      return;
    }
    b(paramLong, str1, (String)localObject);
    return;
    label639:
    if ((paramInt == 4) && (localAVActivity != null))
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.i()) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3004);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().p()) {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int == 1) {
          str1 = "0X8004897";
        } else {
          str1 = "0X8004891";
        }
      }
      for (;;)
      {
        break;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
          str1 = "0X800488B";
        } else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
          str1 = "0X8004887";
        }
      }
      ReportController.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.jdField_h_of_type_JavaLangString, "");
      return;
    }
    if (paramInt == 2048) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Boolean = true;
    }
  }
  
  protected void c(long paramLong, String paramString)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    int i1 = UITools.b((Context)localObject);
    int i2 = UITools.a((Context)localObject);
    float f1 = UITools.a((Context)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adaptScreens[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], bottomBarHeight[");
      localStringBuilder.append(c());
      localStringBuilder.append("], topBarHeight[");
      localStringBuilder.append(a(paramLong));
      localStringBuilder.append("], density[");
      localStringBuilder.append(f1);
      localStringBuilder.append("], screenSize[");
      localStringBuilder.append(i2);
      localStringBuilder.append(", ");
      localStringBuilder.append(i1);
      localStringBuilder.append("], hasSmartBar[");
      localStringBuilder.append(j());
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().g == 11)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1015);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().g == 16)
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
    boolean bool1 = h();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695333);
    Object localObject2;
    if (localObject1 == null)
    {
      if (jdField_o_of_type_Boolean)
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_Camera, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    Object localObject3;
    if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
    {
      bool1 = bool2;
      if (jdField_o_of_type_Boolean)
      {
        localObject2 = this.jdField_d_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateBtn_Camera, GLVersion, seq[");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        bool1 = bool2;
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (((SessionInfo)localObject2).jdField_k_of_type_Int == 1044)
      {
        ((OperationBtnItem)localObject1).c(false);
        bool1 = bool2;
      }
      else
      {
        if ((((SessionInfo)localObject2).d != 1) && (((SessionInfo)localObject2).d != 2))
        {
          if ((((SessionInfo)localObject2).d == 3) || (((SessionInfo)localObject2).d == 4)) {
            if (((SessionInfo)localObject2).y)
            {
              if (!((SessionInfo)localObject2).z)
              {
                bool1 = bool2;
                if (!jdField_o_of_type_Boolean) {
                  break label826;
                }
                localObject2 = this.jdField_d_of_type_JavaLangString;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("updateBtn_Camera, not enter room for meeting, seq[");
                ((StringBuilder)localObject3).append(paramLong);
                ((StringBuilder)localObject3).append("]");
                QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
                bool1 = bool2;
                break label826;
              }
            }
            else if (!this.jdField_a_of_type_ComTencentAvVideoController.d)
            {
              bool1 = bool2;
              if (!jdField_o_of_type_Boolean) {
                break label826;
              }
              localObject2 = this.jdField_d_of_type_JavaLangString;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("updateBtn_Camera, 没有进入房间, seq[");
              ((StringBuilder)localObject3).append(paramLong);
              ((StringBuilder)localObject3).append("]");
              QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
              bool1 = bool2;
              break label826;
            }
          }
        }
        else
        {
          if ((((SessionInfo)localObject2).f()) || (((SessionInfo)localObject2).m()) || (((SessionInfo)localObject2).n())) {
            break label743;
          }
          if (!this.jdField_a_of_type_ComTencentAvVideoController.g())
          {
            bool1 = bool2;
            if (!jdField_o_of_type_Boolean) {
              break label826;
            }
            localObject2 = this.jdField_d_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateBtn_Camera, !canAVShift, seq[");
            ((StringBuilder)localObject3).append(paramLong);
            ((StringBuilder)localObject3).append("]");
            QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
            bool1 = bool2;
            break label826;
          }
        }
        if (!((SessionInfo)localObject2).jdField_o_of_type_Boolean)
        {
          bool1 = bool2;
          if (jdField_o_of_type_Boolean)
          {
            localObject2 = this.jdField_d_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateBtn_Camera, cameraPermission, seq[");
            ((StringBuilder)localObject3).append(paramLong);
            ((StringBuilder)localObject3).append("]");
            QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
            bool1 = bool2;
          }
        }
        else if (((SessionInfo)localObject2).aa == 0)
        {
          bool1 = bool2;
          if (jdField_o_of_type_Boolean)
          {
            localObject2 = this.jdField_d_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateBtn_Camera, mCameraAvailable, seq[");
            ((StringBuilder)localObject3).append(paramLong);
            ((StringBuilder)localObject3).append("]");
            QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
            bool1 = bool2;
          }
        }
        else if (CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isCameraOpening(paramLong))
        {
          bool1 = bool2;
          if (jdField_o_of_type_Boolean)
          {
            localObject2 = this.jdField_d_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateBtn_Camera, isCameraOpening, seq[");
            ((StringBuilder)localObject3).append(paramLong);
            ((StringBuilder)localObject3).append("]");
            QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = true;
          break label826;
          label743:
          bool1 = bool2;
          if (jdField_o_of_type_Boolean)
          {
            localObject3 = this.jdField_d_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateBtn_Camera, state[");
            localStringBuilder.append(((SessionInfo)localObject2).f);
            localStringBuilder.append("], seq[");
            localStringBuilder.append(paramLong);
            localStringBuilder.append("]");
            QLog.w((String)localObject3, 1, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
      }
    }
    label826:
    ((OperationBtnItem)localObject1).b(bool1 ^ true);
    if (jdField_o_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_Camera, enable[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return bool1;
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
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "register camera availability change receiver");
        }
        this.jdField_a_of_type_AndroidContentContext = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        if (localContext != null) {
          localContext.registerReceiver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver, localIntentFilter);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "CANNOT register camera availability change receiver!");
      }
    }
  }
  
  public abstract void d(int paramInt);
  
  public void d(long paramLong)
  {
    this.jdField_m_of_type_Int = 6;
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject != null)
    {
      ((AvTipsView)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiDeviceTipsController;
    if (localObject != null)
    {
      ((DeviceTipsController)localObject).e();
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler;
    if (localObject != null)
    {
      ((VideoControlUI.DelayTipsHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler = null;
    }
    B(paramLong);
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$TimmerRunnable);
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b((Observer)localObject);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$SubControlUIObserver = null;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    if (localObject != null) {
      ((SensorHelper)localObject).a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver != null)) {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
        }
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI$CameraAvailabilityReceiver = null;
        this.jdField_a_of_type_AndroidContentContext = null;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localObject != null)
    {
      ((QavPanel)localObject).a(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeAllViews();
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
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localObject != null)
    {
      ((VideoNetStateBar)localObject).c();
      this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar = null;
    }
  }
  
  abstract void d(long paramLong, View paramView);
  
  void d(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setConnectInfo, str[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramString);
      UITools.a(this.jdField_e_of_type_AndroidWidgetTextView, paramString);
    }
    localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramString);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localObject != null) {
      ((VideoNetStateBar)localObject).a(paramString);
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public boolean d(long paramLong)
  {
    boolean bool1 = h();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695336);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131695346);
    if ((localObject1 == null) && (localObject2 == null)) {
      return false;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo.r())
    {
      if (localObject1 != null) {
        ((OperationBtnItem)localObject1).c(false);
      }
      if (localObject2 != null) {
        ((OperationBtnItem)localObject2).c(false);
      }
      return false;
    }
    boolean bool3 = EffectsRenderController.b();
    if (bool3) {
      bool1 = CameraUtils.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isCameraOpening(paramLong) ^ true;
    } else {
      bool1 = false;
    }
    if (localSessionInfo.j)
    {
      if (localObject1 != null)
      {
        if (!bool1) {
          bool2 = true;
        }
        ((OperationBtnItem)localObject1).b(bool2);
        ((OperationBtnItem)localObject1).a(bool1);
        ((OperationBtnItem)localObject1).c(bool3);
      }
      if (localObject2 != null) {
        ((OperationBtnItem)localObject2).c(bool3 ^ true);
      }
    }
    else
    {
      if (localObject2 != null)
      {
        ((OperationBtnItem)localObject2).b(false);
        ((OperationBtnItem)localObject2).a(true);
        ((OperationBtnItem)localObject2).c(true);
      }
      if (localObject1 != null) {
        ((OperationBtnItem)localObject1).c(false);
      }
    }
    if (localObject2 != null) {
      ((OperationBtnItem)localObject2).b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().u);
    }
    if (jdField_o_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_EffectAndVoice, enable[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], enableAE[");
      ((StringBuilder)localObject2).append(bool3);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return true;
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
    Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if ((localObject != null) && (((QavPanel)localObject).isPressed())) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mVideoController is null, Why???");
      }
      return;
    }
    localObject = ((VideoController)localObject).a();
    if ((((SessionInfo)localObject).jdField_k_of_type_Int == 9500) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_n_of_type_Boolean)) {
      return;
    }
    if (this.j) {
      return;
    }
    if ((!((SessionInfo)localObject).j()) && (((SessionInfo)localObject).d == 2)) {
      return;
    }
    boolean bool = this.jdField_h_of_type_Boolean;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchToolBar-->mRootView is null Why");
      }
      return;
    }
    if (((SessionInfo)localObject).r()) {
      p(this.jdField_h_of_type_Boolean ^ true);
    } else if ((!((SessionInfo)localObject).j) && (!((SessionInfo)localObject).jdField_k_of_type_Boolean) && (!((SessionInfo)localObject).y)) {
      p(true);
    } else if (((SessionInfo)localObject).d == 1) {
      p(true);
    } else if ((((SessionInfo)localObject).d == 3) && (!((SessionInfo)localObject).y)) {
      p(true);
    } else if (DoodleLogic.a().a.jdField_a_of_type_Boolean) {
      p(true);
    } else {
      p(this.jdField_h_of_type_Boolean ^ true);
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToolBar, ToolbarDisplay[");
    localStringBuilder.append(bool);
    localStringBuilder.append("->");
    localStringBuilder.append(this.jdField_h_of_type_Boolean);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    SmallScreenUtils.a();
    if (this.jdField_h_of_type_Boolean)
    {
      TipsUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_d_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("WL_DEBUG switchToolBar mQavPanel.isShown()[");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown());
          localStringBuilder.append("], mTopToolbar.isShown()[");
          localStringBuilder.append(this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown());
          localStringBuilder.append("]");
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
        if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.isShown()) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.isShown())) {
          return;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (localObject != null) {
        ((QavPanel)localObject).setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.s += 1;
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG switchToolBar type=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", toolbarShowTimes: ");
        localStringBuilder.append(this.s);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = a(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = a(true);
      }
      else
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772181);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772217);
      }
    }
    else
    {
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.getRootView().findViewById(2131373442)).setVisibility(4);
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = a(false);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = a(false);
      }
      else
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772180);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772216);
      }
    }
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
    if (!VcSystemInfo.isLowLevelDevice())
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (localObject != null) {
        ((QavPanel)localObject).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(true), Long.valueOf(0L) });
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ToolbarAnimationListener;
    if (localObject != null) {
      ((VideoControlUI.ToolbarAnimationListener)localObject).onAnimationEnd(null);
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.jdField_h_of_type_Boolean), Boolean.valueOf(false), Long.valueOf(0L) });
    }
  }
  
  public void e(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
    if (localObject != null) {
      ((SensorHelper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localObject != null) {
      ((QavPanel)localObject).setWaveVisibility(8);
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
      str = localAVActivity.getString(2131695646);
      paramString = localAVActivity.getString(2131695647);
    }
    else if ("android.permission.RECORD_AUDIO".equals(paramString))
    {
      str = localAVActivity.getString(2131695656);
      paramString = localAVActivity.getString(2131695657);
    }
    else
    {
      if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
        return;
      }
      str = localAVActivity.getString(2131695654);
      paramString = localAVActivity.getString(2131695655);
    }
    a(paramLong, str, paramString);
  }
  
  void e(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView;
    if (localObject != null) {
      ((AvTipsView)localObject).b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiDeviceTipsController;
    if (localObject != null) {
      ((DeviceTipsController)localObject).d();
    }
  }
  
  public void f(int paramInt) {}
  
  public void f(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131695347, paramLong);
    if (localOperationBtnItem != null) {
      localOperationBtnItem.c(false);
    }
  }
  
  @TargetApi(21)
  public void f(long paramLong, View paramView)
  {
    paramView = SessionMgr.a().a();
    if (!paramView.v())
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
      }
      ScreenShareCtrl.a(7);
      return;
    }
    ScreenShareReportHelper.a(paramView.jdField_b_of_type_JavaLangString, 2, "onClick_ScreenShare");
    l(paramLong, 2131695339);
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
      String str1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, this.jdField_e_of_type_JavaLangString, str1);
      if (QLog.isColorLevel())
      {
        String str2 = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate, switchToGaudio, mAudioSesstionType[");
        localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
        localStringBuilder.append("], deviceName[");
        localStringBuilder.append(str1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str2, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, str1);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void g() {}
  
  public void g(int paramInt) {}
  
  protected void g(long paramLong) {}
  
  public void g(long paramLong, View paramView)
  {
    if (h()) {
      return;
    }
    C(paramLong);
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    paramView.a(paramLong, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9005), paramView });
    if (paramView.jdField_a_of_type_Boolean)
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_More, mBlockName[");
      localStringBuilder.append(paramView.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], seq");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else if (this.jdField_a_of_type_ComTencentAvUiQavPanel.b(1))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 1, true);
    }
    a().g(paramLong);
  }
  
  public void g(String paramString)
  {
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideToolBar[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isToolBarDisplay[");
    localStringBuilder.append(i());
    localStringBuilder.append("], mToolbarDisplay[");
    localStringBuilder.append(this.jdField_h_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.jdField_h_of_type_Boolean) {
      e(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
  }
  
  public void g(boolean paramBoolean)
  {
    j(paramBoolean);
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
    paramView = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_ScreenShot, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(paramView, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new VideoControlUI.12(this, l1, paramLong));
    paramView = a();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)) {
      paramView.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h(l1);
    }
    DataReport.ScreenShot.a();
  }
  
  void h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setChatTime, time[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131364477);
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramString);
      if (UITools.jdField_a_of_type_Boolean)
      {
        if (TextUtils.isEmpty(paramString))
        {
          UITools.a((View)localObject, "");
          return;
        }
        UITools.a((View)localObject, UITools.a(paramString));
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    if ((localAVActivity != null) && (localAVActivity.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null))
    {
      int i1;
      if (paramBoolean) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      localAVActivity.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(i1);
    }
  }
  
  public boolean h()
  {
    return this.jdField_m_of_type_Int == 6;
  }
  
  public void i() {}
  
  public void i(int paramInt)
  {
    if (paramInt == 1037) {
      paramInt = 256;
    } else {
      paramInt = 257;
    }
    VideoControlUI.DelayTipsHandler localDelayTipsHandler = this.jdField_a_of_type_ComTencentAvUiVideoControlUI$DelayTipsHandler;
    if (localDelayTipsHandler != null) {
      localDelayTipsHandler.removeMessages(paramInt);
    }
  }
  
  protected void i(long paramLong) {}
  
  public void i(long paramLong, int paramInt)
  {
    if (!h())
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
        return;
      }
      jdField_o_of_type_Boolean = AudioHelper.b();
      if ((paramInt & 0x1) == 1) {
        F(paramLong);
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
        L(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        G(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        b(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        M(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        E(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        H(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        K(paramLong);
      }
      if ((paramInt & 0x1000) == 4096) {
        l(paramLong);
      }
      if ((paramInt & 0x2000) == 8192) {
        D(paramLong);
      }
      if ((paramInt & 0x4000) == 16384) {
        f(paramLong);
      }
      if ((paramInt & 0x8000) == 32768) {
        I(paramLong);
      }
      if ((paramInt & 0x10000) == 65536) {
        J(paramLong);
      }
      h(paramLong);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.g();
      if (jdField_o_of_type_Boolean)
      {
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn, sessionInfo[");
        localStringBuilder.append(localSessionInfo);
        localStringBuilder.append("], screenStyle[");
        localStringBuilder.append(localSessionInfo.L);
        localStringBuilder.append("], remoteHasVideo[");
        localStringBuilder.append(localSessionInfo.jdField_k_of_type_Boolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
    }
  }
  
  void i(long paramLong, View paramView)
  {
    DataReport.f();
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 1);
    paramView.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    String str;
    StringBuilder localStringBuilder;
    if (paramView.jdField_a_of_type_Boolean)
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Voice, mBlockName[");
      localStringBuilder.append(paramView.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Voice, mEffectBtnID[");
      localStringBuilder.append(paramView.jdField_b_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, paramView.jdField_b_of_type_Int);
    }
    l(paramLong, 2131695336);
  }
  
  void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
  }
  
  public boolean i()
  {
    Object localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if ((localObject != null) && (((QavPanel)localObject).getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public void j() {}
  
  void j(int paramInt)
  {
    b(a(this.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt));
  }
  
  void j(long paramLong, int paramInt)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != paramInt))
      {
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisibility_ConnectInfoView_MiddleCenter, visibility[");
        localStringBuilder.append(this.jdField_e_of_type_AndroidWidgetTextView.getVisibility());
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void j(long paramLong, View paramView)
  {
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    String str;
    StringBuilder localStringBuilder;
    if (paramView.jdField_a_of_type_Boolean)
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Effect, mBlockName[");
      localStringBuilder.append(paramView.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Effect, mEffectBtnID[");
      localStringBuilder.append(paramView.jdField_b_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, paramView.jdField_b_of_type_Int);
    }
    l(paramLong, 2131695336);
  }
  
  void j(boolean paramBoolean)
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
  
  public void k() {}
  
  void k(int paramInt)
  {
    if (paramInt != 2131373351) {
      return;
    }
    QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localQavPanel != null)
    {
      localQavPanel.a(2131373351, this.jdField_a_of_type_AndroidContentResResources.getString(2131692829));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, true);
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    }
  }
  
  public abstract void k(long paramLong);
  
  void k(long paramLong, int paramInt)
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != paramInt))
      {
        String str = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisibility_ConnectInfoView_TopCenter, visibility[");
        localStringBuilder.append(this.jdField_f_of_type_AndroidWidgetTextView.getVisibility());
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  public void k(long paramLong, View paramView)
  {
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 2);
    paramView.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9003), paramView });
    String str;
    StringBuilder localStringBuilder;
    if (paramView.jdField_a_of_type_Boolean)
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_VirtualBackground, mBlockName[");
      localStringBuilder.append(paramView.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_VirtualBackground, mEffectBtnID[");
      localStringBuilder.append(paramView.jdField_b_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 4, true);
    }
    l(paramLong, 2131695345);
    AVUtil.a("0X800ADA9", 0, 0, "", "", "", "");
  }
  
  public void k(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.b(paramBoolean);
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
          if (QLog.isColorLevel())
          {
            str = this.jdField_d_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isKeyguardLocked = ");
            localStringBuilder.append(localKeyguardManager.isKeyguardLocked());
            localStringBuilder.append(". isKeyguardSecure =");
            localStringBuilder.append(localKeyguardManager.isKeyguardSecure());
            QLog.e(str, 2, localStringBuilder.toString());
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
          String str;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            str = this.jdField_d_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isKeyguardLocked() = ");
            localStringBuilder.append(localSecurityException);
            QLog.e(str, 2, localStringBuilder.toString());
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
    if (paramInt != 2131373351) {
      return;
    }
    QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localQavPanel != null)
    {
      localQavPanel.a(2131373351, this.jdField_a_of_type_AndroidContentResResources.getString(2131692821));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, false);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    }
  }
  
  public void l(long paramLong)
  {
    if ((QLog.isColorLevel()) && (paramLong == -1052L)) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateBtn_ScreenShare");
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    OperationBtnItem localOperationBtnItem = a(2131695339, paramLong);
    if (localOperationBtnItem != null)
    {
      if (localContext == null) {
        return;
      }
      if (!QAVConfigUtils.k())
      {
        localOperationBtnItem.c(false);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!WTogetherUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))) {
        localOperationBtnItem.c(true);
      } else {
        localOperationBtnItem.c(false);
      }
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if (localSessionInfo.jdField_k_of_type_Int == 1044)
      {
        localOperationBtnItem.c(false);
        localOperationBtnItem.a(false);
        return;
      }
      if ((localSessionInfo.X != 2) && (localSessionInfo.X != 1))
      {
        localOperationBtnItem.a(2130842089);
        localOperationBtnItem.a(localContext.getResources().getString(2131695339));
        return;
      }
      localOperationBtnItem.a(2130842090);
      localOperationBtnItem.a(localContext.getResources().getString(2131695340));
    }
  }
  
  void l(long paramLong, int paramInt)
  {
    if ((2131695338 != paramInt) && (2131695336 != paramInt) && (2131695345 != paramInt)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, true);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.c(paramBoolean);
    }
  }
  
  void m() {}
  
  public void m(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void m(long paramLong)
  {
    this.jdField_m_of_type_Int = 4;
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.f();
    }
  }
  
  public void m(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.a(paramBoolean);
    }
  }
  
  public void n() {}
  
  public void n(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.d(paramBoolean);
    }
  }
  
  public void o() {}
  
  public void o(boolean paramBoolean)
  {
    a(i(), paramBoolean);
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(170), Boolean.valueOf(this.jdField_h_of_type_Boolean) });
    }
  }
  
  public void q(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject == null) {
      return;
    }
    localObject = ((ViewGroup)localObject).findViewById(2131373647);
    if (localObject == null) {
      return;
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
  }
  
  protected void r(boolean paramBoolean)
  {
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramBoolean ^ true, 3000L);
  }
  
  public void s(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean) {
      localTextView.setVisibility(0);
    } else {
      localTextView.setVisibility(8);
    }
    AudioHelper.jdField_b_of_type_Boolean = paramBoolean;
    g(paramBoolean);
  }
  
  public void t() {}
  
  public void u() {}
  
  protected void y(long paramLong) {}
  
  protected void z(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */