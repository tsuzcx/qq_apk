package com.tencent.av;

import absy;
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
import anvx;
import bdla;
import bgzw;
import bheg;
import bhfy;
import bhgd;
import bhhr;
import bhml;
import bhyk;
import bkxc;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.compat.InviteUIChecker;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.random.RandomController;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import lbd;
import lbi;
import lbv;
import lby;
import lbz;
import lcc;
import lcf;
import lch;
import lck;
import lcl;
import lcm;
import lcn;
import lco;
import lcp;
import lcq;
import lcr;
import lcs;
import lcu;
import lcv;
import lcz;
import lda;
import ldc;
import ldd;
import lde;
import leu;
import lfe;
import lff;
import lfg;
import lfm;
import lfs;
import lfx;
import lii;
import lik;
import ljk;
import lkf;
import lkm;
import llc;
import llk;
import lll;
import llm;
import lln;
import llq;
import lls;
import llv;
import llw;
import lny;
import loa;
import lob;
import lph;
import lsq;
import lvy;
import lzr;
import mbf;
import mfa;
import mjw;
import mli;
import mow;
import mqh;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mrr;
import mrt;
import mry;
import msa;
import mtf;
import mtg;
import mtj;
import mtr;
import mtt;
import mtx;
import mur;
import mut;
import muy;
import mvk;
import mxd;
import nad;
import nbr;
import nbs;
import nbv;
import ncl;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  implements lfs, llk, lln, loa
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
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  VideoController.AnyChatReqTimeoutRunnable jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
  VideoController.StartAudioSendRunnable jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
  VideoController.StartRingRunnable jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
  public VideoAppInterface a;
  private InviteUIChecker jdField_a_of_type_ComTencentAvCompatInviteUIChecker;
  public VcControllerImpl a;
  QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  private ScreenShareCtrl jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl;
  private WatchTogetherMediaPlayCtrl jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
  Object jdField_a_of_type_JavaLangObject = new Object();
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoController.1(this);
  ArrayList<lcu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  public lbv a;
  public final lby a;
  lbz jdField_a_of_type_Lbz = lbz.a();
  private volatile lcc jdField_a_of_type_Lcc;
  public final lcf a;
  lcv jdField_a_of_type_Lcv = new lcs(this);
  public lkm a;
  private lph jdField_a_of_type_Lph;
  private mjw jdField_a_of_type_Mjw;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public mtf a;
  mtg jdField_a_of_type_Mtg;
  public muy a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  boolean jdField_a_of_type_Boolean = true;
  private mow[] jdField_a_of_type_ArrayOfMow;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoController.2(this);
  private ArrayList<lcu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public lcv b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  public Runnable c;
  private final ArrayList<lcu> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  lcv jdField_c_of_type_Lcv = new lcl(this);
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  public long d;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  long jdField_e_of_type_Long = 0L;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  private String jdField_e_of_type_JavaLangString = "";
  public boolean e;
  public int f;
  long jdField_f_of_type_Long = 0L;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  public boolean f;
  int jdField_g_of_type_Int = 0;
  public long g;
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
  Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.32(this);
  boolean jdField_k_of_type_Boolean = false;
  private Runnable jdField_l_of_type_JavaLangRunnable = new VideoController.31(this);
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int = jdField_j_of_type_Int;
  private Runnable jdField_m_of_type_JavaLangRunnable;
  public boolean m;
  private int n;
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
  public boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoController";
    jdField_f_of_type_JavaLangString = "com.tencent.av.count";
    jdField_b_of_type_JavaLangString = "WifiQQCall";
    jdField_c_of_type_JavaLangString = "WifiRandom";
    jdField_d_of_type_JavaLangString = "WifiGuild";
    jdField_j_of_type_Int = -1;
    jdField_k_of_type_Int = 1;
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Lcf = new lcf(this);
    this.jdField_c_of_type_Long = 6000L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_b_of_type_Lcv = new lck(this);
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_h_of_type_JavaLangRunnable = null;
    this.jdField_q_of_type_Int = 1;
    this.jdField_h_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_a_of_type_Lby = new lby(this);
    if (!mrr.b()) {}
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
      this.jdField_a_of_type_Lkm = new lkm();
    }
  }
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new lcr(this, a(), 3);
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
  
  private void L()
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
      lbd.f(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void M()
  {
    Object localObject = a();
    int i4;
    int i2;
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
    {
      int i3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
      long l1 = ((lfe)localObject).jdField_h_of_type_Long;
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
  
  private void N()
  {
    if (this.jdField_m_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    }
    this.jdField_m_of_type_JavaLangRunnable = null;
  }
  
  private void O()
  {
    if ((this.jdField_g_of_type_Long != -1L) && (System.currentTimeMillis() - this.jdField_g_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldc.class);
    localNewIntent.putExtra("reqType", 20);
    localNewIntent.putExtra("vMsg", localReqEcho.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkNetStatus -->sendEcho");
    }
    this.jdField_a_of_type_Lby.a(localNewIntent);
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
  
  private lfe a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = lbz.a(3, paramString, new int[0]);
      localObject2 = lbz.a().c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = lbz.a(100, paramString, new int[0]);
        localObject1 = lbz.a().c((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = lbz.a().b(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = lbz.a(4, paramString, new int[0]);
        localObject1 = lbz.a().c((String)localObject1);
      }
    }
  }
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_Lbz.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramAVUserInfo.account;
    long l2 = mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = lbz.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt != 3) {
        break label1685;
      }
      paramVarArgs = lbz.a(100, String.valueOf(paramLong1), new int[0]);
    }
    label648:
    label1685:
    for (;;)
    {
      if (paramInt == 1) {}
      for (??? = a();; ??? = lbz.a().c(paramVarArgs))
      {
        if ((??? != null) && (!TextUtils.isEmpty(((lfe)???).jdField_c_of_type_JavaLangString))) {
          break label175;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, illegal session, sessionId[" + paramVarArgs + "]");
        return;
        bool1 = false;
        break;
      }
      label175:
      long l3 = AudioHelper.b();
      if (AudioHelper.f()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_b_of_type_Int + "], relationType[" + paramInt + "], UserInfo[" + paramAVUserInfo + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_l_of_type_Boolean + "], switchToGAudioMode[" + ((lfe)???).G + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((lfe)???).jdField_V_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        bool2 = ((lfe)???).a();
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.33(this, bool2));
        }
        if (((this.jdField_b_of_type_Int == 1) && (((lfe)???).D == 10)) || (this.jdField_b_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label538;
          }
        }
      }
      label538:
      for (boolean bool2 = false;; bool2 = true)
      {
        ((lfe)???).jdField_ad_of_type_Boolean = bool2;
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
        if (i() != 1) {
          break label1082;
        }
        if (!bool1) {
          break label1070;
        }
        paramVarArgs.jdField_a_of_type_Lff.jdField_b_of_type_Int = 4;
        label599:
        if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
          this.jdField_a_of_type_Muy.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        a(paramVarArgs.jdField_a_of_type_Lff.jdField_b_of_type_Int, 3, null);
        ??? = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((??? != null) && (((mtt)???).a())) {
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
            paramVarArgs.af = false;
          }
        }
        else
        {
          label744:
          if ((paramVarArgs.jdField_h_of_type_Long != l1) && (l1 != l2)) {
            mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
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
            paramAVUserInfo = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            s();
            if (paramAVUserInfo.a()) {
              paramAVUserInfo.a(paramVarArgs.jdField_c_of_type_JavaLangString);
            }
          }
          if (!paramVarArgs.ap) {
            break;
          }
          a(l3, paramLong1, false, 2);
          return;
          label1070:
          paramVarArgs.jdField_a_of_type_Lff.jdField_b_of_type_Int = 1;
          break label599;
          label1082:
          paramVarArgs.jdField_a_of_type_Lff.jdField_b_of_type_Int = 5;
          break label599;
          label1094:
          if (i() == 1) {
            paramVarArgs.jdField_a_of_type_Lff.jdField_b_of_type_Int = 4;
          }
          if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) || (!m())) {
            break label648;
          }
          this.jdField_a_of_type_Muy.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
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
            if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (((lcu)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
            {
              i1 = 1;
              if (i1 != 0)
              {
                paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
                paramVarArgs.af = true;
                ??? = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                if ((??? != null) && (((mtt)???).a()))
                {
                  s();
                  b();
                }
              }
              mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
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
          f(true);
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
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      label185:
      if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size()) {
        if (((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong2) {}
      }
    }
    for (int i1 = ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;; i1 = 1)
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
    long l1 = mrr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {}
    for (Object localObject = lbz.a(100, String.valueOf(paramLong1), new int[0]);; localObject = lbz.a(paramInt1, String.valueOf(paramLong1), new int[0]))
    {
      localObject = this.jdField_a_of_type_Lbz.c((String)localObject);
      if (localObject != null) {
        ((lfe)localObject).b(paramLong2, paramBoolean1, paramBoolean2);
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
    lcu locallcu = a(String.valueOf(paramLong1));
    if (locallcu == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
      }
    }
    lob locallob;
    do
    {
      do
      {
        return;
        locallcu.jdField_b_of_type_Boolean = paramBoolean;
      } while ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1));
      if (!paramBoolean) {
        break;
      }
      locallob = new lob();
      locallob.jdField_a_of_type_Long = paramLong1;
      locallob.jdField_a_of_type_Int = 1;
    } while (a().a(paramLong1, locallob.jdField_a_of_type_Int) != -1);
    locallob.jdField_b_of_type_Long = paramLong2;
    if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
      locallob.jdField_b_of_type_Long = 5L;
    }
    if (!a().v())
    {
      locallob.jdField_a_of_type_Boolean = true;
      if ((h() == 4) || (paramInt == 3)) {
        break label320;
      }
      if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) != -1) {
        break label311;
      }
      locallob.jdField_c_of_type_Boolean = true;
      label236:
      if (locallcu.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        break label338;
      }
      locallob.jdField_b_of_type_Boolean = true;
      locallob.jdField_d_of_type_Boolean = true;
      locallob.jdField_c_of_type_Boolean = true;
      if (a().v()) {
        break label329;
      }
    }
    label311:
    label320:
    label329:
    for (locallob.jdField_a_of_type_Boolean = true;; locallob.jdField_a_of_type_Boolean = false)
    {
      a().a(locallob);
      return;
      locallob.jdField_a_of_type_Boolean = false;
      break;
      locallob.jdField_c_of_type_Boolean = false;
      break label236;
      locallob.jdField_c_of_type_Boolean = true;
      break label236;
    }
    label338:
    locallob.jdField_b_of_type_Boolean = false;
    a().a(locallob);
    return;
    if (paramInt == 2) {
      a(paramLong1, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    for (;;)
    {
      t();
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
      lob locallob1 = new lob();
      if (paramBoolean2) {
        ((lcu)???).jdField_b_of_type_Int = 2;
      }
      for (;;)
      {
        locallob1.jdField_a_of_type_Long = paramLong;
        locallob1.jdField_a_of_type_Int = 2;
        locallob1.jdField_a_of_type_Boolean = true;
        locallob1.jdField_b_of_type_Boolean = false;
        long l1;
        lob locallob3;
        if (paramInt1 != 0)
        {
          l1 = 4L;
          locallob1.jdField_b_of_type_Long = l1;
          if (a().a(paramLong, locallob1.jdField_a_of_type_Int) != -1) {
            break;
          }
          if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
          {
            ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = false;
            if (h() != 4)
            {
              paramInt1 = a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue());
              if (paramInt1 != -1) {
                ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_c_of_type_Boolean = false;
              }
            }
          }
          locallob1.jdField_c_of_type_Boolean = true;
          if (a().jdField_c_of_type_JavaUtilArrayList.size() <= 1) {
            break label489;
          }
          locallob3 = (lob)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          a().jdField_c_of_type_JavaUtilArrayList.set(0, locallob1);
        }
        synchronized (a().jdField_d_of_type_JavaUtilArrayList)
        {
          a().jdField_d_of_type_JavaUtilArrayList.set(0, locallob1);
          a().a(locallob3);
          return;
          ((lcu)???).jdField_b_of_type_Int = 1;
          continue;
          l1 = 5L;
        }
      }
      label489:
      a().a(0, locallob2);
      return;
    }
    ((lcu)???).jdField_b_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    t();
  }
  
  private void a(Intent paramIntent)
  {
    lkm locallkm = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (locallkm != null) {
      locallkm.a(paramIntent);
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
    lkm locallkm = a();
    lde.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772178, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
      if (locallkm != null) {
        locallkm.a(paramIntent);
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
  
  private void a(ArrayList<lob> paramArrayList, int paramInt)
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
              lob locallob = (lob)paramArrayList.get(paramInt);
              paramArrayList.set(paramInt, paramArrayList.get(i1));
              paramArrayList.set(i1, locallob);
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
    lcu locallcu = a(String.valueOf(paramLong));
    if (locallcu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    locallcu.jdField_a_of_type_Boolean = paramBoolean;
    locallcu.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  private void b(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    if (this.jdField_m_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    }
    this.jdField_m_of_type_JavaLangRunnable = new VideoController.38(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_m_of_type_JavaLangRunnable, 1000L);
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
    lfe locallfe;
    do
    {
      return false;
      locallfe = lbz.a().a();
    } while ((locallfe == null) || (locallfe.jdField_d_of_type_JavaLangString == null) || (!paramString.equals(locallfe.jdField_d_of_type_JavaLangString)));
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
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onProcessExit();
    }
  }
  
  public void A(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setupDeviceInfos(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAndroidPath(paramString);
    }
  }
  
  public void B()
  {
    long l1 = (System.currentTimeMillis() - this.jdField_e_of_type_Long) / 1000L;
    bdla.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    bdla.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void C()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_Lbv == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Lbv.jdField_a_of_type_JavaLangString)
    {
      bdla.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
      this.jdField_f_of_type_Long = 0L;
      return;
    }
  }
  
  public void D()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "playRecordVoice, seq[" + l1 + "]");
    }
    a(l1, 2131230739, 1, null);
  }
  
  public void E()
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
    this.jdField_a_of_type_Muy.b(l1);
    this.jdField_a_of_type_Muy.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230738, null, 1, null);
  }
  
  void F()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.sdk.onRequestVideo");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void G()
  {
    switch (NetworkUtil.getSystemNetwork(null))
    {
    default: 
      i(0);
      return;
    case 0: 
      i(3);
      return;
    }
    O();
  }
  
  public void H()
  {
    lfe locallfe = a();
    long l1 = AudioHelper.b();
    String str;
    int i1;
    if ((locallfe.l()) || (locallfe.m()) || (locallfe.jdField_g_of_type_Int == 9) || (locallfe.n()))
    {
      lzr.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = locallfe.jdField_c_of_type_JavaLangString;
      i1 = locallfe.jdField_d_of_type_Int;
      if (locallfe.jdField_g_of_type_Int == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i1, false, bool, locallfe.x());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reNotifyChatInfo2QQ, sessionInfo[" + locallfe + "]");
      return;
    }
  }
  
  public void I()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      lfm.a();
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl.h();
    }
    this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl = null;
  }
  
  public void J()
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
    lbd.f(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
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
    lbd.e("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().D);
    AudioHelper.b("startGAudioChat ");
    e(false);
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
    localObject1 = lbz.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = lbz.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l1;
    int i2;
    int i1;
    if (!this.jdField_a_of_type_Lbz.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_Lbz.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((lfe)localObject2).F = paramInt1;
        ((lfe)localObject2).D = paramInt2;
        localObject1 = localObject2;
      }
      this.jdField_m_of_type_Boolean = false;
      l1 = mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      if ((paramInt1 != 7) && (paramInt1 != 9)) {
        break label602;
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
      if ((((lfe)localObject1).J) && (((lfe)localObject1).aF)) {
        paramInt2 = 5;
      }
      for (;;)
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_j_of_type_Boolean);
        }
        L();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().b(), a().jdField_P_of_type_Int, a().jdField_O_of_type_Int);
        if (this.jdField_j_of_type_JavaLangRunnable == null) {
          this.jdField_j_of_type_JavaLangRunnable = new VideoController.22(this, paramInt1, paramLong);
        }
        this.jdField_r_of_type_Boolean = true;
        ((lfe)localObject1).a("startGAudioChat.2", 8);
        ((lfe)localObject1).jdField_g_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
        g();
        a(((lfe)localObject1).jdField_c_of_type_JavaLangString, 3, false, false, false);
        return 0;
        localObject1 = this.jdField_a_of_type_Lbz.c((String)localObject1);
        break;
        label602:
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
            break label774;
          }
          ((lfe)localObject1).jdField_g_of_type_Long = paramLong;
          ((lfe)localObject1).F = paramInt1;
          ((lfe)localObject1).D = paramInt2;
          ((lfe)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
          ((lfe)localObject1).jdField_j_of_type_Int = 0;
          ((lfe)localObject1).e("startGAudioChat", true);
          i2 = 1;
          i1 = paramInt2;
          paramInt2 = i2;
          break label372;
        }
        return -1;
        if (((lfe)localObject1).b()) {
          paramInt2 = 3;
        }
      }
      label774:
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
          lcu locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallcu != null) && (locallcu.jdField_a_of_type_Long == paramLong)) {
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
    k(false);
    e(false);
    this.jdField_m_of_type_Boolean = false;
    for (;;)
    {
      int i2;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        a().a("acceptGAudioChat", 8);
        a().jdField_g_of_type_Long = paramLong2;
        a().ah = true;
        a().ar = true;
        paramLong1 = mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
          if (AudioHelper.f()) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "acceptGAudioChat, MainSession[" + a() + "]");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i2, i1, paramLong2, paramArrayOfLong, c(), paramLong1, a().jdField_O_of_type_Int);
          if (this.jdField_j_of_type_JavaLangRunnable == null) {
            this.jdField_j_of_type_JavaLangRunnable = new VideoController.23(this, paramInt, paramLong2);
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
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
    if ((localObject != null) && (1 == ((lll)localObject).a(mrr.a(paramString), false, false))) {
      mrr.a("0X800B62B", 0, 0, "", "", "", "");
    }
    localObject = a(paramInt2, paramString);
    if (localObject == null) {
      localObject = a();
    }
    for (;;)
    {
      k(false);
      if ((((lfe)localObject).jdField_j_of_type_Int == 1011) || (((lfe)localObject).jdField_j_of_type_Int == 21)) {
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
          ((lfe)localObject).a("acceptRequest", 3);
          i();
        }
        this.jdField_a_of_type_Lby.a();
        ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
        lii.a(37);
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
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
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
      this.jdField_a_of_type_Lby.d();
      i1 = -1;
      l1 = 0L;
      if (paramString1.ai)
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
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      lii.a(28);
      lii.a(11, str);
      lii.a(12, 1L);
      if (!paramString1.S) {
        break label1030;
      }
      l2 = 1L;
      label620:
      lii.a(13, l2);
      lii.a(15, 1L);
      L();
      if ((paramString1.jdField_j_of_type_Int != 1011) && (paramString1.jdField_j_of_type_Int != 21)) {
        break label1044;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      paramString1.S = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label1038;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label748:
      lvy.a().o = paramString1.S;
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
          break label1447;
        }
      }
    }
    label1030:
    label1038:
    label1044:
    label1447:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      for (;;)
      {
        a(paramString1.jdField_c_of_type_JavaLangString, paramInt1, false, false, true);
        paramString1.jdField_o_of_type_Int = -1;
        this.jdField_k_of_type_Boolean = false;
        a(paramLong, paramString1.jdField_d_of_type_JavaLangString);
        b();
        paramString1.ag = false;
        a(str, 2, paramString1.jdField_a_of_type_Long);
        a(str, 1, 0L);
        a("deviceMemory", lii.c() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.a(a()));
        if (this.jdField_a_of_type_Lcc != null) {
          this.jdField_a_of_type_Lcc.b();
        }
        this.jdField_a_of_type_Lcc = new lcc(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
        return i1;
        this.w = true;
        break;
        l2 = 2L;
        break label620;
        i1 = 0;
        break label748;
        if (paramInt3 == 9500)
        {
          paramInt4 = 4200;
          try
          {
            l1 = mry.a(str);
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
          paramString10 = lbi.a(paramString10);
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
        break label748;
      }
      if (1 != paramInt1) {
        break label748;
      }
      paramString1.S = false;
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      break label748;
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
    while (!this.jdField_e_of_type_Boolean) {
      return i1;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
      paramString = paramString + "_stopOrStartGAudioTRAE_stop";
      this.z = this.jdField_l_of_type_Boolean;
      a(paramString, false, false);
      b(paramString, true);
      g(paramString, 1);
      return 0;
    }
    paramString = paramString + "_stopOrStartGAudioTRAE";
    if (!this.z)
    {
      paramBoolean = true;
      a(paramString, paramBoolean, false);
      b(paramString, this.z);
      if (!this.z) {
        break label164;
      }
    }
    label164:
    for (i1 = i2;; i1 = 0)
    {
      g(paramString, i1);
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
  
  public int a(lfe paramlfe, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramlfe, paramString);
    }
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
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
    lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallda != null) {
      locallda.c();
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
  
  public long a(long paramLong)
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).longValue();
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("getMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
    return l1;
  }
  
  public long a(String paramString)
  {
    long l1 = 0L;
    lfe locallfe = lbz.a().a(paramString);
    if ((locallfe != null) && (locallfe.b() != 0L)) {
      l1 = locallfe.b();
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
    } while (locallfe == null);
    locallfe.d(l2);
    return l2;
  }
  
  public long a(lfe paramlfe)
  {
    if (paramlfe == null) {
      return 0L;
    }
    long l1 = paramlfe.b();
    switch (paramlfe.jdField_d_of_type_Int)
    {
    default: 
      return l1;
    }
    return a(paramlfe.jdField_d_of_type_JavaLangString);
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
    return bheg.a(paramBitmap, paramInt1, paramInt1, paramInt2);
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
      lcu locallcu;
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
          } while (a().jdField_a_of_type_Lff.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return a().jdField_a_of_type_Lff.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (a().jdField_a_of_type_Lff.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return a().jdField_a_of_type_Lff.jdField_b_of_type_AndroidGraphicsBitmap;
        if (a().jdField_a_of_type_Lff.jdField_a_of_type_Int != 3) {
          break;
        }
        locallcu = a(paramString);
      } while ((locallcu == null) || (locallcu.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + locallcu.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return locallcu.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((a().jdField_a_of_type_Lff.jdField_a_of_type_Int != 1) || (a().jdField_a_of_type_Lff.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return a().jdField_a_of_type_Lff.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_a_of_type_Lbz.b());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_Lbz.b()))
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
  
  public VideoAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
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
  
  public WatchTogetherMediaPlayCtrl a()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl == null) && (nad.a())) {
      this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl = new WatchTogetherMediaPlayCtrl(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
  }
  
  public Pair<Integer, ArrayList<lcu>> a()
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
        lcu locallcu = (lcu)((Iterator)localObject4).next();
        locallcu.jdField_h_of_type_Boolean = true;
        localArrayList2.add(locallcu);
        localHashSet.add(Long.valueOf(locallcu.jdField_a_of_type_Long));
      }
    }
    int i1 = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (lcu)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((lcu)localObject4).jdField_a_of_type_Long)))
      {
        ((lcu)localObject4).jdField_h_of_type_Boolean = false;
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
  
  public String a(ArrayList<lob> paramArrayList)
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
  
  public ArrayList<lcu> a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    lcu locallcu;
    while (localIterator.hasNext())
    {
      locallcu = (lcu)localIterator.next();
      localArrayList.add(locallcu);
      localHashSet.add(Long.valueOf(locallcu.jdField_a_of_type_Long));
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      locallcu = (lcu)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(locallcu.jdField_a_of_type_Long)))
      {
        locallcu.jdField_h_of_type_Boolean = false;
        localArrayList.add(locallcu);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<lcu> a(int paramInt, ArrayList<lcu> paramArrayList)
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
        localObject2 = (lcu)paramArrayList.get(i2);
        if (((lcu)localObject2).jdField_a_of_type_Long == l2) {
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
      localObject2 = (lcu)paramArrayList.get(i2);
      if (((lcu)localObject2).jdField_a_of_type_Long == l2) {
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
      long l3 = ((lcu)localArrayList1.get(i2)).jdField_a_of_type_Long;
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
      Collections.sort((List)localObject2, new lcn(this));
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
      l2 = ((lcu)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
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
      Collections.sort(localArrayList2, new lco(this));
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
      lcu locallcu;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 >= i2) {
          break label152;
        }
        locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (locallcu == null) {
          break label158;
        }
        if (locallcu.jdField_a_of_type_Long == paramLong1)
        {
          if (!locallcu.jdField_e_of_type_Boolean)
          {
            locallcu.jdField_g_of_type_Boolean = paramBoolean;
            locallcu.jdField_b_of_type_Long = l1;
            locallcu.jdField_c_of_type_Long = paramLong2;
          }
        }
        else
        {
          if (!locallcu.jdField_g_of_type_Boolean) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(locallcu.jdField_a_of_type_Long));
        }
      }
      if (locallcu.jdField_g_of_type_Boolean)
      {
        locallcu.jdField_g_of_type_Boolean = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i1 += 1;
      }
    }
  }
  
  public lcu a(String paramString)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          lcu locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallcu == null) || (locallcu.jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = locallcu;
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
  
  public lfe a()
  {
    return this.jdField_a_of_type_Lbz.a();
  }
  
  public lkm a()
  {
    return this.jdField_a_of_type_Lkm;
  }
  
  public lll a()
  {
    lll locallll = null;
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      locallll = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getJniSimpleInfo();
    }
    return locallll;
  }
  
  public lph a(Context arg1)
  {
    if (!lph.b()) {
      return null;
    }
    if ((this.jdField_a_of_type_Lph == null) && (??? != null)) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Lph == null)
      {
        this.jdField_a_of_type_Lph = new lph(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        this.jdField_a_of_type_Lph.c();
      }
      this.jdField_a_of_type_Lcf.a(this.jdField_a_of_type_Lph);
      return this.jdField_a_of_type_Lph;
    }
  }
  
  @TargetApi(21)
  public mjw a()
  {
    if (this.jdField_a_of_type_Mjw == null) {
      this.jdField_a_of_type_Mjw = new mjw();
    }
    return this.jdField_a_of_type_Mjw;
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public nbv a()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
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
  
  public void a(int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    boolean bool = ljk.a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_j_of_type_Boolean + "], preSize[" + ljk.jdField_a_of_type_Int + ", " + ljk.jdField_b_of_type_Int + "], seq[" + l1 + "], forbiddenReopenCamera[" + bool + "]");
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
    } while ((ljk.jdField_a_of_type_Int == i2) && (ljk.jdField_b_of_type_Int == i1));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(i2), Integer.valueOf(i1), Long.valueOf(l1) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Long = paramInt3;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.26(this, paramInt1, paramInt2, paramInt3));
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
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
      if (((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
      {
        i3 = ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
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
        t();
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
              a((lcu)localObject, paramInt1);
              i1 = a().a(paramLong1, 0);
            }
            for (((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;; ((lob)localObject).jdField_a_of_type_Int = paramInt1)
            {
              i1 = 1;
              break;
              localObject = (lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
              lob locallob = new lob();
              locallob.jdField_a_of_type_Long = ((lob)localObject).jdField_a_of_type_Long;
              locallob.jdField_a_of_type_Int = ((lob)localObject).jdField_a_of_type_Int;
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(locallob);
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
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setRandomChatStatus: " + paramInt1 + ", chatType" + paramInt2 + " ,sessionName: " + paramString);
    }
    Object localObject = a();
    if (localObject != null) {
      ((lfe)localObject).jdField_a_of_type_Lff.jdField_a_of_type_Int = paramInt2;
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
      ((Intent)localObject).putExtra("guild_group_id", a().jdField_a_of_type_Lfg.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", i());
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_Lfg.jdField_a_of_type_JavaLangString);
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
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize dataTransferred: dirction = " + paramInt + ", size = " + paramLong);
      }
      Intent localIntent = new Intent("tencent.video.v2q.VideoFlowSize");
      localIntent.putExtra("direction", paramInt);
      localIntent.putExtra("size", paramLong);
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
    //   2: invokestatic 676	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 443	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 18
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 663	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 634	lbz:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 17
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +2069 -> 2097
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 663	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 634	lbz:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 17
    //   45: aload_0
    //   46: getfield 116	com/tencent/av/VideoController:jdField_a_of_type_Lbz	Llbz;
    //   49: aload 17
    //   51: invokevirtual 637	lbz:c	(Ljava/lang/String;)Llfe;
    //   54: astore 19
    //   56: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 20
    //   67: new 378	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 2198
    //   77: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 688
    //   87: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2200
    //   97: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2202
    //   108: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 17
    //   113: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 522
    //   119: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2204
    //   130: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 21
    //   135: aload 18
    //   137: ifnull +47 -> 184
    //   140: iconst_1
    //   141: istore 16
    //   143: aload 20
    //   145: iconst_1
    //   146: aload 21
    //   148: iload 16
    //   150: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2206
    //   156: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 19
    //   161: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 548
    //   167: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 550	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 18
    //   178: ifnonnull +12 -> 190
    //   181: aload_0
    //   182: monitorexit
    //   183: return
    //   184: iconst_0
    //   185: istore 16
    //   187: goto -44 -> 143
    //   190: aload 19
    //   192: ifnull -11 -> 181
    //   195: getstatic 292	android/os/Build$VERSION:SDK_INT	I
    //   198: bipush 21
    //   200: if_icmplt +44 -> 244
    //   203: aload_0
    //   204: getfield 2067	com/tencent/av/VideoController:jdField_a_of_type_Mjw	Lmjw;
    //   207: astore 20
    //   209: aload 20
    //   211: ifnull +17 -> 228
    //   214: aload 20
    //   216: invokevirtual 2207	mjw:c	()Z
    //   219: ifeq +9 -> 228
    //   222: aload 20
    //   224: iconst_4
    //   225: invokevirtual 2208	mjw:a	(I)V
    //   228: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +13 -> 244
    //   234: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc_w 2210
    //   241: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aload 18
    //   246: invokevirtual 2213	com/tencent/av/app/VideoAppInterface:a	()Llkf;
    //   249: astore 20
    //   251: aload 20
    //   253: ifnull +10 -> 263
    //   256: aload 20
    //   258: aload 19
    //   260: invokevirtual 2218	lkf:a	(Llfe;)V
    //   263: aload 18
    //   265: invokevirtual 448	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   268: aload_0
    //   269: getfield 234	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   272: invokevirtual 454	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   275: aload_0
    //   276: aconst_null
    //   277: putfield 234	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   280: aload_0
    //   281: getfield 210	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   284: ifnull +20 -> 304
    //   287: aload 18
    //   289: invokevirtual 448	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   292: aload_0
    //   293: getfield 210	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   296: invokevirtual 454	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   299: aload_0
    //   300: aconst_null
    //   301: putfield 210	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   304: aload_0
    //   305: getfield 216	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   308: ifnull -127 -> 181
    //   311: aload 18
    //   313: iconst_4
    //   314: anewarray 4	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: sipush 203
    //   322: invokestatic 741	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: dup
    //   327: iconst_1
    //   328: lload_2
    //   329: invokestatic 663	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   332: aastore
    //   333: dup
    //   334: iconst_2
    //   335: aload_0
    //   336: getfield 118	com/tencent/av/VideoController:jdField_a_of_type_Boolean	Z
    //   339: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   342: aastore
    //   343: dup
    //   344: iconst_3
    //   345: lload 12
    //   347: invokestatic 744	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: aastore
    //   351: invokevirtual 747	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   354: aload_0
    //   355: invokevirtual 406	com/tencent/av/VideoController:a	()Llfe;
    //   358: getfield 2220	lfe:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   361: invokevirtual 790	java/util/ArrayList:size	()I
    //   364: ifle +21 -> 385
    //   367: aload_0
    //   368: invokevirtual 406	com/tencent/av/VideoController:a	()Llfe;
    //   371: getfield 729	lfe:jdField_ad_of_type_Boolean	Z
    //   374: ifeq +11 -> 385
    //   377: aload_0
    //   378: iconst_2
    //   379: iconst_0
    //   380: iconst_0
    //   381: lconst_0
    //   382: invokevirtual 2222	com/tencent/av/VideoController:a	(IIIJ)V
    //   385: iload_1
    //   386: iconst_2
    //   387: if_icmpne +149 -> 536
    //   390: aload 19
    //   392: getfield 729	lfe:jdField_ad_of_type_Boolean	Z
    //   395: ifne +141 -> 536
    //   398: aload 19
    //   400: getfield 2220	lfe:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   403: ifnull +133 -> 536
    //   406: new 829	android/content/Intent
    //   409: dup
    //   410: invokespecial 830	android/content/Intent:<init>	()V
    //   413: astore 20
    //   415: aload 20
    //   417: ldc_w 832
    //   420: invokevirtual 836	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   423: pop
    //   424: aload 20
    //   426: ldc_w 838
    //   429: sipush 411
    //   432: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   435: pop
    //   436: aload 20
    //   438: ldc_w 2224
    //   441: aload_0
    //   442: invokevirtual 406	com/tencent/av/VideoController:a	()Llfe;
    //   445: getfield 2220	lfe:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   448: invokevirtual 2227	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   451: pop
    //   452: aload 20
    //   454: ldc_w 841
    //   457: aload_0
    //   458: invokevirtual 406	com/tencent/av/VideoController:a	()Llfe;
    //   461: getfield 1332	lfe:F	I
    //   464: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   467: pop
    //   468: aload 20
    //   470: ldc_w 843
    //   473: aload_0
    //   474: invokevirtual 406	com/tencent/av/VideoController:a	()Llfe;
    //   477: getfield 733	lfe:jdField_g_of_type_Long	J
    //   480: invokevirtual 846	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   483: pop
    //   484: aload 20
    //   486: ldc_w 850
    //   489: aload_0
    //   490: invokevirtual 406	com/tencent/av/VideoController:a	()Llfe;
    //   493: getfield 726	lfe:D	I
    //   496: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   499: pop
    //   500: aload 20
    //   502: ldc_w 902
    //   505: ldc_w 2229
    //   508: invokevirtual 907	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   511: pop
    //   512: aload 20
    //   514: aload 18
    //   516: invokevirtual 854	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   519: invokevirtual 859	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   522: invokevirtual 862	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   525: pop
    //   526: aload 18
    //   528: invokevirtual 854	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   531: aload 20
    //   533: invokevirtual 866	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   536: iload_1
    //   537: bipush 7
    //   539: if_icmpne +10 -> 549
    //   542: aload_0
    //   543: iconst_0
    //   544: iconst_0
    //   545: aconst_null
    //   546: invokevirtual 777	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   549: iload_1
    //   550: bipush 9
    //   552: if_icmpne +29 -> 581
    //   555: aload 19
    //   557: getfield 757	lfe:jdField_a_of_type_Lff	Llff;
    //   560: iconst_0
    //   561: putfield 760	lff:jdField_b_of_type_Int	I
    //   564: aload_0
    //   565: iconst_0
    //   566: iconst_0
    //   567: aconst_null
    //   568: invokevirtual 777	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   571: aload 19
    //   573: invokevirtual 2230	lfe:b	()V
    //   576: aload 19
    //   578: invokevirtual 2231	lfe:a	()V
    //   581: iload_1
    //   582: bipush 10
    //   584: if_icmpne +13 -> 597
    //   587: aload 19
    //   589: invokevirtual 2230	lfe:b	()V
    //   592: aload 19
    //   594: invokevirtual 2231	lfe:a	()V
    //   597: iload_1
    //   598: iconst_2
    //   599: if_icmpne +1115 -> 1714
    //   602: ldc_w 2233
    //   605: aload 19
    //   607: getfield 2235	lfe:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   610: invokevirtual 1140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   613: ifeq +30 -> 643
    //   616: aconst_null
    //   617: ldc_w 2237
    //   620: ldc 173
    //   622: ldc 173
    //   624: ldc_w 2239
    //   627: ldc_w 2239
    //   630: iconst_0
    //   631: iconst_0
    //   632: ldc 173
    //   634: ldc 173
    //   636: ldc 173
    //   638: ldc 173
    //   640: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   643: aload_0
    //   644: invokevirtual 2241	com/tencent/av/VideoController:h	()Z
    //   647: ifeq +30 -> 677
    //   650: aconst_null
    //   651: ldc_w 2237
    //   654: ldc 173
    //   656: ldc 173
    //   658: ldc_w 2243
    //   661: ldc_w 2243
    //   664: iconst_0
    //   665: iconst_0
    //   666: ldc 173
    //   668: ldc 173
    //   670: ldc 173
    //   672: ldc 173
    //   674: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 19
    //   679: getfield 1341	lfe:jdField_j_of_type_Boolean	Z
    //   682: ifeq +38 -> 720
    //   685: aconst_null
    //   686: ldc_w 2237
    //   689: ldc 173
    //   691: ldc 173
    //   693: ldc_w 2245
    //   696: ldc_w 2245
    //   699: iconst_0
    //   700: iconst_0
    //   701: ldc 173
    //   703: ldc 173
    //   705: ldc 173
    //   707: ldc 173
    //   709: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 19
    //   714: getfield 2246	lfe:jdField_m_of_type_Boolean	Z
    //   717: ifeq +967 -> 1684
    //   720: aload_0
    //   721: getfield 236	com/tencent/av/VideoController:jdField_s_of_type_Boolean	Z
    //   724: ifeq +44 -> 768
    //   727: aload_0
    //   728: invokevirtual 2248	com/tencent/av/VideoController:a	()J
    //   731: lconst_0
    //   732: lcmp
    //   733: ifle +35 -> 768
    //   736: aconst_null
    //   737: ldc_w 2237
    //   740: ldc 173
    //   742: ldc 173
    //   744: ldc_w 2250
    //   747: ldc_w 2250
    //   750: iconst_0
    //   751: iconst_0
    //   752: ldc 173
    //   754: ldc 173
    //   756: aload_0
    //   757: invokevirtual 2248	com/tencent/av/VideoController:a	()J
    //   760: invokestatic 2254	mvk:a	(J)Ljava/lang/String;
    //   763: ldc 173
    //   765: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload_0
    //   769: getfield 216	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   772: lload_2
    //   773: invokevirtual 2257	com/tencent/av/gaudio/QQGAudioCtrl:getNetTrafficSize	(J)J
    //   776: lstore 14
    //   778: iconst_0
    //   779: istore 5
    //   781: iload 4
    //   783: bipush 7
    //   785: if_icmpeq +1315 -> 2100
    //   788: iload 4
    //   790: bipush 20
    //   792: if_icmpne +6 -> 798
    //   795: goto +1305 -> 2100
    //   798: getstatic 2260	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   801: ifne +24 -> 825
    //   804: iload 4
    //   806: bipush 69
    //   808: if_icmpeq +17 -> 825
    //   811: iload 4
    //   813: bipush 70
    //   815: if_icmpeq +10 -> 825
    //   818: iload 4
    //   820: bipush 71
    //   822: if_icmpne +1223 -> 2045
    //   825: aload_0
    //   826: ldc_w 2261
    //   829: putfield 230	com/tencent/av/VideoController:jdField_r_of_type_Int	I
    //   832: aload_0
    //   833: getfield 315	com/tencent/av/VideoController:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   836: ifnull +21 -> 857
    //   839: aload_0
    //   840: getfield 315	com/tencent/av/VideoController:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   843: new 2263	com/tencent/av/VideoController$24
    //   846: dup
    //   847: aload_0
    //   848: iload 5
    //   850: invokespecial 2266	com/tencent/av/VideoController$24:<init>	(Lcom/tencent/av/VideoController;I)V
    //   853: invokevirtual 723	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   856: pop
    //   857: aload_0
    //   858: getfield 228	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   861: astore 20
    //   863: aload 20
    //   865: monitorenter
    //   866: aload_0
    //   867: getfield 228	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   870: sipush 2000
    //   873: i2l
    //   874: invokevirtual 2269	java/lang/Object:wait	(J)V
    //   877: aload 20
    //   879: monitorexit
    //   880: aload_0
    //   881: getfield 230	com/tencent/av/VideoController:jdField_r_of_type_Int	I
    //   884: ldc_w 2261
    //   887: if_icmpne +1207 -> 2094
    //   890: sipush 261
    //   893: istore 5
    //   895: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   898: iconst_1
    //   899: new 378	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 2271
    //   909: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_0
    //   913: getfield 230	com/tencent/av/VideoController:jdField_r_of_type_Int	I
    //   916: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   919: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   925: aload_0
    //   926: getfield 1726	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   929: ifeq +1129 -> 2058
    //   932: aload 19
    //   934: getfield 789	lfe:jdField_g_of_type_Int	I
    //   937: bipush 9
    //   939: if_icmpne +1119 -> 2058
    //   942: aload 19
    //   944: getfield 797	lfe:af	Z
    //   947: ifne +1111 -> 2058
    //   950: lconst_0
    //   951: lstore 8
    //   953: aload_0
    //   954: ldc_w 2273
    //   957: iconst_0
    //   958: invokevirtual 1738	com/tencent/av/VideoController:b	(Ljava/lang/String;Z)V
    //   961: aload_0
    //   962: ldc_w 2273
    //   965: iconst_1
    //   966: invokevirtual 1740	com/tencent/av/VideoController:g	(Ljava/lang/String;I)V
    //   969: aload_0
    //   970: getfield 245	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   973: astore 20
    //   975: aload 20
    //   977: monitorenter
    //   978: aload_0
    //   979: getfield 245	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   982: invokevirtual 790	java/util/ArrayList:size	()I
    //   985: ifne +1103 -> 2088
    //   988: aload_0
    //   989: getfield 1726	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   992: ifne +1096 -> 2088
    //   995: aload_0
    //   996: getfield 682	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   999: lconst_0
    //   1000: lcmp
    //   1001: ifne +1087 -> 2088
    //   1004: iconst_1
    //   1005: istore 6
    //   1007: aload_0
    //   1008: getfield 245	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1011: invokevirtual 790	java/util/ArrayList:size	()I
    //   1014: istore 7
    //   1016: aload_0
    //   1017: getfield 245	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1020: invokevirtual 1437	java/util/ArrayList:clear	()V
    //   1023: aload 20
    //   1025: monitorexit
    //   1026: aload_0
    //   1027: ldc_w 2273
    //   1030: iconst_0
    //   1031: iconst_0
    //   1032: lconst_0
    //   1033: invokevirtual 710	com/tencent/av/VideoController:a	(Ljava/lang/String;ZIJ)V
    //   1036: aload 19
    //   1038: iconst_0
    //   1039: putfield 713	lfe:jdField_V_of_type_Boolean	Z
    //   1042: aload_0
    //   1043: getfield 216	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1046: iconst_0
    //   1047: putfield 2276	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   1050: aload 18
    //   1052: invokevirtual 652	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1055: astore 20
    //   1057: lconst_0
    //   1058: lstore 10
    //   1060: aload 20
    //   1062: ifnull +10 -> 1072
    //   1065: aload 20
    //   1067: invokestatic 657	mry:a	(Ljava/lang/String;)J
    //   1070: lstore 10
    //   1072: aload 20
    //   1074: invokestatic 670	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1077: ifne +214 -> 1291
    //   1080: new 829	android/content/Intent
    //   1083: dup
    //   1084: invokespecial 830	android/content/Intent:<init>	()V
    //   1087: astore 21
    //   1089: aload 21
    //   1091: ldc_w 832
    //   1094: invokevirtual 836	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   1097: pop
    //   1098: aload 21
    //   1100: ldc_w 838
    //   1103: bipush 23
    //   1105: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1108: pop
    //   1109: aload 21
    //   1111: ldc_w 848
    //   1114: lload 10
    //   1116: invokevirtual 846	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1119: pop
    //   1120: aload 21
    //   1122: ldc_w 843
    //   1125: lload_2
    //   1126: invokevirtual 846	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1129: pop
    //   1130: aload 21
    //   1132: ldc_w 841
    //   1135: iload_1
    //   1136: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1139: pop
    //   1140: aload 21
    //   1142: ldc_w 850
    //   1145: aload 19
    //   1147: getfield 726	lfe:D	I
    //   1150: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1153: pop
    //   1154: aload 21
    //   1156: ldc_w 2278
    //   1159: lload 8
    //   1161: invokevirtual 846	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1164: pop
    //   1165: aload 21
    //   1167: ldc_w 895
    //   1170: aload_0
    //   1171: getfield 232	com/tencent/av/VideoController:jdField_r_of_type_Boolean	Z
    //   1174: invokevirtual 898	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1177: pop
    //   1178: aload 21
    //   1180: ldc_w 2280
    //   1183: iload 4
    //   1185: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1188: pop
    //   1189: aload 21
    //   1191: ldc_w 902
    //   1194: ldc_w 2282
    //   1197: invokevirtual 907	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1200: pop
    //   1201: iload 7
    //   1203: iconst_1
    //   1204: if_icmple +871 -> 2075
    //   1207: aload 21
    //   1209: ldc_w 900
    //   1212: iload 7
    //   1214: iconst_1
    //   1215: isub
    //   1216: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1219: pop
    //   1220: aload 21
    //   1222: aload 18
    //   1224: invokevirtual 854	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1227: invokevirtual 859	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1230: invokevirtual 862	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1233: pop
    //   1234: aload 21
    //   1236: lload 12
    //   1238: invokestatic 2287	mur:a	(Landroid/content/Intent;J)V
    //   1241: aload 18
    //   1243: invokevirtual 854	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1246: aload 21
    //   1248: invokevirtual 866	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1251: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1254: ifeq +37 -> 1291
    //   1257: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1260: iconst_1
    //   1261: new 378	java/lang/StringBuilder
    //   1264: dup
    //   1265: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   1268: ldc_w 2289
    //   1271: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: lload 12
    //   1276: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1279: ldc_w 548
    //   1282: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: invokestatic 550	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1291: aload 19
    //   1293: ldc_w 2273
    //   1296: aconst_null
    //   1297: invokevirtual 2291	lfe:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1300: aload 19
    //   1302: aconst_null
    //   1303: putfield 2294	lfe:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1306: aload_0
    //   1307: invokevirtual 2295	com/tencent/av/VideoController:h	()V
    //   1310: aload 19
    //   1312: getfield 919	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1315: invokevirtual 790	java/util/ArrayList:size	()I
    //   1318: ifle +28 -> 1346
    //   1321: aload 18
    //   1323: iconst_2
    //   1324: anewarray 4	java/lang/Object
    //   1327: dup
    //   1328: iconst_0
    //   1329: bipush 104
    //   1331: invokestatic 741	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1334: aastore
    //   1335: dup
    //   1336: iconst_1
    //   1337: aload 19
    //   1339: getfield 919	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1342: aastore
    //   1343: invokevirtual 747	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1346: aload 19
    //   1348: getfield 1332	lfe:F	I
    //   1351: iconst_1
    //   1352: if_icmpne +28 -> 1380
    //   1355: aload 18
    //   1357: iconst_2
    //   1358: anewarray 4	java/lang/Object
    //   1361: dup
    //   1362: iconst_0
    //   1363: sipush 410
    //   1366: invokestatic 741	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1369: aastore
    //   1370: dup
    //   1371: iconst_1
    //   1372: lload_2
    //   1373: invokestatic 744	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1376: aastore
    //   1377: invokevirtual 747	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1380: aload 19
    //   1382: getfield 2297	lfe:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   1385: astore 21
    //   1387: aload 19
    //   1389: getfield 1332	lfe:F	I
    //   1392: iconst_1
    //   1393: if_icmpeq +12 -> 1405
    //   1396: aload 19
    //   1398: getfield 1332	lfe:F	I
    //   1401: iconst_2
    //   1402: if_icmpne +44 -> 1446
    //   1405: aload 19
    //   1407: getfield 1341	lfe:jdField_j_of_type_Boolean	Z
    //   1410: ifeq +28 -> 1438
    //   1413: aload 18
    //   1415: iconst_2
    //   1416: anewarray 4	java/lang/Object
    //   1419: dup
    //   1420: iconst_0
    //   1421: bipush 106
    //   1423: invokestatic 741	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1426: aastore
    //   1427: dup
    //   1428: iconst_1
    //   1429: lload 12
    //   1431: invokestatic 744	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1434: aastore
    //   1435: invokevirtual 747	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1438: aload 19
    //   1440: lload 12
    //   1442: iconst_0
    //   1443: invokevirtual 2300	lfe:a	(JZ)V
    //   1446: aload 19
    //   1448: lload 12
    //   1450: invokevirtual 2302	lfe:c	(J)V
    //   1453: aload_0
    //   1454: invokevirtual 2304	com/tencent/av/VideoController:f	()V
    //   1457: lload 12
    //   1459: aload 18
    //   1461: invokestatic 2307	mbf:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1464: iload 6
    //   1466: ifne +46 -> 1512
    //   1469: aload_0
    //   1470: new 378	java/lang/StringBuilder
    //   1473: dup
    //   1474: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   1477: ldc_w 2309
    //   1480: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: iload 4
    //   1485: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: aload 17
    //   1493: iload_1
    //   1494: invokestatic 2311	mvk:c	(I)I
    //   1497: aload 20
    //   1499: lload_2
    //   1500: invokestatic 663	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1503: bipush 7
    //   1505: aload 21
    //   1507: iconst_0
    //   1508: iconst_0
    //   1509: invokevirtual 2314	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1512: aload 19
    //   1514: iconst_m1
    //   1515: putfield 752	lfe:jdField_j_of_type_Int	I
    //   1518: aload 19
    //   1520: iconst_1
    //   1521: putfield 2315	lfe:jdField_p_of_type_Boolean	Z
    //   1524: aload_0
    //   1525: lload 14
    //   1527: putfield 2183	com/tencent/av/VideoController:jdField_b_of_type_Long	J
    //   1530: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1533: ifeq +31 -> 1564
    //   1536: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1539: iconst_2
    //   1540: new 378	java/lang/StringBuilder
    //   1543: dup
    //   1544: invokespecial 379	java/lang/StringBuilder:<init>	()V
    //   1547: ldc_w 2317
    //   1550: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: lload 14
    //   1555: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1558: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1564: new 829	android/content/Intent
    //   1567: dup
    //   1568: ldc_w 2189
    //   1571: invokespecial 2191	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1574: astore 19
    //   1576: aload 19
    //   1578: ldc_w 2194
    //   1581: lload 14
    //   1583: invokevirtual 846	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1586: pop
    //   1587: aload 19
    //   1589: aload 18
    //   1591: invokevirtual 854	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1594: invokevirtual 859	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1597: invokevirtual 862	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1600: pop
    //   1601: iload 6
    //   1603: ifne +13 -> 1616
    //   1606: aload 18
    //   1608: invokevirtual 854	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1611: aload 19
    //   1613: invokevirtual 866	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1616: aload_0
    //   1617: getfield 116	com/tencent/av/VideoController:jdField_a_of_type_Lbz	Llbz;
    //   1620: lload 12
    //   1622: aload 17
    //   1624: invokevirtual 2320	lbz:a	(JLjava/lang/String;)Z
    //   1627: istore 16
    //   1629: aload 18
    //   1631: invokestatic 782	mtt:a	(Lcom/tencent/av/app/VideoAppInterface;)Lmtt;
    //   1634: astore 18
    //   1636: aload 18
    //   1638: ifnull +27 -> 1665
    //   1641: aload 18
    //   1643: invokevirtual 783	mtt:a	()Z
    //   1646: ifeq +19 -> 1665
    //   1649: aload 18
    //   1651: aload 17
    //   1653: invokevirtual 873	mtt:a	(Ljava/lang/String;)V
    //   1656: iload 16
    //   1658: ifeq +7 -> 1665
    //   1661: aload_0
    //   1662: invokevirtual 785	com/tencent/av/VideoController:b	()V
    //   1665: invokestatic 2323	com/tencent/av/utils/PopupDialog:a	()V
    //   1668: aload_0
    //   1669: iload 5
    //   1671: invokevirtual 2325	com/tencent/av/VideoController:d	(I)V
    //   1674: goto -1493 -> 181
    //   1677: astore 17
    //   1679: aload_0
    //   1680: monitorexit
    //   1681: aload 17
    //   1683: athrow
    //   1684: aconst_null
    //   1685: ldc_w 2237
    //   1688: ldc 173
    //   1690: ldc 173
    //   1692: ldc_w 2327
    //   1695: ldc_w 2327
    //   1698: iconst_0
    //   1699: iconst_0
    //   1700: ldc 173
    //   1702: ldc 173
    //   1704: ldc 173
    //   1706: ldc 173
    //   1708: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1711: goto -991 -> 720
    //   1714: iload_1
    //   1715: iconst_1
    //   1716: if_icmpne -996 -> 720
    //   1719: ldc_w 2233
    //   1722: aload 19
    //   1724: getfield 2235	lfe:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   1727: invokevirtual 1140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1730: ifeq +40 -> 1770
    //   1733: aload 19
    //   1735: getfield 726	lfe:D	I
    //   1738: bipush 10
    //   1740: if_icmpne +167 -> 1907
    //   1743: aconst_null
    //   1744: ldc_w 2237
    //   1747: ldc 173
    //   1749: ldc 173
    //   1751: ldc_w 2329
    //   1754: ldc_w 2329
    //   1757: iconst_0
    //   1758: iconst_0
    //   1759: ldc 173
    //   1761: ldc 173
    //   1763: ldc 173
    //   1765: ldc 173
    //   1767: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1770: aload_0
    //   1771: invokevirtual 2241	com/tencent/av/VideoController:h	()Z
    //   1774: ifeq +40 -> 1814
    //   1777: aload 19
    //   1779: getfield 726	lfe:D	I
    //   1782: bipush 10
    //   1784: if_icmpne +153 -> 1937
    //   1787: aconst_null
    //   1788: ldc_w 2237
    //   1791: ldc 173
    //   1793: ldc 173
    //   1795: ldc_w 2331
    //   1798: ldc_w 2331
    //   1801: iconst_0
    //   1802: iconst_0
    //   1803: ldc 173
    //   1805: ldc 173
    //   1807: ldc 173
    //   1809: ldc 173
    //   1811: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1814: aload 19
    //   1816: getfield 1341	lfe:jdField_j_of_type_Boolean	Z
    //   1819: ifeq -1099 -> 720
    //   1822: aload 19
    //   1824: getfield 726	lfe:D	I
    //   1827: bipush 10
    //   1829: if_icmpne +138 -> 1967
    //   1832: aconst_null
    //   1833: ldc_w 2237
    //   1836: ldc 173
    //   1838: ldc 173
    //   1840: ldc_w 2333
    //   1843: ldc_w 2333
    //   1846: iconst_0
    //   1847: iconst_0
    //   1848: ldc 173
    //   1850: ldc 173
    //   1852: ldc 173
    //   1854: ldc 173
    //   1856: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1859: aload 19
    //   1861: getfield 2246	lfe:jdField_m_of_type_Boolean	Z
    //   1864: ifne -1144 -> 720
    //   1867: aload 19
    //   1869: getfield 726	lfe:D	I
    //   1872: bipush 10
    //   1874: if_icmpne +123 -> 1997
    //   1877: aconst_null
    //   1878: ldc_w 2237
    //   1881: ldc 173
    //   1883: ldc 173
    //   1885: ldc_w 2335
    //   1888: ldc_w 2335
    //   1891: iconst_0
    //   1892: iconst_0
    //   1893: ldc 173
    //   1895: ldc 173
    //   1897: ldc 173
    //   1899: ldc 173
    //   1901: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1904: goto -1184 -> 720
    //   1907: aconst_null
    //   1908: ldc_w 2237
    //   1911: ldc 173
    //   1913: ldc 173
    //   1915: ldc_w 2337
    //   1918: ldc_w 2337
    //   1921: iconst_0
    //   1922: iconst_0
    //   1923: ldc 173
    //   1925: ldc 173
    //   1927: ldc 173
    //   1929: ldc 173
    //   1931: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1934: goto -164 -> 1770
    //   1937: aconst_null
    //   1938: ldc_w 2237
    //   1941: ldc 173
    //   1943: ldc 173
    //   1945: ldc_w 2339
    //   1948: ldc_w 2339
    //   1951: iconst_0
    //   1952: iconst_0
    //   1953: ldc 173
    //   1955: ldc 173
    //   1957: ldc 173
    //   1959: ldc 173
    //   1961: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1964: goto -150 -> 1814
    //   1967: aconst_null
    //   1968: ldc_w 2237
    //   1971: ldc 173
    //   1973: ldc 173
    //   1975: ldc_w 2341
    //   1978: ldc_w 2341
    //   1981: iconst_0
    //   1982: iconst_0
    //   1983: ldc 173
    //   1985: ldc 173
    //   1987: ldc 173
    //   1989: ldc 173
    //   1991: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1994: goto -135 -> 1859
    //   1997: aconst_null
    //   1998: ldc_w 2237
    //   2001: ldc 173
    //   2003: ldc 173
    //   2005: ldc_w 2343
    //   2008: ldc_w 2343
    //   2011: iconst_0
    //   2012: iconst_0
    //   2013: ldc 173
    //   2015: ldc 173
    //   2017: ldc 173
    //   2019: ldc 173
    //   2021: invokestatic 1208	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2024: goto -1304 -> 720
    //   2027: astore 21
    //   2029: aload 21
    //   2031: invokevirtual 2344	java/lang/InterruptedException:printStackTrace	()V
    //   2034: goto -1157 -> 877
    //   2037: astore 17
    //   2039: aload 20
    //   2041: monitorexit
    //   2042: aload 17
    //   2044: athrow
    //   2045: aload_0
    //   2046: getfield 216	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   2049: iload 5
    //   2051: invokevirtual 2347	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   2054: pop
    //   2055: goto -1130 -> 925
    //   2058: aload_0
    //   2059: invokevirtual 2248	com/tencent/av/VideoController:a	()J
    //   2062: lstore 8
    //   2064: goto -1111 -> 953
    //   2067: astore 17
    //   2069: aload 20
    //   2071: monitorexit
    //   2072: aload 17
    //   2074: athrow
    //   2075: aload 21
    //   2077: ldc_w 900
    //   2080: iconst_0
    //   2081: invokevirtual 839	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2084: pop
    //   2085: goto -865 -> 1220
    //   2088: iconst_0
    //   2089: istore 6
    //   2091: goto -1084 -> 1007
    //   2094: goto -1199 -> 895
    //   2097: goto -2052 -> 45
    //   2100: iload 4
    //   2102: istore 5
    //   2104: goto -1306 -> 798
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2107	0	this	VideoController
    //   0	2107	1	paramInt1	int
    //   0	2107	2	paramLong	long
    //   0	2107	4	paramInt2	int
    //   779	1324	5	i1	int
    //   1005	1085	6	i2	int
    //   1014	202	7	i3	int
    //   951	1112	8	l1	long
    //   1058	57	10	l2	long
    //   5	1616	12	l3	long
    //   776	806	14	l4	long
    //   141	1516	16	bool	boolean
    //   24	1628	17	str	String
    //   1677	5	17	localObject1	Object
    //   2037	6	17	localObject2	Object
    //   2067	6	17	localObject3	Object
    //   11	1639	18	localObject4	Object
    //   54	1814	19	localObject5	Object
    //   133	1373	21	localObject7	Object
    //   2027	49	21	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	26	1677	finally
    //   31	45	1677	finally
    //   45	135	1677	finally
    //   143	176	1677	finally
    //   195	209	1677	finally
    //   214	228	1677	finally
    //   228	244	1677	finally
    //   244	251	1677	finally
    //   256	263	1677	finally
    //   263	304	1677	finally
    //   304	385	1677	finally
    //   390	536	1677	finally
    //   542	549	1677	finally
    //   555	581	1677	finally
    //   587	597	1677	finally
    //   602	643	1677	finally
    //   643	677	1677	finally
    //   677	720	1677	finally
    //   720	768	1677	finally
    //   768	778	1677	finally
    //   798	804	1677	finally
    //   825	857	1677	finally
    //   857	866	1677	finally
    //   880	890	1677	finally
    //   895	925	1677	finally
    //   925	950	1677	finally
    //   953	978	1677	finally
    //   1026	1057	1677	finally
    //   1065	1072	1677	finally
    //   1072	1201	1677	finally
    //   1207	1220	1677	finally
    //   1220	1291	1677	finally
    //   1291	1346	1677	finally
    //   1346	1380	1677	finally
    //   1380	1405	1677	finally
    //   1405	1438	1677	finally
    //   1438	1446	1677	finally
    //   1446	1464	1677	finally
    //   1469	1512	1677	finally
    //   1512	1564	1677	finally
    //   1564	1601	1677	finally
    //   1606	1616	1677	finally
    //   1616	1636	1677	finally
    //   1641	1656	1677	finally
    //   1661	1665	1677	finally
    //   1665	1674	1677	finally
    //   1684	1711	1677	finally
    //   1719	1770	1677	finally
    //   1770	1814	1677	finally
    //   1814	1859	1677	finally
    //   1859	1904	1677	finally
    //   1907	1934	1677	finally
    //   1937	1964	1677	finally
    //   1967	1994	1677	finally
    //   1997	2024	1677	finally
    //   2042	2045	1677	finally
    //   2045	2055	1677	finally
    //   2058	2064	1677	finally
    //   2072	2075	1677	finally
    //   2075	2085	1677	finally
    //   866	877	2027	java/lang/InterruptedException
    //   866	877	2037	finally
    //   877	880	2037	finally
    //   2029	2034	2037	finally
    //   2039	2042	2037	finally
    //   978	1004	2067	finally
    //   1007	1026	2067	finally
    //   2069	2072	2067	finally
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = lbz.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = lbz.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l1 = AudioHelper.b();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], seq[" + l1 + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((lfe)localObject).jdField_j_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      if ((l()) && ((paramInt2 == 16) || (paramInt2 == 69) || (paramInt2 == 68) || (paramInt2 == 17) || (paramInt2 == 71) || (paramInt2 == 70)))
      {
        if (this.jdField_e_of_type_Boolean) {
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
      int i1 = mvk.c(paramInt1);
      a(a().jdField_c_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        a("onGAudioSDKError_2");
        if (this.jdField_a_of_type_Muy != null) {
          this.jdField_a_of_type_Muy.a(l1);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_a_of_type_Lbz.a(l1, str);
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
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    lfe locallfe = a();
    String str;
    if (paramInt2 == 3)
    {
      str = lbz.a(100, String.valueOf(paramLong2), new int[0]);
      boolean bool = TextUtils.equals(locallfe.jdField_c_of_type_JavaLangString, str);
      if ((!bool) || (QLog.isDevelopLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + locallfe.jdField_c_of_type_JavaLangString + "], seq[" + l1 + "]");
      }
      if (bool) {
        break label169;
      }
    }
    label169:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      str = lbz.a(paramInt2, String.valueOf(paramLong2), new int[0]);
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
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(502), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(500), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    long l1 = AudioHelper.b();
    lbd.d("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    e(false);
    Object localObject1 = a();
    long l2 = a(String.valueOf(paramLong2));
    long l3 = d();
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder().append("onGAudioInvite, friendUin[").append(paramLong2).append("], groupId[").append(paramLong1).append("], multiSubType[").append(paramInt3).append("], multiAVType[").append(paramInt2).append("], relationType[").append(paramInt1).append("], mGAudioInRoom[").append(this.jdField_e_of_type_Boolean).append("], mGAudioGroupId[").append(this.jdField_a_of_type_Long).append("], mCurrentInviteId[").append(this.jdField_d_of_type_Long).append("], mCurrentInviteRelationType[").append(this.jdField_h_of_type_Int).append("], offLineInvite[").append(paramBoolean).append("], roomId[").append(l2).append("], gRoomId[").append(l3).append("], seq[").append(l1).append("], main[").append(localObject1).append("], app[");
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
    label803:
    do
    {
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      if ((paramInt3 == 6) || (paramInt3 == 5) || (paramInt3 == 4) || (paramInt3 == 3)) {
        paramBoolean = true;
      }
      if (!bhfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
        return;
      }
      localObject3 = lbz.a(paramInt1, String.valueOf(paramLong1), new int[0]);
      if (this.jdField_a_of_type_Lbz.a((String)localObject3))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
        return;
      }
      localObject2 = this.jdField_a_of_type_Lbz.a((String)localObject3, false);
      ((lfe)localObject2).jdField_g_of_type_Long = paramLong1;
      ((lfe)localObject2).F = paramInt1;
      ((lfe)localObject2).D = paramInt2;
      ((lfe)localObject2).ah = false;
      ((lfe)localObject2).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      ((lfe)localObject2).jdField_ad_of_type_Int = paramInt4;
      if (b(paramInt1, paramLong1, paramInt3))
      {
        a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      lch.jdField_b_of_type_Boolean = localVideoAppInterface.b();
      paramBoolean = false;
      if (!((lfe)localObject1).f()) {
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
          ((lfe)localObject2).a("onGAudioInvite.1", 0);
        }
        L();
        bool = a(localVideoAppInterface.getApp().getApplicationContext());
        if (!bool) {
          break label803;
        }
        if ((((lfe)localObject1).jdField_g_of_type_Int <= 0) || (((lfe)localObject1).jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
          break;
        }
        a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
        if (localVideoAppInterface.e()) {
          paramBoolean = true;
        }
      }
      if (7 == ((lfe)localObject1).jdField_g_of_type_Int)
      {
        a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((lfe)localObject1).jdField_g_of_type_Int == 14) || (((lfe)localObject1).jdField_g_of_type_Int == 13))
      {
        a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((lfe)localObject1).jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) && (((lfe)localObject1).jdField_a_of_type_Lff.jdField_a_of_type_Int == 1))
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + ((lfe)localObject1).jdField_a_of_type_Lff.jdField_b_of_type_Int + "], chatType[" + ((lfe)localObject1).jdField_a_of_type_Lff.jdField_a_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
      }
      if (((lfe)localObject2).jdField_d_of_type_Int == 0)
      {
        ((lfe)localObject2).jdField_e_of_type_Boolean = true;
        ((lfe)localObject2).a(l1, "onGAudioInvite.1", 3);
        ((lfe)localObject2).jdField_j_of_type_Int = mvk.c(paramInt1);
        ((lfe)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong2);
        if (paramInt1 == 2) {
          ((lfe)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong2);
        }
        ((lfe)localObject2).jdField_e_of_type_Boolean = true;
        if ((paramInt3 != 3) && (paramInt3 != 4)) {
          a((String)localObject3, ((lfe)localObject2).jdField_d_of_type_Int, false, false, false);
        }
      }
      this.jdField_d_of_type_Long = paramLong1;
      this.jdField_h_of_type_Int = paramInt1;
      if (((lfe)localObject2).jdField_g_of_type_Int == 0) {
        ((lfe)localObject2).a("onGAudioInvite", 7);
      }
      bool = false;
      if ((paramInt3 != 3) || (((lfe)localObject1).jdField_g_of_type_Long != 0L)) {
        break label1377;
      }
      bool = b((lfe)localObject1, (lfe)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
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
        paramArrayOfLong.putExtra("extraUin", ((lfe)localObject1).jdField_f_of_type_JavaLangString);
        paramArrayOfLong.putExtra("relationId", paramLong1);
        paramArrayOfLong.putExtra("type", 13);
        paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("isSender", false);
        paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("realSenderUin", ((lfe)localObject1).jdField_s_of_type_JavaLangString);
        localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
        a(l1, this.jdField_h_of_type_Int, paramLong1, true);
        new bkxc(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
        this.jdField_a_of_type_Lbz.a(l1, (String)localObject3);
        return;
        label1377:
        if (paramInt3 != 4) {
          break;
        }
        bool = a((lfe)localObject1, (lfe)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
        break;
        if (paramInt1 == 2) {
          paramArrayOfLong.putExtra("uinType", 3000);
        }
      }
    }
    ((lfe)localObject1).jdField_s_of_type_JavaLangString = ("" + paramLong2);
    this.jdField_s_of_type_Boolean = b();
    if (((lfe)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite msg blocked [" + ((lfe)localObject2).jdField_c_of_type_JavaLangString + "]");
      }
      if (!localVideoAppInterface.jdField_c_of_type_Boolean) {
        break label1815;
      }
      localVideoAppInterface.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      localVideoAppInterface.jdField_d_of_type_Boolean = true;
      return;
      if ((paramBoolean) || (lde.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        bhgd.d();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", mvk.c(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((lfe)localObject2).jdField_c_of_type_JavaLangString);
        if ((!this.jdField_s_of_type_Boolean) || (!lzr.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1806;
        }
        if ((!paramBoolean) && (!lde.a())) {
          break label1774;
        }
        paramArrayOfLong = new mfa(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.d();
        paramArrayOfLong.a((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1774:
      paramArrayOfLong = new mli(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.d();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1806:
      a((Intent)localObject1);
      break;
      label1815:
      lii.a();
    }
  }
  
  public void a(int paramInt, long paramLong, nbs paramnbs)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt, paramLong, paramnbs);
    }
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    paramVarArgs = lbz.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_Lbz.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = lbz.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      lfe locallfe = this.jdField_a_of_type_Lbz.c(paramVarArgs);
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l1 + "], \nsession[" + locallfe + "]");
      }
      int i1;
      if ((locallfe != null) && ((locallfe.jdField_g_of_type_Int == 7) || (locallfe.jdField_g_of_type_Int == 2)))
      {
        locallfe.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_Lbz.a(paramVarArgs))
        {
          locallfe = this.jdField_a_of_type_Lbz.c(paramVarArgs);
          i1 = mvk.c(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(locallfe.jdField_c_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Lbz.a(l1, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, locallfe.jdField_s_of_type_JavaLangString, true, false);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Lbz == null) || (a() == null) || (a().jdField_d_of_type_JavaLangString == null)) {}
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
      Object localObject1 = this.jdField_a_of_type_Lbz;
      localObject1 = this.jdField_a_of_type_Lbz;
      localObject1 = lbz.a(lbz.a(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_a_of_type_Lbz.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((lfe)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((lfe)localObject1).jdField_d_of_type_JavaLangString)) && (((lfe)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((lfe)localObject1).A);
      ((Intent)localObject2).putExtra("bindId", ((lfe)localObject1).jdField_p_of_type_JavaLangString);
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
    boolean bool3 = this.jdField_a_of_type_Lby.a(paramString1);
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
    this.jdField_a_of_type_Lby.c();
    L();
    lch.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = mtx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i1 + ",sdkAVAccostType = " + paramInt1 + "|" + lch.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
    }
    if (a(i1, paramString1))
    {
      a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
      return;
    }
    localObject = a();
    str = lbz.a(3, paramString1, new int[0]);
    if ((TextUtils.equals(str, ((lfe)localObject).jdField_c_of_type_JavaLangString)) && (((lfe)localObject).jdField_d_of_type_Boolean))
    {
      ((lfe)localObject).jdField_e_of_type_Boolean = true;
      paramInt1 = 1;
      if (((lfe)localObject).S) {
        paramInt1 = 0;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((lfe)localObject).F);
      return;
    }
    boolean bool2 = false;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((i1 != 21) && (i1 != 1011) && ((((lfe)localObject).jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (((lfe)localObject).jdField_a_of_type_Lff.jdField_a_of_type_Int == 1))
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
      this.jdField_a_of_type_Lbz.a(str, false);
      localObject = this.jdField_a_of_type_Lbz.c(str);
      ((lfe)localObject).A = paramInt2;
      ((lfe)localObject).jdField_p_of_type_JavaLangString = paramString3;
      ((lfe)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((lfe)localObject).jdField_B_of_type_Int = i1;
      if (this.jdField_h_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_h_of_type_JavaLangRunnable = null;
        ((lfe)localObject).a("onRequestVideo.1", 0);
      }
      if (!this.jdField_a_of_type_Lby.a()) {
        break label1854;
      }
      i1 = 9500;
    }
    label693:
    label1854:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      ((lfe)localObject).S = paramBoolean;
      long l3;
      if (paramBoolean)
      {
        ((lfe)localObject).jdField_f_of_type_Int = 1;
        l1 = a(paramString1);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  ,roomId = " + l1);
        ((lfe)localObject).d(l1);
        ((lfe)localObject).jdField_j_of_type_Int = i1;
        ((lfe)localObject).jdField_k_of_type_Int = paramInt1;
        ((lfe)localObject).jdField_d_of_type_JavaLangString = paramString1;
        ((lfe)localObject).jdField_f_of_type_JavaLangString = paramString2;
        ((lfe)localObject).jdField_e_of_type_Boolean = true;
        ((lfe)localObject).a("onRequestVideo.2", 2);
        ((lfe)localObject).jdField_q_of_type_Int = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!paramBoolean) {
          break label1540;
        }
        paramInt1 = 1;
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        l3 = a(paramString1);
        lii.a(l3, 36);
        lii.a(l3, 9, ((lfe)localObject).b());
        lii.a(l3, 11, paramString1);
        lii.a(l3, 12, 2L);
        if (!((lfe)localObject).S) {
          break label1545;
        }
      }
      for (long l1 = 1L;; l1 = 2L)
      {
        lii.a(l3, 13, l1);
        lii.a(l3, 15, 1L);
        y(paramString1);
        if (!bool3) {
          break label1553;
        }
        ((lfe)localObject).jdField_c_of_type_Boolean = true;
        b(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((lfe)localObject).jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) && (((lfe)localObject).jdField_a_of_type_Lff.jdField_a_of_type_Int == 3))
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
        if (((lfe)localObject).f())
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
        if ((((lfe)localObject).o()) || (((lfe)localObject).p()))
        {
          b(((lfe)localObject).jdField_d_of_type_JavaLangString, 2);
          bool1 = bool2;
          break label570;
        }
        if (((((lfe)localObject).jdField_g_of_type_Int == 7) && (this.jdField_d_of_type_Long != 0L)) || (((lfe)localObject).jdField_g_of_type_Int == 14) || (((lfe)localObject).jdField_g_of_type_Int == 13))
        {
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label570;
        }
        if (!this.jdField_e_of_type_Boolean)
        {
          if (((i1 == 21) || (i1 == 1011)) && (a().jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString != null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  auto Accept");
            if ((((lfe)localObject).jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString != null) && (!((lfe)localObject).jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString.equals(paramString1)))
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
          if ((((lfe)localObject).jdField_d_of_type_JavaLangString != null) && (paramString1.equals(((lfe)localObject).jdField_d_of_type_JavaLangString)))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when request: fromUin = " + paramString1);
            F();
            y(paramString1);
            return;
          }
          if (!bool4) {
            break label570;
          }
          a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.jdField_e_of_type_Boolean) || (((lfe)localObject).jdField_g_of_type_Int == 8))
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
        if (((lfe)localObject).jdField_g_of_type_Int != 1) {
          break label570;
        }
        bool1 = bool2;
        if (((lfe)localObject).jdField_d_of_type_JavaLangString == null) {
          break label570;
        }
        bool1 = bool2;
        if (!paramString1.equals(((lfe)localObject).jdField_d_of_type_JavaLangString)) {
          break label570;
        }
        return;
        ((lfe)localObject).jdField_f_of_type_Int = 2;
        break label693;
        paramInt1 = 2;
        break label812;
      }
      if ((!this.jdField_e_of_type_Boolean) && (((lfe)localObject).jdField_j_of_type_Int != 21) && (((lfe)localObject).jdField_j_of_type_Int != 1011)) {
        a(str, ((lfe)localObject).jdField_f_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_n_of_type_Int + ", isQQPaused: " + lch.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
      }
      if ((this.x) && (this.jdField_n_of_type_Int == 0) && (!bool4) && (lch.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.6(this, l2, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_Lcc != null) {
        this.jdField_a_of_type_Lcc.b();
      }
      this.jdField_a_of_type_Lcc = new lcc(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      a(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt, ArrayList<AVUserInfo> paramArrayList)
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
  
  public void a(int paramInt, mow parammow)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + parammow);
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMow == null) {
      this.jdField_a_of_type_ArrayOfMow = new mow[2];
    }
    this.jdField_a_of_type_ArrayOfMow[paramInt] = parammow;
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
    muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    lfe locallfe = a();
    j();
    locallfe.a("onSubState2", 4);
    locallfe.a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!locallfe.jdField_g_of_type_Boolean) {
        break label212;
      }
      a(true, locallfe.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, paramLong), 50L);
      a(locallfe.jdField_c_of_type_JavaLangString, locallfe.jdField_d_of_type_Int, true, true, true);
      msa.i(this);
      msa.c(this, true);
      msa.b(this, true);
      lkf locallkf = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallkf != null) {
        locallkf.a(locallfe);
      }
      return;
      b();
      break;
      label212:
      a(false, locallfe.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, int paramInt)
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
      i1 = f();
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
      a(-1L, i1, f());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15001), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onKickOutSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], errCode[" + paramInt3 + "], strMsg[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(true), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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
      this.jdField_a_of_type_Muy.b(paramLong);
      if (!this.jdField_a_of_type_Muy.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        lbd.g(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_d_of_type_JavaLangString, 212);
        b(212);
        b(a().jdField_d_of_type_JavaLangString, a().z);
      }
    } while (!a().T);
    lbd.g(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
    a(a().jdField_d_of_type_JavaLangString, 213);
    b(213);
    b(a().jdField_d_of_type_JavaLangString, a().z);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
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
        i1 = f();
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
      a(-1L, i1, f());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (bool2)) {
        a(0L, false, 0L);
      }
      return;
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, -1, false);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    muy.a().b();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = lbz.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_a_of_type_Lbz.c(str1);
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
      str1 = lbz.a(paramInt1, String.valueOf(paramLong2), new int[0]);
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
    ((lfe)localObject).ah = true;
    int i1 = 4;
    label277:
    String str2;
    if (((lfe)localObject).jdField_g_of_type_Int == 7)
    {
      ((lfe)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        h();
        paramInt2 = mvk.c(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((lfe)localObject).jdField_c_of_type_JavaLangString, mvk.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((lfe)localObject).jdField_g_of_type_Long), 5, ((lfe)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_Lbz.a(paramLong1, str1);
      localObject = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mtt)localObject).a())) {
        break;
      }
      ((mtt)localObject).a(str1);
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
        a("ignoreGAudioChat_2", str1, paramInt2, ((lfe)localObject).jdField_d_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((lfe)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i1, ((lfe)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
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
      bdla.b(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i1, 0, "", "", "", "");
      if (paramArrayList == null) {
        break label638;
      }
      l(true);
      i1 = 1;
      i2 = 2;
      if (paramInt == 1)
      {
        i2 = 1;
        i1 = 10;
      }
      localObject2 = a();
      localObject1 = lbz.a(i2, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_a_of_type_Lbz.a((String)localObject1, false);
      i3 = ((lfe)localObject2).jdField_d_of_type_Int;
      ((lfe)localObject1).a(paramLong1, ((lfe)localObject2).jdField_j_of_type_Boolean);
      ((lfe)localObject1).jdField_g_of_type_Boolean = ((lfe)localObject2).jdField_g_of_type_Boolean;
      ((lfe)localObject1).b("switchToMultiAudio", ((lfe)localObject2).jdField_P_of_type_Boolean);
      ((lfe)localObject1).b("switchToMultiAudio", ((lfe)localObject2).jdField_q_of_type_JavaLangString);
      ((lfe)localObject1).jdField_d_of_type_JavaLangString = ((lfe)localObject2).jdField_d_of_type_JavaLangString;
      ((lfe)localObject1).D = i1;
      ((lfe)localObject1).aE = true;
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      if (!((lfe)localObject2).J) {
        break label454;
      }
      boolean bool = this.jdField_l_of_type_Boolean;
      a(paramLong1, Long.valueOf(((lfe)localObject2).jdField_d_of_type_JavaLangString).longValue(), true, 0);
      b("switchToMultiAudio", bool);
      if (!bool) {
        break label448;
      }
      i1 = 1;
      label328:
      g("switchToMultiAudio", i1);
    }
    for (this.jdField_d_of_type_Int = 2;; this.jdField_d_of_type_Int = 1)
    {
      if (!paramArrayList.contains(((lfe)localObject2).jdField_d_of_type_JavaLangString)) {
        paramArrayList.add(((lfe)localObject2).jdField_d_of_type_JavaLangString);
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
      a(((lfe)localObject2).jdField_d_of_type_JavaLangString, 1);
      b(214);
      b(((lfe)localObject2).jdField_d_of_type_JavaLangString, 21);
    }
    label500:
    if (i1 == localObject2.length)
    {
      ((lfe)localObject1).jdField_a_of_type_ArrayOfLong = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((lfe)localObject1).z = -1;
      if (i3 != 1) {
        break label680;
      }
      ((lfe)localObject1).a(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((lfe)localObject1).jdField_j_of_type_Int = paramInt;
      ((lfe)localObject1).jdField_g_of_type_Long = paramLong2;
      ((lfe)localObject1).d("switchToMultiAudio", mrr.a(paramInt));
      ((lfe)localObject1).c("switchToMultiAudio", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label638:
      return;
      ((lfe)localObject1).jdField_a_of_type_ArrayOfLong = new long[i1];
      i2 = 0;
      while (i2 < i1)
      {
        ((lfe)localObject1).jdField_a_of_type_ArrayOfLong[i2] = localObject2[i2];
        i2 += 1;
      }
      break;
      label680:
      if (i3 == 2) {
        ((lfe)localObject1).a(paramLong1, "switchToMultiAudio.2", 4);
      } else if (i3 == 3) {
        ((lfe)localObject1).a(paramLong1, "switchToMultiAudio.3", 3);
      } else if (i3 == 4) {
        ((lfe)localObject1).a(paramLong1, "switchToMultiAudio.4", 3);
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
      paramLong = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
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
        l1 = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
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
    String str = lbz.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_a_of_type_Lbz.c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((lfe)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((lfe)localObject).jdField_d_of_type_JavaLangString, ((lfe)localObject).jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((lfe)localObject).D);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_Lbz.a(paramLong1, str);
      localObject = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mtt)localObject).a())) {
        break;
      }
      ((mtt)localObject).a(str);
      if (!bool) {
        break;
      }
      b();
      return;
      a(str, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    lcu locallcu = a(String.valueOf(paramLong2));
    if (locallcu == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    locallcu.jdField_d_of_type_Boolean = false;
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
      a().ac = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
    a().ac = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    lfe locallfe = a();
    if ((locallfe.jdField_d_of_type_Int != 2) || ((locallfe.w != 2) && (locallfe.w != 3))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupSecurityLimit, mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], info[" + paramLong2 + "], strMsg[" + paramString + "]");
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1)) {
      a(1, paramLong1, 82);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_j_of_type_JavaLangRunnable = null;
      a().a("onGroupSecurityLimit", 0);
      a(1, paramLong1, 17, 0);
    }
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<lny> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.29(this, paramArrayList, paramLong1, paramLong2));
  }
  
  @TargetApi(21)
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, relationId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    Object localObject = this.jdField_a_of_type_Mjw;
    if (localObject != null) {
      ((mjw)localObject).a(4);
    }
    localObject = lbz.a(100, String.valueOf(paramLong2), new int[0]);
    lfe locallfe = this.jdField_a_of_type_Lbz.c((String)localObject);
    if (locallfe == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", locallfe.D);
    localIntent.putExtra("from", "VideoController6");
    mur.a(localIntent, paramLong1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a((String)localObject, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (locallfe.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      locallfe.d("quitDoubleVideoMeeting", false);
      locallfe.e("quitDoubleVideoMeeting", false);
    }
    for (;;)
    {
      localObject = a();
      if (localObject == null) {
        break;
      }
      ((ScreenShareCtrl)localObject).b(paramLong2);
      return;
      locallfe.a("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230741, 1, this.jdField_c_of_type_Lcv);
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.34(this);
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
    N();
    String str = lbz.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_Lbz.a(str)) {}
    for (lfe locallfe = this.jdField_a_of_type_Lbz.c(str); locallfe == null; locallfe = this.jdField_a_of_type_Lbz.c(str))
    {
      lbd.h(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = lbz.a(100, paramString, new int[0]);
    }
    locallfe.jdField_d_of_type_Boolean = false;
    if ((q()) && (paramString != null) && (!paramString.equals(locallfe.jdField_d_of_type_JavaLangString)))
    {
      lbd.g(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + locallfe.jdField_d_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Lcc != null)
    {
      this.jdField_a_of_type_Lcc.b();
      this.jdField_a_of_type_Lcc = null;
    }
    this.jdField_h_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    j();
    if ((locallfe.jdField_d_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(paramLong, str, paramString, 3);
      label296:
      if (!locallfe.j()) {
        break label440;
      }
      locallfe.z = paramInt;
      if ((locallfe.j()) && (paramInt == locallfe.jdField_d_of_type_Int)) {
        locallfe.a(paramLong, 0L);
      }
      locallfe.a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(locallfe.jdField_d_of_type_JavaLangString, locallfe.z);
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
        if (locallfe.h())
        {
          locallfe.z = paramInt;
          locallfe.a(paramLong, 0L);
          int i2 = 2131230741;
          switch (paramInt)
          {
          default: 
            i1 = 0;
            this.jdField_a_of_type_Lcv.jdField_a_of_type_Long = paramLong;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a(paramLong, i2, i1, this.jdField_a_of_type_Lcv);
            locallfe.a("onCloseVideo.isInviting1", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            bdla.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            if (l()) {
              break;
            }
            if (locallfe.jdField_d_of_type_Long != 2L)
            {
              bdla.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230740;
              break label531;
            }
            i2 = 2131230741;
            i1 = 1;
            break label531;
            this.jdField_b_of_type_Lcv.jdField_a_of_type_Long = paramLong;
            a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lcv);
            locallfe.a("onCloseVideo.isInviting", 6);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (l()) {
              break;
            }
            bdla.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            i2 = 2131230740;
            i1 = 0;
            break label531;
          }
        }
        label531:
        if (!locallfe.o())
        {
          locallfe.z = paramInt;
          if (locallfe.j()) {
            locallfe.a(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (locallfe.jdField_j_of_type_Int == 1011))
          {
            locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label1080;
            }
            a(6, 0, null);
            label950:
            mtt localmtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label1097;
            }
            if (localmtt != null) {
              localmtt.a();
            }
          }
          label976:
          locallfe.a("onCloseVideo.isClosing1", 6);
          if ((!q()) && (!mtj.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label1104;
          }
          a(locallfe.jdField_d_of_type_JavaLangString, 209);
          b(209);
          b(locallfe.jdField_d_of_type_JavaLangString, locallfe.z);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1080:
      a(locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int, 0, null);
      break label950;
      label1097:
      b();
      break label976;
      label1104:
      this.jdField_b_of_type_Lcv.jdField_a_of_type_Long = paramLong;
      a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lcv);
      mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_s_of_type_Boolean = b();
    boolean bool2 = lzr.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.jdField_s_of_type_Boolean + "], isFloatWindowOpAllowedOnBackground[" + bool2 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l1 + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!llc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
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
      lfe locallfe = this.jdField_a_of_type_Lbz.c(paramString1);
      if (locallfe == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      locallfe.jdField_e_of_type_Boolean = true;
      locallfe.S = paramBoolean1;
      locallfe.a("processVideoRequest.1", 2);
      locallfe.ag = false;
      locallfe.jdField_k_of_type_Long = System.currentTimeMillis();
      lvy.a().o = locallfe.S;
      if ((paramBoolean3) || (lde.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()))
      {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        localIntent.putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      }
      for (bool1 = false;; bool1 = true)
      {
        localIntent.addFlags(268435456);
        localIntent.putExtra("uinType", paramInt1);
        localIntent.putExtra("relationType", mvk.b(paramInt1));
        localIntent.putExtra("session_id", paramString1);
        localIntent.putExtra("peerUin", paramString2);
        localIntent.putExtra("extraUin", paramString3);
        localIntent.putExtra("isAudioMode", paramBoolean1);
        localIntent.putExtra("curUserStatus", this.jdField_g_of_type_Int);
        localIntent.putExtra("isDoubleVideoMeeting", paramBoolean2);
        localIntent.putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_Lfg.jdField_a_of_type_Long > 0L))) {
          localIntent.putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label699;
        }
        g();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString)) {
          break label656;
        }
        locallfe.jdField_d_of_type_JavaLangString = paramString2;
        a(paramLong, locallfe.jdField_d_of_type_JavaLangString, 0, 4);
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        return;
        localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), VideoInviteActivity.class);
        if (bgzw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
          localIntent.addFlags(262144);
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Boolean = true;
      locallfe.a("processVideoRequest.2", 0);
      locallfe.jdField_j_of_type_Int = paramInt1;
      locallfe.jdField_d_of_type_JavaLangString = paramString2;
      return;
      if (!locallfe.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "processVideoRequest block notify video msg");
    return;
    paramString1 = a();
    if (paramString1 != null)
    {
      paramInt1 = paramString1.a(lll.a(paramString2), false, true);
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, paramString2, paramInt1);
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
        if ((paramBoolean3) || (lde.a()))
        {
          paramString1 = new mfa(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localIntent);
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
          paramString1 = new mli(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localIntent);
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
    if ((localObject != null) && (1 == ((lll)localObject).a(mrr.a(paramString), false, false))) {
      mrr.a("0X800B62C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Muy.b(paramLong);
    localObject = this.jdField_a_of_type_Muy;
    muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 10, 1L);
      if ((a().jdField_d_of_type_JavaLangString == null) || (!a().jdField_d_of_type_JavaLangString.equals(paramString))) {
        break label319;
      }
      lii.a(a().b(), 38);
    }
    for (;;)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      h();
      j();
      if (!this.jdField_a_of_type_Lby.a()) {
        break;
      }
      absy.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label319:
      lii.a(a(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    lfe locallfe = this.jdField_a_of_type_Lbz.c(paramString1);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + locallfe + "]", new Throwable("打印调用栈"));
    int i1;
    String str;
    if ((locallfe != null) && ((!locallfe.ag) || (locallfe.jdField_c_of_type_Boolean)))
    {
      i1 = this.jdField_a_of_type_Lbz.c(paramString1).jdField_j_of_type_Int;
      str = locallfe.jdField_f_of_type_JavaLangString;
      if ((TextUtils.isEmpty(locallfe.jdField_d_of_type_JavaLangString)) || (!locallfe.jdField_d_of_type_JavaLangString.contains(paramString2))) {
        break label413;
      }
      paramString2 = locallfe.jdField_d_of_type_JavaLangString;
    }
    label413:
    for (;;)
    {
      if (this.jdField_a_of_type_Lby.a())
      {
        i1 = 9500;
        if (this.w) {
          i1 = 0;
        }
      }
      boolean bool = false;
      if (locallfe.jdField_f_of_type_Int == 2) {
        bool = true;
      }
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
      {
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        if ((paramInt == 12) && (!TextUtils.isEmpty(a().a()))) {
          a(paramString1, i1, 66, bool, paramString2, str, false);
        }
        if (!this.jdField_e_of_type_Boolean) {
          break label341;
        }
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, paramString2, str, 1, a().jdField_s_of_type_JavaLangString, false, true);
      }
      for (;;)
      {
        locallfe.ag = true;
        locallfe.jdField_c_of_type_Boolean = false;
        return;
        if (!locallfe.jdField_c_of_type_Boolean) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        label341:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_Lbz.c(paramString1).jdField_s_of_type_JavaLangString, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_Lbz.c(paramString1).jdField_s_of_type_JavaLangString, false, true);
        }
      }
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, mvk.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_Lbz.a(paramLong, paramString2);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((!this.jdField_e_of_type_Boolean) || (a().jdField_g_of_type_Long != paramLong) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
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
  
  public void a(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      lcu locallcu = new lcu();
      locallcu.jdField_a_of_type_Long = ((AVUserInfo)paramArrayList.get(i1)).account;
      locallcu.jdField_d_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).accountType;
      this.jdField_a_of_type_JavaUtilArrayList.add(locallcu);
      if (((AVUserInfo)paramArrayList.get(i1)).accountType == 1) {
        localArrayList.add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).account));
      }
      i1 += 1;
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_Lby.a(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate, size[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList<lob> paramArrayList, int paramInt, boolean paramBoolean)
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
            if (((lob)paramArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
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
          if (paramInt == ((lob)paramArrayList.get(i1)).jdField_a_of_type_Int)
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
  
  public void a(long paramLong, ArrayList<lob> paramArrayList1, ArrayList<lob> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList1.size()) {
        if (((lob)paramArrayList1.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((lob)paramArrayList1.get(i1)).jdField_a_of_type_Int)
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
      localObject = (lcu)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((lcu)localObject).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((lcu)localObject).jdField_a_of_type_Long);
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
      str = lbz.a(100, paramString1, new int[0]);
      lfe locallfe2 = this.jdField_a_of_type_Lbz.c(str);
      lfe locallfe1 = locallfe2;
      if (locallfe2 == null) {
        locallfe1 = this.jdField_a_of_type_Lbz.a(str, false);
      }
      locallfe1.jdField_j_of_type_Int = paramInt1;
      locallfe1.A = paramInt2;
      locallfe1.jdField_p_of_type_JavaLangString = paramString3;
      locallfe1.jdField_e_of_type_Boolean = true;
      paramInt1 = locallfe1.jdField_j_of_type_Int;
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
        l1 = mry.a(paramString1);
        a(paramLong, 3, l1);
        lbz.a().a(paramLong, str);
        return;
        str = lbz.a(3, paramString1, new int[0]);
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
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArrayList localArrayList = a(paramLong1, paramBoolean, paramLong2);
    if (localArrayList != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(142), localArrayList, Integer.valueOf(localArrayList.size()) });
    }
    if (paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
    {
      if (paramBoolean) {
        bdla.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      bdla.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (paramBoolean2) {
      if (a().H == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomMicModeChanged, manager uin[" + paramLong + "], old isRoomMicOff[" + a().W + "], new isRoomMicOff[" + paramBoolean1 + "], mIsMicOffBySelf[" + this.u + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], micAuthByAdmin[" + a().H + "], isCreateRoomOrEnterRoom[" + paramBoolean2 + "], bNeedUpdateMic[" + bool + "]");
      a().c("onGAudioRoomMicModeChanged", paramBoolean1);
      int i1;
      long l1;
      if ((bool) && (!this.u) && ((paramLong != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
      {
        i1 = f();
        l1 = this.jdField_a_of_type_Long;
        if (paramBoolean1) {
          break label279;
        }
      }
      label279:
      for (bool = true;; bool = false)
      {
        a("onGAudioRoomMicModeChanged", l1, bool, false, -1);
        a(-1L, i1, f());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        return;
        bool = false;
        break;
      }
      bool = true;
    }
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
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
      lcu locallcu = new lcu();
      locallcu.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(locallcu);
      paramInt2 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate, size[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1) });
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
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
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      return;
    }
    this.jdField_a_of_type_Lby.a(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApp().getApplicationContext();
    VideoController.3 local3 = new VideoController.3(this);
    paramVideoAppInterface.a().post(local3);
    if (!NetworkUtil.isNetSupport(a())) {
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      c();
      if ((this.jdField_i_of_type_Int == 0) && (lzr.e(paramVideoAppInterface.getApp()))) {
        this.jdField_i_of_type_Int = 1;
      }
      this.jdField_a_of_type_Muy = muy.a(this.jdField_a_of_type_AndroidContentContext, this);
      if (this.x) {
        K();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(0L, "qqVersion", AppSetting.a(a()));
      return;
      if (NetworkUtil.isWifiEnabled(a())) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 2;
      }
    }
  }
  
  public void a(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
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
      this.jdField_a_of_type_Lby.a(paramAVUserInfo.account);
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
      localObject1 = new lcu();
      ((lcu)localObject1).jdField_a_of_type_Long = paramAVUserInfo.account;
      ((lcu)localObject1).jdField_d_of_type_Int = paramAVUserInfo.accountType;
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
      localObject1 = (lcu)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
    }
    for (;;)
    {
      a(paramAVUserInfo.account, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      t();
      if ((localObject1 == null) || (((lcu)localObject1).jdField_e_of_type_Boolean) || (!((lcu)localObject1).jdField_g_of_type_Boolean)) {
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
  
  public void a(PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField1, PBRepeatMessageField<submsgtype0x116.MemberInfo> paramPBRepeatMessageField2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList updateMemberListWithPushMessage joins" + paramPBRepeatMessageField1.size() + ";quits size" + paramPBRepeatMessageField2.size() + ";eventType:=" + paramInt2);
    }
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(Long.valueOf(((lcu)((Iterator)localObject2).next()).jdField_a_of_type_Long));
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
        lcu locallcu = new lcu();
        locallcu.jdField_d_of_type_Int = 0;
        locallcu.jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        locallcu.jdField_h_of_type_Boolean = false;
        locallcu.jdField_d_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.jdField_b_of_type_JavaUtilArrayList.add(locallcu);
        paramInt1 = 1;
        i2 = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver add member UIN:" + locallcu.jdField_a_of_type_Long);
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
        localObject2 = (lcu)((Iterator)localObject1).next();
      } while (((lcu)localObject2).jdField_a_of_type_Long != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i1 = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver remove member UIN:" + ((lcu)localObject2).jdField_a_of_type_Long);
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
      a().ab = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    a().ab = false;
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
      } while ((!q()) && (this.jdField_a_of_type_Lbz.b()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mut.a(a()).b();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if (this.jdField_a_of_type_Lcc != null) {
      this.jdField_a_of_type_Lcc.b();
    }
    ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, paramString);
    this.jdField_h_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    if ((q()) && (paramInt != 110)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((lda)localObject).a(paramInt);
    }
    localObject = lbz.a().a().jdField_d_of_type_JavaLangString;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString))) {
      I();
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
      mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
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
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, long paramLong)
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
    if (paramString1.aj)
    {
      paramString1.aj = false;
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
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(paramString1, bool1);
      return;
      paramString2 = new VideoController.14(this, paramString1);
      this.jdField_a_of_type_JavaUtilList.add(paramString2);
      break;
      label329:
      bool1 = false;
      break label250;
      bool1 = bool2;
      if (paramString1.ai)
      {
        a(paramString1.jdField_d_of_type_JavaLangString, paramInt2, paramInt3, paramString2, paramLong);
        bool1 = true;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onPeerSwitchTerminal. fromUin = " + paramString + ", peerTerminalType = " + paramInt1 + ", peerSdkVersion = " + paramInt2 + ", roomId = " + paramLong);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    a().aj = true;
    paramString = lbz.a().a(paramString);
    if (paramString != null)
    {
      paramString.b(paramInt2);
      paramString.c(paramInt1);
      paramString.d(paramLong);
    }
    a("onPeerSwitchTerminal", a());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).c(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "onChannelReady, fromUin[" + paramString1 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    lfe locallfe = a();
    int i2 = locallfe.F;
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
      locallfe = a();
    }
    for (;;)
    {
      locallfe.x = paramInt1;
      locallfe.y = paramInt2;
      locallfe.jdField_n_of_type_JavaLangString = paramString2;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onChannelReady, fromUin[" + paramString1 + "], hdModeFreeUseStartTime[" + paramInt1 + "], hdModeFreeUseEndTime[" + paramInt2 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], session[" + locallfe + "]");
      lii.a(30);
      lii.a(9, locallfe.b());
      lii.a(11, locallfe.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mut.a(a()).a();
      if (1L == locallfe.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Muy.b(l1);
        if ((locallfe.S) && (locallfe.jdField_e_of_type_Boolean) && (!l())) {
          this.jdField_a_of_type_Muy.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        a(true, locallfe.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Muy.b(l1);
      if (locallfe.jdField_j_of_type_Int != 1011) {
        muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
      }
      locallfe.b(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
      locallfe.c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
      locallfe.d(paramLong);
      j();
      locallfe.jdField_h_of_type_Int = locallfe.jdField_g_of_type_Int;
      locallfe.a("onChannelReady", 4);
      locallfe.a(l1, SystemClock.elapsedRealtime());
      if ((locallfe.jdField_e_of_type_Boolean) && (!l()))
      {
        if (locallfe.S) {
          this.jdField_a_of_type_Muy.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        label501:
        if ((locallfe.jdField_d_of_type_Int == 1) && (locallfe.jdField_j_of_type_Int == 1011))
        {
          locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int = 5;
          a(locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int, 1, null);
        }
        paramString2 = (lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!locallfe.jdField_e_of_type_Boolean) {
          break label899;
        }
        paramInt1 = 11;
        label568:
        paramString2.a(locallfe.b(), paramInt1, 1L);
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
          if (l()) {
            a(l1, 2131230736, 1, null);
          }
        }
        b();
        if (!locallfe.jdField_g_of_type_Boolean) {
          break label904;
        }
        a(true, locallfe.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l1), 50L);
        a(locallfe.jdField_c_of_type_JavaLangString, locallfe.jdField_d_of_type_Int, true, true, true);
        msa.i(this);
        msa.c(this, true);
        msa.b(this, true);
        paramLong = f();
        paramString2 = bhhr.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        paramString2.edit().putLong("qav_roomid", paramLong).commit();
        paramLong = c(paramString1);
        paramString2.edit().putLong(lch.g, paramLong).commit();
        o(false);
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a();
        }
        if (this.jdField_a_of_type_Lcc != null) {
          this.jdField_a_of_type_Lcc.a();
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a(locallfe);
        }
        paramString1 = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
        if (paramString1 == null) {
          break;
        }
        paramString1.a(locallfe);
        return;
        if (this.jdField_a_of_type_Muy.a()) {
          break label501;
        }
        this.jdField_a_of_type_Muy.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label501;
        label899:
        paramInt1 = 4;
        break label568;
        label904:
        a(false, locallfe.jdField_d_of_type_JavaLangString);
      }
    }
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
    localObject3 = this.jdField_a_of_type_Lbz.c(paramString1);
    if (localObject3 == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      return;
    }
    if (paramInt2 == 21) {
      if ((((lfe)localObject3).jdField_i_of_type_Int == 11) || (((lfe)localObject3).jdField_i_of_type_Int == 12))
      {
        paramInt2 = 47;
        ((lfe)localObject3).a(1, 0);
        paramInt1 = 0;
      }
    }
    label523:
    label926:
    label933:
    for (;;)
    {
      boolean bool = false;
      if ((((lfe)localObject3).j()) && (paramInt2 == 1)) {
        bool = true;
      }
      label480:
      float f1;
      for (;;)
      {
        if (paramBoolean2) {
          bool = false;
        }
        ((Intent)localObject2).putExtra("uinType", paramInt1);
        ((Intent)localObject2).putExtra("msgType", paramInt2);
        ((Intent)localObject2).putExtra("isVideoMsg", paramBoolean1);
        ((Intent)localObject2).putExtra("isRead", bool);
        ((Intent)localObject2).putExtra("bindType", ((lfe)localObject3).A);
        ((Intent)localObject2).putExtra("bindId", ((lfe)localObject3).jdField_p_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("MultiAVType", ((lfe)localObject3).D);
        if (paramInt2 == 17) {
          ((Intent)localObject2).putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
          break label759;
        }
        if (paramInt2 == 20) {
          paramString3 = paramString1;
        }
        localObject1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          localObject1 = paramString1;
        }
        if (((lfe)localObject3).J)
        {
          if (!((lfe)localObject3).M) {
            break label831;
          }
          localObject1 = paramString1;
        }
        ((Intent)localObject2).putExtra("friendUin", paramString2);
        ((Intent)localObject2).putExtra("senderUin", (String)localObject1);
        ((Intent)localObject2).putExtra("selfUin", paramString1);
        if (((lfe)localObject3).jdField_e_of_type_Boolean) {
          break label838;
        }
        paramBoolean1 = true;
        ((Intent)localObject2).putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label900;
        }
        if (this.jdField_b_of_type_Long <= 0L) {
          break label889;
        }
        f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
        if (f1 >= 1024.0F) {
          break label844;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
        label607:
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
          break label933;
        }
        if ((((lfe)localObject3).jdField_i_of_type_Int == 16) || (((lfe)localObject3).jdField_i_of_type_Int == 17)) {}
        for (paramInt2 = 47;; paramInt2 = 48)
        {
          ((lfe)localObject3).a(1, 0);
          paramInt1 = 0;
          break;
        }
        if (((lfe)localObject3).l()) {
          bool = true;
        }
      }
      label759:
      if (paramInt1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label926;
        }
      }
      for (;;)
      {
        if (((lfe)localObject3).jdField_e_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          localObject1 = paramString3;
          paramString3 = paramString2;
          paramString2 = (String)localObject1;
          break;
        }
        if (((lfe)localObject3).jdField_e_of_type_Boolean) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        label831:
        localObject1 = paramString2;
        break label480;
        label838:
        paramBoolean1 = false;
        break label523;
        label844:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label607;
        label889:
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> return!  no to show net traffic tips msg in AIO");
        return;
        if (((lfe)localObject3).jdField_e_of_type_Long > 0L)
        {
          paramString1 = mvk.a(a());
          break label607;
        }
        paramString1 = null;
        break label607;
        paramString3 = paramString2;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.b();
    lfe locallfe = this.jdField_a_of_type_Lbz.b(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l1 + "], Main[" + this.jdField_a_of_type_Lbz.a() + "], come[" + locallfe + "]");
    if (locallfe == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], no session");
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lda)localObject).a(paramInt);
      }
      if (q()) {
        C();
      }
      ((mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15)).a(3, locallfe.jdField_d_of_type_JavaLangString);
      if (((locallfe.jdField_j_of_type_Int != 1011) && (locallfe.jdField_j_of_type_Int != 21)) || (!locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Boolean)) {
        break;
      }
      lbd.g(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Boolean);
      locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0, this);
    } while ((q()) && ((paramInt == 2) || (paramInt == 3)));
    d(paramInt);
    return;
    z(locallfe.jdField_c_of_type_JavaLangString);
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
        if (locallfe.jdField_d_of_type_Int != 2) {
          break label818;
        }
        bdla.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramInt == 49) {
          o(true);
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
          a(locallfe.jdField_j_of_type_Int, locallfe.jdField_d_of_type_JavaLangString, locallfe.jdField_i_of_type_Long, 0);
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
          if (locallfe.jdField_d_of_type_Int == 2)
          {
            bdla.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          bdla.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
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
          bdla.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
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
        bdla.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = lbz.a(3, paramString, new int[0]);
        locallfe = null;
        if (this.jdField_a_of_type_Lbz.a((String)localObject)) {
          locallfe = this.jdField_a_of_type_Lbz.c((String)localObject);
        }
        if ((locallfe != null) && (locallfe.jdField_g_of_type_Int == 1))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, set autoAcceptChat, seq[" + l1 + "]");
          locallfe.jdField_d_of_type_Boolean = true;
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
        locallfe.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 12);
        return;
      }
      if (paramLong == 61L)
      {
        locallfe.jdField_s_of_type_Boolean = false;
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
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
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
          else if (!a().ai) {
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
              bdla.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
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
      p(true);
      a().jdField_s_of_type_Boolean = false;
      a(a().jdField_d_of_type_JavaLangString, 210);
      b(210);
      this.jdField_h_of_type_JavaLangRunnable = new VideoController.20(this, l1);
    } while ((this.jdField_h_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    label405:
    label817:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_h_of_type_JavaLangRunnable, 2000L);
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
      if (AudioHelper.f()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStartVideoBroadcast, sessionId[" + paramString + "], sessionType[" + paramInt + "], updateTime[" + paramBoolean1 + "], showTime[" + paramBoolean2 + "], isDouble[" + paramBoolean3 + "]");
      }
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("sessionId", paramString);
      if (this.jdField_a_of_type_Lbz != null)
      {
        paramString = this.jdField_a_of_type_Lbz.c(paramString);
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
    paramString = lfx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus, fromUin[" + paramString + "], roomid[" + paramLong + "], type[" + paramInt + "], seq[" + l1 + "]");
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject = lbz.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_Lbz.c((String)localObject);
    if (localObject != null) {
      ((lfe)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
    }
    if ((paramInt != 0) && (!TextUtils.isEmpty(a().jdField_d_of_type_JavaLangString)) && ((!a().jdField_d_of_type_JavaLangString.equals(paramString)) || (a().jdField_d_of_type_Int == 0)))
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onOtherTerminalChatingStatus sendQueryRoomInfoRequest");
    }
    a(0, paramString, paramLong, paramInt);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onSDKCustomCommand uin=%s, cmd=%s, arg1=%s, arg2=%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    if (paramLong1 == 200L)
    {
      if (paramLong2 != 1L) {
        break label69;
      }
      ldd.a();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    ldd.a(paramLong3);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramLong, paramBoolean, false, -1);
  }
  
  public void a(String arg1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      a(??? + "_" + paramLong, paramBoolean1, paramBoolean2);
      if (paramBoolean1) {
        break label143;
      }
      paramBoolean2 = true;
      b("gAudioSetInput", paramBoolean2);
      if (paramInt != -1) {
        break label168;
      }
      if (!paramBoolean1) {
        break label149;
      }
      paramInt = 0;
    }
    label143:
    label149:
    label168:
    for (;;)
    {
      for (;;)
      {
        g("gAudioSetInput", paramInt);
        paramLong = mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
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
            a().jdField_a_of_type_Lff.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          a().jdField_a_of_type_Lff.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (a().jdField_a_of_type_Lff.jdField_a_of_type_Int != 3) {
          break;
        }
        lcu locallcu = a(paramString);
        if (locallcu != null)
        {
          locallcu.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lff.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lff.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    lbd.g(jdField_a_of_type_JavaLangString, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    lfe locallfe = null;
    if (this.jdField_a_of_type_Lbz != null) {
      locallfe = this.jdField_a_of_type_Lbz.c(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (String str = "mApp is null";; str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + locallfe + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (locallfe != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", locallfe.A);
    paramString1.putExtra("bindId", locallfe.jdField_p_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", locallfe.jdField_d_of_type_Int);
    paramString1.putExtra("isDoubleVideoMeeting", locallfe.J);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(lch.jdField_d_of_type_JavaLangString, locallfe.jdField_e_of_type_Long);
    paramString1.putExtra(lch.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
    paramString1.putExtra(lch.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", a());
    long l1 = 0L;
    if ((locallfe.jdField_d_of_type_Int == 1) || (locallfe.jdField_d_of_type_Int == 2)) {
      l1 = 1L;
    }
    if ((locallfe.jdField_d_of_type_Int == 3) || (locallfe.jdField_d_of_type_Int == 4)) {
      l1 = 2L;
    }
    paramString1.putExtra(lch.i, l1);
    if ((locallfe.jdField_d_of_type_Int == 1) || (locallfe.jdField_d_of_type_Int == 3)) {}
    for (l1 = 1L;; l1 = 0L)
    {
      paramString1.putExtra(lch.j, l1);
      if (this.jdField_a_of_type_Lbz.c(paramString2).l != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_Lbz.c(paramString2).l);
      }
      if (this.jdField_a_of_type_Lbz.c(paramString2).jdField_m_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_Lbz.c(paramString2).jdField_m_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_Lbz.c(paramString2).F);
        paramString1.putExtra("relationId", this.jdField_a_of_type_Lbz.c(paramString2).jdField_g_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label661;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        lls.a().a.a();
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
          a().jdField_a_of_type_Lff.g = paramString2;
        }
        lcu locallcu;
        for (;;)
        {
          if (a().jdField_a_of_type_Lff.jdField_a_of_type_Int != 3) {
            break label195;
          }
          locallcu = a(paramString1);
          if (locallcu == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          locallcu.jdField_b_of_type_JavaLangString = paramString2;
          return;
          a().jdField_a_of_type_Lff.jdField_f_of_type_JavaLangString = paramString2;
        }
        locallcu.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lff.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().T = paramBoolean;
    if (paramBoolean) {
      msa.o(this);
    }
    if (mtj.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      return;
    }
    a(false, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((this.jdField_e_of_type_Boolean != paramBoolean) || (this.jdField_b_of_type_Int != paramInt) || (this.jdField_a_of_type_Long != paramLong) || (QLog.isColorLevel())) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, String.format("updateCurJoinGRoomInfo, from[%s], [%s, %s, %s] --> [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
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
        localObject = (lcu)localIterator.next();
        if ((((lcu)localObject).jdField_d_of_type_Int == 1) && (((lcu)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((lcu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
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
  
  void a(lcu paramlcu, int paramInt)
  {
    paramlcu.jdField_b_of_type_Int = 0;
    paramlcu.jdField_b_of_type_Boolean = false;
    paramlcu.jdField_c_of_type_Boolean = false;
    paramlcu.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramlcu.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramlcu.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramlcu.jdField_b_of_type_Int = 1;
      return;
    }
    paramlcu.jdField_d_of_type_Boolean = true;
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
            z();
          }
          else
          {
            a("notifyAnotherSelfIsRing", false);
            if (a().jdField_P_of_type_Boolean)
            {
              if (this.jdField_g_of_type_JavaLangRunnable == null) {
                this.jdField_g_of_type_JavaLangRunnable = new VideoController.19(this);
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
        mtt localmtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localmtt != null) {
          localmtt.a(paramVarArgs.jdField_c_of_type_JavaLangString);
        }
        QLog.w(jdField_a_of_type_JavaLangString, 1, "closeMainSession, mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], isDoubleVideoMeeting[" + paramVarArgs.J + "], \nsession[" + paramVarArgs + "], \nseq[" + l1 + "]");
        if ((l()) || (m()))
        {
          g(true);
          return;
        }
        if ((paramVarArgs.jdField_d_of_type_Int != 3) && (paramVarArgs.jdField_d_of_type_Int != 4)) {
          break;
        }
      } while (!this.jdField_e_of_type_Boolean);
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
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(((lfe)localObject).jdField_b_of_type_Boolean).append("->").append(paramBoolean2).append("], deviceName[").append(((lfe)localObject).jdField_q_of_type_JavaLangString).append("], audioStateBeforePhoneCall[").append(((lfe)localObject).t).append("], mTraeHelper[");
    if (this.jdField_a_of_type_Muy != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Muy != null) {
        break;
      }
      return;
    }
    if ((((lfe)localObject).jdField_g_of_type_Int != 0) && (((lfe)localObject).jdField_g_of_type_Int != 5) && (((lfe)localObject).jdField_g_of_type_Int != 6) && (((lfe)localObject).jdField_b_of_type_Boolean != paramBoolean2))
    {
      ((lfe)localObject).jdField_b_of_type_Boolean = paramBoolean2;
      if (!paramBoolean2) {
        break label225;
      }
      this.jdField_a_of_type_Muy.b();
      ((lfe)localObject).t = ((lfe)localObject).jdField_q_of_type_JavaLangString;
    }
    while (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label225:
      if ("DEVICE_SPEAKERPHONE".equals(((lfe)localObject).t))
      {
        this.jdField_a_of_type_Muy.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else if ("DEVICE_EARPHONE".equals(((lfe)localObject).t))
      {
        this.jdField_a_of_type_Muy.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (((lfe)localObject).jdField_d_of_type_Int == 1) {}
        for (localObject = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; localObject = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
        {
          this.jdField_a_of_type_Muy.a((String)localObject);
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i1 = lls.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().jdField_B_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecordAudio=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
    if (paramInt1 == 100) {
      if ((this.jdField_a_of_type_ArrayOfMow != null) && (this.jdField_a_of_type_ArrayOfMow[0] != null)) {
        this.jdField_a_of_type_ArrayOfMow[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      if (mrt.a()) {
        mrt.a().a(paramArrayOfByte, paramInt1, paramInt2);
      }
      return;
      if (((paramInt1 == 3) || (paramInt1 == 0) || (paramInt1 == 8)) && (this.jdField_a_of_type_ArrayOfMow != null) && (this.jdField_a_of_type_ArrayOfMow[1] != null)) {
        this.jdField_a_of_type_ArrayOfMow[1].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(byte[] paramArrayOfByte, long paramLong)
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
  
  public void a(long[] paramArrayOfLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    if (str != null)
    {
      long l1 = mry.a(str);
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
    return (this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == paramInt) && (this.jdField_a_of_type_Long == paramLong);
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
    lfe locallfe = a();
    String str = lbz.a(3, paramString, new int[0]);
    if (TextUtils.equals(locallfe.jdField_c_of_type_JavaLangString, str)) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt == 1011) && (locallfe.jdField_j_of_type_Int == paramInt) && (TextUtils.equals(locallfe.jdField_d_of_type_JavaLangString, paramString)));
      paramInt = this.jdField_a_of_type_Lbz.a();
      if (paramInt >= 2)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDAV, to many session, reject. [" + paramInt + "]");
        return true;
      }
    } while ((!locallfe.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()));
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
    paramBoolean = this.jdField_a_of_type_Lby.a(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + lch.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      }
      if (this.jdField_a_of_type_Lbz.a() < 2) {
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
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((a().jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (a().jdField_a_of_type_Lff.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lff.jdField_a_of_type_Int == 3))
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
    else if (((a().jdField_g_of_type_Int == 7) && (this.jdField_d_of_type_Long != 0L)) || (a().jdField_g_of_type_Int == 14) || (a().jdField_g_of_type_Int == 13))
    {
      if (bool) {
        return false;
      }
    }
    else if (!this.jdField_e_of_type_Boolean)
    {
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (a().jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo  auto Accept");
        }
        if ((a().jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString.equals(paramString1))) {
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
          lbd.g(jdField_a_of_type_JavaLangString, "isRequestVideo when request: fromUin = " + paramString1);
          return false;
        }
        if (bool) {
          return false;
        }
      }
    }
    else if ((this.jdField_e_of_type_Boolean) || (a().jdField_g_of_type_Int == 8))
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo orientation: " + this.jdField_n_of_type_Int + ", isQQPaused: " + lch.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
    }
    return true;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {}
    lfe locallfe;
    do
    {
      String str;
      do
      {
        return false;
        str = lbz.a(100, String.valueOf(paramLong), new int[0]);
        locallfe = a();
      } while (TextUtils.equals(str, locallfe.jdField_c_of_type_JavaLangString));
      paramInt1 = this.jdField_a_of_type_Lbz.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDM, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!locallfe.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()));
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
        lcu locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((locallcu == null) || (locallcu.jdField_a_of_type_Long != paramLong)) {
          break label186;
        }
        locallcu.jdField_e_of_type_Boolean = paramBoolean;
        locallcu.jdField_d_of_type_Int = paramInt1;
        bool = locallcu.jdField_g_of_type_Boolean;
        if (paramBoolean)
        {
          locallcu.jdField_g_of_type_Boolean = false;
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
  
  boolean a(long paramLong, int paramInt, ArrayList<lob> paramArrayList)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramArrayList.size())
      {
        if ((((lob)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((lob)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
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
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "StopGVideo, from[" + paramString + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv() != 0)
      {
        if (a().jdField_c_of_type_JavaUtilArrayList.size() == 0) {
          a().a(l1, "StopGVideo", false, true);
        }
        bool = true;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
      return false;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    long l1 = a(paramString);
    boolean bool = a(b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()), b(paramString), l1, paramInt, paramLong);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "quaReport --> report result = " + bool + " | node = " + paramInt + " | timestamp = " + paramLong);
    return bool;
  }
  
  public boolean a(String paramString, lfe paramlfe)
  {
    boolean bool2;
    if (paramlfe == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i1 = paramlfe.e();
    long l1 = paramlfe.b();
    long l2 = paramlfe.g();
    long l3;
    if (i1 == 2)
    {
      l3 = a(paramlfe);
      if (l3 != paramlfe.b()) {
        paramlfe.d(l3);
      }
    }
    for (;;)
    {
      l3 = paramlfe.b();
      long l4 = paramlfe.g();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramlfe, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i1 == 1)
      {
        l3 = b(paramlfe);
        if (l3 != paramlfe.b()) {
          paramlfe.d(l3);
        }
      }
    }
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    lfe locallfe = a();
    String str;
    boolean bool;
    if (paramBoolean) {
      if (paramInt == 3)
      {
        str = lbz.a(100, paramString2, new int[0]);
        if (TextUtils.equals(locallfe.jdField_c_of_type_JavaLangString, str)) {
          break label231;
        }
        bool = lbz.a().b(str);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkMainSession, need reset main session, from[" + paramString1 + "], cur" + locallfe.jdField_c_of_type_JavaLangString + "], coming[" + str + "], ret[" + bool + "]");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMainSession, from[" + paramString1 + "], isFromMAVEngine[" + paramBoolean + "], relationType[" + paramInt + "], relationId[" + paramString2 + "], ret[" + bool + "]");
      }
      return bool;
      str = lbz.a(paramInt, paramString2, new int[0]);
      break;
      str = lbz.a(paramInt, paramString2, new int[0]);
      break;
      label231:
      bool = false;
    }
  }
  
  public boolean a(lfe paramlfe1, lfe paramlfe2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlfe1.jdField_d_of_type_JavaLangString);
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
          paramlfe2.a(paramLong1, paramlfe1.jdField_j_of_type_Boolean);
          a(paramString, paramlfe2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_e_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          }
          if (!paramlfe1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          int i1 = paramlfe1.jdField_d_of_type_Int;
          paramlfe2.aE = true;
          paramlfe2.jdField_d_of_type_JavaLangString = paramlfe1.jdField_d_of_type_JavaLangString;
          if ((paramlfe1.jdField_g_of_type_Int == 15) || (paramlfe1.jdField_K_of_type_Boolean)) {
            f(false);
          }
          paramlfe1.a(3, 12);
          if (i1 == 1)
          {
            paramlfe1.a(paramLong1, "onGAudioInvite.6", 3);
            paramlfe1.jdField_j_of_type_Int = mvk.c(paramInt);
            paramlfe1.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlfe1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlfe1.c("onGAudioInvite.1", 1);
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.a() <= 0) {
                break label522;
              }
              paramlfe1.d("onGAudioInvite3", mrr.a(paramlfe1.jdField_j_of_type_Int));
              localVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramlfe2 = mtt.a(localVideoAppInterface);
            int i2 = 0;
            if (paramlfe2 != null)
            {
              boolean bool2 = paramlfe2.a();
              i2 = bool2;
              if (bool2)
              {
                paramlfe2.a(paramlfe1.jdField_c_of_type_JavaLangString);
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
            paramlfe1.a(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i1 != 4) {
            break label510;
          }
        }
        catch (Exception paramlfe1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramlfe1.getMessage());
          }
          this.jdField_a_of_type_Lbz.a(paramLong1, paramString);
          return bool1;
        }
        paramlfe1.a(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label510:
        paramlfe1.a(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label522:
        if (localThrowable.isBackgroundStop)
        {
          paramlfe1.d("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          m(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramlfe1.L))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramlfe1.L + "], ret[" + bool1 + "], main[" + paramlfe1 + "], new[" + paramlfe2 + "]");
      }
      paramlfe1.L = false;
      if (!bool1) {
        break label559;
      }
    }
    label559:
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    String str = a(a().jdField_e_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->info=" + str);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      L();
      i1 = 0;
      if (i1 >= a().jdField_e_of_type_JavaUtilArrayList.size()) {
        break label334;
      }
      if (((lob)a().jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        a().jdField_e_of_type_JavaUtilArrayList.remove(i1);
      }
    }
    label140:
    label334:
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
            ArrayList localArrayList = new ArrayList(i1);
            int i2 = 0;
            for (;;)
            {
              if (i2 < i1)
              {
                localArrayList.add(a().jdField_e_of_type_JavaUtilArrayList.get(i2));
                i2 += 1;
                continue;
                i1 += 1;
                break;
                i1 = 9;
                break label140;
              }
            }
            a().jdField_e_of_type_JavaUtilArrayList = localArrayList;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoRecv(a().jdField_e_of_type_JavaUtilArrayList, paramBoolean) != 0) {
        paramBoolean = true;
      }
      do
      {
        return paramBoolean;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,ViewInfos=" + str);
        }
        a().jdField_e_of_type_JavaUtilArrayList.clear();
        return false;
        a().jdField_e_of_type_JavaUtilArrayList.clear();
        paramBoolean = bool;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=" + str);
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
          lcu locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(i3);
          if ((locallcu != null) && (locallcu.jdField_a_of_type_Long != mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
          {
            int i2 = i1;
            if (locallcu.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (locallcu.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            if (locallcu.jdField_c_of_type_Boolean) {
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
    lbd.g(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
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
  
  public int b(String paramString)
  {
    int i1 = -1;
    lfe locallfe = lbz.a().a(paramString);
    if ((locallfe != null) && (locallfe.d() != -1)) {
      i1 = locallfe.d();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
  }
  
  public int b(lfe paramlfe, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramlfe, paramString);
    }
    return -1;
  }
  
  public int b(boolean paramBoolean)
  {
    if ((a().l()) || (this.jdField_e_of_type_Boolean))
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
    return this.jdField_d_of_type_Long;
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
      long l1 = mry.a(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      lbd.h(jdField_a_of_type_JavaLangString, paramString.getMessage());
    }
    return -1L;
  }
  
  public long b(lfe paramlfe)
  {
    if (paramlfe == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramlfe.jdField_d_of_type_Int == 3) || (paramlfe.jdField_d_of_type_Int == 4)) && (paramlfe.b() == 0L))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramlfe.F, paramlfe.D, paramlfe.jdField_g_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramlfe.d(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramlfe.d(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramlfe.b();
  }
  
  public WatchTogetherMediaPlayCtrl b()
  {
    if (r()) {
      return this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl;
    }
    return null;
  }
  
  public ArrayList<lcu> b()
  {
    if ((AudioHelper.e()) && (mqh.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(mqh.jdField_a_of_type_JavaUtilArrayList);
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
        mtt localmtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((lfe)localObject2).jdField_e_of_type_Boolean) {
          break label306;
        }
        if (((lfe)localObject2).j())
        {
          if ((((lfe)localObject2).jdField_d_of_type_Int == 1) || (((lfe)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((lfe)localObject2).S) && (!((lfe)localObject2).J))
            {
              i1 = 56;
              if ((((lfe)localObject2).jdField_j_of_type_Int != 1011) && (!l())) {
                break label372;
              }
              i1 = ((lfe)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label665;
              }
              if (((lfe)localObject2).F != 7) {
                break label695;
              }
              i1 = i2;
              if (((lfe)localObject2).jdField_a_of_type_Lff.jdField_b_of_type_Int <= 4) {
                break label344;
              }
              i2 = 52;
              if (this.jdField_f_of_type_Boolean)
              {
                i2 = 60;
                s();
              }
              localmtt.a(((lfe)localObject2).jdField_c_of_type_JavaLangString, "", null, null, i2, ((lfe)localObject2).jdField_j_of_type_Int, i1);
              r();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((lfe)localObject2).jdField_g_of_type_Long);
          localObject4 = ((lfe)localObject2).jdField_d_of_type_JavaLangString;
          localObject2 = ((lfe)localObject2).jdField_c_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localmtt.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.12(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((lfe)localObject2).jdField_d_of_type_Int != 1) {
          break label671;
        }
      }
      finally {}
      int i1 = 47;
      label306:
      if (((lfe)localObject2).l())
      {
        if (((lfe)localObject2).jdField_d_of_type_Int != 1) {
          break label680;
        }
        i1 = 47;
      }
      else
      {
        if (((lfe)localObject2).jdField_d_of_type_Int != 1) {
          break label689;
        }
        i1 = 46;
        break label686;
        label344:
        localObject1.a(((lfe)localObject2).jdField_c_of_type_JavaLangString, "", null, null, 51, ((lfe)localObject2).jdField_j_of_type_Int, i1);
        s();
        continue;
        label372:
        if ((((lfe)localObject2).jdField_d_of_type_Int == 3) || (((lfe)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((lfe)localObject2).J)
          {
            localObject3 = ((lfe)localObject2).jdField_e_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((lfe)localObject2).jdField_d_of_type_JavaLangString, null, true, true);
            localObject1.a(((lfe)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lfe)localObject2).jdField_g_of_type_Long), 48, 0, ((lfe)localObject2).jdField_d_of_type_Int);
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a().jdField_j_of_type_Int, String.valueOf(a().jdField_g_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lfe)localObject2).jdField_j_of_type_Int, String.valueOf(((lfe)localObject2).jdField_g_of_type_Long), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((lfe)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lfe)localObject2).jdField_g_of_type_Long), 44, ((lfe)localObject2).jdField_j_of_type_Int, ((lfe)localObject2).jdField_d_of_type_Int);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this), 1000L);
          continue;
        }
        if (((lfe)localObject2).jdField_e_of_type_JavaLangString == null) {
          ((lfe)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(((lfe)localObject2).jdField_j_of_type_Int, ((lfe)localObject2).jdField_d_of_type_JavaLangString, ((lfe)localObject2).jdField_f_of_type_JavaLangString);
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lfe)localObject2).jdField_j_of_type_Int, ((lfe)localObject2).jdField_d_of_type_JavaLangString, ((lfe)localObject2).jdField_f_of_type_JavaLangString, true, true);
        localObject1.a(((lfe)localObject2).jdField_c_of_type_JavaLangString, ((lfe)localObject2).jdField_e_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((lfe)localObject2).jdField_j_of_type_Int, ((lfe)localObject2).jdField_d_of_type_Int);
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
  
  public void b(int paramInt, long paramLong)
  {
    String str = lbz.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = lbz.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_a_of_type_Lbz.a(str)) {}
    for (Object localObject = this.jdField_a_of_type_Lbz.c(str);; localObject = null)
    {
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, relationType[" + paramInt + "], seq[" + l1 + "], sessionId[" + str + "], \nsession[" + localObject + "]");
      }
      if (localObject == null) {}
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Muy != null) {
            this.jdField_a_of_type_Muy.b(l1);
          }
          muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          muy.a().b();
          if ((AudioHelper.f()) || (((lfe)localObject).ar)) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, \nmainsession[" + a() + "], \nstate[" + ((lfe)localObject).jdField_g_of_type_Int + "], seq[" + l1 + "], isAcceptingMultiAV[" + ((lfe)localObject).ar + "], isCurJoinedGRoom[" + a(paramInt, paramLong) + "]");
          }
        } while (((lfe)localObject).ar);
        if (this.jdField_d_of_type_Long == paramLong)
        {
          this.jdField_d_of_type_Long = 0L;
          this.jdField_h_of_type_Int = 0;
        }
        if ((paramInt != 3) || (!((lfe)localObject).J) || ((((lfe)localObject).jdField_d_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((lfe)localObject).jdField_d_of_type_JavaLangString).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((lfe)localObject).jdField_d_of_type_JavaLangString + " ,relationId = " + paramLong);
      return;
      if ((!((lfe)localObject).ah) && (!((lfe)localObject).J))
      {
        int i1 = 6;
        if (((lfe)localObject).jdField_g_of_type_Int == 7) {
          i1 = 5;
        }
        a("onGAudioRoomDestroy", str, mvk.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((lfe)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
      if (a(paramInt, paramLong)) {
        a(paramInt, paramLong, 69);
      }
      ((lfe)localObject).a("onGAudioRoomDestroy", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_a_of_type_Lbz.a(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_Lbz.c(str);
          paramInt = mvk.c(paramInt);
          a(((lfe)localObject).jdField_c_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_a_of_type_Lbz.a(l1, str))
        {
          localObject = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject != null) && (((mtt)localObject).a()))
          {
            ((mtt)localObject).a(str);
            b();
          }
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      q();
      return;
    }
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    lfe locallfe = a();
    if (locallfe.ao) {}
    while (locallfe.b(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < locallfe.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((lob)locallfe.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((lob)locallfe.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((lob)locallfe.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupVideoClosed, relationId[" + paramLong + "], reason[" + paramInt2 + "], avtype[" + paramInt3 + "], bKickout[" + this.v + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    if (this.v) {
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {
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
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    a().a(l1, "onGaGoOffStageResult", false, false);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l1) });
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
    String str = bhml.a(l1, 3);
    if (new File(str).exists())
    {
      muy.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_f_of_type_Boolean = true;
      int i1 = a().jdField_p_of_type_Int;
      bdla.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    muy.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
    a().jdField_f_of_type_Boolean = true;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_Lbz.a();
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
      localObject1 = lbz.a(100, String.valueOf(paramLong), new int[0]);
      this.jdField_a_of_type_Lbz.a((String)localObject1, false);
      lch.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
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
      this.jdField_a_of_type_Lbz.c((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
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
      Object localObject2 = this.jdField_a_of_type_Lbz.c((String)localObject1);
      if (localObject2 != null)
      {
        ((lfe)localObject2).S = true;
        ((lfe)localObject2).jdField_f_of_type_Int = 2;
        ((lfe)localObject2).jdField_j_of_type_Int = 0;
        ((lfe)localObject2).F = 3;
        ((lfe)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        ((lfe)localObject2).jdField_f_of_type_JavaLangString = null;
        ((lfe)localObject2).jdField_e_of_type_Boolean = true;
        ((lfe)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
        ((lfe)localObject2).e("onDoubleVideoMeetingInvite", true);
        ((lfe)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong);
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
      new bkxc(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_Lbz.a(l1, (String)localObject1);
      return;
      if ((a().o()) || (a().p()) || (a().q()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_d_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_Lbz.c((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
          n(true);
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.jdField_n_of_type_Int + "], isQQPaused[" + lch.jdField_b_of_type_Boolean + "], isVideoPaused[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(a()) + "], seq[" + l1 + "]");
    }
    if ((this.x) && (this.jdField_n_of_type_Int == 0) && (!bool2) && (lch.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.25(this, l1, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l1, (String)localObject1, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onKickOutFail, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], errCode[" + paramInt3 + "], strMsg[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(518), Boolean.valueOf(false), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (a(a().jdField_d_of_type_JavaLangString) == paramLong2) {
      a().an = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRecvAudioReady uin = " + paramLong1 + ",roomid = " + paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
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
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInviteRespFail, groupId[" + paramLong1 + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], err[" + paramLong2 + "], msg[" + paramString + "]");
    if (paramLong1 == this.jdField_a_of_type_Long) {
      QQToast.a(a(), 2131695420, 1).a();
    }
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<lny> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.30(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = lbz.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_Lbz.a(str)) {}
      for (lfe locallfe = this.jdField_a_of_type_Lbz.c(str); locallfe == null; locallfe = this.jdField_a_of_type_Lbz.c(str))
      {
        QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        lii.a(0L, 33);
        lii.b(0L);
        return;
        str = lbz.a(100, paramString, new int[0]);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lkf)localObject).a(locallfe);
      }
      lii.a(locallfe.b(), 16, 0L);
      lii.a(locallfe.b(), 33);
      lii.b(locallfe.b());
      localObject = (lik)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (locallfe.jdField_e_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((lik)localObject).a(locallfe.b(), i2, i1 + 500);
        ((lik)localObject).a("NoCrash");
        ((lik)localObject).a(locallfe.b(), 29, 1L);
        ((lik)localObject).a(36, 1L);
        ((lik)localObject).b(locallfe.b());
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + locallfe.f() + "], sessionInfo.peerUin[" + locallfe.jdField_d_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + locallfe.S + "], sessionInfo.SessionType[" + locallfe.jdField_d_of_type_Int + "], mNetTrafficAllSize[" + this.jdField_b_of_type_Long + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!locallfe.f()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((locallfe.jdField_d_of_type_Int == 2) && (!locallfe.J) && (locallfe.jdField_g_of_type_Int >= 4) && (locallfe.jdField_e_of_type_Long > 0L))
      {
        i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
        lbd.g(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + locallfe.jdField_e_of_type_Long + " | " + locallfe.jdField_g_of_type_Int + " | " + locallfe.u);
        if ((locallfe.u) || (i2 > 0)) {
          bdla.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_s_of_type_Boolean) && (a() > 0L))
      {
        if (locallfe.jdField_d_of_type_Int == 1) {
          bdla.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", mvk.a(a()), "");
        }
      }
      else
      {
        label763:
        locallfe.jdField_d_of_type_Long = 0L;
        locallfe.jdField_o_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(locallfe.jdField_d_of_type_JavaLangString))
        {
          localObject = paramString;
          if (locallfe.jdField_d_of_type_JavaLangString.contains(paramString)) {
            localObject = locallfe.jdField_d_of_type_JavaLangString;
          }
        }
        if ((locallfe.o()) || (locallfe.p())) {
          locallfe.z = i1;
        }
        if ((locallfe.h()) || ((locallfe.j()) && (i1 == locallfe.z))) {
          locallfe.a(paramLong, 0L);
        }
        if ((locallfe.ai) && (this.jdField_f_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1585;
        }
        paramBoolean = false;
        if (locallfe.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(locallfe.jdField_c_of_type_JavaLangString, locallfe.jdField_j_of_type_Int, paramBoolean, locallfe.jdField_d_of_type_JavaLangString, locallfe.jdField_f_of_type_JavaLangString);
        label949:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_Lbz.a())
        {
          h();
          j();
          s();
        }
        locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Boolean = false;
        locallfe.jdField_a_of_type_Lff.jdField_a_of_type_JavaLangString = null;
        locallfe.jdField_a_of_type_Lff.jdField_b_of_type_JavaLangString = null;
        locallfe.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          msa.b(this, false);
          msa.c(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            msa.l(this);
          }
        }
        locallfe.a("doCloseSession", 0);
        locallfe.a(paramLong, "doCloseSession", 0);
        locallfe.jdField_f_of_type_Int = 0;
        locallfe.jdField_a_of_type_JavaUtilBitSet.clear();
        locallfe.jdField_j_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        locallfe.av = false;
        locallfe.jdField_a_of_type_ArrayOfJavaLangString = null;
        locallfe.b("doCloseSession", null);
        locallfe.jdField_p_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + locallfe.jdField_j_of_type_Int + " # matchStatus = " + locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (i1 != 72) && (locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          locallfe.jdField_j_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1599;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1261:
        if ((locallfe.jdField_j_of_type_Int != 1011) || ((locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int != 2) && (locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int != 6))) {
          break label1626;
        }
        if ((!this.jdField_f_of_type_Boolean) && (locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int != 6)) {
          break label1609;
        }
        a(6, 1, null);
        label1325:
        this.jdField_a_of_type_Boolean = false;
        label1330:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((locallfe.jdField_a_of_type_Lff.jdField_a_of_type_Int == 1) || (locallfe.jdField_a_of_type_Lff.jdField_a_of_type_Int == 2)))
        {
          locallfe.a();
          a(0, 0, null);
        }
        locallfe.a(paramLong, false);
        locallfe.b(paramLong, false);
        locallfe.a(paramLong, 0L);
        locallfe.b(paramLong);
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1644;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_Lbz.a(paramLong, str);
      }
      for (;;)
      {
        paramString = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str);
        if (!paramBoolean) {
          break;
        }
        b();
        return;
        if (locallfe.jdField_d_of_type_Int != 2) {
          break label763;
        }
        bdla.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", mvk.a(a()), "");
        break label763;
        label1585:
        a(paramLong, str, (String)localObject, i1);
        break label949;
        label1599:
        if (!this.jdField_a_of_type_Boolean) {
          break label1261;
        }
        break label1261;
        label1609:
        a(locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int, 1, null);
        break label1325;
        label1626:
        if (!this.jdField_f_of_type_Boolean) {
          break label1330;
        }
        a(6, 1, null);
        break label1330;
        label1644:
        this.jdField_a_of_type_Lbz.a(str, 3);
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
    muy.a().b(l1);
    muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (d(paramString)) {
      muy.a().b();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "closeSession", new Throwable("closeSession"));
    }
    b(l1, paramString, paramInt, false);
  }
  
  public void b(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    paramLong = AudioHelper.b();
    if ((paramInt == 1) && (1L == a().jdField_d_of_type_Long))
    {
      a().jdField_d_of_type_Long = 0L;
      a(paramLong);
    }
  }
  
  public void b(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.receiveTransferMsg(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(122), paramString });
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioMute, [" + this.jdField_l_of_type_Boolean + " --> " + paramBoolean + "], from[" + paramString + "]");
    }
    this.jdField_l_of_type_Boolean = paramBoolean;
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
  
  public void b(ArrayList<nbr> paramArrayList)
  {
    String str;
    StringBuilder localStringBuilder;
    boolean bool;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("onGAudioInviteResp, avInviteAccountList[");
      if (paramArrayList == null) {
        break label78;
      }
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], size[");
      if (paramArrayList != null) {
        break label83;
      }
    }
    label78:
    label83:
    for (int i1 = 0;; i1 = paramArrayList.size())
    {
      QLog.w(str, 1, i1 + "]");
      if (paramArrayList != null) {
        break label91;
      }
      return;
      bool = false;
      break;
    }
    label91:
    if (a().jdField_a_of_type_JavaUtilArrayList != null)
    {
      i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if ((((nbr)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((nbr)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((nbr)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
          a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((nbr)paramArrayList.get(i1)).jdField_a_of_type_Long));
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(99) });
  }
  
  public void b(boolean paramBoolean)
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
  
  public void b(byte[] paramArrayOfByte)
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
    lfe locallfe;
    do
    {
      do
      {
        return false;
        locallfe = this.jdField_a_of_type_Lbz.a();
      } while ((locallfe.F == paramInt1) && (locallfe.jdField_g_of_type_Long == paramLong));
      paramInt1 = this.jdField_a_of_type_Lbz.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!locallfe.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.k()));
    QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
    return true;
  }
  
  public boolean b(String paramString)
  {
    int i1 = b(paramString);
    return (i1 == 5) || (i1 == 14);
  }
  
  public boolean b(lfe paramlfe1, lfe paramlfe2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlfe1.jdField_d_of_type_JavaLangString);
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
          paramlfe2.a(paramLong1, paramlfe1.jdField_j_of_type_Boolean);
          a(paramString, paramlfe2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramlfe1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          i1 = paramlfe1.jdField_d_of_type_Int;
          paramlfe2.jdField_d_of_type_JavaLangString = paramlfe1.jdField_d_of_type_JavaLangString;
          paramlfe2.a(paramLong1, paramlfe1.jdField_j_of_type_Boolean);
          paramlfe2.jdField_g_of_type_Boolean = paramlfe1.jdField_g_of_type_Boolean;
          paramlfe2.b("onGAudioInvite", paramlfe1.jdField_P_of_type_Boolean);
          paramlfe2.b("onGAudioInvite", paramlfe1.jdField_q_of_type_JavaLangString);
          paramlfe2.aE = true;
          paramlfe2.a(3, 12);
          paramlfe1.a(3, 12);
          b(paramlfe1.jdField_d_of_type_JavaLangString, 21);
          if (i1 == 1)
          {
            paramlfe2.a(paramLong1, "onGAudioInvite.2", 3);
            paramlfe2.jdField_j_of_type_Int = mvk.c(paramInt);
            paramlfe2.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlfe2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlfe2.c("onGAudioInvite.2", 1);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
              break label547;
            }
            paramlfe2.d("onGAudioInvite1", mrr.a(paramlfe2.jdField_j_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramlfe1 = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            int i2 = 0;
            if (paramlfe1 != null)
            {
              boolean bool2 = paramlfe1.a();
              i2 = bool2;
              if (bool2)
              {
                paramlfe1.a(paramString);
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
        catch (Exception paramlfe1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramlfe1);
          }
          this.jdField_a_of_type_Lbz.a(paramLong1, paramString);
          return bool1;
        }
        if (i1 == 2)
        {
          paramlfe2.a(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i1 == 4)
        {
          paramlfe2.a(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramlfe2.a(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label547:
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop)
          {
            paramlfe2.d("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            m(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramlfe1 != paramlfe2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramlfe1 + "], new[" + paramlfe2 + "]");
      }
      if (!bool1) {
        break label586;
      }
      if (paramlfe1.z != 0) {
        break label164;
      }
      paramlfe1.a("onGAudioInvite.2", 0);
      this.jdField_a_of_type_Lbz.a(paramLong1, paramString);
      return bool1;
    }
    label586:
    return false;
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
    return leu.a();
  }
  
  public int c(String paramString)
  {
    int i1 = -1;
    lfe locallfe = lbz.a().a(paramString);
    if ((locallfe != null) && (locallfe.c() != -1)) {
      i1 = locallfe.c();
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
  
  public ArrayList<lcu> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.e()) && (mqh.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(mqh.jdField_a_of_type_JavaUtilArrayList);
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
      this.jdField_d_of_type_JavaLangRunnable = new VideoController.15(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 20000L);
      }
    }
  }
  
  public void c(int paramInt)
  {
    lfe locallfe = a();
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", locallfe.jdField_j_of_type_Int);
      localIntent.putExtra("peerUin", locallfe.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("extraUin", locallfe.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("relationType", locallfe.F);
      if ((locallfe.jdField_g_of_type_Long != 0L) || (locallfe.jdField_j_of_type_Int != 0)) {
        break label259;
      }
      localIntent.putExtra("relationId", mrr.a(locallfe.jdField_d_of_type_JavaLangString));
    }
    for (;;)
    {
      localIntent.putExtra("isDoubleVideoMeeting", locallfe.J);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "sendAvSwitchBroadcast, sessionType[" + paramInt + "], peer[" + locallfe.jdField_d_of_type_JavaLangString + "], type[" + locallfe.jdField_d_of_type_Int + "], uinType[" + locallfe.jdField_j_of_type_Int + "], relationType[" + locallfe.F + "], relationId[" + locallfe.jdField_g_of_type_Long + "]");
      }
      return;
      label259:
      localIntent.putExtra("relationId", locallfe.jdField_g_of_type_Long);
    }
  }
  
  void c(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaRoomSettingChanged-->relationType = " + paramInt1 + " relationUin = " + paramLong + " changedType = " + paramInt2);
    }
    if (paramInt2 == 102) {
      a().Y = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        a().Y = false;
      }
    }
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaSwitchVideoResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], seq[" + l1 + "]");
    }
    if (paramInt1 == 96) {
      if (a().jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        a().a(l1, "onGaSwitchVideoResult", true, true);
        this.jdField_d_of_type_Boolean = true;
        int i2 = 0;
        if (i2 < a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject = (lob)a().jdField_c_of_type_JavaUtilArrayList.get(i2);
          int i1;
          if (a()) {
            if (((lob)localObject).jdField_a_of_type_Int == 1)
            {
              i1 = 1;
              label178:
              if ((((lob)localObject).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (i1 == 0)) {
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
            if (a(((lob)localObject).jdField_a_of_type_Long, ((lob)localObject).jdField_a_of_type_Int, a().jdField_e_of_type_JavaUtilArrayList)) {
              ((lob)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((lob)localObject).jdField_b_of_type_Boolean = false;
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
      this.jdField_d_of_type_Boolean = false;
      a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), true, true);
      a().jdField_e_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    lbd.f(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6009), Integer.valueOf(paramInt), paramString });
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
  
  public void c(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioKickOut, Groupid[" + paramLong + "], relationType[" + paramInt1 + "], seq[" + l1 + "]");
    paramInt2 = mvk.c(paramInt1);
    if ((this.jdField_e_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
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
      bdla.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().J) {
        bdla.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      lfe locallfe = a();
      if ((locallfe != null) && (locallfe.jdField_j_of_type_Boolean)) {
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
          bdla.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          bdla.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    lfe locallfe = a();
    int i1;
    if ((!TextUtils.isEmpty(locallfe.jdField_d_of_type_JavaLangString)) && ((!locallfe.jdField_d_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (locallfe.jdField_d_of_type_Int == 0)))
    {
      i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo1, result[" + i1 + "]");
      return;
    }
    if ((this.jdField_a_of_type_Lbz.a() == 0) && (TextUtils.isEmpty(locallfe.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(locallfe.jdField_d_of_type_JavaLangString)))
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
    GraphicRenderMgr.getInstance();
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTerminalFail fromUin = " + paramString + ", info :" + paramInt);
    }
    a("onPeerSwitchTerminalFail", a());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ScreenShareCtrl localScreenShareCtrl = a();
    if (localScreenShareCtrl != null) {
      localScreenShareCtrl.a(paramString, paramArrayOfByte, paramLong);
    }
  }
  
  public void c(boolean paramBoolean)
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
          VcControllerImpl localVcControllerImpl = new VcControllerImpl(a(), (String)localObject, this.jdField_a_of_type_Lby, this);
          ClientLogReport.instance().setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          long l1 = mry.a(str3);
          String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = QQDeviceInfo.getIMEI("62ad83");
          int i2 = bhyk.a(str3);
          str3 = DeviceInfoUtil.getIMSI();
          String str4 = str3 + "," + i2;
          String str5 = Build.HARDWARE + "_" + llq.a();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(i2), str4, str5 }));
          }
          localVcControllerImpl.init(a(), l1, "8.4.10", Build.MODEL, (String)localObject, str1, AppSetting.d(), str2, llq.b(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, llq.d(), i1, str4, new llm().a(), mtr.a(l1), mtr.b(l1), str5);
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
        break label436;
      }
      return true;
      localObject = new String((byte[])localObject);
    }
    label436:
    return false;
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public boolean c(boolean paramBoolean)
  {
    lbd.g(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
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
  
  public int d()
  {
    return c();
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
        lcu locallcu = (lcu)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = String.valueOf(locallcu.jdField_a_of_type_Long);
        localArrayList2.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new VideoController.16(this);
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
      lbd.g(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_f_of_type_Int);
      return;
    }
    if (muy.a() != null) {
      muy.a().a(l1);
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    Object localObject = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((mtt)localObject).a();
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
        lbd.h(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 == 108)
    {
      a().aa = true;
      locallfe = a();
      if (!h())
      {
        bool = true;
        locallfe.Z = bool;
        i1 = f();
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, f());
      }
    }
    while (!a().aa) {
      for (;;)
      {
        lfe locallfe;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
        return;
        boolean bool = false;
      }
    }
    a().aa = false;
    int i1 = f();
    if (a().Z) {
      a("onMVSpeakModeChanged_2", this.jdField_a_of_type_Long, true, false, -1);
    }
    for (;;)
    {
      a(-1L, i1, f());
      break;
      a("onMVSpeakModeChanged_3", this.jdField_a_of_type_Long, false, false, -1);
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    lbd.g(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void d(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onSetMicBySelf uin = " + paramLong);
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lcu locallcu = (lcu)localIterator.next();
        if (locallcu.jdField_a_of_type_Long == paramLong) {
          if (!locallcu.jdField_f_of_type_Boolean)
          {
            locallcu.jdField_f_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
          }
        }
      }
      return;
    }
  }
  
  public void d(long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      a().X = true;
      d(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      a().jdField_K_of_type_Int = paramInt2;
      d(paramInt1, paramLong, paramInt2);
      return;
    }
    c(paramInt1, paramLong, paramInt2);
  }
  
  public void d(String paramString)
  {
    a().a("onAcceptedVideo", 3);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (!a().ai)
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
    if (a().ak)
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
  
  public void d(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = AudioHelper.b();
    paramArrayOfByte = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchGroup, fromUin[" + paramString + "], flag[" + paramLong + "], seq[" + l1 + "]");
    if ((paramArrayOfByte.jdField_d_of_type_Int == 3) || (paramArrayOfByte.jdField_d_of_type_Int == 4)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.jdField_d_of_type_JavaLangString))) {
      return;
    }
    m(true);
    if (!paramArrayOfByte.b()) {
      a(l1, 2131230736, 1, null);
    }
    paramArrayOfByte.d("onSwitchGroup", mrr.a(paramArrayOfByte.jdField_j_of_type_Int));
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(2, 11);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
    c();
  }
  
  public void d(boolean paramBoolean)
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
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lbz.a().jdField_e_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lbz.a().jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_Lbz.a().jdField_d_of_type_Int != 2)) {
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
      if (this.jdField_a_of_type_Lbz.a().jdField_d_of_type_Int == 0) {
        if (this.jdField_a_of_type_Lbz.a().jdField_f_of_type_Int != 1)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Lbz.a().jdField_f_of_type_Int != 2) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Lby.jdField_a_of_type_Int;
  }
  
  public int e(String paramString)
  {
    paramString = a();
    if ((paramString != null) && (paramString.jdField_c_of_type_Boolean)) {
      return 1;
    }
    return 0;
  }
  
  public long e()
  {
    long l1 = 0L;
    if ((a().jdField_d_of_type_Int == 3) || (a().jdField_d_of_type_Int == 4)) {
      l1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEnterRoomTime();
    }
    return l1;
  }
  
  public ArrayList<lcu> e()
  {
    if ((AudioHelper.e()) && (mqh.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(mqh.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void e()
  {
    long l1 = AudioHelper.b();
    if (this.jdField_f_of_type_JavaLangRunnable == null)
    {
      this.jdField_f_of_type_JavaLangRunnable = new VideoController.17(this, l1);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_f_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 15000L);
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void e(int paramInt1, long paramLong, int paramInt2)
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
      ((lfe)localObject1).jdField_O_of_type_Boolean = true;
      ((lfe)localObject1).jdField_a_of_type_JavaUtilArrayList.clear();
      if ((mrr.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
      label779:
      for (;;)
      {
        a("onCreateRoomSuc");
        a("onCreateSuc", true, paramInt1, paramLong);
        ((lfe)localObject1).ar = false;
        if (((lfe)localObject1).J)
        {
          ((lfe)localObject1).d("onCreateRoomSuc", true);
          ((lfe)localObject1).M = true;
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
          ((lkf)localObject2).a(a());
        }
        if ((!((lfe)localObject1).J) && (((lfe)localObject1).F != 3)) {
          break;
        }
        localObject2 = a();
        if (localObject2 == null) {
          break;
        }
        ((ScreenShareCtrl)localObject2).a((lfe)localObject1);
        return;
        int i1;
        int i2;
        if (((lfe)localObject1).jdField_ad_of_type_Int == 5)
        {
          i1 = ((lfe)localObject1).d();
          i2 = ((lfe)localObject1).c();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onCreateRoomSuc, double meeting, terminalType[" + i1 + "], sdkVersion[" + i2 + "]");
          }
          long l2;
          if ((i1 == 2) || (i1 == 12) || ((i1 == 4) && (i2 >= 114)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lfe)localObject1).jdField_g_of_type_Long;
            i1 = ((lfe)localObject1).jdField_ad_of_type_Int;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lfe)localObject1).jdField_g_of_type_Long;
            i1 = ((lfe)localObject1).jdField_ad_of_type_Int;
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((lfe)localObject1).jdField_ad_of_type_Int, 0);
        }
        else
        {
          if (AudioHelper.a(19) == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label779;
            }
            AudioHelper.a(anvx.a(2131715481));
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((lfe)localObject1).jdField_ad_of_type_Int, 0);
            break;
          }
        }
      }
    }
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
  
  public void e(long paramLong)
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
  
  public void e(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject = a();
    if (a("onEnterSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject = a();
    }
    QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "onEnterSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], MainSession[" + localObject + "], seq[" + l1 + "]");
    a("onEnterSuc");
    ((lfe)localObject).ar = false;
    if (paramInt1 == 3)
    {
      ((lfe)localObject).a("onEnterSuc.1", 14);
      ((lfe)localObject).d("onEnterSuc", true);
      ((lfe)localObject).a(l1, SystemClock.elapsedRealtime());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l1) });
      if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.35(this, paramInt1, paramInt2, paramLong));
        }
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lkf)localObject).a(a());
      }
      return;
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject = lbz.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = lbz.a().c((String)localObject);
      if (localObject != null)
      {
        ((lfe)localObject).jdField_V_of_type_Boolean = true;
        ((lfe)localObject).jdField_O_of_type_Boolean = false;
        ((lfe)localObject).aD = true;
      }
      if ((mrr.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
    }
  }
  
  public void e(String paramString)
  {
    lfe locallfe = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallfe.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallfe.S + "], seq[" + l1 + "]");
    if (lsq.a(BaseApplication.getContext()) == 1) {
      locallfe.b(l1, false);
    }
    while ((locallfe.jdField_d_of_type_Int != 2) || (!locallfe.jdField_k_of_type_Boolean)) {
      return;
    }
    locallfe.b(l1, false);
    if (!locallfe.jdField_j_of_type_Boolean)
    {
      locallfe.S = true;
      locallfe.a(l1, "onPauseVideo", 1);
      c(locallfe.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    msa.n(this);
  }
  
  public void e(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public int f()
  {
    return this.jdField_q_of_type_Int;
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
      lcu locallcu = (lcu)localIterator.next();
      if ((locallcu.jdField_d_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(locallcu.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(locallcu.jdField_a_of_type_Long));
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
    lfe locallfe = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallfe.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallfe.S + "], seq[" + l1 + "]");
    if ((locallfe.jdField_f_of_type_Int == 1) && (!f())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (locallfe.jdField_k_of_type_Boolean);
      locallfe.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      msa.m(this);
    } while (locallfe.jdField_d_of_type_Int != 1);
    locallfe.a(l1, "onResumeVideo", 2);
    locallfe.S = false;
  }
  
  public void f(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  void f(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    lfe locallfe = a();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + locallfe + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(locallfe.jdField_d_of_type_JavaLangString).longValue();
    int i1 = locallfe.jdField_d_of_type_Int;
    long l3 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    int i2 = locallfe.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      lob locallob1 = new lob();
      lob locallob2 = new lob();
      locallob1.jdField_a_of_type_Long = l2;
      locallob1.jdField_a_of_type_Int = 1;
      locallob2.jdField_a_of_type_Long = l2;
      locallob2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(locallob2);
      localArrayList.add(locallob1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (locallfe.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      m(true);
      a(l1, l2, true, 0);
      a().jdField_d_of_type_JavaLangString = String.valueOf(l2);
      a().a(l1, "notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      a().e("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      a().d("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      a().L = true;
      b("notifyChangeDoubleVideoMeeting2MultiVideo", bool);
      if (!bool) {
        break label491;
      }
    }
    label491:
    for (i1 = 1;; i1 = 0)
    {
      g("notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      if (paramBoolean)
      {
        d();
        a().a(4, 11);
        a().d("notifyChangeDoubleVideoMeeting2MultiVideo", mrr.a(i2));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.jdField_l_of_type_Boolean + "], session[" + locallfe + "], seq[" + l1 + "]");
      }
      return;
      if (locallfe.a(l3, 1) == -1) {
        break;
      }
      locallfe.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
      break;
    }
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
        long l1 = mry.a(str1);
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
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetLevel();
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
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new lcm(this);
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
  
  public void g(String paramString)
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
  
  public void g(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioSpeakerMode, [" + this.jdField_q_of_type_Int + " --> " + paramInt + "], from[" + paramString + "]");
    }
    this.jdField_q_of_type_Int = paramInt;
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_Lff.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_Lff.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_c_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      lfe locallfe = a();
      if (paramBoolean)
      {
        a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (locallfe != null)
        {
          locallfe.jdField_a_of_type_Lff.jdField_f_of_type_Boolean = false;
          locallfe.jdField_a_of_type_Lff.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          locallfe.a();
          locallfe.b();
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
        if (a().jdField_a_of_type_Lff.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((a().jdField_a_of_type_Lff.jdField_a_of_type_Int == 1) || (a().jdField_a_of_type_Lff.jdField_a_of_type_Int == 2))
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
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int h()
  {
    if ((this.jdField_o_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)) {
      this.jdField_o_of_type_Int = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return this.jdField_o_of_type_Int;
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
  
  public void h(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDetectAudioDataIssue, issueType[" + this.jdField_c_of_type_Int + "->" + paramInt + "], seq[" + l1 + "]");
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt), Long.valueOf(l1) });
  }
  
  public void h(String paramString)
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
  
  public void h(String paramString, int paramInt)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_p_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_Lby.receiveGatewayMsg(paramString, paramInt);
      bhhr.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(lch.h, paramString).apply();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      ncl.a(jdField_a_of_type_JavaLangString, "saveGateWayMsg fail.", paramString);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public boolean h()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public int i()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
      return i1;
    }
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
  
  public void i(int paramInt)
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
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
  }
  
  public void i(boolean paramBoolean)
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
          lcu locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (locallcu != null)
          {
            bool2 = bool1;
            if (!locallcu.jdField_g_of_type_Boolean) {
              break label231;
            }
            if ((locallcu.jdField_c_of_type_Long >= 2000L) && (locallcu.jdField_c_of_type_Long < this.jdField_c_of_type_Long))
            {
              l1 = locallcu.jdField_c_of_type_Long;
              bool2 = bool1;
              if (l2 - locallcu.jdField_b_of_type_Long <= l1) {
                break label231;
              }
              locallcu.jdField_g_of_type_Boolean = false;
              locallcu.jdField_b_of_type_Long = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + locallcu.jdField_a_of_type_Long + ",isSuspectNoisy = " + locallcu.jdField_g_of_type_Boolean);
              bool2 = bool1;
              break label231;
            }
            if (this.jdField_c_of_type_Long < 2000L) {
              break label238;
            }
            l1 = this.jdField_c_of_type_Long;
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
  
  public int j()
  {
    if ((a().l()) || (this.jdField_e_of_type_Boolean)) {
      return 0;
    }
    return 255;
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
  
  public void j(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "closeVideo timeout. force to exitProcess. closeReason = " + paramInt);
    d(261);
  }
  
  public void j(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    o(true);
    a(paramString, 206);
    b(206);
    b(paramString, 7);
  }
  
  public void j(boolean paramBoolean)
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
      lcu locallcu = (lcu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
      if ((locallcu == null) || (!locallcu.jdField_g_of_type_Boolean)) {
        break label159;
      }
      if (l1 == locallcu.jdField_a_of_type_Long)
      {
        int i3 = f();
        a("setSuspectNoisyUserMicOff", this.jdField_a_of_type_Long, false, true, -1);
        a(-1L, i3, f());
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
  
  public int k()
  {
    return this.jdField_m_of_type_Int;
  }
  
  public void k()
  {
    boolean bool = llq.c();
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
          long l1 = mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          int i1 = c();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetChannel(this.jdField_a_of_type_Lby);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setCallback(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppId(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1, "8.4.10", new llm().a());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_a_of_type_Lby.receiveGatewayMsg(this.jdField_e_of_type_JavaLangString, this.jdField_p_of_type_Int);
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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    a(paramString, 207);
    b(207);
    b(paramString, 7);
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lcz locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcz != null) {
        locallcz.b(paramBoolean);
      }
    }
  }
  
  public boolean k()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2)
      {
        bdla.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
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
          bdla.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public void l()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 50);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public void l(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lcz locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcz != null) {
        locallcz.c(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_Lff.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lff.jdField_b_of_type_Int < 6);
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(307) });
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    a().I = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lcz locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcz != null) {
        locallcz.d(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    lfe locallfe = a();
    boolean bool1 = bool2;
    if (locallfe != null)
    {
      bool1 = bool2;
      if (locallfe.jdField_a_of_type_Lfg.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (locallfe.jdField_a_of_type_Lfg.jdField_a_of_type_Long > 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void n()
  {
    if (!this.jdField_e_of_type_Boolean) {
      a().a("clearGAudioState", 0);
    }
  }
  
  public void n(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void n(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lcz locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcz != null) {
        locallcz.e(paramBoolean);
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
    if (this.jdField_e_of_type_Boolean) {
      l1 = mry.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1;
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (l1 == ((lcu)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long))
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
  
  public void o(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void o(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lcz locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcz != null) {
        locallcz.f(paramBoolean);
      }
    }
  }
  
  public boolean o()
  {
    return this.t;
  }
  
  public void p()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStartTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_l_of_type_JavaLangRunnable, 3000L);
  }
  
  public void p(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lcz locallcz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcz != null) {
        locallcz.g(paramBoolean);
      }
    }
  }
  
  public boolean p()
  {
    if (AudioHelper.f()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[" + this.jdField_i_of_type_Int + "]");
    }
    return this.jdField_i_of_type_Int > 0;
  }
  
  public void q()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStopTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
  }
  
  public void q(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public void q(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "callBackNetStatus <--receiveEcho Cost = " + l1);
      if (l1 < 3000L) {
        i(1);
      }
    }
    for (;;)
    {
      this.jdField_g_of_type_Long = -1L;
      return;
      i(2);
      continue;
      i(4);
    }
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
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_Lff.jdField_b_of_type_Int >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void r(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public boolean r()
  {
    return (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl != null) && (this.jdField_a_of_type_ComTencentAvWtogetherMediaWatchTogetherMediaPlayCtrl.h());
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void s(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void t()
  {
    int i1;
    if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      if (h() == 4) {
        break label420;
      }
      i1 = a().b();
      if (i1 != -1) {
        break label71;
      }
      ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label71:
    do
    {
      for (;;)
      {
        return;
        lob locallob1 = (lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        locallob1.jdField_a_of_type_Boolean = true;
        if (locallob1.jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          if (i1 != 0)
          {
            locallob2 = (lob)a().jdField_c_of_type_JavaUtilArrayList.get(0);
            locallob2.jdField_a_of_type_Boolean = false;
            a().jdField_c_of_type_JavaUtilArrayList.set(0, locallob1);
            a().jdField_c_of_type_JavaUtilArrayList.set(i1, locallob2);
          }
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, locallob1);
            a().jdField_d_of_type_JavaUtilArrayList.set(i1, locallob2);
            a().c();
            if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1)
            {
              i1 = 0;
              if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
              {
                if (((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
                  ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    } while (i1 == 0);
    lob locallob2 = (lob)a().jdField_c_of_type_JavaUtilArrayList.get(0);
    locallob2.jdField_a_of_type_Boolean = false;
    a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
    a().jdField_c_of_type_JavaUtilArrayList.set(i1, locallob2);
    synchronized (a().jdField_d_of_type_JavaUtilArrayList)
    {
      a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
      a().jdField_d_of_type_JavaUtilArrayList.set(i1, locallob2);
      a().c();
      return;
    }
    label420:
    ((lob)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void t(String paramString)
  {
    long l1 = AudioHelper.b();
    lfe locallfe = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + locallfe.jdField_d_of_type_JavaLangString + "], extraUin[" + locallfe.jdField_f_of_type_JavaLangString + "], remoteHasVideo[" + locallfe.jdField_k_of_type_Boolean + "], mXiaoweiDevice[" + this.jdField_q_of_type_Boolean + "], seq[" + l1 + "]");
    if ((TextUtils.equals(locallfe.jdField_d_of_type_JavaLangString, paramString)) || (TextUtils.equals(locallfe.jdField_f_of_type_JavaLangString, paramString)) || (this.jdField_q_of_type_Boolean))
    {
      if ((locallfe.jdField_f_of_type_Int == 1) && (!f())) {
        lbd.g(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
      }
    }
    else {
      return;
    }
    if (!locallfe.jdField_k_of_type_Boolean)
    {
      locallfe.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
      msa.m(this);
      if (locallfe.jdField_d_of_type_Int == 1)
      {
        locallfe.a(l1, "onNeedShowPeerVideo", 2);
        locallfe.S = false;
      }
    }
    for (;;)
    {
      if (!TextUtils.equals(locallfe.jdField_d_of_type_JavaLangString, paramString)) {
        GraphicRenderMgr.getInstance().onUinChanged(locallfe.jdField_d_of_type_JavaLangString, paramString);
      }
      if ((!locallfe.jdField_j_of_type_Boolean) && (!locallfe.jdField_k_of_type_Boolean)) {
        break;
      }
      c(2);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
    }
    c(1);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2) {
        bdla.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
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
          bdla.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void u(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onAvReqAutoAccept, peerUin[" + paramString + "]");
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoController.21(this, paramString));
    }
  }
  
  public void v()
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
  
  public void v(String paramString)
  {
    a().am = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    w(paramString);
  }
  
  public void w()
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.jdField_i_of_type_Int + "]");
    this.jdField_i_of_type_Int = 0;
  }
  
  public void w(String paramString)
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
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (llc.b(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = h();
      if (!bool1)
      {
        int i1 = f();
        a("onHowling", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, f());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().jdField_P_of_type_Boolean;
      if (bool2) {
        this.jdField_a_of_type_Muy.d();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131695365), 2131690697, 2131694399, new lcp(this), new lcq(this, bool1, bool2));
      bdla.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void x(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695453, 1).a();
    }
    Object localObject = a();
    if (localObject != null) {
      if (((lfe)localObject).F != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      llw.a((String)localObject);
      return;
    }
  }
  
  public void y(String paramString)
  {
    a("deviceMemory", lii.c() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
  
  public void z()
  {
    lfe locallfe = a();
    if (locallfe != null)
    {
      int i2 = locallfe.jdField_V_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = locallfe.U;
      }
      b(i1);
      if ((i1 == 0) || (!locallfe.aA)) {
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
  
  public void z(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */