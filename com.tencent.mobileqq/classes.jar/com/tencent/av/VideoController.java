package com.tencent.av;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import com.tencent.av.app.MSFNetInfoMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.CameraUtils;
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
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.random.RandomController;
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
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
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
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
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
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  implements IVideoSession, ISetAudioFrameCallback, IVideoEventListener, VcControllerImpl.CloseVideoTimeoutCallback, QQGAudioCtrlCallback
{
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  private static String jdField_f_of_type_JavaLangString;
  public static int j;
  public static int k;
  public static int l;
  public int a;
  public long a;
  Context jdField_a_of_type_AndroidContentContext;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener = null;
  public MatchedUser a;
  public final QavChannelProxy a;
  SessionMgr jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
  private volatile VideoCallStateMonitor jdField_a_of_type_ComTencentAvVideoCallStateMonitor = null;
  public final VideoCameraListener a;
  VideoController.AnyChatReqTimeoutRunnable jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
  VideoController.OnCustomCompletionListener jdField_a_of_type_ComTencentAvVideoController$OnCustomCompletionListener = new VideoController.9(this);
  VideoController.StartAudioSendRunnable jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
  VideoController.StartRingRunnable jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
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
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
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
  long jdField_d_of_type_Long = 0L;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  public boolean d;
  public int e;
  long jdField_e_of_type_Long = 0L;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  private String jdField_e_of_type_JavaLangString = "";
  public boolean e;
  public int f;
  public long f;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  public boolean f;
  int jdField_g_of_type_Int = 0;
  Runnable jdField_g_of_type_JavaLangRunnable = null;
  boolean jdField_g_of_type_Boolean = true;
  public int h;
  Runnable h;
  public volatile boolean h;
  int jdField_i_of_type_Int = 0;
  Runnable jdField_i_of_type_JavaLangRunnable = null;
  boolean jdField_i_of_type_Boolean = false;
  Runnable jdField_j_of_type_JavaLangRunnable = null;
  boolean jdField_j_of_type_Boolean = false;
  Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.37(this);
  boolean jdField_k_of_type_Boolean = false;
  private Runnable jdField_l_of_type_JavaLangRunnable = null;
  boolean jdField_l_of_type_Boolean = false;
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
  private int q;
  public boolean q;
  private int jdField_r_of_type_Int = -1;
  boolean jdField_r_of_type_Boolean = false;
  boolean s;
  boolean t = false;
  public boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoController";
    jdField_a_of_type_ComTencentAvVideoController = null;
    jdField_f_of_type_JavaLangString = "com.tencent.av.count";
    jdField_b_of_type_JavaLangString = "WifiQQCall";
    jdField_c_of_type_JavaLangString = "WifiRandom";
    jdField_d_of_type_JavaLangString = "WifiGuild";
    jdField_j_of_type_Int = -1;
    jdField_k_of_type_Int = 1;
    jdField_l_of_type_Int = 0;
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoCameraListener = new VideoCameraListener(this);
    this.jdField_b_of_type_Long = 6000L;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    this.jdField_h_of_type_JavaLangRunnable = null;
    this.jdField_q_of_type_Int = 1;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvMatchedUser = null;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactHelper = null;
    this.jdField_a_of_type_ComTencentAvQavChannelProxy = new QavChannelProxy(this);
    if (!AVUtil.b()) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker = new InviteUIChecker();
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoController create.");
      }
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
      return;
      this.jdField_a_of_type_ComTencentAvCompatAVCallCompactHelper = new AVCallCompactHelper();
    }
  }
  
  private void I()
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
  
  private void J()
  {
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
    if (localAudioManager != null)
    {
      long l1 = System.currentTimeMillis();
      boolean bool = localAudioManager.isMicrophoneMute();
      if (bool) {
        localAudioManager.setMicrophoneMute(false);
      }
      long l2 = System.currentTimeMillis();
      AVLog.printColorLog(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void K()
  {
    Object localObject = a();
    int i4;
    int i2;
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
    {
      int i3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
      long l1 = ((SessionInfo)localObject).jdField_h_of_type_Long;
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      int i1 = this.jdField_d_of_type_Int;
      ((QQGAudioCtrl)localObject).inviteUser(new long[] { l1 }, i1);
      i4 = i3 - 1;
      localObject = new long[i4 * 2];
      i2 = 0;
      i1 = 0;
      if (i2 < i3)
      {
        if ((((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i2)).longValue() == l1) || (i1 >= i4)) {
          break label186;
        }
        localObject[(i1 * 2)] = 1L;
        localObject[(i1 * 2 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i2)).longValue();
        i1 += 1;
      }
    }
    label186:
    for (;;)
    {
      i2 += 1;
      break;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject, i4, null, 0, 0, false, false, 4);
      return;
    }
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController == null) {}
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
  
  private void M()
  {
    if (this.jdField_n_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_n_of_type_JavaLangRunnable);
    }
    this.jdField_n_of_type_JavaLangRunnable = null;
  }
  
  private void N()
  {
    if ((this.jdField_f_of_type_Long != -1L) && (System.currentTimeMillis() - this.jdField_f_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_f_of_type_Long = System.currentTimeMillis();
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
    if (paramBoolean)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = -1;
        return paramInt2;
      case 0: 
      case 9500: 
        if (paramInt2 == 2) {
          return 22;
        }
        return 0;
      case 1006: 
        return 5;
      case 1000: 
        return 8;
      case 1004: 
        return 9;
      case 1001: 
        return 12;
      case 10002: 
        return 27;
      case 10003: 
        return 29;
      case 1021: 
        return 10;
      case 1024: 
      case 1025: 
        return 19;
      case 1010: 
        return 20;
      case 1011: 
        return 21;
      case 8: 
        return 22;
      case 24: 
        return 24;
      case 25: 
        return 25;
      case 26: 
        return 26;
      }
      return 30;
    }
    paramInt2 = paramInt1;
    switch (paramInt1)
    {
    case 19: 
    default: 
      return -1;
    case 0: 
    case 9500: 
      return 0;
    case 4: 
    case 5: 
      return 1006;
    case 8: 
      return 1000;
    case 9: 
      return 1004;
    case 12: 
      return 1001;
    case 27: 
      return 10002;
    case 29: 
      return 10003;
    case 10: 
      return 1021;
    case 20: 
      return 1010;
    case 21: 
      return 1011;
    case 22: 
      return 22;
    case 24: 
      return 24;
    case 25: 
      return 25;
    case 26: 
      return 26;
    }
    return 1044;
  }
  
  private int a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong1, paramLong2);
    }
    return -100;
  }
  
  private int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i1 = 0;
    VideoController.StartAudioSendRunnable localStartAudioSendRunnable;
    boolean bool1;
    label58:
    label64:
    label104:
    label126:
    String str;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean1) {
        i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend(paramBoolean2);
      }
    }
    else
    {
      boolean bool2 = this.u;
      localStartAudioSendRunnable = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
      if (paramBoolean1) {
        break label311;
      }
      if ((!paramBoolean2) && (!this.u)) {
        break label305;
      }
      bool1 = true;
      this.u = bool1;
      if (paramInt == 2) {
        break label376;
      }
      if ((i1 == 0) || (!paramBoolean2)) {
        break label362;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable != null) {
        break label319;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable, 1000L);
      }
      str = jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder().append("switchAudioSend[").append(paramString).append("], seq[").append(paramLong).append("], flag[").append(paramInt).append("], enable[").append(paramBoolean1).append("], notifySvr[").append(paramBoolean2).append("], mIsMicOffBySelf[").append(bool2).append("->").append(this.u).append("], result[").append(i1).append("], mGAudioCtrl[");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        break label384;
      }
    }
    label384:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      QLog.w(str, 1, paramBoolean1 + "], lastRunnable[" + localStartAudioSendRunnable + "], curRunnable[" + this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable + "]");
      return i1;
      i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopAudioSend(paramBoolean2);
      break;
      label305:
      bool1 = false;
      break label58;
      label311:
      this.u = false;
      break label64;
      label319:
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable);
      }
      if (paramInt != 0) {
        break label104;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
      break label104;
      label362:
      if (paramInt != 1) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      break label126;
      label376:
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      break label126;
    }
  }
  
  private VideoController.OnCustomCompletionListener a(long paramLong)
  {
    if (this.jdField_l_of_type_JavaLangRunnable == null) {
      this.jdField_l_of_type_JavaLangRunnable = new VideoController.11(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_l_of_type_JavaLangRunnable, 2000L);
    this.jdField_b_of_type_ComTencentAvVideoController$OnCustomCompletionListener.jdField_a_of_type_Long = paramLong;
    return this.jdField_b_of_type_ComTencentAvVideoController$OnCustomCompletionListener;
  }
  
  public static VideoController a()
  {
    if (jdField_a_of_type_ComTencentAvVideoController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvVideoController == null) {
        jdField_a_of_type_ComTencentAvVideoController = new VideoController();
      }
      return jdField_a_of_type_ComTencentAvVideoController;
    }
    finally {}
  }
  
  private SessionInfo a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
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
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = SessionMgr.a().b(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = SessionMgr.a(4, paramString, new int[0]);
        localObject1 = SessionMgr.a().c((String)localObject1);
      }
    }
  }
  
  private qav_gvideo_sdk_transfer.RespInfo a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = new qav_gvideo_sdk_transfer.ReqInfo();
    ((qav_gvideo_sdk_transfer.ReqInfo)localObject).req_event.set(4);
    ((qav_gvideo_sdk_transfer.ReqInfo)localObject).gAudioInfo.setHasFlag(true);
    qav_gvideo_sdk_transfer.GAudioInfo localGAudioInfo = ((qav_gvideo_sdk_transfer.ReqInfo)localObject).gAudioInfo;
    localGAudioInfo.uint32_relationType.set(paramInt1);
    localGAudioInfo.uint32_multiBusiType.set(paramInt2);
    localGAudioInfo.uint64_relationId.set(paramLong);
    localObject = a(3, ((qav_gvideo_sdk_transfer.ReqInfo)localObject).toByteArray());
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getGAudioRoomInfo, result[" + ((qav_gvideo_sdk_transfer.RespInfo)localObject).uint32_result.get() + "], uint64_roomId[" + ((qav_gvideo_sdk_transfer.RespInfo)localObject).gAudioInfo.uint64_roomId.get() + "]");
    }
    return localObject;
  }
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramAVUserInfo.account;
    long l2 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt != 3) {
        break label1685;
      }
      paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong1), new int[0]);
    }
    label648:
    label1685:
    for (;;)
    {
      if (paramInt == 1) {}
      for (??? = a();; ??? = SessionMgr.a().c(paramVarArgs))
      {
        if ((??? != null) && (!TextUtils.isEmpty(((SessionInfo)???).jdField_c_of_type_JavaLangString))) {
          break label175;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, illegal session, sessionId[" + paramVarArgs + "]");
        return;
        bool1 = false;
        break;
      }
      label175:
      long l3 = AudioHelper.b();
      if (AudioHelper.e()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_b_of_type_Int + "], relationType[" + paramInt + "], UserInfo[" + paramAVUserInfo + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_l_of_type_Boolean + "], switchToGAudioMode[" + ((SessionInfo)???).G + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((SessionInfo)???).jdField_V_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        bool2 = ((SessionInfo)???).a();
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.39(this, bool2));
        }
        if (((this.jdField_b_of_type_Int == 1) && (((SessionInfo)???).D == 10)) || (this.jdField_b_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label538;
          }
        }
      }
      label538:
      for (boolean bool2 = false;; bool2 = true)
      {
        ((SessionInfo)???).ae = bool2;
        paramVarArgs = a();
        if ((paramBoolean) || (l1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (paramLong1 != paramVarArgs.jdField_g_of_type_Long)) {
          break;
        }
        a(paramInt, paramLong1, 72);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
        return;
      }
      a(paramAVUserInfo, paramBoolean);
      if ((paramVarArgs.jdField_d_of_type_Int == 3) && (paramVarArgs.jdField_j_of_type_Int == 1011))
      {
        if (!paramBoolean) {
          break label1094;
        }
        if (h() != 1) {
          break label1082;
        }
        if (!bool1) {
          break label1070;
        }
        paramVarArgs.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 4;
        label599:
        if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        a(paramVarArgs.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 3, null);
        ??? = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((??? != null) && (((QAVNotification)???).a())) {
          b();
        }
      }
      if (paramBoolean)
      {
        paramVarArgs.c("onGAudioUserEnterOrLeave", 2);
        if (paramVarArgs.jdField_g_of_type_Int < 10)
        {
          if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (bool1))
          {
            paramVarArgs.a("onGAudioUserEnterOrLeave.1", 9);
            paramVarArgs.ah = false;
          }
        }
        else
        {
          label744:
          if ((paramVarArgs.jdField_h_of_type_Long != l1) && (l1 != l2)) {
            TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
          }
          if (!paramVarArgs.J) {
            break label1187;
          }
          if (!bool1) {
            paramVarArgs.a(l3, SystemClock.elapsedRealtime());
          }
          label796:
          if (!paramBoolean) {
            break label1351;
          }
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramAVUserInfo.accountType != 0) {
            break label1345;
          }
          bool2 = true;
          label818:
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2) });
          label865:
          if (!paramVarArgs.J) {
            break label1520;
          }
          if ((paramBoolean) && (!bool1))
          {
            paramAVUserInfo = a();
            if (paramAVUserInfo != null) {
              paramAVUserInfo.b(paramLong1);
            }
          }
          paramAVUserInfo = new Intent();
          paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
          if (!paramBoolean) {
            break label1505;
          }
          paramAVUserInfo.putExtra("type", 401);
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramAVUserInfo.putExtra("relationType", 3);
          paramAVUserInfo.putExtra("relationId", paramLong1);
          paramAVUserInfo.putExtra("friendUin", l1);
          paramAVUserInfo.putExtra("MultiAVType", paramVarArgs.D);
          paramAVUserInfo.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramAVUserInfo);
          if (paramBoolean) {
            break;
          }
          if (paramVarArgs.jdField_K_of_type_Boolean)
          {
            paramAVUserInfo = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            s();
            if (paramAVUserInfo.a()) {
              paramAVUserInfo.a(paramVarArgs.jdField_c_of_type_JavaLangString);
            }
          }
          if (!paramVarArgs.ar) {
            break;
          }
          a(l3, paramLong1, false, 2);
          return;
          label1070:
          paramVarArgs.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 1;
          break label599;
          label1082:
          paramVarArgs.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 5;
          break label599;
          label1094:
          if (h() == 1) {
            paramVarArgs.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 4;
          }
          if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) || (!m())) {
            break label648;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
          break label648;
          paramVarArgs.a("onGAudioUserEnterOrLeave.2", 10);
          r();
          break label744;
          label1187:
          if (paramVarArgs.jdField_e_of_type_Long != 0L) {
            break label796;
          }
          paramVarArgs.a(l3, SystemClock.elapsedRealtime());
          break label796;
          synchronized (this.jdField_c_of_type_JavaUtilArrayList)
          {
            if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (((VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
            {
              i1 = 1;
              if (i1 != 0)
              {
                paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
                paramVarArgs.ah = true;
                ??? = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                if ((??? != null) && (((QAVNotification)???).a()))
                {
                  s();
                  b();
                }
              }
              TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
              break label796;
            }
            int i1 = 0;
          }
        }
        label1345:
        bool2 = false;
        break label818;
        label1351:
        if (paramLong2 == 1L)
        {
          d(true);
          break label865;
        }
        if (paramLong2 == 0L)
        {
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramAVUserInfo.accountType == 0) {}
          for (bool2 = true;; bool2 = false)
          {
            ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
            break;
          }
        }
        ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramAVUserInfo.accountType == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
          break;
        }
        label1505:
        paramAVUserInfo.putExtra("type", 402);
      }
      label1520:
      paramAVUserInfo = new Intent();
      paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
      if (paramBoolean)
      {
        paramAVUserInfo.putExtra("type", 22);
        paramAVUserInfo.putExtra("isStart", this.jdField_r_of_type_Boolean);
      }
      for (;;)
      {
        paramAVUserInfo.putExtra("roomUserNum", this.jdField_c_of_type_JavaUtilArrayList.size());
        paramAVUserInfo.putExtra("relationType", paramInt);
        paramAVUserInfo.putExtra("relationId", paramLong1);
        paramAVUserInfo.putExtra("friendUin", l1);
        paramAVUserInfo.putExtra("MultiAVType", a().D);
        paramAVUserInfo.putExtra("from", "VideoController5");
        paramAVUserInfo.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramAVUserInfo);
        return;
        paramAVUserInfo.putExtra("type", 23);
      }
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
    localWTogetherRealNameVideoProcessHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695839));
    localWTogetherRealNameVideoProcessHelper.b(new VideoController.38(this, paramLong1, paramLong2, paramInt1, paramLong3, paramInt2, localContext, localWTogetherRealNameVideoProcessHelper));
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, long paramLong3, int paramInt2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaChatVideoInOrOut, groupId[" + paramLong1 + "], user[" + paramLong2 + "], bVideoIn[" + paramBoolean + "], relationType[" + paramInt1 + "], extraInfo[" + paramLong3 + "], avtype[" + paramInt2 + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean) && (paramLong2 != l2) && (paramInt1 == 3)) {
      return;
    }
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      label185:
      if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size()) {
        if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong2) {}
      }
    }
    for (int i1 = ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;; i1 = 1)
    {
      a(paramLong2, paramBoolean, paramInt1, paramLong3);
      if (paramBoolean)
      {
        if ((paramInt1 != 2) && (paramInt1 != 3) && ((paramInt1 != 1) || (paramInt2 != 10))) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(69), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        return;
        i1 += 1;
        break label185;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i1), Long.valueOf(l1) });
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatPPTInOrOut,groupUin=" + paramLong1 + " uin = " + paramLong2 + " bIn = " + paramBoolean1 + " bIsPPT = " + paramBoolean2 + " extraInfo = " + paramLong3);
    }
    long l1 = AVUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {}
    for (Object localObject = SessionMgr.a(100, String.valueOf(paramLong1), new int[0]);; localObject = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
      if (localObject != null) {
        ((SessionInfo)localObject).b(paramLong2, paramBoolean1, paramBoolean2);
      }
      a(paramLong2, paramBoolean1, paramInt1, paramBoolean2, paramInt2);
      if (!paramBoolean1) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(77), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(78), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    VideoController.GAudioFriends localGAudioFriends = a(String.valueOf(paramLong1));
    if (localGAudioFriends == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
      }
    }
    VideoViewInfo localVideoViewInfo;
    do
    {
      do
      {
        return;
        localGAudioFriends.jdField_b_of_type_Boolean = paramBoolean;
      } while ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1));
      if (!paramBoolean) {
        break;
      }
      localVideoViewInfo = new VideoViewInfo();
      localVideoViewInfo.jdField_a_of_type_Long = paramLong1;
      localVideoViewInfo.jdField_a_of_type_Int = 1;
    } while (a().a(paramLong1, localVideoViewInfo.jdField_a_of_type_Int) != -1);
    localVideoViewInfo.jdField_b_of_type_Long = paramLong2;
    if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
      localVideoViewInfo.jdField_b_of_type_Long = 5L;
    }
    if (!a().v())
    {
      localVideoViewInfo.jdField_a_of_type_Boolean = true;
      if ((g() == 4) || (paramInt == 3)) {
        break label320;
      }
      if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) != -1) {
        break label311;
      }
      localVideoViewInfo.jdField_c_of_type_Boolean = true;
      label236:
      if (localGAudioFriends.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        break label338;
      }
      localVideoViewInfo.jdField_b_of_type_Boolean = true;
      localVideoViewInfo.jdField_d_of_type_Boolean = true;
      localVideoViewInfo.jdField_c_of_type_Boolean = true;
      if (a().v()) {
        break label329;
      }
    }
    label311:
    label320:
    label329:
    for (localVideoViewInfo.jdField_a_of_type_Boolean = true;; localVideoViewInfo.jdField_a_of_type_Boolean = false)
    {
      a().a(localVideoViewInfo);
      return;
      localVideoViewInfo.jdField_a_of_type_Boolean = false;
      break;
      localVideoViewInfo.jdField_c_of_type_Boolean = false;
      break label236;
      localVideoViewInfo.jdField_c_of_type_Boolean = true;
      break label236;
    }
    label338:
    localVideoViewInfo.jdField_b_of_type_Boolean = false;
    a().a(localVideoViewInfo);
    return;
    if (paramInt == 2) {
      a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    for (;;)
    {
      u();
      return;
      if (paramInt == 1)
      {
        if (a().D == 10) {
          a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
        } else {
          a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
        }
      }
      else if (paramInt == 3) {
        a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      }
    }
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    if ((paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 == 2)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberShareSrcInOrOut-->relationtype is not discuss,uin=" + paramLong + ",bin=" + paramBoolean1 + ",relationType=" + paramInt1 + ",isPPT=" + paramBoolean2);
      }
    }
    label158:
    do
    {
      return;
      if (paramLong == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((a()) || (paramLong != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())) {
          break label158;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "ScreenShare launcher shoult not display content");
        return;
      }
      ??? = a(String.valueOf(paramLong));
      if (??? != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
    return;
    if (paramBoolean1)
    {
      VideoViewInfo localVideoViewInfo1 = new VideoViewInfo();
      if (paramBoolean2) {
        ((VideoController.GAudioFriends)???).jdField_b_of_type_Int = 2;
      }
      for (;;)
      {
        localVideoViewInfo1.jdField_a_of_type_Long = paramLong;
        localVideoViewInfo1.jdField_a_of_type_Int = 2;
        localVideoViewInfo1.jdField_a_of_type_Boolean = true;
        localVideoViewInfo1.jdField_b_of_type_Boolean = false;
        long l1;
        VideoViewInfo localVideoViewInfo3;
        if (paramInt1 != 0)
        {
          l1 = 4L;
          localVideoViewInfo1.jdField_b_of_type_Long = l1;
          if (a().a(paramLong, localVideoViewInfo1.jdField_a_of_type_Int) != -1) {
            break;
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
          localVideoViewInfo1.jdField_c_of_type_Boolean = true;
          if (a().jdField_c_of_type_JavaUtilArrayList.size() <= 1) {
            break label489;
          }
          localVideoViewInfo3 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
        }
        synchronized (a().jdField_d_of_type_JavaUtilArrayList)
        {
          a().jdField_d_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
          a().a(localVideoViewInfo3);
          return;
          ((VideoController.GAudioFriends)???).jdField_b_of_type_Int = 1;
          continue;
          l1 = 5L;
        }
      }
      label489:
      a().a(0, localVideoViewInfo2);
      return;
    }
    ((VideoController.GAudioFriends)???).jdField_b_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    u();
  }
  
  private void a(Intent paramIntent)
  {
    AVCallCompactHelper localAVCallCompactHelper = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (localAVCallCompactHelper != null) {
      localAVCallCompactHelper.a(paramIntent);
    }
    long l1 = 0L;
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      l1 = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramIntent, true);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "startInviteForGroup canStartActivityNow[" + true + "], timeout[" + l1 + "]");
    }
  }
  
  private void a(Intent paramIntent, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVCallCompactHelper localAVCallCompactHelper = a();
    VideoUtils.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772193, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
      if (localAVCallCompactHelper != null) {
        localAVCallCompactHelper.a(paramIntent);
      }
      if (!paramBoolean2) {
        break label201;
      }
      a(paramString, "screenState", String.valueOf(2));
    }
    for (;;)
    {
      a(paramString, "inviteUIState", String.valueOf(1));
      long l1 = 0L;
      if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
        l1 = this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramIntent, true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CompatModeTag", 2, "startInvite  canStartActivityNow[" + true + "], timeout[" + l1 + "]");
      }
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
      break;
      label201:
      a(paramString, "screenState", String.valueOf(1));
    }
  }
  
  private void a(ArrayList<VideoViewInfo> paramArrayList, int paramInt)
  {
    int i4 = 0;
    int i1;
    if (a().N == 3)
    {
      i1 = 1;
      if (a().jdField_d_of_type_Int != 4) {
        break label173;
      }
    }
    label173:
    for (int i2 = 1;; i2 = 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        i4 = 1;
      }
      int i3 = paramInt;
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
              VideoViewInfo localVideoViewInfo = (VideoViewInfo)paramArrayList.get(paramInt);
              paramArrayList.set(paramInt, paramArrayList.get(i1));
              paramArrayList.set(i1, localVideoViewInfo);
              i3 = i1;
            }
          }
        }
      }
      paramArrayList.remove(i3);
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequest_ShowVideo,in removeChildrenWithStytle infoLogs[" + a(a().jdField_c_of_type_JavaUtilArrayList) + "]");
      }
      return;
      i1 = 0;
      break;
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    VideoController.GAudioFriends localGAudioFriends = a(String.valueOf(paramLong));
    if (localGAudioFriends == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    localGAudioFriends.jdField_a_of_type_Boolean = paramBoolean;
    localGAudioFriends.jdField_a_of_type_Int = paramInt;
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
  
  public static boolean b(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  public static int d(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences(jdField_f_of_type_JavaLangString, 0);
    int i1 = ((SharedPreferences)localObject).getInt(paramString, 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, i1 + 1);
    ((SharedPreferences.Editor)localObject).commit();
    return i1;
  }
  
  private boolean d(String paramString)
  {
    if (paramString == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return false;
      localSessionInfo = SessionMgr.a().a();
    } while ((localSessionInfo == null) || (localSessionInfo.jdField_d_of_type_JavaLangString == null) || (!paramString.equals(localSessionInfo.jdField_d_of_type_JavaLangString)));
    return true;
  }
  
  private boolean s()
  {
    WindowManager localWindowManager = (WindowManager)a().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    int i3 = localWindowManager.getDefaultDisplay().getRotation();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isLandscape screenWidth: " + i1 + ", screenHeight: " + i2 + ", rotation: " + i3 + ", orientation: " + this.jdField_n_of_type_Int);
    }
    return (i1 > i2) || (i3 == 1) || (i3 == 3) || (this.jdField_n_of_type_Int == 4) || (this.jdField_n_of_type_Int == 2);
  }
  
  public void A()
  {
    long l1 = (System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000L;
    ReportController.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    ReportController.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_d_of_type_Long = 0L;
  }
  
  public void B()
  {
    if (this.jdField_e_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_e_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_ComTencentAvMatchedUser == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentAvMatchedUser.jdField_a_of_type_JavaLangString)
    {
      ReportController.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
      this.jdField_e_of_type_Long = 0L;
      return;
    }
  }
  
  public void C()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "playRecordVoice, seq[" + l1 + "]");
    }
    a(l1, 2131230739, 1, null);
  }
  
  public void D()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "playRecordDing, seq[" + l1 + "]");
    }
    if (q())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + "Q.nearby.video_chat", 2, "not playRing");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230738, null, 1, null);
  }
  
  void E()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.sdk.onRequestVideo");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void F()
  {
    SessionInfo localSessionInfo = a();
    long l1 = AudioHelper.b();
    String str;
    int i1;
    if ((localSessionInfo.l()) || (localSessionInfo.m()) || (localSessionInfo.jdField_g_of_type_Int == 9) || (localSessionInfo.n()))
    {
      SmallScreenUtils.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = localSessionInfo.jdField_c_of_type_JavaLangString;
      i1 = localSessionInfo.jdField_d_of_type_Int;
      if (localSessionInfo.jdField_g_of_type_Int == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i1, false, bool, localSessionInfo.x());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reNotifyChatInfo2QQ, sessionInfo[" + localSessionInfo + "]");
      return;
    }
  }
  
  public void G()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a();
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl.i();
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl = null;
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      k();
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!a().l()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setGroundGlassSwitch(a().jdField_d_of_type_JavaLangString, paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AVLog.printColorLog(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setNativeGatewayTestResult(paramInt1, paramInt2, paramInt3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioDataFormat(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return -1;
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramLong == 0L)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "startGAudioChat, relationId illegal.");
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      k();
    }
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    AVLog.printInfoLog("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().D);
    AudioHelper.b("startGAudioChat ");
    c(false);
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder().append("startGAudioChat, relationType[").append(paramInt1).append("], relationId[").append(paramLong).append("], businessId[").append(paramInt2).append("], uinList[").append(paramArrayOfLong).append("], isVideo[").append(paramBoolean).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      bool = true;
      localObject2 = ((StringBuilder)localObject2).append(bool).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label235;
      }
    }
    label235:
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label241;
      }
      return -1;
      bool = false;
      break;
    }
    label241:
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return -1;
    }
    localObject1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l1;
    int i2;
    int i1;
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((SessionInfo)localObject2).F = paramInt1;
        ((SessionInfo)localObject2).D = paramInt2;
        localObject1 = localObject2;
      }
      this.jdField_m_of_type_Boolean = false;
      l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      if ((paramInt1 != 7) && (paramInt1 != 9)) {
        break label609;
      }
      i2 = 1;
      i1 = paramInt2;
      paramInt2 = i2;
    }
    for (;;)
    {
      label372:
      localObject1 = a();
      if (paramBoolean) {
        paramInt2 = 2;
      }
      if ((((SessionInfo)localObject1).J) && (((SessionInfo)localObject1).aI)) {
        paramInt2 = 5;
      }
      for (;;)
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_j_of_type_Boolean);
        }
        J();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().b(), a().jdField_P_of_type_Int, a().jdField_O_of_type_Int, a().jdField_ad_of_type_Int);
        if (this.jdField_j_of_type_JavaLangRunnable == null) {
          this.jdField_j_of_type_JavaLangRunnable = new VideoController.26(this, paramInt1, paramLong);
        }
        this.jdField_r_of_type_Boolean = true;
        ((SessionInfo)localObject1).a("startGAudioChat.2", 8);
        ((SessionInfo)localObject1).jdField_g_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
        g();
        a(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString, 3, false, false, false);
        return 0;
        localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
        break;
        label609:
        if (paramInt1 == 2)
        {
          if (a().jdField_j_of_type_Boolean) {}
          for (paramInt2 = 2;; paramInt2 = 1)
          {
            i1 = 1;
            break;
          }
        }
        if (paramInt1 == 1)
        {
          i1 = a().D;
          if (a().jdField_j_of_type_Boolean) {}
          for (paramInt2 = 2;; paramInt2 = 1) {
            break;
          }
        }
        if (paramInt1 == 10)
        {
          i2 = 1;
          i1 = paramInt2;
          paramInt2 = i2;
          break label372;
        }
        if (paramInt1 == 3)
        {
          if (localObject1 == null) {
            break label781;
          }
          ((SessionInfo)localObject1).jdField_g_of_type_Long = paramLong;
          ((SessionInfo)localObject1).F = paramInt1;
          ((SessionInfo)localObject1).D = paramInt2;
          ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
          ((SessionInfo)localObject1).jdField_j_of_type_Int = 0;
          ((SessionInfo)localObject1).e("startGAudioChat", true);
          i2 = 1;
          i1 = paramInt2;
          paramInt2 = i2;
          break label372;
        }
        return -1;
        if (((SessionInfo)localObject1).b()) {
          paramInt2 = 3;
        }
      }
      label781:
      i2 = 1;
      i1 = paramInt2;
      paramInt2 = i2;
    }
  }
  
  public int a(int paramInt, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    if (paramAVFunChatMessage == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "sendAVFunChatMsg, msg is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "sendAVFunChatMsg, toUin[" + a().jdField_d_of_type_JavaLangString + "], msg[" + paramAVFunChatMessage.uint64_type.get() + ", " + paramAVFunChatMessage.enum_operator.get() + ", " + paramAVFunChatMessage.str_msg.get() + "]");
    }
    return a(paramInt, paramAVFunChatMessage.toByteArray());
  }
  
  public int a(int paramInt, String paramString)
  {
    boolean bool = a().l();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendAVFunChatMsg, type[" + paramInt + "], data[" + paramString + "], isConnected[" + bool + "]");
    if (!bool) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_d_of_type_JavaLangString, paramInt, paramString);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.registerAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = a().l();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("sendAVFunChatMsg, type[").append(paramInt).append("], isConnected[").append(bool).append("], dataLen[");
      if (paramArrayOfByte != null) {
        break label90;
      }
    }
    label90:
    for (int i1 = 0;; i1 = paramArrayOfByte.length)
    {
      QLog.i(str, 2, i1 + "]");
      if (bool) {
        break;
      }
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_d_of_type_JavaLangString, paramInt, paramArrayOfByte);
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
      finally {}
      i1 += 1;
    }
  }
  
  public int a(long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendSelectVideoModeRequest(paramLong, paramInt);
  }
  
  public int a(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ??? = jdField_a_of_type_JavaLangString + "|VideoNodeManager";
    StringBuilder localStringBuilder = new StringBuilder().append("acceptGAudioChat, relationType[").append(paramInt).append("], relationId[").append(paramLong2).append("], isVideo[").append(paramBoolean).append("], relationId[").append(paramLong2).append("], mIsStartGAuio[").append(this.jdField_r_of_type_Boolean).append("], uinList[");
    if (paramArrayOfLong != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], mGAudioCtrl[");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)???, 1, bool + "], seq[" + paramLong1 + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        k();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label192;
      }
      return -1;
      bool = false;
      break;
    }
    label192:
    i(false);
    c(false);
    this.jdField_m_of_type_Boolean = false;
    for (;;)
    {
      int i2;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        a().a("acceptGAudioChat", 8);
        a().jdField_g_of_type_Long = paramLong2;
        a().aj = true;
        a().at = true;
        paramLong1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        i2 = 2;
        if (paramInt != 2) {
          break label456;
        }
        i2 = 1;
        if (a().jdField_j_of_type_Boolean)
        {
          i1 = 2;
          if (paramBoolean) {
            i1 = 2;
          }
          if (AudioHelper.e()) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "acceptGAudioChat, MainSession[" + a() + "]");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i2, i1, paramLong2, paramArrayOfLong, c(), paramLong1, a().jdField_O_of_type_Int);
          if (this.jdField_j_of_type_JavaLangRunnable == null) {
            this.jdField_j_of_type_JavaLangRunnable = new VideoController.27(this, paramInt, paramLong2);
          }
          this.jdField_r_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
          g();
          return 0;
        }
      }
      int i1 = 1;
      continue;
      label456:
      if (paramInt == 1)
      {
        i2 = a().D;
        if (a().jdField_j_of_type_Boolean) {}
        for (i1 = 2;; i1 = 1) {
          break;
        }
      }
      if (paramInt == 3)
      {
        i2 = 8;
        i1 = 1;
      }
      else
      {
        i1 = 2;
      }
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo acceptRequest, peerUin[" + paramString + "], businessType[" + paramInt1 + "], relationType[" + paramInt2 + "], uiMode[" + this.jdField_f_of_type_Int + "], seq[" + paramLong + "]");
    if ((q()) && (this.jdField_f_of_type_Int != 3) && (!paramString.equals(a().jdField_d_of_type_JavaLangString)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,is nearby");
      return -1;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,network not support");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    Object localObject = a();
    if ((localObject != null) && (1 == ((JniSimpleInfoMng)localObject).a(AVUtil.a(paramString), false, false))) {
      AVUtil.a("0X800B62B", 0, 0, "", "", "", "");
    }
    localObject = a(paramInt2, paramString);
    if (localObject == null) {
      localObject = a();
    }
    for (;;)
    {
      i(false);
      if ((((SessionInfo)localObject).jdField_j_of_type_Int == 1011) || (((SessionInfo)localObject).jdField_j_of_type_Int == 21)) {
        a(paramLong, 15000L);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
      if (paramInt1 == 0) {
        paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 0, paramInt2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "acceptRequest, result[" + paramInt1 + "], peerUin[" + paramString + "], relationType[" + paramInt2 + "], session[" + localObject + "]");
        }
        if (paramInt1 == 0)
        {
          ((SessionInfo)localObject).a("acceptRequest", 3);
          i();
        }
        this.jdField_a_of_type_ComTencentAvQavChannelProxy.a();
        ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
        VideoNodeManager.a(37);
        return paramInt1;
        if (1 == paramInt1) {
          paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 2, paramInt2);
        } else {
          paramInt1 = -1;
        }
      }
    }
  }
  
  public int a(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10)
  {
    String str = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder().append("avideo request, selfUin[").append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).append("], peerUin[").append(paramString1).append("], businessType[").append(paramInt1).append("], relationType[").append(paramInt2).append("], fromNation[").append(paramString2).append("], fromMobile[").append(paramString3).append("], toMobile[").append(paramString4).append("], uinType[").append(paramInt3).append("], extraUin[").append(paramString5).append("], sig[");
    if (paramArrayOfByte != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], bindID[" + paramString8 + "], bindType[" + paramInt4 + "], subServiceType[" + paramInt5 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + paramLong + "]");
      AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (paramArrayOfByte != null) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request sigLength: " + paramArrayOfByte.length);
      }
      if (NetworkUtil.d(BaseApplication.getContext())) {
        break;
      }
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
    int i2 = a(paramInt3, true, 1);
    if (i2 == -1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail, accostType = " + i2);
      return -1;
    }
    paramString1 = a();
    if ((paramString1.j()) && (paramString1.jdField_d_of_type_JavaLangString != null) && (str.equals(paramString1.jdField_d_of_type_JavaLangString)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,----already receive invite, return~");
      paramString1.jdField_e_of_type_Boolean = true;
      return -1;
    }
    int i1;
    long l1;
    long l2;
    if (paramInt3 == 9500)
    {
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.a("request");
      i1 = -1;
      l1 = 0L;
      if (paramString1.ak)
      {
        l1 = paramString1.jdField_i_of_type_Long;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "request, startTerminalSwitchTimeOutCheck, oldRoomId[" + l1 + "], seq[" + paramLong + "]");
        e();
      }
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request funcall buffer:" + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      VideoNodeManager.a(28);
      VideoNodeManager.a(11, str);
      VideoNodeManager.a(12, 1L);
      if (!paramString1.S) {
        break label1040;
      }
      l2 = 1L;
      label623:
      VideoNodeManager.a(13, l2);
      VideoNodeManager.a(15, 1L);
      J();
      if ((paramString1.jdField_j_of_type_Int != 1011) && (paramString1.jdField_j_of_type_Int != 21)) {
        break label1054;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      paramString1.S = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label1048;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label751:
      AVReport.a().jdField_o_of_type_Boolean = paramString1.S;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "request result = " + i1 + ", uinType = " + paramInt3 + ", accostType = " + i2);
      if (i1 == 0)
      {
        paramString1.a("request", 1);
        paramString1.jdField_j_of_type_Int = paramInt3;
        paramString1.jdField_k_of_type_Int = i2;
        if ((paramString1.jdField_d_of_type_Int != 3) && (paramString1.jdField_d_of_type_Int != 4)) {
          paramString1.a(paramLong, SystemClock.elapsedRealtime());
        }
        g();
        if (!paramString1.S) {
          break label1457;
        }
      }
    }
    label1040:
    label1048:
    label1054:
    label1457:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      for (;;)
      {
        a(paramString1.jdField_c_of_type_JavaLangString, paramInt1, false, false, true);
        paramString1.jdField_o_of_type_Int = -1;
        this.jdField_k_of_type_Boolean = false;
        a(paramLong, paramString1.jdField_d_of_type_JavaLangString);
        b();
        paramString1.ai = false;
        a(str, 2, paramString1.jdField_a_of_type_Long);
        a(str, 1, 0L);
        a("deviceMemory", VideoNodeManager.c() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.a(a()));
        if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
          this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
        }
        this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor = new VideoCallStateMonitor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
        return i1;
        this.jdField_a_of_type_ComTencentAvQavChannelProxy.c();
        this.w = true;
        break;
        l2 = 2L;
        break label623;
        i1 = 0;
        break label751;
        if (paramInt3 == 9500)
        {
          paramInt4 = 4200;
          try
          {
            l1 = CharacterUtil.a(str);
            if (!TextUtils.isEmpty(paramString6)) {
              paramInt4 = Integer.valueOf(paramString6).intValue();
            }
            if (QLog.isColorLevel()) {
              QLog.d("SDVideo", 2, "request smart tv " + paramInt4);
            }
            paramString1.S = false;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(c());
            i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestFromUnQQ(l1, paramInt1, paramInt2, paramInt4);
          }
          catch (NumberFormatException paramString1)
          {
            paramString1.printStackTrace();
            QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,NumberFormatException ", paramString1);
            return -1;
          }
        }
      }
      if (paramInt1 == 0)
      {
        paramString1.S = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = C2BUserInfo.a(paramString10);
          if (paramString10 != null) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number");
          }
          for (paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9, paramString10);; paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9))
          {
            i1 = paramInt1;
            break;
            QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number is null");
          }
        }
        i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
        break label751;
      }
      if (1 != paramInt1) {
        break label751;
      }
      paramString1.S = false;
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      break label751;
    }
  }
  
  public int a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    NetAddr[] arrayOfNetAddr = null;
    if (paramList != null) {
      arrayOfNetAddr = (NetAddr[])paramList.toArray(new NetAddr[paramList.size()]);
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendRecordingRequest(paramLong1, paramBoolean, arrayOfNetAddr, paramLong2);
  }
  
  public int a(SessionInfo paramSessionInfo, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramSessionInfo, paramString);
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.UpdateSelfUin(paramString);
    }
    return -1;
  }
  
  int a(String paramString, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      i1 = -1;
    }
    while (!this.jdField_d_of_type_Boolean) {
      return i1;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
      paramString = paramString + "_stopOrStartGAudioTRAE_stop";
      this.z = this.jdField_l_of_type_Boolean;
      a(paramString, false, false);
      a(paramString, true);
      c(paramString, 1);
      return 0;
    }
    paramString = paramString + "_stopOrStartGAudioTRAE";
    if (!this.z)
    {
      paramBoolean = true;
      a(paramString, paramBoolean, false);
      a(paramString, this.z);
      if (!this.z) {
        break label164;
      }
    }
    label164:
    for (i1 = i2;; i1 = 0)
    {
      c(paramString, i1);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      return 0;
      paramBoolean = false;
      break;
    }
  }
  
  int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(AudioHelper.b(), paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = paramBoolean;
      return 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
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
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioInputMute(paramString, paramBoolean);
  }
  
  public long a()
  {
    if (a().jdField_e_of_type_Long == 0L) {
      return 0L;
    }
    long l1 = (SystemClock.elapsedRealtime() - a().jdField_e_of_type_Long) / 1000L + a().jdField_f_of_type_Long;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1);
    return l1;
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramInt1, paramInt2, paramLong);
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getGAudioRoomId, result[" + localRespInfo.uint32_result.get() + "], uint64_roomId[" + localRespInfo.gAudioInfo.uint64_roomId.get() + "]");
    }
    return localRespInfo.gAudioInfo.uint64_roomId.get();
  }
  
  public long a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return 0L;
    }
    long l1 = paramSessionInfo.b();
    switch (paramSessionInfo.jdField_d_of_type_Int)
    {
    default: 
      return l1;
    }
    return a(paramSessionInfo.jdField_d_of_type_JavaLangString);
  }
  
  public long a(String paramString)
  {
    long l1 = 0L;
    SessionInfo localSessionInfo = SessionMgr.a().a(paramString);
    if ((localSessionInfo != null) && (localSessionInfo.b() != 0L)) {
      l1 = localSessionInfo.b();
    }
    long l2;
    do
    {
      do
      {
        return l1;
      } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
      l2 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getChatRoomId(paramString);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "retry to get room id. new room id = " + l2);
      l1 = l2;
    } while (localSessionInfo == null);
    localSessionInfo.d(l2);
    return l2;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestStrangerFace: " + paramString + ", uinType = " + a().jdField_j_of_type_Int);
    }
    Bitmap localBitmap = a(paramString, false);
    if (localBitmap != null) {
      return localBitmap;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString, a().jdField_j_of_type_Int);
    return null;
  }
  
  public Bitmap a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1004;
    int i1;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1)) {
      i1 = 0;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, paramString1, paramString2, paramBoolean2, paramBoolean1);
      if (paramInt == 1)
      {
        i1 = 1000;
      }
      else
      {
        i1 = i2;
        if (paramInt == 2) {
          i1 = i2;
        }
      }
    }
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", anonymous: " + paramBoolean);
    }
    if (paramString == null) {}
    label127:
    do
    {
      VideoController.GAudioFriends localGAudioFriends;
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (a().jdField_j_of_type_Int == 25);
            if (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
              break label127;
            }
            if (!paramBoolean) {
              break;
            }
          } while (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap;
        if (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 3) {
          break;
        }
        localGAudioFriends = a(paramString);
      } while ((localGAudioFriends == null) || (localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1) || (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController.GAudioFriends a(String paramString)
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
          if ((localGAudioFriends == null) || (localGAudioFriends.jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = localGAudioFriends;
          return paramString;
        }
      }
      finally {}
      paramString = null;
      continue;
      label74:
      i1 += 1;
    }
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_a_of_type_ComTencentAvSessionMgr.b());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_ComTencentAvSessionMgr.b()))
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(l1, paramString2, paramString3);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "quaReport --> updateProcessInfo peerUin = " + l1 + ",key = " + paramString2 + ",value = " + paramString3);
        }
      }
      return this;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramString1));
        l1 = l2;
      }
    }
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
    JniSimpleInfoMng localJniSimpleInfoMng = null;
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      localJniSimpleInfoMng = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getJniSimpleInfo();
    }
    return localJniSimpleInfoMng;
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
      L();
    }
    return this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController;
  }
  
  public qav_gvideo_sdk_transfer.RespInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = new qav_gvideo_sdk_transfer.RespInfo();
    i1 = -101;
    int i2 = i1;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.postData(paramInt, paramArrayOfByte);
        i2 = i1;
      }
      catch (Throwable paramArrayOfByte)
      {
        try
        {
          localRespInfo.mergeFrom(paramArrayOfByte);
          return localRespInfo;
        }
        catch (Throwable paramArrayOfByte)
        {
          for (;;)
          {
            i1 = -102;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
      }
      if (QLog.isDevelopLevel())
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "postData exception , event[" + paramInt + "]", paramArrayOfByte);
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
      if ((localAVPbInfo != null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processQCallPush result, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
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
    ArrayList localArrayList2;
    HashSet localHashSet;
    Object localObject4;
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Object localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
      localObject3 = b();
      if (((ArrayList)localObject1).size() == 0)
      {
        localObject1 = new Pair(Integer.valueOf(0), null);
        return localObject1;
      }
      localArrayList2 = new ArrayList();
      localHashSet = new HashSet();
      localObject4 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject4).next();
        localGAudioFriends.jdField_h_of_type_Boolean = true;
        localArrayList2.add(localGAudioFriends);
        localHashSet.add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
      }
    }
    int i1 = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (VideoController.GAudioFriends)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((VideoController.GAudioFriends)localObject4).jdField_a_of_type_Long)))
      {
        ((VideoController.GAudioFriends)localObject4).jdField_h_of_type_Boolean = false;
        localArrayList2.add(localObject4);
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "updateMemberAttendedInfo joint number size:=" + localObject2.size() + ";all members:=" + localArrayList2.size());
    Pair localPair = new Pair(Integer.valueOf(i1), localArrayList2);
    return localPair;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getAVGQuality();
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getPhoneNameByPhoneNum --> phoneNum = " + paramString);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString);
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int i2 = 1004;
    int i1;
    if (paramInt == 1) {
      i1 = 1000;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, paramString1, paramString2);
      i1 = i2;
      if (paramInt != 2)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1)) {
          i1 = 0;
        }
      }
    }
  }
  
  public String a(ArrayList<VideoViewInfo> paramArrayList)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = "VideoViewInfo[0]";
      return localObject;
    }
    String str = "VideoViewInfo[" + paramArrayList.size() + "]\n";
    int i1 = 0;
    for (;;)
    {
      localObject = str;
      if (i1 >= paramArrayList.size()) {
        break;
      }
      str = str + i1 + ", " + paramArrayList.get(i1) + "\n";
      i1 += 1;
    }
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
    long l1 = System.currentTimeMillis();
    if (paramInt > 8) {}
    ArrayList localArrayList1;
    long l2;
    for (int i1 = 1;; i1 = 0)
    {
      localArrayList1 = new ArrayList(8);
      l2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin();
      localObject2 = null;
      localObject1 = null;
      if (i1 != 0) {
        break;
      }
      i2 = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i2 >= paramArrayList.size()) {
          break;
        }
        localObject2 = localObject1;
        if (i2 >= 8) {
          break;
        }
        localObject2 = (VideoController.GAudioFriends)paramArrayList.get(i2);
        if (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long == l2) {
          localObject1 = localObject2;
        }
        localArrayList1.add(localObject2);
        i2 += 1;
      }
    }
    int i2 = 0;
    Object localObject1 = localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i2 >= paramInt) {
        break;
      }
      localObject2 = (VideoController.GAudioFriends)paramArrayList.get(i2);
      if (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long == l2) {
        localObject1 = localObject2;
      }
      localArrayList1.add(localObject2);
      i2 += 1;
    }
    localObject1 = new ArrayList();
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject2 = new ArrayList();
    i2 = 0;
    if (i2 < paramInt)
    {
      long l3 = ((VideoController.GAudioFriends)localArrayList1.get(i2)).jdField_a_of_type_Long;
      if (l3 == l2) {}
      for (;;)
      {
        i2 += 1;
        break;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l3))) {
          ((ArrayList)localObject1).add(localArrayList1.get(i2));
        } else {
          ((ArrayList)localObject2).add(localArrayList1.get(i2));
        }
      }
    }
    if (!((ArrayList)localObject2).isEmpty())
    {
      Collections.sort((List)localObject2, new VideoController.32(this));
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    if (i1 != 0)
    {
      while (paramInt < paramArrayList.size())
      {
        ((ArrayList)localObject1).add(paramArrayList.get(paramInt));
        paramInt += 1;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "InviteMemberList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - l1));
      return localObject1;
    }
    localObject2 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramInt < localArrayList1.size())
    {
      l2 = ((VideoController.GAudioFriends)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l2))) {
        ((ArrayList)localObject2).add(localArrayList1.get(paramInt));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localArrayList2.add(localArrayList1.get(paramInt));
      }
    }
    if (!localArrayList2.isEmpty())
    {
      Collections.sort(localArrayList2, new VideoController.33(this));
      ((ArrayList)localObject2).addAll(localArrayList2);
    }
    if (!((ArrayList)localObject2).isEmpty()) {
      ((ArrayList)localObject1).addAll((Collection)localObject2);
    }
    if (paramArrayList.size() > 8)
    {
      paramInt = 8;
      while (paramInt < paramArrayList.size())
      {
        ((ArrayList)localObject1).add(paramArrayList.get(paramInt));
        paramInt += 1;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "InviteMemberList listSort not exceedMaxNumber cost" + (System.currentTimeMillis() - l1));
    return localObject1;
  }
  
  public ArrayList<Long> a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    for (;;)
    {
      int i1;
      VideoController.GAudioFriends localGAudioFriends;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 >= i2) {
          break label152;
        }
        localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (localGAudioFriends == null) {
          break label158;
        }
        if (localGAudioFriends.jdField_a_of_type_Long == paramLong1)
        {
          if (!localGAudioFriends.jdField_e_of_type_Boolean)
          {
            localGAudioFriends.jdField_g_of_type_Boolean = paramBoolean;
            localGAudioFriends.jdField_c_of_type_Long = l1;
            localGAudioFriends.jdField_d_of_type_Long = paramLong2;
          }
        }
        else
        {
          if (!localGAudioFriends.jdField_g_of_type_Boolean) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
        }
      }
      if (localGAudioFriends.jdField_g_of_type_Boolean)
      {
        localGAudioFriends.jdField_g_of_type_Boolean = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i1 += 1;
      }
    }
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNetWorkTimer");
    }
    if (this.y) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.y = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onApnChanged netType = " + paramInt);
    }
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label145;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        int i1 = c();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
      }
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && ((paramInt == 1) || (paramInt == 2))) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(c());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(21), Integer.valueOf(paramInt) });
      return;
      label145:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Long = paramInt3;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.31(this, paramInt1, paramInt2, paramInt3));
      }
    }
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    String str = paramInt2 + "|" + paramInt3 + "|" + paramLong;
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramInt1, str.getBytes());
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "kickOutUsers, event[" + paramInt1 + "], result[" + localRespInfo.uint32_result.get() + "], data[" + str + "]");
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setRandomChatStatus: " + paramInt1 + ", chatType" + paramInt2 + " ,sessionName: " + paramString);
    }
    Object localObject = a();
    if (localObject != null) {
      ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int = paramInt2;
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.v2q.setChatStatus");
    ((Intent)localObject).putExtra("status", paramInt1);
    ((Intent)localObject).putExtra("type", paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      ((Intent)localObject).putExtra("sessionName", paramString);
    }
    if (m())
    {
      ((Intent)localObject).putExtra("guild_group_id", a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", h());
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_b_of_type_JavaLangString);
    }
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
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
  
  /* Error */
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 750	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 128	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 16
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 737	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 640	com/tencent/av/SessionMgr:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 15
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +1958 -> 1986
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 737	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 640	com/tencent/av/SessionMgr:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 15
    //   45: aload_0
    //   46: getfield 122	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvSessionMgr	Lcom/tencent/av/SessionMgr;
    //   49: aload 15
    //   51: invokevirtual 643	com/tencent/av/SessionMgr:c	(Ljava/lang/String;)Lcom/tencent/av/app/SessionInfo;
    //   54: astore 17
    //   56: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 87	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 18
    //   67: new 432	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 433	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 2194
    //   77: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 447	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 760
    //   87: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2196
    //   97: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2198
    //   108: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 15
    //   113: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 584
    //   119: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 447	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2200
    //   130: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 19
    //   135: aload 16
    //   137: ifnull +55 -> 192
    //   140: iconst_1
    //   141: istore 14
    //   143: aload 18
    //   145: iconst_1
    //   146: aload 19
    //   148: iload 14
    //   150: invokevirtual 442	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2202
    //   156: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 17
    //   161: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 610
    //   167: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 612	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 15
    //   178: ldc_w 2204
    //   181: invokestatic 2208	com/tencent/av/screenshare/ScreenShareReportHelper:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 16
    //   186: ifnonnull +12 -> 198
    //   189: aload_0
    //   190: monitorexit
    //   191: return
    //   192: iconst_0
    //   193: istore 14
    //   195: goto -52 -> 143
    //   198: aload 17
    //   200: ifnull -11 -> 189
    //   203: getstatic 354	android/os/Build$VERSION:SDK_INT	I
    //   206: bipush 21
    //   208: if_icmplt +44 -> 252
    //   211: aload_0
    //   212: getfield 2016	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvUiScreenRecordHelper	Lcom/tencent/av/ui/ScreenRecordHelper;
    //   215: astore 18
    //   217: aload 18
    //   219: ifnull +17 -> 236
    //   222: aload 18
    //   224: invokevirtual 2209	com/tencent/av/ui/ScreenRecordHelper:c	()Z
    //   227: ifeq +9 -> 236
    //   230: aload 18
    //   232: iconst_4
    //   233: invokevirtual 2210	com/tencent/av/ui/ScreenRecordHelper:a	(I)V
    //   236: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +13 -> 252
    //   242: getstatic 87	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   245: iconst_2
    //   246: ldc_w 2212
    //   249: invokestatic 369	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload 16
    //   254: invokevirtual 2215	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/chatroom/ChatRoomMng;
    //   257: astore 18
    //   259: aload 18
    //   261: ifnull +10 -> 271
    //   264: aload 18
    //   266: aload 17
    //   268: invokevirtual 2220	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/app/SessionInfo;)V
    //   271: aload 16
    //   273: invokevirtual 512	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   276: aload_0
    //   277: getfield 288	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   280: invokevirtual 518	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 288	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   288: aload_0
    //   289: getfield 252	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   292: ifnull +20 -> 312
    //   295: aload 16
    //   297: invokevirtual 512	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   300: aload_0
    //   301: getfield 252	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   304: invokevirtual 518	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   307: aload_0
    //   308: aconst_null
    //   309: putfield 252	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   312: aload_0
    //   313: getfield 258	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   316: ifnull -127 -> 189
    //   319: aload 16
    //   321: iconst_4
    //   322: anewarray 4	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: sipush 203
    //   330: invokestatic 814	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: lload_2
    //   337: invokestatic 737	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   340: aastore
    //   341: dup
    //   342: iconst_2
    //   343: aload_0
    //   344: getfield 124	com/tencent/av/VideoController:jdField_a_of_type_Boolean	Z
    //   347: invokestatic 890	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   350: aastore
    //   351: dup
    //   352: iconst_3
    //   353: lload 12
    //   355: invokestatic 817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   358: aastore
    //   359: invokevirtual 820	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   362: aload_0
    //   363: invokevirtual 461	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   366: getfield 2222	com/tencent/av/app/SessionInfo:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   369: invokevirtual 860	java/util/ArrayList:size	()I
    //   372: ifle +21 -> 393
    //   375: aload_0
    //   376: invokevirtual 461	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   379: getfield 801	com/tencent/av/app/SessionInfo:ae	Z
    //   382: ifeq +11 -> 393
    //   385: aload_0
    //   386: iconst_2
    //   387: iconst_0
    //   388: iconst_0
    //   389: lconst_0
    //   390: invokevirtual 2224	com/tencent/av/VideoController:a	(IIIJ)V
    //   393: iload_1
    //   394: iconst_2
    //   395: if_icmpne +149 -> 544
    //   398: aload 17
    //   400: getfield 801	com/tencent/av/app/SessionInfo:ae	Z
    //   403: ifne +141 -> 544
    //   406: aload 17
    //   408: getfield 2222	com/tencent/av/app/SessionInfo:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   411: ifnull +133 -> 544
    //   414: new 899	android/content/Intent
    //   417: dup
    //   418: invokespecial 900	android/content/Intent:<init>	()V
    //   421: astore 18
    //   423: aload 18
    //   425: ldc_w 902
    //   428: invokevirtual 906	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   431: pop
    //   432: aload 18
    //   434: ldc_w 908
    //   437: sipush 411
    //   440: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   443: pop
    //   444: aload 18
    //   446: ldc_w 2226
    //   449: aload_0
    //   450: invokevirtual 461	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   453: getfield 2222	com/tencent/av/app/SessionInfo:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   456: invokevirtual 2229	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   459: pop
    //   460: aload 18
    //   462: ldc_w 911
    //   465: aload_0
    //   466: invokevirtual 461	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   469: getfield 1401	com/tencent/av/app/SessionInfo:F	I
    //   472: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   475: pop
    //   476: aload 18
    //   478: ldc_w 913
    //   481: aload_0
    //   482: invokevirtual 461	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   485: getfield 806	com/tencent/av/app/SessionInfo:jdField_g_of_type_Long	J
    //   488: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   491: pop
    //   492: aload 18
    //   494: ldc_w 920
    //   497: aload_0
    //   498: invokevirtual 461	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   501: getfield 798	com/tencent/av/app/SessionInfo:D	I
    //   504: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   507: pop
    //   508: aload 18
    //   510: ldc_w 972
    //   513: ldc_w 2231
    //   516: invokevirtual 977	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   519: pop
    //   520: aload 18
    //   522: aload 16
    //   524: invokevirtual 924	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   527: invokevirtual 929	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   530: invokevirtual 932	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   533: pop
    //   534: aload 16
    //   536: invokevirtual 924	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   539: aload 18
    //   541: invokevirtual 936	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   544: iload_1
    //   545: bipush 7
    //   547: if_icmpne +10 -> 557
    //   550: aload_0
    //   551: iconst_0
    //   552: iconst_0
    //   553: aconst_null
    //   554: invokevirtual 848	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   557: iload_1
    //   558: bipush 9
    //   560: if_icmpne +29 -> 589
    //   563: aload 17
    //   565: getfield 830	com/tencent/av/app/SessionInfo:jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info	Lcom/tencent/av/app/SessionInfo$Anychat_Info;
    //   568: iconst_0
    //   569: putfield 833	com/tencent/av/app/SessionInfo$Anychat_Info:jdField_b_of_type_Int	I
    //   572: aload_0
    //   573: iconst_0
    //   574: iconst_0
    //   575: aconst_null
    //   576: invokevirtual 848	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   579: aload 17
    //   581: invokevirtual 2232	com/tencent/av/app/SessionInfo:b	()V
    //   584: aload 17
    //   586: invokevirtual 2233	com/tencent/av/app/SessionInfo:a	()V
    //   589: iload_1
    //   590: bipush 10
    //   592: if_icmpne +13 -> 605
    //   595: aload 17
    //   597: invokevirtual 2232	com/tencent/av/app/SessionInfo:b	()V
    //   600: aload 17
    //   602: invokevirtual 2233	com/tencent/av/app/SessionInfo:a	()V
    //   605: iload_1
    //   606: iconst_2
    //   607: if_icmpne +996 -> 1603
    //   610: ldc_w 2235
    //   613: aload 17
    //   615: getfield 2237	com/tencent/av/app/SessionInfo:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   618: invokevirtual 1229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +30 -> 651
    //   624: aconst_null
    //   625: ldc_w 2239
    //   628: ldc 211
    //   630: ldc 211
    //   632: ldc_w 2241
    //   635: ldc_w 2241
    //   638: iconst_0
    //   639: iconst_0
    //   640: ldc 211
    //   642: ldc 211
    //   644: ldc 211
    //   646: ldc 211
    //   648: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload_0
    //   652: invokevirtual 2243	com/tencent/av/VideoController:h	()Z
    //   655: ifeq +30 -> 685
    //   658: aconst_null
    //   659: ldc_w 2239
    //   662: ldc 211
    //   664: ldc 211
    //   666: ldc_w 2245
    //   669: ldc_w 2245
    //   672: iconst_0
    //   673: iconst_0
    //   674: ldc 211
    //   676: ldc 211
    //   678: ldc 211
    //   680: ldc 211
    //   682: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   685: aload 17
    //   687: getfield 1408	com/tencent/av/app/SessionInfo:jdField_j_of_type_Boolean	Z
    //   690: ifeq +38 -> 728
    //   693: aconst_null
    //   694: ldc_w 2239
    //   697: ldc 211
    //   699: ldc 211
    //   701: ldc_w 2247
    //   704: ldc_w 2247
    //   707: iconst_0
    //   708: iconst_0
    //   709: ldc 211
    //   711: ldc 211
    //   713: ldc 211
    //   715: ldc 211
    //   717: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 17
    //   722: getfield 2248	com/tencent/av/app/SessionInfo:jdField_m_of_type_Boolean	Z
    //   725: ifeq +848 -> 1573
    //   728: aload_0
    //   729: getfield 290	com/tencent/av/VideoController:jdField_s_of_type_Boolean	Z
    //   732: ifeq +1257 -> 1989
    //   735: aload_0
    //   736: invokevirtual 2250	com/tencent/av/VideoController:a	()J
    //   739: lconst_0
    //   740: lcmp
    //   741: ifle +1248 -> 1989
    //   744: aconst_null
    //   745: ldc_w 2239
    //   748: ldc 211
    //   750: ldc 211
    //   752: ldc_w 2252
    //   755: ldc_w 2252
    //   758: iconst_0
    //   759: iconst_0
    //   760: ldc 211
    //   762: ldc 211
    //   764: aload_0
    //   765: invokevirtual 2250	com/tencent/av/VideoController:a	()J
    //   768: invokestatic 2256	com/tencent/av/utils/UITools:a	(J)Ljava/lang/String;
    //   771: ldc 211
    //   773: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   776: goto +1213 -> 1989
    //   779: getstatic 2259	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   782: ifne +24 -> 806
    //   785: iload 4
    //   787: bipush 69
    //   789: if_icmpeq +17 -> 806
    //   792: iload 4
    //   794: bipush 70
    //   796: if_icmpeq +10 -> 806
    //   799: iload 4
    //   801: bipush 71
    //   803: if_icmpne +1131 -> 1934
    //   806: aload_0
    //   807: ldc_w 2260
    //   810: putfield 284	com/tencent/av/VideoController:jdField_r_of_type_Int	I
    //   813: aload_0
    //   814: getfield 193	com/tencent/av/VideoController:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   817: ifnull +21 -> 838
    //   820: aload_0
    //   821: getfield 193	com/tencent/av/VideoController:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   824: new 2262	com/tencent/av/VideoController$28
    //   827: dup
    //   828: aload_0
    //   829: iload 5
    //   831: invokespecial 2265	com/tencent/av/VideoController$28:<init>	(Lcom/tencent/av/VideoController;I)V
    //   834: invokevirtual 795	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   837: pop
    //   838: aload_0
    //   839: getfield 282	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   842: astore 18
    //   844: aload 18
    //   846: monitorenter
    //   847: aload_0
    //   848: getfield 282	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   851: sipush 2000
    //   854: i2l
    //   855: invokevirtual 2268	java/lang/Object:wait	(J)V
    //   858: aload 18
    //   860: monitorexit
    //   861: aload_0
    //   862: getfield 284	com/tencent/av/VideoController:jdField_r_of_type_Int	I
    //   865: ldc_w 2260
    //   868: if_icmpne +1115 -> 1983
    //   871: sipush 261
    //   874: istore 5
    //   876: getstatic 87	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   879: iconst_1
    //   880: new 432	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 433	java/lang/StringBuilder:<init>	()V
    //   887: ldc_w 2270
    //   890: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload_0
    //   894: getfield 284	com/tencent/av/VideoController:jdField_r_of_type_Int	I
    //   897: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   900: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   906: aload_0
    //   907: getfield 136	com/tencent/av/VideoController:jdField_d_of_type_Boolean	Z
    //   910: ifeq +1037 -> 1947
    //   913: aload 17
    //   915: getfield 859	com/tencent/av/app/SessionInfo:jdField_g_of_type_Int	I
    //   918: bipush 9
    //   920: if_icmpne +1027 -> 1947
    //   923: aload 17
    //   925: getfield 867	com/tencent/av/app/SessionInfo:ah	Z
    //   928: ifne +1019 -> 1947
    //   931: lconst_0
    //   932: lstore 8
    //   934: aload_0
    //   935: ldc_w 2204
    //   938: iconst_0
    //   939: invokevirtual 1803	com/tencent/av/VideoController:a	(Ljava/lang/String;Z)V
    //   942: aload_0
    //   943: ldc_w 2204
    //   946: iconst_1
    //   947: invokevirtual 1804	com/tencent/av/VideoController:c	(Ljava/lang/String;I)V
    //   950: aload_0
    //   951: getfield 299	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   954: astore 18
    //   956: aload 18
    //   958: monitorenter
    //   959: aload_0
    //   960: getfield 299	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   963: invokevirtual 860	java/util/ArrayList:size	()I
    //   966: ifne +1011 -> 1977
    //   969: aload_0
    //   970: getfield 136	com/tencent/av/VideoController:jdField_d_of_type_Boolean	Z
    //   973: ifne +1004 -> 1977
    //   976: aload_0
    //   977: getfield 138	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   980: lconst_0
    //   981: lcmp
    //   982: ifne +995 -> 1977
    //   985: iconst_1
    //   986: istore 6
    //   988: aload_0
    //   989: getfield 299	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   992: invokevirtual 860	java/util/ArrayList:size	()I
    //   995: istore 7
    //   997: aload_0
    //   998: getfield 299	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1001: invokevirtual 1508	java/util/ArrayList:clear	()V
    //   1004: aload 18
    //   1006: monitorexit
    //   1007: aload_0
    //   1008: ldc_w 2204
    //   1011: iconst_0
    //   1012: iconst_0
    //   1013: lconst_0
    //   1014: invokevirtual 782	com/tencent/av/VideoController:a	(Ljava/lang/String;ZIJ)V
    //   1017: aload 17
    //   1019: iconst_0
    //   1020: putfield 785	com/tencent/av/app/SessionInfo:jdField_V_of_type_Boolean	Z
    //   1023: aload_0
    //   1024: getfield 258	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1027: iconst_0
    //   1028: putfield 2273	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   1031: aload 16
    //   1033: invokevirtual 726	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1036: astore 18
    //   1038: lconst_0
    //   1039: lstore 10
    //   1041: aload 18
    //   1043: ifnull +10 -> 1053
    //   1046: aload 18
    //   1048: invokestatic 731	com/tencent/av/utils/CharacterUtil:a	(Ljava/lang/String;)J
    //   1051: lstore 10
    //   1053: aload 18
    //   1055: invokestatic 744	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1058: ifne +214 -> 1272
    //   1061: new 899	android/content/Intent
    //   1064: dup
    //   1065: invokespecial 900	android/content/Intent:<init>	()V
    //   1068: astore 19
    //   1070: aload 19
    //   1072: ldc_w 902
    //   1075: invokevirtual 906	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   1078: pop
    //   1079: aload 19
    //   1081: ldc_w 908
    //   1084: bipush 23
    //   1086: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1089: pop
    //   1090: aload 19
    //   1092: ldc_w 918
    //   1095: lload 10
    //   1097: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1100: pop
    //   1101: aload 19
    //   1103: ldc_w 913
    //   1106: lload_2
    //   1107: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1110: pop
    //   1111: aload 19
    //   1113: ldc_w 911
    //   1116: iload_1
    //   1117: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1120: pop
    //   1121: aload 19
    //   1123: ldc_w 920
    //   1126: aload 17
    //   1128: getfield 798	com/tencent/av/app/SessionInfo:D	I
    //   1131: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1134: pop
    //   1135: aload 19
    //   1137: ldc_w 2275
    //   1140: lload 8
    //   1142: invokevirtual 916	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1145: pop
    //   1146: aload 19
    //   1148: ldc_w 965
    //   1151: aload_0
    //   1152: getfield 286	com/tencent/av/VideoController:jdField_r_of_type_Boolean	Z
    //   1155: invokevirtual 968	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1158: pop
    //   1159: aload 19
    //   1161: ldc_w 2277
    //   1164: iload 4
    //   1166: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1169: pop
    //   1170: aload 19
    //   1172: ldc_w 972
    //   1175: ldc_w 2279
    //   1178: invokevirtual 977	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1181: pop
    //   1182: iload 7
    //   1184: iconst_1
    //   1185: if_icmple +779 -> 1964
    //   1188: aload 19
    //   1190: ldc_w 970
    //   1193: iload 7
    //   1195: iconst_1
    //   1196: isub
    //   1197: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1200: pop
    //   1201: aload 19
    //   1203: aload 16
    //   1205: invokevirtual 924	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1208: invokevirtual 929	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1211: invokevirtual 932	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1214: pop
    //   1215: aload 19
    //   1217: lload 12
    //   1219: invokestatic 2284	com/tencent/av/utils/SeqUtil:a	(Landroid/content/Intent;J)V
    //   1222: aload 16
    //   1224: invokevirtual 924	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1227: aload 19
    //   1229: invokevirtual 936	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1232: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1235: ifeq +37 -> 1272
    //   1238: getstatic 87	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1241: iconst_1
    //   1242: new 432	java/lang/StringBuilder
    //   1245: dup
    //   1246: invokespecial 433	java/lang/StringBuilder:<init>	()V
    //   1249: ldc_w 2286
    //   1252: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: lload 12
    //   1257: invokevirtual 447	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1260: ldc_w 610
    //   1263: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 612	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: aload 17
    //   1274: ldc_w 2204
    //   1277: aconst_null
    //   1278: invokevirtual 2287	com/tencent/av/app/SessionInfo:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1281: aload 17
    //   1283: aconst_null
    //   1284: putfield 2290	com/tencent/av/app/SessionInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1287: aload_0
    //   1288: invokevirtual 2292	com/tencent/av/VideoController:h	()V
    //   1291: aload 17
    //   1293: getfield 1011	com/tencent/av/app/SessionInfo:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1296: invokevirtual 860	java/util/ArrayList:size	()I
    //   1299: ifle +28 -> 1327
    //   1302: aload 16
    //   1304: iconst_2
    //   1305: anewarray 4	java/lang/Object
    //   1308: dup
    //   1309: iconst_0
    //   1310: bipush 104
    //   1312: invokestatic 814	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1315: aastore
    //   1316: dup
    //   1317: iconst_1
    //   1318: aload 17
    //   1320: getfield 1011	com/tencent/av/app/SessionInfo:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1323: aastore
    //   1324: invokevirtual 820	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1327: aload 17
    //   1329: getfield 1401	com/tencent/av/app/SessionInfo:F	I
    //   1332: iconst_1
    //   1333: if_icmpne +28 -> 1361
    //   1336: aload 16
    //   1338: iconst_2
    //   1339: anewarray 4	java/lang/Object
    //   1342: dup
    //   1343: iconst_0
    //   1344: sipush 410
    //   1347: invokestatic 814	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_1
    //   1353: lload_2
    //   1354: invokestatic 817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1357: aastore
    //   1358: invokevirtual 820	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1361: aload 17
    //   1363: getfield 2294	com/tencent/av/app/SessionInfo:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   1366: astore 19
    //   1368: aload 17
    //   1370: getfield 1401	com/tencent/av/app/SessionInfo:F	I
    //   1373: iconst_1
    //   1374: if_icmpeq +12 -> 1386
    //   1377: aload 17
    //   1379: getfield 1401	com/tencent/av/app/SessionInfo:F	I
    //   1382: iconst_2
    //   1383: if_icmpne +44 -> 1427
    //   1386: aload 17
    //   1388: getfield 1408	com/tencent/av/app/SessionInfo:jdField_j_of_type_Boolean	Z
    //   1391: ifeq +28 -> 1419
    //   1394: aload 16
    //   1396: iconst_2
    //   1397: anewarray 4	java/lang/Object
    //   1400: dup
    //   1401: iconst_0
    //   1402: bipush 106
    //   1404: invokestatic 814	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1407: aastore
    //   1408: dup
    //   1409: iconst_1
    //   1410: lload 12
    //   1412: invokestatic 817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1415: aastore
    //   1416: invokevirtual 820	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1419: aload 17
    //   1421: lload 12
    //   1423: iconst_0
    //   1424: invokevirtual 2297	com/tencent/av/app/SessionInfo:a	(JZ)V
    //   1427: aload 17
    //   1429: lload 12
    //   1431: invokevirtual 2299	com/tencent/av/app/SessionInfo:c	(J)V
    //   1434: aload_0
    //   1435: invokevirtual 2301	com/tencent/av/VideoController:f	()V
    //   1438: lload 12
    //   1440: aload 16
    //   1442: invokestatic 2304	com/tencent/av/tips/TipsUtil:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1445: iload 6
    //   1447: ifne +46 -> 1493
    //   1450: aload_0
    //   1451: new 432	java/lang/StringBuilder
    //   1454: dup
    //   1455: invokespecial 433	java/lang/StringBuilder:<init>	()V
    //   1458: ldc_w 2306
    //   1461: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: iload 4
    //   1466: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1469: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1472: aload 15
    //   1474: iload_1
    //   1475: invokestatic 2308	com/tencent/av/utils/UITools:c	(I)I
    //   1478: aload 18
    //   1480: lload_2
    //   1481: invokestatic 737	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1484: bipush 7
    //   1486: aload 19
    //   1488: iconst_0
    //   1489: iconst_0
    //   1490: invokevirtual 2311	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1493: aload 17
    //   1495: iconst_m1
    //   1496: putfield 825	com/tencent/av/app/SessionInfo:jdField_j_of_type_Int	I
    //   1499: aload 17
    //   1501: iconst_1
    //   1502: putfield 2312	com/tencent/av/app/SessionInfo:jdField_p_of_type_Boolean	Z
    //   1505: aload_0
    //   1506: getfield 122	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvSessionMgr	Lcom/tencent/av/SessionMgr;
    //   1509: lload 12
    //   1511: aload 15
    //   1513: invokevirtual 2315	com/tencent/av/SessionMgr:a	(JLjava/lang/String;)Z
    //   1516: istore 14
    //   1518: aload 16
    //   1520: invokestatic 853	com/tencent/av/utils/QAVNotification:a	(Lcom/tencent/av/app/VideoAppInterface;)Lcom/tencent/av/utils/QAVNotification;
    //   1523: astore 16
    //   1525: aload 16
    //   1527: ifnull +27 -> 1554
    //   1530: aload 16
    //   1532: invokevirtual 854	com/tencent/av/utils/QAVNotification:a	()Z
    //   1535: ifeq +19 -> 1554
    //   1538: aload 16
    //   1540: aload 15
    //   1542: invokevirtual 943	com/tencent/av/utils/QAVNotification:a	(Ljava/lang/String;)V
    //   1545: iload 14
    //   1547: ifeq +7 -> 1554
    //   1550: aload_0
    //   1551: invokevirtual 855	com/tencent/av/VideoController:b	()V
    //   1554: invokestatic 2318	com/tencent/av/utils/PopupDialog:a	()V
    //   1557: aload_0
    //   1558: iload 5
    //   1560: invokevirtual 2320	com/tencent/av/VideoController:d	(I)V
    //   1563: goto -1374 -> 189
    //   1566: astore 15
    //   1568: aload_0
    //   1569: monitorexit
    //   1570: aload 15
    //   1572: athrow
    //   1573: aconst_null
    //   1574: ldc_w 2239
    //   1577: ldc 211
    //   1579: ldc 211
    //   1581: ldc_w 2322
    //   1584: ldc_w 2322
    //   1587: iconst_0
    //   1588: iconst_0
    //   1589: ldc 211
    //   1591: ldc 211
    //   1593: ldc 211
    //   1595: ldc 211
    //   1597: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1600: goto -872 -> 728
    //   1603: iload_1
    //   1604: iconst_1
    //   1605: if_icmpne -877 -> 728
    //   1608: ldc_w 2235
    //   1611: aload 17
    //   1613: getfield 2237	com/tencent/av/app/SessionInfo:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   1616: invokevirtual 1229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1619: ifeq +40 -> 1659
    //   1622: aload 17
    //   1624: getfield 798	com/tencent/av/app/SessionInfo:D	I
    //   1627: bipush 10
    //   1629: if_icmpne +167 -> 1796
    //   1632: aconst_null
    //   1633: ldc_w 2239
    //   1636: ldc 211
    //   1638: ldc 211
    //   1640: ldc_w 2324
    //   1643: ldc_w 2324
    //   1646: iconst_0
    //   1647: iconst_0
    //   1648: ldc 211
    //   1650: ldc 211
    //   1652: ldc 211
    //   1654: ldc 211
    //   1656: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1659: aload_0
    //   1660: invokevirtual 2243	com/tencent/av/VideoController:h	()Z
    //   1663: ifeq +40 -> 1703
    //   1666: aload 17
    //   1668: getfield 798	com/tencent/av/app/SessionInfo:D	I
    //   1671: bipush 10
    //   1673: if_icmpne +153 -> 1826
    //   1676: aconst_null
    //   1677: ldc_w 2239
    //   1680: ldc 211
    //   1682: ldc 211
    //   1684: ldc_w 2326
    //   1687: ldc_w 2326
    //   1690: iconst_0
    //   1691: iconst_0
    //   1692: ldc 211
    //   1694: ldc 211
    //   1696: ldc 211
    //   1698: ldc 211
    //   1700: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1703: aload 17
    //   1705: getfield 1408	com/tencent/av/app/SessionInfo:jdField_j_of_type_Boolean	Z
    //   1708: ifeq -980 -> 728
    //   1711: aload 17
    //   1713: getfield 798	com/tencent/av/app/SessionInfo:D	I
    //   1716: bipush 10
    //   1718: if_icmpne +138 -> 1856
    //   1721: aconst_null
    //   1722: ldc_w 2239
    //   1725: ldc 211
    //   1727: ldc 211
    //   1729: ldc_w 2328
    //   1732: ldc_w 2328
    //   1735: iconst_0
    //   1736: iconst_0
    //   1737: ldc 211
    //   1739: ldc 211
    //   1741: ldc 211
    //   1743: ldc 211
    //   1745: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1748: aload 17
    //   1750: getfield 2248	com/tencent/av/app/SessionInfo:jdField_m_of_type_Boolean	Z
    //   1753: ifne -1025 -> 728
    //   1756: aload 17
    //   1758: getfield 798	com/tencent/av/app/SessionInfo:D	I
    //   1761: bipush 10
    //   1763: if_icmpne +123 -> 1886
    //   1766: aconst_null
    //   1767: ldc_w 2239
    //   1770: ldc 211
    //   1772: ldc 211
    //   1774: ldc_w 2330
    //   1777: ldc_w 2330
    //   1780: iconst_0
    //   1781: iconst_0
    //   1782: ldc 211
    //   1784: ldc 211
    //   1786: ldc 211
    //   1788: ldc 211
    //   1790: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1793: goto -1065 -> 728
    //   1796: aconst_null
    //   1797: ldc_w 2239
    //   1800: ldc 211
    //   1802: ldc 211
    //   1804: ldc_w 2332
    //   1807: ldc_w 2332
    //   1810: iconst_0
    //   1811: iconst_0
    //   1812: ldc 211
    //   1814: ldc 211
    //   1816: ldc 211
    //   1818: ldc 211
    //   1820: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1823: goto -164 -> 1659
    //   1826: aconst_null
    //   1827: ldc_w 2239
    //   1830: ldc 211
    //   1832: ldc 211
    //   1834: ldc_w 2334
    //   1837: ldc_w 2334
    //   1840: iconst_0
    //   1841: iconst_0
    //   1842: ldc 211
    //   1844: ldc 211
    //   1846: ldc 211
    //   1848: ldc 211
    //   1850: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1853: goto -150 -> 1703
    //   1856: aconst_null
    //   1857: ldc_w 2239
    //   1860: ldc 211
    //   1862: ldc 211
    //   1864: ldc_w 2336
    //   1867: ldc_w 2336
    //   1870: iconst_0
    //   1871: iconst_0
    //   1872: ldc 211
    //   1874: ldc 211
    //   1876: ldc 211
    //   1878: ldc 211
    //   1880: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1883: goto -135 -> 1748
    //   1886: aconst_null
    //   1887: ldc_w 2239
    //   1890: ldc 211
    //   1892: ldc 211
    //   1894: ldc_w 2338
    //   1897: ldc_w 2338
    //   1900: iconst_0
    //   1901: iconst_0
    //   1902: ldc 211
    //   1904: ldc 211
    //   1906: ldc 211
    //   1908: ldc 211
    //   1910: invokestatic 1287	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1913: goto -1185 -> 728
    //   1916: astore 19
    //   1918: aload 19
    //   1920: invokevirtual 2339	java/lang/InterruptedException:printStackTrace	()V
    //   1923: goto -1065 -> 858
    //   1926: astore 15
    //   1928: aload 18
    //   1930: monitorexit
    //   1931: aload 15
    //   1933: athrow
    //   1934: aload_0
    //   1935: getfield 258	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1938: iload 5
    //   1940: invokevirtual 2342	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   1943: pop
    //   1944: goto -1038 -> 906
    //   1947: aload_0
    //   1948: invokevirtual 2250	com/tencent/av/VideoController:a	()J
    //   1951: lstore 8
    //   1953: goto -1019 -> 934
    //   1956: astore 15
    //   1958: aload 18
    //   1960: monitorexit
    //   1961: aload 15
    //   1963: athrow
    //   1964: aload 19
    //   1966: ldc_w 970
    //   1969: iconst_0
    //   1970: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1973: pop
    //   1974: goto -773 -> 1201
    //   1977: iconst_0
    //   1978: istore 6
    //   1980: goto -992 -> 988
    //   1983: goto -1107 -> 876
    //   1986: goto -1941 -> 45
    //   1989: iconst_0
    //   1990: istore 5
    //   1992: iload 4
    //   1994: bipush 7
    //   1996: if_icmpeq +10 -> 2006
    //   1999: iload 4
    //   2001: bipush 20
    //   2003: if_icmpne -1224 -> 779
    //   2006: iload 4
    //   2008: istore 5
    //   2010: goto -1231 -> 779
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2013	0	this	VideoController
    //   0	2013	1	paramInt1	int
    //   0	2013	2	paramLong	long
    //   0	2013	4	paramInt2	int
    //   829	1180	5	i1	int
    //   986	993	6	i2	int
    //   995	202	7	i3	int
    //   932	1020	8	l1	long
    //   1039	57	10	l2	long
    //   5	1505	12	l3	long
    //   141	1405	14	bool	boolean
    //   24	1517	15	str	String
    //   1566	5	15	localObject1	Object
    //   1926	6	15	localObject2	Object
    //   1956	6	15	localObject3	Object
    //   11	1528	16	localObject4	Object
    //   54	1703	17	localSessionInfo	SessionInfo
    //   133	1354	19	localObject6	Object
    //   1916	49	19	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	26	1566	finally
    //   31	45	1566	finally
    //   45	135	1566	finally
    //   143	176	1566	finally
    //   176	184	1566	finally
    //   203	217	1566	finally
    //   222	236	1566	finally
    //   236	252	1566	finally
    //   252	259	1566	finally
    //   264	271	1566	finally
    //   271	312	1566	finally
    //   312	393	1566	finally
    //   398	544	1566	finally
    //   550	557	1566	finally
    //   563	589	1566	finally
    //   595	605	1566	finally
    //   610	651	1566	finally
    //   651	685	1566	finally
    //   685	728	1566	finally
    //   728	776	1566	finally
    //   779	785	1566	finally
    //   806	838	1566	finally
    //   838	847	1566	finally
    //   861	871	1566	finally
    //   876	906	1566	finally
    //   906	931	1566	finally
    //   934	959	1566	finally
    //   1007	1038	1566	finally
    //   1046	1053	1566	finally
    //   1053	1182	1566	finally
    //   1188	1201	1566	finally
    //   1201	1272	1566	finally
    //   1272	1327	1566	finally
    //   1327	1361	1566	finally
    //   1361	1386	1566	finally
    //   1386	1419	1566	finally
    //   1419	1427	1566	finally
    //   1427	1445	1566	finally
    //   1450	1493	1566	finally
    //   1493	1525	1566	finally
    //   1530	1545	1566	finally
    //   1550	1554	1566	finally
    //   1554	1563	1566	finally
    //   1573	1600	1566	finally
    //   1608	1659	1566	finally
    //   1659	1703	1566	finally
    //   1703	1748	1566	finally
    //   1748	1793	1566	finally
    //   1796	1823	1566	finally
    //   1826	1853	1566	finally
    //   1856	1883	1566	finally
    //   1886	1913	1566	finally
    //   1931	1934	1566	finally
    //   1934	1944	1566	finally
    //   1947	1953	1566	finally
    //   1961	1964	1566	finally
    //   1964	1974	1566	finally
    //   847	858	1916	java/lang/InterruptedException
    //   847	858	1926	finally
    //   858	861	1926	finally
    //   1918	1923	1926	finally
    //   1928	1931	1926	finally
    //   959	985	1956	finally
    //   988	1007	1956	finally
    //   1958	1961	1956	finally
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l1 = AudioHelper.b();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.jdField_d_of_type_Boolean + "], seq[" + l1 + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((SessionInfo)localObject).jdField_j_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      if ((l()) && ((paramInt2 == 16) || (paramInt2 == 69) || (paramInt2 == 68) || (paramInt2 == 17) || (paramInt2 == 71) || (paramInt2 == 70)))
      {
        if (this.jdField_d_of_type_Boolean) {
          a(paramInt1, paramLong, 70);
        }
        a("onGAudioSDKError_1");
        if ((-19 == paramInt3) || (19 == paramInt3))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
          this.jdField_j_of_type_JavaLangRunnable = null;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(200), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      int i1 = UITools.c(paramInt1);
      a(a().jdField_c_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.jdField_d_of_type_Boolean) {
        a(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        a("onGAudioSDKError_2");
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(l1);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, str);
        return;
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        a("onGAudioSDKError", str, i1, (String)localObject, String.valueOf(paramLong), 7, (String)localObject, false, false);
        if (this.jdField_j_of_type_JavaLangRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
          this.jdField_j_of_type_JavaLangRunnable = null;
        }
      }
    }
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + paramSdkAudioFrameCallback);
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
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.uploadSharpNode(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_Node", 2, "report_node is" + paramInt);
      }
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendAnotherChatingBroadcast session:" + paramInt2 + ", peerUin:" + paramString + "， roomid：" + paramLong);
      if (paramInt2 != 3) {
        break label268;
      }
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr;
      localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr;
      localObject1 = SessionMgr.a(SessionMgr.a(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((SessionInfo)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((SessionInfo)localObject1).jdField_d_of_type_JavaLangString)) && (((SessionInfo)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((SessionInfo)localObject1).A);
      ((Intent)localObject2).putExtra("bindId", ((SessionInfo)localObject1).jdField_p_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("roomId", paramLong);
      ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject2);
      return;
      label268:
      if (paramInt2 != 4) {}
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendReplyMsgToAio uinType: " + paramInt + ", friendUin: " + paramString1 + ", friendName: " + paramString2 + ", extraUin: " + paramString3 + ", replyMsg: " + paramString4 + ", isDiyMsg: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.replyMsg");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("friendName", paramString2);
      paramString2 = paramString3;
      if (paramInt == 1006)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = paramString1;
        }
      }
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("replyMsg", paramString4);
      localIntent.putExtra("isDiyMsg", paramBoolean);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendLeaveMsg uinType: " + paramInt + ", friendUin: " + paramString1 + ", friendName: " + paramString2 + ", extraUin: " + paramString3 + ", isPtt: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.leaveMsg");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("friendName", paramString2);
      paramString2 = paramString3;
      if (paramInt == 1006)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = paramString1;
        }
      }
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("isPtt", paramBoolean);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsgSigBroadcast uinType: " + paramInt + ", peerUin: " + paramString1 + ", extraUin: " + paramString2 + ", sig = " + paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.video.v2q.AddMsgSig");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("sig", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyOtherTerminalChatStatus time:" + paramInt + ", camera:" + paramBoolean1 + ", mic:" + paramBoolean2);
    }
    int i1;
    if (paramBoolean1)
    {
      i1 = 1;
      if (!paramBoolean2) {
        break label119;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherTerChatStatus(Long.valueOf(a().jdField_d_of_type_JavaLangString).longValue(), (i2 << 21) + ((i1 << 20) + (paramInt & 0xFFFFF)));
      }
      return;
      i1 = 0;
      break;
      label119:
      i2 = 0;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onSubState2 seq[" + paramLong + "]");
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    SessionInfo localSessionInfo = a();
    j();
    localSessionInfo.a("onSubState2", 4);
    localSessionInfo.a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!localSessionInfo.jdField_g_of_type_Boolean) {
        break label207;
      }
      a(true, localSessionInfo.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, paramLong), 50L);
      a(localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_d_of_type_Int, true, true, true);
      DataReport.i(this);
      DataReport.c(this, true);
      DataReport.b(this, true);
      ChatRoomMng localChatRoomMng = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localChatRoomMng != null) {
        localChatRoomMng.a(localSessionInfo);
      }
      return;
      b();
      break;
      label207:
      a(false, localSessionInfo.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15001), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "playRing, listener[" + paramOnCompletionListener + "], seq[" + paramLong + "]");
    }
    if (q()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + "Q.nearby.video_chat", 2, "not playRing");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(paramLong);
      if (!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_d_of_type_JavaLangString, 212);
        b(212);
        b(a().jdField_d_of_type_JavaLangString, a().z);
      }
    } while (!a().T);
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
    a(a().jdField_d_of_type_JavaLangString, 213);
    b(213);
    b(a().jdField_d_of_type_JavaLangString, a().z);
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, -1, false);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    TraeHelper.a().b();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (paramInt1 != 1) {
          break label175;
        }
        i1 = 10;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.ignore(paramInt1, paramLong2, i1);
      QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "ignoreGAudioChat, groupId[" + paramLong2 + "], iFlag[" + paramInt2 + "], sessionId[" + str1 + "], sessionInfo[" + localObject + "]");
      if (localObject != null) {
        break label231;
      }
      return;
      str1 = SessionMgr.a(paramInt1, String.valueOf(paramLong2), new int[0]);
      break;
      label175:
      if (paramInt1 == 2)
      {
        i1 = 1;
      }
      else if (paramInt1 == 3)
      {
        i1 = 8;
      }
      else
      {
        i1 = 0;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "ignoreGAudioChat, Can't Support Ignore" + paramInt1);
      }
    }
    label231:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
    ((SessionInfo)localObject).aj = true;
    int i1 = 4;
    label277:
    String str2;
    if (((SessionInfo)localObject).jdField_g_of_type_Int == 7)
    {
      ((SessionInfo)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        h();
        paramInt2 = UITools.c(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((SessionInfo)localObject).jdField_c_of_type_JavaLangString, UITools.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((SessionInfo)localObject).jdField_g_of_type_Long), 5, ((SessionInfo)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, str1);
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((QAVNotification)localObject).a())) {
        break;
      }
      ((QAVNotification)localObject).a(str1);
      if (!paramBoolean) {
        break;
      }
      b();
      return;
      i1 = 3;
      break label277;
      if (paramInt2 == -1) {
        break label277;
      }
      i1 = paramInt2;
      break label277;
      label412:
      if (paramInt1 == 3) {
        a("ignoreGAudioChat_2", str1, paramInt2, ((SessionInfo)localObject).jdField_d_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((SessionInfo)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i1, ((SessionInfo)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, ArrayList<String> paramArrayList)
  {
    Object localObject2 = new StringBuilder().append("switchToMultiAudio, roomId[").append(paramLong2).append("], memberList[");
    Object localObject1;
    int i1;
    label92:
    int i2;
    int i3;
    if (paramArrayList != null)
    {
      localObject1 = Integer.valueOf(paramArrayList.size());
      QLog.w("double_2_multi", 1, localObject1 + "], seq[" + paramLong1 + "], uinType[" + paramInt + "]");
      if (paramInt != 1) {
        break label442;
      }
      i1 = 1;
      ReportController.b(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i1, 0, "", "", "", "");
      if (paramArrayList == null) {
        break label638;
      }
      j(true);
      i1 = 1;
      i2 = 2;
      if (paramInt == 1)
      {
        i2 = 1;
        i1 = 10;
      }
      localObject2 = a();
      localObject1 = SessionMgr.a(i2, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, false);
      i3 = ((SessionInfo)localObject2).jdField_d_of_type_Int;
      ((SessionInfo)localObject1).a(paramLong1, ((SessionInfo)localObject2).jdField_j_of_type_Boolean);
      ((SessionInfo)localObject1).jdField_g_of_type_Boolean = ((SessionInfo)localObject2).jdField_g_of_type_Boolean;
      ((SessionInfo)localObject1).b("switchToMultiAudio", ((SessionInfo)localObject2).jdField_P_of_type_Boolean);
      ((SessionInfo)localObject1).b("switchToMultiAudio", ((SessionInfo)localObject2).jdField_q_of_type_JavaLangString);
      ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString = ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString;
      ((SessionInfo)localObject1).D = i1;
      ((SessionInfo)localObject1).aH = true;
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      if (!((SessionInfo)localObject2).J) {
        break label454;
      }
      boolean bool = this.jdField_l_of_type_Boolean;
      a(paramLong1, Long.valueOf(((SessionInfo)localObject2).jdField_d_of_type_JavaLangString).longValue(), true, 0);
      a("switchToMultiAudio", bool);
      if (!bool) {
        break label448;
      }
      i1 = 1;
      label328:
      c("switchToMultiAudio", i1);
    }
    for (this.jdField_d_of_type_Int = 2;; this.jdField_d_of_type_Int = 1)
    {
      if (!paramArrayList.contains(((SessionInfo)localObject2).jdField_d_of_type_JavaLangString)) {
        paramArrayList.add(((SessionInfo)localObject2).jdField_d_of_type_JavaLangString);
      }
      localObject2 = new long[paramArrayList.size()];
      paramArrayList = paramArrayList.iterator();
      i1 = 0;
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label500;
        }
        String str = (String)paramArrayList.next();
        try
        {
          long l1 = Long.parseLong(str);
          i2 = i1 + 1;
          localObject2[i1] = l1;
          i1 = i2;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      localObject1 = "null";
      break;
      label442:
      i1 = 2;
      break label92;
      label448:
      i1 = 0;
      break label328;
      label454:
      a(((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, 1);
      b(214);
      b(((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, 21);
    }
    label500:
    if (i1 == localObject2.length)
    {
      ((SessionInfo)localObject1).jdField_a_of_type_ArrayOfLong = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((SessionInfo)localObject1).z = -1;
      if (i3 != 1) {
        break label680;
      }
      ((SessionInfo)localObject1).a(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((SessionInfo)localObject1).jdField_j_of_type_Int = paramInt;
      ((SessionInfo)localObject1).jdField_g_of_type_Long = paramLong2;
      ((SessionInfo)localObject1).d("switchToMultiAudio", AVUtil.a(paramInt));
      ((SessionInfo)localObject1).c("switchToMultiAudio", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label638:
      return;
      ((SessionInfo)localObject1).jdField_a_of_type_ArrayOfLong = new long[i1];
      i2 = 0;
      while (i2 < i1)
      {
        ((SessionInfo)localObject1).jdField_a_of_type_ArrayOfLong[i2] = localObject2[i2];
        i2 += 1;
      }
      break;
      label680:
      if (i3 == 2) {
        ((SessionInfo)localObject1).a(paramLong1, "switchToMultiAudio.2", 4);
      } else if (i3 == 3) {
        ((SessionInfo)localObject1).a(paramLong1, "switchToMultiAudio.3", 3);
      } else if (i3 == 4) {
        ((SessionInfo)localObject1).a(paramLong1, "switchToMultiAudio.4", 3);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    a(paramLong1, paramInt, paramLong2, -1, paramBoolean);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = 0L;
    boolean bool;
    GraphicRenderMgr localGraphicRenderMgr;
    if ((paramInt == 4) || (paramInt == 3))
    {
      bool = true;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "setEncodeDecodePtr, sessionType[" + paramInt + "], clean[" + paramBoolean1 + "], isRemote[" + paramBoolean2 + "], isMultiEngine[" + bool + "], seq[" + paramLong + "]");
      localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      if (!bool) {
        break label249;
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (!paramBoolean2) {
          break label224;
        }
        if (!paramBoolean1) {
          break label188;
        }
        if (localGraphicRenderMgr.decoderPtrRef > 0) {
          localGraphicRenderMgr.decoderPtrRef -= 1;
        }
        if (localGraphicRenderMgr.decoderPtrRef == 0) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
        }
      }
    }
    label188:
    label224:
    label249:
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      do
      {
        return;
        if (((paramInt == 2) || (paramInt == 1)) && (a().J))
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        localGraphicRenderMgr.decoderPtrRef += 1;
      } while (localGraphicRenderMgr.decoderPtrRef != 1);
      paramLong = localGraphicRenderMgr.getRecvDecoderFrameFunctionPtr();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(paramLong);
      return;
      if (paramBoolean1) {}
      for (paramLong = 0L;; paramLong = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEncodeFrameFunctionPtrFunPtr())
      {
        localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramLong);
        return;
      }
    }
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setProcessDecoderFrameFunctionptr(l1);
        return;
        l1 = localGraphicRenderMgr.getRecvDecoderFrameFunctionPtr();
      }
    }
    if (paramBoolean1) {}
    for (;;)
    {
      localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(l1);
      return;
      l1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getEncodeFrameFunctionPtrFunPtr();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startCheckAnyChatReqTimeout, ms[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
      this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = new VideoController.AnyChatReqTimeoutRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    String str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((SessionInfo)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((SessionInfo)localObject).jdField_d_of_type_JavaLangString, ((SessionInfo)localObject).jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((SessionInfo)localObject).D);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, str);
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((QAVNotification)localObject).a())) {
        break;
      }
      ((QAVNotification)localObject).a(str);
      if (!bool) {
        break;
      }
      b();
      return;
      a(str, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "onGroupSystemMsgCome()  mGAudioCtrl == null !!    return !");
    }
    do
    {
      do
      {
        return;
        switch (paramInt2)
        {
        default: 
          return;
        case 3: 
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, true);
          }
          break;
        }
      } while ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
      a().jdField_ad_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
    a().jdField_ad_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    SessionInfo localSessionInfo = a();
    if ((localSessionInfo.jdField_d_of_type_Int != 2) || ((localSessionInfo.w != 2) && (localSessionInfo.w != 3))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInviteRespFail, groupId[" + paramLong1 + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], err[" + paramLong2 + "], msg[" + paramString + "]");
    if (paramLong1 == this.jdField_a_of_type_Long) {
      QQToast.a(a(), 2131695660, 1).a();
    }
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.34(this, paramArrayList, paramLong1, paramLong2));
  }
  
  @TargetApi(21)
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, relationId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper;
    if (localObject != null) {
      ((ScreenRecordHelper)localObject).a(4);
    }
    localObject = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
    if (localSessionInfo == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", localSessionInfo.D);
    localIntent.putExtra("from", "VideoController6");
    SeqUtil.a(localIntent, paramLong1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a((String)localObject, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (localSessionInfo.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      localSessionInfo.d("quitDoubleVideoMeeting", false);
      localSessionInfo.e("quitDoubleVideoMeeting", false);
    }
    for (;;)
    {
      localObject = a();
      if (localObject == null) {
        break;
      }
      ((ScreenShareCtrl)localObject).b(paramLong2);
      return;
      localSessionInfo.a("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230741, 1, this.jdField_c_of_type_ComTencentAvVideoController$OnCustomCompletionListener);
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.40(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
    }
    this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = new VideoController.StartRingRunnable(this, paramString);
    if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable, 6000L);
    }
  }
  
  void a(long paramLong, String paramString, int paramInt)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo onCloseVideo fromUin[" + paramString + "], type[" + paramInt + "], seq[" + paramLong + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "]");
    M();
    String str = SessionMgr.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str)) {}
    for (SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str); localSessionInfo == null; localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str))
    {
      AVLog.printErrorLog(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = SessionMgr.a(100, paramString, new int[0]);
    }
    localSessionInfo.jdField_d_of_type_Boolean = false;
    if ((q()) && (paramString != null) && (!paramString.equals(localSessionInfo.jdField_d_of_type_JavaLangString)))
    {
      AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + localSessionInfo.jdField_d_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor = null;
    }
    this.jdField_h_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    j();
    if ((localSessionInfo.jdField_d_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(paramLong, str, paramString, 3);
      label296:
      if (!localSessionInfo.j()) {
        break label440;
      }
      localSessionInfo.z = paramInt;
      if ((localSessionInfo.j()) && (paramInt == localSessionInfo.jdField_d_of_type_Int)) {
        localSessionInfo.a(paramLong, 0L);
      }
      localSessionInfo.a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(localSessionInfo.jdField_d_of_type_JavaLangString, localSessionInfo.z);
    }
    for (;;)
    {
      label398:
      if ((this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        return;
        a(paramLong, str, paramString, paramInt);
        break label296;
        label440:
        if (localSessionInfo.h())
        {
          localSessionInfo.z = paramInt;
          localSessionInfo.a(paramLong, 0L);
          int i2 = 2131230741;
          switch (paramInt)
          {
          default: 
            i1 = 0;
            this.jdField_a_of_type_ComTencentAvVideoController$OnCustomCompletionListener.jdField_a_of_type_Long = paramLong;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a(paramLong, i2, i1, this.jdField_a_of_type_ComTencentAvVideoController$OnCustomCompletionListener);
            localSessionInfo.a("onCloseVideo.isInviting1", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            if (l()) {
              break;
            }
            if (localSessionInfo.jdField_d_of_type_Long != 2L)
            {
              ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230740;
              break label531;
            }
            i2 = 2131230741;
            i1 = 1;
            break label531;
            localSessionInfo.a("onCloseVideo.isInviting", 6);
            a(paramLong, 2131230741, 1, a(paramLong));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (l()) {
              break;
            }
            ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            i2 = 2131230740;
            i1 = 0;
            break label531;
          }
        }
        label531:
        if (!localSessionInfo.o())
        {
          localSessionInfo.z = paramInt;
          if (localSessionInfo.j()) {
            localSessionInfo.a(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (localSessionInfo.jdField_j_of_type_Int == 1011))
          {
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label1073;
            }
            a(6, 0, null);
            label943:
            QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label1090;
            }
            if (localQAVNotification != null) {
              localQAVNotification.a();
            }
          }
          label969:
          localSessionInfo.a("onCloseVideo.isClosing1", 6);
          if ((!q()) && (!PhoneStatusTools.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label1097;
          }
          a(localSessionInfo.jdField_d_of_type_JavaLangString, 209);
          b(209);
          b(localSessionInfo.jdField_d_of_type_JavaLangString, localSessionInfo.z);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1073:
      a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 0, null);
      break label943;
      label1090:
      b();
      break label969;
      label1097:
      a(paramLong, 2131230741, 1, a(paramLong));
      QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_s_of_type_Boolean = b();
    boolean bool2 = SmallScreenUtils.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.jdField_s_of_type_Boolean + "], isFloatWindowOpAllowedOnBackground[" + bool2 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l1 + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
    {
      a(paramLong, paramString2, 0, paramBoolean2);
      b(paramString2, 0);
    }
    Intent localIntent;
    boolean bool1;
    label656:
    label699:
    do
    {
      return;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
      if (localSessionInfo == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      localSessionInfo.jdField_e_of_type_Boolean = true;
      localSessionInfo.S = paramBoolean1;
      localSessionInfo.a("processVideoRequest.1", 2);
      localSessionInfo.ai = false;
      localSessionInfo.jdField_k_of_type_Long = System.currentTimeMillis();
      AVReport.a().jdField_o_of_type_Boolean = localSessionInfo.S;
      if ((paramBoolean3) || (VideoUtils.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()))
      {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        localIntent.putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      }
      for (bool1 = false;; bool1 = true)
      {
        localIntent.addFlags(268435456);
        localIntent.putExtra("uinType", paramInt1);
        localIntent.putExtra("relationType", UITools.b(paramInt1));
        localIntent.putExtra("session_id", paramString1);
        localIntent.putExtra("peerUin", paramString2);
        localIntent.putExtra("extraUin", paramString3);
        localIntent.putExtra("isAudioMode", paramBoolean1);
        localIntent.putExtra("curUserStatus", this.jdField_g_of_type_Int);
        localIntent.putExtra("isDoubleVideoMeeting", paramBoolean2);
        localIntent.putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L))) {
          localIntent.putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label699;
        }
        g();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString)) {
          break label656;
        }
        localSessionInfo.jdField_d_of_type_JavaLangString = paramString2;
        a(paramLong, localSessionInfo.jdField_d_of_type_JavaLangString, 0, 4);
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        return;
        localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), VideoInviteActivity.class);
        if (NoDisturbUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
          localIntent.addFlags(262144);
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = true;
      localSessionInfo.a("processVideoRequest.2", 0);
      localSessionInfo.jdField_j_of_type_Int = paramInt1;
      localSessionInfo.jdField_d_of_type_JavaLangString = paramString2;
      return;
      if (!localSessionInfo.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "processVideoRequest block notify video msg");
    return;
    paramString1 = a();
    if (paramString1 != null)
    {
      paramInt1 = paramString1.a(JniSimpleInfoMng.a(paramString2), false, true);
      ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, paramString2, paramInt1);
    }
    if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext())) {
      a(localIntent, paramString2, bool1, true);
    }
    for (;;)
    {
      g();
      return;
      if ((this.jdField_s_of_type_Boolean) && (bool2))
      {
        if ((paramBoolean3) || (VideoUtils.a()))
        {
          paramString1 = new MultiIncomingCallUICtr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localIntent);
          paramString1.d();
          paramString1.a(localIntent);
        }
        for (;;)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest startActivity when GameMode");
          a("mode", "1");
          c(paramString2);
          a(paramString2, "screenState", String.valueOf(1));
          break;
          paramString1 = new VideoInviteFloatBarUICtr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localIntent);
          paramString1.d();
          paramString1.a(paramLong, localIntent);
        }
      }
      a(localIntent, paramString2, bool1, false);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("cancelVideoChat, peerUin[").append(paramString).append("], reason[").append(paramInt).append("], isDoubleMetting[").append(paramBoolean).append("], mVcCtrl[");
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        break;
      }
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
      if ((a().jdField_d_of_type_JavaLangString == null) || (!a().jdField_d_of_type_JavaLangString.equals(paramString))) {
        break label319;
      }
      VideoNodeManager.a(a().b(), 38);
    }
    for (;;)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      h();
      j();
      if (!this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
        break;
      }
      SmartDeviceReport.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label319:
      VideoNodeManager.a(a(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + localSessionInfo + "]", new Throwable("打印调用栈"));
    int i1;
    String str;
    if ((localSessionInfo != null) && ((!localSessionInfo.ai) || (localSessionInfo.jdField_c_of_type_Boolean)))
    {
      i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1).jdField_j_of_type_Int;
      str = localSessionInfo.jdField_f_of_type_JavaLangString;
      if ((TextUtils.isEmpty(localSessionInfo.jdField_d_of_type_JavaLangString)) || (!localSessionInfo.jdField_d_of_type_JavaLangString.contains(paramString2))) {
        break label413;
      }
      paramString2 = localSessionInfo.jdField_d_of_type_JavaLangString;
    }
    label413:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvQavChannelProxy.a())
      {
        i1 = 9500;
        if (this.w) {
          i1 = 0;
        }
      }
      boolean bool = false;
      if (localSessionInfo.jdField_f_of_type_Int == 2) {
        bool = true;
      }
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
      {
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        if ((paramInt == 12) && (!TextUtils.isEmpty(a().a()))) {
          a(paramString1, i1, 66, bool, paramString2, str, false);
        }
        if (!this.jdField_d_of_type_Boolean) {
          break label341;
        }
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, paramString2, str, 1, a().jdField_s_of_type_JavaLangString, false, true);
      }
      for (;;)
      {
        localSessionInfo.ai = true;
        localSessionInfo.jdField_c_of_type_Boolean = false;
        return;
        if (!localSessionInfo.jdField_c_of_type_Boolean) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        label341:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1).jdField_s_of_type_JavaLangString, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1).jdField_s_of_type_JavaLangString, false, true);
        }
      }
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, UITools.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong, paramString2);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((!this.jdField_d_of_type_Boolean) || (a().jdField_g_of_type_Long != paramLong) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
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
    if (paramArrayList == a().jdField_d_of_type_JavaUtilArrayList)
    {
      ArrayList localArrayList = a().jdField_d_of_type_JavaUtilArrayList;
      int i1 = 0;
      label115:
      for (;;)
      {
        try
        {
          if (i1 < paramArrayList.size())
          {
            if (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
              break label115;
            }
            if (paramBoolean)
            {
              a(paramArrayList, i1);
              a().c();
            }
          }
          else
          {
            return;
          }
          if (paramInt == ((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int)
          {
            a(paramArrayList, i1);
            a().c();
          }
          else
          {
            i1 += 1;
          }
        }
        finally {}
      }
    }
  }
  
  public void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList1, ArrayList<VideoViewInfo> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList1.size()) {
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
          i1 += 1;
        }
        else
        {
          i1 += 1;
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i1 = 0;
    Object localObject;
    if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localObject = (VideoController.GAudioFriends)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long);
        i1 = 1;
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.jdField_b_of_type_JavaUtilArrayList });
      }
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("InviteMemberList removeCertainInviteNumber uin:").append(paramLong).append(";result:");
      boolean bool1 = bool2;
      if (i1 != 0)
      {
        bool1 = bool2;
        if (paramBoolean) {
          bool1 = true;
        }
      }
      QLog.d((String)localObject, 1, bool1);
      return;
      i1 += 1;
      break;
      label218:
      i1 = 1;
      continue;
      i1 = 0;
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], uinType[" + paramInt1 + "], fromUin[" + paramString1 + "], extraUin[" + paramString2 + "], bindType[" + paramInt2 + "], bindID[" + paramString3 + "], onlyAudio[" + paramBoolean2 + "], seq[" + paramLong + "]");
    }
    String str;
    long l2;
    if (paramBoolean1)
    {
      str = SessionMgr.a(100, paramString1, new int[0]);
      SessionInfo localSessionInfo2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      SessionInfo localSessionInfo1 = localSessionInfo2;
      if (localSessionInfo2 == null) {
        localSessionInfo1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
      }
      localSessionInfo1.jdField_j_of_type_Int = paramInt1;
      localSessionInfo1.A = paramInt2;
      localSessionInfo1.jdField_p_of_type_JavaLangString = paramString3;
      localSessionInfo1.jdField_e_of_type_Boolean = true;
      paramInt1 = localSessionInfo1.jdField_j_of_type_Int;
      if (paramBoolean2) {
        break label268;
      }
      paramBoolean2 = true;
      a(str, paramInt1, paramBoolean2, paramString1, paramString2);
      if (!paramBoolean1) {
        break label304;
      }
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString1);
        a(paramLong, 3, l1);
        SessionMgr.a().a(paramLong, str);
        return;
        str = SessionMgr.a(3, paramString1, new int[0]);
        break;
        label268:
        paramBoolean2 = false;
      }
      catch (NumberFormatException paramString1)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramString1);
        l1 = l2;
        continue;
      }
      label304:
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString1, c(), 65536);
    }
  }
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean, int paramInt)
  {
    long l1 = paramArrayOfLong[0];
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->setSpeakingUin,uin=" + l1 + ", isSpeaking = " + paramBoolean + ", audioEnergy = " + paramInt);
    }
    boolean bool = a(l1, paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), Long.valueOf(l1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
    Intent localIntent = new Intent("tencent.video.v2q.memberSpeaking");
    localIntent.putExtra("groupId", paramLong);
    localIntent.putExtra("uinList", paramArrayOfLong);
    localIntent.putExtra("isSpeaking", paramBoolean);
    localIntent.putExtra("audioEnergy", paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().sendBroadcast(localIntent);
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, int paramInt)
  {
    paramGAudioFriends.jdField_b_of_type_Int = 0;
    paramGAudioFriends.jdField_b_of_type_Boolean = false;
    paramGAudioFriends.jdField_c_of_type_Boolean = false;
    paramGAudioFriends.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramGAudioFriends.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramGAudioFriends.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramGAudioFriends.jdField_b_of_type_Int = 1;
      return;
    }
    paramGAudioFriends.jdField_d_of_type_Boolean = true;
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
    VideoController.3 local3 = new VideoController.3(this);
    paramVideoAppInterface.a().post(local3);
    if (!NetworkUtil.d(a())) {
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      c();
      if ((this.jdField_i_of_type_Int == 0) && (SmallScreenUtils.e(paramVideoAppInterface.getApp()))) {
        this.jdField_i_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a(this.jdField_a_of_type_AndroidContentContext, this);
      if (this.x) {
        I();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(0L, "qqVersion", AppSetting.a(a()));
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectsRenderController.a(paramVideoAppInterface);
      return;
      if (NetworkUtil.a(a())) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 2;
      }
    }
  }
  
  void a(AVUserInfo paramAVUserInfo, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    if (paramBoolean) {}
    Object localObject1;
    try
    {
      if (a(paramAVUserInfo.account) != -1) {
        return;
      }
      localObject1 = new VideoController.GAudioFriends();
      ((VideoController.GAudioFriends)localObject1).jdField_a_of_type_Long = paramAVUserInfo.account;
      ((VideoController.GAudioFriends)localObject1).jdField_d_of_type_Int = paramAVUserInfo.accountType;
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut, size[" + this.jdField_c_of_type_JavaUtilArrayList.size() + "], coming[" + paramAVUserInfo + "]");
      return;
    }
    finally {}
    int i1 = a(paramAVUserInfo.account);
    Object localObject2 = null;
    if (i1 != -1) {
      localObject1 = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
    }
    for (;;)
    {
      a(paramAVUserInfo.account, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      u();
      if ((localObject1 == null) || (((VideoController.GAudioFriends)localObject1).jdField_e_of_type_Boolean) || (!((VideoController.GAudioFriends)localObject1).jdField_g_of_type_Boolean)) {
        break;
      }
      onGAudioUserAudioSuspectNoisy(0L, false, 0L);
      break;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramAVUserInfo);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField1, PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList updateMemberListWithPushMessage joins" + paramPBRepeatMessageField1.size() + ";quits size" + paramPBRepeatMessageField2.size() + ";eventType:=" + paramInt2);
    }
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)((Iterator)localObject2).next()).jdField_a_of_type_Long));
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver totalCount:" + paramInt1);
    }
    paramInt1 = 0;
    int i1 = 0;
    if (i1 < paramPBRepeatMessageField1.size())
    {
      localObject2 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MemberInfo)paramPBRepeatMessageField1.get(i1)).get();
      int i3;
      if (((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get() == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
      {
        i3 = 1;
        label201:
        i2 = paramInt1;
        if (!((Set)localObject1).contains(Long.valueOf(((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get())))
        {
          if (i3 == 0) {
            break label251;
          }
          i2 = paramInt1;
        }
      }
      for (;;)
      {
        i1 += 1;
        paramInt1 = i2;
        break;
        i3 = 0;
        break label201;
        label251:
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.jdField_d_of_type_Int = 0;
        localGAudioFriends.jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        localGAudioFriends.jdField_h_of_type_Boolean = false;
        localGAudioFriends.jdField_e_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.jdField_b_of_type_JavaUtilArrayList.add(localGAudioFriends);
        paramInt1 = 1;
        i2 = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver add member UIN:" + localGAudioFriends.jdField_a_of_type_Long);
          i2 = paramInt1;
        }
      }
    }
    int i2 = 0;
    if (i2 < paramPBRepeatMessageField2.size())
    {
      paramPBRepeatMessageField1 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MemberInfo)paramPBRepeatMessageField2.get(i2)).get();
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      do
      {
        i1 = paramInt1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (VideoController.GAudioFriends)((Iterator)localObject1).next();
      } while (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i1 = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver remove member UIN:" + ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long);
    }
    for (;;)
    {
      i2 += 1;
      break;
      if (paramInt1 != 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.jdField_b_of_type_JavaUtilArrayList });
      }
      return;
      label548:
      paramInt1 = i1;
    }
  }
  
  public void a(Class paramClass)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.a(paramClass.getName());
    }
  }
  
  void a(Long paramLong, long paramLong1, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onBanAudio-->relationId" + paramLong + " uin=" + paramLong1 + " relationType=" + paramInt + " bBan=" + paramBoolean);
    }
    if (paramLong1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
      return;
    }
    if (paramBoolean)
    {
      a().ac = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    a().ac = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelNetWorkTimer[" + paramString + "]");
    }
    this.y = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    PopupDialog.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo closeVideo begin, peerUin[" + paramString + "], emCloseReason[" + paramInt + "], seq[" + l1 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "]", new Throwable("打印调用栈"));
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((!q()) && (this.jdField_a_of_type_ComTencentAvSessionMgr.b()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      SignalStrengthReport.a(a()).b();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
    }
    ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, paramString);
    this.jdField_h_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    if ((q()) && (paramInt != 110)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((VideoRecoveryMonitor)localObject).a(paramInt);
    }
    localObject = SessionMgr.a().a().jdField_d_of_type_JavaLangString;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString))) {
      G();
    }
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    localObject = a().jdField_d_of_type_JavaLangString;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString)))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      if (a().jdField_k_of_type_Boolean)
      {
        paramString = VideoLayerUI.a(paramString, 1);
        GraphicRenderMgr.getInstance().setGlRender(paramString, null);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "avideo closeVideo, clear gl render, key[" + paramString + "]");
        }
        a(l1, a().jdField_d_of_type_Int, true, true);
      }
      d(paramInt);
      QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo closeVideo end, result[" + i1 + "], cancelNotificationForce[" + bool + "], seq[" + l1 + "]");
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    Object localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder().append("sendVideoMsgBroadcast uinType: ").append(paramInt1).append(", msgType: ").append(paramInt2).append(", friendUin: ").append(paramString2).append(", selfUin: ");
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      localObject1 = Integer.valueOf(0);
      QLog.d((String)localObject2, 1, localObject1 + ", isReceiver = " + a().jdField_e_of_type_Boolean + ", isVideoMsg = " + paramBoolean1 + ", extraUin: " + paramString3 + ", forceUnread:" + paramBoolean2);
      if ((!TextUtils.isEmpty(paramString2)) && (!"0".equals(paramString2))) {
        break label195;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast, invalid uin[" + paramString2 + "]");
    }
    label195:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      break;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).setAction("tencent.video.v2q.AddVideoMsg");
    localObject3 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
    if (localObject3 == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      return;
    }
    if (paramInt2 == 21) {
      if ((((SessionInfo)localObject3).jdField_i_of_type_Int == 11) || (((SessionInfo)localObject3).jdField_i_of_type_Int == 12))
      {
        paramInt2 = 47;
        ((SessionInfo)localObject3).a(1, 0);
        paramInt1 = 0;
      }
    }
    label523:
    label785:
    label791:
    label794:
    label801:
    for (;;)
    {
      boolean bool = false;
      if ((((SessionInfo)localObject3).j()) && (paramInt2 == 1)) {
        bool = true;
      }
      for (;;)
      {
        if (paramBoolean2) {
          bool = false;
        }
        ((Intent)localObject2).putExtra("uinType", paramInt1);
        ((Intent)localObject2).putExtra("msgType", paramInt2);
        ((Intent)localObject2).putExtra("isVideoMsg", paramBoolean1);
        ((Intent)localObject2).putExtra("isRead", bool);
        ((Intent)localObject2).putExtra("bindType", ((SessionInfo)localObject3).A);
        ((Intent)localObject2).putExtra("bindId", ((SessionInfo)localObject3).jdField_p_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("MultiAVType", ((SessionInfo)localObject3).D);
        if (paramInt2 == 17) {
          ((Intent)localObject2).putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
          break label706;
        }
        if (paramInt2 != 20) {
          break label791;
        }
        paramString3 = paramString1;
        label446:
        localObject1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          localObject1 = paramString1;
        }
        if (((SessionInfo)localObject3).J)
        {
          if (!((SessionInfo)localObject3).M) {
            break label778;
          }
          localObject1 = paramString1;
        }
        label480:
        ((Intent)localObject2).putExtra("friendUin", paramString2);
        ((Intent)localObject2).putExtra("senderUin", (String)localObject1);
        ((Intent)localObject2).putExtra("selfUin", paramString1);
        if (((SessionInfo)localObject3).jdField_e_of_type_Boolean) {
          break label785;
        }
        paramBoolean1 = true;
        ((Intent)localObject2).putExtra("isSender", paramBoolean1);
        paramString1 = null;
        if (((SessionInfo)localObject3).jdField_e_of_type_Long > 0L) {
          paramString1 = UITools.a(a());
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getConnectedTime():" + a() + " extra:" + paramString1);
        }
        ((Intent)localObject2).putExtra("extra", paramString1);
        ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject2);
        return;
        paramInt2 = 48;
        break;
        if (paramInt2 != 72) {
          break label801;
        }
        if ((((SessionInfo)localObject3).jdField_i_of_type_Int == 16) || (((SessionInfo)localObject3).jdField_i_of_type_Int == 17)) {}
        for (paramInt2 = 47;; paramInt2 = 48)
        {
          ((SessionInfo)localObject3).a(1, 0);
          paramInt1 = 0;
          break;
        }
        if (((SessionInfo)localObject3).l()) {
          bool = true;
        }
      }
      label706:
      if (paramInt1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label794;
        }
      }
      for (;;)
      {
        if (((SessionInfo)localObject3).jdField_e_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          localObject1 = paramString3;
          paramString3 = paramString2;
          paramString2 = (String)localObject1;
          break;
        }
        if (((SessionInfo)localObject3).jdField_e_of_type_Boolean) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        localObject1 = paramString2;
        break label480;
        paramBoolean1 = false;
        break label523;
        break label446;
        paramString3 = paramString2;
      }
    }
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, 2, paramBoolean, paramString2, paramString3, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (AudioHelper.e()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStartVideoBroadcast, sessionId[" + paramString + "], sessionType[" + paramInt + "], updateTime[" + paramBoolean1 + "], showTime[" + paramBoolean2 + "], isDouble[" + paramBoolean3 + "]");
      }
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("sessionId", paramString);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr != null)
      {
        paramString = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString);
        if (paramString != null)
        {
          localIntent.putExtra("uinType", paramString.jdField_j_of_type_Int);
          if (paramString.jdField_j_of_type_Int != 26) {
            break label376;
          }
          localIntent.putExtra("peerUin", paramString.jdField_f_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      if ((paramInt == 3) || (paramInt == 4))
      {
        localIntent.putExtra("peerUin", String.valueOf(paramString.jdField_g_of_type_Long));
        localIntent.putExtra("relationType", paramString.F);
        localIntent.putExtra("relationId", paramString.jdField_g_of_type_Long);
      }
      localIntent.putExtra("extraUin", paramString.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("bindType", paramString.A);
      localIntent.putExtra("bindId", paramString.jdField_p_of_type_JavaLangString);
      localIntent.putExtra("isReceiver", paramString.jdField_e_of_type_Boolean);
      localIntent.putExtra("isDoubleVideoMeeting", paramString.J);
      if (q()) {
        localIntent.putExtra("isNearbyVideoChat", true);
      }
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("isDouble", paramBoolean3);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      return;
      label376:
      localIntent.putExtra("peerUin", paramString.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    StringBuilder localStringBuilder;
    if (((paramString == null) || (!paramString.a(paramInt, paramArrayOfByte))) && (QLog.isDevelopLevel()))
    {
      paramArrayOfByte = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("收到未知的C2C消息[").append(paramInt).append("], handlerForVideo[");
      if (paramString == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(paramArrayOfByte, 1, bool + "]");
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("setMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      long l1 = Long.valueOf(paramString).longValue();
      if ((l1 > 0L) && (paramLong > 0L)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), Long.valueOf(paramLong));
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setMSFInviteMessageTimeStamp fail.", paramString);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramLong, paramBoolean, false, -1);
  }
  
  public void a(String arg1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.29(this, ???, paramLong, paramBoolean1, paramBoolean2));
      }
      if (paramBoolean1) {
        break label139;
      }
      paramBoolean2 = true;
      a("gAudioSetInput", paramBoolean2);
      if (paramInt != -1) {
        break label164;
      }
      if (!paramBoolean1) {
        break label145;
      }
      paramInt = 0;
    }
    label139:
    label145:
    label164:
    for (;;)
    {
      for (;;)
      {
        c("gAudioSetInput", paramInt);
        paramLong = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        synchronized (this.jdField_c_of_type_JavaUtilArrayList)
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.size() > 1)
          {
            paramInt = 1;
            if ((!paramBoolean1) && (paramInt != 0)) {
              a(this.jdField_a_of_type_Long, new long[] { paramLong }, paramBoolean1, 0);
            }
            return;
            paramBoolean2 = false;
            break;
            paramInt = 1;
            continue;
          }
          paramInt = 0;
        }
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetStrangerFaceSuc uin:" + paramString + ",face :" + paramBitmap);
    }
    a(paramString, paramBitmap, false);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(201), paramString, paramBitmap });
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin: " + paramString + ", anonymous: " + paramBoolean);
    }
    if (!l()) {}
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())))
        {
          if (paramBoolean)
          {
            a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 3) {
          break;
        }
        VideoController.GAudioFriends localGAudioFriends = a(paramString);
        if (localGAudioFriends != null)
        {
          localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    SessionInfo localSessionInfo = null;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr != null) {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (String str = "mApp is null";; str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + localSessionInfo + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (localSessionInfo != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", localSessionInfo.A);
    paramString1.putExtra("bindId", localSessionInfo.jdField_p_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", localSessionInfo.jdField_d_of_type_Int);
    paramString1.putExtra("isDoubleVideoMeeting", localSessionInfo.J);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(VideoConstants.jdField_d_of_type_JavaLangString, localSessionInfo.jdField_e_of_type_Long);
    paramString1.putExtra(VideoConstants.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
    paramString1.putExtra(VideoConstants.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", a());
    long l1 = 0L;
    if ((localSessionInfo.jdField_d_of_type_Int == 1) || (localSessionInfo.jdField_d_of_type_Int == 2)) {
      l1 = 1L;
    }
    if ((localSessionInfo.jdField_d_of_type_Int == 3) || (localSessionInfo.jdField_d_of_type_Int == 4)) {
      l1 = 2L;
    }
    paramString1.putExtra(VideoConstants.i, l1);
    if ((localSessionInfo.jdField_d_of_type_Int == 1) || (localSessionInfo.jdField_d_of_type_Int == 3)) {}
    for (l1 = 1L;; l1 = 0L)
    {
      paramString1.putExtra(VideoConstants.j, l1);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).l != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).l);
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_m_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_m_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).F);
        paramString1.putExtra("relationId", this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2).jdField_g_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label661;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        DoodleLogic.a().a.a();
        break;
        label661:
        paramString1.putExtra("senderUin", paramString5);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateRandomChatInfo uin: " + paramString1 + ", nickName: " + paramString2 + ", headUrl: " + paramString3);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.updateChatInfo");
    if (!TextUtils.isEmpty(paramString1))
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("nickName", paramString2);
      localIntent.putExtra("headUrl", paramString3);
    }
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ",nickname:" + paramString2 + ", anonymous = " + paramBoolean);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!l())) {}
    label134:
    label155:
    label195:
    do
    {
      do
      {
        return;
        if (paramString1.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          if (!paramBoolean) {
            break label134;
          }
          a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.g = paramString2;
        }
        VideoController.GAudioFriends localGAudioFriends;
        for (;;)
        {
          if (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 3) {
            break label195;
          }
          localGAudioFriends = a(paramString1);
          if (localGAudioFriends == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          localGAudioFriends.jdField_b_of_type_JavaLangString = paramString2;
          return;
          a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_JavaLangString = paramString2;
        }
        localGAudioFriends.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioMute, [" + this.jdField_l_of_type_Boolean + " --> " + paramBoolean + "], from[" + paramString + "]");
    }
    this.jdField_l_of_type_Boolean = paramBoolean;
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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "on 0x626Recv --> Size = " + paramArrayList.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "on0x626Recv --> no data");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    paramArrayList = paramArrayList.iterator();
    AVPhoneUserInfo localAVPhoneUserInfo;
    Iterator localIterator;
    int i1;
    label114:
    Object localObject;
    if (paramArrayList.hasNext())
    {
      localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      localIterator = a().jdField_f_of_type_JavaUtilArrayList.iterator();
      i1 = 0;
      if (localIterator.hasNext())
      {
        localObject = (AVPhoneUserInfo)localIterator.next();
        if ((((AVPhoneUserInfo)localObject).account == 0L) || (((AVPhoneUserInfo)localObject).account != localAVPhoneUserInfo.account)) {
          break label450;
        }
        ((AVPhoneUserInfo)localObject).telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
        ((AVPhoneUserInfo)localObject).telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
        ((AVPhoneUserInfo)localObject).telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
        i1 = 1;
      }
    }
    label450:
    for (;;)
    {
      break label114;
      if ((i1 == 0) && (QLog.isColorLevel()))
      {
        localStringBuilder.append("on0x626Recv --> can not find the item . Info = ");
        localStringBuilder.append(localAVPhoneUserInfo.toString());
        localStringBuilder.append("\n");
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoController.GAudioFriends)localIterator.next();
        if ((((VideoController.GAudioFriends)localObject).jdField_d_of_type_Int == 1) && (((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
        }
      }
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(406) });
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("notifyAnotherSelfIsRing, isCalling[").append(this.jdField_i_of_type_Boolean).append("->").append(paramBoolean).append("], mVcCtrl[");
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        bool = true;
        QLog.w(str, 1, bool + "], sessionInfo SessionType[" + a().jdField_d_of_type_Int + "], sessionInfo state[" + a().jdField_g_of_type_Int + "], isPeerOnPhone[" + a().T + "]");
      }
    }
    else
    {
      if (this.jdField_i_of_type_Boolean != paramBoolean) {
        break label139;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label139:
      this.jdField_i_of_type_Boolean = paramBoolean;
      if (!a().T)
      {
        if (paramBoolean) {
          if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
          {
            if ((!a().S) && (a().jdField_j_of_type_Boolean)) {
              b(a().jdField_d_of_type_JavaLangString);
            }
            if (!a().jdField_g_of_type_Boolean) {
              a(true, a().jdField_d_of_type_JavaLangString);
            }
            b(false, a().jdField_d_of_type_JavaLangString);
          }
        }
        while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
        {
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherSelfIsRing(a().jdField_d_of_type_JavaLangString, paramBoolean);
          return;
          a("notifyAnotherSelfIsRing", true);
          continue;
          if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
          {
            if ((!a().S) && (a().jdField_j_of_type_Boolean)) {
              c(a().jdField_d_of_type_JavaLangString);
            }
            if (!a().jdField_g_of_type_Boolean) {
              a(false, a().jdField_d_of_type_JavaLangString);
            }
            b(true, a().jdField_d_of_type_JavaLangString);
            y();
          }
          else
          {
            a("notifyAnotherSelfIsRing", false);
            if (a().jdField_P_of_type_Boolean)
            {
              if (this.jdField_g_of_type_JavaLangRunnable == null) {
                this.jdField_g_of_type_JavaLangRunnable = new VideoController.23(this);
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 2000L);
            }
          }
        }
      }
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
    if (paramVarArgs.jdField_g_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localQAVNotification != null) {
          localQAVNotification.a(paramVarArgs.jdField_c_of_type_JavaLangString);
        }
        QLog.w(jdField_a_of_type_JavaLangString, 1, "closeMainSession, mGAudioInRoom[" + this.jdField_d_of_type_Boolean + "], isDoubleVideoMeeting[" + paramVarArgs.J + "], \nsession[" + paramVarArgs + "], \nseq[" + l1 + "]");
        if ((l()) || (m()))
        {
          e(true);
          return;
        }
        if ((paramVarArgs.jdField_d_of_type_Int != 3) && (paramVarArgs.jdField_d_of_type_Int != 4)) {
          break;
        }
      } while (!this.jdField_d_of_type_Boolean);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(paramVarArgs.jdField_g_of_type_Long), Boolean.valueOf(true) });
      }
      if (paramVarArgs.J)
      {
        a(l1, this.jdField_a_of_type_Long, true, 0);
        return;
      }
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 30);
      return;
    } while ((paramVarArgs.jdField_d_of_type_Int != 1) && (paramVarArgs.jdField_d_of_type_Int != 2));
    if ((paramVarArgs.jdField_g_of_type_Int == 2) || (paramVarArgs.jdField_g_of_type_Int == 13))
    {
      if (paramVarArgs.J)
      {
        a(l1, paramVarArgs.jdField_d_of_type_JavaLangString, 1, true);
        long l2 = Long.valueOf(paramVarArgs.jdField_d_of_type_JavaLangString).longValue();
        a(l1, 3, l2);
        a(l1, l2, 1);
        return;
      }
      a(l1, paramVarArgs.jdField_d_of_type_JavaLangString, 1, false);
      a(paramVarArgs.jdField_d_of_type_JavaLangString, paramInt);
      b(paramVarArgs.jdField_d_of_type_JavaLangString, 0);
      return;
    }
    if (paramVarArgs.J)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramVarArgs.jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      a(l1, Long.valueOf(paramVarArgs.jdField_d_of_type_JavaLangString).longValue(), true, 0);
      return;
    }
    a(paramVarArgs.jdField_d_of_type_JavaLangString, paramInt);
    b(paramVarArgs.jdField_d_of_type_JavaLangString, 0);
    a(l1, 2, true, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(((SessionInfo)localObject).jdField_b_of_type_Boolean).append("->").append(paramBoolean2).append("], deviceName[").append(((SessionInfo)localObject).jdField_q_of_type_JavaLangString).append("], audioStateBeforePhoneCall[").append(((SessionInfo)localObject).t).append("], mTraeHelper[");
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        break;
      }
      return;
    }
    if ((((SessionInfo)localObject).jdField_g_of_type_Int != 0) && (((SessionInfo)localObject).jdField_g_of_type_Int != 5) && (((SessionInfo)localObject).jdField_g_of_type_Int != 6) && (((SessionInfo)localObject).jdField_b_of_type_Boolean != paramBoolean2))
    {
      ((SessionInfo)localObject).jdField_b_of_type_Boolean = paramBoolean2;
      if (!paramBoolean2) {
        break label225;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b();
      ((SessionInfo)localObject).t = ((SessionInfo)localObject).jdField_q_of_type_JavaLangString;
    }
    while (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label225:
      if ("DEVICE_SPEAKERPHONE".equals(((SessionInfo)localObject).t))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject).t))
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (((SessionInfo)localObject).jdField_d_of_type_Int == 1) {}
        for (localObject = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; localObject = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
        {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a((String)localObject);
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i1 = DoodleLogic.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().jdField_B_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(long[] paramArrayOfLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    if (str != null)
    {
      long l1 = CharacterUtil.a(str);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "inviteNewMemJoin, uinList[" + paramArrayOfLong + "], needNotifyUI[" + paramBoolean + "], mMultiInviteEntranceFlag[" + this.jdField_e_of_type_Int + "]");
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    do
    {
      return;
      if (this.jdField_e_of_type_Int == 1)
      {
        int i2 = paramArrayOfLong.length;
        long[] arrayOfLong = new long[i2 * 2];
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfLong[(i1 * 2)] = 1L;
          arrayOfLong[(i1 * 2 + 1)] = paramArrayOfLong[i1];
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(arrayOfLong, i2, null, 0, 0, false, false, 4);
        i1 = 0;
        while (i1 < i2)
        {
          if (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramArrayOfLong[i1]))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramArrayOfLong[i1]));
          }
          i1 += 1;
        }
      }
    } while (!paramBoolean);
    int i1 = paramArrayOfLong.length;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(i1) });
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return (this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == paramInt) && (this.jdField_a_of_type_Long == paramLong);
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      k();
    }
    int i2 = -999;
    int i1 = i2;
    if (paramLong > 0L)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_m_of_type_Boolean = true;
        if (paramInt1 != 1) {
          break label139;
        }
        i1 = paramInt2;
      }
    }
    for (;;)
    {
      i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeUpdateRoomInfo(paramInt1, paramLong, i1, true, true, true);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getGAudioRoomMemList, relationType[" + paramInt1 + "], discussId[" + paramLong + "], avtype[" + paramInt2 + "], result[" + i1 + "]");
      if (i1 != 0) {
        break;
      }
      return true;
      label139:
      if (paramInt1 == 2) {
        i1 = 1;
      } else if (paramInt1 == 3) {
        i1 = 8;
      } else {
        i1 = 0;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    SessionInfo localSessionInfo = a();
    String str = SessionMgr.a(3, paramString, new int[0]);
    if (TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, str)) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt == 1011) && (localSessionInfo.jdField_j_of_type_Int == paramInt) && (TextUtils.equals(localSessionInfo.jdField_d_of_type_JavaLangString, paramString)));
      paramInt = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      if (paramInt >= 2)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDAV, to many session, reject. [" + paramInt + "]");
        return true;
      }
    } while ((!localSessionInfo.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()));
    QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDAV, one in av game and one in invite.");
    return true;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo isRequestVideo uinType = " + paramInt1 + ", fromUin = " + paramString1 + ", extraUin = " + paramString2 + ", sig = " + paramArrayOfByte + ", onlyAudio = " + paramBoolean + ", bindID=" + paramString3 + " ,bindType=" + paramInt2);
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "isRequestVideo  faile,app is null, return false");
      return false;
    }
    paramBoolean = this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() < 2) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo->pending session exists");
      }
      paramInt1 = -1;
      paramString2 = null;
      if (a() != null)
      {
        paramInt1 = a().jdField_j_of_type_Int;
        paramString2 = a().jdField_d_of_type_JavaLangString;
      }
      if ((paramInt2 == 1011) && (paramInt1 == 1011) && (paramString2 != null) && (paramString2.equals(paramString1))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo->pending session exists, return false");
      }
      return false;
    }
    boolean bool = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo->isScreenLocked:" + bool);
    }
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random mulit");
      }
      if (bool) {
        return false;
      }
    }
    else if (a().f())
    {
      if (paramInt2 == -1) {
        return false;
      }
    }
    else if (((a().jdField_g_of_type_Int == 7) && (this.jdField_c_of_type_Long != 0L)) || (a().jdField_g_of_type_Int == 14) || (a().jdField_g_of_type_Int == 13))
    {
      if (bool) {
        return false;
      }
    }
    else if (!this.jdField_d_of_type_Boolean)
    {
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo  auto Accept");
        }
        if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString.equals(paramString1))) {
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool);
        }
        if ((a().jdField_d_of_type_JavaLangString != null) && (paramString1.equals(a().jdField_d_of_type_JavaLangString)))
        {
          AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "isRequestVideo when request: fromUin = " + paramString1);
          return false;
        }
        if (bool) {
          return false;
        }
      }
    }
    else if ((this.jdField_d_of_type_Boolean) || (a().jdField_g_of_type_Int == 8))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in group chat, fromUin = " + paramString1);
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_g_of_type_Int == 1) && (a().jdField_d_of_type_JavaLangString != null) && (paramString1.equals(a().jdField_d_of_type_JavaLangString)))
    {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
      return false;
    }
    if (paramBoolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo orientation: " + this.jdField_n_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a(), 0));
    }
    return true;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {}
    SessionInfo localSessionInfo;
    do
    {
      String str;
      do
      {
        return false;
        str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
        localSessionInfo = a();
      } while (TextUtils.equals(str, localSessionInfo.jdField_c_of_type_JavaLangString));
      paramInt1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDM, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!localSessionInfo.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()));
    QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDM, one in av game and one in invite.");
    return true;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
        paramInt2 = 0;
        if (paramInt2 >= i1) {
          break label173;
        }
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((localGAudioFriends == null) || (localGAudioFriends.jdField_a_of_type_Long != paramLong)) {
          break label186;
        }
        localGAudioFriends.jdField_e_of_type_Boolean = paramBoolean;
        localGAudioFriends.jdField_d_of_type_Int = paramInt1;
        bool = localGAudioFriends.jdField_g_of_type_Boolean;
        if (paramBoolean)
        {
          localGAudioFriends.jdField_g_of_type_Boolean = false;
          paramBoolean = bool;
          return paramBoolean;
        }
      }
      if (localObject.jdField_f_of_type_Boolean)
      {
        localObject.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(false) });
        paramBoolean = bool;
        continue;
        label173:
        paramBoolean = false;
      }
      else
      {
        paramBoolean = bool;
        continue;
        label186:
        paramInt2 += 1;
      }
    }
  }
  
  boolean a(long paramLong, int paramInt, ArrayList<VideoViewInfo> paramArrayList)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.quaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
    }
    if (QLog.isColorLevel()) {}
    return false;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public boolean a(SessionInfo paramSessionInfo1, SessionInfo paramSessionInfo2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo1.jdField_d_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          boolean bool1;
          VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          paramSessionInfo2.a(paramLong1, paramSessionInfo1.jdField_j_of_type_Boolean);
          a(paramString, paramSessionInfo2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_e_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          }
          if (!paramSessionInfo1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          int i1 = paramSessionInfo1.jdField_d_of_type_Int;
          paramSessionInfo2.aH = true;
          paramSessionInfo2.jdField_d_of_type_JavaLangString = paramSessionInfo1.jdField_d_of_type_JavaLangString;
          if ((paramSessionInfo1.jdField_g_of_type_Int == 15) || (paramSessionInfo1.jdField_K_of_type_Boolean)) {
            d(false);
          }
          paramSessionInfo1.a(3, 12);
          if (i1 == 1)
          {
            paramSessionInfo1.a(paramLong1, "onGAudioInvite.6", 3);
            paramSessionInfo1.jdField_j_of_type_Int = UITools.c(paramInt);
            paramSessionInfo1.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramSessionInfo1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramSessionInfo1.c("onGAudioInvite.1", 1);
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.a() <= 0) {
                break label522;
              }
              paramSessionInfo1.d("onGAudioInvite3", AVUtil.a(paramSessionInfo1.jdField_j_of_type_Int));
              localVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramSessionInfo2 = QAVNotification.a(localVideoAppInterface);
            int i2 = 0;
            if (paramSessionInfo2 != null)
            {
              boolean bool2 = paramSessionInfo2.a();
              i2 = bool2;
              if (bool2)
              {
                paramSessionInfo2.a(paramSessionInfo1.jdField_c_of_type_JavaLangString);
                i2 = bool2;
              }
            }
            if (i2 != 0) {
              b();
            }
            return bool1;
            localThrowable = localThrowable;
            localThrowable.printStackTrace();
            continue;
            bool1 = false;
            continue;
          }
          if (i1 == 2)
          {
            paramSessionInfo1.a(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i1 != 4) {
            break label510;
          }
        }
        catch (Exception paramSessionInfo1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramSessionInfo1.getMessage());
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, paramString);
          return bool1;
        }
        paramSessionInfo1.a(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label510:
        paramSessionInfo1.a(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label522:
        if (localThrowable.isBackgroundStop)
        {
          paramSessionInfo1.d("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          k(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramSessionInfo1.L))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramSessionInfo1.L + "], ret[" + bool1 + "], main[" + paramSessionInfo1 + "], new[" + paramSessionInfo2 + "]");
      }
      paramSessionInfo1.L = false;
      if (!bool1) {
        break label559;
      }
    }
    label559:
    return false;
  }
  
  public boolean a(String paramString)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "StopGVideo, from[" + paramString + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.21(this, l1));
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
    QLog.d(jdField_a_of_type_JavaLangString, 1, "quaReport --> report result = " + bool + " | node = " + paramInt + " | timestamp = " + paramLong);
    return bool;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    boolean bool2;
    if (paramSessionInfo == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i1 = paramSessionInfo.e();
    long l1 = paramSessionInfo.b();
    long l2 = paramSessionInfo.g();
    long l3;
    if (i1 == 2)
    {
      l3 = a(paramSessionInfo);
      if (l3 != paramSessionInfo.b()) {
        paramSessionInfo.d(l3);
      }
    }
    for (;;)
    {
      l3 = paramSessionInfo.b();
      long l4 = paramSessionInfo.g();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramSessionInfo, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i1 == 1)
      {
        l3 = b(paramSessionInfo);
        if (l3 != paramSessionInfo.b()) {
          paramSessionInfo.d(l3);
        }
      }
    }
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = a();
    String str;
    boolean bool;
    if (paramBoolean) {
      if (paramInt == 3)
      {
        str = SessionMgr.a(100, paramString2, new int[0]);
        if (TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, str)) {
          break label231;
        }
        bool = SessionMgr.a().b(str);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkMainSession, need reset main session, from[" + paramString1 + "], cur" + localSessionInfo.jdField_c_of_type_JavaLangString + "], coming[" + str + "], ret[" + bool + "]");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMainSession, from[" + paramString1 + "], isFromMAVEngine[" + paramBoolean + "], relationType[" + paramInt + "], relationId[" + paramString2 + "], ret[" + bool + "]");
      }
      return bool;
      str = SessionMgr.a(paramInt, paramString2, new int[0]);
      break;
      str = SessionMgr.a(paramInt, paramString2, new int[0]);
      break;
      label231:
      bool = false;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject = a(a().jdField_e_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->info=" + (String)localObject);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      J();
      i1 = 0;
      if (i1 >= a().jdField_e_of_type_JavaUtilArrayList.size()) {
        break label316;
      }
      if (((VideoViewInfo)a().jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        a().jdField_e_of_type_JavaUtilArrayList.remove(i1);
      }
    }
    label139:
    label316:
    for (int i1 = 1;; i1 = 0)
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        if (i1 != 0) {
          i1 = 8;
        }
        for (;;)
        {
          if (i1 < a().jdField_e_of_type_JavaUtilArrayList.size())
          {
            localObject = new ArrayList(i1);
            for (;;)
            {
              if (i2 < i1)
              {
                ((ArrayList)localObject).add(a().jdField_e_of_type_JavaUtilArrayList.get(i2));
                i2 += 1;
                continue;
                i1 += 1;
                break;
                i1 = 9;
                break label139;
              }
            }
            a().jdField_e_of_type_JavaUtilArrayList = ((ArrayList)localObject);
          }
        }
      }
      if (a().jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (ArrayList)a().jdField_e_of_type_JavaUtilArrayList.clone();
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.20(this, (ArrayList)localObject, paramBoolean));
        }
      }
      return true;
      a().jdField_e_of_type_JavaUtilArrayList.clear();
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=" + (String)localObject);
      }
      return false;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.postData(paramLong2, paramArrayOfByte);
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
          if ((localGAudioFriends != null) && (localGAudioFriends.jdField_a_of_type_Long != CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
          {
            int i2 = i1;
            if (localGAudioFriends.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (localGAudioFriends.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            if (localGAudioFriends.jdField_c_of_type_Boolean) {
              i1 += 1;
            }
          }
        }
        else
        {
          return i1;
        }
      }
      finally {}
      i3 += 1;
    }
  }
  
  public int b(int paramInt)
  {
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
    int i2 = -1;
    int i1;
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2))
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setVoiceType(paramInt);
      }
    }
    do
    {
      do
      {
        return i1;
        if (a().jdField_d_of_type_Int == 3) {
          break;
        }
        i1 = i2;
      } while (a().jdField_d_of_type_Int != 4);
      i1 = i2;
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setVoiceType(paramInt);
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterAudioDataCallback(paramInt);
    }
    return -1;
  }
  
  public int b(SessionInfo paramSessionInfo, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramSessionInfo, paramString);
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    int i1 = -1;
    SessionInfo localSessionInfo = SessionMgr.a().a(paramString);
    if ((localSessionInfo != null) && (localSessionInfo.d() != -1)) {
      i1 = localSessionInfo.d();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
  }
  
  public int b(boolean paramBoolean)
  {
    if ((a().l()) || (this.jdField_d_of_type_Boolean))
    {
      int i1 = 0;
      if (a().jdField_d_of_type_Int == 1) {
        if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
          i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getVolume(paramBoolean);
        }
      }
      do
      {
        return i1;
        if (a().jdField_d_of_type_Int != 3) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVolume();
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getVolume(paramBoolean);
    }
    return 255;
  }
  
  public int b(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioOutput(paramString, paramBoolean);
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
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramSessionInfo.F, paramSessionInfo.D, paramSessionInfo.jdField_g_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramSessionInfo.d(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramSessionInfo.d(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
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
    if (r()) {
      return this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
    }
    return null;
  }
  
  public ArrayList<VideoController.GAudioFriends> b()
  {
    if ((AudioHelper.d()) && (AVRedBagMgr.TestFlag.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(AVRedBagMgr.TestFlag.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    int i2 = 3;
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((SessionInfo)localObject2).jdField_e_of_type_Boolean) {
          break label306;
        }
        if (((SessionInfo)localObject2).j())
        {
          if ((((SessionInfo)localObject2).jdField_d_of_type_Int == 1) || (((SessionInfo)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((SessionInfo)localObject2).S) && (!((SessionInfo)localObject2).J))
            {
              i1 = 56;
              if ((((SessionInfo)localObject2).jdField_j_of_type_Int != 1011) && (!l())) {
                break label372;
              }
              i1 = ((SessionInfo)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label665;
              }
              if (((SessionInfo)localObject2).F != 7) {
                break label695;
              }
              i1 = i2;
              if (((SessionInfo)localObject2).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 4) {
                break label344;
              }
              i2 = 52;
              if (this.jdField_f_of_type_Boolean)
              {
                i2 = 60;
                s();
              }
              localQAVNotification.a(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, "", null, null, i2, ((SessionInfo)localObject2).jdField_j_of_type_Int, i1);
              r();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((SessionInfo)localObject2).jdField_g_of_type_Long);
          localObject4 = ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString;
          localObject2 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localQAVNotification.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.14(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
          break label671;
        }
      }
      finally {}
      int i1 = 47;
      label306:
      if (((SessionInfo)localObject2).l())
      {
        if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
          break label680;
        }
        i1 = 47;
      }
      else
      {
        if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
          break label689;
        }
        i1 = 46;
        break label686;
        label344:
        localObject1.a(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, "", null, null, 51, ((SessionInfo)localObject2).jdField_j_of_type_Int, i1);
        s();
        continue;
        label372:
        if ((((SessionInfo)localObject2).jdField_d_of_type_Int == 3) || (((SessionInfo)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((SessionInfo)localObject2).J)
          {
            localObject3 = ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, null, true, true);
            localObject1.a(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((SessionInfo)localObject2).jdField_g_of_type_Long), 48, 0, ((SessionInfo)localObject2).jdField_d_of_type_Int);
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(a().jdField_j_of_type_Int, String.valueOf(a().jdField_g_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_j_of_type_Int, String.valueOf(((SessionInfo)localObject2).jdField_g_of_type_Long), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((SessionInfo)localObject2).jdField_g_of_type_Long), 44, ((SessionInfo)localObject2).jdField_j_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_Int);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.15(this), 1000L);
          continue;
        }
        if (((SessionInfo)localObject2).jdField_e_of_type_JavaLangString == null) {
          ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_j_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_f_of_type_JavaLangString);
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_j_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_f_of_type_JavaLangString, true, true);
        localObject1.a(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((SessionInfo)localObject2).jdField_j_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_Int);
        continue;
        continue;
        for (;;)
        {
          break;
          i1 = 42;
        }
      }
      for (;;)
      {
        label665:
        label671:
        break;
        label680:
        i1 = 42;
      }
      for (;;)
      {
        label686:
        break;
        label689:
        i1 = 41;
      }
      label695:
      i1 = 1;
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportCloseReasonBeacon,reason  = " + paramInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("closeReason", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAvideoCloseReasonB", true, 0L, 0L, localHashMap, "", true);
  }
  
  void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaRoomSettingChanged-->relationType = " + paramInt1 + " relationUin = " + paramLong + " changedType = " + paramInt2);
    }
    if (paramInt2 == 102) {
      a().Z = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        a().Z = false;
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    AVLog.printColorLog(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6009), Integer.valueOf(paramInt), paramString });
  }
  
  void b(long paramLong)
  {
    if ((a().jdField_j_of_type_Int == 1011) || (a().jdField_j_of_type_Int == 21) || (q())) {}
    while (a().jdField_d_of_type_Long != 0L) {
      return;
    }
    long l1 = a().jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startReachedRing, peer colorRingId=" + l1);
    }
    String str = ColorRingManager.a(l1, 3);
    if (new File(str).exists())
    {
      TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_f_of_type_Boolean = true;
      int i1 = a().jdField_p_of_type_Int;
      ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
    a().jdField_f_of_type_Boolean = true;
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (a(a().jdField_d_of_type_JavaLangString) == paramLong2) {
      a().ap = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRecvAudioReady uin = " + paramLong1 + ",roomid = " + paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.35(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = SessionMgr.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str)) {}
      for (SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str); localSessionInfo == null; localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str))
      {
        QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        VideoNodeManager.a(0L, 33);
        VideoNodeManager.b(0L);
        return;
        str = SessionMgr.a(100, paramString, new int[0]);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a(localSessionInfo);
      }
      VideoNodeManager.a(localSessionInfo.b(), 16, 0L);
      VideoNodeManager.a(localSessionInfo.b(), 33);
      VideoNodeManager.b(localSessionInfo.b());
      localObject = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (localSessionInfo.jdField_e_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((VideoNodeReporter)localObject).a(localSessionInfo.b(), i2, i1 + 500);
        ((VideoNodeReporter)localObject).a("NoCrash");
        ((VideoNodeReporter)localObject).a(localSessionInfo.b(), 29, 1L);
        ((VideoNodeReporter)localObject).a(36, 1L);
        ((VideoNodeReporter)localObject).b(localSessionInfo.b());
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + localSessionInfo.f() + "], sessionInfo.peerUin[" + localSessionInfo.jdField_d_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + localSessionInfo.S + "], sessionInfo.SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!localSessionInfo.f()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((localSessionInfo.jdField_d_of_type_Int == 2) && (!localSessionInfo.J) && (localSessionInfo.jdField_g_of_type_Int >= 4) && (localSessionInfo.jdField_e_of_type_Long > 0L))
      {
        i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
        AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + localSessionInfo.jdField_e_of_type_Long + " | " + localSessionInfo.jdField_g_of_type_Int + " | " + localSessionInfo.u);
        if ((localSessionInfo.u) || (i2 > 0)) {
          ReportController.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_s_of_type_Boolean) && (a() > 0L))
      {
        if (localSessionInfo.jdField_d_of_type_Int == 1) {
          ReportController.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", UITools.a(a()), "");
        }
      }
      else
      {
        label750:
        localSessionInfo.jdField_d_of_type_Long = 0L;
        localSessionInfo.jdField_o_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(localSessionInfo.jdField_d_of_type_JavaLangString))
        {
          localObject = paramString;
          if (localSessionInfo.jdField_d_of_type_JavaLangString.contains(paramString)) {
            localObject = localSessionInfo.jdField_d_of_type_JavaLangString;
          }
        }
        if ((localSessionInfo.o()) || (localSessionInfo.p())) {
          localSessionInfo.z = i1;
        }
        if ((localSessionInfo.h()) || ((localSessionInfo.j()) && (i1 == localSessionInfo.z))) {
          localSessionInfo.a(paramLong, 0L);
        }
        if ((localSessionInfo.ak) && (this.jdField_f_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1599;
        }
        paramBoolean = false;
        if (localSessionInfo.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_j_of_type_Int, paramBoolean, localSessionInfo.jdField_d_of_type_JavaLangString, localSessionInfo.jdField_f_of_type_JavaLangString);
        label936:
        if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a())
        {
          h();
          j();
          s();
        }
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          DataReport.b(this, false);
          DataReport.c(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            DataReport.l(this);
          }
        }
        localSessionInfo.a("doCloseSession", 0);
        localSessionInfo.a(paramLong, "doCloseSession", 0);
        localSessionInfo.jdField_f_of_type_Int = 0;
        localSessionInfo.jdField_a_of_type_JavaUtilBitSet.clear();
        localSessionInfo.jdField_j_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        localSessionInfo.ax = false;
        localSessionInfo.jdField_a_of_type_ArrayOfJavaLangString = null;
        localSessionInfo.b("doCloseSession", null);
        localSessionInfo.jdField_p_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + localSessionInfo.jdField_j_of_type_Int + " # matchStatus = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (i1 != 72) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          localSessionInfo.jdField_j_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1613;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1243:
        if ((localSessionInfo.jdField_j_of_type_Int != 1011) || ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 6))) {
          break label1640;
        }
        if ((!this.jdField_f_of_type_Boolean) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 6)) {
          break label1623;
        }
        a(6, 1, null);
        label1307:
        this.jdField_a_of_type_Boolean = false;
        label1312:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 2)))
        {
          localSessionInfo.a();
          a(0, 0, null);
        }
        localSessionInfo.a(paramLong, false);
        localSessionInfo.b(paramLong, false);
        localSessionInfo.a(paramLong, 0L);
        localSessionInfo.b(paramLong);
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1658;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong, str);
      }
      for (;;)
      {
        paramString = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString != null) && (paramString.a()) && (!this.jdField_f_of_type_Boolean))
        {
          paramString.a(str);
          if (paramBoolean) {
            b();
          }
        }
        if (!this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this), 5000L);
        return;
        if (localSessionInfo.jdField_d_of_type_Int != 2) {
          break label750;
        }
        ReportController.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", UITools.a(a()), "");
        break label750;
        label1599:
        a(paramLong, str, (String)localObject, i1);
        break label936;
        label1613:
        if (!this.jdField_a_of_type_Boolean) {
          break label1243;
        }
        break label1243;
        label1623:
        a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, null);
        break label1307;
        label1640:
        if (!this.jdField_f_of_type_Boolean) {
          break label1312;
        }
        a(6, 1, null);
        break label1312;
        label1658:
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, 3);
      }
    }
  }
  
  public void b(long paramLong, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((a().jdField_d_of_type_Int > 0) && (a().jdField_d_of_type_Int <= 2) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
      if (a().l()) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.pauseVideo(paramString);
    }
    QLog.d("VideoController", 2, "pauseVideo end");
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
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setSoundEnable: " + paramBoolean);
      }
    } while (!this.jdField_d_of_type_Boolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public boolean b()
  {
    boolean bool1 = a(a());
    boolean bool2 = s();
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGameMode isQQPaused: " + bool3 + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isLandscape: " + bool2 + ", isScreenLocked: " + bool1);
    }
    return (!bool1) && (bool2) && (bool3) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
  }
  
  public boolean b(int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramInt2 == 5) || (paramInt2 == 4) || (paramInt2 == 3)) {}
    SessionInfo localSessionInfo;
    do
    {
      do
      {
        return false;
        localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      } while ((localSessionInfo.F == paramInt1) && (localSessionInfo.jdField_g_of_type_Long == paramLong));
      paramInt1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!localSessionInfo.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()));
    QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
    return true;
  }
  
  public boolean b(SessionInfo paramSessionInfo1, SessionInfo paramSessionInfo2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo1.jdField_d_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      boolean bool1;
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        bool1 = false;
      }
      for (;;)
      {
        label164:
        int i1;
        try
        {
          paramSessionInfo2.a(paramLong1, paramSessionInfo1.jdField_j_of_type_Boolean);
          a(paramString, paramSessionInfo2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramSessionInfo1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          i1 = paramSessionInfo1.jdField_d_of_type_Int;
          paramSessionInfo2.jdField_d_of_type_JavaLangString = paramSessionInfo1.jdField_d_of_type_JavaLangString;
          paramSessionInfo2.a(paramLong1, paramSessionInfo1.jdField_j_of_type_Boolean);
          paramSessionInfo2.jdField_g_of_type_Boolean = paramSessionInfo1.jdField_g_of_type_Boolean;
          paramSessionInfo2.b("onGAudioInvite", paramSessionInfo1.jdField_P_of_type_Boolean);
          paramSessionInfo2.b("onGAudioInvite", paramSessionInfo1.jdField_q_of_type_JavaLangString);
          paramSessionInfo2.aH = true;
          paramSessionInfo2.a(3, 12);
          paramSessionInfo1.a(3, 12);
          b(paramSessionInfo1.jdField_d_of_type_JavaLangString, 21);
          if (i1 == 1)
          {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.2", 3);
            paramSessionInfo2.jdField_j_of_type_Int = UITools.c(paramInt);
            paramSessionInfo2.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramSessionInfo2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramSessionInfo2.c("onGAudioInvite.2", 1);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
              break label547;
            }
            paramSessionInfo2.d("onGAudioInvite1", AVUtil.a(paramSessionInfo2.jdField_j_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramSessionInfo1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            int i2 = 0;
            if (paramSessionInfo1 != null)
            {
              boolean bool2 = paramSessionInfo1.a();
              i2 = bool2;
              if (bool2)
              {
                paramSessionInfo1.a(paramString);
                i2 = bool2;
              }
            }
            if (i2 == 0) {
              break;
            }
            b();
            return bool1;
          }
        }
        catch (Exception paramSessionInfo1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramSessionInfo1);
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, paramString);
          return bool1;
        }
        if (i1 == 2)
        {
          paramSessionInfo2.a(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i1 == 4)
        {
          paramSessionInfo2.a(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramSessionInfo2.a(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label547:
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop)
          {
            paramSessionInfo2.d("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            k(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramSessionInfo1 != paramSessionInfo2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramSessionInfo1 + "], new[" + paramSessionInfo2 + "]");
      }
      if (!bool1) {
        break label586;
      }
      if (paramSessionInfo1.z != 0) {
        break label164;
      }
      paramSessionInfo1.a("onGAudioInvite.2", 0);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramLong1, paramString);
      return bool1;
    }
    label586:
    return false;
  }
  
  public boolean b(String paramString)
  {
    int i1 = b(paramString);
    return (i1 == 5) || (i1 == 14);
  }
  
  public boolean b(boolean paramBoolean)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setRoomMicOff, micOff[" + paramBoolean + "]");
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (paramBoolean) {}
    for (;;)
    {
      return localQQGAudioCtrl.setMicMode(i1);
      i1 = 0;
    }
  }
  
  public int c()
  {
    return MSFNetInfoMonitor.a();
  }
  
  public int c(String paramString)
  {
    int i1 = -1;
    SessionInfo localSessionInfo = SessionMgr.a().a(paramString);
    if ((localSessionInfo != null) && (localSessionInfo.c() != -1)) {
      i1 = localSessionInfo.c();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString);
  }
  
  public long c()
  {
    return a(a());
  }
  
  public ArrayList<VideoController.GAudioFriends> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.d()) && (AVRedBagMgr.TestFlag.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(AVRedBagMgr.TestFlag.jdField_a_of_type_JavaUtilArrayList);
        return localArrayList2;
      }
      ArrayList localArrayList2 = this.jdField_c_of_type_JavaUtilArrayList;
      return localArrayList2;
    }
  }
  
  void c()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null)
    {
      this.jdField_d_of_type_JavaLangRunnable = new VideoController.17(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 20000L);
      }
    }
  }
  
  public void c(int paramInt)
  {
    SessionInfo localSessionInfo = a();
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", localSessionInfo.jdField_j_of_type_Int);
      localIntent.putExtra("peerUin", localSessionInfo.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("extraUin", localSessionInfo.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("relationType", localSessionInfo.F);
      if ((localSessionInfo.jdField_g_of_type_Long != 0L) || (localSessionInfo.jdField_j_of_type_Int != 0)) {
        break label259;
      }
      localIntent.putExtra("relationId", AVUtil.a(localSessionInfo.jdField_d_of_type_JavaLangString));
    }
    for (;;)
    {
      localIntent.putExtra("isDoubleVideoMeeting", localSessionInfo.J);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "sendAvSwitchBroadcast, sessionType[" + paramInt + "], peer[" + localSessionInfo.jdField_d_of_type_JavaLangString + "], type[" + localSessionInfo.jdField_d_of_type_Int + "], uinType[" + localSessionInfo.jdField_j_of_type_Int + "], relationType[" + localSessionInfo.F + "], relationId[" + localSessionInfo.jdField_g_of_type_Long + "]");
      }
      return;
      label259:
      localIntent.putExtra("relationId", localSessionInfo.jdField_g_of_type_Long);
    }
  }
  
  void c(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 == 108)
    {
      a().ab = true;
      localSessionInfo = a();
      if (!h())
      {
        bool = true;
        localSessionInfo.aa = bool;
        i1 = e();
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, e());
      }
    }
    while (!a().ab) {
      for (;;)
      {
        SessionInfo localSessionInfo;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        return;
        boolean bool = false;
      }
    }
    a().ab = false;
    int i1 = e();
    if (a().aa) {
      a("onMVSpeakModeChanged_2", this.jdField_a_of_type_Long, true, false, -1);
    }
    for (;;)
    {
      a(-1L, i1, e());
      break;
      a("onMVSpeakModeChanged_3", this.jdField_a_of_type_Long, false, false, -1);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void c(long paramLong)
  {
    int i1;
    if (a().jdField_j_of_type_Boolean)
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchVideo(a().jdField_d_of_type_JavaLangString);
      if ((QLog.isColorLevel()) || (i1 == -1)) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "switchVideo , ret[" + i1 + "], seq[" + paramLong + "]");
      }
    }
    do
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(a().jdField_d_of_type_JavaLangString);
    } while ((!QLog.isColorLevel()) && (i1 != -1));
    QLog.w(jdField_a_of_type_JavaLangString, 1, "switchAudio , ret[" + i1 + "], seq[" + paramLong + "]");
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    SessionInfo localSessionInfo = a();
    int i1;
    if ((!TextUtils.isEmpty(localSessionInfo.jdField_d_of_type_JavaLangString)) && ((!localSessionInfo.jdField_d_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (localSessionInfo.jdField_d_of_type_Int == 0)))
    {
      i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo1, result[" + i1 + "]");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a() == 0) && (TextUtils.isEmpty(localSessionInfo.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(localSessionInfo.jdField_d_of_type_JavaLangString)))
    {
      i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo2, result[" + i1 + "]");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo fail, mainSession[" + a() + "]");
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "resumeVideo SessionType :" + a().jdField_d_of_type_Int);
    }
    if (GraphicRenderMgr.soloaded) {}
    try
    {
      GraphicRenderMgr.getInstance().clearCameraFrames();
      if ((a().jdField_d_of_type_Int <= 0) || (a().jdField_d_of_type_Int > 2) || (!a().l())) {
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      do
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
        }
      } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.resumeVideo(paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioSpeakerMode, [" + this.jdField_q_of_type_Int + " --> " + paramInt + "], from[" + paramString + "]");
    }
    this.jdField_q_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public boolean c()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("initVcController mVcCtrl=%s", new Object[] { this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl }));
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
        {
          localObject = String.valueOf(AppSetting.a());
          int i1 = c();
          String str3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          if (TextUtils.isEmpty(str3)) {
            continue;
          }
          VcControllerImpl localVcControllerImpl = new VcControllerImpl(a(), (String)localObject, this.jdField_a_of_type_ComTencentAvQavChannelProxy, this);
          ClientLogReport.instance().setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          long l1 = CharacterUtil.a(str3);
          String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = QQDeviceInfo.getIMEI("62ad83");
          int i2 = CUKingCardHelper.a(str3);
          String str5 = DeviceInfoUtil.b();
          str3 = str5 + "," + i2;
          String str4 = Build.HARDWARE + "_" + VcSystemInfo.getCpuModel();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s], [%s]", new Object[] { str2, str5, Integer.valueOf(i2), str3, str4 }));
          }
          str5 = ResMgr.a();
          String str6 = ResMgr.b();
          localVcControllerImpl.init(a(), l1, "8.5.5", Build.MODEL, (String)localObject, str1, AppSetting.d(), str2, VcSystemInfo.getDeviceName(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, VcSystemInfo.getCPUName(), i1, str3, new SDKConfigInfoBuilder().a(), QAVConfigUtils.a(l1), QAVConfigUtils.b(l1), str4, str5, str6);
          localVcControllerImpl.updateProcessInfo(0L, "manufacturer", Build.MANUFACTURER);
          localObject = localVcControllerImpl.postData(5L, null);
          if (localObject != null) {
            continue;
          }
          localObject = "";
          QLog.w(jdField_a_of_type_JavaLangString, 1, "initVcController, SDK BuildNum[" + (String)localObject + "]");
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = localVcControllerImpl;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController fail.", localThrowable);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
        AVSoUtils.b();
        continue;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController selfUin invalid.");
        AVSoUtils.b();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break label450;
      }
      return true;
      localObject = new String((byte[])localObject);
    }
    label450:
    return false;
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public boolean c(boolean paramBoolean)
  {
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
    boolean bool2 = false;
    boolean bool1;
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        bool1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.enableLoopback(paramBoolean);
      }
    }
    do
    {
      do
      {
        return bool1;
        if (a().jdField_d_of_type_Int == 3) {
          break;
        }
        bool1 = bool2;
      } while (a().jdField_d_of_type_Int != 4);
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.enableLoopback(paramBoolean);
  }
  
  public void checkNetStatus()
  {
    switch (NetworkUtil.a(null))
    {
    default: 
      f(0);
      return;
    case 0: 
      f(3);
      return;
    }
    N();
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
      Object localObject = c();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = String.valueOf(localGAudioFriends.jdField_a_of_type_Long);
        localArrayList2.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new VideoController.18(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_e_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
    }
  }
  
  public void d(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "exitProcess, reason[" + paramInt + "], seq[" + l1 + "]");
    int i1 = paramInt;
    if (paramInt < 200) {
      i1 = paramInt + 200;
    }
    if ((q()) && ((this.jdField_f_of_type_Int == 2) || (this.jdField_f_of_type_Int == 3)))
    {
      AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_f_of_type_Int);
      return;
    }
    if (TraeHelper.a() != null) {
      TraeHelper.a().a(l1);
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    Object localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((QAVNotification)localObject).a();
      localObject = new Intent("tencent.video.destroyService");
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1, i1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.printErrorLog(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteUser --> Count = " + paramInt + " , firstName = " + paramString);
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
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_p_of_type_Int = paramInt;
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
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = a();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + localSessionInfo + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(localSessionInfo.jdField_d_of_type_JavaLangString).longValue();
    int i1 = localSessionInfo.jdField_d_of_type_Int;
    long l3 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    int i2 = localSessionInfo.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      VideoViewInfo localVideoViewInfo1 = new VideoViewInfo();
      VideoViewInfo localVideoViewInfo2 = new VideoViewInfo();
      localVideoViewInfo1.jdField_a_of_type_Long = l2;
      localVideoViewInfo1.jdField_a_of_type_Int = 1;
      localVideoViewInfo2.jdField_a_of_type_Long = l2;
      localVideoViewInfo2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo2);
      localArrayList.add(localVideoViewInfo1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (localSessionInfo.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      k(true);
      a(l1, l2, true, 0);
      a().jdField_d_of_type_JavaLangString = String.valueOf(l2);
      a().a(l1, "notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      a().e("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      a().d("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      a().L = true;
      a("notifyChangeDoubleVideoMeeting2MultiVideo", bool);
      if (!bool) {
        break label491;
      }
    }
    label491:
    for (i1 = 1;; i1 = 0)
    {
      c("notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      if (paramBoolean)
      {
        d();
        a().a(4, 11);
        a().d("notifyChangeDoubleVideoMeeting2MultiVideo", AVUtil.a(i2));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.jdField_l_of_type_Boolean + "], session[" + localSessionInfo + "], seq[" + l1 + "]");
      }
      return;
      if (localSessionInfo.a(l3, 1) == -1) {
        break;
      }
      localSessionInfo.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
      break;
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Int != 2)) {
        break label76;
      }
      bool1 = true;
    }
    for (;;)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "CheckIsDoubleReceiveInviting ret=" + bool1);
      return bool1;
      label76:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Int == 0) {
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 1)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 2) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public void dataTransferred(int paramInt, long paramLong) {}
  
  public int e()
  {
    return this.jdField_q_of_type_Int;
  }
  
  public long e()
  {
    long l1 = 0L;
    if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4)) {
      l1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEnterRoomTime();
    }
    return l1;
  }
  
  public ArrayList<VideoController.GAudioFriends> e()
  {
    if ((AudioHelper.d()) && (AVRedBagMgr.TestFlag.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(AVRedBagMgr.TestFlag.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void e()
  {
    long l1 = AudioHelper.b();
    if (this.jdField_f_of_type_JavaLangRunnable == null)
    {
      this.jdField_f_of_type_JavaLangRunnable = new VideoController.19(this, l1);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_f_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 15000L);
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void e(int paramInt, String paramString)
  {
    if ((a().jdField_d_of_type_Int != 4) && (a().jdField_d_of_type_Int != 2)) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.lockVideoMaxQP(paramInt, paramString);
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_c_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      SessionInfo localSessionInfo = a();
      if (paramBoolean)
      {
        a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (localSessionInfo != null)
        {
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          localSessionInfo.a();
          localSessionInfo.b();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = false;
      }
      if (paramBoolean) {
        RandomController.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).c();
      }
      return;
      if ((l()) || (this.jdField_f_of_type_Boolean)) {
        if (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) || (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(204) });
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat: double");
          }
        }
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public int f()
  {
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetLevel();
  }
  
  public long f()
  {
    switch (a().jdField_d_of_type_Int)
    {
    default: 
      return 0L;
    case 1: 
    case 2: 
      return c();
    }
    return d();
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
    GraphicRenderMgr.getInstance().decoderPtrRef = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
    }
  }
  
  public void f(int paramInt)
  {
    if (a().jdField_d_of_type_JavaLangString == null) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNetStatus <--receiveEcho peerUin = null, return!");
    }
    for (;;)
    {
      return;
      try
      {
        l1 = Long.valueOf(a().jdField_d_of_type_JavaLangString).longValue();
        if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) || (l1 <= 0L)) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNetStatus <--receiveEcho netStatus = " + paramInt);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateNetworkTestResult(l1, paramInt);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNetStatus Long.valueOf(peerUin) Exception= " + localException.getMessage());
          long l1 = 0L;
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void f(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public boolean f()
  {
    boolean bool2 = true;
    int i1 = a().jdField_j_of_type_Int;
    boolean bool1;
    if ((i1 == 21) || (i1 == 22) || (i1 == 26)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (a().jdField_f_of_type_Int != 1);
    String str2 = a().jdField_d_of_type_JavaLangString;
    String str1 = str2;
    if (a().jdField_j_of_type_Int == 1006)
    {
      str1 = str2;
      if (!a().jdField_e_of_type_Boolean)
      {
        str1 = str2;
        if (a().jdField_f_of_type_JavaLangString != null) {
          str1 = a().jdField_f_of_type_JavaLangString;
        }
      }
    }
    for (;;)
    {
      try
      {
        long l1 = CharacterUtil.a(str1);
        i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.hasAVShiftAbility(l1);
        if (i1 == -1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        int i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Can not get Number. PeerUin = " + str1);
        bool1 = false;
        continue;
      }
      if (bool1) {
        return bool1;
      }
      i1 = b(str1);
      i2 = c(str1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canAVShift peerTerminalType: " + i1 + ", peerSharpVersion: " + i2);
      }
      if (i2 >= 16)
      {
        bool1 = bool2;
        if (i1 == 4) {
          break;
        }
        bool1 = bool2;
        if (i1 == 2) {
          break;
        }
        bool1 = bool2;
        if (i1 == 3) {
          break;
        }
      }
      if (i1 == 5)
      {
        bool1 = bool2;
        if (i2 >= 5437) {
          break;
        }
      }
      return false;
      bool1 = false;
    }
    return bool1;
  }
  
  public int g()
  {
    if ((this.jdField_o_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)) {
      this.jdField_o_of_type_Int = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return this.jdField_o_of_type_Int;
  }
  
  public long g()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getOnPeerFrameRenderEndFunctionPtr();
    }
    return 0L;
  }
  
  void g()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestAudioFoucs");
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new VideoController.22(this);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    try
    {
      int i1 = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
      if ((i1 != 1) && (QLog.isColorLevel())) {
        QLog.d("AudioManager", 2, "request audio focus fail. " + i1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Intent localIntent;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "requestAudioFocus e = " + localException);
        }
      }
    }
    localIntent = new Intent("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void g(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "closeVideo timeout. force to exitProcess. closeReason = " + paramInt);
    d(261);
  }
  
  public void g(String paramString)
  {
    long l1 = a(paramString);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "send0x211C2CMsg_Audio_start roomId = " + l1);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AudioEngineReady");
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("roomId", l1);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(36) });
    }
  }
  
  public void g(boolean paramBoolean)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setSelectMemberActivityIsResume, IsResume[" + paramBoolean + "], mSelectMemberActivityIsResume[" + this.jdField_i_of_type_Int + "]");
    if (paramBoolean) {
      this.jdField_i_of_type_Int += 1;
    }
    do
    {
      return;
      this.jdField_i_of_type_Int -= 1;
    } while (this.jdField_i_of_type_Int >= 0);
    this.jdField_i_of_type_Int = 0;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int getAPAndGateWayIP()
  {
    return c();
  }
  
  public long getMSFInviteMessageTimeStamp(long paramLong)
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).longValue();
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("getMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
    return l1;
  }
  
  public int h()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
      return i1;
    }
  }
  
  void h()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "abandonAudioFocus");
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
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
    if (paramBoolean) {}
    for (int i1 = jdField_k_of_type_Int;; i1 = jdField_l_of_type_Int)
    {
      if (this.jdField_m_of_type_Int != i1)
      {
        this.jdField_m_of_type_Int = i1;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "setLoadPTuSo, bloadSuc[" + paramBoolean + "]");
      }
      return;
    }
  }
  
  public boolean h()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public int i()
  {
    if ((a().l()) || (this.jdField_d_of_type_Boolean)) {
      return 0;
    }
    return 255;
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 25000L);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "startConnectingTimer");
    }
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoProcessExitMonitor localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoProcessExitMonitor != null) {
        localVideoProcessExitMonitor.b(paramBoolean);
      }
    }
  }
  
  public boolean i()
  {
    for (;;)
    {
      int i1;
      boolean bool1;
      boolean bool2;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        long l2 = System.currentTimeMillis();
        i1 = 0;
        bool1 = false;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (localGAudioFriends != null)
          {
            bool2 = bool1;
            if (!localGAudioFriends.jdField_g_of_type_Boolean) {
              break label231;
            }
            if ((localGAudioFriends.jdField_d_of_type_Long >= 2000L) && (localGAudioFriends.jdField_d_of_type_Long < this.jdField_b_of_type_Long))
            {
              l1 = localGAudioFriends.jdField_d_of_type_Long;
              bool2 = bool1;
              if (l2 - localGAudioFriends.jdField_c_of_type_Long <= l1) {
                break label231;
              }
              localGAudioFriends.jdField_g_of_type_Boolean = false;
              localGAudioFriends.jdField_c_of_type_Long = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + localGAudioFriends.jdField_a_of_type_Long + ",isSuspectNoisy = " + localGAudioFriends.jdField_g_of_type_Boolean);
              bool2 = bool1;
              break label231;
            }
            if (this.jdField_b_of_type_Long < 2000L) {
              break label238;
            }
            l1 = this.jdField_b_of_type_Long;
            continue;
          }
        }
        else
        {
          return bool1;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label231:
        bool1 = bool2;
      }
      label238:
      long l1 = 2000L;
    }
  }
  
  public int isOfflineSession(String paramString)
  {
    paramString = a();
    if ((paramString != null) && (paramString.jdField_c_of_type_Boolean)) {
      return 1;
    }
    return 0;
  }
  
  public int j()
  {
    return this.jdField_m_of_type_Int;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "stopConnectingTimer");
    }
  }
  
  public void j(String paramString)
  {
    a("deviceMemory", VideoNodeManager.c() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoProcessExitMonitor localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoProcessExitMonitor != null) {
        localVideoProcessExitMonitor.c(paramBoolean);
      }
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    int i2;
    int i1;
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      i1 = 0;
      if (i1 >= i2) {
        break label166;
      }
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
      if ((localGAudioFriends == null) || (!localGAudioFriends.jdField_g_of_type_Boolean)) {
        break label159;
      }
      if (l1 == localGAudioFriends.jdField_a_of_type_Long)
      {
        int i3 = e();
        a("setSuspectNoisyUserMicOff", this.jdField_a_of_type_Long, false, true, -1);
        a(-1L, i3, e());
      }
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(localObject.jdField_a_of_type_Long, true);
    for (;;)
    {
      label147:
      return bool;
      label159:
      label166:
      do
      {
        bool = false;
        break label147;
        i1 += 1;
        break;
      } while (i1 == i2);
      boolean bool = true;
    }
  }
  
  public void k()
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
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveGatewayMsg(this.jdField_e_of_type_JavaLangString, this.jdField_p_of_type_Int);
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
  
  public void k(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.b(paramString);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoProcessExitMonitor localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoProcessExitMonitor != null) {
        localVideoProcessExitMonitor.d(paramBoolean);
      }
    }
  }
  
  public boolean k()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
        i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend();
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "goOnstage, ret[" + i1 + "]");
        }
        if (i1 != 0) {
          break label151;
        }
      }
    }
    label151:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        int i1;
        return false;
        if ((a().F == 1) && (a().D == 10)) {
          ReportController.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public void l()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 50);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public void l(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setupDeviceInfos(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAndroidPath(paramString);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoProcessExitMonitor localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoProcessExitMonitor != null) {
        localVideoProcessExitMonitor.e(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int < 6);
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(307) });
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoProcessExitMonitor localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoProcessExitMonitor != null) {
        localVideoProcessExitMonitor.f(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    SessionInfo localSessionInfo = a();
    boolean bool1 = bool2;
    if (localSessionInfo != null)
    {
      bool1 = bool2;
      if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void n()
  {
    if (!this.jdField_d_of_type_Boolean) {
      a().a("clearGAudioState", 0);
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoProcessExitMonitor localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoProcessExitMonitor != null) {
        localVideoProcessExitMonitor.g(paramBoolean);
      }
    }
  }
  
  public boolean n()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
  }
  
  public void o()
  {
    long l1;
    if (this.jdField_d_of_type_Boolean) {
      l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1;
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (l1 == ((VideoController.GAudioFriends)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long))
      {
        i1 = 1;
        if (i1 != 0) {
          a().a("setGAudioState.1", 9);
        }
      }
      else
      {
        i1 = 0;
      }
    }
    a().a("setGAudioState.2", 10);
  }
  
  public void o(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "callBackNetStatus <--receiveEcho Cost = " + l1);
      if (l1 < 3000L) {
        f(1);
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_Long = -1L;
      return;
      f(2);
      continue;
      f(4);
    }
  }
  
  public boolean o()
  {
    return this.t;
  }
  
  public void onAVShiftEvent(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr == null) || (a() == null) || (a().jdField_d_of_type_JavaLangString == null)) {}
    while (!a().jdField_d_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    switch (paramInt)
    {
    case 0: 
    case 3: 
    default: 
      return;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onAVShiftEvent remote switch to video mode,waiting for confirm");
      }
      a().S = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "remote confirm switch to video");
    }
    a().S = false;
  }
  
  public void onAcceptVideoMode(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void onAcceptedVideo(String paramString)
  {
    a().a("onAcceptedVideo", 3);
  }
  
  public void onAnotherHaveAccept(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    m(true);
    a(paramString, 206);
    b(206);
    b(paramString, 7);
  }
  
  public void onAnotherHaveReject(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    a(paramString, 207);
    b(207);
    b(paramString, 7);
  }
  
  public void onAnotherIsRing(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().T = paramBoolean;
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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSelfAudioVolumeChange dooubleAV.value:=" + paramLong1);
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
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onAvReqAutoAccept, peerUin[" + paramString + "]");
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.25(this, paramString));
    }
  }
  
  public void onCancelRequest(String paramString)
  {
    j();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo onCancelRequest: fromUin = " + paramString);
    b(paramString, 10);
  }
  
  public void onCancelVideoMode(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void onChangePreviewSize(int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    boolean bool = AndroidCamera.a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_j_of_type_Boolean + "], preSize[" + AndroidCamera.jdField_a_of_type_Int + ", " + AndroidCamera.jdField_b_of_type_Int + "], seq[" + l1 + "], forbiddenReopenCamera[" + bool + "]");
    if (bool) {}
    int i2;
    int i1;
    do
    {
      do
      {
        return;
      } while (!a().jdField_j_of_type_Boolean);
      if (paramInt1 >= 640)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (paramInt2 >= 480) {}
      }
      else
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], use min previewSize[640,480]");
        i1 = 480;
        i2 = 640;
      }
    } while ((AndroidCamera.jdField_a_of_type_Int == i2) && (AndroidCamera.jdField_b_of_type_Int == i1));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(i2), Integer.valueOf(i1), Long.valueOf(l1) });
  }
  
  public void onChannelReady(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "onChannelReady, fromUin[" + paramString1 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    SessionInfo localSessionInfo = a();
    int i2 = localSessionInfo.F;
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
      localSessionInfo = a();
    }
    for (;;)
    {
      localSessionInfo.x = paramInt1;
      localSessionInfo.y = paramInt2;
      localSessionInfo.jdField_n_of_type_JavaLangString = paramString2;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onChannelReady, fromUin[" + paramString1 + "], hdModeFreeUseStartTime[" + paramInt1 + "], hdModeFreeUseEndTime[" + paramInt2 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], session[" + localSessionInfo + "]");
      VideoNodeManager.a(30);
      VideoNodeManager.a(9, localSessionInfo.b());
      VideoNodeManager.a(11, localSessionInfo.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      SignalStrengthReport.a(a()).a();
      if (1L == localSessionInfo.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
        if ((localSessionInfo.S) && (localSessionInfo.jdField_e_of_type_Boolean) && (!l())) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        a(true, localSessionInfo.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
      if (localSessionInfo.jdField_j_of_type_Int != 1011) {
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
      }
      localSessionInfo.b(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
      localSessionInfo.c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
      localSessionInfo.d(paramLong);
      j();
      localSessionInfo.jdField_h_of_type_Int = localSessionInfo.jdField_g_of_type_Int;
      localSessionInfo.a("onChannelReady", 4);
      localSessionInfo.a(l1, SystemClock.elapsedRealtime());
      if ((localSessionInfo.jdField_e_of_type_Boolean) && (!l()))
      {
        if (localSessionInfo.S) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        label501:
        if ((localSessionInfo.jdField_d_of_type_Int == 1) && (localSessionInfo.jdField_j_of_type_Int == 1011))
        {
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 5;
          a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, null);
        }
        paramString2 = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!localSessionInfo.jdField_e_of_type_Boolean) {
          break label894;
        }
        paramInt1 = 11;
        label568:
        paramString2.a(localSessionInfo.b(), paramInt1, 1L);
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
          if (l()) {
            a(l1, 2131230736, 1, null);
          }
        }
        b();
        if (!localSessionInfo.jdField_g_of_type_Boolean) {
          break label899;
        }
        a(true, localSessionInfo.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l1), 50L);
        a(localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_d_of_type_Int, true, true, true);
        DataReport.i(this);
        DataReport.c(this, true);
        DataReport.b(this, true);
        paramLong = f();
        paramString2 = SharedPreUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        paramString2.edit().putLong("qav_roomid", paramLong).commit();
        paramLong = c(paramString1);
        paramString2.edit().putLong(VideoConstants.g, paramLong).commit();
        m(false);
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a();
        }
        if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
          this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.a();
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a(localSessionInfo);
        }
        paramString1 = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
        if (paramString1 == null) {
          break;
        }
        paramString1.a(localSessionInfo);
        return;
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a()) {
          break label501;
        }
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label501;
        label894:
        paramInt1 = 4;
        break label568;
        label899:
        a(false, localSessionInfo.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void onCheckScreenShareAvailable(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCheckScreenShareValid, isValid[" + paramInt + "], detail[" + paramArrayOfByte + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(521), Integer.valueOf(paramInt), paramArrayOfByte });
  }
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.b(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l1 + "], Main[" + this.jdField_a_of_type_ComTencentAvSessionMgr.a() + "], come[" + localSessionInfo + "]");
    if (localSessionInfo == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], no session");
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((VideoRecoveryMonitor)localObject).a(paramInt);
      }
      if (q()) {
        B();
      }
      ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, localSessionInfo.jdField_d_of_type_JavaLangString);
      if (((localSessionInfo.jdField_j_of_type_Int != 1011) && (localSessionInfo.jdField_j_of_type_Int != 21)) || (!localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean)) {
        break;
      }
      AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean);
      localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0, this);
    } while ((q()) && ((paramInt == 2) || (paramInt == 3)));
    d(paramInt);
    return;
    k(localSessionInfo.jdField_c_of_type_JavaLangString);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 13: 
    case 16: 
    case 17: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    default: 
    case 0: 
      for (paramInt = 5;; paramInt = 0)
      {
        b(paramString, paramInt);
        return;
      }
    case 1: 
      if (paramLong == 9L) {
        paramInt = 43;
      }
      break;
    }
    for (;;)
    {
      if ((paramLong == 12L) || (paramLong == 13L) || (paramLong == 15L) || (paramLong == 16L))
      {
        if (localSessionInfo.jdField_d_of_type_Int != 2) {
          break label818;
        }
        ReportController.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramInt == 49) {
          m(true);
        }
        a(l1, paramString, paramInt);
        return;
        if (paramLong == 10L)
        {
          paramInt = 54;
          break;
        }
        if (paramLong == 5L)
        {
          paramInt = 49;
          break;
        }
        if ((paramLong == 12L) || (paramLong == 16L))
        {
          a(localSessionInfo.jdField_j_of_type_Int, localSessionInfo.jdField_d_of_type_JavaLangString, localSessionInfo.jdField_i_of_type_Long, 0);
          paramInt = 52;
          break;
        }
        if (paramLong == 13L)
        {
          paramInt = 50;
          break;
        }
        if (paramLong == 14L)
        {
          paramInt = 51;
          if (localSessionInfo.jdField_d_of_type_Int == 2)
          {
            ReportController.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          ReportController.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong == 15L)
        {
          paramInt = 55;
          break;
        }
        if (paramLong == 17L)
        {
          paramInt = 56;
          ReportController.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong == 6L)
        {
          paramInt = 72;
          break;
        }
        if (paramLong == 7L)
        {
          paramInt = 24;
          break;
        }
        if (paramLong != 983055L) {
          break label1123;
        }
        paramInt = 63;
        break;
        label818:
        ReportController.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = SessionMgr.a(3, paramString, new int[0]);
        localSessionInfo = null;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject)) {
          localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
        }
        if ((localSessionInfo != null) && (localSessionInfo.jdField_g_of_type_Int == 1))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, set autoAcceptChat, seq[" + l1 + "]");
          localSessionInfo.jdField_d_of_type_Boolean = true;
          return;
        }
      }
      paramInt = 3;
      if ((paramLong == 3L) || (paramLong == 65535L)) {
        paramInt = 42;
      }
      a(l1, paramString, paramInt);
      return;
      paramInt = 5;
      break;
      a(l1, paramString, 25);
      return;
      paramInt = 9;
      break;
      paramInt = 1;
      break;
      paramInt = 4;
      break;
      paramInt = 10;
      break;
      paramInt = 28;
      break;
      paramInt = 29;
      break;
      paramInt = 39;
      break;
      paramInt = 35;
      break;
      a(l1, paramString, 12);
      return;
      paramInt = 21;
      break;
      if (paramLong == 62L)
      {
        localSessionInfo.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 12);
        return;
      }
      if (paramLong == 61L)
      {
        localSessionInfo.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 25);
        return;
      }
      paramInt = 64;
      break;
      paramInt = 62;
      a(l1, paramString, 62);
      break;
      label1123:
      paramInt = 2;
    }
  }
  
  public void onConfigSysDealDone(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject1 = jdField_a_of_type_JavaLangString + "|VideoNodeManager";
    Object localObject2 = new StringBuilder().append("onCreateRoomSuc, relationType[").append(paramInt1).append("], groupId[").append(paramLong).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "], mutiAvType[" + paramInt2 + "], seq[" + l1 + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break;
      }
      return;
    }
    localObject1 = a();
    if (a("onCreateRoomSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject1 = a();
    }
    for (;;)
    {
      ((SessionInfo)localObject1).jdField_O_of_type_Boolean = true;
      ((SessionInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.clear();
      if ((AVUtil.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        K();
      }
      label779:
      for (;;)
      {
        a("onCreateRoomSuc");
        a("onCreateSuc", true, paramInt1, paramLong);
        ((SessionInfo)localObject1).at = false;
        if (((SessionInfo)localObject1).J)
        {
          ((SessionInfo)localObject1).d("onCreateRoomSuc", true);
          ((SessionInfo)localObject1).M = true;
        }
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCreateRoomSuc, MainSession[" + a() + "]");
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong), Long.valueOf(l1) });
        if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
        {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "InviteMemberList onCreateRoomSuc, request memberList]" + 0);
          }
        }
        this.jdField_d_of_type_Int = 0;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localObject2 != null) {
          ((ChatRoomMng)localObject2).a(a());
        }
        if ((!((SessionInfo)localObject1).J) && (((SessionInfo)localObject1).F != 3)) {
          break;
        }
        localObject2 = a();
        if (localObject2 == null) {
          break;
        }
        ((ScreenShareCtrl)localObject2).a((SessionInfo)localObject1);
        return;
        int i1;
        int i2;
        if (((SessionInfo)localObject1).jdField_ad_of_type_Int == 5)
        {
          i1 = ((SessionInfo)localObject1).d();
          i2 = ((SessionInfo)localObject1).c();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onCreateRoomSuc, double meeting, terminalType[" + i1 + "], sdkVersion[" + i2 + "]");
          }
          long l2;
          if ((i1 == 2) || (i1 == 12) || ((i1 == 4) && (i2 >= 114)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((SessionInfo)localObject1).jdField_g_of_type_Long;
            i1 = ((SessionInfo)localObject1).jdField_ad_of_type_Int;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((SessionInfo)localObject1).jdField_g_of_type_Long;
            i1 = ((SessionInfo)localObject1).jdField_ad_of_type_Int;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 4, i1, 0);
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((SessionInfo)localObject1).jdField_ad_of_type_Int, 0);
        }
        else
        {
          if (AudioHelper.a(19) == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label779;
            }
            AudioHelper.a(HardCodeUtil.a(2131715947));
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((SessionInfo)localObject1).jdField_ad_of_type_Int, 0);
            break;
          }
        }
      }
    }
  }
  
  public void onDetectAudioDataIssue(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDetectAudioDataIssue, issueType[" + this.jdField_c_of_type_Int + "->" + paramInt + "], seq[" + l1 + "]");
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt), Long.valueOf(l1) });
  }
  
  public void onDoubleVideoMeetingInvite(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, inviteUin[" + paramLong + "], aliveSessionCount[" + i1 + "], multiAVType[" + paramInt1 + "], multiSubType[" + paramInt2 + "], seq[" + l1 + "], \nmainSession[" + a() + "]");
    if (a(paramLong, paramInt1, paramInt2)) {
      a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
    }
    Object localObject1;
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      localObject1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, false);
      VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
      bool1 = false;
      bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
      if ((!TextUtils.equals(a().jdField_d_of_type_JavaLangString, String.valueOf(paramLong))) || ((a().jdField_i_of_type_Int != 16) && (paramInt2 != 5))) {
        break;
      }
      if (this.jdField_d_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        this.jdField_d_of_type_JavaLangRunnable = null;
      }
      localObject1 = a();
    } while (localObject1 == null);
    ((ScreenShareCtrl)localObject1).a(l1, paramLong, paramInt1, paramInt2);
    return;
    if ((TextUtils.equals(a().jdField_d_of_type_JavaLangString, String.valueOf(paramLong))) && (a().jdField_i_of_type_Int == 11))
    {
      if (this.jdField_d_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        this.jdField_d_of_type_JavaLangRunnable = null;
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
      b(a().jdField_d_of_type_JavaLangString, 2);
    }
    if (a().f()) {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
      if (localObject2 != null)
      {
        ((SessionInfo)localObject2).S = true;
        ((SessionInfo)localObject2).jdField_f_of_type_Int = 2;
        ((SessionInfo)localObject2).jdField_j_of_type_Int = 0;
        ((SessionInfo)localObject2).F = 3;
        ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        ((SessionInfo)localObject2).jdField_f_of_type_JavaLangString = null;
        ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
        ((SessionInfo)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
        ((SessionInfo)localObject2).e("onDoubleVideoMeetingInvite", true);
        ((SessionInfo)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong);
      }
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "recv double video meeting when phone is not idle:from uin=" + paramLong);
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
      new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, (String)localObject1);
      return;
      if ((a().o()) || (a().p()) || (a().q()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_d_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
          l(true);
          a(a().jdField_d_of_type_JavaLangString, 299);
          b(299);
          b(a().jdField_d_of_type_JavaLangString, 2);
        }
        else if ((a().o()) || (a().p()))
        {
          a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
        }
        if (bool2)
        {
          a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.jdField_n_of_type_Int + "], isQQPaused[" + VideoConstants.jdField_b_of_type_Boolean + "], isVideoPaused[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(a(), 0) + "], seq[" + l1 + "]");
    }
    if ((this.x) && (this.jdField_n_of_type_Int == 0) && (!bool2) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.30(this, l1, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l1, (String)localObject1, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
  }
  
  public void onEnterSuc(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject = a();
    if (a("onEnterSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject = a();
    }
    QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "onEnterSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], MainSession[" + localObject + "], seq[" + l1 + "]");
    a("onEnterSuc");
    ((SessionInfo)localObject).at = false;
    if (paramInt1 == 3)
    {
      ((SessionInfo)localObject).a("onEnterSuc.1", 14);
      ((SessionInfo)localObject).d("onEnterSuc", true);
      ((SessionInfo)localObject).a(l1, SystemClock.elapsedRealtime());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l1) });
      if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.41(this, paramInt1, paramInt2, paramLong));
        }
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ChatRoomMng)localObject).a(a());
      }
      return;
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = SessionMgr.a().c((String)localObject);
      if (localObject != null)
      {
        ((SessionInfo)localObject).jdField_V_of_type_Boolean = true;
        ((SessionInfo)localObject).jdField_O_of_type_Boolean = false;
        ((SessionInfo)localObject).aG = true;
      }
      if ((AVUtil.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        K();
      }
    }
  }
  
  public void onFpsChange(int paramInt)
  {
    int i1 = 15000;
    if (paramInt >= 20) {
      i1 = Math.min(30000, paramInt * 1000);
    }
    paramInt = a().jdField_e_of_type_Int;
    if ((paramInt == i1) || (Build.MODEL.equalsIgnoreCase("HWI-AL00")) || (Build.MODEL.equalsIgnoreCase("VKY-AL00"))) {
      return;
    }
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onFpsChange, nFps[" + paramInt + "->" + i1 + "], seq[" + l1 + "]");
    a().jdField_e_of_type_Int = i1;
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(l1, i1);
  }
  
  public void onGAudioInvite(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = AudioHelper.b();
    AVLog.printDebugLog("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    c(false);
    Object localObject1 = a();
    long l2 = a(String.valueOf(paramLong2));
    long l3 = d();
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder().append("onGAudioInvite, friendUin[").append(paramLong2).append("], groupId[").append(paramLong1).append("], multiSubType[").append(paramInt3).append("], multiAVType[").append(paramInt2).append("], relationType[").append(paramInt1).append("], mGAudioInRoom[").append(this.jdField_d_of_type_Boolean).append("], mGAudioGroupId[").append(this.jdField_a_of_type_Long).append("], mCurrentInviteId[").append(this.jdField_c_of_type_Long).append("], mCurrentInviteRelationType[").append(this.jdField_h_of_type_Int).append("], offLineInvite[").append(paramBoolean).append("], roomId[").append(l2).append("], gRoomId[").append(l3).append("], seq[").append(l1).append("], main[").append(localObject1).append("], app[");
      if (localVideoAppInterface != null)
      {
        paramBoolean = true;
        QLog.w((String)localObject2, 2, paramBoolean + "], original[" + paramInt4 + "]");
      }
    }
    else
    {
      if (localVideoAppInterface != null) {
        break label294;
      }
    }
    label294:
    boolean bool;
    label824:
    do
    {
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      if ((paramInt3 == 6) || (paramInt3 == 5) || (paramInt3 == 4) || (paramInt3 == 3)) {
        paramBoolean = true;
      }
      if (!QAVGroupConfig.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
        return;
      }
      localObject3 = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject3))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject3, false);
      ((SessionInfo)localObject2).jdField_g_of_type_Long = paramLong1;
      ((SessionInfo)localObject2).F = paramInt1;
      ((SessionInfo)localObject2).D = paramInt2;
      ((SessionInfo)localObject2).aj = false;
      ((SessionInfo)localObject2).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      ((SessionInfo)localObject2).jdField_ad_of_type_Int = paramInt4;
      if (((SessionInfo)localObject2).jdField_ad_of_type_Int == 4) {
        ScreenShareReportHelper.a(((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, 2, "onGAudioInvite");
      }
      if (b(paramInt1, paramLong1, paramInt3))
      {
        a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      VideoConstants.jdField_b_of_type_Boolean = localVideoAppInterface.b();
      paramBoolean = false;
      if (!((SessionInfo)localObject1).f()) {
        paramBoolean = true;
      }
      for (;;)
      {
        if (this.jdField_h_of_type_JavaLangRunnable != null)
        {
          if (localVideoAppInterface.a() != null) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
          }
          this.jdField_h_of_type_JavaLangRunnable = null;
          ((SessionInfo)localObject2).a("onGAudioInvite.1", 0);
        }
        J();
        bool = a(localVideoAppInterface.getApp().getApplicationContext());
        if (!bool) {
          break label824;
        }
        if ((((SessionInfo)localObject1).jdField_g_of_type_Int <= 0) || (((SessionInfo)localObject1).jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
          break;
        }
        a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
        if (localVideoAppInterface.e()) {
          paramBoolean = true;
        }
      }
      if (7 == ((SessionInfo)localObject1).jdField_g_of_type_Int)
      {
        a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((SessionInfo)localObject1).jdField_g_of_type_Int == 14) || (((SessionInfo)localObject1).jdField_g_of_type_Int == 13))
      {
        a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1))
      {
        a(l1, "ScreenLocked_in_random", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((paramBoolean) && (paramInt3 != 3))
      {
        a(l1, "ScreenLocked_session_exist", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + ((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int + "], chatType[" + ((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
      }
      if (((SessionInfo)localObject2).jdField_d_of_type_Int == 0)
      {
        ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
        ((SessionInfo)localObject2).a(l1, "onGAudioInvite.1", 3);
        ((SessionInfo)localObject2).jdField_j_of_type_Int = UITools.c(paramInt1);
        ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong2);
        if (paramInt1 == 2) {
          ((SessionInfo)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong2);
        }
        ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
        if ((paramInt3 != 3) && (paramInt3 != 4)) {
          a((String)localObject3, ((SessionInfo)localObject2).jdField_d_of_type_Int, false, false, false);
        }
      }
      this.jdField_c_of_type_Long = paramLong1;
      this.jdField_h_of_type_Int = paramInt1;
      if (((SessionInfo)localObject2).jdField_g_of_type_Int == 0) {
        ((SessionInfo)localObject2).a("onGAudioInvite", 7);
      }
      bool = false;
      if ((paramInt3 != 3) || (((SessionInfo)localObject1).jdField_g_of_type_Long != 0L)) {
        break label1398;
      }
      bool = b((SessionInfo)localObject1, (SessionInfo)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite multiSubType[" + paramInt3 + "], hasDeal[" + bool + "]");
      }
    } while (bool);
    if (localVideoAppInterface.c())
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
      }
      for (;;)
      {
        paramArrayOfLong.putExtra("relationType", paramInt1);
        paramArrayOfLong.putExtra("extraUin", ((SessionInfo)localObject1).jdField_f_of_type_JavaLangString);
        paramArrayOfLong.putExtra("relationId", paramLong1);
        paramArrayOfLong.putExtra("type", 13);
        paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("isSender", false);
        paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("realSenderUin", ((SessionInfo)localObject1).jdField_s_of_type_JavaLangString);
        localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
        a(l1, this.jdField_h_of_type_Int, paramLong1, true);
        new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, (String)localObject3);
        return;
        label1398:
        if (paramInt3 != 4) {
          break;
        }
        bool = a((SessionInfo)localObject1, (SessionInfo)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
        break;
        if (paramInt1 == 2) {
          paramArrayOfLong.putExtra("uinType", 3000);
        }
      }
    }
    ((SessionInfo)localObject1).jdField_s_of_type_JavaLangString = ("" + paramLong2);
    this.jdField_s_of_type_Boolean = b();
    if (((SessionInfo)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite msg blocked [" + ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString + "]");
      }
      if (!localVideoAppInterface.jdField_c_of_type_Boolean) {
        break label1836;
      }
      localVideoAppInterface.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      localVideoAppInterface.jdField_d_of_type_Boolean = true;
      return;
      if ((paramBoolean) || (VideoUtils.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        QAVGroupConfig.Report.d();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", UITools.c(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString);
        if ((!this.jdField_s_of_type_Boolean) || (!SmallScreenUtils.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1827;
        }
        if ((!paramBoolean) && (!VideoUtils.a())) {
          break label1795;
        }
        paramArrayOfLong = new MultiIncomingCallUICtr(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.d();
        paramArrayOfLong.a((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1795:
      paramArrayOfLong = new VideoInviteFloatBarUICtr(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.d();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1827:
      a((Intent)localObject1);
      break;
      label1836:
      VideoNodeManager.a();
    }
  }
  
  public void onGAudioInviteResp(MavInviteData paramMavInviteData)
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    boolean bool;
    if (paramMavInviteData == null)
    {
      localArrayList = null;
      if (paramMavInviteData != null) {
        ScreenShareTipsHelper.a(paramMavInviteData.retCode, paramMavInviteData.tip);
      }
      if (QLog.isColorLevel())
      {
        paramMavInviteData = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("onGAudioInviteResp, inviteAccountList[");
        if (localArrayList == null) {
          break label110;
        }
        bool = true;
        label54:
        localStringBuilder = localStringBuilder.append(bool).append("], size[");
        if (localArrayList != null) {
          break label115;
        }
      }
    }
    label110:
    label115:
    for (int i1 = 0;; i1 = localArrayList.size())
    {
      QLog.w(paramMavInviteData, 1, i1 + "]");
      if (localArrayList != null) {
        break label124;
      }
      return;
      localArrayList = paramMavInviteData.inviteAccountList;
      break;
      bool = false;
      break label54;
    }
    label124:
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioKickOut, Groupid[" + paramLong + "], relationType[" + paramInt1 + "], seq[" + l1 + "]");
    paramInt2 = UITools.c(paramInt1);
    if ((this.jdField_d_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.v = true;
      if (paramInt1 != 3) {
        break label274;
      }
      a(a().jdField_c_of_type_JavaLangString, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      paramInt1 = 7;
      if (paramInt2 != 3000) {
        break label302;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().J) {
        ReportController.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      SessionInfo localSessionInfo = a();
      if ((localSessionInfo != null) && (localSessionInfo.jdField_j_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
      return;
      label274:
      a(a().jdField_c_of_type_JavaLangString, paramInt2, 20, false, String.valueOf(paramLong), null, false);
      paramInt1 = 20;
      break;
      label302:
      if (paramInt2 == 1) {
        if (a().D == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void onGAudioMemAllUpdate(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
      localGAudioFriends.jdField_a_of_type_Long = ((AVUserInfo)paramArrayList.get(i1)).account;
      localGAudioFriends.jdField_d_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).accountType;
      this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
      if (((AVUserInfo)paramArrayList.get(i1)).accountType == 1) {
        localArrayList.add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).account));
      }
      i1 += 1;
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate, size[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onGAudioMemAllUpdate(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramArrayOfLong == null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramInt2 = 0;
    while (paramInt2 < paramArrayOfLong.length)
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
      localGAudioFriends.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
      paramInt2 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate, size[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1) });
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = a(paramLong, paramInt1, paramInt2, paramBoolean);
    int i1;
    long l1;
    if (paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "onGAudioMemberMicChanged, uin[" + paramLong + "], mGAudioMute[" + this.jdField_l_of_type_Boolean + "], isMicOff[" + paramBoolean + "], mIsMicOffBySelf[" + this.u + "]");
      }
      if ((paramBoolean != this.jdField_l_of_type_Boolean) && (!this.u))
      {
        i1 = e();
        l1 = this.jdField_a_of_type_Long;
        if (paramBoolean) {
          break label230;
        }
      }
    }
    label230:
    for (boolean bool1 = true;; bool1 = false)
    {
      a("onGAudioMemberMicChanged", l1, bool1, false, -1);
      a(-1L, i1, e());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (bool2)) {
        onGAudioUserAudioSuspectNoisy(0L, false, 0L);
      }
      return;
    }
  }
  
  public void onGAudioMicSetByAdmin(long paramLong, int paramInt)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioMicSetByAdmin, manager uin[" + paramLong + "], old micAuthByAdmin[" + a().H + "], new micAuthByAdmin[" + paramInt + "], mIsMicOffBySelf[" + this.u + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    a().e("onGAudioMicSetByAdmin", paramInt);
    if (paramInt == 2) {
      return;
    }
    int i1;
    long l1;
    boolean bool1;
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (paramInt != 0))
    {
      i1 = e();
      l1 = this.jdField_a_of_type_Long;
      if (paramInt != 0) {
        break label214;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() != paramLong) {
        break label220;
      }
    }
    label214:
    label220:
    for (boolean bool2 = true;; bool2 = false)
    {
      a("onGAudioMicSetByAdmin", l1, bool1, bool2, -1);
      a(-1L, i1, e());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onGAudioRoomDestroy(int paramInt, long paramLong)
  {
    String str = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str)) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);; localObject = null)
    {
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, relationType[" + paramInt + "], seq[" + l1 + "], sessionId[" + str + "], \nsession[" + localObject + "]");
      }
      ScreenShareReportHelper.b(str, "onGAudioRoomDestroy");
      if (localObject == null) {}
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
            this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b(l1);
          }
          TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          TraeHelper.a().b();
          if ((AudioHelper.e()) || (((SessionInfo)localObject).at)) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, \nmainsession[" + a() + "], \nstate[" + ((SessionInfo)localObject).jdField_g_of_type_Int + "], seq[" + l1 + "], isAcceptingMultiAV[" + ((SessionInfo)localObject).at + "], isCurJoinedGRoom[" + a(paramInt, paramLong) + "]");
          }
        } while (((SessionInfo)localObject).at);
        if (this.jdField_c_of_type_Long == paramLong)
        {
          this.jdField_c_of_type_Long = 0L;
          this.jdField_h_of_type_Int = 0;
        }
        if ((paramInt != 3) || (!((SessionInfo)localObject).J) || ((((SessionInfo)localObject).jdField_d_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((SessionInfo)localObject).jdField_d_of_type_JavaLangString).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((SessionInfo)localObject).jdField_d_of_type_JavaLangString + " ,relationId = " + paramLong);
      return;
      if ((!((SessionInfo)localObject).aj) && (!((SessionInfo)localObject).J))
      {
        int i1 = 6;
        if (((SessionInfo)localObject).jdField_g_of_type_Int == 7) {
          i1 = 5;
        }
        a("onGAudioRoomDestroy", str, UITools.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((SessionInfo)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
      if (a(paramInt, paramLong)) {
        a(paramInt, paramLong, 69);
      }
      ((SessionInfo)localObject).a("onGAudioRoomDestroy", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
          paramInt = UITools.c(paramInt);
          a(((SessionInfo)localObject).jdField_c_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, str))
        {
          localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject != null) && (((QAVNotification)localObject).a()))
          {
            ((QAVNotification)localObject).a(str);
            b();
          }
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      q();
      return;
    }
  }
  
  public void onGAudioRoomMicModeChanged(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (paramBoolean2) {
      if (a().H == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomMicModeChanged, manager uin[" + paramLong + "], old isRoomMicOff[" + a().X + "], new isRoomMicOff[" + paramBoolean1 + "], mIsMicOffBySelf[" + this.u + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], micAuthByAdmin[" + a().H + "], isCreateRoomOrEnterRoom[" + paramBoolean2 + "], bNeedUpdateMic[" + bool + "]");
      a().c("onGAudioRoomMicModeChanged", paramBoolean1);
      int i1;
      long l1;
      if ((bool) && (!this.u) && ((paramLong != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
      {
        i1 = e();
        l1 = this.jdField_a_of_type_Long;
        if (paramBoolean1) {
          break label279;
        }
      }
      label279:
      for (bool = true;; bool = false)
      {
        a("onGAudioRoomMicModeChanged", l1, bool, false, -1);
        a(-1L, i1, e());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        return;
        bool = false;
        break;
      }
      bool = true;
    }
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
    paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l1 + "], \nsession[" + localSessionInfo + "]");
      }
      int i1;
      if ((localSessionInfo != null) && ((localSessionInfo.jdField_g_of_type_Int == 7) || (localSessionInfo.jdField_g_of_type_Int == 2)))
      {
        localSessionInfo.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs))
        {
          localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
          i1 = UITools.c(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(localSessionInfo.jdField_c_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(l1, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, localSessionInfo.jdField_s_of_type_JavaLangString, true, false);
        }
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
    qav_gvideo_sdk_transfer.gVideoDownChannelControl localgVideoDownChannelControl;
    if (paramArrayOfByte != null) {
      localgVideoDownChannelControl = new qav_gvideo_sdk_transfer.gVideoDownChannelControl();
    }
    try
    {
      localgVideoDownChannelControl.mergeFrom(paramArrayOfByte);
      i1 = localgVideoDownChannelControl.uint32_switch.get();
      bool = a().a(localgVideoDownChannelControl);
      if (i1 == 1) {}
      if (!bool) {
        break label87;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        label87:
        paramArrayOfByte.printStackTrace();
        boolean bool = false;
        continue;
        int i1 = 0;
      }
    }
    if (a().N == 3)
    {
      i1 = 1;
      if (i1 != 0) {
        a(true);
      }
      return;
    }
  }
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    a().a(l1, "onGaGoOffStageResult", false, false);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
  }
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = a();
    String str;
    if (paramInt2 == 3)
    {
      str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
      boolean bool = TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, str);
      if ((!bool) || (QLog.isDevelopLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + localSessionInfo.jdField_c_of_type_JavaLangString + "], seq[" + l1 + "]");
      }
      if (bool) {
        break label169;
      }
    }
    label169:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      str = SessionMgr.a(paramInt2, String.valueOf(paramLong2), new int[0]);
      break;
    }
    if (paramInt1 == 90) {
      if (paramLong1 == 3L) {
        a().a(l1, "onGaGoOnStageResult.1", true, false);
      }
    }
    for (;;)
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
      return;
      a().a(l1, "onGaGoOnStageResult.2", false, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      continue;
      a().a(l1, "onGaGoOnStageResult.3", false, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
  }
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaSwitchVideoResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], seq[" + l1 + "]");
    }
    if (paramInt1 == 96) {
      if (a().jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        a().a(l1, "onGaSwitchVideoResult", true, true);
        this.jdField_c_of_type_Boolean = true;
        int i2 = 0;
        if (i2 < a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i2);
          int i1;
          if (a()) {
            if (((VideoViewInfo)localObject).jdField_a_of_type_Int == 1)
            {
              i1 = 1;
              label178:
              if ((((VideoViewInfo)localObject).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (i1 == 0)) {
                break label226;
              }
            }
          }
          for (;;)
          {
            i2 += 1;
            break;
            i1 = 0;
            break label178;
            i1 = 1;
            break label178;
            label226:
            if (a(((VideoViewInfo)localObject).jdField_a_of_type_Long, ((VideoViewInfo)localObject).jdField_a_of_type_Int, a().jdField_e_of_type_JavaUtilArrayList)) {
              ((VideoViewInfo)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((VideoViewInfo)localObject).jdField_b_of_type_Boolean = false;
            }
          }
        }
        a().jdField_e_of_type_JavaUtilArrayList.clear();
        a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), false, true);
        Object localObject = a(a().jdField_c_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaSwitchVideoResult-->Display VideoViewInfo List = " + (String)localObject);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
      }
      return;
      this.jdField_c_of_type_Boolean = false;
      a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), true, true);
      a().jdField_e_of_type_JavaUtilArrayList.clear();
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
    case 101: 
      a().Y = true;
      c(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      a().jdField_K_of_type_Int = paramInt2;
      c(paramInt1, paramLong, paramInt2);
      return;
    }
    b(paramInt1, paramLong, paramInt2);
  }
  
  public void onGroupSecurityLimit(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupSecurityLimit, mGAudioInRoom[" + this.jdField_d_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], info[" + paramLong2 + "], strMsg[" + paramString + "]");
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1)) {
      a(1, paramLong1, 82);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_j_of_type_JavaLangRunnable = null;
      a().a("onGroupSecurityLimit", 0);
      onGAudioSDKError(1, paramLong1, 17, 0);
    }
  }
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupVideoClosed, relationId[" + paramLong + "], reason[" + paramInt2 + "], avtype[" + paramInt3 + "], bKickout[" + this.v + "], mGAudioInRoom[" + this.jdField_d_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    if (this.v) {
      return;
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {
      a(1, paramLong, 83);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_j_of_type_JavaLangRunnable = null;
      a().a("onGroupVideoClosed", 0);
      a(paramInt1, paramLong, 17, 0, paramInt2);
    }
  }
  
  public void onHowling()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = h();
      if (!bool1)
      {
        int i1 = e();
        a("onHowling", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, e());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().jdField_P_of_type_Boolean;
      if (bool2) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131695605), 2131690800, 2131694615, new VideoController.42(this), new VideoController.43(this, bool1, bool2));
      ReportController.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo onInviteReached, peerUin[" + paramString + "], friend_state[" + paramInt + "], extraParam0[" + paramLong + "], subState[" + a().jdField_d_of_type_Long + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l1 + "]");
    a().jdField_o_of_type_JavaLangString = null;
    if (a() != null)
    {
      if (0L != a().jdField_d_of_type_Long) {
        break label313;
      }
      if (0L != paramLong) {}
    }
    else
    {
      if ((a() == null) || (!a().l())) {
        break label369;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onInviteReached, isConnected");
    }
    label313:
    label369:
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            return;
            if (1L == paramLong)
            {
              a().jdField_d_of_type_Long = 1L;
              if (paramArrayOfByte == null) {
                break;
              }
              a().jdField_o_of_type_JavaLangString = new String(paramArrayOfByte);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :" + a().jdField_o_of_type_JavaLangString);
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(400), a().jdField_o_of_type_JavaLangString });
              break;
            }
            if (2L != paramLong) {
              break;
            }
            a().jdField_d_of_type_Long = 2L;
          } while (paramArrayOfByte == null);
          a().jdField_o_of_type_JavaLangString = new String(paramArrayOfByte);
          return;
          if (1L != a().jdField_d_of_type_Long) {
            break;
          }
          if (0L == paramLong)
          {
            a().jdField_d_of_type_Long = 0L;
            return;
          }
        } while (1L == paramLong);
        if (2L != paramLong) {
          break;
        }
        a().jdField_d_of_type_Long = 0L;
        a(l1);
        return;
        i1 = 0x80000 & paramInt;
        if ((i1 <= 0) || (!this.jdField_k_of_type_Boolean)) {
          break label405;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :has get phone state");
      return;
      if (i1 == 0) {
        this.jdField_k_of_type_Boolean = true;
      }
      a().jdField_o_of_type_Int = 0;
      if ((0x10000 & paramInt) > 0)
      {
        i1 = 0x40000 & paramInt;
        a().jdField_m_of_type_Int = (0x20000 & paramInt);
        a().jdField_n_of_type_Int = i1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached pcOnLine:" + a().jdField_m_of_type_Int + " # phoneOnLine = " + a().jdField_n_of_type_Int);
        }
        if (((0x100000 & paramInt) > 0) && (i1 > 0))
        {
          if ((0xFFFF & paramInt & 0x1) > 0) {
            a().jdField_o_of_type_Int = 1;
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
          {
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
            }
            this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
          }
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
          {
            if ((a() != null) && (a().jdField_d_of_type_Long == 1L) && (!TextUtils.isEmpty(a().jdField_o_of_type_JavaLangString))) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString, a().jdField_o_of_type_JavaLangString });
            }
          }
          else if (!a().ak) {
            b(l1);
          }
        }
        for (;;)
        {
          a().jdField_s_of_type_Boolean = true;
          return;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString });
          break;
          paramInt &= 0xFFFF;
          if ((paramInt & 0x2) > 0) {
            a().jdField_o_of_type_Int = 2;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label817;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached low 16bit value is" + paramInt);
            break;
            if ((paramInt & 0x4) > 0)
            {
              a().jdField_o_of_type_Int = 3;
              ReportController.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
            }
            else if ((paramInt & 0x8) > 0)
            {
              a().jdField_o_of_type_Int = 4;
            }
          }
        }
      }
      a().jdField_m_of_type_Int = 0;
      a().jdField_n_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pc and phone both not online");
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        }
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      n(true);
      a().jdField_s_of_type_Boolean = false;
      a(a().jdField_d_of_type_JavaLangString, 210);
      b(210);
      this.jdField_h_of_type_JavaLangRunnable = new VideoController.24(this, l1);
    } while ((this.jdField_h_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    label405:
    label817:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 2000L);
  }
  
  public void onKickOutFail(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onKickOutFail, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], errCode[" + paramInt3 + "], strMsg[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(false), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void onKickOutSuc(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onKickOutSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], errCode[" + paramInt3 + "], strMsg[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(true), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut--> UserInfo = " + paramAVUserInfo.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramAVUserInfo.accountType == 1)
      {
        if (a().a(paramAVUserInfo.account, a().jdField_f_of_type_JavaUtilArrayList) == null) {
          break label183;
        }
        localAVPhoneUserInfo = a().a(paramAVUserInfo.account, a().jdField_f_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + localAVPhoneUserInfo);
        }
      }
      a(paramInt2, paramLong1, paramAVUserInfo, true, paramLong2, paramVarArgs);
    }
    label183:
    do
    {
      return;
      localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramAVUserInfo.account;
      localAVPhoneUserInfo.accountType = 2;
      a().a(localAVPhoneUserInfo);
      this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramAVUserInfo.account);
      break;
      if (paramInt1 == 71)
      {
        if (paramAVUserInfo.accountType == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramAVUserInfo.account;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramAVUserInfo, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  public void onMediaCameraNotify(byte[] paramArrayOfByte, long paramLong)
  {
    String str = null;
    if (paramLong == 0L) {
      a().Q = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(27), str });
      return;
      if (paramLong == 1L)
      {
        a().Q = true;
      }
      else if (paramLong == 100L)
      {
        a().R = false;
      }
      else if (paramLong == 101L)
      {
        a().R = true;
        if (paramArrayOfByte != null) {
          str = new String(paramArrayOfByte);
        }
      }
      else
      {
        a().Q = false;
        a().R = false;
      }
    }
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if (paramArrayOfLong == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGaChatUserInOrOut-->userUin is 0,OpType = " + paramInt1);
      }
    }
    long l1;
    do
    {
      return;
      l1 = paramArrayOfLong[0];
      switch (paramInt1)
      {
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong type of GaChatMemBerInType, and Type = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", groupUin = ");
    localStringBuilder.append(paramLong1);
    paramInt2 = paramArrayOfLong.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramLong1 = paramArrayOfLong[paramInt1];
      localStringBuilder.append(", userUin = ");
      localStringBuilder.append(paramLong1);
      paramInt1 += 1;
      continue;
      a(paramLong1, paramArrayOfLong, true, paramInt4);
      return;
      a(paramLong1, paramArrayOfLong, false, paramInt4);
      return;
      a(paramLong1, l1, true, paramInt2, paramLong2, paramInt3);
      return;
      a(paramLong1, l1, false, paramInt2, paramLong2, paramInt3);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onMultiVideoChatMembersInfoChange = userUin:" + l1 + "curuin:" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      }
      if (l1 != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) {
        a(paramLong1, l1, paramInt2, paramLong2, paramInt3);
      }
      for (;;)
      {
        ScreenShareReportHelper.a(SessionMgr.a().a().jdField_c_of_type_JavaLangString, "MEMBER_SHARE_SCREEN_IN");
        return;
        a(paramLong1, l1, true, paramInt2, false, paramLong2, paramInt3);
      }
      a(paramLong1, l1, false, paramInt2, false, paramLong2, paramInt3);
      ScreenShareReportHelper.b(SessionMgr.a().a().jdField_c_of_type_JavaLangString, "MEMBER_SHARE_SCREEN_OUT");
      return;
      a(Long.valueOf(paramLong1), l1, paramInt2, true);
      return;
      a(Long.valueOf(paramLong1), l1, paramInt2, false);
      return;
      a(paramLong1, l1, true, paramInt2, true, paramLong2, paramInt3);
      return;
      a(paramLong1, l1, false, paramInt2, true, paramLong2, paramInt3);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
  }
  
  public void onNeedShowPeerVideo(String paramString)
  {
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + localSessionInfo.jdField_d_of_type_JavaLangString + "], extraUin[" + localSessionInfo.jdField_f_of_type_JavaLangString + "], remoteHasVideo[" + localSessionInfo.jdField_k_of_type_Boolean + "], mXiaoweiDevice[" + this.jdField_q_of_type_Boolean + "], seq[" + l1 + "]");
    if ((TextUtils.equals(localSessionInfo.jdField_d_of_type_JavaLangString, paramString)) || (TextUtils.equals(localSessionInfo.jdField_f_of_type_JavaLangString, paramString)) || (this.jdField_q_of_type_Boolean))
    {
      if ((localSessionInfo.jdField_f_of_type_Int == 1) && (!f())) {
        AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
      }
    }
    else {
      return;
    }
    if (!localSessionInfo.jdField_k_of_type_Boolean)
    {
      localSessionInfo.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
      DataReport.m(this);
      if (localSessionInfo.jdField_d_of_type_Int == 1)
      {
        localSessionInfo.a(l1, "onNeedShowPeerVideo", 2);
        localSessionInfo.S = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.equals(localSessionInfo.jdField_d_of_type_JavaLangString, paramString)) {
        GraphicRenderMgr.getInstance().onUinChanged(localSessionInfo.jdField_d_of_type_JavaLangString, paramString);
      }
      if ((!localSessionInfo.jdField_j_of_type_Boolean) && (!localSessionInfo.jdField_k_of_type_Boolean)) {
        break;
      }
      c(2);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
    }
    c(1);
  }
  
  public void onNetLevel_S2C(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  public void onNetworkDisconnect(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
  }
  
  public void onNetworkInfo_S2C(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C:flag is:" + paramLong);
    }
    if (paramLong != 0L) {
      try
      {
        String str = new String(paramArrayOfByte, "UTF-8");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf((int)paramLong), str });
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localNullPointerException);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localUnsupportedEncodingException);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf(0), null });
  }
  
  public void onNetworkMonitorInfo(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad,detail is null");
      }
    }
    label192:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if ((QLog.isColorLevel()) && (paramLong != 1L)) {
              break label192;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad");
            }
            if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
              try
              {
                paramArrayOfByte = new String(paramArrayOfByte, "GBK");
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(26), paramArrayOfByte });
                return;
              }
              catch (NullPointerException paramArrayOfByte)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
                  return;
                }
              }
              catch (UnsupportedEncodingException paramArrayOfByte) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
        return;
      } while (paramLong != 0L);
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(19), paramArrayOfByte });
        return;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
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
  
  public void onOpenMicFail()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695694, 1).a();
    }
    Object localObject = a();
    if (localObject != null) {
      if (((SessionInfo)localObject).F != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      DoodleUtils.a((String)localObject);
      return;
    }
  }
  
  public void onOtherTerminalChatingStatus(String paramString, long paramLong, int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus, fromUin[" + paramString + "], roomid[" + paramLong + "], type[" + paramInt + "], seq[" + l1 + "]");
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject = SessionMgr.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
    if (localObject != null) {
      ((SessionInfo)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
    }
    if ((paramInt != 0) && (!TextUtils.isEmpty(a().jdField_d_of_type_JavaLangString)) && ((!a().jdField_d_of_type_JavaLangString.equals(paramString)) || (a().jdField_d_of_type_Int == 0)))
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus sendQueryRoomInfoRequest");
    }
    a(0, paramString, paramLong, paramInt);
  }
  
  public void onPPTInOrOut(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    VideoController.GAudioFriends localGAudioFriends = a(String.valueOf(paramLong2));
    if (localGAudioFriends == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    localGAudioFriends.jdField_d_of_type_Boolean = false;
  }
  
  public void onPauseAudio(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseAudio fromUin = " + paramString + ", remoteMute = " + a().jdField_h_of_type_Boolean);
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + localSessionInfo.jdField_k_of_type_Boolean + "], isOnlyAudio[" + localSessionInfo.S + "], seq[" + l1 + "]");
    if (Utils.a(BaseApplication.getContext()) == 1) {
      localSessionInfo.b(l1, false);
    }
    while ((localSessionInfo.jdField_d_of_type_Int != 2) || (!localSessionInfo.jdField_k_of_type_Boolean)) {
      return;
    }
    localSessionInfo.b(l1, false);
    if (!localSessionInfo.jdField_j_of_type_Boolean)
    {
      localSessionInfo.S = true;
      localSessionInfo.a(l1, "onPauseVideo", 1);
      c(localSessionInfo.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    DataReport.n(this);
  }
  
  public void onPeerSwitchTerminal(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onPeerSwitchTerminal. fromUin = " + paramString + ", peerTerminalType = " + paramInt1 + ", peerSdkVersion = " + paramInt2 + ", roomId = " + paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    a().al = true;
    paramString = SessionMgr.a().a(paramString);
    if (paramString != null)
    {
      paramString.b(paramInt2);
      paramString.c(paramInt1);
      paramString.d(paramLong);
    }
    a("onPeerSwitchTerminal", a());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).c(paramString);
    }
  }
  
  public void onPeerSwitchTerminalFail(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTerminalFail fromUin = " + paramString + ", info :" + paramInt);
    }
    a("onPeerSwitchTerminalFail", a());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void onPstnCallConnected(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    paramLong = AudioHelper.b();
    if ((paramInt == 1) && (1L == a().jdField_d_of_type_Long))
    {
      a().jdField_d_of_type_Long = 0L;
      a(paramLong);
    }
  }
  
  public void onRecSharePushEncParam(int paramInt, long paramLong, RecordParam paramRecordParam)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt, paramLong, paramRecordParam);
    }
  }
  
  public void onRecordAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecordAudio=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
    if (paramInt1 == 100) {
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0] != null)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      if (AudioDump.a()) {
        AudioDump.a().a(paramArrayOfByte, paramInt1, paramInt2);
      }
      return;
      if (((paramInt1 == 3) || (paramInt1 == 0) || (paramInt1 == 8)) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1] != null)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
  }
  
  public void onRecvFirstAudioData(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRecvFirstAudioData, recvFirstAudio[" + paramBoolean + "], seq[" + l1 + "]");
    }
    if (paramBoolean)
    {
      if (!a().S) {
        break label144;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        if (-1 != this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(a().jdField_d_of_type_JavaLangString)) {
          break label136;
        }
        this.jdField_j_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean), Long.valueOf(l1) });
      return;
      label136:
      this.jdField_j_of_type_Boolean = true;
      continue;
      label144:
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  public void onRejectVideo(String paramString)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo onRejectVideo fromUin = " + paramString);
    b(paramString, 3);
  }
  
  public void onRejectVideoMode(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2)
  {
    SessionInfo localSessionInfo = a();
    if (localSessionInfo.aq) {}
    while (localSessionInfo.b(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
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
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    boolean bool3 = this.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramString1);
    long l2 = AudioHelper.b();
    String str = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder().append("avideo onRequestVideo, uinType[").append(paramInt1).append("], fromUin[").append(paramString1).append("], extraUin[").append(paramString2).append("], sig[");
    if (paramArrayOfByte != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.w(str, 1, bool1 + "], onlyAudio[" + paramBoolean + "], bindID[" + paramString3 + "], bindType[" + paramInt2 + "], isOfflineSession[" + bool3 + "], seq[" + l2 + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() != null)) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvQavChannelProxy.b();
    J();
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = QAVNotificationUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i1 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
    }
    if (a(i1, paramString1))
    {
      a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
      return;
    }
    localObject = a();
    str = SessionMgr.a(3, paramString1, new int[0]);
    if ((TextUtils.equals(str, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString)) && (((SessionInfo)localObject).jdField_d_of_type_Boolean))
    {
      ((SessionInfo)localObject).jdField_e_of_type_Boolean = true;
      paramInt1 = 1;
      if (((SessionInfo)localObject).S) {
        paramInt1 = 0;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((SessionInfo)localObject).F);
      return;
    }
    boolean bool2 = false;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((i1 != 21) && (i1 != 1011) && ((((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in Random Double");
      if (bool4)
      {
        a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
        return;
      }
      bool2 = true;
      bool1 = bool2;
      if (!this.jdField_f_of_type_Boolean)
      {
        a(l2, 30000L);
        bool1 = bool2;
      }
      label570:
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      ((SessionInfo)localObject).A = paramInt2;
      ((SessionInfo)localObject).jdField_p_of_type_JavaLangString = paramString3;
      ((SessionInfo)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((SessionInfo)localObject).jdField_B_of_type_Int = i1;
      if (this.jdField_h_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_h_of_type_JavaLangRunnable = null;
        ((SessionInfo)localObject).a("onRequestVideo.1", 0);
      }
      if (!this.jdField_a_of_type_ComTencentAvQavChannelProxy.a()) {
        break label1855;
      }
      i1 = 9500;
    }
    label693:
    label1855:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      ((SessionInfo)localObject).S = paramBoolean;
      long l3;
      if (paramBoolean)
      {
        ((SessionInfo)localObject).jdField_f_of_type_Int = 1;
        l1 = a(paramString1);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  ,roomId = " + l1);
        ((SessionInfo)localObject).d(l1);
        ((SessionInfo)localObject).jdField_j_of_type_Int = i1;
        ((SessionInfo)localObject).jdField_k_of_type_Int = paramInt1;
        ((SessionInfo)localObject).jdField_d_of_type_JavaLangString = paramString1;
        ((SessionInfo)localObject).jdField_f_of_type_JavaLangString = paramString2;
        ((SessionInfo)localObject).jdField_e_of_type_Boolean = true;
        ((SessionInfo)localObject).a("onRequestVideo.2", 2);
        ((SessionInfo)localObject).jdField_q_of_type_Int = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!paramBoolean) {
          break label1540;
        }
        paramInt1 = 1;
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        l3 = a(paramString1);
        VideoNodeManager.a(l3, 36);
        VideoNodeManager.a(l3, 9, ((SessionInfo)localObject).b());
        VideoNodeManager.a(l3, 11, paramString1);
        VideoNodeManager.a(l3, 12, 2L);
        if (!((SessionInfo)localObject).S) {
          break label1545;
        }
      }
      for (long l1 = 1L;; l1 = 2L)
      {
        VideoNodeManager.a(l3, 13, l1);
        VideoNodeManager.a(l3, 15, 1L);
        j(paramString1);
        if (!bool3) {
          break label1553;
        }
        ((SessionInfo)localObject).jdField_c_of_type_Boolean = true;
        b(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in Random mulit");
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label570;
        }
        if (((SessionInfo)localObject).f())
        {
          if (i1 == -1)
          {
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString1, c());
            QLog.w(jdField_a_of_type_JavaLangString, 1, "closeVideo uinType == -1");
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString1, 0, this);
            paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
            if (paramString1 == null) {
              break;
            }
            paramString1.a(0);
            return;
          }
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
            break label570;
          }
          bool1 = true;
          break label570;
        }
        if ((((SessionInfo)localObject).o()) || (((SessionInfo)localObject).p()))
        {
          b(((SessionInfo)localObject).jdField_d_of_type_JavaLangString, 2);
          bool1 = bool2;
          break label570;
        }
        if (((((SessionInfo)localObject).jdField_g_of_type_Int == 7) && (this.jdField_c_of_type_Long != 0L)) || (((SessionInfo)localObject).jdField_g_of_type_Int == 14) || (((SessionInfo)localObject).jdField_g_of_type_Int == 13))
        {
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label570;
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          if (((i1 == 21) || (i1 == 1011)) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString != null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  auto Accept");
            if ((((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString != null) && (!((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString.equals(paramString1)))
            {
              a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            a(l2, 30000L);
            bool1 = bool2;
            break label570;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool4);
          bool1 = true;
          if ((((SessionInfo)localObject).jdField_d_of_type_JavaLangString != null) && (paramString1.equals(((SessionInfo)localObject).jdField_d_of_type_JavaLangString)))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when request: fromUin = " + paramString1);
            E();
            j(paramString1);
            return;
          }
          if (!bool4) {
            break label570;
          }
          a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.jdField_d_of_type_Boolean) || (((SessionInfo)localObject).jdField_g_of_type_Int == 8))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in group chat, fromUin = " + paramString1);
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label570;
        }
        bool1 = bool2;
        if (((SessionInfo)localObject).jdField_g_of_type_Int != 1) {
          break label570;
        }
        bool1 = bool2;
        if (((SessionInfo)localObject).jdField_d_of_type_JavaLangString == null) {
          break label570;
        }
        bool1 = bool2;
        if (!paramString1.equals(((SessionInfo)localObject).jdField_d_of_type_JavaLangString)) {
          break label570;
        }
        return;
        ((SessionInfo)localObject).jdField_f_of_type_Int = 2;
        break label693;
        paramInt1 = 2;
        break label812;
      }
      if ((!this.jdField_d_of_type_Boolean) && (((SessionInfo)localObject).jdField_j_of_type_Int != 21) && (((SessionInfo)localObject).jdField_j_of_type_Int != 1011)) {
        a(str, ((SessionInfo)localObject).jdField_f_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_n_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a(), 0));
      }
      if ((this.x) && (this.jdField_n_of_type_Int == 0) && (!bool4) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.6(this, l2, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor != null) {
        this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor.b();
      }
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor = new VideoCallStateMonitor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      a(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
      return;
    }
  }
  
  public void onRequestVideoMode(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    a().I = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void onResumeAudio(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeAudio fromUin = " + paramString + ", remoteMute = " + a().jdField_h_of_type_Boolean + "|" + this.jdField_b_of_type_Boolean);
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + localSessionInfo.jdField_k_of_type_Boolean + "], isOnlyAudio[" + localSessionInfo.S + "], seq[" + l1 + "]");
    if ((localSessionInfo.jdField_f_of_type_Int == 1) && (!f())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (localSessionInfo.jdField_k_of_type_Boolean);
      localSessionInfo.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      DataReport.m(this);
    } while (localSessionInfo.jdField_d_of_type_Int != 1);
    localSessionInfo.a(l1, "onResumeVideo", 2);
    localSessionInfo.S = false;
  }
  
  public void onSDKCustomCommand(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onSDKCustomCommand uin=%s, cmd=%s, arg1=%s, arg2=%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    if (paramLong1 == 200L)
    {
      if (paramLong2 != 1L) {
        break label69;
      }
      VideoSocketReconnectReporter.a();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    VideoSocketReconnectReporter.a(paramLong3);
  }
  
  public void onSelfAudioVolumeChange(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSelfAudioVolumeChange qav.value:=" + paramLong);
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
    a().ao = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    g(paramString);
  }
  
  public void onSetMicBySelf(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onSetMicBySelf uin = " + paramLong);
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
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
  }
  
  public void onShareOpsCallback(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
    }
  }
  
  public void onSwitchGroup(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = AudioHelper.b();
    paramArrayOfByte = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchGroup, fromUin[" + paramString + "], flag[" + paramLong + "], seq[" + l1 + "]");
    if ((paramArrayOfByte.jdField_d_of_type_Int == 3) || (paramArrayOfByte.jdField_d_of_type_Int == 4)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.jdField_d_of_type_JavaLangString))) {
      return;
    }
    k(true);
    if (!paramArrayOfByte.b()) {
      a(l1, 2131230736, 1, null);
    }
    paramArrayOfByte.d("onSwitchGroup", AVUtil.a(paramArrayOfByte.jdField_j_of_type_Int));
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(2, 11);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
    c();
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
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchTerminalSuccess, fromUin[" + paramString1 + "], info[" + paramInt1 + "], hdModeFreeUseStartTime[" + paramInt2 + "], hdModeFreeUseEndTime[" + paramInt3 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.jdField_f_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_f_of_type_JavaLangRunnable = null;
    }
    boolean bool2 = false;
    paramString1 = a();
    boolean bool1;
    if (paramString1.al)
    {
      paramString1.al = false;
      if (paramString1.jdField_g_of_type_Boolean) {
        a(true, paramString1.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString1.jdField_d_of_type_JavaLangString, Boolean.valueOf(false) });
        c(l1);
        paramInt1 = (int)a();
        boolean bool3 = paramString1.jdField_k_of_type_Boolean;
        if (paramString1.jdField_h_of_type_Boolean) {
          break label329;
        }
        bool1 = true;
        label250:
        a(paramInt1, bool3, bool1);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      paramString2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (paramString2 != null) {
        paramString2.a(this, paramString1);
      }
      ((WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(paramString1, bool1);
      return;
      paramString2 = new VideoController.16(this, paramString1);
      this.jdField_a_of_type_JavaUtilList.add(paramString2);
      break;
      label329:
      bool1 = false;
      break label250;
      bool1 = bool2;
      if (paramString1.ak)
      {
        onChannelReady(paramString1.jdField_d_of_type_JavaLangString, paramInt2, paramInt3, paramString2, paramLong);
        bool1 = true;
      }
    }
  }
  
  public void onSyncOtherTerminalChatStatus(String paramString, int paramInt)
  {
    if (!a().ak)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "not start StartByTerminalSwitch but receive onSyncOtherTerminalChatStatus message");
      }
      return;
    }
    int i2 = paramInt & 0xFFFFF;
    int i1 = paramInt >> 20 & 0x1;
    int i3 = paramInt >> 21 & 0x1;
    paramInt = i1;
    if (a().am)
    {
      paramInt = i1;
      if (a().jdField_d_of_type_Int == 1)
      {
        paramInt = i1;
        if (f())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "switch start frome video entry, open camera");
          }
          paramInt = 1;
        }
      }
    }
    a().jdField_f_of_type_Long = i2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSyncOtherTerminalChatStatus time:" + i2 + ", isCamreOpen:" + paramInt + ", isMicOpen:" + i3);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(34), Integer.valueOf(paramInt), Integer.valueOf(i3) });
  }
  
  public void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onVideoSrcChange, videoSrcType[" + paramInt1 + "], relationType[" + paramInt2 + "], userUin[" + paramLong1 + "], groupUin[" + paramLong2 + "], seq[" + l1 + "]");
    }
    Object localObject = a(String.valueOf(paramLong1));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onVideoSrcChange-->can not find the user");
      }
      return;
    }
    int i1 = 0;
    int i3;
    int i2;
    if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size()) {
      if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
      {
        i3 = ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
        i2 = i1;
      }
    }
    for (i1 = i3;; i1 = 1)
    {
      if (paramInt1 == 4)
      {
        if (i2 == -1) {
          break label564;
        }
        a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
        u();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i1), Long.valueOf(l1) });
      }
      label562:
      label564:
      for (i1 = 0;; i1 = 1)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(73), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(l1) });
        for (;;)
        {
          if (i1 == 0) {
            break label562;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(87), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return;
          i1 += 1;
          break;
          if (paramInt1 != 0)
          {
            i1 = a().a(paramLong1, 0);
            if (i1 == -1)
            {
              a(paramLong1, true, paramInt2, 5L);
              a((VideoController.GAudioFriends)localObject, paramInt1);
              i1 = a().a(paramLong1, 0);
            }
            for (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;; ((VideoViewInfo)localObject).jdField_a_of_type_Int = paramInt1)
            {
              i1 = 1;
              break;
              localObject = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
              VideoViewInfo localVideoViewInfo = new VideoViewInfo();
              localVideoViewInfo.jdField_a_of_type_Long = ((VideoViewInfo)localObject).jdField_a_of_type_Long;
              localVideoViewInfo.jdField_a_of_type_Int = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localVideoViewInfo);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
            }
          }
          i1 = 0;
        }
        break;
      }
      i2 = -1;
    }
  }
  
  public void p()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStartTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_m_of_type_JavaLangRunnable, 3000L);
  }
  
  public boolean p()
  {
    if (AudioHelper.e()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[" + this.jdField_i_of_type_Int + "]");
    }
    return this.jdField_i_of_type_Int > 0;
  }
  
  public void q()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStopTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
  }
  
  public boolean q()
  {
    if ((a() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    while ((a().jdField_j_of_type_Int != 10003) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean)) {
      return false;
    }
    return true;
  }
  
  public void r()
  {
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public boolean r()
  {
    return (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl != null) && (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl.h());
  }
  
  public void receiveTransferMsg(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.receiveTransferMsg(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(122), paramString });
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkScreenShareValid");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.checkScreenShareAvaliable();
    }
  }
  
  public void u()
  {
    int i1;
    if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      if (g() == 4) {
        break label420;
      }
      i1 = a().b();
      if (i1 != -1) {
        break label71;
      }
      ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label71:
    do
    {
      for (;;)
      {
        return;
        VideoViewInfo localVideoViewInfo1 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        localVideoViewInfo1.jdField_a_of_type_Boolean = true;
        if (localVideoViewInfo1.jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          if (i1 != 0)
          {
            localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
            localVideoViewInfo2.jdField_a_of_type_Boolean = false;
            a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
            a().jdField_c_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
          }
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
            a().jdField_d_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
            a().c();
            if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1)
            {
              i1 = 0;
              if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
              {
                if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
                  ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    } while (i1 == 0);
    VideoViewInfo localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
    localVideoViewInfo2.jdField_a_of_type_Boolean = false;
    a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
    a().jdField_c_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
    synchronized (a().jdField_d_of_type_JavaUtilArrayList)
    {
      a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
      a().jdField_d_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
      a().c();
      return;
    }
    label420:
    ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "goOffStage, ret[" + i1 + "]");
        }
        return;
        if ((a().F == 1) && (a().D == 10)) {
          ReportController.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void w()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startRandomTimeout, seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
      this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = new VideoController.AnyChatReqTimeoutRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable.jdField_a_of_type_Long = l1;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable, 30000L);
  }
  
  public void x()
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.jdField_i_of_type_Int + "]");
    this.jdField_i_of_type_Int = 0;
  }
  
  public void y()
  {
    SessionInfo localSessionInfo = a();
    if (localSessionInfo != null)
    {
      int i2 = localSessionInfo.jdField_V_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = localSessionInfo.U;
      }
      b(i1);
      if ((i1 == 0) || (!localSessionInfo.aC)) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      return;
    }
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onProcessExit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */