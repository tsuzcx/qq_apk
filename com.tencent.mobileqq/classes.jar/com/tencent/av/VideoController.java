package com.tencent.av;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.av.app.GVideoDownloadChannelControl;
import com.tencent.av.app.MSFNetInfoMonitor;
import com.tencent.av.app.SessionFlag;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.av.avsdkconfig.QavSdkConfigHelper;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.compat.InviteUIChecker;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.core.SDKConfigInfoBuilder;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.core.VcControllerImpl.CloseVideoTimeoutCallback;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleReportController;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.QQGAudioCtrlCallback;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.screenshare.ScreenShareTipsHelper;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.so.ResMgr;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteFloatBarUICtr;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PerfReporter;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.QAVNotificationUtil;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avcore.data.AVInviteAccount;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.qav.QavTestUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import com.tencent.util.Pair;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  implements IVideoSession, QavChannelProxy.IChannelCallback, ISetAudioFrameCallback, IVideoEventListener, VcControllerImpl.CloseVideoTimeoutCallback, QQGAudioCtrlCallback
{
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController;
  public static String a = "VideoController";
  public static String b = "WifiQQCall";
  public static String c = "WifiRandom";
  public static String d = "WifiGuild";
  private static String jdField_e_of_type_JavaLangString = "com.tencent.av.count";
  public static int j = -1;
  public static int k = 1;
  public static int l;
  public int a;
  public long a;
  Context jdField_a_of_type_AndroidContentContext;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  public final QavChannelProxy a;
  SessionMgr jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
  private volatile VideoCallStateMonitor jdField_a_of_type_ComTencentAvVideoCallStateMonitor = null;
  public final VideoCameraListener a;
  VideoController.OnCustomCompletionListener jdField_a_of_type_ComTencentAvVideoController$OnCustomCompletionListener = new VideoController.9(this);
  VideoController.StartAudioSendRunnable jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
  VideoController.StartRingRunnable jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
  GVideoDownloadChannelControl jdField_a_of_type_ComTencentAvAppGVideoDownloadChannelControl = new GVideoDownloadChannelControl();
  public VideoAppInterface a;
  public AVCallCompactHelper a;
  private InviteUIChecker jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
  VcControllerImpl jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
  QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  private EffectsRenderController jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController;
  private ScreenShareCtrl jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
  private ScreenRecordHelper jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
  PhoneStatusMonitor.PhoneStatusListener jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener;
  public PhoneStatusMonitor a;
  public TraeHelper a;
  private WatchTogetherMediaPlayCtrl jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoController.1(this);
  ArrayList<VideoController.GAudioFriends> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = true;
  private SdkAudioFrameCallback[] jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback = null;
  public int b;
  public long b;
  VideoController.OnCustomCompletionListener jdField_b_of_type_ComTencentAvVideoController$OnCustomCompletionListener = new VideoController.10(this);
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoController.2(this);
  private ArrayList<VideoController.GAudioFriends> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  VideoController.OnCustomCompletionListener jdField_c_of_type_ComTencentAvVideoController$OnCustomCompletionListener = new VideoController.12(this);
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  private final ArrayList<VideoController.GAudioFriends> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  public long d;
  Runnable d;
  public boolean d;
  public int e;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  public boolean e;
  public int f;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int = 0;
  Runnable jdField_g_of_type_JavaLangRunnable = null;
  public volatile boolean g;
  public int h;
  Runnable jdField_h_of_type_JavaLangRunnable = null;
  boolean jdField_h_of_type_Boolean = false;
  int jdField_i_of_type_Int = 0;
  Runnable jdField_i_of_type_JavaLangRunnable = null;
  boolean jdField_i_of_type_Boolean = false;
  Runnable jdField_j_of_type_JavaLangRunnable = null;
  boolean jdField_j_of_type_Boolean = false;
  Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.37(this);
  boolean jdField_k_of_type_Boolean = false;
  private Runnable l;
  public boolean l;
  int jdField_m_of_type_Int = jdField_j_of_type_Int;
  private Runnable jdField_m_of_type_JavaLangRunnable = new VideoController.36(this);
  public boolean m;
  private int jdField_n_of_type_Int = 0;
  private Runnable jdField_n_of_type_JavaLangRunnable = null;
  public boolean n;
  private int o;
  public boolean o;
  private int p;
  public boolean p;
  private int jdField_q_of_type_Int = -1;
  boolean jdField_q_of_type_Boolean = false;
  boolean r;
  boolean s = false;
  public boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y;
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoCameraListener = new VideoCameraListener(this);
    this.jdField_b_of_type_Long = 6000L;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_l_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_p_of_type_Int = 1;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactHelper = null;
    this.jdField_a_of_type_ComTencentAvQavChannelProxy = new QavChannelProxy(this);
    if (AVUtil.b()) {
      this.jdField_a_of_type_ComTencentAvCompatAVCallCompactHelper = new AVCallCompactHelper();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker = new InviteUIChecker();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoController create.");
    }
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  private void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new VideoController.4(this, a(), 3);
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Can detect orientation");
      }
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Cannot detect orientation");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
  }
  
  private void H()
  {
    Object localObject = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    if (localObject != null)
    {
      long l1 = System.currentTimeMillis();
      boolean bool = ((AudioManager)localObject).isMicrophoneMute();
      if (bool) {
        ((AudioManager)localObject).setMicrophoneMute(false);
      }
      long l2 = System.currentTimeMillis();
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ---setMicrophoneMute:");
      localStringBuilder.append(bool);
      localStringBuilder.append("|");
      localStringBuilder.append(l2 - l1);
      AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    }
  }
  
  private void I()
  {
    Object localObject = a();
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
    {
      int i4 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
      long l1 = ((SessionInfo)localObject).jdField_g_of_type_Long;
      int i1 = 0;
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      int i2 = this.jdField_d_of_type_Int;
      ((QQGAudioCtrl)localObject).inviteUser(new long[] { l1 }, i2);
      int i5 = i4 - 1;
      localObject = new long[i5 * 2];
      int i3;
      for (i2 = 0; i1 < i4; i2 = i3)
      {
        i3 = i2;
        if (((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue() != l1)
        {
          i3 = i2;
          if (i2 < i5)
          {
            i3 = i2 * 2;
            localObject[i3] = 1L;
            localObject[(i3 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
            i3 = i2 + 1;
          }
        }
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject, i5, null, 0, 0, false, false, 4);
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController == null)
        {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController = new EffectsRenderController(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.b();
        }
        this.jdField_a_of_type_ComTencentAvVideoCameraListener.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController);
        return;
      }
    }
  }
  
  private void K()
  {
    if (this.jdField_n_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_n_of_type_JavaLangRunnable);
    }
    this.jdField_n_of_type_JavaLangRunnable = null;
  }
  
  private void L()
  {
    if ((this.jdField_d_of_type_Long != -1L) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 20);
    localNewIntent.putExtra("vMsg", localReqEcho.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkNetStatus -->sendEcho");
    }
    this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(localNewIntent);
  }
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {
      if (paramInt1 != 0)
      {
        if (paramInt1 == 8) {
          break label319;
        }
        if (paramInt1 != 1004) {
          if (paramInt1 != 1006) {
            if (paramInt1 != 1021) {
              if (paramInt1 != 1044)
              {
                if (paramInt1 == 9500) {
                  break label167;
                }
                if (paramInt1 != 1000) {
                  if (paramInt1 != 1001) {
                    if (paramInt1 != 1010) {
                      if (paramInt1 != 1011) {
                        if ((paramInt1 != 1024) && (paramInt1 != 1025)) {
                          if (paramInt1 != 10002) {
                            if (paramInt1 == 10003) {}
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      break label304;
      return 29;
      return 27;
      return 19;
      return 21;
      return 20;
      return 12;
      return 8;
      return 30;
      return 10;
      return 5;
      return 9;
      if (paramInt2 != 2) {
        break label358;
      }
      break;
      if (paramInt1 == 0) {
        break label358;
      }
      if (paramInt1 == 12) {
        break label354;
      }
      if (paramInt1 == 9500) {
        break label358;
      }
      if ((paramInt1 == 4) || (paramInt1 == 5)) {
        break label350;
      }
      if (paramInt1 == 29) {
        break label346;
      }
      if (paramInt1 == 30) {
        break label342;
      }
      switch (paramInt1)
      {
      default: 
        paramInt2 = paramInt1;
        switch (paramInt1)
        {
        default: 
          switch (paramInt1)
          {
          default: 
            return -1;
          case 27: 
            return 10002;
          }
          break;
        }
        break;
      }
    case 26: 
      return 26;
    case 25: 
      return 25;
    case 24: 
      label167:
      label304:
      return 24;
    }
    label319:
    return 22;
    return 1011;
    return 1010;
    return 1021;
    return 1004;
    return 1000;
    label342:
    return 1044;
    label346:
    return 10003;
    label350:
    return 1006;
    label354:
    return 1001;
    label358:
    paramInt2 = 0;
    return paramInt2;
  }
  
  private int a(long paramLong1, long paramLong2)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.sendQueryRoomInfoRequest(paramLong1, paramLong2);
    }
    return -100;
  }
  
  private int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    boolean bool2 = false;
    int i1;
    if (localObject1 != null)
    {
      if (paramBoolean1) {
        i1 = ((QQGAudioCtrl)localObject1).startAudioSend(paramBoolean2);
      } else {
        i1 = ((QQGAudioCtrl)localObject1).nativeStopAudioSend(paramBoolean2);
      }
    }
    else {
      i1 = 0;
    }
    boolean bool3 = this.t;
    localObject1 = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
    if (!paramBoolean1)
    {
      boolean bool1;
      if ((!paramBoolean2) && (!bool3)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      this.t = bool1;
    }
    else
    {
      this.t = false;
    }
    if (paramInt != 2)
    {
      if ((i1 != 0) && (paramBoolean2))
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
        if (localObject2 == null)
        {
          this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
        }
        else
        {
          localObject3 = this.jdField_a_of_type_MqqOsMqqHandler;
          if (localObject3 != null) {
            ((MqqHandler)localObject3).removeCallbacks((Runnable)localObject2);
          }
          if (paramInt == 0) {
            this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
          }
        }
        localObject2 = this.jdField_a_of_type_MqqOsMqqHandler;
        if (localObject2 != null) {
          ((MqqHandler)localObject2).postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable, 1000L);
        }
      }
      else if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      }
    }
    else {
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
    }
    Object localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("switchAudioSend[");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(paramLong);
    ((StringBuilder)localObject3).append("], flag[");
    ((StringBuilder)localObject3).append(paramInt);
    ((StringBuilder)localObject3).append("], enable[");
    ((StringBuilder)localObject3).append(paramBoolean1);
    ((StringBuilder)localObject3).append("], notifySvr[");
    ((StringBuilder)localObject3).append(paramBoolean2);
    ((StringBuilder)localObject3).append("], mIsMicOffBySelf[");
    ((StringBuilder)localObject3).append(bool3);
    ((StringBuilder)localObject3).append("->");
    ((StringBuilder)localObject3).append(this.t);
    ((StringBuilder)localObject3).append("], result[");
    ((StringBuilder)localObject3).append(i1);
    ((StringBuilder)localObject3).append("], mGAudioCtrl[");
    paramBoolean1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      paramBoolean1 = true;
    }
    ((StringBuilder)localObject3).append(paramBoolean1);
    ((StringBuilder)localObject3).append("], lastRunnable[");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append("], curRunnable[");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    return i1;
  }
  
  private VideoController.OnCustomCompletionListener a(long paramLong)
  {
    if (this.jdField_l_of_type_JavaLangRunnable == null) {
      this.jdField_l_of_type_JavaLangRunnable = new VideoController.11(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_l_of_type_JavaLangRunnable, 2000L);
    VideoController.OnCustomCompletionListener localOnCustomCompletionListener = this.jdField_b_of_type_ComTencentAvVideoController$OnCustomCompletionListener;
    localOnCustomCompletionListener.jdField_a_of_type_Long = paramLong;
    return localOnCustomCompletionListener;
  }
  
  public static VideoController a()
  {
    if (jdField_a_of_type_ComTencentAvVideoController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvVideoController == null) {
          jdField_a_of_type_ComTencentAvVideoController = new VideoController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvVideoController;
  }
  
  private SessionInfo a(int paramInt, String paramString)
  {
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = SessionMgr.a(3, paramString, new int[0]);
      localObject2 = SessionMgr.a().c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = SessionMgr.a(100, paramString, new int[0]);
        localObject1 = SessionMgr.a().c((String)localObject1);
      }
    }
    else if (paramInt == 4)
    {
      localObject1 = SessionMgr.a(4, paramString, new int[0]);
      localObject1 = SessionMgr.a().c((String)localObject1);
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = SessionMgr.a().b(paramString);
    }
    return localObject2;
  }
  
  private qav_gvideo_sdk_transfer.RespInfo a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject1 = new qav_gvideo_sdk_transfer.ReqInfo();
    ((qav_gvideo_sdk_transfer.ReqInfo)localObject1).req_event.set(4);
    ((qav_gvideo_sdk_transfer.ReqInfo)localObject1).gAudioInfo.setHasFlag(true);
    Object localObject2 = ((qav_gvideo_sdk_transfer.ReqInfo)localObject1).gAudioInfo;
    ((qav_gvideo_sdk_transfer.GAudioInfo)localObject2).uint32_relationType.set(paramInt1);
    ((qav_gvideo_sdk_transfer.GAudioInfo)localObject2).uint32_multiBusiType.set(paramInt2);
    ((qav_gvideo_sdk_transfer.GAudioInfo)localObject2).uint64_relationId.set(paramLong);
    localObject1 = a(3, ((qav_gvideo_sdk_transfer.ReqInfo)localObject1).toByteArray());
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGAudioRoomInfo, result[");
      localStringBuilder.append(((qav_gvideo_sdk_transfer.RespInfo)localObject1).uint32_result.get());
      localStringBuilder.append("], uint64_roomId[");
      localStringBuilder.append(((qav_gvideo_sdk_transfer.RespInfo)localObject1).gAudioInfo.uint64_roomId.get());
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramAVUserInfo.account;
    long l3 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    if (l3 == l1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong1), new int[0]);
    if (paramInt == 3) {
      paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong1), new int[0]);
    }
    if (paramInt == 1) {
      ??? = a();
    } else {
      ??? = SessionMgr.a().c(paramVarArgs);
    }
    long l2;
    boolean bool2;
    label511:
    long l4;
    if ((??? != null) && (!TextUtils.isEmpty(((SessionInfo)???).jdField_b_of_type_JavaLangString)))
    {
      l2 = AudioHelper.b();
      if (AudioHelper.b())
      {
        paramVarArgs = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGAudioUserEnterOrLeave, mGAudioGroupId[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("], relationId[");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("], mGAudioRelationType[");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("], relationType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], UserInfo[");
        localStringBuilder.append(paramAVUserInfo);
        localStringBuilder.append("], isEnter[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], bSelfIn[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(l3);
        localStringBuilder.append("], mGAudioMute[");
        localStringBuilder.append(this.jdField_k_of_type_Boolean);
        localStringBuilder.append("], switchToGAudioMode[");
        localStringBuilder.append(((SessionInfo)???).jdField_F_of_type_Int);
        localStringBuilder.append("], extroInfo = ");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l2);
        localStringBuilder.append("]");
        QLog.w(paramVarArgs, 1, localStringBuilder.toString());
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((SessionInfo)???).K = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        bool2 = ((SessionInfo)???).a();
        paramVarArgs = this.jdField_a_of_type_MqqOsMqqHandler;
        if (paramVarArgs != null) {
          paramVarArgs.post(new VideoController.39(this, bool2));
        }
        if ((this.jdField_b_of_type_Int == 1) && (((SessionInfo)???).jdField_j_of_type_Int == 10)) {
          break label511;
        }
        if (this.jdField_b_of_type_Int == 2)
        {
          if (paramLong2 == 0L) {
            bool2 = false;
          } else {
            bool2 = true;
          }
          ((SessionInfo)???).T = bool2;
        }
      }
      bool2 = bool1;
      paramVarArgs = a();
      if ((!paramBoolean) && (l1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()))
      {
        long l5 = paramVarArgs.jdField_f_of_type_Long;
        l4 = paramLong1;
        if (l4 == l5)
        {
          a(paramInt, l4, 72);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
          return;
        }
      }
      l4 = paramLong1;
      a(paramAVUserInfo, paramBoolean);
      if (paramBoolean)
      {
        paramVarArgs.d("onGAudioUserEnterOrLeave", 2);
        if (paramVarArgs.jdField_f_of_type_Int < 10) {
          if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (bool2))
          {
            paramVarArgs.a("onGAudioUserEnterOrLeave.1", 9);
            paramVarArgs.jdField_V_of_type_Boolean = false;
          }
          else
          {
            paramVarArgs.a("onGAudioUserEnterOrLeave.2", 10);
            t();
          }
        }
        if ((paramVarArgs.jdField_g_of_type_Long != l1) && (l1 != l3)) {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
        }
        if (paramVarArgs.jdField_y_of_type_Boolean)
        {
          if (!bool2) {
            paramVarArgs.a(l2, SystemClock.elapsedRealtime());
          }
        }
        else if (paramVarArgs.jdField_d_of_type_Long == 0L) {
          paramVarArgs.a(l2, SystemClock.elapsedRealtime());
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        if ((this.jdField_c_of_type_JavaUtilArrayList.size() != 1) || (this.jdField_c_of_type_JavaUtilArrayList.get(0) == null) || (((VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long != l3)) {
          break label1585;
        }
        i1 = 1;
        if (i1 != 0)
        {
          paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
          paramVarArgs.jdField_V_of_type_Boolean = true;
          ??? = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((??? != null) && (((QAVNotification)???).a()))
          {
            u();
            d();
          }
        }
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
        if (paramBoolean)
        {
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramAVUserInfo.accountType == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool1) });
        }
        else if (paramLong2 == 1L)
        {
          d(true);
        }
        else if (paramLong2 == 0L)
        {
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramAVUserInfo.accountType == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
        }
        else
        {
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          bool1 = false;
          if (paramAVUserInfo.accountType == 0) {
            bool1 = true;
          }
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
        }
        if (paramVarArgs.jdField_y_of_type_Boolean)
        {
          if ((paramBoolean) && (!bool2))
          {
            paramAVUserInfo = a();
            if (paramAVUserInfo != null) {
              paramAVUserInfo.b(l4);
            }
          }
          paramAVUserInfo = new Intent();
          paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
          if (paramBoolean) {
            paramAVUserInfo.putExtra("type", 401);
          } else {
            paramAVUserInfo.putExtra("type", 402);
          }
          paramAVUserInfo.putExtra("relationType", 3);
          paramAVUserInfo.putExtra("relationId", l4);
          paramAVUserInfo.putExtra("friendUin", l1);
          paramAVUserInfo.putExtra("MultiAVType", paramVarArgs.jdField_j_of_type_Int);
          paramAVUserInfo.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramAVUserInfo);
          if (!paramBoolean)
          {
            if (paramVarArgs.jdField_z_of_type_Boolean)
            {
              paramAVUserInfo = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
              u();
              if (paramAVUserInfo.a()) {
                paramAVUserInfo.a(paramVarArgs.jdField_b_of_type_JavaLangString);
              }
            }
            if (paramVarArgs.af) {
              a(l2, paramLong1, false, 2);
            }
          }
        }
        else
        {
          paramAVUserInfo = new Intent();
          paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
          if (paramBoolean)
          {
            paramAVUserInfo.putExtra("type", 22);
            paramAVUserInfo.putExtra("isStart", this.jdField_q_of_type_Boolean);
          }
          else
          {
            paramAVUserInfo.putExtra("type", 23);
          }
          paramAVUserInfo.putExtra("roomUserNum", this.jdField_c_of_type_JavaUtilArrayList.size());
          paramAVUserInfo.putExtra("relationType", paramInt);
          paramAVUserInfo.putExtra("relationId", l4);
          paramAVUserInfo.putExtra("friendUin", l1);
          paramAVUserInfo.putExtra("MultiAVType", a().jdField_j_of_type_Int);
          paramAVUserInfo.putExtra("from", "VideoController5");
          paramAVUserInfo.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramAVUserInfo);
        }
        return;
      }
      paramAVUserInfo = jdField_a_of_type_JavaLangString;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onGAudioUserEnterOrLeave, illegal session, sessionId[");
      ((StringBuilder)???).append(paramVarArgs);
      ((StringBuilder)???).append("]");
      QLog.i(paramAVUserInfo, 1, ((StringBuilder)???).toString());
      return;
      label1585:
      int i1 = 0;
    }
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoRecv ");
    Context localContext = a();
    if (localContext == null) {
      return;
    }
    WTogetherRealNameVideoProcessHelper localWTogetherRealNameVideoProcessHelper = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localWTogetherRealNameVideoProcessHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695853));
    localWTogetherRealNameVideoProcessHelper.b(new VideoController.38(this, paramLong1, paramLong2, paramInt1, paramLong3, paramInt2, localContext, localWTogetherRealNameVideoProcessHelper));
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, long paramLong3, int paramInt2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGaChatVideoInOrOut, groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], user[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], bVideoIn[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], extraInfo[");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append("], avtype[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean) && (paramLong2 != l2) && (paramInt1 == 3)) {
      return;
    }
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      while (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong2)
        {
          i1 = ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
          break label314;
        }
        i1 += 1;
      }
    }
    int i1 = 1;
    label314:
    a(paramLong2, paramBoolean, paramInt1, paramLong3);
    if (paramBoolean)
    {
      if ((paramInt1 != 2) && (paramInt1 != 3)) {
        if ((paramInt1 != 1) || (paramInt2 != 10)) {
          return;
        }
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(69), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i1), Long.valueOf(l1) });
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGaChatPPTInOrOut,groupUin=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" uin = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" bIn = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" bIsPPT = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" extraInfo = ");
      localStringBuilder.append(paramLong3);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    long l1 = AVUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {
      localObject = SessionMgr.a(100, String.valueOf(paramLong1), new int[0]);
    } else {
      localObject = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
    if (localObject != null) {
      ((SessionInfo)localObject).a(paramLong2, paramBoolean1, paramBoolean2);
    }
    a(paramLong2, paramBoolean1, paramInt1, paramBoolean2, paramInt2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(77), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(78), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    Object localObject1 = a(String.valueOf(paramLong1));
    Object localObject2;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onMemberVideoInOrOut-->Can not find the.Uin=");
        ((StringBuilder)localObject2).append(paramLong1);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    ((VideoController.GAudioFriends)localObject1).jdField_b_of_type_Boolean = paramBoolean;
    if ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1)) {
      return;
    }
    if (paramBoolean)
    {
      localObject2 = new VideoViewInfo();
      ((VideoViewInfo)localObject2).jdField_a_of_type_Long = paramLong1;
      ((VideoViewInfo)localObject2).jdField_a_of_type_Int = 1;
      if (a().a(paramLong1, ((VideoViewInfo)localObject2).jdField_a_of_type_Int) != -1) {
        return;
      }
      ((VideoViewInfo)localObject2).jdField_b_of_type_Long = paramLong2;
      if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
        ((VideoViewInfo)localObject2).jdField_b_of_type_Long = 5L;
      }
      if (!a().w()) {
        ((VideoViewInfo)localObject2).jdField_a_of_type_Boolean = true;
      } else {
        ((VideoViewInfo)localObject2).jdField_a_of_type_Boolean = false;
      }
      if ((g() != 4) && (paramInt != 3))
      {
        if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1) {
          ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
        } else {
          ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = false;
        }
      }
      else {
        ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
      }
      if (((VideoController.GAudioFriends)localObject1).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
      {
        ((VideoViewInfo)localObject2).jdField_b_of_type_Boolean = true;
        ((VideoViewInfo)localObject2).jdField_d_of_type_Boolean = true;
        ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
        if (!a().w()) {
          ((VideoViewInfo)localObject2).jdField_a_of_type_Boolean = true;
        } else {
          ((VideoViewInfo)localObject2).jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        ((VideoViewInfo)localObject2).jdField_b_of_type_Boolean = false;
      }
      a().a((VideoViewInfo)localObject2, false);
      return;
    }
    if (paramInt == 2) {
      a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    } else if (paramInt == 1)
    {
      if (a().jdField_j_of_type_Int == 10) {
        a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      } else {
        a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      }
    }
    else if (paramInt == 3) {
      a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    w();
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject1;
    if ((paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 == 2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onMemberShareSrcInOrOut-->relationtype is not discuss,uin=");
        ((StringBuilder)???).append(paramLong);
        ((StringBuilder)???).append(",bin=");
        ((StringBuilder)???).append(paramBoolean1);
        ((StringBuilder)???).append(",relationType=");
        ((StringBuilder)???).append(paramInt1);
        ((StringBuilder)???).append(",isPPT=");
        ((StringBuilder)???).append(paramBoolean2);
        QLog.e((String)localObject1, 2, ((StringBuilder)???).toString());
      }
      return;
    }
    if (paramLong == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((!b()) && (paramLong == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "ScreenShare launcher shoult not display content");
      }
      return;
    }
    ??? = a(String.valueOf(paramLong));
    if (??? == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onMemberSpeak-->Can not find the.Uin=");
        ((StringBuilder)???).append(paramLong);
        QLog.e((String)localObject1, 2, ((StringBuilder)???).toString());
      }
      return;
    }
    if (paramBoolean1)
    {
      localObject1 = new VideoViewInfo();
      if (paramBoolean2) {
        ((VideoController.GAudioFriends)???).jdField_b_of_type_Int = 2;
      } else {
        ((VideoController.GAudioFriends)???).jdField_b_of_type_Int = 1;
      }
      ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong;
      ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
      ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean = true;
      ((VideoViewInfo)localObject1).jdField_b_of_type_Boolean = false;
      long l1;
      if (paramInt1 != 0) {
        l1 = 4L;
      } else {
        l1 = 5L;
      }
      ((VideoViewInfo)localObject1).jdField_b_of_type_Long = l1;
      if (a().a(paramLong, ((VideoViewInfo)localObject1).jdField_a_of_type_Int) != -1) {
        return;
      }
      if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
      {
        ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = false;
        if (g() != 4)
        {
          paramInt1 = a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue());
          if (paramInt1 != -1) {
            ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_c_of_type_Boolean = false;
          }
        }
      }
      ((VideoViewInfo)localObject1).jdField_c_of_type_Boolean = true;
      if (a().jdField_c_of_type_JavaUtilArrayList.size() > 1)
      {
        VideoViewInfo localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
        a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
        synchronized (a().jdField_d_of_type_JavaUtilArrayList)
        {
          a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
          a().a(localVideoViewInfo2, false);
          return;
        }
      }
      a().a(localVideoViewInfo1, true);
      return;
    }
    ((VideoController.GAudioFriends)???).jdField_b_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    w();
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (localObject != null) {
      ((AVCallCompactHelper)localObject).a(paramIntent);
    }
    long l1 = 0L;
    localObject = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
    if (localObject != null) {
      l1 = ((InviteUIChecker)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramIntent, true);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("startInviteForGroup canStartActivityNow[");
      paramIntent.append(true);
      paramIntent.append("], timeout[");
      paramIntent.append(l1);
      paramIntent.append("]");
      QLog.i("CompatModeTag", 2, paramIntent.toString());
    }
  }
  
  private void a(Intent paramIntent, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVCallCompactHelper localAVCallCompactHelper = a();
    VideoUtils.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772220, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
    if (localAVCallCompactHelper != null) {
      localAVCallCompactHelper.a(paramIntent);
    }
    if (paramBoolean2) {
      a(paramString, "screenState", String.valueOf(2));
    } else {
      a(paramString, "screenState", String.valueOf(1));
    }
    a(paramString, "inviteUIState", String.valueOf(1));
    long l1 = 0L;
    paramString = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
    if (paramString != null) {
      l1 = paramString.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramIntent, true);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("startInvite  canStartActivityNow[");
      paramIntent.append(true);
      paramIntent.append("], timeout[");
      paramIntent.append(l1);
      paramIntent.append("]");
      QLog.i("CompatModeTag", 2, paramIntent.toString());
    }
  }
  
  private void a(ArrayList<VideoViewInfo> paramArrayList, int paramInt)
  {
    int i1 = a().jdField_L_of_type_Int;
    int i4 = 0;
    if (i1 == 3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (a().jdField_d_of_type_Int == 4) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      i4 = 1;
    }
    int i3 = paramInt;
    Object localObject;
    if (i1 != 0)
    {
      i3 = paramInt;
      if (i2 != 0)
      {
        i3 = paramInt;
        if (i4 != 0)
        {
          i1 = paramArrayList.size() - 1;
          i3 = paramInt;
          if (i1 != paramInt)
          {
            localObject = (VideoViewInfo)paramArrayList.get(paramInt);
            paramArrayList.set(paramInt, paramArrayList.get(i1));
            paramArrayList.set(i1, localObject);
            i3 = i1;
          }
        }
      }
    }
    paramArrayList.remove(i3);
    if (QLog.isColorLevel())
    {
      paramArrayList = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRequest_ShowVideo,in removeChildrenWithStytle infoLogs[");
      ((StringBuilder)localObject).append(a(a().jdField_c_of_type_JavaUtilArrayList));
      ((StringBuilder)localObject).append("]");
      QLog.w(paramArrayList, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = a(String.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberSpeak-->Can not find the.Uin=");
        localStringBuilder.append(paramLong);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return false;
    }
    ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Boolean = paramBoolean;
    ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  private void b(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    if (this.jdField_n_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_n_of_type_JavaLangRunnable);
    }
    this.jdField_n_of_type_JavaLangRunnable = new VideoController.44(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_n_of_type_JavaLangRunnable, 1000L);
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  public static int d(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences(jdField_e_of_type_JavaLangString, 0);
    int i1 = ((SharedPreferences)localObject).getInt(paramString, 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, i1 + 1);
    ((SharedPreferences.Editor)localObject).commit();
    return i1;
  }
  
  private boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.jdField_c_of_type_JavaLangString == null) {
        return false;
      }
      if (paramString.equals(localSessionInfo.jdField_c_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean q()
  {
    Object localObject1 = (WindowManager)a().getSystemService("window");
    Object localObject2 = new DisplayMetrics();
    ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    int i1 = ((DisplayMetrics)localObject2).widthPixels;
    int i2 = ((DisplayMetrics)localObject2).heightPixels;
    int i3 = ((WindowManager)localObject1).getDefaultDisplay().getRotation();
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isLandscape screenWidth: ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", screenHeight: ");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(", rotation: ");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(", orientation: ");
      ((StringBuilder)localObject2).append(this.jdField_n_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((i1 <= i2) && (i3 != 1) && (i3 != 3))
    {
      i1 = this.jdField_n_of_type_Int;
      if (i1 != 4) {
        return i1 == 2;
      }
    }
    return true;
  }
  
  public void A()
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      localVcControllerImpl.onProcessExit();
    }
  }
  
  public void B()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRecordVoice, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    a(l1, 2131230743, 1, null);
  }
  
  public void C()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRecordDing, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, null, 1, null);
  }
  
  void D()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.sdk.onRequestVideo");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void E()
  {
    SessionInfo localSessionInfo = a();
    long l1 = AudioHelper.b();
    if ((localSessionInfo.j()) || (localSessionInfo.k()) || (localSessionInfo.jdField_f_of_type_Int == 9) || (localSessionInfo.l()))
    {
      SmallScreenUtils.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = localSessionInfo.jdField_b_of_type_JavaLangString;
      int i1 = localSessionInfo.jdField_d_of_type_Int;
      boolean bool;
      if (localSessionInfo.jdField_f_of_type_Int != 9) {
        bool = true;
      } else {
        bool = false;
      }
      a(str, i1, false, bool, localSessionInfo.u());
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reNotifyChatInfo2QQ, sessionInfo[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void F()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a();
    }
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.i();
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl = null;
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!a().j()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setGroundGlassSwitch(a().jdField_c_of_type_JavaLangString, paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGatewayTestResult networkType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | signalStrength:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" | pingResult:");
    localStringBuilder.append(paramInt3);
    AVLog.printColorLog(str, localStringBuilder.toString());
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setNativeGatewayTestResult(paramInt1, paramInt2, paramInt3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((a().jdField_d_of_type_Int != 1) && (a().jdField_d_of_type_Int != 2)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioDataFormat(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramLong == 0L)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "startGAudioChat, relationId illegal.");
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      m();
    }
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("==> startGAudioChat() ********************************** isVideo = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append("  getSessionInfo().multiAVType = ");
    ((StringBuilder)localObject1).append(a().jdField_j_of_type_Int);
    AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject1).toString());
    AudioHelper.b("startGAudioChat ");
    c(false);
    localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startGAudioChat, relationType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], relationId[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], businessId[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], uinList[");
    ((StringBuilder)localObject2).append(paramArrayOfLong);
    ((StringBuilder)localObject2).append("], isVideo[");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], mGAudioCtrl[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("], mApp[");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return -1;
    }
    localObject1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((SessionInfo)localObject2).jdField_E_of_type_Int = paramInt1;
        ((SessionInfo)localObject2).jdField_j_of_type_Int = paramInt2;
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
    }
    this.jdField_l_of_type_Boolean = false;
    long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramInt1 != 7) && (paramInt1 != 9))
    {
      if (paramInt1 == 2)
      {
        if (a().jdField_j_of_type_Boolean) {
          paramInt2 = 2;
        } else {
          paramInt2 = 1;
        }
        i1 = 1;
        break label579;
      }
      if (paramInt1 == 1)
      {
        i1 = a().jdField_j_of_type_Int;
        if (a().jdField_j_of_type_Boolean) {
          paramInt2 = 2;
        } else {
          paramInt2 = 1;
        }
        break label579;
      }
      if (paramInt1 != 10) {
        if (paramInt1 == 3)
        {
          if (localObject1 != null)
          {
            ((SessionInfo)localObject1).jdField_f_of_type_Long = paramLong;
            ((SessionInfo)localObject1).jdField_E_of_type_Int = paramInt1;
            ((SessionInfo)localObject1).jdField_j_of_type_Int = paramInt2;
            ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(paramLong);
            ((SessionInfo)localObject1).jdField_k_of_type_Int = 0;
            ((SessionInfo)localObject1).f("startGAudioChat", true);
          }
        }
        else {
          return -1;
        }
      }
    }
    int i2 = 1;
    int i1 = paramInt2;
    paramInt2 = i2;
    label579:
    localObject1 = a();
    if (paramBoolean) {
      paramInt2 = 2;
    }
    if ((((SessionInfo)localObject1).jdField_y_of_type_Boolean) && (((SessionInfo)localObject1).jdField_L_of_type_Boolean)) {
      paramInt2 = 5;
    } else if (((SessionInfo)localObject1).b()) {
      paramInt2 = 3;
    }
    c();
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSessionInfo().localHasVideo = ");
      localStringBuilder.append(a().jdField_j_of_type_Boolean);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    H();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().b(), a().jdField_N_of_type_Int, a().jdField_M_of_type_Int, a().jdField_W_of_type_Int);
    if (this.jdField_j_of_type_JavaLangRunnable == null) {
      this.jdField_j_of_type_JavaLangRunnable = new VideoController.26(this, paramInt1, paramLong);
    }
    this.jdField_q_of_type_Boolean = true;
    ((SessionInfo)localObject1).a("startGAudioChat.2", 8);
    ((SessionInfo)localObject1).jdField_f_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
    i();
    a(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, 3, false, false, false);
    return 0;
  }
  
  public int a(int paramInt, String paramString)
  {
    boolean bool = a().j();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendAVFunChatMsg, type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], data[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isConnected[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (!bool) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_c_of_type_JavaLangString, paramInt, paramString);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if ((a().jdField_d_of_type_Int != 1) && (a().jdField_d_of_type_Int != 2)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.registerAudioDataCallback(paramInt, paramBoolean);
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = a().j();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendAVFunChatMsg, type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isConnected[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], dataLen[");
      int i1;
      if (paramArrayOfByte == null) {
        i1 = 0;
      } else {
        i1 = paramArrayOfByte.length;
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (!bool) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_c_of_type_JavaLangString, paramInt, paramArrayOfByte);
  }
  
  int a(long paramLong)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((localGAudioFriends != null) && (localGAudioFriends.jdField_a_of_type_Long == paramLong)) {
            return i1;
          }
        }
        else
        {
          return -1;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i1 += 1;
      }
    }
  }
  
  public int a(long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendSelectVideoModeRequest(paramLong, paramInt);
  }
  
  public int a(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)???).append("|VideoNodeManager");
    ??? = ((StringBuilder)???).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptGAudioChat, relationType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], isVideo[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], mIsStartGAuio[");
    localStringBuilder.append(this.jdField_q_of_type_Boolean);
    localStringBuilder.append("], uinList[");
    boolean bool;
    if (paramArrayOfLong != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w((String)???, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      m();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    h(false);
    c(false);
    this.jdField_l_of_type_Boolean = false;
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      ??? = a();
      int i2 = 8;
      ((SessionInfo)???).a("acceptGAudioChat", 8);
      a().jdField_f_of_type_Long = paramLong2;
      a().X = true;
      a().ah = true;
      paramLong1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      int i1;
      if (paramInt == 2)
      {
        if (a().jdField_j_of_type_Boolean) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        i2 = 1;
      }
      else
      {
        if (paramInt == 1)
        {
          i1 = a().jdField_j_of_type_Int;
          i2 = i1;
          if (a().jdField_j_of_type_Boolean)
          {
            i2 = i1;
            break label418;
          }
        }
        else
        {
          if (paramInt != 3) {
            break label415;
          }
        }
        i1 = 1;
        break label421;
        label415:
        i2 = 2;
        label418:
        i1 = 2;
      }
      label421:
      if (paramBoolean) {
        i1 = 2;
      }
      if (AudioHelper.b())
      {
        ??? = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("acceptGAudioChat, MainSession[");
        localStringBuilder.append(a());
        localStringBuilder.append("]");
        QLog.w((String)???, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i2, i1, paramLong2, paramArrayOfLong, c(), paramLong1, a().jdField_M_of_type_Int);
      if (this.jdField_j_of_type_JavaLangRunnable == null) {
        this.jdField_j_of_type_JavaLangRunnable = new VideoController.27(this, paramInt, paramLong2);
      }
      this.jdField_q_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
      i();
      return 0;
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo acceptRequest, peerUin[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("], businessType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], relationType[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], uiMode[");
    ((StringBuilder)localObject2).append(this.jdField_f_of_type_Int);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,network not support");
      return -2;
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    int i1 = -1;
    if (localObject1 == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    localObject1 = a();
    if ((localObject1 != null) && (1 == ((JniSimpleInfoMng)localObject1).a(AVUtil.a(paramString), false, false))) {
      AVUtil.a("0X800B62B", 0, 0, "", "", "", "");
    }
    localObject2 = a(paramInt2, paramString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a();
    }
    h(false);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    if (paramInt1 == 0) {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 0, paramInt2);
    } else if (1 == paramInt1) {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 2, paramInt2);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acceptRequest, result[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], session[");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("]");
      QLog.i((String)localObject2, 2, localStringBuilder.toString());
    }
    if (i1 == 0)
    {
      ((SessionInfo)localObject1).a("acceptRequest", 3);
      k();
    }
    this.jdField_a_of_type_ComTencentAvQavChannelProxy.a();
    ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
    VideoNodeManager.a(37);
    return i1;
  }
  
  public int a(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10)
  {
    String str = jdField_a_of_type_JavaLangString;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("avideo request, selfUin[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject1).append("], peerUin[");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("], businessType[");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], relationType[");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("], fromNation[");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("], fromMobile[");
    ((StringBuilder)localObject1).append(paramString3);
    ((StringBuilder)localObject1).append("], toMobile[");
    ((StringBuilder)localObject1).append(paramString4);
    ((StringBuilder)localObject1).append("], uinType[");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append("], extraUin[");
    ((StringBuilder)localObject1).append(paramString5);
    ((StringBuilder)localObject1).append("], sig[");
    boolean bool;
    if (paramArrayOfByte != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append("], bindID[");
    ((StringBuilder)localObject1).append(paramString8);
    ((StringBuilder)localObject1).append("], bindType[");
    ((StringBuilder)localObject1).append(paramInt4);
    ((StringBuilder)localObject1).append("], subServiceType[");
    ((StringBuilder)localObject1).append(paramInt5);
    ((StringBuilder)localObject1).append("], mStartRing[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject1).toString());
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (paramArrayOfByte != null)
    {
      str = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("request sigLength: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      QLog.d(str, 2, ((StringBuilder)localObject1).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail, network not support!");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,controller is null!");
      return -1;
    }
    str = paramString1;
    if (paramInt3 == 1006)
    {
      str = paramString1;
      if (paramString1.startsWith("+")) {
        str = paramString1.substring(1);
      }
    }
    int i1 = a(paramInt3, true, 1);
    if (i1 == -1)
    {
      paramString1 = jdField_a_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append("request fail, accostType = ");
      paramString2.append(i1);
      QLog.e(paramString1, 1, paramString2.toString());
      return -1;
    }
    paramString1 = a();
    if ((paramString1.h()) && (paramString1.jdField_c_of_type_JavaLangString != null) && (str.equals(paramString1.jdField_c_of_type_JavaLangString)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,----already receive invite, return~");
      paramString1.jdField_e_of_type_Boolean = true;
      return -1;
    }
    if (paramInt3 == 9500)
    {
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.a("request");
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.c();
      this.v = true;
    }
    long l1;
    Object localObject2;
    if (paramString1.Y)
    {
      l1 = paramString1.jdField_h_of_type_Long;
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("request, startTerminalSwitchTimeOutCheck, oldRoomId[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      g();
    }
    else
    {
      l1 = 0L;
    }
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request funcall buffer:");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
    VideoNodeManager.a(28);
    VideoNodeManager.a(11, str);
    VideoNodeManager.a(12, 1L);
    long l2;
    if (paramString1.jdField_H_of_type_Boolean) {
      l2 = 1L;
    } else {
      l2 = 2L;
    }
    VideoNodeManager.a(13, l2);
    VideoNodeManager.a(15, 1L);
    H();
    if ((paramString1.jdField_k_of_type_Int != 1011) && (paramString1.jdField_k_of_type_Int != 21))
    {
      if (paramInt3 == 9500)
      {
        paramInt4 = 4200;
        try
        {
          l1 = CharacterUtil.a(str);
          if (!TextUtils.isEmpty(paramString6)) {
            paramInt4 = Integer.valueOf(paramString6).intValue();
          }
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("request smart tv ");
            paramString2.append(paramInt4);
            QLog.d("SDVideo", 2, paramString2.toString());
          }
          paramString1.jdField_H_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(c());
          paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestFromUnQQ(l1, paramInt1, paramInt2, paramInt4);
        }
        catch (NumberFormatException paramString1)
        {
          paramString1.printStackTrace();
          QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,NumberFormatException ", paramString1);
          return -1;
        }
      }
      else
      {
        if (paramInt1 != 0) {
          break label1189;
        }
        paramString1.jdField_H_of_type_Boolean = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = C2BUserInfo.a(paramString10);
          if (paramString10 != null)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number");
            paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject1, paramString7, paramString8, paramInt4, paramInt5, paramString9, paramString10);
          }
          else
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number is null");
            paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
          }
        }
        else
        {
          paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
        }
      }
      break label1363;
      label1189:
      if (1 == paramInt1)
      {
        paramString1.jdField_H_of_type_Boolean = false;
        paramString10 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
        int i2 = c();
        paramInt1 = paramString10.requestVideo(str, 0L, i2, paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      }
      else
      {
        paramInt1 = -1;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      paramString1.jdField_H_of_type_Boolean = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() > Long.valueOf(str).longValue()) {
        paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      } else {
        paramInt1 = 0;
      }
    }
    label1363:
    AVReport.a().jdField_o_of_type_Boolean = paramString1.jdField_H_of_type_Boolean;
    paramString2 = jdField_a_of_type_JavaLangString;
    paramString3 = new StringBuilder();
    paramString3.append("request result = ");
    paramString3.append(paramInt1);
    paramString3.append(", uinType = ");
    paramString3.append(paramInt3);
    paramString3.append(", accostType = ");
    paramString3.append(i1);
    QLog.d(paramString2, 1, paramString3.toString());
    if (paramInt1 == 0)
    {
      paramString1.a("request", 1);
      paramString1.jdField_k_of_type_Int = paramInt3;
      paramString1.jdField_l_of_type_Int = i1;
      if ((paramString1.jdField_d_of_type_Int != 3) && (paramString1.jdField_d_of_type_Int != 4)) {
        paramString1.a(paramLong, SystemClock.elapsedRealtime());
      }
      i();
      if (paramString1.jdField_H_of_type_Boolean) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      a(paramString1.jdField_b_of_type_JavaLangString, paramInt2, false, false, true);
      paramString1.jdField_q_of_type_Int = -1;
      this.jdField_j_of_type_Boolean = false;
      a(paramLong, paramString1.jdField_c_of_type_JavaLangString);
      d();
    }
    paramString1.jdField_W_of_type_Boolean = false;
    a(str, 2, paramString1.jdField_a_of_type_Long);
    a(str, 1, 0L);
    paramString1 = new StringBuilder();
    paramString1.append(VideoNodeManager.c());
    paramString1.append("");
    a("deviceMemory", paramString1.toString());
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
    if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
    }
    this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor = new VideoCallStateMonitor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
    return paramInt1;
  }
  
  public int a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    if (paramList != null) {
      paramList = (NetAddr[])paramList.toArray(new NetAddr[paramList.size()]);
    } else {
      paramList = null;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendRecordingRequest(paramLong1, paramBoolean, paramList, paramLong2);
  }
  
  public int a(SessionInfo paramSessionInfo, String paramString)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl != null) {
      return localQQGAudioCtrl.getRoomUserTerminalType(paramSessionInfo, paramString);
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.updateSelfUin(paramString);
    }
    return -1;
  }
  
  int a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(AudioHelper.b(), paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
    }
    else
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_f_of_type_Boolean = paramBoolean;
    return 0;
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("setAudioInputMute enable=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    VideoRecoveryMonitor localVideoRecoveryMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localVideoRecoveryMonitor != null) {
      localVideoRecoveryMonitor.c();
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioInputMute(paramString, paramBoolean);
  }
  
  public long a()
  {
    if (a().jdField_d_of_type_Long == 0L) {
      return 0L;
    }
    long l1 = (SystemClock.elapsedRealtime() - a().jdField_d_of_type_Long) / 1000L + a().jdField_e_of_type_Long;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1);
    return l1;
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramInt1, paramInt2, paramLong);
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGAudioRoomId, result[");
      localStringBuilder.append(localRespInfo.uint32_result.get());
      localStringBuilder.append("], uint64_roomId[");
      localStringBuilder.append(localRespInfo.gAudioInfo.uint64_roomId.get());
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return localRespInfo.gAudioInfo.uint64_roomId.get();
  }
  
  public long a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return 0L;
    }
    long l1 = paramSessionInfo.b();
    int i1 = paramSessionInfo.jdField_d_of_type_Int;
    if ((i1 != 1) && (i1 != 2)) {
      return l1;
    }
    return a(paramSessionInfo.jdField_c_of_type_JavaLangString);
  }
  
  public long a(String paramString)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a(paramString);
    long l1 = 0L;
    if ((localSessionInfo != null) && (localSessionInfo.b() != 0L)) {
      return localSessionInfo.b();
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localObject != null)
    {
      long l2 = ((VcControllerImpl)localObject).getChatRoomId(paramString);
      paramString = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry to get room id. new room id = ");
      ((StringBuilder)localObject).append(l2);
      QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
      l1 = l2;
      if (localSessionInfo != null)
      {
        localSessionInfo.c(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Bitmap a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1)) {
      paramInt = 0;
    } else if (paramInt == 1) {
      paramInt = 1000;
    } else {
      paramInt = 1004;
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramInt, paramString1, paramString2, paramBoolean2, paramBoolean1);
  }
  
  public VideoController.GAudioFriends a(String paramString)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    Object localObject2 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((localObject1 == null) || (((VideoController.GAudioFriends)localObject1).jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label82;
          }
        }
        return localObject1;
      }
      finally
      {
        for (;;)
        {
          throw paramString;
        }
        label82:
        i1 += 1;
      }
    }
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProcessInfo peerUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",key = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",value = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", isAllSessionIdle = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvSessionMgr.b());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        l1 = Long.parseLong(paramString1);
      }
      catch (Exception paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramString1));
        l1 = l2;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_ComTencentAvSessionMgr.b()))
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(l1, paramString2, paramString3);
      if (QLog.isColorLevel())
      {
        paramString1 = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("quaReport --> updateProcessInfo peerUin = ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(",key = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(",value = ");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d(paramString1, 2, ((StringBuilder)localObject).toString());
      }
    }
    return this;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvSessionMgr.a();
  }
  
  public VideoAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  }
  
  public AVCallCompactHelper a()
  {
    return this.jdField_a_of_type_ComTencentAvCompatAVCallCompactHelper;
  }
  
  public JniSimpleInfoMng a()
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.getJniSimpleInfo();
    }
    return null;
  }
  
  public AVPhoneUserInfo a(long paramLong, ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if (paramLong == localAVPhoneUserInfo.account) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public QQGAudioCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  }
  
  public EffectsRenderController a(boolean paramBoolean)
  {
    if (!EffectsRenderController.b()) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController == null) && (paramBoolean)) {
      J();
    }
    return this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController;
  }
  
  public qav_gvideo_sdk_transfer.RespInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = new qav_gvideo_sdk_transfer.RespInfo();
    Object localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    int i1 = -101;
    int i2 = i1;
    if (localObject != null)
    {
      long l1 = paramInt;
      try
      {
        paramArrayOfByte = ((QQGAudioCtrl)localObject).postData(l1, paramArrayOfByte);
        try
        {
          localRespInfo.mergeFrom(paramArrayOfByte);
          return localRespInfo;
        }
        catch (Throwable paramArrayOfByte)
        {
          i1 = -102;
        }
        i2 = i1;
      }
      catch (Throwable paramArrayOfByte) {}
      if (QLog.isDevelopLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("postData exception , event[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString(), paramArrayOfByte);
        i2 = i1;
      }
    }
    localRespInfo.uint32_result.set(i2);
    return localRespInfo;
  }
  
  public ScreenShareCtrl a()
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl == null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl = new ScreenShareCtrl(this);
    }
    return this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processQCallPush in VideoController");
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      AVPbInfo localAVPbInfo = new AVPbInfo();
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.processQCallPush(paramArrayOfByte, localAVPbInfo);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processQCallPush result, bindId:");
        localStringBuilder.append(localAVPbInfo.bindId);
        localStringBuilder.append(", bindIdType:");
        localStringBuilder.append(localAVPbInfo.bindIdType);
        localStringBuilder.append(", phoneNum:");
        localStringBuilder.append(localAVPbInfo.phoneNum);
        QLog.d(paramArrayOfByte, 2, localStringBuilder.toString());
      }
      return localAVPbInfo;
    }
    return null;
  }
  
  @TargetApi(21)
  public ScreenRecordHelper a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper == null) {
      this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper = new ScreenRecordHelper();
    }
    return this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
  }
  
  public WatchTogetherMediaPlayCtrl a()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl == null) && (WTogetherUtil.a())) {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl = new WatchTogetherMediaPlayCtrl(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
  }
  
  public IAVEngineCommon a()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
  }
  
  public Pair<Integer, ArrayList<VideoController.GAudioFriends>> a()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Object localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
      Object localObject4 = b();
      if (((ArrayList)localObject1).size() == 0)
      {
        localObject1 = new Pair(Integer.valueOf(0), null);
        return localObject1;
      }
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3 = new HashSet();
      Object localObject5 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject5).next();
        localGAudioFriends.jdField_h_of_type_Boolean = true;
        localArrayList2.add(localGAudioFriends);
        ((Set)localObject3).add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
      }
      int i1 = localArrayList2.size();
      localObject4 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (VideoController.GAudioFriends)((Iterator)localObject4).next();
        if (!((Set)localObject3).contains(Long.valueOf(((VideoController.GAudioFriends)localObject5).jdField_a_of_type_Long)))
        {
          ((VideoController.GAudioFriends)localObject5).jdField_h_of_type_Boolean = false;
          localArrayList2.add(localObject5);
        }
      }
      localObject3 = jdField_a_of_type_JavaLangString;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("updateMemberAttendedInfo joint number size:=");
      ((StringBuilder)localObject4).append(((ArrayList)localObject1).size());
      ((StringBuilder)localObject4).append(";all members:=");
      ((StringBuilder)localObject4).append(localArrayList2.size());
      QLog.d((String)localObject3, 1, ((StringBuilder)localObject4).toString());
      localObject1 = new Pair(Integer.valueOf(i1), localArrayList2);
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public String a()
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl != null) {
      return localQQGAudioCtrl.getAVGQuality();
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPhoneNameByPhoneNum --> phoneNum = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString);
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int i1 = 1004;
    if (paramInt == 1)
    {
      paramInt = 1000;
    }
    else if (paramInt == 2)
    {
      paramInt = i1;
    }
    else
    {
      paramInt = i1;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1)) {
        paramInt = 0;
      }
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramInt, paramString1, paramString2);
  }
  
  public String a(ArrayList<VideoViewInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return "VideoViewInfo[0]";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoViewInfo[");
    ((StringBuilder)localObject).append(paramArrayList.size());
    ((StringBuilder)localObject).append("]\n");
    localObject = ((StringBuilder)localObject).toString();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(i1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayList.get(i1));
      localStringBuilder.append("\n");
      localObject = localStringBuilder.toString();
      i1 += 1;
    }
    return localObject;
  }
  
  public ArrayList<VideoController.GAudioFriends> a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    VideoController.GAudioFriends localGAudioFriends;
    while (localIterator.hasNext())
    {
      localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      localArrayList.add(localGAudioFriends);
      localHashSet.add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long)))
      {
        localGAudioFriends.jdField_h_of_type_Boolean = false;
        localArrayList.add(localGAudioFriends);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<VideoController.GAudioFriends> a(int paramInt, ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    int i1 = paramInt;
    long l1 = System.currentTimeMillis();
    if (i1 > 8) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    ArrayList localArrayList1 = new ArrayList(8);
    long l2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin();
    int i2;
    if (paramInt == 0)
    {
      localObject1 = null;
      i3 = 0;
      for (;;)
      {
        i2 = paramInt;
        localObject2 = localObject1;
        if (i3 >= paramArrayList.size()) {
          break;
        }
        i2 = paramInt;
        localObject2 = localObject1;
        if (i3 >= 8) {
          break;
        }
        localObject2 = (VideoController.GAudioFriends)paramArrayList.get(i3);
        if (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long == l2) {
          localObject1 = localObject2;
        }
        localArrayList1.add(localObject2);
        i3 += 1;
      }
    }
    Object localObject1 = null;
    int i3 = 0;
    for (;;)
    {
      i2 = paramInt;
      localObject2 = localObject1;
      if (i3 >= i1) {
        break;
      }
      localObject2 = (VideoController.GAudioFriends)paramArrayList.get(i3);
      if (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long == l2) {
        localObject1 = localObject2;
      }
      localArrayList1.add(localObject2);
      i3 += 1;
    }
    localObject1 = new ArrayList();
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = new ArrayList();
    paramInt = 0;
    while (paramInt < i1)
    {
      long l3 = ((VideoController.GAudioFriends)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
      if (l3 != l2) {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l3))) {
          ((ArrayList)localObject1).add(localArrayList1.get(paramInt));
        } else {
          ((ArrayList)localObject2).add(localArrayList1.get(paramInt));
        }
      }
      paramInt += 1;
    }
    if (!((ArrayList)localObject2).isEmpty())
    {
      Collections.sort((List)localObject2, new VideoController.32(this));
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    if (i2 != 0)
    {
      while (i1 < paramArrayList.size())
      {
        ((ArrayList)localObject1).add(paramArrayList.get(i1));
        i1 += 1;
      }
      paramArrayList = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InviteMemberList listSort exceedMaxNumber cost");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
      QLog.d(paramArrayList, 1, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    localObject2 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    while (i1 < localArrayList1.size())
    {
      l2 = ((VideoController.GAudioFriends)localArrayList1.get(i1)).jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l2))) {
        ((ArrayList)localObject2).add(localArrayList1.get(i1));
      } else {
        localArrayList2.add(localArrayList1.get(i1));
      }
      i1 += 1;
    }
    if (!localArrayList2.isEmpty())
    {
      Collections.sort(localArrayList2, new VideoController.33(this));
      ((ArrayList)localObject2).addAll(localArrayList2);
    }
    if (!((ArrayList)localObject2).isEmpty()) {
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    i1 = paramArrayList.size();
    paramInt = 8;
    if (i1 > 8) {
      while (paramInt < paramArrayList.size())
      {
        ((ArrayList)localObject1).add(paramArrayList.get(paramInt));
        paramInt += 1;
      }
    }
    paramArrayList = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("InviteMemberList listSort not exceedMaxNumber cost");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
    QLog.d(paramArrayList, 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public ArrayList<Long> a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    int i1;
    label170:
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      ArrayList localArrayList2 = new ArrayList();
      long l1 = System.currentTimeMillis();
      i1 = 0;
      if (i1 < i2)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (localGAudioFriends == null) {
          break label170;
        }
        if (localGAudioFriends.jdField_a_of_type_Long == paramLong1)
        {
          if (!localGAudioFriends.jdField_e_of_type_Boolean)
          {
            localGAudioFriends.jdField_g_of_type_Boolean = paramBoolean;
            localGAudioFriends.jdField_c_of_type_Long = l1;
            localGAudioFriends.jdField_d_of_type_Long = paramLong2;
          }
          else if (localGAudioFriends.jdField_g_of_type_Boolean)
          {
            localGAudioFriends.jdField_g_of_type_Boolean = false;
          }
          if (!localGAudioFriends.jdField_g_of_type_Boolean) {
            break label170;
          }
          localArrayList2.add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
          break label170;
        }
      }
      else
      {
        return localArrayList2;
      }
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      m();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onApnChanged netType = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
      } else {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        int i1 = c();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
      }
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && ((paramInt == 1) || (paramInt == 2))) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(c());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(21), Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Long = paramInt3;
    Object localObject;
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject != null) {
        ((MqqHandler)localObject).post(new VideoController.31(this, paramInt1, paramInt2, paramInt3));
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (localObject != null) {
        ((QQGAudioCtrl)localObject).setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramInt1, ((String)localObject).getBytes());
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kickOutUsers, event[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], result[");
      localStringBuilder.append(localRespInfo.uint32_result.get());
      localStringBuilder.append("], data[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartDoubleVideoMeeting");
      localIntent.putExtra("sessionType", paramInt1);
      localIntent.putExtra("uinType", paramInt2);
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("isReceiver", true);
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    label2176:
    try
    {
      l1 = AudioHelper.b();
      localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      str1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
      if (paramInt1 == 3) {
        str1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
      }
      localObject3 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1);
      if (!QLog.isColorLevel()) {
        break label224;
      }
      ??? = jdField_a_of_type_JavaLangString;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("quitGAudioChat, groupId[");
      localStringBuilder1.append(paramLong);
      localStringBuilder1.append("], relationType[");
      localStringBuilder1.append(paramInt1);
      localStringBuilder1.append("], reason[");
      localStringBuilder1.append(paramInt2);
      localStringBuilder1.append("], sessionId[");
      localStringBuilder1.append(str1);
      localStringBuilder1.append("], seq[");
      localStringBuilder1.append(l1);
      localStringBuilder1.append("], app[");
      if (localVideoAppInterface == null) {
        break label2137;
      }
      bool = true;
    }
    finally
    {
      label1409:
      label2179:
      label2185:
      label2188:
      for (;;)
      {
        long l1;
        VideoAppInterface localVideoAppInterface;
        String str1;
        Object localObject3;
        StringBuilder localStringBuilder1;
        label224:
        long l3;
        int i1;
        Object localObject5;
        long l2;
        int i2;
        for (;;)
        {
          throw localObject2;
        }
        label2137:
        boolean bool = false;
        continue;
        continue;
        label2146:
        if ((paramInt2 != 7) && (paramInt2 != 20))
        {
          i1 = 0;
        }
        else
        {
          i1 = paramInt2;
          continue;
          continue;
          i2 = 0;
          continue;
        }
      }
    }
    localStringBuilder1.append(bool);
    localStringBuilder1.append("], \nsessionInfo[");
    localStringBuilder1.append(localObject3);
    localStringBuilder1.append("]");
    QLog.w((String)???, 1, localStringBuilder1.toString());
    ScreenShareReportHelper.b(str1, "quitGAudioChat");
    if (localVideoAppInterface == null) {
      return;
    }
    if (localObject3 == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      ??? = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
      if ((??? != null) && (((ScreenRecordHelper)???).c())) {
        ((ScreenRecordHelper)???).a(4);
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "quitGAudioChat, check screen share and stop.");
      }
    }
    ??? = localVideoAppInterface.a();
    if (??? != null) {
      ((ChatRoomMng)???).a((SessionInfo)localObject3);
    }
    localVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
    this.jdField_j_of_type_JavaLangRunnable = null;
    if (this.jdField_g_of_type_JavaLangRunnable != null)
    {
      localVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
      this.jdField_g_of_type_JavaLangRunnable = null;
    }
    ??? = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (??? == null) {
      return;
    }
    localVideoAppInterface.a(new Object[] { Integer.valueOf(203), String.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(l1) });
    if ((a().jdField_f_of_type_JavaUtilArrayList.size() > 0) && (a().T))
    {
      a(2, 0, 0, 0L);
      if ((paramInt1 == 2) && (!((SessionInfo)localObject3).T) && (((SessionInfo)localObject3).jdField_f_of_type_JavaUtilArrayList != null))
      {
        ??? = new Intent();
        ((Intent)???).setAction("tencent.av.v2q.MultiVideo");
        ((Intent)???).putExtra("type", 411);
        ((Intent)???).putExtra("phoneList", a().jdField_f_of_type_JavaUtilArrayList);
        ((Intent)???).putExtra("relationType", a().jdField_E_of_type_Int);
        ((Intent)???).putExtra("relationId", a().jdField_f_of_type_Long);
        ((Intent)???).putExtra("MultiAVType", a().jdField_j_of_type_Int);
        ((Intent)???).putExtra("from", "VideoController2");
        ((Intent)???).setPackage(localVideoAppInterface.getApp().getPackageName());
        localVideoAppInterface.getApp().sendBroadcast((Intent)???);
      }
      if (paramInt1 == 2)
      {
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject3).jdField_p_of_type_JavaLangString)) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE5", "0X8004CE5", 0, 0, "", "", "", "");
        }
        if (i()) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE8", "0X8004CE8", 0, 0, "", "", "", "");
        }
        if (((SessionInfo)localObject3).jdField_j_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CEB", "0X8004CEB", 0, 0, "", "", "", "");
          if (!((SessionInfo)localObject3).jdField_m_of_type_Boolean) {
            ReportController.b(null, "CliOper", "", "", "0X8004CEF ", "0X8004CEF ", 0, 0, "", "", "", "");
          }
        }
      }
      else if (paramInt1 == 1)
      {
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject3).jdField_p_of_type_JavaLangString)) {
          if (((SessionInfo)localObject3).jdField_j_of_type_Int == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005942", "0X8005942", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8004F54", "0X8004F54", 0, 0, "", "", "", "");
          }
        }
        if (i()) {
          if (((SessionInfo)localObject3).jdField_j_of_type_Int == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005943", "0X8005943", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8004F55", "0X8004F55", 0, 0, "", "", "", "");
          }
        }
        if (((SessionInfo)localObject3).jdField_j_of_type_Boolean)
        {
          if (((SessionInfo)localObject3).jdField_j_of_type_Int == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005944", "0X8005944", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8004F56", "0X8004F56", 0, 0, "", "", "", "");
          }
          if (!((SessionInfo)localObject3).jdField_m_of_type_Boolean) {
            if (((SessionInfo)localObject3).jdField_j_of_type_Int == 10) {
              ReportController.b(null, "CliOper", "", "", "0X8005945 ", "0X8005945 ", 0, 0, "", "", "", "");
            } else {
              ReportController.b(null, "CliOper", "", "", "0X8004F57 ", "0X8004F57 ", 0, 0, "", "", "", "");
            }
          }
        }
      }
      bool = this.jdField_r_of_type_Boolean;
      l3 = 0L;
      if ((!bool) || (a() <= 0L)) {
        break label2146;
      }
      ReportController.b(null, "CliOper", "", "", "0X8008B2F ", "0X8008B2F ", 0, 0, "", "", UITools.a(a()), "");
      break label2146;
      if ((!VcControllerImpl.sIsSpecialDevice) && (paramInt2 != 69) && (paramInt2 != 70) && (paramInt2 != 71))
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quitRoom(i1);
        break label2176;
      }
      this.jdField_q_of_type_Int = -1000001;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.28(this, i1));
      }
      try
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaLangObject.wait(2000);
        }
        if (!this.jdField_d_of_type_Boolean) {
          break label1409;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        if (this.jdField_q_of_type_Int == -1000001) {
          i1 = 261;
        }
        ??? = jdField_a_of_type_JavaLangString;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("GAudioCtrl.quitRoom end. continue. mQuitResult = ");
        ((StringBuilder)localObject5).append(this.jdField_q_of_type_Int);
        QLog.d((String)???, 1, ((StringBuilder)localObject5).toString());
      }
      if ((((SessionInfo)localObject3).jdField_f_of_type_Int == 9) && (!((SessionInfo)localObject3).jdField_V_of_type_Boolean)) {
        l2 = 0L;
      } else {
        l2 = a();
      }
      a("quitGAudioChat", false);
      c("quitGAudioChat", 1);
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        if ((this.jdField_c_of_type_JavaUtilArrayList.size() != 0) || (this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Long != 0L)) {
          break label2179;
        }
        i2 = 1;
        int i3 = this.jdField_c_of_type_JavaUtilArrayList.size();
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        a("quitGAudioChat", false, 0, 0L);
        ((SessionInfo)localObject3).K = false;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup = false;
        ??? = localVideoAppInterface.getCurrentAccountUin();
        if (??? != null) {
          l3 = CharacterUtil.a((String)???);
        }
        if (TextUtils.isEmpty((CharSequence)???)) {
          break label2185;
        }
        localObject5 = new Intent();
        ((Intent)localObject5).setAction("tencent.av.v2q.MultiVideo");
        ((Intent)localObject5).putExtra("type", 23);
        ((Intent)localObject5).putExtra("friendUin", l3);
        ((Intent)localObject5).putExtra("relationId", paramLong);
        ((Intent)localObject5).putExtra("relationType", paramInt1);
        ((Intent)localObject5).putExtra("MultiAVType", ((SessionInfo)localObject3).jdField_j_of_type_Int);
        ((Intent)localObject5).putExtra("time", l2);
        ((Intent)localObject5).putExtra("isStart", this.jdField_q_of_type_Boolean);
        ((Intent)localObject5).putExtra("quitReson", paramInt2);
        ((Intent)localObject5).putExtra("from", "VideoController3");
        if (i3 > 1) {
          ((Intent)localObject5).putExtra("roomUserNum", i3 - 1);
        } else {
          ((Intent)localObject5).putExtra("roomUserNum", 0);
        }
        ((Intent)localObject5).setPackage(localVideoAppInterface.getApp().getPackageName());
        l2 = l1;
        SeqUtil.a((Intent)localObject5, l2);
        localVideoAppInterface.getApp().sendBroadcast((Intent)localObject5);
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localObject5 = jdField_a_of_type_JavaLangString;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("quitGAudioChat, send broadcast of quitRoom chatting, seq[");
          localStringBuilder2.append(l2);
          localStringBuilder2.append("]");
          QLog.w((String)localObject5, 1, localStringBuilder2.toString());
        }
        ((SessionInfo)localObject3).b("quitGAudioChat", null);
        ((SessionInfo)localObject3).jdField_a_of_type_ArrayOfJavaLangString = null;
        j();
        if (((SessionInfo)localObject3).jdField_c_of_type_JavaUtilArrayList.size() > 0) {
          localVideoAppInterface.a(new Object[] { Integer.valueOf(104), ((SessionInfo)localObject3).jdField_c_of_type_JavaUtilArrayList });
        }
        if (((SessionInfo)localObject3).jdField_E_of_type_Int == 1) {
          localVideoAppInterface.a(new Object[] { Integer.valueOf(410), Long.valueOf(paramLong) });
        }
        localObject5 = ((SessionInfo)localObject3).jdField_r_of_type_JavaLangString;
        if (((SessionInfo)localObject3).jdField_E_of_type_Int == 1) {
          break label2188;
        }
        if (((SessionInfo)localObject3).jdField_E_of_type_Int == 2)
        {
          if (((SessionInfo)localObject3).jdField_j_of_type_Boolean) {
            localVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
          }
          ((SessionInfo)localObject3).b(l1, false);
        }
        ((SessionInfo)localObject3).b(l1);
        SessionFlag.a().a();
        this.jdField_a_of_type_ComTencentAvAppGVideoDownloadChannelControl.a();
        h();
        TipsUtil.a(l1, localVideoAppInterface);
        if (i2 == 0)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("quitGAudioChat_");
          localStringBuilder2.append(paramInt2);
          a(localStringBuilder2.toString(), str2, UITools.c(paramInt1), (String)???, String.valueOf(paramLong), 7, (String)localObject5, false, false);
        }
        ((SessionInfo)localObject3).jdField_k_of_type_Int = -1;
        ((SessionInfo)localObject3).jdField_p_of_type_Boolean = true;
        bool = this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, str2);
        localObject3 = QAVNotification.a(localVideoAppInterface);
        if ((localObject3 != null) && (((QAVNotification)localObject3).a()))
        {
          ((QAVNotification)localObject3).a(str2);
          if (bool) {
            d();
          }
        }
        PopupDialog.a();
        d(i1);
        return;
      }
      throw localObject1;
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l1 = AudioHelper.b();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioSDKError, relationType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], detail[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(str);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramLong == 0L) {
      return;
    }
    localObject = a();
    if ((localObject != null) && (((SessionInfo)localObject).jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
    int i1 = UITools.c(paramInt1);
    a(a().jdField_b_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
    if (this.jdField_d_of_type_Boolean)
    {
      a(paramInt1, paramLong, 71);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      a("onGAudioSDKError", str, i1, (String)localObject, String.valueOf(paramLong), 7, (String)localObject, false, false);
      if (this.jdField_j_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        this.jdField_j_of_type_JavaLangRunnable = null;
      }
    }
    a("onGAudioSDKError_2");
    localObject = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    if (localObject != null) {
      ((TraeHelper)localObject).a(l1);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, str);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(502), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(500), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt, SdkAudioFrameCallback paramSdkAudioFrameCallback)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Record setAudioFrameCallback, type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", callback=");
    localStringBuilder.append(paramSdkAudioFrameCallback);
    QLog.i(str, 1, localStringBuilder.toString());
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback == null) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback = new SdkAudioFrameCallback[2];
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[paramInt] = paramSdkAudioFrameCallback;
  }
  
  public void a(int paramInt, String paramString)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null)
    {
      localVcControllerImpl.uploadSharpNode(paramInt, paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("report_node is");
        paramString.append(paramInt);
        QLog.d("SharpReport_Node", 2, paramString.toString());
      }
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Object localObject1 = jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendAnotherChatingBroadcast session:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(", peerUin:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("， roomid：");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (paramInt2 != 3) {}
      localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr;
      localObject1 = SessionMgr.a(SessionMgr.a(paramInt1), paramString, new int[0]);
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((SessionInfo)localObject1).jdField_e_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString)) && (((SessionInfo)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((SessionInfo)localObject1).jdField_A_of_type_Int);
      ((Intent)localObject2).putExtra("bindId", ((SessionInfo)localObject1).jdField_o_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("roomId", paramLong);
      ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendReplyMsgToAio uinType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", friendUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", friendName: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", extraUin: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", replyMsg: ");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", isDiyMsg: ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.replyMsg");
      ((Intent)localObject).putExtra("uinType", paramInt);
      ((Intent)localObject).putExtra("friendUin", paramString1);
      ((Intent)localObject).putExtra("friendName", paramString2);
      if ((paramInt != 1006) || (paramString3 != null)) {
        paramString1 = paramString3;
      }
      ((Intent)localObject).putExtra("extraUin", paramString1);
      ((Intent)localObject).putExtra("replyMsg", paramString4);
      ((Intent)localObject).putExtra("isDiyMsg", paramBoolean);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendLeaveMsg uinType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", friendUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", friendName: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", extraUin: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", isPtt: ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.leaveMsg");
      ((Intent)localObject).putExtra("uinType", paramInt);
      ((Intent)localObject).putExtra("friendUin", paramString1);
      ((Intent)localObject).putExtra("friendName", paramString2);
      if ((paramInt != 1006) || (paramString3 != null)) {
        paramString1 = paramString3;
      }
      ((Intent)localObject).putExtra("extraUin", paramString1);
      ((Intent)localObject).putExtra("isPtt", paramBoolean);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMsgSigBroadcast uinType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", peerUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", extraUin: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", sig = ");
      localStringBuilder.append(paramArrayOfByte);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      ((Intent)localObject).setAction("tencent.video.v2q.AddMsgSig");
      ((Intent)localObject).putExtra("uinType", paramInt);
      ((Intent)localObject).putExtra("peerUin", paramString1);
      ((Intent)localObject).putExtra("extraUin", paramString2);
      ((Intent)localObject).putExtra("sig", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:620)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSubState2 seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    Object localObject1 = a();
    l();
    ((SessionInfo)localObject1).a("onSubState2", 4);
    ((SessionInfo)localObject1).a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
    } else {
      d();
    }
    if (((SessionInfo)localObject1).jdField_g_of_type_Boolean) {
      a(true, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    } else {
      a(false, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, paramLong), 50L);
    a(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_d_of_type_Int, true, true, true);
    DataReport.i(this);
    DataReport.c(this, true);
    DataReport.b(this, true);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject2 != null) {
      ((ChatRoomMng)localObject2).a((SessionInfo)localObject1);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15001), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRing, listener[");
      localStringBuilder.append(paramOnCompletionListener);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(paramLong);
    if (!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
    {
      AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
      a(a().jdField_c_of_type_JavaLangString, 212);
      b(212);
      b(a().jdField_c_of_type_JavaLangString, a().jdField_z_of_type_Int);
    }
    if (a().I)
    {
      AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
      a(a().jdField_c_of_type_JavaLangString, 213);
      b(213);
      b(a().jdField_c_of_type_JavaLangString, a().jdField_z_of_type_Int);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, -1, false);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    TraeHelper.a().b();
    String str;
    if (paramInt1 == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    } else {
      str = SessionMgr.a(paramInt1, String.valueOf(paramLong2), new int[0]);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramInt1 == 1)
      {
        i1 = 10;
      }
      else if (paramInt1 == 2)
      {
        i1 = 1;
      }
      else if (paramInt1 == 3)
      {
        i1 = 8;
      }
      else
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ignoreGAudioChat, Can't Support Ignore");
        localStringBuilder.append(paramInt1);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        i1 = 0;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.ignore(paramInt1, paramLong2, i1);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("|VideoNodeManager");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignoreGAudioChat, groupId[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], iFlag[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(str);
    localStringBuilder.append("], sessionInfo[");
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_c_of_type_Boolean = false;
    ((SessionInfo)localObject1).X = true;
    int i1 = 4;
    if (((SessionInfo)localObject1).jdField_f_of_type_Int == 7)
    {
      ((SessionInfo)localObject1).a("ignoreGAudioChat", 0);
      if (paramInt2 == -1)
      {
        i1 = 3;
        break label351;
      }
    }
    else
    {
      if (paramInt2 == -1) {
        break label351;
      }
    }
    i1 = paramInt2;
    label351:
    j();
    paramInt2 = UITools.c(paramInt1);
    localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    if (i1 == 10) {
      a("ignoreGAudioChat_1", ((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, UITools.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((SessionInfo)localObject1).jdField_f_of_type_Long), 5, ((SessionInfo)localObject1).jdField_r_of_type_JavaLangString, false, false);
    } else if (paramInt1 == 3) {
      a("ignoreGAudioChat_2", str, paramInt2, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((SessionInfo)localObject1).jdField_r_of_type_JavaLangString, paramBoolean, false);
    } else {
      a("ignoreGAudioChat_3", str, paramInt2, (String)localObject2, String.valueOf(paramLong2), i1, ((SessionInfo)localObject1).jdField_r_of_type_JavaLangString, paramBoolean, false);
    }
    paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, str);
    localObject1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
    {
      ((QAVNotification)localObject1).a(str);
      if (paramBoolean) {
        d();
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, ArrayList<String> paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    a(paramLong1, paramInt, paramLong2, -1, paramBoolean);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if ((paramInt != 4) && (paramInt != 3) && (((paramInt != 2) && (paramInt != 1)) || (!a().jdField_y_of_type_Boolean))) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setEncodeDecodePtr, sessionType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], clean[");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append("], isRemote[");
    ((StringBuilder)localObject2).append(paramBoolean2);
    ((StringBuilder)localObject2).append("], isMultiEngine[");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = GraphicRenderMgr.getInstance();
    paramLong = 0L;
    if (bool)
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (localObject2 != null) {
        if (paramBoolean2)
        {
          if (paramBoolean1)
          {
            if (((IGraphicRender)localObject1).getDecodePtrRef() > 0) {
              ((IGraphicRender)localObject1).decreaseDecoderPtrRef();
            }
            if (((IGraphicRender)localObject1).getDecodePtrRef() == 0) {
              this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
            }
          }
          else
          {
            ((IGraphicRender)localObject1).increaseDecodePtrRef();
            if (((IGraphicRender)localObject1).getDecodePtrRef() == 1)
            {
              paramLong = ((IGraphicRender)localObject1).getRecvDecoderFrameFunctionPtr();
              this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(paramLong);
            }
          }
        }
        else
        {
          if (!paramBoolean1) {
            paramLong = ((QQGAudioCtrl)localObject2).getEncodeFrameFunctionPtrFunPtr();
          }
          ((IGraphicRender)localObject1).setProcessEncodeFrameFunctionPtr(paramLong);
        }
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject2 != null)
      {
        if (paramBoolean2)
        {
          if (!paramBoolean1) {
            paramLong = ((IGraphicRender)localObject1).getRecvDecoderFrameFunctionPtr();
          }
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setProcessDecoderFrameFunctionptr(paramLong);
          return;
        }
        if (!paramBoolean1) {
          paramLong = ((VcControllerImpl)localObject2).getEncodeFrameFunctionPtrFunPtr();
        }
        ((IGraphicRender)localObject1).setProcessEncodeFrameFunctionPtr(paramLong);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a(a().jdField_c_of_type_JavaLangString) == paramLong2) {
      a().jdField_ad_of_type_Boolean = true;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvAudioReady uin = ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",roomid = ");
    localStringBuilder.append(paramLong2);
    QLog.d(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    String str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("closeDoubleVideoMeetingInvite found no session, relationId :");
        ((StringBuilder)localObject1).append(paramLong2);
        QLog.e(str, 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    ((SessionInfo)localObject1).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23)
    {
      a(str, 0, true, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramLong2);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramLong2);
      a(str, 0, paramInt, true, (String)localObject2, localStringBuilder.toString(), false);
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject2).putExtra("type", 403);
    ((Intent)localObject2).putExtra("relationType", 3);
    ((Intent)localObject2).putExtra("relationId", paramLong2);
    ((Intent)localObject2).putExtra("friendUin", paramLong2);
    ((Intent)localObject2).putExtra("MultiAVType", ((SessionInfo)localObject1).jdField_j_of_type_Int);
    ((Intent)localObject2).putExtra("from", "VideoController4");
    ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject2);
    boolean bool = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, str);
    localObject1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
    {
      ((QAVNotification)localObject1).a(str);
      if (bool) {
        d();
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "onGroupSystemMsgCome()  mGAudioCtrl == null !!    return !");
      return;
    }
    if (paramInt2 != 3)
    {
      if (paramInt2 != 7)
      {
        if (paramInt2 != 15) {
          return;
        }
        if (paramBoolean) {
          localQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
        }
        if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
        {
          a().S = false;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      }
    }
    else
    {
      if (paramBoolean) {
        localQQGAudioCtrl.modifyGroupAdmin(paramLong2, true);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
      {
        a().S = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    SessionInfo localSessionInfo = a();
    if (localSessionInfo.jdField_d_of_type_Int == 2)
    {
      if ((localSessionInfo.w != 2) && (localSessionInfo.w != 3)) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioInviteRespFail, groupId[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], err[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], msg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramLong1 == this.jdField_a_of_type_Long) {
      QQToast.a(a(), 2131695674, 1).a();
    }
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.34(this, paramArrayList, paramLong1, paramLong2));
  }
  
  @TargetApi(21)
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("quitDoubleVideoMeeting, relationId[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
    if (localObject1 != null) {
      ((ScreenRecordHelper)localObject1).a(4);
    }
    localObject1 = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
    if (localObject2 == null) {
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject3).putExtra("type", 402);
    ((Intent)localObject3).putExtra("relationType", 3);
    ((Intent)localObject3).putExtra("relationId", paramLong2);
    ((Intent)localObject3).putExtra("friendUin", paramLong2);
    ((Intent)localObject3).putExtra("MultiAVType", ((SessionInfo)localObject2).jdField_j_of_type_Int);
    ((Intent)localObject3).putExtra("from", "VideoController6");
    SeqUtil.a((Intent)localObject3, paramLong1);
    ((Intent)localObject3).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject3);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(paramLong2);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong2);
    a((String)localObject1, 0, paramInt, true, (String)localObject3, localStringBuilder.toString(), false);
    if (((SessionInfo)localObject2).jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      ((SessionInfo)localObject2).e("quitDoubleVideoMeeting", false);
      ((SessionInfo)localObject2).f("quitDoubleVideoMeeting", false);
    }
    else
    {
      ((SessionInfo)localObject2).a("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230745, 1, this.jdField_c_of_type_ComTencentAvVideoController$OnCustomCompletionListener);
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.40(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
    localObject1 = a();
    if (localObject1 != null) {
      ((ScreenShareCtrl)localObject1).b(paramLong2);
    }
  }
  
  void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    }
    this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = new VideoController.StartRingRunnable(this, paramString);
    paramString = this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable;
    if (paramString != null)
    {
      paramString.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable, 6000L);
    }
  }
  
  void a(long paramLong, String paramString, int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo onCloseVideo fromUin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], mStartRing[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    ((StringBuilder)localObject).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
    K();
    str = SessionMgr.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    }
    else
    {
      str = SessionMgr.a(100, paramString, new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    }
    if (localObject == null)
    {
      AVLog.printErrorLog(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
    }
    ((SessionInfo)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor = null;
    }
    this.jdField_g_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    l();
    if ((((SessionInfo)localObject).jdField_c_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24))) {
      a(paramLong, str, paramString, 3);
    } else {
      a(paramLong, str, paramString, paramInt);
    }
    if (((SessionInfo)localObject).h())
    {
      ((SessionInfo)localObject).jdField_z_of_type_Int = paramInt;
      if ((((SessionInfo)localObject).h()) && (paramInt == ((SessionInfo)localObject).jdField_d_of_type_Int)) {
        ((SessionInfo)localObject).a(paramLong, 0L);
      }
      ((SessionInfo)localObject).a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(((SessionInfo)localObject).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject).jdField_z_of_type_Int);
    }
    else if (((SessionInfo)localObject).f())
    {
      ((SessionInfo)localObject).jdField_z_of_type_Int = paramInt;
      ((SessionInfo)localObject).a(paramLong, 0L);
      int i1 = 2131230745;
      if (paramInt != 3)
      {
        if (paramInt != 12)
        {
          if ((paramInt != 25) && (paramInt != 56))
          {
            if (paramInt != 42) {
              if (paramInt == 43) {
                break label494;
              }
            }
            for (;;)
            {
              i2 = 0;
              break;
              ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
              label494:
              i1 = 2131230744;
            }
          }
          ((SessionInfo)localObject).a("onCloseVideo.isInviting", 6);
          a(paramLong, 2131230745, 1, a(paramLong));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
          return;
        }
        if (((SessionInfo)localObject).jdField_c_of_type_Long != 2L)
        {
          ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
        }
        else
        {
          i2 = 1;
          i1 = 2131230745;
          break label665;
        }
      }
      else
      {
        ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
      }
      int i2 = 0;
      i1 = 2131230744;
      label665:
      this.jdField_a_of_type_ComTencentAvVideoController$OnCustomCompletionListener.jdField_a_of_type_Long = paramLong;
      if (i2 != 0) {
        i2 = 4;
      } else {
        i2 = 3;
      }
      a(paramLong, i1, i2, this.jdField_a_of_type_ComTencentAvVideoController$OnCustomCompletionListener);
      ((SessionInfo)localObject).a("onCloseVideo.isInviting1", 5);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
    }
    else if (!((SessionInfo)localObject).m())
    {
      ((SessionInfo)localObject).jdField_z_of_type_Int = paramInt;
      if (((SessionInfo)localObject).h()) {
        ((SessionInfo)localObject).a(paramLong, 0L);
      }
      ((SessionInfo)localObject).a("onCloseVideo.isClosing1", 6);
      if (PhoneStatusTools.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))
      {
        a(((SessionInfo)localObject).jdField_c_of_type_JavaLangString, 209);
        b(209);
        b(((SessionInfo)localObject).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject).jdField_z_of_type_Int);
      }
      else
      {
        a(paramLong, 2131230745, 1, a(paramLong));
        QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
    {
      paramString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (paramString != null) {
        paramString.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
      }
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_r_of_type_Boolean = c();
    boolean bool2 = SmallScreenUtils.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("processVideoRequest, uinType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], peerUin[");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("], extraUin[");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append("], onlyAudio[");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append("], isDoubleVideoMeeting[");
    ((StringBuilder)localObject2).append(paramBoolean2);
    ((StringBuilder)localObject2).append("], mIsGameMode[");
    ((StringBuilder)localObject2).append(this.jdField_r_of_type_Boolean);
    ((StringBuilder)localObject2).append("], isFloatWindowOpAllowedOnBackground[");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append("], aSessionExists[");
    ((StringBuilder)localObject2).append(paramBoolean3);
    ((StringBuilder)localObject2).append("], roomId[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("], sessionId[");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if ((paramBoolean1) && (!ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
    {
      a(paramLong, paramString2, 0, paramBoolean2);
      b(paramString2, 0);
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
    if (localObject2 == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
      return;
    }
    ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
    ((SessionInfo)localObject2).jdField_H_of_type_Boolean = paramBoolean1;
    ((SessionInfo)localObject2).a("processVideoRequest.1", 2);
    ((SessionInfo)localObject2).jdField_W_of_type_Boolean = false;
    ((SessionInfo)localObject2).jdField_j_of_type_Long = System.currentTimeMillis();
    AVReport.a().jdField_o_of_type_Boolean = ((SessionInfo)localObject2).jdField_H_of_type_Boolean;
    boolean bool1;
    if ((!paramBoolean3) && (!VideoUtils.a()) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), VideoInviteActivity.class);
      if (NoDisturbUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        ((Intent)localObject1).addFlags(262144);
      }
      bool1 = true;
    }
    else
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
      ((Intent)localObject1).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      bool1 = false;
    }
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("uinType", paramInt1);
    ((Intent)localObject1).putExtra("relationType", UITools.b(paramInt1));
    ((Intent)localObject1).putExtra("session_id", paramString1);
    ((Intent)localObject1).putExtra("peerUin", paramString2);
    ((Intent)localObject1).putExtra("extraUin", paramString3);
    ((Intent)localObject1).putExtra("isAudioMode", paramBoolean1);
    ((Intent)localObject1).putExtra("curUserStatus", this.jdField_g_of_type_Int);
    ((Intent)localObject1).putExtra("isDoubleVideoMeeting", paramBoolean2);
    ((Intent)localObject1).putExtra("bindType", paramInt2);
    if (((SessionInfo)localObject2).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "processVideoRequest block notify video msg");
      }
    }
    else
    {
      paramString1 = a();
      if (paramString1 != null)
      {
        paramInt1 = paramString1.a(JniSimpleInfoMng.a(paramString2), false, true);
        ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(3, paramString2, paramInt1);
      }
      if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()))
      {
        a((Intent)localObject1, paramString2, bool1, true);
      }
      else if ((this.jdField_r_of_type_Boolean) && (bool2))
      {
        if ((!paramBoolean3) && (!VideoUtils.a()))
        {
          paramString1 = new VideoInviteFloatBarUICtr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject1);
          paramString1.d();
          paramString1.a(paramLong, (Intent)localObject1);
        }
        else
        {
          paramString1 = new MultiIncomingCallUICtr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject1);
          paramString1.d();
          paramString1.a((Intent)localObject1);
        }
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest startActivity when GameMode");
        a("mode", "1");
        c(paramString2);
        a(paramString2, "screenState", String.valueOf(1));
      }
      else
      {
        a((Intent)localObject1, paramString2, bool1, false);
      }
      i();
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelVideoChat, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isDoubleMetting[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mVcCtrl[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return;
    }
    localObject = a();
    if ((localObject != null) && (1 == ((JniSimpleInfoMng)localObject).a(AVUtil.a(paramString), false, false))) {
      AVUtil.a("0X800B62C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(paramLong);
    localObject = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 10, 1L);
      if ((a().jdField_c_of_type_JavaLangString != null) && (a().jdField_c_of_type_JavaLangString.equals(paramString))) {
        VideoNodeManager.a(a().b(), 38);
      } else {
        VideoNodeManager.a(a(paramString), 38);
      }
    }
    paramString = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelVideoChat, result[");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString, 1, ((StringBuilder)localObject).toString());
    j();
    l();
    if (this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
      SmartDeviceReport.a(null, "Usr_TV_Video", 3, 0, 0);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
    String str = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendDoubleChatMsgToMQQ, sessionId[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], peerUin[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("], type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], \nsession[");
    ((StringBuilder)localObject).append(localSessionInfo);
    ((StringBuilder)localObject).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
    if ((localSessionInfo != null) && ((!localSessionInfo.jdField_W_of_type_Boolean) || (localSessionInfo.jdField_b_of_type_Boolean)))
    {
      int i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1).jdField_k_of_type_Int;
      localObject = localSessionInfo.jdField_e_of_type_JavaLangString;
      str = paramString2;
      if (!TextUtils.isEmpty(localSessionInfo.jdField_c_of_type_JavaLangString))
      {
        str = paramString2;
        if (localSessionInfo.jdField_c_of_type_JavaLangString.contains(paramString2)) {
          str = localSessionInfo.jdField_c_of_type_JavaLangString;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
        if (this.v) {
          i1 = 0;
        } else {
          i1 = 9500;
        }
      }
      boolean bool;
      if (localSessionInfo.jdField_e_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
      {
        a(paramString1, i1, paramInt, bool, str, (String)localObject, false);
        if ((paramInt == 12) && (!TextUtils.isEmpty(a().jdField_g_of_type_JavaLangString))) {
          a(paramString1, i1, 66, bool, str, (String)localObject, false);
        }
      }
      else if (localSessionInfo.jdField_b_of_type_Boolean)
      {
        a(paramString1, i1, paramInt, bool, str, (String)localObject, false);
      }
      if (this.jdField_d_of_type_Boolean) {
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, str, (String)localObject, 1, a().jdField_r_of_type_JavaLangString, false, true);
      } else if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b()) {
        a("sendDoubleChatMsgToMQQ_2", paramString1, i1, str, (String)localObject, 2, this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1).jdField_r_of_type_JavaLangString, true, true);
      } else {
        a("sendDoubleChatMsgToMQQ_3", paramString1, i1, str, (String)localObject, 0, this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1).jdField_r_of_type_JavaLangString, false, true);
      }
      localSessionInfo.jdField_W_of_type_Boolean = true;
      localSessionInfo.jdField_b_of_type_Boolean = false;
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reject3rdMultiCall[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], sessionId[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], senderUin[");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("], extraUin[");
      localStringBuilder.append(paramString4);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    a(paramString1, paramString2, UITools.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong, paramString2);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((this.jdField_d_of_type_Boolean) && (a().jdField_f_of_type_Long == paramLong) && (paramArrayOfString != null))
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
    }
  }
  
  public void a(long paramLong, ArrayList<String> paramArrayList)
  {
    int i2 = paramArrayList.size();
    long[] arrayOfLong = new long[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      String str = (String)paramArrayList.get(i1);
      if (str != null) {
        arrayOfLong[i1] = Long.valueOf(str).longValue();
      }
      i1 += 1;
    }
    a(arrayOfLong, false);
  }
  
  public void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList;
    int i1;
    if (paramArrayList == a().jdField_d_of_type_JavaUtilArrayList)
    {
      localArrayList = a().jdField_d_of_type_JavaUtilArrayList;
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < paramArrayList.size())
        {
          if (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
            break label119;
          }
          if (paramBoolean)
          {
            a(paramArrayList, i1);
            a().a();
          }
          else
          {
            if (paramInt != ((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int) {
              break label119;
            }
            a(paramArrayList, i1);
            a().a();
          }
        }
        return;
      }
      finally {}
      return;
      label119:
      i1 += 1;
    }
  }
  
  public void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList1, ArrayList<VideoViewInfo> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if (paramArrayList1 != null)
    {
      if (paramArrayList1.size() == 0) {
        return;
      }
      int i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        if (((VideoViewInfo)paramArrayList1.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((VideoViewInfo)paramArrayList1.get(i1)).jdField_a_of_type_Int)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (VideoController.GAudioFriends)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((VideoController.GAudioFriends)localObject1).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("InviteMemberList removeCertainInviteNumber remove: member uin:=");
          localStringBuilder.append(((VideoController.GAudioFriends)localObject1).jdField_a_of_type_Long);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        i1 = 1;
        break label121;
      }
      i1 += 1;
    }
    i1 = 0;
    label121:
    if ((i1 != 0) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.jdField_b_of_type_JavaUtilArrayList });
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("InviteMemberList removeCertainInviteNumber uin:");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(";result:");
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    ((StringBuilder)localObject2).append(bool1);
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  void a(long paramLong, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reject3rdDoubleCall, isDoubleVideoMeeting[");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("], uinType[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], fromUin[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], extraUin[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], bindType[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], bindID[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("], onlyAudio[");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w(str, 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1) {
      str = SessionMgr.a(100, paramString1, new int[0]);
    } else {
      str = SessionMgr.a(3, paramString1, new int[0]);
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    Object localObject = localSessionInfo;
    if (localSessionInfo == null) {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
    }
    ((SessionInfo)localObject).jdField_k_of_type_Int = paramInt1;
    ((SessionInfo)localObject).jdField_A_of_type_Int = paramInt2;
    ((SessionInfo)localObject).jdField_o_of_type_JavaLangString = paramString3;
    ((SessionInfo)localObject).jdField_e_of_type_Boolean = true;
    a(str, ((SessionInfo)localObject).jdField_k_of_type_Int, paramBoolean2 ^ true, paramString1, paramString2);
    if (paramBoolean1)
    {
      long l1;
      try
      {
        l1 = CharacterUtil.a(paramString1);
      }
      catch (NumberFormatException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramString1);
        }
        l1 = -1L;
      }
      a(paramLong, 3, l1);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString1, c(), 65536);
    }
    SessionMgr.a().a(paramLong, str);
  }
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean, int paramInt)
  {
    long l1 = paramArrayOfLong[0];
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberSpeak-->setSpeakingUin,uin=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", isSpeaking = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", audioEnergy = ");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool = a(l1, paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), Long.valueOf(l1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
    Object localObject = new Intent("tencent.video.v2q.memberSpeaking");
    ((Intent)localObject).putExtra("groupId", paramLong);
    ((Intent)localObject).putExtra("uinList", paramArrayOfLong);
    ((Intent)localObject).putExtra("isSpeaking", paramBoolean);
    ((Intent)localObject).putExtra("audioEnergy", paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().sendBroadcast((Intent)localObject);
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, int paramInt)
  {
    paramGAudioFriends.jdField_b_of_type_Int = 0;
    paramGAudioFriends.jdField_b_of_type_Boolean = false;
    paramGAudioFriends.jdField_c_of_type_Boolean = false;
    paramGAudioFriends.jdField_d_of_type_Boolean = false;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (QLog.isColorLevel())
              {
                paramGAudioFriends = jdField_a_of_type_JavaLangString;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("setVideoSrcType-->wrong type of videosrctype,type=");
                localStringBuilder.append(paramInt);
                QLog.e(paramGAudioFriends, 2, localStringBuilder.toString());
              }
            }
            else {
              paramGAudioFriends.jdField_d_of_type_Boolean = true;
            }
          }
          else {
            paramGAudioFriends.jdField_c_of_type_Boolean = true;
          }
        }
        else {
          paramGAudioFriends.jdField_b_of_type_Int = 1;
        }
      }
      else {
        paramGAudioFriends.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      return;
    }
    this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApp().getApplicationContext();
    Object localObject = new VideoController.3(this);
    paramVideoAppInterface.a().post((Runnable)localObject);
    if (!NetworkUtil.isNetSupport(a())) {
      this.jdField_a_of_type_Int = 0;
    } else if (NetworkUtil.isWifiEnabled(a())) {
      this.jdField_a_of_type_Int = 1;
    } else {
      this.jdField_a_of_type_Int = 2;
    }
    d();
    if ((this.jdField_i_of_type_Int == 0) && (SmallScreenUtils.e(paramVideoAppInterface.getApp()))) {
      this.jdField_i_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a(this.jdField_a_of_type_AndroidContentContext, this);
    if (this.w) {
      G();
    }
    localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localObject != null) {
      ((VcControllerImpl)localObject).updateProcessInfo(0L, "qqVersion", AppSetting.a(a()));
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController;
    if (localObject != null) {
      ((EffectsRenderController)localObject).a(paramVideoAppInterface);
    }
  }
  
  void a(AVUserInfo paramAVUserInfo, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    if (paramBoolean) {}
    try
    {
      if (a(paramAVUserInfo.account) != -1) {
        return;
      }
      Object localObject = new VideoController.GAudioFriends();
      ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long = paramAVUserInfo.account;
      ((VideoController.GAudioFriends)localObject).jdField_d_of_type_Int = paramAVUserInfo.accountType;
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
      break label213;
      int i1 = a(paramAVUserInfo.account);
      StringBuilder localStringBuilder1 = null;
      if (i1 != -1)
      {
        localObject = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
      }
      else
      {
        localObject = localStringBuilder1;
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("onMemberInOrOut-->can not find the member.userInfo = ");
          localStringBuilder2.append(paramAVUserInfo);
          QLog.e((String)localObject, 2, localStringBuilder2.toString());
          localObject = localStringBuilder1;
        }
      }
      a(paramAVUserInfo.account, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      w();
      if ((localObject != null) && (!((VideoController.GAudioFriends)localObject).jdField_e_of_type_Boolean) && (((VideoController.GAudioFriends)localObject).jdField_g_of_type_Boolean)) {
        onGAudioUserAudioSuspectNoisy(0L, false, 0L);
      }
      label213:
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onMemberInOrOut, size[");
        localStringBuilder1.append(this.jdField_c_of_type_JavaUtilArrayList.size());
        localStringBuilder1.append("], coming[");
        localStringBuilder1.append(paramAVUserInfo);
        localStringBuilder1.append("]");
        QLog.i((String)localObject, 2, localStringBuilder1.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField1, PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InviteMemberList updateMemberListWithPushMessage joins");
      ((StringBuilder)localObject2).append(paramPBRepeatMessageField1.size());
      ((StringBuilder)localObject2).append(";quits size");
      ((StringBuilder)localObject2).append(paramPBRepeatMessageField2.size());
      ((StringBuilder)localObject2).append(";eventType:=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)((Iterator)localObject2).next()).jdField_a_of_type_Long));
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mMemberChangeEventReceiver totalCount:");
      ((StringBuilder)localObject3).append(paramInt1);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    int i1 = 0;
    int i2;
    for (paramInt1 = 0; i1 < paramPBRepeatMessageField1.size(); paramInt1 = i2)
    {
      localObject3 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MemberInfo)paramPBRepeatMessageField1.get(i1)).get();
      int i3;
      if (((submsgtype0x116.MemberInfo)localObject3).uint64_member_uin.get() == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      i2 = paramInt1;
      if (!((Set)localObject1).contains(Long.valueOf(((submsgtype0x116.MemberInfo)localObject3).uint64_member_uin.get()))) {
        if (i3 != 0)
        {
          i2 = paramInt1;
        }
        else
        {
          localObject2 = new VideoController.GAudioFriends();
          ((VideoController.GAudioFriends)localObject2).jdField_d_of_type_Int = 0;
          ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject3).uint64_member_uin.get();
          ((VideoController.GAudioFriends)localObject2).jdField_h_of_type_Boolean = false;
          ((VideoController.GAudioFriends)localObject2).jdField_e_of_type_Long = ((submsgtype0x116.MemberInfo)localObject3).uint32_invite_timestamp.get();
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          if (QLog.isColorLevel())
          {
            localObject3 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mMemberChangeEventReceiver add member UIN:");
            localStringBuilder.append(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long);
            QLog.d((String)localObject3, 2, localStringBuilder.toString());
          }
          i2 = 1;
        }
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < paramPBRepeatMessageField2.size())
    {
      localObject1 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MemberInfo)paramPBRepeatMessageField2.get(i1)).get();
      localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      do
      {
        i2 = paramInt1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramPBRepeatMessageField1 = (VideoController.GAudioFriends)((Iterator)localObject2).next();
      } while (paramPBRepeatMessageField1.jdField_a_of_type_Long != ((submsgtype0x116.MemberInfo)localObject1).uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramPBRepeatMessageField1);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i2 = paramInt1;
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mMemberChangeEventReceiver remove member UIN:");
        ((StringBuilder)localObject2).append(paramPBRepeatMessageField1.jdField_a_of_type_Long);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        i2 = paramInt1;
      }
      i1 += 1;
      paramInt1 = i2;
    }
    if (paramInt1 != 0) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.jdField_b_of_type_JavaUtilArrayList });
    }
  }
  
  public void a(Class paramClass)
  {
    InviteUIChecker localInviteUIChecker = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
    if (localInviteUIChecker != null) {
      localInviteUIChecker.a(paramClass.getName());
    }
  }
  
  void a(Long paramLong, long paramLong1, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBanAudio-->relationId");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" uin=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" relationType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" bBan=");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramLong1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
      return;
    }
    if (paramBoolean)
    {
      a().R = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    a().R = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelNetWorkTimer[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.x = false;
    paramString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramString != null) {
      paramString.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    PopupDialog.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    long l1 = AudioHelper.b();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo closeVideo begin, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], emCloseReason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], mStartRing[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    PerfReporter.a(a());
    PerfReporter.b();
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.b()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
      this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
    }
    SignalStrengthReport.a(a()).b();
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
    }
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(3, paramString);
    boolean bool2 = false;
    this.jdField_g_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((VideoRecoveryMonitor)localObject).a(paramInt);
    }
    localObject = SessionMgr.a().a().jdField_c_of_type_JavaLangString;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString))) {
      F();
    }
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    localObject = a().jdField_c_of_type_JavaLangString;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bool1 = bool2;
      if (((String)localObject).equalsIgnoreCase(paramString))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
        if (a().jdField_k_of_type_Boolean)
        {
          paramString = VideoLayerUI.a(paramString, 1);
          GraphicRenderMgr.setGlRender(paramString, null);
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("avideo closeVideo, clear gl render, key[");
            localStringBuilder.append(paramString);
            localStringBuilder.append("]");
            QLog.i((String)localObject, 2, localStringBuilder.toString());
          }
          a(l1, a().jdField_d_of_type_Int, true, true);
        }
        d(paramInt);
        QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
        bool1 = true;
      }
    }
    paramString = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo closeVideo end, result[");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("], cancelNotificationForce[");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString, 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    String str = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sendVideoMsgBroadcast uinType: ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", msgType: ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", friendUin: ");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(", selfUin: ");
    Object localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject1 == null) {
      localObject1 = Integer.valueOf(0);
    } else {
      localObject1 = ((VideoAppInterface)localObject1).getCurrentAccountUin();
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(", isReceiver = ");
    ((StringBuilder)localObject2).append(a().jdField_e_of_type_Boolean);
    ((StringBuilder)localObject2).append(", isVideoMsg = ");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append(", extraUin: ");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append(", forceUnread:");
    ((StringBuilder)localObject2).append(paramBoolean2);
    QLog.d(str, 1, ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty(paramString2)) && (!"0".equals(paramString2)))
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("tencent.video.v2q.AddVideoMsg");
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
        if (localSessionInfo == null)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
          return;
        }
        if (paramInt2 == 21)
        {
          if ((localSessionInfo.jdField_g_of_type_Int != 11) && (localSessionInfo.jdField_g_of_type_Int != 12)) {
            paramInt1 = 48;
          } else {
            paramInt1 = 47;
          }
          localSessionInfo.b("sendVideoMsgBroadcast", 0);
        }
        int i1;
        for (;;)
        {
          i1 = 0;
          break;
          i1 = paramInt1;
          paramInt1 = paramInt2;
          if (paramInt2 != 72) {
            break;
          }
          if ((localSessionInfo.jdField_g_of_type_Int != 16) && (localSessionInfo.jdField_g_of_type_Int != 17)) {
            paramInt1 = 48;
          } else {
            paramInt1 = 47;
          }
          localSessionInfo.b("sendVideoMsgBroadcast", 0);
        }
        boolean bool;
        if (((localSessionInfo.h()) && (paramInt1 == 1)) || (localSessionInfo.j())) {
          bool = true;
        } else {
          bool = false;
        }
        if (paramBoolean2) {
          bool = false;
        }
        ((Intent)localObject2).putExtra("uinType", i1);
        ((Intent)localObject2).putExtra("msgType", paramInt1);
        ((Intent)localObject2).putExtra("isVideoMsg", paramBoolean1);
        ((Intent)localObject2).putExtra("isRead", bool);
        ((Intent)localObject2).putExtra("bindType", localSessionInfo.jdField_A_of_type_Int);
        ((Intent)localObject2).putExtra("bindId", localSessionInfo.jdField_o_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("isDoubleVideoMeeting", localSessionInfo.jdField_y_of_type_Boolean);
        ((Intent)localObject2).putExtra("MultiAVType", localSessionInfo.jdField_j_of_type_Int);
        if (paramInt1 == 17) {
          ((Intent)localObject2).putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        localObject1 = paramString2;
        str = paramString3;
        if (i1 != 1004) {
          if (i1 == 1000)
          {
            localObject1 = paramString2;
            str = paramString3;
          }
          else
          {
            if (i1 == 1006)
            {
              localObject1 = paramString2;
              if (!paramString2.startsWith("+")) {
                localObject1 = paramString3;
              }
              paramString3 = (String)localObject1;
              if (localSessionInfo.jdField_e_of_type_Boolean) {
                paramString2 = (String)localObject1;
              }
            }
            for (;;)
            {
              str = paramString2;
              localObject1 = paramString2;
              break;
              do
              {
                str = paramString1;
                localObject1 = paramString3;
                break;
                paramString3 = paramString2;
              } while (!localSessionInfo.jdField_e_of_type_Boolean);
            }
          }
        }
        if (paramInt1 == 20) {
          str = paramString1;
        }
        paramString2 = str;
        if (TextUtils.isEmpty(str)) {
          paramString2 = paramString1;
        }
        if (localSessionInfo.jdField_y_of_type_Boolean) {
          if (localSessionInfo.jdField_B_of_type_Boolean) {
            paramString2 = paramString1;
          } else {
            paramString2 = (String)localObject1;
          }
        }
        ((Intent)localObject2).putExtra("friendUin", (String)localObject1);
        ((Intent)localObject2).putExtra("senderUin", paramString2);
        ((Intent)localObject2).putExtra("selfUin", paramString1);
        ((Intent)localObject2).putExtra("isSender", localSessionInfo.jdField_e_of_type_Boolean ^ true);
        paramString1 = null;
        if (localSessionInfo.jdField_d_of_type_Long > 0L) {
          paramString1 = UITools.a(a());
        }
        if (QLog.isColorLevel())
        {
          paramString2 = jdField_a_of_type_JavaLangString;
          paramString3 = new StringBuilder();
          paramString3.append("getConnectedTime():");
          paramString3.append(a());
          paramString3.append(" extra:");
          paramString3.append(paramString1);
          QLog.d(paramString2, 2, paramString3.toString());
        }
        ((Intent)localObject2).putExtra("extra", paramString1);
        ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject2);
      }
      return;
    }
    paramString1 = jdField_a_of_type_JavaLangString;
    paramString3 = new StringBuilder();
    paramString3.append("sendVideoMsgBroadcast, invalid uin[");
    paramString3.append(paramString2);
    paramString3.append("]");
    QLog.i(paramString1, 1, paramString3.toString());
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, 2, paramBoolean, paramString2, paramString3, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (AudioHelper.b())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendStartVideoBroadcast, sessionId[");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("], sessionType[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("], updateTime[");
        ((StringBuilder)localObject2).append(paramBoolean1);
        ((StringBuilder)localObject2).append("], showTime[");
        ((StringBuilder)localObject2).append(paramBoolean2);
        ((StringBuilder)localObject2).append("], isDouble[");
        ((StringBuilder)localObject2).append(paramBoolean3);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      AVBizModuleFactory.a("音视频通话").a();
      Object localObject1 = new Intent();
      ((Intent)localObject1).setAction("tencent.av.v2q.StartVideoChat");
      ((Intent)localObject1).putExtra("sessionType", paramInt);
      ((Intent)localObject1).putExtra("sessionId", paramString);
      Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr;
      if (localObject2 != null)
      {
        paramString = ((SessionMgr)localObject2).c(paramString);
        if (paramString != null)
        {
          ((Intent)localObject1).putExtra("uinType", paramString.jdField_k_of_type_Int);
          if (paramString.jdField_k_of_type_Int == 26) {
            ((Intent)localObject1).putExtra("peerUin", paramString.jdField_e_of_type_JavaLangString);
          } else {
            ((Intent)localObject1).putExtra("peerUin", paramString.jdField_c_of_type_JavaLangString);
          }
          if ((paramInt == 3) || (paramInt == 4))
          {
            ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramString.jdField_f_of_type_Long));
            ((Intent)localObject1).putExtra("relationType", paramString.jdField_E_of_type_Int);
            ((Intent)localObject1).putExtra("relationId", paramString.jdField_f_of_type_Long);
          }
          ((Intent)localObject1).putExtra("extraUin", paramString.jdField_e_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("bindType", paramString.jdField_A_of_type_Int);
          ((Intent)localObject1).putExtra("bindId", paramString.jdField_o_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("isReceiver", paramString.jdField_e_of_type_Boolean);
          ((Intent)localObject1).putExtra("isDoubleVideoMeeting", paramString.jdField_y_of_type_Boolean);
        }
      }
      ((Intent)localObject1).putExtra("updateTime", paramBoolean1);
      ((Intent)localObject1).putExtra("isDouble", paramBoolean3);
      ((Intent)localObject1).putExtra("showTime", paramBoolean2);
      ((Intent)localObject1).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject1);
    }
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel())
    {
      paramString = jdField_a_of_type_JavaLangString;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("收到未知的C2C消息[");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append("], handlerForVideo[");
      paramArrayOfByte.append(false);
      paramArrayOfByte.append("]");
      QLog.w(paramString, 1, paramArrayOfByte.toString());
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    b(paramString, paramLong);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramLong, paramBoolean, false, -1);
  }
  
  public void a(String arg1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.post(new VideoController.29(this, ???, paramLong, paramBoolean1, paramBoolean2));
      }
      a("gAudioSetInput", paramBoolean1 ^ true);
      int i1 = paramInt;
      int i2;
      if (paramInt == -1) {
        i2 = paramBoolean1 ^ true;
      }
      c("gAudioSetInput", i2);
    }
    paramLong = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > 1)
        {
          paramInt = 1;
          if ((!paramBoolean1) && (paramInt != 0)) {
            a(this.jdField_a_of_type_Long, new long[] { paramLong }, paramBoolean1, 0);
          }
          return;
        }
      }
      paramInt = 0;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr;
    if (localObject1 != null) {
      localObject1 = ((SessionMgr)localObject1).c(paramString2);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject2 == null) {
      localObject2 = "mApp is null";
    } else {
      localObject2 = ((VideoAppInterface)localObject2).getCurrentAccountUin();
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendStopVideoBroadcast[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("], stopReason[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], senderUin[");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("], isSystemCalling[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], selfUin[");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("], isDouble[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], session[");
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (localObject1 != null))
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        return;
      }
      paramString1 = new Intent();
      paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      paramString1.setAction("tencent.av.v2q.StopVideoChat");
      paramString1.putExtra("sessionId", paramString2);
      paramString1.putExtra("uinType", paramInt1);
      paramString1.putExtra("bindType", ((SessionInfo)localObject1).jdField_A_of_type_Int);
      paramString1.putExtra("bindId", ((SessionInfo)localObject1).jdField_o_of_type_JavaLangString);
      paramString1.putExtra("peerUin", paramString3);
      paramString1.putExtra("sessionType", ((SessionInfo)localObject1).jdField_d_of_type_Int);
      paramString1.putExtra("isDoubleVideoMeeting", ((SessionInfo)localObject1).jdField_y_of_type_Boolean);
      paramString1.putExtra("extraUin", paramString4);
      paramString1.putExtra("stopReason", paramInt2);
      paramString1.putExtra("isSystemCalling", paramBoolean1);
      paramString1.putExtra("isDouble", paramBoolean2);
      paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      paramString1.putExtra(VideoConstants.jdField_d_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_d_of_type_Long);
      paramString1.putExtra(VideoConstants.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
      paramString1.putExtra(VideoConstants.f, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
      paramString1.putExtra("score_connect_duration", a());
      paramInt1 = ((SessionInfo)localObject1).jdField_d_of_type_Int;
      long l2 = 1L;
      if ((paramInt1 != 1) && (((SessionInfo)localObject1).jdField_d_of_type_Int != 2)) {
        l1 = 0L;
      } else {
        l1 = 1L;
      }
      if ((((SessionInfo)localObject1).jdField_d_of_type_Int == 3) || (((SessionInfo)localObject1).jdField_d_of_type_Int == 4)) {
        l1 = 2L;
      }
      paramString1.putExtra(VideoConstants.i, l1);
      long l1 = l2;
      if (((SessionInfo)localObject1).jdField_d_of_type_Int != 1) {
        if (((SessionInfo)localObject1).jdField_d_of_type_Int == 3) {
          l1 = l2;
        } else {
          l1 = 0L;
        }
      }
      paramString1.putExtra(VideoConstants.j, l1);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_k_of_type_JavaLangString != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_k_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_l_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_l_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_E_of_type_Int);
        paramString1.putExtra("relationId", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_f_of_type_Long);
      }
      else
      {
        DoodleLogic.a().a.a();
      }
      if (TextUtils.isEmpty(paramString5)) {
        paramString1.putExtra("senderUin", "");
      } else {
        paramString1.putExtra("senderUin", paramString5);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
      AVBizModuleFactory.a("音视频通话").a();
      AVBizModuleFactory.a("音视频通话");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGAudioMute, [");
      localStringBuilder.append(this.jdField_k_of_type_Boolean);
      localStringBuilder.append(" --> ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((this.jdField_d_of_type_Boolean != paramBoolean) || (this.jdField_b_of_type_Int != paramInt) || (this.jdField_a_of_type_Long != paramLong) || (QLog.isColorLevel())) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, String.format("updateCurJoinGRoomInfo, from[%s], [%s, %s, %s] --> [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(this.jdField_d_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("on 0x626Recv --> Size = ");
      ((StringBuilder)localObject2).append(paramArrayList.size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      localObject1 = new StringBuilder(1024);
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        boolean bool = paramArrayList.hasNext();
        int i1 = 0;
        if (!bool) {
          break;
        }
        localObject2 = (AVPhoneUserInfo)paramArrayList.next();
        Iterator localIterator = a().jdField_f_of_type_JavaUtilArrayList.iterator();
        Object localObject3;
        while (localIterator.hasNext())
        {
          localObject3 = (AVPhoneUserInfo)localIterator.next();
          if ((((AVPhoneUserInfo)localObject3).account != 0L) && (((AVPhoneUserInfo)localObject3).account == ((AVPhoneUserInfo)localObject2).account))
          {
            ((AVPhoneUserInfo)localObject3).telInfo.mobile = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
            ((AVPhoneUserInfo)localObject3).telInfo.nation = ((AVPhoneUserInfo)localObject2).telInfo.nation;
            ((AVPhoneUserInfo)localObject3).telInfo.prefix = ((AVPhoneUserInfo)localObject2).telInfo.prefix;
            i1 = 1;
          }
        }
        if ((i1 == 0) && (QLog.isColorLevel()))
        {
          ((StringBuilder)localObject1).append("on0x626Recv --> can not find the item . Info = ");
          ((StringBuilder)localObject1).append(((AVPhoneUserInfo)localObject2).toString());
          ((StringBuilder)localObject1).append("\n");
        }
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (VideoController.GAudioFriends)localIterator.next();
          if ((((VideoController.GAudioFriends)localObject3).jdField_d_of_type_Int == 1) && (((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long == ((AVPhoneUserInfo)localObject2).account))
          {
            if (((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
              ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
            }
            ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
            ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = ((AVPhoneUserInfo)localObject2).account;
            ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
            ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = ((AVPhoneUserInfo)localObject2).telInfo.nation;
            ((VideoController.GAudioFriends)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = ((AVPhoneUserInfo)localObject2).telInfo.prefix;
          }
        }
      }
      if ((((StringBuilder)localObject1).length() > 0) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(406) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "on0x626Recv --> no data");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAnotherSelfIsRing, isCalling[");
      localStringBuilder.append(this.jdField_h_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mVcCtrl[");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], sessionInfo SessionType[");
      localStringBuilder.append(a().jdField_d_of_type_Int);
      localStringBuilder.append("], sessionInfo state[");
      localStringBuilder.append(a().jdField_f_of_type_Int);
      localStringBuilder.append("], isPeerOnPhone[");
      localStringBuilder.append(a().I);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.jdField_h_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (a().I) {
      return;
    }
    if (paramBoolean)
    {
      if ((a().jdField_f_of_type_Int > 0) && (a().jdField_f_of_type_Int <= 4))
      {
        if ((!a().jdField_H_of_type_Boolean) && (a().jdField_j_of_type_Boolean)) {
          b(a().jdField_c_of_type_JavaLangString);
        }
        if (!a().jdField_g_of_type_Boolean) {
          a(true, a().jdField_c_of_type_JavaLangString);
        }
        b(false, a().jdField_c_of_type_JavaLangString);
      }
      else
      {
        a("notifyAnotherSelfIsRing", true);
      }
    }
    else if ((a().jdField_f_of_type_Int > 0) && (a().jdField_f_of_type_Int <= 4))
    {
      if ((!a().jdField_H_of_type_Boolean) && (a().jdField_j_of_type_Boolean)) {
        c(a().jdField_c_of_type_JavaLangString);
      }
      if (!a().jdField_g_of_type_Boolean) {
        a(false, a().jdField_c_of_type_JavaLangString);
      }
      b(true, a().jdField_c_of_type_JavaLangString);
      z();
    }
    else
    {
      a("notifyAnotherSelfIsRing", false);
      if (a().jdField_E_of_type_Boolean)
      {
        if (this.jdField_g_of_type_JavaLangRunnable == null) {
          this.jdField_g_of_type_JavaLangRunnable = new VideoController.23(this);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 2000L);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localObject != null) {
      ((VcControllerImpl)localObject).notifyAnotherSelfIsRing(a().jdField_c_of_type_JavaLangString, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (a().jdField_d_of_type_Int != 2) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10002), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public void a(boolean paramBoolean, int paramInt, int... paramVarArgs)
  {
    long l1 = AudioHelper.b();
    paramVarArgs = a();
    if (paramVarArgs.jdField_f_of_type_Int == 0) {
      return;
    }
    Object localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localObject != null) {
      ((QAVNotification)localObject).a(paramVarArgs.jdField_b_of_type_JavaLangString);
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeMainSession, mGAudioInRoom[");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("], isDoubleVideoMeeting[");
    localStringBuilder.append(paramVarArgs.jdField_y_of_type_Boolean);
    localStringBuilder.append("], \nsession[");
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("], \nseq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((paramVarArgs.jdField_d_of_type_Int != 3) && (paramVarArgs.jdField_d_of_type_Int != 4))
    {
      if ((paramVarArgs.jdField_d_of_type_Int == 1) || (paramVarArgs.jdField_d_of_type_Int == 2))
      {
        if ((paramVarArgs.jdField_f_of_type_Int != 2) && (paramVarArgs.jdField_f_of_type_Int != 13))
        {
          if (paramVarArgs.jdField_y_of_type_Boolean)
          {
            if (paramBoolean) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramVarArgs.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
            }
            a(l1, Long.valueOf(paramVarArgs.jdField_c_of_type_JavaLangString).longValue(), true, 0);
            return;
          }
          a(paramVarArgs.jdField_c_of_type_JavaLangString, paramInt);
          b(paramVarArgs.jdField_c_of_type_JavaLangString, 0);
          a(l1, 2, true, true);
          return;
        }
        if (paramVarArgs.jdField_y_of_type_Boolean)
        {
          a(l1, paramVarArgs.jdField_c_of_type_JavaLangString, 1, true);
          long l2 = Long.valueOf(paramVarArgs.jdField_c_of_type_JavaLangString).longValue();
          a(l1, 3, l2);
          a(l1, l2, 1);
          return;
        }
        a(l1, paramVarArgs.jdField_c_of_type_JavaLangString, 1, false);
        a(paramVarArgs.jdField_c_of_type_JavaLangString, paramInt);
        b(paramVarArgs.jdField_c_of_type_JavaLangString, 0);
      }
    }
    else if (this.jdField_d_of_type_Boolean)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(paramVarArgs.jdField_f_of_type_Long), Boolean.valueOf(true) });
      }
      if (paramVarArgs.jdField_y_of_type_Boolean)
      {
        a(l1, this.jdField_a_of_type_Long, true, 0);
        return;
      }
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 30);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SessionInfo localSessionInfo = a();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPhoneCalling, isSelf[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], isCalling[");
    localStringBuilder.append(localSessionInfo.jdField_d_of_type_Boolean);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], deviceName[");
    localStringBuilder.append(localSessionInfo.jdField_p_of_type_JavaLangString);
    localStringBuilder.append("], audioStateBeforePhoneCall[");
    localStringBuilder.append(localSessionInfo.jdField_s_of_type_JavaLangString);
    localStringBuilder.append("], mTraeHelper[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
      return;
    }
    if ((localSessionInfo.jdField_f_of_type_Int != 0) && (localSessionInfo.jdField_f_of_type_Int != 5) && (localSessionInfo.jdField_f_of_type_Int != 6) && (localSessionInfo.jdField_d_of_type_Boolean != paramBoolean2))
    {
      localSessionInfo.jdField_d_of_type_Boolean = paramBoolean2;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
        localSessionInfo.jdField_s_of_type_JavaLangString = localSessionInfo.jdField_p_of_type_JavaLangString;
      }
      else
      {
        bool = "DEVICE_SPEAKERPHONE".equals(localSessionInfo.jdField_s_of_type_JavaLangString);
        str = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
        if (bool)
        {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        }
        else if ("DEVICE_EARPHONE".equals(localSessionInfo.jdField_s_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        }
        else
        {
          if (localSessionInfo.jdField_d_of_type_Int == 1) {
            str = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
          }
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(str);
        }
      }
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i1 = DoodleLogic.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().az)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(long[] paramArrayOfLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    if (localObject != null)
    {
      long l1 = CharacterUtil.a((String)localObject);
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (localObject != null) {
        ((QQGAudioCtrl)localObject).setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inviteNewMemJoin, uinList[");
    localStringBuilder.append(paramArrayOfLong);
    localStringBuilder.append("], needNotifyUI[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mMultiInviteEntranceFlag[");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length == 0) {
        return;
      }
      int i1;
      if (this.jdField_e_of_type_Int == 1)
      {
        int i2 = paramArrayOfLong.length;
        localObject = new long[i2 * 2];
        i1 = 0;
        while (i1 < i2)
        {
          int i3 = i1 * 2;
          localObject[i3] = 1L;
          localObject[(i3 + 1)] = paramArrayOfLong[i1];
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject, i2, null, 0, 0, false, false, 4);
        i1 = 0;
        while (i1 < i2)
        {
          if (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramArrayOfLong[i1]))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramArrayOfLong[i1]));
          }
          i1 += 1;
        }
      }
      if (paramBoolean)
      {
        i1 = paramArrayOfLong.length;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(i1) });
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return (this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == paramInt) && (this.jdField_a_of_type_Long == paramLong);
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      m();
    }
    int i2 = -999;
    boolean bool = false;
    int i1 = i2;
    if (paramLong > 0L)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_l_of_type_Boolean = true;
        if (paramInt1 == 1) {
          i1 = paramInt2;
        } else if (paramInt1 == 2) {
          i1 = 1;
        } else if (paramInt1 == 3) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeUpdateRoomInfo(paramInt1, paramLong, i1, true, true, true);
      }
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGAudioRoomMemList, relationType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], discussId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], result[");
    localStringBuilder.append(i1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (i1 == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    Object localObject = a();
    String str = SessionMgr.a(3, paramString, new int[0]);
    if (TextUtils.equals(((SessionInfo)localObject).jdField_b_of_type_JavaLangString, str)) {
      return false;
    }
    if ((paramInt == 1011) && (((SessionInfo)localObject).jdField_k_of_type_Int == paramInt) && (TextUtils.equals(((SessionInfo)localObject).jdField_c_of_type_JavaLangString, paramString))) {
      return false;
    }
    paramInt = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    if (paramInt >= 2)
    {
      paramString = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedAutoRejectDAV, to many session, reject. [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d(paramString, 1, ((StringBuilder)localObject).toString());
      return true;
    }
    if ((((SessionInfo)localObject).h()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDAV, one in av game and one in invite.");
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo isRequestVideo uinType = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", fromUin = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", extraUin = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", sig = ");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append(", onlyAudio = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", bindID=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" ,bindType=");
    localStringBuilder.append(paramInt2);
    QLog.d(str, 1, localStringBuilder.toString());
    paramString2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if ((paramString2 != null) && (paramString2.getApp() != null))
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramString1);
      if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {
        paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);
      } else {
        paramInt2 = a(paramInt1, false, paramInt2);
      }
      if (QLog.isColorLevel())
      {
        paramString2 = jdField_a_of_type_JavaLangString;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("isRequestVideo converted uinType = ");
        paramArrayOfByte.append(paramInt2);
        paramArrayOfByte.append(",sdkAVAccostType = ");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append("|");
        paramArrayOfByte.append(VideoConstants.jdField_b_of_type_Boolean);
        paramArrayOfByte.append(", isVideoPaused: ");
        paramArrayOfByte.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
        QLog.d(paramString2, 2, paramArrayOfByte.toString());
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() >= 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo->pending session exists");
        }
        if (a() != null)
        {
          paramInt1 = a().jdField_k_of_type_Int;
          paramString2 = a().jdField_c_of_type_JavaLangString;
        }
        else
        {
          paramString2 = null;
          paramInt1 = -1;
        }
        if ((paramInt2 != 1011) || (paramInt1 != 1011) || (paramString2 == null) || (!paramString2.equals(paramString1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo->pending session exists, return false");
          }
          return false;
        }
      }
      boolean bool = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
      if (QLog.isColorLevel())
      {
        paramString2 = jdField_a_of_type_JavaLangString;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("isRequestVideo->isScreenLocked:");
        paramArrayOfByte.append(bool);
        QLog.d(paramString2, 2, paramArrayOfByte.toString());
      }
      if (a().e())
      {
        if (paramInt2 == -1) {
          return false;
        }
      }
      else if (((a().jdField_f_of_type_Int != 7) || (this.jdField_c_of_type_Long == 0L)) && (a().jdField_f_of_type_Int != 14) && (a().jdField_f_of_type_Int != 13))
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = jdField_a_of_type_JavaLangString;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("isRequestVideo when chatting: fromUin = ");
            paramArrayOfByte.append(paramString1);
            paramArrayOfByte.append("|");
            paramArrayOfByte.append(bool);
            QLog.d(paramString2, 2, paramArrayOfByte.toString());
          }
          if ((a().jdField_c_of_type_JavaLangString != null) && (paramString1.equals(a().jdField_c_of_type_JavaLangString)))
          {
            paramString2 = jdField_a_of_type_JavaLangString;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("isRequestVideo when request: fromUin = ");
            paramArrayOfByte.append(paramString1);
            AVLog.printAllUserLog(paramString2, paramArrayOfByte.toString());
            return false;
          }
          if (bool) {
            return false;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramString2 = jdField_a_of_type_JavaLangString;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("isRequestVideo when in group chat, fromUin = ");
            paramArrayOfByte.append(paramString1);
            QLog.d(paramString2, 2, paramArrayOfByte.toString());
          }
          if (bool) {
            return false;
          }
        }
      }
      else if (bool) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b()) {
        return false;
      }
      if (paramBoolean) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder();
        paramString2.append("isRequestVideo orientation: ");
        paramString2.append(this.jdField_n_of_type_Int);
        paramString2.append(", isQQPaused: ");
        paramString2.append(VideoConstants.jdField_b_of_type_Boolean);
        paramString2.append(", isVideoPaused: ");
        paramString2.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
        paramString2.append(", isScreenLocked: ");
        paramString2.append(bool);
        paramString2.append(", isAppOnForeground: ");
        paramString2.append(GesturePWDUtils.isAppOnForegroundByTasks(a(), 0));
        QLog.d(paramString1, 2, paramString2.toString());
      }
      return true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "isRequestVideo  faile,app is null, return false");
    return false;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    GVideoDownloadChannelControl localGVideoDownloadChannelControl = this.jdField_a_of_type_ComTencentAvAppGVideoDownloadChannelControl;
    if (localGVideoDownloadChannelControl == null) {
      return GVideoDownloadChannelControl.a();
    }
    return localGVideoDownloadChannelControl.a(paramLong, paramInt);
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {
      return false;
    }
    String str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    Object localObject = a();
    if (TextUtils.equals(str, ((SessionInfo)localObject).jdField_b_of_type_JavaLangString)) {
      return false;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    if (paramInt1 >= 2)
    {
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedAutoRejectDM, to many session, reject. [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("]");
      QLog.i(str, 1, ((StringBuilder)localObject).toString());
      return true;
    }
    if ((((SessionInfo)localObject).h()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDM, one in av game and one in invite.");
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
      paramInt2 = 0;
      if (paramInt2 < i1)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((localGAudioFriends != null) && (localGAudioFriends.jdField_a_of_type_Long == paramLong))
        {
          localGAudioFriends.jdField_e_of_type_Boolean = paramBoolean;
          localGAudioFriends.jdField_d_of_type_Int = paramInt1;
          boolean bool = localGAudioFriends.jdField_g_of_type_Boolean;
          if (paramBoolean)
          {
            localGAudioFriends.jdField_g_of_type_Boolean = false;
            paramBoolean = bool;
          }
          else
          {
            paramBoolean = bool;
            if (localGAudioFriends.jdField_f_of_type_Boolean)
            {
              localGAudioFriends.jdField_f_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(false) });
              paramBoolean = bool;
            }
          }
          return paramBoolean;
        }
      }
    }
  }
  
  boolean a(long paramLong, int paramInt, ArrayList<VideoViewInfo> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      if ((((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.quaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
    }
    QLog.isColorLevel();
    return false;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl == null) {
      return false;
    }
    return localQQGAudioCtrl.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_ac_of_type_Int == -1) {
      paramSessionInfo.jdField_ac_of_type_Int = a(paramSessionInfo, paramSessionInfo.jdField_c_of_type_JavaLangString);
    }
    if (paramSessionInfo.ab == -1) {
      paramSessionInfo.ab = b(paramSessionInfo, paramSessionInfo.jdField_c_of_type_JavaLangString);
    }
    int i1 = paramSessionInfo.jdField_ac_of_type_Int;
    boolean bool2 = false;
    boolean bool1;
    if (i1 == 2)
    {
      bool1 = bool2;
      if (paramSessionInfo.ab < 100) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          bool1 = true;
          break label122;
          if (paramSessionInfo.jdField_ac_of_type_Int != 4) {
            break;
          }
          bool1 = bool2;
          if (paramSessionInfo.ab < 101) {
            break label122;
          }
        }
        bool1 = bool2;
        if (paramSessionInfo.jdField_ac_of_type_Int != 5) {
          break;
        }
        bool1 = bool2;
      } while (paramSessionInfo.ab >= 5635);
    }
    label122:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeerSupportDMeetingSwitchTroop, end[");
      localStringBuilder.append(paramSessionInfo.jdField_ac_of_type_Int);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSessionInfo.ab);
      localStringBuilder.append(",");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean a(SessionInfo paramSessionInfo1, SessionInfo paramSessionInfo2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1;
    try
    {
      l1 = Long.parseLong(paramSessionInfo1.jdField_c_of_type_JavaLangString);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l1 = 0L;
    }
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if ((l1 == paramLong2) && (paramSessionInfo1.jdField_A_of_type_Boolean)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealSwitchP2PShare ], peerUin[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], friendUin[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], isTurnDoubleVideoMeeting2Multi[");
      ((StringBuilder)localObject).append(paramSessionInfo1.jdField_A_of_type_Boolean);
      ((StringBuilder)localObject).append("], ret[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], main[");
      ((StringBuilder)localObject).append(paramSessionInfo1);
      ((StringBuilder)localObject).append("], new[");
      ((StringBuilder)localObject).append(paramSessionInfo2);
      ((StringBuilder)localObject).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    paramSessionInfo1.jdField_A_of_type_Boolean = false;
    if (bool1)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        paramSessionInfo2.b(paramLong1, paramSessionInfo1.jdField_j_of_type_Boolean);
        a(paramString, paramSessionInfo2.jdField_d_of_type_Int, false, false, false);
        if ((this.jdField_e_of_type_JavaLangRunnable != null) && (localObject != null)) {
          ((VideoAppInterface)localObject).a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        }
        if (!paramSessionInfo1.b()) {
          a(paramLong1, 2131230740, 1, null);
        }
        int i1 = paramSessionInfo1.jdField_d_of_type_Int;
        paramSessionInfo2.av = true;
        paramSessionInfo2.jdField_c_of_type_JavaLangString = paramSessionInfo1.jdField_c_of_type_JavaLangString;
        if ((paramSessionInfo1.jdField_f_of_type_Int == 15) || (paramSessionInfo1.jdField_z_of_type_Boolean)) {
          d(false);
        }
        paramSessionInfo1.b("onGAudioInvite", 12);
        if (i1 == 1) {
          paramSessionInfo1.a(paramLong1, "onGAudioInvite.6", 3);
        } else if (i1 == 2) {
          paramSessionInfo1.a(paramLong1, "onGAudioInvite.7", 4);
        } else if (i1 == 4) {
          paramSessionInfo1.a(paramLong1, "onGAudioInvite.8", 4);
        } else {
          paramSessionInfo1.a(paramLong1, "onGAudioInvite.9", 3);
        }
        paramSessionInfo1.jdField_k_of_type_Int = UITools.c(paramInt);
        paramSessionInfo1.jdField_f_of_type_Long = paramLong3;
        if (paramArrayOfLong != null) {
          paramSessionInfo1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
        }
        paramSessionInfo1.d("onGAudioInvite.1", 1);
        if (localObject != null) {
          if (((VideoAppInterface)localObject).a() > 0)
          {
            paramSessionInfo1.e("onGAudioInvite3", AVUtil.a(paramSessionInfo1.jdField_k_of_type_Int));
            ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
          }
          else if (((VideoAppInterface)localObject).isBackgroundStop)
          {
            paramSessionInfo1.e("onGAudioInvite4", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            j(false);
          }
        }
        paramSessionInfo2 = QAVNotification.a((VideoAppInterface)localObject);
        bool2 = bool3;
        if (paramSessionInfo2 != null)
        {
          bool3 = paramSessionInfo2.a();
          bool2 = bool3;
          if (bool3)
          {
            paramSessionInfo2.a(paramSessionInfo1.jdField_b_of_type_JavaLangString);
            bool2 = bool3;
          }
        }
        if (bool2) {
          d();
        }
      }
      catch (Exception paramSessionInfo1)
      {
        if (QLog.isColorLevel())
        {
          paramSessionInfo2 = jdField_a_of_type_JavaLangString;
          paramArrayOfLong = new StringBuilder();
          paramArrayOfLong.append("onGAudioInviteError-->Exception=");
          paramArrayOfLong.append(paramSessionInfo1.getMessage());
          QLog.e(paramSessionInfo2, 2, paramArrayOfLong.toString());
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, paramString);
      }
      bool2 = bool1;
    }
    return bool2;
  }
  
  public boolean a(qav_gvideo_sdk_transfer.gVideoDownChannelControl paramgVideoDownChannelControl)
  {
    GVideoDownloadChannelControl localGVideoDownloadChannelControl = this.jdField_a_of_type_ComTencentAvAppGVideoDownloadChannelControl;
    if (localGVideoDownloadChannelControl != null) {
      return localGVideoDownloadChannelControl.a(paramgVideoDownChannelControl);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StopGVideo, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      if (paramString != null) {
        paramString.post(new VideoController.21(this, l1));
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    long l1 = a(paramString);
    boolean bool = a(b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()), b(paramString), l1, paramInt, paramLong);
    paramString = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("quaReport --> report result = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" | node = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" | timestamp = ");
    localStringBuilder.append(paramLong);
    QLog.d(paramString, 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return false;
    }
    int i1 = paramSessionInfo.a();
    long l1 = paramSessionInfo.b();
    long l2 = paramSessionInfo.d();
    if (i1 == 2)
    {
      l3 = a(paramSessionInfo);
      if (l3 != paramSessionInfo.b()) {
        paramSessionInfo.c(l3);
      }
    }
    else if (i1 == 1)
    {
      l3 = b(paramSessionInfo);
      if (l3 != paramSessionInfo.b()) {
        paramSessionInfo.c(l3);
      }
    }
    long l3 = paramSessionInfo.b();
    long l4 = paramSessionInfo.d();
    boolean bool;
    if ((l1 == l3) && (l2 == l4)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool), paramSessionInfo, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
    }
    return bool;
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    Object localObject = a();
    boolean bool = false;
    String str1;
    if (paramBoolean)
    {
      if (paramInt == 3) {
        str1 = SessionMgr.a(100, paramString2, new int[0]);
      } else {
        str1 = SessionMgr.a(paramInt, paramString2, new int[0]);
      }
    }
    else {
      str1 = SessionMgr.a(paramInt, paramString2, new int[0]);
    }
    if (!TextUtils.equals(((SessionInfo)localObject).jdField_b_of_type_JavaLangString, str1))
    {
      bool = SessionMgr.a().b(str1);
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkMainSession, need reset main session, from[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], cur");
      localStringBuilder.append(((SessionInfo)localObject).jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], coming[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i(str2, 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      str1 = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMainSession, from[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], isFromMAVEngine[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], ret[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i(str1, 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject1 = a(a().jdField_e_of_type_JavaUtilArrayList);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestGVideo-->info=");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    int i2 = 0;
    if (localObject2 != null)
    {
      H();
      int i1 = 0;
      while (i1 < a().jdField_e_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)a().jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          a().jdField_e_of_type_JavaUtilArrayList.remove(i1);
          i1 = 1;
          break label154;
        }
        i1 += 1;
      }
      i1 = 0;
      label154:
      if (Build.VERSION.SDK_INT < 21)
      {
        if (i1 != 0) {
          i1 = 8;
        } else {
          i1 = 9;
        }
        if (i1 < a().jdField_e_of_type_JavaUtilArrayList.size())
        {
          localObject1 = new ArrayList(i1);
          while (i2 < i1)
          {
            ((ArrayList)localObject1).add(a().jdField_e_of_type_JavaUtilArrayList.get(i2));
            i2 += 1;
          }
          a().jdField_e_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
      }
      if (a().jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject1 = (ArrayList)a().jdField_e_of_type_JavaUtilArrayList.clone();
        localObject2 = this.jdField_a_of_type_MqqOsMqqHandler;
        if (localObject2 != null) {
          ((MqqHandler)localObject2).post(new VideoController.20(this, (ArrayList)localObject1, paramBoolean));
        }
      }
      return true;
    }
    a().jdField_e_of_type_JavaUtilArrayList.clear();
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=");
      localStringBuilder.append((String)localObject1);
      QLog.e((String)localObject2, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl == null) {
      return null;
    }
    return localVcControllerImpl.postData(paramLong2, paramArrayOfByte);
  }
  
  public int b()
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i3 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i3);
          if (localGAudioFriends == null)
          {
            i2 = i1;
          }
          else if (localGAudioFriends.jdField_a_of_type_Long == CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
          {
            i2 = i1;
          }
          else
          {
            i2 = i1;
            if (localGAudioFriends.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (localGAudioFriends.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            i2 = i1;
            if (localGAudioFriends.jdField_c_of_type_Boolean) {
              i2 = i1 + 1;
            }
          }
        }
        else
        {
          return i1;
        }
      }
      finally
      {
        int i2;
        continue;
        throw localObject;
        continue;
        i3 += 1;
        i1 = i2;
      }
    }
  }
  
  public int b(int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVoiceType| sessionType=");
    localStringBuilder.append(a().jdField_d_of_type_Int);
    localStringBuilder.append("type=");
    localStringBuilder.append(paramInt);
    AVLog.printAllUserLog((String)localObject, localStringBuilder.toString());
    if ((a().jdField_d_of_type_Int != 1) && (a().jdField_d_of_type_Int != 2))
    {
      if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4))
      {
        localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
        if (localObject != null) {
          return ((QQGAudioCtrl)localObject).setVoiceType(paramInt);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject != null) {
        return ((VcControllerImpl)localObject).setVoiceType(paramInt);
      }
    }
    return -1;
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    if ((a().jdField_d_of_type_Int != 1) && (a().jdField_d_of_type_Int != 2)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterAudioDataCallback(paramInt);
  }
  
  public int b(SessionInfo paramSessionInfo, String paramString)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl != null) {
      return localQQGAudioCtrl.getRoomUserSdkVersion(paramSessionInfo, paramString);
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    Object localObject = SessionMgr.a().a(paramString);
    if ((localObject != null) && (((SessionInfo)localObject).jdField_ac_of_type_Int != -1)) {
      return ((SessionInfo)localObject).jdField_ac_of_type_Int;
    }
    localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localObject != null) {
      return ((VcControllerImpl)localObject).getPeerTerminalType(paramString);
    }
    return -1;
  }
  
  public int b(boolean paramBoolean)
  {
    if ((!a().j()) && (!this.jdField_d_of_type_Boolean)) {
      return 255;
    }
    int i1 = 0;
    Object localObject;
    if (a().jdField_d_of_type_Int == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject != null) {
        return ((VcControllerImpl)localObject).getVolume(paramBoolean);
      }
    }
    else if (a().jdField_d_of_type_Int == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (localObject != null) {
        return ((QQGAudioCtrl)localObject).getVolume();
      }
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getVolume(paramBoolean);
    }
    return i1;
  }
  
  public int b(boolean paramBoolean, String paramString)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl == null) {
      return -1;
    }
    return localVcControllerImpl.setAudioOutput(paramString, paramBoolean);
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public long b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramSessionInfo.jdField_d_of_type_Int == 3) || (paramSessionInfo.jdField_d_of_type_Int == 4)) && (paramSessionInfo.b() == 0L))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramSessionInfo.jdField_E_of_type_Int, paramSessionInfo.jdField_j_of_type_Int, paramSessionInfo.jdField_f_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramSessionInfo.c(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramSessionInfo.e(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramSessionInfo.b();
  }
  
  public long b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l1 = CharacterUtil.a(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog(jdField_a_of_type_JavaLangString, paramString.getMessage());
    }
    return -1L;
  }
  
  public WatchTogetherMediaPlayCtrl b()
  {
    if (p()) {
      return this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
    }
    return null;
  }
  
  public ArrayList<VideoController.GAudioFriends> b()
  {
    if ((AudioHelper.a()) && (QavTestUtil.sGAudioVirtualList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(QavTestUtil.sGAudioVirtualList);
      return localArrayList;
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject == null) {
      return;
    }
    localObject = ((VideoAppInterface)localObject).a();
    if (localObject != null) {
      ((VideoProcessExitMonitor)localObject).a();
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportCloseReasonBeacon,reason  = ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("closeReason", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAvideoCloseReasonB", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGaRoomSettingChanged-->relationType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" relationUin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" changedType = ");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt2 == 102) {
      a().O = true;
    } else if (paramInt2 == 103) {
      a().O = false;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt, String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveSubtitleChanged:");
    localStringBuilder.append(paramString);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6009), Integer.valueOf(paramInt), paramString });
  }
  
  void b(long paramLong)
  {
    if (a().jdField_k_of_type_Int != 1011)
    {
      if (a().jdField_k_of_type_Int == 21) {
        return;
      }
      if (a().jdField_c_of_type_Long == 0L)
      {
        long l1 = a().jdField_b_of_type_Long;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startReachedRing, peer colorRingId=");
          localStringBuilder.append(l1);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        Object localObject = ColorRingManager.a(l1, 3);
        if (new File((String)localObject).exists())
        {
          TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
          a().jdField_f_of_type_Boolean = true;
          int i1 = a().jdField_r_of_type_Int;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(i1);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(l1);
          localStringBuilder.append("");
          ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
          return;
        }
        TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230747, null, -1, null);
        a().jdField_f_of_type_Boolean = true;
      }
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    Object localObject = a();
    int i1;
    if ((!TextUtils.isEmpty(((SessionInfo)localObject).jdField_c_of_type_JavaLangString)) && ((!((SessionInfo)localObject).jdField_c_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (((SessionInfo)localObject).jdField_d_of_type_Int == 0)))
    {
      i1 = a(paramLong1, paramLong2);
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryRoomInfo1, result[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a() == 0) && (TextUtils.isEmpty(((SessionInfo)localObject).jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(((SessionInfo)localObject).jdField_c_of_type_JavaLangString)))
    {
      i1 = a(paramLong1, paramLong2);
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryRoomInfo2, result[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QueryRoomInfo fail, mainSession[");
    localStringBuilder.append(a());
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.35(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    int i1;
    if (paramInt == 23) {
      i1 = 1;
    } else {
      i1 = paramInt;
    }
    Object localObject1 = SessionMgr.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
    }
    else
    {
      localObject1 = SessionMgr.a(100, paramString, new int[0]);
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
    }
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("|VideoNodeManager");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doCloseSession, fail to find session, peerUin[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], type[");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("], fourceCloseIgnoreSessionState[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      VideoNodeManager.a(0L, 33);
      VideoNodeManager.b(0L);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject3 != null) {
      ((ChatRoomMng)localObject3).a((SessionInfo)localObject2);
    }
    VideoNodeManager.a(((SessionInfo)localObject2).b(), 16, 0L);
    VideoNodeManager.a(((SessionInfo)localObject2).b(), 33);
    VideoNodeManager.b(((SessionInfo)localObject2).b());
    localObject3 = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    int i2;
    if (((SessionInfo)localObject2).jdField_e_of_type_Boolean) {
      i2 = 12;
    } else {
      i2 = 5;
    }
    ((VideoNodeReporter)localObject3).a(((SessionInfo)localObject2).b(), i2, i1 + 500);
    ((VideoNodeReporter)localObject3).a("NoCrash");
    ((VideoNodeReporter)localObject3).a(((SessionInfo)localObject2).b(), 29, 1L);
    ((VideoNodeReporter)localObject3).a(36, 1L);
    ((VideoNodeReporter)localObject3).b(((SessionInfo)localObject2).b());
    localObject3 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo doCloseSession, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("->");
    localStringBuilder.append(i1);
    localStringBuilder.append("], fourceCloseIgnoreSessionState[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mIsQuit[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("], sessionInfo.isIdling[");
    localStringBuilder.append(((SessionInfo)localObject2).e());
    localStringBuilder.append("], sessionInfo.peerUin[");
    localStringBuilder.append(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], sessionInfo.isOnlyAudio[");
    localStringBuilder.append(((SessionInfo)localObject2).jdField_H_of_type_Boolean);
    localStringBuilder.append("], sessionInfo.SessionType[");
    localStringBuilder.append(((SessionInfo)localObject2).jdField_d_of_type_Int);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject3, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    if ((((SessionInfo)localObject2).e()) && (!paramBoolean))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
      return;
    }
    if ((((SessionInfo)localObject2).jdField_d_of_type_Int == 2) && (!((SessionInfo)localObject2).jdField_y_of_type_Boolean) && (((SessionInfo)localObject2).jdField_f_of_type_Int >= 4) && (((SessionInfo)localObject2).jdField_d_of_type_Long > 0L))
    {
      i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
      localObject3 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeSession double video call end with beauty: ");
      localStringBuilder.append(i2);
      localStringBuilder.append(" | ");
      localStringBuilder.append(((SessionInfo)localObject2).jdField_d_of_type_Long);
      localStringBuilder.append(" | ");
      localStringBuilder.append(((SessionInfo)localObject2).jdField_f_of_type_Int);
      localStringBuilder.append(" | ");
      localStringBuilder.append(((SessionInfo)localObject2).t);
      AVLog.printAllUserLog((String)localObject3, localStringBuilder.toString());
      if ((((SessionInfo)localObject2).t) || (i2 > 0)) {
        ReportController.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
      }
    }
    if ((this.jdField_r_of_type_Boolean) && (a() > 0L)) {
      if (((SessionInfo)localObject2).jdField_d_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", UITools.a(a()), "");
      } else if (((SessionInfo)localObject2).jdField_d_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", UITools.a(a()), "");
      }
    }
    ((SessionInfo)localObject2).jdField_c_of_type_Long = 0L;
    ((SessionInfo)localObject2).n = null;
    localObject3 = paramString;
    if (!TextUtils.isEmpty(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString))
    {
      localObject3 = paramString;
      if (((SessionInfo)localObject2).jdField_c_of_type_JavaLangString.contains(paramString)) {
        localObject3 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
      }
    }
    if ((((SessionInfo)localObject2).m()) || (((SessionInfo)localObject2).n())) {
      ((SessionInfo)localObject2).jdField_z_of_type_Int = i1;
    }
    if ((!((SessionInfo)localObject2).f()) && ((!((SessionInfo)localObject2).h()) || (i1 != ((SessionInfo)localObject2).jdField_z_of_type_Int))) {
      break label1042;
    }
    ((SessionInfo)localObject2).a(paramLong, 0L);
    label1042:
    if ((((SessionInfo)localObject2).Y) && (this.jdField_f_of_type_JavaLangRunnable != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_f_of_type_JavaLangRunnable = null;
    }
    if (paramInt == 23)
    {
      if (((SessionInfo)localObject2).jdField_d_of_type_Int == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_k_of_type_Int, paramBoolean, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString);
    }
    else
    {
      a(paramLong, (String)localObject1, (String)localObject3, i1);
    }
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a())
    {
      j();
      l();
      u();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      DataReport.b(this, false);
      DataReport.c(this, false);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        DataReport.l(this);
      }
    }
    ((SessionInfo)localObject2).a("doCloseSession", 0);
    ((SessionInfo)localObject2).a(paramLong, "doCloseSession", 0);
    ((SessionInfo)localObject2).jdField_e_of_type_Int = 0;
    ((SessionInfo)localObject2).jdField_a_of_type_JavaUtilBitSet.clear();
    ((SessionInfo)localObject2).i = 0L;
    GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
    ((SessionInfo)localObject2).al = false;
    ((SessionInfo)localObject2).jdField_a_of_type_ArrayOfJavaLangString = null;
    ((SessionInfo)localObject2).b("doCloseSession", null);
    ((SessionInfo)localObject2).jdField_p_of_type_Boolean = true;
    if ((i1 != 21) && (i1 != 72) && (i1 != 110))
    {
      ((SessionInfo)localObject2).jdField_k_of_type_Int = -1;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject3, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      } else {
        paramBoolean = this.jdField_a_of_type_Boolean;
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject3, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
    ((SessionInfo)localObject2).b(paramLong, false);
    ((SessionInfo)localObject2).c(paramLong, false);
    ((SessionInfo)localObject2).a(paramLong, 0L);
    ((SessionInfo)localObject2).a(paramLong);
    SessionFlag.a().a();
    paramString = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("close session removeSession sessionId = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
    paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong, (String)localObject1);
    paramString = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((paramString != null) && (paramString.a()))
    {
      paramString.a((String)localObject1);
      if (paramBoolean) {
        d();
      }
    }
    if (this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this), 5000L);
    }
  }
  
  public void b(long paramLong, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((a().jdField_d_of_type_Int > 0) && (a().jdField_d_of_type_Int <= 2) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null))
    {
      if (!a().j()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.pauseVideo(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo end");
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    long l1 = AudioHelper.b();
    TraeHelper.a().b(l1);
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (d(paramString)) {
      TraeHelper.a().b();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "closeSession", new Throwable("closeSession"));
    }
    b(l1, paramString, paramInt, false);
  }
  
  public void b(String paramString, long paramLong)
  {
    try
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("setMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      long l1 = Long.valueOf(paramString).longValue();
      if ((l1 > 0L) && (paramLong > 0L))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), Long.valueOf(paramLong));
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setMSFInviteMessageTimeStamp fail.", paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSoundEnable: ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
        return;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
    }
  }
  
  public boolean b(int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramInt2 != 5) && (paramInt2 != 4))
    {
      if (paramInt2 == 3) {
        return false;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      if ((((SessionInfo)localObject).jdField_E_of_type_Int == paramInt1) && (((SessionInfo)localObject).jdField_f_of_type_Long == paramLong)) {
        return false;
      }
      paramInt1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      if (paramInt1 >= 2)
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkNeedAutoRejectMAV, to many session, reject. [");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 1, localStringBuilder.toString());
        return true;
      }
      if ((((SessionInfo)localObject).h()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
        return true;
      }
    }
    return false;
  }
  
  public boolean b(SessionInfo paramSessionInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeerSupportDoubleSwitchToTroop, start[");
      localStringBuilder.append(paramSessionInfo.jdField_ac_of_type_Int);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSessionInfo.ab);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    if (paramSessionInfo.jdField_ac_of_type_Int == -1) {
      paramSessionInfo.jdField_ac_of_type_Int = b(paramSessionInfo.jdField_c_of_type_JavaLangString);
    }
    if (paramSessionInfo.ab == -1) {
      paramSessionInfo.ab = c(paramSessionInfo.jdField_c_of_type_JavaLangString);
    }
    int i1 = paramSessionInfo.jdField_ac_of_type_Int;
    boolean bool = false;
    if (i1 == 2)
    {
      if (paramSessionInfo.ab < 100) {}
    }
    else
    {
      for (;;)
      {
        bool = true;
        break label165;
        if (paramSessionInfo.jdField_ac_of_type_Int != 4) {
          break;
        }
        if (paramSessionInfo.ab < 101) {
          break label165;
        }
      }
      i1 = paramSessionInfo.jdField_ac_of_type_Int;
    }
    label165:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeerSupportDoubleSwitchToTroop, end[");
      localStringBuilder.append(paramSessionInfo.jdField_ac_of_type_Int);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSessionInfo.ab);
      localStringBuilder.append(",");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean b(SessionInfo paramSessionInfo1, SessionInfo paramSessionInfo2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1;
    try
    {
      l1 = Long.parseLong(paramSessionInfo1.jdField_c_of_type_JavaLangString);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l1 = 0L;
    }
    boolean bool1;
    if ((l1 == paramLong2) && (paramSessionInfo1 != paramSessionInfo2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealSwitchP2PAV ], peerUin[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], ret[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], main[");
      localStringBuilder.append(paramSessionInfo1);
      localStringBuilder.append("], new[");
      localStringBuilder.append(paramSessionInfo2);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    if (bool1) {
      if (paramSessionInfo1.jdField_z_of_type_Int == 0)
      {
        paramSessionInfo1.a("onGAudioInvite.2", 0);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, paramString);
        return bool1;
      }
    }
    label640:
    label643:
    label646:
    for (;;)
    {
      try
      {
        paramSessionInfo2.b(paramLong1, paramSessionInfo1.jdField_j_of_type_Boolean);
        int i1 = paramSessionInfo2.jdField_d_of_type_Int;
        boolean bool2 = bool1;
        try
        {
          a(paramString, i1, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramSessionInfo1.b()) {
            a(paramLong1, 2131230740, 1, null);
          }
          i1 = paramSessionInfo1.jdField_d_of_type_Int;
          paramSessionInfo2.jdField_c_of_type_JavaLangString = paramSessionInfo1.jdField_c_of_type_JavaLangString;
          paramSessionInfo2.b(paramLong1, paramSessionInfo1.jdField_j_of_type_Boolean);
          paramSessionInfo2.jdField_g_of_type_Boolean = paramSessionInfo1.jdField_g_of_type_Boolean;
          paramSessionInfo2.b("onGAudioInvite", paramSessionInfo1.jdField_E_of_type_Boolean);
          paramSessionInfo2.b("onGAudioInvite", paramSessionInfo1.jdField_p_of_type_JavaLangString);
          paramSessionInfo2.av = true;
          paramSessionInfo2.b("onGAudioInvite", 12);
          paramSessionInfo1.b("onGAudioInvite", 12);
          b(paramSessionInfo1.jdField_c_of_type_JavaLangString, 21);
          if (i1 == 1) {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.2", 3);
          } else if (i1 == 2) {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.3", 4);
          } else if (i1 == 4) {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.4", 4);
          } else {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.5", 3);
          }
          paramSessionInfo2.jdField_k_of_type_Int = UITools.c(paramInt);
          paramSessionInfo2.jdField_f_of_type_Long = paramLong3;
          if (paramArrayOfLong != null) {
            paramSessionInfo2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
          }
          paramSessionInfo2.d("onGAudioInvite.2", 1);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
          {
            paramSessionInfo2.e("onGAudioInvite1", AVUtil.a(paramSessionInfo2.jdField_k_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            break label643;
          }
          if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop) {
            break label643;
          }
          paramSessionInfo2.e("onGAudioInvite2", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          j(false);
          boolean bool3 = false;
          paramSessionInfo1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if (paramSessionInfo1 != null)
          {
            bool3 = paramSessionInfo1.a();
            if (!bool3) {
              break label646;
            }
            paramSessionInfo1.a(paramString);
            break label646;
          }
          bool4 = bool2;
          if (!bool3) {
            break label640;
          }
          d();
          return bool2;
        }
        catch (Exception paramSessionInfo1) {}
        if (!QLog.isColorLevel()) {
          break label623;
        }
      }
      catch (Exception paramSessionInfo1) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramSessionInfo1);
      label623:
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, paramString);
      return bool1;
      boolean bool4 = false;
      return bool4;
    }
  }
  
  public boolean b(String paramString)
  {
    int i1 = b(paramString);
    return (i1 == 5) || (i1 == 14);
  }
  
  public boolean b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int c()
  {
    return MSFNetInfoMonitor.a();
  }
  
  public int c(String paramString)
  {
    Object localObject = SessionMgr.a().a(paramString);
    if ((localObject != null) && (((SessionInfo)localObject).ab != -1)) {
      return ((SessionInfo)localObject).ab;
    }
    localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localObject != null) {
      return ((VcControllerImpl)localObject).getPeerSdkVersion(paramString);
    }
    return -1;
  }
  
  public long c()
  {
    return a(a());
  }
  
  public ArrayList<VideoController.GAudioFriends> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.a()) && (QavTestUtil.sGAudioVirtualList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(QavTestUtil.sGAudioVirtualList);
        return localArrayList2;
      }
      ArrayList localArrayList2 = this.jdField_c_of_type_JavaUtilArrayList;
      return localArrayList2;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNetWorkTimer");
    }
    if (this.x) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.x = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void c(int paramInt)
  {
    SessionInfo localSessionInfo = a();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.av.v2q.AvSwitch");
      ((Intent)localObject).putExtra("sessionType", paramInt);
      ((Intent)localObject).putExtra("uinType", localSessionInfo.jdField_k_of_type_Int);
      ((Intent)localObject).putExtra("peerUin", localSessionInfo.jdField_c_of_type_JavaLangString);
      ((Intent)localObject).putExtra("extraUin", localSessionInfo.jdField_e_of_type_JavaLangString);
      ((Intent)localObject).putExtra("relationType", localSessionInfo.jdField_E_of_type_Int);
      if ((localSessionInfo.jdField_f_of_type_Long == 0L) && (localSessionInfo.jdField_k_of_type_Int == 0)) {
        ((Intent)localObject).putExtra("relationId", AVUtil.a(localSessionInfo.jdField_c_of_type_JavaLangString));
      } else {
        ((Intent)localObject).putExtra("relationId", localSessionInfo.jdField_f_of_type_Long);
      }
      ((Intent)localObject).putExtra("isDoubleVideoMeeting", localSessionInfo.jdField_y_of_type_Boolean);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendAvSwitchBroadcast, sessionType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], peer[");
      localStringBuilder.append(localSessionInfo.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("], type[");
      localStringBuilder.append(localSessionInfo.jdField_d_of_type_Int);
      localStringBuilder.append("], uinType[");
      localStringBuilder.append(localSessionInfo.jdField_k_of_type_Int);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(localSessionInfo.jdField_E_of_type_Int);
      localStringBuilder.append("], relationId[");
      localStringBuilder.append(localSessionInfo.jdField_f_of_type_Long);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  void c(int paramInt1, long paramLong, int paramInt2)
  {
    int i1;
    if (paramInt2 == 108)
    {
      a().Q = true;
      a().P = (i() ^ true);
      i1 = e();
      a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false, -1);
      a(-1L, i1, e());
    }
    else if (a().Q)
    {
      a().Q = false;
      i1 = e();
      if (a().P) {
        a("onMVSpeakModeChanged_2", this.jdField_a_of_type_Long, true, false, -1);
      } else {
        a("onMVSpeakModeChanged_3", this.jdField_a_of_type_Long, false, false, -1);
      }
      a(-1L, i1, e());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void c(int paramInt, String paramString)
  {
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void c(long paramLong)
  {
    int i1;
    String str;
    StringBuilder localStringBuilder;
    if (a().jdField_j_of_type_Boolean)
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchVideo(a().jdField_c_of_type_JavaLangString);
      if ((QLog.isColorLevel()) || (i1 == -1))
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchVideo , ret[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(a().jdField_c_of_type_JavaLangString);
      if ((QLog.isColorLevel()) || (i1 == -1))
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchAudio , ret[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeVideo SessionType :");
      localStringBuilder.append(a().jdField_d_of_type_Int);
      QLog.d("VideoController", 2, localStringBuilder.toString());
    }
    try
    {
      GraphicRenderMgr.getInstance().clearCameraFrames();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    if ((a().jdField_d_of_type_Int > 0) && (a().jdField_d_of_type_Int <= 2))
    {
      if (!a().j()) {
        return;
      }
      VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localVcControllerImpl == null) {
        return;
      }
      localVcControllerImpl.resumeVideo(paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGAudioSpeakerMode, [");
      localStringBuilder.append(this.jdField_p_of_type_Int);
      localStringBuilder.append(" --> ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.jdField_p_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      localVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public boolean c()
  {
    boolean bool1 = a(a());
    boolean bool2 = q();
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGameMode isQQPaused: ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(", isVideoPaused: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      localStringBuilder.append(", isLandscape: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", isScreenLocked: ");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return (!bool1) && (bool2) && (bool3) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public boolean c(boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableLoopback| sessionType=");
    localStringBuilder.append(a().jdField_d_of_type_Int);
    localStringBuilder.append("enable=");
    localStringBuilder.append(paramBoolean);
    AVLog.printAllUserLog((String)localObject, localStringBuilder.toString());
    if ((a().jdField_d_of_type_Int != 1) && (a().jdField_d_of_type_Int != 2))
    {
      if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4))
      {
        localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
        if (localObject != null) {
          return ((QQGAudioCtrl)localObject).enableLoopback(paramBoolean);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
      if (localObject != null) {
        return ((VcControllerImpl)localObject).enableLoopback(paramBoolean);
      }
    }
    return false;
  }
  
  public void checkNetStatus()
  {
    int i1 = NetworkUtil.getSystemNetwork(null);
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2) && (i1 != 3) && (i1 != 4) && (i1 != 5))
      {
        f(0);
        return;
      }
      L();
      return;
    }
    f(3);
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentAvQavChannelProxy.jdField_a_of_type_Int;
  }
  
  public long d()
  {
    return b(a());
  }
  
  public ArrayList<ResultRecord> d()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Object localObject2 = c();
      ArrayList localArrayList2 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject2).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = String.valueOf(localGAudioFriends.jdField_a_of_type_Long);
        localArrayList2.add(localResultRecord);
      }
      return localArrayList2;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void d()
  {
    label539:
    label545:
    label548:
    label551:
    label554:
    for (;;)
    {
      try
      {
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        Object localObject2 = a();
        boolean bool = ((SessionInfo)localObject2).jdField_e_of_type_Boolean;
        i1 = 47;
        Object localObject3;
        Object localObject4;
        if (bool)
        {
          if (((SessionInfo)localObject2).h())
          {
            if ((((SessionInfo)localObject2).jdField_d_of_type_Int != 1) && (((SessionInfo)localObject2).jdField_d_of_type_Int != 2))
            {
              localObject3 = String.valueOf(((SessionInfo)localObject2).jdField_f_of_type_Long);
              localObject4 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
              localObject2 = ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString;
              Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
              localQAVNotification.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
              if (localBitmap == null) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.14(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
              }
              return;
            }
            if ((((SessionInfo)localObject2).jdField_H_of_type_Boolean) || (((SessionInfo)localObject2).jdField_y_of_type_Boolean)) {
              break label539;
            }
            i1 = 56;
          }
          else
          {
            if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
              break label545;
            }
            break label548;
          }
        }
        else
        {
          if (((SessionInfo)localObject2).j())
          {
            if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
              break label545;
            }
            break label548;
          }
          if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
            break label551;
          }
          i1 = 46;
          break label554;
        }
        if ((((SessionInfo)localObject2).jdField_d_of_type_Int != 3) && (((SessionInfo)localObject2).jdField_d_of_type_Int != 4))
        {
          if (((SessionInfo)localObject2).jdField_d_of_type_JavaLangString == null) {
            ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_k_of_type_Int, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString);
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_k_of_type_Int, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString, true, true);
          localQAVNotification.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((SessionInfo)localObject2).jdField_k_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_Int);
        }
        else if (((SessionInfo)localObject2).jdField_y_of_type_Boolean)
        {
          localObject3 = ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString;
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, null, true, true);
          localQAVNotification.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((SessionInfo)localObject2).jdField_f_of_type_Long), 48, 0, ((SessionInfo)localObject2).jdField_d_of_type_Int);
        }
        else
        {
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(a().jdField_k_of_type_Int, String.valueOf(a().jdField_f_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_k_of_type_Int, String.valueOf(((SessionInfo)localObject2).jdField_f_of_type_Long), null, true, true);
          if (localObject4 != null) {
            localQAVNotification.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((SessionInfo)localObject2).jdField_f_of_type_Long), 44, ((SessionInfo)localObject2).jdField_k_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_Int);
          } else {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.15(this), 1000L);
          }
        }
        t();
        return;
      }
      finally {}
      int i1 = 55;
      continue;
      i1 = 42;
      continue;
      i1 = 41;
    }
  }
  
  public void d(int paramInt)
  {
    long l1 = AudioHelper.b();
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("exitProcess, reason[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    int i1 = paramInt;
    if (paramInt < 200) {
      i1 = paramInt + 200;
    }
    if (TraeHelper.a() != null) {
      TraeHelper.a().a(l1);
    }
    localObject1 = this.jdField_a_of_type_AndroidViewOrientationEventListener;
    if (localObject1 != null) {
      ((OrientationEventListener)localObject1).disable();
    }
    localObject1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((QAVNotification)localObject1).a();
    }
    catch (Exception localException)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception msg = ");
      localStringBuilder.append(localException.getMessage());
      AVLog.printErrorLog((String)localObject2, localStringBuilder.toString());
    }
    Intent localIntent = new Intent("tencent.video.destroyService");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1, i1);
  }
  
  public void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteUser --> Count = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , firstName = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramInt > 0) && (paramString != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(409), Integer.valueOf(paramInt), paramString });
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public void d(String paramString, int paramInt)
  {
    ClientLogReport.sGatewayIP = paramString;
    ClientLogReport.sGatewayPort = paramInt;
    try
    {
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveGatewayMsg(paramString, paramInt);
      SharedPreUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(VideoConstants.h, paramString).apply();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      AVCoreLog.e(jdField_a_of_type_JavaLangString, "saveGateWayMsg fail.", paramString);
    }
  }
  
  void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean d()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("initVcController mVcCtrl=%s", new Object[] { this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl }));
    try
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
      {
        Object localObject1 = String.valueOf(AppSetting.a());
        int i1 = c();
        String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (!TextUtils.isEmpty(str1))
        {
          VcControllerImpl localVcControllerImpl = new VcControllerImpl(a(), (String)localObject1, this.jdField_a_of_type_ComTencentAvQavChannelProxy, this);
          ClientLogReport.instance().setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          long l1 = CharacterUtil.a(str1);
          Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = QQDeviceInfo.getIMEI("62ad83");
          int i2 = CUKingCardUtils.a(str1);
          String str3 = DeviceInfoUtil.b();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(str3);
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(i2);
          localObject3 = ((StringBuilder)localObject3).toString();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(Build.HARDWARE);
          ((StringBuilder)localObject4).append("_");
          ((StringBuilder)localObject4).append(VcSystemInfo.getCpuModel());
          localObject4 = ((StringBuilder)localObject4).toString();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(i2), localObject3, localObject4 }));
          }
          str3 = ResMgr.a();
          String str4 = ResMgr.b();
          String str5 = QavSdkConfigHelper.a();
          localVcControllerImpl.init(a(), l1, "8.7.0", Build.MODEL, (String)localObject1, (String)localObject2, AppSetting.d(), str2, VcSystemInfo.getDeviceName(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, VcSystemInfo.getCPUName(), i1, (String)localObject3, new SDKConfigInfoBuilder().a(), QAVConfigUtils.a(l1), QAVConfigUtils.b(l1), (String)localObject4, str3, str4, str5);
          localVcControllerImpl.updateProcessInfo(0L, "manufacturer", Build.MANUFACTURER);
          localObject1 = localVcControllerImpl.postData(5L, null);
          if (localObject1 == null) {
            localObject1 = "";
          } else {
            localObject1 = new String((byte[])localObject1);
          }
          PerfReporter.a(a(), str1, "8.7.0");
          str1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initVcController, SDK BuildNum[");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("]");
          QLog.w(str1, 1, ((StringBuilder)localObject2).toString());
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = localVcControllerImpl;
        }
        else
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController selfUin invalid.");
          AVSoUtils.b();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController fail.", localThrowable);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
      AVSoUtils.b();
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public void dataTransferred(int paramInt, long paramLong) {}
  
  public int e()
  {
    return this.jdField_p_of_type_Int;
  }
  
  public long e()
  {
    if ((a().jdField_d_of_type_Int != 3) && (a().jdField_d_of_type_Int != 4)) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEnterRoomTime();
  }
  
  public ArrayList<VideoController.GAudioFriends> e()
  {
    if ((AudioHelper.a()) && (QavTestUtil.sGAudioVirtualList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(QavTestUtil.sGAudioVirtualList);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void e()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null)
    {
      this.jdField_d_of_type_JavaLangRunnable = new VideoController.17(this);
      VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if ((localVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
        localVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 20000L);
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void e(int paramInt, String paramString)
  {
    if ((a().jdField_d_of_type_Int != 4) && (a().jdField_d_of_type_Int != 2)) {
      return;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl != null) {
      localQQGAudioCtrl.lockVideoMaxQP(paramInt, paramString);
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public void e(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean e()
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Int == 2) || ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Int == 0) && ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Int == 2))))) {
      bool = true;
    } else {
      bool = false;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckIsDoubleReceiveInviting ret=");
    localStringBuilder.append(bool);
    QLog.d(str, 1, localStringBuilder.toString());
    return bool;
  }
  
  public int f()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (localQQGAudioCtrl != null) {
        return localQQGAudioCtrl.getNetLevel();
      }
    }
    return -1;
  }
  
  public long f()
  {
    int i1 = a().jdField_d_of_type_Int;
    if ((i1 != 1) && (i1 != 2))
    {
      if ((i1 != 3) && (i1 != 4)) {
        return 0L;
      }
      return d();
    }
    return c();
  }
  
  public ArrayList<Long> f()
  {
    ArrayList localArrayList = new ArrayList();
    if (a() == null) {
      return localArrayList;
    }
    Iterator localIterator = a().jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Long)localIterator.next());
    }
    localIterator = c().iterator();
    while (localIterator.hasNext())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if ((localGAudioFriends.jdField_d_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  void f()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new VideoController.18(this);
    }
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if ((localVideoAppInterface != null) && (this.jdField_e_of_type_JavaLangRunnable != null)) {
      localVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
    }
  }
  
  public void f(int paramInt)
  {
    if (a().jdField_c_of_type_JavaLangString == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNetStatus <--receiveEcho peerUin = null, return!");
      return;
    }
    long l1;
    Object localObject;
    try
    {
      l1 = Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue();
    }
    catch (Exception localException)
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNetStatus Long.valueOf(peerUin) Exception= ");
      localStringBuilder.append(localException.getMessage());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      l1 = 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (l1 > 0L))
    {
      String str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNetStatus <--receiveEcho netStatus = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateNetworkTestResult(l1, paramInt);
    }
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void f(boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectMemberActivityIsResume, IsResume[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mSelectMemberActivityIsResume[");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_i_of_type_Int += 1;
      return;
    }
    this.jdField_i_of_type_Int -= 1;
    if (this.jdField_i_of_type_Int < 0) {
      this.jdField_i_of_type_Int = 0;
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public int g()
  {
    if (this.jdField_o_of_type_Int <= 0)
    {
      QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      if (localQQGAudioCtrl != null) {
        this.jdField_o_of_type_Int = localQQGAudioCtrl.getVideoAbilityLevel();
      }
    }
    return this.jdField_o_of_type_Int;
  }
  
  public long g()
  {
    VcControllerImpl localVcControllerImpl = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.getOnPeerFrameRenderEndFunctionPtr();
    }
    return 0L;
  }
  
  void g()
  {
    long l1 = AudioHelper.b();
    if (this.jdField_f_of_type_JavaLangRunnable == null)
    {
      this.jdField_f_of_type_JavaLangRunnable = new VideoController.19(this, l1);
      VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if ((localVideoAppInterface != null) && (this.jdField_f_of_type_JavaLangRunnable != null)) {
        localVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 15000L);
      }
    }
  }
  
  public void g(int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeVideo timeout. force to exitProcess. closeReason = ");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
    d(261);
  }
  
  public void g(String paramString)
  {
    long l1 = a(paramString);
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send0x211C2CMsg_Audio_start roomId = ");
    localStringBuilder.append(l1);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AudioEngineReady");
      ((Intent)localObject).putExtra("peerUin", paramString);
      ((Intent)localObject).putExtra("roomId", l1);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(36) });
    }
  }
  
  public void g(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = jdField_k_of_type_Int;
    } else {
      i1 = jdField_l_of_type_Int;
    }
    if (this.jdField_m_of_type_Int != i1)
    {
      this.jdField_m_of_type_Int = i1;
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLoadPTuSo, bloadSuc[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public boolean g()
  {
    int i1 = a().jdField_k_of_type_Int;
    boolean bool2;
    Object localObject2;
    Object localObject1;
    if ((i1 != 21) && (i1 != 22))
    {
      if (i1 == 26) {
        return false;
      }
      i1 = a().jdField_e_of_type_Int;
      bool2 = true;
      bool1 = bool2;
      if (i1 == 1)
      {
        localObject2 = a().jdField_c_of_type_JavaLangString;
        localObject1 = localObject2;
        if (a().jdField_k_of_type_Int == 1006)
        {
          localObject1 = localObject2;
          if (!a().jdField_e_of_type_Boolean)
          {
            localObject1 = localObject2;
            if (a().jdField_e_of_type_JavaLangString != null) {
              localObject1 = a().jdField_e_of_type_JavaLangString;
            }
          }
        }
      }
    }
    try
    {
      long l1 = CharacterUtil.a((String)localObject1);
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.hasAVShiftAbility(l1);
      if (i1 == -1) {
        break label185;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      label137:
      StringBuilder localStringBuilder;
      label185:
      int i2;
      label313:
      break label137;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not get Number. PeerUin = ");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    boolean bool1 = false;
    if (!bool1)
    {
      i1 = b((String)localObject1);
      i2 = c((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("canAVShift peerTerminalType: ");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(", peerSharpVersion: ");
        ((StringBuilder)localObject2).append(i2);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (i2 >= 16)
      {
        bool1 = bool2;
        if (i1 == 4) {
          break label313;
        }
        bool1 = bool2;
        if (i1 == 2) {
          break label313;
        }
        if (i1 == 3) {
          return true;
        }
      }
      return (i1 == 5) && (i2 >= 5437);
    }
    return bool1;
    return false;
  }
  
  public int getAPAndGateWayIP()
  {
    return c();
  }
  
  public long getMSFInviteMessageTimeStamp(long paramLong)
  {
    long l1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).longValue();
    } else {
      l1 = 0L;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("getMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
    return l1;
  }
  
  public int h()
  {
    if ((!a().j()) && (!this.jdField_d_of_type_Boolean)) {
      return 255;
    }
    return 0;
  }
  
  void h()
  {
    GraphicRenderMgr.getInstance().clearDecoderPtrRef();
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl != null) {
      localQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
    }
  }
  
  public void h(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.upgradeInvite");
    localIntent.putExtra("peerUin", paramString);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void h(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).b(paramBoolean);
      }
    }
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int i()
  {
    return this.jdField_m_of_type_Int;
  }
  
  void i()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestAudioFoucs");
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new VideoController.22(this);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null) {
      try
      {
        int i1 = ((AudioManager)localObject).requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
        if ((i1 != 1) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("request audio focus fail. ");
          ((StringBuilder)localObject).append(i1);
          QLog.d("AudioManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestAudioFocus e = ");
          localStringBuilder.append(localException);
          QLog.e(str, 2, localStringBuilder.toString());
        }
      }
    }
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetQCallNickName nickName : ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void i(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).c(paramBoolean);
      }
    }
  }
  
  public boolean i()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int isOfflineSession(String paramString)
  {
    paramString = a();
    if ((paramString != null) && (paramString.jdField_b_of_type_Boolean)) {
      return 1;
    }
    return 0;
  }
  
  void j()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "abandonAudioFocus");
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager != null)
    {
      localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
    }
  }
  
  public void j(String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(VideoNodeManager.c());
    paramString.append("");
    a("deviceMemory", paramString.toString());
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
  
  public void j(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).d(paramBoolean);
      }
    }
  }
  
  public boolean j()
  {
    int i1;
    boolean bool1;
    boolean bool2;
    label254:
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      long l2 = System.currentTimeMillis();
      i1 = 0;
      bool1 = false;
      if (i1 < i2)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (localGAudioFriends == null)
        {
          bool2 = bool1;
          break label254;
        }
        bool2 = bool1;
        if (!localGAudioFriends.jdField_g_of_type_Boolean) {
          break label254;
        }
        long l3 = localGAudioFriends.jdField_d_of_type_Long;
        long l1 = 2000L;
        if ((l3 >= 2000L) && (localGAudioFriends.jdField_d_of_type_Long < this.jdField_b_of_type_Long)) {
          l1 = localGAudioFriends.jdField_d_of_type_Long;
        } else if (this.jdField_b_of_type_Long >= 2000L) {
          l1 = this.jdField_b_of_type_Long;
        }
        bool2 = bool1;
        if (l2 - localGAudioFriends.jdField_c_of_type_Long <= l1) {
          break label254;
        }
        localGAudioFriends.jdField_g_of_type_Boolean = false;
        localGAudioFriends.jdField_c_of_type_Long = l2;
        if (QLog.isColorLevel())
        {
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshUserNoiseState : has valid state uin = ");
          localStringBuilder.append(localGAudioFriends.jdField_a_of_type_Long);
          localStringBuilder.append(",isSuspectNoisy = ");
          localStringBuilder.append(localGAudioFriends.jdField_g_of_type_Boolean);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      else
      {
        return bool1;
      }
    }
  }
  
  void k()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null) {
      localVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 25000L);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "startConnectingTimer");
    }
  }
  
  public void k(String paramString)
  {
    InviteUIChecker localInviteUIChecker = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
    if (localInviteUIChecker != null) {
      localInviteUIChecker.b(paramString);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).e(paramBoolean);
      }
    }
  }
  
  public boolean k()
  {
    ??? = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    boolean bool = false;
    if (??? == null) {
      return false;
    }
    int i2;
    int i1;
    label166:
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      i1 = 0;
      if (i1 < i2)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if ((localGAudioFriends != null) && (localGAudioFriends.jdField_g_of_type_Boolean)) {
          if (l1 == localGAudioFriends.jdField_a_of_type_Long)
          {
            int i3 = e();
            a("setSuspectNoisyUserMicOff", this.jdField_a_of_type_Long, false, true, -1);
            a(-1L, i3, e());
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(localGAudioFriends.jdField_a_of_type_Long, true);
            break label166;
            return bool;
          }
        }
      }
    }
  }
  
  void l()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null) {
      localVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "stopConnectingTimer");
    }
  }
  
  public void l(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
    if (localObject != null) {
      ((VcControllerImpl)localObject).setupDeviceInfos(paramString);
    }
    localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localObject != null) {
      ((QQGAudioCtrl)localObject).setAndroidPath(paramString);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).f(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (a().jdField_E_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
      } else if ((a().jdField_E_of_type_Int == 1) && (a().jdField_j_of_type_Int == 10)) {
        ReportController.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
      }
      int i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goOnstage, ret[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      return i1 != 0;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    }
    return false;
  }
  
  public void m()
  {
    boolean bool = VcSystemInfo.isSupportSharpAudio();
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("initGAudioCtrl isSupportSharpAudio=%s mGAudioCtrl=%s ", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl }));
    if (!bool) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          int i1 = c();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetChannel(this.jdField_a_of_type_ComTencentAvQavChannelProxy);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setCallback(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppId(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
          if (!TextUtils.isEmpty(ClientLogReport.sGatewayIP)) {
            this.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveGatewayMsg(ClientLogReport.sGatewayIP, ClientLogReport.sGatewayPort);
          }
          GAClientLogReport.instance();
          return;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initGAudioCtrl create instance fail.");
        d(1014);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "initGAudioCtrl fail.", localThrowable);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      d(1014);
    }
  }
  
  public void m(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).a();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).g(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
  }
  
  public void n()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      a(this.jdField_b_of_type_Int, l1, 50);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callBackNetStatus <--receiveEcho Cost = ");
      localStringBuilder.append(l1);
      QLog.d(str, 1, localStringBuilder.toString());
      if (l1 < 3000L) {
        f(1);
      } else {
        f(2);
      }
    }
    else
    {
      f(4);
    }
    this.jdField_d_of_type_Long = -1L;
  }
  
  public boolean n()
  {
    return this.s;
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(307) });
  }
  
  public boolean o()
  {
    if (AudioHelper.b())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return this.jdField_i_of_type_Int > 0;
  }
  
  public void onAVShiftEvent(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr != null) && (a() != null))
    {
      if (a().jdField_c_of_type_JavaLangString == null) {
        return;
      }
      if (!a().jdField_c_of_type_JavaLangString.equals(paramString)) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "remote confirm switch to video");
          }
          a().jdField_H_of_type_Boolean = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAVShiftEvent remote switch to video mode,waiting for confirm");
        }
        a().jdField_H_of_type_Boolean = false;
      }
    }
  }
  
  public void onAcceptVideoMode(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAcceptVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void onAcceptedVideo(String paramString)
  {
    a().a("onAcceptedVideo", 3);
  }
  
  public void onAnotherHaveAccept(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnotherHaveAccept fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    l(true);
    a(paramString, 206);
    b(206);
    b(paramString, 7);
  }
  
  public void onAnotherHaveReject(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnotherHaveReject fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    a(paramString, 207);
    b(207);
    b(paramString, 7);
  }
  
  public void onAnotherIsRing(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramString = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnotherIsRing isCalling = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    a().I = paramBoolean;
    if (paramBoolean) {
      DataReport.o(this);
    }
    if (PhoneStatusTools.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      return;
    }
    a(false, paramBoolean);
  }
  
  public void onAudioVolumeChange(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfAudioVolumeChange dooubleAV.value:=");
      localStringBuilder.append(paramLong1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20002), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void onAvReqAutoAccept(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAvReqAutoAccept, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).post(new VideoController.25(this, paramString));
    }
  }
  
  public void onCancelRequest(String paramString)
  {
    l();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onCancelRequest: fromUin = ");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    b(paramString, 10);
  }
  
  public void onCancelVideoMode(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void onChangePreviewSize(int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    boolean bool = AndroidCamera.a();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangePreviewSize, size[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], localHasVideo[");
    localStringBuilder.append(a().jdField_j_of_type_Boolean);
    localStringBuilder.append("], preSize[");
    localStringBuilder.append(AndroidCamera.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append(AndroidCamera.jdField_b_of_type_Int);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], forbiddenReopenCamera[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (bool) {
      return;
    }
    if (a().jdField_j_of_type_Boolean)
    {
      int i2;
      int i1;
      if (paramInt1 >= 640)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (paramInt2 >= 480) {}
      }
      else
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onChangePreviewSize, size[");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("], use min previewSize[640,480]");
        QLog.w(str, 1, localStringBuilder.toString());
        i2 = 640;
        i1 = 480;
      }
      if ((AndroidCamera.jdField_a_of_type_Int != i2) || (AndroidCamera.jdField_b_of_type_Int != i1)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(i2), Integer.valueOf(i1), Long.valueOf(l1) });
      }
    }
  }
  
  public void onChannelReady(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onChannelReady, fromUin[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("], mStartRing[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    Object localObject1 = a();
    int i2 = ((SessionInfo)localObject1).jdField_E_of_type_Int;
    int i1;
    if ((i2 != 1) && (i2 != 2) && (i2 != 0))
    {
      i1 = i2;
      if (i2 != 100) {}
    }
    else
    {
      i1 = 3;
    }
    if (a("onChannelReady", false, i1, paramString1)) {
      localObject1 = a();
    }
    ((SessionInfo)localObject1).x = paramInt1;
    ((SessionInfo)localObject1).jdField_y_of_type_Int = paramInt2;
    ((SessionInfo)localObject1).jdField_m_of_type_JavaLangString = paramString2;
    Object localObject2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelReady, fromUin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], hdModeFreeUseStartTime[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], hdModeFreeUseEndTime[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], hdModeFreeUseTips[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], roomId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], session[");
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    VideoNodeManager.a(30);
    VideoNodeManager.a(9, ((SessionInfo)localObject1).b());
    VideoNodeManager.a(11, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
      this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
    }
    SignalStrengthReport.a(a()).a();
    if (1L == ((SessionInfo)localObject1).jdField_c_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
      if ((((SessionInfo)localObject1).jdField_H_of_type_Boolean) && (((SessionInfo)localObject1).jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      }
      a(true, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
    if (((SessionInfo)localObject1).jdField_k_of_type_Int != 1011) {
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
    }
    ((SessionInfo)localObject1).c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
    ((SessionInfo)localObject1).d(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
    ((SessionInfo)localObject1).c(paramLong);
    l();
    ((SessionInfo)localObject1).jdField_h_of_type_Int = ((SessionInfo)localObject1).jdField_f_of_type_Int;
    ((SessionInfo)localObject1).a("onChannelReady", 4);
    ((SessionInfo)localObject1).a(l1, SystemClock.elapsedRealtime());
    if (((SessionInfo)localObject1).jdField_e_of_type_Boolean) {
      if (((SessionInfo)localObject1).jdField_H_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      } else if (!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a()) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      }
    }
    paramString2 = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if (((SessionInfo)localObject1).jdField_e_of_type_Boolean) {
      paramInt1 = 11;
    } else {
      paramInt1 = 4;
    }
    paramString2.a(((SessionInfo)localObject1).b(), paramInt1, 1L);
    paramString2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if ((paramString2 != null) && (paramString2.a() > 0)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
    }
    d();
    if (((SessionInfo)localObject1).jdField_g_of_type_Boolean) {
      a(true, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    } else {
      a(false, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l1), 50L);
    a(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_d_of_type_Int, true, true, true);
    DataReport.i(this);
    DataReport.c(this, true);
    DataReport.b(this, true);
    paramLong = f();
    paramString2 = SharedPreUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString2.edit().putLong("qav_roomid", paramLong).commit();
    paramLong = c(paramString1);
    paramString2.edit().putLong(VideoConstants.jdField_g_of_type_JavaLangString, paramLong).commit();
    l(false);
    paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramString1 != null) {
      paramString1.a();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.a();
    }
    paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramString1 != null) {
      paramString1.a((SessionInfo)localObject1);
    }
    paramString1 = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    if (paramString1 != null) {
      paramString1.a((SessionInfo)localObject1);
    }
  }
  
  public void onCheckScreenShareAvailable(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckScreenShareValid, isValid[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], detail[");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(521), Integer.valueOf(paramInt), paramArrayOfByte });
  }
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.b(paramString);
    Object localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onCloseVideo, fromUin[");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("], reason[");
    ((StringBuilder)localObject3).append(paramInt);
    ((StringBuilder)localObject3).append("], extraParam[");
    ((StringBuilder)localObject3).append(paramLong);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l1);
    ((StringBuilder)localObject3).append("], Main[");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvSessionMgr.a());
    ((StringBuilder)localObject3).append("], come[");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append("]");
    localObject3 = ((StringBuilder)localObject3).toString();
    int i1 = 1;
    QLog.w((String)localObject2, 1, (String)localObject3);
    if (localObject1 == null)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCloseVideo, fromUin[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], no session");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject2 != null) {
      ((VideoRecoveryMonitor)localObject2).a(paramInt);
    }
    localObject2 = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16);
    localObject3 = ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString;
    int i2 = 3;
    ((WTogetherMng)localObject2).a(3, (String)localObject3);
    k(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt != 14)
                {
                  if (paramInt == 15) {
                    break label521;
                  }
                  if (paramInt == 28) {}
                }
                else
                {
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      i1 = 5;
                      break;
                    case 21: 
                      if (paramLong == 62L)
                      {
                        ((SessionInfo)localObject1).jdField_r_of_type_Boolean = false;
                        a(l1, paramString, 12);
                        return;
                      }
                      if (paramLong == 61L)
                      {
                        ((SessionInfo)localObject1).jdField_r_of_type_Boolean = false;
                        a(l1, paramString, 25);
                        return;
                      }
                      i1 = 64;
                      break;
                    case 20: 
                      i1 = 21;
                      break;
                    case 19: 
                      i1 = 39;
                      break;
                    case 18: 
                      i1 = 10;
                    }
                    break;
                  case 12: 
                    i1 = 9;
                    break;
                  case 11: 
                    i1 = 29;
                    break;
                  case 10: 
                    i1 = 28;
                    break;
                  case 8: 
                  case 9: 
                    a(l1, paramString, 12);
                    return;
                  }
                }
                i1 = 62;
                a(l1, paramString, 62);
                break label1120;
                label521:
                i1 = 35;
              }
              else
              {
                a(l1, paramString, 25);
              }
            }
            else {
              i1 = 4;
            }
          }
        }
        else
        {
          if (paramLong == 100L)
          {
            localObject2 = SessionMgr.a(3, paramString, new int[0]);
            localObject1 = null;
            if (this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject2)) {
              localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject2);
            }
            if ((localObject1 != null) && (((SessionInfo)localObject1).jdField_f_of_type_Int == 1))
            {
              paramString = jdField_a_of_type_JavaLangString;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onCloseVideo, set autoAcceptChat, seq[");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append("]");
              QLog.w(paramString, 1, ((StringBuilder)localObject2).toString());
              ((SessionInfo)localObject1).jdField_c_of_type_Boolean = true;
              return;
            }
          }
          if (paramLong != 3L)
          {
            paramInt = i2;
            if (paramLong != 65535L) {}
          }
          else
          {
            paramInt = 42;
          }
          a(l1, paramString, paramInt);
        }
      }
      else
      {
        if (paramLong == 9L)
        {
          paramInt = 43;
        }
        else if (paramLong == 10L)
        {
          paramInt = 54;
        }
        else if (paramLong == 5L)
        {
          paramInt = 49;
        }
        else if ((paramLong != 12L) && (paramLong != 16L))
        {
          if (paramLong == 13L)
          {
            paramInt = 50;
          }
          else if (paramLong == 14L)
          {
            paramInt = 51;
            if (((SessionInfo)localObject1).jdField_d_of_type_Int == 2) {
              ReportController.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            } else {
              ReportController.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
            }
          }
          else if (paramLong == 15L)
          {
            paramInt = 55;
          }
          else if (paramLong == 17L)
          {
            paramInt = 56;
            ReportController.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
          }
          else if (paramLong == 6L)
          {
            paramInt = 72;
          }
          else if (paramLong == 7L)
          {
            paramInt = 24;
          }
          else if (paramLong == 983055L)
          {
            paramInt = 63;
          }
          else
          {
            paramInt = 2;
          }
        }
        else
        {
          a(((SessionInfo)localObject1).jdField_k_of_type_Int, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_h_of_type_Long, 0);
          paramInt = 52;
        }
        if ((paramLong == 12L) || (paramLong == 13L) || (paramLong == 15L) || (paramLong == 16L)) {
          if (((SessionInfo)localObject1).jdField_d_of_type_Int == 2) {
            ReportController.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
          }
        }
        if (paramInt == 49) {
          l(true);
        }
        a(l1, paramString, paramInt);
      }
    }
    else {
      i1 = 0;
    }
    label1120:
    b(paramString, i1);
  }
  
  public void onConfigSysDealDone(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfigSysDealDone fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCreateRoomSuc, relationType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], groupId[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], mGAudioCtrl[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("], mutiAvType[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    localObject1 = a();
    if (a("onCreateRoomSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject1 = a();
    }
    ((SessionInfo)localObject1).D = true;
    ((SessionInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.clear();
    if ((AVUtil.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
      I();
    }
    for (;;)
    {
      break;
      int i1;
      int i2;
      if (((SessionInfo)localObject1).jdField_W_of_type_Int == 5)
      {
        i1 = ((SessionInfo)localObject1).jdField_ac_of_type_Int;
        i2 = ((SessionInfo)localObject1).ab;
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCreateRoomSuc, double meeting, terminalType[");
          localStringBuilder.append(i1);
          localStringBuilder.append("], sdkVersion[");
          localStringBuilder.append(i2);
          localStringBuilder.append("]");
          QLog.i((String)localObject2, 2, localStringBuilder.toString());
        }
        long l2;
        if ((i1 != 2) && (i1 != 12) && ((i1 != 4) || (i2 < 114)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
          l2 = ((SessionInfo)localObject1).jdField_f_of_type_Long;
          i1 = ((SessionInfo)localObject1).jdField_W_of_type_Int;
          ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 4, i1, 0);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
          l2 = ((SessionInfo)localObject1).jdField_f_of_type_Long;
          i1 = ((SessionInfo)localObject1).jdField_W_of_type_Int;
          ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
      {
        i2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
        localObject2 = new long[i2];
        i1 = 0;
        while (i1 < i2)
        {
          localObject2[i1] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((SessionInfo)localObject1).jdField_W_of_type_Int, 0);
      }
      else
      {
        if (AudioHelper.a(19) == 1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          AudioHelper.a(HardCodeUtil.a(2131715870));
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((SessionInfo)localObject1).jdField_W_of_type_Int, 0);
        }
      }
    }
    a("onCreateRoomSuc");
    a("onCreateSuc", true, paramInt1, paramLong);
    ((SessionInfo)localObject1).ah = false;
    if (((SessionInfo)localObject1).jdField_y_of_type_Boolean)
    {
      ((SessionInfo)localObject1).e("onCreateRoomSuc", true);
      ((SessionInfo)localObject1).jdField_B_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc, MainSession[");
      localStringBuilder.append(a());
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong), Long.valueOf(l1) });
    if ((paramInt1 != 2) && (paramInt1 != 1)) {}
    do
    {
      do
      {
        break;
      } while ((paramInt2 != 10) && (paramInt2 != 1));
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    localObject2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InviteMemberList onCreateRoomSuc, request memberList]");
    localStringBuilder.append(0);
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    this.jdField_d_of_type_Int = 0;
    localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject2 != null) {
      ((ChatRoomMng)localObject2).a(a());
    }
    if ((((SessionInfo)localObject1).jdField_y_of_type_Boolean) || (((SessionInfo)localObject1).jdField_E_of_type_Int == 3))
    {
      localObject2 = a();
      if (localObject2 != null) {
        ((ScreenShareCtrl)localObject2).a((SessionInfo)localObject1);
      }
    }
  }
  
  public void onDetectAudioDataIssue(int paramInt)
  {
    long l1 = AudioHelper.b();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetectAudioDataIssue, issueType[");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt), Long.valueOf(l1) });
  }
  
  public void onDoubleVideoMeetingInvite(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    long l1 = AudioHelper.b();
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onDoubleVideoMeetingInvite, inviteUin[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], aliveSessionCount[");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append("], multiAVType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], multiSubType[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("], \nmainSession[");
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (a(paramLong, paramInt1, paramInt2))
    {
      a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
      return;
    }
    localObject1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, false);
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    boolean bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    if ((TextUtils.equals(a().jdField_c_of_type_JavaLangString, String.valueOf(paramLong))) && ((a().jdField_g_of_type_Int == 16) || (paramInt2 == 5)))
    {
      if (this.jdField_d_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        this.jdField_d_of_type_JavaLangRunnable = null;
      }
      localObject1 = a();
      if (localObject1 != null) {
        ((ScreenShareCtrl)localObject1).a(l1, paramLong, paramInt1, paramInt2);
      }
      return;
    }
    if ((TextUtils.equals(a().jdField_c_of_type_JavaLangString, String.valueOf(paramLong))) && (a().jdField_g_of_type_Int == 11))
    {
      if (this.jdField_d_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        this.jdField_d_of_type_JavaLangRunnable = null;
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
      b(a().jdField_c_of_type_JavaLangString, 2);
    }
    if (a().e())
    {
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) {}
    }
    else
    {
      for (;;)
      {
        bool1 = true;
        break label598;
        if ((!a().m()) && (!a().n()) && (!a().o()))
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
          }
          if (bool2) {
            a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          }
        }
        else
        {
          if (!String.valueOf(paramLong).equals(a().jdField_c_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
          k(true);
          a(a().jdField_c_of_type_JavaLangString, 299);
          b(299);
          b(a().jdField_c_of_type_JavaLangString, 2);
        }
      }
      if ((a().m()) || (a().n())) {
        break label1176;
      }
    }
    boolean bool1 = false;
    label598:
    this.jdField_a_of_type_Boolean = true;
    localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
    if (localObject2 != null)
    {
      ((SessionInfo)localObject2).jdField_H_of_type_Boolean = true;
      ((SessionInfo)localObject2).jdField_e_of_type_Int = 2;
      ((SessionInfo)localObject2).jdField_k_of_type_Int = 0;
      ((SessionInfo)localObject2).jdField_E_of_type_Int = 3;
      ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString = String.valueOf(paramLong);
      ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString = null;
      ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
      ((SessionInfo)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
      ((SessionInfo)localObject2).f("onDoubleVideoMeetingInvite", true);
      ((SessionInfo)localObject2).jdField_r_of_type_JavaLangString = String.valueOf(paramLong);
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
    {
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv double video meeting when phone is not idle:from uin=");
        localStringBuilder.append(paramLong);
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.video.v2q.CallingDialog");
      ((Intent)localObject2).putExtra("isAudio", true);
      ((Intent)localObject2).putExtra("friendUin", String.valueOf(paramLong));
      ((Intent)localObject2).putExtra("uinType", 0);
      ((Intent)localObject2).putExtra("type", 1);
      ((Intent)localObject2).putExtra("senderUin", paramLong);
      ((Intent)localObject2).putExtra("isSender", false);
      ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject2);
      localObject2 = (ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class);
      ((ITraeMediaPlayerApi)localObject2).init(this.jdField_a_of_type_AndroidContentContext, null);
      ((ITraeMediaPlayerApi)localObject2).playRing(l1, 0, 2131230741, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, (String)localObject1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDoubleVideoMeetingInvite, mOrientation[");
      localStringBuilder.append(this.jdField_n_of_type_Int);
      localStringBuilder.append("], isQQPaused[");
      localStringBuilder.append(VideoConstants.jdField_b_of_type_Boolean);
      localStringBuilder.append("], isVideoPaused[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      localStringBuilder.append("], isScreenLocked[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], isAppOnForeground[");
      localStringBuilder.append(GesturePWDUtils.isAppOnForegroundByTasks(a(), 0));
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    if ((this.w) && (this.jdField_n_of_type_Int == 0) && (!bool2) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.30(this, l1, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l1, (String)localObject1, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
    return;
    label1176:
    a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
  }
  
  public void onEnterSuc(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject1 = a();
    if (a("onEnterSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject1 = a();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("|VideoNodeManager");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterSuc, groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], relationType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], MainSession[");
    localStringBuilder.append(localObject1);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    a("onEnterSuc");
    ((SessionInfo)localObject1).ah = false;
    if (paramInt1 == 3)
    {
      ((SessionInfo)localObject1).a("onEnterSuc.1", 14);
      ((SessionInfo)localObject1).e("onEnterSuc", true);
      ((SessionInfo)localObject1).a(l1, SystemClock.elapsedRealtime());
    }
    else
    {
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject1 = SessionMgr.a().c((String)localObject1);
      if (localObject1 != null)
      {
        ((SessionInfo)localObject1).K = true;
        ((SessionInfo)localObject1).D = false;
        ((SessionInfo)localObject1).au = true;
      }
      if ((AVUtil.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        I();
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l1) });
    if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localObject1 != null) {
        ((MqqHandler)localObject1).post(new VideoController.41(this, paramInt1, paramInt2, paramLong));
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject1 != null) {
      ((ChatRoomMng)localObject1).a(a());
    }
  }
  
  public void onFpsChange(int paramInt)
  {
    if (paramInt >= 20) {
      paramInt = Math.min(30000, paramInt * 1000);
    } else {
      paramInt = 15000;
    }
    int i1 = a().jdField_V_of_type_Int;
    if ((i1 != paramInt) && (!Build.MODEL.equalsIgnoreCase("HWI-AL00")))
    {
      if (Build.MODEL.equalsIgnoreCase("VKY-AL00")) {
        return;
      }
      long l1 = AudioHelper.b();
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFpsChange, nFps[");
      localStringBuilder.append(i1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      a().jdField_V_of_type_Int = paramInt;
      CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).setCameraWithNewFps(l1, paramInt);
    }
  }
  
  public void onGAudioInvite(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = AudioHelper.b();
    AVLog.printDebugLog("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AudioHelper.a(localVideoAppInterface);
    c(false);
    Object localObject2 = a();
    long l2 = a(String.valueOf(paramLong2));
    long l3 = d();
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onGAudioInvite, friendUin[");
      ((StringBuilder)localObject3).append(paramLong2);
      ((StringBuilder)localObject3).append("], groupId[");
      ((StringBuilder)localObject3).append(paramLong1);
      ((StringBuilder)localObject3).append("], multiSubType[");
      ((StringBuilder)localObject3).append(paramInt3);
      ((StringBuilder)localObject3).append("], multiAVType[");
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append("], relationType[");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("], mGAudioInRoom[");
      ((StringBuilder)localObject3).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject3).append("], mGAudioGroupId[");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject3).append("], mCurrentInviteId[");
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject3).append("], mCurrentInviteRelationType[");
      ((StringBuilder)localObject3).append(this.jdField_h_of_type_Int);
      ((StringBuilder)localObject3).append("], offLineInvite[");
      ((StringBuilder)localObject3).append(paramBoolean);
      ((StringBuilder)localObject3).append("], roomId[");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append("], gRoomId[");
      ((StringBuilder)localObject3).append(l3);
      ((StringBuilder)localObject3).append("], seq[");
      ((StringBuilder)localObject3).append(l1);
      ((StringBuilder)localObject3).append("], main[");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append("], app[");
      if (localVideoAppInterface != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject3).append(paramBoolean);
      ((StringBuilder)localObject3).append("], original[");
      ((StringBuilder)localObject3).append(paramInt4);
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject3).toString());
    }
    if (localVideoAppInterface == null) {
      return;
    }
    if ((paramInt3 != 6) && (paramInt3 != 5) && (paramInt3 != 4) && (paramInt3 != 3)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    if (!QAVGroupConfig.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
      return;
    }
    String str2 = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str2))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str2, false);
    ((SessionInfo)localObject1).jdField_f_of_type_Long = paramLong1;
    ((SessionInfo)localObject1).jdField_E_of_type_Int = paramInt1;
    ((SessionInfo)localObject1).jdField_j_of_type_Int = paramInt2;
    ((SessionInfo)localObject1).X = false;
    ((SessionInfo)localObject1).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    ((SessionInfo)localObject1).jdField_W_of_type_Int = paramInt4;
    if (((SessionInfo)localObject1).jdField_W_of_type_Int == 4) {
      ScreenShareReportHelper.a(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, 2, "onGAudioInvite");
    }
    if (b(paramInt1, paramLong1, paramInt3))
    {
      a(l1, "too_much_session", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    VideoConstants.jdField_b_of_type_Boolean = localVideoAppInterface.a();
    if (!((SessionInfo)localObject2).e()) {}
    while (localVideoAppInterface.d())
    {
      paramBoolean = true;
      break;
    }
    paramBoolean = false;
    if (this.jdField_h_of_type_JavaLangRunnable != null)
    {
      if (localVideoAppInterface.a() != null) {
        localVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
      }
      this.jdField_h_of_type_JavaLangRunnable = null;
      ((SessionInfo)localObject1).a("onGAudioInvite.1", 0);
    }
    H();
    boolean bool = a(localVideoAppInterface.getApp().getApplicationContext());
    if (bool)
    {
      if ((((SessionInfo)localObject2).jdField_f_of_type_Int > 0) && (((SessionInfo)localObject2).jdField_f_of_type_Int <= 4) && (paramInt3 != 3))
      {
        a(l1, "ScreenLocked_before_connect", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if (7 == ((SessionInfo)localObject2).jdField_f_of_type_Int)
      {
        a(l1, "ScreenLocked_group_invite", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((SessionInfo)localObject2).jdField_f_of_type_Int != 14) && (((SessionInfo)localObject2).jdField_f_of_type_Int != 13))
      {
        if ((paramBoolean) && (paramInt3 != 3)) {
          a(l1, "ScreenLocked_session_exist", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        }
      }
      else
      {
        a(l1, "ScreenLocked_double_meeting", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
    }
    String str1 = "]";
    if (QLog.isColorLevel())
    {
      localObject3 = jdField_a_of_type_JavaLangString;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onGAudioInvite,  aSessionExists[");
      ((StringBuilder)localObject4).append(paramBoolean);
      ((StringBuilder)localObject4).append("], isScreenLocked[");
      ((StringBuilder)localObject4).append(bool);
      ((StringBuilder)localObject4).append("], \nmainSession[");
      ((StringBuilder)localObject4).append(localObject2);
      ((StringBuilder)localObject4).append("], \nsessionInfo[");
      ((StringBuilder)localObject4).append(localObject1);
      ((StringBuilder)localObject4).append(str1);
      QLog.w((String)localObject3, 1, ((StringBuilder)localObject4).toString());
    }
    if (((SessionInfo)localObject1).jdField_d_of_type_Int == 0)
    {
      ((SessionInfo)localObject1).jdField_e_of_type_Boolean = true;
      ((SessionInfo)localObject1).a(l1, "onGAudioInvite.1", 3);
      ((SessionInfo)localObject1).jdField_k_of_type_Int = UITools.c(paramInt1);
      ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(paramLong2);
      if (paramInt1 == 2) {
        ((SessionInfo)localObject1).jdField_r_of_type_JavaLangString = String.valueOf(paramLong2);
      }
      ((SessionInfo)localObject1).jdField_e_of_type_Boolean = true;
      if ((paramInt3 != 3) && (paramInt3 != 4)) {
        a(str2, ((SessionInfo)localObject1).jdField_d_of_type_Int, false, false, false);
      }
    }
    Object localObject3 = localObject1;
    localObject1 = localObject2;
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_h_of_type_Int = paramInt1;
    if (((SessionInfo)localObject3).jdField_f_of_type_Int == 0) {
      ((SessionInfo)localObject3).a("onGAudioInvite", 7);
    }
    Object localObject4 = "onGAudioInvite";
    localObject2 = localObject1;
    if (paramInt3 == 3)
    {
      if (((SessionInfo)localObject1).jdField_f_of_type_Long == 0L)
      {
        localObject2 = localObject1;
        bool = b((SessionInfo)localObject1, (SessionInfo)localObject3, l1, paramLong2, str2, paramInt1, paramLong1, paramArrayOfLong);
      }
      else
      {
        localObject2 = localObject1;
      }
    }
    else if (paramInt3 == 4) {
      bool = a((SessionInfo)localObject2, (SessionInfo)localObject3, l1, paramLong2, str2, paramInt1, paramLong1, paramArrayOfLong);
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioInvite multiSubType[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], hasDeal[");
      localStringBuilder.append(bool);
      localStringBuilder.append(str1);
      QLog.i((String)localObject1, 2, localStringBuilder.toString());
    }
    if (bool) {
      return;
    }
    if (localVideoAppInterface.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, phone is calling");
      }
      paramArrayOfLong = new Intent();
      paramArrayOfLong.setAction("tencent.video.v2q.CallingDialogMulti");
      paramArrayOfLong.setPackage(localVideoAppInterface.getApp().getPackageName());
      paramArrayOfLong.putExtra("friendUin", paramLong2);
      paramArrayOfLong.putExtra("sessionType", 3);
      if (paramInt1 == 1) {
        paramArrayOfLong.putExtra("uinType", 1);
      } else if (paramInt1 == 2) {
        paramArrayOfLong.putExtra("uinType", 3000);
      }
      paramArrayOfLong.putExtra("relationType", paramInt1);
      paramArrayOfLong.putExtra("extraUin", ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString);
      paramArrayOfLong.putExtra("relationId", paramLong1);
      paramArrayOfLong.putExtra("type", 13);
      paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("isSender", false);
      paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("realSenderUin", ((SessionInfo)localObject2).jdField_r_of_type_JavaLangString);
      localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
      a(l1, this.jdField_h_of_type_Int, paramLong1, true);
      paramArrayOfLong = (ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class);
      paramArrayOfLong.init(this.jdField_a_of_type_AndroidContentContext, null);
      paramArrayOfLong.playRing(l1, 0, 2131230741, null, null, false, 1, false, true, 0);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, str2);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramLong2);
    ((SessionInfo)localObject2).jdField_r_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    this.jdField_r_of_type_Boolean = c();
    if (((SessionInfo)localObject3).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfLong = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onGAudioInvite msg blocked [");
        ((StringBuilder)localObject1).append(((SessionInfo)localObject3).jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(str1);
        QLog.i(paramArrayOfLong, 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if ((!paramBoolean) && (!VideoUtils.a()) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      else
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        QAVGroupConfig.Report.d();
      }
      BaseGaInvite.a((Intent)localObject1, (String)localObject4);
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("uinType", UITools.c(paramInt1));
      ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
      ((Intent)localObject1).putExtra("friendUin", paramLong2);
      ((Intent)localObject1).putExtra("relationType", paramInt1);
      ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
      ((Intent)localObject1).putExtra("discussId", paramLong1);
      ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
      ((Intent)localObject1).putExtra("session_id", ((SessionInfo)localObject3).jdField_b_of_type_JavaLangString);
      if ((this.jdField_r_of_type_Boolean) && (SmallScreenUtils.d(localVideoAppInterface.getApplication().getApplicationContext())))
      {
        if ((!paramBoolean) && (!VideoUtils.a()))
        {
          paramArrayOfLong = new VideoInviteFloatBarUICtr(this, localVideoAppInterface, (Intent)localObject1);
          paramArrayOfLong.d();
          paramArrayOfLong.a(l1, (Intent)localObject1);
        }
        else
        {
          paramArrayOfLong = new MultiIncomingCallUICtr(this, localVideoAppInterface, (Intent)localObject1);
          paramArrayOfLong.d();
          paramArrayOfLong.a((Intent)localObject1);
        }
      }
      else {
        a((Intent)localObject1);
      }
    }
    if (localVideoAppInterface.jdField_b_of_type_Boolean) {
      localVideoAppInterface.jdField_b_of_type_Boolean = false;
    } else {
      VideoNodeManager.a();
    }
    localVideoAppInterface.jdField_c_of_type_Boolean = true;
  }
  
  public void onGAudioInviteResp(MavInviteData paramMavInviteData)
  {
    ArrayList localArrayList;
    if (paramMavInviteData == null) {
      localArrayList = null;
    } else {
      localArrayList = paramMavInviteData.inviteAccountList;
    }
    if (paramMavInviteData != null) {
      ScreenShareTipsHelper.a(paramMavInviteData.retCode, paramMavInviteData.tip);
    }
    int i1;
    if (QLog.isColorLevel())
    {
      paramMavInviteData = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioInviteResp, inviteAccountList[");
      boolean bool;
      if (localArrayList != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], size[");
      if (localArrayList == null) {
        i1 = 0;
      } else {
        i1 = localArrayList.size();
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w(paramMavInviteData, 1, localStringBuilder.toString());
    }
    if (localArrayList == null) {
      return;
    }
    if (a().jdField_a_of_type_JavaUtilArrayList != null)
    {
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        if ((((AVInviteAccount)localArrayList.get(i1)).accountType == 1) && (((AVInviteAccount)localArrayList.get(i1)).inviteType == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((AVInviteAccount)localArrayList.get(i1)).account)))) {
          a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((AVInviteAccount)localArrayList.get(i1)).account));
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(99) });
  }
  
  public void onGAudioKickOut(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioKickOut, Groupid[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], relationType[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    paramInt2 = UITools.c(paramInt1);
    if ((this.jdField_d_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.u = true;
      if (paramInt1 == 3)
      {
        paramInt1 = 7;
        a(a().jdField_b_of_type_JavaLangString, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      }
      else
      {
        paramInt1 = 20;
        a(a().jdField_b_of_type_JavaLangString, paramInt2, 20, false, String.valueOf(paramLong), null, false);
      }
      if (paramInt2 == 3000) {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
      } else if (paramInt2 == 1) {
        if (a().jdField_j_of_type_Int == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
      if (a().jdField_y_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      localObject = a();
      if ((localObject != null) && (((SessionInfo)localObject).jdField_j_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
    }
  }
  
  public void onGAudioMemAllUpdate(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
      localGAudioFriends.jdField_a_of_type_Long = ((AVUserInfo)paramArrayList.get(i1)).account;
      localGAudioFriends.jdField_d_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).accountType;
      this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
      if (((AVUserInfo)paramArrayList.get(i1)).accountType == 1) {
        ((ArrayList)localObject).add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).account));
      }
      i1 += 1;
    }
    if (((ArrayList)localObject).size() > 0) {
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.a((ArrayList)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGAudioMemAllUpdate, size[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append("]");
      QLog.i(paramArrayList, 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onGAudioMemAllUpdate(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Integer localInteger = Integer.valueOf(64);
    if (paramArrayOfLong == null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { localInteger, Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramInt2 = 0;
    Object localObject;
    while (paramInt2 < paramArrayOfLong.length)
    {
      localObject = new VideoController.GAudioFriends();
      ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramInt2 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfLong = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGAudioMemAllUpdate, size[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append("]");
      QLog.i(paramArrayOfLong, 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { localInteger, Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1) });
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGAudioMemberMicChanged, uin[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], mGAudioMute[");
        localStringBuilder.append(this.jdField_k_of_type_Boolean);
        localStringBuilder.append("], isMicOff[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], mIsMicOffBySelf[");
        localStringBuilder.append(this.t);
        localStringBuilder.append("]");
        QLog.w(str, 2, localStringBuilder.toString());
      }
      if ((paramBoolean != this.jdField_k_of_type_Boolean) && (!this.t))
      {
        int i1 = e();
        a("onGAudioMemberMicChanged", this.jdField_a_of_type_Long, paramBoolean ^ true, false, -1);
        a(-1L, i1, e());
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (bool)) {
      onGAudioUserAudioSuspectNoisy(0L, false, 0L);
    }
  }
  
  public void onGAudioMicSetByAdmin(long paramLong, int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioMicSetByAdmin, manager uin[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], old micAuthByAdmin[");
    localStringBuilder.append(a().jdField_G_of_type_Int);
    localStringBuilder.append("], new micAuthByAdmin[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mIsMicOffBySelf[");
    localStringBuilder.append(this.t);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    a().f("onGAudioMicSetByAdmin", paramInt);
    if (paramInt == 2) {
      return;
    }
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (paramInt != 0))
    {
      int i1 = e();
      long l1 = this.jdField_a_of_type_Long;
      boolean bool1;
      if (paramInt == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() == paramLong) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a("onGAudioMicSetByAdmin", l1, bool1, bool2, -1);
      a(-1L, i1, e());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  public void onGAudioRoomDestroy(int paramInt, long paramLong)
  {
    String str = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str)) {
      localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    }
    long l1 = AudioHelper.b();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioRoomDestroy, relationType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], sessionId[");
      localStringBuilder.append(str);
      localStringBuilder.append("], \nsession[");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    ScreenShareReportHelper.b(str, "onGAudioRoomDestroy");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    if (localObject2 != null) {
      ((TraeHelper)localObject2).b(l1);
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    TraeHelper.a().b();
    if ((AudioHelper.b()) || (((SessionInfo)localObject1).ah))
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioRoomDestroy, \nmainsession[");
      localStringBuilder.append(a());
      localStringBuilder.append("], \nstate[");
      localStringBuilder.append(((SessionInfo)localObject1).jdField_f_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], isAcceptingMultiAV[");
      localStringBuilder.append(((SessionInfo)localObject1).ah);
      localStringBuilder.append("], isCurJoinedGRoom[");
      localStringBuilder.append(a(paramInt, paramLong));
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    if (((SessionInfo)localObject1).ah) {
      return;
    }
    if (this.jdField_c_of_type_Long == paramLong)
    {
      this.jdField_c_of_type_Long = 0L;
      this.jdField_h_of_type_Int = 0;
    }
    if ((paramInt == 3) && (((SessionInfo)localObject1).jdField_y_of_type_Boolean) && ((((SessionInfo)localObject1).jdField_c_of_type_JavaLangString == null) || (paramLong != Long.valueOf(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString).longValue())))
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = ");
        ((StringBuilder)localObject2).append(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" ,relationId = ");
        ((StringBuilder)localObject2).append(paramLong);
        QLog.d(str, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if ((!((SessionInfo)localObject1).X) && (!((SessionInfo)localObject1).jdField_y_of_type_Boolean))
    {
      int i1;
      if (((SessionInfo)localObject1).jdField_f_of_type_Int == 7) {
        i1 = 5;
      } else {
        i1 = 6;
      }
      a("onGAudioRoomDestroy", str, UITools.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((SessionInfo)localObject1).jdField_r_of_type_JavaLangString, false, false);
    }
    if (a(paramInt, paramLong)) {
      a(paramInt, paramLong, 69);
    }
    ((SessionInfo)localObject1).a("onGAudioRoomDestroy", 0);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str))
    {
      if (paramInt == 3)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
        paramInt = UITools.c(paramInt);
        a(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, str))
      {
        localObject1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
        {
          ((QAVNotification)localObject1).a(str);
          d();
        }
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    s();
  }
  
  public void onGAudioRoomMicModeChanged(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if ((paramBoolean2) && (a().jdField_G_of_type_Int != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioRoomMicModeChanged, manager uin[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], old isRoomMicOff[");
    localStringBuilder.append(a().jdField_M_of_type_Boolean);
    localStringBuilder.append("], new isRoomMicOff[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], mIsMicOffBySelf[");
    localStringBuilder.append(this.t);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], micAuthByAdmin[");
    localStringBuilder.append(a().jdField_G_of_type_Int);
    localStringBuilder.append("], isCreateRoomOrEnterRoom[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], bNeedUpdateMic[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    a().c("onGAudioRoomMicModeChanged", paramBoolean1);
    if ((bool) && (!this.t) && ((paramLong != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
    {
      int i1 = e();
      a("onGAudioRoomMicModeChanged", this.jdField_a_of_type_Long, paramBoolean1 ^ true, false, -1);
      a(-1L, i1, e());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void onGAudioSetMicFailed(int paramInt, ArrayList<AVUserInfo> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      AVUserInfo localAVUserInfo = (AVUserInfo)paramArrayList.get(i1);
      a(localAVUserInfo.account, localAVUserInfo.accountType, localAVUserInfo.pstnStatus, false);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void onGAudioTerminalEnterRoom(int paramInt, long paramLong, int... paramVarArgs)
  {
    Object localObject = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    paramVarArgs = (int[])localObject;
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject))
    {
      paramVarArgs = (int[])localObject;
      if (paramInt == 3) {
        paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioTerminalEnterRoom begin, sessionId[");
      localStringBuilder.append(paramVarArgs);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], \nsession[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((localObject != null) && ((((SessionInfo)localObject).jdField_f_of_type_Int == 7) || (((SessionInfo)localObject).jdField_f_of_type_Int == 2)))
    {
      ((SessionInfo)localObject).a("onGAudioTerminalEnterRoom", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs))
      {
        localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
        int i1 = UITools.c(paramInt);
        if (paramInt == 3) {
          a(((SessionInfo)localObject).jdField_b_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        } else if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, ((SessionInfo)localObject).jdField_r_of_type_JavaLangString, true, false);
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, paramVarArgs);
      }
    }
  }
  
  public void onGAudioUserAudioSuspectNoisy(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArrayList localArrayList = a(paramLong1, paramBoolean, paramLong2);
    if (localArrayList != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(142), localArrayList, Integer.valueOf(localArrayList.size()) });
    }
    if (paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
    {
      if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      ReportController.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
    }
  }
  
  public void onGVideoDownloadChannelCtlChanged(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGVideoDownloadChannelCtlChanged start");
    }
    if (paramArrayOfByte != null)
    {
      qav_gvideo_sdk_transfer.gVideoDownChannelControl localgVideoDownChannelControl = new qav_gvideo_sdk_transfer.gVideoDownChannelControl();
      int i1 = 0;
      boolean bool;
      try
      {
        localgVideoDownChannelControl.mergeFrom(paramArrayOfByte);
        localgVideoDownChannelControl.uint32_switch.get();
        bool = a(localgVideoDownChannelControl);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        bool = false;
      }
      if (bool)
      {
        if (a().jdField_L_of_type_Int == 3) {
          i1 = 1;
        }
        if (i1 != 0) {
          a(true);
        }
      }
    }
  }
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    a().a(l1, "onGaGoOffStageResult", false, false);
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null)
    {
      long l2 = Long.valueOf(localVideoAppInterface.getCurrentAccountUin()).longValue();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
  }
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = a();
    if (paramInt2 == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    } else {
      str = SessionMgr.a(paramInt2, String.valueOf(paramLong2), new int[0]);
    }
    boolean bool = TextUtils.equals(localSessionInfo.jdField_b_of_type_JavaLangString, str);
    if ((bool) && (!QLog.isDevelopLevel())) {
      break label216;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGaGoOnStageResult, result[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], info[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], groupId[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], relationType[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], main[");
    localStringBuilder.append(localSessionInfo.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    label216:
    if (!bool) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (paramInt1 == 90)
    {
      if (paramLong1 == 3L)
      {
        a().a(l1, "onGaGoOnStageResult.1", true, false);
      }
      else
      {
        a().a(l1, "onGaGoOnStageResult.2", false, false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
    }
    else
    {
      a().a(l1, "onGaGoOnStageResult.3", false, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
    long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
  }
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGaSwitchVideoResult, result[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], info[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("], groupId[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], relationType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramInt1 == 96)
    {
      if (a().jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        a().a(l1, "onGaSwitchVideoResult", true, true);
        this.jdField_c_of_type_Boolean = true;
        int i1 = 0;
        while (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
          int i2;
          if ((b()) && (((VideoViewInfo)localObject1).jdField_a_of_type_Int != 1)) {
            i2 = 0;
          } else {
            i2 = 1;
          }
          if ((((VideoViewInfo)localObject1).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (i2 == 0))
          {
            if (a(((VideoViewInfo)localObject1).jdField_a_of_type_Long, ((VideoViewInfo)localObject1).jdField_a_of_type_Int, a().jdField_e_of_type_JavaUtilArrayList)) {
              ((VideoViewInfo)localObject1).jdField_b_of_type_Boolean = true;
            }
          }
          else {
            break label300;
          }
          ((VideoViewInfo)localObject1).jdField_b_of_type_Boolean = false;
          label300:
          i1 += 1;
        }
        a().jdField_e_of_type_JavaUtilArrayList.clear();
        a().b(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), false, true);
        localObject1 = a(a().jdField_c_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGaSwitchVideoResult-->Display VideoViewInfo List = ");
          localStringBuilder.append((String)localObject1);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
          break label445;
        }
      }
    }
    else
    {
      this.jdField_c_of_type_Boolean = false;
      a().b(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), true, true);
      a().jdField_e_of_type_JavaUtilArrayList.clear();
    }
    label445:
    Object localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject1 != null) {
      ((VideoAppInterface)localObject1).a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
  }
  
  public void onGroundGlassSwitch(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  public void onGroundGlassWaitTimeChange(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  public void onGroupChatModeChange(long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 105: 
    case 106: 
    default: 
      return;
    case 104: 
    case 107: 
    case 108: 
      a().J = paramInt2;
      c(paramInt1, paramLong, paramInt2);
      return;
    case 102: 
    case 103: 
      b(paramInt1, paramLong, paramInt2);
      return;
    }
    a().jdField_N_of_type_Boolean = true;
    c(paramInt1, paramLong, paramInt2);
  }
  
  public void onGroupSecurityLimit(long paramLong1, long paramLong2, String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGroupSecurityLimit, mGAudioInRoom[");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], info[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], strMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
    {
      a(1, paramLong1, 82);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_j_of_type_JavaLangRunnable = null;
      a().a("onGroupSecurityLimit", 0);
      onGAudioSDKError(1, paramLong1, 17, 0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
  }
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGroupVideoClosed, relationId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], bKickout[");
    localStringBuilder.append(this.u);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.u) {
      return;
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong))
    {
      a(1, paramLong, 83);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_j_of_type_JavaLangRunnable = null;
      a().a("onGroupVideoClosed", 0);
      a(paramInt1, paramLong, 17, 0, paramInt2);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void onHowling()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = i();
      if (!bool1)
      {
        int i1 = e();
        a("onHowling", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, e());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().jdField_E_of_type_Boolean;
      if (bool2) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
      }
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      PopupDialog.b(localContext, 230, null, localContext.getString(2131695616), 2131690728, 2131694583, new VideoController.42(this), new VideoController.43(this, bool1, bool2));
      ReportController.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.b();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onInviteReached, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], friend_state[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], extraParam0[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], subState[");
    localStringBuilder.append(a().jdField_c_of_type_Long);
    localStringBuilder.append("], mStartRing[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    a().n = null;
    if (a() != null) {
      if (0L == a().jdField_c_of_type_Long)
      {
        if (0L != paramLong) {
          if (1L == paramLong)
          {
            a().jdField_c_of_type_Long = 1L;
            if (paramArrayOfByte != null)
            {
              a().n = new String(paramArrayOfByte);
              if (QLog.isColorLevel())
              {
                paramArrayOfByte = jdField_a_of_type_JavaLangString;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("onInviteReached :");
                ((StringBuilder)localObject).append(a().n);
                QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
              }
              paramArrayOfByte = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
              if (paramArrayOfByte != null) {
                paramArrayOfByte.a(new Object[] { Integer.valueOf(400), a().n });
              }
            }
          }
          else if (2L == paramLong)
          {
            a().jdField_c_of_type_Long = 2L;
            if (paramArrayOfByte != null) {
              a().n = new String(paramArrayOfByte);
            }
          }
        }
      }
      else if (1L == a().jdField_c_of_type_Long)
      {
        if (0L == paramLong)
        {
          a().jdField_c_of_type_Long = 0L;
          return;
        }
        if (1L == paramLong) {
          return;
        }
        if (2L == paramLong)
        {
          a().jdField_c_of_type_Long = 0L;
          a(l1);
          return;
        }
      }
    }
    if ((a() != null) && (a().j()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onInviteReached, isConnected");
      return;
    }
    int i1 = 0x80000 & paramInt;
    if ((i1 > 0) && (this.jdField_j_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :has get phone state");
      }
      return;
    }
    if (i1 == 0) {
      this.jdField_j_of_type_Boolean = true;
    }
    a().jdField_q_of_type_Int = 0;
    if ((0x10000 & paramInt) > 0)
    {
      i1 = 0x40000 & paramInt;
      a().jdField_o_of_type_Int = (0x20000 & paramInt);
      a().jdField_p_of_type_Int = i1;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onInviteReached pcOnLine:");
        ((StringBuilder)localObject).append(a().jdField_o_of_type_Int);
        ((StringBuilder)localObject).append(" # phoneOnLine = ");
        ((StringBuilder)localObject).append(a().jdField_p_of_type_Int);
        QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
      }
      if (((0x100000 & paramInt) > 0) && (i1 > 0))
      {
        if ((paramInt & 0xFFFF & 0x1) > 0) {
          a().jdField_q_of_type_Int = 1;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
        {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramArrayOfByte != null) {
            paramArrayOfByte.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
          }
          this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          if ((a() != null) && (a().jdField_c_of_type_Long == 1L) && (!TextUtils.isEmpty(a().n))) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString, a().n });
          } else {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString });
          }
        }
        if (!a().Y) {
          b(l1);
        }
      }
      else
      {
        paramInt &= 0xFFFF;
        if ((paramInt & 0x2) > 0)
        {
          a().jdField_q_of_type_Int = 2;
        }
        else if ((paramInt & 0x4) > 0)
        {
          a().jdField_q_of_type_Int = 3;
          ReportController.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
        }
        else if ((paramInt & 0x8) > 0)
        {
          a().jdField_q_of_type_Int = 4;
        }
        if (QLog.isColorLevel())
        {
          paramString = jdField_a_of_type_JavaLangString;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("onInviteReached low 16bit value is");
          paramArrayOfByte.append(paramInt);
          QLog.d(paramString, 2, paramArrayOfByte.toString());
        }
      }
      a().jdField_r_of_type_Boolean = true;
      return;
    }
    a().jdField_o_of_type_Int = 0;
    a().jdField_p_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pc and phone both not online");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
    {
      paramString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (paramString != null) {
        paramString.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
    }
    m(true);
    a().jdField_r_of_type_Boolean = false;
    a(a().jdField_c_of_type_JavaLangString, 210);
    b(210);
    this.jdField_h_of_type_JavaLangRunnable = new VideoController.24(this, l1);
    if (this.jdField_h_of_type_JavaLangRunnable != null)
    {
      paramString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (paramString != null) {
        paramString.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 2000L);
      }
    }
  }
  
  public void onKickOutFail(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKickOutFail, groupId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], errCode[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], strMsg[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(false), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void onKickOutSuc(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKickOutSuc, groupId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], errCode[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], strMsg[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(true), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onMAVMemberInOrOut--> UserInfo = ");
      ((StringBuilder)localObject2).append(paramAVUserInfo.toString());
      ((StringBuilder)localObject2).append(" ,relationId = ");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" ,opType = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" ,relationType = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" ,extroInfo = ");
      ((StringBuilder)localObject2).append(paramLong2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt1 == 70)
    {
      if (paramAVUserInfo.accountType == 1) {
        if (a().a(paramAVUserInfo.account) != null)
        {
          localObject1 = a().a(paramAVUserInfo.account);
          if (QLog.isColorLevel())
          {
            localObject2 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onMAVMemberInOrOut --> This PSTN User is in List. Info = ");
            localStringBuilder.append(localObject1);
            QLog.e((String)localObject2, 2, localStringBuilder.toString());
          }
        }
        else
        {
          localObject1 = new AVPhoneUserInfo();
          ((AVPhoneUserInfo)localObject1).account = paramAVUserInfo.account;
          ((AVPhoneUserInfo)localObject1).accountType = 2;
          a().a((AVPhoneUserInfo)localObject1);
          this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramAVUserInfo.account);
        }
      }
      a(paramInt2, paramLong1, paramAVUserInfo, true, paramLong2, paramVarArgs);
      return;
    }
    if (paramInt1 == 71)
    {
      if (paramAVUserInfo.accountType == 1)
      {
        localObject1 = new AVPhoneUserInfo();
        ((AVPhoneUserInfo)localObject1).account = paramAVUserInfo.account;
        ((AVPhoneUserInfo)localObject1).accountType = 2;
      }
      a(paramInt2, paramLong1, paramAVUserInfo, false, paramLong2, paramVarArgs);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
    }
  }
  
  public void onMediaCameraNotify(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramLong == 0L)
    {
      a().jdField_F_of_type_Boolean = false;
    }
    else if (paramLong == 1L)
    {
      a().jdField_F_of_type_Boolean = true;
    }
    else if (paramLong == 100L)
    {
      a().jdField_G_of_type_Boolean = false;
    }
    else if (paramLong == 101L)
    {
      a().jdField_G_of_type_Boolean = true;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        break label103;
      }
    }
    else
    {
      a().jdField_F_of_type_Boolean = false;
      a().jdField_G_of_type_Boolean = false;
    }
    paramArrayOfByte = null;
    label103:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(27), paramArrayOfByte });
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder;
    if (paramArrayOfLong == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfLong = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGaChatUserInOrOut-->userUin is 0,OpType = ");
        localStringBuilder.append(paramInt1);
        QLog.e(paramArrayOfLong, 2, localStringBuilder.toString());
      }
      return;
    }
    int i1 = 0;
    long l1 = paramArrayOfLong[0];
    if (paramInt1 != 42)
    {
      if (paramInt1 != 43) {
        switch (paramInt1)
        {
        default: 
          if (!QLog.isColorLevel()) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Wrong type of GaChatMemBerInType, and Type = ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", groupUin = ");
          localStringBuilder.append(paramLong1);
          paramInt2 = paramArrayOfLong.length;
          paramInt1 = i1;
          while (paramInt1 < paramInt2)
          {
            paramLong1 = paramArrayOfLong[paramInt1];
            localStringBuilder.append(", userUin = ");
            localStringBuilder.append(paramLong1);
            paramInt1 += 1;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          return;
        case 79: 
          a(paramLong1, l1, false, paramInt2, false, paramLong2, paramInt3);
          ScreenShareReportHelper.b(SessionMgr.a().a().jdField_b_of_type_JavaLangString, "MEMBER_SHARE_SCREEN_OUT");
          return;
        case 78: 
          if (QLog.isColorLevel())
          {
            paramArrayOfLong = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onMultiVideoChatMembersInfoChange = userUin:");
            localStringBuilder.append(l1);
            localStringBuilder.append("curuin:");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
            QLog.d(paramArrayOfLong, 2, localStringBuilder.toString());
          }
          if (l1 != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
            a(paramLong1, l1, paramInt2, paramLong2, paramInt3);
          } else {
            a(paramLong1, l1, true, paramInt2, false, paramLong2, paramInt3);
          }
          ScreenShareReportHelper.a(SessionMgr.a().a().jdField_b_of_type_JavaLangString, "MEMBER_SHARE_SCREEN_IN");
          return;
        case 77: 
          a(paramLong1, l1, false, paramInt2, true, paramLong2, paramInt3);
          return;
        case 76: 
          a(paramLong1, l1, true, paramInt2, true, paramLong2, paramInt3);
          return;
        case 75: 
          a(Long.valueOf(paramLong1), l1, paramInt2, false);
          return;
        case 74: 
          a(Long.valueOf(paramLong1), l1, paramInt2, true);
          return;
        case 73: 
          a(paramLong1, l1, false, paramInt2, paramLong2, paramInt3);
          return;
        case 72: 
          a(paramLong1, l1, true, paramInt2, paramLong2, paramInt3);
          return;
        }
      } else {
        a(paramLong1, paramArrayOfLong, false, paramInt4);
      }
    }
    else {
      a(paramLong1, paramArrayOfLong, true, paramInt4);
    }
  }
  
  public void onNeedShowPeerVideo(String paramString)
  {
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = a();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNeedShowPeerVideo, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(localSessionInfo.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(localSessionInfo.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(localSessionInfo.jdField_k_of_type_Boolean);
    localStringBuilder.append("], mXiaoweiDevice[");
    localStringBuilder.append(this.jdField_p_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((!TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, paramString)) && (!TextUtils.equals(localSessionInfo.jdField_e_of_type_JavaLangString, paramString)) && (!this.jdField_p_of_type_Boolean)) {
      return;
    }
    if ((localSessionInfo.jdField_e_of_type_Int == 1) && (!g()))
    {
      AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
      return;
    }
    if (!localSessionInfo.jdField_k_of_type_Boolean)
    {
      localSessionInfo.c(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
      DataReport.m(this);
      if (localSessionInfo.jdField_d_of_type_Int == 1)
      {
        localSessionInfo.a(l1, "onNeedShowPeerVideo", 2);
        localSessionInfo.jdField_H_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
    }
    if (!TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, paramString)) {
      GraphicRenderMgr.getInstance().onUinChanged(localSessionInfo.jdField_c_of_type_JavaLangString, paramString);
    }
    if ((!localSessionInfo.jdField_j_of_type_Boolean) && (!localSessionInfo.jdField_k_of_type_Boolean))
    {
      c(1);
      return;
    }
    c(2);
  }
  
  public void onNetLevel_S2C(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  public void onNetworkDisconnect(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkDisconnect fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
  }
  
  public void onNetworkInfo_S2C(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNetworkInfo_S2C:flag is:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong != 0L)
    {
      try
      {
        str = new String(paramArrayOfByte, "UTF-8");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf((int)paramLong), str });
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNetworkInfo_S2C fromUin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", info = ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.d((String)localObject, 2, localStringBuilder.toString(), localUnsupportedEncodingException);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkInfo_S2C fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", info = ");
      localStringBuilder.append(paramArrayOfByte);
      QLog.d((String)localObject, 2, localStringBuilder.toString(), localNullPointerException);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf(0), null });
    }
  }
  
  public void onNetworkMonitorInfo(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      QLog.isColorLevel();
      String str;
      StringBuilder localStringBuilder;
      if (paramLong == 1L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad");
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b()) {
          return;
        }
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "GBK");
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(26), paramArrayOfByte });
          return;
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          if (!QLog.isColorLevel()) {
            break label321;
          }
          str = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onNetworkMonitorInfo fromUin = ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", info = ");
          localStringBuilder.append(paramLong);
          QLog.d(str, 2, localStringBuilder.toString(), paramArrayOfByte);
          return;
        }
        catch (NullPointerException paramArrayOfByte)
        {
          if (!QLog.isColorLevel()) {
            break label321;
          }
        }
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNetworkMonitorInfo fromUin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", info = ");
        localStringBuilder.append(paramLong);
        QLog.d(str, 2, localStringBuilder.toString(), paramArrayOfByte);
      }
      else if (paramLong == 0L)
      {
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(19), paramArrayOfByte });
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            str = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onNetworkMonitorInfo fromUin = ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(", info = ");
            localStringBuilder.append(paramLong);
            QLog.d(str, 2, localStringBuilder.toString(), paramArrayOfByte);
          }
        }
      }
      label321:
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad,detail is null");
    }
  }
  
  public void onNetworkQualityChanged(int paramInt)
  {
    if (a().jdField_d_of_type_Int != 2) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10003), Integer.valueOf(paramInt) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void onNotRecvAudioData(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotRecvAudioData bNotRecv = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (!a().jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(true) });
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(false) });
  }
  
  public void onNotifyAIDenoiseTips(boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotifyAIDenoiseTips, isFromlocal[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(100), Boolean.valueOf(paramBoolean) });
  }
  
  public void onOpenMicFail()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null) {
      QQToast.a((Context)localObject, 2131695708, 1).a();
    }
    localObject = a();
    if (localObject != null)
    {
      if (((SessionInfo)localObject).jdField_E_of_type_Int == 1) {
        localObject = "0x8007CB5";
      } else {
        localObject = "0x8007CB6";
      }
      DoodleUtils.a((String)localObject);
    }
  }
  
  public void onOtherTerminalChatingStatus(String paramString, long paramLong, int paramInt)
  {
    long l1 = AudioHelper.b();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onOtherTerminalChatingStatus, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], roomid[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        return;
      }
      localObject = SessionMgr.a(3, paramString, new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
      if (localObject != null) {
        ((SessionInfo)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
      }
      if ((paramInt != 0) && (!TextUtils.isEmpty(a().jdField_c_of_type_JavaLangString)) && ((!a().jdField_c_of_type_JavaLangString.equals(paramString)) || (a().jdField_d_of_type_Int == 0)))
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
        QLog.d(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus sendQueryRoomInfoRequest");
      }
      a(0, paramString, paramLong, paramInt);
    }
  }
  
  public void onPPTInOrOut(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    VideoController.GAudioFriends localGAudioFriends = a(String.valueOf(paramLong2));
    if (localGAudioFriends == null) {
      return;
    }
    if (paramInt2 == 1) {
      return;
    }
    if ((paramInt2 == 3) || (paramInt2 == 4)) {
      localGAudioFriends.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void onPauseAudio(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPauseAudio fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", remoteMute = ");
      localStringBuilder.append(a().jdField_h_of_type_Boolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!a().jdField_h_of_type_Boolean)
    {
      a().jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(17) });
    }
  }
  
  public void onPauseVideo(String paramString)
  {
    SessionInfo localSessionInfo = a();
    long l1 = AudioHelper.b();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseVideo, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(localSessionInfo.jdField_k_of_type_Boolean);
    localStringBuilder.append("], isOnlyAudio[");
    localStringBuilder.append(localSessionInfo.jdField_H_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (Utils.a(BaseApplication.getContext()) == 1)
    {
      localSessionInfo.c(l1, false);
      return;
    }
    if ((localSessionInfo.jdField_d_of_type_Int == 2) && (localSessionInfo.jdField_k_of_type_Boolean))
    {
      localSessionInfo.c(l1, false);
      if (!localSessionInfo.jdField_j_of_type_Boolean)
      {
        localSessionInfo.jdField_H_of_type_Boolean = true;
        localSessionInfo.a(l1, "onPauseVideo", 1);
        c(localSessionInfo.jdField_d_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
      DataReport.n(this);
    }
  }
  
  public void onPeerSwitchTerminal(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPeerSwitchTerminal. fromUin = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", peerTerminalType = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", peerSdkVersion = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", roomId = ");
    localStringBuilder.append(paramLong);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    a().Z = true;
    paramString = SessionMgr.a().a(paramString);
    if (paramString != null)
    {
      paramString.c(paramInt2);
      paramString.d(paramInt1);
      paramString.c(paramLong);
    }
    a("onPeerSwitchTerminal", a());
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null) {
      ((WTogetherMng)((VideoAppInterface)localObject).a(16)).c(paramString);
    }
  }
  
  public void onPeerSwitchTerminalFail(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminalFail fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", info :");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    a("onPeerSwitchTerminalFail", a());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void onPstnCallConnected(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    paramLong = AudioHelper.b();
    if ((paramInt == 1) && (1L == a().jdField_c_of_type_Long))
    {
      a().jdField_c_of_type_Long = 0L;
      a(paramLong);
    }
  }
  
  public void onRecSharePushEncParam(int paramInt, long paramLong, RecordParam paramRecordParam)
  {
    ScreenShareCtrl localScreenShareCtrl = this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramInt, paramLong, paramRecordParam);
    }
  }
  
  public void onRecordAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecordAudio=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", size=");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramInt1 == 100)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback;
      if ((localObject != null) && (localObject[0] != null)) {
        localObject[0].onReceiveAudioFrame(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    else if ((paramInt1 == 3) || (paramInt1 == 0) || (paramInt1 == 8))
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback;
      if ((localObject != null) && (localObject[1] != null)) {
        localObject[1].onReceiveAudioFrame(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    if (AudioDump.a()) {
      AudioDump.a().onReceiveAudioFrame(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void onRecvFirstAudioData(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvFirstAudioData, recvFirstAudio[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    PerfReporter.a();
    if (paramBoolean)
    {
      if (a().jdField_H_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
        if (localObject != null) {
          if (-1 == ((VcControllerImpl)localObject).switchAudio(a().jdField_c_of_type_JavaLangString)) {
            this.jdField_i_of_type_Boolean = false;
          } else {
            this.jdField_i_of_type_Boolean = true;
          }
        }
      }
      else
      {
        this.jdField_i_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean), Long.valueOf(l1) });
    }
  }
  
  public void onRejectVideo(String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onRejectVideo fromUin = ");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    b(paramString, 3);
  }
  
  public void onRejectVideoMode(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRejectVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2)
  {
    SessionInfo localSessionInfo = a();
    if (localSessionInfo.jdField_ae_of_type_Boolean) {
      return;
    }
    if (!localSessionInfo.a(paramLong, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRemoteVideoDataComeIn-->uin = ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(", videoSrcType=");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      paramInt1 = 0;
      while (paramInt1 < localSessionInfo.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)localSessionInfo.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)localSessionInfo.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
          ((VideoViewInfo)localSessionInfo.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    }
  }
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramString1);
    long l2 = AudioHelper.b();
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo onRequestVideo, uinType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], fromUin[");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("], extraUin[");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("], sig[");
    boolean bool1;
    if (paramArrayOfByte != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append("], onlyAudio[");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], bindID[");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append("], bindType[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], isOfflineSession[");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l2);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject1 != null)
    {
      if (((VideoAppInterface)localObject1).getApp() == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.b();
      H();
      VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      int i1 = QAVNotificationUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onRequestVideo converted uinType = ");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(",sdkAVAccostType = ");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(VideoConstants.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject2).append(", isVideoPaused: ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (a(i1, paramString1))
      {
        a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
        return;
      }
      localObject2 = a();
      localObject1 = SessionMgr.a(3, paramString1, new int[0]);
      if ((TextUtils.equals((CharSequence)localObject1, ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString)) && (((SessionInfo)localObject2).jdField_c_of_type_Boolean))
      {
        ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
        paramBoolean = ((SessionInfo)localObject2).jdField_H_of_type_Boolean;
        paramString2 = jdField_a_of_type_JavaLangString;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onRequestVideo, autoAcceptChat, seq[");
        paramArrayOfByte.append(l2);
        paramArrayOfByte.append("]");
        QLog.w(paramString2, 1, paramArrayOfByte.toString());
        a(l2, paramString1, paramBoolean ^ true, ((SessionInfo)localObject2).jdField_E_of_type_Int);
        return;
      }
      boolean bool3 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
      Object localObject3 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestVideo->isScreenLocked:");
      localStringBuilder.append(bool3);
      QLog.w((String)localObject3, 1, localStringBuilder.toString());
      if (((SessionInfo)localObject2).e())
      {
        if (i1 == -1)
        {
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString1, c());
          QLog.w(jdField_a_of_type_JavaLangString, 1, "closeVideo uinType == -1");
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString1, 0, this);
          paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          if (paramString1 != null) {
            paramString1.a(0);
          }
          return;
        }
        if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) {}
      }
      label954:
      do
      {
        int i2;
        do
        {
          do
          {
            bool1 = true;
            break label990;
            break label987;
            if ((((SessionInfo)localObject2).m()) || (((SessionInfo)localObject2).n())) {
              break label977;
            }
            if (((SessionInfo)localObject2).jdField_f_of_type_Int == 7) {
              if (this.jdField_c_of_type_Long != 0L) {
                break label954;
              }
            }
            i2 = i1;
            if ((((SessionInfo)localObject2).jdField_f_of_type_Int == 14) || (((SessionInfo)localObject2).jdField_f_of_type_Int == 13)) {
              break label954;
            }
            if (this.jdField_d_of_type_Boolean) {
              break;
            }
            localObject3 = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onRequestVideo when chatting: fromUin = ");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("|");
            localStringBuilder.append(bool3);
            QLog.w((String)localObject3, 1, localStringBuilder.toString());
            if ((((SessionInfo)localObject2).jdField_c_of_type_JavaLangString != null) && (paramString1.equals(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString)))
            {
              paramString2 = jdField_a_of_type_JavaLangString;
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("onRequestVideo when request: fromUin = ");
              paramArrayOfByte.append(paramString1);
              QLog.w(paramString2, 1, paramArrayOfByte.toString());
              D();
              j(paramString1);
              return;
            }
          } while (!bool3);
          a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
          localObject2 = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onRequestVideo when in group chat, fromUin = ");
          ((StringBuilder)localObject3).append(paramString1);
          QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        } while (!bool3);
        a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
        return;
      } while (!bool3);
      a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
      return;
      label977:
      b(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, 2);
      label987:
      bool1 = false;
      label990:
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, false);
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
      ((SessionInfo)localObject2).jdField_A_of_type_Int = paramInt2;
      ((SessionInfo)localObject2).jdField_o_of_type_JavaLangString = paramString3;
      ((SessionInfo)localObject2).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((SessionInfo)localObject2).jdField_B_of_type_Int = i1;
      if (this.jdField_h_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_h_of_type_JavaLangRunnable = null;
        ((SessionInfo)localObject2).a("onRequestVideo.1", 0);
      }
      if (this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
        i1 = 9500;
      }
      this.jdField_a_of_type_Boolean = true;
      ((SessionInfo)localObject2).jdField_H_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        ((SessionInfo)localObject2).jdField_e_of_type_Int = 1;
      } else {
        ((SessionInfo)localObject2).jdField_e_of_type_Int = 2;
      }
      long l1 = a(paramString1);
      paramString3 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onRequestVideo  ,roomId = ");
      ((StringBuilder)localObject3).append(l1);
      QLog.w(paramString3, 1, ((StringBuilder)localObject3).toString());
      ((SessionInfo)localObject2).c(l1);
      ((SessionInfo)localObject2).jdField_k_of_type_Int = i1;
      ((SessionInfo)localObject2).jdField_l_of_type_Int = paramInt1;
      ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString = paramString1;
      ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString = paramString2;
      ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
      ((SessionInfo)localObject2).a("onRequestVideo.2", 2);
      ((SessionInfo)localObject2).jdField_s_of_type_Int = paramInt3;
      a(i1, paramString1, paramString2, paramArrayOfByte);
      paramArrayOfByte = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (paramBoolean) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      paramArrayOfByte.a(l1, 20, paramInt1);
      paramArrayOfByte.a(l1, 6, 1L);
      long l3 = a(paramString1);
      VideoNodeManager.a(l3, 36);
      VideoNodeManager.a(l3, 9, ((SessionInfo)localObject2).b());
      VideoNodeManager.a(l3, 11, paramString1);
      VideoNodeManager.a(l3, 12, 2L);
      if (((SessionInfo)localObject2).jdField_H_of_type_Boolean) {
        l1 = 1L;
      } else {
        l1 = 2L;
      }
      VideoNodeManager.a(l3, 13, l1);
      VideoNodeManager.a(l3, 15, 1L);
      j(paramString1);
      if (bool2)
      {
        ((SessionInfo)localObject2).jdField_b_of_type_Boolean = true;
        b(l2, (String)localObject1, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
      }
      if ((!this.jdField_d_of_type_Boolean) && (((SessionInfo)localObject2).jdField_k_of_type_Int != 21) && (((SessionInfo)localObject2).jdField_k_of_type_Int != 1011)) {
        a((String)localObject1, ((SessionInfo)localObject2).jdField_e_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = jdField_a_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("onRequestVideo orientation: ");
        paramString3.append(this.jdField_n_of_type_Int);
        paramString3.append(", isQQPaused: ");
        paramString3.append(VideoConstants.jdField_b_of_type_Boolean);
        paramString3.append(", isVideoPaused: ");
        paramString3.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
        paramString3.append(", isScreenLocked: ");
        paramString3.append(bool3);
        paramString3.append(", isAppOnForeground: ");
        paramString3.append(GesturePWDUtils.isAppOnForegroundByTasks(a(), 0));
        QLog.d(paramArrayOfByte, 2, paramString3.toString());
      }
      if ((this.w) && (this.jdField_n_of_type_Int == 0) && (!bool3) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.6(this, l2, (String)localObject1, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = jdField_a_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = ");
        paramString3.append(paramString1);
        QLog.d(paramArrayOfByte, 2, paramString3.toString());
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
        this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
      }
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor = new VideoCallStateMonitor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      a(l2, (String)localObject1, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
    }
  }
  
  public void onRequestVideoMode(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    a().jdField_H_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void onResumeAudio(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResumeAudio fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", remoteMute = ");
      localStringBuilder.append(a().jdField_h_of_type_Boolean);
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((this.jdField_b_of_type_Boolean) && (a().jdField_h_of_type_Boolean))
    {
      a().jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(18) });
    }
  }
  
  public void onResumeVideo(String paramString)
  {
    SessionInfo localSessionInfo = a();
    long l1 = AudioHelper.b();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeVideo, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(localSessionInfo.jdField_k_of_type_Boolean);
    localStringBuilder.append("], isOnlyAudio[");
    localStringBuilder.append(localSessionInfo.jdField_H_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((localSessionInfo.jdField_e_of_type_Int == 1) && (!g()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
      return;
    }
    if (!localSessionInfo.jdField_k_of_type_Boolean)
    {
      localSessionInfo.c(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      DataReport.m(this);
      if (localSessionInfo.jdField_d_of_type_Int == 1)
      {
        localSessionInfo.a(l1, "onResumeVideo", 2);
        localSessionInfo.jdField_H_of_type_Boolean = false;
      }
    }
  }
  
  public void onSDKCustomCommand(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onSDKCustomCommand uin=%s, cmd=%s, arg1=%s, arg2=%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    if (paramLong1 == 200L)
    {
      if (paramLong2 == 1L)
      {
        VideoSocketReconnectReporter.a();
        return;
      }
      if (paramLong2 == 2L) {
        VideoSocketReconnectReporter.a(paramLong3);
      }
    }
  }
  
  public void onSelfAudioVolumeChange(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfAudioVolumeChange qav.value:=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20002), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(100L) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void onSendC2CMsg(String paramString)
  {
    a().jdField_ac_of_type_Boolean = true;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      g(paramString);
    }
  }
  
  public void onSetMicBySelf(long paramLong)
  {
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      ??? = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("WL_DEBUG onSetMicBySelf uin = ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)???, 2, ((StringBuilder)localObject2).toString());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject2).next();
        if (localGAudioFriends.jdField_a_of_type_Long == paramLong) {
          if (!localGAudioFriends.jdField_f_of_type_Boolean)
          {
            localGAudioFriends.jdField_f_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void onShareOpsCallback(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    ScreenShareCtrl localScreenShareCtrl = this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
    }
  }
  
  public void onSwitchGroup(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = AudioHelper.b();
    paramArrayOfByte = a();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchGroup, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], flag[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramArrayOfByte.jdField_d_of_type_Int != 3)
    {
      if (paramArrayOfByte.jdField_d_of_type_Int == 4) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!paramString.equalsIgnoreCase(paramArrayOfByte.jdField_c_of_type_JavaLangString)) {
        return;
      }
      j(true);
      if (!paramArrayOfByte.b()) {
        a(l1, 2131230740, 1, null);
      }
      paramArrayOfByte.e("onSwitchGroup", AVUtil.a(paramArrayOfByte.jdField_k_of_type_Int));
      paramArrayOfByte.jdField_f_of_type_Long = 0L;
      paramArrayOfByte.b("onSwitchGroup", 11);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      e();
    }
  }
  
  public void onSwitchMeeting(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ScreenShareCtrl localScreenShareCtrl = a();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramString, paramArrayOfByte, paramLong);
    }
  }
  
  public void onSwitchTerminalSuccess(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, long paramLong)
  {
    long l1 = AudioHelper.b();
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchTerminalSuccess, fromUin[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], info[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], hdModeFreeUseStartTime[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], hdModeFreeUseEndTime[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], hdModeFreeUseTips[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], roomId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramString1 == null) {
      return;
    }
    if (this.jdField_f_of_type_JavaLangRunnable != null)
    {
      paramString1.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_f_of_type_JavaLangRunnable = null;
    }
    paramString1 = a();
    if (paramString1.Z)
    {
      paramString1.Z = false;
      if (paramString1.jdField_g_of_type_Boolean) {
        a(true, paramString1.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString1.jdField_c_of_type_JavaLangString, Boolean.valueOf(false) });
      }
      else
      {
        paramString2 = new VideoController.16(this, paramString1);
        this.jdField_a_of_type_JavaUtilList.add(paramString2);
      }
      c(l1);
      a((int)a(), paramString1.jdField_k_of_type_Boolean, paramString1.jdField_h_of_type_Boolean ^ true);
    }
    else if (paramString1.Y)
    {
      onChannelReady(paramString1.jdField_c_of_type_JavaLangString, paramInt2, paramInt3, paramString2, paramLong);
      break label363;
    }
    bool1 = false;
    label363:
    paramString2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramString2 != null) {
      paramString2.a(this, paramString1);
    }
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(16)).a(paramString1, bool1);
  }
  
  public void onSyncOtherTerminalChatStatus(String paramString, int paramInt)
  {
    if (!a().Y)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "not start StartByTerminalSwitch but receive onSyncOtherTerminalChatStatus message");
      }
      return;
    }
    int i2 = 0xFFFFF & paramInt;
    int i1 = paramInt >> 20 & 0x1;
    int i3 = paramInt >> 21 & 0x1;
    paramInt = i1;
    if (a().aa)
    {
      paramInt = i1;
      if (a().jdField_d_of_type_Int == 1)
      {
        paramInt = i1;
        if (g())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "switch start frome video entry, open camera");
          }
          paramInt = 1;
        }
      }
    }
    a().jdField_e_of_type_Long = i2;
    if (QLog.isColorLevel())
    {
      paramString = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSyncOtherTerminalChatStatus time:");
      localStringBuilder.append(i2);
      localStringBuilder.append(", isCamreOpen:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isMicOpen:");
      localStringBuilder.append(i3);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(34), Integer.valueOf(paramInt), Integer.valueOf(i3) });
  }
  
  public void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    long l1 = AudioHelper.b();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onVideoSrcChange, videoSrcType[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], relationType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], userUin[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("], groupUin[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = a(String.valueOf(paramLong1));
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onVideoSrcChange-->can not find the user");
      }
      return;
    }
    int i1 = 0;
    while (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
      {
        i2 = ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
        break label241;
      }
      i1 += 1;
    }
    i1 = -1;
    int i2 = 1;
    label241:
    if (paramInt1 == 4)
    {
      if (i1 != -1)
      {
        a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
        w();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i2), Long.valueOf(l1) });
        i1 = 0;
      }
      else
      {
        i1 = 1;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(73), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
    else if (paramInt1 != 0)
    {
      i1 = a().a(paramLong1, 0);
      if (i1 == -1)
      {
        a(paramLong1, true, paramInt2, 5L);
        a((VideoController.GAudioFriends)localObject1, paramInt1);
        i1 = a().a(paramLong1, 0);
        ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;
      }
      else
      {
        localObject1 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        localObject2 = new VideoViewInfo();
        ((VideoViewInfo)localObject2).jdField_a_of_type_Long = ((VideoViewInfo)localObject1).jdField_a_of_type_Long;
        ((VideoViewInfo)localObject2).jdField_a_of_type_Int = ((VideoViewInfo)localObject1).jdField_a_of_type_Int;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject2);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
        ((VideoViewInfo)localObject1).jdField_a_of_type_Int = paramInt1;
      }
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(87), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public void p()
  {
    if (!this.jdField_d_of_type_Boolean) {
      a().a("clearGAudioState", 0);
    }
  }
  
  public boolean p()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
    return (localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.h());
  }
  
  public void q()
  {
    long l1;
    if (this.jdField_d_of_type_Boolean) {
      l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        i1 = 1;
        if ((i2 != 1) || (this.jdField_c_of_type_JavaUtilArrayList.get(0) == null) || (l1 != ((VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long)) {
          break label117;
        }
        if (i1 != 0)
        {
          a().a("setGAudioState.1", 9);
          return;
        }
        a().a("setGAudioState.2", 10);
        return;
      }
      return;
      label117:
      int i1 = 0;
    }
  }
  
  public void r()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStartTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_m_of_type_JavaLangRunnable, 3000L);
  }
  
  public void receiveTransferMsg(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.receiveTransferMsg(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(122), paramString });
  }
  
  public void s()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStopTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
  }
  
  public void t()
  {
    if ((a().jdField_f_of_type_Int == 4) || (a().jdField_f_of_type_Int == 10) || (a().jdField_f_of_type_Int == 14))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void u()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkScreenShareValid");
    }
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (localQQGAudioCtrl != null) {
      localQQGAudioCtrl.checkScreenShareAvaliable();
    }
  }
  
  public void w()
  {
    if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      int i2 = g();
      int i1 = 0;
      if (i2 != 4)
      {
        i2 = a().c();
        if (i2 == -1)
        {
          ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
          ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
          return;
        }
        VideoViewInfo localVideoViewInfo1 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i2);
        localVideoViewInfo1.jdField_a_of_type_Boolean = true;
        VideoViewInfo localVideoViewInfo2;
        if (localVideoViewInfo1.jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          if (i2 != 0)
          {
            localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
            localVideoViewInfo2.jdField_a_of_type_Boolean = false;
            a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
            a().jdField_c_of_type_JavaUtilArrayList.set(i2, localVideoViewInfo2);
            synchronized (a().jdField_d_of_type_JavaUtilArrayList)
            {
              a().jdField_d_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
              a().jdField_d_of_type_JavaUtilArrayList.set(i2, localVideoViewInfo2);
              a().a();
            }
          }
          if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1) {
            while (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
            {
              if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
                ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
              }
              i1 += 1;
            }
          }
        }
        else if (i2 != 0)
        {
          localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          localVideoViewInfo2.jdField_a_of_type_Boolean = false;
          a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
          a().jdField_c_of_type_JavaUtilArrayList.set(i2, localVideoViewInfo2);
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
            a().jdField_d_of_type_JavaUtilArrayList.set(i2, localVideoViewInfo2);
            a().a();
            return;
          }
        }
      }
      else
      {
        ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (a().jdField_E_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
      } else if ((a().jdField_E_of_type_Int == 1) && (a().jdField_j_of_type_Int == 10)) {
        ReportController.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
      }
      int i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goOffStage, ret[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
    }
  }
  
  public void y()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearSelectMemberActivityIsResume, selectMemberActivityIsResume[");
    localStringBuilder.append(this.jdField_i_of_type_Int);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_i_of_type_Int = 0;
  }
  
  public void z()
  {
    SessionInfo localSessionInfo = a();
    if (localSessionInfo != null)
    {
      int i2 = localSessionInfo.jdField_ae_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = localSessionInfo.jdField_ad_of_type_Int;
      }
      b(i1);
      boolean bool;
      if ((i1 != 0) && (localSessionInfo.ar)) {
        bool = true;
      } else {
        bool = false;
      }
      c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */