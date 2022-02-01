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
import com.tencent.av.avatar.IAvatar2DAIDataListener;
import com.tencent.av.avsdkconfig.QavSdkConfigHelper;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.QavCameraPreviewSizeControl;
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
import com.tencent.av.gaudio.GInviteTimeOutHelper;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.QQGAudioCtrlCallback;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.qavperf.QAVPerf;
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
import com.tencent.mobileqq.debug.qav.tools.QavDebugTools;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
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
import mqq.util.LogUtil;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  implements IVideoSession, QavChannelProxy.IChannelCallback, ISetAudioFrameCallback, IVideoEventListener, VcControllerImpl.CloseVideoTimeoutCallback, QQGAudioCtrlCallback
{
  static volatile VideoController D;
  public static String a = "VideoController";
  private static String aR = "com.tencent.av.count";
  public static String aj = "WifiQQCall";
  public static String ak = "WifiRandom";
  public static String al = "WifiGuild";
  public static int as = -1;
  public static int at = 1;
  public static int au;
  GVideoDownloadChannelControl A = new GVideoDownloadChannelControl();
  Runnable B = new VideoController.1(this);
  Runnable C = new VideoController.2(this);
  boolean E = false;
  int F = 0;
  VideoController.OnCustomCompletionListener G = new VideoController.9(this);
  VideoController.OnCustomCompletionListener H = new VideoController.10(this);
  Runnable I = null;
  VideoController.OnCustomCompletionListener J = new VideoController.12(this);
  Runnable K = null;
  Runnable L = null;
  Runnable M = null;
  public PhoneStatusMonitor N;
  PhoneStatusMonitor.PhoneStatusListener O;
  AudioManager P = null;
  AudioManager.OnAudioFocusChangeListener Q = null;
  Runnable R = null;
  boolean S = false;
  Runnable T = null;
  QQGAudioCtrl U = null;
  boolean V = false;
  Runnable W = null;
  public boolean X = false;
  public long Y = 0L;
  public int Z = 0;
  private int aA = 0;
  private OrientationEventListener aB = null;
  private boolean aC = false;
  private SdkAudioFrameCallback[] aD = null;
  private InviteUIChecker aE;
  private MqqHandler aF = null;
  private int aG = 0;
  private boolean aH = false;
  private volatile VideoCallStateMonitor aI = null;
  private Runnable aJ = null;
  private int aK = 1;
  private boolean aL = false;
  private final Object aM = new Object();
  private int aN = -1;
  private ArrayList<VideoController.GAudioFriends> aO = new ArrayList();
  private Runnable aP = new VideoController.36(this);
  private final ArrayList<VideoController.GAudioFriends> aQ = new ArrayList();
  private EffectsRenderController aS;
  private boolean aT = false;
  private IAvatar2DAIDataListener aU = new VideoController.44(this);
  private Runnable aV = null;
  private WatchTogetherMediaPlayCtrl aW;
  private ScreenRecordHelper aX;
  private ScreenShareCtrl aY;
  public boolean aa = false;
  public boolean ab = false;
  public boolean ac = true;
  public boolean ad = false;
  boolean ae = false;
  Runnable af = null;
  boolean ag = false;
  ArrayList<VideoController.GAudioFriends> ah = new ArrayList();
  Runnable ai = new VideoController.37(this);
  VideoController.StartRingRunnable am = null;
  boolean an = false;
  int ao = 0;
  public boolean ap = false;
  VideoController.StartAudioSendRunnable aq = null;
  final Object ar = new Object();
  int av = as;
  public long aw = -1L;
  public AVCallCompactHelper ax = null;
  private boolean ay = false;
  private boolean az = false;
  SessionMgr b = SessionMgr.a();
  boolean c = true;
  VcControllerImpl d = null;
  public VideoAppInterface e = null;
  Context f;
  boolean g = false;
  public int h = 0;
  boolean i = false;
  public boolean j = false;
  public long k = 0L;
  public int l = 0;
  public boolean m = false;
  public final QavChannelProxy n = new QavChannelProxy(this);
  public int o = 0;
  boolean p = true;
  List<Runnable> q = new ArrayList();
  public int r = 0;
  public volatile boolean s = true;
  public final VideoCameraListener t = new VideoCameraListener(this);
  public long u = 6000L;
  public TraeHelper v = null;
  public int w = 0;
  boolean x = false;
  public int y;
  HashMap<Long, Long> z = new HashMap();
  
  private VideoController()
  {
    if (AVUtil.b()) {
      this.ax = new AVCallCompactHelper();
    }
    if (Build.VERSION.SDK_INT >= 21) {
      this.aE = new InviteUIChecker();
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "VideoController create.");
    }
    this.aF = ThreadManager.getSubThreadHandler();
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
  
  private int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject1 = this.U;
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
    boolean bool3 = this.ap;
    localObject1 = this.aq;
    if (!paramBoolean1)
    {
      boolean bool1;
      if ((!paramBoolean2) && (!bool3)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      this.ap = bool1;
    }
    else
    {
      this.ap = false;
    }
    if (paramInt != 2)
    {
      if ((i1 != 0) && (paramBoolean2))
      {
        localObject2 = this.aq;
        if (localObject2 == null)
        {
          this.aq = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
        }
        else
        {
          localObject3 = this.aF;
          if (localObject3 != null) {
            ((MqqHandler)localObject3).removeCallbacks((Runnable)localObject2);
          }
          if (paramInt == 0) {
            this.aq = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
          }
        }
        localObject2 = this.aF;
        if (localObject2 != null) {
          ((MqqHandler)localObject2).postDelayed(this.aq, 1000L);
        }
      }
      else if (paramInt == 1)
      {
        this.aq = null;
      }
    }
    else {
      this.aq = null;
    }
    Object localObject2 = a;
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
    ((StringBuilder)localObject3).append(this.ap);
    ((StringBuilder)localObject3).append("], result[");
    ((StringBuilder)localObject3).append(i1);
    ((StringBuilder)localObject3).append("], mGAudioCtrl[");
    paramBoolean1 = bool2;
    if (this.U != null) {
      paramBoolean1 = true;
    }
    ((StringBuilder)localObject3).append(paramBoolean1);
    ((StringBuilder)localObject3).append("], lastRunnable[");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append("], curRunnable[");
    ((StringBuilder)localObject3).append(this.aq);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    return i1;
  }
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.b.d()))
    {
      QLog.w(a, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramAVUserInfo.account;
    long l3 = CharacterUtil.b(this.e.getCurrentAccountUin());
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
      ??? = k();
    } else {
      ??? = SessionMgr.a().d(paramVarArgs);
    }
    long l2;
    boolean bool2;
    label511:
    long l4;
    if ((??? != null) && (!TextUtils.isEmpty(((SessionInfo)???).f)))
    {
      l2 = AudioHelper.c();
      if (AudioHelper.e())
      {
        paramVarArgs = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGAudioUserEnterOrLeave, mGAudioGroupId[");
        localStringBuilder.append(this.k);
        localStringBuilder.append("], relationId[");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("], mGAudioRelationType[");
        localStringBuilder.append(this.l);
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
        localStringBuilder.append(this.V);
        localStringBuilder.append("], switchToGAudioMode[");
        localStringBuilder.append(((SessionInfo)???).aR);
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
        ((SessionInfo)???).aS = true;
        this.e.a().removeCallbacks(this.af);
        bool2 = ((SessionInfo)???).a();
        paramVarArgs = this.aF;
        if (paramVarArgs != null) {
          paramVarArgs.post(new VideoController.39(this, bool2));
        }
        if ((this.l == 1) && (((SessionInfo)???).o == 10)) {
          break label511;
        }
        if (this.l == 2)
        {
          if (paramLong2 == 0L) {
            bool2 = false;
          } else {
            bool2 = true;
          }
          ((SessionInfo)???).bh = bool2;
        }
      }
      bool2 = bool1;
      paramVarArgs = k();
      if ((!paramBoolean) && (l1 == Long.valueOf(this.e.getCurrentAccountUin()).longValue()))
      {
        long l5 = paramVarArgs.aN;
        l4 = paramLong1;
        if (l4 == l5)
        {
          a(paramInt, l4, 72);
          this.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
          return;
        }
      }
      l4 = paramLong1;
      a(paramAVUserInfo, paramBoolean);
      if (paramBoolean)
      {
        paramVarArgs.d("onGAudioUserEnterOrLeave", 2);
        if (paramVarArgs.i < 10) {
          if ((this.aQ.size() == 1) && (bool2))
          {
            paramVarArgs.a("onGAudioUserEnterOrLeave.1", 9);
            paramVarArgs.bo = false;
          }
          else
          {
            paramVarArgs.a("onGAudioUserEnterOrLeave.2", 10);
            Y();
          }
        }
        if ((paramVarArgs.aX != l1) && (l1 != l3)) {
          TipsUtil.b(this.e, 1047);
        }
        if (paramVarArgs.am)
        {
          if (!bool2) {
            paramVarArgs.a(l2, SystemClock.elapsedRealtime());
          }
        }
        else if (paramVarArgs.aw == 0L) {
          paramVarArgs.a(l2, SystemClock.elapsedRealtime());
        }
      }
    }
    for (;;)
    {
      synchronized (this.aQ)
      {
        if ((this.aQ.size() != 1) || (this.aQ.get(0) == null) || (((VideoController.GAudioFriends)this.aQ.get(0)).a != l3)) {
          break label1585;
        }
        i1 = 1;
        if (i1 != 0)
        {
          paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
          paramVarArgs.bo = true;
          ??? = QAVNotification.a(this.e);
          if ((??? != null) && (((QAVNotification)???).a()))
          {
            Z();
            p();
          }
        }
        TipsUtil.b(this.e, 1047);
        if (paramBoolean)
        {
          ??? = this.e;
          if (paramAVUserInfo.accountType == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool1) });
        }
        else if (paramLong2 == 1L)
        {
          g(true);
        }
        else if (paramLong2 == 0L)
        {
          ??? = this.e;
          if (paramAVUserInfo.accountType == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
        }
        else
        {
          ??? = this.e;
          bool1 = false;
          if (paramAVUserInfo.accountType == 0) {
            bool1 = true;
          }
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
        }
        if (paramVarArgs.am)
        {
          if ((paramBoolean) && (!bool2))
          {
            paramAVUserInfo = aF();
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
          paramAVUserInfo.putExtra("MultiAVType", paramVarArgs.o);
          paramAVUserInfo.setPackage(this.e.getApp().getPackageName());
          this.e.getApp().sendBroadcast(paramAVUserInfo);
          if (!paramBoolean)
          {
            if (paramVarArgs.an)
            {
              paramAVUserInfo = QAVNotification.a(this.e);
              Z();
              if (paramAVUserInfo.a()) {
                paramAVUserInfo.a(paramVarArgs.f);
              }
            }
            if (paramVarArgs.bz) {
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
            paramAVUserInfo.putExtra("isStart", this.ae);
          }
          else
          {
            paramAVUserInfo.putExtra("type", 23);
          }
          paramAVUserInfo.putExtra("roomUserNum", this.aQ.size());
          paramAVUserInfo.putExtra("relationType", paramInt);
          paramAVUserInfo.putExtra("relationId", l4);
          paramAVUserInfo.putExtra("friendUin", l1);
          paramAVUserInfo.putExtra("MultiAVType", k().o);
          paramAVUserInfo.putExtra("from", "VideoController5");
          paramAVUserInfo.setPackage(this.e.getApp().getPackageName());
          this.e.getApp().sendBroadcast(paramAVUserInfo);
        }
        return;
      }
      paramAVUserInfo = a;
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
    QLog.d(a, 2, "onVideoRecv ");
    Context localContext = i();
    if (localContext == null) {
      return;
    }
    WTogetherRealNameVideoProcessHelper localWTogetherRealNameVideoProcessHelper = this.e.B();
    localWTogetherRealNameVideoProcessHelper.a(this.e.getApp().getString(2131893612));
    localWTogetherRealNameVideoProcessHelper.b(new VideoController.38(this, paramLong1, paramLong2, paramInt1, paramLong3, paramInt2, localContext, localWTogetherRealNameVideoProcessHelper));
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, long paramLong3, int paramInt2)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = a;
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
    long l2 = Long.valueOf(this.e.getCurrentAccountUin()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean) && (paramLong2 != l2) && (paramInt1 == 3)) {
      return;
    }
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != CharacterUtil.b(this.e.getCurrentAccountUin())))
    {
      i1 = 0;
      while (i1 < k().bi.size())
      {
        if (((VideoViewInfo)k().bi.get(i1)).a == paramLong2)
        {
          i1 = ((VideoViewInfo)k().bi.get(i1)).b;
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
      this.e.a(new Object[] { Integer.valueOf(69), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    else
    {
      this.e.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i1), Long.valueOf(l1) });
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
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
    long l1 = AVUtil.c(this.e.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {
      localObject = SessionMgr.a(100, String.valueOf(paramLong1), new int[0]);
    } else {
      localObject = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]);
    }
    Object localObject = this.b.d((String)localObject);
    if (localObject != null) {
      ((SessionInfo)localObject).a(paramLong2, paramBoolean1, paramBoolean2);
    }
    a(paramLong2, paramBoolean1, paramInt1, paramBoolean2, paramInt2);
    if (paramBoolean1)
    {
      this.e.a(new Object[] { Integer.valueOf(77), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.e.a(new Object[] { Integer.valueOf(78), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    Object localObject1 = m(String.valueOf(paramLong1));
    Object localObject2;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onMemberVideoInOrOut-->Can not find the.Uin=");
        ((StringBuilder)localObject2).append(paramLong1);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    ((VideoController.GAudioFriends)localObject1).d = paramBoolean;
    if ((paramLong1 == Long.valueOf(this.e.getCurrentAccountUin()).longValue()) && (k().b(paramLong1, 1) != -1)) {
      return;
    }
    if (paramBoolean)
    {
      localObject2 = new VideoViewInfo();
      ((VideoViewInfo)localObject2).a = paramLong1;
      ((VideoViewInfo)localObject2).b = 1;
      if (k().b(paramLong1, ((VideoViewInfo)localObject2).b) != -1) {
        return;
      }
      ((VideoViewInfo)localObject2).g = paramLong2;
      if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
        ((VideoViewInfo)localObject2).g = 5L;
      }
      if (!k().w()) {
        ((VideoViewInfo)localObject2).c = true;
      } else {
        ((VideoViewInfo)localObject2).c = false;
      }
      if ((X() != 4) && (paramInt != 3))
      {
        if (k().b(Long.valueOf(this.e.getCurrentAccountUin()).longValue()) == -1) {
          ((VideoViewInfo)localObject2).e = true;
        } else {
          ((VideoViewInfo)localObject2).e = false;
        }
      }
      else {
        ((VideoViewInfo)localObject2).e = true;
      }
      if (((VideoController.GAudioFriends)localObject1).a == Long.valueOf(this.e.getCurrentAccountUin()).longValue())
      {
        ((VideoViewInfo)localObject2).d = true;
        ((VideoViewInfo)localObject2).f = true;
        ((VideoViewInfo)localObject2).e = true;
        if (!k().w()) {
          ((VideoViewInfo)localObject2).c = true;
        } else {
          ((VideoViewInfo)localObject2).c = false;
        }
      }
      else
      {
        ((VideoViewInfo)localObject2).d = false;
      }
      k().a((VideoViewInfo)localObject2, false);
      return;
    }
    if (paramInt == 2) {
      a(paramLong1, k().bi, k().bk, 1, false);
    } else if (paramInt == 1)
    {
      if (k().o == 10) {
        a(paramLong1, k().bi, k().bk, 1, false);
      } else {
        a(paramLong1, k().bi, k().bk, 0, true);
      }
    }
    else if (paramInt == 3) {
      a(paramLong1, k().bi, k().bk, 1, false);
    }
    ab();
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject1;
    if ((paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 == 2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
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
    if (paramLong == Long.valueOf(this.e.getCurrentAccountUin()).longValue()) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((!d()) && (paramLong == Long.valueOf(this.e.getCurrentAccountUin()).longValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "ScreenShare launcher shoult not display content");
      }
      return;
    }
    ??? = m(String.valueOf(paramLong));
    if (??? == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
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
        ((VideoController.GAudioFriends)???).e = 2;
      } else {
        ((VideoController.GAudioFriends)???).e = 1;
      }
      ((VideoViewInfo)localObject1).a = paramLong;
      ((VideoViewInfo)localObject1).b = 2;
      ((VideoViewInfo)localObject1).c = true;
      ((VideoViewInfo)localObject1).d = false;
      long l1;
      if (paramInt1 != 0) {
        l1 = 4L;
      } else {
        l1 = 5L;
      }
      ((VideoViewInfo)localObject1).g = l1;
      if (k().b(paramLong, ((VideoViewInfo)localObject1).b) != -1) {
        return;
      }
      if (k().bi.size() > 0)
      {
        ((VideoViewInfo)k().bi.get(0)).c = false;
        if (X() != 4)
        {
          paramInt1 = k().b(Long.valueOf(this.e.getCurrentAccountUin()).longValue());
          if (paramInt1 != -1) {
            ((VideoViewInfo)k().bi.get(paramInt1)).e = false;
          }
        }
      }
      ((VideoViewInfo)localObject1).e = true;
      if (k().bi.size() > 1)
      {
        VideoViewInfo localVideoViewInfo2 = (VideoViewInfo)k().bi.get(0);
        k().bi.set(0, localObject1);
        synchronized (k().bk)
        {
          k().bk.set(0, localObject1);
          k().a(localVideoViewInfo2, false);
          return;
        }
      }
      k().a(localVideoViewInfo1, true);
      return;
    }
    ((VideoController.GAudioFriends)???).e = 0;
    a(paramLong, k().bi, k().bk, 2, false);
    ab();
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = az();
    this.e.getApp().startActivity(paramIntent);
    if (localObject != null) {
      ((AVCallCompactHelper)localObject).a(paramIntent);
    }
    long l1 = 0L;
    localObject = this.aE;
    if (localObject != null) {
      l1 = ((InviteUIChecker)localObject).a(this.e, paramIntent, true);
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
    AVCallCompactHelper localAVCallCompactHelper = az();
    VideoUtils.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.e.getApp(), 2130772286, 0);
      this.e.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
    }
    else
    {
      this.e.getApp().startActivity(paramIntent);
    }
    QLog.w(a, 1, "startInvite startActivity");
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
    paramString = this.aE;
    if (paramString != null) {
      l1 = paramString.a(this.e, paramIntent, true);
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
    int i1 = k().bM;
    int i4 = 0;
    if (i1 == 3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (k().g == 4) {
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
      paramArrayList = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRequest_ShowVideo,in removeChildrenWithStytle infoLogs[");
      ((StringBuilder)localObject).append(a(k().bi));
      ((StringBuilder)localObject).append("]");
      QLog.w(paramArrayList, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = m(String.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberSpeak-->Can not find the.Uin=");
        localStringBuilder.append(paramLong);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return false;
    }
    ((VideoController.GAudioFriends)localObject).b = paramBoolean;
    ((VideoController.GAudioFriends)localObject).c = paramInt;
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  private void aI()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "initOrientationListener");
    }
    this.aB = new VideoController.4(this, i(), 3);
    if (this.aB.canDetectOrientation())
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "Can detect orientation");
      }
      this.aB.enable();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "Cannot detect orientation");
    }
    this.aB.disable();
    this.aB = null;
  }
  
  private boolean aJ()
  {
    Object localObject1 = (WindowManager)i().getSystemService("window");
    Object localObject2 = new DisplayMetrics();
    ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    int i1 = ((DisplayMetrics)localObject2).widthPixels;
    int i2 = ((DisplayMetrics)localObject2).heightPixels;
    int i3 = ((WindowManager)localObject1).getDefaultDisplay().getRotation();
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isLandscape screenWidth: ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", screenHeight: ");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(", rotation: ");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append(", orientation: ");
      ((StringBuilder)localObject2).append(this.aA);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((i1 <= i2) && (i3 != 1) && (i3 != 3))
    {
      i1 = this.aA;
      if (i1 != 4) {
        return i1 == 2;
      }
    }
    return true;
  }
  
  private void aK()
  {
    Object localObject = (AudioManager)this.f.getSystemService("audio");
    if (localObject != null)
    {
      long l1 = System.currentTimeMillis();
      boolean bool = ((AudioManager)localObject).isMicrophoneMute();
      if (bool) {
        ((AudioManager)localObject).setMicrophoneMute(false);
      }
      long l2 = System.currentTimeMillis();
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ---setMicrophoneMute:");
      localStringBuilder.append(bool);
      localStringBuilder.append("|");
      localStringBuilder.append(l2 - l1);
      AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    }
  }
  
  private void aL()
  {
    QAVPerf localQAVPerf = QAVPerf.a(this.e);
    localQAVPerf.b(i(), k());
    localQAVPerf.a(i(), k());
  }
  
  private void aM()
  {
    QAVPerf localQAVPerf = QAVPerf.a(this.e);
    localQAVPerf.b(k());
    localQAVPerf.a(k());
  }
  
  private void aN()
  {
    Object localObject = k();
    if ((this.U.mInviteGAudioUinList != null) && (this.U.mInviteGAudioUinList.size() > 0))
    {
      int i4 = this.U.mInviteGAudioUinList.size();
      long l1 = ((SessionInfo)localObject).aX;
      int i1 = 0;
      localObject = this.U;
      int i2 = this.r;
      ((QQGAudioCtrl)localObject).inviteUser(new long[] { l1 }, i2);
      int i5 = i4 - 1;
      localObject = new long[i5 * 2];
      int i3;
      for (i2 = 0; i1 < i4; i2 = i3)
      {
        i3 = i2;
        if (((Long)this.U.mInviteGAudioUinList.get(i1)).longValue() != l1)
        {
          i3 = i2;
          if (i2 < i5)
          {
            i3 = i2 * 2;
            localObject[i3] = 1L;
            localObject[(i3 + 1)] = ((Long)this.U.mInviteGAudioUinList.get(i1)).longValue();
            i3 = i2 + 1;
          }
        }
        i1 += 1;
      }
      this.U.inviteUser((long[])localObject, i5, null, 0, 0, false, false, 4);
    }
  }
  
  private void aO()
  {
    if (this.aS == null) {
      synchronized (this.ar)
      {
        if (this.aS == null)
        {
          this.aS = new EffectsRenderController(this.e);
          this.aS.g();
        }
        this.aS.a(this.aU);
        this.t.a(this.aS);
        return;
      }
    }
  }
  
  private void aP()
  {
    if (this.aV != null) {
      this.e.a().removeCallbacks(this.aV);
    }
    this.aV = null;
  }
  
  private void aQ()
  {
    if ((this.aw != -1L) && (System.currentTimeMillis() - this.aw < 10000L)) {
      return;
    }
    this.aw = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.e.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 20);
    localNewIntent.putExtra("vMsg", localReqEcho.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "checkNetStatus -->sendEcho");
    }
    this.n.a(localNewIntent);
  }
  
  private qav_gvideo_sdk_transfer.RespInfo b(int paramInt1, int paramInt2, long paramLong)
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
      localObject2 = a;
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
  
  private void b(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    if (this.aV != null) {
      this.e.a().removeCallbacks(this.aV);
    }
    this.aV = new VideoController.45(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
    this.e.a().postDelayed(this.aV, 1000L);
  }
  
  public static boolean b(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  private int c(long paramLong1, long paramLong2)
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.sendQueryRoomInfoRequest(paramLong1, paramLong2);
    }
    return -100;
  }
  
  public static boolean d()
  {
    return false;
  }
  
  private VideoController.OnCustomCompletionListener e(long paramLong)
  {
    if (this.aJ == null) {
      this.aJ = new VideoController.11(this);
    }
    this.e.a().postDelayed(this.aJ, 2000L);
    VideoController.OnCustomCompletionListener localOnCustomCompletionListener = this.H;
    localOnCustomCompletionListener.b = paramLong;
    return localOnCustomCompletionListener;
  }
  
  public static VideoController f()
  {
    if (D == null) {
      try
      {
        if (D == null) {
          D = new VideoController();
        }
      }
      finally {}
    }
    return D;
  }
  
  private SessionInfo h(int paramInt, String paramString)
  {
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = SessionMgr.a(3, paramString, new int[0]);
      localObject2 = SessionMgr.a().d((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = SessionMgr.a(100, paramString, new int[0]);
        localObject1 = SessionMgr.a().d((String)localObject1);
      }
    }
    else if (paramInt == 4)
    {
      localObject1 = SessionMgr.a(4, paramString, new int[0]);
      localObject1 = SessionMgr.a().d((String)localObject1);
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = SessionMgr.a().c(paramString);
    }
    return localObject2;
  }
  
  public static int n(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences(aR, 0);
    int i1 = ((SharedPreferences)localObject).getInt(paramString, 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, i1 + 1);
    ((SharedPreferences.Editor)localObject).commit();
    return i1;
  }
  
  private boolean x(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.s == null) {
        return false;
      }
      if (paramString.equals(localSessionInfo.s)) {
        return true;
      }
    }
    return false;
  }
  
  public int A()
  {
    return this.n.a;
  }
  
  void B()
  {
    VideoAppInterface localVideoAppInterface = this.e;
    if (localVideoAppInterface != null) {
      localVideoAppInterface.a().postDelayed(this.C, 25000L);
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "startConnectingTimer");
    }
  }
  
  void C()
  {
    VideoAppInterface localVideoAppInterface = this.e;
    if (localVideoAppInterface != null) {
      localVideoAppInterface.a().removeCallbacks(this.C);
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "stopConnectingTimer");
    }
  }
  
  public int D()
  {
    return this.aK;
  }
  
  public void E()
  {
    boolean bool = VcSystemInfo.isSupportSharpAudio();
    QLog.d(a, 1, String.format("initGAudioCtrl isSupportSharpAudio=%s mGAudioCtrl=%s ", new Object[] { Boolean.valueOf(bool), this.U }));
    if (!bool) {
      this.U = null;
    }
    try
    {
      if (this.U == null)
      {
        this.U = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.U != null)
        {
          long l1 = CharacterUtil.b(this.e.getCurrentAccountUin());
          int i1 = r();
          this.U.setNetChannel(this.n);
          this.U.setCallback(this);
          this.U.setAppId(this.e.getAppid());
          this.U.init(this.f, l1, 1);
          this.U.setApType(i1);
          if (!TextUtils.isEmpty(ClientLogReport.sGatewayIP)) {
            this.n.receiveGatewayMsg(ClientLogReport.sGatewayIP, ClientLogReport.sGatewayPort);
          }
          GAClientLogReport.instance();
          return;
        }
        QLog.e(a, 1, "initGAudioCtrl create instance fail.");
        d(1014);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a, 1, "initGAudioCtrl fail.", localThrowable);
      this.U = null;
      d(1014);
    }
  }
  
  public QQGAudioCtrl F()
  {
    return this.U;
  }
  
  public void G()
  {
    if (this.j)
    {
      long l1 = this.k;
      a(this.l, l1, 50);
      this.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public boolean H()
  {
    return this.V;
  }
  
  public void I()
  {
    this.e.a(new Object[] { Integer.valueOf(307) });
  }
  
  public void J()
  {
    if (!this.j) {
      k().a("clearGAudioState", 0);
    }
  }
  
  public void K()
  {
    long l1;
    if (this.j) {
      l1 = CharacterUtil.b(this.e.getCurrentAccountUin());
    }
    for (;;)
    {
      synchronized (this.aQ)
      {
        int i2 = this.aQ.size();
        i1 = 1;
        if ((i2 != 1) || (this.aQ.get(0) == null) || (l1 != ((VideoController.GAudioFriends)this.aQ.get(0)).a)) {
          break label117;
        }
        if (i1 != 0)
        {
          k().a("setGAudioState.1", 9);
          return;
        }
        k().a("setGAudioState.2", 10);
        return;
      }
      return;
      label117:
      int i1 = 0;
    }
  }
  
  public boolean L()
  {
    int i1;
    boolean bool1;
    boolean bool2;
    label254:
    synchronized (this.aQ)
    {
      int i2 = this.aQ.size();
      long l2 = System.currentTimeMillis();
      i1 = 0;
      bool1 = false;
      if (i1 < i2)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.aQ.get(i1);
        if (localGAudioFriends == null)
        {
          bool2 = bool1;
          break label254;
        }
        bool2 = bool1;
        if (!localGAudioFriends.r) {
          break label254;
        }
        long l3 = localGAudioFriends.t;
        long l1 = 2000L;
        if ((l3 >= 2000L) && (localGAudioFriends.t < this.u)) {
          l1 = localGAudioFriends.t;
        } else if (this.u >= 2000L) {
          l1 = this.u;
        }
        bool2 = bool1;
        if (l2 - localGAudioFriends.s <= l1) {
          break label254;
        }
        localGAudioFriends.r = false;
        localGAudioFriends.s = l2;
        if (QLog.isColorLevel())
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshUserNoiseState : has valid state uin = ");
          localStringBuilder.append(localGAudioFriends.a);
          localStringBuilder.append(",isSuspectNoisy = ");
          localStringBuilder.append(localGAudioFriends.r);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      else
      {
        return bool1;
      }
    }
  }
  
  public boolean M()
  {
    ??? = this.U;
    boolean bool = false;
    if (??? == null) {
      return false;
    }
    int i2;
    int i1;
    label166:
    synchronized (this.aQ)
    {
      i2 = this.aQ.size();
      long l1 = Long.valueOf(this.e.getCurrentAccountUin()).longValue();
      i1 = 0;
      if (i1 < i2)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.aQ.get(i1);
        if ((localGAudioFriends != null) && (localGAudioFriends.r)) {
          if (l1 == localGAudioFriends.a)
          {
            int i3 = D();
            a("setSuspectNoisyUserMicOff", this.k, false, true, -1);
            a(-1L, i3, D());
          }
          else
          {
            this.U.setMicByAdmin(localGAudioFriends.a, true);
            break label166;
            return bool;
          }
        }
      }
    }
  }
  
  public int N()
  {
    if (this.j)
    {
      QQGAudioCtrl localQQGAudioCtrl = this.U;
      if (localQQGAudioCtrl != null) {
        return localQQGAudioCtrl.getNetLevel();
      }
    }
    return -1;
  }
  
  public long O()
  {
    return this.Y;
  }
  
  public ArrayList<VideoController.GAudioFriends> P()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = U().iterator();
    VideoController.GAudioFriends localGAudioFriends;
    while (localIterator.hasNext())
    {
      localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      localArrayList.add(localGAudioFriends);
      localHashSet.add(Long.valueOf(localGAudioFriends.a));
    }
    localIterator = R().iterator();
    while (localIterator.hasNext())
    {
      localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(localGAudioFriends.a)))
      {
        localGAudioFriends.w = false;
        localArrayList.add(localGAudioFriends);
      }
    }
    return localArrayList;
  }
  
  public Pair<Integer, ArrayList<VideoController.GAudioFriends>> Q()
  {
    synchronized (this.aQ)
    {
      Object localObject1 = this.aQ;
      Object localObject4 = R();
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
        localGAudioFriends.w = true;
        localArrayList2.add(localGAudioFriends);
        ((Set)localObject3).add(Long.valueOf(localGAudioFriends.a));
      }
      int i1 = localArrayList2.size();
      localObject4 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (VideoController.GAudioFriends)((Iterator)localObject4).next();
        if (!((Set)localObject3).contains(Long.valueOf(((VideoController.GAudioFriends)localObject5).a)))
        {
          ((VideoController.GAudioFriends)localObject5).w = false;
          localArrayList2.add(localObject5);
        }
      }
      localObject3 = a;
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
  
  public ArrayList<VideoController.GAudioFriends> R()
  {
    if ((AudioHelper.a()) && (QavTestUtil.sGAudioVirtualList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.aO);
      localArrayList.addAll(QavTestUtil.sGAudioVirtualList);
      return localArrayList;
    }
    return this.aO;
  }
  
  public void S()
  {
    QLog.d(a, 1, "requestStartTimerOfMemberLists");
    this.e.a().removeCallbacks(this.aP);
    this.e.a().postDelayed(this.aP, 3000L);
  }
  
  public void T()
  {
    QLog.d(a, 1, "requestStopTimerOfMemberLists");
    this.e.a().removeCallbacks(this.aP);
  }
  
  public ArrayList<VideoController.GAudioFriends> U()
  {
    synchronized (this.aQ)
    {
      if ((AudioHelper.a()) && (QavTestUtil.sGAudioVirtualList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.aQ);
        localArrayList2.addAll(QavTestUtil.sGAudioVirtualList);
        return localArrayList2;
      }
      ArrayList localArrayList2 = this.aQ;
      return localArrayList2;
    }
  }
  
  public ArrayList<ResultRecord> V()
  {
    synchronized (this.aQ)
    {
      Object localObject2 = U();
      ArrayList localArrayList2 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject2).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = String.valueOf(localGAudioFriends.a);
        localArrayList2.add(localResultRecord);
      }
      return localArrayList2;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public ArrayList<VideoController.GAudioFriends> W()
  {
    if ((AudioHelper.a()) && (QavTestUtil.sGAudioVirtualList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.ah);
      localArrayList.addAll(QavTestUtil.sGAudioVirtualList);
      return localArrayList;
    }
    return this.ah;
  }
  
  public int X()
  {
    if (this.aG <= 0)
    {
      QQGAudioCtrl localQQGAudioCtrl = this.U;
      if (localQQGAudioCtrl != null) {
        this.aG = localQQGAudioCtrl.getVideoAbilityLevel();
      }
    }
    return this.aG;
  }
  
  public void Y()
  {
    if ((k().i == 4) || (k().i == 10) || (k().i == 14))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "Chatting Timer-->Start");
      }
      this.e.a().removeCallbacks(this.ai);
      this.e.a().postDelayed(this.ai, 1000L);
    }
  }
  
  public void Z()
  {
    this.e.a().removeCallbacks(this.ai);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((k().g != 1) && (k().g != 2)) {
      return -1;
    }
    return this.d.setAudioDataFormat(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramLong == 0L)
    {
      QLog.i(a, 1, "startGAudioChat, relationId illegal.");
      return -1;
    }
    if (this.U == null) {
      E();
    }
    AudioHelper.a(this.e);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("==> startGAudioChat() ********************************** isVideo = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append("  getSessionInfo().multiAVType = ");
    ((StringBuilder)localObject1).append(k().o);
    AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject1).toString());
    AudioHelper.b("startGAudioChat ");
    e(false);
    localObject1 = a;
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
    if (this.U != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("], mApp[");
    if (this.e != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.U == null) {
      return -1;
    }
    if (this.e == null) {
      return -1;
    }
    localObject1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (!this.b.a((String)localObject1))
    {
      localObject2 = this.b.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((SessionInfo)localObject2).aQ = paramInt1;
        ((SessionInfo)localObject2).o = paramInt2;
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.b.d((String)localObject1);
    }
    this.X = false;
    long l1 = CharacterUtil.b(this.e.getCurrentAccountUin());
    if ((paramInt1 != 7) && (paramInt1 != 9))
    {
      if (paramInt1 == 2)
      {
        if (k().H) {
          paramInt2 = 2;
        } else {
          paramInt2 = 1;
        }
        i1 = 1;
        break label579;
      }
      if (paramInt1 == 1)
      {
        i1 = k().o;
        if (k().H) {
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
            ((SessionInfo)localObject1).aN = paramLong;
            ((SessionInfo)localObject1).aQ = paramInt1;
            ((SessionInfo)localObject1).o = paramInt2;
            ((SessionInfo)localObject1).s = String.valueOf(paramLong);
            ((SessionInfo)localObject1).p = 0;
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
    localObject1 = k();
    if (paramBoolean) {
      paramInt2 = 2;
    }
    if ((((SessionInfo)localObject1).am) && (((SessionInfo)localObject1).aT)) {
      paramInt2 = 5;
    } else if (((SessionInfo)localObject1).b()) {
      paramInt2 = 3;
    }
    e();
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSessionInfo().localHasVideo = ");
      localStringBuilder.append(k().H);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    aK();
    this.e.g();
    this.e.h();
    this.U.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, r(), l1, k().b(), k().bP, k().bO, k().ci);
    if (this.af == null) {
      this.af = new VideoController.26(this, paramInt1, paramLong);
    }
    this.ae = true;
    ((SessionInfo)localObject1).a("startGAudioChat.2", 8);
    ((SessionInfo)localObject1).aN = paramLong;
    this.e.a().postDelayed(this.af, 30000L);
    w();
    a(((SessionInfo)localObject1).f, 3, false, false, false);
    return 0;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if ((k().g != 1) && (k().g != 2)) {
      return -1;
    }
    return this.d.registerAudioDataCallback(paramInt, paramBoolean);
  }
  
  public int a(long paramLong, int paramInt)
  {
    return this.d.sendSelectVideoModeRequest(paramLong, paramInt);
  }
  
  public int a(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(a);
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
    localStringBuilder.append(this.ae);
    localStringBuilder.append("], uinList[");
    boolean bool;
    if (paramArrayOfLong != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], mGAudioCtrl[");
    if (this.U != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w((String)???, 1, localStringBuilder.toString());
    AVBizModuleFactory.getModuleByName("音视频通话").requestAVFocus();
    if (this.U == null) {
      E();
    }
    if (this.U == null) {
      return -1;
    }
    o(false);
    e(false);
    this.X = false;
    synchronized (this.aQ)
    {
      this.aQ.clear();
      k().a("acceptGAudioChat", 8);
      k().aN = paramLong2;
      k().bq = true;
      k().bC = true;
      paramLong1 = CharacterUtil.b(this.e.getCurrentAccountUin());
      int i1;
      int i2;
      if (paramInt == 2)
      {
        if (k().H) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        i2 = 1;
      }
      else if (paramInt == 1)
      {
        i2 = k().o;
        if (k().H) {
          i1 = 2;
        } else {
          i1 = 1;
        }
      }
      else if (paramInt == 3)
      {
        i1 = 1;
        i2 = 8;
      }
      else
      {
        i1 = 2;
        i2 = 2;
      }
      if (paramBoolean) {
        i1 = 2;
      }
      if (AudioHelper.e())
      {
        ??? = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("acceptGAudioChat, MainSession[");
        localStringBuilder.append(k());
        localStringBuilder.append("]");
        QLog.w((String)???, 1, localStringBuilder.toString());
      }
      this.e.g();
      this.e.h();
      this.U.acceptGAudio(paramInt, i2, i1, paramLong2, paramArrayOfLong, r(), paramLong1, k().bO);
      GInviteTimeOutHelper.a().b();
      if (this.af == null) {
        this.af = new VideoController.27(this, paramInt, paramLong2);
      }
      this.ae = false;
      this.e.a().postDelayed(this.af, 30000L);
      w();
      return 0;
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo acceptRequest, peerUin[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("], businessType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], relationType[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], uiMode[");
    ((StringBuilder)localObject2).append(this.y);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    AVBizModuleFactory.getModuleByName("音视频通话").requestAVFocus();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d(a, 1, "acceptRequest fail,network not support");
      return -2;
    }
    localObject1 = this.d;
    int i1 = -1;
    if (localObject1 == null)
    {
      QLog.d(a, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    localObject1 = aG();
    if ((localObject1 != null) && (1 == ((JniSimpleInfoMng)localObject1).a(AVUtil.c(paramString), false, false))) {
      AVUtil.a("0X800B62B", 0, 0, "", "", "", "");
    }
    localObject2 = h(paramInt2, paramString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = k();
    }
    o(false);
    this.e.g();
    this.e.h();
    if (paramInt1 == 0) {
      i1 = this.d.acceptVideo(paramString, 0L, r(), 0, paramInt2);
    } else if (1 == paramInt1) {
      i1 = this.d.acceptVideo(paramString, 0L, r(), 2, paramInt2);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = a;
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
      B();
    }
    this.n.a();
    ((VideoNodeReporter)this.e.c(4)).a(k().D(), 9, 1L);
    VideoNodeManager.a(37);
    return i1;
  }
  
  public int a(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10)
  {
    String str = paramString1;
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo request, selfUin[");
    ((StringBuilder)localObject2).append(LogUtil.getSafePrintUin(this.e.getCurrentAccountUin()));
    ((StringBuilder)localObject2).append("], peerUin[");
    ((StringBuilder)localObject2).append(LogUtil.getSafePrintUin(paramString1));
    ((StringBuilder)localObject2).append("], businessType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], relationType[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], fromNation[");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("], fromMobile[");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append("], toMobile[");
    ((StringBuilder)localObject2).append(paramString4);
    ((StringBuilder)localObject2).append("], uinType[");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append("], extraUin[");
    ((StringBuilder)localObject2).append(paramString5);
    ((StringBuilder)localObject2).append("], sig[");
    boolean bool;
    if (paramArrayOfByte != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("], bindID[");
    ((StringBuilder)localObject2).append(paramString8);
    ((StringBuilder)localObject2).append("], bindType[");
    ((StringBuilder)localObject2).append(paramInt4);
    ((StringBuilder)localObject2).append("], subServiceType[");
    ((StringBuilder)localObject2).append(paramInt5);
    ((StringBuilder)localObject2).append("], mStartRing[");
    ((StringBuilder)localObject2).append(this.am);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    AudioHelper.a(this.e);
    if (paramArrayOfByte != null)
    {
      paramString1 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("request sigLength: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      QLog.d(paramString1, 2, ((StringBuilder)localObject1).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e(a, 1, "request fail, network not support!");
      return -2;
    }
    if (this.d == null)
    {
      QLog.e(a, 1, "request fail,controller is null!");
      return -1;
    }
    localObject1 = str;
    if (paramInt3 == 1006)
    {
      localObject1 = str;
      if (str.startsWith("+")) {
        localObject1 = str.substring(1);
      }
    }
    int i1 = a(paramInt3, true, 1);
    if (i1 == -1)
    {
      paramString1 = a;
      paramString2 = new StringBuilder();
      paramString2.append("request fail, accostType = ");
      paramString2.append(i1);
      QLog.e(paramString1, 1, paramString2.toString());
      return -1;
    }
    paramString1 = k();
    if ((paramString1.h()) && (paramString1.s != null) && (((String)localObject1).equals(paramString1.s)))
    {
      QLog.e(a, 1, "request fail,----already receive invite, return~");
      paramString1.B = true;
      return -1;
    }
    if (paramInt3 == 9500)
    {
      this.n.b("request");
    }
    else
    {
      this.n.c();
      this.az = true;
    }
    long l1;
    if (paramString1.br)
    {
      l1 = paramString1.bt;
      str = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("request, startTerminalSwitchTimeOutCheck, oldRoomId[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w(str, 1, ((StringBuilder)localObject2).toString());
      u();
    }
    else
    {
      l1 = 0L;
    }
    str = BaseApplicationImpl.getApplication().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request funcall buffer:");
      localStringBuilder.append(str);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.e.g();
    this.e.h();
    ((VideoNodeReporter)this.e.c(4)).a(-1L, 2, 1L);
    VideoNodeManager.a(28);
    VideoNodeManager.a(11, (String)localObject1);
    VideoNodeManager.a(12, 1L);
    long l2;
    if (paramString1.aK) {
      l2 = 1L;
    } else {
      l2 = 2L;
    }
    VideoNodeManager.a(13, l2);
    VideoNodeManager.a(15, 1L);
    aK();
    if ((paramString1.p != 1011) && (paramString1.p != 21))
    {
      if (paramInt3 == 9500)
      {
        paramInt4 = 4200;
        try
        {
          l1 = CharacterUtil.b((String)localObject1);
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
          paramString1.aK = false;
          this.d.setApType(r());
          paramInt1 = this.d.requestFromUnQQ(l1, paramInt1, paramInt2, paramInt4);
        }
        catch (NumberFormatException paramString1)
        {
          paramString1.printStackTrace();
          QLog.e(a, 1, "request fail,NumberFormatException ", paramString1);
          return -1;
        }
      }
      else
      {
        if (paramInt1 != 0) {
          break label1200;
        }
        paramString1.aK = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = C2BUserInfo.a(paramString10);
          if (paramString10 != null)
          {
            QLog.e(a, 2, "requestVideo new number");
            paramInt1 = this.d.requestVideo((String)localObject1, 0L, r(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9, paramString10);
          }
          else
          {
            QLog.e(a, 2, "requestVideo new number is null");
            paramInt1 = this.d.requestVideo((String)localObject1, 0L, r(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
          }
        }
        else
        {
          paramInt1 = this.d.requestVideo((String)localObject1, 0L, r(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
        }
      }
      break label1374;
      label1200:
      if (1 == paramInt1)
      {
        paramString1.aK = false;
        paramString10 = this.d;
        int i2 = r();
        paramInt1 = paramString10.requestVideo((String)localObject1, 0L, i2, paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      }
      else
      {
        paramInt1 = -1;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "request Anychat Mode ");
      }
      paramString1.aK = true;
      if (Long.valueOf(this.e.getCurrentAccountUin()).longValue() > Long.valueOf((String)localObject1).longValue()) {
        paramInt1 = this.d.requestVideo((String)localObject1, 0L, r(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      } else {
        paramInt1 = 0;
      }
    }
    label1374:
    AVReport.a().aj = paramString1.aK;
    paramString2 = a;
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
      paramString1.p = paramInt3;
      paramString1.r = i1;
      if ((paramString1.g != 3) && (paramString1.g != 4)) {
        paramString1.a(paramLong, SystemClock.elapsedRealtime());
      }
      w();
      if (paramString1.aK) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      a(paramString1.f, paramInt2, false, false, true);
      paramString1.W = -1;
      this.S = false;
      a(paramLong, paramString1.s);
      p();
    }
    paramString1.bp = false;
    a((String)localObject1, 2, paramString1.A);
    a((String)localObject1, 1, 0L);
    paramString1 = new StringBuilder();
    paramString1.append(VideoNodeManager.f());
    paramString1.append("");
    b("deviceMemory", paramString1.toString());
    b("manufacturer", Build.MANUFACTURER);
    b("qqVersion", AppSetting.a(i()));
    if (this.aI != null) {
      this.aI.b();
    }
    this.aI = new VideoCallStateMonitor(this.e, (String)localObject1);
    return paramInt1;
  }
  
  public int a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    if (paramList != null) {
      paramList = (NetAddr[])paramList.toArray(new NetAddr[paramList.size()]);
    } else {
      paramList = null;
    }
    return this.d.sendRecordingRequest(paramLong1, paramBoolean, paramList, paramLong2);
  }
  
  public int a(SessionInfo paramSessionInfo, String paramString)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl != null) {
      return localQQGAudioCtrl.getRoomUserTerminalType(paramSessionInfo, paramString);
    }
    return -1;
  }
  
  int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(AudioHelper.c(), paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((VideoNodeReporter)this.e.c(4)).b();
    }
    else
    {
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.q.clear();
    }
    this.p = paramBoolean;
    return 0;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = k().j();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendAVAvatar2DSwitchRequest, isConnected[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (!bool) {
      return 0;
    }
    return this.d.sendAVAvatar2DSwitchRequest(k().s, paramBoolean, paramInt1, paramInt2, paramString);
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (this.d == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, String.format("setAudioInputMute enable=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    VideoRecoveryMonitor localVideoRecoveryMonitor = this.e.d();
    if (localVideoRecoveryMonitor != null) {
      localVideoRecoveryMonitor.c();
    }
    return this.d.setAudioInputMute(paramString, paramBoolean);
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = b(paramInt1, paramInt2, paramLong);
    if (QLog.isColorLevel())
    {
      String str = a;
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
    long l1 = paramSessionInfo.D();
    int i1 = paramSessionInfo.g;
    if ((i1 != 1) && (i1 != 2)) {
      return l1;
    }
    return p(paramSessionInfo.s);
  }
  
  public Bitmap a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e.c(paramString1)) {
      paramInt = 0;
    } else if (paramInt == 1) {
      paramInt = 1000;
    } else {
      paramInt = 1004;
    }
    return this.e.a(paramInt, paramString1, paramString2, paramBoolean2, paramBoolean1);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProcessInfo peerUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",key = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",value = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", isAllSessionIdle = ");
      localStringBuilder.append(this.b.e());
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
        QLog.e(a, 2, Log.getStackTraceString(paramString1));
        l1 = l2;
      }
    }
    if ((this.d != null) && (!this.b.e()))
    {
      this.d.updateProcessInfo(l1, paramString2, paramString3);
      if (QLog.isColorLevel())
      {
        paramString1 = a;
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
  
  public qav_gvideo_sdk_transfer.RespInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    qav_gvideo_sdk_transfer.RespInfo localRespInfo = new qav_gvideo_sdk_transfer.RespInfo();
    Object localObject = this.U;
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
        localObject = a;
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
      if (this.e.c(paramString1)) {
        paramInt = 0;
      }
    }
    return this.e.a(paramInt, paramString1, paramString2);
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
    long l2 = this.e.getLongAccountUin();
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
        if (((VideoController.GAudioFriends)localObject2).a == l2) {
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
      if (((VideoController.GAudioFriends)localObject2).a == l2) {
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
      long l3 = ((VideoController.GAudioFriends)localArrayList1.get(paramInt)).a;
      if (l3 != l2) {
        if (this.e.c(String.valueOf(l3))) {
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
      paramArrayList = a;
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
      l2 = ((VideoController.GAudioFriends)localArrayList1.get(i1)).a;
      if (this.e.c(String.valueOf(l2))) {
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
    paramArrayList = a;
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
    synchronized (this.aQ)
    {
      int i2 = this.aQ.size();
      ArrayList localArrayList2 = new ArrayList();
      long l1 = System.currentTimeMillis();
      i1 = 0;
      if (i1 < i2)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.aQ.get(i1);
        if (localGAudioFriends == null) {
          break label170;
        }
        if (localGAudioFriends.a == paramLong1)
        {
          if (!localGAudioFriends.p)
          {
            localGAudioFriends.r = paramBoolean;
            localGAudioFriends.s = l1;
            localGAudioFriends.t = paramLong2;
          }
          else if (localGAudioFriends.r)
          {
            localGAudioFriends.r = false;
          }
          if (!localGAudioFriends.r) {
            break label170;
          }
          localArrayList2.add(Long.valueOf(localGAudioFriends.a));
          break label170;
        }
      }
      else
      {
        return localArrayList2;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onApnChanged netType = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.h != paramInt)
    {
      this.h = paramInt;
      if (paramInt == 0) {
        this.e.a().postDelayed(this.B, 60000L);
      } else {
        this.e.a().removeCallbacks(this.B);
      }
      if (this.U != null)
      {
        int i1 = r();
        this.U.setApType(i1);
      }
      if ((this.d != null) && ((paramInt == 1) || (paramInt == 2))) {
        this.d.setApType(r());
      }
      this.e.a(new Object[] { Integer.valueOf(21), Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.u = paramInt3;
    Object localObject;
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      localObject = this.aF;
      if (localObject != null) {
        ((MqqHandler)localObject).post(new VideoController.31(this, paramInt1, paramInt2, paramInt3));
      }
    }
    else
    {
      localObject = this.U;
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
      String str = a;
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
    if (this.e != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartDoubleVideoMeeting");
      localIntent.putExtra("sessionType", paramInt1);
      localIntent.putExtra("uinType", paramInt2);
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("isReceiver", true);
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    label2176:
    try
    {
      l1 = AudioHelper.c();
      localVideoAppInterface = this.e;
      str1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
      if (paramInt1 == 3) {
        str1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
      }
      localObject3 = this.b.d(str1);
      if (!QLog.isColorLevel()) {
        break label224;
      }
      ??? = a;
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
      ??? = this.aX;
      if ((??? != null) && (((ScreenRecordHelper)???).e())) {
        ((ScreenRecordHelper)???).b(4);
      }
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "quitGAudioChat, check screen share and stop.");
      }
    }
    ??? = localVideoAppInterface.A();
    if (??? != null) {
      ((ChatRoomMng)???).b((SessionInfo)localObject3);
    }
    localVideoAppInterface.a().removeCallbacks(this.af);
    this.af = null;
    if (this.R != null)
    {
      localVideoAppInterface.a().removeCallbacks(this.R);
      this.R = null;
    }
    ??? = this.U;
    if (??? == null) {
      return;
    }
    localVideoAppInterface.a(new Object[] { Integer.valueOf(203), String.valueOf(paramLong), Boolean.valueOf(this.c), Long.valueOf(l1) });
    if ((k().bm.size() > 0) && (k().bh))
    {
      a(2, 0, 0, 0L);
      if ((paramInt1 == 2) && (!((SessionInfo)localObject3).bh) && (((SessionInfo)localObject3).bm != null))
      {
        ??? = new Intent();
        ((Intent)???).setAction("tencent.av.v2q.MultiVideo");
        ((Intent)???).putExtra("type", 411);
        ((Intent)???).putExtra("phoneList", k().bm);
        ((Intent)???).putExtra("relationType", k().aQ);
        ((Intent)???).putExtra("relationId", k().aN);
        ((Intent)???).putExtra("MultiAVType", k().o);
        ((Intent)???).putExtra("from", "VideoController2");
        ((Intent)???).setPackage(localVideoAppInterface.getApp().getPackageName());
        localVideoAppInterface.getApp().sendBroadcast((Intent)???);
      }
      if (paramInt1 == 2)
      {
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject3).aD)) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE5", "0X8004CE5", 0, 0, "", "", "", "");
        }
        if (H()) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE8", "0X8004CE8", 0, 0, "", "", "", "");
        }
        if (((SessionInfo)localObject3).H)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CEB", "0X8004CEB", 0, 0, "", "", "", "");
          if (!((SessionInfo)localObject3).L) {
            ReportController.b(null, "CliOper", "", "", "0X8004CEF ", "0X8004CEF ", 0, 0, "", "", "", "");
          }
        }
      }
      else if (paramInt1 == 1)
      {
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject3).aD)) {
          if (((SessionInfo)localObject3).o == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005942", "0X8005942", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8004F54", "0X8004F54", 0, 0, "", "", "", "");
          }
        }
        if (H()) {
          if (((SessionInfo)localObject3).o == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005943", "0X8005943", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8004F55", "0X8004F55", 0, 0, "", "", "", "");
          }
        }
        if (((SessionInfo)localObject3).H)
        {
          if (((SessionInfo)localObject3).o == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005944", "0X8005944", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8004F56", "0X8004F56", 0, 0, "", "", "", "");
          }
          if (!((SessionInfo)localObject3).L) {
            if (((SessionInfo)localObject3).o == 10) {
              ReportController.b(null, "CliOper", "", "", "0X8005945 ", "0X8005945 ", 0, 0, "", "", "", "");
            } else {
              ReportController.b(null, "CliOper", "", "", "0X8004F57 ", "0X8004F57 ", 0, 0, "", "", "", "");
            }
          }
        }
      }
      bool = this.ag;
      l3 = 0L;
      if ((!bool) || (z() <= 0L)) {
        break label2146;
      }
      ReportController.b(null, "CliOper", "", "", "0X8008B2F ", "0X8008B2F ", 0, 0, "", "", UITools.a(z()), "");
      break label2146;
      if ((!VcControllerImpl.sIsSpecialDevice) && (paramInt2 != 69) && (paramInt2 != 70) && (paramInt2 != 71))
      {
        this.U.quitRoom(i1);
        break label2176;
      }
      this.aN = -1000001;
      if (this.aF != null) {
        this.aF.post(new VideoController.28(this, i1));
      }
      try
      {
        synchronized (this.aM)
        {
          this.aM.wait(2000);
        }
        if (!this.j) {
          break label1409;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        if (this.aN == -1000001) {
          i1 = 261;
        }
        ??? = a;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("GAudioCtrl.quitRoom end. continue. mQuitResult = ");
        ((StringBuilder)localObject5).append(this.aN);
        QLog.d((String)???, 1, ((StringBuilder)localObject5).toString());
      }
      if ((((SessionInfo)localObject3).i == 9) && (!((SessionInfo)localObject3).bo)) {
        l2 = 0L;
      } else {
        l2 = z();
      }
      a("quitGAudioChat", false);
      c("quitGAudioChat", 1);
      synchronized (this.aQ)
      {
        if ((this.aQ.size() != 0) || (this.j) || (this.k != 0L)) {
          break label2179;
        }
        i2 = 1;
        int i3 = this.aQ.size();
        this.aQ.clear();
        a("quitGAudioChat", false, 0, 0L);
        ((SessionInfo)localObject3).aS = false;
        this.U.mIsSwitchGroup = false;
        ??? = localVideoAppInterface.getCurrentAccountUin();
        if (??? != null) {
          l3 = CharacterUtil.b((String)???);
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
        ((Intent)localObject5).putExtra("MultiAVType", ((SessionInfo)localObject3).o);
        ((Intent)localObject5).putExtra("time", l2);
        ((Intent)localObject5).putExtra("isStart", this.ae);
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
          localObject5 = a;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("quitGAudioChat, send broadcast of quitRoom chatting, seq[");
          localStringBuilder2.append(l2);
          localStringBuilder2.append("]");
          QLog.w((String)localObject5, 1, localStringBuilder2.toString());
        }
        ((SessionInfo)localObject3).b("quitGAudioChat", null);
        ((SessionInfo)localObject3).aF = null;
        x();
        if (((SessionInfo)localObject3).bi.size() > 0) {
          localVideoAppInterface.a(new Object[] { Integer.valueOf(104), ((SessionInfo)localObject3).bi });
        }
        if (((SessionInfo)localObject3).aQ == 1) {
          localVideoAppInterface.a(new Object[] { Integer.valueOf(410), Long.valueOf(paramLong) });
        }
        localObject5 = ((SessionInfo)localObject3).aW;
        if (((SessionInfo)localObject3).aQ == 1) {
          break label2188;
        }
        if (((SessionInfo)localObject3).aQ == 2)
        {
          if (((SessionInfo)localObject3).H) {
            localVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
          }
          ((SessionInfo)localObject3).b(l1, false);
        }
        ((SessionInfo)localObject3).d(l1);
        SessionFlag.a().b();
        this.A.b();
        v();
        TipsUtil.b(l1, localVideoAppInterface);
        if (i2 == 0)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("quitGAudioChat_");
          localStringBuilder2.append(paramInt2);
          a(localStringBuilder2.toString(), str2, UITools.c(paramInt1), (String)???, String.valueOf(paramLong), 7, (String)localObject5, false, false);
        }
        ((SessionInfo)localObject3).p = -1;
        ((SessionInfo)localObject3).O = true;
        bool = this.b.a(l1, str2);
        localObject3 = QAVNotification.a(localVideoAppInterface);
        if ((localObject3 != null) && (((QAVNotification)localObject3).a()))
        {
          ((QAVNotification)localObject3).a(str2);
          if (bool) {
            p();
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
    long l1 = AudioHelper.c();
    Object localObject = a;
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
    localStringBuilder.append(this.j);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramLong == 0L) {
      return;
    }
    localObject = k();
    if ((localObject != null) && (((SessionInfo)localObject).H)) {
      this.e.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
    int i1 = UITools.c(paramInt1);
    a(k().f, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
    if (this.j)
    {
      a(paramInt1, paramLong, 71);
    }
    else
    {
      localObject = this.e.getCurrentAccountUin();
      a("onGAudioSDKError", str, i1, (String)localObject, String.valueOf(paramLong), 7, (String)localObject, false, false);
      if (this.af != null)
      {
        this.e.a().removeCallbacks(this.af);
        this.af = null;
      }
    }
    a("onGAudioSDKError_2");
    localObject = this.v;
    if (localObject != null) {
      ((TraeHelper)localObject).a(l1);
    }
    this.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
    this.b.a(l1, str);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.e.a(new Object[] { Integer.valueOf(502), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    this.e.a(new Object[] { Integer.valueOf(500), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt, SdkAudioFrameCallback paramSdkAudioFrameCallback)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Record setAudioFrameCallback, type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", callback=");
    localStringBuilder.append(paramSdkAudioFrameCallback);
    QLog.i(str, 1, localStringBuilder.toString());
    if (paramInt >= 2) {
      return;
    }
    if (this.aD == null) {
      this.aD = new SdkAudioFrameCallback[2];
    }
    this.aD[paramInt] = paramSdkAudioFrameCallback;
  }
  
  public void a(int paramInt, String paramString)
  {
    VcControllerImpl localVcControllerImpl = this.d;
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
    if (this.e != null)
    {
      Object localObject1 = a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendAnotherChatingBroadcast session:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(", peerUin:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("， roomid：");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if (paramInt2 != 3) {}
      localObject1 = this.b;
      localObject1 = SessionMgr.a(SessionMgr.a(paramInt1), paramString, new int[0]);
      localObject2 = this.b.d((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = k();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((SessionInfo)localObject1).h == paramInt2) && (paramString.equalsIgnoreCase(((SessionInfo)localObject1).s)) && (((SessionInfo)localObject1).B)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((SessionInfo)localObject1).az);
      ((Intent)localObject2).putExtra("bindId", ((SessionInfo)localObject1).aB);
      ((Intent)localObject2).putExtra("roomId", paramLong);
      ((Intent)localObject2).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
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
    if (this.e != null)
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
      ((Intent)localObject).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
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
    if (this.e != null)
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
      ((Intent)localObject).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
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
    if (this.e != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setPackage(this.e.getApp().getPackageName());
      ((Intent)localObject).setAction("tencent.video.v2q.AddMsgSig");
      ((Intent)localObject).putExtra("uinType", paramInt);
      ((Intent)localObject).putExtra("peerUin", paramString1);
      ((Intent)localObject).putExtra("extraUin", paramString2);
      ((Intent)localObject).putExtra("sig", paramArrayOfByte);
      this.e.getApp().sendBroadcast((Intent)localObject);
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
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSubState2 seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    TraeHelper.a(this.e, true, paramLong);
    Object localObject1 = k();
    C();
    ((SessionInfo)localObject1).a("onSubState2", 4);
    ((SessionInfo)localObject1).a(paramLong, SystemClock.elapsedRealtime());
    if (this.e.f() > 0) {
      this.e.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
    } else {
      p();
    }
    if (((SessionInfo)localObject1).E) {
      a(true, ((SessionInfo)localObject1).s);
    } else {
      a(false, ((SessionInfo)localObject1).s);
    }
    this.e.a().postDelayed(new VideoController.8(this, paramLong), 50L);
    a(((SessionInfo)localObject1).f, ((SessionInfo)localObject1).g, true, true, true);
    DataReport.i(this);
    DataReport.d(this, true);
    DataReport.c(this, true);
    Object localObject2 = this.e.A();
    if (localObject2 != null) {
      ((ChatRoomMng)localObject2).a((SessionInfo)localObject1);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.e.a(new Object[] { Integer.valueOf(15001), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRing, listener[");
      localStringBuilder.append(paramOnCompletionListener);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.v.b(paramLong);
    if (!this.v.a(paramLong, this.e, paramInt1, null, paramInt2, paramOnCompletionListener))
    {
      AVLog.printAllUserLog(a, "exit !mTraeHelper.startRing");
      a(k().s, 212);
      b(212);
      b(k().s, k().ay);
    }
    if (k().aL)
    {
      AVLog.printAllUserLog(a, "exit getSessionInfo().isPeerOnPhone");
      a(k().s, 213);
      b(213);
      b(k().s, k().ay);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, -1, false);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    TraeHelper.a().d();
    String str;
    if (paramInt1 == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    } else {
      str = SessionMgr.a(paramInt1, String.valueOf(paramLong2), new int[0]);
    }
    Object localObject1 = this.b.d(str);
    if (this.U != null)
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
        localObject2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ignoreGAudioChat, Can't Support Ignore");
        localStringBuilder.append(paramInt1);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        i1 = 0;
      }
      this.U.ignore(paramInt1, paramLong2, i1);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a);
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
    this.e.j = false;
    ((SessionInfo)localObject1).bq = true;
    if (((SessionInfo)localObject1).i == 7)
    {
      ((SessionInfo)localObject1).a("ignoreGAudioChat", 0);
      if (paramInt2 == -1) {
        paramInt2 = 3;
      }
    }
    else
    {
      if (paramInt2 != -1) {
        break label350;
      }
    }
    paramInt2 = 4;
    label350:
    x();
    int i1 = UITools.c(paramInt1);
    localObject2 = this.e.getCurrentAccountUin();
    if (paramInt2 == 10) {
      a("ignoreGAudioChat_1", ((SessionInfo)localObject1).f, UITools.c(paramInt1), this.e.getCurrentAccountUin(), String.valueOf(((SessionInfo)localObject1).aN), 5, ((SessionInfo)localObject1).aW, false, false);
    } else if (paramInt1 == 3) {
      a("ignoreGAudioChat_2", str, i1, ((SessionInfo)localObject1).s, String.valueOf(paramLong2), paramInt2, ((SessionInfo)localObject1).aW, paramBoolean, false);
    } else {
      a("ignoreGAudioChat_3", str, i1, (String)localObject2, String.valueOf(paramLong2), paramInt2, ((SessionInfo)localObject1).aW, paramBoolean, false);
    }
    d(paramInt2);
    GInviteTimeOutHelper.a().b();
    paramBoolean = this.b.a(paramLong1, str);
    localObject1 = QAVNotification.a(this.e);
    if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
    {
      ((QAVNotification)localObject1).a(str);
      if (paramBoolean) {
        p();
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
    if ((paramInt != 4) && (paramInt != 3) && (((paramInt != 2) && (paramInt != 1)) || (!k().am))) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject1 = a;
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
      localObject2 = this.U;
      if (localObject2 != null) {
        if (paramBoolean2)
        {
          if (paramBoolean1)
          {
            if (((IGraphicRender)localObject1).getDecodePtrRef() > 0) {
              ((IGraphicRender)localObject1).decreaseDecoderPtrRef();
            }
            if (((IGraphicRender)localObject1).getDecodePtrRef() == 0) {
              this.U.setProcessDecoderFrameFunctionptr(0L);
            }
          }
          else
          {
            ((IGraphicRender)localObject1).increaseDecodePtrRef();
            if (((IGraphicRender)localObject1).getDecodePtrRef() == 1)
            {
              paramLong = ((IGraphicRender)localObject1).getRecvDecoderFrameFunctionPtr();
              this.U.setProcessDecoderFrameFunctionptr(paramLong);
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
      localObject2 = this.d;
      if (localObject2 != null)
      {
        if (paramBoolean2)
        {
          if (!paramBoolean1) {
            paramLong = ((IGraphicRender)localObject1).getRecvDecoderFrameFunctionPtr();
          }
          this.d.setProcessDecoderFrameFunctionptr(paramLong);
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
    if (p(k().s) == paramLong2) {
      k().bx = true;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvAudioReady uin = ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",roomid = ");
    localStringBuilder.append(paramLong2);
    QLog.d(str, 1, localStringBuilder.toString());
    this.e.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    String str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject1 = this.b.d(str);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        str = a;
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
      a(str, 0, true, ((SessionInfo)localObject1).s, ((SessionInfo)localObject1).s);
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
    ((Intent)localObject2).putExtra("MultiAVType", ((SessionInfo)localObject1).o);
    ((Intent)localObject2).putExtra("from", "VideoController4");
    ((Intent)localObject2).setPackage(this.e.getApp().getPackageName());
    this.e.getApp().sendBroadcast((Intent)localObject2);
    boolean bool = this.b.a(paramLong1, str);
    localObject1 = QAVNotification.a(this.e);
    if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
    {
      ((QAVNotification)localObject1).a(str);
      if (bool) {
        p();
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl == null)
    {
      QLog.w(a, 2, "onGroupSystemMsgCome()  mGAudioCtrl == null !!    return !");
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
        if ((this.j) && (this.k == paramLong1))
        {
          k().bg = false;
          this.e.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
        }
      }
      else
      {
        this.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      }
    }
    else
    {
      if (paramBoolean) {
        localQQGAudioCtrl.modifyGroupAdmin(paramLong2, true);
      }
      if ((this.j) && (this.k == paramLong1))
      {
        k().bg = true;
        this.e.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    SessionInfo localSessionInfo = k();
    if (localSessionInfo.g == 2)
    {
      if ((localSessionInfo.ai != 2) && (localSessionInfo.ai != 3)) {
        return;
      }
      this.e.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioInviteRespFail, groupId[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("], err[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], msg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramLong1 == this.k) {
      QQToast.makeText(i(), 2131893433, 1).show();
    }
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    this.e.a().post(new VideoController.34(this, paramArrayList, paramLong1, paramLong2));
  }
  
  @TargetApi(21)
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("quitDoubleVideoMeeting, relationId[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.aX;
    if (localObject1 != null) {
      ((ScreenRecordHelper)localObject1).b(4);
    }
    localObject1 = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject2 = this.b.d((String)localObject1);
    if (localObject2 == null) {
      return;
    }
    Object localObject3 = new Intent();
    ((Intent)localObject3).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject3).putExtra("type", 402);
    ((Intent)localObject3).putExtra("relationType", 3);
    ((Intent)localObject3).putExtra("relationId", paramLong2);
    ((Intent)localObject3).putExtra("friendUin", paramLong2);
    ((Intent)localObject3).putExtra("MultiAVType", ((SessionInfo)localObject2).o);
    ((Intent)localObject3).putExtra("from", "VideoController6");
    SeqUtil.a((Intent)localObject3, paramLong1);
    ((Intent)localObject3).setPackage(this.e.getApp().getPackageName());
    this.e.getApp().sendBroadcast((Intent)localObject3);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(paramLong2);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong2);
    a((String)localObject1, 0, paramInt, true, (String)localObject3, localStringBuilder.toString(), false);
    if (((SessionInfo)localObject2).H) {
      this.e.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
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
      a(paramLong1, 2131230813, 1, this.J);
      this.I = new VideoController.40(this);
      this.e.a().postDelayed(this.I, 2000L);
    }
    localObject1 = aF();
    if (localObject1 != null) {
      ((ScreenShareCtrl)localObject1).b(paramLong2);
    }
  }
  
  void a(long paramLong, String paramString)
  {
    if (this.am != null) {
      this.e.a().removeCallbacks(this.am);
    }
    this.am = new VideoController.StartRingRunnable(this, paramString);
    paramString = this.am;
    if (paramString != null)
    {
      paramString.b = paramLong;
      this.e.a().postDelayed(this.am, 6000L);
    }
  }
  
  void a(long paramLong, String paramString, int paramInt)
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo onCloseVideo fromUin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], type[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], mStartRing[");
    ((StringBuilder)localObject).append(this.am);
    ((StringBuilder)localObject).append("]");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
    aP();
    str = SessionMgr.a(3, paramString, new int[0]);
    if (this.b.a(str))
    {
      localObject = this.b.d(str);
    }
    else
    {
      str = SessionMgr.a(100, paramString, new int[0]);
      localObject = this.b.d(str);
    }
    if (localObject == null)
    {
      AVLog.printErrorLog(a, "onCloseVideo fail to find session");
      return;
    }
    ((SessionInfo)localObject).m = false;
    if (this.aI != null)
    {
      this.aI.b();
      this.aI = null;
    }
    this.s = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    C();
    if ((((SessionInfo)localObject).aq == 1L) && ((paramInt == 2) || (paramInt == 24))) {
      a(paramLong, str, paramString, 3);
    } else {
      a(paramLong, str, paramString, paramInt);
    }
    if (((SessionInfo)localObject).h())
    {
      ((SessionInfo)localObject).ay = paramInt;
      if ((((SessionInfo)localObject).h()) && (paramInt == ((SessionInfo)localObject).g)) {
        ((SessionInfo)localObject).a(paramLong, 0L);
      }
      ((SessionInfo)localObject).a("onCloseVideo.isBeInviting", 6);
      this.e.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(((SessionInfo)localObject).s, ((SessionInfo)localObject).ay);
    }
    else if (((SessionInfo)localObject).f())
    {
      ((SessionInfo)localObject).ay = paramInt;
      ((SessionInfo)localObject).a(paramLong, 0L);
      int i1 = 2131230813;
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
              i1 = 2131230812;
            }
          }
          ((SessionInfo)localObject).a("onCloseVideo.isInviting", 6);
          a(paramLong, 2131230813, 1, e(paramLong));
          this.e.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
          return;
        }
        if (((SessionInfo)localObject).aq != 2L)
        {
          ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
        }
        else
        {
          i2 = 1;
          i1 = 2131230813;
          break label665;
        }
      }
      else
      {
        ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
      }
      int i2 = 0;
      i1 = 2131230812;
      label665:
      this.G.b = paramLong;
      if (i2 != 0) {
        i2 = 4;
      } else {
        i2 = 3;
      }
      a(paramLong, i1, i2, this.G);
      ((SessionInfo)localObject).a("onCloseVideo.isInviting1", 5);
      this.e.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
    }
    else if (!((SessionInfo)localObject).m())
    {
      ((SessionInfo)localObject).ay = paramInt;
      if (((SessionInfo)localObject).h()) {
        ((SessionInfo)localObject).a(paramLong, 0L);
      }
      ((SessionInfo)localObject).a("onCloseVideo.isClosing1", 6);
      if (PhoneStatusTools.e(this.e.getApp()))
      {
        a(((SessionInfo)localObject).s, 209);
        b(209);
        b(((SessionInfo)localObject).s, ((SessionInfo)localObject).ay);
      }
      else
      {
        a(paramLong, 2131230813, 1, e(paramLong));
        QAVNotification.a(this.e).a(str);
      }
      this.e.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
    }
    if (this.am != null)
    {
      paramString = this.e;
      if (paramString != null) {
        paramString.a().removeCallbacks(this.am);
      }
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.ag = g();
    boolean bool2 = SmallScreenUtils.d(this.e.getApplication().getApplicationContext());
    long l1 = p(paramString2);
    Object localObject1 = a;
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
    ((StringBuilder)localObject2).append(this.ag);
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
    if ((paramBoolean1) && (!ConfigSystemImpl.c(this.e.getApp())))
    {
      a(paramLong, paramString2, 0, paramBoolean2);
      b(paramString2, 0);
      return;
    }
    localObject2 = this.b.d(paramString1);
    if (localObject2 == null)
    {
      QLog.w(a, 1, "processVideoRequest, sessionInfo为空");
      return;
    }
    ((SessionInfo)localObject2).B = true;
    ((SessionInfo)localObject2).aK = paramBoolean1;
    ((SessionInfo)localObject2).a("processVideoRequest.1", 2);
    ((SessionInfo)localObject2).bp = false;
    ((SessionInfo)localObject2).cc = System.currentTimeMillis();
    AVReport.a().aj = ((SessionInfo)localObject2).aK;
    boolean bool1;
    if ((!paramBoolean3) && (!VideoUtils.a()) && (!this.e.t()))
    {
      localObject1 = new Intent(this.e.getApp().getApplicationContext(), VideoInviteActivity.class);
      if (NoDisturbUtil.a(this.e.getApp().getApplicationContext(), this.e)) {
        ((Intent)localObject1).addFlags(262144);
      }
      bool1 = true;
    }
    else
    {
      localObject1 = new Intent(this.e.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
      ((Intent)localObject1).putExtra("isScreenLocked", a(this.e.getApp().getApplicationContext()));
      bool1 = false;
    }
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("uinType", paramInt1);
    ((Intent)localObject1).putExtra("relationType", UITools.b(paramInt1));
    ((Intent)localObject1).putExtra("session_id", paramString1);
    ((Intent)localObject1).putExtra("peerUin", paramString2);
    ((Intent)localObject1).putExtra("extraUin", paramString3);
    ((Intent)localObject1).putExtra("isAudioMode", paramBoolean1);
    ((Intent)localObject1).putExtra("curUserStatus", this.F);
    ((Intent)localObject1).putExtra("isDoubleVideoMeeting", paramBoolean2);
    ((Intent)localObject1).putExtra("bindType", paramInt2);
    if (((SessionInfo)localObject2).a(this.e))
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "processVideoRequest block notify video msg");
      }
    }
    else
    {
      paramString1 = aG();
      if (paramString1 != null)
      {
        paramInt1 = paramString1.a(JniSimpleInfoMng.a(paramString2), false, true);
        ((WTogetherMng)this.e.c(17)).a(3, paramString2, paramInt1);
      }
      if (a(this.e.getApp().getApplicationContext()))
      {
        a((Intent)localObject1, paramString2, bool1, true);
      }
      else if ((this.ag) && (bool2))
      {
        if ((!paramBoolean3) && (!VideoUtils.a()))
        {
          paramString1 = new VideoInviteFloatBarUICtr(this, this.e, (Intent)localObject1);
          paramString1.d();
          paramString1.a(paramLong, (Intent)localObject1);
        }
        else
        {
          paramString1 = new MultiIncomingCallUICtr(this, this.e, (Intent)localObject1);
          paramString1.d();
          paramString1.a((Intent)localObject1);
        }
        QLog.w(a, 1, "processVideoRequest startActivity when GameMode");
        b("mode", "1");
        t(paramString2);
        a(paramString2, "screenState", String.valueOf(1));
      }
      else
      {
        a((Intent)localObject1, paramString2, bool1, false);
      }
      w();
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelVideoChat, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isDoubleMetting[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mVcCtrl[");
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.d == null) {
      return;
    }
    localObject = aG();
    if ((localObject != null) && (1 == ((JniSimpleInfoMng)localObject).a(AVUtil.c(paramString), false, false))) {
      AVUtil.a("0X800B62C", 0, 0, "", "", "", "");
    }
    this.v.b(paramLong);
    localObject = this.v;
    TraeHelper.b(this.e);
    int i1 = -99;
    if (!paramBoolean)
    {
      i1 = this.d.rejectVideo(paramString, r(), paramInt);
      ((VideoNodeReporter)this.e.c(4)).a(k().D(), 10, 1L);
      if ((k().s != null) && (k().s.equals(paramString))) {
        VideoNodeManager.a(k().D(), 38);
      } else {
        VideoNodeManager.a(p(paramString), 38);
      }
    }
    paramString = a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelVideoChat, result[");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString, 1, ((StringBuilder)localObject).toString());
    x();
    C();
    if (this.n.d()) {
      SmartDeviceReport.a(null, "Usr_TV_Video", 3, 0, 0);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = this.b.d(paramString1);
    String str = a;
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
    if ((localSessionInfo != null) && ((!localSessionInfo.bp) || (localSessionInfo.l)))
    {
      int i1 = this.b.d(paramString1).p;
      localObject = localSessionInfo.u;
      str = paramString2;
      if (!TextUtils.isEmpty(localSessionInfo.s))
      {
        str = paramString2;
        if (localSessionInfo.s.contains(paramString2)) {
          str = localSessionInfo.s;
        }
      }
      if (this.n.d()) {
        if (this.az) {
          i1 = 0;
        } else {
          i1 = 9500;
        }
      }
      boolean bool;
      if (localSessionInfo.h == 2) {
        bool = true;
      } else {
        bool = false;
      }
      if (!this.e.m())
      {
        a(paramString1, i1, paramInt, bool, str, (String)localObject, false);
        if ((paramInt == 12) && (!TextUtils.isEmpty(k().w))) {
          a(paramString1, i1, 66, bool, str, (String)localObject, false);
        }
      }
      else if (localSessionInfo.l)
      {
        a(paramString1, i1, paramInt, bool, str, (String)localObject, false);
      }
      if (this.j) {
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, str, (String)localObject, 1, k().aW, false, true);
      } else if (this.e.m()) {
        a("sendDoubleChatMsgToMQQ_2", paramString1, i1, str, (String)localObject, 2, this.b.d(paramString1).aW, true, true);
      } else {
        a("sendDoubleChatMsgToMQQ_3", paramString1, i1, str, (String)localObject, 0, this.b.d(paramString1).aW, false, true);
      }
      localSessionInfo.bp = true;
      localSessionInfo.l = false;
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
    a(paramString1, paramString2, UITools.c(paramInt), this.e.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.b.a(paramLong, paramString2);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((this.j) && (k().aN == paramLong) && (paramArrayOfString != null))
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      if (this.e.getCurrentAccountUin().equals(paramString)) {
        return;
      }
      this.e.a(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
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
    if (paramArrayList == k().bk)
    {
      localArrayList = k().bk;
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (i1 < paramArrayList.size())
        {
          if (((VideoViewInfo)paramArrayList.get(i1)).a != paramLong) {
            break label119;
          }
          if (paramBoolean)
          {
            a(paramArrayList, i1);
            k().C();
          }
          else
          {
            if (paramInt != ((VideoViewInfo)paramArrayList.get(i1)).b) {
              break label119;
            }
            a(paramArrayList, i1);
            k().C();
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
        if (((VideoViewInfo)paramArrayList1.get(i1)).a == paramLong)
        {
          if (paramBoolean)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((VideoViewInfo)paramArrayList1.get(i1)).b)
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
  
  void a(long paramLong, boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = a;
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
    SessionInfo localSessionInfo = this.b.d(str);
    Object localObject = localSessionInfo;
    if (localSessionInfo == null) {
      localObject = this.b.a(str, false);
    }
    ((SessionInfo)localObject).p = paramInt1;
    ((SessionInfo)localObject).az = paramInt2;
    ((SessionInfo)localObject).aB = paramString3;
    ((SessionInfo)localObject).B = true;
    a(str, ((SessionInfo)localObject).p, paramBoolean2 ^ true, paramString1, paramString2);
    if (paramBoolean1)
    {
      long l1;
      try
      {
        l1 = CharacterUtil.b(paramString1);
      }
      catch (NumberFormatException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "", paramString1);
        }
        l1 = -1L;
      }
      a(paramLong, 3, l1);
    }
    else
    {
      this.d.rejectVideo(paramString1, r(), 65536);
    }
    SessionMgr.a().a(paramLong, str);
  }
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean, int paramInt)
  {
    long l1 = paramArrayOfLong[0];
    if (QLog.isColorLevel())
    {
      localObject = a;
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
    this.e.a(new Object[] { Integer.valueOf(63), Long.valueOf(l1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
    Object localObject = new Intent("tencent.video.v2q.memberSpeaking");
    ((Intent)localObject).putExtra("groupId", paramLong);
    ((Intent)localObject).putExtra("uinList", paramArrayOfLong);
    ((Intent)localObject).putExtra("isSpeaking", paramBoolean);
    ((Intent)localObject).putExtra("audioEnergy", paramInt);
    this.e.getApplication().sendBroadcast((Intent)localObject);
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, int paramInt)
  {
    paramGAudioFriends.e = 0;
    paramGAudioFriends.d = false;
    paramGAudioFriends.f = false;
    paramGAudioFriends.g = false;
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
                paramGAudioFriends = a;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("setVideoSrcType-->wrong type of videosrctype,type=");
                localStringBuilder.append(paramInt);
                QLog.e(paramGAudioFriends, 2, localStringBuilder.toString());
              }
            }
            else {
              paramGAudioFriends.g = true;
            }
          }
          else {
            paramGAudioFriends.f = true;
          }
        }
        else {
          paramGAudioFriends.e = 1;
        }
      }
      else {
        paramGAudioFriends.d = true;
      }
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.e != null)
    {
      this.e = paramVideoAppInterface;
      return;
    }
    this.n.a(paramVideoAppInterface);
    this.e = paramVideoAppInterface;
    this.f = paramVideoAppInterface.getApp().getApplicationContext();
    Object localObject = new VideoController.3(this);
    paramVideoAppInterface.a().post((Runnable)localObject);
    if (!NetworkUtil.isNetSupport(i())) {
      this.h = 0;
    } else if (NetworkUtil.isWifiEnabled(i())) {
      this.h = 1;
    } else {
      this.h = 2;
    }
    h();
    if ((this.ao == 0) && (SmallScreenUtils.e(paramVideoAppInterface.getApp()))) {
      this.ao = 1;
    }
    this.v = TraeHelper.a(this.f, this);
    if (this.aC) {
      aI();
    }
    localObject = this.d;
    if (localObject != null) {
      ((VcControllerImpl)localObject).updateProcessInfo(0L, "qqVersion", AppSetting.a(i()));
    }
    localObject = this.aS;
    if (localObject != null) {
      ((EffectsRenderController)localObject).a(paramVideoAppInterface);
    }
  }
  
  void a(AVUserInfo paramAVUserInfo, boolean paramBoolean)
  {
    ArrayList localArrayList = this.aQ;
    if (paramBoolean) {}
    try
    {
      if (d(paramAVUserInfo.account) != -1) {
        return;
      }
      Object localObject = new VideoController.GAudioFriends();
      ((VideoController.GAudioFriends)localObject).a = paramAVUserInfo.account;
      ((VideoController.GAudioFriends)localObject).n = paramAVUserInfo.accountType;
      this.aQ.add(localObject);
      break label213;
      int i1 = d(paramAVUserInfo.account);
      StringBuilder localStringBuilder1 = null;
      if (i1 != -1)
      {
        localObject = (VideoController.GAudioFriends)this.aQ.remove(i1);
      }
      else
      {
        localObject = localStringBuilder1;
        if (QLog.isColorLevel())
        {
          localObject = a;
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("onMemberInOrOut-->can not find the member.userInfo = ");
          localStringBuilder2.append(paramAVUserInfo);
          QLog.e((String)localObject, 2, localStringBuilder2.toString());
          localObject = localStringBuilder1;
        }
      }
      a(paramAVUserInfo.account, k().bi, k().bk, 0, true);
      ab();
      if ((localObject != null) && (!((VideoController.GAudioFriends)localObject).p) && (((VideoController.GAudioFriends)localObject).r)) {
        onGAudioUserAudioSuspectNoisy(0L, false, 0L);
      }
      label213:
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onMemberInOrOut, size[");
        localStringBuilder1.append(this.aQ.size());
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
      localObject1 = a;
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
    Object localObject2 = this.aO.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)((Iterator)localObject2).next()).a));
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = a;
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
      if (((submsgtype0x116.MemberInfo)localObject3).uint64_member_uin.get() == this.e.getLongAccountUin()) {
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
          ((VideoController.GAudioFriends)localObject2).n = 0;
          ((VideoController.GAudioFriends)localObject2).a = ((submsgtype0x116.MemberInfo)localObject3).uint64_member_uin.get();
          ((VideoController.GAudioFriends)localObject2).w = false;
          ((VideoController.GAudioFriends)localObject2).x = ((submsgtype0x116.MemberInfo)localObject3).uint32_invite_timestamp.get();
          this.aO.add(localObject2);
          if (QLog.isColorLevel())
          {
            localObject3 = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mMemberChangeEventReceiver add member UIN:");
            localStringBuilder.append(((VideoController.GAudioFriends)localObject2).a);
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
      localObject2 = this.aO.iterator();
      do
      {
        i2 = paramInt1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramPBRepeatMessageField1 = (VideoController.GAudioFriends)((Iterator)localObject2).next();
      } while (paramPBRepeatMessageField1.a != ((submsgtype0x116.MemberInfo)localObject1).uint64_member_uin.get());
      this.aO.remove(paramPBRepeatMessageField1);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i2 = paramInt1;
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mMemberChangeEventReceiver remove member UIN:");
        ((StringBuilder)localObject2).append(paramPBRepeatMessageField1.a);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        i2 = paramInt1;
      }
      i1 += 1;
      paramInt1 = i2;
    }
    if (paramInt1 != 0) {
      this.e.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.aO });
    }
  }
  
  public void a(Class paramClass)
  {
    InviteUIChecker localInviteUIChecker = this.aE;
    if (localInviteUIChecker != null) {
      localInviteUIChecker.a(paramClass.getName());
    }
  }
  
  void a(Long paramLong, long paramLong1, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
    if (paramLong1 != Long.valueOf(this.e.getCurrentAccountUin()).longValue()) {
      return;
    }
    if (paramBoolean)
    {
      k().bf = true;
      this.e.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    k().bf = false;
    this.e.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelNetWorkTimer[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.aH = false;
    paramString = this.e;
    if (paramString != null) {
      paramString.a().removeCallbacks(this.B);
    }
    PopupDialog.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    long l1 = AudioHelper.c();
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo closeVideo begin, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], emCloseReason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], mStartRing[");
    localStringBuilder.append(this.am);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    if (this.e == null) {
      return;
    }
    PerfReporter.b(k());
    PerfReporter.b();
    aM();
    if (this.b.e()) {
      return;
    }
    if (this.am != null)
    {
      this.e.a().removeCallbacks(this.am);
      this.am = null;
    }
    SignalStrengthReport.a(i()).b();
    if (this.d == null) {
      return;
    }
    if (this.aI != null) {
      this.aI.b();
    }
    ((WTogetherMng)this.e.c(17)).a(3, paramString);
    boolean bool2 = false;
    this.s = false;
    int i1 = this.d.closeVideo(paramString, paramInt, this);
    localObject = this.e.d();
    if (localObject != null) {
      ((VideoRecoveryMonitor)localObject).a(paramInt);
    }
    localObject = SessionMgr.a().b().s;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString))) {
      aC();
    }
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    localObject = k().s;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bool1 = bool2;
      if (((String)localObject).equalsIgnoreCase(paramString))
      {
        this.e.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
        if (k().I)
        {
          paramString = VideoLayerUI.a(paramString, 1);
          GraphicRenderMgr.setGlRender(paramString, null);
          if (QLog.isColorLevel())
          {
            localObject = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("avideo closeVideo, clear gl render, key[");
            localStringBuilder.append(paramString);
            localStringBuilder.append("]");
            QLog.i((String)localObject, 2, localStringBuilder.toString());
          }
          a(l1, k().g, true, true);
        }
        d(paramInt);
        QAVNotification.a(this.e.getApplication().getApplicationContext());
        bool1 = true;
      }
    }
    paramString = a;
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
    this.d.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    String str = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sendVideoMsgBroadcast uinType: ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", msgType: ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", friendUin: ");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(", selfUin: ");
    Object localObject1 = this.e;
    if (localObject1 == null) {
      localObject1 = Integer.valueOf(0);
    } else {
      localObject1 = ((VideoAppInterface)localObject1).getCurrentAccountUin();
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(", isReceiver = ");
    ((StringBuilder)localObject2).append(k().B);
    ((StringBuilder)localObject2).append(", isVideoMsg = ");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append(", extraUin: ");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append(", forceUnread:");
    ((StringBuilder)localObject2).append(paramBoolean2);
    QLog.d(str, 1, ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty(paramString2)) && (!"0".equals(paramString2)))
    {
      if (this.e != null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("tencent.video.v2q.AddVideoMsg");
        SessionInfo localSessionInfo = this.b.d(paramString1);
        if (localSessionInfo == null)
        {
          QLog.d(a, 1, "sendVideoMsgBroadcast() -> session == null, return!");
          return;
        }
        if (paramInt2 == 21)
        {
          if ((localSessionInfo.j != 11) && (localSessionInfo.j != 12)) {
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
          if ((localSessionInfo.j != 16) && (localSessionInfo.j != 17)) {
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
        ((Intent)localObject2).putExtra("bindType", localSessionInfo.az);
        ((Intent)localObject2).putExtra("bindId", localSessionInfo.aB);
        ((Intent)localObject2).putExtra("isDoubleVideoMeeting", localSessionInfo.am);
        ((Intent)localObject2).putExtra("MultiAVType", localSessionInfo.o);
        if (paramInt1 == 17) {
          ((Intent)localObject2).putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.e.getCurrentAccountUin();
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
              if (localSessionInfo.B) {
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
              } while (!localSessionInfo.B);
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
        if (localSessionInfo.am) {
          if (localSessionInfo.ap) {
            paramString2 = paramString1;
          } else {
            paramString2 = (String)localObject1;
          }
        }
        ((Intent)localObject2).putExtra("friendUin", (String)localObject1);
        ((Intent)localObject2).putExtra("senderUin", paramString2);
        ((Intent)localObject2).putExtra("selfUin", paramString1);
        ((Intent)localObject2).putExtra("isSender", localSessionInfo.B ^ true);
        paramString1 = null;
        if (localSessionInfo.aw > 0L) {
          paramString1 = UITools.a(z());
        }
        if (QLog.isColorLevel())
        {
          paramString2 = a;
          paramString3 = new StringBuilder();
          paramString3.append("getConnectedTime():");
          paramString3.append(z());
          paramString3.append(" extra:");
          paramString3.append(paramString1);
          QLog.d(paramString2, 2, paramString3.toString());
        }
        ((Intent)localObject2).putExtra("extra", paramString1);
        ((Intent)localObject2).setPackage(this.e.getApp().getPackageName());
        this.e.getApp().sendBroadcast((Intent)localObject2);
      }
      return;
    }
    paramString1 = a;
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
    if (this.e != null)
    {
      if (AudioHelper.e())
      {
        localObject1 = a;
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
      Object localObject1 = new Intent();
      ((Intent)localObject1).setAction("tencent.av.v2q.StartVideoChat");
      ((Intent)localObject1).putExtra("sessionType", paramInt);
      ((Intent)localObject1).putExtra("sessionId", paramString);
      Object localObject2 = this.b;
      if (localObject2 != null)
      {
        paramString = ((SessionMgr)localObject2).d(paramString);
        if (paramString != null)
        {
          ((Intent)localObject1).putExtra("uinType", paramString.p);
          if (paramString.p == 26) {
            ((Intent)localObject1).putExtra("peerUin", paramString.u);
          } else {
            ((Intent)localObject1).putExtra("peerUin", paramString.s);
          }
          if ((paramInt == 3) || (paramInt == 4))
          {
            ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramString.aN));
            ((Intent)localObject1).putExtra("relationType", paramString.aQ);
            ((Intent)localObject1).putExtra("relationId", paramString.aN);
          }
          ((Intent)localObject1).putExtra("extraUin", paramString.u);
          ((Intent)localObject1).putExtra("bindType", paramString.az);
          ((Intent)localObject1).putExtra("bindId", paramString.aB);
          ((Intent)localObject1).putExtra("isReceiver", paramString.B);
          ((Intent)localObject1).putExtra("isDoubleVideoMeeting", paramString.am);
          if (!paramString.B) {
            AVBizModuleFactory.getModuleByName("音视频通话").requestAVFocus();
          }
        }
      }
      ((Intent)localObject1).putExtra("updateTime", paramBoolean1);
      ((Intent)localObject1).putExtra("isDouble", paramBoolean3);
      ((Intent)localObject1).putExtra("showTime", paramBoolean2);
      ((Intent)localObject1).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject1);
    }
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel())
    {
      paramString = a;
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
    if (this.U != null)
    {
      MqqHandler localMqqHandler = this.aF;
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
    paramLong = CharacterUtil.b(this.e.getCurrentAccountUin());
    for (;;)
    {
      synchronized (this.aQ)
      {
        if (this.aQ.size() > 1)
        {
          paramInt = 1;
          if ((!paramBoolean1) && (paramInt != 0)) {
            a(this.k, new long[] { paramLong }, paramBoolean1, 0);
          }
          return;
        }
      }
      paramInt = 0;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((SessionMgr)localObject1).d(paramString2);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.e;
    if (localObject2 == null) {
      localObject2 = "mApp is null";
    } else {
      localObject2 = ((VideoAppInterface)localObject2).getCurrentAccountUin();
    }
    String str = a;
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
    if ((this.e != null) && (localObject1 != null))
    {
      if (this.d == null) {
        return;
      }
      paramString1 = new Intent();
      paramString1.setPackage(this.e.getApp().getPackageName());
      paramString1.setAction("tencent.av.v2q.StopVideoChat");
      paramString1.putExtra("sessionId", paramString2);
      paramString1.putExtra("uinType", paramInt1);
      paramString1.putExtra("bindType", ((SessionInfo)localObject1).az);
      paramString1.putExtra("bindId", ((SessionInfo)localObject1).aB);
      paramString1.putExtra("peerUin", paramString3);
      paramString1.putExtra("sessionType", ((SessionInfo)localObject1).g);
      paramString1.putExtra("isDoubleVideoMeeting", ((SessionInfo)localObject1).am);
      paramString1.putExtra("extraUin", paramString4);
      paramString1.putExtra("stopReason", paramInt2);
      paramString1.putExtra("isSystemCalling", paramBoolean1);
      paramString1.putExtra("isDouble", paramBoolean2);
      paramString1.putExtra("selfUin", this.e.getCurrentAccountUin());
      paramString1.putExtra(VideoConstants.l, ((SessionInfo)localObject1).aw);
      paramString1.putExtra(VideoConstants.m, SystemClock.elapsedRealtime());
      paramString1.putExtra(VideoConstants.n, this.d.getSdkVersion());
      paramString1.putExtra("score_connect_duration", z());
      paramInt1 = ((SessionInfo)localObject1).g;
      long l2 = 1L;
      if ((paramInt1 != 1) && (((SessionInfo)localObject1).g != 2)) {
        l1 = 0L;
      } else {
        l1 = 1L;
      }
      if ((((SessionInfo)localObject1).g == 3) || (((SessionInfo)localObject1).g == 4)) {
        l1 = 2L;
      }
      paramString1.putExtra(VideoConstants.q, l1);
      long l1 = l2;
      if (((SessionInfo)localObject1).g != 1) {
        if (((SessionInfo)localObject1).g == 3) {
          l1 = l2;
        } else {
          l1 = 0L;
        }
      }
      paramString1.putExtra(VideoConstants.r, l1);
      if (this.b.d(paramString2).aa != null) {
        paramString1.putExtra("actId", this.b.d(paramString2).aa);
      }
      if (this.b.d(paramString2).ab != null) {
        paramString1.putExtra("mp_ext_params", this.b.d(paramString2).ab);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.b.d(paramString2).aQ);
        paramString1.putExtra("relationId", this.b.d(paramString2).aN);
      }
      else
      {
        DoodleLogic.b().m.a();
      }
      if (TextUtils.isEmpty(paramString5)) {
        paramString1.putExtra("senderUin", "");
      } else {
        paramString1.putExtra("senderUin", paramString5);
      }
      this.e.getApp().sendBroadcast(paramString1);
      AVBizModuleFactory.getModuleByName("音视频通话").abandonAVFocus();
      AVBizModuleFactory.removeModuleByName("音视频通话");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGAudioMute, [");
      localStringBuilder.append(this.V);
      localStringBuilder.append(" --> ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.V = paramBoolean;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((this.j != paramBoolean) || (this.l != paramInt) || (this.k != paramLong) || (QLog.isColorLevel())) {
      QLog.i(a, 1, String.format("updateCurJoinGRoomInfo, from[%s], [%s, %s, %s] --> [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(this.j), Integer.valueOf(this.l), Long.valueOf(this.k), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    this.j = paramBoolean;
    this.k = paramLong;
    this.l = paramInt;
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (k().g != 2) {
      return;
    }
    try
    {
      this.e.a(new Object[] { Integer.valueOf(10002), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public void a(boolean paramBoolean, int paramInt, int... paramVarArgs)
  {
    long l1 = AudioHelper.c();
    paramVarArgs = k();
    if (paramVarArgs.i == 0) {
      return;
    }
    Object localObject = QAVNotification.a(this.e);
    if (localObject != null) {
      ((QAVNotification)localObject).a(paramVarArgs.f);
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeMainSession, mGAudioInRoom[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], isDoubleVideoMeeting[");
    localStringBuilder.append(paramVarArgs.am);
    localStringBuilder.append("], \nsession[");
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("], \nseq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((paramVarArgs.g != 3) && (paramVarArgs.g != 4))
    {
      if ((paramVarArgs.g == 1) || (paramVarArgs.g == 2))
      {
        if ((paramVarArgs.i != 2) && (paramVarArgs.i != 13))
        {
          if (paramVarArgs.am)
          {
            if (paramBoolean) {
              this.e.a(new Object[] { Integer.valueOf(28), paramVarArgs.s, Boolean.valueOf(true) });
            }
            a(l1, Long.valueOf(paramVarArgs.s).longValue(), true, 0);
            return;
          }
          a(paramVarArgs.s, paramInt);
          b(paramVarArgs.s, 0);
          a(l1, 2, true, true);
          return;
        }
        if (paramVarArgs.am)
        {
          a(l1, paramVarArgs.s, 1, true);
          long l2 = Long.valueOf(paramVarArgs.s).longValue();
          a(l1, 3, l2);
          a(l1, l2, 1);
          return;
        }
        a(l1, paramVarArgs.s, 1, false);
        a(paramVarArgs.s, paramInt);
        b(paramVarArgs.s, 0);
      }
    }
    else if (this.j)
    {
      if (paramBoolean) {
        this.e.a(new Object[] { Integer.valueOf(28), String.valueOf(paramVarArgs.aN), Boolean.valueOf(true) });
      }
      if (paramVarArgs.am)
      {
        a(l1, this.k, true, 0);
        return;
      }
      a(this.l, this.k, 30);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SessionInfo localSessionInfo = k();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPhoneCalling, isSelf[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], isCalling[");
    localStringBuilder.append(localSessionInfo.q);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], deviceName[");
    localStringBuilder.append(localSessionInfo.aD);
    localStringBuilder.append("], audioStateBeforePhoneCall[");
    localStringBuilder.append(localSessionInfo.bn);
    localStringBuilder.append("], mTraeHelper[");
    boolean bool;
    if (this.v != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.v == null) {
      return;
    }
    if ((localSessionInfo.i != 0) && (localSessionInfo.i != 5) && (localSessionInfo.i != 6) && (localSessionInfo.q != paramBoolean2))
    {
      localSessionInfo.q = paramBoolean2;
      if (paramBoolean2)
      {
        this.v.d();
        localSessionInfo.bn = localSessionInfo.aD;
      }
      else
      {
        bool = "DEVICE_SPEAKERPHONE".equals(localSessionInfo.bn);
        str = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
        if (bool)
        {
          this.v.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        }
        else if ("DEVICE_EARPHONE".equals(localSessionInfo.bn))
        {
          this.v.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        }
        else
        {
          if (localSessionInfo.g == 1) {
            str = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
          }
          this.v.a(str);
        }
      }
    }
    if (paramBoolean1)
    {
      this.e.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.e.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i1 = DoodleLogic.b().a(paramArrayOfByte);
    if (i1 == 1) {
      this.e.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (k().cB)) {
      this.e.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(long[] paramArrayOfLong)
  {
    Object localObject = this.e.getCurrentAccountUin();
    if (localObject != null)
    {
      long l1 = CharacterUtil.b((String)localObject);
      localObject = this.U;
      if (localObject != null) {
        ((QQGAudioCtrl)localObject).setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inviteNewMemJoin, uinList[");
    localStringBuilder.append(paramArrayOfLong);
    localStringBuilder.append("], needNotifyUI[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mMultiInviteEntranceFlag[");
    localStringBuilder.append(this.w);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length == 0) {
        return;
      }
      int i1;
      if (this.w == 1)
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
        this.U.inviteUser((long[])localObject, i2, null, 0, 0, false, false, 4);
        i1 = 0;
        while (i1 < i2)
        {
          if (!k().au.contains(Long.valueOf(paramArrayOfLong[i1]))) {
            k().au.add(Long.valueOf(paramArrayOfLong[i1]));
          }
          i1 += 1;
        }
      }
      if (paramBoolean)
      {
        i1 = paramArrayOfLong.length;
        this.e.a(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(i1) });
      }
    }
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return (this.j) && (this.l == paramInt) && (this.k == paramLong);
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    String str = a;
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
    paramString2 = this.e;
    if ((paramString2 != null) && (paramString2.getApp() != null))
    {
      paramBoolean = this.n.a(paramString1);
      if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {
        paramInt2 = this.e.m(paramString1);
      } else {
        paramInt2 = a(paramInt1, false, paramInt2);
      }
      if (QLog.isColorLevel())
      {
        paramString2 = a;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("isRequestVideo converted uinType = ");
        paramArrayOfByte.append(paramInt2);
        paramArrayOfByte.append(",sdkAVAccostType = ");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append("|");
        paramArrayOfByte.append(VideoConstants.b);
        paramArrayOfByte.append(", isVideoPaused: ");
        paramArrayOfByte.append(this.e.isBackgroundPause);
        QLog.d(paramString2, 2, paramArrayOfByte.toString());
      }
      if (this.b.c() >= 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "isRequestVideo->pending session exists");
        }
        if (k() != null)
        {
          paramInt1 = k().p;
          paramString2 = k().s;
        }
        else
        {
          paramString2 = null;
          paramInt1 = -1;
        }
        if ((paramInt2 != 1011) || (paramInt1 != 1011) || (paramString2 == null) || (!paramString2.equals(paramString1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "isRequestVideo->pending session exists, return false");
          }
          return false;
        }
      }
      boolean bool = a(this.e.getApp().getApplicationContext());
      if (QLog.isColorLevel())
      {
        paramString2 = a;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("isRequestVideo->isScreenLocked:");
        paramArrayOfByte.append(bool);
        QLog.d(paramString2, 2, paramArrayOfByte.toString());
      }
      if (k().e())
      {
        if (paramInt2 == -1) {
          return false;
        }
      }
      else if (((k().i != 7) || (this.Y == 0L)) && (k().i != 14) && (k().i != 13))
      {
        if (!this.j)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = a;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("isRequestVideo when chatting: fromUin = ");
            paramArrayOfByte.append(paramString1);
            paramArrayOfByte.append("|");
            paramArrayOfByte.append(bool);
            QLog.d(paramString2, 2, paramArrayOfByte.toString());
          }
          if ((k().s != null) && (paramString1.equals(k().s)))
          {
            paramString2 = a;
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
            paramString2 = a;
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
      if (this.e.m()) {
        return false;
      }
      if (paramBoolean) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = a;
        paramString2 = new StringBuilder();
        paramString2.append("isRequestVideo orientation: ");
        paramString2.append(this.aA);
        paramString2.append(", isQQPaused: ");
        paramString2.append(VideoConstants.b);
        paramString2.append(", isVideoPaused: ");
        paramString2.append(this.e.isBackgroundPause);
        paramString2.append(", isScreenLocked: ");
        paramString2.append(bool);
        paramString2.append(", isAppOnForeground: ");
        paramString2.append(GesturePWDUtils.isAppOnForegroundByTasks(i(), 0));
        QLog.d(paramString1, 2, paramString2.toString());
      }
      return true;
    }
    QLog.d(a, 1, "isRequestVideo  faile,app is null, return false");
    return false;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.U == null) {
      return false;
    }
    synchronized (this.aQ)
    {
      int i1 = this.aQ.size();
      paramInt2 = 0;
      if (paramInt2 < i1)
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.aQ.get(paramInt2);
        if ((localGAudioFriends != null) && (localGAudioFriends.a == paramLong))
        {
          localGAudioFriends.p = paramBoolean;
          localGAudioFriends.n = paramInt1;
          boolean bool = localGAudioFriends.r;
          if (paramBoolean)
          {
            localGAudioFriends.r = false;
            paramBoolean = bool;
          }
          else
          {
            paramBoolean = bool;
            if (localGAudioFriends.q)
            {
              localGAudioFriends.q = false;
              this.e.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(false) });
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
      if ((((VideoViewInfo)paramArrayList.get(i1)).a == paramLong) && (((VideoViewInfo)paramArrayList.get(i1)).b == paramInt)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.quaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
    }
    QLog.isColorLevel();
    return false;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl == null) {
      return false;
    }
    return localQQGAudioCtrl.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public boolean a(SessionInfo paramSessionInfo1, SessionInfo paramSessionInfo2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1;
    try
    {
      l1 = Long.parseLong(paramSessionInfo1.s);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l1 = 0L;
    }
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if ((l1 == paramLong2) && (paramSessionInfo1.ao)) {
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
      ((StringBuilder)localObject).append(paramSessionInfo1.ao);
      ((StringBuilder)localObject).append("], ret[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], main[");
      ((StringBuilder)localObject).append(paramSessionInfo1);
      ((StringBuilder)localObject).append("], new[");
      ((StringBuilder)localObject).append(paramSessionInfo2);
      ((StringBuilder)localObject).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    paramSessionInfo1.ao = false;
    if (bool1)
    {
      try
      {
        localObject = this.e;
        paramSessionInfo2.b(paramLong1, paramSessionInfo1.H);
        a(paramString, paramSessionInfo2.g, false, false, false);
        if ((this.L != null) && (localObject != null)) {
          ((VideoAppInterface)localObject).a().removeCallbacks(this.L);
        }
        if (!paramSessionInfo1.b()) {
          a(paramLong1, 2131230808, 1, null);
        }
        int i1 = paramSessionInfo1.g;
        paramSessionInfo2.ch = true;
        paramSessionInfo2.s = paramSessionInfo1.s;
        if ((paramSessionInfo1.i == 15) || (paramSessionInfo1.an)) {
          g(false);
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
        paramSessionInfo1.p = UITools.c(paramInt);
        paramSessionInfo1.aN = paramLong3;
        if (paramArrayOfLong != null) {
          paramSessionInfo1.aO = paramArrayOfLong;
        }
        paramSessionInfo1.d("onGAudioInvite.1", 1);
        if (localObject != null) {
          if (((VideoAppInterface)localObject).f() > 0)
          {
            paramSessionInfo1.e("onGAudioInvite3", AVUtil.b(paramSessionInfo1.p));
            ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
          }
          else if (((VideoAppInterface)localObject).isBackgroundStop)
          {
            paramSessionInfo1.e("onGAudioInvite4", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            q(false);
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
            paramSessionInfo2.a(paramSessionInfo1.f);
            bool2 = bool3;
          }
        }
        if (bool2) {
          p();
        }
      }
      catch (Exception paramSessionInfo1)
      {
        if (QLog.isColorLevel())
        {
          paramSessionInfo2 = a;
          paramArrayOfLong = new StringBuilder();
          paramArrayOfLong.append("onGAudioInviteError-->Exception=");
          paramArrayOfLong.append(paramSessionInfo1.getMessage());
          QLog.e(paramSessionInfo2, 2, paramArrayOfLong.toString());
        }
        this.b.a(paramLong1, paramString);
      }
      bool2 = bool1;
    }
    return bool2;
  }
  
  public boolean a(qav_gvideo_sdk_transfer.gVideoDownChannelControl paramgVideoDownChannelControl)
  {
    GVideoDownloadChannelControl localGVideoDownloadChannelControl = this.A;
    if (localGVideoDownloadChannelControl != null) {
      return localGVideoDownloadChannelControl.a(paramgVideoDownChannelControl);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    long l1 = p(paramString);
    boolean bool = a(u(this.e.getCurrentAccountUin()), u(paramString), l1, paramInt, paramLong);
    paramString = a;
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
    int i1 = paramSessionInfo.x();
    long l1 = paramSessionInfo.D();
    long l2 = paramSessionInfo.E();
    if (i1 == 2)
    {
      l3 = a(paramSessionInfo);
      if (l3 != paramSessionInfo.D()) {
        paramSessionInfo.e(l3);
      }
    }
    else if (i1 == 1)
    {
      l3 = b(paramSessionInfo);
      if (l3 != paramSessionInfo.D()) {
        paramSessionInfo.e(l3);
      }
    }
    long l3 = paramSessionInfo.D();
    long l4 = paramSessionInfo.E();
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
    Object localObject = k();
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
    if (!TextUtils.equals(((SessionInfo)localObject).f, str1))
    {
      bool = SessionMgr.a().e(str1);
      String str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkMainSession, need reset main session, from[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], cur");
      localStringBuilder.append(((SessionInfo)localObject).f);
      localStringBuilder.append("], coming[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i(str2, 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      str1 = a;
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
  
  public byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl == null) {
      return null;
    }
    return localVcControllerImpl.postData(paramLong2, paramArrayOfByte);
  }
  
  public WatchTogetherMediaPlayCtrl aA()
  {
    if ((this.aW == null) && (WTogetherUtil.a())) {
      this.aW = new WatchTogetherMediaPlayCtrl(this.e);
    }
    return this.aW;
  }
  
  public WatchTogetherMediaPlayCtrl aB()
  {
    if (aD()) {
      return this.aW;
    }
    return null;
  }
  
  public void aC()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.c();
    }
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.aW;
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.B();
    }
    this.aW = null;
  }
  
  public boolean aD()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.aW;
    return (localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.q());
  }
  
  @TargetApi(21)
  public ScreenRecordHelper aE()
  {
    if (this.aX == null) {
      this.aX = new ScreenRecordHelper();
    }
    return this.aX;
  }
  
  public ScreenShareCtrl aF()
  {
    if (this.aY == null) {
      this.aY = new ScreenShareCtrl(this);
    }
    return this.aY;
  }
  
  public JniSimpleInfoMng aG()
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.getJniSimpleInfo();
    }
    return null;
  }
  
  public MqqHandler aH()
  {
    return this.aF;
  }
  
  public void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "checkScreenShareValid");
    }
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl != null) {
      localQQGAudioCtrl.checkScreenShareAvaliable();
    }
  }
  
  public void ab()
  {
    if (k().bi.size() > 0)
    {
      int i2 = X();
      int i1 = 0;
      if (i2 != 4)
      {
        i2 = k().B();
        if (i2 == -1)
        {
          ((VideoViewInfo)k().bi.get(0)).c = true;
          ((VideoViewInfo)k().bi.get(0)).e = true;
          return;
        }
        VideoViewInfo localVideoViewInfo1 = (VideoViewInfo)k().bi.get(i2);
        localVideoViewInfo1.c = true;
        VideoViewInfo localVideoViewInfo2;
        if (localVideoViewInfo1.a == Long.valueOf(this.e.getCurrentAccountUin()).longValue())
        {
          if (i2 != 0)
          {
            localVideoViewInfo2 = (VideoViewInfo)k().bi.get(0);
            localVideoViewInfo2.c = false;
            k().bi.set(0, localVideoViewInfo1);
            k().bi.set(i2, localVideoViewInfo2);
            synchronized (k().bk)
            {
              k().bk.set(0, localVideoViewInfo1);
              k().bk.set(i2, localVideoViewInfo2);
              k().C();
            }
          }
          if (k().b(Long.valueOf(this.e.getCurrentAccountUin()).longValue()) == -1) {
            while (i1 < k().bi.size())
            {
              if (((VideoViewInfo)k().bi.get(i1)).a != Long.valueOf(this.e.getCurrentAccountUin()).longValue()) {
                ((VideoViewInfo)k().bi.get(i1)).e = true;
              }
              i1 += 1;
            }
          }
        }
        else if (i2 != 0)
        {
          localVideoViewInfo2 = (VideoViewInfo)k().bi.get(0);
          localVideoViewInfo2.c = false;
          k().bi.set(0, localObject1);
          k().bi.set(i2, localVideoViewInfo2);
          synchronized (k().bk)
          {
            k().bk.set(0, localObject1);
            k().bk.set(i2, localVideoViewInfo2);
            k().C();
            return;
          }
        }
      }
      else
      {
        ((VideoViewInfo)k().bi.get(0)).c = true;
      }
    }
  }
  
  public boolean ac()
  {
    if (this.U != null)
    {
      if (k().aQ == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
      } else if ((k().aQ == 1) && (k().o == 10)) {
        ReportController.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
      }
      int i1 = this.U.startVideoSend();
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goOnstage, ret[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      return i1 != 0;
    }
    if (QLog.isColorLevel()) {
      QLog.e(a, 2, "goOnstage-->mGAudioCtrl is null");
    }
    return false;
  }
  
  public void ad()
  {
    if (this.U != null)
    {
      if (k().aQ == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
      } else if ((k().aQ == 1) && (k().o == 10)) {
        ReportController.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
      }
      int i1 = this.U.nativeStopVideoSend();
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goOffStage, ret[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(a, 2, "goOffStage-->mGAudioCtrl is null");
    }
  }
  
  public String ae()
  {
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl != null) {
      return localQQGAudioCtrl.getAVGQuality();
    }
    return null;
  }
  
  public boolean af()
  {
    return this.e.n();
  }
  
  public boolean ag()
  {
    return this.an;
  }
  
  public boolean ah()
  {
    if (AudioHelper.e())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[");
      localStringBuilder.append(this.ao);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    return this.ao > 0;
  }
  
  public void ai()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearSelectMemberActivityIsResume, selectMemberActivityIsResume[");
    localStringBuilder.append(this.ao);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.ao = 0;
  }
  
  public VideoAppInterface aj()
  {
    return this.e;
  }
  
  public int ak()
  {
    if ((!k().j()) && (!this.j)) {
      return 255;
    }
    return 0;
  }
  
  public ArrayList<Long> al()
  {
    ArrayList localArrayList = new ArrayList();
    if (k() == null) {
      return localArrayList;
    }
    Iterator localIterator = k().au.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Long)localIterator.next());
    }
    localIterator = U().iterator();
    while (localIterator.hasNext())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if ((localGAudioFriends.n == 0) && (localArrayList.contains(Long.valueOf(localGAudioFriends.a)))) {
        localArrayList.remove(Long.valueOf(localGAudioFriends.a));
      }
    }
    return localArrayList;
  }
  
  public void am()
  {
    SessionInfo localSessionInfo = k();
    if (localSessionInfo != null)
    {
      int i2 = localSessionInfo.cs;
      int i1 = i2;
      if (i2 == 0) {
        i1 = localSessionInfo.cr;
      }
      g(i1);
      boolean bool;
      if ((i1 != 0) && (localSessionInfo.bX)) {
        bool = true;
      } else {
        bool = false;
      }
      k(bool);
    }
  }
  
  public void an()
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      localVcControllerImpl.onProcessExit();
    }
  }
  
  public long ao()
  {
    return a(k());
  }
  
  public long ap()
  {
    return b(k());
  }
  
  public long aq()
  {
    if ((k().g != 3) && (k().g != 4)) {
      return 0L;
    }
    return this.U.getEnterRoomTime();
  }
  
  public void ar()
  {
    this.aT = true;
  }
  
  public long as()
  {
    int i1 = k().g;
    if ((i1 != 1) && (i1 != 2))
    {
      if ((i1 != 3) && (i1 != 4)) {
        return 0L;
      }
      return ap();
    }
    return ao();
  }
  
  public void at()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRecordVoice, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    a(l1, 2131230811, 1, null);
  }
  
  public void au()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRecordDing, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.v.b(l1);
    this.v.a(l1, this.e, 2131230810, null, 1, null);
  }
  
  public int av()
  {
    return this.av;
  }
  
  void aw()
  {
    if (this.e != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.sdk.onRequestVideo");
      localIntent.setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void ax()
  {
    SessionInfo localSessionInfo = k();
    long l1 = AudioHelper.c();
    if ((localSessionInfo.j()) || (localSessionInfo.k()) || (localSessionInfo.i == 9) || (localSessionInfo.l()))
    {
      SmallScreenUtils.a(l1, this.e, 2);
      str = localSessionInfo.f;
      int i1 = localSessionInfo.g;
      boolean bool;
      if (localSessionInfo.i != 9) {
        bool = true;
      } else {
        bool = false;
      }
      a(str, i1, false, bool, localSessionInfo.u());
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reNotifyChatInfo2QQ, sessionInfo[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public long ay()
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.getOnPeerFrameRenderEndFunctionPtr();
    }
    return 0L;
  }
  
  public AVCallCompactHelper az()
  {
    return this.ax;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGatewayTestResult networkType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | signalStrength:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" | pingResult:");
    localStringBuilder.append(paramInt3);
    AVLog.printColorLog(str, localStringBuilder.toString());
    return this.d.setNativeGatewayTestResult(paramInt1, paramInt2, paramInt3);
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    if ((k().g != 1) && (k().g != 2)) {
      return -1;
    }
    return this.d.unregisterAudioDataCallback(paramInt);
  }
  
  public int b(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = k().j();
    if (QLog.isColorLevel())
    {
      String str = a;
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
    return this.d.sendAVFunChatMsg(k().s, paramInt, paramArrayOfByte);
  }
  
  public int b(SessionInfo paramSessionInfo, String paramString)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl != null) {
      return localQQGAudioCtrl.getRoomUserSdkVersion(paramSessionInfo, paramString);
    }
    return -1;
  }
  
  int b(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int b(boolean paramBoolean, String paramString)
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl == null) {
      return -1;
    }
    return localVcControllerImpl.setAudioOutput(paramString, paramBoolean);
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    if (!k().j())
    {
      QLog.e(a, 1, "sendAvatar2DMsg, is not Connected");
      return 0;
    }
    return this.d.sendAvatar2DMsg(k().s, paramArrayOfByte);
  }
  
  public long b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return 0L;
    }
    if ((this.U != null) && ((paramSessionInfo.g == 3) || (paramSessionInfo.g == 4)) && (paramSessionInfo.D() == 0L))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = b(paramSessionInfo.aQ, paramSessionInfo.o, paramSessionInfo.aN);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramSessionInfo.e(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramSessionInfo.e(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramSessionInfo.D();
  }
  
  public VideoController b(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public AVPhoneUserInfo b(long paramLong, ArrayList<AVPhoneUserInfo> paramArrayList)
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
  
  public void b()
  {
    if (this.U == null) {
      E();
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportCloseReasonBeacon,reason  = ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("closeReason", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAvideoCloseReasonB", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  public void b(int paramInt, String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveSubtitleChanged:");
    localStringBuilder.append(paramString);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.e.a(new Object[] { Integer.valueOf(6009), Integer.valueOf(paramInt), paramString });
  }
  
  void b(long paramLong)
  {
    if (k().p != 1011)
    {
      if (k().p == 21) {
        return;
      }
      if (k().aq == 0L)
      {
        long l1 = k().X;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startReachedRing, peer colorRingId=");
          localStringBuilder.append(l1);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        Object localObject = ColorRingManager.a(l1, 3);
        if (new File((String)localObject).exists())
        {
          TraeHelper.a().a(paramLong, this.e, 0, (String)localObject, -1, null);
          k().C = true;
          int i1 = k().Y;
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
        TraeHelper.a().a(paramLong, this.e, 2131230815, null, -1, null);
        k().C = true;
      }
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    Object localObject = k();
    int i1;
    if ((!TextUtils.isEmpty(((SessionInfo)localObject).s)) && ((!((SessionInfo)localObject).s.equals(String.valueOf(paramLong2))) || (((SessionInfo)localObject).g == 0)))
    {
      i1 = c(paramLong1, paramLong2);
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryRoomInfo1, result[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    if ((this.b.c() == 0) && (TextUtils.isEmpty(((SessionInfo)localObject).f)) && (TextUtils.isEmpty(((SessionInfo)localObject).s)))
    {
      i1 = c(paramLong1, paramLong2);
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryRoomInfo2, result[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QueryRoomInfo fail, mainSession[");
    localStringBuilder.append(k());
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    this.e.a().post(new VideoController.35(this, paramArrayList, paramLong1, paramLong2));
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
    if (this.b.a((String)localObject1))
    {
      localObject2 = this.b.d((String)localObject1);
    }
    else
    {
      localObject1 = SessionMgr.a(100, paramString, new int[0]);
      localObject2 = this.b.d((String)localObject1);
    }
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a);
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
    Object localObject3 = this.e.A();
    if (localObject3 != null) {
      ((ChatRoomMng)localObject3).b((SessionInfo)localObject2);
    }
    VideoNodeManager.a(((SessionInfo)localObject2).D(), 16, 0L);
    VideoNodeManager.a(((SessionInfo)localObject2).D(), 33);
    VideoNodeManager.b(((SessionInfo)localObject2).D());
    localObject3 = (VideoNodeReporter)this.e.c(4);
    int i2;
    if (((SessionInfo)localObject2).B) {
      i2 = 12;
    } else {
      i2 = 5;
    }
    ((VideoNodeReporter)localObject3).a(((SessionInfo)localObject2).D(), i2, i1 + 500);
    ((VideoNodeReporter)localObject3).b("NoCrash");
    ((VideoNodeReporter)localObject3).a(((SessionInfo)localObject2).D(), 29, 1L);
    ((VideoNodeReporter)localObject3).a(36, 1L);
    ((VideoNodeReporter)localObject3).c(((SessionInfo)localObject2).D());
    localObject3 = a;
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
    localStringBuilder.append(this.c);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("], sessionInfo.isIdling[");
    localStringBuilder.append(((SessionInfo)localObject2).e());
    localStringBuilder.append("], sessionInfo.peerUin[");
    localStringBuilder.append(((SessionInfo)localObject2).s);
    localStringBuilder.append("], sessionInfo.isOnlyAudio[");
    localStringBuilder.append(((SessionInfo)localObject2).aK);
    localStringBuilder.append("], sessionInfo.SessionType[");
    localStringBuilder.append(((SessionInfo)localObject2).g);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject3, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    if ((((SessionInfo)localObject2).e()) && (!paramBoolean))
    {
      QLog.e(a, 1, "closeSession state error!!!");
      return;
    }
    if ((((SessionInfo)localObject2).g == 2) && (!((SessionInfo)localObject2).am) && (((SessionInfo)localObject2).i >= 4) && (((SessionInfo)localObject2).aw > 0L))
    {
      i2 = this.e.n("BEAUTY_SKIN");
      localObject3 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeSession double video call end with beauty: ");
      localStringBuilder.append(i2);
      localStringBuilder.append(" | ");
      localStringBuilder.append(((SessionInfo)localObject2).aw);
      localStringBuilder.append(" | ");
      localStringBuilder.append(((SessionInfo)localObject2).i);
      localStringBuilder.append(" | ");
      localStringBuilder.append(((SessionInfo)localObject2).S);
      AVLog.printAllUserLog((String)localObject3, localStringBuilder.toString());
      if ((((SessionInfo)localObject2).S) || (i2 > 0)) {
        ReportController.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
      }
    }
    if ((this.ag) && (z() > 0L)) {
      if (((SessionInfo)localObject2).g == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", UITools.a(z()), "");
      } else if (((SessionInfo)localObject2).g == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", UITools.a(z()), "");
      }
    }
    ((SessionInfo)localObject2).aq = 0L;
    ((SessionInfo)localObject2).ar = null;
    localObject3 = paramString;
    if (!TextUtils.isEmpty(((SessionInfo)localObject2).s))
    {
      localObject3 = paramString;
      if (((SessionInfo)localObject2).s.contains(paramString)) {
        localObject3 = ((SessionInfo)localObject2).s;
      }
    }
    if ((((SessionInfo)localObject2).m()) || (((SessionInfo)localObject2).n())) {
      ((SessionInfo)localObject2).ay = i1;
    }
    if ((!((SessionInfo)localObject2).f()) && ((!((SessionInfo)localObject2).h()) || (i1 != ((SessionInfo)localObject2).ay))) {
      break label1042;
    }
    ((SessionInfo)localObject2).a(paramLong, 0L);
    label1042:
    if ((((SessionInfo)localObject2).br) && (this.M != null))
    {
      this.e.a().removeCallbacks(this.M);
      this.M = null;
    }
    if (paramInt == 23)
    {
      if (((SessionInfo)localObject2).g == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      a(((SessionInfo)localObject2).f, ((SessionInfo)localObject2).p, paramBoolean, ((SessionInfo)localObject2).s, ((SessionInfo)localObject2).u);
    }
    else
    {
      a(paramLong, (String)localObject1, (String)localObject3, i1);
    }
    if (!this.b.d())
    {
      x();
      C();
      Z();
    }
    if (this.c)
    {
      DataReport.c(this, false);
      DataReport.d(this, false);
      if (this.e.f() > 0) {
        DataReport.l(this);
      }
    }
    ((SessionInfo)localObject2).a("doCloseSession", 0);
    ((SessionInfo)localObject2).a(paramLong, "doCloseSession", 0);
    ((SessionInfo)localObject2).h = 0;
    ((SessionInfo)localObject2).bG.clear();
    ((SessionInfo)localObject2).bI = 0L;
    GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
    ((SessionInfo)localObject2).bJ = false;
    ((SessionInfo)localObject2).aF = null;
    ((SessionInfo)localObject2).b("doCloseSession", null);
    ((SessionInfo)localObject2).O = true;
    if ((i1 != 21) && (i1 != 72) && (i1 != 110))
    {
      ((SessionInfo)localObject2).p = -1;
      if (this.e.f() > 0) {
        this.e.a(new Object[] { Integer.valueOf(28), localObject3, Boolean.valueOf(this.c) });
      } else {
        paramBoolean = this.c;
      }
    }
    this.e.a(new Object[] { Integer.valueOf(203), localObject3, Boolean.valueOf(this.c), Long.valueOf(paramLong) });
    ((SessionInfo)localObject2).b(paramLong, false);
    ((SessionInfo)localObject2).c(paramLong, false);
    ((SessionInfo)localObject2).a(paramLong, 0L);
    ((SessionInfo)localObject2).c(paramLong);
    SessionFlag.a().b();
    paramString = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("close session removeSession sessionId = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
    paramBoolean = this.b.a(paramLong, (String)localObject1);
    paramString = QAVNotification.a(this.e);
    if ((paramString != null) && (paramString.a()))
    {
      paramString.a((String)localObject1);
      if (paramBoolean) {
        p();
      }
    }
    if (this.n.d()) {
      this.e.a().postDelayed(new VideoController.13(this), 5000L);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i1 = 0;
    while (i1 < this.aO.size())
    {
      localObject1 = (VideoController.GAudioFriends)this.aO.get(i1);
      if (((VideoController.GAudioFriends)localObject1).a == paramLong)
      {
        this.aO.remove(i1);
        if (QLog.isColorLevel())
        {
          localObject2 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("InviteMemberList removeCertainInviteNumber remove: member uin:=");
          localStringBuilder.append(((VideoController.GAudioFriends)localObject1).a);
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
      this.e.a(new Object[] { Integer.valueOf(708), Long.valueOf(1L), Long.valueOf(1L), this.aO });
    }
    Object localObject1 = a;
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
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((k().g > 0) && (k().g <= 2) && (this.d != null))
    {
      if (!k().j()) {
        return;
      }
      this.d.pauseVideo(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo end");
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    long l1 = AudioHelper.c();
    TraeHelper.a().b(l1);
    TraeHelper.b(this.e);
    if (x(paramString)) {
      TraeHelper.a().d();
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "closeSession", new Throwable("closeSession"));
    }
    b(l1, paramString, paramInt, false);
  }
  
  public void b(String paramString, long paramLong)
  {
    try
    {
      QLog.d(a, 1, String.format("setMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      long l1 = Long.valueOf(paramString).longValue();
      if ((l1 > 0L) && (paramLong > 0L))
      {
        this.z.put(Long.valueOf(l1), Long.valueOf(paramLong));
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.d(a, 1, "setMSFInviteMessageTimeStamp fail.", paramString);
    }
  }
  
  public void b(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
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
        Iterator localIterator = k().bm.iterator();
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
        localIterator = this.ah.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (VideoController.GAudioFriends)localIterator.next();
          if ((((VideoController.GAudioFriends)localObject3).n == 1) && (((VideoController.GAudioFriends)localObject3).a == ((AVPhoneUserInfo)localObject2).account))
          {
            if (((VideoController.GAudioFriends)localObject3).o == null) {
              ((VideoController.GAudioFriends)localObject3).o = new AVPhoneUserInfo();
            }
            ((VideoController.GAudioFriends)localObject3).o.accountType = 2;
            ((VideoController.GAudioFriends)localObject3).o.account = ((AVPhoneUserInfo)localObject2).account;
            ((VideoController.GAudioFriends)localObject3).o.telInfo.mobile = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
            ((VideoController.GAudioFriends)localObject3).o.telInfo.nation = ((AVPhoneUserInfo)localObject2).telInfo.nation;
            ((VideoController.GAudioFriends)localObject3).o.telInfo.prefix = ((AVPhoneUserInfo)localObject2).telInfo.prefix;
          }
        }
      }
      if ((((StringBuilder)localObject1).length() > 0) && (QLog.isColorLevel())) {
        QLog.e(a, 2, ((StringBuilder)localObject1).toString());
      }
      this.e.a(new Object[] { Integer.valueOf(406) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(a, 2, "on0x626Recv --> no data");
    }
  }
  
  public boolean b(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.U == null) {
      E();
    }
    int i2 = -999;
    boolean bool = false;
    int i1 = i2;
    if (paramLong > 0L)
    {
      i1 = i2;
      if (this.U != null)
      {
        this.X = true;
        if (paramInt1 == 1) {
          i1 = paramInt2;
        } else if (paramInt1 == 2) {
          i1 = 1;
        } else if (paramInt1 == 3) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        i1 = this.U.nativeUpdateRoomInfo(paramInt1, paramLong, i1, true, true, true);
      }
    }
    String str = a;
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
  
  public boolean b(long paramLong, int paramInt)
  {
    GVideoDownloadChannelControl localGVideoDownloadChannelControl = this.A;
    if (localGVideoDownloadChannelControl == null) {
      return GVideoDownloadChannelControl.c();
    }
    return localGVideoDownloadChannelControl.a(paramLong, paramInt);
  }
  
  public boolean b(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {
      return false;
    }
    String str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    Object localObject = k();
    if (TextUtils.equals(str, ((SessionInfo)localObject).f)) {
      return false;
    }
    paramInt1 = this.b.c();
    if (paramInt1 >= 2)
    {
      str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedAutoRejectDM, to many session, reject. [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("]");
      QLog.i(str, 1, ((StringBuilder)localObject).toString());
      return true;
    }
    if ((((SessionInfo)localObject).h()) && (this.e.t()))
    {
      QLog.i(a, 1, "checkNeedAutoRejectDM, one in av game and one in invite.");
      return true;
    }
    return false;
  }
  
  public boolean b(SessionInfo paramSessionInfo1, SessionInfo paramSessionInfo2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1;
    try
    {
      l1 = Long.parseLong(paramSessionInfo1.s);
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
      if (paramSessionInfo1.ay == 0)
      {
        paramSessionInfo1.a("onGAudioInvite.2", 0);
        this.b.a(paramLong1, paramString);
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
        paramSessionInfo2.b(paramLong1, paramSessionInfo1.H);
        int i1 = paramSessionInfo2.g;
        boolean bool2 = bool1;
        try
        {
          a(paramString, i1, false, false, false);
          if ((this.K != null) && (this.e.a() != null)) {
            this.e.a().removeCallbacks(this.K);
          }
          if (!paramSessionInfo1.b()) {
            a(paramLong1, 2131230808, 1, null);
          }
          i1 = paramSessionInfo1.g;
          paramSessionInfo2.s = paramSessionInfo1.s;
          paramSessionInfo2.b(paramLong1, paramSessionInfo1.H);
          paramSessionInfo2.E = paramSessionInfo1.E;
          paramSessionInfo2.b("onGAudioInvite", paramSessionInfo1.aG);
          paramSessionInfo2.b("onGAudioInvite", paramSessionInfo1.aD);
          paramSessionInfo2.ch = true;
          paramSessionInfo2.b("onGAudioInvite", 12);
          paramSessionInfo1.b("onGAudioInvite", 12);
          b(paramSessionInfo1.s, 21);
          if (i1 == 1) {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.2", 3);
          } else if (i1 == 2) {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.3", 4);
          } else if (i1 == 4) {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.4", 4);
          } else {
            paramSessionInfo2.a(paramLong1, "onGAudioInvite.5", 3);
          }
          paramSessionInfo2.p = UITools.c(paramInt);
          paramSessionInfo2.aN = paramLong3;
          if (paramArrayOfLong != null) {
            paramSessionInfo2.aO = paramArrayOfLong;
          }
          paramSessionInfo2.d("onGAudioInvite.2", 1);
          if (this.e.f() > 0)
          {
            paramSessionInfo2.e("onGAudioInvite1", AVUtil.b(paramSessionInfo2.p));
            this.e.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            break label643;
          }
          if (!this.e.isBackgroundStop) {
            break label643;
          }
          paramSessionInfo2.e("onGAudioInvite2", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          q(false);
          boolean bool3 = false;
          paramSessionInfo1 = QAVNotification.a(this.e);
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
          p();
          return bool2;
        }
        catch (Exception paramSessionInfo1) {}
        if (!QLog.isColorLevel()) {
          break label623;
        }
      }
      catch (Exception paramSessionInfo1) {}
      QLog.e(a, 2, "onGAudioInvite, Exception", paramSessionInfo1);
      label623:
      this.b.a(paramLong1, paramString);
      return bool1;
      boolean bool4 = false;
      return bool4;
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    Object localObject1 = a(k().bl);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestGVideo-->info=");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    Object localObject2 = this.U;
    int i2 = 0;
    if (localObject2 != null)
    {
      aK();
      int i1 = 0;
      while (i1 < k().bl.size())
      {
        if (((VideoViewInfo)k().bl.get(i1)).a == Long.valueOf(this.e.getCurrentAccountUin()).longValue())
        {
          k().bl.remove(i1);
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
        if (i1 < k().bl.size())
        {
          localObject1 = new ArrayList(i1);
          while (i2 < i1)
          {
            ((ArrayList)localObject1).add(k().bl.get(i2));
            i2 += 1;
          }
          k().bl = ((ArrayList)localObject1);
        }
      }
      if (k().bl.size() > 0)
      {
        localObject1 = (ArrayList)k().bl.clone();
        localObject2 = this.aF;
        if (localObject2 != null) {
          ((MqqHandler)localObject2).post(new VideoController.20(this, (ArrayList)localObject1, paramBoolean));
        }
      }
      return true;
    }
    k().bl.clear();
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=");
      localStringBuilder.append((String)localObject1);
      QLog.e((String)localObject2, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public AVPbInfo c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "processQCallPush in VideoController");
    }
    if (this.d != null)
    {
      AVPbInfo localAVPbInfo = new AVPbInfo();
      this.d.processQCallPush(paramArrayOfByte, localAVPbInfo);
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = a;
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
  
  public void c()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = ((VideoAppInterface)localObject).c();
    if (localObject != null) {
      ((VideoProcessExitMonitor)localObject).a();
    }
  }
  
  public void c(int paramInt)
  {
    SessionInfo localSessionInfo = k();
    Object localObject;
    if (this.e != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.av.v2q.AvSwitch");
      ((Intent)localObject).putExtra("sessionType", paramInt);
      ((Intent)localObject).putExtra("uinType", localSessionInfo.p);
      ((Intent)localObject).putExtra("peerUin", localSessionInfo.s);
      ((Intent)localObject).putExtra("extraUin", localSessionInfo.u);
      ((Intent)localObject).putExtra("relationType", localSessionInfo.aQ);
      if ((localSessionInfo.aN == 0L) && (localSessionInfo.p == 0)) {
        ((Intent)localObject).putExtra("relationId", AVUtil.c(localSessionInfo.s));
      } else {
        ((Intent)localObject).putExtra("relationId", localSessionInfo.aN);
      }
      ((Intent)localObject).putExtra("isDoubleVideoMeeting", localSessionInfo.am);
      ((Intent)localObject).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendAvSwitchBroadcast, sessionType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], peer[");
      localStringBuilder.append(localSessionInfo.s);
      localStringBuilder.append("], type[");
      localStringBuilder.append(localSessionInfo.g);
      localStringBuilder.append("], uinType[");
      localStringBuilder.append(localSessionInfo.p);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(localSessionInfo.aQ);
      localStringBuilder.append("], relationId[");
      localStringBuilder.append(localSessionInfo.aN);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  void c(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
      k().bc = true;
    } else if (paramInt2 == 103) {
      k().bc = false;
    }
    this.e.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void c(int paramInt, String paramString)
  {
    AVLog.printAllUserLog(a, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.e.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void c(long paramLong)
  {
    int i1;
    String str;
    StringBuilder localStringBuilder;
    if (k().H)
    {
      i1 = this.d.switchVideo(k().s);
      if ((QLog.isColorLevel()) || (i1 == -1))
      {
        str = a;
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
      i1 = this.d.switchAudio(k().s);
      if ((QLog.isColorLevel()) || (i1 == -1))
      {
        str = a;
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
  
  public void c(long paramLong, ArrayList<AVUserInfo> paramArrayList) {}
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeVideo SessionType :");
      localStringBuilder.append(k().g);
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
    if ((k().g > 0) && (k().g <= 2))
    {
      if (!k().j()) {
        return;
      }
      VcControllerImpl localVcControllerImpl = this.d;
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
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGAudioSpeakerMode, [");
      localStringBuilder.append(this.aK);
      localStringBuilder.append(" --> ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.aK = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAnotherSelfIsRing, isCalling[");
      localStringBuilder.append(this.x);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mVcCtrl[");
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], sessionInfo SessionType[");
      localStringBuilder.append(k().g);
      localStringBuilder.append("], sessionInfo state[");
      localStringBuilder.append(k().i);
      localStringBuilder.append("], isPeerOnPhone[");
      localStringBuilder.append(k().aL);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.x == paramBoolean) {
      return;
    }
    this.x = paramBoolean;
    if (k().aL) {
      return;
    }
    if (paramBoolean)
    {
      if ((k().i > 0) && (k().i <= 4))
      {
        if ((!k().aK) && (k().H)) {
          b(k().s);
        }
        if (!k().E) {
          a(true, k().s);
        }
        b(false, k().s);
      }
      else
      {
        b("notifyAnotherSelfIsRing", true);
      }
    }
    else if ((k().i > 0) && (k().i <= 4))
    {
      if ((!k().aK) && (k().H)) {
        c(k().s);
      }
      if (!k().E) {
        a(false, k().s);
      }
      b(true, k().s);
      am();
    }
    else
    {
      b("notifyAnotherSelfIsRing", false);
      if (k().aG)
      {
        if (this.R == null) {
          this.R = new VideoController.23(this);
        }
        this.e.a().postDelayed(this.R, 2000L);
      }
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((VcControllerImpl)localObject).notifyAnotherSelfIsRing(k().s, paramBoolean);
    }
  }
  
  public boolean c(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.cq == -1) {
      paramSessionInfo.cq = a(paramSessionInfo, paramSessionInfo.s);
    }
    if (paramSessionInfo.cp == -1) {
      paramSessionInfo.cp = b(paramSessionInfo, paramSessionInfo.s);
    }
    int i1 = paramSessionInfo.cq;
    boolean bool2 = false;
    boolean bool1;
    if (i1 == 2)
    {
      bool1 = bool2;
      if (paramSessionInfo.cp < 100) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          bool1 = true;
          break label122;
          if (paramSessionInfo.cq != 4) {
            break;
          }
          bool1 = bool2;
          if (paramSessionInfo.cp < 101) {
            break label122;
          }
        }
        bool1 = bool2;
        if (paramSessionInfo.cq != 5) {
          break;
        }
        bool1 = bool2;
      } while (paramSessionInfo.cp >= 5635);
    }
    label122:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeerSupportDMeetingSwitchTroop, end[");
      localStringBuilder.append(paramSessionInfo.cq);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSessionInfo.cp);
      localStringBuilder.append(",");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void checkNetStatus()
  {
    int i1 = NetworkUtil.getSystemNetwork(null);
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2) && (i1 != 3) && (i1 != 4) && (i1 != 5))
      {
        h(0);
        return;
      }
      aQ();
      return;
    }
    h(3);
  }
  
  int d(long paramLong)
  {
    ArrayList localArrayList = this.aQ;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.aQ.size())
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.aQ.get(i1);
          if ((localGAudioFriends != null) && (localGAudioFriends.a == paramLong)) {
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
  
  public String d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPhoneNameByPhoneNum --> phoneNum = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.e.d(paramString);
  }
  
  public void d(int paramInt)
  {
    long l1 = AudioHelper.c();
    Object localObject1 = a;
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
    localObject1 = this.aB;
    if (localObject1 != null) {
      ((OrientationEventListener)localObject1).disable();
    }
    localObject1 = QAVNotification.a(this.e);
    try
    {
      ((QAVNotification)localObject1).b();
    }
    catch (Exception localException)
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception msg = ");
      localStringBuilder.append(localException.getMessage());
      AVLog.printErrorLog((String)localObject2, localStringBuilder.toString());
    }
    Intent localIntent = new Intent("tencent.video.destroyService");
    localIntent.setPackage(this.e.getApp().getPackageName());
    this.e.getApp().sendBroadcast(localIntent);
    this.e.a(l1, i1);
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    int i1;
    if (paramInt2 == 108)
    {
      k().be = true;
      k().bd = (H() ^ true);
      i1 = D();
      a("onMVSpeakModeChanged_1", this.k, false, false, -1);
      a(-1L, i1, D());
    }
    else if (k().be)
    {
      k().be = false;
      i1 = D();
      if (k().bd) {
        a("onMVSpeakModeChanged_2", this.k, true, false, -1);
      } else {
        a("onMVSpeakModeChanged_3", this.k, false, false, -1);
      }
      a(-1L, i1, D());
    }
    this.e.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteUser --> Count = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , firstName = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramInt > 0) && (paramString != null)) {
      this.e.a(new Object[] { Integer.valueOf(409), Integer.valueOf(paramInt), paramString });
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    ClientLogReport.sGatewayIP = paramString;
    ClientLogReport.sGatewayPort = paramInt;
    try
    {
      this.n.receiveGatewayMsg(paramString, paramInt);
      SharedPreUtils.e(this.e.getCurrentAccountUin()).edit().putString(VideoConstants.p, paramString).apply();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      AVCoreLog.e(a, "saveGateWayMsg fail.", paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.U == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSoundEnable: ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.j)
    {
      if (paramBoolean)
      {
        this.U.startAudioRecv();
        return;
      }
      this.U.stopAudioRecv();
    }
  }
  
  public boolean d(SessionInfo paramSessionInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeerSupportDoubleSwitchToTroop, start[");
      localStringBuilder.append(paramSessionInfo.cq);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSessionInfo.cp);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    if (paramSessionInfo.cq == -1) {
      paramSessionInfo.cq = g(paramSessionInfo.s);
    }
    if (paramSessionInfo.cp == -1) {
      paramSessionInfo.cp = i(paramSessionInfo.s);
    }
    int i1 = paramSessionInfo.cq;
    boolean bool = false;
    if (i1 == 2)
    {
      if (paramSessionInfo.cp < 100) {}
    }
    else
    {
      for (;;)
      {
        bool = true;
        break label165;
        if (paramSessionInfo.cq != 4) {
          break;
        }
        if (paramSessionInfo.cp < 101) {
          break label165;
        }
      }
      i1 = paramSessionInfo.cq;
    }
    label165:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeerSupportDoubleSwitchToTroop, end[");
      localStringBuilder.append(paramSessionInfo.cq);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSessionInfo.cp);
      localStringBuilder.append(",");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("double_2_multi", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void dataTransferred(int paramInt, long paramLong) {}
  
  public int e(int paramInt, String paramString)
  {
    boolean bool = k().j();
    String str = a;
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
    return this.d.sendAVFunChatMsg(k().s, paramInt, paramString);
  }
  
  public int e(String paramString)
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      return localVcControllerImpl.updateSelfUin(paramString);
    }
    return -1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "startNetWorkTimer");
    }
    if (this.aH) {
      this.e.a().removeCallbacks(this.B);
    }
    this.aH = true;
    this.e.a().postDelayed(this.B, 30000L);
  }
  
  public void e(int paramInt)
  {
    this.e.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void e(boolean paramBoolean)
  {
    VcControllerImpl localVcControllerImpl = this.d;
    if (localVcControllerImpl != null) {
      localVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public boolean e(int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramInt2 != 5) && (paramInt2 != 4))
    {
      if (paramInt2 == 3) {
        return false;
      }
      Object localObject = this.b.b();
      if ((((SessionInfo)localObject).aQ == paramInt1) && (((SessionInfo)localObject).aN == paramLong)) {
        return false;
      }
      paramInt1 = this.b.c();
      if (paramInt1 >= 2)
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkNeedAutoRejectMAV, to many session, reject. [");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 1, localStringBuilder.toString());
        return true;
      }
      if ((((SessionInfo)localObject).h()) && (this.e.t()))
      {
        QLog.i(a, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
        return true;
      }
    }
    return false;
  }
  
  public int f(int paramInt)
  {
    if (!k().j()) {
      return 0;
    }
    return this.d.setGroundGlassSwitch(k().s, paramInt);
  }
  
  public void f(int paramInt, String paramString)
  {
    if ((k().g != 4) && (k().g != 2)) {
      return;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl != null) {
      localQQGAudioCtrl.lockVideoMaxQP(paramInt, paramString);
    }
  }
  
  public boolean f(String paramString)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StopGVideo, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.U != null)
    {
      paramString = this.aF;
      if (paramString != null) {
        paramString.post(new VideoController.21(this, l1));
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e(a, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    }
    return false;
  }
  
  public boolean f(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int g(int paramInt)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVoiceType| sessionType=");
    localStringBuilder.append(k().g);
    localStringBuilder.append("type=");
    localStringBuilder.append(paramInt);
    AVLog.printAllUserLog((String)localObject, localStringBuilder.toString());
    if ((k().g != 1) && (k().g != 2))
    {
      if ((k().g == 3) || (k().g == 4))
      {
        localObject = this.U;
        if (localObject != null) {
          return ((QQGAudioCtrl)localObject).setVoiceType(paramInt);
        }
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        return ((VcControllerImpl)localObject).setVoiceType(paramInt);
      }
    }
    return -1;
  }
  
  public int g(String paramString)
  {
    Object localObject = SessionMgr.a().b(paramString);
    if ((localObject != null) && (((SessionInfo)localObject).cq != -1)) {
      return ((SessionInfo)localObject).cq;
    }
    localObject = this.d;
    if (localObject != null) {
      return ((VcControllerImpl)localObject).getPeerTerminalType(paramString);
    }
    return -1;
  }
  
  void g(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean g()
  {
    boolean bool1 = a(i());
    boolean bool2 = aJ();
    boolean bool3 = this.e.l();
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGameMode isQQPaused: ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(", isVideoPaused: ");
      localStringBuilder.append(this.e.isBackgroundPause);
      localStringBuilder.append(", isLandscape: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", isScreenLocked: ");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return (!bool1) && (bool2) && (bool3) && (this.e.isBackgroundPause);
  }
  
  public boolean g(int paramInt, String paramString)
  {
    Object localObject = k();
    String str = SessionMgr.a(3, paramString, new int[0]);
    if (TextUtils.equals(((SessionInfo)localObject).f, str)) {
      return false;
    }
    if ((paramInt == 1011) && (((SessionInfo)localObject).p == paramInt) && (TextUtils.equals(((SessionInfo)localObject).s, paramString))) {
      return false;
    }
    paramInt = this.b.c();
    if (paramInt >= 2)
    {
      paramString = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedAutoRejectDAV, to many session, reject. [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d(paramString, 1, ((StringBuilder)localObject).toString());
      return true;
    }
    if ((((SessionInfo)localObject).h()) && (this.e.t()))
    {
      QLog.i(a, 1, "checkNeedAutoRejectDAV, one in av game and one in invite.");
      return true;
    }
    return false;
  }
  
  public int getAPAndGateWayIP()
  {
    return r();
  }
  
  public long getMSFInviteMessageTimeStamp(long paramLong)
  {
    long l1;
    if (this.z.containsKey(Long.valueOf(paramLong))) {
      l1 = ((Long)this.z.get(Long.valueOf(paramLong))).longValue();
    } else {
      l1 = 0L;
    }
    QLog.d(a, 1, String.format("getMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
    return l1;
  }
  
  public void h(int paramInt)
  {
    if (k().s == null)
    {
      QLog.d(a, 1, "checkNetStatus <--receiveEcho peerUin = null, return!");
      return;
    }
    long l1;
    Object localObject;
    try
    {
      l1 = Long.valueOf(k().s).longValue();
    }
    catch (Exception localException)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNetStatus Long.valueOf(peerUin) Exception= ");
      localStringBuilder.append(localException.getMessage());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      l1 = 0L;
    }
    if ((this.d != null) && (l1 > 0L))
    {
      String str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNetStatus <--receiveEcho netStatus = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 1, ((StringBuilder)localObject).toString());
      this.d.updateNetworkTestResult(l1, paramInt);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.an = paramBoolean;
  }
  
  public boolean h()
  {
    QLog.d(a, 1, String.format("initVcController mVcCtrl=%s", new Object[] { this.d }));
    try
    {
      if (this.d == null)
      {
        String str1 = String.valueOf(AppSetting.d());
        int i1 = r();
        String str2 = this.e.getCurrentAccountUin();
        if (!TextUtils.isEmpty(str2))
        {
          VcControllerImpl localVcControllerImpl = new VcControllerImpl(i(), str1, this.n, this);
          ClientLogReport.instance().setAppInterface(this.e);
          long l1 = CharacterUtil.b(str2);
          Object localObject1 = this.e.getApp().getPackageName();
          String str3 = QQDeviceInfo.getIMEI("62ad83");
          int i2 = CUKingCardUtils.a(str2);
          String str4 = DeviceInfoUtil.c();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str4);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(i2);
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(Build.HARDWARE);
          ((StringBuilder)localObject3).append("_");
          ((StringBuilder)localObject3).append(VcSystemInfo.getCpuModel());
          localObject3 = ((StringBuilder)localObject3).toString();
          if (QLog.isColorLevel()) {
            QLog.i(a, 2, String.format("init, [%s], [%s], [%s], [%s], [%s]", new Object[] { str3, str4, Integer.valueOf(i2), localObject2, localObject3 }));
          }
          String str5 = ResMgr.c();
          str4 = ResMgr.e();
          String str6 = QavSdkConfigHelper.b();
          localVcControllerImpl.init(i(), l1, "8.8.17", Build.MODEL, str1, (String)localObject1, AppSetting.f(), str3, VcSystemInfo.getDeviceName(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, VcSystemInfo.getCPUName(), i1, (String)localObject2, new SDKConfigInfoBuilder().a(), QAVConfigUtils.a(l1), QAVConfigUtils.b(l1), (String)localObject3, str5, str4, str6, QAVConfigUtils.o());
          localVcControllerImpl.updateProcessInfo(0L, "manufacturer", Build.MANUFACTURER);
          str1 = "";
          boolean bool;
          if (str4 != "") {
            bool = true;
          } else {
            bool = false;
          }
          SharedPreUtils.a(bool);
          localObject1 = localVcControllerImpl.postData(5L, null);
          if (localObject1 != null) {
            str1 = new String((byte[])localObject1);
          }
          PerfReporter.a(i(), str2, "8.8.17");
          str2 = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initVcController, SDK BuildNum[");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("]AppSetting.subVersion:=");
          ((StringBuilder)localObject1).append("8.8.17");
          QLog.w(str2, 1, ((StringBuilder)localObject1).toString());
          this.d = localVcControllerImpl;
        }
        else
        {
          QLog.e(a, 1, "initVcController selfUin invalid.");
          AVSoUtils.d();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a, 1, "initVcController fail.", localThrowable);
      this.d = null;
      AVSoUtils.d();
    }
    return this.d != null;
  }
  
  public boolean h(String paramString)
  {
    int i1 = g(paramString);
    return (i1 == 5) || (i1 == 14);
  }
  
  public int i(String paramString)
  {
    Object localObject = SessionMgr.a().b(paramString);
    if ((localObject != null) && (((SessionInfo)localObject).cp != -1)) {
      return ((SessionInfo)localObject).cp;
    }
    localObject = this.d;
    if (localObject != null) {
      return ((VcControllerImpl)localObject).getPeerSdkVersion(paramString);
    }
    return -1;
  }
  
  public Context i()
  {
    if (this.f == null) {
      this.f = this.e.getApp().getApplicationContext();
    }
    return this.f;
  }
  
  public void i(int paramInt)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeVideo timeout. force to exitProcess. closeReason = ");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
    d(261);
  }
  
  public void i(boolean paramBoolean)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectMemberActivityIsResume, IsResume[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mSelectMemberActivityIsResume[");
    localStringBuilder.append(this.ao);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.ao += 1;
      return;
    }
    this.ao -= 1;
    if (this.ao < 0) {
      this.ao = 0;
    }
  }
  
  public int isOfflineSession(String paramString)
  {
    paramString = k();
    if ((paramString != null) && (paramString.l)) {
      return 1;
    }
    return 0;
  }
  
  public int j(boolean paramBoolean)
  {
    if ((!k().j()) && (!this.j)) {
      return 255;
    }
    int i1 = 0;
    Object localObject;
    if (k().g == 1)
    {
      localObject = this.d;
      if (localObject != null) {
        return ((VcControllerImpl)localObject).getVolume(paramBoolean);
      }
    }
    else if (k().g == 3)
    {
      localObject = this.U;
      if (localObject != null) {
        return ((QQGAudioCtrl)localObject).getVolume();
      }
    }
    else
    {
      i1 = this.d.getVolume(paramBoolean);
    }
    return i1;
  }
  
  public IAVEngineCommon j()
  {
    return this.d;
  }
  
  public void j(String paramString)
  {
    this.e.a(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public SessionInfo k()
  {
    return this.b.b();
  }
  
  public void k(String paramString)
  {
    this.e.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public boolean k(boolean paramBoolean)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableLoopback| sessionType=");
    localStringBuilder.append(k().g);
    localStringBuilder.append("enable=");
    localStringBuilder.append(paramBoolean);
    AVLog.printAllUserLog((String)localObject, localStringBuilder.toString());
    if ((k().g != 1) && (k().g != 2))
    {
      if ((k().g == 3) || (k().g == 4))
      {
        localObject = this.U;
        if (localObject != null) {
          return ((QQGAudioCtrl)localObject).enableLoopback(paramBoolean);
        }
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        return ((VcControllerImpl)localObject).enableLoopback(paramBoolean);
      }
    }
    return false;
  }
  
  public void l(String paramString)
  {
    this.e.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void l(boolean paramBoolean)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAIDenoiseStatusChanged | sessionType=");
    localStringBuilder.append(k().g);
    localStringBuilder.append(" enable=");
    localStringBuilder.append(paramBoolean);
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((k().g != 1) && (k().g != 2))
    {
      if ((k().g == 3) || (k().g == 4))
      {
        localObject = this.U;
        if (localObject != null) {
          ((QQGAudioCtrl)localObject).enableAIDenoise(paramBoolean);
        }
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        ((VcControllerImpl)localObject).enableAIDenoise(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    boolean bool;
    if ((this.b.b().B) && ((this.b.b().g == 1) || (this.b.b().g == 2) || ((this.b.b().g == 0) && ((this.b.b().h == 1) || (this.b.b().h == 2))))) {
      bool = true;
    } else {
      bool = false;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckIsDoubleReceiveInviting ret=");
    localStringBuilder.append(bool);
    QLog.d(str, 1, localStringBuilder.toString());
    return bool;
  }
  
  public VideoController.GAudioFriends m(String paramString)
  {
    ArrayList localArrayList = this.aQ;
    Object localObject2 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      try
      {
        if (i1 < this.aQ.size())
        {
          localObject1 = (VideoController.GAudioFriends)this.aQ.get(i1);
          if ((localObject1 == null) || (((VideoController.GAudioFriends)localObject1).a != Long.valueOf(paramString).longValue())) {
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
  
  public EffectsRenderController m(boolean paramBoolean)
  {
    if (!EffectsRenderController.c()) {
      return null;
    }
    if ((this.aS == null) && (paramBoolean)) {
      aO();
    }
    return this.aS;
  }
  
  public boolean m()
  {
    return this.d != null;
  }
  
  public void n(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = at;
    } else {
      i1 = au;
    }
    if (this.av != i1)
    {
      this.av = i1;
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLoadPTuSo, bloadSuc[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public boolean n()
  {
    int i1 = k().p;
    boolean bool2;
    Object localObject2;
    Object localObject1;
    if ((i1 != 21) && (i1 != 22))
    {
      if (i1 == 26) {
        return false;
      }
      i1 = k().h;
      bool2 = true;
      bool1 = bool2;
      if (i1 == 1)
      {
        localObject2 = k().s;
        localObject1 = localObject2;
        if (k().p == 1006)
        {
          localObject1 = localObject2;
          if (!k().B)
          {
            localObject1 = localObject2;
            if (k().u != null) {
              localObject1 = k().u;
            }
          }
        }
      }
    }
    try
    {
      long l1 = CharacterUtil.b((String)localObject1);
      i1 = this.d.hasAVShiftAbility(l1);
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
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not get Number. PeerUin = ");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    boolean bool1 = false;
    if (!bool1)
    {
      i1 = g((String)localObject1);
      i2 = i((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = a;
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
  
  public int o()
  {
    return this.F;
  }
  
  public void o(String paramString)
  {
    long l1 = p(paramString);
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send0x211C2CMsg_Audio_start roomId = ");
    localStringBuilder.append(l1);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (this.e != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AudioEngineReady");
      ((Intent)localObject).putExtra("peerUin", paramString);
      ((Intent)localObject).putExtra("roomId", l1);
      ((Intent)localObject).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject);
      this.e.a(new Object[] { Integer.valueOf(36) });
    }
  }
  
  public void o(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).c();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).b(paramBoolean);
      }
    }
  }
  
  public void onAVShiftEvent(int paramInt, String paramString)
  {
    if ((this.b != null) && (k() != null))
    {
      if (k().s == null) {
        return;
      }
      if (!k().s.equals(paramString)) {
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
            QLog.d(a, 2, "remote confirm switch to video");
          }
          k().aK = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "onAVShiftEvent remote switch to video mode,waiting for confirm");
        }
        k().aK = false;
      }
    }
  }
  
  public void onAcceptVideoMode(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAcceptVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void onAcceptedVideo(String paramString)
  {
    k().a("onAcceptedVideo", 3);
  }
  
  public void onAnotherHaveAccept(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnotherHaveAccept fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    s(true);
    a(paramString, 206);
    b(206);
    b(paramString, 7);
  }
  
  public void onAnotherHaveReject(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnotherIsRing isCalling = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    k().aL = paramBoolean;
    if (paramBoolean) {
      DataReport.o(this);
    }
    if (PhoneStatusTools.e(this.e.getApp())) {
      return;
    }
    a(false, paramBoolean);
  }
  
  public void onAudioVolumeChange(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfAudioVolumeChange dooubleAV.value:=");
      localStringBuilder.append(paramLong1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    try
    {
      this.e.a(new Object[] { Integer.valueOf(20002), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void onAvReqAutoAccept(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAvReqAutoAccept, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.aF;
    if (localObject != null) {
      ((MqqHandler)localObject).post(new VideoController.25(this, paramString));
    }
  }
  
  public void onCancelRequest(String paramString)
  {
    C();
    String str = a;
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
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void onChangePreviewSize(int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.c();
    boolean bool = QavCameraPreviewSizeControl.a();
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangePreviewSize, size[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], localHasVideo[");
    localStringBuilder.append(k().H);
    localStringBuilder.append("], preSize[");
    localStringBuilder.append(AndroidCamera.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(AndroidCamera.c);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], forbiddenReopenCamera[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (bool) {
      return;
    }
    if (k().H)
    {
      localObject = QavCameraPreviewSizeControl.a(paramInt1, paramInt2);
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      paramInt2 = ((Integer)((Pair)localObject).second).intValue();
      if ((AndroidCamera.b != paramInt1) || (AndroidCamera.c != paramInt2)) {
        this.e.a(new Object[] { Integer.valueOf(32), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1) });
      }
    }
  }
  
  public void onChannelReady(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onChannelReady, fromUin[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("], mStartRing[");
      ((StringBuilder)localObject2).append(this.am);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.e == null) {
      return;
    }
    Object localObject1 = k();
    int i2 = ((SessionInfo)localObject1).aQ;
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
      localObject1 = k();
    }
    ((SessionInfo)localObject1).aj = paramInt1;
    ((SessionInfo)localObject1).ak = paramInt2;
    ((SessionInfo)localObject1).al = paramString2;
    Object localObject2 = a;
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
    VideoNodeManager.a(9, ((SessionInfo)localObject1).D());
    VideoNodeManager.a(11, ((SessionInfo)localObject1).s);
    if (this.am != null)
    {
      this.e.a().removeCallbacks(this.am);
      this.am = null;
    }
    SignalStrengthReport.a(i()).a();
    if (1L == ((SessionInfo)localObject1).aq)
    {
      this.v.b(l1);
      if ((((SessionInfo)localObject1).aK) && (((SessionInfo)localObject1).B)) {
        this.v.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      }
      a(true, ((SessionInfo)localObject1).s);
      return;
    }
    this.v.b(l1);
    if (((SessionInfo)localObject1).p != 1011) {
      TraeHelper.a(this.e, true, l1);
    }
    ((SessionInfo)localObject1).c(this.d.getPeerSdkVersion(paramString1));
    ((SessionInfo)localObject1).d(this.d.getPeerTerminalType(paramString1));
    ((SessionInfo)localObject1).e(paramLong);
    C();
    ((SessionInfo)localObject1).k = ((SessionInfo)localObject1).i;
    ((SessionInfo)localObject1).a("onChannelReady", 4);
    ((SessionInfo)localObject1).a(l1, SystemClock.elapsedRealtime());
    if (((SessionInfo)localObject1).B) {
      if (((SessionInfo)localObject1).aK) {
        this.v.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      } else if (!this.v.e()) {
        this.v.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      }
    }
    paramString2 = (VideoNodeReporter)this.e.c(4);
    if (((SessionInfo)localObject1).B) {
      paramInt1 = 11;
    } else {
      paramInt1 = 4;
    }
    paramString2.a(((SessionInfo)localObject1).D(), paramInt1, 1L);
    paramString2 = this.e;
    if ((paramString2 != null) && (paramString2.f() > 0)) {
      this.e.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
    }
    p();
    if (((SessionInfo)localObject1).E) {
      a(true, ((SessionInfo)localObject1).s);
    } else {
      a(false, ((SessionInfo)localObject1).s);
    }
    this.e.a().postDelayed(new VideoController.7(this, l1), 50L);
    a(((SessionInfo)localObject1).f, ((SessionInfo)localObject1).g, true, true, true);
    DataReport.i(this);
    DataReport.d(this, true);
    DataReport.c(this, true);
    paramLong = as();
    paramString2 = SharedPreUtils.e(this.e.getCurrentAccountUin());
    paramString2.edit().putLong("qav_roomid", paramLong).commit();
    paramLong = i(paramString1);
    paramString2.edit().putLong(VideoConstants.o, paramLong).commit();
    s(false);
    paramString1 = this.e.d();
    if (paramString1 != null) {
      paramString1.a();
    }
    if (this.aI != null) {
      this.aI.a();
    }
    paramString1 = this.e.A();
    if (paramString1 != null) {
      paramString1.a((SessionInfo)localObject1);
    }
    paramString1 = (WTogetherMng)this.e.c(17);
    if (paramString1 != null) {
      paramString1.c((SessionInfo)localObject1);
    }
  }
  
  public void onCheckScreenShareAvailable(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckScreenShareValid, isValid[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], detail[");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(521), Integer.valueOf(paramInt), paramArrayOfByte });
  }
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.c();
    Object localObject1 = this.b.c(paramString);
    Object localObject2 = a;
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
    ((StringBuilder)localObject3).append(this.b.b());
    ((StringBuilder)localObject3).append("], come[");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append("]");
    localObject3 = ((StringBuilder)localObject3).toString();
    int i1 = 1;
    QLog.w((String)localObject2, 1, (String)localObject3);
    if (localObject1 == null)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCloseVideo, fromUin[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], no session");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject2 = this.e.d();
    if (localObject2 != null) {
      ((VideoRecoveryMonitor)localObject2).a(paramInt);
    }
    localObject2 = (WTogetherMng)this.e.c(17);
    localObject3 = ((SessionInfo)localObject1).s;
    int i2 = 3;
    ((WTogetherMng)localObject2).a(3, (String)localObject3);
    v(((SessionInfo)localObject1).f);
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
                        ((SessionInfo)localObject1).Q = false;
                        a(l1, paramString, 12);
                        return;
                      }
                      if (paramLong == 61L)
                      {
                        ((SessionInfo)localObject1).Q = false;
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
            if (this.b.a((String)localObject2)) {
              localObject1 = this.b.d((String)localObject2);
            }
            if ((localObject1 != null) && (((SessionInfo)localObject1).i == 1))
            {
              paramString = a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onCloseVideo, set autoAcceptChat, seq[");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append("]");
              QLog.w(paramString, 1, ((StringBuilder)localObject2).toString());
              ((SessionInfo)localObject1).m = true;
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
            if (((SessionInfo)localObject1).g == 2) {
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
          a(((SessionInfo)localObject1).p, ((SessionInfo)localObject1).s, ((SessionInfo)localObject1).bt, 0);
          paramInt = 52;
        }
        if ((paramLong == 12L) || (paramLong == 13L) || (paramLong == 15L) || (paramLong == 16L)) {
          if (((SessionInfo)localObject1).g == 2) {
            ReportController.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
          }
        }
        if (paramInt == 49) {
          s(true);
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
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfigSysDealDone fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2)
  {
    long l1 = AudioHelper.c();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a);
    ((StringBuilder)localObject1).append("|VideoNodeManager");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCreateRoomSuc, relationType[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], groupId[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], mGAudioCtrl[");
    boolean bool;
    if (this.U != null) {
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
    if (this.U == null) {
      return;
    }
    localObject1 = k();
    if (a("onCreateRoomSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject1 = k();
    }
    ((SessionInfo)localObject1).at = true;
    ((SessionInfo)localObject1).au.clear();
    if ((AVUtil.a(paramInt1)) && (this.U.mIsSwitchGroup)) {
      aN();
    }
    for (;;)
    {
      break;
      int i1;
      int i2;
      if (((SessionInfo)localObject1).ci == 5)
      {
        i1 = ((SessionInfo)localObject1).cq;
        i2 = ((SessionInfo)localObject1).cp;
        if (QLog.isColorLevel())
        {
          localObject2 = a;
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
          localObject2 = this.U;
          l2 = ((SessionInfo)localObject1).aN;
          i1 = ((SessionInfo)localObject1).ci;
          ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 4, i1, 0);
        }
        else
        {
          localObject2 = this.U;
          l2 = ((SessionInfo)localObject1).aN;
          i1 = ((SessionInfo)localObject1).ci;
          ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
        }
      }
      else if ((this.U.mInviteGAudioUinList != null) && (this.U.mInviteGAudioUinList.size() > 0))
      {
        i2 = this.U.mInviteGAudioUinList.size();
        localObject2 = new long[i2];
        i1 = 0;
        while (i1 < i2)
        {
          localObject2[i1] = ((Long)this.U.mInviteGAudioUinList.get(i1)).longValue();
          i1 += 1;
        }
        this.U.inviteUser((long[])localObject2, 4, ((SessionInfo)localObject1).ci, 0);
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
          AudioHelper.a(HardCodeUtil.a(2131913327));
          this.U.inviteUser(null, 4, ((SessionInfo)localObject1).ci, 0);
        }
      }
    }
    a("onCreateRoomSuc");
    a("onCreateSuc", true, paramInt1, paramLong);
    ((SessionInfo)localObject1).bC = false;
    if (((SessionInfo)localObject1).am)
    {
      ((SessionInfo)localObject1).e("onCreateRoomSuc", true);
      ((SessionInfo)localObject1).ap = true;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc, MainSession[");
      localStringBuilder.append(k());
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong), Long.valueOf(l1) });
    if ((paramInt1 != 2) && (paramInt1 != 1)) {}
    do
    {
      do
      {
        break;
      } while ((paramInt2 != 10) && (paramInt2 != 1));
      this.aO.clear();
    } while (!QLog.isColorLevel());
    localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InviteMemberList onCreateRoomSuc, request memberList]");
    localStringBuilder.append(0);
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    this.r = 0;
    localObject2 = this.e.A();
    if (localObject2 != null) {
      ((ChatRoomMng)localObject2).a(k());
    }
    if ((((SessionInfo)localObject1).am) || (((SessionInfo)localObject1).aQ == 3))
    {
      localObject2 = aF();
      if (localObject2 != null) {
        ((ScreenShareCtrl)localObject2).a((SessionInfo)localObject1);
      }
    }
  }
  
  public void onDetectAudioDataIssue(int paramInt)
  {
    long l1 = AudioHelper.c();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetectAudioDataIssue, issueType[");
    localStringBuilder.append(this.o);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.o = paramInt;
    this.e.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt), Long.valueOf(l1) });
  }
  
  public void onDoubleVideoMeetingInvite(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.b.c();
    long l1 = AudioHelper.c();
    Object localObject1 = a;
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
    ((StringBuilder)localObject2).append(k());
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (b(paramLong, paramInt1, paramInt2))
    {
      a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
      return;
    }
    localObject1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    this.b.a((String)localObject1, false);
    VideoConstants.b = this.e.l();
    boolean bool2 = a(this.e.getApp().getApplicationContext());
    if ((TextUtils.equals(k().s, String.valueOf(paramLong))) && ((k().j == 16) || (paramInt2 == 5)))
    {
      if (this.K != null)
      {
        this.e.a().removeCallbacks(this.K);
        this.K = null;
      }
      localObject1 = aF();
      if (localObject1 != null) {
        ((ScreenShareCtrl)localObject1).a(l1, paramLong, paramInt1, paramInt2);
      }
      return;
    }
    if ((TextUtils.equals(k().s, String.valueOf(paramLong))) && (k().j == 11))
    {
      if (this.K != null)
      {
        this.e.a().removeCallbacks(this.K);
        this.K = null;
      }
      this.b.d((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
      b(k().s, 2);
    }
    if (k().e())
    {
      if (!this.e.o()) {}
    }
    else
    {
      for (;;)
      {
        bool1 = true;
        break label598;
        if ((!k().m()) && (!k().n()) && (!k().o()))
        {
          if (QLog.isColorLevel()) {
            QLog.e(a, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
          }
          if (bool2) {
            a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          }
        }
        else
        {
          if (!String.valueOf(paramLong).equals(k().s)) {
            break;
          }
          this.b.d((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
          r(true);
          a(k().s, 299);
          b(299);
          b(k().s, 2);
        }
      }
      if ((k().m()) || (k().n())) {
        break label1176;
      }
    }
    boolean bool1 = false;
    label598:
    this.c = true;
    localObject2 = this.b.d((String)localObject1);
    if (localObject2 != null)
    {
      ((SessionInfo)localObject2).aK = true;
      ((SessionInfo)localObject2).h = 2;
      ((SessionInfo)localObject2).p = 0;
      ((SessionInfo)localObject2).aQ = 3;
      ((SessionInfo)localObject2).s = String.valueOf(paramLong);
      ((SessionInfo)localObject2).u = null;
      ((SessionInfo)localObject2).B = true;
      ((SessionInfo)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
      ((SessionInfo)localObject2).f("onDoubleVideoMeetingInvite", true);
      ((SessionInfo)localObject2).aW = String.valueOf(paramLong);
    }
    StringBuilder localStringBuilder;
    if (this.e.m())
    {
      if (QLog.isColorLevel())
      {
        localObject2 = a;
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
      ((Intent)localObject2).setPackage(this.e.getApp().getPackageName());
      this.e.getApp().sendBroadcast((Intent)localObject2);
      localObject2 = (ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class);
      ((ITraeMediaPlayerApi)localObject2).init(this.f, null);
      ((ITraeMediaPlayerApi)localObject2).playRing(l1, 0, 2131230809, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.b.a(l1, (String)localObject1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDoubleVideoMeetingInvite, mOrientation[");
      localStringBuilder.append(this.aA);
      localStringBuilder.append("], isQQPaused[");
      localStringBuilder.append(VideoConstants.b);
      localStringBuilder.append("], isVideoPaused[");
      localStringBuilder.append(this.e.isBackgroundPause);
      localStringBuilder.append("], isScreenLocked[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], isAppOnForeground[");
      localStringBuilder.append(GesturePWDUtils.isAppOnForegroundByTasks(i(), 0));
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    if ((this.aC) && (this.aA == 0) && (!bool2) && (VideoConstants.b) && (this.e.isBackgroundPause))
    {
      this.e.a().postDelayed(new VideoController.30(this, l1, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l1, (String)localObject1, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
    return;
    label1176:
    a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
  }
  
  public void onEnterSuc(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.c();
    Object localObject1 = k();
    if (a("onEnterSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject1 = k();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a);
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
    ((SessionInfo)localObject1).bC = false;
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
      localObject1 = SessionMgr.a().d((String)localObject1);
      if (localObject1 != null)
      {
        ((SessionInfo)localObject1).aS = true;
        ((SessionInfo)localObject1).at = false;
        ((SessionInfo)localObject1).ce = true;
      }
      if ((AVUtil.a(paramInt1)) && (this.U.mIsSwitchGroup)) {
        aN();
      }
    }
    this.e.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l1) });
    if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
    {
      this.aO.clear();
      localObject1 = this.aF;
      if (localObject1 != null) {
        ((MqqHandler)localObject1).post(new VideoController.41(this, paramInt1, paramInt2, paramLong));
      }
    }
    localObject1 = this.e.A();
    if (localObject1 != null) {
      ((ChatRoomMng)localObject1).a(k());
    }
  }
  
  public void onFpsChange(int paramInt)
  {
    if (paramInt >= 20) {
      paramInt = Math.min(30000, paramInt * 1000);
    } else {
      paramInt = 15000;
    }
    int i1 = k().cg;
    if ((i1 != paramInt) && (!Build.MODEL.equalsIgnoreCase("HWI-AL00")))
    {
      if (Build.MODEL.equalsIgnoreCase("VKY-AL00")) {
        return;
      }
      long l1 = AudioHelper.c();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFpsChange, nFps[");
      localStringBuilder.append(i1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      k().cg = paramInt;
      CameraUtils.a(this.f).setCameraWithNewFps(l1, paramInt);
    }
  }
  
  public void onGAudioInvite(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = AudioHelper.c();
    AVLog.printDebugLog("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.e;
    AudioHelper.a(localVideoAppInterface);
    e(false);
    Object localObject2 = k();
    long l2 = p(String.valueOf(paramLong2));
    long l3 = ap();
    if (QLog.isColorLevel())
    {
      localObject1 = a;
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
      ((StringBuilder)localObject3).append(this.j);
      ((StringBuilder)localObject3).append("], mGAudioGroupId[");
      ((StringBuilder)localObject3).append(this.k);
      ((StringBuilder)localObject3).append("], mCurrentInviteId[");
      ((StringBuilder)localObject3).append(this.Y);
      ((StringBuilder)localObject3).append("], mCurrentInviteRelationType[");
      ((StringBuilder)localObject3).append(this.Z);
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
    if (!QAVGroupConfig.a(this.e, paramLong1, paramBoolean))
    {
      QLog.w(a, 1, "onGAudioInvite, forceDisableInviteBox");
      return;
    }
    String str2 = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]);
    if (this.b.a(str2))
    {
      QLog.d(a, 1, "onGAudioInvite, Session already exists");
      return;
    }
    Object localObject1 = this.b.a(str2, false);
    ((SessionInfo)localObject1).aN = paramLong1;
    ((SessionInfo)localObject1).aQ = paramInt1;
    ((SessionInfo)localObject1).o = paramInt2;
    ((SessionInfo)localObject1).bq = false;
    ((SessionInfo)localObject1).aO = paramArrayOfLong;
    ((SessionInfo)localObject1).ci = paramInt4;
    if (((SessionInfo)localObject1).ci == 4) {
      ScreenShareReportHelper.a(((SessionInfo)localObject1).f, 2, "onGAudioInvite");
    }
    if (((IGuildLiveChannelApi)QRoute.api(IGuildLiveChannelApi.class)).checkGuildLiveAvBusinessFocus("频道直播"))
    {
      QLog.i(a, 1, "onGAudioInvite: live author. refused");
      this.U.ignore(paramInt1, paramLong1, 10);
      a(l1, "ignoreGAudioChat_3", str2, 3, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if (e(paramInt1, paramLong1, paramInt3))
    {
      a(l1, "too_much_session", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    VideoConstants.b = localVideoAppInterface.l();
    if (!((SessionInfo)localObject2).e()) {}
    while (localVideoAppInterface.o())
    {
      paramBoolean = true;
      break;
    }
    paramBoolean = false;
    if (this.T != null)
    {
      if (localVideoAppInterface.a() != null) {
        localVideoAppInterface.a().removeCallbacks(this.T);
      }
      this.T = null;
      ((SessionInfo)localObject1).a("onGAudioInvite.1", 0);
    }
    aK();
    boolean bool = a(localVideoAppInterface.getApp().getApplicationContext());
    if (bool)
    {
      if ((((SessionInfo)localObject2).i > 0) && (((SessionInfo)localObject2).i <= 4) && (paramInt3 != 3))
      {
        a(l1, "ScreenLocked_before_connect", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if (7 == ((SessionInfo)localObject2).i)
      {
        a(l1, "ScreenLocked_group_invite", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.j) && (this.k == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", str2, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((SessionInfo)localObject2).i != 14) && (((SessionInfo)localObject2).i != 13))
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
      localObject3 = a;
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
    if (((SessionInfo)localObject1).g == 0)
    {
      ((SessionInfo)localObject1).B = true;
      ((SessionInfo)localObject1).a(l1, "onGAudioInvite.1", 3);
      ((SessionInfo)localObject1).p = UITools.c(paramInt1);
      ((SessionInfo)localObject1).s = String.valueOf(paramLong2);
      if (paramInt1 == 2) {
        ((SessionInfo)localObject1).aW = String.valueOf(paramLong2);
      }
      ((SessionInfo)localObject1).B = true;
      if ((paramInt3 != 3) && (paramInt3 != 4)) {
        a(str2, ((SessionInfo)localObject1).g, false, false, false);
      }
    }
    Object localObject3 = localObject1;
    localObject1 = localObject2;
    this.Y = paramLong1;
    this.Z = paramInt1;
    if (((SessionInfo)localObject3).i == 0) {
      ((SessionInfo)localObject3).a("onGAudioInvite", 7);
    }
    Object localObject4 = "onGAudioInvite";
    localObject2 = localObject1;
    if (paramInt3 == 3)
    {
      if (((SessionInfo)localObject1).aN == 0L)
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
      localObject1 = a;
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
    if (localVideoAppInterface.m())
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "onGAudioInvite, phone is calling");
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
      paramArrayOfLong.putExtra("extraUin", ((SessionInfo)localObject2).u);
      paramArrayOfLong.putExtra("relationId", paramLong1);
      paramArrayOfLong.putExtra("type", 13);
      paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("isSender", false);
      paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("realSenderUin", ((SessionInfo)localObject2).aW);
      localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
      a(l1, this.Z, paramLong1, true);
      paramArrayOfLong = (ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class);
      paramArrayOfLong.init(this.f, null);
      paramArrayOfLong.playRing(l1, 0, 2131230809, null, null, false, 1, false, true, 0);
      this.b.a(l1, str2);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramLong2);
    ((SessionInfo)localObject2).aW = ((StringBuilder)localObject1).toString();
    this.ag = g();
    if (((SessionInfo)localObject3).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfLong = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onGAudioInvite msg blocked [");
        ((StringBuilder)localObject1).append(((SessionInfo)localObject3).f);
        ((StringBuilder)localObject1).append(str1);
        QLog.i(paramArrayOfLong, 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if ((!paramBoolean) && (!VideoUtils.a()) && (!this.e.t()))
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
      ((Intent)localObject1).putExtra("session_id", ((SessionInfo)localObject3).f);
      if ((this.ag) && (SmallScreenUtils.d(localVideoAppInterface.getApplication().getApplicationContext())))
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
    if (localVideoAppInterface.i) {
      localVideoAppInterface.i = false;
    } else {
      VideoNodeManager.a();
    }
    localVideoAppInterface.j = true;
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
      paramMavInviteData = a;
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
    if (k().au != null)
    {
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        if ((((AVInviteAccount)localArrayList.get(i1)).accountType == 1) && (((AVInviteAccount)localArrayList.get(i1)).inviteType == 1) && (!k().au.contains(Long.valueOf(((AVInviteAccount)localArrayList.get(i1)).account)))) {
          k().au.add(Long.valueOf(((AVInviteAccount)localArrayList.get(i1)).account));
        }
        i1 += 1;
      }
    }
    this.e.a(new Object[] { Integer.valueOf(99) });
  }
  
  public void onGAudioKickOut(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.c();
    Object localObject = a;
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
    if ((this.j) && (paramLong == this.k))
    {
      this.ay = true;
      if (paramInt1 == 3)
      {
        paramInt1 = 7;
        a(k().f, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      }
      else
      {
        paramInt1 = 20;
        a(k().f, paramInt2, 20, false, String.valueOf(paramLong), null, false);
      }
      if (paramInt2 == 3000) {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
      } else if (paramInt2 == 1) {
        if (k().o == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
      if (k().am) {
        ReportController.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      localObject = k();
      if ((localObject != null) && (((SessionInfo)localObject).H)) {
        this.e.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      a(this.l, this.k, paramInt1);
      this.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
    }
  }
  
  public void onGAudioMemAllUpdate(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    this.ah.clear();
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
      localGAudioFriends.a = ((AVUserInfo)paramArrayList.get(i1)).account;
      localGAudioFriends.n = ((AVUserInfo)paramArrayList.get(i1)).accountType;
      this.ah.add(localGAudioFriends);
      if (((AVUserInfo)paramArrayList.get(i1)).accountType == 1) {
        ((ArrayList)localObject).add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).account));
      }
      i1 += 1;
    }
    if (((ArrayList)localObject).size() > 0) {
      this.n.a((ArrayList)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGAudioMemAllUpdate, size[");
      ((StringBuilder)localObject).append(this.ah.size());
      ((StringBuilder)localObject).append("]");
      QLog.i(paramArrayList, 2, ((StringBuilder)localObject).toString());
    }
    this.e.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), W(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onGAudioMemAllUpdate(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.ah.clear();
    Integer localInteger = Integer.valueOf(64);
    if (paramArrayOfLong == null)
    {
      this.e.a(new Object[] { localInteger, Long.valueOf(paramLong), W(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramInt2 = 0;
    Object localObject;
    while (paramInt2 < paramArrayOfLong.length)
    {
      localObject = new VideoController.GAudioFriends();
      ((VideoController.GAudioFriends)localObject).a = paramArrayOfLong[paramInt2];
      this.ah.add(localObject);
      paramInt2 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfLong = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGAudioMemAllUpdate, size[");
      ((StringBuilder)localObject).append(this.ah.size());
      ((StringBuilder)localObject).append("]");
      QLog.i(paramArrayOfLong, 2, ((StringBuilder)localObject).toString());
    }
    this.e.a(new Object[] { localInteger, Long.valueOf(paramLong), W(), Integer.valueOf(paramInt1) });
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (paramLong == this.e.getLongAccountUin())
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGAudioMemberMicChanged, uin[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], mGAudioMute[");
        localStringBuilder.append(this.V);
        localStringBuilder.append("], isMicOff[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], mIsMicOffBySelf[");
        localStringBuilder.append(this.ap);
        localStringBuilder.append("]");
        QLog.w(str, 2, localStringBuilder.toString());
      }
      if ((paramBoolean != this.V) && (!this.ap))
      {
        int i1 = D();
        a("onGAudioMemberMicChanged", this.k, paramBoolean ^ true, false, -1);
        a(-1L, i1, D());
      }
    }
    this.e.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (bool)) {
      onGAudioUserAudioSuspectNoisy(0L, false, 0L);
    }
  }
  
  public void onGAudioMicSetByAdmin(long paramLong, int paramInt)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioMicSetByAdmin, manager uin[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], old micAuthByAdmin[");
    localStringBuilder.append(k().aV);
    localStringBuilder.append("], new micAuthByAdmin[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mIsMicOffBySelf[");
    localStringBuilder.append(this.ap);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    k().f("onGAudioMicSetByAdmin", paramInt);
    if (paramInt == 2) {
      return;
    }
    if ((paramLong == this.e.getLongAccountUin()) || (paramInt != 0))
    {
      int i1 = D();
      long l1 = this.k;
      boolean bool1;
      if (paramInt == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (this.e.getLongAccountUin() == paramLong) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      a("onGAudioMicSetByAdmin", l1, bool1, bool2, -1);
      a(-1L, i1, D());
    }
    this.e.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  public void onGAudioRoomDestroy(int paramInt, long paramLong)
  {
    String str = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    Object localObject1 = null;
    if (this.b.a(str)) {
      localObject1 = this.b.d(str);
    }
    long l1 = AudioHelper.c();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = a;
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
    Object localObject2 = this.v;
    if (localObject2 != null) {
      ((TraeHelper)localObject2).b(l1);
    }
    TraeHelper.b(this.e);
    TraeHelper.a().d();
    if ((AudioHelper.e()) || (((SessionInfo)localObject1).bC))
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioRoomDestroy, \nmainsession[");
      localStringBuilder.append(k());
      localStringBuilder.append("], \nstate[");
      localStringBuilder.append(((SessionInfo)localObject1).i);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], isAcceptingMultiAV[");
      localStringBuilder.append(((SessionInfo)localObject1).bC);
      localStringBuilder.append("], isCurJoinedGRoom[");
      localStringBuilder.append(a(paramInt, paramLong));
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    if (((SessionInfo)localObject1).bC) {
      return;
    }
    if (this.Y == paramLong)
    {
      this.Y = 0L;
      this.Z = 0;
    }
    if ((paramInt == 3) && (((SessionInfo)localObject1).am) && ((((SessionInfo)localObject1).s == null) || (paramLong != Long.valueOf(((SessionInfo)localObject1).s).longValue())))
    {
      if (QLog.isColorLevel())
      {
        str = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = ");
        ((StringBuilder)localObject2).append(((SessionInfo)localObject1).s);
        ((StringBuilder)localObject2).append(" ,relationId = ");
        ((StringBuilder)localObject2).append(paramLong);
        QLog.d(str, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if ((!((SessionInfo)localObject1).bq) && (!((SessionInfo)localObject1).am))
    {
      int i1;
      if (((SessionInfo)localObject1).i == 7) {
        i1 = 5;
      } else {
        i1 = 6;
      }
      a("onGAudioRoomDestroy", str, UITools.c(paramInt), this.e.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((SessionInfo)localObject1).aW, false, false);
    }
    if (a(paramInt, paramLong)) {
      a(paramInt, paramLong, 69);
    }
    ((SessionInfo)localObject1).a("onGAudioRoomDestroy", 0);
    this.e.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
    this.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
    if (this.b.a(str))
    {
      if (paramInt == 3)
      {
        localObject1 = this.b.d(str);
        paramInt = UITools.c(paramInt);
        a(((SessionInfo)localObject1).f, paramInt, 10, true, String.valueOf(paramLong), null, true);
      }
      if (this.b.a(l1, str))
      {
        localObject1 = QAVNotification.a(this.e);
        if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
        {
          ((QAVNotification)localObject1).a(str);
          p();
        }
      }
    }
    this.aO.clear();
    T();
  }
  
  public void onGAudioRoomMicModeChanged(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if ((paramBoolean2) && (k().aV != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGAudioRoomMicModeChanged, manager uin[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], old isRoomMicOff[");
    localStringBuilder.append(k().aU);
    localStringBuilder.append("], new isRoomMicOff[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], mIsMicOffBySelf[");
    localStringBuilder.append(this.ap);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("], micAuthByAdmin[");
    localStringBuilder.append(k().aV);
    localStringBuilder.append("], isCreateRoomOrEnterRoom[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], bNeedUpdateMic[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    k().c("onGAudioRoomMicModeChanged", paramBoolean1);
    if ((bool) && (!this.ap) && ((paramLong != this.e.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
    {
      int i1 = D();
      a("onGAudioRoomMicModeChanged", this.k, paramBoolean1 ^ true, false, -1);
      a(-1L, i1, D());
    }
    this.e.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
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
    this.e.a(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void onGAudioTerminalEnterRoom(int paramInt, long paramLong, int... paramVarArgs)
  {
    Object localObject = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    paramVarArgs = (int[])localObject;
    if (!this.b.a((String)localObject))
    {
      paramVarArgs = (int[])localObject;
      if (paramInt == 3) {
        paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
      }
    }
    localObject = this.b.d(paramVarArgs);
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = a;
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
    if ((localObject != null) && ((((SessionInfo)localObject).i == 7) || (((SessionInfo)localObject).i == 2)))
    {
      ((SessionInfo)localObject).a("onGAudioTerminalEnterRoom", 0);
      this.e.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
      if (this.b.a(paramVarArgs))
      {
        localObject = this.b.d(paramVarArgs);
        int i1 = UITools.c(paramInt);
        if (paramInt == 3) {
          a(((SessionInfo)localObject).f, i1, 7, true, String.valueOf(paramLong), null, false);
        } else if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.e.getCurrentAccountUin(), String.valueOf(paramLong), 4, ((SessionInfo)localObject).aW, true, false);
        }
        this.b.a(l1, paramVarArgs);
      }
    }
  }
  
  public void onGAudioUserAudioSuspectNoisy(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArrayList localArrayList = a(paramLong1, paramBoolean, paramLong2);
    if (localArrayList != null) {
      this.e.a(new Object[] { Integer.valueOf(142), localArrayList, Integer.valueOf(localArrayList.size()) });
    }
    if (paramLong1 == Long.valueOf(this.e.getCurrentAccountUin()).longValue())
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
      QLog.d(a, 2, "onGVideoDownloadChannelCtlChanged start");
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
        if (k().bM == 3) {
          i1 = 1;
        }
        if (i1 != 0) {
          b(true);
        }
      }
    }
  }
  
  public void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.c();
    k().a(l1, "onGaGoOffStageResult", false, false);
    VideoAppInterface localVideoAppInterface = this.e;
    if (localVideoAppInterface != null)
    {
      long l2 = Long.valueOf(localVideoAppInterface.getCurrentAccountUin()).longValue();
      this.e.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
  }
  
  public void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.c();
    SessionInfo localSessionInfo = k();
    if (paramInt2 == 3) {
      str = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    } else {
      str = SessionMgr.a(paramInt2, String.valueOf(paramLong2), new int[0]);
    }
    boolean bool = TextUtils.equals(localSessionInfo.f, str);
    if ((bool) && (!QLog.isDevelopLevel())) {
      break label216;
    }
    String str = a;
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
    localStringBuilder.append(localSessionInfo.f);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    label216:
    if (!bool) {
      return;
    }
    if (this.e == null) {
      return;
    }
    if (paramInt1 == 90)
    {
      if (paramLong1 == 3L)
      {
        k().a(l1, "onGaGoOnStageResult.1", true, false);
      }
      else
      {
        k().a(l1, "onGaGoOnStageResult.2", false, false);
        this.e.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
    }
    else
    {
      k().a(l1, "onGaGoOnStageResult.3", false, false);
      this.e.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
    long l2 = Long.valueOf(this.e.getCurrentAccountUin()).longValue();
    this.e.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
  }
  
  public void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.c();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
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
      if (k().bl.size() > 0)
      {
        k().a(l1, "onGaSwitchVideoResult", true, true);
        this.i = true;
        int i1 = 0;
        while (i1 < k().bi.size())
        {
          localObject1 = (VideoViewInfo)k().bi.get(i1);
          int i2;
          if ((d()) && (((VideoViewInfo)localObject1).b != 1)) {
            i2 = 0;
          } else {
            i2 = 1;
          }
          if ((((VideoViewInfo)localObject1).a != Long.valueOf(this.e.getCurrentAccountUin()).longValue()) || (i2 == 0))
          {
            if (a(((VideoViewInfo)localObject1).a, ((VideoViewInfo)localObject1).b, k().bl)) {
              ((VideoViewInfo)localObject1).d = true;
            }
          }
          else {
            break label300;
          }
          ((VideoViewInfo)localObject1).d = false;
          label300:
          i1 += 1;
        }
        k().bl.clear();
        k().b(Long.valueOf(this.e.getCurrentAccountUin()).longValue(), false, true);
        localObject1 = a(k().bi);
        if (QLog.isColorLevel())
        {
          localObject2 = a;
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
      this.i = false;
      k().b(Long.valueOf(this.e.getCurrentAccountUin()).longValue(), true, true);
      k().bl.clear();
    }
    label445:
    Object localObject1 = this.e;
    if (localObject1 != null) {
      ((VideoAppInterface)localObject1).a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
  }
  
  public void onGroundGlassSwitch(String paramString, int paramInt)
  {
    this.e.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  public void onGroundGlassWaitTimeChange(String paramString, int paramInt)
  {
    this.e.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
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
      k().ba = paramInt2;
      d(paramInt1, paramLong, paramInt2);
      return;
    case 102: 
    case 103: 
      c(paramInt1, paramLong, paramInt2);
      return;
    }
    k().bb = true;
    d(paramInt1, paramLong, paramInt2);
  }
  
  public void onGroupSecurityLimit(long paramLong1, long paramLong2, String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGroupSecurityLimit, mGAudioInRoom[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], info[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], strMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((this.j) && (this.k == paramLong1))
    {
      a(1, paramLong1, 82);
    }
    else
    {
      this.e.a().removeCallbacks(this.af);
      this.af = null;
      k().a("onGroupSecurityLimit", 0);
      onGAudioSDKError(1, paramLong1, 17, 0);
    }
    this.e.a(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
  }
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGroupVideoClosed, relationId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("], bKickout[");
    localStringBuilder.append(this.ay);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], mGAudioGroupId[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.ay) {
      return;
    }
    if ((this.j) && (this.k == paramLong))
    {
      a(1, paramLong, 83);
    }
    else
    {
      this.e.a().removeCallbacks(this.af);
      this.af = null;
      k().a("onGroupVideoClosed", 0);
      a(paramInt1, paramLong, 17, 0, paramInt2);
    }
    this.e.a(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void onHowling()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onHowling");
    }
    this.U.setHowlingDetectEnable(false);
    if (ConfigSystemImpl.e(this.f))
    {
      boolean bool1 = H();
      if (!bool1)
      {
        int i1 = D();
        a("onHowling", this.k, false, false, -1);
        a(-1L, i1, D());
        this.e.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = k().aG;
      if (bool2) {
        this.v.g();
      }
      Context localContext = this.f;
      PopupDialog.c(localContext, 230, null, localContext.getString(2131893375), 2131887648, 2131892267, new VideoController.42(this), new VideoController.43(this, bool1, bool2));
      ReportController.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void onInitAIDenoiseStatus()
  {
    QLog.w(a, 1, "onInitAIDenoiseStatus");
    if (SharedPreUtils.b())
    {
      Object localObject;
      if ((k().g != 1) && (k().g != 2))
      {
        if ((k().g == 3) || (k().g == 4))
        {
          localObject = this.U;
          if (localObject != null) {
            ((QQGAudioCtrl)localObject).enableAIDenoise(SharedPreUtils.d());
          }
        }
      }
      else
      {
        localObject = this.d;
        if (localObject != null) {
          ((VcControllerImpl)localObject).enableAIDenoise(SharedPreUtils.c());
        }
      }
    }
  }
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.c();
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onInviteReached, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], friend_state[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], extraParam0[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], subState[");
    localStringBuilder.append(k().aq);
    localStringBuilder.append("], mStartRing[");
    localStringBuilder.append(this.am);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    k().ar = null;
    if (k() != null) {
      if (0L == k().aq)
      {
        if (0L != paramLong) {
          if (1L == paramLong)
          {
            k().aq = 1L;
            if (paramArrayOfByte != null)
            {
              k().ar = new String(paramArrayOfByte);
              if (QLog.isColorLevel())
              {
                paramArrayOfByte = a;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("onInviteReached :");
                ((StringBuilder)localObject).append(k().ar);
                QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
              }
              paramArrayOfByte = this.e;
              if (paramArrayOfByte != null) {
                paramArrayOfByte.a(new Object[] { Integer.valueOf(400), k().ar });
              }
            }
          }
          else if (2L == paramLong)
          {
            k().aq = 2L;
            if (paramArrayOfByte != null) {
              k().ar = new String(paramArrayOfByte);
            }
          }
        }
      }
      else if (1L == k().aq)
      {
        if (0L == paramLong)
        {
          k().aq = 0L;
          return;
        }
        if (1L == paramLong) {
          return;
        }
        if (2L == paramLong)
        {
          k().aq = 0L;
          a(l1);
          return;
        }
      }
    }
    if ((k() != null) && (k().j()))
    {
      QLog.w(a, 1, "onInviteReached, isConnected");
      return;
    }
    int i1 = 0x80000 & paramInt;
    if ((i1 > 0) && (this.S))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "onInviteReached :has get phone state");
      }
      return;
    }
    if (i1 == 0) {
      this.S = true;
    }
    k().W = 0;
    if ((0x10000 & paramInt) > 0)
    {
      i1 = 0x40000 & paramInt;
      k().U = (0x20000 & paramInt);
      k().V = i1;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onInviteReached pcOnLine:");
        ((StringBuilder)localObject).append(k().U);
        ((StringBuilder)localObject).append(" # phoneOnLine = ");
        ((StringBuilder)localObject).append(k().V);
        QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
      }
      if (((0x100000 & paramInt) > 0) && (i1 > 0))
      {
        if ((paramInt & 0xFFFF & 0x1) > 0) {
          k().W = 1;
        }
        if (this.am != null)
        {
          paramArrayOfByte = this.e;
          if (paramArrayOfByte != null) {
            paramArrayOfByte.a().removeCallbacks(this.am);
          }
          this.am = null;
        }
        if (this.e != null) {
          if ((k() != null) && (k().aq == 1L) && (!TextUtils.isEmpty(k().ar))) {
            this.e.a(new Object[] { Integer.valueOf(30), paramString, k().ar });
          } else {
            this.e.a(new Object[] { Integer.valueOf(30), paramString });
          }
        }
        if (!k().br) {
          b(l1);
        }
      }
      else
      {
        paramInt &= 0xFFFF;
        if ((paramInt & 0x2) > 0)
        {
          k().W = 2;
        }
        else if ((paramInt & 0x4) > 0)
        {
          k().W = 3;
          ReportController.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
        }
        else if ((paramInt & 0x8) > 0)
        {
          k().W = 4;
        }
        if (QLog.isColorLevel())
        {
          paramString = a;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("onInviteReached low 16bit value is");
          paramArrayOfByte.append(paramInt);
          QLog.d(paramString, 2, paramArrayOfByte.toString());
        }
      }
      k().Q = true;
      return;
    }
    k().U = 0;
    k().V = 0;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "pc and phone both not online");
    }
    if (this.am != null)
    {
      paramString = this.e;
      if (paramString != null) {
        paramString.a().removeCallbacks(this.am);
      }
      this.am = null;
    }
    t(true);
    k().Q = false;
    a(k().s, 210);
    b(210);
    this.T = new VideoController.24(this, l1);
    if (this.T != null)
    {
      paramString = this.e;
      if (paramString != null) {
        paramString.a().postDelayed(this.T, 2000L);
      }
    }
  }
  
  public void onKickOutFail(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
    this.e.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(false), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void onKickOutSuc(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
    this.e.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(true), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
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
        if (k().a(paramAVUserInfo.account) != null)
        {
          localObject1 = k().a(paramAVUserInfo.account);
          if (QLog.isColorLevel())
          {
            localObject2 = a;
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
          k().a((AVPhoneUserInfo)localObject1);
          this.n.a(paramAVUserInfo.account);
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
      QLog.e(a, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
    }
  }
  
  public void onMediaCameraNotify(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramLong == 0L)
    {
      k().aI = false;
    }
    else if (paramLong == 1L)
    {
      k().aI = true;
    }
    else if (paramLong == 100L)
    {
      k().aJ = false;
    }
    else if (paramLong == 101L)
    {
      k().aJ = true;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        break label103;
      }
    }
    else
    {
      k().aI = false;
      k().aJ = false;
    }
    paramArrayOfByte = null;
    label103:
    this.e.a(new Object[] { Integer.valueOf(27), paramArrayOfByte });
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder;
    if (paramArrayOfLong == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfLong = a;
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
          QLog.e(a, 2, localStringBuilder.toString());
          return;
        case 79: 
          a(paramLong1, l1, false, paramInt2, false, paramLong2, paramInt3);
          ScreenShareReportHelper.b(SessionMgr.a().b().f, "MEMBER_SHARE_SCREEN_OUT");
          return;
        case 78: 
          if (QLog.isColorLevel())
          {
            paramArrayOfLong = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onMultiVideoChatMembersInfoChange = userUin:");
            localStringBuilder.append(l1);
            localStringBuilder.append("curuin:");
            localStringBuilder.append(this.e.getCurrentAccountUin());
            QLog.d(paramArrayOfLong, 2, localStringBuilder.toString());
          }
          if (l1 != this.e.getLongAccountUin()) {
            a(paramLong1, l1, paramInt2, paramLong2, paramInt3);
          } else {
            a(paramLong1, l1, true, paramInt2, false, paramLong2, paramInt3);
          }
          ScreenShareReportHelper.a(SessionMgr.a().b().f, "MEMBER_SHARE_SCREEN_IN");
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
    long l1 = AudioHelper.c();
    SessionInfo localSessionInfo = k();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNeedShowPeerVideo, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(localSessionInfo.s);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(localSessionInfo.u);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(localSessionInfo.I);
    localStringBuilder.append("], mXiaoweiDevice[");
    localStringBuilder.append(this.ad);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((!TextUtils.equals(localSessionInfo.s, paramString)) && (!TextUtils.equals(localSessionInfo.u, paramString)) && (!this.ad)) {
      return;
    }
    if ((localSessionInfo.h == 1) && (!n()))
    {
      AVLog.printAllUserLog(a, "onNeedShowPeerVideo, !canAVShift()");
      return;
    }
    if (!localSessionInfo.I)
    {
      localSessionInfo.c(l1, true);
      this.e.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      this.e.a(new Object[] { Integer.valueOf(29) });
      DataReport.m(this);
      if (localSessionInfo.g == 1)
      {
        localSessionInfo.a(l1, "onNeedShowPeerVideo", 2);
        localSessionInfo.aK = false;
      }
    }
    else
    {
      this.e.a(new Object[] { Integer.valueOf(29) });
    }
    if (!TextUtils.equals(localSessionInfo.s, paramString)) {
      GraphicRenderMgr.getInstance().onUinChanged(localSessionInfo.s, paramString);
    }
    if ((!localSessionInfo.H) && (!localSessionInfo.I))
    {
      c(1);
      return;
    }
    c(2);
  }
  
  public void onNetLevel_S2C(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.e.a(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  public void onNetworkDisconnect(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkDisconnect fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(20) });
  }
  
  public void onNetworkInfo_S2C(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = a;
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
        this.e.a(new Object[] { Integer.valueOf(31), Integer.valueOf((int)paramLong), str });
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject = a;
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
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkInfo_S2C fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", info = ");
      localStringBuilder.append(paramArrayOfByte);
      QLog.d((String)localObject, 2, localStringBuilder.toString(), localNullPointerException);
    }
    else
    {
      this.e.a(new Object[] { Integer.valueOf(31), Integer.valueOf(0), null });
    }
  }
  
  public void onNetworkQualityChanged(int paramInt)
  {
    if (k().g != 2) {
      return;
    }
    try
    {
      this.e.a(new Object[] { Integer.valueOf(10003), Integer.valueOf(paramInt) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void onNotRecvAudioData(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotRecvAudioData bNotRecv = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (!k().F) {
        this.e.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(true) });
      }
      this.g = false;
      return;
    }
    this.g = true;
    this.e.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(false) });
  }
  
  public void onNotifyAIDenoiseTips(boolean paramBoolean)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotifyAIDenoiseTips, isFromlocal[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.e.a(new Object[] { Integer.valueOf(100), Boolean.valueOf(paramBoolean) });
  }
  
  public void onNotifyRecvAvatar2d(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      this.e.a(new Object[] { Integer.valueOf(524), paramString, paramArrayOfByte });
    }
  }
  
  public void onNotifyRecvAvatar2dSwitchPeer(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject2 = this.e;
    if (paramArrayOfByte == null) {
      localObject1 = "";
    } else {
      localObject1 = new String(paramArrayOfByte);
    }
    ((VideoAppInterface)localObject2).a(new Object[] { Integer.valueOf(523), paramString, Boolean.valueOf(paramBoolean), localObject1 });
    Object localObject1 = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onNotifyRecvAvatar2dSwitchPeer, fromUin[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("], enable [");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], width [");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("], height [");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("], materialID [");
    ((StringBuilder)localObject2).append(paramArrayOfByte);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramString = new String(paramArrayOfByte, "UTF-8");
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
        break label225;
      }
    } else {
      QLog.w(a, 1, "onNotifyRecvAvatar2dSwitchPeer , materialID null");
    }
    label225:
    paramString = "";
    paramArrayOfByte = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onNotifyRecvAvatar2dSwitchPeer , mID [");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("]");
    QLog.w(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
  }
  
  public void onOpenMicFail()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 2, "WL_DEBUG onOpenMicFail");
    }
    Object localObject = this.f;
    if (localObject != null) {
      QQToast.makeText((Context)localObject, 2131893467, 1).show();
    }
    localObject = k();
    if (localObject != null)
    {
      if (((SessionInfo)localObject).aQ == 1) {
        localObject = "0x8007CB5";
      } else {
        localObject = "0x8007CB6";
      }
      DoodleUtils.a((String)localObject);
    }
  }
  
  public void onOtherTerminalChatingStatus(String paramString, long paramLong, int paramInt)
  {
    long l1 = AudioHelper.c();
    Object localObject = a;
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
      localObject = this.b.d((String)localObject);
      if (localObject != null) {
        ((SessionInfo)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
      }
      if ((paramInt != 0) && (!TextUtils.isEmpty(k().s)) && ((!k().s.equals(paramString)) || (k().g == 0)))
      {
        this.d.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
        QLog.d(a, 1, "onOtherTerminalChatingStatus sendQueryRoomInfoRequest");
      }
      a(0, paramString, paramLong, paramInt);
    }
  }
  
  public void onPPTInOrOut(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    VideoController.GAudioFriends localGAudioFriends = m(String.valueOf(paramLong2));
    if (localGAudioFriends == null) {
      return;
    }
    if (paramInt2 == 1) {
      return;
    }
    if ((paramInt2 == 3) || (paramInt2 == 4)) {
      localGAudioFriends.g = false;
    }
  }
  
  public void onPauseAudio(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPauseAudio fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", remoteMute = ");
      localStringBuilder.append(k().F);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!k().F)
    {
      k().F = true;
      this.e.a(new Object[] { Integer.valueOf(17) });
    }
  }
  
  public void onPauseVideo(String paramString)
  {
    SessionInfo localSessionInfo = k();
    long l1 = AudioHelper.c();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseVideo, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(localSessionInfo.I);
    localStringBuilder.append("], isOnlyAudio[");
    localStringBuilder.append(localSessionInfo.aK);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (Utils.a(BaseApplication.getContext()) == 1)
    {
      localSessionInfo.c(l1, false);
      return;
    }
    if ((localSessionInfo.g == 2) && (localSessionInfo.I))
    {
      localSessionInfo.c(l1, false);
      if (!localSessionInfo.H)
      {
        localSessionInfo.aK = true;
        localSessionInfo.a(l1, "onPauseVideo", 1);
        c(localSessionInfo.g);
      }
      this.e.a(new Object[] { Integer.valueOf(15) });
      DataReport.n(this);
    }
  }
  
  public void onPeerSwitchTerminal(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = a;
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
    localObject = this.e;
    if (localObject != null) {
      ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    k().bs = true;
    paramString = SessionMgr.a().b(paramString);
    if (paramString != null)
    {
      paramString.c(paramInt2);
      paramString.d(paramInt1);
      paramString.e(paramLong);
    }
    a("onPeerSwitchTerminal", k());
    localObject = this.e;
    if (localObject != null) {
      ((WTogetherMng)((VideoAppInterface)localObject).c(17)).e(paramString);
    }
  }
  
  public void onPeerSwitchTerminalFail(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminalFail fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", info :");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    a("onPeerSwitchTerminalFail", k());
    this.e.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void onPstnCallConnected(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    paramLong = AudioHelper.c();
    if ((paramInt == 1) && (1L == k().aq))
    {
      k().aq = 0L;
      a(paramLong);
    }
  }
  
  public void onRecSharePushEncParam(int paramInt, long paramLong, RecordParam paramRecordParam)
  {
    ScreenShareCtrl localScreenShareCtrl = this.aY;
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramInt, paramLong, paramRecordParam);
    }
  }
  
  public void onRecordAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
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
      localObject = this.aD;
      if ((localObject != null) && (localObject[0] != null)) {
        localObject[0].onReceiveAudioFrame(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    else if ((paramInt1 == 3) || (paramInt1 == 0) || (paramInt1 == 8))
    {
      localObject = this.aD;
      if ((localObject != null) && (localObject[1] != null)) {
        localObject[1].onReceiveAudioFrame(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    if (AudioDump.c()) {
      AudioDump.a().onReceiveAudioFrame(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void onRecvFirstAudioData(boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvFirstAudioData, recvFirstAudio[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    PerfReporter.a();
    aL();
    if (paramBoolean)
    {
      if (k().aK)
      {
        localObject = this.d;
        if (localObject != null) {
          if (-1 == ((VcControllerImpl)localObject).switchAudio(k().s)) {
            this.E = false;
          } else {
            this.E = true;
          }
        }
      }
      else
      {
        this.E = true;
      }
      this.g = true;
      this.e.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean), Long.valueOf(l1) });
    }
  }
  
  public void onRejectVideo(String paramString)
  {
    String str = a;
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
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRejectVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2)
  {
    SessionInfo localSessionInfo = k();
    if (localSessionInfo.by) {
      return;
    }
    if (!localSessionInfo.a(paramLong, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRemoteVideoDataComeIn-->uin = ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(", videoSrcType=");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      paramInt1 = 0;
      while (paramInt1 < localSessionInfo.bi.size())
      {
        if ((((VideoViewInfo)localSessionInfo.bi.get(paramInt1)).a == paramLong) && (((VideoViewInfo)localSessionInfo.bi.get(paramInt1)).b == paramInt2)) {
          ((VideoViewInfo)localSessionInfo.bi.get(paramInt1)).f = true;
        }
        paramInt1 += 1;
      }
      this.e.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    }
  }
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    boolean bool2 = this.n.a(paramString1);
    long l2 = AudioHelper.c();
    Object localObject1 = a;
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
    localObject1 = this.e;
    if (localObject1 != null)
    {
      if (((VideoAppInterface)localObject1).getApp() == null) {
        return;
      }
      this.n.b();
      aK();
      VideoConstants.b = this.e.l();
      AudioHelper.a(this.e);
      int i1 = QAVNotificationUtil.a(this.e, paramInt1, paramString1, paramInt2);
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onRequestVideo converted uinType = ");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(",sdkAVAccostType = ");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(VideoConstants.b);
        ((StringBuilder)localObject2).append(", isVideoPaused: ");
        ((StringBuilder)localObject2).append(this.e.isBackgroundPause);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      bool1 = ((IGuildLiveChannelApi)QRoute.api(IGuildLiveChannelApi.class)).checkGuildLiveAvBusinessFocus("频道直播");
      if (bool1) {
        QLog.i(a, 1, "onRequestVideo: live author. refused");
      }
      if ((!g(i1, paramString1)) && (!bool1))
      {
        localObject2 = k();
        localObject1 = SessionMgr.a(3, paramString1, new int[0]);
        if ((TextUtils.equals((CharSequence)localObject1, ((SessionInfo)localObject2).f)) && (((SessionInfo)localObject2).m))
        {
          ((SessionInfo)localObject2).B = true;
          paramBoolean = ((SessionInfo)localObject2).aK;
          paramString2 = a;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("onRequestVideo, autoAcceptChat, seq[");
          paramArrayOfByte.append(l2);
          paramArrayOfByte.append("]");
          QLog.w(paramString2, 1, paramArrayOfByte.toString());
          a(l2, paramString1, paramBoolean ^ true, ((SessionInfo)localObject2).aQ);
          return;
        }
        boolean bool3 = a(this.e.getApp().getApplicationContext());
        Object localObject3 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRequestVideo->isScreenLocked:");
        localStringBuilder.append(bool3);
        QLog.w((String)localObject3, 1, localStringBuilder.toString());
        if (((SessionInfo)localObject2).e())
        {
          if (i1 == -1)
          {
            this.d.ignoreVideo(paramString1, r());
            QLog.w(a, 1, "closeVideo uinType == -1");
            this.d.closeVideo(paramString1, 0, this);
            paramString1 = this.e.d();
            if (paramString1 != null) {
              paramString1.a(0);
            }
            return;
          }
          if (!this.e.o()) {}
        }
        label981:
        do
        {
          int i2;
          do
          {
            do
            {
              bool1 = true;
              break label1017;
              break label1014;
              if ((((SessionInfo)localObject2).m()) || (((SessionInfo)localObject2).n())) {
                break label1004;
              }
              if (((SessionInfo)localObject2).i == 7) {
                if (this.Y != 0L) {
                  break label981;
                }
              }
              i2 = i1;
              if ((((SessionInfo)localObject2).i == 14) || (((SessionInfo)localObject2).i == 13)) {
                break label981;
              }
              if (this.j) {
                break;
              }
              localObject3 = a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onRequestVideo when chatting: fromUin = ");
              localStringBuilder.append(paramString1);
              localStringBuilder.append("|");
              localStringBuilder.append(bool3);
              QLog.w((String)localObject3, 1, localStringBuilder.toString());
              if ((((SessionInfo)localObject2).s != null) && (paramString1.equals(((SessionInfo)localObject2).s)))
              {
                paramString2 = a;
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append("onRequestVideo when request: fromUin = ");
                paramArrayOfByte.append(paramString1);
                QLog.w(paramString2, 1, paramArrayOfByte.toString());
                aw();
                s(paramString1);
                return;
              }
            } while (!bool3);
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
            localObject2 = a;
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
        label1004:
        b(((SessionInfo)localObject2).s, 2);
        label1014:
        bool1 = false;
        label1017:
        this.b.a((String)localObject1, false);
        localObject2 = this.b.d((String)localObject1);
        ((SessionInfo)localObject2).az = paramInt2;
        ((SessionInfo)localObject2).aB = paramString3;
        ((SessionInfo)localObject2).aH = paramArrayOfByte;
        ((SessionInfo)localObject2).aA = i1;
        if (this.T != null)
        {
          this.e.a().removeCallbacks(this.T);
          this.T = null;
          ((SessionInfo)localObject2).a("onRequestVideo.1", 0);
        }
        if (this.n.d()) {
          i1 = 9500;
        }
        this.c = true;
        ((SessionInfo)localObject2).aK = paramBoolean;
        if (paramBoolean) {
          ((SessionInfo)localObject2).h = 1;
        } else {
          ((SessionInfo)localObject2).h = 2;
        }
        long l1 = p(paramString1);
        paramString3 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onRequestVideo  ,roomId = ");
        ((StringBuilder)localObject3).append(l1);
        QLog.w(paramString3, 1, ((StringBuilder)localObject3).toString());
        ((SessionInfo)localObject2).e(l1);
        ((SessionInfo)localObject2).p = i1;
        ((SessionInfo)localObject2).r = paramInt1;
        ((SessionInfo)localObject2).s = paramString1;
        ((SessionInfo)localObject2).u = paramString2;
        ((SessionInfo)localObject2).B = true;
        ((SessionInfo)localObject2).a("onRequestVideo.2", 2);
        ((SessionInfo)localObject2).Z = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (VideoNodeReporter)this.e.c(4);
        if (paramBoolean) {
          paramInt1 = 1;
        } else {
          paramInt1 = 2;
        }
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        long l3 = p(paramString1);
        VideoNodeManager.a(l3, 36);
        VideoNodeManager.a(l3, 9, ((SessionInfo)localObject2).D());
        VideoNodeManager.a(l3, 11, paramString1);
        VideoNodeManager.a(l3, 12, 2L);
        if (((SessionInfo)localObject2).aK) {
          l1 = 1L;
        } else {
          l1 = 2L;
        }
        VideoNodeManager.a(l3, 13, l1);
        VideoNodeManager.a(l3, 15, 1L);
        s(paramString1);
        if (bool2)
        {
          ((SessionInfo)localObject2).l = true;
          b(l2, (String)localObject1, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
          return;
        }
        if ((!this.j) && (((SessionInfo)localObject2).p != 21) && (((SessionInfo)localObject2).p != 1011)) {
          a((String)localObject1, ((SessionInfo)localObject2).h, false, false, true);
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = a;
          paramString3 = new StringBuilder();
          paramString3.append("onRequestVideo orientation: ");
          paramString3.append(this.aA);
          paramString3.append(", isQQPaused: ");
          paramString3.append(VideoConstants.b);
          paramString3.append(", isVideoPaused: ");
          paramString3.append(this.e.isBackgroundPause);
          paramString3.append(", isScreenLocked: ");
          paramString3.append(bool3);
          paramString3.append(", isAppOnForeground: ");
          paramString3.append(GesturePWDUtils.isAppOnForegroundByTasks(i(), 0));
          QLog.d(paramArrayOfByte, 2, paramString3.toString());
        }
        if ((this.aC) && (this.aA == 0) && (!bool3) && (VideoConstants.b) && (this.e.isBackgroundPause))
        {
          this.e.a().postDelayed(new VideoController.6(this, l2, (String)localObject1, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = a;
          paramString3 = new StringBuilder();
          paramString3.append("updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = ");
          paramString3.append(paramString1);
          QLog.d(paramArrayOfByte, 2, paramString3.toString());
        }
        a(paramString1, "inviteUIState", String.valueOf(0));
        if (this.aI != null) {
          this.aI.b();
        }
        this.aI = new VideoCallStateMonitor(this.e, paramString1);
        a(l2, (String)localObject1, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
      }
      a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
    }
  }
  
  public void onRequestVideoMode(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    k().aY = 2;
    this.e.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void onResponseRecvAvatar2dSwitch(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      paramArrayOfByte = new String(paramArrayOfByte);
    } else {
      paramArrayOfByte = "";
    }
    this.e.a(new Object[] { Integer.valueOf(522), paramString, Integer.valueOf(paramInt), paramArrayOfByte });
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResponseRecvAvatar2dSwitch, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], errcode [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], errMsg [");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void onResumeAudio(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResumeAudio fromUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", remoteMute = ");
      localStringBuilder.append(k().F);
      localStringBuilder.append("|");
      localStringBuilder.append(this.g);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((this.g) && (k().F))
    {
      k().F = false;
      this.e.a(new Object[] { Integer.valueOf(18) });
    }
  }
  
  public void onResumeVideo(String paramString)
  {
    SessionInfo localSessionInfo = k();
    long l1 = AudioHelper.c();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeVideo, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(localSessionInfo.I);
    localStringBuilder.append("], isOnlyAudio[");
    localStringBuilder.append(localSessionInfo.aK);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.e.getCurrentAccountUin()))) {
      return;
    }
    if ((localSessionInfo.h == 1) && (!n()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "onResumeVideo !canAVShift()");
      }
      return;
    }
    if (!localSessionInfo.I)
    {
      localSessionInfo.c(l1, true);
      this.e.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      DataReport.m(this);
      if (localSessionInfo.g == 1)
      {
        localSessionInfo.a(l1, "onResumeVideo", 2);
        localSessionInfo.aK = false;
      }
    }
  }
  
  public void onSDKCustomCommand(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, String.format("onSDKCustomCommand uin=%s, cmd=%s, arg1=%s, arg2=%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
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
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfAudioVolumeChange qav.value:=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    try
    {
      this.e.a(new Object[] { Integer.valueOf(20002), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(100L) });
      return;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public void onSendC2CMsg(String paramString)
  {
    k().bw = true;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      o(paramString);
    }
  }
  
  public void onSetMicBySelf(long paramLong)
  {
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      ??? = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("WL_DEBUG onSetMicBySelf uin = ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)???, 2, ((StringBuilder)localObject2).toString());
    }
    synchronized (this.aQ)
    {
      localObject2 = this.aQ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)((Iterator)localObject2).next();
        if (localGAudioFriends.a == paramLong) {
          if (!localGAudioFriends.q)
          {
            localGAudioFriends.q = true;
            this.e.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
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
    ScreenShareCtrl localScreenShareCtrl = this.aY;
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
    }
  }
  
  public void onStateInfo(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (AudioHelper.a()) {
        QavDebugTools.checkVideoDecoderFrameCostTimes(paramArrayOfByte);
      }
      QLog.isColorLevel();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        this.e.a(new Object[] { Integer.valueOf(19), paramArrayOfByte });
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onStateInfo fromUin = ");
          localStringBuilder.append(paramString);
          QLog.d(str, 2, localStringBuilder.toString(), paramArrayOfByte);
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onStateInfo:network is bad,detail is null");
    }
  }
  
  public void onSwitchGroup(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = AudioHelper.c();
    paramArrayOfByte = k();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchGroup, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], flag[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramArrayOfByte.g != 3)
    {
      if (paramArrayOfByte.g == 4) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!paramString.equalsIgnoreCase(paramArrayOfByte.s)) {
        return;
      }
      q(true);
      if (!paramArrayOfByte.b()) {
        a(l1, 2131230808, 1, null);
      }
      paramArrayOfByte.e("onSwitchGroup", AVUtil.b(paramArrayOfByte.p));
      paramArrayOfByte.aN = 0L;
      paramArrayOfByte.b("onSwitchGroup", 11);
      this.e.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      s();
    }
  }
  
  public void onSwitchMeeting(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ScreenShareCtrl localScreenShareCtrl = aF();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramString, paramArrayOfByte, paramLong);
    }
  }
  
  public void onSwitchTerminalSuccess(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, long paramLong)
  {
    long l1 = AudioHelper.c();
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      String str = a;
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
    paramString1 = this.e;
    if (paramString1 == null) {
      return;
    }
    if (this.M != null)
    {
      paramString1.a().removeCallbacks(this.M);
      this.M = null;
    }
    paramString1 = k();
    if (paramString1.bs)
    {
      paramString1.bs = false;
      if (paramString1.E) {
        a(true, paramString1.s);
      }
      if (this.e.f() > 0)
      {
        this.e.a(new Object[] { Integer.valueOf(33), paramString1.s, Boolean.valueOf(false) });
      }
      else
      {
        paramString2 = new VideoController.16(this, paramString1);
        this.q.add(paramString2);
      }
      c(l1);
      a((int)z(), paramString1.I, paramString1.F ^ true);
    }
    else if (paramString1.br)
    {
      onChannelReady(paramString1.s, paramInt2, paramInt3, paramString2, paramLong);
      break label363;
    }
    bool1 = false;
    label363:
    paramString2 = this.e.A();
    if (paramString2 != null) {
      paramString2.a(this, paramString1);
    }
    ((WTogetherMng)this.e.c(17)).a(paramString1, bool1);
  }
  
  public void onSyncOtherTerminalChatStatus(String paramString, int paramInt)
  {
    if (!k().br)
    {
      if (QLog.isColorLevel()) {
        QLog.w(a, 2, "not start StartByTerminalSwitch but receive onSyncOtherTerminalChatStatus message");
      }
      return;
    }
    int i2 = 0xFFFFF & paramInt;
    int i1 = paramInt >> 20 & 0x1;
    int i3 = paramInt >> 21 & 0x1;
    paramInt = i1;
    if (k().bu)
    {
      paramInt = i1;
      if (k().g == 1)
      {
        paramInt = i1;
        if (n())
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "switch start frome video entry, open camera");
          }
          paramInt = 1;
        }
      }
    }
    k().ax = i2;
    if (QLog.isColorLevel())
    {
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSyncOtherTerminalChatStatus time:");
      localStringBuilder.append(i2);
      localStringBuilder.append(", isCamreOpen:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isMicOpen:");
      localStringBuilder.append(i3);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(34), Integer.valueOf(paramInt), Integer.valueOf(i3) });
  }
  
  public void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    long l1 = AudioHelper.c();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
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
    Object localObject1 = m(String.valueOf(paramLong1));
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "onVideoSrcChange-->can not find the user");
      }
      return;
    }
    int i1 = 0;
    while (i1 < k().bi.size())
    {
      if (((VideoViewInfo)k().bi.get(i1)).a == paramLong1)
      {
        i2 = ((VideoViewInfo)k().bi.get(i1)).b;
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
        a(paramLong1, k().bi, k().bk, 0, true);
        ab();
        this.e.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i2), Long.valueOf(l1) });
        i1 = 0;
      }
      else
      {
        i1 = 1;
      }
      this.e.a(new Object[] { Integer.valueOf(73), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(l1) });
    }
    else if (paramInt1 != 0)
    {
      i1 = k().b(paramLong1, 0);
      if (i1 == -1)
      {
        a(paramLong1, true, paramInt2, 5L);
        a((VideoController.GAudioFriends)localObject1, paramInt1);
        i1 = k().b(paramLong1, 0);
        ((VideoViewInfo)k().bi.get(i1)).b = paramInt1;
      }
      else
      {
        localObject1 = (VideoViewInfo)k().bi.get(i1);
        localObject2 = new VideoViewInfo();
        ((VideoViewInfo)localObject2).a = ((VideoViewInfo)localObject1).a;
        ((VideoViewInfo)localObject2).b = ((VideoViewInfo)localObject1).b;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject2);
        this.e.a(new Object[] { Integer.valueOf(104), localArrayList });
        ((VideoViewInfo)localObject1).b = paramInt1;
      }
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      this.e.a(new Object[] { Integer.valueOf(87), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public long p(String paramString)
  {
    SessionInfo localSessionInfo = SessionMgr.a().b(paramString);
    long l1 = 0L;
    if ((localSessionInfo != null) && (localSessionInfo.D() != 0L)) {
      return localSessionInfo.D();
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      long l2 = ((VcControllerImpl)localObject).getChatRoomId(paramString);
      paramString = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry to get room id. new room id = ");
      ((StringBuilder)localObject).append(l2);
      QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
      l1 = l2;
      if (localSessionInfo != null)
      {
        localSessionInfo.e(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public void p()
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
        QAVNotification localQAVNotification = QAVNotification.a(this.e);
        Object localObject2 = k();
        boolean bool = ((SessionInfo)localObject2).B;
        i1 = 47;
        Object localObject3;
        Object localObject4;
        if (bool)
        {
          if (((SessionInfo)localObject2).h())
          {
            if ((((SessionInfo)localObject2).g != 1) && (((SessionInfo)localObject2).g != 2))
            {
              localObject3 = String.valueOf(((SessionInfo)localObject2).aN);
              localObject4 = ((SessionInfo)localObject2).s;
              localObject2 = ((SessionInfo)localObject2).f;
              Bitmap localBitmap = this.e.a(3000, (String)localObject3, null, true, true);
              localQAVNotification.a((String)localObject2, this.e.a(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
              if (localBitmap == null) {
                this.e.a().postDelayed(new VideoController.14(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
              }
              return;
            }
            if ((((SessionInfo)localObject2).aK) || (((SessionInfo)localObject2).am)) {
              break label539;
            }
            i1 = 56;
          }
          else
          {
            if (((SessionInfo)localObject2).g != 1) {
              break label545;
            }
            break label548;
          }
        }
        else
        {
          if (((SessionInfo)localObject2).j())
          {
            if (((SessionInfo)localObject2).g != 1) {
              break label545;
            }
            break label548;
          }
          if (((SessionInfo)localObject2).g != 1) {
            break label551;
          }
          i1 = 46;
          break label554;
        }
        if ((((SessionInfo)localObject2).g != 3) && (((SessionInfo)localObject2).g != 4))
        {
          if (((SessionInfo)localObject2).t == null) {
            ((SessionInfo)localObject2).t = this.e.a(((SessionInfo)localObject2).p, ((SessionInfo)localObject2).s, ((SessionInfo)localObject2).u);
          }
          localObject3 = this.e.a(((SessionInfo)localObject2).p, ((SessionInfo)localObject2).s, ((SessionInfo)localObject2).u, true, true);
          localQAVNotification.a(((SessionInfo)localObject2).f, ((SessionInfo)localObject2).t, (Bitmap)localObject3, null, i1, ((SessionInfo)localObject2).p, ((SessionInfo)localObject2).g);
        }
        else if (((SessionInfo)localObject2).am)
        {
          localObject3 = ((SessionInfo)localObject2).t;
          localObject4 = this.e.a(0, ((SessionInfo)localObject2).s, null, true, true);
          localQAVNotification.a(((SessionInfo)localObject2).f, (String)localObject3, (Bitmap)localObject4, String.valueOf(((SessionInfo)localObject2).aN), 48, 0, ((SessionInfo)localObject2).g);
        }
        else
        {
          localObject3 = this.e.a(k().p, String.valueOf(k().aN), null);
          localObject4 = this.e.a(((SessionInfo)localObject2).p, String.valueOf(((SessionInfo)localObject2).aN), null, true, true);
          if (localObject4 != null) {
            localQAVNotification.a(((SessionInfo)localObject2).f, (String)localObject3, (Bitmap)localObject4, String.valueOf(((SessionInfo)localObject2).aN), 44, ((SessionInfo)localObject2).p, ((SessionInfo)localObject2).g);
          } else {
            this.e.a().postDelayed(new VideoController.15(this), 1000L);
          }
        }
        Y();
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
  
  public void p(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).c();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).c(paramBoolean);
      }
    }
  }
  
  public int q()
  {
    ArrayList localArrayList = this.aQ;
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i3 < this.aQ.size())
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.aQ.get(i3);
          if (localGAudioFriends == null)
          {
            i2 = i1;
          }
          else if (localGAudioFriends.a == CharacterUtil.b(this.e.getCurrentAccountUin()))
          {
            i2 = i1;
          }
          else
          {
            i2 = i1;
            if (localGAudioFriends.d) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (localGAudioFriends.g) {
              i1 = i2 + 1;
            }
            i2 = i1;
            if (localGAudioFriends.f) {
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
  
  public void q(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.upgradeInvite");
    localIntent.putExtra("peerUin", paramString);
    localIntent.setPackage(this.e.getApp().getPackageName());
    this.e.getApp().sendBroadcast(localIntent);
  }
  
  public void q(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).c();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).d(paramBoolean);
      }
    }
  }
  
  public int r()
  {
    return MSFNetInfoMonitor.a();
  }
  
  public void r(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetQCallNickName nickName : ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.e.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void r(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).c();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).e(paramBoolean);
      }
    }
  }
  
  public void receiveTransferMsg(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.d.receiveTransferMsg(paramString, paramArrayOfByte);
    this.e.a(new Object[] { Integer.valueOf(122), paramString });
  }
  
  void s()
  {
    if (this.K == null)
    {
      this.K = new VideoController.17(this);
      VideoAppInterface localVideoAppInterface = this.e;
      if ((localVideoAppInterface != null) && (this.K != null)) {
        localVideoAppInterface.a().postDelayed(this.K, 20000L);
      }
    }
  }
  
  public void s(String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(VideoNodeManager.f());
    paramString.append("");
    b("deviceMemory", paramString.toString());
    b("manufacturer", Build.MANUFACTURER);
    b("qqVersion", AppSetting.a(i()));
  }
  
  public void s(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).c();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).f(paramBoolean);
      }
    }
  }
  
  void t()
  {
    if (this.L == null) {
      this.L = new VideoController.18(this);
    }
    VideoAppInterface localVideoAppInterface = this.e;
    if ((localVideoAppInterface != null) && (this.L != null)) {
      localVideoAppInterface.a().postDelayed(this.L, 5000L);
    }
  }
  
  public void t(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((VideoAppInterface)localObject).c();
      if (localObject != null) {
        ((VideoProcessExitMonitor)localObject).g(paramBoolean);
      }
    }
  }
  
  public boolean t(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public long u(String paramString)
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
      long l1 = CharacterUtil.b(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog(a, paramString.getMessage());
    }
    return -1L;
  }
  
  void u()
  {
    long l1 = AudioHelper.c();
    if (this.M == null)
    {
      this.M = new VideoController.19(this, l1);
      VideoAppInterface localVideoAppInterface = this.e;
      if ((localVideoAppInterface != null) && (this.M != null)) {
        localVideoAppInterface.a().postDelayed(this.M, 15000L);
      }
    }
  }
  
  public void u(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis() - this.aw;
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callBackNetStatus <--receiveEcho Cost = ");
      localStringBuilder.append(l1);
      QLog.d(str, 1, localStringBuilder.toString());
      if (l1 < 3000L) {
        h(1);
      } else {
        h(2);
      }
    }
    else
    {
      h(4);
    }
    this.aw = -1L;
  }
  
  void v()
  {
    GraphicRenderMgr.getInstance().clearDecoderPtrRef();
    QQGAudioCtrl localQQGAudioCtrl = this.U;
    if (localQQGAudioCtrl != null) {
      localQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
    }
  }
  
  public void v(String paramString)
  {
    InviteUIChecker localInviteUIChecker = this.aE;
    if (localInviteUIChecker != null) {
      localInviteUIChecker.b(paramString);
    }
  }
  
  void w()
  {
    QLog.d(a, 1, "requestAudioFoucs");
    if (this.Q == null) {
      this.Q = new VideoController.22(this);
    }
    if (this.P == null) {
      this.P = ((AudioManager)this.f.getSystemService("audio"));
    }
    Object localObject = this.P;
    if (localObject != null) {
      try
      {
        int i1 = ((AudioManager)localObject).requestAudioFocus(this.Q, 3, 2);
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
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestAudioFocus e = ");
          localStringBuilder.append(localException);
          QLog.e(str, 2, localStringBuilder.toString());
        }
      }
    }
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
    localIntent.setPackage(this.e.getApp().getPackageName());
    this.e.getApp().sendBroadcast(localIntent);
  }
  
  public void w(String paramString)
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((VcControllerImpl)localObject).setupDeviceInfos(paramString);
    }
    localObject = this.U;
    if (localObject != null) {
      ((QQGAudioCtrl)localObject).setAndroidPath(paramString);
    }
  }
  
  void x()
  {
    QLog.d(a, 1, "abandonAudioFocus");
    AudioManager localAudioManager = this.P;
    if (localAudioManager != null)
    {
      localAudioManager.abandonAudioFocus(this.Q);
      this.P = null;
    }
  }
  
  public boolean y()
  {
    return this.g;
  }
  
  public long z()
  {
    if (k().aw == 0L) {
      return 0L;
    }
    long l1 = (SystemClock.elapsedRealtime() - k().aw) / 1000L + k().ax;
    this.e.b(l1);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */