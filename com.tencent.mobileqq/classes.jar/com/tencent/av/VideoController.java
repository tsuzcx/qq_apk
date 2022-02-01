package com.tencent.av;

import abdm;
import amtj;
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
import bcef;
import bfrf;
import bfvo;
import bfxg;
import bfxl;
import bfyz;
import bgdt;
import bgoa;
import bjlr;
import bjms;
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
import lba;
import lbf;
import lbr;
import lbt;
import lbu;
import lbx;
import lca;
import lcc;
import lcf;
import lcg;
import lch;
import lci;
import lcj;
import lck;
import lcl;
import lcm;
import lcn;
import lcp;
import lcq;
import lcu;
import lcv;
import lcx;
import lcy;
import lcz;
import lep;
import lez;
import lfa;
import lfb;
import lfl;
import lhw;
import lhy;
import liy;
import ljt;
import lka;
import lkq;
import lky;
import lkz;
import lla;
import lld;
import llf;
import lli;
import llj;
import lnl;
import lnn;
import lno;
import lou;
import lsd;
import lvl;
import lzb;
import mak;
import mee;
import miz;
import mkl;
import mnz;
import mpk;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqu;
import mqw;
import mrb;
import mrd;
import msi;
import msj;
import msm;
import msu;
import msw;
import mta;
import mtt;
import mtv;
import mua;
import mum;
import mwe;
import mwf;
import mwv;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  implements lky, lla, lnn
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
  Object jdField_a_of_type_JavaLangObject = new Object();
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoController.1(this);
  ArrayList<lcp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  public lbr a;
  public final lbt a;
  lbu jdField_a_of_type_Lbu = lbu.a();
  private volatile lbx jdField_a_of_type_Lbx;
  public final lca a;
  lcq jdField_a_of_type_Lcq = new lcn(this);
  public lka a;
  private lou jdField_a_of_type_Lou;
  private miz jdField_a_of_type_Miz;
  public msi a;
  msj jdField_a_of_type_Msj;
  public mua a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  boolean jdField_a_of_type_Boolean = true;
  private mnz[] jdField_a_of_type_ArrayOfMnz;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoController.2(this);
  private ArrayList<lcp> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public lcq b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  public Runnable c;
  private final ArrayList<lcp> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  lcq jdField_c_of_type_Lcq = new lcg(this);
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
  Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.31(this);
  boolean jdField_k_of_type_Boolean = false;
  private Runnable jdField_l_of_type_JavaLangRunnable = new VideoController.30(this);
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
  boolean r = false;
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
    this.jdField_a_of_type_Lca = new lca(this);
    this.jdField_c_of_type_Long = 6000L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_b_of_type_Lcq = new lcf(this);
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_h_of_type_JavaLangRunnable = null;
    this.jdField_p_of_type_Int = 1;
    this.jdField_h_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_q_of_type_Int = -1;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_g_of_type_Long = -1L;
    this.jdField_a_of_type_Lbt = new lbt(this);
    if (!mqu.b()) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker = new InviteUIChecker();
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoController create.");
      }
      return;
      this.jdField_a_of_type_Lka = new lka();
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new lcm(this, a(), 3);
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
  
  private void K()
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
      lba.f(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void L()
  {
    Object localObject = a();
    int i4;
    int i2;
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
    {
      int i3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
      long l1 = ((lez)localObject).jdField_h_of_type_Long;
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
  
  private void M()
  {
    if (this.jdField_m_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    }
    this.jdField_m_of_type_JavaLangRunnable = null;
  }
  
  private void N()
  {
    if ((this.jdField_g_of_type_Long != -1L) && (System.currentTimeMillis() - this.jdField_g_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lcx.class);
    localNewIntent.putExtra("reqType", 20);
    localNewIntent.putExtra("vMsg", localReqEcho.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkNetStatus -->sendEcho");
    }
    this.jdField_a_of_type_Lbt.a(localNewIntent);
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
      boolean bool2 = this.u;
      localStartAudioSendRunnable = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
      if (paramBoolean1) {
        break label307;
      }
      if ((!paramBoolean2) && (!this.u)) {
        break label301;
      }
      bool1 = true;
      this.u = bool1;
      if (paramInt == 2) {
        break label368;
      }
      if ((i1 == 0) || (!paramBoolean2)) {
        break label354;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable != null) {
        break label315;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable, 1000L);
      str = jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder().append("switchAudioSend[").append(paramString).append("], seq[").append(paramLong).append("], flag[").append(paramInt).append("], enable[").append(paramBoolean1).append("], notifySvr[").append(paramBoolean2).append("], mIsMicOffBySelf[").append(bool2).append("->").append(this.u).append("], result[").append(i1).append("], mGAudioCtrl[");
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
      QLog.w(str, 1, paramBoolean1 + "], lastRunnable[" + localStartAudioSendRunnable + "], curRunnable[" + this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable + "]");
      return i1;
      i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.nativeStopAudioSend(paramBoolean2);
      break;
      bool1 = false;
      break label58;
      this.u = false;
      break label64;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable);
      if (paramInt != 0) {
        break label104;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = new VideoController.StartAudioSendRunnable(paramLong, paramString, paramBoolean1, paramBoolean2);
      break label104;
      if (paramInt != 1) {
        break label122;
      }
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      break label122;
      this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable = null;
      break label122;
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
  
  private lez a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = lbu.a(3, paramString, new int[0]);
      localObject2 = lbu.a().c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = lbu.a(100, paramString, new int[0]);
        localObject1 = lbu.a().c((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = lbu.a().b(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = lbu.a(4, paramString, new int[0]);
        localObject1 = lbu.a().c((String)localObject1);
      }
    }
  }
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_Lbu.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramAVUserInfo.account;
    long l2 = mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = lbu.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt != 3) {
        break label1684;
      }
      paramVarArgs = lbu.a(100, String.valueOf(paramLong1), new int[0]);
    }
    label531:
    label1684:
    for (;;)
    {
      if (paramInt == 1) {}
      for (??? = a();; ??? = lbu.a().c(paramVarArgs))
      {
        if ((??? != null) && (!TextUtils.isEmpty(((lez)???).jdField_c_of_type_JavaLangString))) {
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_b_of_type_Int + "], relationType[" + paramInt + "], UserInfo[" + paramAVUserInfo + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_l_of_type_Boolean + "], switchToGAudioMode[" + ((lez)???).G + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((lez)???).jdField_V_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        if (this.jdField_l_of_type_Boolean) {
          break label531;
        }
        bool2 = true;
        a("onGAudioUserEnterOrLeave", bool2, ((lez)???).a());
        if (((this.jdField_b_of_type_Int == 1) && (((lez)???).D == 10)) || (this.jdField_b_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label537;
          }
        }
      }
      label537:
      for (boolean bool2 = false;; bool2 = true)
      {
        ((lez)???).jdField_ad_of_type_Boolean = bool2;
        paramVarArgs = a();
        if ((paramBoolean) || (l1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (paramLong1 != paramVarArgs.jdField_g_of_type_Long)) {
          break label543;
        }
        a(paramInt, paramLong1, 72);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
        return;
        bool2 = false;
        break;
      }
      label543:
      a(paramAVUserInfo, paramBoolean);
      if ((paramVarArgs.jdField_d_of_type_Int == 3) && (paramVarArgs.jdField_j_of_type_Int == 1011))
      {
        if (!paramBoolean) {
          break label1093;
        }
        if (i() != 1) {
          break label1081;
        }
        if (!bool1) {
          break label1069;
        }
        paramVarArgs.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 4;
        label598:
        if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
          this.jdField_a_of_type_Mua.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        a(paramVarArgs.jdField_a_of_type_Lfa.jdField_b_of_type_Int, 3, null);
        ??? = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((??? != null) && (((msw)???).a())) {
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
          label743:
          if ((paramVarArgs.jdField_h_of_type_Long != l1) && (l1 != l2)) {
            mak.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
          }
          if (!paramVarArgs.J) {
            break label1186;
          }
          if (!bool1) {
            paramVarArgs.a(l3, SystemClock.elapsedRealtime());
          }
          label795:
          if (!paramBoolean) {
            break label1350;
          }
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramAVUserInfo.accountType != 0) {
            break label1344;
          }
          bool2 = true;
          label817:
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2) });
          label864:
          if (!paramVarArgs.J) {
            break label1519;
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
            break label1504;
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
            paramAVUserInfo = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
          label1069:
          paramVarArgs.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 1;
          break label598;
          label1081:
          paramVarArgs.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 5;
          break label598;
          label1093:
          if (i() == 1) {
            paramVarArgs.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 4;
          }
          if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) || (!m())) {
            break label647;
          }
          this.jdField_a_of_type_Mua.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
          break label647;
          paramVarArgs.a("onGAudioUserEnterOrLeave.2", 10);
          r();
          break label743;
          label1186:
          if (paramVarArgs.jdField_e_of_type_Long != 0L) {
            break label795;
          }
          paramVarArgs.a(l3, SystemClock.elapsedRealtime());
          break label795;
          synchronized (this.jdField_c_of_type_JavaUtilArrayList)
          {
            if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (((lcp)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
            {
              i1 = 1;
              if (i1 != 0)
              {
                paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
                paramVarArgs.af = true;
                ??? = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                if ((??? != null) && (((msw)???).a()))
                {
                  s();
                  b();
                }
              }
              mak.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
              break label795;
            }
            int i1 = 0;
          }
        }
        label1344:
        bool2 = false;
        break label817;
        label1350:
        if (paramLong2 == 1L)
        {
          f(true);
          break label864;
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
        label1504:
        paramAVUserInfo.putExtra("type", 402);
      }
      label1519:
      paramAVUserInfo = new Intent();
      paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
      if (paramBoolean)
      {
        paramAVUserInfo.putExtra("type", 22);
        paramAVUserInfo.putExtra("isStart", this.r);
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
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      label185:
      if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size()) {
        if (((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong2) {}
      }
    }
    for (int i1 = ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;; i1 = 1)
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
    long l1 = mqu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {}
    for (Object localObject = lbu.a(100, String.valueOf(paramLong1), new int[0]);; localObject = lbu.a(paramInt1, String.valueOf(paramLong1), new int[0]))
    {
      localObject = this.jdField_a_of_type_Lbu.c((String)localObject);
      if (localObject != null) {
        ((lez)localObject).b(paramLong2, paramBoolean1, paramBoolean2);
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
    lcp locallcp = a(String.valueOf(paramLong1));
    if (locallcp == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
      }
    }
    lno locallno;
    do
    {
      do
      {
        return;
        locallcp.jdField_b_of_type_Boolean = paramBoolean;
      } while ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1));
      if (!paramBoolean) {
        break;
      }
      locallno = new lno();
      locallno.jdField_a_of_type_Long = paramLong1;
      locallno.jdField_a_of_type_Int = 1;
    } while (a().a(paramLong1, locallno.jdField_a_of_type_Int) != -1);
    locallno.jdField_b_of_type_Long = paramLong2;
    if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
      locallno.jdField_b_of_type_Long = 5L;
    }
    if (!a().v())
    {
      locallno.jdField_a_of_type_Boolean = true;
      if ((h() == 4) || (paramInt == 3)) {
        break label320;
      }
      if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) != -1) {
        break label311;
      }
      locallno.jdField_c_of_type_Boolean = true;
      label236:
      if (locallcp.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        break label338;
      }
      locallno.jdField_b_of_type_Boolean = true;
      locallno.jdField_d_of_type_Boolean = true;
      locallno.jdField_c_of_type_Boolean = true;
      if (a().v()) {
        break label329;
      }
    }
    label311:
    label320:
    label329:
    for (locallno.jdField_a_of_type_Boolean = true;; locallno.jdField_a_of_type_Boolean = false)
    {
      a().a(locallno);
      return;
      locallno.jdField_a_of_type_Boolean = false;
      break;
      locallno.jdField_c_of_type_Boolean = false;
      break label236;
      locallno.jdField_c_of_type_Boolean = true;
      break label236;
    }
    label338:
    locallno.jdField_b_of_type_Boolean = false;
    a().a(locallno);
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
      lno locallno1 = new lno();
      if (paramBoolean2) {
        ((lcp)???).jdField_b_of_type_Int = 2;
      }
      for (;;)
      {
        locallno1.jdField_a_of_type_Long = paramLong;
        locallno1.jdField_a_of_type_Int = 2;
        locallno1.jdField_a_of_type_Boolean = true;
        locallno1.jdField_b_of_type_Boolean = false;
        long l1;
        lno locallno3;
        if (paramInt1 != 0)
        {
          l1 = 4L;
          locallno1.jdField_b_of_type_Long = l1;
          if (a().a(paramLong, locallno1.jdField_a_of_type_Int) != -1) {
            break;
          }
          if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
          {
            ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = false;
            if (h() != 4)
            {
              paramInt1 = a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue());
              if (paramInt1 != -1) {
                ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_c_of_type_Boolean = false;
              }
            }
          }
          locallno1.jdField_c_of_type_Boolean = true;
          if (a().jdField_c_of_type_JavaUtilArrayList.size() <= 1) {
            break label489;
          }
          locallno3 = (lno)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          a().jdField_c_of_type_JavaUtilArrayList.set(0, locallno1);
        }
        synchronized (a().jdField_d_of_type_JavaUtilArrayList)
        {
          a().jdField_d_of_type_JavaUtilArrayList.set(0, locallno1);
          a().a(locallno3);
          return;
          ((lcp)???).jdField_b_of_type_Int = 1;
          continue;
          l1 = 5L;
        }
      }
      label489:
      a().a(0, locallno2);
      return;
    }
    ((lcp)???).jdField_b_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    t();
  }
  
  private void a(Intent paramIntent)
  {
    lka locallka = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (locallka != null) {
      locallka.a(paramIntent);
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
    lka locallka = a();
    lcz.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772178, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
      if (locallka != null) {
        locallka.a(paramIntent);
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
  
  private void a(ArrayList<lno> paramArrayList, int paramInt)
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
              lno locallno = (lno)paramArrayList.get(paramInt);
              paramArrayList.set(paramInt, paramArrayList.get(i1));
              paramArrayList.set(i1, locallno);
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
    lcp locallcp = a(String.valueOf(paramLong));
    if (locallcp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    locallcp.jdField_a_of_type_Boolean = paramBoolean;
    locallcp.jdField_a_of_type_Int = paramInt;
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
    this.jdField_m_of_type_JavaLangRunnable = new VideoController.36(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
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
    lez locallez;
    do
    {
      return false;
      locallez = lbu.a().a();
    } while ((locallez == null) || (locallez.jdField_d_of_type_JavaLangString == null) || (!paramString.equals(locallez.jdField_d_of_type_JavaLangString)));
    return true;
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
  
  public void B()
  {
    long l1 = (System.currentTimeMillis() - this.jdField_e_of_type_Long) / 1000L;
    bcef.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    bcef.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void C()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_Lbr == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Lbr.jdField_a_of_type_JavaLangString)
    {
      bcef.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
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
    this.jdField_a_of_type_Mua.b(l1);
    this.jdField_a_of_type_Mua.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230738, null, 1, null);
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
    N();
  }
  
  public void H()
  {
    lez locallez = a();
    long l1 = AudioHelper.b();
    String str;
    int i1;
    if ((locallez.l()) || (locallez.m()) || (locallez.jdField_g_of_type_Int == 9) || (locallez.n()))
    {
      lzb.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = locallez.jdField_c_of_type_JavaLangString;
      i1 = locallez.jdField_d_of_type_Int;
      if (locallez.jdField_g_of_type_Int == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i1, false, bool, locallez.x());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reNotifyChatInfo2QQ, sessionInfo[" + locallez + "]");
      return;
    }
  }
  
  public void I()
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
    lba.f(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
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
    lba.e("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().D);
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
    localObject1 = lbu.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = lbu.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l1;
    int i2;
    int i1;
    if (!this.jdField_a_of_type_Lbu.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_Lbu.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((lez)localObject2).F = paramInt1;
        ((lez)localObject2).D = paramInt2;
        localObject1 = localObject2;
      }
      this.jdField_m_of_type_Boolean = false;
      l1 = mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
      if ((((lez)localObject1).J) && (((lez)localObject1).aF)) {
        paramInt2 = 5;
      }
      for (;;)
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_j_of_type_Boolean);
        }
        K();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().b(), a().jdField_P_of_type_Int, a().jdField_O_of_type_Int);
        if (this.jdField_j_of_type_JavaLangRunnable == null) {
          this.jdField_j_of_type_JavaLangRunnable = new VideoController.21(this, paramInt1, paramLong);
        }
        this.r = true;
        ((lez)localObject1).a("startGAudioChat.2", 8);
        ((lez)localObject1).jdField_g_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
        g();
        a(((lez)localObject1).jdField_c_of_type_JavaLangString, 3, false, false, false);
        return 0;
        localObject1 = this.jdField_a_of_type_Lbu.c((String)localObject1);
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
          ((lez)localObject1).jdField_g_of_type_Long = paramLong;
          ((lez)localObject1).F = paramInt1;
          ((lez)localObject1).D = paramInt2;
          ((lez)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
          ((lez)localObject1).jdField_j_of_type_Int = 0;
          ((lez)localObject1).e("startGAudioChat", true);
          i2 = 1;
          i1 = paramInt2;
          paramInt2 = i2;
          break label372;
        }
        return -1;
        if (((lez)localObject1).b()) {
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
          lcp locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallcp != null) && (locallcp.jdField_a_of_type_Long == paramLong)) {
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
    StringBuilder localStringBuilder = new StringBuilder().append("acceptGAudioChat, relationType[").append(paramInt).append("], relationId[").append(paramLong2).append("], isVideo[").append(paramBoolean).append("], relationId[").append(paramLong2).append("], mIsStartGAuio[").append(this.r).append("], uinList[");
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
        paramLong1 = mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
            this.jdField_j_of_type_JavaLangRunnable = new VideoController.22(this, paramInt, paramLong2);
          }
          this.r = false;
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
    lez locallez = a(paramInt2, paramString);
    if (locallez == null) {
      locallez = a();
    }
    for (;;)
    {
      k(false);
      if ((locallez.jdField_j_of_type_Int == 1011) || (locallez.jdField_j_of_type_Int == 21)) {
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
          QLog.i(jdField_a_of_type_JavaLangString, 2, "acceptRequest, result[" + paramInt1 + "], peerUin[" + paramString + "], relationType[" + paramInt2 + "], session[" + locallez + "]");
        }
        if (paramInt1 == 0)
        {
          locallez.a("acceptRequest", 3);
          i();
        }
        this.jdField_a_of_type_Lbt.a();
        ((lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
        lhw.a(37);
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
      this.jdField_a_of_type_Lbt.d();
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
      ((lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      lhw.a(28);
      lhw.a(11, str);
      lhw.a(12, 1L);
      if (!paramString1.S) {
        break label1030;
      }
      l2 = 1L;
      label620:
      lhw.a(13, l2);
      lhw.a(15, 1L);
      K();
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
      lvl.a().o = paramString1.S;
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
        a("deviceMemory", lhw.c() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.a(a()));
        if (this.jdField_a_of_type_Lbx != null) {
          this.jdField_a_of_type_Lbx.b();
        }
        this.jdField_a_of_type_Lbx = new lbx(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
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
            l1 = mrb.a(str);
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
          paramString10 = lbf.a(paramString10);
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
  
  public int a(lez paramlez, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramlez, paramString);
    }
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
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
    lcv locallcv = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallcv != null) {
      locallcv.c();
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
    lez locallez = lbu.a().a(paramString);
    if ((locallez != null) && (locallez.b() != 0L)) {
      l1 = locallez.b();
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
    } while (locallez == null);
    locallez.d(l2);
    return l2;
  }
  
  public long a(lez paramlez)
  {
    if (paramlez == null) {
      return 0L;
    }
    long l1 = paramlez.b();
    switch (paramlez.jdField_d_of_type_Int)
    {
    default: 
      return l1;
    }
    return a(paramlez.jdField_d_of_type_JavaLangString);
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
    return bfvo.a(paramBitmap, paramInt1, paramInt1, paramInt2);
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
      lcp locallcp;
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
          } while (a().jdField_a_of_type_Lfa.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return a().jdField_a_of_type_Lfa.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (a().jdField_a_of_type_Lfa.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return a().jdField_a_of_type_Lfa.jdField_b_of_type_AndroidGraphicsBitmap;
        if (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int != 3) {
          break;
        }
        locallcp = a(paramString);
      } while ((locallcp == null) || (locallcp.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + locallcp.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return locallcp.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((a().jdField_a_of_type_Lfa.jdField_a_of_type_Int != 1) || (a().jdField_a_of_type_Lfa.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return a().jdField_a_of_type_Lfa.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_a_of_type_Lbu.b());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_Lbu.b()))
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
  
  public Pair<Integer, ArrayList<lcp>> a()
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
        lcp locallcp = (lcp)((Iterator)localObject4).next();
        locallcp.jdField_h_of_type_Boolean = true;
        localArrayList2.add(locallcp);
        localHashSet.add(Long.valueOf(locallcp.jdField_a_of_type_Long));
      }
    }
    int i1 = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (lcp)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((lcp)localObject4).jdField_a_of_type_Long)))
      {
        ((lcp)localObject4).jdField_h_of_type_Boolean = false;
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
  
  public String a(ArrayList<lno> paramArrayList)
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
  
  public ArrayList<lcp> a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    lcp locallcp;
    while (localIterator.hasNext())
    {
      locallcp = (lcp)localIterator.next();
      localArrayList.add(locallcp);
      localHashSet.add(Long.valueOf(locallcp.jdField_a_of_type_Long));
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      locallcp = (lcp)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(locallcp.jdField_a_of_type_Long)))
      {
        locallcp.jdField_h_of_type_Boolean = false;
        localArrayList.add(locallcp);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<lcp> a(int paramInt, ArrayList<lcp> paramArrayList)
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
        localObject2 = (lcp)paramArrayList.get(i2);
        if (((lcp)localObject2).jdField_a_of_type_Long == l2) {
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
      localObject2 = (lcp)paramArrayList.get(i2);
      if (((lcp)localObject2).jdField_a_of_type_Long == l2) {
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
      long l3 = ((lcp)localArrayList1.get(i2)).jdField_a_of_type_Long;
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
      Collections.sort((List)localObject2, new lci(this));
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
      l2 = ((lcp)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
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
      Collections.sort(localArrayList2, new lcj(this));
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
      lcp locallcp;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 >= i2) {
          break label152;
        }
        locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (locallcp == null) {
          break label158;
        }
        if (locallcp.jdField_a_of_type_Long == paramLong1)
        {
          if (!locallcp.jdField_e_of_type_Boolean)
          {
            locallcp.jdField_g_of_type_Boolean = paramBoolean;
            locallcp.jdField_b_of_type_Long = l1;
            locallcp.jdField_c_of_type_Long = paramLong2;
          }
        }
        else
        {
          if (!locallcp.jdField_g_of_type_Boolean) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(locallcp.jdField_a_of_type_Long));
        }
      }
      if (locallcp.jdField_g_of_type_Boolean)
      {
        locallcp.jdField_g_of_type_Boolean = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i1 += 1;
      }
    }
  }
  
  public lcp a(String paramString)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          lcp locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallcp == null) || (locallcp.jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = locallcp;
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
  
  public lez a()
  {
    return this.jdField_a_of_type_Lbu.a();
  }
  
  public lka a()
  {
    return this.jdField_a_of_type_Lka;
  }
  
  public lou a(Context arg1)
  {
    if (!lou.b()) {
      return null;
    }
    if ((this.jdField_a_of_type_Lou == null) && (??? != null)) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Lou == null)
      {
        this.jdField_a_of_type_Lou = new lou(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        this.jdField_a_of_type_Lou.c();
      }
      this.jdField_a_of_type_Lca.a(this.jdField_a_of_type_Lou);
      return this.jdField_a_of_type_Lou;
    }
  }
  
  @TargetApi(21)
  public miz a()
  {
    if (this.jdField_a_of_type_Miz == null) {
      this.jdField_a_of_type_Miz = new miz();
    }
    return this.jdField_a_of_type_Miz;
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
    boolean bool = liy.a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_j_of_type_Boolean + "], preSize[" + liy.jdField_a_of_type_Int + ", " + liy.jdField_b_of_type_Int + "], seq[" + l1 + "], forbiddenReopenCamera[" + bool + "]");
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
    } while ((liy.jdField_a_of_type_Int == i2) && (liy.jdField_b_of_type_Int == i1));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(i2), Integer.valueOf(i1), Long.valueOf(l1) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Long = paramInt3;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      ThreadManager.excute(new VideoController.25(this, paramInt1, paramInt2, paramInt3), 16, null, false);
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
      if (((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
      {
        i3 = ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
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
              a((lcp)localObject, paramInt1);
              i1 = a().a(paramLong1, 0);
            }
            for (((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;; ((lno)localObject).jdField_a_of_type_Int = paramInt1)
            {
              i1 = 1;
              break;
              localObject = (lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
              lno locallno = new lno();
              locallno.jdField_a_of_type_Long = ((lno)localObject).jdField_a_of_type_Long;
              locallno.jdField_a_of_type_Int = ((lno)localObject).jdField_a_of_type_Int;
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(locallno);
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
      ((lez)localObject).jdField_a_of_type_Lfa.jdField_a_of_type_Int = paramInt2;
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
      ((Intent)localObject).putExtra("guild_group_id", a().jdField_a_of_type_Lfb.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", i());
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_Lfb.jdField_a_of_type_JavaLangString);
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
    //   2: invokestatic 660	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 430	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 18
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 647	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 618	lbu:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 17
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +2061 -> 2089
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 647	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 618	lbu:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 17
    //   45: aload_0
    //   46: getfield 112	com/tencent/av/VideoController:jdField_a_of_type_Lbu	Llbu;
    //   49: aload 17
    //   51: invokevirtual 621	lbu:c	(Ljava/lang/String;)Llez;
    //   54: astore 19
    //   56: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 20
    //   67: new 365	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 2142
    //   77: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 672
    //   87: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 512	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2144
    //   97: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 512	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2146
    //   108: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 17
    //   113: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 507
    //   119: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2148
    //   130: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 21
    //   135: aload 18
    //   137: ifnull +47 -> 184
    //   140: iconst_1
    //   141: istore 16
    //   143: aload 20
    //   145: iconst_1
    //   146: aload 21
    //   148: iload 16
    //   150: invokevirtual 375	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2150
    //   156: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 19
    //   161: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 533
    //   167: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 535	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   195: getstatic 288	android/os/Build$VERSION:SDK_INT	I
    //   198: bipush 21
    //   200: if_icmplt +44 -> 244
    //   203: aload_0
    //   204: getfield 2006	com/tencent/av/VideoController:jdField_a_of_type_Miz	Lmiz;
    //   207: astore 20
    //   209: aload 20
    //   211: ifnull +17 -> 228
    //   214: aload 20
    //   216: invokevirtual 2151	miz:c	()Z
    //   219: ifeq +9 -> 228
    //   222: aload 20
    //   224: iconst_4
    //   225: invokevirtual 2152	miz:a	(I)V
    //   228: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +13 -> 244
    //   234: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc_w 2154
    //   241: invokestatic 303	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: aload 18
    //   246: invokevirtual 2157	com/tencent/av/app/VideoAppInterface:a	()Lljt;
    //   249: astore 20
    //   251: aload 20
    //   253: ifnull +10 -> 263
    //   256: aload 20
    //   258: aload 19
    //   260: invokevirtual 2162	ljt:a	(Llez;)V
    //   263: aload 18
    //   265: invokevirtual 435	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   268: aload_0
    //   269: getfield 230	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   272: invokevirtual 441	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   275: aload_0
    //   276: aconst_null
    //   277: putfield 230	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   280: aload_0
    //   281: getfield 206	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   284: ifnull +20 -> 304
    //   287: aload 18
    //   289: invokevirtual 435	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   292: aload_0
    //   293: getfield 206	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   296: invokevirtual 441	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   299: aload_0
    //   300: aconst_null
    //   301: putfield 206	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   304: aload_0
    //   305: getfield 212	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   308: ifnull -127 -> 181
    //   311: aload 18
    //   313: iconst_4
    //   314: anewarray 4	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: sipush 203
    //   322: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: dup
    //   327: iconst_1
    //   328: lload_2
    //   329: invokestatic 647	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   332: aastore
    //   333: dup
    //   334: iconst_2
    //   335: aload_0
    //   336: getfield 114	com/tencent/av/VideoController:jdField_a_of_type_Boolean	Z
    //   339: invokestatic 798	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   342: aastore
    //   343: dup
    //   344: iconst_3
    //   345: lload 12
    //   347: invokestatic 722	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: aastore
    //   351: invokevirtual 725	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   354: aload_0
    //   355: invokevirtual 393	com/tencent/av/VideoController:a	()Llez;
    //   358: getfield 2164	lez:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   361: invokevirtual 768	java/util/ArrayList:size	()I
    //   364: ifle +21 -> 385
    //   367: aload_0
    //   368: invokevirtual 393	com/tencent/av/VideoController:a	()Llez;
    //   371: getfield 707	lez:jdField_ad_of_type_Boolean	Z
    //   374: ifeq +11 -> 385
    //   377: aload_0
    //   378: iconst_2
    //   379: iconst_0
    //   380: iconst_0
    //   381: lconst_0
    //   382: invokevirtual 2166	com/tencent/av/VideoController:a	(IIIJ)V
    //   385: iload_1
    //   386: iconst_2
    //   387: if_icmpne +149 -> 536
    //   390: aload 19
    //   392: getfield 707	lez:jdField_ad_of_type_Boolean	Z
    //   395: ifne +141 -> 536
    //   398: aload 19
    //   400: getfield 2164	lez:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   403: ifnull +133 -> 536
    //   406: new 807	android/content/Intent
    //   409: dup
    //   410: invokespecial 808	android/content/Intent:<init>	()V
    //   413: astore 20
    //   415: aload 20
    //   417: ldc_w 810
    //   420: invokevirtual 814	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   423: pop
    //   424: aload 20
    //   426: ldc_w 816
    //   429: sipush 411
    //   432: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   435: pop
    //   436: aload 20
    //   438: ldc_w 2168
    //   441: aload_0
    //   442: invokevirtual 393	com/tencent/av/VideoController:a	()Llez;
    //   445: getfield 2164	lez:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   448: invokevirtual 2171	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   451: pop
    //   452: aload 20
    //   454: ldc_w 819
    //   457: aload_0
    //   458: invokevirtual 393	com/tencent/av/VideoController:a	()Llez;
    //   461: getfield 1293	lez:F	I
    //   464: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   467: pop
    //   468: aload 20
    //   470: ldc_w 821
    //   473: aload_0
    //   474: invokevirtual 393	com/tencent/av/VideoController:a	()Llez;
    //   477: getfield 711	lez:jdField_g_of_type_Long	J
    //   480: invokevirtual 824	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   483: pop
    //   484: aload 20
    //   486: ldc_w 828
    //   489: aload_0
    //   490: invokevirtual 393	com/tencent/av/VideoController:a	()Llez;
    //   493: getfield 704	lez:D	I
    //   496: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   499: pop
    //   500: aload 20
    //   502: ldc_w 880
    //   505: ldc_w 2173
    //   508: invokevirtual 885	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   511: pop
    //   512: aload 20
    //   514: aload 18
    //   516: invokevirtual 832	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   519: invokevirtual 837	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   522: invokevirtual 840	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   525: pop
    //   526: aload 18
    //   528: invokevirtual 832	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   531: aload 20
    //   533: invokevirtual 844	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   536: iload_1
    //   537: bipush 7
    //   539: if_icmpne +10 -> 549
    //   542: aload_0
    //   543: iconst_0
    //   544: iconst_0
    //   545: aconst_null
    //   546: invokevirtual 755	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   549: iload_1
    //   550: bipush 9
    //   552: if_icmpne +29 -> 581
    //   555: aload 19
    //   557: getfield 735	lez:jdField_a_of_type_Lfa	Llfa;
    //   560: iconst_0
    //   561: putfield 738	lfa:jdField_b_of_type_Int	I
    //   564: aload_0
    //   565: iconst_0
    //   566: iconst_0
    //   567: aconst_null
    //   568: invokevirtual 755	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   571: aload 19
    //   573: invokevirtual 2174	lez:b	()V
    //   576: aload 19
    //   578: invokevirtual 2175	lez:a	()V
    //   581: iload_1
    //   582: bipush 10
    //   584: if_icmpne +13 -> 597
    //   587: aload 19
    //   589: invokevirtual 2174	lez:b	()V
    //   592: aload 19
    //   594: invokevirtual 2175	lez:a	()V
    //   597: iload_1
    //   598: iconst_2
    //   599: if_icmpne +1107 -> 1706
    //   602: ldc_w 2177
    //   605: aload 19
    //   607: getfield 2179	lez:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   610: invokevirtual 1117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   613: ifeq +30 -> 643
    //   616: aconst_null
    //   617: ldc_w 2181
    //   620: ldc 169
    //   622: ldc 169
    //   624: ldc_w 2183
    //   627: ldc_w 2183
    //   630: iconst_0
    //   631: iconst_0
    //   632: ldc 169
    //   634: ldc 169
    //   636: ldc 169
    //   638: ldc 169
    //   640: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   643: aload_0
    //   644: invokevirtual 2185	com/tencent/av/VideoController:h	()Z
    //   647: ifeq +30 -> 677
    //   650: aconst_null
    //   651: ldc_w 2181
    //   654: ldc 169
    //   656: ldc 169
    //   658: ldc_w 2187
    //   661: ldc_w 2187
    //   664: iconst_0
    //   665: iconst_0
    //   666: ldc 169
    //   668: ldc 169
    //   670: ldc 169
    //   672: ldc 169
    //   674: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 19
    //   679: getfield 1303	lez:jdField_j_of_type_Boolean	Z
    //   682: ifeq +38 -> 720
    //   685: aconst_null
    //   686: ldc_w 2181
    //   689: ldc 169
    //   691: ldc 169
    //   693: ldc_w 2189
    //   696: ldc_w 2189
    //   699: iconst_0
    //   700: iconst_0
    //   701: ldc 169
    //   703: ldc 169
    //   705: ldc 169
    //   707: ldc 169
    //   709: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 19
    //   714: getfield 2190	lez:jdField_m_of_type_Boolean	Z
    //   717: ifeq +959 -> 1676
    //   720: aload_0
    //   721: getfield 232	com/tencent/av/VideoController:jdField_s_of_type_Boolean	Z
    //   724: ifeq +44 -> 768
    //   727: aload_0
    //   728: invokevirtual 2192	com/tencent/av/VideoController:a	()J
    //   731: lconst_0
    //   732: lcmp
    //   733: ifle +35 -> 768
    //   736: aconst_null
    //   737: ldc_w 2181
    //   740: ldc 169
    //   742: ldc 169
    //   744: ldc_w 2194
    //   747: ldc_w 2194
    //   750: iconst_0
    //   751: iconst_0
    //   752: ldc 169
    //   754: ldc 169
    //   756: aload_0
    //   757: invokevirtual 2192	com/tencent/av/VideoController:a	()J
    //   760: invokestatic 2198	mum:a	(J)Ljava/lang/String;
    //   763: ldc 169
    //   765: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload_0
    //   769: getfield 212	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   772: lload_2
    //   773: invokevirtual 2201	com/tencent/av/gaudio/QQGAudioCtrl:getNetTrafficSize	(J)J
    //   776: lstore 14
    //   778: iconst_0
    //   779: istore 5
    //   781: iload 4
    //   783: bipush 7
    //   785: if_icmpeq +1307 -> 2092
    //   788: iload 4
    //   790: bipush 20
    //   792: if_icmpne +6 -> 798
    //   795: goto +1297 -> 2092
    //   798: getstatic 2204	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   801: ifne +24 -> 825
    //   804: iload 4
    //   806: bipush 69
    //   808: if_icmpeq +17 -> 825
    //   811: iload 4
    //   813: bipush 70
    //   815: if_icmpeq +10 -> 825
    //   818: iload 4
    //   820: bipush 71
    //   822: if_icmpne +1215 -> 2037
    //   825: aload_0
    //   826: ldc_w 2205
    //   829: putfield 226	com/tencent/av/VideoController:jdField_q_of_type_Int	I
    //   832: new 2207	com/tencent/av/VideoController$23
    //   835: dup
    //   836: aload_0
    //   837: iload 5
    //   839: invokespecial 2210	com/tencent/av/VideoController$23:<init>	(Lcom/tencent/av/VideoController;I)V
    //   842: bipush 16
    //   844: aconst_null
    //   845: iconst_0
    //   846: invokestatic 2061	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   849: aload_0
    //   850: getfield 224	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   853: astore 20
    //   855: aload 20
    //   857: monitorenter
    //   858: aload_0
    //   859: getfield 224	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   862: sipush 2000
    //   865: i2l
    //   866: invokevirtual 2213	java/lang/Object:wait	(J)V
    //   869: aload 20
    //   871: monitorexit
    //   872: aload_0
    //   873: getfield 226	com/tencent/av/VideoController:jdField_q_of_type_Int	I
    //   876: ldc_w 2205
    //   879: if_icmpne +1207 -> 2086
    //   882: sipush 261
    //   885: istore 5
    //   887: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   890: iconst_1
    //   891: new 365	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   898: ldc_w 2215
    //   901: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_0
    //   905: getfield 226	com/tencent/av/VideoController:jdField_q_of_type_Int	I
    //   908: invokevirtual 512	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   911: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: aload_0
    //   918: getfield 1676	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   921: ifeq +1129 -> 2050
    //   924: aload 19
    //   926: getfield 767	lez:jdField_g_of_type_Int	I
    //   929: bipush 9
    //   931: if_icmpne +1119 -> 2050
    //   934: aload 19
    //   936: getfield 775	lez:af	Z
    //   939: ifne +1111 -> 2050
    //   942: lconst_0
    //   943: lstore 8
    //   945: aload_0
    //   946: ldc_w 2217
    //   949: iconst_0
    //   950: invokevirtual 1685	com/tencent/av/VideoController:b	(Ljava/lang/String;Z)V
    //   953: aload_0
    //   954: ldc_w 2217
    //   957: iconst_1
    //   958: invokevirtual 1687	com/tencent/av/VideoController:g	(Ljava/lang/String;I)V
    //   961: aload_0
    //   962: getfield 241	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   965: astore 20
    //   967: aload 20
    //   969: monitorenter
    //   970: aload_0
    //   971: getfield 241	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   974: invokevirtual 768	java/util/ArrayList:size	()I
    //   977: ifne +1103 -> 2080
    //   980: aload_0
    //   981: getfield 1676	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   984: ifne +1096 -> 2080
    //   987: aload_0
    //   988: getfield 666	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   991: lconst_0
    //   992: lcmp
    //   993: ifne +1087 -> 2080
    //   996: iconst_1
    //   997: istore 6
    //   999: aload_0
    //   1000: getfield 241	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1003: invokevirtual 768	java/util/ArrayList:size	()I
    //   1006: istore 7
    //   1008: aload_0
    //   1009: getfield 241	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1012: invokevirtual 1400	java/util/ArrayList:clear	()V
    //   1015: aload 20
    //   1017: monitorexit
    //   1018: aload_0
    //   1019: ldc_w 2217
    //   1022: iconst_0
    //   1023: iconst_0
    //   1024: lconst_0
    //   1025: invokevirtual 694	com/tencent/av/VideoController:a	(Ljava/lang/String;ZIJ)V
    //   1028: aload 19
    //   1030: iconst_0
    //   1031: putfield 697	lez:jdField_V_of_type_Boolean	Z
    //   1034: aload_0
    //   1035: getfield 212	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1038: iconst_0
    //   1039: putfield 2220	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   1042: aload 18
    //   1044: invokevirtual 636	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1047: astore 20
    //   1049: lconst_0
    //   1050: lstore 10
    //   1052: aload 20
    //   1054: ifnull +10 -> 1064
    //   1057: aload 20
    //   1059: invokestatic 641	mrb:a	(Ljava/lang/String;)J
    //   1062: lstore 10
    //   1064: aload 20
    //   1066: invokestatic 654	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1069: ifne +214 -> 1283
    //   1072: new 807	android/content/Intent
    //   1075: dup
    //   1076: invokespecial 808	android/content/Intent:<init>	()V
    //   1079: astore 21
    //   1081: aload 21
    //   1083: ldc_w 810
    //   1086: invokevirtual 814	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   1089: pop
    //   1090: aload 21
    //   1092: ldc_w 816
    //   1095: bipush 23
    //   1097: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1100: pop
    //   1101: aload 21
    //   1103: ldc_w 826
    //   1106: lload 10
    //   1108: invokevirtual 824	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1111: pop
    //   1112: aload 21
    //   1114: ldc_w 821
    //   1117: lload_2
    //   1118: invokevirtual 824	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1121: pop
    //   1122: aload 21
    //   1124: ldc_w 819
    //   1127: iload_1
    //   1128: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1131: pop
    //   1132: aload 21
    //   1134: ldc_w 828
    //   1137: aload 19
    //   1139: getfield 704	lez:D	I
    //   1142: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1145: pop
    //   1146: aload 21
    //   1148: ldc_w 2222
    //   1151: lload 8
    //   1153: invokevirtual 824	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1156: pop
    //   1157: aload 21
    //   1159: ldc_w 873
    //   1162: aload_0
    //   1163: getfield 228	com/tencent/av/VideoController:r	Z
    //   1166: invokevirtual 876	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1169: pop
    //   1170: aload 21
    //   1172: ldc_w 2224
    //   1175: iload 4
    //   1177: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1180: pop
    //   1181: aload 21
    //   1183: ldc_w 880
    //   1186: ldc_w 2226
    //   1189: invokevirtual 885	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1192: pop
    //   1193: iload 7
    //   1195: iconst_1
    //   1196: if_icmple +871 -> 2067
    //   1199: aload 21
    //   1201: ldc_w 878
    //   1204: iload 7
    //   1206: iconst_1
    //   1207: isub
    //   1208: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1211: pop
    //   1212: aload 21
    //   1214: aload 18
    //   1216: invokevirtual 832	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1219: invokevirtual 837	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1222: invokevirtual 840	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1225: pop
    //   1226: aload 21
    //   1228: lload 12
    //   1230: invokestatic 2231	mtt:a	(Landroid/content/Intent;J)V
    //   1233: aload 18
    //   1235: invokevirtual 832	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1238: aload 21
    //   1240: invokevirtual 844	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1243: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1246: ifeq +37 -> 1283
    //   1249: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1252: iconst_1
    //   1253: new 365	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   1260: ldc_w 2233
    //   1263: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: lload 12
    //   1268: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1271: ldc_w 533
    //   1274: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 535	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1283: aload 19
    //   1285: ldc_w 2217
    //   1288: aconst_null
    //   1289: invokevirtual 2235	lez:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1292: aload 19
    //   1294: aconst_null
    //   1295: putfield 2238	lez:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1298: aload_0
    //   1299: invokevirtual 2240	com/tencent/av/VideoController:h	()V
    //   1302: aload 19
    //   1304: getfield 897	lez:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1307: invokevirtual 768	java/util/ArrayList:size	()I
    //   1310: ifle +28 -> 1338
    //   1313: aload 18
    //   1315: iconst_2
    //   1316: anewarray 4	java/lang/Object
    //   1319: dup
    //   1320: iconst_0
    //   1321: bipush 104
    //   1323: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1326: aastore
    //   1327: dup
    //   1328: iconst_1
    //   1329: aload 19
    //   1331: getfield 897	lez:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1334: aastore
    //   1335: invokevirtual 725	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1338: aload 19
    //   1340: getfield 1293	lez:F	I
    //   1343: iconst_1
    //   1344: if_icmpne +28 -> 1372
    //   1347: aload 18
    //   1349: iconst_2
    //   1350: anewarray 4	java/lang/Object
    //   1353: dup
    //   1354: iconst_0
    //   1355: sipush 410
    //   1358: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1361: aastore
    //   1362: dup
    //   1363: iconst_1
    //   1364: lload_2
    //   1365: invokestatic 722	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1368: aastore
    //   1369: invokevirtual 725	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1372: aload 19
    //   1374: getfield 2242	lez:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   1377: astore 21
    //   1379: aload 19
    //   1381: getfield 1293	lez:F	I
    //   1384: iconst_1
    //   1385: if_icmpeq +12 -> 1397
    //   1388: aload 19
    //   1390: getfield 1293	lez:F	I
    //   1393: iconst_2
    //   1394: if_icmpne +44 -> 1438
    //   1397: aload 19
    //   1399: getfield 1303	lez:jdField_j_of_type_Boolean	Z
    //   1402: ifeq +28 -> 1430
    //   1405: aload 18
    //   1407: iconst_2
    //   1408: anewarray 4	java/lang/Object
    //   1411: dup
    //   1412: iconst_0
    //   1413: bipush 106
    //   1415: invokestatic 719	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1418: aastore
    //   1419: dup
    //   1420: iconst_1
    //   1421: lload 12
    //   1423: invokestatic 722	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1426: aastore
    //   1427: invokevirtual 725	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1430: aload 19
    //   1432: lload 12
    //   1434: iconst_0
    //   1435: invokevirtual 2245	lez:a	(JZ)V
    //   1438: aload 19
    //   1440: lload 12
    //   1442: invokevirtual 2247	lez:c	(J)V
    //   1445: aload_0
    //   1446: invokevirtual 2249	com/tencent/av/VideoController:f	()V
    //   1449: lload 12
    //   1451: aload 18
    //   1453: invokestatic 2252	mak:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1456: iload 6
    //   1458: ifne +46 -> 1504
    //   1461: aload_0
    //   1462: new 365	java/lang/StringBuilder
    //   1465: dup
    //   1466: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   1469: ldc_w 2254
    //   1472: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: iload 4
    //   1477: invokevirtual 512	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: aload 17
    //   1485: iload_1
    //   1486: invokestatic 2256	mum:c	(I)I
    //   1489: aload 20
    //   1491: lload_2
    //   1492: invokestatic 647	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1495: bipush 7
    //   1497: aload 21
    //   1499: iconst_0
    //   1500: iconst_0
    //   1501: invokevirtual 2259	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1504: aload 19
    //   1506: iconst_m1
    //   1507: putfield 730	lez:jdField_j_of_type_Int	I
    //   1510: aload 19
    //   1512: iconst_1
    //   1513: putfield 2260	lez:jdField_p_of_type_Boolean	Z
    //   1516: aload_0
    //   1517: lload 14
    //   1519: putfield 2127	com/tencent/av/VideoController:jdField_b_of_type_Long	J
    //   1522: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq +31 -> 1556
    //   1528: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1531: iconst_2
    //   1532: new 365	java/lang/StringBuilder
    //   1535: dup
    //   1536: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   1539: ldc_w 2262
    //   1542: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: lload 14
    //   1547: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1550: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1553: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1556: new 807	android/content/Intent
    //   1559: dup
    //   1560: ldc_w 2133
    //   1563: invokespecial 2135	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1566: astore 19
    //   1568: aload 19
    //   1570: ldc_w 2138
    //   1573: lload 14
    //   1575: invokevirtual 824	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1578: pop
    //   1579: aload 19
    //   1581: aload 18
    //   1583: invokevirtual 832	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1586: invokevirtual 837	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1589: invokevirtual 840	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1592: pop
    //   1593: iload 6
    //   1595: ifne +13 -> 1608
    //   1598: aload 18
    //   1600: invokevirtual 832	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1603: aload 19
    //   1605: invokevirtual 844	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1608: aload_0
    //   1609: getfield 112	com/tencent/av/VideoController:jdField_a_of_type_Lbu	Llbu;
    //   1612: lload 12
    //   1614: aload 17
    //   1616: invokevirtual 2265	lbu:a	(JLjava/lang/String;)Z
    //   1619: istore 16
    //   1621: aload 18
    //   1623: invokestatic 760	msw:a	(Lcom/tencent/av/app/VideoAppInterface;)Lmsw;
    //   1626: astore 18
    //   1628: aload 18
    //   1630: ifnull +27 -> 1657
    //   1633: aload 18
    //   1635: invokevirtual 761	msw:a	()Z
    //   1638: ifeq +19 -> 1657
    //   1641: aload 18
    //   1643: aload 17
    //   1645: invokevirtual 851	msw:a	(Ljava/lang/String;)V
    //   1648: iload 16
    //   1650: ifeq +7 -> 1657
    //   1653: aload_0
    //   1654: invokevirtual 763	com/tencent/av/VideoController:b	()V
    //   1657: invokestatic 2268	com/tencent/av/utils/PopupDialog:a	()V
    //   1660: aload_0
    //   1661: iload 5
    //   1663: invokevirtual 2270	com/tencent/av/VideoController:d	(I)V
    //   1666: goto -1485 -> 181
    //   1669: astore 17
    //   1671: aload_0
    //   1672: monitorexit
    //   1673: aload 17
    //   1675: athrow
    //   1676: aconst_null
    //   1677: ldc_w 2181
    //   1680: ldc 169
    //   1682: ldc 169
    //   1684: ldc_w 2272
    //   1687: ldc_w 2272
    //   1690: iconst_0
    //   1691: iconst_0
    //   1692: ldc 169
    //   1694: ldc 169
    //   1696: ldc 169
    //   1698: ldc 169
    //   1700: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1703: goto -983 -> 720
    //   1706: iload_1
    //   1707: iconst_1
    //   1708: if_icmpne -988 -> 720
    //   1711: ldc_w 2177
    //   1714: aload 19
    //   1716: getfield 2179	lez:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   1719: invokevirtual 1117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1722: ifeq +40 -> 1762
    //   1725: aload 19
    //   1727: getfield 704	lez:D	I
    //   1730: bipush 10
    //   1732: if_icmpne +167 -> 1899
    //   1735: aconst_null
    //   1736: ldc_w 2181
    //   1739: ldc 169
    //   1741: ldc 169
    //   1743: ldc_w 2274
    //   1746: ldc_w 2274
    //   1749: iconst_0
    //   1750: iconst_0
    //   1751: ldc 169
    //   1753: ldc 169
    //   1755: ldc 169
    //   1757: ldc 169
    //   1759: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1762: aload_0
    //   1763: invokevirtual 2185	com/tencent/av/VideoController:h	()Z
    //   1766: ifeq +40 -> 1806
    //   1769: aload 19
    //   1771: getfield 704	lez:D	I
    //   1774: bipush 10
    //   1776: if_icmpne +153 -> 1929
    //   1779: aconst_null
    //   1780: ldc_w 2181
    //   1783: ldc 169
    //   1785: ldc 169
    //   1787: ldc_w 2276
    //   1790: ldc_w 2276
    //   1793: iconst_0
    //   1794: iconst_0
    //   1795: ldc 169
    //   1797: ldc 169
    //   1799: ldc 169
    //   1801: ldc 169
    //   1803: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1806: aload 19
    //   1808: getfield 1303	lez:jdField_j_of_type_Boolean	Z
    //   1811: ifeq -1091 -> 720
    //   1814: aload 19
    //   1816: getfield 704	lez:D	I
    //   1819: bipush 10
    //   1821: if_icmpne +138 -> 1959
    //   1824: aconst_null
    //   1825: ldc_w 2181
    //   1828: ldc 169
    //   1830: ldc 169
    //   1832: ldc_w 2278
    //   1835: ldc_w 2278
    //   1838: iconst_0
    //   1839: iconst_0
    //   1840: ldc 169
    //   1842: ldc 169
    //   1844: ldc 169
    //   1846: ldc 169
    //   1848: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1851: aload 19
    //   1853: getfield 2190	lez:jdField_m_of_type_Boolean	Z
    //   1856: ifne -1136 -> 720
    //   1859: aload 19
    //   1861: getfield 704	lez:D	I
    //   1864: bipush 10
    //   1866: if_icmpne +123 -> 1989
    //   1869: aconst_null
    //   1870: ldc_w 2181
    //   1873: ldc 169
    //   1875: ldc 169
    //   1877: ldc_w 2280
    //   1880: ldc_w 2280
    //   1883: iconst_0
    //   1884: iconst_0
    //   1885: ldc 169
    //   1887: ldc 169
    //   1889: ldc 169
    //   1891: ldc 169
    //   1893: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1896: goto -1176 -> 720
    //   1899: aconst_null
    //   1900: ldc_w 2181
    //   1903: ldc 169
    //   1905: ldc 169
    //   1907: ldc_w 2282
    //   1910: ldc_w 2282
    //   1913: iconst_0
    //   1914: iconst_0
    //   1915: ldc 169
    //   1917: ldc 169
    //   1919: ldc 169
    //   1921: ldc 169
    //   1923: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1926: goto -164 -> 1762
    //   1929: aconst_null
    //   1930: ldc_w 2181
    //   1933: ldc 169
    //   1935: ldc 169
    //   1937: ldc_w 2284
    //   1940: ldc_w 2284
    //   1943: iconst_0
    //   1944: iconst_0
    //   1945: ldc 169
    //   1947: ldc 169
    //   1949: ldc 169
    //   1951: ldc 169
    //   1953: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1956: goto -150 -> 1806
    //   1959: aconst_null
    //   1960: ldc_w 2181
    //   1963: ldc 169
    //   1965: ldc 169
    //   1967: ldc_w 2286
    //   1970: ldc_w 2286
    //   1973: iconst_0
    //   1974: iconst_0
    //   1975: ldc 169
    //   1977: ldc 169
    //   1979: ldc 169
    //   1981: ldc 169
    //   1983: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1986: goto -135 -> 1851
    //   1989: aconst_null
    //   1990: ldc_w 2181
    //   1993: ldc 169
    //   1995: ldc 169
    //   1997: ldc_w 2288
    //   2000: ldc_w 2288
    //   2003: iconst_0
    //   2004: iconst_0
    //   2005: ldc 169
    //   2007: ldc 169
    //   2009: ldc 169
    //   2011: ldc 169
    //   2013: invokestatic 1179	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2016: goto -1296 -> 720
    //   2019: astore 21
    //   2021: aload 21
    //   2023: invokevirtual 2289	java/lang/InterruptedException:printStackTrace	()V
    //   2026: goto -1157 -> 869
    //   2029: astore 17
    //   2031: aload 20
    //   2033: monitorexit
    //   2034: aload 17
    //   2036: athrow
    //   2037: aload_0
    //   2038: getfield 212	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   2041: iload 5
    //   2043: invokevirtual 2292	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   2046: pop
    //   2047: goto -1130 -> 917
    //   2050: aload_0
    //   2051: invokevirtual 2192	com/tencent/av/VideoController:a	()J
    //   2054: lstore 8
    //   2056: goto -1111 -> 945
    //   2059: astore 17
    //   2061: aload 20
    //   2063: monitorexit
    //   2064: aload 17
    //   2066: athrow
    //   2067: aload 21
    //   2069: ldc_w 878
    //   2072: iconst_0
    //   2073: invokevirtual 817	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2076: pop
    //   2077: goto -865 -> 1212
    //   2080: iconst_0
    //   2081: istore 6
    //   2083: goto -1084 -> 999
    //   2086: goto -1199 -> 887
    //   2089: goto -2044 -> 45
    //   2092: iload 4
    //   2094: istore 5
    //   2096: goto -1298 -> 798
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2099	0	this	VideoController
    //   0	2099	1	paramInt1	int
    //   0	2099	2	paramLong	long
    //   0	2099	4	paramInt2	int
    //   779	1316	5	i1	int
    //   997	1085	6	i2	int
    //   1006	202	7	i3	int
    //   943	1112	8	l1	long
    //   1050	57	10	l2	long
    //   5	1608	12	l3	long
    //   776	798	14	l4	long
    //   141	1508	16	bool	boolean
    //   24	1620	17	str	String
    //   1669	5	17	localObject1	Object
    //   2029	6	17	localObject2	Object
    //   2059	6	17	localObject3	Object
    //   11	1631	18	localObject4	Object
    //   54	1806	19	localObject5	Object
    //   133	1365	21	localObject7	Object
    //   2019	49	21	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	26	1669	finally
    //   31	45	1669	finally
    //   45	135	1669	finally
    //   143	176	1669	finally
    //   195	209	1669	finally
    //   214	228	1669	finally
    //   228	244	1669	finally
    //   244	251	1669	finally
    //   256	263	1669	finally
    //   263	304	1669	finally
    //   304	385	1669	finally
    //   390	536	1669	finally
    //   542	549	1669	finally
    //   555	581	1669	finally
    //   587	597	1669	finally
    //   602	643	1669	finally
    //   643	677	1669	finally
    //   677	720	1669	finally
    //   720	768	1669	finally
    //   768	778	1669	finally
    //   798	804	1669	finally
    //   825	858	1669	finally
    //   872	882	1669	finally
    //   887	917	1669	finally
    //   917	942	1669	finally
    //   945	970	1669	finally
    //   1018	1049	1669	finally
    //   1057	1064	1669	finally
    //   1064	1193	1669	finally
    //   1199	1212	1669	finally
    //   1212	1283	1669	finally
    //   1283	1338	1669	finally
    //   1338	1372	1669	finally
    //   1372	1397	1669	finally
    //   1397	1430	1669	finally
    //   1430	1438	1669	finally
    //   1438	1456	1669	finally
    //   1461	1504	1669	finally
    //   1504	1556	1669	finally
    //   1556	1593	1669	finally
    //   1598	1608	1669	finally
    //   1608	1628	1669	finally
    //   1633	1648	1669	finally
    //   1653	1657	1669	finally
    //   1657	1666	1669	finally
    //   1676	1703	1669	finally
    //   1711	1762	1669	finally
    //   1762	1806	1669	finally
    //   1806	1851	1669	finally
    //   1851	1896	1669	finally
    //   1899	1926	1669	finally
    //   1929	1956	1669	finally
    //   1959	1986	1669	finally
    //   1989	2016	1669	finally
    //   2034	2037	1669	finally
    //   2037	2047	1669	finally
    //   2050	2056	1669	finally
    //   2064	2067	1669	finally
    //   2067	2077	1669	finally
    //   858	869	2019	java/lang/InterruptedException
    //   858	869	2029	finally
    //   869	872	2029	finally
    //   2021	2026	2029	finally
    //   2031	2034	2029	finally
    //   970	996	2059	finally
    //   999	1018	2059	finally
    //   2061	2064	2059	finally
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = lbu.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = lbu.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l1 = AudioHelper.b();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], seq[" + l1 + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((lez)localObject).jdField_j_of_type_Boolean)) {
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
      int i1 = mum.c(paramInt1);
      a(a().jdField_c_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        a("onGAudioSDKError_2");
        if (this.jdField_a_of_type_Mua != null) {
          this.jdField_a_of_type_Mua.a(l1);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_a_of_type_Lbu.a(l1, str);
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
    lez locallez = a();
    String str;
    if (paramInt2 == 3)
    {
      str = lbu.a(100, String.valueOf(paramLong2), new int[0]);
      boolean bool = TextUtils.equals(locallez.jdField_c_of_type_JavaLangString, str);
      if ((!bool) || (QLog.isDevelopLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + locallez.jdField_c_of_type_JavaLangString + "], seq[" + l1 + "]");
      }
      if (bool) {
        break label169;
      }
    }
    label169:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      str = lbu.a(paramInt2, String.valueOf(paramLong2), new int[0]);
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
    lba.d("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
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
      if (!bfxg.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
        return;
      }
      localObject3 = lbu.a(paramInt1, String.valueOf(paramLong1), new int[0]);
      if (this.jdField_a_of_type_Lbu.a((String)localObject3))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
        return;
      }
      localObject2 = this.jdField_a_of_type_Lbu.a((String)localObject3, false);
      ((lez)localObject2).jdField_g_of_type_Long = paramLong1;
      ((lez)localObject2).F = paramInt1;
      ((lez)localObject2).D = paramInt2;
      ((lez)localObject2).ah = false;
      ((lez)localObject2).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      ((lez)localObject2).jdField_ad_of_type_Int = paramInt4;
      if (b(paramInt1, paramLong1, paramInt3))
      {
        a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      lcc.jdField_b_of_type_Boolean = localVideoAppInterface.b();
      paramBoolean = false;
      if (!((lez)localObject1).f()) {
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
          ((lez)localObject2).a("onGAudioInvite.1", 0);
        }
        K();
        bool = a(localVideoAppInterface.getApp().getApplicationContext());
        if (!bool) {
          break label803;
        }
        if ((((lez)localObject1).jdField_g_of_type_Int <= 0) || (((lez)localObject1).jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
          break;
        }
        a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
        if (localVideoAppInterface.e()) {
          paramBoolean = true;
        }
      }
      if (7 == ((lez)localObject1).jdField_g_of_type_Int)
      {
        a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((lez)localObject1).jdField_g_of_type_Int == 14) || (((lez)localObject1).jdField_g_of_type_Int == 13))
      {
        a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((lez)localObject1).jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) && (((lez)localObject1).jdField_a_of_type_Lfa.jdField_a_of_type_Int == 1))
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + ((lez)localObject1).jdField_a_of_type_Lfa.jdField_b_of_type_Int + "], chatType[" + ((lez)localObject1).jdField_a_of_type_Lfa.jdField_a_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
      }
      if (((lez)localObject2).jdField_d_of_type_Int == 0)
      {
        ((lez)localObject2).jdField_e_of_type_Boolean = true;
        ((lez)localObject2).a(l1, "onGAudioInvite.1", 3);
        ((lez)localObject2).jdField_j_of_type_Int = mum.c(paramInt1);
        ((lez)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong2);
        if (paramInt1 == 2) {
          ((lez)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong2);
        }
        ((lez)localObject2).jdField_e_of_type_Boolean = true;
        if ((paramInt3 != 3) && (paramInt3 != 4)) {
          a((String)localObject3, ((lez)localObject2).jdField_d_of_type_Int, false, false, false);
        }
      }
      this.jdField_d_of_type_Long = paramLong1;
      this.jdField_h_of_type_Int = paramInt1;
      if (((lez)localObject2).jdField_g_of_type_Int == 0) {
        ((lez)localObject2).a("onGAudioInvite", 7);
      }
      bool = false;
      if ((paramInt3 != 3) || (((lez)localObject1).jdField_g_of_type_Long != 0L)) {
        break label1377;
      }
      bool = b((lez)localObject1, (lez)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
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
        paramArrayOfLong.putExtra("extraUin", ((lez)localObject1).jdField_f_of_type_JavaLangString);
        paramArrayOfLong.putExtra("relationId", paramLong1);
        paramArrayOfLong.putExtra("type", 13);
        paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("isSender", false);
        paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("realSenderUin", ((lez)localObject1).jdField_s_of_type_JavaLangString);
        localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
        a(l1, this.jdField_h_of_type_Int, paramLong1, true);
        new bjlr(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
        this.jdField_a_of_type_Lbu.a(l1, (String)localObject3);
        return;
        label1377:
        if (paramInt3 != 4) {
          break;
        }
        bool = a((lez)localObject1, (lez)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
        break;
        if (paramInt1 == 2) {
          paramArrayOfLong.putExtra("uinType", 3000);
        }
      }
    }
    ((lez)localObject1).jdField_s_of_type_JavaLangString = ("" + paramLong2);
    this.jdField_s_of_type_Boolean = b();
    if (((lez)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite msg blocked [" + ((lez)localObject2).jdField_c_of_type_JavaLangString + "]");
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
      if ((paramBoolean) || (lcz.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        bfxl.d();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", mum.c(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((lez)localObject2).jdField_c_of_type_JavaLangString);
        if ((!this.jdField_s_of_type_Boolean) || (!lzb.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1806;
        }
        if ((!paramBoolean) && (!lcz.a())) {
          break label1774;
        }
        paramArrayOfLong = new mee(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.d();
        paramArrayOfLong.a((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1774:
      paramArrayOfLong = new mkl(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.d();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1806:
      a((Intent)localObject1);
      break;
      label1815:
      lhw.a();
    }
  }
  
  public void a(int paramInt, long paramLong, mwf parammwf)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt, paramLong, parammwf);
    }
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    paramVarArgs = lbu.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_Lbu.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = lbu.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      lez locallez = this.jdField_a_of_type_Lbu.c(paramVarArgs);
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l1 + "], \nsession[" + locallez + "]");
      }
      int i1;
      if ((locallez != null) && ((locallez.jdField_g_of_type_Int == 7) || (locallez.jdField_g_of_type_Int == 2)))
      {
        locallez.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_Lbu.a(paramVarArgs))
        {
          locallez = this.jdField_a_of_type_Lbu.c(paramVarArgs);
          i1 = mum.c(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(locallez.jdField_c_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Lbu.a(l1, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, locallez.jdField_s_of_type_JavaLangString, true, false);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Lbu == null) || (a() == null) || (a().jdField_d_of_type_JavaLangString == null)) {}
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
      Object localObject1 = this.jdField_a_of_type_Lbu;
      localObject1 = this.jdField_a_of_type_Lbu;
      localObject1 = lbu.a(lbu.a(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_a_of_type_Lbu.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((lez)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((lez)localObject1).jdField_d_of_type_JavaLangString)) && (((lez)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((lez)localObject1).A);
      ((Intent)localObject2).putExtra("bindId", ((lez)localObject1).jdField_p_of_type_JavaLangString);
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
    boolean bool3 = this.jdField_a_of_type_Lbt.a(paramString1);
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
    this.jdField_a_of_type_Lbt.c();
    K();
    lcc.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = mta.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i1 + ",sdkAVAccostType = " + paramInt1 + "|" + lcc.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
    }
    if (a(i1, paramString1))
    {
      a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
      return;
    }
    localObject = a();
    str = lbu.a(3, paramString1, new int[0]);
    if ((TextUtils.equals(str, ((lez)localObject).jdField_c_of_type_JavaLangString)) && (((lez)localObject).jdField_d_of_type_Boolean))
    {
      ((lez)localObject).jdField_e_of_type_Boolean = true;
      paramInt1 = 1;
      if (((lez)localObject).S) {
        paramInt1 = 0;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((lez)localObject).F);
      return;
    }
    boolean bool2 = false;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((i1 != 21) && (i1 != 1011) && ((((lez)localObject).jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (((lez)localObject).jdField_a_of_type_Lfa.jdField_a_of_type_Int == 1))
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
      this.jdField_a_of_type_Lbu.a(str, false);
      localObject = this.jdField_a_of_type_Lbu.c(str);
      ((lez)localObject).A = paramInt2;
      ((lez)localObject).jdField_p_of_type_JavaLangString = paramString3;
      ((lez)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((lez)localObject).jdField_B_of_type_Int = i1;
      if (this.jdField_h_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_h_of_type_JavaLangRunnable = null;
        ((lez)localObject).a("onRequestVideo.1", 0);
      }
      if (!this.jdField_a_of_type_Lbt.a()) {
        break label1854;
      }
      i1 = 9500;
    }
    label693:
    label1854:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      ((lez)localObject).S = paramBoolean;
      long l3;
      if (paramBoolean)
      {
        ((lez)localObject).jdField_f_of_type_Int = 1;
        l1 = a(paramString1);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  ,roomId = " + l1);
        ((lez)localObject).d(l1);
        ((lez)localObject).jdField_j_of_type_Int = i1;
        ((lez)localObject).jdField_k_of_type_Int = paramInt1;
        ((lez)localObject).jdField_d_of_type_JavaLangString = paramString1;
        ((lez)localObject).jdField_f_of_type_JavaLangString = paramString2;
        ((lez)localObject).jdField_e_of_type_Boolean = true;
        ((lez)localObject).a("onRequestVideo.2", 2);
        ((lez)localObject).jdField_q_of_type_Int = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!paramBoolean) {
          break label1540;
        }
        paramInt1 = 1;
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        l3 = a(paramString1);
        lhw.a(l3, 36);
        lhw.a(l3, 9, ((lez)localObject).b());
        lhw.a(l3, 11, paramString1);
        lhw.a(l3, 12, 2L);
        if (!((lez)localObject).S) {
          break label1545;
        }
      }
      for (long l1 = 1L;; l1 = 2L)
      {
        lhw.a(l3, 13, l1);
        lhw.a(l3, 15, 1L);
        x(paramString1);
        if (!bool3) {
          break label1553;
        }
        ((lez)localObject).jdField_c_of_type_Boolean = true;
        b(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((lez)localObject).jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) && (((lez)localObject).jdField_a_of_type_Lfa.jdField_a_of_type_Int == 3))
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
        if (((lez)localObject).f())
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
        if ((((lez)localObject).o()) || (((lez)localObject).p()))
        {
          b(((lez)localObject).jdField_d_of_type_JavaLangString, 2);
          bool1 = bool2;
          break label570;
        }
        if (((((lez)localObject).jdField_g_of_type_Int == 7) && (this.jdField_d_of_type_Long != 0L)) || (((lez)localObject).jdField_g_of_type_Int == 14) || (((lez)localObject).jdField_g_of_type_Int == 13))
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
          if (((i1 == 21) || (i1 == 1011)) && (a().jdField_a_of_type_Lfa.jdField_b_of_type_JavaLangString != null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  auto Accept");
            if ((((lez)localObject).jdField_a_of_type_Lfa.jdField_c_of_type_JavaLangString != null) && (!((lez)localObject).jdField_a_of_type_Lfa.jdField_c_of_type_JavaLangString.equals(paramString1)))
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
          if ((((lez)localObject).jdField_d_of_type_JavaLangString != null) && (paramString1.equals(((lez)localObject).jdField_d_of_type_JavaLangString)))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when request: fromUin = " + paramString1);
            F();
            x(paramString1);
            return;
          }
          if (!bool4) {
            break label570;
          }
          a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.jdField_e_of_type_Boolean) || (((lez)localObject).jdField_g_of_type_Int == 8))
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
        if (((lez)localObject).jdField_g_of_type_Int != 1) {
          break label570;
        }
        bool1 = bool2;
        if (((lez)localObject).jdField_d_of_type_JavaLangString == null) {
          break label570;
        }
        bool1 = bool2;
        if (!paramString1.equals(((lez)localObject).jdField_d_of_type_JavaLangString)) {
          break label570;
        }
        return;
        ((lez)localObject).jdField_f_of_type_Int = 2;
        break label693;
        paramInt1 = 2;
        break label812;
      }
      if ((!this.jdField_e_of_type_Boolean) && (((lez)localObject).jdField_j_of_type_Int != 21) && (((lez)localObject).jdField_j_of_type_Int != 1011)) {
        a(str, ((lez)localObject).jdField_f_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_n_of_type_Int + ", isQQPaused: " + lcc.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
      }
      if ((this.x) && (this.jdField_n_of_type_Int == 0) && (!bool4) && (lcc.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.6(this, l2, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_Lbx != null) {
        this.jdField_a_of_type_Lbx.b();
      }
      this.jdField_a_of_type_Lbx = new lbx(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
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
  
  public void a(int paramInt, mnz parammnz)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + parammnz);
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMnz == null) {
      this.jdField_a_of_type_ArrayOfMnz = new mnz[2];
    }
    this.jdField_a_of_type_ArrayOfMnz[paramInt] = parammnz;
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
    mua.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    lez locallez = a();
    j();
    locallez.a("onSubState2", 4);
    locallez.a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!locallez.jdField_g_of_type_Boolean) {
        break label219;
      }
      a(true, locallez.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, paramLong), 50L);
      a(locallez.jdField_c_of_type_JavaLangString, locallez.jdField_d_of_type_Int, true, true, true);
      mrd.i(this);
      mrd.c(this, true);
      mrd.b(this, true);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        ljt localljt = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localljt != null) {
          localljt.a(locallez);
        }
      }
      return;
      b();
      break;
      label219:
      a(false, locallez.jdField_d_of_type_JavaLangString);
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
      this.jdField_a_of_type_Mua.b(paramLong);
      if (!this.jdField_a_of_type_Mua.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        lba.g(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_d_of_type_JavaLangString, 212);
        b(212);
        b(a().jdField_d_of_type_JavaLangString, a().z);
      }
    } while (!a().T);
    lba.g(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
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
    mua.a().b();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = lbu.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_a_of_type_Lbu.c(str1);
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
      str1 = lbu.a(paramInt1, String.valueOf(paramLong2), new int[0]);
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
    ((lez)localObject).ah = true;
    int i1 = 4;
    label277:
    String str2;
    if (((lez)localObject).jdField_g_of_type_Int == 7)
    {
      ((lez)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        h();
        paramInt2 = mum.c(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((lez)localObject).jdField_c_of_type_JavaLangString, mum.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((lez)localObject).jdField_g_of_type_Long), 5, ((lez)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_Lbu.a(paramLong1, str1);
      localObject = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((msw)localObject).a())) {
        break;
      }
      ((msw)localObject).a(str1);
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
        a("ignoreGAudioChat_2", str1, paramInt2, ((lez)localObject).jdField_d_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((lez)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i1, ((lez)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
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
      bcef.b(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i1, 0, "", "", "", "");
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
      localObject1 = lbu.a(i2, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_a_of_type_Lbu.a((String)localObject1, false);
      i3 = ((lez)localObject2).jdField_d_of_type_Int;
      ((lez)localObject1).a(paramLong1, ((lez)localObject2).jdField_j_of_type_Boolean);
      ((lez)localObject1).jdField_g_of_type_Boolean = ((lez)localObject2).jdField_g_of_type_Boolean;
      ((lez)localObject1).b("switchToMultiAudio", ((lez)localObject2).jdField_P_of_type_Boolean);
      ((lez)localObject1).b("switchToMultiAudio", ((lez)localObject2).jdField_q_of_type_JavaLangString);
      ((lez)localObject1).jdField_d_of_type_JavaLangString = ((lez)localObject2).jdField_d_of_type_JavaLangString;
      ((lez)localObject1).D = i1;
      ((lez)localObject1).aE = true;
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      if (!((lez)localObject2).J) {
        break label454;
      }
      boolean bool = this.jdField_l_of_type_Boolean;
      a(paramLong1, Long.valueOf(((lez)localObject2).jdField_d_of_type_JavaLangString).longValue(), true, 0);
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
      if (!paramArrayList.contains(((lez)localObject2).jdField_d_of_type_JavaLangString)) {
        paramArrayList.add(((lez)localObject2).jdField_d_of_type_JavaLangString);
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
      a(((lez)localObject2).jdField_d_of_type_JavaLangString, 1);
      b(214);
      b(((lez)localObject2).jdField_d_of_type_JavaLangString, 21);
    }
    label500:
    if (i1 == localObject2.length)
    {
      ((lez)localObject1).jdField_a_of_type_ArrayOfLong = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((lez)localObject1).z = -1;
      if (i3 != 1) {
        break label680;
      }
      ((lez)localObject1).a(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((lez)localObject1).jdField_j_of_type_Int = paramInt;
      ((lez)localObject1).jdField_g_of_type_Long = paramLong2;
      ((lez)localObject1).d("switchToMultiAudio", mqu.a(paramInt));
      ((lez)localObject1).c("switchToMultiAudio", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label638:
      return;
      ((lez)localObject1).jdField_a_of_type_ArrayOfLong = new long[i1];
      i2 = 0;
      while (i2 < i1)
      {
        ((lez)localObject1).jdField_a_of_type_ArrayOfLong[i2] = localObject2[i2];
        i2 += 1;
      }
      break;
      label680:
      if (i3 == 2) {
        ((lez)localObject1).a(paramLong1, "switchToMultiAudio.2", 4);
      } else if (i3 == 3) {
        ((lez)localObject1).a(paramLong1, "switchToMultiAudio.3", 3);
      } else if (i3 == 4) {
        ((lez)localObject1).a(paramLong1, "switchToMultiAudio.4", 3);
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
    String str = lbu.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_a_of_type_Lbu.c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((lez)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((lez)localObject).jdField_d_of_type_JavaLangString, ((lez)localObject).jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((lez)localObject).D);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_Lbu.a(paramLong1, str);
      localObject = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((msw)localObject).a())) {
        break;
      }
      ((msw)localObject).a(str);
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
    lcp locallcp = a(String.valueOf(paramLong2));
    if (locallcp == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    locallcp.jdField_d_of_type_Boolean = false;
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
    lez locallez = a();
    if ((locallez.jdField_d_of_type_Int != 2) || ((locallez.w != 2) && (locallez.w != 3))) {
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
  
  public void a(long paramLong1, long paramLong2, ArrayList<lnl> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.28(this, paramArrayList, paramLong1, paramLong2));
  }
  
  @TargetApi(21)
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, relationId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    Object localObject = this.jdField_a_of_type_Miz;
    if (localObject != null) {
      ((miz)localObject).a(4);
    }
    localObject = lbu.a(100, String.valueOf(paramLong2), new int[0]);
    lez locallez = this.jdField_a_of_type_Lbu.c((String)localObject);
    if (locallez == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", locallez.D);
    localIntent.putExtra("from", "VideoController6");
    mtt.a(localIntent, paramLong1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a((String)localObject, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (locallez.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      locallez.d("quitDoubleVideoMeeting", false);
      locallez.e("quitDoubleVideoMeeting", false);
    }
    for (;;)
    {
      localObject = a();
      if (localObject == null) {
        break;
      }
      ((ScreenShareCtrl)localObject).b(paramLong2);
      return;
      locallez.a("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230741, 1, this.jdField_c_of_type_Lcq);
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.32(this);
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
    String str = lbu.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_Lbu.a(str)) {}
    for (lez locallez = this.jdField_a_of_type_Lbu.c(str); locallez == null; locallez = this.jdField_a_of_type_Lbu.c(str))
    {
      lba.h(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = lbu.a(100, paramString, new int[0]);
    }
    locallez.jdField_d_of_type_Boolean = false;
    if ((q()) && (paramString != null) && (!paramString.equals(locallez.jdField_d_of_type_JavaLangString)))
    {
      lba.g(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + locallez.jdField_d_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Lbx != null)
    {
      this.jdField_a_of_type_Lbx.b();
      this.jdField_a_of_type_Lbx = null;
    }
    this.jdField_h_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    j();
    if ((locallez.jdField_d_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(paramLong, str, paramString, 3);
      label296:
      if (!locallez.j()) {
        break label440;
      }
      locallez.z = paramInt;
      if ((locallez.j()) && (paramInt == locallez.jdField_d_of_type_Int)) {
        locallez.a(paramLong, 0L);
      }
      locallez.a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(locallez.jdField_d_of_type_JavaLangString, locallez.z);
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
        if (locallez.h())
        {
          locallez.z = paramInt;
          locallez.a(paramLong, 0L);
          int i2 = 2131230741;
          switch (paramInt)
          {
          default: 
            i1 = 0;
            this.jdField_a_of_type_Lcq.jdField_a_of_type_Long = paramLong;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a(paramLong, i2, i1, this.jdField_a_of_type_Lcq);
            locallez.a("onCloseVideo.isInviting1", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            bcef.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            if (l()) {
              break;
            }
            if (locallez.jdField_d_of_type_Long != 2L)
            {
              bcef.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230740;
              break label531;
            }
            i2 = 2131230741;
            i1 = 1;
            break label531;
            this.jdField_b_of_type_Lcq.jdField_a_of_type_Long = paramLong;
            a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lcq);
            locallez.a("onCloseVideo.isInviting", 6);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (l()) {
              break;
            }
            bcef.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            i2 = 2131230740;
            i1 = 0;
            break label531;
          }
        }
        label531:
        if (!locallez.o())
        {
          locallez.z = paramInt;
          if (locallez.j()) {
            locallez.a(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (locallez.jdField_j_of_type_Int == 1011))
          {
            locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label1080;
            }
            a(6, 0, null);
            label950:
            msw localmsw = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label1097;
            }
            if (localmsw != null) {
              localmsw.a();
            }
          }
          label976:
          locallez.a("onCloseVideo.isClosing1", 6);
          if ((!q()) && (!msm.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label1104;
          }
          a(locallez.jdField_d_of_type_JavaLangString, 209);
          b(209);
          b(locallez.jdField_d_of_type_JavaLangString, locallez.z);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1080:
      a(locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int, 0, null);
      break label950;
      label1097:
      b();
      break label976;
      label1104:
      this.jdField_b_of_type_Lcq.jdField_a_of_type_Long = paramLong;
      a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lcq);
      msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_s_of_type_Boolean = b();
    boolean bool3 = lzb.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.jdField_s_of_type_Boolean + "], isFloatWindowOpAllowedOnBackground[" + bool3 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l1 + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!lkq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
    {
      a(paramLong, paramString2, 0, paramBoolean2);
      b(paramString2, 0);
    }
    boolean bool1;
    Object localObject;
    label672:
    label715:
    do
    {
      return;
      lez locallez = this.jdField_a_of_type_Lbu.c(paramString1);
      if (locallez == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      locallez.jdField_e_of_type_Boolean = true;
      locallez.S = paramBoolean1;
      locallez.a("processVideoRequest.1", 2);
      locallez.ag = false;
      locallez.jdField_k_of_type_Long = System.currentTimeMillis();
      lvl.a().o = locallez.S;
      bool1 = false;
      if ((paramBoolean3) || (lcz.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("relationType", mum.b(paramInt1));
        ((Intent)localObject).putExtra("session_id", paramString1);
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.jdField_g_of_type_Int);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_Lfb.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_Lfb.jdField_a_of_type_Long > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label715;
        }
        g();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_Lfa.jdField_c_of_type_JavaLangString)) {
          break label672;
        }
        locallez.jdField_d_of_type_JavaLangString = paramString2;
        a(paramLong, locallez.jdField_d_of_type_JavaLangString, 0, 4);
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        return;
        boolean bool2 = true;
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), VideoInviteActivity.class);
        localObject = localIntent;
        bool1 = bool2;
        if (bfrf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
        {
          localIntent.addFlags(262144);
          localObject = localIntent;
          bool1 = bool2;
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Boolean = true;
      locallez.a("processVideoRequest.2", 0);
      locallez.jdField_j_of_type_Int = paramInt1;
      locallez.jdField_d_of_type_JavaLangString = paramString2;
      return;
      if (!locallez.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "processVideoRequest block notify video msg");
    return;
    if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext())) {
      a((Intent)localObject, paramString2, bool1, true);
    }
    for (;;)
    {
      g();
      return;
      if ((this.jdField_s_of_type_Boolean) && (bool3))
      {
        if ((paramBoolean3) || (lcz.a()))
        {
          paramString1 = new mee(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
          paramString1.d();
          paramString1.a((Intent)localObject);
        }
        for (;;)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest startActivity when GameMode");
          a("mode", "1");
          c(paramString2);
          a(paramString2, "screenState", String.valueOf(1));
          break;
          paramString1 = new mkl(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
          paramString1.d();
          paramString1.a(paramLong, (Intent)localObject);
        }
      }
      a((Intent)localObject, paramString2, bool1, false);
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
    this.jdField_a_of_type_Mua.b(paramLong);
    localObject = this.jdField_a_of_type_Mua;
    mua.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 10, 1L);
      if ((a().jdField_d_of_type_JavaLangString == null) || (!a().jdField_d_of_type_JavaLangString.equals(paramString))) {
        break label281;
      }
      lhw.a(a().b(), 38);
    }
    for (i1 = paramInt;; i1 = paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      h();
      j();
      if (!this.jdField_a_of_type_Lbt.a()) {
        break;
      }
      abdm.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label281:
      lhw.a(a(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    lez locallez = this.jdField_a_of_type_Lbu.c(paramString1);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + locallez + "]", new Throwable("打印调用栈"));
    int i1;
    String str;
    if ((locallez != null) && ((!locallez.ag) || (locallez.jdField_c_of_type_Boolean)))
    {
      i1 = this.jdField_a_of_type_Lbu.c(paramString1).jdField_j_of_type_Int;
      str = locallez.jdField_f_of_type_JavaLangString;
      if ((TextUtils.isEmpty(locallez.jdField_d_of_type_JavaLangString)) || (!locallez.jdField_d_of_type_JavaLangString.contains(paramString2))) {
        break label413;
      }
      paramString2 = locallez.jdField_d_of_type_JavaLangString;
    }
    label413:
    for (;;)
    {
      if (this.jdField_a_of_type_Lbt.a())
      {
        i1 = 9500;
        if (this.w) {
          i1 = 0;
        }
      }
      boolean bool = false;
      if (locallez.jdField_f_of_type_Int == 2) {
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
        locallez.ag = true;
        locallez.jdField_c_of_type_Boolean = false;
        return;
        if (!locallez.jdField_c_of_type_Boolean) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        label341:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_Lbu.c(paramString1).jdField_s_of_type_JavaLangString, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_Lbu.c(paramString1).jdField_s_of_type_JavaLangString, false, true);
        }
      }
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, mum.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_Lbu.a(paramLong, paramString2);
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
      lcp locallcp = new lcp();
      locallcp.jdField_a_of_type_Long = ((AVUserInfo)paramArrayList.get(i1)).account;
      locallcp.jdField_d_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).accountType;
      this.jdField_a_of_type_JavaUtilArrayList.add(locallcp);
      if (((AVUserInfo)paramArrayList.get(i1)).accountType == 1) {
        localArrayList.add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).account));
      }
      i1 += 1;
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_Lbt.a(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate, size[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList<lno> paramArrayList, int paramInt, boolean paramBoolean)
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
            if (((lno)paramArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
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
          if (paramInt == ((lno)paramArrayList.get(i1)).jdField_a_of_type_Int)
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
  
  public void a(long paramLong, ArrayList<lno> paramArrayList1, ArrayList<lno> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList1.size()) {
        if (((lno)paramArrayList1.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((lno)paramArrayList1.get(i1)).jdField_a_of_type_Int)
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
      localObject = (lcp)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((lcp)localObject).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((lcp)localObject).jdField_a_of_type_Long);
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
      str = lbu.a(100, paramString1, new int[0]);
      lez locallez2 = this.jdField_a_of_type_Lbu.c(str);
      lez locallez1 = locallez2;
      if (locallez2 == null) {
        locallez1 = this.jdField_a_of_type_Lbu.a(str, false);
      }
      locallez1.jdField_j_of_type_Int = paramInt1;
      locallez1.A = paramInt2;
      locallez1.jdField_p_of_type_JavaLangString = paramString3;
      locallez1.jdField_e_of_type_Boolean = true;
      paramInt1 = locallez1.jdField_j_of_type_Int;
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
        l1 = mrb.a(paramString1);
        a(paramLong, 3, l1);
        lbu.a().a(paramLong, str);
        return;
        str = lbu.a(3, paramString1, new int[0]);
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
        bcef.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      bcef.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
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
      lcp locallcp = new lcp();
      locallcp.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(locallcp);
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
    this.jdField_a_of_type_Lbt.a(paramVideoAppInterface);
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
      if ((this.jdField_i_of_type_Int == 0) && (lzb.e(paramVideoAppInterface.getApp()))) {
        this.jdField_i_of_type_Int = 1;
      }
      this.jdField_a_of_type_Mua = mua.a(this.jdField_a_of_type_AndroidContentContext, this);
      if (this.x) {
        J();
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
      this.jdField_a_of_type_Lbt.a(paramAVUserInfo.account);
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
      localObject1 = new lcp();
      ((lcp)localObject1).jdField_a_of_type_Long = paramAVUserInfo.account;
      ((lcp)localObject1).jdField_d_of_type_Int = paramAVUserInfo.accountType;
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
      localObject1 = (lcp)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
    }
    for (;;)
    {
      a(paramAVUserInfo.account, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      t();
      if ((localObject1 == null) || (((lcp)localObject1).jdField_e_of_type_Boolean) || (!((lcp)localObject1).jdField_g_of_type_Boolean)) {
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
      ((Set)localObject1).add(Long.valueOf(((lcp)((Iterator)localObject2).next()).jdField_a_of_type_Long));
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
        lcp locallcp = new lcp();
        locallcp.jdField_d_of_type_Int = 0;
        locallcp.jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        locallcp.jdField_h_of_type_Boolean = false;
        locallcp.jdField_d_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.jdField_b_of_type_JavaUtilArrayList.add(locallcp);
        paramInt1 = 1;
        i2 = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver add member UIN:" + locallcp.jdField_a_of_type_Long);
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
        localObject2 = (lcp)((Iterator)localObject1).next();
      } while (((lcp)localObject2).jdField_a_of_type_Long != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i1 = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver remove member UIN:" + ((lcp)localObject2).jdField_a_of_type_Long);
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
    boolean bool2 = false;
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo closeVideo begin, peerUin[" + paramString + "], emCloseReason[" + paramInt + "], seq[" + l1 + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "]", new Throwable("打印调用栈"));
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((!q()) && (this.jdField_a_of_type_Lbu.b()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mtv.a(a()).b();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if ((1 != c()) && (!e()))
    {
      a(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Lbx != null) {
      this.jdField_a_of_type_Lbx.b();
    }
    this.jdField_h_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    if ((q()) && (paramInt != 110)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((lcv)localObject).a(paramInt);
    }
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    localObject = a().jdField_d_of_type_JavaLangString;
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
          GraphicRenderMgr.getInstance().setGlRender(paramString, null);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "avideo closeVideo, clear gl render, key[" + paramString + "]");
          }
          a(l1, a().jdField_d_of_type_Int, true, true);
        }
        d(paramInt);
        msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
        bool1 = true;
      }
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo closeVideo end, result[" + i1 + "], cancelNotificationForce[" + bool1 + "], seq[" + l1 + "]");
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
    paramString1 = a();
    label219:
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
        boolean bool2 = paramString1.jdField_k_of_type_Boolean;
        if (paramString1.jdField_h_of_type_Boolean) {
          break label304;
        }
        bool1 = true;
        label247:
        a(paramInt1, bool2, bool1);
      }
    }
    for (;;)
    {
      paramString2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(this, paramString1);
      return;
      paramString2 = new VideoController.14(this, paramString1);
      this.jdField_a_of_type_JavaUtilList.add(paramString2);
      break label219;
      label304:
      bool1 = false;
      break label247;
      if (paramString1.ai) {
        a(paramString1.jdField_d_of_type_JavaLangString, paramInt2, paramInt3, paramString2, paramLong);
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
    paramString = lbu.a().a(paramString);
    if (paramString != null)
    {
      paramString.b(paramInt2);
      paramString.c(paramInt1);
      paramString.d(paramLong);
    }
    a("onPeerSwitchTerminal", a());
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
    lez locallez = a();
    int i2 = locallez.F;
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
      locallez = a();
    }
    for (;;)
    {
      locallez.x = paramInt1;
      locallez.y = paramInt2;
      locallez.jdField_n_of_type_JavaLangString = paramString2;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onChannelReady, fromUin[" + paramString1 + "], hdModeFreeUseStartTime[" + paramInt1 + "], hdModeFreeUseEndTime[" + paramInt2 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], session[" + locallez + "]");
      lhw.a(30);
      lhw.a(9, locallez.b());
      lhw.a(11, locallez.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mtv.a(a()).a();
      if (1L == locallez.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Mua.b(l1);
        if ((locallez.S) && (locallez.jdField_e_of_type_Boolean) && (!l())) {
          this.jdField_a_of_type_Mua.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        a(true, locallez.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Mua.b(l1);
      if (locallez.jdField_j_of_type_Int != 1011) {
        mua.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
      }
      locallez.b(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
      locallez.c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
      locallez.d(paramLong);
      j();
      locallez.jdField_h_of_type_Int = locallez.jdField_g_of_type_Int;
      locallez.a("onChannelReady", 4);
      locallez.a(l1, SystemClock.elapsedRealtime());
      if ((locallez.jdField_e_of_type_Boolean) && (!l()))
      {
        if (locallez.S) {
          this.jdField_a_of_type_Mua.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        label501:
        if ((locallez.jdField_d_of_type_Int == 1) && (locallez.jdField_j_of_type_Int == 1011))
        {
          locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 5;
          a(locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int, 1, null);
        }
        paramString2 = (lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!locallez.jdField_e_of_type_Boolean) {
          break label883;
        }
        paramInt1 = 11;
        label568:
        paramString2.a(locallez.b(), paramInt1, 1L);
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
          if (l()) {
            a(l1, 2131230736, 1, null);
          }
        }
        b();
        if (!locallez.jdField_g_of_type_Boolean) {
          break label888;
        }
        a(true, locallez.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l1), 50L);
        a(locallez.jdField_c_of_type_JavaLangString, locallez.jdField_d_of_type_Int, true, true, true);
        mrd.i(this);
        mrd.c(this, true);
        mrd.b(this, true);
        paramLong = f();
        paramString2 = bfyz.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        paramString2.edit().putLong("qav_roomid", paramLong).commit();
        paramLong = c(paramString1);
        paramString2.edit().putLong(lcc.g, paramLong).commit();
        o(false);
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a();
        }
        if (this.jdField_a_of_type_Lbx != null) {
          this.jdField_a_of_type_Lbx.a();
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
          break;
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 == null) {
          break;
        }
        paramString1.a(locallez);
        return;
        if (this.jdField_a_of_type_Mua.a()) {
          break label501;
        }
        this.jdField_a_of_type_Mua.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label501;
        label883:
        paramInt1 = 4;
        break label568;
        label888:
        a(false, locallez.jdField_d_of_type_JavaLangString);
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
    localObject3 = this.jdField_a_of_type_Lbu.c(paramString1);
    if (localObject3 == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      return;
    }
    if (paramInt2 == 21) {
      if ((((lez)localObject3).jdField_i_of_type_Int == 11) || (((lez)localObject3).jdField_i_of_type_Int == 12))
      {
        paramInt2 = 47;
        ((lez)localObject3).a(1, 0);
        paramInt1 = 0;
      }
    }
    label523:
    label926:
    label933:
    for (;;)
    {
      boolean bool = false;
      if ((((lez)localObject3).j()) && (paramInt2 == 1)) {
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
        ((Intent)localObject2).putExtra("bindType", ((lez)localObject3).A);
        ((Intent)localObject2).putExtra("bindId", ((lez)localObject3).jdField_p_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("MultiAVType", ((lez)localObject3).D);
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
        if (((lez)localObject3).J)
        {
          if (!((lez)localObject3).M) {
            break label831;
          }
          localObject1 = paramString1;
        }
        ((Intent)localObject2).putExtra("friendUin", paramString2);
        ((Intent)localObject2).putExtra("senderUin", (String)localObject1);
        ((Intent)localObject2).putExtra("selfUin", paramString1);
        if (((lez)localObject3).jdField_e_of_type_Boolean) {
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
        if ((((lez)localObject3).jdField_i_of_type_Int == 16) || (((lez)localObject3).jdField_i_of_type_Int == 17)) {}
        for (paramInt2 = 47;; paramInt2 = 48)
        {
          ((lez)localObject3).a(1, 0);
          paramInt1 = 0;
          break;
        }
        if (((lez)localObject3).l()) {
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
        if (((lez)localObject3).jdField_e_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          localObject1 = paramString3;
          paramString3 = paramString2;
          paramString2 = (String)localObject1;
          break;
        }
        if (((lez)localObject3).jdField_e_of_type_Boolean) {}
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
        if (((lez)localObject3).jdField_e_of_type_Long > 0L)
        {
          paramString1 = mum.a(a());
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
    lez locallez = this.jdField_a_of_type_Lbu.b(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l1 + "], Main[" + this.jdField_a_of_type_Lbu.a() + "], come[" + locallez + "]");
    if (locallez == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], no session");
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lcv)localObject).a(paramInt);
      }
      if (q()) {
        C();
      }
      if (((locallez.jdField_j_of_type_Int != 1011) && (locallez.jdField_j_of_type_Int != 21)) || (!locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Boolean)) {
        break;
      }
      lba.g(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Boolean);
      locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0, this);
    } while ((q()) && ((paramInt == 2) || (paramInt == 3)));
    d(paramInt);
    return;
    y(locallez.jdField_c_of_type_JavaLangString);
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
        if (locallez.jdField_d_of_type_Int != 2) {
          break label798;
        }
        bcef.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
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
          a(locallez.jdField_j_of_type_Int, locallez.jdField_d_of_type_JavaLangString, locallez.jdField_i_of_type_Long, 0);
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
          if (locallez.jdField_d_of_type_Int == 2)
          {
            bcef.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          bcef.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
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
          bcef.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
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
          break label1103;
        }
        paramInt = 63;
        break;
        label798:
        bcef.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = lbu.a(3, paramString, new int[0]);
        locallez = null;
        if (this.jdField_a_of_type_Lbu.a((String)localObject)) {
          locallez = this.jdField_a_of_type_Lbu.c((String)localObject);
        }
        if ((locallez != null) && (locallez.jdField_g_of_type_Int == 1))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, set autoAcceptChat, seq[" + l1 + "]");
          locallez.jdField_d_of_type_Boolean = true;
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
        locallez.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 12);
        return;
      }
      if (paramLong == 61L)
      {
        locallez.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 25);
        return;
      }
      paramInt = 64;
      break;
      paramInt = 62;
      a(l1, paramString, 62);
      break;
      label1103:
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
              bcef.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
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
      if (this.jdField_a_of_type_Lbu != null)
      {
        paramString = this.jdField_a_of_type_Lbu.c(paramString);
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
    paramString = lfl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    Object localObject = lbu.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_Lbu.c((String)localObject);
    if (localObject != null) {
      ((lez)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
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
      lcy.a();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    lcy.a(paramLong3);
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
        paramLong = mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
            a().jdField_a_of_type_Lfa.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          a().jdField_a_of_type_Lfa.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int != 3) {
          break;
        }
        lcp locallcp = a(paramString);
        if (locallcp != null)
        {
          locallcp.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lfa.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    lba.g(jdField_a_of_type_JavaLangString, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    lez locallez = null;
    if (this.jdField_a_of_type_Lbu != null) {
      locallez = this.jdField_a_of_type_Lbu.c(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (String str = "mApp is null";; str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + locallez + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (locallez != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", locallez.A);
    paramString1.putExtra("bindId", locallez.jdField_p_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", locallez.jdField_d_of_type_Int);
    paramString1.putExtra("isDoubleVideoMeeting", locallez.J);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(lcc.jdField_d_of_type_JavaLangString, locallez.jdField_e_of_type_Long);
    paramString1.putExtra(lcc.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
    paramString1.putExtra(lcc.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", a());
    long l1 = 0L;
    if ((locallez.jdField_d_of_type_Int == 1) || (locallez.jdField_d_of_type_Int == 2)) {
      l1 = 1L;
    }
    if ((locallez.jdField_d_of_type_Int == 3) || (locallez.jdField_d_of_type_Int == 4)) {
      l1 = 2L;
    }
    paramString1.putExtra(lcc.i, l1);
    if ((locallez.jdField_d_of_type_Int == 1) || (locallez.jdField_d_of_type_Int == 3)) {}
    for (l1 = 1L;; l1 = 0L)
    {
      paramString1.putExtra(lcc.j, l1);
      if (this.jdField_a_of_type_Lbu.c(paramString2).l != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_Lbu.c(paramString2).l);
      }
      if (this.jdField_a_of_type_Lbu.c(paramString2).jdField_m_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_Lbu.c(paramString2).jdField_m_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_Lbu.c(paramString2).F);
        paramString1.putExtra("relationId", this.jdField_a_of_type_Lbu.c(paramString2).jdField_g_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label661;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        llf.a().a.a();
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
          a().jdField_a_of_type_Lfa.g = paramString2;
        }
        lcp locallcp;
        for (;;)
        {
          if (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int != 3) {
            break label195;
          }
          locallcp = a(paramString1);
          if (locallcp == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          locallcp.jdField_b_of_type_JavaLangString = paramString2;
          return;
          a().jdField_a_of_type_Lfa.jdField_f_of_type_JavaLangString = paramString2;
        }
        locallcp.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lfa.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().T = paramBoolean;
    if (paramBoolean) {
      mrd.o(this);
    }
    if (msm.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
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
        localObject = (lcp)localIterator.next();
        if ((((lcp)localObject).jdField_d_of_type_Int == 1) && (((lcp)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((lcp)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
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
  
  void a(lcp paramlcp, int paramInt)
  {
    paramlcp.jdField_b_of_type_Int = 0;
    paramlcp.jdField_b_of_type_Boolean = false;
    paramlcp.jdField_c_of_type_Boolean = false;
    paramlcp.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramlcp.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramlcp.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramlcp.jdField_b_of_type_Int = 1;
      return;
    }
    paramlcp.jdField_d_of_type_Boolean = true;
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
        msw localmsw = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localmsw != null) {
          localmsw.a(paramVarArgs.jdField_c_of_type_JavaLangString);
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
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(((lez)localObject).jdField_b_of_type_Boolean).append("->").append(paramBoolean2).append("], deviceName[").append(((lez)localObject).jdField_q_of_type_JavaLangString).append("], audioStateBeforePhoneCall[").append(((lez)localObject).t).append("], mTraeHelper[");
    if (this.jdField_a_of_type_Mua != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Mua != null) {
        break;
      }
      return;
    }
    if ((((lez)localObject).jdField_g_of_type_Int != 0) && (((lez)localObject).jdField_g_of_type_Int != 5) && (((lez)localObject).jdField_g_of_type_Int != 6) && (((lez)localObject).jdField_b_of_type_Boolean != paramBoolean2))
    {
      ((lez)localObject).jdField_b_of_type_Boolean = paramBoolean2;
      if (!paramBoolean2) {
        break label225;
      }
      this.jdField_a_of_type_Mua.b();
      ((lez)localObject).t = ((lez)localObject).jdField_q_of_type_JavaLangString;
    }
    while (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label225:
      if ("DEVICE_SPEAKERPHONE".equals(((lez)localObject).t))
      {
        this.jdField_a_of_type_Mua.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else if ("DEVICE_EARPHONE".equals(((lez)localObject).t))
      {
        this.jdField_a_of_type_Mua.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (((lez)localObject).jdField_d_of_type_Int == 1) {}
        for (localObject = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; localObject = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
        {
          this.jdField_a_of_type_Mua.a((String)localObject);
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i1 = llf.a().a(paramArrayOfByte);
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
      if ((this.jdField_a_of_type_ArrayOfMnz != null) && (this.jdField_a_of_type_ArrayOfMnz[0] != null)) {
        this.jdField_a_of_type_ArrayOfMnz[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      if (mqw.a()) {
        mqw.a().a(paramArrayOfByte, paramInt1, paramInt2);
      }
      return;
      if (((paramInt1 == 3) || (paramInt1 == 0) || (paramInt1 == 8)) && (this.jdField_a_of_type_ArrayOfMnz != null) && (this.jdField_a_of_type_ArrayOfMnz[1] != null)) {
        this.jdField_a_of_type_ArrayOfMnz[1].a(paramArrayOfByte, paramInt1, paramInt2);
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
      long l1 = mrb.a(str);
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
    lez locallez = a();
    String str = lbu.a(3, paramString, new int[0]);
    if (TextUtils.equals(locallez.jdField_c_of_type_JavaLangString, str)) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt == 1011) && (locallez.jdField_j_of_type_Int == paramInt) && (TextUtils.equals(locallez.jdField_d_of_type_JavaLangString, paramString)));
      paramInt = this.jdField_a_of_type_Lbu.a();
      if (paramInt >= 2)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDAV, to many session, reject. [" + paramInt + "]");
        return true;
      }
    } while ((!locallez.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()));
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
    paramBoolean = this.jdField_a_of_type_Lbt.a(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + lcc.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      }
      if (this.jdField_a_of_type_Lbu.a() < 2) {
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
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((a().jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int == 3))
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
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (a().jdField_a_of_type_Lfa.jdField_b_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo  auto Accept");
        }
        if ((a().jdField_a_of_type_Lfa.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_Lfa.jdField_c_of_type_JavaLangString.equals(paramString1))) {
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
          lba.g(jdField_a_of_type_JavaLangString, "isRequestVideo when request: fromUin = " + paramString1);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo orientation: " + this.jdField_n_of_type_Int + ", isQQPaused: " + lcc.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
    }
    return true;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {}
    lez locallez;
    do
    {
      String str;
      do
      {
        return false;
        str = lbu.a(100, String.valueOf(paramLong), new int[0]);
        locallez = a();
      } while (TextUtils.equals(str, locallez.jdField_c_of_type_JavaLangString));
      paramInt1 = this.jdField_a_of_type_Lbu.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDM, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!locallez.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()));
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
        lcp locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((locallcp == null) || (locallcp.jdField_a_of_type_Long != paramLong)) {
          break label186;
        }
        locallcp.jdField_e_of_type_Boolean = paramBoolean;
        locallcp.jdField_d_of_type_Int = paramInt1;
        bool = locallcp.jdField_g_of_type_Boolean;
        if (paramBoolean)
        {
          locallcp.jdField_g_of_type_Boolean = false;
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
  
  boolean a(long paramLong, int paramInt, ArrayList<lno> paramArrayList)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramArrayList.size())
      {
        if ((((lno)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((lno)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
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
  
  public boolean a(String paramString, lez paramlez)
  {
    boolean bool2;
    if (paramlez == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i1 = paramlez.e();
    long l1 = paramlez.b();
    long l2 = paramlez.f();
    long l3;
    if (i1 == 2)
    {
      l3 = a(paramlez);
      if (l3 != paramlez.b()) {
        paramlez.d(l3);
      }
    }
    for (;;)
    {
      l3 = paramlez.b();
      long l4 = paramlez.f();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramlez, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i1 == 1)
      {
        l3 = b(paramlez);
        if (l3 != paramlez.b()) {
          paramlez.d(l3);
        }
      }
    }
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    lez locallez = a();
    String str;
    boolean bool;
    if (paramBoolean) {
      if (paramInt == 3)
      {
        str = lbu.a(100, paramString2, new int[0]);
        if (TextUtils.equals(locallez.jdField_c_of_type_JavaLangString, str)) {
          break label231;
        }
        bool = lbu.a().b(str);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkMainSession, need reset main session, from[" + paramString1 + "], cur" + locallez.jdField_c_of_type_JavaLangString + "], coming[" + str + "], ret[" + bool + "]");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMainSession, from[" + paramString1 + "], isFromMAVEngine[" + paramBoolean + "], relationType[" + paramInt + "], relationId[" + paramString2 + "], ret[" + bool + "]");
      }
      return bool;
      str = lbu.a(paramInt, paramString2, new int[0]);
      break;
      str = lbu.a(paramInt, paramString2, new int[0]);
      break;
      label231:
      bool = false;
    }
  }
  
  public boolean a(lez paramlez1, lez paramlez2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlez1.jdField_d_of_type_JavaLangString);
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
          paramlez2.a(paramLong1, paramlez1.jdField_j_of_type_Boolean);
          a(paramString, paramlez2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_e_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          }
          if (!paramlez1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          int i1 = paramlez1.jdField_d_of_type_Int;
          paramlez2.aE = true;
          paramlez2.jdField_d_of_type_JavaLangString = paramlez1.jdField_d_of_type_JavaLangString;
          if ((paramlez1.jdField_g_of_type_Int == 15) || (paramlez1.jdField_K_of_type_Boolean)) {
            f(false);
          }
          paramlez1.a(3, 12);
          if (i1 == 1)
          {
            paramlez1.a(paramLong1, "onGAudioInvite.6", 3);
            paramlez1.jdField_j_of_type_Int = mum.c(paramInt);
            paramlez1.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlez1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlez1.c("onGAudioInvite.1", 1);
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.a() <= 0) {
                break label522;
              }
              paramlez1.d("onGAudioInvite3", mqu.a(paramlez1.jdField_j_of_type_Int));
              localVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramlez2 = msw.a(localVideoAppInterface);
            int i2 = 0;
            if (paramlez2 != null)
            {
              boolean bool2 = paramlez2.a();
              i2 = bool2;
              if (bool2)
              {
                paramlez2.a(paramlez1.jdField_c_of_type_JavaLangString);
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
            paramlez1.a(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i1 != 4) {
            break label510;
          }
        }
        catch (Exception paramlez1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramlez1.getMessage());
          }
          this.jdField_a_of_type_Lbu.a(paramLong1, paramString);
          return bool1;
        }
        paramlez1.a(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label510:
        paramlez1.a(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label522:
        if (localThrowable.isBackgroundStop)
        {
          paramlez1.d("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          m(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramlez1.L))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramlez1.L + "], ret[" + bool1 + "], main[" + paramlez1 + "], new[" + paramlez2 + "]");
      }
      paramlez1.L = false;
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
      K();
      i1 = 0;
      if (i1 >= a().jdField_e_of_type_JavaUtilArrayList.size()) {
        break label334;
      }
      if (((lno)a().jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
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
          lcp locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(i3);
          if ((locallcp != null) && (locallcp.jdField_a_of_type_Long != mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
          {
            int i2 = i1;
            if (locallcp.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (locallcp.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            if (locallcp.jdField_c_of_type_Boolean) {
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
    lba.g(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
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
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    int i1 = -1;
    lez locallez = lbu.a().a(paramString);
    if ((locallez != null) && (locallez.d() != -1)) {
      i1 = locallez.d();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
  }
  
  public int b(lez paramlez, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramlez, paramString);
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
      long l1 = mrb.a(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      lba.h(jdField_a_of_type_JavaLangString, paramString.getMessage());
    }
    return -1L;
  }
  
  public long b(lez paramlez)
  {
    if (paramlez == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramlez.jdField_d_of_type_Int == 3) || (paramlez.jdField_d_of_type_Int == 4)))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramlez.F, paramlez.D, paramlez.jdField_g_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramlez.d(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramlez.d(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramlez.b();
  }
  
  public ArrayList<lcp> b()
  {
    if ((AudioHelper.e()) && (mpk.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(mpk.jdField_a_of_type_JavaUtilArrayList);
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
        msw localmsw = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((lez)localObject2).jdField_e_of_type_Boolean) {
          break label306;
        }
        if (((lez)localObject2).j())
        {
          if ((((lez)localObject2).jdField_d_of_type_Int == 1) || (((lez)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((lez)localObject2).S) && (!((lez)localObject2).J))
            {
              i1 = 56;
              if ((((lez)localObject2).jdField_j_of_type_Int != 1011) && (!l())) {
                break label372;
              }
              i1 = ((lez)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label665;
              }
              if (((lez)localObject2).F != 7) {
                break label695;
              }
              i1 = i2;
              if (((lez)localObject2).jdField_a_of_type_Lfa.jdField_b_of_type_Int <= 4) {
                break label344;
              }
              i2 = 52;
              if (this.jdField_f_of_type_Boolean)
              {
                i2 = 60;
                s();
              }
              localmsw.a(((lez)localObject2).jdField_c_of_type_JavaLangString, "", null, null, i2, ((lez)localObject2).jdField_j_of_type_Int, i1);
              r();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((lez)localObject2).jdField_g_of_type_Long);
          localObject4 = ((lez)localObject2).jdField_d_of_type_JavaLangString;
          localObject2 = ((lez)localObject2).jdField_c_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localmsw.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.12(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((lez)localObject2).jdField_d_of_type_Int != 1) {
          break label671;
        }
      }
      finally {}
      int i1 = 47;
      label306:
      if (((lez)localObject2).l())
      {
        if (((lez)localObject2).jdField_d_of_type_Int != 1) {
          break label680;
        }
        i1 = 47;
      }
      else
      {
        if (((lez)localObject2).jdField_d_of_type_Int != 1) {
          break label689;
        }
        i1 = 46;
        break label686;
        label344:
        localObject1.a(((lez)localObject2).jdField_c_of_type_JavaLangString, "", null, null, 51, ((lez)localObject2).jdField_j_of_type_Int, i1);
        s();
        continue;
        label372:
        if ((((lez)localObject2).jdField_d_of_type_Int == 3) || (((lez)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((lez)localObject2).J)
          {
            localObject3 = ((lez)localObject2).jdField_e_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((lez)localObject2).jdField_d_of_type_JavaLangString, null, true, true);
            localObject1.a(((lez)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lez)localObject2).jdField_g_of_type_Long), 48, 0, ((lez)localObject2).jdField_d_of_type_Int);
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a().jdField_j_of_type_Int, String.valueOf(a().jdField_g_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lez)localObject2).jdField_j_of_type_Int, String.valueOf(((lez)localObject2).jdField_g_of_type_Long), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((lez)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lez)localObject2).jdField_g_of_type_Long), 44, ((lez)localObject2).jdField_j_of_type_Int, ((lez)localObject2).jdField_d_of_type_Int);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this), 1000L);
          continue;
        }
        if (((lez)localObject2).jdField_e_of_type_JavaLangString == null) {
          ((lez)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(((lez)localObject2).jdField_j_of_type_Int, ((lez)localObject2).jdField_d_of_type_JavaLangString, ((lez)localObject2).jdField_f_of_type_JavaLangString);
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lez)localObject2).jdField_j_of_type_Int, ((lez)localObject2).jdField_d_of_type_JavaLangString, ((lez)localObject2).jdField_f_of_type_JavaLangString, true, true);
        localObject1.a(((lez)localObject2).jdField_c_of_type_JavaLangString, ((lez)localObject2).jdField_e_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((lez)localObject2).jdField_j_of_type_Int, ((lez)localObject2).jdField_d_of_type_Int);
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
    String str = lbu.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = lbu.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_a_of_type_Lbu.a(str)) {}
    for (Object localObject = this.jdField_a_of_type_Lbu.c(str);; localObject = null)
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
          if (this.jdField_a_of_type_Mua != null) {
            this.jdField_a_of_type_Mua.b(l1);
          }
          mua.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          mua.a().b();
          if ((AudioHelper.f()) || (((lez)localObject).ar)) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, \nmainsession[" + a() + "], \nstate[" + ((lez)localObject).jdField_g_of_type_Int + "], seq[" + l1 + "], isAcceptingMultiAV[" + ((lez)localObject).ar + "], isCurJoinedGRoom[" + a(paramInt, paramLong) + "]");
          }
        } while (((lez)localObject).ar);
        if (this.jdField_d_of_type_Long == paramLong)
        {
          this.jdField_d_of_type_Long = 0L;
          this.jdField_h_of_type_Int = 0;
        }
        if ((paramInt != 3) || (!((lez)localObject).J) || ((((lez)localObject).jdField_d_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((lez)localObject).jdField_d_of_type_JavaLangString).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((lez)localObject).jdField_d_of_type_JavaLangString + " ,relationId = " + paramLong);
      return;
      if ((!((lez)localObject).ah) && (!((lez)localObject).J))
      {
        int i1 = 6;
        if (((lez)localObject).jdField_g_of_type_Int == 7) {
          i1 = 5;
        }
        a("onGAudioRoomDestroy", str, mum.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((lez)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
      if (a(paramInt, paramLong)) {
        a(paramInt, paramLong, 69);
      }
      ((lez)localObject).a("onGAudioRoomDestroy", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_a_of_type_Lbu.a(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_Lbu.c(str);
          paramInt = mum.c(paramInt);
          a(((lez)localObject).jdField_c_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_a_of_type_Lbu.a(l1, str))
        {
          localObject = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject != null) && (((msw)localObject).a()))
          {
            ((msw)localObject).a(str);
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
    lez locallez = a();
    if (locallez.ao) {}
    while (locallez.b(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < locallez.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((lno)locallez.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((lno)locallez.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((lno)locallez.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
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
    String str = bgdt.a(l1, 3);
    if (new File(str).exists())
    {
      mua.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_f_of_type_Boolean = true;
      int i1 = a().jdField_p_of_type_Int;
      bcef.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    mua.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
    a().jdField_f_of_type_Boolean = true;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_Lbu.a();
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
      localObject1 = lbu.a(100, String.valueOf(paramLong), new int[0]);
      this.jdField_a_of_type_Lbu.a((String)localObject1, false);
      lcc.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
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
      this.jdField_a_of_type_Lbu.c((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
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
      Object localObject2 = this.jdField_a_of_type_Lbu.c((String)localObject1);
      if (localObject2 != null)
      {
        ((lez)localObject2).S = true;
        ((lez)localObject2).jdField_f_of_type_Int = 2;
        ((lez)localObject2).jdField_j_of_type_Int = 0;
        ((lez)localObject2).F = 3;
        ((lez)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        ((lez)localObject2).jdField_f_of_type_JavaLangString = null;
        ((lez)localObject2).jdField_e_of_type_Boolean = true;
        ((lez)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
        ((lez)localObject2).e("onDoubleVideoMeetingInvite", true);
        ((lez)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong);
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
      new bjlr(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_Lbu.a(l1, (String)localObject1);
      return;
      if ((a().o()) || (a().p()) || (a().q()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_d_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_Lbu.c((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.jdField_n_of_type_Int + "], isQQPaused[" + lcc.jdField_b_of_type_Boolean + "], isVideoPaused[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(a()) + "], seq[" + l1 + "]");
    }
    if ((this.x) && (this.jdField_n_of_type_Int == 0) && (!bool2) && (lcc.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.24(this, l1, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
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
      QQToast.a(a(), 2131695203, 1).a();
    }
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<lnl> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.29(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = lbu.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_Lbu.a(str)) {}
      for (lez locallez = this.jdField_a_of_type_Lbu.c(str); locallez == null; locallez = this.jdField_a_of_type_Lbu.c(str))
      {
        QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        lhw.a(0L, 33);
        lhw.b(0L);
        return;
        str = lbu.a(100, paramString, new int[0]);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ljt)localObject).a(locallez);
      }
      lhw.a(locallez.b(), 16, 0L);
      lhw.a(locallez.b(), 33);
      lhw.b(locallez.b());
      localObject = (lhy)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (locallez.jdField_e_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((lhy)localObject).a(locallez.b(), i2, i1 + 500);
        ((lhy)localObject).a("NoCrash");
        ((lhy)localObject).a(locallez.b(), 29, 1L);
        ((lhy)localObject).a(36, 1L);
        ((lhy)localObject).b(locallez.b());
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + locallez.f() + "], sessionInfo.peerUin[" + locallez.jdField_d_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + locallez.S + "], sessionInfo.SessionType[" + locallez.jdField_d_of_type_Int + "], mNetTrafficAllSize[" + this.jdField_b_of_type_Long + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!locallez.f()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((locallez.jdField_d_of_type_Int == 2) && (!locallez.J) && (locallez.jdField_g_of_type_Int >= 4) && (locallez.jdField_e_of_type_Long > 0L))
      {
        i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
        lba.g(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + locallez.jdField_e_of_type_Long + " | " + locallez.jdField_g_of_type_Int + " | " + locallez.u);
        if ((locallez.u) || (i2 > 0)) {
          bcef.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_s_of_type_Boolean) && (a() > 0L))
      {
        if (locallez.jdField_d_of_type_Int == 1) {
          bcef.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", mum.a(a()), "");
        }
      }
      else
      {
        label763:
        locallez.jdField_d_of_type_Long = 0L;
        locallez.jdField_o_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(locallez.jdField_d_of_type_JavaLangString))
        {
          localObject = paramString;
          if (locallez.jdField_d_of_type_JavaLangString.contains(paramString)) {
            localObject = locallez.jdField_d_of_type_JavaLangString;
          }
        }
        if ((locallez.o()) || (locallez.p())) {
          locallez.z = i1;
        }
        if ((locallez.h()) || ((locallez.j()) && (i1 == locallez.z))) {
          locallez.a(paramLong, 0L);
        }
        if ((locallez.ai) && (this.jdField_f_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1585;
        }
        paramBoolean = false;
        if (locallez.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(locallez.jdField_c_of_type_JavaLangString, locallez.jdField_j_of_type_Int, paramBoolean, locallez.jdField_d_of_type_JavaLangString, locallez.jdField_f_of_type_JavaLangString);
        label949:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_Lbu.a())
        {
          h();
          j();
          s();
        }
        locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Boolean = false;
        locallez.jdField_a_of_type_Lfa.jdField_a_of_type_JavaLangString = null;
        locallez.jdField_a_of_type_Lfa.jdField_b_of_type_JavaLangString = null;
        locallez.jdField_a_of_type_Lfa.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          mrd.b(this, false);
          mrd.c(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            mrd.l(this);
          }
        }
        locallez.a("doCloseSession", 0);
        locallez.a(paramLong, "doCloseSession", 0);
        locallez.jdField_f_of_type_Int = 0;
        locallez.jdField_a_of_type_JavaUtilBitSet.clear();
        locallez.jdField_j_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        locallez.av = false;
        locallez.jdField_a_of_type_ArrayOfJavaLangString = null;
        locallez.b("doCloseSession", null);
        locallez.jdField_p_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + locallez.jdField_j_of_type_Int + " # matchStatus = " + locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (i1 != 72) && (locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          locallez.jdField_j_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1599;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1261:
        if ((locallez.jdField_j_of_type_Int != 1011) || ((locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int != 2) && (locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int != 6))) {
          break label1626;
        }
        if ((!this.jdField_f_of_type_Boolean) && (locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int != 6)) {
          break label1609;
        }
        a(6, 1, null);
        label1325:
        this.jdField_a_of_type_Boolean = false;
        label1330:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((locallez.jdField_a_of_type_Lfa.jdField_a_of_type_Int == 1) || (locallez.jdField_a_of_type_Lfa.jdField_a_of_type_Int == 2)))
        {
          locallez.a();
          a(0, 0, null);
        }
        locallez.a(paramLong, false);
        locallez.b(paramLong, false);
        locallez.a(paramLong, 0L);
        locallez.b(paramLong);
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1644;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_Lbu.a(paramLong, str);
      }
      for (;;)
      {
        paramString = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str);
        if (!paramBoolean) {
          break;
        }
        b();
        return;
        if (locallez.jdField_d_of_type_Int != 2) {
          break label763;
        }
        bcef.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", mum.a(a()), "");
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
        a(locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int, 1, null);
        break label1325;
        label1626:
        if (!this.jdField_f_of_type_Boolean) {
          break label1330;
        }
        a(6, 1, null);
        break label1330;
        label1644:
        this.jdField_a_of_type_Lbu.a(str, 3);
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
    mua.a().b(l1);
    mua.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (d(paramString)) {
      mua.a().b();
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
  
  public void b(ArrayList<mwe> paramArrayList)
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
        if ((((mwe)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((mwe)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((mwe)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
          a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((mwe)paramArrayList.get(i1)).jdField_a_of_type_Long));
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
    boolean bool2 = r();
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGameMode isQQPaused: " + bool3 + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isLandscape: " + bool2 + ", isScreenLocked: " + bool1);
    }
    return (!bool1) && (bool2) && (bool3) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
  }
  
  public boolean b(int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramInt2 == 5) || (paramInt2 == 4) || (paramInt2 == 3)) {}
    lez locallez;
    do
    {
      do
      {
        return false;
        locallez = this.jdField_a_of_type_Lbu.a();
      } while ((locallez.F == paramInt1) && (locallez.jdField_g_of_type_Long == paramLong));
      paramInt1 = this.jdField_a_of_type_Lbu.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!locallez.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()));
    QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
    return true;
  }
  
  public boolean b(String paramString)
  {
    int i1 = b(paramString);
    return (i1 == 5) || (i1 == 14);
  }
  
  public boolean b(lez paramlez1, lez paramlez2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlez1.jdField_d_of_type_JavaLangString);
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
          paramlez2.a(paramLong1, paramlez1.jdField_j_of_type_Boolean);
          a(paramString, paramlez2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramlez1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          i1 = paramlez1.jdField_d_of_type_Int;
          paramlez2.jdField_d_of_type_JavaLangString = paramlez1.jdField_d_of_type_JavaLangString;
          paramlez2.a(paramLong1, paramlez1.jdField_j_of_type_Boolean);
          paramlez2.jdField_g_of_type_Boolean = paramlez1.jdField_g_of_type_Boolean;
          paramlez2.b("onGAudioInvite", paramlez1.jdField_P_of_type_Boolean);
          paramlez2.b("onGAudioInvite", paramlez1.jdField_q_of_type_JavaLangString);
          paramlez2.aE = true;
          paramlez2.a(3, 12);
          paramlez1.a(3, 12);
          b(paramlez1.jdField_d_of_type_JavaLangString, 21);
          if (i1 == 1)
          {
            paramlez2.a(paramLong1, "onGAudioInvite.2", 3);
            paramlez2.jdField_j_of_type_Int = mum.c(paramInt);
            paramlez2.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlez2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlez2.c("onGAudioInvite.2", 1);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
              break label547;
            }
            paramlez2.d("onGAudioInvite1", mqu.a(paramlez2.jdField_j_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramlez1 = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            int i2 = 0;
            if (paramlez1 != null)
            {
              boolean bool2 = paramlez1.a();
              i2 = bool2;
              if (bool2)
              {
                paramlez1.a(paramString);
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
        catch (Exception paramlez1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramlez1);
          }
          this.jdField_a_of_type_Lbu.a(paramLong1, paramString);
          return bool1;
        }
        if (i1 == 2)
        {
          paramlez2.a(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i1 == 4)
        {
          paramlez2.a(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramlez2.a(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label547:
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop)
          {
            paramlez2.d("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            m(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramlez1 != paramlez2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramlez1 + "], new[" + paramlez2 + "]");
      }
      if (!bool1) {
        break label586;
      }
      if (paramlez1.z != 0) {
        break label164;
      }
      paramlez1.a("onGAudioInvite.2", 0);
      this.jdField_a_of_type_Lbu.a(paramLong1, paramString);
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
    return lep.a();
  }
  
  public int c(String paramString)
  {
    int i1 = -1;
    lez locallez = lbu.a().a(paramString);
    if ((locallez != null) && (locallez.c() != -1)) {
      i1 = locallez.c();
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
  
  public ArrayList<lcp> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.e()) && (mpk.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(mpk.jdField_a_of_type_JavaUtilArrayList);
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
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", a().jdField_j_of_type_Int);
      localIntent.putExtra("peerUin", a().jdField_d_of_type_JavaLangString);
      localIntent.putExtra("extraUin", a().jdField_f_of_type_JavaLangString);
      localIntent.putExtra("relationType", a().F);
      localIntent.putExtra("relationId", a().jdField_g_of_type_Long);
      localIntent.putExtra("isDoubleVideoMeeting", a().J);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
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
          localObject = (lno)a().jdField_c_of_type_JavaUtilArrayList.get(i2);
          int i1;
          if (a()) {
            if (((lno)localObject).jdField_a_of_type_Int == 1)
            {
              i1 = 1;
              label178:
              if ((((lno)localObject).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (i1 == 0)) {
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
            if (a(((lno)localObject).jdField_a_of_type_Long, ((lno)localObject).jdField_a_of_type_Int, a().jdField_e_of_type_JavaUtilArrayList)) {
              ((lno)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((lno)localObject).jdField_b_of_type_Boolean = false;
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
    lba.f(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
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
    paramInt2 = mum.c(paramInt1);
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
      bcef.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().J) {
        bcef.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      lez locallez = a();
      if ((locallez != null) && (locallez.jdField_j_of_type_Boolean)) {
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
          bcef.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          bcef.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    lez locallez = a();
    int i1;
    if ((!TextUtils.isEmpty(locallez.jdField_d_of_type_JavaLangString)) && ((!locallez.jdField_d_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (locallez.jdField_d_of_type_Int == 0)))
    {
      i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo1, result[" + i1 + "]");
      return;
    }
    if ((this.jdField_a_of_type_Lbu.a() == 0) && (TextUtils.isEmpty(locallez.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(locallez.jdField_d_of_type_JavaLangString)))
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
          VcControllerImpl localVcControllerImpl = new VcControllerImpl(a(), (String)localObject, this.jdField_a_of_type_Lbt, this);
          ClientLogReport.instance().setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          long l1 = mrb.a(str3);
          String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = bjms.a("62ad83");
          int i2 = bgoa.a(str3);
          str3 = DeviceInfoUtil.getIMSI();
          String str4 = str3 + "," + i2;
          String str5 = Build.HARDWARE + "_" + lld.a();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(i2), str4, str5 }));
          }
          localVcControllerImpl.init(a(), l1, "8.4.8", Build.MODEL, (String)localObject, str1, AppSetting.d(), str2, lld.b(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, lld.d(), i1, str4, new lkz().a(), msu.a(l1), msu.b(l1), str5);
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
    lba.g(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
    boolean bool = false;
    if ((a().jdField_d_of_type_Int == 1) || (a().jdField_d_of_type_Int == 2)) {
      bool = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.enableLoopback(paramBoolean);
    }
    while ((a().jdField_d_of_type_Int != 3) && (a().jdField_d_of_type_Int != 4)) {
      return bool;
    }
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
        lcp locallcp = (lcp)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = String.valueOf(locallcp.jdField_a_of_type_Long);
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
      lba.g(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_f_of_type_Int);
      return;
    }
    if (mua.a() != null) {
      mua.a().a(l1);
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    Object localObject = msw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((msw)localObject).a();
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
        lba.h(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 == 108)
    {
      a().aa = true;
      locallez = a();
      if (!h())
      {
        bool = true;
        locallez.Z = bool;
        i1 = f();
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, f());
      }
    }
    while (!a().aa) {
      for (;;)
      {
        lez locallez;
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
    lba.g(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
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
        lcp locallcp = (lcp)localIterator.next();
        if (locallcp.jdField_a_of_type_Long == paramLong) {
          if (!locallcp.jdField_f_of_type_Boolean)
          {
            locallcp.jdField_f_of_type_Boolean = true;
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
    paramArrayOfByte.d("onSwitchGroup", mqu.a(paramArrayOfByte.jdField_j_of_type_Int));
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
    if (this.jdField_a_of_type_Lbu.a().jdField_e_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lbu.a().jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_Lbu.a().jdField_d_of_type_Int != 2)) {
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
      if (this.jdField_a_of_type_Lbu.a().jdField_d_of_type_Int == 0) {
        if (this.jdField_a_of_type_Lbu.a().jdField_f_of_type_Int != 1)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Lbu.a().jdField_f_of_type_Int != 2) {}
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
    return this.jdField_a_of_type_Lbt.jdField_a_of_type_Int;
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
  
  public ArrayList<lcp> e()
  {
    if ((AudioHelper.e()) && (mpk.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(mpk.jdField_a_of_type_JavaUtilArrayList);
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
      ((lez)localObject1).jdField_O_of_type_Boolean = true;
      ((lez)localObject1).jdField_a_of_type_JavaUtilArrayList.clear();
      if ((mqu.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        L();
      }
      label779:
      for (;;)
      {
        a("onCreateRoomSuc");
        a("onCreateSuc", true, paramInt1, paramLong);
        ((lez)localObject1).ar = false;
        if (((lez)localObject1).J)
        {
          ((lez)localObject1).d("onCreateRoomSuc", true);
          ((lez)localObject1).M = true;
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
          ((ljt)localObject2).a(a());
        }
        if ((!((lez)localObject1).J) && (((lez)localObject1).F != 3)) {
          break;
        }
        localObject2 = a();
        if (localObject2 == null) {
          break;
        }
        ((ScreenShareCtrl)localObject2).a((lez)localObject1);
        return;
        int i1;
        int i2;
        if (((lez)localObject1).jdField_ad_of_type_Int == 5)
        {
          i1 = ((lez)localObject1).d();
          i2 = ((lez)localObject1).c();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onCreateRoomSuc, double meeting, terminalType[" + i1 + "], sdkVersion[" + i2 + "]");
          }
          long l2;
          if ((i1 == 2) || (i1 == 12) || ((i1 == 4) && (i2 >= 114)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lez)localObject1).jdField_g_of_type_Long;
            i1 = ((lez)localObject1).jdField_ad_of_type_Int;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lez)localObject1).jdField_g_of_type_Long;
            i1 = ((lez)localObject1).jdField_ad_of_type_Int;
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((lez)localObject1).jdField_ad_of_type_Int, 0);
        }
        else
        {
          if (AudioHelper.a(19) == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label779;
            }
            AudioHelper.a(amtj.a(2131715133));
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((lez)localObject1).jdField_ad_of_type_Int, 0);
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
    ((lez)localObject).ar = false;
    if (paramInt1 == 3)
    {
      ((lez)localObject).a("onEnterSuc.1", 14);
      ((lez)localObject).d("onEnterSuc", true);
      ((lez)localObject).a(l1, SystemClock.elapsedRealtime());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l1) });
      if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        ThreadManager.excute(new VideoController.33(this, paramInt1, paramInt2, paramLong), 16, null, false);
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ljt)localObject).a(a());
      }
      return;
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject = lbu.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = lbu.a().c((String)localObject);
      if (localObject != null)
      {
        ((lez)localObject).jdField_V_of_type_Boolean = true;
        ((lez)localObject).jdField_O_of_type_Boolean = false;
        ((lez)localObject).aD = true;
      }
      if ((mqu.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        L();
      }
    }
  }
  
  public void e(String paramString)
  {
    lez locallez = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallez.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallez.S + "], seq[" + l1 + "]");
    if (lsd.a(BaseApplication.getContext()) == 1) {
      locallez.b(l1, false);
    }
    while ((locallez.jdField_d_of_type_Int != 2) || (!locallez.jdField_k_of_type_Boolean)) {
      return;
    }
    locallez.b(l1, false);
    if (!locallez.jdField_j_of_type_Boolean)
    {
      locallez.S = true;
      locallez.a(l1, "onPauseVideo", 1);
      c(locallez.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    mrd.n(this);
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
    return this.jdField_p_of_type_Int;
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
      lcp locallcp = (lcp)localIterator.next();
      if ((locallcp.jdField_d_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(locallcp.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(locallcp.jdField_a_of_type_Long));
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
    lez locallez = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallez.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallez.S + "], seq[" + l1 + "]");
    if ((locallez.jdField_f_of_type_Int == 1) && (!f())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (locallez.jdField_k_of_type_Boolean);
      locallez.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      mrd.m(this);
    } while (locallez.jdField_d_of_type_Int != 1);
    locallez.a(l1, "onResumeVideo", 2);
    locallez.S = false;
  }
  
  public void f(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  void f(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    lez locallez = a();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + locallez + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(locallez.jdField_d_of_type_JavaLangString).longValue();
    int i1 = locallez.jdField_d_of_type_Int;
    long l3 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    int i2 = locallez.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      lno locallno1 = new lno();
      lno locallno2 = new lno();
      locallno1.jdField_a_of_type_Long = l2;
      locallno1.jdField_a_of_type_Int = 1;
      locallno2.jdField_a_of_type_Long = l2;
      locallno2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(locallno2);
      localArrayList.add(locallno1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (locallez.jdField_j_of_type_Boolean) {
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
        a().d("notifyChangeDoubleVideoMeeting2MultiVideo", mqu.a(i2));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.jdField_l_of_type_Boolean + "], session[" + locallez + "], seq[" + l1 + "]");
      }
      return;
      if (locallez.a(l3, 1) == -1) {
        break;
      }
      locallez.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
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
        long l1 = mrb.a(str1);
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
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new lch(this);
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
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioSpeakerMode, [" + this.jdField_p_of_type_Int + " --> " + paramInt + "], from[" + paramString + "]");
    }
    this.jdField_p_of_type_Int = paramInt;
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_Lfa.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_Lfa.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_c_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      lez locallez = a();
      if (paramBoolean)
      {
        a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (locallez != null)
        {
          locallez.jdField_a_of_type_Lfa.jdField_f_of_type_Boolean = false;
          locallez.jdField_a_of_type_Lfa.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          locallez.a();
          locallez.b();
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
        if (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((a().jdField_a_of_type_Lfa.jdField_a_of_type_Int == 1) || (a().jdField_a_of_type_Lfa.jdField_a_of_type_Int == 2))
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
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
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
    this.jdField_o_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_Lbt.receiveGatewayMsg(paramString, paramInt);
      bfyz.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(lcc.h, paramString).apply();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      mwv.a(jdField_a_of_type_JavaLangString, "saveGateWayMsg fail.", paramString);
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
          lcp locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (locallcp != null)
          {
            bool2 = bool1;
            if (!locallcp.jdField_g_of_type_Boolean) {
              break label231;
            }
            if ((locallcp.jdField_c_of_type_Long >= 2000L) && (locallcp.jdField_c_of_type_Long < this.jdField_c_of_type_Long))
            {
              l1 = locallcp.jdField_c_of_type_Long;
              bool2 = bool1;
              if (l2 - locallcp.jdField_b_of_type_Long <= l1) {
                break label231;
              }
              locallcp.jdField_g_of_type_Boolean = false;
              locallcp.jdField_b_of_type_Long = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + locallcp.jdField_a_of_type_Long + ",isSuspectNoisy = " + locallcp.jdField_g_of_type_Boolean);
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
      lcp locallcp = (lcp)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
      if ((locallcp == null) || (!locallcp.jdField_g_of_type_Boolean)) {
        break label159;
      }
      if (l1 == locallcp.jdField_a_of_type_Long)
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
    boolean bool = lld.c();
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
          long l1 = mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          int i1 = c();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetChannel(this.jdField_a_of_type_Lbt);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setCallback(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppId(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1, "8.4.8", new lkz().a());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_a_of_type_Lbt.receiveGatewayMsg(this.jdField_e_of_type_JavaLangString, this.jdField_o_of_type_Int);
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
      lcu locallcu = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcu != null) {
        locallcu.b(paramBoolean);
      }
    }
  }
  
  public boolean k()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2)
      {
        bcef.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
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
          bcef.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
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
      lcu locallcu = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcu != null) {
        locallcu.c(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_Lfa.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lfa.jdField_b_of_type_Int < 6);
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
      lcu locallcu = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcu != null) {
        locallcu.d(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    lez locallez = a();
    boolean bool1 = bool2;
    if (locallez != null)
    {
      bool1 = bool2;
      if (locallez.jdField_a_of_type_Lfb.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (locallez.jdField_a_of_type_Lfb.jdField_a_of_type_Long > 0L) {
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
      lcu locallcu = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcu != null) {
        locallcu.e(paramBoolean);
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
      l1 = mrb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1;
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (l1 == ((lcp)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long))
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
      lcu locallcu = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcu != null) {
        locallcu.f(paramBoolean);
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
      lcu locallcu = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallcu != null) {
        locallcu.g(paramBoolean);
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
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_Lfa.jdField_b_of_type_Int >= 4))
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
      ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label71:
    do
    {
      for (;;)
      {
        return;
        lno locallno1 = (lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        locallno1.jdField_a_of_type_Boolean = true;
        if (locallno1.jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          if (i1 != 0)
          {
            locallno2 = (lno)a().jdField_c_of_type_JavaUtilArrayList.get(0);
            locallno2.jdField_a_of_type_Boolean = false;
            a().jdField_c_of_type_JavaUtilArrayList.set(0, locallno1);
            a().jdField_c_of_type_JavaUtilArrayList.set(i1, locallno2);
          }
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, locallno1);
            a().jdField_d_of_type_JavaUtilArrayList.set(i1, locallno2);
            a().c();
            if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1)
            {
              i1 = 0;
              if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
              {
                if (((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
                  ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    } while (i1 == 0);
    lno locallno2 = (lno)a().jdField_c_of_type_JavaUtilArrayList.get(0);
    locallno2.jdField_a_of_type_Boolean = false;
    a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
    a().jdField_c_of_type_JavaUtilArrayList.set(i1, locallno2);
    synchronized (a().jdField_d_of_type_JavaUtilArrayList)
    {
      a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
      a().jdField_d_of_type_JavaUtilArrayList.set(i1, locallno2);
      a().c();
      return;
    }
    label420:
    ((lno)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void t(String paramString)
  {
    long l1 = AudioHelper.b();
    lez locallez = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + locallez.jdField_d_of_type_JavaLangString + "], extraUin[" + locallez.jdField_f_of_type_JavaLangString + "], remoteHasVideo[" + locallez.jdField_k_of_type_Boolean + "], mXiaoweiDevice[" + this.jdField_q_of_type_Boolean + "], seq[" + l1 + "]");
    if ((TextUtils.equals(locallez.jdField_d_of_type_JavaLangString, paramString)) || (TextUtils.equals(locallez.jdField_f_of_type_JavaLangString, paramString)) || (this.jdField_q_of_type_Boolean))
    {
      if ((locallez.jdField_f_of_type_Int != 1) || (f())) {
        break label165;
      }
      lba.g(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
    }
    for (;;)
    {
      return;
      label165:
      if (locallez.jdField_d_of_type_Int == 1) {
        c(2);
      }
      if (!locallez.jdField_k_of_type_Boolean)
      {
        locallez.b(l1, true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
        mrd.m(this);
        if (locallez.jdField_d_of_type_Int == 1)
        {
          locallez.a(l1, "onNeedShowPeerVideo", 2);
          locallez.S = false;
        }
      }
      while (!TextUtils.equals(locallez.jdField_d_of_type_JavaLangString, paramString))
      {
        GraphicRenderMgr.getInstance().onUinChanged(locallez.jdField_d_of_type_JavaLangString, paramString);
        return;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
      }
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2) {
        bcef.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
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
          bcef.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void u(String paramString)
  {
    a().am = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    v(paramString);
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
  
  public void w()
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.jdField_i_of_type_Int + "]");
    this.jdField_i_of_type_Int = 0;
  }
  
  public void w(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (lkq.b(this.jdField_a_of_type_AndroidContentContext))
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
        this.jdField_a_of_type_Mua.d();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131695149), 2131690620, 2131694201, new lck(this), new lcl(this, bool1, bool2));
      bcef.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void x(String paramString)
  {
    a("deviceMemory", lhw.c() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
  
  public void y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695236, 1).a();
    }
    Object localObject = a();
    if (localObject != null) {
      if (((lez)localObject).F != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      llj.a((String)localObject);
      return;
    }
  }
  
  public void y(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.b(paramString);
    }
  }
  
  public void z()
  {
    lez locallez = a();
    if (locallez != null)
    {
      int i2 = locallez.jdField_V_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = locallez.U;
      }
      b(i1);
      if ((i1 == 0) || (!locallez.aA)) {
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
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setupDeviceInfos(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAndroidPath(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */