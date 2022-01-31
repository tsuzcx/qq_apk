package com.tencent.av;

import android.annotation.SuppressLint;
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
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.DeviceSharpController;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.SDKConfigInfo.Builder;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleReportController;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.AVInviteAccount;
import com.tencent.av.gaudio.AVInvitePSTNPhone;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectBeautyTools;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.effects.LowlightAndDenoiseTools;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.random.RandomController;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteFloatBarUICtr;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.PstnNumberManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import jct;
import jcv;
import jcw;
import jcx;
import jcy;
import jcz;
import jda;
import jdb;
import jdc;
import jdd;
import jde;
import jdf;
import jdg;
import jdh;
import jdi;
import jdj;
import jdk;
import jdl;
import jdm;
import jdn;
import jdo;
import jdp;
import jdq;
import jdr;
import jds;
import jdt;
import jdu;
import jdw;
import jdx;
import jdz;
import jea;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class VideoController
  extends AbstractNetChannel
  implements IVideoSession, IVideoEventListener
{
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  private static String jdField_e_of_type_JavaLangString;
  public static int u;
  public static int v;
  public static int w;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  int jdField_a_of_type_Int = -1;
  public long a;
  public Context a;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new jdt(this);
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  public MatchedUser a;
  SessionMgr jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
  private VideoController.CameraDataUpdataInterface jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface;
  public VideoAppInterface a;
  public DeviceSharpController a;
  public VcControllerImpl a;
  QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  EffectController jdField_a_of_type_ComTencentAvOpenglEffectsEffectController = null;
  public PhoneStatusMonitor.PhoneStatusListener a;
  public PhoneStatusMonitor a;
  public TraeHelper a;
  GAClientLogReport jdField_a_of_type_ComTencentAvVideoCallGAClientLogReport = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new jct(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  jdu jdField_a_of_type_Jdu = null;
  jdw jdField_a_of_type_Jdw = null;
  public jdx a;
  jdz jdField_a_of_type_Jdz = null;
  public jea a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  boolean jdField_a_of_type_Boolean = true;
  public byte[] a;
  public float[] a;
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private SdkAudioFrameCallback[] jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback;
  public int b;
  public long b;
  public MediaPlayer.OnCompletionListener b;
  private EffectController jdField_b_of_type_ComTencentAvOpenglEffectsEffectController;
  Runnable jdField_b_of_type_JavaLangRunnable = new jdf(this);
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  int[] jdField_b_of_type_ArrayOfInt = new int[8];
  public int c;
  public long c;
  MediaPlayer.OnCompletionListener jdField_c_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new jcw(this);
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  public ArrayList c;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  long jdField_d_of_type_Long = 0L;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  public long e;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  public boolean e;
  public int f;
  long jdField_f_of_type_Long = 0L;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  public boolean f;
  public int g;
  long jdField_g_of_type_Long = 0L;
  Runnable jdField_g_of_type_JavaLangRunnable = null;
  public boolean g;
  public int h;
  Runnable jdField_h_of_type_JavaLangRunnable = null;
  boolean jdField_h_of_type_Boolean = true;
  public int i;
  public Runnable i;
  public boolean i;
  public int j;
  Runnable jdField_j_of_type_JavaLangRunnable = new jdk(this);
  boolean jdField_j_of_type_Boolean = false;
  public int k;
  boolean k;
  int jdField_l_of_type_Int = 0;
  boolean jdField_l_of_type_Boolean = false;
  public int m;
  public boolean m;
  int n;
  public boolean n;
  int jdField_o_of_type_Int = 1;
  boolean jdField_o_of_type_Boolean = false;
  int jdField_p_of_type_Int = 2;
  boolean jdField_p_of_type_Boolean = false;
  int q;
  public boolean q;
  int r = 4;
  public boolean r;
  public int s = 0;
  public boolean s;
  int t;
  public boolean t;
  public boolean u;
  boolean v;
  boolean w;
  int jdField_x_of_type_Int = jdField_u_of_type_Int;
  boolean jdField_x_of_type_Boolean = false;
  public int y;
  public boolean y;
  private int jdField_z_of_type_Int = 0;
  private boolean jdField_z_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoController";
    jdField_e_of_type_JavaLangString = "com.tencent.av.count";
    jdField_b_of_type_JavaLangString = "WifiQQCall";
    jdField_c_of_type_JavaLangString = "WifiRandom";
    jdField_d_of_type_JavaLangString = "WifiGuild";
    jdField_u_of_type_Int = -1;
    jdField_v_of_type_Int = 1;
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Long = 6000L;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 20;
    this.jdField_i_of_type_Int = 60;
    this.jdField_j_of_type_Int = 100000;
    this.jdField_a_of_type_Jdx = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_n_of_type_Int = 0;
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new jcv(this);
    this.jdField_q_of_type_Int = 3;
    this.jdField_t_of_type_Boolean = true;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_i_of_type_JavaLangRunnable = null;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_a_of_type_Jea = null;
    this.jdField_t_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_y_of_type_Int = -1;
  }
  
  private void Q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new jdo(this, a(), 3);
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
  
  private void R()
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
      AVLog.c(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void S()
  {
    SessionInfo localSessionInfo = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchGroup, multiCalledInviteType[" + localSessionInfo.jdField_y_of_type_Int + "]");
    if (localSessionInfo.jdField_y_of_type_Int == 1)
    {
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->double to multi-->uinList:" + this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList);
        }
        i1 = 0;
        if (i1 < this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size())
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1) + "");
          if (localObject1 != null) {
            localArrayList1.add(localObject1);
          }
          for (;;)
          {
            i1 += 1;
            break;
            localArrayList2.add(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->double to multi-->inviteByIpList:" + localArrayList2 + "-->inviteByPhoneList:" + localArrayList1);
      }
      i2 = localArrayList2.size();
      localObject1 = null;
      if (i2 > 0)
      {
        localObject2 = new long[i2 * 2];
        i1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 >= i2) {
            break;
          }
          localObject2[(i1 * 2)] = 1L;
          localObject2[(i1 * 2 + 1)] = ((Long)localArrayList2.get(i1)).longValue();
          if (!localSessionInfo.jdField_a_of_type_JavaUtilArrayList.contains(localArrayList2.get(i1))) {
            localSessionInfo.jdField_a_of_type_JavaUtilArrayList.add(localArrayList2.get(i1));
          }
          i1 += 1;
        }
      }
      i3 = localArrayList1.size();
      localObject2 = null;
      if (i3 > 0)
      {
        localObject2 = new String[i3 * 3];
        localArrayList2 = new ArrayList();
        i1 = 0;
        while (i1 < i3)
        {
          localAVPhoneUserInfo = PstnUtils.a((String)localArrayList1.get(i1));
          localArrayList2.add(localAVPhoneUserInfo);
          localObject2[(i1 * 3)] = localAVPhoneUserInfo.telInfo.nation;
          localObject2[(i1 * 3 + 1)] = localAVPhoneUserInfo.telInfo.prefix;
          localObject2[(i1 * 3 + 2)] = localAVPhoneUserInfo.telInfo.mobile;
          i1 += 1;
        }
        localSessionInfo.a(localArrayList2);
        f();
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject1, i2, (String[])localObject2, i3, 0, false, true, 0);
      localSessionInfo.jdField_x_of_type_Int = 1;
      localSessionInfo.jdField_M_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(705), Boolean.valueOf(true) });
    }
    while ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList == null) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() <= 0))
    {
      ArrayList localArrayList2;
      ArrayList localArrayList1;
      Object localObject2;
      AVPhoneUserInfo localAVPhoneUserInfo;
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
    long l1 = localSessionInfo.jdField_g_of_type_Long;
    Object localObject1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    int i1 = this.jdField_f_of_type_Int;
    int i2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.pstnLevel;
    ((QQGAudioCtrl)localObject1).inviteUser(new long[] { l1 }, i1, 1, i2);
    int i4 = i3 - 1;
    localObject1 = new long[i4 * 2];
    i1 = 0;
    i2 = 0;
    if (i2 < i3)
    {
      if ((((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i2)).longValue() == l1) || (i1 >= i4)) {
        break label772;
      }
      localObject1[(i1 * 2)] = 1L;
      localObject1[(i1 * 2 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i2)).longValue();
      i1 += 1;
    }
    label772:
    for (;;)
    {
      i2 += 1;
      break;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d() >= 9)
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy((long[])localObject1, i4, null, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject1, i4, null, 0, 0, false, false, 0);
      return;
    }
  }
  
  private void T()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null)
    {
      this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController = new DeviceSharpController(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a().jdField_i_of_type_Int = 9500;
      if (QLog.isColorLevel()) {
        QLog.w("BaseIMSharp", 2, "init device sharp");
      }
    }
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
      }
      return 26;
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
    }
    return 26;
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
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramAVUserInfo.jdField_a_of_type_Long;
    long l2 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if (l2 == l1)
    {
      bool1 = true;
      label62:
      paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt == 3) {
        paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong1), new int[0]);
      }
      if (paramInt != 1) {
        break label635;
      }
      paramVarArgs = a();
      label105:
      if (paramVarArgs == null) {
        break label646;
      }
      if (AudioHelper.e()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_c_of_type_Int + "], relationType[" + paramInt + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_Long = paramLong1;
        this.jdField_c_of_type_Int = paramInt;
        if (paramVarArgs != null) {
          paramVarArgs.U = true;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
        if (this.jdField_p_of_type_Boolean) {
          break label648;
        }
        bool2 = true;
        label267:
        a("onGAudioUserEnterOrLeave", bool2, paramVarArgs.jdField_T_of_type_Boolean);
        if (((this.jdField_c_of_type_Int == 1) && (paramVarArgs.D == 10)) || (this.jdField_c_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label654;
          }
        }
      }
    }
    label646:
    label648:
    label654:
    for (boolean bool2 = false;; bool2 = true)
    {
      paramVarArgs.af = bool2;
      if ((this.jdField_c_of_type_Int == 2) && (paramVarArgs.n()) && (paramVarArgs.o()) && ((paramVarArgs.jdField_y_of_type_Int == 2) || (paramVarArgs.jdField_y_of_type_Int == 1) || (paramVarArgs.jdField_y_of_type_Int == 4)) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d() >= 9) && (!paramVarArgs.jdField_K_of_type_Boolean) && (paramVarArgs.af))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave roomower enter again");
        }
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy(null, 0, null, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave-->RelationId[" + paramLong1 + "], UserInfo[" + paramAVUserInfo + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_p_of_type_Boolean + "], switchToGaudio[" + paramVarArgs.jdField_T_of_type_Boolean + "], extroInfo = " + paramLong2 + "]");
      }
      if ((paramBoolean) || (l1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (paramLong1 != a().jdField_f_of_type_Long)) {
        break label660;
      }
      a(paramInt, paramLong1, 72);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      bool1 = false;
      break label62;
      label635:
      paramVarArgs = SessionMgr.a().a(paramVarArgs);
      break label105;
      break;
      bool2 = false;
      break label267;
    }
    label660:
    a(paramAVUserInfo, paramBoolean);
    if ((a().jdField_d_of_type_Int == 3) && (a().jdField_i_of_type_Int == 1011))
    {
      if (!paramBoolean) {
        break label1122;
      }
      if (h() != 1) {
        break label1108;
      }
      if (!bool1) {
        break label1094;
      }
      a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 4;
      label721:
      if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d())) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("onGAudioUserEnterOrLeave.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230735, null, 0, null);
      }
      label771:
      a(a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 3, null);
      paramVarArgs = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((paramVarArgs != null) && (paramVarArgs.a())) {
        g();
      }
    }
    if (paramBoolean) {
      if (a().jdField_g_of_type_Int < 10)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (bool1))
        {
          a().a("onGAudioUserEnterOrLeave.1", 9);
          a().ah = false;
        }
      }
      else
      {
        label866:
        if ((a().jdField_g_of_type_Long != l1) && (l1 != l2)) {
          TipsManager.c(105);
        }
        if ((!a().Y) || (a().W)) {
          break label1274;
        }
        ReportController.b(null, "CliOper", "", "", "0X800667D", "0X800667D", 0, 0, "", "", "", "");
        label945:
        if (!paramBoolean) {
          break label1425;
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramAVUserInfo.jdField_a_of_type_Int != 0) {
          break label1419;
        }
        bool1 = true;
        label967:
        paramVarArgs.a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool1) });
      }
    }
    for (;;)
    {
      H();
      if (!a().jdField_G_of_type_Boolean) {
        break label1613;
      }
      if (paramBoolean) {
        break;
      }
      if (a().H)
      {
        paramAVUserInfo = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        x();
        if (paramAVUserInfo.a()) {
          paramAVUserInfo.a(a().jdField_b_of_type_JavaLangString);
        }
      }
      if (!a().ar) {
        break;
      }
      a(paramLong1, false, 2);
      return;
      label1094:
      a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 1;
      break label721;
      label1108:
      a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 5;
      break label721;
      label1122:
      if (h() == 1) {
        a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 4;
      }
      if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) || (!m())) {
        break label771;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("onGAudioUserEnterOrLeave.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      break label771;
      if ((!a().ah) && (a().jdField_g_of_type_Int == 9)) {
        a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
      }
      a().a("onGAudioUserEnterOrLeave.2", 10);
      w();
      if (a().jdField_d_of_type_Long != 0L) {
        break label866;
      }
      a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
      break label866;
      label1274:
      if ((!a().X) || (a().W)) {
        break label945;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006416", "0X8006416", 0, 0, "", "", "", "");
      break label945;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
      {
        a().a("onGAudioUserEnterOrLeave.3", 9);
        a().ah = true;
        paramVarArgs = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramVarArgs != null) && (paramVarArgs.a()))
        {
          x();
          g();
        }
      }
      TipsManager.c(105);
      break label945;
      label1419:
      bool1 = false;
      break label967;
      label1425:
      if (paramLong2 != 1L) {
        break label1440;
      }
      g(true);
    }
    label1440:
    if (paramLong2 == 0L)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (paramAVUserInfo.jdField_a_of_type_Int == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramVarArgs.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
        break;
      }
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramAVUserInfo.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramVarArgs.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave-->Extro Info is Wrong.Extro Info = " + paramLong2);
      break;
    }
    label1613:
    paramAVUserInfo = new Intent();
    paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
    if (paramBoolean)
    {
      paramAVUserInfo.putExtra("type", 22);
      paramAVUserInfo.putExtra("isStart", this.jdField_v_of_type_Boolean);
    }
    for (;;)
    {
      paramAVUserInfo.putExtra("roomUserNum", this.jdField_a_of_type_JavaUtilArrayList.size());
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
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatVideoInOrOut-->Groupid=" + paramLong1 + " user = " + paramLong2 + " bVideoIn = " + paramBoolean + " extraInfo = " + paramLong3);
    }
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean) && (paramLong2 != l1) && (paramInt1 == 3)) {
      return;
    }
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      label141:
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
        break label141;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i1) });
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatPPTInOrOut,groupUin=" + paramLong1 + " uin = " + paramLong2 + " bIn = " + paramBoolean1 + " bIsPPT = " + paramBoolean2 + " extraInfo = " + paramLong3);
    }
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i1 = a(paramLong1);
        if (i1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
          }
          return;
        }
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localGAudioFriends.jdField_b_of_type_Boolean = paramBoolean;
        if ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1)) {
          return;
        }
      }
      if (paramBoolean)
      {
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        localVideoViewInfo.jdField_a_of_type_Long = paramLong1;
        localVideoViewInfo.jdField_a_of_type_Int = 1;
        if (a().a(paramLong1, localVideoViewInfo.jdField_a_of_type_Int) != -1) {
          return;
        }
        localVideoViewInfo.jdField_b_of_type_Long = paramLong2;
        if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
          localVideoViewInfo.jdField_b_of_type_Long = 5L;
        }
        if (!a().m())
        {
          localVideoViewInfo.jdField_a_of_type_Boolean = true;
          if ((g() == 4) || (paramInt == 3)) {
            break label370;
          }
          if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) != -1) {
            break label361;
          }
          localVideoViewInfo.jdField_c_of_type_Boolean = true;
          label283:
          if (localObject.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
            break label388;
          }
          localVideoViewInfo.jdField_b_of_type_Boolean = true;
          localVideoViewInfo.jdField_d_of_type_Boolean = true;
          localVideoViewInfo.jdField_c_of_type_Boolean = true;
          if (a().m()) {
            break label379;
          }
          localVideoViewInfo.jdField_a_of_type_Boolean = true;
          label339:
          a().a(localVideoViewInfo);
        }
        for (;;)
        {
          return;
          localVideoViewInfo.jdField_a_of_type_Boolean = false;
          break;
          label361:
          localVideoViewInfo.jdField_c_of_type_Boolean = false;
          break label283;
          label370:
          localVideoViewInfo.jdField_c_of_type_Boolean = true;
          break label283;
          label379:
          localVideoViewInfo.jdField_a_of_type_Boolean = false;
          break label339;
          label388:
          localVideoViewInfo.jdField_b_of_type_Boolean = false;
          a().a(localVideoViewInfo);
        }
      }
      if (paramInt == 2) {
        a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, 1, false);
      }
      for (;;)
      {
        y();
        break;
        if (paramInt == 1)
        {
          if (a().D == 10) {
            a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, 1, false);
          } else {
            a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, 0, true);
          }
        }
        else if (paramInt == 3) {
          a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        }
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
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      paramInt1 = a(paramLong);
      if (paramInt1 == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
        }
        return;
      }
    }
    Object localObject2 = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    VideoViewInfo localVideoViewInfo;
    if (paramBoolean1)
    {
      localVideoViewInfo = new VideoViewInfo();
      if (paramBoolean2) {}
      for (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Int = 2;; ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Int = 1)
      {
        localVideoViewInfo.jdField_a_of_type_Long = paramLong;
        localVideoViewInfo.jdField_a_of_type_Int = 2;
        localVideoViewInfo.jdField_a_of_type_Boolean = true;
        localVideoViewInfo.jdField_b_of_type_Boolean = false;
        localVideoViewInfo.jdField_b_of_type_Long = 5L;
        if (a().a(paramLong, localVideoViewInfo.jdField_a_of_type_Int) == -1) {
          break;
        }
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
      localVideoViewInfo.jdField_c_of_type_Boolean = true;
      if (a().jdField_c_of_type_JavaUtilArrayList.size() > 1)
      {
        localObject2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
        a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo);
        a().a((VideoViewInfo)localObject2);
      }
    }
    for (;;)
    {
      return;
      a().a(0, localVideoViewInfo);
      continue;
      ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Int = 0;
      a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, 2, false);
      y();
    }
  }
  
  private boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b() != -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "recv video request when phone isn't idle: fromUin = " + paramString);
      }
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.CallingDialog");
      localIntent.putExtra("isAudio", paramBoolean);
      localIntent.putExtra("friendUin", paramString);
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("senderUin", paramString);
      localIntent.putExtra("isSender", false);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a("onRequestVideo", 0, 2131230736, null, null, false, 1, false, true, 0);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), 3);
      a(paramString, 0);
      b(211);
      c(paramString, 1);
      bool = true;
    }
    return bool;
  }
  
  private boolean b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i1 = a(paramLong);
        if (i1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
          }
          return false;
        }
        ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean = paramBoolean;
        return false;
      }
    }
    return false;
  }
  
  private void c(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong1, paramLong2);
    }
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
  
  private boolean r()
  {
    WindowManager localWindowManager = (WindowManager)a().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    int i3 = localWindowManager.getDefaultDisplay().getRotation();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isLandscape screenWidth: " + i1 + ", screenHeight: " + i2 + ", rotation: " + i3 + ", orientation: " + this.jdField_z_of_type_Int);
    }
    return (i1 > i2) || (i3 == 1) || (i3 == 3) || (this.jdField_z_of_type_Int == 4) || (this.jdField_z_of_type_Int == 2);
  }
  
  public void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startRandomTimeout");
    }
    if (this.jdField_a_of_type_Jdu == null) {
      this.jdField_a_of_type_Jdu = new jdu(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jdu, 30000L);
  }
  
  public void B()
  {
    a().a(a().jdField_g_of_type_JavaUtilArrayList);
    f();
    a(a().jdField_g_of_type_JavaUtilArrayList);
    a().jdField_g_of_type_JavaUtilArrayList.clear();
  }
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "kickOutPstnUsers");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.KickOutPstnUsers();
    }
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPstnBill");
    }
  }
  
  public void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onKickOutSuc");
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onKickOutFail");
    }
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMultiPstnTimeLess");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(704) });
    }
  }
  
  void H()
  {
    if ((a().F == 2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      int i1 = c().size();
      if (i1 > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(703), Integer.valueOf(i1) });
      }
    }
    else
    {
      return;
    }
    a().L = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(702) });
  }
  
  public void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (ConfigSystemImpl.c(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = h();
      if (!bool1)
      {
        a("onHowling", this.jdField_a_of_type_Long, false, false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().jdField_N_of_type_Boolean;
      if (bool2) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131429584), 2131433015, 2131433016, new jdl(this), new jdm(this, bool1, bool2));
      ReportController.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void J()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131429602, 1).a();
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
  
  public void K()
  {
    SessionInfo localSessionInfo = a();
    if (localSessionInfo != null)
    {
      int i2 = localSessionInfo.jdField_T_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = localSessionInfo.S;
      }
      b(i1);
      if ((i1 == 0) || (!localSessionInfo.aC)) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public void L()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onProcessExit();
    }
  }
  
  public void M()
  {
    long l1 = (System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L;
    ReportController.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    ReportController.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_f_of_type_Long = 0L;
  }
  
  public void N()
  {
    if (this.jdField_g_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_g_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_ComTencentAvMatchedUser == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentAvMatchedUser.jdField_a_of_type_JavaLangString)
    {
      ReportController.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
      this.jdField_g_of_type_Long = 0L;
      return;
    }
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "playRecordVoice");
    }
    a("playRecordVoice", 2131230738, 1, null);
  }
  
  public void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "playRecordDing");
    }
    if (p())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + "Q.nearby.video_chat", 2, "not playRing");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("playRecordDing_VideoController.playRing");
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("playRecordDing_VideoController.playRing", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 1, null);
  }
  
  public int a()
  {
    return this.jdField_n_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!a().f()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setGroundGlassSwitch(a().jdField_c_of_type_JavaLangString, paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AVLog.c(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setNativeGatewayTestResult(paramInt1, paramInt2, paramInt3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetOutputFormat(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return -1;
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    AVLog.b("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().D);
    AudioHelper.b("startGAudioChat ");
    if (!VideoNodeManager.a()) {
      VideoNodeManager.a();
    }
    VideoNodeManager.a(26);
    VideoNodeManager.a(28);
    VideoNodeManager.a(12, 1L);
    VideoNodeManager.a(15, 2L);
    f(false);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("startGAudioChat, relationType[").append(paramInt1).append("], relationId[").append(paramLong).append("], businessId[").append(paramInt2).append("], uinList[").append(paramArrayOfLong).append("], isVideo[").append(paramBoolean).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label232;
      }
    }
    label232:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label238;
      }
      return -1;
      bool = false;
      break;
    }
    label238:
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return -1;
    }
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]))) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]), true);
    }
    this.jdField_q_of_type_Boolean = false;
    long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    int i2;
    int i1;
    if ((paramInt1 == 7) || (paramInt1 == 9))
    {
      i2 = 1;
      i1 = paramInt2;
      paramInt2 = i2;
      if (paramBoolean) {
        paramInt2 = 2;
      }
      a();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_f_of_type_Boolean);
      }
      R();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      i2 = ConfigSystemImpl.c(a());
      if (!a().jdField_T_of_type_Boolean) {
        break label646;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setPstnInviteInfo(1, i2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().jdField_T_of_type_Boolean, a().jdField_N_of_type_Int, a().jdField_M_of_type_Int);
      if (this.jdField_i_of_type_JavaLangRunnable == null) {
        this.jdField_i_of_type_JavaLangRunnable = new jdh(this, paramInt1, paramLong);
      }
      this.jdField_v_of_type_Boolean = true;
      a().a("startGAudioChat.2", 8);
      a().jdField_f_of_type_Long = paramLong;
      a().q = String.valueOf(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 30000L);
      l();
      a(a().jdField_b_of_type_JavaLangString, 3, false, false, false);
      return 0;
      if (paramInt1 == 2)
      {
        if (a().jdField_f_of_type_Boolean) {}
        for (paramInt2 = 2;; paramInt2 = 1)
        {
          i1 = 1;
          break;
        }
      }
      if (paramInt1 == 1)
      {
        i1 = a().D;
        if (a().jdField_f_of_type_Boolean) {}
        for (paramInt2 = 2;; paramInt2 = 1) {
          break;
        }
      }
      if (paramInt1 == 10)
      {
        i2 = 1;
        i1 = paramInt2;
        paramInt2 = i2;
        break;
      }
      return -1;
      label646:
      if (a().ag) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setPstnInviteInfo(2, i2);
      } else {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setPstnInviteInfo(3, i2);
      }
    }
  }
  
  public int a(int paramInt, long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("acceptGAudioChat, relationType[").append(paramInt).append("], relationId[").append(paramLong).append("], isVideo[").append(paramBoolean).append("], relationId[").append(paramLong).append("], mIsStartGAuio[").append(this.jdField_v_of_type_Boolean).append("], uinList[");
    if (paramArrayOfLong != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], mGAudioCtrl[");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      AVLog.b("VideoNodeManager", "acceptGAudioChat()*************************** isVideo = " + paramBoolean);
      VideoNodeManager.a(37);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label182;
      }
      return -1;
      bool = false;
      break;
    }
    label182:
    f(false);
    this.jdField_q_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a().a("acceptGAudioChat", 8);
    a().jdField_f_of_type_Long = paramLong;
    a().q = String.valueOf(paramLong);
    a().aj = true;
    a().at = true;
    long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    int i2 = 2;
    int i1;
    if (paramInt == 2)
    {
      i2 = 1;
      if (a().jdField_f_of_type_Boolean) {
        i1 = 2;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        i1 = 2;
      }
      if (AudioHelper.e()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "acceptGAudioChat, MainSession[" + a() + "]");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i2, i1, paramLong, paramArrayOfLong, c(), l1, a().jdField_M_of_type_Int);
      if (this.jdField_i_of_type_JavaLangRunnable == null) {
        this.jdField_i_of_type_JavaLangRunnable = new jdi(this, paramInt, paramLong);
      }
      this.jdField_v_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 30000L);
      l();
      return 0;
      i1 = 1;
      continue;
      if (paramInt == 1)
      {
        i2 = a().D;
        if (a().jdField_f_of_type_Boolean) {}
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
  
  public int a(int paramInt, String paramString)
  {
    if (!a().f())
    {
      AVLog.d(jdField_a_of_type_JavaLangString, "sendAVFunChatMsg|session is not connected.");
      return 0;
    }
    AVLog.d(jdField_a_of_type_JavaLangString, String.format("sendAVFunChatMsg|type=%d, data=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_c_of_type_JavaLangString, paramInt, paramString);
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.registerDAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int a(int paramInt, byte[] paramArrayOfByte)
  {
    if (!a().f()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_c_of_type_JavaLangString, paramInt, paramArrayOfByte);
  }
  
  int a(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i1 = 0;
    jdz localjdz;
    boolean bool1;
    label58:
    label64:
    label104:
    label122:
    String str;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean1) {
        i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend(paramBoolean2);
      }
    }
    else
    {
      boolean bool2 = this.jdField_y_of_type_Boolean;
      localjdz = this.jdField_a_of_type_Jdz;
      if (paramBoolean1) {
        break label307;
      }
      if ((!paramBoolean2) && (!this.jdField_y_of_type_Boolean)) {
        break label301;
      }
      bool1 = true;
      this.jdField_y_of_type_Boolean = bool1;
      if (paramInt == 2) {
        break label368;
      }
      if ((i1 == 0) || (!paramBoolean2)) {
        break label354;
      }
      if (this.jdField_a_of_type_Jdz != null) {
        break label315;
      }
      this.jdField_a_of_type_Jdz = new jdz(paramLong, paramString, paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jdz, 1000L);
      str = jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder().append("switchAudioSend[").append(paramString).append("], seq[").append(paramLong).append("], flag[").append(paramInt).append("], enable[").append(paramBoolean1).append("], notifySvr[").append(paramBoolean2).append("], mIsMicOffBySelf[").append(bool2).append("->").append(this.jdField_y_of_type_Boolean).append("], result[").append(i1).append("], mGAudioCtrl[");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        break label376;
      }
    }
    label301:
    label307:
    label315:
    label354:
    label368:
    label376:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      QLog.w(str, 1, paramBoolean1 + "], lastRunnable[" + localjdz + "], curRunnable[" + this.jdField_a_of_type_Jdz + "]");
      return i1;
      i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopAudioSend(paramBoolean2);
      break;
      bool1 = false;
      break label58;
      this.jdField_y_of_type_Boolean = false;
      break label64;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jdz);
      if (paramInt != 0) {
        break label104;
      }
      this.jdField_a_of_type_Jdz = new jdz(paramLong, paramString, paramBoolean1, paramBoolean2);
      break label104;
      if (paramInt != 1) {
        break label122;
      }
      this.jdField_a_of_type_Jdz = null;
      break label122;
      this.jdField_a_of_type_Jdz = null;
      break label122;
    }
  }
  
  public int a(long paramLong1, boolean paramBoolean, List paramList, long paramLong2)
  {
    NetAddr[] arrayOfNetAddr = null;
    if (paramList != null) {
      arrayOfNetAddr = (NetAddr[])paramList.toArray(new NetAddr[paramList.size()]);
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendRecordingRequest(paramLong1, paramBoolean, arrayOfNetAddr, paramLong2);
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.UpdateSelfUin(paramString);
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo acceptRequest, peerUin[" + paramString + "], businessType[" + paramInt1 + "], relationType[" + paramInt2 + "], uiMode[" + this.jdField_k_of_type_Int + "]");
    if ((p()) && (this.jdField_k_of_type_Int != 3) && (!paramString.equals(a().jdField_c_of_type_JavaLangString)))
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
    if ((a().jdField_i_of_type_Int == 1011) || (a().jdField_i_of_type_Int == 21)) {
      a(15000L);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramInt1 == 0) {
      paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 0, paramInt2);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptRequest: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", toUin = " + paramString + ", result = " + paramInt1);
      }
      if (paramInt1 == 0)
      {
        a().a("acceptRequest", 3);
        o();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
        SmartDeviceReport.a(null, "Usr_TV_Video", 4, 0, 0);
      }
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().jdField_j_of_type_Long, 9, 1L);
      VideoNodeManager.a(37);
      return paramInt1;
      if (1 == paramInt1) {
        paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 2, paramInt2);
      } else {
        paramInt1 = -1;
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo request selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", toUin: " + paramString1 + ", businessType: " + paramInt1 + ", relationType: " + paramInt2 + ", fromNation: " + paramString2 + ", fromMobile: " + paramString3 + ", toMobile: " + paramString4 + ", uinType: " + paramInt3 + ", extraUin: " + paramString5 + ", sig: " + paramArrayOfByte + ", bindID: " + paramString8 + ", bindType: " + paramInt4 + ", subServiceType: " + paramInt5);
    if (paramArrayOfByte != null) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "request sigLength: " + paramArrayOfByte.length);
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail, network not support!");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,controller is null!");
      return -1;
    }
    String str = paramString1;
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
    if ((a() != null) && (a().d()) && (a().jdField_c_of_type_JavaLangString != null) && (str.equals(a().jdField_c_of_type_JavaLangString)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "request fail,----already receive invite, return~");
      a().jdField_a_of_type_Boolean = true;
      return -1;
    }
    int i1;
    long l1;
    long l2;
    if (paramInt3 == 9500)
    {
      T();
      i1 = -1;
      l1 = 0L;
      if (a().ak)
      {
        l1 = a().jdField_h_of_type_Long;
        j();
      }
      paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request funcall buffer:" + paramString1);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      VideoNodeManager.a(28);
      VideoNodeManager.a(11, Long.valueOf(str).longValue());
      VideoNodeManager.a(12, 1L);
      if (!a().Q) {
        break label873;
      }
      l2 = 1L;
      label534:
      VideoNodeManager.a(13, l2);
      VideoNodeManager.a(15, 1L);
      R();
      if ((a().jdField_i_of_type_Int != 1011) && (a().jdField_i_of_type_Int != 21)) {
        break label887;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      a().Q = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label881;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, paramString1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label670:
      AVReport.a().jdField_o_of_type_Boolean = a().Q;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "request result = " + i1 + ", uinType = " + paramInt3 + ", accostType = " + i2);
      if (i1 == 0)
      {
        a().a("request", 1);
        a().jdField_i_of_type_Int = paramInt3;
        a().jdField_j_of_type_Int = i2;
        if ((a().jdField_d_of_type_Int != 3) && (a().jdField_d_of_type_Int != 4)) {
          a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
        }
        l();
        if (!a().Q) {
          break label1280;
        }
      }
    }
    label1280:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      for (;;)
      {
        a(a().jdField_b_of_type_JavaLangString, paramInt1, false, false, true);
        a().jdField_n_of_type_Int = -1;
        this.jdField_o_of_type_Boolean = false;
        x(a().jdField_c_of_type_JavaLangString);
        a().ai = false;
        return i1;
        this.A = true;
        break;
        label873:
        l2 = 2L;
        break label534;
        label881:
        i1 = 0;
        break label670;
        label887:
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
            a().Q = false;
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
        a().Q = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = C2BUserInfo.a(paramString10);
          if (paramString10 != null) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number");
          }
          for (paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, paramString1, paramString7, paramString8, paramInt4, paramInt5, paramString9, paramString10);; paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, paramString1, paramString7, paramString8, paramInt4, paramInt5, paramString9))
          {
            i1 = paramInt1;
            break;
            QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number is null");
          }
        }
        i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, paramString1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
        break label670;
      }
      if (1 != paramInt1) {
        break label670;
      }
      a().Q = false;
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, paramString1, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      break label670;
    }
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString2, int paramInt3)
  {
    if ((paramInt3 == 2) && (paramArrayOfByte != null))
    {
      paramArrayOfByte[0] = 1;
      paramArrayOfByte[1] = 1;
      paramArrayOfByte[2] = -117;
    }
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestFromQQ2UnQQ selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", toUin: " + paramString1 + ", businessType: " + paramInt1 + ", relationType: " + paramInt2 + ", uinType: " + paramInt2 + ", bindId: " + paramString2 + ", bindType: " + paramInt3);
      if (paramArrayOfByte != null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request sigLength: " + paramArrayOfByte.length);
        HexUtil.a(jdField_a_of_type_JavaLangString, paramArrayOfByte);
      }
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "network not support!");
      }
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "controller is null!");
      }
      return -1;
    }
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, c(), paramInt1, paramInt2, paramArrayOfByte, paramString2, paramInt3);
    }
    if (i1 == 0)
    {
      a().a("requestFromQQ2UnQQ", 1);
      if ((a().jdField_d_of_type_Int != 3) && (a().jdField_d_of_type_Int != 4)) {
        a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
      }
      l();
      if (a().Q) {}
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        a(a().jdField_b_of_type_JavaLangString, paramInt1, false, false, true);
        a().jdField_n_of_type_Int = -1;
        this.jdField_o_of_type_Boolean = false;
        x(a().jdField_c_of_type_JavaLangString);
        return i1;
      }
    }
    return -1;
  }
  
  int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(AudioHelper.a(), paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public int a(ArrayList paramArrayList)
  {
    String[] arrayOfString = null;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "invitePstn --> info list is null or no data");
      return -1;
    }
    Object localObject = new String();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localObject = (String)localObject + " " + ((AVPhoneUserInfo)paramArrayList.get(i1)).toString() + " .";
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "invitePstn --> InfoList = " + (String)localObject);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    i1 = 0;
    if (i1 < paramArrayList.size())
    {
      localObject = (AVPhoneUserInfo)paramArrayList.get(i1);
      if ((((AVPhoneUserInfo)localObject).accountType == 1) || (((AVPhoneUserInfo)localObject).accountType == 2))
      {
        localArrayList1.add(Long.valueOf(((AVPhoneUserInfo)localObject).accountType));
        localArrayList1.add(Long.valueOf(((AVPhoneUserInfo)localObject).account));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (((AVPhoneUserInfo)localObject).accountType == 3)
        {
          localArrayList2.add(((AVPhoneUserInfo)localObject).telInfo.nation);
          localArrayList2.add(((AVPhoneUserInfo)localObject).telInfo.prefix);
          localArrayList2.add(((AVPhoneUserInfo)localObject).telInfo.mobile);
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = new long[localArrayList1.size()];
      i1 = 0;
      while (i1 < localArrayList1.size())
      {
        paramArrayList[i1] = ((Long)localArrayList1.get(i1)).longValue();
        i1 += 1;
      }
    }
    for (;;)
    {
      localObject = arrayOfString;
      if (localArrayList2.size() > 0)
      {
        arrayOfString = new String[localArrayList2.size()];
        i1 = 0;
        for (;;)
        {
          localObject = arrayOfString;
          if (i1 >= localArrayList2.size()) {
            break;
          }
          arrayOfString[i1] = ((String)localArrayList2.get(i1));
          i1 += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(paramArrayList, localArrayList1.size() / 2, (String[])localObject, localArrayList2.size() / 3, 0, false, false, 0);
      }
      return -1;
      paramArrayList = null;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sharp SetAudioInputMute: " + paramBoolean);
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioInputMute(paramString, paramBoolean);
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
  
  public long a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getChatRoomID(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getChatRoomId --> VcCtrl is null. PeerUin = " + paramString);
    }
    return 0L;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestStrangerFace: " + paramString + ", uinType = " + a().jdField_i_of_type_Int);
    }
    Bitmap localBitmap = a(paramString, false);
    if (localBitmap != null) {
      return localBitmap;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString, a().jdField_i_of_type_Int);
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
            } while (a().jdField_i_of_type_Int == 25);
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
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(paramString).longValue()) {
        return (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      }
      i1 += 1;
    }
    return null;
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo key = " + paramString1 + ",value = " + paramString2 + ", isAllSessionIdle = " + this.jdField_a_of_type_ComTencentAvSessionMgr.b());
    }
    if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_ComTencentAvSessionMgr.b())) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(paramString1, paramString2);
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
  
  public AVPhoneUserInfo a(long paramLong, ArrayList paramArrayList)
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
  
  public EffectController a(Context paramContext)
  {
    if ((this.jdField_b_of_type_ComTencentAvOpenglEffectsEffectController == null) && (paramContext != null))
    {
      this.jdField_b_of_type_ComTencentAvOpenglEffectsEffectController = new EffectsRenderController(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, null);
      this.jdField_b_of_type_ComTencentAvOpenglEffectsEffectController.a();
    }
    return this.jdField_b_of_type_ComTencentAvOpenglEffectsEffectController;
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
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i1, paramString1, paramString2);
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
  
  public String a(ArrayList paramArrayList)
  {
    Object localObject = new String();
    label111:
    do
    {
      try
      {
        str = "VideoViewInfo[" + paramArrayList.size() + "]\n";
        localObject = str;
        int i1 = 0;
        str = (String)localObject + "Exception[" + paramArrayList.getClass().getName() + "]\n";
      }
      catch (Exception paramArrayList)
      {
        try
        {
          while (i1 < paramArrayList.size())
          {
            str = (String)localObject + i1 + ", " + ((VideoViewInfo)paramArrayList.get(i1)).toString() + "\n";
            localObject = str;
            i1 += 1;
          }
          return localObject;
        }
        catch (Exception paramArrayList)
        {
          String str;
          break label111;
        }
        paramArrayList = paramArrayList;
      }
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getVideoViewInfoListInfo Exception," + str, paramArrayList);
    return str;
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
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
              break label159;
            }
            localArrayList2.add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
            break label159;
          }
          if (!localGAudioFriends.jdField_g_of_type_Boolean) {
            continue;
          }
          localGAudioFriends.jdField_g_of_type_Boolean = false;
        }
      }
      return localArrayList3;
      label159:
      i1 += 1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNetWorkTimer");
    }
    if (this.D) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.D = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onApnChanged netType = " + paramInt);
    }
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label145;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
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
    this.jdField_c_of_type_Long = paramInt3;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoSrcChange-->videoSrcType=" + paramInt1 + "relationType=" + paramInt2 + "userUin=" + paramLong1 + "groupUin=" + paramLong2);
    }
    int i1 = a(paramLong1);
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onVideoSrcChange-->can not find the user");
      }
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject1 = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        i1 = 0;
        if (i1 >= a().jdField_c_of_type_JavaUtilArrayList.size()) {
          break label546;
        }
        if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
        {
          i2 = ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
          if (paramInt1 != 4) {
            continue;
          }
          if (i1 == -1) {
            break label540;
          }
          a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, 0, true);
          y();
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i2) });
          i1 = 0;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(73), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt2) });
          if (i1 == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(87), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return;
        }
        i1 += 1;
        continue;
        if (paramInt1 == 0) {
          break label555;
        }
        i1 = a().a(paramLong1, 0);
        if (i1 == -1)
        {
          a(paramLong1, true, paramInt2, 5L);
          a((VideoController.GAudioFriends)localObject1, paramInt1);
          i1 = a().a(paramLong1, 0);
          ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;
          i1 = 1;
          continue;
        }
        localObject1 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        localVideoViewInfo.jdField_a_of_type_Long = ((VideoViewInfo)localObject1).jdField_a_of_type_Long;
        localVideoViewInfo.jdField_a_of_type_Int = ((VideoViewInfo)localObject1).jdField_a_of_type_Int;
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(localVideoViewInfo);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList2 });
        ((VideoViewInfo)localObject1).jdField_a_of_type_Int = paramInt1;
        i1 = 1;
      }
      label540:
      i1 = 1;
      continue;
      label546:
      i1 = -1;
      int i2 = 1;
      continue;
      label555:
      i1 = 0;
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
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_m_of_type_JavaLangString);
    }
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    QLog.d("Lightalk-openSdk", 2, String.format("sendLightalkMsgToQQ: uinType=%d, friendUin=%s, extraUin=%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2 }));
    Intent localIntent;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AddLightalkMsg");
      if ((!a().d()) || (paramInt2 != 1)) {
        break label271;
      }
      bool1 = true;
    }
    for (;;)
    {
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("msgType", paramInt2);
      localIntent.putExtra("isVideoMsg", false);
      localIntent.putExtra("isRead", bool1);
      localIntent.putExtra("bindType", a().A);
      localIntent.putExtra("bindId", a().jdField_n_of_type_JavaLangString);
      if (paramInt1 == 26)
      {
        localIntent.putExtra("friendUin", paramString2);
        label169:
        localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        if (a().jdField_a_of_type_Boolean) {
          break label300;
        }
      }
      label271:
      label300:
      for (bool1 = bool2;; bool1 = false)
      {
        localIntent.putExtra("isSender", bool1);
        paramString1 = null;
        if (a().jdField_d_of_type_Long > 0L) {
          paramString1 = UITools.a(a());
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
        return;
        if (!a().f()) {
          break label306;
        }
        bool1 = true;
        break;
        localIntent.putExtra("friendUin", paramString1);
        break label169;
      }
      label306:
      bool1 = false;
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
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize dataTransfered: dirction = " + paramInt + ", size = " + paramLong);
      }
      Intent localIntent = new Intent("tencent.video.v2q.VideoFlowSize");
      localIntent.putExtra("direction", paramInt);
      localIntent.putExtra("size", paramLong);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      String str;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      long l3;
      int i1;
      long l1;
      try
      {
        AVLog.a("VideoNodeManager", "==> quitGAudioChat()**********************************");
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        str = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
        if (paramInt1 != 3) {
          break label2133;
        }
        str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
        localObject3 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
        if (QLog.isColorLevel())
        {
          localObject4 = jdField_a_of_type_JavaLangString;
          localObject5 = new StringBuilder().append("quitGAudioChat, groupId[").append(paramLong).append("], relationType[").append(paramInt1).append("], reason[").append(paramInt2).append("], sessionId[").append(str).append("], sessionInfo[").append(localObject3).append("], app[");
          if (localObject2 != null)
          {
            bool1 = true;
            QLog.w((String)localObject4, 1, bool1 + "]");
          }
        }
        else
        {
          if (localObject2 != null) {
            continue;
          }
          return;
        }
        bool1 = false;
        continue;
        if (localObject3 == null) {
          continue;
        }
        VideoNodeManager.a(((SessionInfo)localObject3).jdField_j_of_type_Long, 15, 2L);
        VideoNodeManager.a(((SessionInfo)localObject3).jdField_j_of_type_Long, 16, 0L);
        VideoNodeManager.a(((SessionInfo)localObject3).jdField_j_of_type_Long, 33);
        VideoNodeManager.b(((SessionInfo)localObject3).jdField_j_of_type_Long);
        ((VideoAppInterface)localObject2).a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
        this.jdField_i_of_type_JavaLangRunnable = null;
        if (this.jdField_f_of_type_JavaLangRunnable != null)
        {
          ((VideoAppInterface)localObject2).a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), String.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        if ((a().jdField_f_of_type_JavaUtilArrayList.size() > 0) && (a().af)) {
          C();
        }
        if ((paramInt1 == 2) && (!((SessionInfo)localObject3).af) && (((SessionInfo)localObject3).jdField_f_of_type_JavaUtilArrayList != null))
        {
          localObject4 = new Intent();
          ((Intent)localObject4).setAction("tencent.av.v2q.MultiVideo");
          ((Intent)localObject4).putExtra("type", 411);
          ((Intent)localObject4).putExtra("phoneList", a().jdField_f_of_type_JavaUtilArrayList);
          ((Intent)localObject4).putExtra("relationType", a().F);
          ((Intent)localObject4).putExtra("relationId", a().jdField_f_of_type_Long);
          ((Intent)localObject4).putExtra("MultiAVType", a().D);
          ((Intent)localObject4).putExtra("from", "VideoController2");
          ((Intent)localObject4).setPackage(((VideoAppInterface)localObject2).getApp().getPackageName());
          ((VideoAppInterface)localObject2).getApp().sendBroadcast((Intent)localObject4);
        }
        if (paramInt1 == 7) {
          a(0, 0, null);
        }
        if (paramInt1 == 9)
        {
          ((SessionInfo)localObject3).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          ((SessionInfo)localObject3).e();
          ((SessionInfo)localObject3).d();
        }
        if (paramInt1 == 10)
        {
          ((SessionInfo)localObject3).e();
          ((SessionInfo)localObject3).d();
        }
        if (paramInt1 != 2) {
          break label1701;
        }
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject3).jdField_o_of_type_JavaLangString)) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE5", "0X8004CE5", 0, 0, "", "", "", "");
        }
        if (h()) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE8", "0X8004CE8", 0, 0, "", "", "", "");
        }
        if (((SessionInfo)localObject3).jdField_f_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CEB", "0X8004CEB", 0, 0, "", "", "", "");
          if (!((SessionInfo)localObject3).jdField_h_of_type_Boolean) {
            break label1665;
          }
        }
        if ((a().jdField_d_of_type_Int == 4) && (EffectBeautyTools.a())) {
          ReportController.b(null, "CliOper", "", "", "0X8008135", "0X8008135", 0, 0, a().jdField_K_of_type_Int + "", "", "", "");
        }
        if ((this.jdField_w_of_type_Boolean) && (a() > 0L)) {
          ReportController.b(null, "CliOper", "", "", "0X8008B2F ", "0X8008B2F ", 0, 0, "", "", UITools.a(a()), "");
        }
        l3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetTrafficSize(paramLong);
        if (paramInt2 == 7) {
          break label2136;
        }
        if (paramInt2 != 20) {
          break label2127;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quit(i1);
      int i2;
      int i3;
      boolean bool2;
      if ((this.jdField_e_of_type_Boolean) && (((SessionInfo)localObject3).jdField_g_of_type_Int == 9) && (!((SessionInfo)localObject3).ah))
      {
        l1 = 0L;
        this.jdField_p_of_type_Boolean = false;
        if ((((SessionInfo)localObject3).n()) && (((SessionInfo)localObject3).F == 2) && (((SessionInfo)localObject3).jdField_v_of_type_Int == 4) && (((SessionInfo)localObject3).af) && (((SessionInfo)localObject3).jdField_f_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject4 = new Intent("tencent.av.v2q.multiPsntTryEnd");
          ((Intent)localObject4).setPackage(((VideoAppInterface)localObject2).getApp().getPackageName());
          ((VideoAppInterface)localObject2).getApp().sendBroadcast((Intent)localObject4);
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 0) || (this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != 0L)) {
          break label2121;
        }
        i2 = 1;
        i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_e_of_type_Boolean = false;
        ((SessionInfo)localObject3).U = false;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup = false;
        localObject4 = ((VideoAppInterface)localObject2).getCurrentAccountUin();
        long l2 = 0L;
        if (localObject4 != null) {
          l2 = CharacterUtil.a((String)localObject4);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject5 = new Intent();
          ((Intent)localObject5).setAction("tencent.av.v2q.MultiVideo");
          ((Intent)localObject5).putExtra("type", 23);
          ((Intent)localObject5).putExtra("friendUin", l2);
          ((Intent)localObject5).putExtra("relationId", paramLong);
          ((Intent)localObject5).putExtra("relationType", paramInt1);
          ((Intent)localObject5).putExtra("MultiAVType", ((SessionInfo)localObject3).D);
          ((Intent)localObject5).putExtra("time", l1);
          ((Intent)localObject5).putExtra("isStart", this.jdField_v_of_type_Boolean);
          ((Intent)localObject5).putExtra("PLACE", a().jdField_s_of_type_JavaLangString);
          ((Intent)localObject5).putExtra("quitReson", paramInt2);
          ((Intent)localObject5).putExtra("from", "VideoController3");
          if (i3 <= 1) {
            break label2071;
          }
          ((Intent)localObject5).putExtra("roomUserNum", i3 - 1);
          bool2 = false;
          if (!((SessionInfo)localObject3).af) {
            break label2084;
          }
          bool1 = bool2;
          if (((SessionInfo)localObject3).jdField_e_of_type_JavaUtilArrayList != null)
          {
            bool1 = bool2;
            if (((SessionInfo)localObject3).jdField_e_of_type_JavaUtilArrayList.size() > 0) {
              bool1 = true;
            }
          }
          ((Intent)localObject5).putExtra("hasPstn", bool1);
          ((Intent)localObject5).setPackage(((VideoAppInterface)localObject2).getApp().getPackageName());
          ((VideoAppInterface)localObject2).getApp().sendBroadcast((Intent)localObject5);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "quitGAudioChat: send broadcast of quit chatting");
          }
        }
        ((SessionInfo)localObject3).jdField_o_of_type_JavaLangString = null;
        ((SessionInfo)localObject3).jdField_a_of_type_ArrayOfJavaLangString = null;
        m();
        if (((SessionInfo)localObject3).jdField_c_of_type_JavaUtilArrayList.size() > 0) {
          ((VideoAppInterface)localObject2).a(new Object[] { Integer.valueOf(104), ((SessionInfo)localObject3).jdField_c_of_type_JavaUtilArrayList });
        }
        if (((SessionInfo)localObject3).F == 1) {
          ((VideoAppInterface)localObject2).a(new Object[] { Integer.valueOf(410), Long.valueOf(paramLong) });
        }
        localObject5 = ((SessionInfo)localObject3).r;
        if (((SessionInfo)localObject3).F == 1) {
          ((SessionInfo)localObject3).jdField_f_of_type_Boolean = false;
        }
        ((SessionInfo)localObject3).f();
        k();
        TipsManager.c(109);
        if (i2 == 0) {
          a("quitGAudioChat_" + paramInt2, str, UITools.b(paramInt1), (String)localObject4, String.valueOf(paramLong), 7, (String)localObject5, false, false);
        }
        ((SessionInfo)localObject3).jdField_i_of_type_Int = -1;
        ((SessionInfo)localObject3).jdField_i_of_type_Int = -1;
        ((SessionInfo)localObject3).jdField_k_of_type_Boolean = true;
        this.jdField_b_of_type_Long = l3;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize size = " + l3);
        }
        localObject3 = new Intent("tencent.video.v2q.VideoFlowSize");
        ((Intent)localObject3).putExtra("size", l3);
        ((Intent)localObject3).setPackage(((VideoAppInterface)localObject2).getApp().getPackageName());
        if (i2 == 0) {
          ((VideoAppInterface)localObject2).getApp().sendBroadcast((Intent)localObject3);
        }
        bool1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
        localObject2 = QAVNotification.a((VideoAppInterface)localObject2);
        if ((localObject2 != null) && (((QAVNotification)localObject2).a()))
        {
          ((QAVNotification)localObject2).a(str);
          if (bool1) {
            g();
          }
        }
        PopupDialog.a();
        d(i1);
        continue;
        label1665:
        ReportController.b(null, "CliOper", "", "", "0X8004CEF ", "0X8004CEF ", 0, 0, "", "", "", "");
        continue;
        label1701:
        if (paramInt1 != 1) {
          continue;
        }
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject3).jdField_o_of_type_JavaLangString))
        {
          if (((SessionInfo)localObject3).D == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005942", "0X8005942", 0, 0, "", "", "", "");
          }
        }
        else
        {
          label1763:
          if (h())
          {
            if (((SessionInfo)localObject3).D != 10) {
              break label1954;
            }
            ReportController.b(null, "CliOper", "", "", "0X8005943", "0X8005943", 0, 0, "", "", "", "");
          }
          label1813:
          if (!((SessionInfo)localObject3).jdField_f_of_type_Boolean) {
            break label1988;
          }
          if (((SessionInfo)localObject3).D != 10) {
            break label1990;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005944", "0X8005944", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          if (((SessionInfo)localObject3).jdField_h_of_type_Boolean) {
            break label2024;
          }
          if (((SessionInfo)localObject3).D != 10) {
            break label2026;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005945 ", "0X8005945 ", 0, 0, "", "", "", "");
          break;
          ReportController.b(null, "CliOper", "", "", "0X8004F54", "0X8004F54", 0, 0, "", "", "", "");
          break label1763;
          label1954:
          ReportController.b(null, "CliOper", "", "", "0X8004F55", "0X8004F55", 0, 0, "", "", "", "");
          break label1813;
          label1988:
          break;
          label1990:
          ReportController.b(null, "CliOper", "", "", "0X8004F56", "0X8004F56", 0, 0, "", "", "", "");
        }
        label2024:
        continue;
        label2026:
        ReportController.b(null, "CliOper", "", "", "0X8004F57 ", "0X8004F57 ", 0, 0, "", "", "", "");
        continue;
      }
      else
      {
        l1 = a();
        continue;
      }
      label2071:
      ((Intent)localObject5).putExtra("roomUserNum", 0);
      continue;
      label2084:
      boolean bool1 = bool2;
      if (((SessionInfo)localObject3).jdField_f_of_type_JavaUtilArrayList != null)
      {
        i3 = ((SessionInfo)localObject3).jdField_f_of_type_JavaUtilArrayList.size();
        bool1 = bool2;
        if (i3 > 0)
        {
          bool1 = true;
          continue;
          label2121:
          i2 = 0;
          continue;
          label2127:
          i1 = 0;
          continue;
          label2133:
          continue;
          label2136:
          i1 = paramInt2;
        }
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioSDKError-->GroupId=" + paramLong + "reason=" + paramInt2);
    }
    if (paramLong == 0L) {
      return;
    }
    SessionInfo localSessionInfo = a();
    if (localSessionInfo != null)
    {
      AVLog.d(jdField_a_of_type_JavaLangString, " TYPE_NOTIFY_CAMERA_CLOSE 1: " + localSessionInfo.jdField_f_of_type_Boolean + "|" + localSessionInfo.jdField_d_of_type_Int);
      if (localSessionInfo.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      }
    }
    if ((l()) && ((paramInt2 == 16) || (paramInt2 == 17)))
    {
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 70);
      }
      a("onGAudioSDKError");
      if ((-19 == paramInt3) || (19 == paramInt3))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
        this.jdField_i_of_type_JavaLangRunnable = null;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(200), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    int i1 = UITools.b(paramInt1);
    a(a().jdField_b_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
    if (this.jdField_e_of_type_Boolean) {
      a(paramInt1, paramLong, 71);
    }
    a("onGAudioSDKError");
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    AVLog.b("VideoNodeManager", "ignoreGAudioChat()***************************");
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (paramInt1 != 1) {
          break label98;
        }
        i1 = 2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.ignore(paramInt1, paramLong, i1);
      if (localObject != null) {
        break label154;
      }
      VideoNodeManager.a(0L, 33);
      VideoNodeManager.b(0L);
      return;
      str1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
      break;
      label98:
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
    label154:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Boolean = false;
    VideoNodeManager.a(((SessionInfo)localObject).jdField_j_of_type_Long, 38);
    VideoNodeManager.a(((SessionInfo)localObject).jdField_j_of_type_Long, 16, 0L);
    VideoNodeManager.a(((SessionInfo)localObject).jdField_j_of_type_Long, 33);
    VideoNodeManager.b(((SessionInfo)localObject).jdField_j_of_type_Long);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "ignoreGAudioChat, groupId[" + paramLong + "], iFlag[" + paramInt2 + "], state[" + ((SessionInfo)localObject).jdField_g_of_type_Int + "]");
    ((SessionInfo)localObject).aj = true;
    int i1 = 4;
    label297:
    String str2;
    if (((SessionInfo)localObject).jdField_g_of_type_Int == 7)
    {
      ((SessionInfo)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        m();
        paramInt2 = UITools.b(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label431;
        }
        a("ignoreGAudioChat_1", ((SessionInfo)localObject).jdField_b_of_type_JavaLangString, UITools.b(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((SessionInfo)localObject).jdField_f_of_type_Long), 5, ((SessionInfo)localObject).r, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1);
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((QAVNotification)localObject).a())) {
        break;
      }
      ((QAVNotification)localObject).a(str1);
      if (!paramBoolean) {
        break;
      }
      g();
      return;
      i1 = 3;
      break label297;
      if (paramInt2 == -1) {
        break label297;
      }
      i1 = paramInt2;
      break label297;
      label431:
      if (paramInt1 == 3) {
        a("ignoreGAudioChat_2", str1, paramInt2, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString, String.valueOf(paramLong), i1, ((SessionInfo)localObject).r, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong), i1, ((SessionInfo)localObject).r, paramBoolean, false);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 90) {
      if (paramLong1 == 3L) {
        a().a(true, false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      }
      return;
      a().a(false, false);
      continue;
      a().a(false, false);
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
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AVLog.a("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    f(false);
    boolean bool1 = a().jdField_I_of_type_Boolean;
    long l1 = a(String.valueOf(paramLong2));
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("onGAudioInvite, friendUin[").append(paramLong2).append("], groupId[").append(paramLong1).append("], multiSubType[").append(paramInt3).append("], multiAVType[").append(paramInt2).append("], relationType[").append(paramInt1).append("], isTure2DoubleVideoMeeting[").append(bool1).append("], mGAudioInRoom[").append(this.jdField_e_of_type_Boolean).append("], mGAudioGroupId[").append(this.jdField_a_of_type_Long).append("], mCurrentInviteId[").append(this.jdField_e_of_type_Long).append("], mCurrentInviteRelationType[").append(this.s).append("], app[");
      if (localVideoAppInterface != null)
      {
        paramBoolean = true;
        QLog.w((String)localObject1, 1, paramBoolean + "]");
      }
    }
    else
    {
      if (localVideoAppInterface != null) {
        break label224;
      }
    }
    label224:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        localObject1 = (VideoNodeReporter)localVideoAppInterface.a(4);
        ((VideoNodeReporter)localObject1).a(l1, 20, 3);
        ((VideoNodeReporter)localObject1).a(l1, 6, 1L);
      } while ((paramInt1 == 1) && (!QAVGroupConfig.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1)));
      localObject1 = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[0]);
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1)) {
        break label314;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Session already exists");
    return;
    label314:
    Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1, false);
    ((SessionInfo)localObject2).jdField_f_of_type_Long = paramLong1;
    ((SessionInfo)localObject2).F = paramInt1;
    ((SessionInfo)localObject2).D = paramInt2;
    ((SessionInfo)localObject2).aj = false;
    ((SessionInfo)localObject2).W = false;
    ((SessionInfo)localObject2).X = false;
    ((SessionInfo)localObject2).Y = false;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() >= 2)
    {
      a("too_much_session", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    VideoConstants.jdField_b_of_type_Boolean = localVideoAppInterface.c();
    paramBoolean = false;
    SessionInfo localSessionInfo = a();
    if ((localSessionInfo != null) && (!localSessionInfo.a())) {
      paramBoolean = true;
    }
    boolean bool2;
    for (;;)
    {
      if (this.jdField_g_of_type_JavaLangRunnable != null)
      {
        if (localVideoAppInterface.a() != null) {
          localVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
        }
        this.jdField_g_of_type_JavaLangRunnable = null;
        ((SessionInfo)localObject2).a("onGAudioInvite.1", 0);
      }
      R();
      bool2 = a(localVideoAppInterface.getApp().getApplicationContext());
      if (!bool2) {
        break label742;
      }
      if ((a().jdField_g_of_type_Int <= 0) || (a().jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
        break;
      }
      a("ScreenLocked_before_connect", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
      if (localVideoAppInterface.e()) {
        paramBoolean = true;
      }
    }
    if (7 == a().jdField_g_of_type_Int)
    {
      a("ScreenLocked_group_invite", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
    {
      a("ScreenLocked_group_in_room", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((a().jdField_g_of_type_Int == 14) || (a().jdField_g_of_type_Int == 13))
    {
      a("ScreenLocked_double_meeting", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1))
    {
      a("ScreenLocked_in_random", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if (paramBoolean)
    {
      a("ScreenLocked_session_exist", (String)localObject1, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    label742:
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int + "], chatType[" + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int + "], SessionType[" + ((SessionInfo)localObject2).jdField_d_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool2 + "]");
    }
    if (((SessionInfo)localObject2).jdField_d_of_type_Int == 0)
    {
      ((SessionInfo)localObject2).jdField_a_of_type_Boolean = true;
      ((SessionInfo)localObject2).jdField_d_of_type_Int = 3;
      ((SessionInfo)localObject2).jdField_i_of_type_Int = UITools.b(paramInt1);
      ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString = String.valueOf(paramLong2);
      if (paramInt1 == 2) {
        ((SessionInfo)localObject2).r = String.valueOf(paramLong2);
      }
      ((SessionInfo)localObject2).jdField_a_of_type_Boolean = true;
      a((String)localObject1, ((SessionInfo)localObject2).jdField_d_of_type_Int, false, false, false);
    }
    this.jdField_e_of_type_Long = paramLong1;
    this.s = paramInt1;
    if (((SessionInfo)localObject2).jdField_g_of_type_Int == 0) {
      ((SessionInfo)localObject2).a("onGAudioInvite", 7);
    }
    if ((paramInt3 == 3) && (a().jdField_f_of_type_Long == 0L))
    {
      if ((a().jdField_c_of_type_JavaLangString == null) || (!a().jdField_c_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(paramLong2)))) {
        break label2754;
      }
      ((SessionInfo)localObject2).jdField_f_of_type_Boolean = a().jdField_f_of_type_Boolean;
      try
      {
        if (paramLong2 != Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue()) {
          break label1585;
        }
        if (a().jdField_z_of_type_Int == 0)
        {
          a().a("onGAudioInvite.2", 0);
          this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
          return;
        }
      }
      catch (Exception paramArrayOfLong)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramArrayOfLong.getMessage());
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
        return;
      }
      if ((this.jdField_c_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null) && (localVideoAppInterface.a() != null)) {
        localVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      if (!a().jdField_T_of_type_Boolean) {
        a("onGAudioInvite.1", 2131230735, 1, null);
      }
      paramInt2 = a().jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_c_of_type_JavaLangString = a().jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_f_of_type_Boolean = a().jdField_f_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_c_of_type_Boolean = a().jdField_c_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_N_of_type_Boolean = a().jdField_N_of_type_Boolean;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_o_of_type_JavaLangString = a().jdField_o_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_h_of_type_Int = 12;
      a().jdField_h_of_type_Int = 12;
      c(a().jdField_c_of_type_JavaLangString, 21);
      if (paramInt2 == 1)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_d_of_type_Int = 3;
        label1319:
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_i_of_type_Int = 3000;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_f_of_type_Long = paramLong1;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).q = Long.toString(paramLong1);
        if (paramArrayOfLong != null) {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).E = 1;
        if (localVideoAppInterface.a() <= 0) {
          break label1548;
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).a("onGAudioInvite1", true);
        localVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
      }
      for (;;)
      {
        paramArrayOfLong = QAVNotification.a(localVideoAppInterface);
        paramBoolean = false;
        if (paramArrayOfLong != null)
        {
          bool1 = paramArrayOfLong.a();
          paramBoolean = bool1;
          if (bool1)
          {
            paramArrayOfLong.a((String)localObject1);
            paramBoolean = bool1;
          }
        }
        if (!paramBoolean) {
          break;
        }
        g();
        return;
        if (paramInt2 == 2)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_d_of_type_Int = 4;
          break label1319;
        }
        if (paramInt2 == 4)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_d_of_type_Int = 4;
          break label1319;
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_d_of_type_Int = 3;
        break label1319;
        label1548:
        if (localVideoAppInterface.isBackground_Stop)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).a("onGAudioInvite2", false);
          a(paramInt1, paramLong1, paramArrayOfLong, false);
        }
      }
      label1585:
      paramBoolean = false;
    }
    label2322:
    label2728:
    label2741:
    label2747:
    label2754:
    for (;;)
    {
      if ((localVideoAppInterface != null) && (localVideoAppInterface.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, phone is calling");
        }
        paramArrayOfLong = new Intent();
        paramArrayOfLong.setAction("tencent.video.v2q.CallingDialogMulti");
        paramArrayOfLong.setPackage(localVideoAppInterface.getApp().getPackageName());
        paramArrayOfLong.putExtra("friendUin", paramLong2);
        paramArrayOfLong.putExtra("sessionType", 3);
        paramArrayOfLong.putExtra("uinType", 3000);
        paramArrayOfLong.putExtra("relationType", paramInt1);
        paramArrayOfLong.putExtra("extraUin", a().jdField_e_of_type_JavaLangString);
        paramArrayOfLong.putExtra("discussId", paramLong1);
        paramArrayOfLong.putExtra("type", 13);
        paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("isSender", false);
        paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("realSenderUin", a().r);
        localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
        a(this.s, paramLong1, true);
        new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a("onGAudioInvite", 0, 2131230736, null, null, false, 1, false, true, 0);
        this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
        return;
        if ((paramInt3 == 4) && (bool1))
        {
          a().jdField_I_of_type_Boolean = false;
          if ((a().jdField_c_of_type_JavaLangString != null) && (a().jdField_c_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(paramLong2))))
          {
            for (;;)
            {
              try
              {
                ((SessionInfo)localObject2).jdField_f_of_type_Boolean = a().jdField_f_of_type_Boolean;
                if (paramLong2 != Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue()) {
                  break label2322;
                }
                if ((this.jdField_d_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
                  localVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
                }
                if (!a().jdField_T_of_type_Boolean) {
                  a("onGAudioInvite.2", 2131230735, 1, null);
                }
                paramInt2 = a().jdField_d_of_type_Int;
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1).jdField_c_of_type_JavaLangString = a().jdField_c_of_type_JavaLangString;
                if ((a().jdField_g_of_type_Int == 15) || (a().H)) {
                  g(false);
                }
                a().jdField_h_of_type_Int = 12;
                if (paramInt2 == 1)
                {
                  a().jdField_d_of_type_Int = 3;
                  a().jdField_i_of_type_Int = 3000;
                  a().jdField_f_of_type_Long = paramLong1;
                  a().q = Long.toString(paramLong1);
                  if (paramArrayOfLong != null) {
                    a().jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
                  }
                  a().E = 1;
                  if (localVideoAppInterface != null)
                  {
                    if (localVideoAppInterface.a() <= 0) {
                      break label2290;
                    }
                    a().a("onGAudioInvite3", true);
                    localVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
                  }
                  paramArrayOfLong = QAVNotification.a(localVideoAppInterface);
                  paramBoolean = false;
                  if (paramArrayOfLong != null)
                  {
                    bool1 = paramArrayOfLong.a();
                    paramBoolean = bool1;
                    if (bool1)
                    {
                      paramArrayOfLong.a(a().jdField_b_of_type_JavaLangString);
                      paramBoolean = bool1;
                    }
                  }
                  if (!paramBoolean) {
                    break;
                  }
                  g();
                  return;
                }
              }
              catch (Exception paramArrayOfLong)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramArrayOfLong.getMessage());
                }
                this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject1);
                return;
              }
              if (paramInt2 == 2)
              {
                a().jdField_d_of_type_Int = 4;
              }
              else if (paramInt2 == 4)
              {
                a().jdField_d_of_type_Int = 4;
              }
              else
              {
                a().jdField_d_of_type_Int = 3;
                continue;
                label2290:
                if (localVideoAppInterface.isBackground_Stop)
                {
                  a().a("onGAudioInvite4", false);
                  a(paramInt1, paramLong1, paramArrayOfLong, false);
                }
              }
            }
            paramBoolean = false;
          }
        }
      }
      else
      {
        a().r = ("" + paramLong2);
        this.jdField_w_of_type_Boolean = a();
        if ((paramBoolean) || (VideoUtils.a()))
        {
          localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
          QAVGroupConfig.Report.d();
          ((Intent)localObject1).putExtra("uinType", UITools.b(paramInt1));
          ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
          ((Intent)localObject1).addFlags(268435456);
          BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
          ((Intent)localObject1).putExtra("friendUin", paramLong2);
          ((Intent)localObject1).putExtra("relationType", paramInt1);
          ((Intent)localObject1).putExtra("discussId", paramLong1);
          ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
          if ((!this.jdField_w_of_type_Boolean) || (!SmallScreenUtils.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
            break label2728;
          }
          if ((!paramBoolean) && (!VideoUtils.a())) {
            break label2698;
          }
          paramArrayOfLong = new MultiIncomingCallUICtr(this, localVideoAppInterface, (Intent)localObject1);
          paramArrayOfLong.e();
          paramArrayOfLong.a((Intent)localObject1);
          label2544:
          if (!localVideoAppInterface.jdField_c_of_type_Boolean) {
            break label2741;
          }
          localVideoAppInterface.jdField_c_of_type_Boolean = false;
          label2558:
          localVideoAppInterface.jdField_d_of_type_Boolean = true;
          paramLong2 = a().a();
          VideoNodeManager.a(35);
          VideoNodeManager.a(paramLong2, 36);
          VideoNodeManager.a(paramLong2, 9, a().a());
          VideoNodeManager.a(paramLong2, 12, 2L);
          if (!a().Q) {
            break label2747;
          }
        }
        for (paramLong1 = 1L;; paramLong1 = 2L)
        {
          VideoNodeManager.a(paramLong2, 13, paramLong1);
          VideoNodeManager.a(paramLong2, 15, 2L);
          return;
          if (bool2)
          {
            localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
            n();
            break;
          }
          localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteDialogActivity.class);
          QAVGroupConfig.Report.d();
          break;
          paramArrayOfLong = new VideoInviteFloatBarUICtr(this, localVideoAppInterface, (Intent)localObject1);
          paramArrayOfLong.e();
          paramArrayOfLong.a((Intent)localObject1);
          break label2544;
          localVideoAppInterface.getApp().startActivity((Intent)localObject1);
          break label2544;
          VideoNodeManager.a();
          break label2558;
        }
      }
    }
  }
  
  public void a(int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPstnErrorMsgCome --> Msg Type = " + paramInt + " , relationId = " + paramLong);
    }
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onPstnErrorMsgCome --> Is not in GAudioRoom Or RelationId is not equal. --> IsInRoom = " + this.jdField_a_of_type_Long + " ,mGAudioGroupId = " + this.jdField_a_of_type_Long);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(407), Integer.valueOf(paramInt), paramArrayList });
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt, paramLong, -1, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioTerminalEnterRoom,relationTye: " + paramInt + " GroupId: " + paramLong);
    }
    paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs);
      int i1;
      if ((localSessionInfo != null) && ((localSessionInfo.jdField_g_of_type_Int == 7) || (localSessionInfo.jdField_g_of_type_Int == 2)))
      {
        localSessionInfo.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs))
        {
          localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs);
          i1 = UITools.b(paramInt);
          if (paramInt != 3) {
            break label246;
          }
          a(localSessionInfo.jdField_b_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioTerminalEnterRoom not in invite");
        return;
        label246:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, localSessionInfo.r, true, false);
        }
      }
    }
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
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr == null) || (a() == null) || (a().jdField_c_of_type_JavaLangString == null)) {}
    while (!a().jdField_c_of_type_JavaLangString.equals(paramString)) {
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
      a().Q = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "remote confirm switch to video");
    }
    a().Q = false;
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
      Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((SessionInfo)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString)) && (((SessionInfo)localObject1).jdField_a_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((SessionInfo)localObject1).A);
      ((Intent)localObject2).putExtra("bindId", ((SessionInfo)localObject1).jdField_n_of_type_JavaLangString);
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
  
  public void a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo onRequestVideo uinType = " + paramInt1 + ", fromUin = " + paramString1 + ", extraUin = " + paramString2 + ", sig = " + paramArrayOfByte + ", onlyAudio = " + paramBoolean + ", bindID=" + paramString3 + " ,bindType=" + paramInt2);
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  faile,app is null");
      return;
    }
    R();
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    String str;
    boolean bool2;
    boolean bool3;
    for (int i1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramString1);; i1 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i1 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() >= 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->pending session exists");
        }
        int i2 = -1;
        str = null;
        if (a() != null)
        {
          i2 = a().jdField_i_of_type_Int;
          str = a().jdField_c_of_type_JavaLangString;
        }
        if ((i1 != 1011) || (i2 != 1011) || (str == null) || (!str.equals(paramString1))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->pending session exists, equals to the current one.");
        }
      }
      bool2 = false;
      bool3 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->isScreenLocked:" + bool3);
      }
      if ((i1 == 21) || (i1 == 1011) || ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0) && (!this.jdField_f_of_type_Boolean)) || (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1)) {
        break label1295;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when in Random Double");
      }
      if (!bool3) {
        break label515;
      }
      a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->pending session exists, just reject.");
    }
    a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
    return;
    label515:
    boolean bool1 = true;
    if (!this.jdField_f_of_type_Boolean)
    {
      a(30000L);
      bool1 = true;
      label535:
      str = SessionMgr.a(3, paramString1, new int[0]);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).A = paramInt2;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_n_of_type_JavaLangString = paramString3;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).B = i1;
      if (!VideoUtils.a(i1, paramInt2)) {
        break label1955;
      }
      if ((paramString2 == null) || (paramString2.startsWith("+"))) {
        break label1952;
      }
      paramString2 = "+" + paramString2;
      label657:
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_g_of_type_JavaLangString = paramString2;
      a(paramArrayOfByte, paramString1, paramInt2, i1, paramString2);
    }
    label768:
    label1295:
    label1952:
    label1955:
    for (;;)
    {
      if (this.jdField_g_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
        this.jdField_g_of_type_JavaLangRunnable = null;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).a("onRequestVideo.1", 0);
      }
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
        i1 = 9500;
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        a().Q = paramBoolean;
        label949:
        long l2;
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_f_of_type_Int = 1;
          l1 = a(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo  ,roomId = " + l1);
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_j_of_type_Long = l1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_i_of_type_Int = i1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_j_of_type_Int = paramInt1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_c_of_type_JavaLangString = paramString1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_e_of_type_JavaLangString = paramString2;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).a("onRequestVideo.2", 2);
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_p_of_type_Int = paramInt3;
          a(i1, paramString1, paramString2, paramArrayOfByte);
          paramArrayOfByte = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
          if (!paramBoolean) {
            break label1918;
          }
          paramInt1 = 1;
          paramArrayOfByte.a(l1, 20, paramInt1);
          paramArrayOfByte.a(l1, 6, 1L);
          l2 = a(paramString1);
          VideoNodeManager.a(l2, 36);
          VideoNodeManager.a(l2, 9, a().a());
          if (!TextUtils.isEmpty(paramString1)) {
            VideoNodeManager.a(l2, 11, Long.valueOf(paramString1).longValue());
          }
          VideoNodeManager.a(l2, 12, 2L);
          if (!a().Q) {
            break label1923;
          }
        }
        for (long l1 = 1L;; l1 = 2L)
        {
          VideoNodeManager.a(l2, 13, l1);
          VideoNodeManager.a(l2, 15, 1L);
          if (a(i1, paramString1, paramBoolean)) {
            break;
          }
          if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_i_of_type_Int != 21) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_i_of_type_Int != 1011)) {
            a(str, this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_f_of_type_Int, false, false, true);
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_z_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isScreenLocked: " + bool3 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
          }
          if ((!this.B) || (this.jdField_z_of_type_Int != 0) || (bool3) || (!VideoConstants.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause)) {
            break label1931;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jdq(this, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
          return;
          if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when in Random mulit");
            }
            if (bool3)
            {
              a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            bool1 = true;
            break label535;
          }
          if (a().a())
          {
            if (i1 == -1)
            {
              this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString1, c());
              AVLog.d(jdField_a_of_type_JavaLangString, "closeVideo uinType == -1");
              this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString1, 0);
              return;
            }
            bool1 = bool2;
            if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
              break label1899;
            }
            bool1 = true;
            break label535;
          }
          if ((a().g()) || (a().h()))
          {
            c(a().jdField_c_of_type_JavaLangString, 2);
            bool1 = false;
            break label535;
          }
          if (((a().jdField_g_of_type_Int == 7) && (this.jdField_e_of_type_Long != 0L)) || (a().jdField_g_of_type_Int == 14) || (a().jdField_g_of_type_Int == 13))
          {
            if (bool3)
            {
              a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            bool1 = true;
            break label535;
          }
          if (!this.jdField_e_of_type_Boolean)
          {
            if (((i1 == 21) || (i1 == 1011)) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo  auto Accept");
              }
              if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString.equals(paramString1)))
              {
                a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
                return;
              }
              a(30000L);
              bool1 = false;
              break label535;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool3);
            }
            bool1 = true;
            if ((a().jdField_c_of_type_JavaLangString != null) && (paramString1.equals(a().jdField_c_of_type_JavaLangString)))
            {
              AVLog.d(jdField_a_of_type_JavaLangString, "onRequestVideo when request: fromUin = " + paramString1);
              return;
            }
            if (!bool3) {
              break label1899;
            }
            a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          if ((this.jdField_e_of_type_Boolean) || (a().jdField_g_of_type_Int == 8))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when in group chat, fromUin = " + paramString1);
            }
            if (bool3)
            {
              a(false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            bool1 = true;
            break label535;
          }
          bool1 = bool2;
          if (a().jdField_g_of_type_Int == 1)
          {
            bool1 = bool2;
            if (a().jdField_c_of_type_JavaLangString != null)
            {
              if (paramString1.equals(a().jdField_c_of_type_JavaLangString)) {
                break;
              }
              bool1 = bool2;
            }
          }
          label1899:
          break label535;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_f_of_type_Int = 2;
          break label768;
          label1918:
          paramInt1 = 2;
          break label949;
        }
        a(str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
      }
      break label657;
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      AVUserInfo localAVUserInfo = (AVUserInfo)paramArrayList.get(i1);
      a(localAVUserInfo.jdField_a_of_type_Long, localAVUserInfo.jdField_a_of_type_Int, localAVUserInfo.jdField_b_of_type_Int, false);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(141), paramArrayList });
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
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherTerChatStatus(Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue(), (i2 << 21) + ((i1 << 20) + (paramInt & 0xFFFFF)));
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startCheckAnyChatReqTimeout ms: " + paramLong);
    }
    if (this.jdField_a_of_type_Jdu == null) {
      this.jdField_a_of_type_Jdu = new jdu(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jdu, paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    String str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong);
      }
      return;
    }
    ((SessionInfo)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("friendUin", paramLong);
      localIntent.putExtra("MultiAVType", ((SessionInfo)localObject).D);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((QAVNotification)localObject).a())) {
        break;
      }
      ((QAVNotification)localObject).a(str);
      if (!bool) {
        break;
      }
      g();
      return;
      a(str, 0, paramInt, true, "" + paramLong, "" + paramLong, false);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioKickOut-->Groupid=" + paramLong + " relationType=" + paramInt1);
    }
    paramInt2 = UITools.b(paramInt1);
    if ((this.jdField_e_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.jdField_z_of_type_Boolean = true;
      if (paramInt1 != 3) {
        break label306;
      }
      a(a().jdField_b_of_type_JavaLangString, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      paramInt1 = 7;
      if (paramInt2 != 3000) {
        break label334;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().jdField_G_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      SessionInfo localSessionInfo = a();
      if (localSessionInfo != null)
      {
        AVLog.d(jdField_a_of_type_JavaLangString, " TYPE_NOTIFY_CAMERA_CLOSE : " + localSessionInfo.jdField_f_of_type_Boolean + "|" + localSessionInfo.jdField_d_of_type_Int);
        if (localSessionInfo.jdField_f_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        }
      }
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramInt1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
      return;
      label306:
      a(a().jdField_b_of_type_JavaLangString, paramInt2, 20, false, String.valueOf(paramLong), null, false);
      paramInt1 = 20;
      break;
      label334:
      if (paramInt2 == 1) {
        if (a().D == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = a(paramLong, paramInt1, paramInt2, paramBoolean);
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (this.jdField_p_of_type_Boolean != paramBoolean) && (QLog.isColorLevel())) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "uin = " + paramLong + "mGAudioMute = " + this.jdField_p_of_type_Boolean + "  isMicOff = " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (bool)) {
      a(0L, false, 0L);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a(a().jdField_c_of_type_JavaLangString) == paramLong2) {
      a().ap = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRecvAudioReady uin = " + paramLong1 + ",roomid = " + paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        paramInt1 = a(paramLong2);
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
        if (paramInt2 == 1)
        {
          return;
          localGAudioFriends.jdField_d_of_type_Boolean = false;
        }
      }
      if (paramInt2 != 3) {
        if (paramInt2 != 4) {}
      }
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
      } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
      a().ae = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
    a().ae = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1)) {
      a(1, paramLong1, 82);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      this.jdField_i_of_type_JavaLangRunnable = null;
      a().a("onGroupSecurityLimit", 0);
      a(1, paramLong1, 17, 0);
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((!this.jdField_e_of_type_Boolean) || (a().jdField_f_of_type_Long != paramLong) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
  }
  
  public void a(long paramLong, ArrayList paramArrayList)
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
    a(arrayOfLong, false, 1, ConfigSystemImpl.c(a()));
  }
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (AudioHelper.e())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("onGAudioMemAllUpdate, mSimpleDataList[");
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      QLog.d((String)localObject1, 2, bool + "]");
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate-->mSimpleDataList is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Object localObject1 = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localObject2 = new VideoController.GAudioFriends(this);
      ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long = ((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Long;
      ((VideoController.GAudioFriends)localObject2).jdField_c_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Int;
      ((VideoController.GAudioFriends)localObject2).jdField_d_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      if (((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) {
        ((ArrayList)localObject1).add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Long));
      }
      i1 += 1;
    }
    if (((ArrayList)localObject1).size() > 0) {
      a((ArrayList)localObject1);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size()) {
        if (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            paramArrayList.remove(i1);
          }
          else
          {
            if (paramInt == ((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int)
            {
              paramArrayList.remove(i1);
              return;
            }
            i1 += 1;
          }
        }
        else {
          i1 += 1;
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    long l1 = this.jdField_a_of_type_Long;
    boolean bool1;
    if (!paramBoolean)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() != paramLong) {
        break label82;
      }
    }
    label82:
    for (boolean bool2 = true;; bool2 = false)
    {
      a("onGAudioMicSetByAdmin", l1, bool1, bool2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "quitDoubleVideoMeeting-->RelationId = " + paramLong);
    }
    String str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
    if (localSessionInfo == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong);
    localIntent.putExtra("friendUin", paramLong);
    localIntent.putExtra("MultiAVType", localSessionInfo.D);
    localIntent.putExtra("from", "VideoController6");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a(str, 0, paramInt, true, "" + paramLong, "" + paramLong, false);
    if (paramBoolean)
    {
      a(3, paramLong, 84);
      localSessionInfo.H = false;
      localSessionInfo.jdField_G_of_type_Boolean = false;
      return;
    }
    localSessionInfo.a("quitDoubleVideoMeeting", 15);
    a("quitDoubleVideoMeeting", 2131230740, 1, this.jdField_c_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
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
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
      SmartDeviceReport.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    T();
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramArrayOfByte, null);
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate-->mSimpleDataList is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (paramArrayOfLong == null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramInt2 = 0;
    while (paramInt2 < paramArrayOfLong.length)
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends(this);
      localGAudioFriends.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_b_of_type_JavaUtilArrayList.add(localGAudioFriends);
      paramInt2 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList, Integer.valueOf(paramInt1) });
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3)
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
      a(paramLong1, paramArrayOfLong, true);
      return;
      a(paramLong1, paramArrayOfLong, false);
      return;
      a(paramLong1, l1, true, paramInt2, paramLong2, paramInt3);
      return;
      a(paramLong1, l1, false, paramInt2, paramLong2, paramInt3);
      return;
      a(paramLong1, l1, true, paramInt2, false, paramLong2, paramInt3);
      return;
      a(paramLong1, l1, false, paramInt2, false, paramLong2, paramInt3);
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
  
  public void a(long paramLong, long[] paramArrayOfLong, ArrayList paramArrayList)
  {
    Object localObject;
    int i5;
    int i1;
    int i2;
    int i3;
    if (paramArrayOfLong != null)
    {
      localObject = SessionMgr.a(2, String.valueOf(paramLong), new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject, false);
      if (paramArrayList != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(PstnUtils.a((String)paramArrayList.next()));
        }
        ((SessionInfo)localObject).a(localArrayList);
        ((SessionInfo)localObject).jdField_g_of_type_JavaUtilArrayList = localArrayList;
      }
      i5 = a().jdField_d_of_type_Int;
      ((SessionInfo)localObject).jdField_f_of_type_Boolean = a().jdField_f_of_type_Boolean;
      ((SessionInfo)localObject).jdField_c_of_type_Boolean = a().jdField_c_of_type_Boolean;
      ((SessionInfo)localObject).jdField_N_of_type_Boolean = a().jdField_N_of_type_Boolean;
      ((SessionInfo)localObject).jdField_o_of_type_JavaLangString = a().jdField_o_of_type_JavaLangString;
      ((SessionInfo)localObject).jdField_c_of_type_JavaLangString = a().jdField_c_of_type_JavaLangString;
      ((SessionInfo)localObject).D = 1;
      if (a().jdField_G_of_type_Boolean)
      {
        boolean bool = this.jdField_p_of_type_Boolean;
        a(Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue(), true, 0);
        this.jdField_p_of_type_Boolean = bool;
      }
      for (this.jdField_f_of_type_Int = 2;; this.jdField_f_of_type_Int = 1)
      {
        ((SessionInfo)localObject).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
        i1 = 0;
        i2 = 0;
        while (i2 < paramArrayOfLong.length)
        {
          i3 = i1;
          if (paramArrayOfLong[i2] != 0L) {
            i3 = i1 + 1;
          }
          i2 += 1;
          i1 = i3;
        }
        a(a().jdField_c_of_type_JavaLangString, 1);
        b(214);
        c(a().jdField_c_of_type_JavaLangString, 21);
      }
      if (i1 != paramArrayOfLong.length) {
        break label481;
      }
      ((SessionInfo)localObject).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      ((SessionInfo)localObject).jdField_z_of_type_Int = -1;
      if (i5 != 1) {
        break label554;
      }
      ((SessionInfo)localObject).jdField_d_of_type_Int = 3;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      ((SessionInfo)localObject).jdField_i_of_type_Int = 3000;
      ((SessionInfo)localObject).jdField_f_of_type_Long = paramLong;
      ((SessionInfo)localObject).q = Long.toString(paramLong);
      ((SessionInfo)localObject).a("switchToMultiAudio", true);
      ((SessionInfo)localObject).E = 0;
      ((SessionInfo)localObject).jdField_u_of_type_Int = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
      ((SessionInfo)localObject).jdField_v_of_type_Int = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e();
      paramArrayOfLong = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 3))
      {
        this.jdField_h_of_type_Int = paramArrayOfLong[1];
        this.jdField_i_of_type_Int = paramArrayOfLong[2];
        this.jdField_j_of_type_Int = paramArrayOfLong[0];
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
      return;
      label481:
      ((SessionInfo)localObject).jdField_a_of_type_ArrayOfLong = new long[i1];
      i3 = 0;
      i2 = 0;
      while ((i2 < paramArrayOfLong.length) && (i3 < i1))
      {
        int i4 = i3;
        if (paramArrayOfLong[i2] != 0L)
        {
          ((SessionInfo)localObject).jdField_a_of_type_ArrayOfLong[i3] = paramArrayOfLong[i2];
          i4 = i3 + 1;
        }
        i2 += 1;
        i3 = i4;
      }
      break;
      label554:
      if (i5 == 2) {
        ((SessionInfo)localObject).jdField_d_of_type_Int = 4;
      } else if (i5 == 3) {
        ((SessionInfo)localObject).jdField_d_of_type_Int = 3;
      } else if (i5 == 4) {
        ((SessionInfo)localObject).jdField_d_of_type_Int = 3;
      }
    }
  }
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    long l1 = paramArrayOfLong[0];
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->setSpeakingUin,uin=" + l1 + "isSpeaking" + paramBoolean);
    }
    boolean bool = b(l1, paramBoolean);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), Long.valueOf(l1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    }
    Intent localIntent = new Intent("tencent.video.v2q.memberSpeaking");
    localIntent.putExtra("groupId", paramLong);
    localIntent.putExtra("uinList", paramArrayOfLong);
    localIntent.putExtra("isSpeaking", paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().sendBroadcast(localIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpOfflineMsg");
    }
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool = paramBundle.getBoolean("isRequest");
    int i1 = a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveSharpVideoCall result: " + i1 + ", buf.length: " + arrayOfByte.length);
    }
    if ((bool) && (this.jdField_a_of_type_Int == -1)) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(VideoController.CameraDataUpdataInterface paramCameraDataUpdataInterface)
  {
    this.jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface = paramCameraDataUpdataInterface;
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, int paramInt)
  {
    paramGAudioFriends.jdField_a_of_type_Int = 0;
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
      paramGAudioFriends.jdField_a_of_type_Int = 1;
      return;
    }
    paramGAudioFriends.jdField_d_of_type_Boolean = true;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApp().getApplicationContext();
      jdn localjdn = new jdn(this);
      paramVideoAppInterface.a().post(localjdn);
      b();
      q();
      if ((this.jdField_t_of_type_Int == 0) && (SmallScreenUtils.e(paramVideoAppInterface.getApp()))) {
        this.jdField_t_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a(this.jdField_a_of_type_AndroidContentContext, this);
    } while (!this.B);
    Q();
  }
  
  public void a(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut--> UserInfo = " + paramAVUserInfo.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramAVUserInfo.jdField_a_of_type_Int == 1)
      {
        if (a().a(paramAVUserInfo.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList) == null) {
          break label183;
        }
        localAVPhoneUserInfo = a().a(paramAVUserInfo.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList);
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
      localAVPhoneUserInfo.account = paramAVUserInfo.jdField_a_of_type_Long;
      localAVPhoneUserInfo.accountType = 2;
      a().a(localAVPhoneUserInfo);
      c(paramAVUserInfo.jdField_a_of_type_Long);
      break;
      if (paramInt1 == 71)
      {
        if (paramAVUserInfo.jdField_a_of_type_Int == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramAVUserInfo.jdField_a_of_type_Long;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramAVUserInfo, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  void a(AVUserInfo paramAVUserInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      Object localObject1;
      if (paramBoolean) {
        try
        {
          if (a(paramAVUserInfo.jdField_a_of_type_Long) != -1) {
            return;
          }
          localObject1 = new VideoController.GAudioFriends(this);
          ((VideoController.GAudioFriends)localObject1).jdField_a_of_type_Long = paramAVUserInfo.jdField_a_of_type_Long;
          ((VideoController.GAudioFriends)localObject1).jdField_c_of_type_Int = paramAVUserInfo.jdField_a_of_type_Int;
          ((VideoController.GAudioFriends)localObject1).jdField_d_of_type_Int = paramAVUserInfo.jdField_b_of_type_Int;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          return;
        }
        finally {}
      }
      int i1 = a(paramAVUserInfo.jdField_a_of_type_Long);
      Object localObject2 = null;
      if (i1 != -1) {
        localObject1 = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
      }
      for (;;)
      {
        a(paramAVUserInfo.jdField_a_of_type_Long, a().jdField_c_of_type_JavaUtilArrayList, 0, true);
        y();
        if ((localObject1 == null) || (((VideoController.GAudioFriends)localObject1).jdField_e_of_type_Boolean) || (!((VideoController.GAudioFriends)localObject1).jdField_g_of_type_Boolean)) {
          break;
        }
        a(0L, false, 0L);
        break;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramAVUserInfo);
          localObject1 = localObject2;
        }
      }
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
      a().ad = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    a().ad = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelNetWorkTimer[" + paramString + "]");
    }
    this.D = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    PopupDialog.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo closeVideo, emCloseReason = " + paramString + "|" + paramInt, new Throwable());
    if ((a().jdField_d_of_type_Int == 2) && (EffectBeautyTools.a())) {
      ReportController.b(null, "CliOper", "", "", "0X8008135", "0X8008135", 0, 0, a().jdField_K_of_type_Int + "", "", "", "");
    }
    if ((!p()) && (this.jdField_a_of_type_ComTencentAvSessionMgr.b())) {}
    int i1;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Jea != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jea);
          this.jdField_a_of_type_Jea = null;
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          SignalStrengthReport.a(a()).b();
        }
      } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
      if ((1 != c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (!b()))
      {
        a(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
        this.jdField_c_of_type_Boolean = true;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt);
      if ((p()) && (paramInt != 110)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    String str = a().jdField_c_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString)))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      d(paramInt);
    }
    AVLog.d(jdField_a_of_type_JavaLangString, "closeVideo:  selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", toUin = " + paramString + ", result = " + i1 + ", emCloseReason = " + paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "playRing[" + paramString + "]");
    }
    if (p()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + "Q.nearby.video_chat", 2, "not playRing");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramString + "_VideoController.playRing");
      if (!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(paramString + "_VideoController.playRing", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        AVLog.d(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_c_of_type_JavaLangString, 0);
        b(212);
        c(a().jdField_c_of_type_JavaLangString, a().jdField_z_of_type_Int);
      }
    } while (!a().R);
    AVLog.d(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
    a(a().jdField_c_of_type_JavaLangString, 0);
    b(213);
    c(a().jdField_c_of_type_JavaLangString, a().jdField_z_of_type_Int);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsgBroadcast uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", friendUin: " + paramString2 + ", selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", isReceiver = " + a().jdField_a_of_type_Boolean + ", isVideoMsg = " + paramBoolean1 + ", extraUin: " + paramString3 + ", forceUnread:" + paramBoolean2);
    }
    Intent localIntent;
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AddVideoMsg");
      localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1);
      if (localSessionInfo != null) {}
    }
    else
    {
      return;
    }
    label189:
    int i1;
    if (paramInt2 == 21) {
      if ((localSessionInfo.jdField_h_of_type_Int == 11) || (localSessionInfo.jdField_h_of_type_Int == 12))
      {
        paramInt1 = 47;
        localSessionInfo.jdField_h_of_type_Int = 0;
        i1 = 0;
        paramInt2 = paramInt1;
      }
    }
    for (;;)
    {
      boolean bool = false;
      if ((localSessionInfo.d()) && (paramInt2 == 1)) {
        bool = true;
      }
      String str;
      label456:
      float f1;
      for (;;)
      {
        if (paramBoolean2) {
          bool = false;
        }
        localIntent.putExtra("uinType", i1);
        localIntent.putExtra("msgType", paramInt2);
        localIntent.putExtra("isVideoMsg", paramBoolean1);
        localIntent.putExtra("isRead", bool);
        localIntent.putExtra("bindType", localSessionInfo.A);
        localIntent.putExtra("bindId", localSessionInfo.jdField_n_of_type_JavaLangString);
        localIntent.putExtra("MultiAVType", localSessionInfo.D);
        if (paramInt2 == 17) {
          localIntent.putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if ((i1 != 1004) && (i1 != 1000)) {
          break label645;
        }
        str = paramString3;
        if (paramInt2 == 20) {
          str = paramString1;
        }
        paramString3 = str;
        if (TextUtils.isEmpty(str)) {
          paramString3 = paramString1;
        }
        if (paramInt2 != 0)
        {
          str = paramString3;
          if (paramInt2 != 2) {}
        }
        else
        {
          str = paramString3;
          if (localSessionInfo.jdField_G_of_type_Boolean) {
            str = paramString2;
          }
        }
        localIntent.putExtra("friendUin", paramString2);
        localIntent.putExtra("senderUin", str);
        localIntent.putExtra("selfUin", paramString1);
        if (localSessionInfo.jdField_a_of_type_Boolean) {
          break label718;
        }
        paramBoolean1 = true;
        localIntent.putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label769;
        }
        if (this.jdField_b_of_type_Long <= 0L) {
          break;
        }
        f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
        if (f1 >= 1024.0F) {
          break label724;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
        label540:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getConnectedTime():" + a() + " extra:" + paramString1);
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
        return;
        paramInt1 = 48;
        break label189;
        if (localSessionInfo.f()) {
          bool = true;
        }
      }
      label645:
      if (i1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label795;
        }
      }
      for (;;)
      {
        if (localSessionInfo.jdField_a_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          str = paramString3;
          paramString3 = paramString2;
          paramString2 = str;
          break;
        }
        if (localSessionInfo.jdField_a_of_type_Boolean) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        label718:
        paramBoolean1 = false;
        break label456;
        label724:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label540;
        label769:
        if (localSessionInfo.jdField_d_of_type_Long > 0L)
        {
          paramString1 = UITools.a(a());
          break label540;
        }
        paramString1 = null;
        break label540;
        label795:
        paramString3 = paramString2;
      }
      i1 = paramInt1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    AVLog.d(jdField_a_of_type_JavaLangString, "avideo onCloseVideo fromUin = " + paramString + ", reason = " + paramInt + ", extraParam = " + paramLong);
    if (p()) {
      N();
    }
    if (((a().jdField_i_of_type_Int == 1011) || (a().jdField_i_of_type_Int == 21)) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean))
    {
      AVLog.d(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean);
      a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0);
      if ((p()) && ((paramInt == 2) || (paramInt == 3))) {
        return;
      }
      d(paramInt);
      return;
    }
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 13: 
    case 16: 
    case 17: 
    default: 
    case 0: 
      for (paramInt = 5;; paramInt = 0)
      {
        c(paramString, paramInt);
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
        if (a().jdField_d_of_type_Int != 2) {
          break label647;
        }
        ReportController.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        b(paramString, paramInt);
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
          a(a().jdField_i_of_type_Int, a().jdField_c_of_type_JavaLangString, a().jdField_h_of_type_Long, 0);
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
          if (a().jdField_d_of_type_Int == 2)
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
        if (paramLong != 6L) {
          break label782;
        }
        paramInt = 24;
        break;
        label647:
        ReportController.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      paramInt = 3;
      if (paramLong == 3L) {
        paramInt = 42;
      }
      b(paramString, paramInt);
      return;
      paramInt = 5;
      break;
      b(paramString, 25);
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
      b(paramString, 12);
      return;
      paramInt = 21;
      break;
      paramInt = 51;
      break;
      label782:
      paramInt = 2;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo onInviteReached state:" + paramInt + " # extraParam0 = " + paramLong + " # subState = " + a().jdField_c_of_type_Long);
    a().jdField_m_of_type_JavaLangString = null;
    if (a() != null)
    {
      if (0L != a().jdField_c_of_type_Long) {
        break label258;
      }
      if (0L != paramLong) {}
    }
    else
    {
      if ((a() == null) || (!a().f())) {
        break label312;
      }
    }
    label258:
    label312:
    label348:
    label764:
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
              a().jdField_c_of_type_Long = 1L;
              if (paramArrayOfByte == null) {
                break;
              }
              a().jdField_m_of_type_JavaLangString = new String(paramArrayOfByte);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :" + a().jdField_m_of_type_JavaLangString);
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(400), a().jdField_m_of_type_JavaLangString });
              break;
            }
            if (2L != paramLong) {
              break;
            }
            a().jdField_c_of_type_Long = 2L;
          } while (paramArrayOfByte == null);
          a().jdField_m_of_type_JavaLangString = new String(paramArrayOfByte);
          return;
          if (1L != a().jdField_c_of_type_Long) {
            break;
          }
          if (0L == paramLong)
          {
            a().jdField_c_of_type_Long = 0L;
            return;
          }
        } while (1L == paramLong);
        if (2L != paramLong) {
          break;
        }
        a().jdField_c_of_type_Long = 0L;
        d();
        return;
        i1 = 0x80000 & paramInt;
        if ((i1 <= 0) || (!this.jdField_o_of_type_Boolean)) {
          break label348;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :has get phone state");
      return;
      if (i1 == 0) {
        this.jdField_o_of_type_Boolean = true;
      }
      a().jdField_n_of_type_Int = 0;
      if ((0x10000 & paramInt) > 0)
      {
        i1 = 0x40000 & paramInt;
        a().jdField_l_of_type_Int = (0x20000 & paramInt);
        a().jdField_m_of_type_Int = i1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached pcOnLine:" + a().jdField_l_of_type_Int + " # phoneOnLine = " + a().jdField_m_of_type_Int);
        }
        if (((0x100000 & paramInt) > 0) && (i1 > 0))
        {
          if ((0xFFFF & paramInt & 0x1) > 0) {
            a().jdField_n_of_type_Int = 1;
          }
          if (this.jdField_a_of_type_Jea != null)
          {
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jea);
            }
            this.jdField_a_of_type_Jea = null;
          }
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
          {
            if ((a() != null) && (a().jdField_c_of_type_Long == 1L) && (!TextUtils.isEmpty(a().jdField_m_of_type_JavaLangString))) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString, a().jdField_m_of_type_JavaLangString });
            }
          }
          else if (!a().ak) {
            e();
          }
        }
        for (;;)
        {
          a().jdField_n_of_type_Boolean = true;
          return;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString });
          break;
          paramInt &= 0xFFFF;
          if ((paramInt & 0x2) > 0) {
            a().jdField_n_of_type_Int = 2;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label764;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached low 16bit value is" + paramInt);
            break;
            if ((paramInt & 0x4) > 0)
            {
              a().jdField_n_of_type_Int = 3;
              ReportController.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
            }
            else if ((paramInt & 0x8) > 0)
            {
              a().jdField_n_of_type_Int = 4;
            }
          }
        }
      }
      a().jdField_l_of_type_Int = 0;
      a().jdField_m_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pc and phone both not online");
      }
      if (this.jdField_a_of_type_Jea != null)
      {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jea);
        }
        this.jdField_a_of_type_Jea = null;
      }
      a().jdField_n_of_type_Boolean = false;
      a(a().jdField_c_of_type_JavaLangString, 0);
      b(210);
      this.jdField_g_of_type_JavaLangRunnable = new jdg(this);
    } while ((this.jdField_g_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 2000L);
  }
  
  @TargetApi(16)
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_w_of_type_Boolean = a();
    long l1 = a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processVideoRequest uinType = " + paramInt1 + ", peerUin = " + paramString2 + ", extraUin = " + paramString3 + ", onlyAudio = " + paramBoolean1 + ", isDoubleVideoMeeting = " + paramBoolean2 + ", isGameMode: " + this.jdField_w_of_type_Boolean + ", aSessionExists: " + paramBoolean3 + ",roomId = " + l1);
    }
    if ((paramBoolean1) && (!ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
    {
      a(paramString2, 0, paramBoolean2);
      c(paramString2, 0);
    }
    int i1;
    Object localObject;
    label665:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1) != null)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).Q = paramBoolean1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).a("processVideoRequest.1", 2);
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).ai = false;
          AVReport.a().jdField_o_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).Q;
        }
        i1 = 0;
        if ((!paramBoolean3) && (!VideoUtils.a())) {
          break;
        }
        localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("relationType", UITools.a(paramInt1));
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.jdField_n_of_type_Int);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label747;
        }
        l();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString)) {
          break label665;
        }
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1) != null)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString = paramString2;
          a(this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString, 0, 4);
        }
      } while (this.jdField_a_of_type_Jdu == null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jdu);
      this.jdField_a_of_type_Jdu = null;
      return;
      if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext())) {}
      for (Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), VideoInviteLock.class);; localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), VideoInviteFull.class))
      {
        int i2 = 1;
        localObject = localIntent;
        i1 = i2;
        if (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
          break;
        }
        localIntent.addFlags(262144);
        localObject = localIntent;
        i1 = i2;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      }
    } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1) == null);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).a("processVideoRequest.2", 0);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_i_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString = paramString2;
    return;
    label747:
    if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext())) {
      if ((i1 != 0) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString1 = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2131034270, 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity((Intent)localObject, paramString1.toBundle());
      }
    }
    for (;;)
    {
      l();
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity((Intent)localObject);
      continue;
      if ((this.jdField_w_of_type_Boolean) && (SmallScreenUtils.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext())))
      {
        if ((paramBoolean3) || (VideoUtils.a()))
        {
          paramString1 = new MultiIncomingCallUICtr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
          paramString1.e();
          paramString1.a((Intent)localObject);
        }
        else
        {
          paramString1 = new VideoInviteFloatBarUICtr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
          paramString1.e();
          paramString1.a((Intent)localObject);
        }
      }
      else if ((i1 != 0) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString1 = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2131034270, 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity((Intent)localObject, paramString1.toBundle());
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity((Intent)localObject);
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("cancelVideoChat, peerUin[").append(paramString).append("], reason[").append(paramInt).append("], isDoubleMetting[").append(paramBoolean).append("], mVcCtrl[");
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("cancelVideoChat");
    localObject = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().jdField_j_of_type_Long, 10, 1L);
      if ((a().jdField_c_of_type_JavaLangString == null) || (!a().jdField_c_of_type_JavaLangString.equals(paramString))) {
        break label264;
      }
      VideoNodeManager.a(a().jdField_j_of_type_Long, 38);
    }
    for (i1 = paramInt;; i1 = paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      m();
      p();
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
        break;
      }
      SmartDeviceReport.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label264:
      VideoNodeManager.a(a(paramString), 38);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new jdp(this, this, paramString, paramInt, paramBoolean, paramRunnable)).start();
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
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("sessionId", paramString);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr != null)
      {
        paramString = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString);
        if (paramString != null)
        {
          localIntent.putExtra("uinType", paramString.jdField_i_of_type_Int);
          if (paramString.jdField_i_of_type_Int != 26) {
            break label279;
          }
          localIntent.putExtra("peerUin", paramString.jdField_e_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      if ((paramInt == 3) || (paramInt == 4))
      {
        localIntent.putExtra("peerUin", paramString.q);
        localIntent.putExtra("relationType", paramString.F);
        localIntent.putExtra("relationId", paramString.jdField_f_of_type_Long);
      }
      localIntent.putExtra("extraUin", paramString.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("bindType", paramString.A);
      localIntent.putExtra("bindId", paramString.jdField_n_of_type_JavaLangString);
      localIntent.putExtra("isReceiver", paramString.jdField_a_of_type_Boolean);
      if (p()) {
        localIntent.putExtra("isNearbyVideoChat", true);
      }
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("isDouble", paramBoolean3);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      return;
      label279:
      localIntent.putExtra("peerUin", paramString.jdField_c_of_type_JavaLangString);
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
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0")))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus invalid uin");
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus fromUin: " + paramString + ", roomid: " + paramLong + ", type: " + paramInt);
    Object localObject = SessionMgr.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject);
    if (localObject != null) {
      ((SessionInfo)localObject).jdField_d_of_type_Int = paramInt;
    }
    if ((paramInt != 0) && (!TextUtils.isEmpty(a().jdField_c_of_type_JavaLangString)) && ((!a().jdField_c_of_type_JavaLangString.equals(paramString)) || (a().jdField_d_of_type_Int == 0)))
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus sendQueryRoomInfoRequest");
    }
    a(0, paramString, paramLong, paramInt);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", CharacterUtil.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    a(localNewIntent);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramLong, paramBoolean, false);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      a(paramString + "_" + paramLong, paramBoolean1, paramBoolean2);
      if (paramBoolean1) {
        break label99;
      }
    }
    label99:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      this.jdField_p_of_type_Boolean = paramBoolean2;
      paramLong = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      if ((!paramBoolean1) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        a(this.jdField_a_of_type_Long, new long[] { paramLong }, paramBoolean1);
      }
      return;
    }
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + CharacterUtil.a(paramLong) + ", uinType = " + a().jdField_i_of_type_Int);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    if (a().jdField_i_of_type_Int == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", CharacterUtil.a(paramString));
      localNewIntent.putExtra("toUin", paramLong);
      localNewIntent.putExtra("vMsg", paramArrayOfByte);
      a(localNewIntent);
      return;
      localNewIntent.putExtra("reqType", 4);
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
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  void a(String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1);
    int i1;
    String str2;
    String str1;
    if ((localSessionInfo != null) && (!localSessionInfo.ai))
    {
      i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_i_of_type_Int;
      str2 = localSessionInfo.jdField_e_of_type_JavaLangString;
      str1 = paramString2;
      if (!TextUtils.isEmpty(localSessionInfo.jdField_c_of_type_JavaLangString))
      {
        str1 = paramString2;
        if (localSessionInfo.jdField_c_of_type_JavaLangString.contains(paramString2)) {
          str1 = localSessionInfo.jdField_c_of_type_JavaLangString;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
        break label319;
      }
      int i2 = 9500;
      i1 = i2;
      paramString2 = str1;
      if (localSessionInfo.A == 1)
      {
        i1 = i2;
        paramString2 = str1;
        if (!TextUtils.isEmpty(localSessionInfo.jdField_n_of_type_JavaLangString))
        {
          i1 = 0;
          paramString2 = localSessionInfo.jdField_n_of_type_JavaLangString;
        }
      }
      if (!this.A) {
        break label316;
      }
      i1 = 0;
    }
    for (;;)
    {
      boolean bool = false;
      if (localSessionInfo.jdField_f_of_type_Int == 2) {
        bool = true;
      }
      if (VideoUtils.a(i1, localSessionInfo.A))
      {
        a(i1, paramInt, paramString2, str2);
        if (!this.jdField_e_of_type_Boolean) {
          break label246;
        }
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, paramString2, str2, 1, a().r, false, true);
      }
      for (;;)
      {
        localSessionInfo.ai = true;
        return;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str2, false);
        break;
        label246:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str2, 2, this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).r, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str2, 0, this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).r, false, true);
        }
      }
      label316:
      continue;
      label319:
      paramString2 = str1;
    }
  }
  
  void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "]");
    }
    a(paramString1, paramString2, UITools.b(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    SessionInfo localSessionInfo = null;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr != null) {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2);
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
    paramString1.putExtra("bindId", localSessionInfo.jdField_n_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", localSessionInfo.jdField_d_of_type_Int);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(VideoConstants.jdField_d_of_type_JavaLangString, localSessionInfo.jdField_d_of_type_Long);
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
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2).jdField_k_of_type_JavaLangString != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2).jdField_k_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2).jdField_l_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2).jdField_l_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2).F);
        paramString1.putExtra("relationId", this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString2).jdField_f_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label649;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        DoodleLogic.a().a.a();
        break;
        label649:
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
          a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_JavaLangString = paramString2;
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
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", VideoPackageUtils.a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().R = paramBoolean;
    if (paramBoolean) {
      DataReport.p(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad,detail is null");
      }
    }
    label186:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramLong != 1L) {
              break label186;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad");
            }
            if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) {
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
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> tinyIDList is null Or size is 0");
      }
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  void a(NewIntent paramNewIntent)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      AVLog.e(jdField_a_of_type_JavaLangString, paramNewIntent.getMessage());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  void a(boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reject3rdDoubleCall, isDoubleVideoMeeting:" + paramBoolean1 + ", uinType:" + paramInt1 + ", fromUin:" + paramString1 + ", extraUin:" + paramString2 + ", bindType: " + paramInt2 + ", bindID:" + paramString3 + ", onlyAudio:" + paramBoolean2);
    }
    String str;
    long l2;
    if (paramBoolean1)
    {
      str = SessionMgr.a(100, paramString1, new int[0]);
      SessionInfo localSessionInfo2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
      SessionInfo localSessionInfo1 = localSessionInfo2;
      if (localSessionInfo2 == null) {
        localSessionInfo1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
      }
      localSessionInfo1.jdField_i_of_type_Int = paramInt1;
      localSessionInfo1.A = paramInt2;
      localSessionInfo1.jdField_n_of_type_JavaLangString = paramString3;
      localSessionInfo1.jdField_a_of_type_Boolean = true;
      paramInt1 = localSessionInfo1.jdField_i_of_type_Int;
      if (paramBoolean2) {
        break label245;
      }
      paramBoolean2 = bool;
      a(str, paramInt1, paramBoolean2, paramString1, paramString2);
      if (!paramBoolean1) {
        break label280;
      }
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString1);
        b(3, l1);
        SessionMgr.a().c(str);
        return;
        str = SessionMgr.a(3, paramString1, new int[0]);
        break;
        label245:
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
      label280:
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString1, c(), 3);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, int... paramVarArgs)
  {
    paramVarArgs = a();
    if (paramVarArgs.jdField_g_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localQAVNotification != null) {
          localQAVNotification.a(paramVarArgs.jdField_b_of_type_JavaLangString);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("closeMainSession, sessionId[%s], SessionType[%s], peerUin[%s], state[%s], isDoubleVideoMeeting[%s], mGAudioInRoom[%s]", new Object[] { paramVarArgs.jdField_b_of_type_JavaLangString, Integer.valueOf(paramVarArgs.jdField_d_of_type_Int), paramVarArgs.jdField_c_of_type_JavaLangString, Integer.valueOf(paramVarArgs.jdField_g_of_type_Int), Boolean.valueOf(paramVarArgs.jdField_G_of_type_Boolean), Boolean.valueOf(this.jdField_e_of_type_Boolean) }));
        }
        if ((l()) || (m()))
        {
          h(true);
          return;
        }
        if ((paramVarArgs.jdField_d_of_type_Int != 3) && (paramVarArgs.jdField_d_of_type_Int != 4)) {
          break;
        }
      } while (!this.jdField_e_of_type_Boolean);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramVarArgs.q, Boolean.valueOf(true) });
      }
      if (paramVarArgs.jdField_G_of_type_Boolean)
      {
        a(this.jdField_a_of_type_Long, true, 0);
        return;
      }
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 30);
      return;
    } while ((paramVarArgs.jdField_d_of_type_Int != 1) && (paramVarArgs.jdField_d_of_type_Int != 2));
    if ((paramVarArgs.jdField_g_of_type_Int == 2) || (paramVarArgs.jdField_g_of_type_Int == 13))
    {
      if (paramVarArgs.jdField_G_of_type_Boolean)
      {
        a(paramVarArgs.jdField_c_of_type_JavaLangString, 1, true);
        long l1 = Long.valueOf(paramVarArgs.jdField_c_of_type_JavaLangString).longValue();
        b(3, l1);
        a(l1, 1);
        return;
      }
      a(paramVarArgs.jdField_c_of_type_JavaLangString, 1, false);
      a(paramVarArgs.jdField_c_of_type_JavaLangString, paramInt);
      c(paramVarArgs.jdField_c_of_type_JavaLangString, 0);
      return;
    }
    if (paramVarArgs.jdField_G_of_type_Boolean)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramVarArgs.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      a(Long.valueOf(paramVarArgs.jdField_c_of_type_JavaLangString).longValue(), true, 0);
      return;
    }
    a(paramVarArgs.jdField_c_of_type_JavaLangString, paramInt);
    c(paramVarArgs.jdField_c_of_type_JavaLangString, 0);
    b(2, true, true);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), a().jdField_c_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecordAudio=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
    if (paramInt1 == 100) {
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback != null) && (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0] != null)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    while ((paramInt1 != 3) || (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback == null) || (this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1] == null)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatRecordSdkAudioFrameCallback[1].a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
    }
    label901:
    for (;;)
    {
      return;
      if (this.C)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface != null) {
          this.jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface.a();
        }
        this.C = false;
      }
      int i2 = paramArrayOfByte.length;
      int i1;
      label359:
      Object localObject;
      int[] arrayOfInt;
      boolean bool;
      if ((this.jdField_e_of_type_Int <= 30) && (!this.jdField_g_of_type_Boolean))
      {
        i1 = 0;
        if ((i1 > 10) || (paramArrayOfByte[((int)(java.lang.Math.random() * i2))] != 0))
        {
          if (i1 < 10) {
            this.jdField_g_of_type_Boolean = true;
          }
          this.jdField_e_of_type_Int += 1;
        }
      }
      else
      {
        if ((this.jdField_e_of_type_Int == 30) && (!this.jdField_g_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "30 video frames has no image");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(1) });
        }
        if (i2 != AndroidCamera.jdField_k_of_type_Int * AndroidCamera.jdField_l_of_type_Int * 3 / 2)
        {
          i1 = AndroidCamera.jdField_k_of_type_Int;
          i3 = AndroidCamera.jdField_l_of_type_Int;
          if (i2 == 460800)
          {
            AndroidCamera.jdField_k_of_type_Int = 640;
            AndroidCamera.jdField_l_of_type_Int = 480;
          }
          if (i2 == 115200)
          {
            AndroidCamera.jdField_k_of_type_Int = 320;
            AndroidCamera.jdField_l_of_type_Int = 240;
          }
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "OnPreviewData false, expectSize[" + i1 + ", " + i3 + "], datalen[" + i2 + "], fixSize[" + AndroidCamera.jdField_k_of_type_Int + ", " + AndroidCamera.jdField_l_of_type_Int + "]");
          }
        }
        if (p()) {
          break label783;
        }
        if ((!LowlightAndDenoiseTools.a()) && (!LowlightAndDenoiseTools.b())) {
          break label729;
        }
        this.jdField_a_of_type_ArrayOfInt = a(paramArrayOfByte, (int)paramLong, 60, 0.75F);
        if ((this.jdField_l_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfInt[0] == 1))
        {
          if (!paramBoolean)
          {
            localObject = this.jdField_b_of_type_ArrayOfInt;
            localObject[1] += 1;
          }
          localObject = this.jdField_b_of_type_ArrayOfInt;
          localObject[4] += 1;
          AVLog.a(jdField_a_of_type_JavaLangString, " This is the " + this.jdField_b_of_type_ArrayOfInt[2] + " times open lowlightand the " + this.jdField_b_of_type_ArrayOfInt[4] + " times open videodenoise");
          AVLog.a(jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + this.jdField_b_of_type_ArrayOfInt[0] + ", video denoise flag = " + this.jdField_b_of_type_ArrayOfInt[3] + ", lowlight open times = " + this.jdField_b_of_type_ArrayOfInt[1] + ", denoise open times = " + this.jdField_b_of_type_ArrayOfInt[4] + ", average luma = " + this.jdField_b_of_type_ArrayOfInt[6]);
        }
        this.jdField_l_of_type_Int = this.jdField_a_of_type_ArrayOfInt[0];
        this.jdField_b_of_type_ArrayOfInt[6] = this.jdField_a_of_type_ArrayOfInt[1];
        this.jdField_b_of_type_ArrayOfInt[7] = ((int)paramLong);
        if (this.jdField_a_of_type_ArrayOfInt[0] == 0)
        {
          this.jdField_b_of_type_ArrayOfInt[0] = 0;
          this.jdField_b_of_type_ArrayOfInt[3] = 0;
          GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_b_of_type_ArrayOfInt);
        }
        if ((!q()) && (this.jdField_a_of_type_ArrayOfInt[0] != 1)) {
          break label752;
        }
        localObject = a(a());
        i1 = AndroidCamera.jdField_k_of_type_Int;
        i2 = AndroidCamera.jdField_l_of_type_Int;
        int i3 = AndroidCamera.jdField_m_of_type_Int;
        arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        if (this.jdField_a_of_type_ArrayOfInt[0] != 1) {
          break label746;
        }
        bool = true;
        label683:
        ((EffectController)localObject).a(paramArrayOfByte, i1, i2, i3, paramInt, paramLong, paramBoolean, arrayOfInt, 4, bool);
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label901;
        }
        this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
        return;
        i1 += 1;
        break;
        label729:
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        this.jdField_a_of_type_ArrayOfInt[1] = 0;
        break label359;
        label746:
        bool = false;
        break label683;
        label752:
        GraphicRenderMgr.getInstance().sendCameraFrame2Native(paramArrayOfByte, AndroidCamera.jdField_m_of_type_Int, AndroidCamera.jdField_k_of_type_Int, AndroidCamera.jdField_l_of_type_Int, paramInt, System.currentTimeMillis(), paramBoolean, this.jdField_a_of_type_ArrayOfFloat, null);
        continue;
        label783:
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController != null)
        {
          localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController;
          i1 = AndroidCamera.jdField_k_of_type_Int;
          i2 = AndroidCamera.jdField_l_of_type_Int;
          arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          if (this.jdField_a_of_type_ArrayOfInt[0] == 1) {}
          for (bool = true;; bool = false)
          {
            ((EffectController)localObject).a(paramArrayOfByte, i1, i2, 0, paramInt, paramLong, paramBoolean, arrayOfInt, 2, bool);
            this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            this.jdField_m_of_type_Boolean = paramBoolean;
            this.jdField_m_of_type_Int = paramInt;
            break;
          }
        }
        GraphicRenderMgr.getInstance().sendCameraFrame2Native(paramArrayOfByte, AndroidCamera.jdField_m_of_type_Int, AndroidCamera.jdField_k_of_type_Int, AndroidCamera.jdField_l_of_type_Int, paramInt, System.currentTimeMillis(), paramBoolean, this.jdField_a_of_type_ArrayOfFloat, null);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    VideoPackageUtils.a(paramArrayOfByte);
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null)
    {
      ReportController.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController.b(paramArrayOfByte, paramLong);
  }
  
  void a(byte[] paramArrayOfByte, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AddLightalkSig");
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("bindType", paramInt1);
      localIntent.putExtra("uinType", paramInt2);
      localIntent.putExtra("phoneNum", paramString2);
      localIntent.putExtra("sig", paramArrayOfByte);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      HexUtil.a(jdField_a_of_type_JavaLangString, paramArrayOfByte);
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
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
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "inviteNewMemJoin, uinList[" + paramArrayOfLong + "], needNotifyUI[" + paramBoolean + "], original[" + paramInt1 + "], pstnlevel[" + paramInt2 + "], mMultiInviteEntranceFlag[" + this.jdField_g_of_type_Int + "]");
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return;
    }
    if (a().jdField_y_of_type_Int == 4) {
      a().jdField_y_of_type_Int = 2;
    }
    Object localObject;
    if (this.jdField_g_of_type_Int == 1)
    {
      paramInt2 = paramArrayOfLong.length;
      localObject = new long[paramInt2 * 2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject[(paramInt1 * 2)] = 1L;
        localObject[(paramInt1 * 2 + 1)] = paramArrayOfLong[paramInt1];
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d() >= 9)
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy((long[])localObject, paramInt2, null, 0);
      }
    }
    for (;;)
    {
      v();
      if (!paramBoolean) {
        break;
      }
      paramInt1 = paramArrayOfLong.length;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(paramInt1) });
      return;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject, paramInt2, null, 0, 0, false, false, 0);
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        if (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramArrayOfLong[paramInt1]))) {
          a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramArrayOfLong[paramInt1]));
        }
        paramInt1 += 1;
      }
      continue;
      if (this.jdField_g_of_type_Int == 2)
      {
        ArrayList localArrayList1 = new ArrayList();
        if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
        {
          paramInt1 = 0;
          while (paramInt1 < paramArrayOfLong.length)
          {
            localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(paramArrayOfLong[paramInt1] + "");
            if (localObject != null)
            {
              localArrayList1.add(localObject);
              a().jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramArrayOfLong[paramInt1]));
            }
            paramInt1 += 1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "inviteNewMemJoin --> inviteByPhoneList = " + localArrayList1);
        }
        paramInt2 = localArrayList1.size();
        localObject = null;
        if (paramInt2 > 0)
        {
          localObject = new String[paramInt2 * 3];
          ArrayList localArrayList2 = new ArrayList();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            AVPhoneUserInfo localAVPhoneUserInfo = PstnUtils.a((String)localArrayList1.get(paramInt1));
            localArrayList2.add(localAVPhoneUserInfo);
            localObject[(paramInt1 * 3)] = localAVPhoneUserInfo.telInfo.nation;
            localObject[(paramInt1 * 3 + 1)] = localAVPhoneUserInfo.telInfo.prefix;
            localObject[(paramInt1 * 3 + 2)] = localAVPhoneUserInfo.telInfo.mobile;
            paramInt1 += 1;
          }
          a().a(localArrayList2);
          f();
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 0, (String[])localObject, paramInt2, 0, false, false, 0);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool1 = a(a());
    boolean bool2 = r();
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGameMode isQQPaused: " + bool3 + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isLandscape: " + bool2 + ", isScreenLocked: " + bool1);
    }
    return (!bool1) && (bool2) && (bool3) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    int i2 = -999;
    int i1 = i2;
    if (paramLong > 0L)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_q_of_type_Boolean = true;
        if (paramInt1 != 1) {
          break label128;
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
      label128:
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
  
  public boolean a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    for (;;)
    {
      int i1;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        i1 = 0;
        if (i1 >= i2) {
          break label190;
        }
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localGAudioFriends.jdField_a_of_type_Long != paramLong) {
          break label181;
        }
        localGAudioFriends.jdField_e_of_type_Boolean = paramBoolean;
        localGAudioFriends.jdField_c_of_type_Int = paramInt1;
        localGAudioFriends.jdField_d_of_type_Int = paramInt2;
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
        label181:
        i1 += 1;
        continue;
        label190:
        paramBoolean = false;
      }
      else
      {
        paramBoolean = bool;
      }
    }
  }
  
  boolean a(long paramLong, int paramInt, ArrayList paramArrayList)
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
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (paramBoolean) {
      i1 = 1;
    }
    return localQQGAudioCtrl.setMicMode(i1);
  }
  
  int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (AndroidCamera.jdField_k_of_type_Int * AndroidCamera.jdField_l_of_type_Int * 3 / 2 != paramArrayOfByte.length)
    {
      AVLog.e(jdField_a_of_type_JavaLangString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    return LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, AndroidCamera.jdField_k_of_type_Int, AndroidCamera.jdField_l_of_type_Int, 60, 0.75F);
  }
  
  public int b()
  {
    int i4 = 0;
    int i1 = 0;
    if (i4 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i4);
      if (localGAudioFriends.jdField_a_of_type_Long == CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {}
      for (;;)
      {
        i4 += 1;
        break;
        int i2 = i1;
        if (localGAudioFriends.jdField_b_of_type_Boolean) {
          i2 = i1 + 1;
        }
        int i3 = i2;
        if (localGAudioFriends.jdField_d_of_type_Boolean) {
          i3 = i2 + 1;
        }
        i1 = i3;
        if (localGAudioFriends.jdField_c_of_type_Boolean) {
          i1 = i3 + 1;
        }
      }
    }
    return i1;
  }
  
  public int b(int paramInt)
  {
    AVLog.d(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
    int i1 = -1;
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setVoiceType(paramInt);
    }
    while ((a().jdField_d_of_type_Int != 3) && (a().jdField_d_of_type_Int != 4)) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setVoiceType(paramInt);
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterDAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
    }
    return -1;
  }
  
  int b(boolean paramBoolean)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      i1 = -1;
    }
    while (!this.jdField_e_of_type_Boolean) {
      return i1;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
      a("stopOrStartGAudioTRAE_stop", false, false);
      return 0;
    }
    if (!this.jdField_p_of_type_Boolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a("stopOrStartGAudioTRAE", paramBoolean, false);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      return 0;
    }
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
    return this.jdField_e_of_type_Long;
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    if (!NetworkUtil.d(a())) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      Object localObject1 = (WindowManager)a().getSystemService("window");
      Object localObject2 = new DisplayMetrics();
      ((WindowManager)localObject1).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
      int i1 = ((DisplayMetrics)localObject2).widthPixels;
      int i2 = ((DisplayMetrics)localObject2).heightPixels;
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          int i3 = c();
          localObject1 = new VcControllerImpl(a(), String.valueOf(AppSetting.jdField_a_of_type_Int), this, this, i1, i2, i3, (String)localObject2);
          long l1 = CharacterUtil.a((String)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str1 = DeviceInfoUtil.b();
          String str2 = DeviceInfoUtil.c();
          str1 = str1 + "," + str2;
          ((VcControllerImpl)localObject1).init(a(), l1, "7.6.3", Build.MODEL, String.valueOf(AppSetting.jdField_a_of_type_Int), (String)localObject2, AppSetting.a(), DeviceInfoUtil.a(), VcSystemInfo.a(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, VcSystemInfo.c(), i3, str1, new SDKConfigInfo.Builder().a());
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = ((VcControllerImpl)localObject1);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController UnsatisfiedLinkError", localUnsatisfiedLinkError);
      }
      if (NetworkUtil.a(a())) {
        this.jdField_b_of_type_Int = 1;
      } else {
        this.jdField_b_of_type_Int = 2;
      }
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportCloseReasonBeacon,reason  = " + paramInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("closeReason", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actAvideoCloseReasonB", true, 0L, 0L, localHashMap, "", true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_f_of_type_Boolean + "], preSize[" + AndroidCamera.jdField_k_of_type_Int + ", " + AndroidCamera.jdField_l_of_type_Int + "]");
    if ((!a().jdField_f_of_type_Boolean) || (((paramInt1 < AndroidCamera.jdField_k_of_type_Int) || (paramInt2 < AndroidCamera.jdField_l_of_type_Int)) && ((AndroidCamera.jdField_k_of_type_Int <= 640) || (AndroidCamera.jdField_l_of_type_Int <= 480)))) {}
    while ((AndroidCamera.jdField_k_of_type_Int == paramInt1) && (AndroidCamera.jdField_l_of_type_Int == paramInt2)) {
      return;
    }
    AndroidCamera.jdField_k_of_type_Int = paramInt1;
    AndroidCamera.jdField_l_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, -1, false);
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (a().aq) {}
    while (a().a(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    a().a(false, false);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.uploadSharpNode(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_Node", 2, "report_node is" + paramInt);
      }
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    boolean bool;
    GraphicRenderMgr localGraphicRenderMgr;
    if ((paramInt == 4) || (paramInt == 3))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("setEncodeDecodePtr, sessionType[%s], clean[%s], isRemote[%s], isMultiEngine[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool) }));
      }
      localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      if (!bool) {
        break label229;
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (!paramBoolean2) {
          break label204;
        }
        if (!paramBoolean1) {
          break label168;
        }
        if (localGraphicRenderMgr.decoderPtrRef > 0) {
          localGraphicRenderMgr.decoderPtrRef -= 1;
        }
        if (localGraphicRenderMgr.decoderPtrRef == 0) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0);
        }
      }
    }
    label168:
    label204:
    label229:
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      do
      {
        return;
        if (((paramInt == 2) || (paramInt == 1)) && (a().jdField_G_of_type_Boolean))
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        localGraphicRenderMgr.decoderPtrRef += 1;
      } while (localGraphicRenderMgr.decoderPtrRef != 1);
      paramInt = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(paramInt);
      return;
      if (paramBoolean1) {}
      for (paramInt = i1;; paramInt = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEncodeFrameFunctionPtrFunPtr())
      {
        localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramInt);
        return;
      }
    }
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (paramInt = i2;; paramInt = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr())
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setProcessDecoderFrameFunctionptr(paramInt);
        return;
      }
    }
    if (paramBoolean1) {}
    for (paramInt = i3;; paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getEncodeFrameFunctionPtrFunPtr())
    {
      localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramInt);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->InviteUin = " + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() >= 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeeting->pending session exists, just reject.");
      }
      a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
      return;
    }
    String str = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    boolean bool1 = false;
    boolean bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    if ((TextUtils.equals(a().jdField_c_of_type_JavaLangString, String.valueOf(paramLong))) && (a().jdField_h_of_type_Int == 11))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).a("onDoubleVideoMeetingInvite.1", 2);
      c(a().jdField_c_of_type_JavaLangString, 2);
    }
    if (a().a()) {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).Q = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_f_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_i_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_c_of_type_JavaLangString = String.valueOf(paramLong);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_e_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).a("onDoubleVideoMeetingInvite.3", 2);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_G_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).r = String.valueOf(paramLong);
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "recv double video meeting when phone is not idle:from uin=" + paramLong);
      }
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.CallingDialog");
      localIntent.putExtra("isAudio", true);
      localIntent.putExtra("friendUin", String.valueOf(paramLong));
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("senderUin", paramLong);
      localIntent.putExtra("isSender", false);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a("onDoubleVideoMeetingInvite", 0, 2131230736, null, null, false, 1, false, true, 0);
      b(3, paramLong);
      a(paramLong, 1);
      this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      return;
      if ((a().g()) || (a().h()) || (a().i()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_c_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).a("onDoubleVideoMeetingInvite.2", 2);
          c(a().jdField_c_of_type_JavaLangString, 2);
        }
        else if ((a().g()) || (a().h()))
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
        }
        if (bool2)
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_z_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isScreenLocked: " + bool2 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
    }
    if ((this.B) && (this.jdField_z_of_type_Int == 0) && (!bool2) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jdj(this, str, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(str, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      a().Z = true;
      d(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      a().jdField_I_of_type_Int = paramInt2;
      d(paramInt1, paramLong, paramInt2);
      return;
    }
    c(paramInt1, paramLong, paramInt2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if ((!TextUtils.isEmpty(a().jdField_c_of_type_JavaLangString)) && ((!a().jdField_c_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (a().jdField_d_of_type_Int == 0)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendQueryRoomInfoRequestFromBroadcast sendQueryRoomInfoRequest");
      c(paramLong1, paramLong2);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean == a().V) {
      return;
    }
    long l1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin();
    a().V = paramBoolean;
    if (((paramLong != l1) || (!paramBoolean)) && (!this.jdField_y_of_type_Boolean))
    {
      l1 = this.jdField_a_of_type_Long;
      if (paramBoolean) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      a("onGAudioRoomMicModeChanged", l1, bool, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoOfflineMsg");
    }
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      paramBundle = paramBundle.getByteArray("buffer");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        q();
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_q_of_type_Int, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((a().jdField_d_of_type_Int > 0) && (a().jdField_d_of_type_Int <= 2) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
      if (a().f()) {}
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
    AVLog.d(jdField_a_of_type_JavaLangString, "avideo onCloseVideo fromUin = " + paramString + ", type = " + paramInt);
    String str = SessionMgr.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str)) {}
    for (SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str); localSessionInfo == null; localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str))
    {
      AVLog.e(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = SessionMgr.a(100, paramString, new int[0]);
    }
    if ((p()) && (paramString != null) && (!paramString.equals(localSessionInfo.jdField_c_of_type_JavaLangString)))
    {
      AVLog.d(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + localSessionInfo.jdField_c_of_type_JavaLangString);
      return;
    }
    p();
    if ((localSessionInfo.jdField_c_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(str, paramString, 3);
      label206:
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).d()) {
        break label344;
      }
      localSessionInfo.jdField_z_of_type_Int = paramInt;
      if ((localSessionInfo.d()) && (paramInt == localSessionInfo.jdField_d_of_type_Int)) {
        localSessionInfo.jdField_d_of_type_Long = 0L;
      }
      localSessionInfo.a("onCloseVideo.1", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
      c(localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_z_of_type_Int);
    }
    label431:
    for (;;)
    {
      label304:
      if ((this.jdField_a_of_type_Jea != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jea);
        return;
        a(str, paramString, paramInt);
        break label206;
        label344:
        if (localSessionInfo.c())
        {
          localSessionInfo.jdField_z_of_type_Int = paramInt;
          localSessionInfo.jdField_d_of_type_Long = 0L;
          int i2;
          switch (paramInt)
          {
          default: 
            i2 = 2131230740;
            i1 = 0;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a("onCloseVideo.2", i2, i1, this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
            localSessionInfo.a("onCloseVideo.3", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
            break label304;
            ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230739;
            break label431;
            if (l()) {
              break;
            }
            if (a().jdField_c_of_type_Long != 2L)
            {
              ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230739;
              break label431;
            }
            i2 = 2131230740;
            i1 = 1;
            break label431;
            a("onCloseVideo.1", 2131230740, 1, this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
            localSessionInfo.a("onCloseVideo.2", 6);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
            return;
            if (l()) {
              break;
            }
            ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230739;
            break label431;
            i2 = 2131230739;
            i1 = 0;
            break label431;
          }
        }
        if (!localSessionInfo.g())
        {
          localSessionInfo.jdField_z_of_type_Int = paramInt;
          if (localSessionInfo.d()) {
            localSessionInfo.jdField_d_of_type_Long = 0L;
          }
          if (((paramInt == 2) || (paramInt == 24)) && (localSessionInfo.jdField_i_of_type_Int == 1011))
          {
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label951;
            }
            a(6, 0, null);
            label825:
            QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label968;
            }
            if (localQAVNotification != null) {
              localQAVNotification.a();
            }
          }
          label851:
          localSessionInfo.a("onCloseVideo.4", 6);
          if ((!p()) && (!PhoneStatusTools.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label975;
          }
          a(a().jdField_c_of_type_JavaLangString, 0);
          b(209);
          c(a().jdField_c_of_type_JavaLangString, a().jdField_z_of_type_Int);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
      break label304;
      break;
      label951:
      a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 0, null);
      break label825;
      label968:
      g();
      break label851;
      label975:
      a("onCloseVideo.3", 2131230740, 1, this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
      QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramInt == 1) && (1L == a().jdField_c_of_type_Long))
    {
      a().jdField_c_of_type_Long = 0L;
      d();
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = SessionMgr.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str)) {}
      for (SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str); localSessionInfo == null; localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession fail to find session");
        AVLog.a("VideoNodeManager", "-->VideoController closeSession fail to find session !!!!!");
        VideoNodeManager.a(0L, 33);
        VideoNodeManager.b(0L);
        return;
        str = SessionMgr.a(100, paramString, new int[0]);
      }
      VideoNodeManager.a(localSessionInfo.jdField_j_of_type_Long, 16, 0L);
      VideoNodeManager.a(localSessionInfo.jdField_j_of_type_Long, 33);
      VideoNodeManager.b(localSessionInfo.jdField_j_of_type_Long);
      Object localObject = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (localSessionInfo.jdField_a_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((VideoNodeReporter)localObject).a(localSessionInfo.jdField_j_of_type_Long, i2, i1 + 500);
        ((VideoNodeReporter)localObject).a("NoCrash");
        ((VideoNodeReporter)localObject).a(localSessionInfo.jdField_j_of_type_Long, 29, 1L);
        ((VideoNodeReporter)localObject).a(36, 1L);
        ((VideoNodeReporter)localObject).b(localSessionInfo.jdField_j_of_type_Long);
        localSessionInfo.jdField_j_of_type_Long = -1L;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + localSessionInfo.a() + "], sessionInfo.peerUin[" + localSessionInfo.jdField_c_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + localSessionInfo.Q + "], sessionInfo.SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], mNetTrafficAllSize[" + this.jdField_b_of_type_Long + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_Jdu != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jdu);
          this.jdField_a_of_type_Jdu = null;
        }
        if ((!localSessionInfo.a()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((localSessionInfo.jdField_d_of_type_Int == 2) && (!localSessionInfo.jdField_G_of_type_Boolean) && (localSessionInfo.jdField_g_of_type_Int >= 4) && (localSessionInfo.jdField_d_of_type_Long > 0L))
      {
        i2 = AVNotifyCenter.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        AVLog.d(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + localSessionInfo.jdField_d_of_type_Long + " | " + localSessionInfo.jdField_g_of_type_Int + " | " + localSessionInfo.jdField_s_of_type_Boolean);
        if ((localSessionInfo.jdField_s_of_type_Boolean) || (i2 > 0)) {
          ReportController.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_w_of_type_Boolean) && (a() > 0L))
      {
        if (localSessionInfo.jdField_d_of_type_Int == 1) {
          ReportController.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", UITools.a(a()), "");
        }
      }
      else
      {
        label682:
        localSessionInfo.jdField_c_of_type_Long = 0L;
        localSessionInfo.jdField_m_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(localSessionInfo.jdField_c_of_type_JavaLangString))
        {
          localObject = paramString;
          if (localSessionInfo.jdField_c_of_type_JavaLangString.contains(paramString)) {
            localObject = localSessionInfo.jdField_c_of_type_JavaLangString;
          }
        }
        if ((localSessionInfo.g()) || (localSessionInfo.h())) {
          localSessionInfo.jdField_z_of_type_Int = i1;
        }
        if ((localSessionInfo.c()) || ((localSessionInfo.d()) && (i1 == localSessionInfo.jdField_z_of_type_Int))) {
          localSessionInfo.jdField_d_of_type_Long = 0L;
        }
        if ((localSessionInfo.ak) && (this.jdField_e_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          this.jdField_e_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1475;
        }
        paramBoolean = false;
        if (localSessionInfo.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(localSessionInfo.jdField_b_of_type_JavaLangString, localSessionInfo.jdField_i_of_type_Int, paramBoolean, localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_e_of_type_JavaLangString);
        label863:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a())
        {
          m();
          p();
          x();
        }
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          DataReport.c(this, false);
          DataReport.e(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            DataReport.m(this);
          }
        }
        localSessionInfo.a("doCloseSession", 0);
        localSessionInfo.jdField_d_of_type_Int = 0;
        localSessionInfo.jdField_f_of_type_Int = 0;
        localSessionInfo.jdField_a_of_type_JavaUtilBitSet.clear();
        localSessionInfo.jdField_i_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        localSessionInfo.ax = false;
        localSessionInfo.jdField_a_of_type_ArrayOfJavaLangString = null;
        localSessionInfo.jdField_o_of_type_JavaLangString = null;
        localSessionInfo.jdField_k_of_type_Boolean = true;
        localSessionInfo.jdField_a_of_type_ComTencentAvUiJSInterfacePushData = null;
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + localSessionInfo.jdField_i_of_type_Int + " # matchStatus = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        if ((i1 != 21) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          localSessionInfo.jdField_i_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1488;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1161:
        if ((localSessionInfo.jdField_i_of_type_Int != 1011) || ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 6))) {
          break label1515;
        }
        if ((!this.jdField_f_of_type_Boolean) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 6)) {
          break label1498;
        }
        a(6, 1, null);
        label1225:
        this.jdField_a_of_type_Boolean = false;
        label1230:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 2)))
        {
          localSessionInfo.d();
          a(0, 0, null);
        }
        localSessionInfo.jdField_f_of_type_Boolean = false;
        localSessionInfo.jdField_g_of_type_Boolean = false;
        localSessionInfo.jdField_d_of_type_Long = 0L;
        localSessionInfo.b();
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1533;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      }
      for (;;)
      {
        paramString = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str);
        if (!paramBoolean) {
          break;
        }
        g();
        return;
        if (localSessionInfo.jdField_d_of_type_Int != 2) {
          break label682;
        }
        ReportController.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", UITools.a(a()), "");
        break label682;
        label1475:
        a(str, (String)localObject, i1);
        break label863;
        label1488:
        if (!this.jdField_a_of_type_Boolean) {
          break label1161;
        }
        break label1161;
        label1498:
        a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, null);
        break label1225;
        label1515:
        if (!this.jdField_f_of_type_Boolean) {
          break label1230;
        }
        a(6, 1, null);
        break label1230;
        label1533:
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, 3);
      }
    }
  }
  
  public void b(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.receiveTransferMsg(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(122), paramString });
  }
  
  public void b(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, long paramLong)
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
  
  public void b(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInvitePhoneUser --> Size = " + paramArrayList.size());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      paramArrayList = localResultRecord.jdField_a_of_type_JavaLangString;
      if (localResultRecord.jdField_a_of_type_Int == 5) {
        break label186;
      }
      paramArrayList = localResultRecord.jdField_d_of_type_JavaLangString;
    }
    label186:
    for (;;)
    {
      localArrayList.add(paramArrayList);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramArrayList) == null)) {
        break;
      }
      a().jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramArrayList))));
      break;
      paramArrayList = PstnUtils.a(localArrayList);
      a().jdField_g_of_type_JavaUtilArrayList = paramArrayList;
      a().a(paramArrayList);
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        B();
      }
      H();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_k_of_type_Boolean == paramBoolean) {}
    for (;;)
    {
      return;
      this.jdField_k_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
        {
          if ((!a().Q) && (a().jdField_f_of_type_Boolean)) {
            b(a().jdField_c_of_type_JavaLangString);
          }
          if (!a().jdField_c_of_type_Boolean) {
            a(true, a().jdField_c_of_type_JavaLangString);
          }
          b(false, a().jdField_c_of_type_JavaLangString);
        }
      }
      while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherSelfIsRing(a().jdField_c_of_type_JavaLangString, paramBoolean);
        return;
        b(true);
        continue;
        if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
        {
          if ((!a().Q) && (a().jdField_f_of_type_Boolean)) {
            c(a().jdField_c_of_type_JavaLangString);
          }
          if (!a().jdField_c_of_type_Boolean) {
            a(false, a().jdField_c_of_type_JavaLangString);
          }
          b(true, a().jdField_c_of_type_JavaLangString);
          K();
        }
        else
        {
          b(false);
          if (a().jdField_N_of_type_Boolean)
          {
            if (this.jdField_f_of_type_JavaLangRunnable == null) {
              this.jdField_f_of_type_JavaLangRunnable = new jde(this);
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 2000L);
          }
        }
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoCallData buf: " + paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      q();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_o_of_type_Int, paramArrayOfByte);
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    String str = null;
    if (paramLong == 0L) {
      a().O = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(27), str });
      return;
      if (paramLong == 1L)
      {
        a().O = true;
      }
      else if (paramLong == 100L)
      {
        a().P = false;
      }
      else if (paramLong == 101L)
      {
        a().P = true;
        if (paramArrayOfByte != null) {
          str = new String(paramArrayOfByte);
        }
      }
      else
      {
        a().O = false;
        a().P = false;
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public boolean b(Context paramContext)
  {
    if (!NetworkUtil.d(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkChatAvilable network not support!");
      }
      QQToast.a(paramContext, 2131433103, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkChatAvilable isPhoneCalling!");
      }
      paramContext = new Intent();
      paramContext.setAction("tencent.av.v2q.CheckChatAbility");
      paramContext.putExtra("reason", "phoneCalling");
      paramContext.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramContext);
      return false;
    }
    return true;
  }
  
  public boolean b(boolean paramBoolean)
  {
    AVLog.d(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
    boolean bool = false;
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      bool = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.enableLoopback(paramBoolean);
    }
    while ((a().jdField_d_of_type_Int != 3) && (a().jdField_d_of_type_Int != 4)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.enableLoopback(paramBoolean);
  }
  
  public int c()
  {
    int i1 = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i1 = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getApn: " + i1);
      }
      return i1;
      if (AppNetConnInfo.isMobileConn()) {
        switch (AppNetConnInfo.getMobileInfo())
        {
        default: 
          i1 = 100;
          break;
        case 1: 
          i1 = 3;
          break;
        case 2: 
          i1 = 9;
          break;
        case 3: 
          i1 = 11;
        }
      }
    }
  }
  
  public int c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString);
    }
    return -1;
  }
  
  public int c(boolean paramBoolean)
  {
    if ((a().f()) || (this.jdField_e_of_type_Boolean))
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
  
  public long c()
  {
    switch (a().jdField_d_of_type_Int)
    {
    default: 
      return 0L;
    }
    return a(a().jdField_c_of_type_JavaLangString);
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    if (a() == null) {
      return localArrayList;
    }
    Iterator localIterator = a().jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Long)localIterator.next());
    }
    localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if ((localGAudioFriends.jdField_c_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", a().jdField_i_of_type_Int);
      localIntent.putExtra("peerUin", a().jdField_c_of_type_JavaLangString);
      localIntent.putExtra("extraUin", a().jdField_e_of_type_JavaLangString);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void c(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDistroy, relationType[" + paramInt + "], relationId[" + paramLong + "]");
    }
    String str1 = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str1 = SessionMgr.a(100, String.valueOf(paramLong), new int[0]);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
      if ((AudioHelper.e()) || (((SessionInfo)localObject).at)) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDistroy, sessionId[" + a().jdField_b_of_type_JavaLangString + "], state[" + ((SessionInfo)localObject).jdField_g_of_type_Int + "], isAcceptingMultiAV[" + ((SessionInfo)localObject).at + "]");
      }
      if (!((SessionInfo)localObject).at) {
        break label211;
      }
    }
    label193:
    label211:
    do
    {
      do
      {
        do
        {
          do
          {
            break label193;
            break label193;
            do
            {
              return;
            } while (!QLog.isColorLevel());
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy, has no session");
            return;
            if (this.jdField_e_of_type_Long == paramLong)
            {
              this.jdField_e_of_type_Long = 0L;
              this.s = 0;
            }
            if ((paramInt != 3) || (!((SessionInfo)localObject).jdField_G_of_type_Boolean) || ((((SessionInfo)localObject).jdField_c_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((SessionInfo)localObject).jdField_c_of_type_JavaLangString).longValue()))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDistroy-->RelationId is wrong-->PeerUin = " + ((SessionInfo)localObject).jdField_c_of_type_JavaLangString + " ,relationId = " + paramLong);
          return;
          if ((!((SessionInfo)localObject).aj) && (!((SessionInfo)localObject).jdField_G_of_type_Boolean))
          {
            int i1 = 6;
            if (((SessionInfo)localObject).jdField_g_of_type_Int == 7) {
              i1 = 5;
            }
            String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
            a("onGAudioRoomDistroy", str1, UITools.b(paramInt), str2, String.valueOf(paramLong), i1, ((SessionInfo)localObject).r, false, false);
          }
          ((SessionInfo)localObject).a("onGAudioRoomDistroy", 0);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
        } while (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1));
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
          paramInt = UITools.b(paramInt);
          a(((SessionInfo)localObject).jdField_b_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
      } while (!this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1));
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    } while ((localObject == null) || (!((QAVNotification)localObject).a()));
    ((QAVNotification)localObject).a(str1);
    g();
  }
  
  void c(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaRoomSettingChanged-->relationType = " + paramInt1 + " relationUin = " + paramLong + " changedType = " + paramInt2);
    }
    if (paramInt2 == 102) {
      a().aa = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        a().aa = false;
      }
    }
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaSwitchVideoResult-->result=" + paramInt1 + "info=" + paramLong1);
    }
    if (paramInt1 == 96) {
      if (a().jdField_d_of_type_JavaUtilArrayList.size() > 0)
      {
        a().a(true, true);
        this.jdField_d_of_type_Boolean = true;
        int i1 = 0;
        if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (((VideoViewInfo)localObject).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (a(((VideoViewInfo)localObject).jdField_a_of_type_Long, ((VideoViewInfo)localObject).jdField_a_of_type_Int, a().jdField_d_of_type_JavaUtilArrayList)) {
              ((VideoViewInfo)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((VideoViewInfo)localObject).jdField_b_of_type_Boolean = false;
            }
          }
        }
        a().jdField_d_of_type_JavaUtilArrayList.clear();
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
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      }
      return;
      this.jdField_d_of_type_Boolean = false;
      a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), true, true);
      a().jdField_d_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    AVLog.c(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6009), Integer.valueOf(paramInt), paramString });
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupVideoClosed, relationId[" + paramLong + "], type[" + paramInt1 + "], avtype[" + paramInt2 + "], bKickout[" + this.jdField_z_of_type_Boolean + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    if (this.jdField_z_of_type_Boolean) {
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {
      a(1, paramLong, 83);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      this.jdField_i_of_type_JavaLangRunnable = null;
      a().a("onGroupVideoClosed", 0);
      a(1, paramLong, 17, 0, paramInt1);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    String str = paramBundle.getString("fromUin");
    boolean bool = paramBundle.getBoolean("isFriend");
    int i1 = a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoCallData: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", fromUin = " + str + ", result = " + i1 + ",isFriend:" + bool);
    }
    this.jdField_a_of_type_Int = 0;
    if ((a().jdField_i_of_type_Int == 1006) && (!a().jdField_a_of_type_Boolean) && (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      a().jdField_e_of_type_JavaLangString = str;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoCallData: CONTACT_STRANGER_FRIEND  peerUin = " + str);
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "resumeVideo SessionType :" + a().jdField_d_of_type_Int);
    }
    GraphicRenderMgr.getInstance();
    if (GraphicRenderMgr.soloaded) {}
    try
    {
      GraphicRenderMgr.getInstance().clearCameraFrames();
      if ((a().jdField_d_of_type_Int <= 0) || (a().jdField_d_of_type_Int > 2) || (!a().f())) {
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
    b(paramString, paramInt, false);
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchGroup, fromUin[" + paramString + "], flag[" + paramLong + "]");
    if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4)) {}
    while (a().jdField_c_of_type_JavaLangString.compareToIgnoreCase(paramString) != 0) {
      return;
    }
    if (!a().jdField_T_of_type_Boolean) {
      a("onSwitchGroup", 2131230735, 1, null);
    }
    a().a("onSwitchGroup", true);
    a().jdField_f_of_type_Long = 0L;
    a().jdField_h_of_type_Int = 11;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
    h();
  }
  
  public void c(ArrayList paramArrayList)
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
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoController.GAudioFriends)localIterator.next();
        if ((((VideoController.GAudioFriends)localObject).jdField_c_of_type_Int == 1) && (((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
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
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setSoundEnable: " + paramBoolean);
      }
    } while (!this.jdField_e_of_type_Boolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoAck");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      q();
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_p_of_type_Int, paramArrayOfByte);
  }
  
  public boolean c()
  {
    boolean bool2 = true;
    int i1 = a().jdField_i_of_type_Int;
    boolean bool1;
    if ((i1 == 21) || (i1 == 22) || (i1 == 26)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (a().jdField_f_of_type_Int != 1);
    String str2 = a().jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (a().jdField_i_of_type_Int == 1006)
    {
      str1 = str2;
      if (!a().jdField_a_of_type_Boolean)
      {
        str1 = str2;
        if (a().jdField_e_of_type_JavaLangString != null) {
          str1 = a().jdField_e_of_type_JavaLangString;
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
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(str1);
      i2 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(str1);
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
  
  public int d()
  {
    return c();
  }
  
  public long d()
  {
    long l1 = 0L;
    if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4)) {
      l1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomId();
    }
    return l1;
  }
  
  public ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)localIterator.next();
      if ((localAVPhoneUserInfo != null) && (localAVPhoneUserInfo.telInfo.mobile != null)) {
        localArrayList.add(localAVPhoneUserInfo.telInfo.mobile);
      }
    }
    return localArrayList;
  }
  
  public void d()
  {
    TraeHelper localTraeHelper = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    p();
    a().a("onSubState2", 4);
    a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13) });
      if (!a().jdField_c_of_type_Boolean) {
        break label160;
      }
      a(true, a().jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jds(this), 50L);
      a(a().jdField_b_of_type_JavaLangString, a().jdField_d_of_type_Int, true, true, true);
      DataReport.j(this);
      DataReport.e(this, true);
      DataReport.c(this, true);
      return;
      g();
      break;
      label160:
      a(false, a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void d(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "exitProcess start,reason = " + paramInt);
    int i1 = paramInt;
    if (paramInt < 200) {
      i1 = paramInt + 200;
    }
    AVLog.d(jdField_a_of_type_JavaLangString, "exitProcess reason = " + i1);
    if ((p()) && ((this.jdField_k_of_type_Int == 2) || (this.jdField_k_of_type_Int == 3)))
    {
      AVLog.d(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_k_of_type_Int);
      return;
    }
    if (TraeHelper.a() != null) {
      TraeHelper.a().d();
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.e(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  public void d(int paramInt, long paramLong)
  {
    AVLog.b("VideoNodeManager", "==> onCreateRoomSuc() ********************************** relationTye = " + paramInt + "  lGroupId = " + paramLong);
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder().append("onCreateRoomSuc, relationType[").append(paramInt).append("], groupId[").append(paramLong).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break;
      }
      return;
    }
    long l1;
    if (a().Q)
    {
      l1 = 1L;
      VideoNodeManager.a(13, l1);
      VideoNodeManager.a(30);
      a().jdField_K_of_type_Boolean = true;
      if (paramInt != 2) {
        break label1255;
      }
      a().jdField_a_of_type_JavaUtilArrayList.clear();
      if (!this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup) {
        break label374;
      }
      S();
      label184:
      if (((a().jdField_y_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) && (a().jdField_g_of_type_JavaUtilArrayList != null) && (a().jdField_g_of_type_JavaUtilArrayList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc send invite-->discussion , invite phone size = " + a().jdField_g_of_type_JavaUtilArrayList.size());
        }
        B();
      }
    }
    for (;;)
    {
      a("onCreateRoomSuc");
      this.jdField_e_of_type_Boolean = true;
      a().at = false;
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onCreateRoomSuc, MainSession[" + a() + "]");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong) });
      v();
      return;
      l1 = 2L;
      break;
      label374:
      localObject2 = null;
      int i1 = 0;
      localObject1 = localObject2;
      paramInt = i1;
      int i2;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null)
      {
        localObject1 = localObject2;
        paramInt = i1;
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0)
        {
          i2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
          localObject2 = new long[i2 * 2];
          i1 = 0;
          for (;;)
          {
            localObject1 = localObject2;
            paramInt = i2;
            if (i1 >= i2) {
              break;
            }
            localObject2[(i1 * 2)] = 1L;
            localObject2[(i1 * 2 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
            i1 += 1;
          }
        }
      }
      int i3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onCreateRoomSuc, multiCalledInviteType[" + a().jdField_y_of_type_Int + "], mDisableInvite[" + a().aw + "], selfBindState[" + i3 + "]");
      if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (a().jdField_g_of_type_JavaUtilArrayList != null) && ((a().jdField_y_of_type_Int == 0) || (a().jdField_y_of_type_Int == 2)))
      {
        i1 = 0;
        if (i1 < this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size())
        {
          l1 = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(l1 + "");
          if (localObject2 != null)
          {
            localObject2 = PstnUtils.a((String)localObject2);
            i2 = 0;
          }
          for (;;)
          {
            if (i2 < a().jdField_g_of_type_JavaUtilArrayList.size())
            {
              localObject3 = (AVPhoneUserInfo)a().jdField_g_of_type_JavaUtilArrayList.get(i2);
              if ((((AVPhoneUserInfo)localObject2).telInfo.mobile != null) && (((AVPhoneUserInfo)localObject3).telInfo.mobile != null) && (((AVPhoneUserInfo)localObject2).telInfo.mobile.equals(((AVPhoneUserInfo)localObject3).telInfo.mobile))) {
                a().jdField_g_of_type_JavaUtilArrayList.remove(i2);
              }
            }
            else
            {
              i1 += 1;
              break;
            }
            i2 += 1;
          }
        }
      }
      if ((a().jdField_y_of_type_Int == 0) || (i3 < 9))
      {
        if (!a().aw) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject1, paramInt, null, 0, 0, false, false, 0);
        }
        i1 = 0;
        while (i1 < paramInt)
        {
          if (!a().jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1));
          }
          i1 += 1;
        }
        break label184;
      }
      if (a().jdField_y_of_type_Int == 2)
      {
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy((long[])localObject1, paramInt, null, 0);
        break label184;
      }
      if (a().jdField_y_of_type_Int == 1)
      {
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy(null, 0, null, 0);
        break label184;
      }
      if (a().jdField_y_of_type_Int != 4) {
        break label184;
      }
      Object localObject3 = new ArrayList();
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null)
      {
        paramInt = 0;
        if (paramInt < this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size())
        {
          l1 = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(paramInt)).longValue();
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(l1 + "");
          if (localObject1 != null) {
            a().jdField_g_of_type_JavaUtilArrayList.add(PstnUtils.a((String)localObject1));
          }
          for (;;)
          {
            paramInt += 1;
            break;
            ((ArrayList)localObject3).add(Long.valueOf(l1));
            if (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(l1))) {
              a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l1));
            }
          }
        }
        i1 = ((ArrayList)localObject3).size();
        localObject1 = null;
        if (i1 > 0)
        {
          localObject2 = new long[i1 * 2];
          paramInt = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (paramInt >= i1) {
              break;
            }
            localObject2[(paramInt * 2)] = 1L;
            localObject2[(paramInt * 2 + 1)] = ((Long)((ArrayList)localObject3).get(paramInt)).longValue();
            paramInt += 1;
          }
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject1, i1, null, 0, 0, false, false, 0);
      }
      this.jdField_j_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy(null, 0, null, 0);
      break label184;
      label1255:
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 0, this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.pstnOriginal, this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.pstnLevel);
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (paramInt2 == 108)
    {
      a().ac = true;
      SessionInfo localSessionInfo = a();
      if (!h())
      {
        bool = true;
        localSessionInfo.ab = bool;
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      break;
      if (a().ac)
      {
        a().ac = false;
        if (a().ab) {
          a("onMVSpeakModeChanged_2", this.jdField_a_of_type_Long, true, false);
        } else {
          a("onMVSpeakModeChanged_3", this.jdField_a_of_type_Long, false, false);
        }
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    AVLog.d(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void d(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onSetMicBySelf uin = " + paramLong);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public void d(long paramLong, int paramInt1, int paramInt2)
  {
    AVLog.b("VideoNodeManager", "==> onEnterSuc() ********************************** relationTye = " + paramInt1 + "  lGroupId = " + paramLong);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onEnterSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], MainSession[" + a() + "]");
    long l2 = a().a();
    VideoNodeManager.a(l2, 30);
    VideoNodeManager.a(l2, 9, a().a());
    VideoNodeManager.a(l2, 12, 2L);
    long l1;
    if (a().Q)
    {
      l1 = 1L;
      VideoNodeManager.a(l2, 13, l1);
      VideoNodeManager.a(l2, 15, 2L);
      a("onEnterSuc");
      a().at = false;
      if (paramInt1 != 3) {
        break label260;
      }
      a().a("onDoubleVideoMeetingInvite.1", 14);
      a().H = true;
      a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong) });
      return;
      l1 = 2L;
      break;
      label260:
      this.jdField_e_of_type_Boolean = true;
      Object localObject = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = SessionMgr.a().a((String)localObject);
      if (localObject != null)
      {
        ((SessionInfo)localObject).U = true;
        ((SessionInfo)localObject).jdField_K_of_type_Boolean = false;
      }
      if (a().jdField_g_of_type_JavaUtilArrayList.size() > 0) {
        B();
      }
      if ((paramInt1 == 2) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        S();
      }
    }
  }
  
  public void d(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    int i1 = b(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramBundle, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoAck: result = " + i1);
    }
  }
  
  public void d(String paramString)
  {
    a().a("onAcceptedVideo", 3);
  }
  
  public void d(String paramString, int paramInt)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchTerminalSuccess fromUin = " + paramString + ", info :" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    label275:
    do
    {
      return;
      if (this.jdField_e_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        this.jdField_e_of_type_JavaLangRunnable = null;
      }
      if (a().al)
      {
        a().al = false;
        boolean bool2;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), a().jdField_c_of_type_JavaLangString, Boolean.valueOf(false) });
          bool2 = a().jdField_f_of_type_Boolean;
          if ((a().jdField_f_of_type_Int == 1) && (bool2))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchTerminalSuccess, notify local has video");
            }
            if ((-1 == this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchVideo(a().jdField_c_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchTerminalSuccess, notify local has video success");
            }
          }
          paramInt = (int)a();
          bool2 = a().jdField_g_of_type_Boolean;
          if (a().jdField_d_of_type_Boolean) {
            break label275;
          }
        }
        for (;;)
        {
          a(paramInt, bool2, bool1);
          return;
          paramString = new jcz(this);
          this.jdField_a_of_type_JavaUtilList.add(paramString);
          break;
          bool1 = false;
        }
      }
    } while (!a().ak);
    k(a().jdField_c_of_type_JavaLangString);
  }
  
  public void d(ArrayList paramArrayList)
  {
    int i2 = 0;
    boolean bool;
    int i1;
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onGAudioInviteResp, avInviteAccountList[");
      if (paramArrayList != null)
      {
        bool = true;
        localStringBuilder = localStringBuilder.append(bool).append("], size[");
        if (paramArrayList != null) {
          break label88;
        }
        i1 = 0;
        label56:
        QLog.w(str, 1, i1 + "]");
      }
    }
    else
    {
      if (paramArrayList != null) {
        break label96;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label88:
      i1 = paramArrayList.size();
      break label56;
      label96:
      if (a().jdField_a_of_type_JavaUtilArrayList != null)
      {
        i1 = i2;
        while (i1 < paramArrayList.size())
        {
          if ((((AVInviteAccount)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((AVInviteAccount)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((AVInviteAccount)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((AVInviteAccount)paramArrayList.get(i1)).jdField_a_of_type_Long));
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!a().jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(true) });
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(false) });
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvIVRPush");
    }
  }
  
  public boolean d()
  {
    int i1 = a().jdField_i_of_type_Int;
    if (i1 == 1011) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canMultiShift uinType: " + i1);
      }
    }
    int i2;
    do
    {
      do
      {
        do
        {
          return false;
          i2 = a().A;
          if (!VideoUtils.a(i1, i2)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("canMultiShift uinType:%d, bindType:%d ", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
        return false;
        if ((a().J) && (i1 == 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "canMultiShift isFriend: false");
      return false;
      i1 = c(a().jdField_c_of_type_JavaLangString);
      i2 = b(a().jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canMultiShift peerTerminalType: " + i2 + ", peerSharpVersion: " + i1);
      }
      if ((i1 >= 16) && ((i2 == 4) || (i2 == 2) || (i2 == 3))) {
        return true;
      }
    } while ((i2 != 5) || (i1 < 5437));
    return true;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long e()
  {
    long l1 = 0L;
    if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4)) {
      l1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEnterRoomTime();
    }
    return l1;
  }
  
  public void e()
  {
    if ((a().jdField_i_of_type_Int == 1011) || (a().jdField_i_of_type_Int == 21) || (p())) {}
    while (a().jdField_c_of_type_Long != 0L) {
      return;
    }
    long l1 = a().jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startReachedRing, peer colorRingId=" + l1);
    }
    String str = ColorRingManager.a(l1, 3);
    if (new File(str).exists())
    {
      TraeHelper.a().a("VideoController.startReachedRing.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_b_of_type_Boolean = true;
      int i1 = a().jdField_o_of_type_Int;
      ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    TraeHelper.a().a("VideoController.startReachedRing.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, null, -1, null);
    a().jdField_b_of_type_Boolean = true;
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void e(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteUser --> Count = " + paramInt + " , firstName = " + paramString);
    }
    if ((paramInt > 0) && (paramString != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(409), Integer.valueOf(paramInt), paramString });
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    a().jdField_G_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void e(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTerminalFail fromUin = " + paramString + ", info :" + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void e(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvitePSTNResp");
    }
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvitePSTNResp size " + paramArrayList.size());
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        Object localObject = ((AVInvitePSTNPhone)paramArrayList.get(i1)).a;
        String str1 = ((TelInfo)localObject).jdField_a_of_type_JavaLangString;
        String str2 = ((TelInfo)localObject).jdField_b_of_type_JavaLangString;
        localObject = ((TelInfo)localObject).jdField_c_of_type_JavaLangString;
        str1 = str1 + str2 + (String)localObject;
        PstnNumberManager.a(str1, 0);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvitePSTNResp insert number code= " + str1);
        i1 += 1;
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvFirstAudioData recvFirstAudio = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!a().Q) {
        break label117;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        if (-1 != this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(a().jdField_c_of_type_JavaLangString)) {
          break label109;
        }
        this.jdField_l_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean) });
      return;
      label109:
      this.jdField_l_of_type_Boolean = true;
      continue;
      label117:
      this.jdField_l_of_type_Boolean = true;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    int i1 = DoodleLogic.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().jdField_y_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public boolean e()
  {
    boolean bool = false;
    String str = a(a().jdField_d_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->info=" + str);
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      R();
      i1 = 0;
      if (i1 < a().jdField_d_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)a().jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
          a().jdField_d_of_type_JavaUtilArrayList.remove(i1);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoRecv(a().jdField_d_of_type_JavaUtilArrayList) == 0) {
          break label148;
        }
        bool = true;
      }
    }
    label148:
    do
    {
      return bool;
      i1 += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,ViewInfos=" + str);
      }
      a().jdField_d_of_type_JavaUtilArrayList.clear();
      return false;
      a().jdField_d_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=" + str);
    return false;
  }
  
  public int f()
  {
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
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
  
  void f()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 405);
    localIntent.putExtra("phoneList", a().jdField_e_of_type_JavaUtilArrayList);
    localIntent.putExtra("relationType", a().F);
    localIntent.putExtra("relationId", a().jdField_f_of_type_Long);
    localIntent.putExtra("sendUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localIntent.putExtra("MultiAVType", a().D);
    localIntent.putExtra("from", "VideoController1");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void f(int paramInt)
  {
    this.jdField_y_of_type_Int = paramInt;
  }
  
  public void f(int paramInt, String paramString)
  {
    if ((a().jdField_d_of_type_Int != 4) && (a().jdField_d_of_type_Int != 2)) {}
    while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.lockVideoMaxQP(paramInt, paramString);
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void f(String paramString, int paramInt)
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
        if (c())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "switch start frome video entry, open camera");
          }
          paramInt = 1;
        }
      }
    }
    a().jdField_e_of_type_Long = i2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSyncOtherTerminalChatStatus time:" + i2 + ", isCamreOpen:" + paramInt + ", isMicOpen:" + i3);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(34), Integer.valueOf(paramInt), Integer.valueOf(i3) });
  }
  
  public void f(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetGAudioInviteStrategy");
    }
    if (paramArrayList == null) {
      this.jdField_j_of_type_Boolean = false;
    }
    do
    {
      boolean bool;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetGAudioInviteStrategy avInviteAccountList size " + paramArrayList.size());
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject1 = new StringBuilder("onGetGAudioInviteStrategy Result:\n");
        int i1 = 0;
        int i2 = 0;
        Object localObject2;
        Object localObject3;
        if (i2 < paramArrayList.size())
        {
          localObject2 = (AVInviteAccount)paramArrayList.get(i2);
          ((StringBuilder)localObject1).append("AccountType:" + ((AVInviteAccount)localObject2).jdField_a_of_type_Int + "|Account:" + ((AVInviteAccount)localObject2).jdField_a_of_type_Long + "|InviteType:" + ((AVInviteAccount)localObject2).jdField_c_of_type_Int + "\n");
          if (((AVInviteAccount)localObject2).jdField_a_of_type_Int != 1) {}
          for (;;)
          {
            i2 += 1;
            break;
            if (((AVInviteAccount)localObject2).jdField_a_of_type_Long == CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
            {
              if (((AVInviteAccount)localObject2).jdField_c_of_type_Int == 2) {
                i1 = 1;
              }
            }
            else if (((AVInviteAccount)localObject2).jdField_c_of_type_Int == 1)
            {
              localArrayList1.add(Long.valueOf(((AVInviteAccount)localObject2).jdField_a_of_type_Long));
            }
            else if (((AVInviteAccount)localObject2).jdField_c_of_type_Int == 2)
            {
              localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(((AVInviteAccount)localObject2).jdField_a_of_type_Long + "");
              if (localObject3 != null) {
                localArrayList2.add(localObject3);
              } else {
                localArrayList1.add(Long.valueOf(((AVInviteAccount)localObject2).jdField_a_of_type_Long));
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject1).toString());
        }
        int i3 = localArrayList1.size();
        paramArrayList = null;
        if (i3 > 0)
        {
          localObject1 = new long[i3 * 2];
          i2 = 0;
          for (;;)
          {
            paramArrayList = (ArrayList)localObject1;
            if (i2 >= i3) {
              break;
            }
            localObject1[(i2 * 2)] = 1L;
            localObject1[(i2 * 2 + 1)] = ((Long)localArrayList1.get(i2)).longValue();
            i2 += 1;
          }
        }
        int i4 = localArrayList2.size();
        localObject1 = null;
        if (i4 > 0)
        {
          localObject1 = new String[i4 * 3];
          localObject2 = new ArrayList();
          i2 = 0;
          while (i2 < i4)
          {
            localObject3 = PstnUtils.a((String)localArrayList2.get(i2));
            ((ArrayList)localObject2).add(localObject3);
            localObject1[(i2 * 3)] = ((AVPhoneUserInfo)localObject3).telInfo.nation;
            localObject1[(i2 * 3 + 1)] = ((AVPhoneUserInfo)localObject3).telInfo.prefix;
            localObject1[(i2 * 3 + 2)] = ((AVPhoneUserInfo)localObject3).telInfo.mobile;
            i2 += 1;
          }
          a().a((ArrayList)localObject2);
          f();
        }
        if ((this.jdField_j_of_type_Boolean) && (i1 != 0)) {}
        for (bool = true;; bool = false)
        {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(paramArrayList, i3, (String[])localObject1, i4, 0, false, bool, 0);
          this.jdField_j_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetGAudioInviteStrategy invite qqAccount size:" + i3 + ",phoneAccount size:" + i4 + ",callMySelf:" + bool);
          }
          i1 = 0;
          while (i1 < localArrayList1.size())
          {
            if (!a().jdField_a_of_type_JavaUtilArrayList.contains(localArrayList1.get(i1))) {
              a().jdField_a_of_type_JavaUtilArrayList.add(localArrayList1.get(i1));
            }
            i1 += 1;
          }
        }
      } while (!bool);
      a().jdField_x_of_type_Int = 1;
      a().jdField_M_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(705), Boolean.valueOf(true) });
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv() != 0)
      {
        if (a().jdField_c_of_type_JavaUtilArrayList.size() == 0) {
          a().a(false, true);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    }
    return false;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
  }
  
  public void g()
  {
    int i2 = 3;
    label152:
    label169:
    label330:
    label731:
    for (;;)
    {
      Object localObject2;
      label117:
      Object localObject3;
      Object localObject4;
      try
      {
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((SessionInfo)localObject2).jdField_a_of_type_Boolean) {
          break label330;
        }
        if (((SessionInfo)localObject2).d())
        {
          if ((((SessionInfo)localObject2).jdField_d_of_type_Int == 1) || (((SessionInfo)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((SessionInfo)localObject2).Q) && (!((SessionInfo)localObject2).jdField_G_of_type_Boolean))
            {
              i1 = 56;
              if ((((SessionInfo)localObject2).jdField_i_of_type_Int != 1011) && (!l())) {
                break label450;
              }
              i1 = ((SessionInfo)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label731;
              }
              if (((SessionInfo)localObject2).F != 7) {
                break label764;
              }
              i1 = i2;
              if (!m()) {
                break label368;
              }
              localObject3 = ((SessionInfo)localObject2).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_m_of_type_JavaLangString;
              if ((localObject3 == null) || (!((String)localObject3).equals("1"))) {
                break label769;
              }
              i1 = 1;
              if (h() > 0) {
                break label780;
              }
              if (i1 == 0) {
                break label774;
              }
              i1 = 58;
              break;
              localQAVNotification.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, "", null, null, i1, ((SessionInfo)localObject2).jdField_i_of_type_Int, 3);
              w();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((SessionInfo)localObject2).q);
          localObject4 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
          localObject2 = ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localQAVNotification.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jcx(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
          break label740;
        }
      }
      finally {}
      i1 = 47;
      break label737;
      if (((SessionInfo)localObject2).f())
      {
        if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
          break label749;
        }
        i1 = 47;
        break label746;
      }
      if (((SessionInfo)localObject2).jdField_d_of_type_Int != 1) {
        break label758;
      }
      i1 = 46;
      break label755;
      label368:
      if (((SessionInfo)localObject2).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 4)
      {
        i2 = 52;
        if (this.jdField_f_of_type_Boolean)
        {
          i2 = 60;
          x();
        }
        localObject1.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, "", null, null, i2, ((SessionInfo)localObject2).jdField_i_of_type_Int, i1);
      }
      else
      {
        localObject1.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, "", null, null, 51, ((SessionInfo)localObject2).jdField_i_of_type_Int, i1);
        x();
        continue;
        if ((((SessionInfo)localObject2).jdField_d_of_type_Int == 3) || (((SessionInfo)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((SessionInfo)localObject2).jdField_G_of_type_Boolean)
          {
            localObject3 = ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, null, true, true);
            localObject1.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, ((SessionInfo)localObject2).q, 48, 0, ((SessionInfo)localObject2).jdField_d_of_type_Int);
          }
          else
          {
            localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a().jdField_i_of_type_Int, a().q, null);
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_i_of_type_Int, ((SessionInfo)localObject2).q, null, true, true);
            if (localObject4 != null) {
              localObject1.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, ((SessionInfo)localObject2).q, 44, ((SessionInfo)localObject2).jdField_i_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_Int);
            } else {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jcy(this), 1000L);
            }
          }
        }
        else
        {
          if (((SessionInfo)localObject2).jdField_d_of_type_JavaLangString == null) {
            ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(((SessionInfo)localObject2).jdField_i_of_type_Int, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString);
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).jdField_i_of_type_Int, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString, true, true);
          localObject1.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((SessionInfo)localObject2).jdField_i_of_type_Int, ((SessionInfo)localObject2).jdField_d_of_type_Int);
        }
      }
    }
    for (;;)
    {
      label450:
      break label169;
      for (;;)
      {
        label737:
        break;
        label740:
        i1 = 42;
      }
      for (;;)
      {
        label746:
        break;
        label749:
        i1 = 42;
      }
      for (;;)
      {
        label755:
        break;
        label758:
        i1 = 41;
      }
      label764:
      i1 = 1;
      break label117;
      label769:
      i1 = 0;
      break label152;
      label774:
      i1 = 53;
    }
    label780:
    if (i1 != 0) {}
    for (int i1 = 59;; i1 = 54) {
      break;
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void g(String paramString, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetNetIPAndPort(paramString, paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
      }
      SharedPreUtils.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(VideoConstants.h, paramString).commit();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "SetNetIPAndPort UnsatisfiedLinkError");
    }
  }
  
  void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyChangeDoubleVideoMeeting2MultiVideo");
    }
    long l1 = Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue();
    int i1 = a().jdField_d_of_type_Int;
    long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      VideoViewInfo localVideoViewInfo1 = new VideoViewInfo();
      VideoViewInfo localVideoViewInfo2 = new VideoViewInfo();
      localVideoViewInfo1.jdField_a_of_type_Long = l1;
      localVideoViewInfo1.jdField_a_of_type_Int = 1;
      localVideoViewInfo2.jdField_a_of_type_Long = l1;
      localVideoViewInfo2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo2);
      localArrayList.add(localVideoViewInfo1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (a().jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      }
    }
    for (;;)
    {
      a(l1, true, 0);
      a().jdField_d_of_type_Int = i1;
      a().jdField_G_of_type_Boolean = false;
      a().H = false;
      a().jdField_I_of_type_Boolean = true;
      this.jdField_p_of_type_Boolean = bool;
      if (paramBoolean)
      {
        i();
        a().jdField_h_of_type_Int = 11;
        a().a("notifyChangeDoubleVideoMeeting2MultiVideo", true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
      }
      return;
      if (a().a(l2, 1) != -1) {
        a().a(true, false);
      }
    }
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int h()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  void h()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null)
    {
      this.jdField_c_of_type_JavaLangRunnable = new jda(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_c_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 20000L);
      }
    }
  }
  
  public void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void h(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_b_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_f_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      SessionInfo localSessionInfo = a();
      if (paramBoolean)
      {
        a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (localSessionInfo != null)
        {
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          localSessionInfo.d();
          localSessionInfo.e();
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
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_f_of_type_Long), Boolean.valueOf(paramBoolean) });
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
  
  public boolean h()
  {
    return this.jdField_p_of_type_Boolean;
  }
  
  public int i()
  {
    if ((a().f()) || (this.jdField_e_of_type_Boolean)) {
      return 0;
    }
    return 255;
  }
  
  void i()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null) {
      this.jdField_d_of_type_JavaLangRunnable = new jdb(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 5000L);
    }
  }
  
  public void i(int paramInt)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDetectAudioDataIssue, issueType[" + this.jdField_d_of_type_Int + "->" + paramInt + "]");
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt) });
  }
  
  public void i(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public void i(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_x_of_type_Boolean = paramBoolean;
  }
  
  public boolean i()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    for (;;)
    {
      int i1;
      boolean bool1;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        long l2 = System.currentTimeMillis();
        i1 = 0;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          bool1 = bool2;
          if (localGAudioFriends.jdField_g_of_type_Boolean) {
            if ((localGAudioFriends.jdField_d_of_type_Long >= 2000L) && (localGAudioFriends.jdField_d_of_type_Long < this.jdField_c_of_type_Long))
            {
              l1 = localGAudioFriends.jdField_d_of_type_Long;
              bool1 = bool2;
              if (l2 - localGAudioFriends.jdField_c_of_type_Long > l1)
              {
                localGAudioFriends.jdField_g_of_type_Boolean = false;
                localGAudioFriends.jdField_c_of_type_Long = l2;
                bool2 = true;
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + localGAudioFriends.jdField_a_of_type_Long + ",isSuspectNoisy = " + localGAudioFriends.jdField_g_of_type_Boolean);
                  bool1 = bool2;
                }
              }
            }
            else
            {
              if (this.jdField_c_of_type_Long < 2000L) {
                break label234;
              }
              l1 = this.jdField_c_of_type_Long;
              continue;
            }
          }
        }
        else
        {
          return bool2;
        }
      }
      i1 += 1;
      bool2 = bool1;
      continue;
      label234:
      long l1 = 2000L;
    }
  }
  
  public int j()
  {
    return this.jdField_x_of_type_Int;
  }
  
  void j()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.jdField_e_of_type_JavaLangRunnable = new jdc(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_e_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 15000L);
      }
    }
  }
  
  public void j(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(49), "", Integer.valueOf(paramInt) });
  }
  
  public void j(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void j(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.upgradeInvite");
    localIntent.putExtra("peerUin", paramString);
    localIntent.putExtra("type", paramInt);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setSelectMemberActivityIsResume selectMemberActivityIsResume = " + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_t_of_type_Int += 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setSelectMemberActivityIsResume mSelectMemberActivityIsResume = " + this.jdField_t_of_type_Int);
      }
      return;
      this.jdField_t_of_type_Int -= 1;
      if (this.jdField_t_of_type_Int < 0) {
        this.jdField_t_of_type_Int = 0;
      }
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    for (;;)
    {
      int i2;
      int i1;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
        i1 = 0;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (!localGAudioFriends.jdField_g_of_type_Boolean) {
            break label148;
          }
          if (l1 == localGAudioFriends.jdField_a_of_type_Long) {
            a("setSuspectNoisyUserMicOff", this.jdField_a_of_type_Long, false, true);
          } else {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(localGAudioFriends.jdField_a_of_type_Long, true);
          }
        }
      }
      if (i1 != i2) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      label148:
      i1 += 1;
    }
  }
  
  public int k()
  {
    return this.jdField_y_of_type_Int;
  }
  
  void k()
  {
    GraphicRenderMgr.getInstance().decoderPtrRef = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0);
    }
  }
  
  public void k(String paramString)
  {
    int i1 = 11;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onChannelReady: fromUin = " + paramString);
    }
    VideoNodeManager.a(30);
    VideoNodeManager.a(9, a().a());
    if (a().jdField_c_of_type_JavaLangString != null) {
      VideoNodeManager.a(11, Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue());
    }
    if ((this.jdField_a_of_type_Jea != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jea);
      this.jdField_a_of_type_Jea = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      SignalStrengthReport.a(a()).a();
    }
    if (1L == a().jdField_c_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("onChannelReady.1");
      if ((a().Q) && (a().jdField_a_of_type_Boolean) && (!l())) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      a(true, a().jdField_c_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("onChannelReady.2");
    Object localObject;
    if (a().jdField_i_of_type_Int != 1011)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    }
    p();
    a().a("onChannelReady", 4);
    a().jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    if ((a().jdField_a_of_type_Boolean) && (!l()))
    {
      if (a().Q) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
    }
    else
    {
      label305:
      if ((a().jdField_d_of_type_Int == 1) && (a().jdField_i_of_type_Int == 1011))
      {
        a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 5;
        a(a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, null);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        localObject = (VideoNodeReporter)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!a().jdField_a_of_type_Boolean) {
          break label640;
        }
        label386:
        ((VideoNodeReporter)localObject).a(a().jdField_j_of_type_Long, i1, 1L);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
          break label645;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13) });
        if (l()) {
          a("onChannelReady", 2131230735, 1, null);
        }
      }
      label448:
      if (!a().jdField_c_of_type_Boolean) {
        break label652;
      }
      a(true, a().jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jdr(this), 50L);
      }
      a(a().jdField_b_of_type_JavaLangString, a().jdField_d_of_type_Int, true, true, true);
      DataReport.j(this);
      DataReport.e(this, true);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      DataReport.c(this, true);
      long l1 = f();
      localObject = SharedPreUtils.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      ((SharedPreferences)localObject).edit().putLong("qav_roomid", l1).commit();
      l1 = c(paramString);
      ((SharedPreferences)localObject).edit().putLong(VideoConstants.jdField_g_of_type_JavaLangString, l1).commit();
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a()) {
        break label305;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      break label305;
      label640:
      i1 = 4;
      break label386;
      label645:
      g();
      break label448;
      label652:
      a(false, a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = jdField_v_of_type_Int;; i1 = jdField_w_of_type_Int)
    {
      this.jdField_x_of_type_Int = i1;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "setLoadPTuSo, bloadSuc[" + paramBoolean + "]");
      return;
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("goOnstage, startVideoSend[%s]", new Object[] { Integer.valueOf(i1) }));
        }
        if (i1 != 0) {
          break label154;
        }
      }
    }
    label154:
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
  
  @SuppressLint({"NewApi"})
  void l()
  {
    if (Build.VERSION.SDK_INT <= 7) {
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new jdd(this);
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
  
  public void l(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseVideo fromUin = " + paramString + ", remoteHasVideo = " + a().jdField_g_of_type_Boolean + ", isOnlyAudio = " + a().Q + ", isSupportSharpVideo = " + VcSystemInfo.b() + ", getGLVersion = " + Utils.a(BaseApplication.getContext()));
    }
    if ((!VcSystemInfo.b()) || (Utils.a(BaseApplication.getContext()) == 1)) {
      a().jdField_g_of_type_Boolean = false;
    }
    while ((a().jdField_d_of_type_Int != 2) || (!a().jdField_g_of_type_Boolean)) {
      return;
    }
    a().jdField_g_of_type_Boolean = false;
    if (!a().jdField_f_of_type_Boolean)
    {
      a().Q = true;
      a().jdField_d_of_type_Int = 1;
      c(a().jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    DataReport.o(this);
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int < 6);
  }
  
  @SuppressLint({"NewApi"})
  void m()
  {
    if (Build.VERSION.SDK_INT <= 7) {}
    while (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo fromUin = " + paramString + ", remoteHasVideo = " + a().jdField_g_of_type_Boolean + ", isOnlyAudio = " + a().Q + ", isSupportSharpVideo = " + VcSystemInfo.b() + ", getGLVersion = " + Utils.a(BaseApplication.getContext()));
    }
    if ((a().jdField_f_of_type_Int == 1) && (!c())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (a().jdField_g_of_type_Boolean);
      a().jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16) });
      DataReport.n(this);
    } while (a().jdField_d_of_type_Int != 1);
    a().jdField_d_of_type_Int = 2;
    a().Q = false;
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
  
  void n()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.ReceiveRequest");
        localIntent.putExtra("revVideoRequest", true);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  public void n(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseAudio fromUin = " + paramString + ", remoteMute = " + a().jdField_d_of_type_Boolean);
    }
    if (!a().jdField_d_of_type_Boolean)
    {
      a().jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(17) });
    }
  }
  
  public boolean n()
  {
    return this.jdField_x_of_type_Boolean;
  }
  
  void o()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
  }
  
  public void o(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeAudio fromUin = " + paramString + ", remoteMute = " + a().jdField_d_of_type_Boolean + "|" + this.jdField_b_of_type_Boolean);
    }
    if ((this.jdField_b_of_type_Boolean) && (a().jdField_d_of_type_Boolean))
    {
      a().jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(18) });
    }
  }
  
  public boolean o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getSelectMemberActivityIsResume mSelectMemberActivityIsResume = " + this.jdField_t_of_type_Int);
    }
    return this.jdField_t_of_type_Int > 0;
  }
  
  void p()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void p(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
  }
  
  public boolean p()
  {
    if ((a() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    while ((a().jdField_i_of_type_Int != 10003) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean)) {
      return false;
    }
    return true;
  }
  
  public void q()
  {
    if ((!VcSystemInfo.c()) || (!VcSystemInfo.d())) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
        {
          d(1014);
          AVLog.e(jdField_a_of_type_JavaLangString, "mGAudioCtrl == null");
          return;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
        long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentAvVideoCallGAClientLogReport = new GAClientLogReport();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1);
        int i1 = c();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "initGAudioCtrl-->can not init QQGAudioCtrl");
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      d(1014);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      localUnsatisfiedLinkError.printStackTrace();
      d(1014);
    }
  }
  
  public void q(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    a(paramString, 0);
    b(206);
    c(paramString, 7);
  }
  
  public boolean q()
  {
    SessionInfo localSessionInfo = a();
    if ((localSessionInfo.jdField_d_of_type_Int == 2) || (localSessionInfo.jdField_d_of_type_Int == 4)) {}
    for (int i1 = 1; (this.jdField_b_of_type_ComTencentAvOpenglEffectsEffectController != null) && ((!localSessionInfo.jdField_a_of_type_JavaUtilBitSet.isEmpty()) || (localSessionInfo.jdField_K_of_type_Int != 0) || (localSessionInfo.az)) && (i1 != 0); i1 = 0) {
      return true;
    }
    return false;
  }
  
  public void r()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 50);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public void r(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTermianl fromUin = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    a().al = true;
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(307) });
  }
  
  public void s(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    a(paramString, 0);
    b(207);
    c(paramString, 7);
  }
  
  public void t()
  {
    if (!this.jdField_e_of_type_Boolean) {
      a().a("clearGAudioState", 0);
    }
  }
  
  public void t(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  public void u()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (l1 == ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long)) {
        a().a("setGAudioState.1", 9);
      }
    }
    else
    {
      return;
    }
    a().a("setGAudioState.2", 10);
  }
  
  public void u(String paramString)
  {
    SessionInfo localSessionInfo = a();
    if (p())
    {
      AVLog.d(jdField_a_of_type_JavaLangString + "Q.nearby.video_chat", String.format("onNeedShowPeerVideo, fromUin[%s], peerUin[%s]", new Object[] { paramString, localSessionInfo.jdField_c_of_type_JavaLangString }));
      if (TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, paramString)) {
        break label136;
      }
    }
    for (;;)
    {
      return;
      AVLog.d(jdField_a_of_type_JavaLangString, String.format("onNeedShowPeerVideo, fromUin[%s], peerUin[%s], mXiaoweiDevice[%s]", new Object[] { paramString, localSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(this.jdField_u_of_type_Boolean) }));
      if ((TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, paramString)) || (TextUtils.equals(localSessionInfo.jdField_e_of_type_JavaLangString, paramString)) || (this.jdField_u_of_type_Boolean))
      {
        label136:
        if ((a().jdField_f_of_type_Int == 1) && (!c()))
        {
          AVLog.d(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
          return;
        }
        if (a().jdField_d_of_type_Int == 1) {
          c(2);
        }
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, remoteHasVideo[" + localSessionInfo.jdField_g_of_type_Boolean + "->true]");
        if (!a().jdField_g_of_type_Boolean)
        {
          a().jdField_g_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16) });
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
          DataReport.n(this);
          if (a().jdField_d_of_type_Int == 1)
          {
            a().jdField_d_of_type_Int = 2;
            a().Q = false;
          }
        }
        while (!TextUtils.equals(localSessionInfo.jdField_c_of_type_JavaLangString, paramString))
        {
          GraphicRenderMgr.getInstance().onUinChanged(localSessionInfo.jdField_c_of_type_JavaLangString, paramString);
          return;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
        }
      }
    }
  }
  
  void v()
  {
    if ((a().n()) && (a().F == 2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
    {
      if (this.jdField_a_of_type_Jdw == null) {
        this.jdField_a_of_type_Jdw = new jdw(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jdw);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jdw, this.jdField_h_of_type_Int * 1000);
    }
  }
  
  public void v(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public void w()
  {
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void w(String paramString)
  {
    a().ao = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    y(paramString);
  }
  
  public void x()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
  
  void x(String paramString)
  {
    if (this.jdField_a_of_type_Jea != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jea);
    }
    this.jdField_a_of_type_Jea = new jea(this, paramString);
    if (this.jdField_a_of_type_Jea != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jea, 6000L);
    }
  }
  
  public void y()
  {
    int i1;
    if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      if (g() == 4) {
        break label312;
      }
      i1 = a().a();
      if (i1 != -1) {
        break label71;
      }
      ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label71:
    VideoViewInfo localVideoViewInfo1;
    do
    {
      for (;;)
      {
        return;
        localVideoViewInfo1 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        localVideoViewInfo1.jdField_a_of_type_Boolean = true;
        if (localVideoViewInfo1.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
          break;
        }
        if (i1 != 0)
        {
          localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          localVideoViewInfo2.jdField_a_of_type_Boolean = false;
          a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
          a().jdField_c_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
        }
        if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1)
        {
          i1 = 0;
          while (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
          {
            if (((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
              ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
            }
            i1 += 1;
          }
        }
      }
    } while (i1 == 0);
    VideoViewInfo localVideoViewInfo2 = (VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0);
    localVideoViewInfo2.jdField_a_of_type_Boolean = false;
    a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
    a().jdField_c_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
    return;
    label312:
    ((VideoViewInfo)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void y(String paramString)
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
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopVideoSend();
        return;
        if ((a().F == 1) && (a().D == 10)) {
          ReportController.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void z(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */