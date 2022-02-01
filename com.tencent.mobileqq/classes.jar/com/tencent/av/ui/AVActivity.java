package com.tencent.av.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import com.tencent.av.AVLog;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoCameraListener;
import com.tencent.av.VideoConstants.ProcessInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.panorama.PanoramaSensorManager;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.compat.AVCallCompactJob;
import com.tencent.av.core.AVSoProxyImpl;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.opengl.effects.RenderUtil;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.recog.AVVoiceRecog.AVVoiceRecogCallback;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.funcall.FunCallUtil;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVConfigUtils.MoreBtnTips;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.api.IUIProxy;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.media.WatchTogetherAudioDecodeHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.debug.qav.QavTest;
import com.tencent.mobileqq.debug.qav.QavTestUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.BaseActivity;

public class AVActivity
  extends BaseActivity
  implements SensorEventListener, AVVoiceRecog.AVVoiceRecogCallback
{
  private static int aI = 1280;
  private static int aJ = 720;
  boolean A = false;
  boolean B = false;
  long C = 0L;
  long D = 0L;
  int E = 0;
  Runnable F = null;
  RelativeLayout G;
  VideoAppInterface H = null;
  public VideoController I = null;
  VoiceChangeChooseDialog J = null;
  public VideoControlUI K;
  public VideoLayerUI L;
  ICameraManagerApi M;
  ChildGuideUi N;
  Bitmap O = null;
  Bitmap P = null;
  QAVNotification Q = null;
  AVActivity.VideoOrientationEventListener R = null;
  public Integer S;
  public Integer T;
  public Integer U;
  public int V = 0;
  BroadcastReceiver W = null;
  ControlUIObserver X = new AVActivity.MyControlUIObserver(this);
  VipFullScreenVideoView Y;
  WeakReference<Activity> Z = new WeakReference(this);
  int a = -1;
  private WatchTogetherUIProxy aA;
  private WatchTogetherUIProxy aB;
  private boolean aC = false;
  private MessageQueue.IdleHandler aD = new AVActivity.1(this);
  private QAVConfigUtils.MoreBtnTips aE = null;
  private URLDrawable aF = null;
  private boolean aG = false;
  private int aH = 2000;
  private int aK = 0;
  private int aL = 0;
  private AVActivity.AnimationTrigger aM = null;
  private boolean aN = false;
  public EffectFilterPanel aa;
  public GuideHelper ab = new GuideHelper();
  QavRecordButtonView ac;
  public QavVideoRecordUICtrl ad = null;
  public boolean ae = false;
  public QavDoubleVideoSharpnessMangaer af;
  public ScreenRecordHelper ag;
  public RedTouch ah = null;
  public VideoChatRoomUIContoller ai;
  @SuppressLint({"HandlerLeak"})
  Handler aj = new AVActivity.2(this);
  CameraObserver ak = new AVActivity.3(this);
  Runnable al = new AVActivity.4(this);
  VipFunCallMediaListener am = new AVActivity.12(this);
  boolean an = true;
  boolean ao = false;
  VideoObserver ap = new AVActivity.MyVideoObserver(this);
  boolean aq = false;
  Dialog ar = null;
  boolean as = false;
  Handler at = new AVActivity.21(this);
  GAudioUIObserver au = new AVActivity.23(this);
  private SensorManager av;
  private Sensor aw;
  private ConfigInfoTips ax = null;
  private SmallScreenActivityPlugin ay = null;
  private AVCallCompactJob az = new AVCallCompactJob();
  int b = 0;
  int c = 0;
  String d = null;
  int e = -1;
  int f = 0;
  int g = 0;
  byte[] h = null;
  final String i;
  String j = null;
  String k = null;
  String l = null;
  String m = null;
  String n = null;
  String o = null;
  String p = null;
  String q = null;
  String r = null;
  String s = null;
  String t = null;
  boolean u = false;
  boolean v = true;
  boolean w = false;
  boolean x = false;
  public boolean y = false;
  boolean z = false;
  
  public AVActivity()
  {
    this.mIsShadow = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVActivity_");
    localStringBuilder.append(AudioHelper.c());
    this.i = localStringBuilder.toString();
  }
  
  private void A()
  {
    View localView = findViewById(2131441304);
    if ((localView != null) && (this.ah == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.11(this, localView));
    }
  }
  
  private void B()
  {
    int i1 = this.V;
    if ((i1 != 0) && (i1 != 180))
    {
      if (i1 == 90)
      {
        setRequestedOrientation(8);
        QLog.d(this.i, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE]");
        return;
      }
      setRequestedOrientation(0);
      QLog.d(this.i, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
      return;
    }
    setRequestedOrientation(1);
    QLog.d(this.i, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
  }
  
  private void C()
  {
    if (this.L != null) {
      return;
    }
    Object localObject = super.findViewById(2131428980);
    this.L = new VideoLayerUI(this.H, this, (View)localObject);
    this.L.a(a());
    this.L.a(new AVActivity.22(this));
    localObject = this.L;
    if (localObject != null) {
      ((VideoLayerUI)localObject).a(this.ad);
    }
  }
  
  private String a(Intent paramIntent)
  {
    int i2 = paramIntent.getIntExtra("uinType", -1);
    int i3 = UITools.b(i2);
    int i1 = i3;
    if (i3 == 0) {
      i1 = 3;
    }
    Object localObject1;
    if (i2 == 1006) {
      localObject1 = paramIntent.getStringExtra("toMobile");
    } else if ((i1 != 1) && (i1 != 2)) {
      localObject1 = paramIntent.getStringExtra("uin");
    } else {
      localObject1 = paramIntent.getStringExtra("GroupId");
    }
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
    {
      localObject1 = paramIntent.getStringExtra("GroupId");
      i2 = 0;
      i1 = 100;
    }
    String str = paramIntent.getStringExtra("Fromwhere");
    i3 = i1;
    Object localObject2 = localObject1;
    if (i1 == 3)
    {
      i3 = i1;
      localObject2 = localObject1;
      if (TextUtils.equals("AIOShareScreen", str))
      {
        localObject2 = paramIntent.getStringExtra("uin");
        i3 = 100;
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.i;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("genSessionIdFromIntent, [");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(i3);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject1).toString());
    }
    if ((i2 != -1) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      return SessionMgr.a(i3, (String)localObject2, new int[0]);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.i;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("genSessionIdFromIntent error: uinType ");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(", relationId ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.e(paramIntent, 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public static void a(Window paramWindow)
  {
    try
    {
      paramWindow.addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramWindow);
      }
      return;
    }
    catch (NoSuchFieldException paramWindow) {}
  }
  
  static boolean a(Activity paramActivity)
  {
    LiuHaiUtils.f(paramActivity);
    boolean bool2 = LiuHaiUtils.b();
    boolean bool1 = true;
    if (bool2)
    {
      int i1 = LiuHaiUtils.e(paramActivity);
      int i2 = ImmersiveUtils.getStatusBarHeight(paramActivity);
      String str = ImmersiveUtils.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLiuHaiProperty, onAttachedToWindow, notchheight[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], statusBarHeight[");
      localStringBuilder.append(i2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (LiuHaiUtils.enableNotch(paramActivity))
      {
        if (!QLog.isDevelopLevel()) {
          return bool1;
        }
        QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, enableNotch");
        return true;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("");
      paramActivity.append(Build.MANUFACTURER);
      if (paramActivity.toString().equalsIgnoreCase("Lenovo")) {
        VideoControlUI.br = true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    int i1 = ImmersiveUtils.isSupporImmersive();
    boolean bool = false;
    if (i1 == 1)
    {
      if (paramBoolean)
      {
        int i2 = paramWindow.getDecorView().getSystemUiVisibility();
        paramWindow.getDecorView().setSystemUiVisibility(i2 | 0x100 | 0x400);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramWindow.addFlags(-2147483648);
          paramWindow.clearFlags(67108864);
          paramWindow.setStatusBarColor(0);
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          paramWindow.addFlags(67108864);
        }
      }
      else
      {
        paramWindow.clearFlags(67108864);
      }
      paramBoolean = true;
    }
    else
    {
      paramBoolean = bool;
      if (AudioHelper.a(25) == 1)
      {
        AudioHelper.a("使用了index_disable_immersive");
        paramBoolean = bool;
      }
    }
    if (QLog.isDevelopLevel())
    {
      String str = ImmersiveUtils.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImmersive, result[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], isSupporImmersive[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], SystemUiVisibility[0x");
      localStringBuilder.append(Integer.toHexString(paramWindow.getDecorView().getSystemUiVisibility()));
      localStringBuilder.append("], flags[0x");
      localStringBuilder.append(Integer.toHexString(paramWindow.getAttributes().flags));
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return paramBoolean;
  }
  
  private boolean b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  private void c(int paramInt)
  {
    Object localObject = SessionMgr.a().b();
    if (localObject != null)
    {
      if (!((SessionInfo)localObject).r()) {
        return;
      }
      localObject = this.I.aA();
      if (localObject == null) {
        return;
      }
      if (((WatchTogetherMediaPlayCtrl)localObject).s() == paramInt) {
        return;
      }
      ((WatchTogetherMediaPlayCtrl)localObject).a(paramInt);
      if (((WatchTogetherMediaPlayCtrl)localObject).t()) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(false);
      }
      B();
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
    paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
    if ((paramIntent != null) && (this.e == 0)) {
      ((WTogetherMng)this.H.c(17)).a(3, this.j, paramIntent, null);
    }
  }
  
  private void c(String paramString)
  {
    if ((this.I != null) && (AudioHelper.d)) {
      this.I.k().cf = paramString;
    }
  }
  
  private void i(long paramLong)
  {
    if (isDestroyed()) {
      return;
    }
    Object localObject1 = this.K;
    if (localObject1 != null)
    {
      if (((VideoControlUI)localObject1).V()) {
        return;
      }
      localObject1 = this.I.k();
      int i1 = ((SessionInfo)localObject1).g;
      boolean bool1 = ((SessionInfo)localObject1).r();
      if (QLog.isDevelopLevel())
      {
        localObject2 = this.i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchToolbar, sessionType[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], isInviting[");
        localStringBuilder.append(((SessionInfo)localObject1).f());
        localStringBuilder.append("], isToolBarDisplay[");
        localStringBuilder.append(this.K.ab());
        localStringBuilder.append("|");
        localStringBuilder.append(this.K.af);
        localStringBuilder.append("], watch[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("], curMenu[");
        localStringBuilder.append(this.K.aA.getCurrentMenuType());
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 4, localStringBuilder.toString());
      }
      boolean bool2 = true;
      if (bool1)
      {
        localObject2 = this.L;
        if ((localObject2 != null) && (((VideoLayerUI)localObject2).T == 2))
        {
          if (this.K.ab()) {
            this.K.h("switchToolbar");
          }
          i1 = 1;
          bool1 = false;
        }
        else
        {
          this.K.d(0);
          bool1 = this.K.af;
          ((SessionInfo)localObject1).c(bool1 ^ true);
          i1 = 0;
        }
        localObject1 = VideoController.f().aA();
        if (localObject1 == null) {
          return;
        }
        localObject1 = d(((WatchTogetherMediaPlayCtrl)localObject1).r());
        if (i1 == 0)
        {
          if (!bool1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((WatchTogetherUIProxy)localObject1).setImmersiveStatus(bool1);
        }
        return;
      }
      if (((i1 == 1) || (i1 == 3)) && (!((SessionInfo)localObject1).cw))
      {
        if ((this.K.aA.i(1)) || (this.K.aA.i(3)) || (this.K.aA.i(5))) {
          this.K.aA.a(paramLong, 0, true);
        }
        if ((!this.K.af) || (!this.K.ab())) {
          this.K.d(0);
        }
        return;
      }
      if (((SessionInfo)localObject1).f())
      {
        if ((i1 == 2) && ((this.K.aA.i(1)) || (this.K.aA.i(3)))) {
          this.K.aA.a(paramLong, 0, true);
        }
        return;
      }
      Object localObject2 = this.N;
      if ((localObject2 != null) && (((ChildGuideUi)localObject2).e())) {
        return;
      }
      if ((((SessionInfo)localObject1).cB) && (!this.K.ab()))
      {
        localObject1 = this.H;
        if (localObject1 != null) {
          TipsUtil.a((VideoAppInterface)localObject1, 1022, 2131893511);
        }
        return;
      }
      if (!i())
      {
        if ((!this.K.ab()) && ((this.K.aA.i(1)) || (this.K.aA.i(3)) || (this.K.aA.i(5)))) {
          this.K.aA.a(paramLong, 0, false);
        }
        b(paramLong, "switchToolbar", this.K.ab());
        this.K.d(0);
        return;
      }
      if (!this.K.ab())
      {
        b(paramLong, "SwitchToolbar2", this.K.ab());
        this.K.d(0);
      }
    }
  }
  
  private void j(long paramLong)
  {
    if (this.aN) {
      return;
    }
    this.aN = true;
    VideoControlUI localVideoControlUI = this.K;
    if (localVideoControlUI != null) {
      localVideoControlUI.c(paramLong);
    }
  }
  
  private void z()
  {
    if (this.P == null) {
      this.P = UITools.a(getApplicationContext(), 2130842939);
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.c();
    Object localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BtnOnClick, id[");
    localStringBuilder.append(LayoutDef.a(paramView.getId()));
    localStringBuilder.append("], nfonWindowFocus[");
    localStringBuilder.append(this.an);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (!this.an) {
      return;
    }
    if ((paramView.getId() == 2131441016) || (paramView.getId() == 2131441017) || (paramView.getId() == 2131441018)) {
      b(true);
    }
    localObject = this.N;
    if ((localObject != null) && (((ChildGuideUi)localObject).e()))
    {
      this.N.a(paramView);
    }
    else
    {
      localObject = this.K;
      if (localObject != null)
      {
        ((VideoControlUI)localObject).I(l1);
        DataReport.c(paramView.getId());
        this.K.a(l1, paramView);
        f(l1);
      }
    }
    if (paramView.getId() == 2131441304)
    {
      paramView = this.ah;
      if (paramView != null)
      {
        AVRedTouchUtil.a(this.H, paramView, 1);
        this.ah = null;
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    if (AudioHelper.a()) {
      try
      {
        QavTestUtil.addMenuInVideoView(this.H, this, paramView);
        return;
      }
      catch (Throwable paramView)
      {
        QLog.i(this.i, 1, "addMenuInVideoView", paramView);
      }
    }
  }
  
  public AVActivity.AnimationTrigger a()
  {
    if (this.aM == null) {
      this.aM = new AVActivity.AnimationTrigger(this.H);
    }
    return this.aM;
  }
  
  void a(int paramInt)
  {
    VideoControlUI localVideoControlUI = this.K;
    if ((localVideoControlUI != null) && (localVideoControlUI.am() != null)) {
      this.K.am().b(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeVideoLayoutMode, mode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], ctrlUI[");
      localStringBuilder.append(this.K);
      localStringBuilder.append("], curMode[");
      localObject = this.L;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(((VideoLayerUI)localObject).B());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i("WTogether", 4, localStringBuilder.toString());
    }
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.K;
    if (localObject != null)
    {
      if (((VideoControlUI)localObject).V()) {
        return;
      }
      localObject = this.L;
      if (localObject != null)
      {
        if (paramInt == ((VideoLayerUI)localObject).B()) {
          return;
        }
        long l1 = AudioHelper.c();
        this.L.i(paramInt);
        if (((this.K instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
        {
          this.L.g(l1);
          ((DoubleVideoCtrlUI)this.K).a(this.L.V(), p());
        }
        this.K.I(l1);
        this.K.f(l1, 16777215);
        localObject = this.ad;
        if (localObject != null)
        {
          ((QavVideoRecordUICtrl)localObject).a(this.L.V(), this.K, this.ad.i());
          localObject = this.ad;
          ((QavVideoRecordUICtrl)localObject).a(((QavVideoRecordUICtrl)localObject).i());
          localObject = this.ad;
          ((QavVideoRecordUICtrl)localObject).b(((QavVideoRecordUICtrl)localObject).i());
        }
        localObject = this.I;
        if ((localObject != null) && (((VideoController)localObject).k().cB) && (!this.I.k().cK)) {
          QavRecordReporter.a("0X8008ABA");
        }
        if (this.aa != null)
        {
          localObject = this.I;
          if (localObject != null)
          {
            paramBoolean = ((VideoController)localObject).k().B;
            this.aa.a(this.L.V(), paramBoolean);
          }
        }
        this.K.i(paramInt);
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.M == null) {
      return;
    }
    Object localObject = this.L;
    if (localObject != null)
    {
      ((VideoLayerUI)localObject).b(paramLong, false, false);
      if (!this.M.isCameraOpened(paramLong)) {
        this.I.k().b(paramLong, false);
      }
    }
    localObject = this.M;
    if (localObject != null) {
      ((ICameraManagerApi)localObject).closeCamera(paramLong, true);
    }
    if (!this.M.isCameraOpened(paramLong))
    {
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestCloseCamera, 摄像头本来没打开, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      localObject = this.K;
      if (localObject != null) {
        ((VideoControlUI)localObject).c(paramLong, true);
      }
    }
    if (!this.I.k().p()) {
      a(1, false);
    }
    localObject = this.ai;
    if (localObject != null) {
      ((VideoChatRoomUIContoller)localObject).e();
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.K;
    if (localObject != null)
    {
      if (((VideoControlUI)localObject).V()) {
        return;
      }
      int i5 = this.K.J(paramLong);
      int i6 = this.K.ae();
      boolean bool = this.K.ab();
      int i4 = 0;
      int i1;
      int i2;
      if (bool)
      {
        localObject = findViewById(2131441298);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          i1 = ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin;
        } else {
          i1 = 0;
        }
        i2 = i1;
        i1 = 0;
      }
      else
      {
        if ((i5 == 0) && (LiuHaiUtils.b())) {
          i1 = LiuHaiUtils.e(this);
        } else {
          i1 = 0;
        }
        localObject = this.I.k();
        if ((((SessionInfo)localObject).u()) && ((((SessionInfo)localObject).cB) || (((SessionInfo)localObject).cD)))
        {
          localObject = this.ad;
          if ((localObject != null) && (!((QavVideoRecordUICtrl)localObject).p()))
          {
            i2 = this.ad.n();
            localObject = this.L;
            if (i2 == 0) {
              i3 = -1;
            } else {
              i3 = i2;
            }
            ((VideoLayerUI)localObject).J = i3;
            i3 = i2;
            i2 = 0;
            break label246;
          }
        }
        i2 = 0;
      }
      int i3 = 0;
      label246:
      int i7 = i5 + i1;
      localObject = this.ai;
      if (localObject != null) {
        i4 = ((VideoChatRoomUIContoller)localObject).a();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("calcControlUIOffset, topOffset[");
        ((StringBuilder)localObject).append(i7);
        ((StringBuilder)localObject).append("], topToolbarHeight[");
        ((StringBuilder)localObject).append(i5);
        ((StringBuilder)localObject).append("], topToolbarTop[");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("], bottomToolbarHeight[");
        ((StringBuilder)localObject).append(i6);
        ((StringBuilder)localObject).append("], chatRoomInputPanelHeight[");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append("], recordBarHeight[");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("], systemBarHeight[");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], from[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w("ChatRoomUtil", 1, ((StringBuilder)localObject).toString());
      }
      if (this.L != null) {
        if ((u() == 1) && (i4 > i6)) {
          this.L.a(paramLong, i7, i4, this.K.af ^ true);
        } else {
          this.L.a(paramLong, i7, i6, this.K.af ^ true);
        }
      }
      this.K.ao();
      this.K.aA_();
      localObject = this.ai;
      if ((localObject != null) && (paramInt != 1)) {
        ((VideoChatRoomUIContoller)localObject).b(i6);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 2131441304) && (paramInt3 == 0)) {
      this.ab.a(paramLong, this, 1, 0);
    }
  }
  
  void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.K;
    if (localObject != null)
    {
      if (((VideoControlUI)localObject).V()) {
        return;
      }
      this.K.b(paramLong, paramInt);
      this.L.a(paramInt, false);
      this.M.setRotation(paramInt);
      this.V = paramInt;
      localObject = this.ad;
      if (localObject != null)
      {
        ((QavVideoRecordUICtrl)localObject).d(paramInt);
        this.ad.h();
        this.ad.a(this.K, this.V);
      }
      if ((this.I.k().cB) || (this.I.k().cD)) {
        h(paramLong);
      }
      c(paramInt);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.I == null) {
      return;
    }
    Object localObject = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("uinname", paramString2);
    startActivity((Intent)localObject);
    paramString2 = this.i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterChatWin, uin[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
    this.y = false;
    finish();
    paramInt = 2130772257;
    paramString1 = this.I.k();
    if (paramString1 != null) {
      paramInt = SmallScreenUtils.a(paramString1.bB);
    }
    overridePendingTransition(0, paramInt);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.ac != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      int i2 = this.ac.getVisibility();
      this.ac.setVisibility(i1);
      if ((i2 != i1) && (AudioHelper.e()))
      {
        String str = this.i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShowRecordBtn, from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], bShown[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
    if (paramBoolean)
    {
      paramString = this.I;
      if ((paramString != null) && (paramString.k().cI))
      {
        this.I.k().cI = false;
        paramBoolean = this.ad.y();
        boolean bool = QavVideoRecordUICtrl.v();
        if ((paramBoolean) && (bool))
        {
          QavRecordReporter.a("0X8008AB2");
          return;
        }
        QavRecordReporter.a("0X8008AB1");
      }
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.I.k();
    Object localObject2 = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onCreateUI, SessionType[");
    localStringBuilder.append(((SessionInfo)localObject1).g);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    if (this.G == null) {
      this.G = ((RelativeLayout)super.findViewById(2131441045));
    }
    this.F = new AVActivity.6(this);
    if (this.M == null)
    {
      this.M = CameraUtils.a(this);
      this.M.addObserver(this.ak);
      this.M.setCameraListener(this.I.t);
    }
    localObject2 = super.findViewById(2131428980).findViewById(2131428977);
    try
    {
      ((View)localObject2).setBackgroundResource(2130843118);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d(this.i, 1, "onCreateUI OutOfMemoryError", localOutOfMemoryError);
    }
    if (this.L == null) {
      C();
    }
    Object localObject3 = this.L;
    if (localObject3 != null) {
      ((VideoLayerUI)localObject3).n();
    }
    c(false);
    if (this.b == 0)
    {
      localObject3 = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateUI, SessionType[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], isDoubleMeeting[");
      localStringBuilder.append(this.A);
      localStringBuilder.append("]");
      QLog.i((String)localObject3, 2, localStringBuilder.toString());
      if (this.A) {
        this.b = 1;
      }
    }
    int i1 = this.b;
    if ((i1 == 2) || (i1 == 4)) {
      ThreadManager.excute(new AVActivity.7(this), 16, null, true);
    }
    i1 = this.b;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 == 3) || (i1 == 4))
        {
          if (this.K == null) {
            if (this.A)
            {
              this.K = new DoubleVideoMeetingCtrlUI(this.H, this, this.G, this.X);
              this.b = ((SessionInfo)localObject1).g;
            }
            else if (((SessionInfo)localObject1).o == 1)
            {
              this.K = new MultiVideoCtrlLayerUI4Discussion(this.H, this, this.G, this.X);
            }
            else if (((SessionInfo)localObject1).o == 10)
            {
              this.K = new MultiVideoCtrlLayerUI4NewGroupChat(this.H, this, this.G, this.X);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.i, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.K = new MultiVideoCtrlLayerUI4Discussion(this.H, this, this.G, this.X);
            }
          }
          this.K.o(this.M.getCameraNum());
        }
      }
      else if (this.A)
      {
        this.K = new DoubleVideoMeetingCtrlUI(this.H, this, this.G, this.X);
        this.b = ((SessionInfo)localObject1).g;
      }
      else
      {
        this.K = new DoubleVideoCtrlUI(this.H, this, this.G, this.X);
        this.K.o(this.M.getCameraNum());
      }
    }
    else
    {
      if (this.K == null) {
        if (this.A)
        {
          this.K = new DoubleVideoMeetingCtrlUI(this.H, this, this.G, this.X);
          this.b = ((SessionInfo)localObject1).g;
        }
        else
        {
          this.K = new DoubleVideoCtrlUI(this.H, this, this.G, this.X);
        }
      }
      this.K.o(this.M.getCameraNum());
    }
    i1 = this.b;
    if ((i1 == 3) && (getIntent() != null) && (getIntent().getBooleanExtra("isVideo", false))) {
      i1 = 4;
    }
    this.aE = QAVConfigUtils.a(i1);
    localObject3 = this.aE;
    if ((localObject3 != null) && (!TextUtils.isEmpty(((QAVConfigUtils.MoreBtnTips)localObject3).b)))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      this.aF = URLDrawable.getDrawable(this.aE.b, (URLDrawable.URLDrawableOptions)localObject3);
      this.aG = false;
      this.aF.setURLDrawableListener(new AVActivity.8(this));
      this.aF.startDownload();
      if (1 == this.aF.getStatus()) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      this.aG = paramBoolean;
      ReportController.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.aE.a, "", "", "", "");
      localObject3 = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. getDrawableAndToDownloadImage. mMoreBtnTipsImageDownloaded = ");
      localStringBuilder.append(this.aG);
      QLog.i((String)localObject3, 1, localStringBuilder.toString());
    }
    localObject3 = this.K;
    if (localObject3 != null)
    {
      ((VideoControlUI)localObject3).e();
      if (this.e == 9500)
      {
        localObject3 = this.K;
        if ((localObject3 instanceof DoubleVideoCtrlUI))
        {
          localObject3 = (DoubleVideoCtrlUI)localObject3;
          ((DoubleVideoCtrlUI)localObject3).a(2131441026, this.I.aa, 2130843005);
          if (!this.I.ac) {
            ((DoubleVideoCtrlUI)localObject3).aA.a(true, 0, false);
          }
        }
      }
    }
    if ((((SessionInfo)localObject1).i != 4) && (((SessionInfo)localObject1).u()) && (!this.u) && (this.b == 1))
    {
      localObject3 = this.G;
      if ((localObject3 != null) && (((RelativeLayout)localObject3).getParent() != null) && (!isDestroyed()))
      {
        i1 = FunCallUtil.a(this.H, ((SessionInfo)localObject1).s, true, true);
        if ((i1 > 0) && (this.Y == null)) {
          this.Y = VipFunCallManager.a(this, (RelativeLayout)this.G.getParent(), false);
        }
        int i2 = VipFunCallUtil.c();
        localObject1 = VipFunCallUtil.a(this.H, i1, i2, null);
        if (localObject1 != null) {
          if (new File((String)localObject1).exists())
          {
            localObject3 = this.H;
            if (localObject3 != null) {
              ((VideoAppInterface)localObject3).a().postDelayed(new AVActivity.9(this, (String)localObject1, i2, i1), 1000L);
            }
          }
          else
          {
            localObject3 = this.i;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("funcall --> !file.exists() + path:");
            localStringBuilder.append((String)localObject1);
            QLog.e((String)localObject3, 1, localStringBuilder.toString());
          }
        }
      }
    }
    this.ac = ((QavRecordButtonView)findViewById(2131444486));
    a(paramLong, "onCreateUI", false);
    localObject1 = this.L;
    if (localObject1 != null) {
      ((VideoLayerUI)localObject1).o(0);
    }
    localObject1 = (RelativeLayout)findViewById(2131449700);
    if ((localObject1 != null) && (QavVideoRecordUICtrl.v()))
    {
      this.ad = new QavVideoRecordUICtrl(this, (RelativeLayout)localObject1, this.I, this.H, this.G, this.K);
      this.ad.c(1);
      localObject1 = this.L;
      if (localObject1 != null) {
        ((VideoLayerUI)localObject1).a(this.ad);
      }
    }
    A();
    AVVoiceRecog.b().a(this.H, this);
    localObject1 = new AVActivity.10(this);
    new Handler().post((Runnable)localObject1);
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    String str = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.H.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    Object localObject1 = (EffectFaceManager)this.H.c(3);
    Object localObject2 = ((EffectFaceManager)localObject1).e(paramString);
    if (localObject2 != null)
    {
      long l1 = AudioHelper.c();
      boolean bool;
      if ((!((FaceItem)localObject2).isUsable()) && (!TextUtils.isEmpty(((FaceItem)localObject2).getResUrl()))) {
        bool = false;
      } else {
        bool = true;
      }
      String str = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAVVoiceRecogComplete, recogResult[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isResReady[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (bool)
      {
        new ControlUIObserver.RequestPlayMagicFace(l1, ((FaceItem)localObject2).getId(), true, 2).a(this.H);
        VoiceRecogTips.c(this.H, paramString);
        ReportController.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", ((FaceItem)localObject2).getId());
        return;
      }
      ((EffectFaceManager)localObject1).b(l1, (ItemBase)localObject2);
      return;
    }
    localObject1 = this.i;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onAVVoiceRecogComplete. recogResult = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", paly voice sticker falied. voiceStickerItem == null.");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  void a(String paramString, long paramLong)
  {
    Object localObject = findViewById(2131441197);
    if (localObject == null) {
      return;
    }
    if (((View)localObject).getVisibility() == 0)
    {
      ((View)localObject).setVisibility(4);
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. hide_qav_more_tips. from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      paramString = this.aE;
      if (paramString != null)
      {
        QAVConfigUtils.b(paramString.a);
        this.aE = null;
        this.aF = null;
        this.aG = false;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDoubleMeeting, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.A);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.A != paramBoolean) {
      this.A = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RedTouch localRedTouch = this.ah;
    if (localRedTouch != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localRedTouch.setVisibility(i1);
    }
  }
  
  View b(long paramLong)
  {
    Object localObject1;
    Object localObject2;
    if ((this.aE != null) && (this.aG))
    {
      if (!this.K.ab())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, 工具栏没显示, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      Object localObject3 = findViewById(2131441304);
      if (localObject3 == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, !MORE, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      if (((View)localObject3).getVisibility() != 0)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, more按钮没显示出来, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      localObject1 = (ImageView)findViewById(2131441197);
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, !qav_more_tips, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      if (((ImageView)localObject1).getVisibility() == 0)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.i;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, qav_more_tips已经在显示中了, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      localObject2 = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = ");
      localStringBuilder.append(this.aG);
      localStringBuilder.append(", mMoreBtnTips = ");
      localStringBuilder.append(this.aE);
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      ((ImageView)localObject1).setImageDrawable(this.aF);
      int i1 = AIOUtils.b(10.0F, getResources());
      double d1 = 25 * getResources().getDisplayMetrics().density;
      Double.isNaN(d1);
      int i2 = (int)(d1 / 1.5D);
      localObject2 = new int[2];
      ((View)localObject3).getLocationInWindow((int[])localObject2);
      int i3 = ((View)localObject3).getWidth();
      int i4 = ((View)localObject3).getHeight();
      int i5 = localObject2[0] + i3 / 2;
      int i6 = localObject2[1] + i4 + i1;
      d1 = this.aF.getIntrinsicWidth();
      Double.isNaN(d1);
      int i7 = (int)(d1 / 1.5D);
      d1 = this.aF.getIntrinsicHeight();
      Double.isNaN(d1);
      int i8 = (int)(d1 / 1.5D);
      int i9 = i5 - i7 + i2;
      localObject3 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i6;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = i9;
      ((RelativeLayout.LayoutParams)localObject3).width = i7;
      ((RelativeLayout.LayoutParams)localObject3).height = i8;
      localObject3 = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. offset[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], left_more[");
      localStringBuilder.append(localObject2[0]);
      localStringBuilder.append("], top_more[");
      localStringBuilder.append(localObject2[1]);
      localStringBuilder.append("], width_more[");
      localStringBuilder.append(i3);
      localStringBuilder.append("], height_more[");
      localStringBuilder.append(i4);
      localStringBuilder.append("], width_tips[");
      localStringBuilder.append(i7);
      localStringBuilder.append("], height_tips[");
      localStringBuilder.append(i8);
      localStringBuilder.append("], arrow[");
      localStringBuilder.append(i2);
      localStringBuilder.append("], dockLeft[");
      localStringBuilder.append(i5);
      localStringBuilder.append("], dockTop[");
      localStringBuilder.append(i6);
      localStringBuilder.append("], tipsTop[");
      localStringBuilder.append(i6);
      localStringBuilder.append("], tipsLeft[");
      localStringBuilder.append(i9);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject3, 1, localStringBuilder.toString());
      return localObject1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, 没有tips需要显示或者已经显示过, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return null;
    }
    return null;
  }
  
  void b()
  {
    EffectMaterialHandler localEffectMaterialHandler = (EffectMaterialHandler)this.H.getBusinessHandler(EffectMaterialHandler.class.getName());
    localEffectMaterialHandler.a("QQAVSinglePendantV2", "9");
    localEffectMaterialHandler.a("QQAVDoublePendantV2", "9");
    localEffectMaterialHandler.a("QQAVAvatar2d", "9");
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  void b(long paramLong, String paramString, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i2 = 1;
    int i1;
    if (bool)
    {
      i1 = -1;
      Object localObject = this.ac;
      if (localObject != null) {
        if (((QavRecordButtonView)localObject).getVisibility() == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryShowRecordBtn[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], bShown[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], visibility[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    paramString = this.I.k();
    if ((!QavVideoRecordUICtrl.A()) && (this.ad != null) && (!paramString.r()))
    {
      int i3 = paramString.g;
      i1 = i2;
      if (i3 != 1) {
        if (i3 == 2) {
          i1 = i2;
        } else {
          i1 = 0;
        }
      }
      if (paramBoolean)
      {
        if ((i1 != 0) && (paramString.cD))
        {
          this.ad.d(this.V);
          this.ad.h();
        }
        if (i1 == 0)
        {
          paramString = this.ac;
          if ((paramString != null) && (paramString.getVisibility() == 0))
          {
            this.at.removeMessages(272);
            a(paramLong, "tryShowRecordBtn.1", false);
          }
        }
        else
        {
          this.at.removeMessages(272);
          paramString = this.at.obtainMessage(272);
          paramString.obj = Long.valueOf(paramLong);
          this.at.sendMessageDelayed(paramString, 50L);
        }
      }
      else if (i1 != 0)
      {
        if (this.I.k().cD)
        {
          this.ad.d(0);
          this.ad.h();
          this.ad.B();
        }
        this.at.removeMessages(272);
        a(paramLong, "tryShowRecordBtn.2", false);
        paramString = this.L;
        if (paramString != null) {
          paramString.o(0);
        }
      }
      return;
    }
    paramString = this.ac;
    if ((paramString != null) && (paramString.getVisibility() != 8)) {
      this.ac.setVisibility(8);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.L;
    if ((localObject != null) && (((VideoLayerUI)localObject).V())) {
      return;
    }
    long l1 = AudioHelper.c();
    localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNeedChangeDoubleScreenMode, id[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], hasChangeDoubleScreen[");
    localStringBuilder.append(this.I.k().aM);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    getResources();
    if (!this.I.k().aM)
    {
      this.I.k().a(true);
      a(2, false);
      TipsUtil.a(this.H, 1043);
      return;
    }
    TipsUtil.a(this.H, 1044, null, new AVActivity.20(this, paramString, l1));
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131428980), paramBoolean);
  }
  
  void c()
  {
    if (this.R == null) {
      this.R = new AVActivity.VideoOrientationEventListener(this, super.getApplicationContext(), 2);
    }
  }
  
  void c(long paramLong)
  {
    if (this.I == null) {
      return;
    }
    e();
    if (this.L != null)
    {
      localObject = this.ay;
      if ((localObject == null) || (((SmallScreenActivityPlugin)localObject).c()))
      {
        if (this.I.k().g == 4)
        {
          localObject = this.I.k().bi;
          int i1 = 0;
          while (i1 < ((ArrayList)localObject).size())
          {
            VideoViewInfo localVideoViewInfo = (VideoViewInfo)((ArrayList)localObject).get(i1);
            String str = CharacterUtil.a(localVideoViewInfo.a);
            int i2 = localVideoViewInfo.b;
            boolean bool;
            if ((localVideoViewInfo.g != 5L) && (localVideoViewInfo.g != 14L)) {
              bool = false;
            } else {
              bool = true;
            }
            if (!str.equals(this.H.getCurrentAccountUin())) {
              this.L.a(paramLong, str, i2, false, false, bool);
            }
            i1 += 1;
          }
        }
        this.M.closeCamera(paramLong, false);
        this.L.b(paramLong, false, false);
      }
      this.L.W();
    }
    Object localObject = this.K;
    if (localObject != null) {
      ((VideoControlUI)localObject).a_(paramLong);
    }
    localObject = this.N;
    if (localObject != null) {
      ((ChildGuideUi)localObject).d();
    }
    h();
    this.I.a(true);
    this.I.h(false);
    localObject = this.ay;
    if (localObject != null) {
      ((SmallScreenActivityPlugin)localObject).a(paramLong, this.y);
    }
    localObject = this.ai;
    if (localObject != null) {
      ((VideoChatRoomUIContoller)localObject).e();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    VideoLayerUI localVideoLayerUI = this.L;
    if (localVideoLayerUI != null) {
      localVideoLayerUI.g(paramBoolean);
    }
  }
  
  public WatchTogetherUIProxy d(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (paramBoolean)
    {
      if (this.aA == null)
      {
        ((ViewStub)findViewById(2131441331)).inflate();
        localRelativeLayout = (RelativeLayout)findViewById(2131441330);
        this.aA = ((IUIProxy)QRoute.api(IUIProxy.class)).getAdminControlView(this);
        localRelativeLayout.addView((View)this.aA, new RelativeLayout.LayoutParams(-1, -1));
      }
      return this.aA;
    }
    if (this.aB == null)
    {
      ((ViewStub)findViewById(2131441333)).inflate();
      localRelativeLayout = (RelativeLayout)findViewById(2131441332);
      this.aB = ((IUIProxy)QRoute.api(IUIProxy.class)).getOrdinaryControlView(this);
      localRelativeLayout.addView((View)this.aB, new RelativeLayout.LayoutParams(-1, -1));
    }
    return this.aB;
  }
  
  void d()
  {
    AVActivity.VideoOrientationEventListener localVideoOrientationEventListener = this.R;
    if (localVideoOrientationEventListener != null) {
      localVideoOrientationEventListener.enable();
    }
  }
  
  void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.i);
      ((StringBuilder)localObject1).append("|VideoNodeManager");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processExtraData, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      QLog.d(this.i, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.a("AVActivity.processExtraData", localIntent.getExtras());
    int i3 = localIntent.getIntExtra("sessionType", 0);
    SessionInfo localSessionInfo = this.I.k();
    int i2 = localSessionInfo.g;
    Object localObject3 = localIntent.getStringExtra("Fromwhere");
    boolean bool = localIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    a("processExtraData", bool);
    if ("AVNotification".equals(localObject3))
    {
      if (((localSessionInfo.i == 2) || (localSessionInfo.i == 13)) && (i3 != 1) && (i3 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.i, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (!localSessionInfo.am)
        {
          this.I.a(paramLong, localSessionInfo.s, 1, true);
          this.I.a(localSessionInfo.s, 230);
          this.I.b(230);
        }
        else
        {
          l1 = Long.valueOf(localSessionInfo.s).longValue();
          this.I.a(paramLong, 3, l1);
          this.I.a(paramLong, l1, 1);
        }
      }
      if (localSessionInfo.p == 1) {
        if (localSessionInfo.o == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
        }
      }
      if (bool) {
        ReportController.b(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
      }
    }
    if (i3 == 0)
    {
      AVLog.printAllUserLog(this.i, "processExtraData-->can not get session type in intent.");
      ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1015L);
      finish();
      return;
    }
    int i1;
    if ((i3 != 1) && (i3 != 2))
    {
      if ((i3 != 3) && (i3 != 4))
      {
        localObject2 = null;
      }
      else
      {
        localObject2 = localIntent.getStringExtra("GroupId");
        i1 = localIntent.getIntExtra("MeetingConfID", 0);
        i4 = localIntent.getIntExtra("ConfAppID", 0);
        int i5 = localIntent.getIntExtra("MeetingStasks", -1);
        localSessionInfo.bO = i1;
        localSessionInfo.bP = i4;
        localSessionInfo.bQ = i5;
      }
    }
    else {
      localObject2 = localIntent.getStringExtra("uin");
    }
    Object localObject1 = localObject2;
    if ("AVNotification".equals(localObject3)) {
      if ((i3 != 1) && (i3 != 2))
      {
        if (i3 != 3)
        {
          localObject1 = localObject2;
          if (i3 != 4) {}
        }
        else if (bool)
        {
          localObject1 = localSessionInfo.s;
        }
        else
        {
          localObject1 = String.valueOf(this.I.k);
        }
      }
      else {
        localObject1 = localSessionInfo.s;
      }
    }
    if (localObject1 == null)
    {
      AVLog.printAllUserLog(this.i, "processExtraData-->can not get uin in intent.");
      ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
      finish();
      return;
    }
    if ((i2 != 1) && (i2 != 2))
    {
      if ((i2 != 3) && (i2 != 4))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.i, 2, "original session type is none");
        }
        localObject2 = null;
        i1 = 0;
      }
      else
      {
        localObject3 = String.valueOf(this.I.k);
        i1 = this.I.l;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          AVLog.printAllUserLog(this.i, "can not get the original group uin");
          ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
          finish();
        }
      }
    }
    else
    {
      localObject3 = localSessionInfo.s;
      i1 = UITools.b(localSessionInfo.p);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        AVLog.printAllUserLog(this.i, "can not get the original peeruin");
        ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
        finish();
        return;
      }
    }
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject3 = this.i;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("processExtraData-->IntentSessionType=");
      ((StringBuilder)localObject4).append(i3);
      ((StringBuilder)localObject4).append(", OriginalSessionType=");
      ((StringBuilder)localObject4).append(i2);
      ((StringBuilder)localObject4).append(", IntentUin=");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
    }
    if ((localObject2 != null) && (QLog.isColorLevel()))
    {
      localObject3 = this.i;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("processExtraData-->OriginalUin=");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(", originalRelationType=");
      ((StringBuilder)localObject4).append(i1);
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
    }
    if (i2 == 0) {
      e(paramLong);
    }
    do
    {
      for (;;)
      {
        localObject2 = localObject1;
        break label2113;
        if ((i2 == 3) || (i2 == 4)) {
          break;
        }
        if (((i2 == 1) || (i2 == 2)) && ((i3 == 1) || (i3 == 2)))
        {
          i1 = localIntent.getIntExtra("uinType", -1);
          if ((i1 != -1) && (i1 != localSessionInfo.p))
          {
            if (QLog.isColorLevel()) {
              QLog.w(this.i, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
            }
            this.I.a(false, 203, new int[] { localSessionInfo.o });
            this.I.b(203);
            localObject2 = this.K;
            if (localObject2 != null)
            {
              ((VideoControlUI)localObject2).d(paramLong);
              this.K = null;
            }
            localObject3 = localSessionInfo.s;
            localObject2 = SessionMgr.a(3, (String)localObject3, new int[0]);
            Object localObject5 = SessionMgr.a().d((String)localObject2);
            if (localObject5 == null)
            {
              localObject1 = this.i;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Can not get SessionInfo : SessionId = ");
              ((StringBuilder)localObject3).append((String)localObject2);
              AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject3).toString());
              finish();
              return;
            }
            localObject4 = ((SessionInfo)localObject5).u;
            i1 = localSessionInfo.p;
            localObject5 = ((SessionInfo)localObject5).aW;
            this.I.a((String)localObject3, 231);
            this.I.b(231);
            this.I.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject3, (String)localObject4, 0, (String)localObject5, false, true);
            e(paramLong);
            localObject2 = SessionMgr.a(3, this.j, new int[0]);
            localObject3 = SessionMgr.a().a((String)localObject2, false);
            ((SessionInfo)localObject3).B = true;
            ((SessionInfo)localObject3).a("processExtraData", 2);
            ((SessionInfo)localObject3).bp = false;
            if (!((String)localObject2).equals(this.d)) {
              this.d = ((String)localObject2);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w(this.i, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
            }
            this.b = localSessionInfo.g;
            a("processExtraData", localSessionInfo.am);
            this.e = localSessionInfo.p;
            this.j = localSessionInfo.s;
            this.l = localSessionInfo.t;
            this.s = localSessionInfo.z;
            this.f = localSessionInfo.az;
            this.t = localSessionInfo.aB;
            this.g = localSessionInfo.aA;
            this.p = localSessionInfo.u;
            this.m = localSessionInfo.w;
            this.u = localSessionInfo.B;
            this.v = localSessionInfo.aK;
            this.w = localSessionInfo.P;
            this.x = localSessionInfo.as;
          }
        }
      }
      if ((i3 == 1) || (i3 == 2)) {
        break label2460;
      }
    } while ((i3 != 3) && (i3 != 4));
    long l1 = Long.valueOf((String)localObject1).longValue();
    int i4 = localIntent.getIntExtra("MultiAVType", 0);
    localSessionInfo.bF = localIntent.getBooleanExtra("disableInvite", false);
    if ((localSessionInfo.o != 0) && (i4 != localSessionInfo.o) && (i4 != 0)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    localSessionInfo.b(i4);
    if (!bool)
    {
      if ((((String)localObject1).compareTo((String)localObject2) != 0) && (this.I.j))
      {
        localObject3 = this.I;
        ((VideoController)localObject3).a(i1, ((VideoController)localObject3).k, 98);
        localSessionInfo.b(i4);
      }
      if (i2 != 0)
      {
        localObject3 = this.I;
        ((VideoController)localObject3).a(i1, ((VideoController)localObject3).k, 99);
        localSessionInfo.b(i4);
        localSessionInfo.a(paramLong, "processExtraData.1", 3);
      }
      localSessionInfo.d("processExtraData.1", localIntent.getIntExtra("Type", -1));
      localSessionInfo.aN = l1;
      localObject3 = localObject1;
      this.k = ((String)localObject3);
      if (((String)localObject3).compareTo((String)localObject2) == 0)
      {
        if (i2 != 0)
        {
          this.b = i3;
          i1 = localIntent.getIntExtra("uinType", -1);
          localSessionInfo.p = i1;
          this.e = i1;
          this.p = localSessionInfo.u;
          if (localSessionInfo.aP == -1) {
            localSessionInfo.d("processExtraData.2", 0);
          }
          this.w = localSessionInfo.P;
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = this.i;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("processExtraData multiAVType: ");
            ((StringBuilder)localObject2).append(localSessionInfo.o);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            localObject1 = localObject3;
          }
        }
        else
        {
          this.b = localSessionInfo.g;
          localObject1 = localObject3;
        }
      }
      else
      {
        localSessionInfo.a(paramLong, "processExtraData.2", i3);
        localSessionInfo.p = localIntent.getIntExtra("uinType", -1);
        if ((localSessionInfo.aP == 0) || (localSessionInfo.aP == 1)) {
          localSessionInfo.aO = localIntent.getLongArrayExtra("DiscussUinList");
        }
        this.b = i3;
        localObject1 = localObject3;
      }
    }
    else
    {
      localSessionInfo.s = ((String)localObject1);
      this.b = i3;
      this.j = ((String)localObject1);
    }
    Object localObject2 = localObject1;
    if (i2 == 0)
    {
      this.e = localSessionInfo.p;
      this.p = localSessionInfo.u;
      this.w = localSessionInfo.P;
      localObject2 = localObject1;
    }
    label2113:
    if ("AIOQAVWatchTogether".equals(this.q)) {
      c(localIntent);
    }
    localObject1 = this.i;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("processExtraData, mSessionType[");
    ((StringBuilder)localObject3).append(this.b);
    ((StringBuilder)localObject3).append("], mUinType[");
    ((StringBuilder)localObject3).append(this.e);
    ((StringBuilder)localObject3).append("], mPeerUin[");
    ((StringBuilder)localObject3).append(this.j);
    ((StringBuilder)localObject3).append("], mPeerName[");
    ((StringBuilder)localObject3).append(this.l);
    ((StringBuilder)localObject3).append("], mPhoneNum[");
    ((StringBuilder)localObject3).append(this.m);
    ((StringBuilder)localObject3).append("], mSelfNation[");
    ((StringBuilder)localObject3).append(this.n);
    ((StringBuilder)localObject3).append("], mSelfMobile[");
    ((StringBuilder)localObject3).append(this.o);
    ((StringBuilder)localObject3).append("], mIsReceiver[");
    ((StringBuilder)localObject3).append(this.u);
    ((StringBuilder)localObject3).append("], mIsAudioMode[");
    ((StringBuilder)localObject3).append(this.v);
    ((StringBuilder)localObject3).append("], mExtraUin[");
    ((StringBuilder)localObject3).append(this.p);
    ((StringBuilder)localObject3).append("], mIsPeerNetworkWell[");
    ((StringBuilder)localObject3).append(this.w);
    ((StringBuilder)localObject3).append("], mIsFriend[");
    ((StringBuilder)localObject3).append(this.x);
    ((StringBuilder)localObject3).append("], mFromWhere[");
    ((StringBuilder)localObject3).append(this.q);
    ((StringBuilder)localObject3).append("], intentUinStr[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("], \nsession[");
    ((StringBuilder)localObject3).append(localSessionInfo);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
    HexUtil.printHexString(this.i, this.h);
    return;
    label2460:
    this.I.a(i1, Long.valueOf((String)localObject2).longValue(), 97);
    e(paramLong);
    localObject1 = SessionMgr.a(3, this.j, new int[0]);
    if (!SessionMgr.a().a((String)localObject1))
    {
      localObject2 = SessionMgr.a().a((String)localObject1, false);
      ((SessionInfo)localObject2).B = false;
      ((SessionInfo)localObject2).a("processExtraData", 0);
      ((SessionInfo)localObject2).bp = false;
      if (!((String)localObject1).equals(this.d)) {
        this.d = ((String)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.i, 2, "mutivideo to doublevideo bug fix call");
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (i1 == 1)) {
      a("dispatchTouchEvent up", AudioHelper.c());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e()
  {
    AVActivity.VideoOrientationEventListener localVideoOrientationEventListener = this.R;
    if (localVideoOrientationEventListener != null) {
      localVideoOrientationEventListener.disable();
    }
  }
  
  void e(long paramLong)
  {
    SessionInfo localSessionInfo = this.I.k();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("processIntentData begin, isProcessCreate[");
    ((StringBuilder)localObject2).append(this.H.i);
    ((StringBuilder)localObject2).append("], isMsfRecv[");
    ((StringBuilder)localObject2).append(this.H.j);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], \nSessionInfo[");
    ((StringBuilder)localObject2).append(localSessionInfo);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if ((!this.H.i) && (!this.H.j))
    {
      VideoNodeManager.a();
    }
    else
    {
      localObject1 = this.H;
      ((VideoAppInterface)localObject1).i = false;
      ((VideoAppInterface)localObject1).j = false;
    }
    VideoNodeManager.a(26);
    localObject2 = super.getIntent();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append("_processIntentData");
    AudioHelper.a(((StringBuilder)localObject1).toString(), ((Intent)localObject2).getExtras());
    this.b = ((Intent)localObject2).getIntExtra("sessionType", 0);
    this.e = ((Intent)localObject2).getIntExtra("uinType", -1);
    this.j = ((Intent)localObject2).getStringExtra("uin");
    this.s = ((Intent)localObject2).getStringExtra("dstClient");
    boolean bool = ((Intent)localObject2).getBooleanExtra("isDoubleVideoMeeting", false);
    if ("AIOShareScreen".equals(((Intent)localObject2).getStringExtra("Fromwhere")))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.i;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("processIntentData, from share screen. uinType[");
        ((StringBuilder)localObject3).append(this.e);
        ((StringBuilder)localObject3).append("]");
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject3).toString());
      }
      if (this.e == 0) {
        bool = true;
      }
      localSessionInfo.ci = 4;
      if (bool) {
        localObject1 = SessionMgr.a(100, this.j, new int[0]);
      } else {
        localObject1 = SessionMgr.a(1, ((Intent)localObject2).getStringExtra("GroupId"), new int[0]);
      }
      ScreenShareReportHelper.a((String)localObject1, 1, "processIntentData");
    }
    a("processIntentData", bool);
    this.t = ((Intent)localObject2).getStringExtra("bindId");
    this.f = ((Intent)localObject2).getIntExtra("bindType", 0);
    this.c = ((Intent)localObject2).getIntExtra("subServiceType", 0);
    this.g = ((Intent)localObject2).getIntExtra("extraType", 0);
    this.l = ((Intent)localObject2).getStringExtra("name");
    this.n = ((Intent)localObject2).getStringExtra("selfNation");
    this.o = ((Intent)localObject2).getStringExtra("selfMobile");
    this.m = ((Intent)localObject2).getStringExtra("toMobile");
    this.u = ((Intent)localObject2).getBooleanExtra("receive", false);
    this.v = ((Intent)localObject2).getBooleanExtra("isAudioMode", true);
    this.C = ((Intent)localObject2).getLongExtra("main_timestamp", 0L);
    this.p = ((Intent)localObject2).getStringExtra("extraUin");
    localObject1 = ((Intent)localObject2).getStringExtra("extraCode");
    Object localObject3 = ((Intent)localObject2).getByteArrayExtra("sig");
    this.w = ((Intent)localObject2).getBooleanExtra("isPeerNetworkWell", false);
    this.x = ((Intent)localObject2).getBooleanExtra("isFriend", false);
    this.q = ((Intent)localObject2).getStringExtra("from");
    this.z = ((Intent)localObject2).getBooleanExtra("shutCamera", false);
    ((Intent)localObject2).getStringExtra("headUrl");
    this.D = VipFunCallUtil.a(this.H, this.j, 3, true, null);
    this.E = ((Intent)localObject2).getIntExtra("vipType", 0);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("==> AVActivity processIntentData() mSessionType = ");
    ((StringBuilder)localObject4).append(this.b);
    ((StringBuilder)localObject4).append("  mIsAudioMode = ");
    ((StringBuilder)localObject4).append(this.v);
    AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject4).toString());
    VideoNodeManager.b(this.b);
    long l1;
    if (this.v) {
      l1 = 1L;
    } else {
      l1 = 2L;
    }
    VideoNodeManager.a(13, l1);
    if ((this.e == 0) && (this.u)) {
      this.x = this.H.c(this.j);
    }
    int i1 = this.e;
    if (i1 == 1008)
    {
      if (localObject3 != null)
      {
        this.h = new byte[localObject3.length + 3];
        localObject4 = this.h;
        localObject4[0] = 1;
        localObject4[1] = 1;
        localObject4[2] = -116;
        System.arraycopy(localObject3, 0, localObject4, 3, localObject3.length);
      }
      else
      {
        this.h = new byte[] { 1, 1, -118 };
      }
    }
    else if (i1 == 1011)
    {
      if (localObject3 != null)
      {
        this.h = new byte[localObject3.length + 3];
        localObject4 = this.h;
        localObject4[0] = 1;
        localObject4[1] = 1;
        localObject4[2] = -118;
        System.arraycopy(localObject3, 0, localObject4, 3, localObject3.length);
      }
      else
      {
        this.h = new byte[] { 1, 1, -118 };
      }
    }
    else {
      this.h = ((byte[])localObject3);
    }
    AVReport.a().ak = this.j;
    i1 = this.b;
    if ((i1 != 3) && (i1 != 4))
    {
      localSessionInfo.br = ((Intent)localObject2).getBooleanExtra("isOtherTerminalOnChating", false);
      if (localSessionInfo.br)
      {
        localSessionInfo.bt = ((Intent)localObject2).getLongExtra("otherTerminalChatingRoomId", 0L);
        localSessionInfo.bu = ((Intent)localObject2).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    else
    {
      localSessionInfo.d("processIntentData", ((Intent)localObject2).getIntExtra("Type", -1));
      localObject3 = ((Intent)localObject2).getStringExtra("GroupId");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        AVLog.printAllUserLog(this.i, "relationIdStr is null");
        this.y = true;
        ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
        finish();
        return;
      }
      int i2 = ((Intent)localObject2).getIntExtra("MultiAVType", 0);
      i1 = i2;
      if (i2 == 0)
      {
        i2 = localSessionInfo.o;
        i1 = i2;
        if (QLog.isColorLevel())
        {
          localObject4 = this.i;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Not get avtype inside intent default value: ");
          localStringBuilder.append(i2);
          QLog.d((String)localObject4, 2, localStringBuilder.toString());
          i1 = i2;
        }
      }
      localSessionInfo.b(i1);
      if (localObject3 != null)
      {
        localSessionInfo.aN = Long.valueOf((String)localObject3).longValue();
        this.k = ((String)localObject3);
      }
      localSessionInfo.aO = ((Intent)localObject2).getLongArrayExtra("DiscussUinList");
      localSessionInfo.bF = ((Intent)localObject2).getBooleanExtra("disableInvite", false);
    }
    if (this.b == 0)
    {
      AVLog.printAllUserLog(this.i, "invalid sessionType!!!");
      this.y = true;
      ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1015L);
      finish();
      return;
    }
    bool = false;
    i1 = ((Intent)localObject2).getIntExtra("remoteStatus", 0);
    if (this.u)
    {
      if (TextUtils.isEmpty(this.j))
      {
        AVLog.printAllUserLog(this.i, "uin is empty");
        this.y = true;
        ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.l)) {
        this.l = this.j;
      }
    }
    else if (this.e == 1006)
    {
      if (TextUtils.isEmpty(this.m))
      {
        AVLog.printAllUserLog(this.i, "phoneNum is empty");
        this.y = true;
        ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
        finish();
        return;
      }
      this.j = this.m;
      if (TextUtils.isEmpty(this.l)) {
        this.l = this.m;
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.j))
      {
        AVLog.printAllUserLog(this.i, "Create video failed because uin is empty");
        this.y = true;
        ((VideoNodeReporter)this.H.c(4)).a(localSessionInfo.D(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.l)) {
        this.l = this.j;
      }
    }
    localSessionInfo.a(paramLong, "processIntentData", this.b);
    localSessionInfo.p = this.e;
    localSessionInfo.s = this.j;
    localSessionInfo.t = this.l;
    localSessionInfo.u = this.p;
    localSessionInfo.v = ((String)localObject1);
    localSessionInfo.a(this.m);
    if (!TextUtils.isEmpty(this.j)) {
      Looper.myQueue().addIdleHandler(this.aD);
    }
    localSessionInfo.B = this.u;
    localSessionInfo.aK = this.v;
    localSessionInfo.P = this.w;
    localSessionInfo.x = this.n;
    localSessionInfo.y = this.o;
    localSessionInfo.z = this.s;
    localSessionInfo.aB = this.t;
    localSessionInfo.az = this.f;
    localSessionInfo.aA = this.g;
    localSessionInfo.aH = this.h;
    localSessionInfo.as = this.x;
    localSessionInfo.h = this.b;
    localSessionInfo.M = this.z;
    localSessionInfo.X = this.D;
    localSessionInfo.Y = this.E;
    if (i1 == 4) {
      bool = true;
    }
    localSessionInfo.Q = bool;
    localSessionInfo.K = ((Intent)localObject2).getIntExtra("friendTerminal", 3);
    localSessionInfo.f("processIntentData", this.A);
    localSessionInfo.Z = this.c;
    localSessionInfo.aa = ((Intent)localObject2).getStringExtra("actId");
    localSessionInfo.ab = ((Intent)localObject2).getStringExtra("mp_ext_params");
    localSessionInfo.A = this.C;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("processIntentData end, mRelationId[");
    ((StringBuilder)localObject2).append(this.k);
    ((StringBuilder)localObject2).append("], bStartByTerminalSwitch[");
    ((StringBuilder)localObject2).append(localSessionInfo.br);
    ((StringBuilder)localObject2).append("], terSwitchStartFromVideoEntry[");
    ((StringBuilder)localObject2).append(localSessionInfo.bu);
    ((StringBuilder)localObject2).append("], \nSessionInfo[");
    ((StringBuilder)localObject2).append(localSessionInfo);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onZimuModeChange, inZimu[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((this.I != null) && (this.K != null))
    {
      localObject = this.ad;
      if (localObject != null)
      {
        ((QavVideoRecordUICtrl)localObject).i = paramBoolean;
        int i1;
        if (paramBoolean) {
          i1 = 0;
        } else {
          i1 = this.V;
        }
        ((QavVideoRecordUICtrl)localObject).d(i1);
        this.ad.h();
      }
    }
  }
  
  void f()
  {
    if ((this.av == null) && (this.aw == null))
    {
      this.av = ((SensorManager)getSystemService("sensor"));
      this.aw = this.av.getDefaultSensor(1);
    }
  }
  
  void f(long paramLong)
  {
    Object localObject = (InputMethodManager)getSystemService("input_method");
    if (((InputMethodManager)localObject).isActive())
    {
      boolean bool;
      int i1;
      if ((getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null))
      {
        bool = ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        i1 = 1;
      }
      else
      {
        bool = ((InputMethodManager)localObject).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        i1 = 2;
      }
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeIME , InputMethodManager, result[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], step[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.H == null) {
      return;
    }
    ImmersiveUtils.setStatusTextColor(false, getWindow());
  }
  
  public void finish()
  {
    boolean bool = TextUtils.isEmpty(this.q);
    int i1 = 1;
    if ((!bool) && (this.q.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    Object localObject1 = this.i;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo life_finish, FromWhere[");
    ((StringBuilder)localObject2).append(this.q);
    ((StringBuilder)localObject2).append("]");
    AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = SessionMgr.a().b();
    if (((SessionInfo)localObject1).cB)
    {
      localObject2 = this.ad;
      if (localObject2 != null)
      {
        ((QavVideoRecordUICtrl)localObject2).e();
        if (this.ad.g() < 1000L) {
          i1 = 2;
        }
        ((SessionInfo)localObject1).cE = i1;
        ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      }
    }
    if ((this.y) && (((SessionInfo)localObject1).ch) && (this.H != null))
    {
      localObject2 = String.valueOf(((SessionInfo)localObject1).aN);
      String str = this.H.a(this.e, (String)localObject2, ((SessionInfo)localObject1).u);
      Intent localIntent = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
      localIntent.putExtra("uin", (String)localObject2);
      localIntent.putExtra("uintype", ((SessionInfo)localObject1).p);
      localIntent.putExtra("uinname", str);
      startActivity(localIntent);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("finish fromDoubleChat[");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject1).ch);
      ((StringBuilder)localObject2).append("], session[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject2).toString());
    }
    super.finish();
  }
  
  void g()
  {
    SensorManager localSensorManager = this.av;
    if (localSensorManager != null)
    {
      Sensor localSensor = this.aw;
      if (localSensor != null) {
        localSensorManager.registerListener(this, localSensor, 2);
      }
    }
  }
  
  void g(long paramLong)
  {
    Object localObject = this.M;
    if (localObject != null)
    {
      if (!((ICameraManagerApi)localObject).isCameraOpened(paramLong)) {
        return;
      }
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRotateMenu, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      n();
      localObject = ActionSheet.createMenuSheet(this);
      ((ActionSheet)localObject).getWindow().addFlags(524288);
      ((ActionSheet)localObject).getWindow().addFlags(2097152);
      ((ActionSheet)localObject).getWindow().addFlags(128);
      ((ActionSheet)localObject).addButton(2131917909);
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnButtonClickListener(new AVActivity.18(this));
      ((ActionSheet)localObject).setOnDismissListener(new AVActivity.19(this));
      ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
      ((ActionSheet)localObject).setAnimationTime(150);
      this.ar = ((Dialog)localObject);
    }
    try
    {
      this.ar.show();
      this.aq = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void g(boolean paramBoolean)
  {
    if (a(getWindow(), paramBoolean)) {
      this.as = paramBoolean;
    }
  }
  
  public int getRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  void h()
  {
    SensorManager localSensorManager = this.av;
    if ((localSensorManager != null) && (this.aw != null)) {
      localSensorManager.unregisterListener(this);
    }
  }
  
  public void h(long paramLong)
  {
    a(paramLong, 0);
  }
  
  public void h(boolean paramBoolean)
  {
    Object localObject = this.I;
    boolean bool2 = true;
    boolean bool1;
    if (((localObject == null) || (((VideoController)localObject).k() == null) || (!VideoLayerUIBase.c(this.I.k()))) && (!this.I.k().cv) && (!this.I.k().cw)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("quitDoubleScreenStatus, exit[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("],[needIntercept:=");
    localStringBuilder.append(bool1);
    localStringBuilder.append("]");
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (bool1) {
      return;
    }
    a(1, false);
    if (i())
    {
      localObject = this.L;
      if (localObject != null) {
        ((VideoLayerUI)localObject).a("onChangeUI_quitDoubleScreenStatus");
      }
    }
    if (paramBoolean) {
      a(2);
    }
    if (this.H.d(3))
    {
      localObject = (FaceItem)((EffectFaceManager)this.H.c(3)).c();
      if ((localObject != null) && (((FaceItem)localObject).isInteract()) && (((FaceItem)localObject).isSameType("face"))) {
        paramBoolean = bool2;
      } else {
        paramBoolean = false;
      }
      localObject = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_quitDoubleScreenStatus isIntactiveFace:");
      localStringBuilder.append(paramBoolean);
      AVLog.printColorLog((String)localObject, localStringBuilder.toString());
      if (paramBoolean) {
        a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool)
    {
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNotificationFlag resume[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = QAVNotification.a(this.H);
    if (localObject != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      ((QAVNotification)localObject).a(i1);
    }
  }
  
  boolean i()
  {
    VideoControlUI localVideoControlUI = this.K;
    if (localVideoControlUI == null) {
      return false;
    }
    return localVideoControlUI.p(4);
  }
  
  public boolean isDestroyed()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return super.isDestroyed();
    }
    return this.a == 5;
  }
  
  boolean j()
  {
    boolean bool2 = isDestroyed();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    VideoControlUI localVideoControlUI = this.K;
    if (localVideoControlUI != null)
    {
      if (localVideoControlUI.V()) {
        return false;
      }
      if (!this.K.aA.i(1))
      {
        if (this.K.aA.i(3)) {
          return true;
        }
        if ((i()) || (this.L.V())) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    return false;
  }
  
  void k()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131428980);
    float f1 = getResources().getDimension(2131298431);
    float f2 = getResources().getDimension(2131298434);
    int i2 = (int)f1;
    int i1 = -1;
    Object localObject = new RelativeLayout.LayoutParams(-1, i2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.aa = new EffectFilterPanel(getBaseContext(), this.H);
    this.aa.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131441334);
    if (localObject != null) {
      i1 = localViewGroup.indexOfChild((View)localObject);
    }
    localViewGroup.addView(this.aa, i1);
  }
  
  void l()
  {
    if (this.aa != null)
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131428980);
      this.aa.setVisibility(8);
      localViewGroup.removeView(this.aa);
      this.aa = null;
    }
  }
  
  int m()
  {
    if (this.H == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.B(getApplicationContext());
    String str = this.H.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showRecordTip");
    localStringBuilder.append(String.valueOf(str));
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  void n()
  {
    if (this.aq)
    {
      Dialog localDialog = this.ar;
      if ((localDialog == null) || (!localDialog.isShowing())) {}
    }
    try
    {
      this.ar.dismiss();
      label30:
      this.aq = false;
      this.ar = null;
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public SmallScreenActivityPlugin o()
  {
    return this.ay;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onActivityResult, requestCode[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], resultCode[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1002)
    {
      paramIntent = this.af;
      if (paramIntent != null) {
        paramIntent.h();
      }
    }
    else if ((Build.VERSION.SDK_INT >= 21) && (paramInt1 == 8080))
    {
      localObject = this.ag;
      if (localObject != null)
      {
        if (paramInt2 == -1)
        {
          ((ScreenRecordHelper)localObject).a(paramIntent);
          this.ag.c();
          return;
        }
        ((ScreenRecordHelper)localObject).b();
      }
    }
    else if (paramInt1 == 2020)
    {
      localObject = (WTogetherMng)this.H.c(17);
      if (localObject != null) {
        ((WTogetherMng)localObject).a(SessionMgr.a().b(), paramInt2, paramIntent);
      }
    }
    else if (paramInt1 == 21001)
    {
      this.H.B().a(paramInt2, paramIntent);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this);
  }
  
  public void onBackPressed()
  {
    if (this.ao == true)
    {
      QLog.i(this.i, 1, "avideo onBackPressed, onSaveInstanceState, return");
      return;
    }
    Object localObject = new ControlUIObserver.CPreEventInfo(null);
    this.H.a(new Object[] { Integer.valueOf(7002), localObject });
    String str = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onBackPressed, BlockSystemBack[");
    localStringBuilder.append(((ControlUIObserver.CPreEventInfo)localObject).d);
    localStringBuilder.append("], BlockName[");
    localStringBuilder.append(((ControlUIObserver.CPreEventInfo)localObject).e);
    localStringBuilder.append("]");
    QLog.i(str, 1, localStringBuilder.toString());
    boolean bool1 = ((ControlUIObserver.CPreEventInfo)localObject).d;
    boolean bool2 = bool1;
    if (!bool1)
    {
      localObject = this.ai;
      bool2 = bool1;
      if (localObject != null) {
        bool2 = ((VideoChatRoomUIContoller)localObject).d();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      localObject = this.N;
      if ((localObject != null) && (((ChildGuideUi)localObject).e()))
      {
        bool1 = this.N.h();
      }
      else
      {
        localObject = this.K;
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((VideoControlUI)localObject).o();
        }
      }
    }
    localObject = this.af;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((QavDoubleVideoSharpnessMangaer)localObject).e())
      {
        this.af.c();
        bool2 = true;
      }
    }
    if (!bool2) {
      super.onBackPressed();
    }
    this.I.b("backgroundReason", "2");
    VideoConstants.ProcessInfo.a = "2";
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject1 = SessionMgr.a().b();
    if ((localObject1 != null) && (((SessionInfo)localObject1).r()))
    {
      Object localObject2 = this.I.aA();
      if (localObject2 != null)
      {
        ((WatchTogetherMediaPlayCtrl)localObject2).x();
        if (QLog.isDebugVersion())
        {
          int i1 = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
          localObject2 = this.i;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onConfigurationChanged, displayRotation[");
          localStringBuilder.append(i1);
          localStringBuilder.append("]");
          QLog.d((String)localObject2, 1, localStringBuilder.toString());
        }
        localObject2 = this.L;
        if (localObject2 != null) {
          ((VideoLayerUI)localObject2).l(paramConfiguration.orientation);
        }
        if (paramConfiguration.orientation == 1) {
          if (((SessionInfo)localObject1).ct)
          {
            this.K.h("onConfigurationChanged");
          }
          else if (((SessionInfo)localObject1).af)
          {
            ((SessionInfo)localObject1).c(true);
            this.K.h("onConfigurationChanged");
          }
          else
          {
            this.K.ai();
          }
        }
        if (paramConfiguration.orientation != 1)
        {
          localObject1 = this.K;
          if ((localObject1 != null) && (((VideoControlUI)localObject1).ab())) {
            this.K.h("onConfigurationChanged");
          }
        }
      }
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append(".onCreate.begin");
    AudioHelper.b(((StringBuilder)localObject1).toString());
    long l1 = AudioHelper.c();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo life_onCreate, seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("], IS_CPU_64_BIT = ");
    ((StringBuilder)localObject2).append(false);
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    this.mIsShadow = false;
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131625711);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    g(true);
    a(super.getWindow());
    localObject1 = super.getAppRuntime();
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle != null)
      {
        QLog.d(this.i, 1, "onCreate, 尝试同步获取AppRuntime");
        paramBundle = paramBundle.getRuntime();
        localObject1 = this.i;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onCreate, 同步获取AppRuntime结果");
        if (paramBundle != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        QLog.d(this.i, 1, "onCreate, BaseApplicationImpl.getApplication is null");
        paramBundle = (Bundle)localObject1;
      }
    }
    if (paramBundle == null)
    {
      AVLog.printAllUserLog(this.i, "onCreate, appRuntime is null exit");
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131917844));
      paramBundle.append(" 0x05");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.y = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    if ((paramBundle instanceof VideoAppInterface)) {
      this.H = ((VideoAppInterface)paramBundle);
    } else {
      this.H = null;
    }
    if (this.H == null)
    {
      localObject1 = this.i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate, AppRuntime is no VideoAppInterface, ");
      ((StringBuilder)localObject2).append(paramBundle.getClass().getName());
      ((StringBuilder)localObject2).append(" exit");
      AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject2).toString());
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131917844));
      paramBundle.append(" 0x06");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.y = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    f(true);
    paramBundle = (VideoNodeReporter)this.H.c(4);
    localObject1 = SessionMgr.a().b();
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject2 = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("avideo life_onCreate roomId = ");
      localStringBuilder.append(((SessionInfo)localObject1).D());
      localStringBuilder.append(",isReceiver = ");
      localStringBuilder.append(((SessionInfo)localObject1).B);
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
      if (((SessionInfo)localObject1).B) {
        paramBundle.a(((SessionInfo)localObject1).D(), 7, 1L);
      }
    }
    else
    {
      QLog.d(this.i, 1, "avideo life_onCreate sessionInfo is null ");
    }
    boolean bool = getIntent().getBooleanExtra("isMakingAcall", false);
    if (bool) {
      paramBundle.a(-1L, 1, 1L);
    }
    paramBundle = this.i;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("avideo life_onCreate  isMakingAcall =  ");
    ((StringBuilder)localObject1).append(bool);
    QLog.d(paramBundle, 1, ((StringBuilder)localObject1).toString());
    AVReport.a().a(getIntent(), this.H.getCurrentAccountUin());
    PanoramaSensorManager.a().a(this);
    this.I = this.H.b();
    paramBundle = this.I;
    if (paramBundle == null)
    {
      AVLog.printAllUserLog(this.i, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131917844));
      paramBundle.append(" 0x07");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.y = true;
      this.H.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    if (!paramBundle.h())
    {
      AVLog.printAllUserLog(this.i, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131917844));
      paramBundle.append(" 0x08");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.y = true;
      this.H.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    this.I.w(SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(getApplicationContext())));
    localObject1 = super.getIntent();
    if (localObject1 != null)
    {
      i1 = ((Intent)localObject1).getIntExtra("uinType", -1);
      paramBundle = ((Intent)localObject1).getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject2 = SessionMgr.a(3, paramBundle, new int[0]);
        localObject2 = SessionMgr.a().d((String)localObject2);
        if ((localObject2 == null) || (((SessionInfo)localObject2).p == -1))
        {
          localObject2 = SessionMgr.a().b();
          if ((((SessionInfo)localObject2).p != -1) && ((((SessionInfo)localObject2).f()) || (((SessionInfo)localObject2).h())))
          {
            localObject1 = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            ((Intent)localObject1).setPackage(this.H.getApp().getPackageName());
            ((Intent)localObject1).putExtra("uin", paramBundle);
            ((Intent)localObject1).putExtra("uinType", i1);
            this.H.getApp().sendBroadcast((Intent)localObject1);
            this.y = true;
            this.H.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            localObject1 = this.i;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: ");
            ((StringBuilder)localObject2).append(paramBundle);
            AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject2).toString());
            finish();
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, from[");
      if (localObject1 == null) {
        paramBundle = "null";
      } else {
        paramBundle = ((Intent)localObject1).getStringExtra("Fromwhere");
      }
      localStringBuilder.append(paramBundle);
      QLog.i((String)localObject2, 2, localStringBuilder.toString());
    }
    this.H.a(this.au);
    this.H.a(this.X);
    this.H.a(this.ap);
    this.I.n.sendGetGatewayMsg();
    c();
    f();
    this.d = a(getIntent());
    if ((!TextUtils.isEmpty(this.d)) && (!b(getIntent())) && (!SessionMgr.a().a(this.d)))
    {
      paramBundle = this.I;
      paramBundle.a(false, 204, new int[] { paramBundle.k().o });
      this.I.b(204);
      SessionMgr.a().a(this.d, false);
    }
    else
    {
      this.d = SessionMgr.a().b().f;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = this.i;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate, sessionId[");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("]");
      QLog.i(paramBundle, 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.I.k().a()) {
      d(l1);
    }
    GraphicRenderMgr.getInstance();
    ThreadManager.post(new AVActivity.5(this), 5, null, false);
    this.Q = QAVNotification.a(this.H);
    b(0);
    a(l1, false);
    if (VideoUtil.a(this.H, false))
    {
      this.ax = new ConfigInfoTips(this);
      this.ax.a();
    }
    this.ay = SmallScreenActivityPlugin.a(this.H);
    int i1 = this.I.k().bM;
    if (QLog.isDevelopLevel())
    {
      paramBundle = this.i;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate changeVideoLayoutMode Style=");
      ((StringBuilder)localObject1).append(this.I.k().g);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(this.I.k().bM);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(this.I.X());
      QLog.d(paramBundle, 4, ((StringBuilder)localObject1).toString());
    }
    a(i1, false);
    this.H.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
    paramBundle = (ViewStub)findViewById(2131441053);
    this.af = new QavDoubleVideoSharpnessMangaer(findViewById(2131440990), paramBundle, 2131441265, this.I, this);
    this.ai = new VideoChatRoomUIContoller(this, this.H);
    if (ThemeUtil.isInNightMode(this.H)) {
      findViewById(2131441224).setVisibility(0);
    }
    this.ab.a(this);
    this.H.B().a(this);
    ((ScreenShareManager)this.H.c(18)).a(this);
    b();
    paramBundle = new StringBuilder();
    paramBundle.append(this.i);
    paramBundle.append(".onCreate.end");
    AudioHelper.b(paramBundle.toString());
  }
  
  protected void onDestroy()
  {
    this.mIsShadow = false;
    super.onDestroy();
    Looper.myQueue().removeIdleHandler(this.aD);
    long l1 = AudioHelper.c();
    Object localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo life_onDestroy, mActivityState[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("->");
    localStringBuilder.append(5);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], isQuit[");
    localStringBuilder.append(this.y);
    localStringBuilder.append("], session[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    a("onDestroy", l1);
    this.ab.a(l1);
    b(5);
    localObject = this.at;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(272);
    }
    w();
    localObject = this.ai;
    if (localObject != null)
    {
      ((VideoChatRoomUIContoller)localObject).a(this.y);
      this.ai = null;
    }
    localObject = this.I;
    if ((localObject != null) && (((VideoController)localObject).k() != null) && (this.I.k().cB))
    {
      localObject = this.ad;
      if (localObject != null) {
        ((QavVideoRecordUICtrl)localObject).e();
      }
    }
    localObject = this.ad;
    if (localObject != null)
    {
      ((QavVideoRecordUICtrl)localObject).j();
      this.ad = null;
    }
    localObject = this.M;
    if (localObject != null)
    {
      ((ICameraManagerApi)localObject).deleteObserver(this.ak);
      this.M = null;
    }
    localObject = this.L;
    if (localObject != null)
    {
      ((VideoLayerUI)localObject).E();
      this.L = null;
    }
    localObject = this.K;
    if (localObject != null)
    {
      ((VideoControlUI)localObject).d(l1);
      this.K = null;
    }
    localObject = this.N;
    if (localObject != null)
    {
      ((ChildGuideUi)localObject).b();
      this.N = null;
    }
    try
    {
      if (this.Y != null)
      {
        this.Y.stopPlayback();
        localObject = this.Y.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeAllViews();
        }
        this.Y = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      label420:
      int i1;
      break label420;
    }
    localObject = this.H;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).b(this.ap);
      this.H.b(this.X);
      this.H.b(this.au);
      this.H.a().removeCallbacks(this.F);
      localObject = this.H.A();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a();
      }
    }
    localObject = this.W;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.W = null;
    }
    if (this.y)
    {
      DoodleLogic.b().a();
      localObject = this.Q;
      if (localObject != null) {
        ((QAVNotification)localObject).a(this.d);
      }
      CameraUtils.a(this).closeCamera(l1, true);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.i;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy isQuit[");
      localStringBuilder.append(this.y);
      localStringBuilder.append("], session[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.I = null;
    localObject = this.H;
    if (localObject != null) {
      ((VideoAppInterface)localObject).b().k().e("AVActivity.onDestroy", 0);
    }
    this.G = null;
    this.Q = null;
    this.R = null;
    AudioHelper.d = false;
    this.W = null;
    this.X = null;
    this.ap = null;
    localObject = this.ax;
    if (localObject != null)
    {
      ((ConfigInfoTips)localObject).b();
      this.ax = null;
    }
    PanoramaSensorManager.a().a(null);
    localObject = this.H;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(7004), this.j, Boolean.valueOf(this.y) });
    }
    AVVoiceRecog.b().d();
    AVVoiceRecog.b().a(null, null);
    this.H = null;
    localObject = this.af;
    if (localObject != null)
    {
      i1 = ((QavDoubleVideoSharpnessMangaer)localObject).d();
      if (i1 > 0) {
        ReportController.b(null, "CliOper", "", "", "0X800A345", "0X800A345", i1, 0, "", "", "", "");
      }
      this.af.i();
    }
    this.af = null;
    if (AudioHelper.a()) {
      try
      {
        if (QavTest.getInstance().isQosTimerRun()) {
          QavTest.getInstance().stopQosTimer();
        }
      }
      catch (Throwable localThrowable1)
      {
        QLog.i(this.i, 2, "onDestroy", localThrowable1);
      }
    }
    AVUtil.a(this);
  }
  
  @RequiresApi(api=16)
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = this.K;
    boolean bool;
    if (localObject != null) {
      bool = ((VideoControlUI)localObject).a(paramInt, paramKeyEvent);
    } else {
      bool = false;
    }
    if (bool) {
      return true;
    }
    if ((paramInt != 24) && (paramInt != 25))
    {
      if (paramInt != 82)
      {
        if (paramInt != 84) {
          break label406;
        }
        return true;
      }
      paramKeyEvent = this.I;
      if ((paramKeyEvent != null) && (this.M != null))
      {
        paramKeyEvent = paramKeyEvent.k();
        if (((paramKeyEvent.g == 2) && (paramKeyEvent.j())) || ((paramKeyEvent.g == 4) && (paramKeyEvent.i >= 9)))
        {
          long l1 = AudioHelper.c();
          if (this.M.isCameraOpened(l1)) {
            g(l1);
          }
        }
      }
      return true;
    }
    for (;;)
    {
      try
      {
        if ((AudioProcess.a()) && (AudioProcess.b().isPlayStarted()))
        {
          if (paramInt != 25) {
            break label413;
          }
          i1 = -1;
          localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
          int i2 = ((AudioManager)localObject).getStreamVolume(0);
          if (this.S == null) {
            this.S = Integer.valueOf(i2);
          }
          int i3 = ((AudioManager)localObject).getStreamMaxVolume(0);
          if (this.U == null) {
            this.U = Integer.valueOf(i3);
          }
          ((AudioManager)localObject).adjustStreamVolume(0, i1, 1);
          i1 = ((AudioManager)localObject).getStreamVolume(0);
          this.T = Integer.valueOf(i1);
          localObject = this.I.aB();
          if (localObject != null) {
            ((WatchTogetherMediaPlayCtrl)localObject).v().a(this.U.intValue(), this.T.intValue());
          }
          if (QLog.isColorLevel())
          {
            localObject = this.i;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("adjustStreamVolume. streamType = ");
            localStringBuilder.append(0);
            localStringBuilder.append(", maxVolume = ");
            localStringBuilder.append(i3);
            localStringBuilder.append(", oldVolume = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(", newVolume = ");
            localStringBuilder.append(i1);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e(this.i, 1, "adjustStreamVolume fail.", localException);
      }
      label406:
      return super.onKeyDown(paramInt, paramKeyEvent);
      label413:
      int i1 = 1;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onNewIntent, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      QLog.d(this.i, 2, "");
    }
    Object localObject = this.ay;
    if (localObject != null) {
      ((SmallScreenActivityPlugin)localObject).b();
    }
    setIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("sessionType", 0);
    int i2 = paramIntent.getIntExtra("MultiAVType", 0);
    int i3 = this.b;
    if ((i3 != 1) && (i3 != 2))
    {
      if ((i3 == 3) || (i3 == 4)) {
        if ((i2 != 2) && (this.I.k().o != 2))
        {
          if ((i1 != 3) && (i1 != 4))
          {
            if ((i1 == 1) || (i1 == 2))
            {
              paramIntent = this.K;
              if (paramIntent != null)
              {
                paramIntent.d(l1);
                this.K = null;
              }
              d(l1);
              b(0);
              a(l1, false);
            }
          }
          else
          {
            d(l1);
            localObject = this.L;
            if (localObject != null) {
              ((VideoLayerUI)localObject).W();
            }
            localObject = this.K;
            if (localObject != null) {
              ((VideoControlUI)localObject).c(paramIntent);
            }
          }
        }
        else if (this.I.k().o == i2)
        {
          d(l1);
          localObject = this.L;
          if (localObject != null) {
            ((VideoLayerUI)localObject).W();
          }
          localObject = this.K;
          if (localObject != null) {
            ((VideoControlUI)localObject).c(paramIntent);
          }
        }
        else
        {
          paramIntent = this.K;
          if (paramIntent != null)
          {
            paramIntent.d(l1);
            this.K = null;
          }
          d(l1);
          b(0);
          a(l1, false);
        }
      }
    }
    else if ((i1 == 3) || (i1 == 4))
    {
      paramIntent = this.K;
      if (paramIntent != null)
      {
        paramIntent.d(l1);
        this.K = null;
      }
      d(l1);
      b(0);
      a(l1, false);
    }
  }
  
  protected void onPause()
  {
    long l1 = AudioHelper.c();
    Object localObject1 = this.i;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo life_onPause, seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    AVVoiceRecog.b().b(16);
    i(false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    this.ae = true;
    try
    {
      this.mIsShadow = false;
      super.onPause();
      b(3);
      localObject1 = this.K;
      if (localObject1 != null) {
        ((VideoControlUI)localObject1).g();
      }
      localObject1 = this.I;
      if (localObject1 != null)
      {
        ((VideoController)localObject1).b("state", "0");
        if ("0".equals(VideoConstants.ProcessInfo.a)) {
          this.I.b("backgroundReason", "5");
        }
      }
      QLog.d(this.i, 1, "avideo life_onPause end");
      localObject1 = this.af;
      if (localObject1 != null)
      {
        ((QavDoubleVideoSharpnessMangaer)localObject1).c();
        this.af.h();
      }
      this.az.a(this.H, this.I);
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      localObject2 = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onPause, exit when onPause Exception, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString(), localException);
      this.H.a(l1, 1007);
    }
  }
  
  public void onResume()
  {
    i(true);
    long l2 = AudioHelper.c();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 50, 1);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i);
    localStringBuilder.append(".onResume.begin");
    AudioHelper.b(localStringBuilder.toString());
    Object localObject4;
    try
    {
      this.mIsShadow = false;
      super.onResume();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localObject3 = this.i;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onResume IllegalArgumentException ");
      ((StringBuilder)localObject4).append(localIllegalArgumentException);
      QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    Object localObject1 = this.i;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("avideo onResume, mhasStopped[");
    ((StringBuilder)localObject3).append(this.aN);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l2);
    ((StringBuilder)localObject3).append("], sessionInfo[");
    ((StringBuilder)localObject3).append(localSessionInfo);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
    this.ae = false;
    RenderUtil.a();
    VideoNodeReporter localVideoNodeReporter = (VideoNodeReporter)this.H.c(4);
    if (localSessionInfo.B) {
      localVideoNodeReporter.a(localSessionInfo.D(), 8, 1L);
    }
    if (getIntent().getBooleanExtra("isMakingAcall", false)) {
      localVideoNodeReporter.a(-1L, 3, 1L);
    }
    if (!this.H.u()) {
      this.H.v();
    }
    this.aN = false;
    int i4 = s();
    this.ao = false;
    b(2);
    this.I.h(true);
    localObject1 = this.ay;
    if (localObject1 != null) {
      ((SmallScreenActivityPlugin)localObject1).b();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = this.I.aE();
      if ((localObject1 != null) && (((ScreenRecordHelper)localObject1).e())) {
        this.H.a().postDelayed(new AVActivity.13(this), 300L);
      }
    }
    this.H.a().postDelayed(new AVActivity.14(this, l2), 200L);
    if (localSessionInfo.g == 2)
    {
      if (localSessionInfo.j())
      {
        localObject1 = localSessionInfo.s;
        bool2 = localSessionInfo.I;
        boolean bool3 = this.I.h(this.j);
        boolean bool4 = localSessionInfo.G;
        bool1 = localSessionInfo.H;
        if (bool1)
        {
          localObject3 = DeviceInfoUtil.f();
          if ((!this.M.isCameraOpening(l2)) && (!this.M.isCameraOpened(l2))) {
            this.M.openCamera(l2);
          } else if ((((String)localObject3).contains("vivo")) && (this.M.getCameraParams() == null)) {
            this.M.reopenCamera("AVonResume", l2, -1, -1);
          }
        }
        localObject3 = this.L;
        if (localObject3 != null) {
          if ((bool1) && (bool2))
          {
            if (bool4)
            {
              ((VideoLayerUI)localObject3).a(l2, (String)localObject1, 1, true, false, bool3);
              this.L.b(l2, true, false);
            }
            else
            {
              ((VideoLayerUI)localObject3).b(l2, true, false);
              this.L.a(l2, (String)localObject1, 1, true, false, bool3);
            }
          }
          else if (bool1) {
            this.L.b(l2, true, false);
          } else if (bool2) {
            this.L.a(l2, (String)localObject1, 1, true, false, bool3);
          }
        }
      }
      else if ((!localSessionInfo.br) && (!this.z))
      {
        localSessionInfo.b(l2, true);
        this.M.openCamera(l2);
        localObject1 = this.L;
        if (localObject1 != null) {
          ((VideoLayerUI)localObject1).b(l2, true, false);
        }
      }
    }
    else if (localSessionInfo.g == 4)
    {
      ArrayList localArrayList = localSessionInfo.bi;
      Collections.sort(localArrayList, new AVActivity.15(this));
      int i1 = this.I.X();
      int i2 = 0;
      while (i2 < localArrayList.size())
      {
        VideoViewInfo localVideoViewInfo = (VideoViewInfo)localArrayList.get(i2);
        localObject3 = CharacterUtil.a(localVideoViewInfo.a);
        int i3 = localVideoViewInfo.b;
        bool2 = localVideoViewInfo.c;
        localObject1 = this.L;
        if (localObject1 != null) {
          bool1 = ((VideoLayerUI)localObject1).b((String)localObject3, i3);
        } else {
          bool1 = false;
        }
        int i5 = AVUtil.c(this.e);
        localObject4 = this.H.a(i5, (String)localObject3, String.valueOf(localSessionInfo.aN));
        if ((localVideoViewInfo.d) && (!((String)localObject3).equals(this.H.getCurrentAccountUin())) && (bool2) && (!localVideoViewInfo.f))
        {
          if (CharacterUtil.a((String)localObject4) > 20)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(CharacterUtil.a((String)localObject4, 0, 20));
            ((StringBuilder)localObject1).append("...");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = localObject4;
          }
          VideoControlUI localVideoControlUI;
          if (i3 == 2)
          {
            localObject1 = String.format(getString(2131893280), new Object[] { localObject1 });
            localVideoControlUI = this.K;
            if ((localVideoControlUI != null) && ((localVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              localVideoControlUI.a(1036, (String)localObject1);
            } else {
              TipsUtil.a(this.H, 1036, (String)localObject1);
            }
          }
          else
          {
            localObject1 = String.format(getString(2131893281), new Object[] { localObject1 });
            localVideoControlUI = this.K;
            if ((localVideoControlUI != null) && ((localVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              localVideoControlUI.a(1037, (String)localObject1);
            } else {
              TipsUtil.a(this.H, 1037, (String)localObject1);
            }
          }
        }
        if (this.L != null)
        {
          z();
          if ((!localVideoViewInfo.d) && (!localVideoViewInfo.c))
          {
            if (i1 != 4)
            {
              if (localSessionInfo.aQ == 2) {
                ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
              } else if (localSessionInfo.o == 10) {
                ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
              } else {
                ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
              }
              this.L.a(l2, (String)localObject3, i3, this.O, localVideoViewInfo.d, localVideoViewInfo.c);
            }
            else
            {
              this.L.a(l2, (String)localObject3, i3, this.P, localVideoViewInfo.d, localVideoViewInfo.c);
            }
          }
          else {
            this.L.a(l2, (String)localObject3, i3, this.P, localVideoViewInfo.d, localVideoViewInfo.c);
          }
          if ((!bool1) && (!localSessionInfo.am))
          {
            float f2 = 12.0F;
            float f1 = f2;
            if (this.L.c((String)localObject3, i3))
            {
              f1 = f2;
              if (this.L.B() != 3) {
                f1 = 18.0F;
              }
            }
            f1 = UITools.a(getApplicationContext(), f1);
            this.L.a((String)localObject3, i3, (String)localObject4, f1, -1);
            this.L.d((String)localObject3, i3);
          }
        }
        i2 += 1;
      }
    }
    localObject1 = this.L;
    if (localObject1 != null)
    {
      ((VideoLayerUI)localObject1).G();
      if (localSessionInfo.cw)
      {
        this.L.a(localSessionInfo.s, 1, true);
        if ((!this.I.k().H) && (!this.I.k().cv))
        {
          localObject1 = this.K;
          if (localObject1 != null) {
            ((VideoControlUI)localObject1).j();
          }
          QLog.d(this.i, 1, "[onresume] open : head view for local.");
        }
      }
    }
    localObject1 = this.K;
    if (localObject1 != null) {
      ((VideoControlUI)localObject1).b(l2);
    }
    localObject1 = this.N;
    if (localObject1 != null) {
      ((ChildGuideUi)localObject1).c();
    }
    this.I.a(false);
    d();
    g();
    this.H.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
    if ((this.L != null) && (i())) {
      this.L.a("onResume");
    }
    if ((localSessionInfo.g == 2) || (localSessionInfo.g == 1))
    {
      localObject1 = this.ad;
      if ((localObject1 != null) && (((QavVideoRecordUICtrl)localObject1).o() == 1) && (localSessionInfo.cD)) {
        this.at.post(new AVActivity.16(this));
      }
    }
    if (localSessionInfo.bZ == -1) {
      localSessionInfo.bZ = m();
    }
    if (localSessionInfo.bY == -1)
    {
      localObject1 = SharedPreUtils.B(getApplicationContext());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("firstEnter_");
      ((StringBuilder)localObject3).append(this.H.getCurrentAccountUin());
      localSessionInfo.bY = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject3).toString(), 1);
      if (localSessionInfo.bY == 1)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("firstEnter_");
        ((StringBuilder)localObject3).append(this.H.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject3).toString(), 0).commit();
      }
    }
    if (localSessionInfo.cE != 0)
    {
      if (localSessionInfo.cE == 1)
      {
        QQToast.makeText(this, 2, getResources().getString(2131893528), 0).show();
      }
      else
      {
        TipsUtil.a(this.H, 1023, 2131893539);
        QavRecordReporter.a("0X8008AB0");
      }
      localSessionInfo.cE = 0;
    }
    this.H.a(new Object[] { Integer.valueOf(7000), this.j });
    if (AudioHelper.a()) {
      try
      {
        QavTestUtil.showTestBtn(this);
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.i, 1, "showTestBtn fail", localThrowable);
      }
    }
    AVVoiceRecog.b().c(16);
    boolean bool1 = localSessionInfo.H;
    boolean bool2 = localSessionInfo.I;
    if ((bool1) && (bool2)) {
      AVVoiceRecog.b().c(1);
    } else {
      AVVoiceRecog.b().b(1);
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.H.y;
    long l1;
    if (localSessionInfo.D() > 0L) {
      l1 = localSessionInfo.D();
    } else {
      l1 = -1L;
    }
    localVideoNodeReporter.a(l1, 25, l3 - l4);
    this.I.b("state", "1");
    VideoConstants.ProcessInfo.a = "0";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.i);
    ((StringBuilder)localObject2).append(".onResume.end");
    AudioHelper.b(((StringBuilder)localObject2).toString());
    if (getIntent().getIntExtra("hc_code", 0) != 0) {
      HardCoderManager.getInstance().stop(getIntent().getIntExtra("hc_code", 0), true);
    }
    r().ai();
    localObject2 = VideoController.f().m(false);
    if (localObject2 != null) {
      ((EffectController)localObject2).a(l2);
    }
    if (AudioHelper.a())
    {
      localObject2 = this.i;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getSystemUiVisibility[");
      ((StringBuilder)localObject3).append(getWindow().getDecorView().getSystemUiVisibility());
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    this.az.a(this, this.H, this.I);
    if (this.ai != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.i;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onResume, mCheckFirstShowChatRoomPanel[");
        ((StringBuilder)localObject3).append(localSessionInfo.cd);
        ((StringBuilder)localObject3).append("]");
        QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (localSessionInfo.cd)
      {
        this.ai.a(0);
        localSessionInfo.cd = false;
      }
      this.ai.e();
    }
    this.H.a().postDelayed(new AVActivity.17(this, i4), 300L);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.ao = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    VideoController localVideoController = this.I;
    if ((localVideoController != null) && (paramSensorEvent != null)) {
      localVideoController.t.a(paramSensorEvent.values);
    }
  }
  
  protected void onStart()
  {
    Object localObject = SessionMgr.a().b();
    VideoNodeManager.a(20, 1L);
    if ((localObject != null) && (((SessionInfo)localObject).j())) {
      VideoNodeManager.a(31);
    }
    this.mIsShadow = false;
    super.onStart();
    b(1);
    this.aN = false;
    long l1 = AudioHelper.c();
    localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo life_onStart, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.K;
    if (localObject != null) {
      ((VideoControlUI)localObject).a(l1);
    }
    localObject = this.L;
    if (localObject != null) {
      ((VideoLayerUI)localObject).H();
    }
    int i1 = this.b;
    this.H.a(new Object[] { Integer.valueOf(7003), this.j });
  }
  
  protected void onStop()
  {
    long l1 = AudioHelper.c();
    Object localObject = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    super.onStop();
    if (this.I == null) {
      return;
    }
    long l2 = AudioHelper.d();
    this.mIsShadow = false;
    if (this.I.k().cB)
    {
      localObject = this.ad;
      if (localObject != null)
      {
        ((QavVideoRecordUICtrl)localObject).e();
        int i1;
        if (this.ad.g() >= 1000L) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        this.I.k().cE = i1;
        ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      }
    }
    b(4);
    if (!this.B) {
      c(l1);
    }
    j(l1);
    long l3 = AudioHelper.d();
    this.H.a(new Object[] { Integer.valueOf(7001), this.j, Boolean.valueOf(this.y) });
    f(l1);
    localObject = this.L;
    if (localObject != null) {
      ((VideoLayerUI)localObject).I();
    }
    localObject = this.i;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo life_onStop, mIsMultiFinish[");
    localStringBuilder.append(this.B);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], cost[");
    localStringBuilder.append(l3 - l2);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    Object localObject = this.I;
    if ((localObject != null) && (((VideoController)localObject).k().o == 2)) {
      return;
    }
    b(4);
    long l1 = AudioHelper.c();
    if (AudioHelper.e())
    {
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onUserLeaveHint, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    j(l1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onWindowFocusChanged, hasFocus[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], nfonWindowFocus[");
      localStringBuilder.append(this.an);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.an = false;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new AVActivity.onWindowFocusChangedRunnable(this), 500L);
    if (AVReport.a().d)
    {
      AVReport.a().m = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().B = SystemClock.elapsedRealtime();
  }
  
  public boolean p()
  {
    return this.as;
  }
  
  public boolean q()
  {
    VideoLayerUI localVideoLayerUI = this.L;
    if (localVideoLayerUI != null) {
      return localVideoLayerUI.V();
    }
    return false;
  }
  
  public VideoController r()
  {
    return this.I;
  }
  
  public int s()
  {
    return this.a;
  }
  
  public boolean t()
  {
    switch (s())
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("], ActivityState[");
    localStringBuilder.append(s());
    localStringBuilder.append("], isActivityVisible[");
    localStringBuilder.append(t());
    localStringBuilder.append("], ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  public int u()
  {
    VideoLayerUI localVideoLayerUI = this.L;
    if (localVideoLayerUI != null) {
      return localVideoLayerUI.B();
    }
    return 1;
  }
  
  @TargetApi(21)
  @Nullable
  public ScreenRecordHelper v()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      VideoController localVideoController = this.I;
      if (localVideoController != null)
      {
        this.ag = localVideoController.aE();
        this.ag.a(this);
        return this.ag;
      }
    }
    return null;
  }
  
  @TargetApi(21)
  public void w() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */