package com.tencent.av.ui;

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
import android.view.View.OnClickListener;
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
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler = new AVActivity.20(this);
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AVActivity.1(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new AVActivity.22(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new AVActivity.MyVideoObserver(this);
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new AVActivity.2(this);
  ICameraManagerApi jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
  private AVCallCompactJob jdField_a_of_type_ComTencentAvCompatAVCallCompactJob = new AVCallCompactJob();
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
  private AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
  AVActivity.VideoOrientationEventListener jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener = null;
  ChildGuideUi jdField_a_of_type_ComTencentAvUiChildGuideUi;
  private ConfigInfoTips jdField_a_of_type_ComTencentAvUiConfigInfoTips = null;
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver = new AVActivity.MyControlUIObserver(this);
  public QavDoubleVideoSharpnessMangaer a;
  public QavVideoRecordUICtrl a;
  public ScreenRecordHelper a;
  public VideoControlUI a;
  public VideoLayerUI a;
  VoiceChangeChooseDialog jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog = null;
  public VideoChatRoomUIContoller a;
  public EffectFilterPanel a;
  QavRecordButtonView jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
  public GuideHelper a;
  private QAVConfigUtils.MoreBtnTips jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  private WatchTogetherUIProxy jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  public RedTouch a;
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView;
  VipFunCallMediaListener jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallMediaListener = new AVActivity.11(this);
  public Integer a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  private WatchTogetherUIProxy jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
  public Integer b;
  Runnable jdField_b_of_type_JavaLangRunnable = new AVActivity.3(this);
  final String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int = 0;
  public Integer c;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = -1;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString = null;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = null;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int = 0;
  String jdField_g_of_type_JavaLangString = null;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  String jdField_h_of_type_JavaLangString = null;
  boolean jdField_h_of_type_Boolean = false;
  String i;
  public boolean i;
  String jdField_j_of_type_JavaLangString = null;
  boolean jdField_j_of_type_Boolean = true;
  String jdField_k_of_type_JavaLangString = null;
  boolean jdField_k_of_type_Boolean = false;
  String jdField_l_of_type_JavaLangString = null;
  boolean jdField_l_of_type_Boolean = false;
  String jdField_m_of_type_JavaLangString = null;
  boolean jdField_m_of_type_Boolean = false;
  private boolean n;
  private boolean o = false;
  
  public AVActivity()
  {
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper = new GuideHelper();
    this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = null;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
    this.jdField_n_of_type_Boolean = false;
    this.mIsShadow = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVActivity_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
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
      paramIntent = this.jdField_b_of_type_JavaLangString;
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
      paramIntent = this.jdField_b_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("genSessionIdFromIntent error: uinType ");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(", relationId ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.e(paramIntent, 2, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
    paramIntent = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
    if ((paramIntent != null) && (this.jdField_d_of_type_Int == 0)) {
      ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(3, this.jdField_c_of_type_JavaLangString, paramIntent, null);
    }
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
    LiuHaiUtils.a(paramActivity);
    boolean bool2 = LiuHaiUtils.b();
    boolean bool1 = true;
    if (bool2)
    {
      int i1 = LiuHaiUtils.b(paramActivity);
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
        VideoControlUI.jdField_n_of_type_Boolean = true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  private boolean a(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Fromwhere");
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
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
  
  private void c(int paramInt)
  {
    Object localObject = SessionMgr.a().a();
    if (localObject != null)
    {
      if (!((SessionInfo)localObject).r()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localObject == null) {
        return;
      }
      if (((WatchTogetherMediaPlayCtrl)localObject).a() == paramInt) {
        return;
      }
      ((WatchTogetherMediaPlayCtrl)localObject).a(paramInt);
      if (((WatchTogetherMediaPlayCtrl)localObject).j()) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(false);
      }
      n();
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (AudioHelper.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().v = paramString;
    }
  }
  
  private void h(long paramLong)
  {
    if (isDestroyed()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject1 != null)
    {
      if (((VideoControlUI)localObject1).h()) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i1 = ((SessionInfo)localObject1).jdField_d_of_type_Int;
      boolean bool1 = ((SessionInfo)localObject1).r();
      Object localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchToolbar, sessionType[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], isInviting[");
        localStringBuilder.append(((SessionInfo)localObject1).f());
        localStringBuilder.append("], isToolBarDisplay[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
        localStringBuilder.append("|");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean);
        localStringBuilder.append("], watch[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("], curMenu[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b());
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject2, 4, localStringBuilder.toString());
      }
      boolean bool2 = true;
      if (bool1)
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if ((localObject2 != null) && (((VideoLayerUI)localObject2).p == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("switchToolbar");
          }
          i1 = 1;
          bool1 = false;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
          bool1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean;
          ((SessionInfo)localObject1).c(bool1 ^ true);
          i1 = 0;
        }
        localObject1 = VideoController.a().a();
        if (localObject1 == null) {
          return;
        }
        localObject1 = a(((WatchTogetherMediaPlayCtrl)localObject1).i());
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
      if ((i1 != 1) && (i1 != 3))
      {
        if (((SessionInfo)localObject1).f())
        {
          if ((i1 == 2) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)))) {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
          }
          return;
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvUiChildGuideUi;
        if ((localObject2 != null) && (((ChildGuideUi)localObject2).a())) {
          return;
        }
        if ((((SessionInfo)localObject1).az) && (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()))
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (localObject1 != null) {
            TipsUtil.a((VideoAppInterface)localObject1, 1022, 2131695752);
          }
          return;
        }
        if (!a())
        {
          if ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) && ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)))) {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, false);
          }
          b(paramLong, "switchToolbar", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
          return;
        }
        if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
        {
          b(paramLong, "SwitchToolbar2", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i());
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
        }
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1)) || (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3))) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
      }
      if ((!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())) {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
      }
    }
  }
  
  private void i(long paramLong)
  {
    if (this.o) {
      return;
    }
    this.o = true;
    VideoControlUI localVideoControlUI = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localVideoControlUI != null) {
      localVideoControlUI.c(paramLong);
    }
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = UITools.a(getApplicationContext(), 2130842022);
    }
  }
  
  private void m()
  {
    View localView = findViewById(2131373636);
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (!isDestroyed())) {
      runOnUiThread(new AVActivity.10(this, localView));
    }
  }
  
  private void n()
  {
    int i1 = this.jdField_h_of_type_Int;
    if ((i1 != 0) && (i1 != 180))
    {
      if (i1 == 90)
      {
        setRequestedOrientation(8);
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE]");
        return;
      }
      setRequestedOrientation(0);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
      return;
    }
    setRequestedOrientation(1);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      return;
    }
    Object localObject = super.findViewById(2131363127);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = new VideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, (View)localObject);
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(a());
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new AVActivity.21(this));
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject != null) {
      ((VideoLayerUI)localObject).a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl);
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    long l1 = AudioHelper.b();
    Object localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BtnOnClick, id[");
    localStringBuilder.append(LayoutDef.a(paramView.getId()));
    localStringBuilder.append("], nfonWindowFocus[");
    localStringBuilder.append(this.jdField_j_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (!this.jdField_j_of_type_Boolean) {
      return;
    }
    if ((paramView.getId() == 2131373345) || (paramView.getId() == 2131373346)) {
      b(true);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiChildGuideUi;
    if ((localObject != null) && (((ChildGuideUi)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi.a(paramView);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      if (localObject != null)
      {
        ((VideoControlUI)localObject).C(l1);
        DataReport.c(paramView.getId());
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(l1, paramView);
        e(l1);
      }
    }
    if (paramView.getId() == 2131373636)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      if (paramView != null)
      {
        AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramView, 1);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
      }
    }
  }
  
  public void TestMenuBtnOnClick(View paramView)
  {
    if (AudioHelper.a()) {
      try
      {
        QavTestUtil.addMenuInVideoView(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, paramView);
        return;
      }
      catch (Throwable paramView)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, "addMenuInVideoView", paramView);
      }
    }
  }
  
  int a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return 0;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.a(getApplicationContext());
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showRecordTip");
    localStringBuilder.append(String.valueOf(str));
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  View a(long paramLong)
  {
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips != null) && (this.jdField_n_of_type_Boolean))
    {
      if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, 工具栏没显示, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      Object localObject3 = findViewById(2131373636);
      if (localObject3 == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
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
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, more按钮没显示出来, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      localObject1 = (ImageView)findViewById(2131373524);
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
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
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, qav_more_tips已经在显示中了, seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      localObject2 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. showTips. mMoreBtnTipsImageDownloaded = ");
      localStringBuilder.append(this.jdField_n_of_type_Boolean);
      localStringBuilder.append(", mMoreBtnTips = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips);
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
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
      d1 = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth();
      Double.isNaN(d1);
      int i7 = (int)(d1 / 1.5D);
      d1 = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight();
      Double.isNaN(d1);
      int i8 = (int)(d1 / 1.5D);
      int i9 = i5 - i7 + i2;
      localObject3 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i6;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = i9;
      ((RelativeLayout.LayoutParams)localObject3).width = i7;
      ((RelativeLayout.LayoutParams)localObject3).height = i8;
      localObject3 = this.jdField_b_of_type_JavaLangString;
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
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qav_UserGuide_for_more.init, 没有tips需要显示或者已经显示过, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return null;
    }
    return null;
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public SmallScreenActivityPlugin a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  }
  
  public AVActivity.AnimationTrigger a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = new AVActivity.AnimationTrigger(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
  }
  
  @TargetApi(21)
  @Nullable
  public ScreenRecordHelper a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      if (localVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper = localVideoController.a();
        this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper.a(this);
        return this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
      }
    }
    return null;
  }
  
  public WatchTogetherUIProxy a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy == null)
      {
        ((ViewStub)findViewById(2131373657)).inflate();
        localRelativeLayout = (RelativeLayout)findViewById(2131373656);
        this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy = ((IUIProxy)QRoute.api(IUIProxy.class)).getAdminControlView(this);
        localRelativeLayout.addView((View)this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy, new RelativeLayout.LayoutParams(-1, -1));
      }
      return this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
    }
    if (this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy == null)
    {
      ((ViewStub)findViewById(2131373659)).inflate();
      localRelativeLayout = (RelativeLayout)findViewById(2131373658);
      this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy = ((IUIProxy)QRoute.api(IUIProxy.class)).getOrdinaryControlView(this);
      localRelativeLayout.addView((View)this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy, new RelativeLayout.LayoutParams(-1, -1));
    }
    return this.jdField_b_of_type_ComTencentAvWtogetherCallbackWatchTogetherUIProxy;
  }
  
  void a()
  {
    EffectMaterialHandler localEffectMaterialHandler = (EffectMaterialHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(EffectMaterialHandler.class.getName());
    localEffectMaterialHandler.a("QQAVSinglePendant", "9");
    localEffectMaterialHandler.a("QQAVDoublePendant", "9");
  }
  
  void a(int paramInt)
  {
    VideoControlUI localVideoControlUI = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if ((localVideoControlUI != null) && (localVideoControlUI.a() != null)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(paramInt);
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
      localStringBuilder.append("], curMode[");
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(((VideoLayerUI)localObject).f());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i("WTogether", 4, localStringBuilder.toString());
    }
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject != null)
    {
      if (((VideoControlUI)localObject).h()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (localObject != null)
      {
        if (paramInt == ((VideoLayerUI)localObject).f()) {
          return;
        }
        long l1 = AudioHelper.b();
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g(paramInt);
        if (((this.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)) && ((paramInt == 2) || (paramInt == 1)))
        {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(l1);
          ((DoubleVideoCtrlUI)this.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), c());
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(l1);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l1, 16777215);
        localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
        if (localObject != null)
        {
          ((QavVideoRecordUICtrl)localObject).a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c());
          localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
          ((QavVideoRecordUICtrl)localObject).a(((QavVideoRecordUICtrl)localObject).c());
          localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
          ((QavVideoRecordUICtrl)localObject).b(((QavVideoRecordUICtrl)localObject).c());
        }
        localObject = this.jdField_a_of_type_ComTencentAvVideoController;
        if ((localObject != null) && (((VideoController)localObject).a().az) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aG)) {
          QavRecordReporter.a("0X8008ABA");
        }
        if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController;
          if (localObject != null)
          {
            paramBoolean = ((VideoController)localObject).a().jdField_e_of_type_Boolean;
            this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), paramBoolean);
          }
        }
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(paramInt);
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject != null)
    {
      ((VideoLayerUI)localObject).b(paramLong, false, false);
      if (!this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isCameraOpened(paramLong)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().b(paramLong, false);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
    if (localObject != null) {
      ((ICameraManagerApi)localObject).closeCamera(paramLong, true);
    }
    if (!this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isCameraOpened(paramLong))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestCloseCamera, 摄像头本来没打开, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      if (localObject != null) {
        ((VideoControlUI)localObject).c(paramLong, true);
      }
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().p()) {
      a(1, false);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller;
    if (localObject != null) {
      ((VideoChatRoomUIContoller)localObject).a();
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject != null)
    {
      if (((VideoControlUI)localObject).h()) {
        return;
      }
      int i5 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
      int i6 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
      boolean bool = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
      int i4 = 0;
      int i1;
      int i2;
      if (bool)
      {
        localObject = findViewById(2131373632);
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
          i1 = LiuHaiUtils.b(this);
        } else {
          i1 = 0;
        }
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((((SessionInfo)localObject).u()) && ((((SessionInfo)localObject).az) || (((SessionInfo)localObject).aA)))
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
          if ((localObject != null) && (!((QavVideoRecordUICtrl)localObject).d()))
          {
            i2 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
            localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
            if (i2 == 0) {
              i3 = -1;
            } else {
              i3 = i2;
            }
            ((VideoLayerUI)localObject).jdField_k_of_type_Int = i3;
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
      localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller;
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
      if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        if ((c() == 1) && (i4 > i6)) {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, i7, i4, this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean ^ true);
        } else {
          this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, i7, i6, this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean ^ true);
        }
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.R();
      localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller;
      if ((localObject != null) && (paramInt != 1)) {
        ((VideoChatRoomUIContoller)localObject).b(i6);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 2131373636) && (paramInt3 == 0))
    {
      a(paramLong, 2000L);
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this, 1, 0);
    }
  }
  
  void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (isDestroyed()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject != null)
    {
      if (((VideoControlUI)localObject).h()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramInt);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramInt, false);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setRotation(paramInt);
      this.jdField_h_of_type_Int = paramInt;
      localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (localObject != null)
      {
        ((QavVideoRecordUICtrl)localObject).d(paramInt);
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI, this.jdField_h_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().az) || (this.jdField_a_of_type_ComTencentAvVideoController.a().aA)) {
        g(paramLong);
      }
      c(paramInt);
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MoreBtnTips. tryShow_qav_more_tips. mMoreBtnTipsImageDownloaded = ");
    localStringBuilder.append(this.jdField_n_of_type_Boolean);
    localStringBuilder.append(", mMoreBtnTips = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips);
    localStringBuilder.append(", delayMillis = ");
    localStringBuilder.append(paramLong2);
    QLog.i(str, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramLong2);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("uinname", paramString2);
    startActivity((Intent)localObject);
    paramString2 = this.jdField_b_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterChatWin, uin[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
    this.jdField_e_of_type_Boolean = false;
    finish();
    paramInt = 2130772191;
    paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramString1 != null) {
      paramInt = SmallScreenUtils.a(paramString1.K);
    }
    overridePendingTransition(0, paramInt);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      int i2 = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility();
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(i1);
      if ((i2 != i1) && (AudioHelper.b()))
      {
        String str = this.jdField_b_of_type_JavaLangString;
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
      paramString = this.jdField_a_of_type_ComTencentAvVideoController;
      if ((paramString != null) && (paramString.a().aE))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().aE = false;
        paramBoolean = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.i();
        boolean bool = QavVideoRecordUICtrl.f();
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
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onCreateUI, SessionType[");
    localStringBuilder.append(((SessionInfo)localObject1).jdField_d_of_type_Int);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131373372));
    }
    this.jdField_a_of_type_JavaLangRunnable = new AVActivity.5(this);
    if (this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi = CameraUtils.a(this);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.addObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setCameraListener(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvVideoCameraListener);
    }
    localObject2 = super.findViewById(2131363127).findViewById(2131363124);
    try
    {
      ((View)localObject2).setBackgroundResource(2130842183);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreateUI OutOfMemoryError", localOutOfMemoryError);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null) {
      o();
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject3 != null) {
      ((VideoLayerUI)localObject3).c();
    }
    c(false);
    if (this.jdField_b_of_type_Int == 0)
    {
      localObject3 = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateUI, SessionType[");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("], isDoubleMeeting[");
      localStringBuilder.append(this.jdField_g_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject3, 2, localStringBuilder.toString());
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_b_of_type_Int = 1;
      }
    }
    int i1 = this.jdField_b_of_type_Int;
    if ((i1 == 2) || (i1 == 4)) {
      ThreadManager.excute(new AVActivity.6(this), 16, null, true);
    }
    i1 = this.jdField_b_of_type_Int;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if ((i1 == 3) || (i1 == 4))
        {
          if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
            if (this.jdField_g_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              this.jdField_b_of_type_Int = ((SessionInfo)localObject1).jdField_d_of_type_Int;
            }
            else if (((SessionInfo)localObject1).jdField_j_of_type_Int == 1)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
            else if (((SessionInfo)localObject1).jdField_j_of_type_Int == 10)
            {
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4NewGroupChat(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "OnCreateUI --> Not Set MultiAVType");
              }
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new MultiVideoCtrlLayerUI4Discussion(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
          }
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.getCameraNum());
        }
      }
      else if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        this.jdField_b_of_type_Int = ((SessionInfo)localObject1).jdField_d_of_type_Int;
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.getCameraNum());
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoMeetingCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          this.jdField_b_of_type_Int = ((SessionInfo)localObject1).jdField_d_of_type_Int;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        }
      }
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.getCameraNum());
    }
    i1 = this.jdField_b_of_type_Int;
    if ((i1 == 3) && (getIntent() != null) && (getIntent().getBooleanExtra("isVideo", false))) {
      i1 = 4;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips = QAVConfigUtils.a(i1);
    localObject3 = this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips;
    if ((localObject3 != null) && (!TextUtils.isEmpty(((QAVConfigUtils.MoreBtnTips)localObject3).jdField_a_of_type_JavaLangString)))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      this.jdField_n_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new AVActivity.7(this));
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      if (1 == this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus()) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      this.jdField_n_of_type_Boolean = paramBoolean;
      ReportController.b(null, "CliOper", "", "", "0X800A75E", "0X800A75E", i1, this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips.jdField_a_of_type_Int, "", "", "", "");
      localObject3 = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. getDrawableAndToDownloadImage. mMoreBtnTipsImageDownloaded = ");
      localStringBuilder.append(this.jdField_n_of_type_Boolean);
      QLog.i((String)localObject3, 1, localStringBuilder.toString());
    }
    localObject3 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject3 != null)
    {
      ((VideoControlUI)localObject3).d();
      if (this.jdField_d_of_type_Int == 9500)
      {
        localObject3 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
        if ((localObject3 instanceof DoubleVideoCtrlUI))
        {
          localObject3 = (DoubleVideoCtrlUI)localObject3;
          ((DoubleVideoCtrlUI)localObject3).a(2131373354, this.jdField_a_of_type_ComTencentAvVideoController.jdField_m_of_type_Boolean, 2130842081);
          if (!this.jdField_a_of_type_ComTencentAvVideoController.o) {
            ((DoubleVideoCtrlUI)localObject3).a.a(true, 0, false);
          }
        }
      }
    }
    if ((((SessionInfo)localObject1).jdField_f_of_type_Int != 4) && (((SessionInfo)localObject1).u()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
    {
      localObject3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if ((localObject3 != null) && (((RelativeLayout)localObject3).getParent() != null) && (!isDestroyed()))
      {
        i1 = FunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, true, true);
        if ((i1 > 0) && (this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView == null)) {
          this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = VipFunCallManager.a(this, (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        int i2 = VipFunCallUtil.a();
        localObject1 = VipFunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i1, i2, null);
        if (localObject1 != null) {
          if (new File((String)localObject1).exists())
          {
            localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
            if (localObject3 != null) {
              ((VideoAppInterface)localObject3).a().postDelayed(new AVActivity.8(this, (String)localObject1, i2, i1), 1000L);
            }
          }
          else
          {
            localObject3 = this.jdField_b_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("funcall --> !file.exists() + path:");
            localStringBuilder.append((String)localObject1);
            QLog.e((String)localObject3, 1, localStringBuilder.toString());
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView = ((QavRecordButtonView)findViewById(2131376277));
    a(paramLong, "onCreateUI", false);
    localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject1 != null) {
      ((VideoLayerUI)localObject1).l(0);
    }
    localObject1 = (RelativeLayout)findViewById(2131380733);
    if ((localObject1 != null) && (QavVideoRecordUICtrl.f()))
    {
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = new QavVideoRecordUICtrl(this, (RelativeLayout)localObject1, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c(1);
      localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (localObject1 != null) {
        ((VideoLayerUI)localObject1).a(this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl);
      }
    }
    m();
    AVVoiceRecog.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this);
    localObject1 = new AVActivity.9(this);
    new Handler().post((Runnable)localObject1);
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(String paramString)
  {
    Object localObject1 = (EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3);
    Object localObject2 = ((EffectFaceManager)localObject1).a(paramString);
    if (localObject2 != null)
    {
      long l1 = AudioHelper.b();
      boolean bool;
      if ((!((FaceItem)localObject2).isUsable()) && (!TextUtils.isEmpty(((FaceItem)localObject2).getResUrl()))) {
        bool = false;
      } else {
        bool = true;
      }
      String str = this.jdField_b_of_type_JavaLangString;
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
        new ControlUIObserver.RequestPlayMagicFace(l1, ((FaceItem)localObject2).getId(), true, 2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        VoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
        ReportController.b(null, "CliOper", "", "", "0X800984F", "0X800984F", 0, 0, "", "", "", ((FaceItem)localObject2).getId());
        return;
      }
      ((EffectFaceManager)localObject1).a(l1, (ItemBase)localObject2);
      return;
    }
    localObject1 = this.jdField_b_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onAVVoiceRecogComplete. recogResult = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", paly voice sticker falied. voiceStickerItem == null.");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  void a(String paramString, long paramLong)
  {
    Object localObject = findViewById(2131373524);
    if (localObject == null) {
      return;
    }
    if (((View)localObject).getVisibility() == 0)
    {
      ((View)localObject).setVisibility(4);
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. hide_qav_more_tips. from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      paramString = this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips;
      if (paramString != null)
      {
        QAVConfigUtils.a(paramString.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentAvUtilsQAVConfigUtils$MoreBtnTips = null;
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
        this.jdField_n_of_type_Boolean = false;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDoubleMeeting, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.jdField_g_of_type_Boolean);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_g_of_type_Boolean != paramBoolean) {
      this.jdField_g_of_type_Boolean = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
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
  
  boolean a()
  {
    VideoControlUI localVideoControlUI = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localVideoControlUI == null) {
      return false;
    }
    return localVideoControlUI.b(4);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener = new AVActivity.VideoOrientationEventListener(this, super.getApplicationContext(), 2);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    d();
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
      if ((localObject == null) || (((SmallScreenActivityPlugin)localObject).a()))
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
        {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
          int i1 = 0;
          while (i1 < ((ArrayList)localObject).size())
          {
            VideoViewInfo localVideoViewInfo = (VideoViewInfo)((ArrayList)localObject).get(i1);
            String str = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
            int i2 = localVideoViewInfo.jdField_a_of_type_Int;
            boolean bool;
            if ((localVideoViewInfo.jdField_b_of_type_Long != 5L) && (localVideoViewInfo.jdField_b_of_type_Long != 14L)) {
              bool = false;
            } else {
              bool = true;
            }
            if (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, i2, false, false, bool);
            }
            i1 += 1;
          }
        }
        this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.closeCamera(paramLong, false);
        this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w();
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject != null) {
      ((VideoControlUI)localObject).m(paramLong);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiChildGuideUi;
    if (localObject != null) {
      ((ChildGuideUi)localObject).d();
    }
    g();
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
    this.jdField_a_of_type_ComTencentAvVideoController.e(false);
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
    if (localObject != null) {
      ((SmallScreenActivityPlugin)localObject).a(paramLong, this.jdField_e_of_type_Boolean);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller;
    if (localObject != null) {
      ((VideoChatRoomUIContoller)localObject).a();
    }
  }
  
  void b(long paramLong, String paramString, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i2 = 1;
    int i1;
    if (bool)
    {
      i1 = -1;
      Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
      if (localObject != null) {
        if (((QavRecordButtonView)localObject).getVisibility() == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
      localObject = this.jdField_b_of_type_JavaLangString;
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
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((!QavVideoRecordUICtrl.k()) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (!paramString.r()))
    {
      int i3 = paramString.jdField_d_of_type_Int;
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
        if ((i1 != 0) && (paramString.aA))
        {
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(this.jdField_h_of_type_Int);
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
        }
        if (i1 == 0)
        {
          paramString = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
          if ((paramString != null) && (paramString.getVisibility() == 0))
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
            a(paramLong, "tryShowRecordBtn.1", false);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
          paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(272);
          paramString.obj = Long.valueOf(paramLong);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 50L);
        }
      }
      else if (i1 != 0)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().aA)
        {
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d(0);
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.k();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(272);
        a(paramLong, "tryShowRecordBtn.2", false);
        paramString = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if (paramString != null) {
          paramString.l(0);
        }
      }
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView;
    if ((paramString != null) && (paramString.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.setVisibility(8);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if ((localObject != null) && (((VideoLayerUI)localObject).i())) {
      return;
    }
    long l1 = AudioHelper.b();
    localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNeedChangeDoubleScreenMode, id[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], hasChangeDoubleScreen[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().J);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    getResources();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      a(2, false);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1043);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new AVActivity.19(this, paramString, l1);
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044, null, this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoLayerUI.a(findViewById(2131363127), paramBoolean);
  }
  
  boolean b()
  {
    boolean bool2 = isDestroyed();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    VideoControlUI localVideoControlUI = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localVideoControlUI != null)
    {
      if (localVideoControlUI.h()) {
        return false;
      }
      if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(1))
      {
        if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(3)) {
          return true;
        }
        if ((a()) || (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    return false;
  }
  
  public int c()
  {
    VideoLayerUI localVideoLayerUI = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localVideoLayerUI != null) {
      return localVideoLayerUI.f();
    }
    return 1;
  }
  
  void c()
  {
    AVActivity.VideoOrientationEventListener localVideoOrientationEventListener = this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener;
    if (localVideoOrientationEventListener != null) {
      localVideoOrientationEventListener.enable();
    }
  }
  
  void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "processExtraData-->can not get intent");
      return;
    }
    AudioHelper.a("AVActivity.processExtraData", localIntent.getExtras());
    int i3 = localIntent.getIntExtra("sessionType", 0);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = localSessionInfo.jdField_d_of_type_Int;
    Object localObject3 = localIntent.getStringExtra("Fromwhere");
    boolean bool = localIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    a("processExtraData", bool);
    if ("AVNotification".equals(localObject3))
    {
      if (((localSessionInfo.jdField_f_of_type_Int == 2) || (localSessionInfo.jdField_f_of_type_Int == 13)) && (i3 != 1) && (i3 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
        }
        if (!localSessionInfo.y)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localSessionInfo.jdField_c_of_type_JavaLangString, 1, true);
          this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.jdField_c_of_type_JavaLangString, 230);
          this.jdField_a_of_type_ComTencentAvVideoController.b(230);
        }
        else
        {
          l1 = Long.valueOf(localSessionInfo.jdField_c_of_type_JavaLangString).longValue();
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
        }
      }
      if (localSessionInfo.jdField_k_of_type_Int == 1) {
        if (localSessionInfo.jdField_j_of_type_Int == 10) {
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
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get session type in intent.");
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1015L);
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
        localSessionInfo.M = i1;
        localSessionInfo.N = i4;
        localSessionInfo.O = i5;
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
          localObject1 = localSessionInfo.jdField_c_of_type_JavaLangString;
        }
        else
        {
          localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        }
      }
      else {
        localObject1 = localSessionInfo.jdField_c_of_type_JavaLangString;
      }
    }
    if (localObject1 == null)
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "processExtraData-->can not get uin in intent.");
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
      finish();
      return;
    }
    if ((i2 != 1) && (i2 != 2))
    {
      if ((i2 != 3) && (i2 != 4))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "original session type is none");
        }
        localObject2 = null;
        i1 = 0;
      }
      else
      {
        localObject3 = String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
        i1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_b_of_type_Int;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "can not get the original group uin");
          ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
          finish();
        }
      }
    }
    else
    {
      localObject3 = localSessionInfo.jdField_c_of_type_JavaLangString;
      i1 = UITools.b(localSessionInfo.jdField_k_of_type_Int);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "can not get the original peeruin");
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
      }
    }
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject3 = this.jdField_b_of_type_JavaLangString;
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
      localObject3 = this.jdField_b_of_type_JavaLangString;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("processExtraData-->OriginalUin=");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(", originalRelationType=");
      ((StringBuilder)localObject4).append(i1);
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
    }
    if (i2 == 0) {
      d(paramLong);
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
          if ((i1 != -1) && (i1 != localSessionInfo.jdField_k_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a(false, 203, new int[] { localSessionInfo.jdField_j_of_type_Int });
            this.jdField_a_of_type_ComTencentAvVideoController.b(203);
            localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            if (localObject2 != null)
            {
              ((VideoControlUI)localObject2).d(paramLong);
              this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
            }
            localObject3 = localSessionInfo.jdField_c_of_type_JavaLangString;
            localObject2 = SessionMgr.a(3, (String)localObject3, new int[0]);
            Object localObject5 = SessionMgr.a().c((String)localObject2);
            if (localObject5 == null)
            {
              localObject1 = this.jdField_b_of_type_JavaLangString;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Can not get SessionInfo : SessionId = ");
              ((StringBuilder)localObject3).append((String)localObject2);
              AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject3).toString());
              finish();
              return;
            }
            localObject4 = ((SessionInfo)localObject5).jdField_e_of_type_JavaLangString;
            i1 = localSessionInfo.jdField_k_of_type_Int;
            localObject5 = ((SessionInfo)localObject5).jdField_r_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject3, 231);
            this.jdField_a_of_type_ComTencentAvVideoController.b(231);
            this.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.processExtraData", (String)localObject2, i1, (String)localObject3, (String)localObject4, 0, (String)localObject5, false, true);
            d(paramLong);
            localObject2 = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
            localObject3 = SessionMgr.a().a((String)localObject2, false);
            ((SessionInfo)localObject3).jdField_e_of_type_Boolean = true;
            ((SessionInfo)localObject3).a("processExtraData", 2);
            ((SessionInfo)localObject3).jdField_W_of_type_Boolean = false;
            if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangString = ((String)localObject2);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_b_of_type_JavaLangString, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
            }
            this.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
            a("processExtraData", localSessionInfo.y);
            this.jdField_d_of_type_Int = localSessionInfo.jdField_k_of_type_Int;
            this.jdField_c_of_type_JavaLangString = localSessionInfo.jdField_c_of_type_JavaLangString;
            this.jdField_e_of_type_JavaLangString = localSessionInfo.jdField_d_of_type_JavaLangString;
            this.jdField_l_of_type_JavaLangString = localSessionInfo.jdField_j_of_type_JavaLangString;
            this.jdField_e_of_type_Int = localSessionInfo.A;
            this.jdField_m_of_type_JavaLangString = localSessionInfo.o;
            this.jdField_f_of_type_Int = localSessionInfo.B;
            this.jdField_i_of_type_JavaLangString = localSessionInfo.jdField_e_of_type_JavaLangString;
            this.jdField_f_of_type_JavaLangString = localSessionInfo.jdField_g_of_type_JavaLangString;
            this.jdField_a_of_type_Boolean = localSessionInfo.jdField_e_of_type_Boolean;
            this.jdField_b_of_type_Boolean = localSessionInfo.H;
            this.jdField_c_of_type_Boolean = localSessionInfo.q;
            this.jdField_d_of_type_Boolean = localSessionInfo.C;
          }
        }
      }
      if ((i3 == 1) || (i3 == 2)) {
        break label2460;
      }
    } while ((i3 != 3) && (i3 != 4));
    long l1 = Long.valueOf((String)localObject1).longValue();
    int i4 = localIntent.getIntExtra("MultiAVType", 0);
    localSessionInfo.ak = localIntent.getBooleanExtra("disableInvite", false);
    if ((localSessionInfo.jdField_j_of_type_Int != 0) && (i4 != localSessionInfo.jdField_j_of_type_Int) && (i4 != 0)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    localSessionInfo.b(i4);
    if (!bool)
    {
      if ((((String)localObject1).compareTo((String)localObject2) != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean))
      {
        localObject3 = this.jdField_a_of_type_ComTencentAvVideoController;
        ((VideoController)localObject3).a(i1, ((VideoController)localObject3).jdField_a_of_type_Long, 98);
        localSessionInfo.b(i4);
      }
      if (i2 != 0)
      {
        localObject3 = this.jdField_a_of_type_ComTencentAvVideoController;
        ((VideoController)localObject3).a(i1, ((VideoController)localObject3).jdField_a_of_type_Long, 99);
        localSessionInfo.b(i4);
        localSessionInfo.a(paramLong, "processExtraData.1", 3);
      }
      localSessionInfo.d("processExtraData.1", localIntent.getIntExtra("Type", -1));
      localSessionInfo.jdField_f_of_type_Long = l1;
      localObject3 = localObject1;
      this.jdField_d_of_type_JavaLangString = ((String)localObject3);
      if (((String)localObject3).compareTo((String)localObject2) == 0)
      {
        if (i2 != 0)
        {
          this.jdField_b_of_type_Int = i3;
          i1 = localIntent.getIntExtra("uinType", -1);
          localSessionInfo.jdField_k_of_type_Int = i1;
          this.jdField_d_of_type_Int = i1;
          this.jdField_i_of_type_JavaLangString = localSessionInfo.jdField_e_of_type_JavaLangString;
          if (localSessionInfo.D == -1) {
            localSessionInfo.d("processExtraData.2", 0);
          }
          this.jdField_c_of_type_Boolean = localSessionInfo.q;
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = this.jdField_b_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("processExtraData multiAVType: ");
            ((StringBuilder)localObject2).append(localSessionInfo.jdField_j_of_type_Int);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            localObject1 = localObject3;
          }
        }
        else
        {
          this.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
          localObject1 = localObject3;
        }
      }
      else
      {
        localSessionInfo.a(paramLong, "processExtraData.2", i3);
        localSessionInfo.jdField_k_of_type_Int = localIntent.getIntExtra("uinType", -1);
        if ((localSessionInfo.D == 0) || (localSessionInfo.D == 1)) {
          localSessionInfo.jdField_a_of_type_ArrayOfLong = localIntent.getLongArrayExtra("DiscussUinList");
        }
        this.jdField_b_of_type_Int = i3;
        localObject1 = localObject3;
      }
    }
    else
    {
      localSessionInfo.jdField_c_of_type_JavaLangString = ((String)localObject1);
      this.jdField_b_of_type_Int = i3;
      this.jdField_c_of_type_JavaLangString = ((String)localObject1);
    }
    Object localObject2 = localObject1;
    if (i2 == 0)
    {
      this.jdField_d_of_type_Int = localSessionInfo.jdField_k_of_type_Int;
      this.jdField_i_of_type_JavaLangString = localSessionInfo.jdField_e_of_type_JavaLangString;
      this.jdField_c_of_type_Boolean = localSessionInfo.q;
      localObject2 = localObject1;
    }
    label2113:
    if ("AIOQAVWatchTogether".equals(this.jdField_j_of_type_JavaLangString)) {
      a(localIntent);
    }
    localObject1 = this.jdField_b_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("processExtraData, mSessionType[");
    ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject3).append("], mUinType[");
    ((StringBuilder)localObject3).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject3).append("], mPeerUin[");
    ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], mPeerName[");
    ((StringBuilder)localObject3).append(this.jdField_e_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], mPhoneNum[");
    ((StringBuilder)localObject3).append(this.jdField_f_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], mSelfNation[");
    ((StringBuilder)localObject3).append(this.jdField_g_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], mSelfMobile[");
    ((StringBuilder)localObject3).append(this.jdField_h_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], mIsReceiver[");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject3).append("], mIsAudioMode[");
    ((StringBuilder)localObject3).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject3).append("], mExtraUin[");
    ((StringBuilder)localObject3).append(this.jdField_i_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], mIsPeerNetworkWell[");
    ((StringBuilder)localObject3).append(this.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject3).append("], mIsFriend[");
    ((StringBuilder)localObject3).append(this.jdField_d_of_type_Boolean);
    ((StringBuilder)localObject3).append("], mFromWhere[");
    ((StringBuilder)localObject3).append(this.jdField_j_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("], intentUinStr[");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("], \nsession[");
    ((StringBuilder)localObject3).append(localSessionInfo);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
    HexUtil.printHexString(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
    return;
    label2460:
    this.jdField_a_of_type_ComTencentAvVideoController.a(i1, Long.valueOf((String)localObject2).longValue(), 97);
    d(paramLong);
    localObject1 = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    if (!SessionMgr.a().a((String)localObject1))
    {
      localObject2 = SessionMgr.a().a((String)localObject1, false);
      ((SessionInfo)localObject2).jdField_e_of_type_Boolean = false;
      ((SessionInfo)localObject2).a("processExtraData", 0);
      ((SessionInfo)localObject2).jdField_W_of_type_Boolean = false;
      if (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_b_of_type_JavaLangString, 2, "mutivideo to doublevideo bug fix call");
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    VideoLayerUI localVideoLayerUI = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localVideoLayerUI != null) {
      localVideoLayerUI.g(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  void d()
  {
    AVActivity.VideoOrientationEventListener localVideoOrientationEventListener = this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener;
    if (localVideoOrientationEventListener != null) {
      localVideoOrientationEventListener.disable();
    }
  }
  
  void d(long paramLong)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("processIntentData begin, isProcessCreate[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject2).append("], isMsfRecv[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], \nSessionInfo[");
    ((StringBuilder)localObject2).append(localSessionInfo);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean))
    {
      VideoNodeManager.a();
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      ((VideoAppInterface)localObject1).jdField_b_of_type_Boolean = false;
      ((VideoAppInterface)localObject1).jdField_c_of_type_Boolean = false;
    }
    VideoNodeManager.a(26);
    localObject2 = super.getIntent();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("_processIntentData");
    AudioHelper.a(((StringBuilder)localObject1).toString(), ((Intent)localObject2).getExtras());
    this.jdField_b_of_type_Int = ((Intent)localObject2).getIntExtra("sessionType", 0);
    this.jdField_d_of_type_Int = ((Intent)localObject2).getIntExtra("uinType", -1);
    this.jdField_c_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("uin");
    this.jdField_l_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("dstClient");
    boolean bool = ((Intent)localObject2).getBooleanExtra("isDoubleVideoMeeting", false);
    if ("AIOShareScreen".equals(((Intent)localObject2).getStringExtra("Fromwhere")))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_b_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("processIntentData, from share screen. uinType[");
        ((StringBuilder)localObject3).append(this.jdField_d_of_type_Int);
        ((StringBuilder)localObject3).append("]");
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject3).toString());
      }
      if (this.jdField_d_of_type_Int == 0) {
        bool = true;
      }
      localSessionInfo.jdField_W_of_type_Int = 4;
      if (bool) {
        localObject1 = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      } else {
        localObject1 = SessionMgr.a(1, ((Intent)localObject2).getStringExtra("GroupId"), new int[0]);
      }
      ScreenShareReportHelper.a((String)localObject1, 1, "processIntentData");
    }
    a("processIntentData", bool);
    this.jdField_m_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("bindId");
    this.jdField_e_of_type_Int = ((Intent)localObject2).getIntExtra("bindType", 0);
    this.jdField_c_of_type_Int = ((Intent)localObject2).getIntExtra("subServiceType", 0);
    this.jdField_f_of_type_Int = ((Intent)localObject2).getIntExtra("extraType", 0);
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("name");
    this.jdField_g_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("selfNation");
    this.jdField_h_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("selfMobile");
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("toMobile");
    this.jdField_a_of_type_Boolean = ((Intent)localObject2).getBooleanExtra("receive", false);
    this.jdField_b_of_type_Boolean = ((Intent)localObject2).getBooleanExtra("isAudioMode", true);
    this.jdField_a_of_type_Long = ((Intent)localObject2).getLongExtra("main_timestamp", 0L);
    this.jdField_i_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("extraUin");
    localObject1 = ((Intent)localObject2).getStringExtra("extraCode");
    Object localObject3 = ((Intent)localObject2).getByteArrayExtra("sig");
    this.jdField_c_of_type_Boolean = ((Intent)localObject2).getBooleanExtra("isPeerNetworkWell", false);
    this.jdField_d_of_type_Boolean = ((Intent)localObject2).getBooleanExtra("isFriend", false);
    this.jdField_j_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("from");
    this.jdField_f_of_type_Boolean = ((Intent)localObject2).getBooleanExtra("shutCamera", false);
    ((Intent)localObject2).getStringExtra("headUrl");
    this.jdField_b_of_type_Long = VipFunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, 3, true, null);
    this.jdField_g_of_type_Int = ((Intent)localObject2).getIntExtra("vipType", 0);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("==> AVActivity processIntentData() mSessionType = ");
    ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject4).append("  mIsAudioMode = ");
    ((StringBuilder)localObject4).append(this.jdField_b_of_type_Boolean);
    AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject4).toString());
    VideoNodeManager.b(this.jdField_b_of_type_Int);
    long l1;
    if (this.jdField_b_of_type_Boolean) {
      l1 = 1L;
    } else {
      l1 = 2L;
    }
    VideoNodeManager.a(13, l1);
    if ((this.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
    }
    int i1 = this.jdField_d_of_type_Int;
    if (i1 == 1008)
    {
      if (localObject3 != null)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[localObject3.length + 3];
        localObject4 = this.jdField_a_of_type_ArrayOfByte;
        localObject4[0] = 1;
        localObject4[1] = 1;
        localObject4[2] = -116;
        System.arraycopy(localObject3, 0, localObject4, 3, localObject3.length);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      }
    }
    else if (i1 == 1011)
    {
      if (localObject3 != null)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[localObject3.length + 3];
        localObject4 = this.jdField_a_of_type_ArrayOfByte;
        localObject4[0] = 1;
        localObject4[1] = 1;
        localObject4[2] = -118;
        System.arraycopy(localObject3, 0, localObject4, 3, localObject3.length);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      }
    }
    else {
      this.jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
    }
    AVReport.a().jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    i1 = this.jdField_b_of_type_Int;
    if ((i1 != 3) && (i1 != 4))
    {
      localSessionInfo.Y = ((Intent)localObject2).getBooleanExtra("isOtherTerminalOnChating", false);
      if (localSessionInfo.Y)
      {
        localSessionInfo.jdField_h_of_type_Long = ((Intent)localObject2).getLongExtra("otherTerminalChatingRoomId", 0L);
        localSessionInfo.aa = ((Intent)localObject2).getBooleanExtra("startfromVideoEntry", false);
      }
    }
    else
    {
      localSessionInfo.d("processIntentData", ((Intent)localObject2).getIntExtra("Type", -1));
      localObject3 = ((Intent)localObject2).getStringExtra("GroupId");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "relationIdStr is null");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
      }
      int i2 = ((Intent)localObject2).getIntExtra("MultiAVType", 0);
      i1 = i2;
      if (i2 == 0)
      {
        i2 = localSessionInfo.jdField_j_of_type_Int;
        i1 = i2;
        if (QLog.isColorLevel())
        {
          localObject4 = this.jdField_b_of_type_JavaLangString;
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
        localSessionInfo.jdField_f_of_type_Long = Long.valueOf((String)localObject3).longValue();
        this.jdField_d_of_type_JavaLangString = ((String)localObject3);
      }
      localSessionInfo.jdField_a_of_type_ArrayOfLong = ((Intent)localObject2).getLongArrayExtra("DiscussUinList");
      localSessionInfo.ak = ((Intent)localObject2).getBooleanExtra("disableInvite", false);
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "invalid sessionType!!!");
      this.jdField_e_of_type_Boolean = true;
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1015L);
      finish();
      return;
    }
    bool = false;
    i1 = ((Intent)localObject2).getIntExtra("remoteStatus", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
    }
    else if (this.jdField_d_of_type_Int == 1006)
    {
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "phoneNum is empty");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "Create video failed because uin is empty");
        this.jdField_e_of_type_Boolean = true;
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(localSessionInfo.b(), 5, 1016L);
        finish();
        return;
      }
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
    }
    localSessionInfo.a(paramLong, "processIntentData", this.jdField_b_of_type_Int);
    localSessionInfo.jdField_k_of_type_Int = this.jdField_d_of_type_Int;
    localSessionInfo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localSessionInfo.jdField_e_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
    localSessionInfo.jdField_f_of_type_JavaLangString = ((String)localObject1);
    localSessionInfo.a(this.jdField_f_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    localSessionInfo.jdField_e_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localSessionInfo.H = this.jdField_b_of_type_Boolean;
    localSessionInfo.q = this.jdField_c_of_type_Boolean;
    localSessionInfo.jdField_h_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    localSessionInfo.jdField_i_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    localSessionInfo.jdField_j_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    localSessionInfo.o = this.jdField_m_of_type_JavaLangString;
    localSessionInfo.A = this.jdField_e_of_type_Int;
    localSessionInfo.B = this.jdField_f_of_type_Int;
    localSessionInfo.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localSessionInfo.C = this.jdField_d_of_type_Boolean;
    localSessionInfo.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    localSessionInfo.jdField_n_of_type_Boolean = this.jdField_f_of_type_Boolean;
    localSessionInfo.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    localSessionInfo.jdField_r_of_type_Int = this.jdField_g_of_type_Int;
    if (i1 == 4) {
      bool = true;
    }
    localSessionInfo.jdField_r_of_type_Boolean = bool;
    localSessionInfo.jdField_n_of_type_Int = ((Intent)localObject2).getIntExtra("friendTerminal", 3);
    localSessionInfo.f("processIntentData", this.jdField_g_of_type_Boolean);
    localSessionInfo.s = this.jdField_c_of_type_Int;
    localSessionInfo.jdField_k_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("actId");
    localSessionInfo.jdField_l_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("mp_ext_params");
    localSessionInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("processIntentData end, mRelationId[");
    ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("], bStartByTerminalSwitch[");
    ((StringBuilder)localObject2).append(localSessionInfo.Y);
    ((StringBuilder)localObject2).append("], terSwitchStartFromVideoEntry[");
    ((StringBuilder)localObject2).append(localSessionInfo.aa);
    ((StringBuilder)localObject2).append("], \nSessionInfo[");
    ((StringBuilder)localObject2).append(localSessionInfo);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onZimuModeChange, inZimu[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (localObject != null)
      {
        ((QavVideoRecordUICtrl)localObject).jdField_d_of_type_Boolean = paramBoolean;
        int i1;
        if (paramBoolean) {
          i1 = 0;
        } else {
          i1 = this.jdField_h_of_type_Int;
        }
        ((QavVideoRecordUICtrl)localObject).d(i1);
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d();
      }
    }
  }
  
  boolean d()
  {
    VideoLayerUI localVideoLayerUI = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localVideoLayerUI != null) {
      return localVideoLayerUI.i();
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (i1 == 1)) {
      a("dispatchTouchEvent up", AudioHelper.b());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    }
  }
  
  void e(long paramLong)
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
      localObject = this.jdField_b_of_type_JavaLangString;
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
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    ImmersiveUtils.setStatusTextColor(false, getWindow());
  }
  
  public boolean e()
  {
    switch (b())
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    return false;
  }
  
  void f()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null)
    {
      Sensor localSensor = this.jdField_a_of_type_AndroidHardwareSensor;
      if (localSensor != null) {
        localSensorManager.registerListener(this, localSensor, 2);
      }
    }
  }
  
  void f(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
    if (localObject != null)
    {
      if (!((ICameraManagerApi)localObject).isCameraOpened(paramLong)) {
        return;
      }
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRotateMenu, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      j();
      localObject = ActionSheet.createMenuSheet(this);
      ((ActionSheet)localObject).getWindow().addFlags(524288);
      ((ActionSheet)localObject).getWindow().addFlags(2097152);
      ((ActionSheet)localObject).getWindow().addFlags(128);
      ((ActionSheet)localObject).addButton(2131720274);
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnButtonClickListener(new AVActivity.17(this));
      ((ActionSheet)localObject).setOnDismissListener(new AVActivity.18(this));
      ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
      ((ActionSheet)localObject).setAnimationTime(150);
      this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
    }
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_l_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f(boolean paramBoolean)
  {
    if (a(getWindow(), paramBoolean)) {
      this.jdField_m_of_type_Boolean = paramBoolean;
    }
  }
  
  public void finish()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString);
    int i1 = 1;
    if ((!bool) && (this.jdField_j_of_type_JavaLangString.equals("from_app_contact"))) {
      moveTaskToBack(true);
    }
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo life_finish, FromWhere[");
    ((StringBuilder)localObject2).append(this.jdField_j_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("]");
    AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = SessionMgr.a().a();
    if (((SessionInfo)localObject1).az)
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (localObject2 != null)
      {
        ((QavVideoRecordUICtrl)localObject2).c();
        if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b() < 1000L) {
          i1 = 2;
        }
        ((SessionInfo)localObject1).ag = i1;
        ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      }
    }
    if ((this.jdField_e_of_type_Boolean) && (((SessionInfo)localObject1).av) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      localObject2 = String.valueOf(((SessionInfo)localObject1).jdField_f_of_type_Long);
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, (String)localObject2, ((SessionInfo)localObject1).jdField_e_of_type_JavaLangString);
      Intent localIntent = AIOUtils.a(new Intent(super.getApplicationContext(), SplashActivity.class), null);
      localIntent.putExtra("uin", (String)localObject2);
      localIntent.putExtra("uintype", ((SessionInfo)localObject1).jdField_k_of_type_Int);
      localIntent.putExtra("uinname", str);
      startActivity(localIntent);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("finish fromDoubleChat[");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject1).av);
      ((StringBuilder)localObject2).append("], session[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject2).toString());
    }
    super.finish();
  }
  
  void g()
  {
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if ((localSensorManager != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      localSensorManager.unregisterListener(this);
    }
  }
  
  void g(long paramLong)
  {
    a(paramLong, 0);
  }
  
  public void g(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool2 = true;
    boolean bool1;
    if ((localObject != null) && (((VideoController)localObject).a() != null) && (VideoLayerUIBase.b(this.jdField_a_of_type_ComTencentAvVideoController.a()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = this.jdField_b_of_type_JavaLangString;
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
    if (a())
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      if (localObject != null) {
        ((VideoLayerUI)localObject).a("onChangeUI_quitDoubleScreenStatus");
      }
    }
    if (paramBoolean) {
      a(2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
    {
      localObject = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a();
      if ((localObject != null) && (((FaceItem)localObject).isInteract()) && (((FaceItem)localObject).isSameType("face"))) {
        paramBoolean = bool2;
      } else {
        paramBoolean = false;
      }
      localObject = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_quitDoubleScreenStatus isIntactiveFace:");
      localStringBuilder.append(paramBoolean);
      AVLog.printColorLog((String)localObject, localStringBuilder.toString());
      if (paramBoolean) {
        a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
    }
  }
  
  public int getRequestedOrientation()
  {
    return super.getRequestedOrientation();
  }
  
  void h()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131363127);
    float f1 = getResources().getDimension(2131297762);
    float f2 = getResources().getDimension(2131297765);
    int i2 = (int)f1;
    int i1 = -1;
    Object localObject = new RelativeLayout.LayoutParams(-1, i2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)f2, 0, 0);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = new EffectFilterPanel(getBaseContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = localViewGroup.findViewById(2131373660);
    if (localObject != null) {
      i1 = localViewGroup.indexOfChild((View)localObject);
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel, i1);
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool)
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNotificationFlag resume[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localObject != null)
    {
      if (paramBoolean) {
        i1 = 1;
      }
      ((QAVNotification)localObject).a(i1);
    }
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel != null)
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131363127);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.setVisibility(8);
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel = null;
    }
  }
  
  public boolean isDestroyed()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return super.isDestroyed();
    }
    return this.jdField_a_of_type_Int == 5;
  }
  
  void j()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog == null) || (!localDialog.isShowing())) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label30:
      this.jdField_l_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  @TargetApi(21)
  public void k() {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
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
      paramIntent = this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer;
      if (paramIntent != null) {
        paramIntent.f();
      }
    }
    else if ((Build.VERSION.SDK_INT >= 21) && (paramInt1 == 8080))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
      if (localObject != null)
      {
        if (paramInt2 == -1)
        {
          ((ScreenRecordHelper)localObject).a(paramIntent);
          this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper.a();
          return;
        }
        ((ScreenRecordHelper)localObject).b();
      }
    }
    else if (paramInt1 == 2020)
    {
      localObject = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
      if (localObject != null) {
        ((WTogetherMng)localObject).a(SessionMgr.a().a(), paramInt2, paramIntent);
      }
    }
    else if (paramInt1 == 21001)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt2, paramIntent);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(this);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_k_of_type_Boolean == true)
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "avideo onBackPressed, onSaveInstanceState, return");
      return;
    }
    Object localObject = new ControlUIObserver.CPreEventInfo(null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7002), localObject });
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onBackPressed, BlockSystemBack[");
    localStringBuilder.append(((ControlUIObserver.CPreEventInfo)localObject).jdField_a_of_type_Boolean);
    localStringBuilder.append("], BlockName[");
    localStringBuilder.append(((ControlUIObserver.CPreEventInfo)localObject).jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    QLog.i(str, 1, localStringBuilder.toString());
    boolean bool1 = ((ControlUIObserver.CPreEventInfo)localObject).jdField_a_of_type_Boolean;
    boolean bool2 = bool1;
    if (!bool1)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller;
      bool2 = bool1;
      if (localObject != null) {
        bool2 = ((VideoChatRoomUIContoller)localObject).c();
      }
    }
    bool1 = bool2;
    if (!bool2)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiChildGuideUi;
      if ((localObject != null) && (((ChildGuideUi)localObject).a()))
      {
        bool1 = this.jdField_a_of_type_ComTencentAvUiChildGuideUi.b();
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((VideoControlUI)localObject).a();
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((QavDoubleVideoSharpnessMangaer)localObject).a())
      {
        this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.c();
        bool2 = true;
      }
    }
    if (!bool2) {
      super.onBackPressed();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "2");
    VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "2";
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject1 = SessionMgr.a().a();
    if ((localObject1 != null) && (((SessionInfo)localObject1).r()))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localObject2 != null)
      {
        ((WatchTogetherMediaPlayCtrl)localObject2).e();
        if (QLog.isDebugVersion())
        {
          int i1 = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
          localObject2 = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onConfigurationChanged, displayRotation[");
          localStringBuilder.append(i1);
          localStringBuilder.append("]");
          QLog.d((String)localObject2, 1, localStringBuilder.toString());
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if (localObject2 != null) {
          ((VideoLayerUI)localObject2).j(paramConfiguration.orientation);
        }
        if (paramConfiguration.orientation == 1) {
          if (((SessionInfo)localObject1).ax)
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          }
          else if (((SessionInfo)localObject1).w)
          {
            ((SessionInfo)localObject1).c(true);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.N();
          }
        }
        if (paramConfiguration.orientation != 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          if ((localObject1 != null) && (((VideoControlUI)localObject1).i())) {
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g("onConfigurationChanged");
          }
        }
      }
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(".onCreate.begin");
    AudioHelper.b(((StringBuilder)localObject1).toString());
    long l1 = AudioHelper.b();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
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
    super.setContentView(2131559680);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    f(true);
    a(super.getWindow());
    localObject1 = super.getAppRuntime();
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle != null)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, 尝试同步获取AppRuntime");
        paramBundle = paramBundle.getRuntime();
        localObject1 = this.jdField_b_of_type_JavaLangString;
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
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate, BaseApplicationImpl.getApplication is null");
        paramBundle = (Bundle)localObject1;
      }
    }
    if (paramBundle == null)
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate, appRuntime is null exit");
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131720211));
      paramBundle.append(" 0x05");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    if ((paramBundle instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramBundle);
    } else {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate, AppRuntime is no VideoAppInterface, ");
      ((StringBuilder)localObject2).append(paramBundle.getClass().getName());
      ((StringBuilder)localObject2).append(" exit");
      AVLog.printAllUserLog((String)localObject1, ((StringBuilder)localObject2).toString());
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131720211));
      paramBundle.append(" 0x06");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    e(true);
    paramBundle = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    localObject1 = SessionMgr.a().a();
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("avideo life_onCreate roomId = ");
      localStringBuilder.append(((SessionInfo)localObject1).b());
      localStringBuilder.append(",isReceiver = ");
      localStringBuilder.append(((SessionInfo)localObject1).jdField_e_of_type_Boolean);
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
      if (((SessionInfo)localObject1).jdField_e_of_type_Boolean) {
        paramBundle.a(((SessionInfo)localObject1).b(), 7, 1L);
      }
    }
    else
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onCreate sessionInfo is null ");
    }
    boolean bool = getIntent().getBooleanExtra("isMakingAcall", false);
    if (bool) {
      paramBundle.a(-1L, 1, 1L);
    }
    paramBundle = this.jdField_b_of_type_JavaLangString;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("avideo life_onCreate  isMakingAcall =  ");
    ((StringBuilder)localObject1).append(bool);
    QLog.d(paramBundle, 1, ((StringBuilder)localObject1).toString());
    AVReport.a().a(getIntent(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    PanoramaSensorManager.a().a(this);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController;
    if (paramBundle == null)
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.mVideoController exit");
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131720211));
      paramBundle.append(" 0x07");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    if (!paramBundle.d())
    {
      AVLog.printAllUserLog(this.jdField_b_of_type_JavaLangString, "onCreate,VideoAppInterface.initVcController exit");
      paramBundle = new StringBuilder();
      paramBundle.append(super.getString(2131720211));
      paramBundle.append(" 0x08");
      paramBundle = paramBundle.toString();
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.l(SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(getApplicationContext())));
    localObject1 = super.getIntent();
    if (localObject1 != null)
    {
      i1 = ((Intent)localObject1).getIntExtra("uinType", -1);
      paramBundle = ((Intent)localObject1).getStringExtra("uin");
      if (i1 == 1008)
      {
        localObject2 = SessionMgr.a(3, paramBundle, new int[0]);
        localObject2 = SessionMgr.a().c((String)localObject2);
        if ((localObject2 == null) || (((SessionInfo)localObject2).jdField_k_of_type_Int == -1))
        {
          localObject2 = SessionMgr.a().a();
          if ((((SessionInfo)localObject2).jdField_k_of_type_Int != -1) && ((((SessionInfo)localObject2).f()) || (((SessionInfo)localObject2).h())))
          {
            localObject1 = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
            ((Intent)localObject1).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            ((Intent)localObject1).putExtra("uin", paramBundle);
            ((Intent)localObject1).putExtra("uinType", i1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject1);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
            localObject1 = this.jdField_b_of_type_JavaLangString;
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
      localObject2 = this.jdField_b_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.sendGetGatewayMsg();
    b();
    e();
    this.jdField_a_of_type_JavaLangString = a(getIntent());
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!a(getIntent())) && (!SessionMgr.a().a(this.jdField_a_of_type_JavaLangString)))
    {
      paramBundle = this.jdField_a_of_type_ComTencentAvVideoController;
      paramBundle.a(false, 204, new int[] { paramBundle.a().jdField_j_of_type_Int });
      this.jdField_a_of_type_ComTencentAvVideoController.b(204);
      SessionMgr.a().a(this.jdField_a_of_type_JavaLangString, false);
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = SessionMgr.a().a().jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = this.jdField_b_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate, sessionId[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("]");
      QLog.i(paramBundle, 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
      c(l1);
    }
    GraphicRenderMgr.getInstance();
    ThreadManager.post(new AVActivity.4(this), 5, null, false);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    b(0);
    a(l1, false);
    if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
    {
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = new ConfigInfoTips(this);
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips.a();
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().L;
    if (QLog.isDevelopLevel())
    {
      paramBundle = this.jdField_b_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate changeVideoLayoutMode Style=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvVideoController.a().L);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvVideoController.g());
      QLog.d(paramBundle, 4, ((StringBuilder)localObject1).toString());
    }
    a(i1, false);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
    paramBundle = (ViewStub)findViewById(2131373380);
    this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer = new QavDoubleVideoSharpnessMangaer(findViewById(2131373321), paramBundle, 2131373600, this.jdField_a_of_type_ComTencentAvVideoController, this);
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller = new VideoChatRoomUIContoller(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
      findViewById(2131373551).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this);
    ((ScreenShareManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(17)).a(this);
    a();
    paramBundle = new StringBuilder();
    paramBundle.append(this.jdField_b_of_type_JavaLangString);
    paramBundle.append(".onCreate.end");
    AudioHelper.b(paramBundle.toString());
  }
  
  protected void onDestroy()
  {
    this.mIsShadow = false;
    super.onDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    long l1 = AudioHelper.b();
    Object localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo life_onDestroy, mActivityState[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("->");
    localStringBuilder.append(5);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], isQuit[");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("], session[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    a("onDestroy", l1);
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l1);
    b(5);
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(272);
    }
    k();
    localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller;
    if (localObject != null)
    {
      ((VideoChatRoomUIContoller)localObject).a(this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localObject != null) && (((VideoController)localObject).a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().az))
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (localObject != null) {
        ((QavVideoRecordUICtrl)localObject).c();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
    if (localObject != null)
    {
      ((QavVideoRecordUICtrl)localObject).e();
      this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
    if (localObject != null)
    {
      ((ICameraManagerApi)localObject).deleteObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject != null)
    {
      ((VideoLayerUI)localObject).p();
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject != null)
    {
      ((VideoControlUI)localObject).d(l1);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiChildGuideUi;
    if (localObject != null)
    {
      ((ChildGuideUi)localObject).b();
      this.jdField_a_of_type_ComTencentAvUiChildGuideUi = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.stopPlayback();
        localObject = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeAllViews();
        }
        this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      label420:
      int i1;
      break label420;
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a();
      }
    }
    localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      DoodleLogic.a().a();
      localObject = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
      if (localObject != null) {
        ((QAVNotification)localObject).a(this.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy isQuit[");
      localStringBuilder.append(this.jdField_e_of_type_Boolean);
      localStringBuilder.append("], session[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a().a().e("AVActivity.onDestroy", 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    this.jdField_a_of_type_ComTencentAvUiAVActivity$VideoOrientationEventListener = null;
    AudioHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    localObject = this.jdField_a_of_type_ComTencentAvUiConfigInfoTips;
    if (localObject != null)
    {
      ((ConfigInfoTips)localObject).b();
      this.jdField_a_of_type_ComTencentAvUiConfigInfoTips = null;
    }
    PanoramaSensorManager.a().a(null);
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(7004), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    }
    AVVoiceRecog.a().a();
    AVVoiceRecog.a().a(null, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    localObject = this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer;
    if (localObject != null)
    {
      i1 = ((QavDoubleVideoSharpnessMangaer)localObject).a();
      if (i1 > 0) {
        ReportController.b(null, "CliOper", "", "", "0X800A345", "0X800A345", i1, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.g();
    }
    this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer = null;
    if (AudioHelper.a()) {
      try
      {
        if (QavTest.getInstance().isQosTimerRun()) {
          QavTest.getInstance().stopQosTimer();
        }
      }
      catch (Throwable localThrowable1)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy", localThrowable1);
      }
    }
    AVUtil.a(this);
  }
  
  @RequiresApi(api=16)
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
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
      paramKeyEvent = this.jdField_a_of_type_ComTencentAvVideoController;
      if ((paramKeyEvent != null) && (this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null))
      {
        paramKeyEvent = paramKeyEvent.a();
        if (((paramKeyEvent.jdField_d_of_type_Int == 2) && (paramKeyEvent.j())) || ((paramKeyEvent.jdField_d_of_type_Int == 4) && (paramKeyEvent.jdField_f_of_type_Int >= 9)))
        {
          long l1 = AudioHelper.b();
          if (this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isCameraOpened(l1)) {
            f(l1);
          }
        }
      }
      return true;
    }
    for (;;)
    {
      try
      {
        if ((AudioProcess.a()) && (AudioProcess.a().isPlayStarted()))
        {
          if (paramInt != 25) {
            break label413;
          }
          i1 = -1;
          localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
          int i2 = ((AudioManager)localObject).getStreamVolume(0);
          if (this.jdField_a_of_type_JavaLangInteger == null) {
            this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i2);
          }
          int i3 = ((AudioManager)localObject).getStreamMaxVolume(0);
          if (this.jdField_c_of_type_JavaLangInteger == null) {
            this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(i3);
          }
          ((AudioManager)localObject).adjustStreamVolume(0, i1, 1);
          i1 = ((AudioManager)localObject).getStreamVolume(0);
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(i1);
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
          if (localObject != null) {
            ((WatchTogetherMediaPlayCtrl)localObject).a().a(this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
          }
          if (QLog.isColorLevel())
          {
            localObject = this.jdField_b_of_type_JavaLangString;
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
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "adjustStreamVolume fail.", localException);
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
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onNewIntent, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
    if (localObject != null) {
      ((SmallScreenActivityPlugin)localObject).b();
    }
    setIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("sessionType", 0);
    int i2 = paramIntent.getIntExtra("MultiAVType", 0);
    int i3 = this.jdField_b_of_type_Int;
    if ((i3 != 1) && (i3 != 2))
    {
      if ((i3 == 3) || (i3 == 4)) {
        if ((i2 != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 2))
        {
          if ((i1 != 3) && (i1 != 4))
          {
            if ((i1 == 1) || (i1 == 2))
            {
              paramIntent = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
              if (paramIntent != null)
              {
                paramIntent.d(l1);
                this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
              }
              c(l1);
              b(0);
              a(l1, false);
            }
          }
          else
          {
            c(l1);
            localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
            if (localObject != null) {
              ((VideoLayerUI)localObject).w();
            }
            localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            if (localObject != null) {
              ((VideoControlUI)localObject).c(paramIntent);
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == i2)
        {
          c(l1);
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if (localObject != null) {
            ((VideoLayerUI)localObject).w();
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          if (localObject != null) {
            ((VideoControlUI)localObject).c(paramIntent);
          }
        }
        else
        {
          paramIntent = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          if (paramIntent != null)
          {
            paramIntent.d(l1);
            this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          }
          c(l1);
          b(0);
          a(l1, false);
        }
      }
    }
    else if ((i1 == 3) || (i1 == 4))
    {
      paramIntent = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      if (paramIntent != null)
      {
        paramIntent.d(l1);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      c(l1);
      b(0);
      a(l1, false);
    }
  }
  
  protected void onPause()
  {
    long l1 = AudioHelper.b();
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo life_onPause, seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    AVVoiceRecog.a().a(16);
    h(false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    this.jdField_i_of_type_Boolean = true;
    try
    {
      this.mIsShadow = false;
      super.onPause();
      b(3);
      localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      if (localObject1 != null) {
        ((VideoControlUI)localObject1).f();
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController;
      if (localObject1 != null)
      {
        ((VideoController)localObject1).a("state", "0");
        if ("0".equals(VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "5");
        }
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "avideo life_onPause end");
      localObject1 = this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer;
      if (localObject1 != null)
      {
        ((QavDoubleVideoSharpnessMangaer)localObject1).c();
        this.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.f();
      }
      this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
    catch (Exception localException)
    {
      super.finish();
      localObject2 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onPause, exit when onPause Exception, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString(), localException);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1, 1007);
    }
  }
  
  public void onResume()
  {
    h(true);
    long l2 = AudioHelper.b();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 50, 1);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
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
      localObject3 = this.jdField_b_of_type_JavaLangString;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onResume IllegalArgumentException ");
      ((StringBuilder)localObject4).append(localIllegalArgumentException);
      QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("avideo onResume, mhasStopped[");
    ((StringBuilder)localObject3).append(this.o);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l2);
    ((StringBuilder)localObject3).append("], sessionInfo[");
    ((StringBuilder)localObject3).append(localSessionInfo);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
    this.jdField_i_of_type_Boolean = false;
    RenderUtil.a();
    VideoNodeReporter localVideoNodeReporter = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if (localSessionInfo.jdField_e_of_type_Boolean) {
      localVideoNodeReporter.a(localSessionInfo.b(), 8, 1L);
    }
    if (getIntent().getBooleanExtra("isMakingAcall", false)) {
      localVideoNodeReporter.a(-1L, 3, 1L);
    }
    if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    }
    this.o = false;
    int i4 = b();
    this.jdField_k_of_type_Boolean = false;
    b(2);
    this.jdField_a_of_type_ComTencentAvVideoController.e(true);
    localObject1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
    if (localObject1 != null) {
      ((SmallScreenActivityPlugin)localObject1).b();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localObject1 != null) && (((ScreenRecordHelper)localObject1).c())) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.12(this), 300L);
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.13(this, l2), 200L);
    if (localSessionInfo.jdField_d_of_type_Int == 2)
    {
      if (localSessionInfo.j())
      {
        localObject1 = localSessionInfo.jdField_c_of_type_JavaLangString;
        bool2 = localSessionInfo.jdField_k_of_type_Boolean;
        boolean bool3 = this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString);
        boolean bool4 = localSessionInfo.jdField_i_of_type_Boolean;
        bool1 = localSessionInfo.jdField_j_of_type_Boolean;
        if (bool1)
        {
          localObject3 = DeviceInfoUtil.d();
          if ((!this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isCameraOpening(l2)) && (!this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isCameraOpened(l2))) {
            this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(l2);
          } else if ((((String)localObject3).contains("vivo")) && (this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.getCameraParams() == null)) {
            this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.reopenCamera("AVonResume", l2, -1, -1);
          }
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if (localObject3 != null) {
          if ((bool1) && (bool2))
          {
            if (bool4)
            {
              ((VideoLayerUI)localObject3).a(l2, (String)localObject1, 1, true, false, bool3);
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(l2, true, false);
            }
            else
            {
              ((VideoLayerUI)localObject3).b(l2, true, false);
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l2, (String)localObject1, 1, true, false, bool3);
            }
          }
          else if (bool1) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(l2, true, false);
          } else if (bool2) {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l2, (String)localObject1, 1, true, false, bool3);
          }
        }
      }
      else if ((!localSessionInfo.Y) && (!this.jdField_f_of_type_Boolean))
      {
        localSessionInfo.b(l2, true);
        this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(l2);
        localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if (localObject1 != null) {
          ((VideoLayerUI)localObject1).b(l2, true, false);
        }
      }
    }
    else if (localSessionInfo.jdField_d_of_type_Int == 4)
    {
      ArrayList localArrayList = localSessionInfo.jdField_c_of_type_JavaUtilArrayList;
      Collections.sort(localArrayList, new AVActivity.14(this));
      int i1 = this.jdField_a_of_type_ComTencentAvVideoController.g();
      int i2 = 0;
      while (i2 < localArrayList.size())
      {
        VideoViewInfo localVideoViewInfo = (VideoViewInfo)localArrayList.get(i2);
        localObject3 = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
        int i3 = localVideoViewInfo.jdField_a_of_type_Int;
        bool2 = localVideoViewInfo.jdField_a_of_type_Boolean;
        localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
        if (localObject1 != null) {
          bool1 = ((VideoLayerUI)localObject1).a((String)localObject3, i3);
        } else {
          bool1 = false;
        }
        int i5 = AVUtil.b(this.jdField_d_of_type_Int);
        localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i5, (String)localObject3, String.valueOf(localSessionInfo.jdField_f_of_type_Long));
        if ((localVideoViewInfo.jdField_b_of_type_Boolean) && (!((String)localObject3).equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (bool2) && (!localVideoViewInfo.jdField_d_of_type_Boolean))
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
            localObject1 = String.format(getString(2131695521), new Object[] { localObject1 });
            localVideoControlUI = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            if ((localVideoControlUI != null) && ((localVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              localVideoControlUI.a(1036, (String)localObject1);
            } else {
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036, (String)localObject1);
            }
          }
          else
          {
            localObject1 = String.format(getString(2131695522), new Object[] { localObject1 });
            localVideoControlUI = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            if ((localVideoControlUI != null) && ((localVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              localVideoControlUI.a(1037, (String)localObject1);
            } else {
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037, (String)localObject1);
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          l();
          if ((!localVideoViewInfo.jdField_b_of_type_Boolean) && (!localVideoViewInfo.jdField_a_of_type_Boolean))
          {
            if (i1 != 4)
            {
              if (localSessionInfo.E == 2) {
                ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
              } else if (localSessionInfo.jdField_j_of_type_Int == 10) {
                ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
              } else {
                ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
              }
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l2, (String)localObject3, i3, this.jdField_a_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l2, (String)localObject3, i3, this.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
            }
          }
          else {
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l2, (String)localObject3, i3, this.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
          }
          if ((!bool1) && (!localSessionInfo.y))
          {
            float f2 = 12.0F;
            float f1 = f2;
            if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b((String)localObject3, i3))
            {
              f1 = f2;
              if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3) {
                f1 = 18.0F;
              }
            }
            f1 = UITools.a(getApplicationContext(), f1);
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject3, i3, (String)localObject4, f1, -1);
            this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject3, i3);
          }
        }
        i2 += 1;
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject1 != null) {
      ((VideoLayerUI)localObject1).B_();
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject1 != null) {
      ((VideoControlUI)localObject1).b(l2);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvUiChildGuideUi;
    if (localObject1 != null) {
      ((ChildGuideUi)localObject1).c();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
    c();
    f();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (a())) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onResume");
    }
    if ((localSessionInfo.jdField_d_of_type_Int == 2) || (localSessionInfo.jdField_d_of_type_Int == 1))
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if ((localObject1 != null) && (((QavVideoRecordUICtrl)localObject1).d() == 1) && (localSessionInfo.aA)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new AVActivity.15(this));
      }
    }
    if (localSessionInfo.T == -1) {
      localSessionInfo.T = a();
    }
    if (localSessionInfo.S == -1)
    {
      localObject1 = SharedPreUtils.a(getApplicationContext());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("firstEnter_");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      localSessionInfo.S = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject3).toString(), 1);
      if (localSessionInfo.S == 1)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("firstEnter_");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject3).toString(), 0).commit();
      }
    }
    if (localSessionInfo.ag != 0)
    {
      if (localSessionInfo.ag == 1)
      {
        QQToast.a(this, 2, getResources().getString(2131695769), 0).a();
      }
      else
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695780);
        QavRecordReporter.a("0X8008AB0");
      }
      localSessionInfo.ag = 0;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7000), this.jdField_c_of_type_JavaLangString });
    if (AudioHelper.a()) {
      try
      {
        QavTestUtil.showTestBtn(this);
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, "showTestBtn fail", localThrowable);
      }
    }
    AVVoiceRecog.a().b(16);
    boolean bool1 = localSessionInfo.jdField_j_of_type_Boolean;
    boolean bool2 = localSessionInfo.jdField_k_of_type_Boolean;
    if ((bool1) && (bool2)) {
      AVVoiceRecog.a().b(1);
    } else {
      AVVoiceRecog.a().a(1);
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_a_of_type_Long;
    long l1;
    if (localSessionInfo.b() > 0L) {
      l1 = localSessionInfo.b();
    } else {
      l1 = -1L;
    }
    localVideoNodeReporter.a(l1, 25, l3 - l4);
    this.jdField_a_of_type_ComTencentAvVideoController.a("state", "1");
    VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "0";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".onResume.end");
    AudioHelper.b(((StringBuilder)localObject2).toString());
    if (getIntent().getIntExtra("hc_code", 0) != 0) {
      HardCoderManager.a().a(getIntent().getIntExtra("hc_code", 0), true);
    }
    a().y();
    localObject2 = VideoController.a().a(false);
    if (localObject2 != null) {
      ((EffectController)localObject2).a(l2);
    }
    if (AudioHelper.a())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getSystemUiVisibility[");
      ((StringBuilder)localObject3).append(getWindow().getDecorView().getSystemUiVisibility());
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onResume, mCheckFirstShowChatRoomPanel[");
        ((StringBuilder)localObject3).append(localSessionInfo.at);
        ((StringBuilder)localObject3).append("]");
        QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (localSessionInfo.at)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(0);
        localSessionInfo.at = false;
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.16(this, i4), 300L);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localVideoController != null) && (paramSensorEvent != null)) {
      localVideoController.jdField_a_of_type_ComTencentAvVideoCameraListener.a(paramSensorEvent.values);
    }
  }
  
  protected void onStart()
  {
    Object localObject = SessionMgr.a().a();
    VideoNodeManager.a(20, 1L);
    if ((localObject != null) && (((SessionInfo)localObject).j())) {
      VideoNodeManager.a(31);
    }
    this.mIsShadow = false;
    super.onStart();
    b(1);
    this.o = false;
    long l1 = AudioHelper.b();
    localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo life_onStart, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    if (localObject != null) {
      ((VideoControlUI)localObject).a(l1);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localObject != null) {
      ((VideoLayerUI)localObject).q();
    }
    int i1 = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7003), this.jdField_c_of_type_JavaLangString });
  }
  
  protected void onStop()
  {
    long l1 = AudioHelper.b();
    Object localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    super.onStop();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l2 = AudioHelper.c();
    this.mIsShadow = false;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().az)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      if (localObject != null)
      {
        ((QavVideoRecordUICtrl)localObject).c();
        int i1;
        if (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b() >= 1000L) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().ag = i1;
        ReportController.b(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
      }
    }
    b(4);
    if (!this.jdField_h_of_type_Boolean) {
      b(l1);
    }
    i(l1);
    long l3 = AudioHelper.c();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(7001), this.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_e_of_type_Boolean) });
    e(l1);
    localObject = this.jdField_b_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo life_onStop, mIsMultiFinish[");
    localStringBuilder.append(this.jdField_h_of_type_Boolean);
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localObject != null) && (((VideoController)localObject).a().jdField_j_of_type_Int == 2)) {
      return;
    }
    b(4);
    long l1 = AudioHelper.b();
    if (AudioHelper.b())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onUserLeaveHint, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    i(l1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("life_onWindowFocusChanged, hasFocus[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], nfonWindowFocus[");
      localStringBuilder.append(this.jdField_j_of_type_Boolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_j_of_type_Boolean = false;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new AVActivity.onWindowFocusChangedRunnable(this), 500L);
    if (AVReport.a().jdField_a_of_type_Boolean)
    {
      AVReport.a().i = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().x = SystemClock.elapsedRealtime();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], ActivityState[");
    localStringBuilder.append(b());
    localStringBuilder.append("], isActivityVisible[");
    localStringBuilder.append(e());
    localStringBuilder.append("], ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity
 * JD-Core Version:    0.7.0.1
 */