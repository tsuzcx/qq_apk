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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavAvatar2dEntranceABTestUtils;
import com.tencent.av.abtest.QavEffectUIABTestUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.api.IDoodleApi;
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
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
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
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Observer;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public abstract class VideoControlUI
{
  static int bf = -1;
  public static boolean br = false;
  static boolean bv = false;
  final String X;
  int Y = 0;
  int Z = 0;
  private boolean a = false;
  QavPanel aA = null;
  RelativeLayout aB = null;
  RelativeLayout aC = null;
  VideoControlUI.QAVButtonOnTouchListener aD;
  VideoNetStateBar aE = null;
  QavPanel.onReciveQavPanelStatusChangeListener aF;
  Animation aG = null;
  Animation aH = null;
  VideoControlUI.ShowSharpInfoRunnable aI = null;
  int aJ = 0;
  Toast aK = null;
  VideoControlUI.ToolbarAnimationListener aL = null;
  VideoControlUI.ToolbarAnimationListener aM = null;
  ImageView aN = null;
  RingAnimator aO = null;
  View aP = null;
  TraeHelper aQ = null;
  SensorHelper aR = null;
  Context aS = null;
  protected boolean aT = false;
  boolean aU = false;
  int aV = 0;
  float aW = 0.0F;
  int aX = 0;
  int aY = 0;
  public boolean aZ = false;
  int aa = 0;
  int ab = 0;
  public int ac = 0;
  int ad = 0;
  boolean ae = false;
  public boolean af = true;
  int ag = 0;
  String ah = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  VideoControlUI.TimmerRunnable ai = null;
  Resources aj = null;
  WeakReference<Context> ak = null;
  public VideoAppInterface al = null;
  public VideoController am = null;
  ViewGroup an = null;
  ControlUIObserver ao;
  VideoControlUI.SubControlUIObserver ap;
  OrientationEventListener aq = null;
  QQFrameByFrameAnimation ar = null;
  TextView as = null;
  TextView at = null;
  LinearLayout au = null;
  TextView av = null;
  GestureDetector aw = null;
  RelativeLayout ax = null;
  RelativeLayout ay = null;
  View az = null;
  private VideoControlUI.DelayTipsHandler b;
  AvTipsView ba;
  protected boolean bb = false;
  protected boolean bc = false;
  protected boolean bd = false;
  QQAnimationListener be = new VideoControlUI.3(this);
  Runnable bg = new VideoControlUI.4(this);
  public int bh = 0;
  public boolean bi = false;
  VideoControlUI.ToolbarAnimationRunnable bj = new VideoControlUI.ToolbarAnimationRunnable(this);
  public String bk;
  public String bl;
  boolean bm = true;
  public int bn = 0;
  public String bo;
  View.OnTouchListener bp;
  GestureDetector.OnGestureListener bq;
  public final int bs;
  public final int bt;
  public final long bu;
  public boolean bw;
  private boolean c = true;
  private boolean d = false;
  private int e = 0;
  private VideoControlUI.CameraAvailabilityReceiver f;
  
  public VideoControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(".");
    localStringBuilder.append(Build.MODEL);
    this.bo = localStringBuilder.toString();
    this.bp = new VideoControlUI.9(this);
    this.bq = new VideoControlUI.10(this);
    this.f = null;
    this.bs = 256;
    this.bt = 257;
    this.bu = 1500L;
    this.bw = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.c());
    this.X = localStringBuilder.toString();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.X, 1, "VideoControlUI");
    }
    this.al = paramVideoAppInterface;
    this.ak = new WeakReference(paramAVActivity);
    this.an = paramViewGroup;
    this.ap = new VideoControlUI.SubControlUIObserver(this);
    this.al.a(this.ap);
    this.b = new VideoControlUI.DelayTipsHandler(this, Looper.getMainLooper());
    paramVideoAppInterface = U();
    if (paramVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "VideoControlUI-->can not get AVActivity");
      }
      return;
    }
    this.aj = paramVideoAppInterface.getResources();
    if (this.aj == null)
    {
      AVLog.printAllUserLog(this.X, "mRes is null. exit video progress");
      paramAVActivity = new StringBuilder();
      paramAVActivity.append(paramVideoAppInterface.getString(2131917844));
      paramAVActivity.append(" 0x08");
      paramAVActivity = paramAVActivity.toString();
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.am = this.al.b();
    if (this.am == null)
    {
      AVLog.printAllUserLog(this.X, "mVideoController is null. exit video progress");
      paramAVActivity = new StringBuilder();
      paramAVActivity.append(this.aj.getString(2131917844));
      paramAVActivity.append(" 0x09");
      paramAVActivity = paramAVActivity.toString();
      Toast.makeText(paramVideoAppInterface.getApplicationContext(), paramAVActivity, 0).show();
      paramVideoAppInterface.finish();
      return;
    }
    this.ao = paramControlUIObserver;
    this.aV = this.aj.getDimensionPixelSize(2131298667);
    this.aW = this.aj.getDimension(2131298669);
    this.aX = this.aj.getDimensionPixelSize(2131298670);
    this.aY = this.aj.getDimensionPixelSize(2131298685);
  }
  
  private int a()
  {
    int i;
    if ((!this.bi) && (!this.af)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return d();
    }
    return s();
  }
  
  public static int a(SessionInfo paramSessionInfo, int paramInt)
  {
    int i = 2131893591;
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
                    i = 2131893587;
                    break;
                  case 54: 
                    i = 2131893586;
                  }
                  break;
                case 50: 
                case 51: 
                case 52: 
                  i = 2131893590;
                  break;
                }
              }
              i = 2131893508;
            }
          }
          else {
            i = 2131893588;
          }
        }
        else {
          i = 2131893465;
        }
      }
      else if (!paramSessionInfo.Q) {
        i = 2131893589;
      }
    }
    else {
      i = 2131917866;
    }
    if (paramSessionInfo.p == 1011)
    {
      if (paramInt == 9) {
        return 2131917846;
      }
      i = 2131893177;
    }
    return i;
  }
  
  private void a(int paramInt)
  {
    AVActivity localAVActivity = U();
    if (localAVActivity != null) {
      localAVActivity.getLayoutInflater().inflate(paramInt, this.an);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = U();
    Window localWindow;
    int i;
    int j;
    if ((Build.VERSION.SDK_INT >= 19) && (localObject != null))
    {
      localWindow = ((AVActivity)localObject).getWindow();
      if (localWindow != null)
      {
        if ((paramBoolean1) && (paramBoolean2)) {
          i = 1;
        } else {
          i = 0;
        }
        j = i;
        if (i != 0) {}
      }
    }
    try
    {
      localObject = ((AVActivity)localObject).findViewById(2131441034);
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((View)localObject).isShown()) {
          j = 1;
        }
      }
      if (br) {
        j = 1;
      }
      if (j != 0) {
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
      if (j == 0) {
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
  
  protected static boolean ad()
  {
    if (bf == -1) {
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        bf = 0;
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
      int i;
      break label60;
    }
    bool = false;
    if (Build.DEVICE.equals("mx2")) {
      bool = true;
    } else if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
      bool = false;
    }
    if (bool) {
      i = 1;
    } else {
      i = 0;
    }
    bf = i;
    return bf == 1;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.an;
    if (localObject == null) {
      return;
    }
    localObject = ((ViewGroup)localObject).findViewById(2131441319);
    if (localObject == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
  }
  
  private int d()
  {
    return this.aj.getDimensionPixelSize(2131298340);
  }
  
  private void e(long paramLong, int paramInt)
  {
    if (V()) {
      return;
    }
    if ((!CameraUtils.a(this.aS).isCameraOpening(paramLong)) && (!CameraUtils.a(this.aS).isCameraOpened(paramLong)))
    {
      this.am.k().co = paramInt;
      f(paramLong, 16777215);
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableCameraRelatedBtn, cameraAvailable[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], already opening or opened");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool = B();
    Object localObject1;
    if (bv)
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_CameraExpImage, null, localHasVideo[");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (ImageButton)this.aA.e(2131441300);
    int j = ((Integer)((ImageButton)localObject2).getTag()).intValue();
    if (bool) {
      localObject1 = CameraUtils.a;
    } else {
      localObject1 = CameraUtils.b;
    }
    int k = ((Integer)localObject1).intValue();
    int i;
    if (!bool) {
      i = 2130843059;
    } else {
      i = 2130843060;
    }
    if (j != k)
    {
      ((ImageButton)localObject2).setImageDrawable(((ImageButton)localObject2).getResources().getDrawable(i));
      ((ImageButton)localObject2).setTag(new Integer(k));
    }
    if (paramBoolean)
    {
      paramBoolean = X(-1L);
      this.aA.setViewEnable(2131441300, paramBoolean);
    }
  }
  
  private int s()
  {
    RelativeLayout localRelativeLayout = this.aA.k(99);
    if (localRelativeLayout != null)
    {
      localRelativeLayout.measure(0, 0);
      return localRelativeLayout.getMeasuredHeight();
    }
    return 0;
  }
  
  private boolean t()
  {
    return Build.MODEL.equalsIgnoreCase("Redmi Note 4");
  }
  
  private boolean u()
  {
    return this.am.k().p == 1044;
  }
  
  protected long A()
  {
    return 0L;
  }
  
  protected boolean B()
  {
    return false;
  }
  
  protected boolean C()
  {
    return false;
  }
  
  protected void D(long paramLong) {}
  
  protected boolean D()
  {
    return false;
  }
  
  protected void E(long paramLong) {}
  
  protected void F(long paramLong) {}
  
  public void G(long paramLong)
  {
    if (this.ae) {
      return;
    }
    int i = this.Y;
    if (i >= 2)
    {
      if (i > 4) {
        return;
      }
      if ((VideoLayerUIBase.b(this.am.k())) && (!r())) {
        return;
      }
      if (QLog.isColorLevel())
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startTimer, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.ae = true;
      if (this.ai == null) {
        this.ai = new VideoControlUI.TimmerRunnable(this);
      }
      this.al.a().postDelayed(this.ai, 0L);
      d(paramLong, null);
    }
  }
  
  public void H(long paramLong)
  {
    if (!this.ae) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopTimer, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.ae = false;
    if (this.ai != null)
    {
      this.al.a().removeCallbacks(this.ai);
      this.ai = null;
    }
    i(null);
  }
  
  public void I(long paramLong)
  {
    if (V()) {
      return;
    }
    boolean bool1 = QLog.isDevelopLevel();
    Object localObject1 = this.am.k();
    int i = ((SessionInfo)localObject1).g;
    boolean bool2 = ((SessionInfo)localObject1).r();
    Object localObject2 = U();
    if (bool2)
    {
      this.al.a().removeCallbacks(this.bg);
      this.al.a().postDelayed(this.bg, 6000L);
      if (bool1)
      {
        localObject1 = HardCodeUtil.a(2131913326);
        break label325;
      }
    }
    else if ((localObject2 != null) && (((AVActivity)localObject2).j()))
    {
      this.al.a().removeCallbacks(this.bg);
      if (bool1)
      {
        localObject1 = "isKeepToolBar";
        break label325;
      }
    }
    else if ((i != 2) && (i != 4))
    {
      if (((i == 1) || (i == 3)) && (!((SessionInfo)localObject1).cw))
      {
        this.al.a().removeCallbacks(this.bg);
        if (!this.af) {
          f(0);
        }
      }
    }
    else
    {
      this.al.a().removeCallbacks(this.bg);
      if (this.af) {
        if ((i == 2) && (!((SessionInfo)localObject1).j()))
        {
          if (bool1)
          {
            localObject1 = "not Connected";
            break label325;
          }
        }
        else if ((i == 4) && (((SessionInfo)localObject1).q()))
        {
          if (bool1)
          {
            localObject1 = "not Recv Data";
            break label325;
          }
        }
        else
        {
          if ((this.aA.W != 5) && (paramLong != -1056L)) {
            this.al.a().postDelayed(this.bg, 6000L);
          }
          if (bool1)
          {
            localObject1 = HardCodeUtil.a(2131913326);
            break label325;
          }
        }
      }
    }
    localObject1 = "";
    label325:
    if (QLog.isDevelopLevel())
    {
      localObject2 = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetToolBarTimer, mToolbarDisplay[");
      localStringBuilder.append(this.af);
      localStringBuilder.append("], SessionType[");
      localStringBuilder.append(i);
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
  
  public int J(long paramLong)
  {
    Object localObject = this.an;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    if (this.aB == null) {
      return 0;
    }
    int j = this.aj.getDimensionPixelSize(2131300031);
    this.an.getRootView().findViewById(2131441295);
    if (this.af)
    {
      if (this.bi)
      {
        i = j / 5;
        i = Math.max(this.bh, 0) * i;
      }
      else
      {
        i = j;
      }
      i += ap();
    }
    localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTopToolbarHeight, topToolbarHeight[");
    localStringBuilder.append(i);
    localStringBuilder.append("], margin[");
    localStringBuilder.append(j);
    localStringBuilder.append("], mInToolBarAnimation[");
    localStringBuilder.append(this.bi);
    localStringBuilder.append("], mToolbarDisplayFrameNow[");
    localStringBuilder.append(this.bh);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    return i;
  }
  
  public void K(long paramLong)
  {
    Object localObject = a(2131893086, paramLong);
    if (localObject == null) {
      return;
    }
    boolean bool3 = EffectsRenderController.c();
    SessionInfo localSessionInfo = this.am.k();
    boolean bool2 = AVUtil.a();
    boolean bool1 = true;
    if ((!bool2) && (!WTogetherUtil.a(this.al)) && (!QavEffectUIABTestUtils.b(this.al.getCurrentAccountUin())) && (bool3) && (AEFilterSupport.a() > 3))
    {
      bool2 = CameraUtils.a((Context)this.ak.get()).isCameraOpening(paramLong) ^ true;
    }
    else
    {
      bool2 = false;
      bool1 = false;
    }
    if (localSessionInfo.H)
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
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_VirtualBackground, visible[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], enable[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], enableAE[");
      localStringBuilder.append(bool3);
      localStringBuilder.append("], localHasVideo[");
      localStringBuilder.append(localSessionInfo.H);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void L(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131893076, paramLong);
    if (localOperationBtnItem == null) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    boolean bool2 = ((IDoodleApi)QRoute.api(IDoodleApi.class)).isDoodleUsable();
    boolean bool1;
    if ((QavEffectUIABTestUtils.b(this.al.getCurrentAccountUin())) && (localSessionInfo.H)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localOperationBtnItem.b(bool2 ^ true);
    localOperationBtnItem.a(bool1);
    localOperationBtnItem.c(bool1);
  }
  
  void M(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject = this.am.k();
    boolean bool = this.bc;
    int j = 8;
    int i;
    StringBuilder localStringBuilder;
    if (bool)
    {
      i = j;
    }
    else if (!EffectsRenderController.c())
    {
      i = j;
      if (bv)
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, !isEnableAEModuleManager, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i = j;
      }
    }
    else if (!((SessionInfo)localObject).H)
    {
      i = j;
      if (bv)
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, !localHasVideo, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i = j;
      }
    }
    else if (!PtuResChecker.a().b())
    {
      i = j;
      if (bv)
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i = j;
      }
    }
    else if (!AEFilterSupport.a(2))
    {
      i = j;
      if (bv)
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Beauty, AEKitSo not ready, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    this.aA.d(i);
    if (bv)
    {
      localObject = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_Beauty, show[");
      localStringBuilder.append(i);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  void N(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject = this.am.k();
    int i = ((SessionInfo)localObject).g;
    boolean bool = false;
    StringBuilder localStringBuilder;
    if ((i == 1) && (!((SessionInfo)localObject).j()))
    {
      j = 8;
      i = j;
      if (bv)
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_More, !isConnected, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    int j = this.aA.g(2131441304);
    this.aA.setViewVisibility(2131441304, i);
    localObject = U();
    if ((j != i) && (localObject != null))
    {
      if (i == 0) {
        bool = true;
      }
      ((AVActivity)localObject).a(bool);
      ((AVActivity)localObject).a(paramLong, 2131441304, j, i);
    }
    if (bv)
    {
      localObject = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_More, show[");
      localStringBuilder.append(i);
      localStringBuilder.append("], lastvisibility[");
      localStringBuilder.append(j);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  void O(long paramLong)
  {
    if (V()) {
      return;
    }
    int i;
    if ((this.am.k().cw) && (this.am.k().cv)) {
      i = 1;
    } else {
      i = 0;
    }
    QavPanel localQavPanel = this.aA;
    if (i != 0) {
      i = 0;
    } else {
      i = 8;
    }
    localQavPanel.setViewVisibility(2131441301, i);
    if (this.bc)
    {
      d(true, true);
      return;
    }
    if (this.bd) {
      d(true, false);
    }
  }
  
  void P(long paramLong)
  {
    if (V()) {
      return;
    }
    QavPanel localQavPanel = this.aA;
    int i;
    if (this.bc) {
      i = 0;
    } else {
      i = 8;
    }
    localQavPanel.setViewVisibility(2131441308, i);
  }
  
  boolean Q(long paramLong)
  {
    boolean bool1 = V();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1 = this.aA.c(2131893078);
    Object localObject2;
    if (localObject1 == null)
    {
      if (bv)
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_InviteMember, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    bool1 = WTogetherUtil.a(this.al);
    int i = 8;
    if (bool1) {}
    StringBuilder localStringBuilder;
    for (;;)
    {
      bool1 = false;
      break label379;
      localObject2 = this.am.k();
      if (((SessionInfo)localObject2).p != 1044)
      {
        if ((((SessionInfo)localObject2).g != 3) && (((SessionInfo)localObject2).g != 4)) {
          break label307;
        }
        if (!QAVHrMeeting.a((SessionInfo)localObject2)) {
          break;
        }
        if (bv)
        {
          localObject2 = this.X;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBtn_InviteMember, isHrConf, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w((String)localObject2, 1, localStringBuilder.toString());
        }
      }
    }
    if (((this instanceof MultiVideoCtrlLayerUIBase)) && (((MultiVideoCtrlLayerUIBase)this).t())) {
      if (bv)
      {
        localObject2 = this.X;
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
      if (!af()) {
        break;
      }
      if (bv)
      {
        localObject2 = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_InviteMember, isKeyguardLock, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
      }
    }
    bool1 = true;
    label377:
    i = 0;
    label379:
    ((OperationBtnItem)localObject1).b(bool1 ^ true);
    if (i == 0) {
      bool2 = true;
    }
    ((OperationBtnItem)localObject1).c(bool2);
    return bool1;
  }
  
  void R(long paramLong)
  {
    if (V()) {
      return;
    }
    if ((this.am.k().H) && (this.ac > 1) && (!this.bc))
    {
      this.aA.setViewVisibility(2131441310, 0);
      return;
    }
    this.aA.setViewVisibility(2131441310, 8);
  }
  
  void S(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject2 = this.aA.c(2131893085);
    if (localObject2 == null)
    {
      if (bv)
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_VideoMode, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject1 = this.am.k();
    int i = 2130843224;
    if (((SessionInfo)localObject1).bM == 4) {
      i = 2130843223;
    }
    ((OperationBtnItem)localObject2).a(i);
    boolean bool;
    if ((!((SessionInfo)localObject1).H) && (!((SessionInfo)localObject1).I)) {
      bool = false;
    } else {
      bool = true;
    }
    ((OperationBtnItem)localObject2).c(bool);
    if (bv)
    {
      localObject2 = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_VideoMode, bShow[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], screenStyle[");
      localStringBuilder.append(((SessionInfo)localObject1).bM);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
  }
  
  protected void T(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131893084, paramLong);
    if (localOperationBtnItem == null) {
      return;
    }
    localOperationBtnItem.c(WTogetherUtil.a(this.al) ^ true);
  }
  
  protected boolean T()
  {
    return true;
  }
  
  public AVActivity U()
  {
    WeakReference localWeakReference = this.ak;
    if (localWeakReference == null) {
      return null;
    }
    if ((localWeakReference.get() instanceof AVActivity)) {
      return (AVActivity)localWeakReference.get();
    }
    return null;
  }
  
  protected void U(long paramLong)
  {
    Object localObject = a(2131893074, paramLong);
    if (localObject == null) {
      return;
    }
    boolean bool = SessionMgr.a().b().r() ^ true;
    ((OperationBtnItem)localObject).c(bool);
    if (QLog.isDevelopLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtn_ChatRoom, visible[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 4, localStringBuilder.toString());
    }
  }
  
  public void V(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject = this.aA.c(2131893072);
    if (localObject == null)
    {
      if (bv)
      {
        localObject = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_AIDenoise null, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      return;
    }
    boolean bool = SharedPreUtils.b();
    int i = this.am.k().g;
    int j = 2130842975;
    if ((i != 1) && (this.am.k().g != 2))
    {
      if (this.am.k().g != 3)
      {
        i = j;
        if (this.am.k().g != 4) {}
      }
      else
      {
        i = j;
        if (!SharedPreUtils.d()) {}
      }
    }
    else {
      do
      {
        i = 2130842976;
        break;
        i = j;
      } while (SharedPreUtils.c());
    }
    ((OperationBtnItem)localObject).a(i);
    ((OperationBtnItem)localObject).c(bool);
  }
  
  public boolean V()
  {
    return this.Y == 6;
  }
  
  public void W()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "onPauseAudio");
    }
  }
  
  void W(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject1 = this.aA.c(2131893082);
    if (localObject1 == null)
    {
      if (bv)
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_ScreenShot, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = this.am.k();
    boolean bool3 = ((SessionInfo)localObject2).r();
    int j = 8;
    boolean bool1 = ((SessionInfo)localObject2).af;
    boolean bool2 = false;
    int i = j;
    if (!bool1)
    {
      i = j;
      if (!bool3) {
        if (((SessionInfo)localObject2).g != 4)
        {
          i = j;
          if (((SessionInfo)localObject2).g != 2) {}
        }
        else
        {
          i = 0;
        }
      }
    }
    boolean bool4 = t();
    bool1 = bool2;
    if (!bool4)
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    ((OperationBtnItem)localObject1).c(bool1);
    if (bv)
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_ScreenShot, visible[");
      ((StringBuilder)localObject2).append(i);
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
  
  public void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.X, 2, "onResumeAudio");
    }
  }
  
  protected boolean X(long paramLong)
  {
    boolean bool1 = V();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1;
    Object localObject2;
    if (Utils.a(this.al.getApp()) == 1)
    {
      bool1 = bool2;
      if (bv)
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getCameraEnable, GLVersion, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        bool1 = bool2;
      }
    }
    else
    {
      localObject1 = this.am.k();
      if (((SessionInfo)localObject1).p == 1044)
      {
        bool1 = bool2;
      }
      else
      {
        if ((((SessionInfo)localObject1).g != 1) && (((SessionInfo)localObject1).g != 2))
        {
          if ((((SessionInfo)localObject1).g == 3) || (((SessionInfo)localObject1).g == 4)) {
            if (((SessionInfo)localObject1).am)
            {
              if (!((SessionInfo)localObject1).an)
              {
                bool1 = bool2;
                if (!bv) {
                  break label744;
                }
                localObject1 = this.X;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("getCameraEnable, not enter room for meeting, seq[");
                ((StringBuilder)localObject2).append(paramLong);
                ((StringBuilder)localObject2).append("]");
                QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
                bool1 = bool2;
                break label744;
              }
            }
            else if (!this.am.j)
            {
              bool1 = bool2;
              if (!bv) {
                break label744;
              }
              localObject1 = this.X;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getCameraEnable, 没有进入房间, seq[");
              ((StringBuilder)localObject2).append(paramLong);
              ((StringBuilder)localObject2).append("]");
              QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
              bool1 = bool2;
              break label744;
            }
          }
        }
        else
        {
          if ((((SessionInfo)localObject1).f()) || (((SessionInfo)localObject1).m()) || (((SessionInfo)localObject1).n())) {
            break label661;
          }
          if (!this.am.n())
          {
            bool1 = bool2;
            if (!bv) {
              break label744;
            }
            localObject1 = this.X;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getCameraEnable, !canAVShift, seq[");
            ((StringBuilder)localObject2).append(paramLong);
            ((StringBuilder)localObject2).append("]");
            QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            bool1 = bool2;
            break label744;
          }
        }
        if (!((SessionInfo)localObject1).N)
        {
          bool1 = bool2;
          if (bv)
          {
            localObject1 = this.X;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getCameraEnable, cameraPermission, seq[");
            ((StringBuilder)localObject2).append(paramLong);
            ((StringBuilder)localObject2).append("]");
            QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            bool1 = bool2;
          }
        }
        else if (((SessionInfo)localObject1).co == 0)
        {
          bool1 = bool2;
          if (bv)
          {
            localObject1 = this.X;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getCameraEnable, mCameraAvailable, seq[");
            ((StringBuilder)localObject2).append(paramLong);
            ((StringBuilder)localObject2).append("]");
            QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            bool1 = bool2;
          }
        }
        else if (CameraUtils.a((Context)this.ak.get()).isCameraOpening(paramLong))
        {
          bool1 = bool2;
          if (bv)
          {
            localObject1 = this.X;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getCameraEnable, isCameraOpening, seq[");
            ((StringBuilder)localObject2).append(paramLong);
            ((StringBuilder)localObject2).append("]");
            QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = true;
          break label744;
          label661:
          bool1 = bool2;
          if (bv)
          {
            localObject2 = this.X;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getCameraEnable, state[");
            localStringBuilder.append(((SessionInfo)localObject1).i);
            localStringBuilder.append("], seq[");
            localStringBuilder.append(paramLong);
            localStringBuilder.append("]");
            QLog.w((String)localObject2, 1, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
      }
    }
    label744:
    if (bv)
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCameraEnable, enable[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public void Y()
  {
    VideoControlUI.DelayTipsHandler localDelayTipsHandler = this.b;
    if (localDelayTipsHandler != null)
    {
      localDelayTipsHandler.removeMessages(256);
      this.b.removeMessages(257);
    }
  }
  
  protected boolean Y(long paramLong)
  {
    boolean bool3 = V();
    boolean bool5 = false;
    if (bool3) {
      return false;
    }
    SessionInfo localSessionInfo = this.am.k();
    boolean bool2 = localSessionInfo.r() ^ true;
    boolean bool1;
    if (EffectsRenderController.c()) {
      bool1 = CameraUtils.a((Context)this.ak.get()).isCameraOpening(paramLong) ^ true;
    } else {
      bool1 = false;
    }
    int i;
    if ((localSessionInfo.g == 1) && (!localSessionInfo.j()))
    {
      if (bv)
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_EffectAndVoiceExternal, state[");
        localStringBuilder.append(localSessionInfo.i);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      i = 0;
    }
    else
    {
      i = 1;
    }
    this.aA.c(localSessionInfo.H);
    if ((bool2) && (bool1)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4 = bool5;
    if (bool2)
    {
      bool4 = bool5;
      if (i != 0) {
        bool4 = true;
      }
    }
    this.aA.setViewEnable(2131440994, bool3);
    this.aA.setViewEnable(2131441323, bool4);
    if (localSessionInfo.H) {
      return bool3;
    }
    return bool4;
  }
  
  void Z()
  {
    if (this.aN != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "setScreenDarken");
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      this.aN.setVisibility(0);
      this.aN.startAnimation(localAlphaAnimation);
    }
  }
  
  protected boolean Z(long paramLong)
  {
    boolean bool1 = V();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject1 = this.aA.c(2131893077);
    Object localObject2 = this.aA.c(2131893087);
    if ((localObject1 == null) && (localObject2 == null)) {
      return false;
    }
    SessionInfo localSessionInfo = this.am.k();
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
    boolean bool3 = EffectsRenderController.c();
    if (bool3) {
      bool1 = CameraUtils.a((Context)this.ak.get()).isCameraOpening(paramLong) ^ true;
    } else {
      bool1 = false;
    }
    if ((!QavAvatar2dEntranceABTestUtils.a(this.al.getCurrentAccountUin())) && (!localSessionInfo.H))
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
    else
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
    if (localObject2 != null) {
      ((OperationBtnItem)localObject2).b(this.al.b().k().bV);
    }
    if (bv)
    {
      localObject1 = this.X;
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
  
  public OperationBtnItem a(int paramInt, long paramLong)
  {
    if (V()) {
      return null;
    }
    StringBuilder localStringBuilder;
    if ((Context)this.ak.get() == null)
    {
      if (bv)
      {
        localObject = this.X;
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
    Object localObject = this.aA.c(paramInt);
    if (localObject == null)
    {
      if (bv)
      {
        localObject = this.X;
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
  
  public void a(int paramInt1, int paramInt2) {}
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aK != null)
    {
      int i = Build.VERSION.SDK_INT;
      if ((i != 14) && (i != 15)) {
        this.aK.cancel();
      }
    }
    this.aK = null;
    Context localContext = (Context)this.ak.get();
    if (localContext != null)
    {
      if (paramInt3 == 0) {}
      try
      {
        this.aK = QQToast.makeText(localContext, paramInt1, paramInt2).show();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showToast-->can not show toast-->e=");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
      this.aK = QQToast.makeText(localContext, paramInt1, paramInt2).show(paramInt3);
      return;
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.aK != null)
    {
      int i = Build.VERSION.SDK_INT;
      if ((i != 14) && (i != 15)) {
        this.aK.cancel();
      }
    }
    this.aK = null;
    Context localContext = (Context)this.ak.get();
    if (localContext != null)
    {
      if (paramInt4 == 0) {}
      try
      {
        this.aK = QQToast.makeText(localContext, paramInt2, paramInt1, paramInt3).show();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showToast-->can not show toast-->e=");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
      this.aK = QQToast.makeText(localContext, paramInt2, paramInt1, paramInt3).show(paramInt4);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    VideoNetStateBar localVideoNetStateBar = this.aE;
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
    VideoControlUI.DelayTipsHandler localDelayTipsHandler = this.b;
    if (localDelayTipsHandler != null)
    {
      localDelayTipsHandler.removeMessages(paramInt);
      paramString = this.b.obtainMessage(paramInt, paramString);
      this.b.sendMessageDelayed(paramString, 1500L);
    }
  }
  
  public void a(long paramLong)
  {
    this.Y = 2;
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.d();
    }
    this.aZ = false;
  }
  
  void a(long paramLong, float paramFloat)
  {
    AvTipsView localAvTipsView = this.ba;
    if (localAvTipsView != null) {
      localAvTipsView.a(paramLong, paramFloat);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (V()) {
      return;
    }
    Object localObject = this.am.k();
    if (QLog.isColorLevel())
    {
      String str = this.X;
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
      l(paramInt);
    }
    else
    {
      if ((paramInt == 25) || (paramInt == 56)) {
        l(paramInt);
      }
      m();
    }
    localObject = this.aR;
    if (localObject != null) {
      ((SensorHelper)localObject).a(false);
    }
    if (SmallScreenUtils.g())
    {
      localObject = this.aA;
      if (localObject != null)
      {
        ((QavPanel)localObject).setViewEnable(2131441023, false);
        this.aA.setViewEnable(2131441014, false);
        this.aA.setViewEnable(2131441020, false);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void a(long paramLong, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AVActivity localAVActivity = U();
    if (localAVActivity == null) {
      return;
    }
    if (!localAVActivity.isResume())
    {
      paramString1 = this.X;
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
    String str = this.X;
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
      this.aZ = true;
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
        this.aZ = true;
        return;
      }
      if (paramBoolean) {
        b(paramLong, paramString1, paramString2);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (!this.d)
    {
      int i;
      if (paramLong1 == 0L) {
        i = 2968;
      } else if (paramLong1 == 100L) {
        i = 7187;
      } else {
        i = (int)((float)paramLong1 * 4218.75F / 100.0F + 2968.75F);
      }
      if (QLog.isColorLevel())
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doUpdateAudioVolumeChange nexValue:=");
        localStringBuilder.append(i);
        QLog.d(str, 1, localStringBuilder.toString());
      }
      this.aA.setAudioVolumeValue(i);
    }
  }
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (V()) {
      return;
    }
    AVActivity localAVActivity = U();
    paramString1 = DialogUtil.a(localAVActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131887648, new VideoControlUI.6(this, paramLong));
    int i;
    if (UITools.b(localAVActivity)) {
      i = 2131893417;
    } else {
      i = 2131893418;
    }
    paramString1.setPositiveButton(i, new VideoControlUI.5(this, paramLong)).show();
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  public abstract void a(long paramLong, boolean paramBoolean, int paramInt);
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(Context paramContext, boolean paramBoolean, String paramString) {}
  
  protected void a(Boolean paramBoolean)
  {
    b(paramBoolean.booleanValue());
    if (C()) {
      ar();
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  boolean a(long paramLong, String paramString, View paramView)
  {
    return a(paramLong, paramString, paramView, null);
  }
  
  boolean a(long paramLong, String paramString, View paramView, QQPermissionCallback paramQQPermissionCallback)
  {
    Object localObject = U();
    if (localObject == null) {
      return false;
    }
    int i;
    if (((AVActivity)localObject).checkSelfPermission(paramString) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString))
    {
      if ((i != 0) && (((AVActivity)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (i == 0)
    {
      if (VideoUtil.a((Context)localObject))
      {
        paramView = new VideoControlUI.13(this, paramQQPermissionCallback, paramString, paramLong, paramView);
        paramQQPermissionCallback = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSelfPermission, begin, permission[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mRequestPermissionIng[");
        localStringBuilder.append(this.bw);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(paramQQPermissionCallback, 1, localStringBuilder.toString());
        this.bw = true;
        if (j == 0) {
          ((AVActivity)localObject).requestPermissions(paramView, 0, new String[] { paramString });
        } else {
          ((AVActivity)localObject).requestPermissions(paramView, 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
      }
      else
      {
        paramView = this.X;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkSelfPermission, fail, permission[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w(paramView, 1, ((StringBuilder)localObject).toString());
        if (paramQQPermissionCallback != null) {
          break label326;
        }
        e(paramLong, paramString);
      }
      return false;
      label326:
      paramQQPermissionCallback.deny(-1, new String[] { paramString }, new int[] { -1 });
      return false;
    }
    return true;
  }
  
  public boolean a(long paramLong, boolean paramBoolean, String paramString)
  {
    return false;
  }
  
  public void aA_() {}
  
  public void aB_()
  {
    boolean bool = as();
    TextView localTextView1 = (TextView)this.aA.e(2131428836);
    TextView localTextView2 = (TextView)this.aA.e(2131449444);
    if (localTextView1 != null)
    {
      if (localTextView2 == null) {
        return;
      }
      if (bool)
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        return;
      }
      localTextView1.setVisibility(0);
      localTextView2.setVisibility(8);
    }
  }
  
  public void a_(long paramLong)
  {
    this.Y = 4;
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.f();
    }
  }
  
  void a_(long paramLong, int paramInt)
  {
    if (paramInt > 0)
    {
      d(paramLong, this.aj.getString(paramInt));
      return;
    }
    d(paramLong, null);
  }
  
  void aa()
  {
    this.ar = new QQFrameByFrameAnimation();
    this.ar.a(100);
    this.ar.b(8);
    this.ar.a(new int[] { 2130842970, 2130842971 });
    this.ar.a(this.be);
  }
  
  void aa(long paramLong)
  {
    if (V()) {
      return;
    }
    if (!this.am.m())
    {
      this.aA.setViewEnable(2131441014, false);
      return;
    }
    this.aA.setViewEnable(2131441014, true);
  }
  
  void ab(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject1 = this.aA.c(2131893075);
    if (localObject1 == null)
    {
      if (bv)
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_ControlMember, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = this.am.k();
    int j = ((SessionInfo)localObject2).g;
    int i = 8;
    boolean bool2 = false;
    if ((j != 1) && (((SessionInfo)localObject2).g != 2))
    {
      if ((((SessionInfo)localObject2).g == 3) || (((SessionInfo)localObject2).g == 4))
      {
        if (((!((SessionInfo)localObject2).bg) && (!((SessionInfo)localObject2).bh)) || (QAVHrMeeting.a((SessionInfo)localObject2))) {
          break label195;
        }
        if (!this.am.j)
        {
          bool1 = false;
          break label190;
        }
      }
      bool1 = true;
      label190:
      i = 0;
      break label198;
    }
    label195:
    boolean bool1 = false;
    label198:
    ((OperationBtnItem)localObject1).b(bool1 ^ true);
    ((OperationBtnItem)localObject1).a(bool1);
    if (i == 0) {
      bool2 = true;
    }
    ((OperationBtnItem)localObject1).c(bool2);
    if (bv)
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateBtn_ControlMember, enable[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], visible[");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public boolean ab()
  {
    Object localObject = this.aB;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0))
    {
      localObject = this.aA;
      if ((localObject != null) && (((QavPanel)localObject).getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  void ac()
  {
    if ((this.am.k().p == 9500) && (this.am.ab)) {
      this.al.a().removeCallbacks(this.bg);
    }
  }
  
  public int ae()
  {
    if (this.an == null) {
      return 0;
    }
    if (this.aA == null) {
      return 0;
    }
    int j = a();
    int k = this.aj.getDimensionPixelSize(2131300013);
    int i;
    if (this.bi)
    {
      i = j / 5;
      i = Math.max(this.bh, 0) * i;
      if (i > j) {
        i = j;
      } else if (i <= 0) {
        i = d();
      }
    }
    else
    {
      i = j;
      if (this.af)
      {
        i = j;
        if (this.ak.get() != null)
        {
          i = j;
          if (UITools.a((Context)this.ak.get()) <= 320) {
            i = this.aj.getDimensionPixelSize(2131298335) + k;
          }
        }
      }
    }
    j = i;
    if (ad()) {
      j = i + this.aj.getDimensionPixelSize(2131298647);
    }
    return j;
  }
  
  @TargetApi(16)
  public boolean af()
  {
    if (this.ak.get() != null)
    {
      Context localContext = (Context)this.ak.get();
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
          if (QLog.isColorLevel())
          {
            str = this.X;
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
            str = this.X;
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
  
  public void ag()
  {
    TipsUtil.a(this.al);
  }
  
  public void ah()
  {
    TipsUtil.b(this.al);
  }
  
  public void ai()
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("displayToolBar, isToolBarDisplay[");
      localStringBuilder.append(ab());
      localStringBuilder.append("], mApp[");
      boolean bool;
      if (this.al != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.al == null) {
      return;
    }
    if (!ab())
    {
      s(false);
      f(0);
    }
    this.al.a().removeCallbacks(this.bg);
  }
  
  void aj()
  {
    if (V()) {
      return;
    }
    QavPanel localQavPanel = this.aA;
    if (localQavPanel != null)
    {
      localQavPanel.setViewEnable(2131441023, false);
      this.aA.setViewEnable(2131441014, false);
      this.aA.setViewEnable(2131441020, false);
      this.aA.setViewEnable(2131441016, false);
      this.aA.setViewEnable(2131441017, false);
      this.aA.setViewEnable(2131441018, false);
    }
  }
  
  public void ak()
  {
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.h();
    }
  }
  
  public QavPanel al()
  {
    return this.aA;
  }
  
  public QavEffectBaseMenuView am()
  {
    if (this.aA != null)
    {
      if (QavEffectUIABTestUtils.b(this.al.getCurrentAccountUin())) {
        return (QavEffectBaseMenuView)this.aA.k(5);
      }
      return (QavEffectBaseMenuView)this.aA.k(2);
    }
    return null;
  }
  
  void an() {}
  
  public void ao()
  {
    a(ab(), true);
  }
  
  public int ap()
  {
    if ((new VideoControlUI.QavStatusBar(this.an).a()) && (this.ak.get() != null)) {
      return ImmersiveUtils.getStatusBarHeight((Context)this.ak.get());
    }
    return 0;
  }
  
  public void aq()
  {
    Object localObject = this.aA.c(2131893072);
    if (localObject == null) {
      return;
    }
    View localView = this.aA.a((OperationBtnItem)localObject);
    if (localView != null)
    {
      if ((this.am.k().g != 1) && (this.am.k().g != 2))
      {
        if ((this.am.k().g != 3) && (this.am.k().g != 4)) {
          localObject = "";
        } else if (SharedPreUtils.d()) {
          localObject = this.aj.getString(2131893235);
        } else {
          localObject = this.aj.getString(2131893197);
        }
      }
      else if (SharedPreUtils.c()) {
        localObject = this.aj.getString(2131893235);
      } else {
        localObject = this.aj.getString(2131893197);
      }
      localView.setContentDescription((CharSequence)localObject);
    }
  }
  
  protected void ar()
  {
    e(true);
  }
  
  public boolean as()
  {
    SessionInfo localSessionInfo = this.am.k();
    boolean bool;
    if ((localSessionInfo.g != 4) && (localSessionInfo.g != 2) && (!localSessionInfo.cw) && (!localSessionInfo.cv)) {
      bool = false;
    } else {
      bool = true;
    }
    if (localSessionInfo.r()) {
      bool = false;
    }
    return bool;
  }
  
  void at()
  {
    int i = this.Z;
    if (i - this.ab > 2)
    {
      this.ab = i;
      this.aa = 0;
    }
    this.aa += 1;
    if (this.aa > 5)
    {
      this.aa = 0;
      this.ab = 0;
      u(true);
    }
  }
  
  protected abstract int b();
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    QavPanel localQavPanel;
    if (paramInt != 2131441014)
    {
      if (paramInt != 2131441023)
      {
        if (paramInt != 2131441310) {
          return;
        }
        localQavPanel = this.aA;
        if (localQavPanel != null) {
          localQavPanel.setViewEnable(2131441310, paramBoolean);
        }
      }
      else
      {
        localQavPanel = this.aA;
        if (localQavPanel != null)
        {
          localQavPanel.setViewEnable(2131441023, paramBoolean);
          this.c = paramBoolean;
          this.aA.a(this.c, this.d);
        }
      }
    }
    else
    {
      localQavPanel = this.aA;
      if (localQavPanel != null) {
        localQavPanel.setViewEnable(2131441014, paramBoolean);
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.Y = 3;
    if (this.am == null) {
      return;
    }
    Object localObject = this.aE;
    if (localObject != null) {
      ((VideoNetStateBar)localObject).e();
    }
    localObject = this.ba;
    if (localObject != null) {
      ((AvTipsView)localObject).c(this.al);
    }
    localObject = this.am.k();
    if (((SessionInfo)localObject).j())
    {
      QavPanel localQavPanel = this.aA;
      if (localQavPanel != null) {
        localQavPanel.setWaveVisibility(8);
      }
    }
    if ((((SessionInfo)localObject).f()) && (!((SessionInfo)localObject).B) && (!((SessionInfo)localObject).j()) && (((SessionInfo)localObject).t()) && ((!NetworkUtil.isWifiConnected(null)) || (AudioHelper.a(0) == 1))) {
      TipsUtil.a(this.al, 1050);
    }
  }
  
  public void b(long paramLong, int paramInt) {}
  
  protected void b(long paramLong, View paramView) {}
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    if (this.ak == null) {
      return;
    }
    Object localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionDialog, msg[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], title[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = U();
    paramString1 = DialogUtil.a((Context)localObject, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131887648, new VideoControlUI.8(this, paramLong));
    int i;
    if (UITools.b((Activity)localObject)) {
      i = 2131893417;
    } else {
      i = 2131893418;
    }
    paramString1 = paramString1.setPositiveButton(i, new VideoControlUI.7(this, paramLong));
    if (((AVActivity)localObject).isResume()) {
      try
      {
        paramString1.show();
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d(this.X, 1, "showPermissionDialog, crash", paramString1);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  protected void b(long paramLong, boolean paramBoolean, int paramInt)
  {
    e(false);
    if (this.bc) {
      paramInt = 8;
    }
    if (u())
    {
      paramBoolean = false;
      paramInt = 8;
    }
    this.aA.setViewVisibility(2131441300, paramInt);
    this.aA.setViewEnable(2131441300, paramBoolean);
    Object localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateBtn_CameraExp, null, enable[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.aA.c(2131893073);
    if (localObject != null) {
      ((OperationBtnItem)localObject).c(false);
    }
  }
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected boolean b_(long paramLong)
  {
    boolean bool1 = C();
    boolean bool2 = X(paramLong);
    SessionInfo localSessionInfo = this.am.k();
    int i;
    if ((localSessionInfo.g == 1) && (!localSessionInfo.j())) {
      i = 8;
    } else {
      i = 0;
    }
    if (bool1)
    {
      b(paramLong, bool2, i);
      return bool2;
    }
    c(paramLong, bool2, i);
    return bool2;
  }
  
  void c()
  {
    if (this.an == null) {
      return;
    }
    a(b());
    this.aB = ((RelativeLayout)this.an.findViewById(2131441294));
    this.aC = ((RelativeLayout)this.an.getRootView().findViewById(2131441295));
    this.aA = ((QavPanel)this.an.findViewById(2131441227));
    this.aD = new VideoControlUI.QAVButtonOnTouchListener(this);
    this.aA.setBtnOnTouchListener(this.aD);
    this.aF = new VideoControlUI.1(this);
    this.aA.a(this.aF);
    this.aA.setOperationMenuViewOnClickListener(new VideoControlUI.2(this));
    this.ax = ((RelativeLayout)this.an.findViewById(2131437095));
    this.ay = ((RelativeLayout)this.an.findViewById(2131437094));
    this.ay.setVisibility(8);
    this.az = this.an.findViewById(2131441317);
    AVActivity localAVActivity = U();
    if (localAVActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.av = ((TextView)localAVActivity.findViewById(2131441260));
    this.aw = new GestureDetector((Context)this.ak.get(), this.bq);
    this.av.setOnTouchListener(this.bp);
    this.av.setMovementMethod(ScrollingMovementMethod.getInstance());
    if ((this.an.findViewById(2131441219) != null) && (this.an.findViewById(2131441220) != null))
    {
      this.aE = new VideoNetStateBar(this.al, localAVActivity, this.an);
      this.aE.a();
    }
    this.at = ((TextView)this.an.findViewById(2131431769));
    this.as = ((TextView)this.an.findViewById(2131441303));
    this.aQ = TraeHelper.a();
    this.aA.a(this.aQ);
    Object localObject = this.aR;
    if (localObject != null) {
      ((SensorHelper)localObject).a(false);
    }
    this.aR = SensorHelper.a(this.aR, localAVActivity, this.am, this.aQ);
    this.aR.a(true);
    this.aQ.b();
    localObject = (ViewGroup)localAVActivity.findViewById(2131440990);
    this.ba = new AvTipsView();
    this.ba.a(this.al, (ViewGroup)localObject);
    if (AudioHelper.a(0) == 1)
    {
      this.aB.setBackgroundColor(2147475117);
      this.aC.setBackgroundColor(2147475117);
      this.aB.findViewById(2131441298).setBackgroundColor(2145838842);
      this.aC.findViewById(2131441299).setBackgroundColor(2145838842);
    }
    new VideoControlUI.QavStatusBar(this.an).a(localAVActivity);
  }
  
  void c(int paramInt) {}
  
  public void c(long paramLong)
  {
    this.Y = 5;
    H(paramLong);
    Object localObject = this.aE;
    if (localObject != null) {
      ((VideoNetStateBar)localObject).g();
    }
    localObject = this.aR;
    if (localObject != null) {
      ((SensorHelper)localObject).b(false);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      str1 = this.X;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDetectNoDevicePermission, issueType[");
      ((StringBuilder)localObject).append(this.bn);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], isRequestCameraPermission[");
      ((StringBuilder)localObject).append(this.aZ);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w(str1, 1, ((StringBuilder)localObject).toString());
    }
    this.bn = paramInt;
    String str1 = "";
    this.bk = "";
    AVActivity localAVActivity = U();
    if (paramInt == 1)
    {
      QLog.w(this.X, 1, "请求相机权限.2");
      str1 = localAVActivity.getString(2131893405);
      localObject = localAVActivity.getString(2131893406);
      if (this.am.k().p())
      {
        this.bk = "0X8004892";
        this.bl = "0X8004893";
        if (this.am.k().p == 1)
        {
          this.bk = "0X8004898";
          this.bl = "0X8004899";
        }
      }
      else if (this.am.k().g == 2)
      {
        this.bk = "0X800488C";
        this.bl = "0X800488D";
      }
      this.bm = true;
    }
    for (;;)
    {
      break;
      if (paramInt == 2)
      {
        QLog.w(this.X, 1, "请求相机权限.3");
        str1 = localAVActivity.getString(2131893405);
        localObject = localAVActivity.getString(2131893406);
        if (this.am.k().p())
        {
          this.bk = "0X80049D3";
          if (this.am.k().p == 1) {
            this.bk = "0X80049D4";
          }
        }
        else if (this.am.k().h == 1)
        {
          this.bk = "0X80049D1";
        }
        else if (this.am.k().g == 2)
        {
          this.bk = "0X80049D2";
        }
        this.bm = false;
      }
      else
      {
        if (paramInt != 3) {
          break label639;
        }
        QLog.w(this.X, 1, "请求麦克风权限.1");
        str1 = localAVActivity.getString(2131893415);
        localObject = localAVActivity.getString(2131893416);
        if (this.am.k().p())
        {
          this.bk = "0X800488F";
          this.bl = "0X8004890";
          if (this.am.k().p == 1)
          {
            this.bk = "0X8004895";
            this.bl = "0X8004896";
          }
        }
        else if (this.am.k().g == 2)
        {
          this.bk = "0X8004889";
          this.bl = "0X800488A";
        }
        else if (this.am.k().g == 1)
        {
          this.bk = "0X8004885";
          this.bl = "0X8004886";
        }
        this.bm = true;
      }
    }
    String str2 = this.bk;
    ReportController.b(null, "CliOper", "", "", str2, str2, 0, 0, "", "", this.bo, "");
    if (VideoUtil.a(localAVActivity))
    {
      if ((paramInt == 2) && (this.aZ)) {
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
      if (!this.am.H()) {
        TipsUtil.a(this.al, 3004);
      }
      if (this.am.k().p()) {
        if (this.am.k().p == 1) {
          str1 = "0X8004897";
        } else {
          str1 = "0X8004891";
        }
      }
      for (;;)
      {
        break;
        if (this.am.k().g == 2) {
          str1 = "0X800488B";
        } else if (this.am.k().g == 1) {
          str1 = "0X8004887";
        }
      }
      ReportController.b(null, "CliOper", "", "", str1, str1, 0, 0, "", "", this.bo, "");
      return;
    }
    if (paramInt == 2048) {
      this.am.k().O = true;
    }
  }
  
  protected void c(long paramLong, String paramString)
  {
    Object localObject = U();
    if (localObject == null) {
      return;
    }
    int i = UITools.b((Context)localObject);
    int j = UITools.a((Context)localObject);
    float f1 = UITools.c((Context)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adaptScreens[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], bottomBarHeight[");
      localStringBuilder.append(ae());
      localStringBuilder.append("], topBarHeight[");
      localStringBuilder.append(J(paramLong));
      localStringBuilder.append("], density[");
      localStringBuilder.append(f1);
      localStringBuilder.append("], screenSize[");
      localStringBuilder.append(j);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      localStringBuilder.append("], hasSmartBar[");
      localStringBuilder.append(ad());
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public abstract void c(long paramLong, boolean paramBoolean);
  
  protected void c(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.aA.c(2131893073);
    if (localObject == null)
    {
      if (bv)
      {
        localObject = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Camera, null, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      return;
    }
    boolean bool1 = u();
    boolean bool2 = false;
    if (bool1) {
      paramBoolean = false;
    }
    if (this.bc) {
      paramBoolean = false;
    }
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((OperationBtnItem)localObject).c(bool1);
    bool1 = bool2;
    if (!paramBoolean) {
      bool1 = true;
    }
    ((OperationBtnItem)localObject).b(bool1);
    ((OperationBtnItem)localObject).a(paramBoolean);
  }
  
  public void c(Intent paramIntent) {}
  
  public void c(String paramString)
  {
    if (this.am.k().j == 11)
    {
      TipsUtil.a(this.al, 1015);
      return;
    }
    if (this.am.k().j == 16)
    {
      TipsUtil.a(this.al, 1061);
      return;
    }
    TipsUtil.b(this.al, 1047);
  }
  
  public void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public abstract void d(int paramInt);
  
  public void d(long paramLong)
  {
    this.Y = 6;
    Object localObject = this.ba;
    if (localObject != null)
    {
      ((AvTipsView)localObject).a(this.al);
      this.ba = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((VideoControlUI.DelayTipsHandler)localObject).removeCallbacksAndMessages(null);
      this.b = null;
    }
    H(paramLong);
    localObject = this.al;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).a().removeCallbacks(this.bj);
      this.al.a().removeCallbacks(this.bg);
      this.al.a().removeCallbacks(this.ai);
      localObject = this.ap;
      if (localObject != null)
      {
        this.al.b((Observer)localObject);
        this.ap = null;
      }
    }
    localObject = this.aR;
    if (localObject != null) {
      ((SensorHelper)localObject).a(false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.f != null)) {
      if (this.aS != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.X, 2, "UnRegister camera availability change receiver");
        }
        this.aS.unregisterReceiver(this.f);
        this.f = null;
        this.aS = null;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(this.X, 2, "CANNOT UnRegister camera availability change receiver!!");
      }
    }
    localObject = this.aA;
    if (localObject != null)
    {
      ((QavPanel)localObject).a(paramLong);
      this.aA = null;
    }
    this.aj = null;
    this.ak = null;
    this.al = null;
    this.am = null;
    localObject = this.an;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeAllViews();
      this.an = null;
    }
    this.aq = null;
    this.ar = null;
    this.aG = null;
    this.aH = null;
    this.aK = null;
    this.aB = null;
    this.aC = null;
    this.aL = null;
    this.aM = null;
    this.aN = null;
    this.aP = null;
    this.ai = null;
    this.ao = null;
    this.as = null;
    this.at = null;
    this.aO = null;
    this.be = null;
    this.aR = null;
    this.aQ = null;
    localObject = this.aE;
    if (localObject != null)
    {
      ((VideoNetStateBar)localObject).c();
      this.aE = null;
    }
  }
  
  abstract void d(long paramLong, View paramView);
  
  void d(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setConnectInfo, str[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.as;
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramString);
      UITools.a(this.as, paramString);
    }
    localObject = this.at;
    if (localObject != null) {
      ((TextView)localObject).setText(paramString);
    }
    localObject = this.aE;
    if (localObject != null) {
      ((VideoNetStateBar)localObject).a(paramString);
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean1, boolean paramBoolean2) {}
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.X, 1, "showPermissionDialog deniedForAudioRecord(2) 04");
  }
  
  @QQPermissionDenied(1)
  public void deniedForCamera()
  {
    QLog.d(this.X, 1, "showPermissionDialog deniedForCamera(1) 02");
  }
  
  @QQPermissionDenied(0)
  public void deniedForCameraAudio()
  {
    QLog.d(this.X, 1, "showPermissionDialog deniedForCameraAudio(1) 00");
  }
  
  public void e()
  {
    this.Y = 1;
    if ((Build.VERSION.SDK_INT >= 21) && (this.f == null))
    {
      this.f = new VideoControlUI.CameraAvailabilityReceiver(this);
      if (this.ak.get() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.X, 2, "register camera availability change receiver");
        }
        this.aS = ((Context)this.ak.get()).getApplicationContext();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
        Context localContext = this.aS;
        if (localContext != null) {
          localContext.registerReceiver(this.f, localIntentFilter);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(this.X, 2, "CANNOT register camera availability change receiver!");
      }
    }
  }
  
  public abstract void e(int paramInt);
  
  public void e(long paramLong)
  {
    Object localObject = this.aR;
    if (localObject != null) {
      ((SensorHelper)localObject).a();
    }
    localObject = this.aA;
    if (localObject != null) {
      ((QavPanel)localObject).setWaveVisibility(8);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.X, 4, "onConnected");
    }
  }
  
  abstract void e(long paramLong, View paramView);
  
  void e(long paramLong, String paramString)
  {
    AVActivity localAVActivity = U();
    if (localAVActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAVActivity.getString(2131893405);
      paramString = localAVActivity.getString(2131893406);
    }
    else if ("android.permission.RECORD_AUDIO".equals(paramString))
    {
      str = localAVActivity.getString(2131893415);
      paramString = localAVActivity.getString(2131893416);
    }
    else
    {
      if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString)) {
        return;
      }
      str = localAVActivity.getString(2131893413);
      paramString = localAVActivity.getString(2131893414);
    }
    a(paramLong, str, paramString);
  }
  
  public void e(long paramLong, boolean paramBoolean) {}
  
  public void f(int paramInt)
  {
    Object localObject = this.aA;
    if ((localObject != null) && (((QavPanel)localObject).isPressed())) {
      return;
    }
    localObject = this.am;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "switchToolBar-->mVideoController is null, Why???");
      }
      return;
    }
    localObject = ((VideoController)localObject).k();
    if ((((SessionInfo)localObject).p == 9500) && (this.am.ab)) {
      return;
    }
    if (this.aU) {
      return;
    }
    if ((!((SessionInfo)localObject).j()) && (((SessionInfo)localObject).g == 2)) {
      return;
    }
    boolean bool = this.af;
    if (this.an == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.X, 2, "switchToolBar-->mRootView is null Why");
      }
      return;
    }
    if (((SessionInfo)localObject).r()) {
      s(this.af ^ true);
    } else if (((SessionInfo)localObject).cw) {
      s(this.af ^ true);
    } else if ((!((SessionInfo)localObject).H) && (!((SessionInfo)localObject).I) && (!((SessionInfo)localObject).am)) {
      s(true);
    } else if (((SessionInfo)localObject).g == 1) {
      s(true);
    } else if ((((SessionInfo)localObject).g == 3) && (!((SessionInfo)localObject).am)) {
      s(true);
    } else {
      s(this.af ^ true);
    }
    localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToolBar, ToolbarDisplay[");
    localStringBuilder.append(bool);
    localStringBuilder.append("->");
    localStringBuilder.append(this.af);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    SmallScreenUtils.a();
    if (this.af)
    {
      TipsUtil.b(this.al, false);
      if (this.aA != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = this.X;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("WL_DEBUG switchToolBar mQavPanel.isShown()[");
          localStringBuilder.append(this.aA.isShown());
          localStringBuilder.append("], mTopToolbar.isShown()[");
          localStringBuilder.append(this.aB.isShown());
          localStringBuilder.append("]");
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
        if ((this.aA.isShown()) && (this.aB.isShown())) {
          return;
        }
      }
      localObject = this.aA;
      if (localObject != null) {
        ((QavPanel)localObject).setVisibility(0);
      }
      this.aB.setVisibility(0);
      this.aC.setVisibility(8);
      this.ag += 1;
      if (QLog.isColorLevel())
      {
        localObject = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG switchToolBar type=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", toolbarShowTimes: ");
        localStringBuilder.append(this.ag);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (paramInt == 1)
      {
        this.aG = j(true);
        this.aH = j(true);
      }
      else
      {
        this.aG = AnimationUtils.loadAnimation((Context)this.ak.get(), 2130772247);
        this.aH = AnimationUtils.loadAnimation((Context)this.ak.get(), 2130772283);
      }
    }
    else if (paramInt == 1)
    {
      this.aG = j(false);
      this.aH = j(false);
    }
    else
    {
      this.aG = AnimationUtils.loadAnimation((Context)this.ak.get(), 2130772246);
      this.aH = AnimationUtils.loadAnimation((Context)this.ak.get(), 2130772282);
    }
    if ((this instanceof MultiVideoCtrlLayerUIBase)) {
      ((MultiVideoCtrlLayerUIBase)this).H();
    }
    if (this.aL == null) {
      this.aL = new VideoControlUI.ToolbarAnimationListener(this, 2);
    }
    if (this.aM == null) {
      this.aM = new VideoControlUI.ToolbarAnimationListener(this, 1);
    }
    this.aG.setAnimationListener(this.aL);
    this.aH.setAnimationListener(this.aM);
    if (!VcSystemInfo.isLowLevelDevice())
    {
      localObject = this.aA;
      if (localObject != null) {
        ((QavPanel)localObject).startAnimation(this.aG);
      }
      this.aB.startAnimation(this.aH);
      return;
    }
    localObject = this.al;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.af), Boolean.valueOf(true), Long.valueOf(0L) });
    }
    localObject = this.aL;
    if (localObject != null) {
      ((VideoControlUI.ToolbarAnimationListener)localObject).onAnimationEnd(null);
    }
    localObject = this.al;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(118), Boolean.valueOf(this.af), Boolean.valueOf(false), Long.valueOf(0L) });
    }
  }
  
  public void f(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131893088, paramLong);
    if (localOperationBtnItem != null) {
      localOperationBtnItem.c(false);
    }
  }
  
  public void f(long paramLong, int paramInt)
  {
    if (!V())
    {
      if (this.aA == null) {
        return;
      }
      bv = AudioHelper.e();
      if ((paramInt & 0x1) == 1) {
        N(paramLong);
      }
      if ((paramInt & 0x2) == 2) {
        b_(paramLong);
      }
      if ((paramInt & 0x4) == 4) {
        j(paramLong);
      }
      if ((paramInt & 0x8) == 8) {
        o(paramLong);
      }
      if ((paramInt & 0x10) == 16) {
        aa(paramLong);
      }
      if ((paramInt & 0x20) == 32) {
        R(paramLong);
      }
      if ((paramInt & 0x40) == 64) {
        Q(paramLong);
      }
      if ((paramInt & 0x80) == 128) {
        ab(paramLong);
      }
      if ((paramInt & 0x100) == 256) {
        M(paramLong);
      }
      if ((paramInt & 0x200) == 512) {
        S(paramLong);
      }
      if ((paramInt & 0x800) == 2048) {
        W(paramLong);
      }
      if ((paramInt & 0x1000) == 4096) {
        n(paramLong);
      }
      if ((paramInt & 0x2000) == 8192) {
        K(paramLong);
      }
      if ((paramInt & 0x80000) == 524288) {
        L(paramLong);
      }
      if ((paramInt & 0x4000) == 16384) {
        f(paramLong);
      }
      if ((0x8000 & paramInt) == 32768) {
        T(paramLong);
      }
      if ((0x10000 & paramInt) == 65536) {
        U(paramLong);
      }
      if ((0x20000 & paramInt) == 131072) {
        V(paramLong);
      }
      if ((0x200000 & paramInt) == 2097152) {
        k(paramLong);
      }
      if ((0x100000 & paramInt) == 1048576) {
        P(paramLong);
      }
      if ((paramInt & 0x40000) == 262144) {
        O(paramLong);
      }
      i(paramLong);
      F(paramLong);
      this.aA.f();
      if (bv)
      {
        SessionInfo localSessionInfo = this.am.k();
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn, sessionInfo[");
        localStringBuilder.append(localSessionInfo);
        localStringBuilder.append("], screenStyle[");
        localStringBuilder.append(localSessionInfo.bM);
        localStringBuilder.append("], remoteHasVideo[");
        localStringBuilder.append(localSessionInfo.I);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      }
    }
  }
  
  @TargetApi(21)
  public void f(long paramLong, View paramView)
  {
    paramView = SessionMgr.a().b();
    if (!paramView.v())
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
      }
      ScreenShareCtrl.b(7);
      return;
    }
    ScreenShareReportHelper.a(paramView.f, 2, "onClick_ScreenShare");
    i(paramLong, 2131893080);
    paramView = this.am.aF();
    if (paramView != null) {
      paramView.a(U(), paramLong);
    }
    this.aA.post(new VideoControlUI.11(this));
  }
  
  void f(long paramLong, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  String g(String paramString)
  {
    return paramString;
  }
  
  public void g()
  {
    AvTipsView localAvTipsView = this.ba;
    if (localAvTipsView != null) {
      localAvTipsView.b(this.al);
    }
  }
  
  protected void g(long paramLong) {}
  
  void g(long paramLong, int paramInt)
  {
    if (this.as != null)
    {
      if ((QLog.isDevelopLevel()) || (this.as.getVisibility() != paramInt))
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisibility_ConnectInfoView_MiddleCenter, visibility[");
        localStringBuilder.append(this.as.getVisibility());
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.as.setVisibility(paramInt);
    }
  }
  
  public void g(long paramLong, View paramView)
  {
    QLog.i(this.X, 1, "onClick_Avatar");
    this.bb ^= true;
    paramView = this.aA;
    if (paramView != null)
    {
      int i;
      if (this.bb) {
        i = 2130842978;
      } else {
        i = 2130842977;
      }
      paramView.setImgBtnDrawable(2131441301, i);
    }
    this.al.a(new Object[] { Integer.valueOf(22201), Boolean.valueOf(this.bb) });
  }
  
  public void g(long paramLong, boolean paramBoolean)
  {
    this.aQ.f();
    if (paramBoolean)
    {
      String str1 = this.am.k().aD;
      this.aQ.a(paramLong, this.ah, str1);
      if (QLog.isColorLevel())
      {
        String str2 = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate, switchToGaudio, mAudioSesstionType[");
        localStringBuilder.append(this.ah);
        localStringBuilder.append("], deviceName[");
        localStringBuilder.append(str1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str2, 1, localStringBuilder.toString());
      }
      this.aQ.a(paramLong, str1);
      return;
    }
    this.aQ.a(this.ah);
  }
  
  public boolean g(int paramInt)
  {
    return false;
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.X, 1, "showPermissionDialog grantForAudioRecord(2) 03");
  }
  
  @QQPermissionGrant(1)
  public void grantForCamera()
  {
    QLog.d(this.X, 1, "showPermissionDialog grantForCamera(1) 01");
  }
  
  @QQPermissionGrant(0)
  public void grantForCameraAudio()
  {
    QLog.d(this.X, 1, "showPermissionDialog grantForCameraAudio(1) 0");
  }
  
  public void h() {}
  
  public void h(int paramInt) {}
  
  void h(long paramLong, int paramInt)
  {
    if (this.at != null)
    {
      if ((QLog.isDevelopLevel()) || (this.at.getVisibility() != paramInt))
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisibility_ConnectInfoView_TopCenter, visibility[");
        localStringBuilder.append(this.at.getVisibility());
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.at.setVisibility(paramInt);
    }
  }
  
  public void h(long paramLong, View paramView)
  {
    if (V()) {
      return;
    }
    I(paramLong);
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    paramView.a(paramLong, null);
    this.al.a(new Object[] { Integer.valueOf(9005), paramView });
    if (paramView.d)
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_More, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("], seq");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else if (this.aA.i(1))
    {
      this.aA.a(paramLong, 0, true);
    }
    else
    {
      this.aA.a(paramLong, 1, true);
      aq();
    }
    U().h(paramLong);
  }
  
  public void h(String paramString)
  {
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideToolBar[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isToolBarDisplay[");
    localStringBuilder.append(ab());
    localStringBuilder.append("], mToolbarDisplay[");
    localStringBuilder.append(this.af);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.af) {
      f(0);
    }
    this.al.a().removeCallbacks(this.bg);
  }
  
  public void h(boolean paramBoolean)
  {
    m(paramBoolean);
  }
  
  public void i() {}
  
  public void i(int paramInt) {}
  
  protected void i(long paramLong)
  {
    OperationBtnItem localOperationBtnItem = a(2131893083, paramLong);
    if (localOperationBtnItem != null) {
      localOperationBtnItem.c(false);
    }
  }
  
  void i(long paramLong, int paramInt)
  {
    if ((2131893079 != paramInt) && (2131893077 != paramInt) && (2131893086 != paramInt)) {
      this.aA.a(paramLong, 0, true);
    }
    if (2131893077 == paramInt) {
      AVUtil.a("0X800BC0C", DataReport.b(this.am.k()), 1, "", "", "", "");
    }
  }
  
  void i(long paramLong, View paramView)
  {
    long l = AudioHelper.c();
    paramView = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_ScreenShot, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(paramView, 1, localStringBuilder.toString());
    this.al.a(new VideoControlUI.12(this, l, paramLong));
    paramView = U();
    if ((paramView != null) && (paramView.L != null)) {
      paramView.L.i(l);
    }
    DataReport.ScreenShot.a();
  }
  
  protected void i(String paramString)
  {
    if (this.aA == null) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setChatTime, time[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (TextView)this.aA.e(2131428836);
    Object localObject2 = (TextView)this.aA.e(2131449444);
    aB_();
    if ((localObject1 != null) && (localObject2 != null))
    {
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject2).setText(paramString);
      if (UITools.b)
      {
        if (TextUtils.isEmpty(paramString))
        {
          UITools.a((View)localObject1, "");
          UITools.a((View)localObject2, "");
          return;
        }
        paramString = UITools.a(paramString);
        UITools.a((View)localObject1, paramString);
        UITools.a((View)localObject2, paramString);
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    AVActivity localAVActivity = U();
    if ((localAVActivity != null) && (localAVActivity.ai != null))
    {
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 0;
      }
      localAVActivity.ai.c(i);
    }
  }
  
  public AlphaAnimation j(boolean paramBoolean)
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
  
  public void j() {}
  
  protected void j(long paramLong) {}
  
  void j(long paramLong, View paramView)
  {
    DataReport.f();
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 1);
    paramView.c = 5;
    this.al.a(new Object[] { Integer.valueOf(9003), paramView });
    String str;
    StringBuilder localStringBuilder;
    if (paramView.d)
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Voice, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Voice, mEffectBtnID[");
      localStringBuilder.append(paramView.c);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.aA.a(paramLong, paramView.c);
    }
    i(paramLong, 2131893077);
  }
  
  public void k() {}
  
  public void k(int paramInt)
  {
    if (paramInt == 1037) {
      paramInt = 256;
    } else {
      paramInt = 257;
    }
    VideoControlUI.DelayTipsHandler localDelayTipsHandler = this.b;
    if (localDelayTipsHandler != null) {
      localDelayTipsHandler.removeMessages(paramInt);
    }
  }
  
  void k(long paramLong) {}
  
  void k(long paramLong, View paramView)
  {
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 2);
    Object localObject = am();
    if ((localObject != null) && (((QavEffectBaseMenuView)localObject).getCurSelectedId() != -1) && (((QavEffectBaseMenuView)localObject).getCurSelectedId() != 100)) {
      paramView.c = ((QavEffectBaseMenuView)localObject).getCurSelectedId();
    } else {
      paramView.c = 1;
    }
    this.al.a(new Object[] { Integer.valueOf(9003), paramView });
    StringBuilder localStringBuilder;
    if (paramView.d)
    {
      localObject = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Effect, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    else
    {
      localObject = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Effect, mEffectBtnID[");
      localStringBuilder.append(paramView.c);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.aA.a(paramLong, paramView.c);
    }
    i(paramLong, 2131893077);
    this.aA.l();
  }
  
  protected void k(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1073;
    } else {
      i = 1074;
    }
    String str1;
    if (paramBoolean) {
      str1 = this.aj.getString(2131893236);
    } else {
      str1 = this.aj.getString(2131893198);
    }
    String str2;
    if (paramBoolean) {
      str2 = this.aj.getString(2131893235);
    } else {
      str2 = this.aj.getString(2131893197);
    }
    TipsUtil.a(this.am.e, i, 3000L);
    Object localObject = this.aA;
    if (localObject != null)
    {
      localObject = ((QavPanel)localObject).c(2131893072);
      if (localObject != null)
      {
        localObject = this.aA.a((OperationBtnItem)localObject);
        if (localObject != null)
        {
          UITools.a((View)localObject, str1);
          ((View)localObject).setContentDescription(str2);
        }
      }
    }
  }
  
  public void l() {}
  
  void l(int paramInt)
  {
    c(a(this.am.k(), paramInt));
  }
  
  public void l(long paramLong, View paramView)
  {
    paramView = new ControlUIObserver.CEffectEntrancePreClickInfo(paramView, 2);
    paramView.c = -1;
    this.al.a(new Object[] { Integer.valueOf(9003), paramView });
    String str;
    StringBuilder localStringBuilder;
    if (paramView.d)
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_VirtualBackground, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_VirtualBackground, mEffectBtnID[");
      localStringBuilder.append(paramView.c);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      this.aA.a(paramLong, 4, true);
    }
    i(paramLong, 2131893086);
    AVUtil.a("0X800ADA9", AVUtil.c(), 0, "", "", "", "");
  }
  
  void l(boolean paramBoolean)
  {
    if (this.aA == null) {}
  }
  
  void m() {}
  
  void m(int paramInt)
  {
    if (paramInt != 2131441023) {
      return;
    }
    QavPanel localQavPanel = this.aA;
    if (localQavPanel != null)
    {
      localQavPanel.a(2131441023, this.aj.getString(2131889937));
      this.aA.a(2131441023, true);
      this.d = true;
      this.aA.a(this.c, this.d);
    }
  }
  
  public abstract void m(long paramLong);
  
  public void m(long paramLong, View paramView)
  {
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    paramView.a(paramLong, null);
    this.al.a(new Object[] { Integer.valueOf(9005), paramView });
    if (paramView.d)
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_More, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("], seq");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    else if (this.aA.i(1))
    {
      this.aA.a(paramLong, 0, true);
    }
    if (!((IDoodleApi)QRoute.api(IDoodleApi.class)).isDoodleUsable())
    {
      if (((IDoodleApi)QRoute.api(IDoodleApi.class)).getUnableTipResId() != 0)
      {
        int i = this.aj.getDimensionPixelSize(2131299920);
        a(((IDoodleApi)QRoute.api(IDoodleApi.class)).getUnableTipResId(), 0, i);
      }
      return;
    }
    ((IDoodleApi)QRoute.api(IDoodleApi.class)).showDoodle(paramLong, U());
    AVUtil.a("0X800BC0D", AVUtil.c(), 0, "", "", "", "");
  }
  
  void m(boolean paramBoolean)
  {
    if (this.aI == null) {
      this.aI = new VideoControlUI.ShowSharpInfoRunnable(this);
    }
    if (paramBoolean)
    {
      this.al.a().post(this.aI);
      return;
    }
    this.al.a().removeCallbacks(this.aI);
  }
  
  void n() {}
  
  void n(int paramInt)
  {
    if (paramInt != 2131441023) {
      return;
    }
    QavPanel localQavPanel = this.aA;
    if (localQavPanel != null)
    {
      localQavPanel.a(2131441023, this.aj.getString(2131889926));
      this.aA.a(2131441023, false);
      this.d = false;
      this.aA.a(this.c, this.d);
    }
  }
  
  public void n(long paramLong)
  {
    if ((QLog.isColorLevel()) && (paramLong == -1052L)) {
      QLog.i(this.X, 2, "updateBtn_ScreenShare");
    }
    Context localContext = (Context)this.ak.get();
    OperationBtnItem localOperationBtnItem = a(2131893080, paramLong);
    if (localOperationBtnItem != null)
    {
      if (localContext == null) {
        return;
      }
      if (!QAVConfigUtils.s())
      {
        localOperationBtnItem.c(false);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (!WTogetherUtil.a(this.al))) {
        localOperationBtnItem.c(true);
      } else {
        localOperationBtnItem.c(false);
      }
      SessionInfo localSessionInfo = SessionMgr.a().b();
      if (localSessionInfo.p == 1044)
      {
        localOperationBtnItem.c(false);
        localOperationBtnItem.a(false);
        return;
      }
      if ((localSessionInfo.cj != 2) && (localSessionInfo.cj != 1))
      {
        localOperationBtnItem.a(2130843013);
        localOperationBtnItem.a(localContext.getResources().getString(2131893080));
        return;
      }
      localOperationBtnItem.a(2130843014);
      localOperationBtnItem.a(localContext.getResources().getString(2131893081));
    }
  }
  
  public void n(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.b(paramBoolean);
    }
  }
  
  public void o(int paramInt)
  {
    this.ac = paramInt;
  }
  
  public void o(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.c(paramBoolean);
    }
  }
  
  public boolean o()
  {
    if ((am() != null) && (am().isShown())) {
      return am().e();
    }
    return false;
  }
  
  public boolean o(long paramLong)
  {
    return Z(paramLong);
  }
  
  public void p() {}
  
  public void p(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.a(paramBoolean);
    }
  }
  
  boolean p(int paramInt)
  {
    if (am() != null) {
      return am().c(paramInt);
    }
    return false;
  }
  
  public void q() {}
  
  public void q(boolean paramBoolean)
  {
    VideoNetStateBar localVideoNetStateBar = this.aE;
    if (localVideoNetStateBar != null) {
      localVideoNetStateBar.d(paramBoolean);
    }
  }
  
  public void r(boolean paramBoolean)
  {
    a(ab(), paramBoolean);
  }
  
  protected abstract boolean r();
  
  public void s(boolean paramBoolean)
  {
    if (this.af != paramBoolean)
    {
      this.af = paramBoolean;
      this.al.a(new Object[] { Integer.valueOf(170), Boolean.valueOf(this.af) });
    }
  }
  
  protected void t(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1062;
    } else {
      i = 1063;
    }
    TipsUtil.a(this.am.e, i, 3000L);
  }
  
  public void u(boolean paramBoolean)
  {
    TextView localTextView = this.av;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean) {
      localTextView.setVisibility(0);
    } else {
      localTextView.setVisibility(8);
    }
    AudioHelper.d = paramBoolean;
    h(paramBoolean);
  }
  
  public void x() {}
  
  public void y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */