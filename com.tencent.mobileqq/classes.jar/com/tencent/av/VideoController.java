package com.tencent.av;

import aabm;
import alpo;
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
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import azmj;
import azmz;
import bcys;
import bdcb;
import bdda;
import bdee;
import bdex;
import bdfc;
import bdiv;
import bdnv;
import bdvr;
import bhms;
import bhoi;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.compat.InviteUIChecker;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.random.RandomController;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.AudioHelper;
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
import lek;
import leo;
import lez;
import lfb;
import lfe;
import lfj;
import lfk;
import lfl;
import lfm;
import lfn;
import lfo;
import lfp;
import lfq;
import lfr;
import lft;
import lfu;
import lfv;
import lfx;
import lfz;
import lga;
import lgc;
import lgd;
import lge;
import lid;
import lie;
import lif;
import lio;
import lkx;
import lkz;
import llz;
import lmk;
import lmr;
import lmy;
import lno;
import lnp;
import lnq;
import lns;
import lnu;
import lnv;
import lnz;
import loc;
import lof;
import log;
import lph;
import lps;
import lqk;
import lqo;
import lqq;
import lrs;
import lrz;
import lsa;
import lsl;
import lux;
import luy;
import lyh;
import mbt;
import mdd;
import mgv;
import mls;
import mnd;
import mqo;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mrz;
import mti;
import mto;
import mtq;
import mtx;
import muv;
import muw;
import muz;
import mvh;
import mvj;
import mvn;
import mwd;
import mwf;
import mwk;
import mww;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  extends lnp
  implements lns, lnv, lqo
{
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  private static String jdField_f_of_type_JavaLangString;
  public static int p;
  public static int q;
  public static int r;
  private boolean A;
  int jdField_a_of_type_Int = -1;
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
  ArrayList<lfu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  public lez a;
  lfb jdField_a_of_type_Lfb = lfb.a();
  private volatile lfe jdField_a_of_type_Lfe;
  private lft jdField_a_of_type_Lft;
  lfv jdField_a_of_type_Lfv = new lfr(this);
  public lmy a;
  public lnq a;
  lrz jdField_a_of_type_Lrz = null;
  private lsa jdField_a_of_type_Lsa;
  private mls jdField_a_of_type_Mls;
  public mtx a;
  public muv a;
  muw jdField_a_of_type_Muw;
  public mwk a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  boolean jdField_a_of_type_Boolean = true;
  public float[] a;
  private mqo[] jdField_a_of_type_ArrayOfMqo;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoController.2(this);
  private ArrayList<lfu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public lfv b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  public Runnable c;
  private final ArrayList<lfu> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  lfv jdField_c_of_type_Lfv = new lfk(this);
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
  public int g;
  public long g;
  Runnable jdField_g_of_type_JavaLangRunnable = null;
  private String jdField_g_of_type_JavaLangString;
  public boolean g;
  public int h;
  Runnable jdField_h_of_type_JavaLangRunnable = null;
  boolean jdField_h_of_type_Boolean = true;
  int jdField_i_of_type_Int = 0;
  Runnable jdField_i_of_type_JavaLangRunnable = null;
  public volatile boolean i;
  int jdField_j_of_type_Int = 1;
  Runnable jdField_j_of_type_JavaLangRunnable = null;
  boolean jdField_j_of_type_Boolean = false;
  int jdField_k_of_type_Int = 2;
  Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.30(this);
  boolean jdField_k_of_type_Boolean = false;
  int jdField_l_of_type_Int = 3;
  private Runnable jdField_l_of_type_JavaLangRunnable = new VideoController.29(this);
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int = 4;
  private Runnable jdField_m_of_type_JavaLangRunnable;
  boolean jdField_m_of_type_Boolean = false;
  public int n;
  public boolean n;
  int o;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  int jdField_s_of_type_Int = jdField_p_of_type_Int;
  boolean jdField_s_of_type_Boolean = false;
  private int jdField_t_of_type_Int = 0;
  boolean jdField_t_of_type_Boolean = false;
  private int jdField_u_of_type_Int;
  boolean jdField_u_of_type_Boolean = false;
  private int v;
  public boolean v;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean;
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
    jdField_p_of_type_Int = -1;
    jdField_q_of_type_Int = 1;
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 6000L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_Lfv = new lfj(this);
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_n_of_type_Int = 0;
    this.jdField_q_of_type_Boolean = true;
    this.jdField_v_of_type_Int = -1;
    this.jdField_o_of_type_Int = 0;
    this.jdField_g_of_type_Long = -1L;
    if (!mti.a()) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker = new InviteUIChecker();
      }
      boolean bool = AEFilterSupport.a();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoController ret[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Lmy = new lmy();
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new lfq(this, a(), 3);
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
      lek.c(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void L()
  {
    lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallfz != null) {
      locallfz.a();
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
      long l1 = ((lid)localObject).jdField_h_of_type_Long;
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      int i1 = this.jdField_f_of_type_Int;
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
    if (this.jdField_a_of_type_Lnq == null)
    {
      this.jdField_a_of_type_Lnq = new lnq(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a().jdField_i_of_type_Int = 9500;
      if (QLog.isColorLevel()) {
        QLog.w("BaseIMSharp", 2, "init device sharp");
      }
    }
  }
  
  private void O()
  {
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_w_of_type_Int = 0;
  }
  
  private void P()
  {
    if (this.jdField_m_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_m_of_type_JavaLangRunnable);
    }
    this.jdField_m_of_type_JavaLangRunnable = null;
  }
  
  private void Q()
  {
    if ((this.jdField_g_of_type_Long != -1L) && (System.currentTimeMillis() - this.jdField_g_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("reqType", 20);
    localNewIntent.putExtra("vMsg", localReqEcho.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkNetStatus -->sendEcho");
    }
    a(localNewIntent);
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
  
  private lid a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = lfb.a(3, paramString, new int[0]);
      localObject2 = lfb.a().c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = lfb.a(100, paramString, new int[0]);
        localObject1 = lfb.a().c((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = lfb.a().b(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = lfb.a(4, paramString, new int[0]);
        localObject1 = lfb.a().c((String)localObject1);
      }
    }
  }
  
  private void a(int paramInt, long paramLong1, lps paramlps, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_Lfb.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramlps.jdField_a_of_type_Long;
    long l2 = mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = lfb.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt != 3) {
        break label1684;
      }
      paramVarArgs = lfb.a(100, String.valueOf(paramLong1), new int[0]);
    }
    label531:
    label1684:
    for (;;)
    {
      if (paramInt == 1) {}
      for (??? = a();; ??? = lfb.a().c(paramVarArgs))
      {
        if ((??? != null) && (!TextUtils.isEmpty(((lid)???).jdField_c_of_type_JavaLangString))) {
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_c_of_type_Int + "], relationType[" + paramInt + "], UserInfo[" + paramlps + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_m_of_type_Boolean + "], switchToGAudioMode[" + ((lid)???).F + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((lid)???).jdField_U_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        if (this.jdField_m_of_type_Boolean) {
          break label531;
        }
        bool2 = true;
        a("onGAudioUserEnterOrLeave", bool2, ((lid)???).a());
        if (((this.jdField_c_of_type_Int == 1) && (((lid)???).C == 10)) || (this.jdField_c_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label537;
          }
        }
      }
      label537:
      for (boolean bool2 = false;; bool2 = true)
      {
        ((lid)???).jdField_ac_of_type_Boolean = bool2;
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
      a(paramlps, paramBoolean);
      if ((paramVarArgs.jdField_d_of_type_Int == 3) && (paramVarArgs.jdField_i_of_type_Int == 1011))
      {
        if (!paramBoolean) {
          break label1093;
        }
        if (h() != 1) {
          break label1081;
        }
        if (!bool1) {
          break label1069;
        }
        paramVarArgs.jdField_a_of_type_Lie.jdField_b_of_type_Int = 4;
        label598:
        if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
          this.jdField_a_of_type_Mwk.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        a(paramVarArgs.jdField_a_of_type_Lie.jdField_b_of_type_Int, 3, null);
        ??? = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((??? != null) && (((mvj)???).a())) {
          c();
        }
      }
      if (paramBoolean)
      {
        paramVarArgs.b("onGAudioUserEnterOrLeave", 2);
        if (paramVarArgs.jdField_g_of_type_Int < 10)
        {
          if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (bool1))
          {
            paramVarArgs.a("onGAudioUserEnterOrLeave.1", 9);
            paramVarArgs.ae = false;
          }
        }
        else
        {
          label743:
          if ((paramVarArgs.jdField_h_of_type_Long != l1) && (l1 != l2)) {
            mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
          }
          if (!paramVarArgs.jdField_J_of_type_Boolean) {
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
          if (paramlps.jdField_a_of_type_Int != 0) {
            break label1344;
          }
          bool2 = true;
          label817:
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2) });
          label864:
          if (!paramVarArgs.jdField_J_of_type_Boolean) {
            break label1519;
          }
          if ((paramBoolean) && (!bool1))
          {
            paramlps = a();
            if (paramlps != null) {
              paramlps.b(paramLong1);
            }
          }
          paramlps = new Intent();
          paramlps.setAction("tencent.av.v2q.MultiVideo");
          if (!paramBoolean) {
            break label1504;
          }
          paramlps.putExtra("type", 401);
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramlps.putExtra("relationType", 3);
          paramlps.putExtra("relationId", paramLong1);
          paramlps.putExtra("friendUin", l1);
          paramlps.putExtra("MultiAVType", paramVarArgs.C);
          paramlps.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramlps);
          if (paramBoolean) {
            break;
          }
          if (paramVarArgs.K)
          {
            paramlps = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            t();
            if (paramlps.a()) {
              paramlps.a(paramVarArgs.jdField_c_of_type_JavaLangString);
            }
          }
          if (!paramVarArgs.ao) {
            break;
          }
          a(l3, paramLong1, false, 2);
          return;
          label1069:
          paramVarArgs.jdField_a_of_type_Lie.jdField_b_of_type_Int = 1;
          break label598;
          label1081:
          paramVarArgs.jdField_a_of_type_Lie.jdField_b_of_type_Int = 5;
          break label598;
          label1093:
          if (h() == 1) {
            paramVarArgs.jdField_a_of_type_Lie.jdField_b_of_type_Int = 4;
          }
          if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) || (!m())) {
            break label647;
          }
          this.jdField_a_of_type_Mwk.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
          break label647;
          paramVarArgs.a("onGAudioUserEnterOrLeave.2", 10);
          s();
          break label743;
          label1186:
          if (paramVarArgs.jdField_e_of_type_Long != 0L) {
            break label795;
          }
          paramVarArgs.a(l3, SystemClock.elapsedRealtime());
          break label795;
          synchronized (this.jdField_c_of_type_JavaUtilArrayList)
          {
            if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (((lfu)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
            {
              i1 = 1;
              if (i1 != 0)
              {
                paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
                paramVarArgs.ae = true;
                ??? = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                if ((??? != null) && (((mvj)???).a()))
                {
                  t();
                  c();
                }
              }
              mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
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
          g(true);
          break label864;
        }
        if (paramLong2 == 0L)
        {
          ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramlps.jdField_a_of_type_Int == 0) {}
          for (bool2 = true;; bool2 = false)
          {
            ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
            break;
          }
        }
        ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramlps.jdField_a_of_type_Int == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
          break;
        }
        label1504:
        paramlps.putExtra("type", 402);
      }
      label1519:
      paramlps = new Intent();
      paramlps.setAction("tencent.av.v2q.MultiVideo");
      if (paramBoolean)
      {
        paramlps.putExtra("type", 22);
        paramlps.putExtra("isStart", this.jdField_s_of_type_Boolean);
      }
      for (;;)
      {
        paramlps.putExtra("roomUserNum", this.jdField_c_of_type_JavaUtilArrayList.size());
        paramlps.putExtra("relationType", paramInt);
        paramlps.putExtra("relationId", paramLong1);
        paramlps.putExtra("friendUin", l1);
        paramlps.putExtra("MultiAVType", a().C);
        paramlps.putExtra("from", "VideoController5");
        paramlps.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramlps);
        return;
        paramlps.putExtra("type", 23);
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
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      label185:
      if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size()) {
        if (((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong2) {}
      }
    }
    for (int i1 = ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;; i1 = 1)
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
    long l1 = mti.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {}
    for (Object localObject = lfb.a(100, String.valueOf(paramLong1), new int[0]);; localObject = lfb.a(paramInt1, String.valueOf(paramLong1), new int[0]))
    {
      localObject = this.jdField_a_of_type_Lfb.c((String)localObject);
      if (localObject != null) {
        ((lid)localObject).b(paramLong2, paramBoolean1, paramBoolean2);
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
    lfu locallfu = a(String.valueOf(paramLong1));
    if (locallfu == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
      }
    }
    lqq locallqq;
    do
    {
      do
      {
        return;
        locallfu.jdField_b_of_type_Boolean = paramBoolean;
      } while ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1));
      if (!paramBoolean) {
        break;
      }
      locallqq = new lqq();
      locallqq.jdField_a_of_type_Long = paramLong1;
      locallqq.jdField_a_of_type_Int = 1;
    } while (a().a(paramLong1, locallqq.jdField_a_of_type_Int) != -1);
    locallqq.jdField_b_of_type_Long = paramLong2;
    if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
      locallqq.jdField_b_of_type_Long = 5L;
    }
    if (!a().u())
    {
      locallqq.jdField_a_of_type_Boolean = true;
      if ((g() == 4) || (paramInt == 3)) {
        break label320;
      }
      if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) != -1) {
        break label311;
      }
      locallqq.jdField_c_of_type_Boolean = true;
      label236:
      if (locallfu.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        break label338;
      }
      locallqq.jdField_b_of_type_Boolean = true;
      locallqq.jdField_d_of_type_Boolean = true;
      locallqq.jdField_c_of_type_Boolean = true;
      if (a().u()) {
        break label329;
      }
    }
    label311:
    label320:
    label329:
    for (locallqq.jdField_a_of_type_Boolean = true;; locallqq.jdField_a_of_type_Boolean = false)
    {
      a().a(locallqq);
      return;
      locallqq.jdField_a_of_type_Boolean = false;
      break;
      locallqq.jdField_c_of_type_Boolean = false;
      break label236;
      locallqq.jdField_c_of_type_Boolean = true;
      break label236;
    }
    label338:
    locallqq.jdField_b_of_type_Boolean = false;
    a().a(locallqq);
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
        if (a().C == 10) {
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
      lqq locallqq1 = new lqq();
      if (paramBoolean2) {
        ((lfu)???).jdField_b_of_type_Int = 2;
      }
      for (;;)
      {
        locallqq1.jdField_a_of_type_Long = paramLong;
        locallqq1.jdField_a_of_type_Int = 2;
        locallqq1.jdField_a_of_type_Boolean = true;
        locallqq1.jdField_b_of_type_Boolean = false;
        long l1;
        lqq locallqq3;
        if (paramInt1 != 0)
        {
          l1 = 4L;
          locallqq1.jdField_b_of_type_Long = l1;
          if (a().a(paramLong, locallqq1.jdField_a_of_type_Int) != -1) {
            break;
          }
          if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
          {
            ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = false;
            if (g() != 4)
            {
              paramInt1 = a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue());
              if (paramInt1 != -1) {
                ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_c_of_type_Boolean = false;
              }
            }
          }
          locallqq1.jdField_c_of_type_Boolean = true;
          if (a().jdField_c_of_type_JavaUtilArrayList.size() <= 1) {
            break label489;
          }
          locallqq3 = (lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          a().jdField_c_of_type_JavaUtilArrayList.set(0, locallqq1);
        }
        synchronized (a().jdField_d_of_type_JavaUtilArrayList)
        {
          a().jdField_d_of_type_JavaUtilArrayList.set(0, locallqq1);
          a().a(locallqq3);
          return;
          ((lfu)???).jdField_b_of_type_Int = 1;
          continue;
          l1 = 5L;
        }
      }
      label489:
      a().a(0, locallqq2);
      return;
    }
    ((lfu)???).jdField_b_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    u();
  }
  
  private void a(Intent paramIntent)
  {
    lmy locallmy = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (locallmy != null) {
      locallmy.a(paramIntent);
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
    lmy locallmy = a();
    lge.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772166, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
      if (locallmy != null) {
        locallmy.a(paramIntent);
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
  
  private void a(ArrayList<lqq> paramArrayList, int paramInt)
  {
    int i4 = 0;
    int i1;
    if (a().M == 3)
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
              lqq locallqq = (lqq)paramArrayList.get(paramInt);
              paramArrayList.set(paramInt, paramArrayList.get(i1));
              paramArrayList.set(i1, locallqq);
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
    lfu locallfu = a(String.valueOf(paramLong));
    if (locallfu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    locallfu.jdField_a_of_type_Boolean = paramBoolean;
    locallfu.jdField_a_of_type_Int = paramInt;
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
    this.jdField_m_of_type_JavaLangRunnable = new VideoController.34(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_m_of_type_JavaLangRunnable, 1000L);
  }
  
  public static boolean b(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  private boolean c(String paramString)
  {
    if (paramString == null) {}
    lid locallid;
    do
    {
      return false;
      locallid = lfb.a().a();
    } while ((locallid == null) || (locallid.jdField_d_of_type_JavaLangString == null) || (!paramString.equals(locallid.jdField_d_of_type_JavaLangString)));
    return true;
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
    int i1 = (int)(System.currentTimeMillis() / 1000L);
    int i2 = this.jdField_w_of_type_Int;
    return (this.jdField_g_of_type_JavaLangString != null) && (paramString != null) && (this.jdField_g_of_type_JavaLangString.equals(paramString)) && (i1 - i2 < 3);
  }
  
  private void e(Bundle paramBundle)
  {
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("fromUin");
    this.jdField_w_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isLandscape screenWidth: " + i1 + ", screenHeight: " + i2 + ", rotation: " + i3 + ", orientation: " + this.jdField_t_of_type_Int);
    }
    return (i1 > i2) || (i3 == 1) || (i3 == 3) || (this.jdField_t_of_type_Int == 4) || (this.jdField_t_of_type_Int == 2);
  }
  
  public void A()
  {
    lid locallid = a();
    if (locallid != null)
    {
      int i2 = locallid.jdField_U_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = locallid.T;
      }
      b(i1);
      if ((i1 == 0) || (!locallid.az)) {
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
  
  public void B()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onProcessExit();
    }
  }
  
  public void C()
  {
    long l1 = (System.currentTimeMillis() - this.jdField_e_of_type_Long) / 1000L;
    azmj.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    azmj.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void D()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_Lez == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Lez.jdField_a_of_type_JavaLangString)
    {
      azmj.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
      this.jdField_f_of_type_Long = 0L;
      return;
    }
  }
  
  public void E()
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "playRecordVoice, seq[" + l1 + "]");
    }
    a(l1, 2131230739, 1, null);
  }
  
  public void F()
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
    this.jdField_a_of_type_Mwk.b(l1);
    this.jdField_a_of_type_Mwk.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230738, null, 1, null);
  }
  
  void G()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.sdk.onRequestVideo");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void H()
  {
    switch (bdee.a(null))
    {
    default: 
      i(0);
      return;
    case 0: 
      i(3);
      return;
    }
    Q();
  }
  
  public void I()
  {
    lid locallid = a();
    long l1 = AudioHelper.b();
    String str;
    int i1;
    if ((locallid.k()) || (locallid.l()) || (locallid.jdField_g_of_type_Int == 9) || (locallid.m()))
    {
      mbt.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = locallid.jdField_c_of_type_JavaLangString;
      i1 = locallid.jdField_d_of_type_Int;
      if (locallid.jdField_g_of_type_Int == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i1, false, bool, locallid.w());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reNotifyChatInfo2QQ, sessionInfo[" + locallid + "]");
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!a().k()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setGroundGlassSwitch(a().jdField_d_of_type_JavaLangString, paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    lek.c(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
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
    if (paramLong == 0L)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "startGAudioChat, relationId illegal.");
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    lek.b("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().C);
    AudioHelper.b("startGAudioChat ");
    f(false);
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
    localObject1 = lfb.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = lfb.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l1;
    int i2;
    int i1;
    if (!this.jdField_a_of_type_Lfb.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_Lfb.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((lid)localObject2).E = paramInt1;
        ((lid)localObject2).C = paramInt2;
        localObject1 = localObject2;
      }
      this.jdField_n_of_type_Boolean = false;
      l1 = mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      if ((paramInt1 != 7) && (paramInt1 != 9)) {
        break label595;
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
      if ((((lid)localObject1).jdField_J_of_type_Boolean) && (((lid)localObject1).aE)) {
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
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().b(), a().jdField_O_of_type_Int, a().jdField_N_of_type_Int);
        if (this.jdField_j_of_type_JavaLangRunnable == null) {
          this.jdField_j_of_type_JavaLangRunnable = new VideoController.21(this, paramInt1, paramLong);
        }
        this.jdField_s_of_type_Boolean = true;
        ((lid)localObject1).a("startGAudioChat.2", 8);
        ((lid)localObject1).jdField_g_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
        h();
        a(((lid)localObject1).jdField_c_of_type_JavaLangString, 3, false, false, false);
        return 0;
        localObject1 = this.jdField_a_of_type_Lfb.c((String)localObject1);
        break;
        label595:
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
          i1 = a().C;
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
            break label767;
          }
          ((lid)localObject1).jdField_g_of_type_Long = paramLong;
          ((lid)localObject1).E = paramInt1;
          ((lid)localObject1).C = paramInt2;
          ((lid)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
          ((lid)localObject1).jdField_i_of_type_Int = 0;
          ((lid)localObject1).d("startGAudioChat", true);
          i2 = 1;
          i1 = paramInt2;
          paramInt2 = i2;
          break label372;
        }
        return -1;
        if (((lid)localObject1).b()) {
          paramInt2 = 3;
        }
      }
      label767:
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
    boolean bool = a().k();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendAVFunChatMsg, type[" + paramInt + "], data[" + paramString + "], isConnected[" + bool + "]");
    if (!bool) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_d_of_type_JavaLangString, paramInt, paramString);
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
    boolean bool = a().k();
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
          lfu locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallfu != null) && (locallfu.jdField_a_of_type_Long == paramLong)) {
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
    StringBuilder localStringBuilder = new StringBuilder().append("acceptGAudioChat, relationType[").append(paramInt).append("], relationId[").append(paramLong2).append("], isVideo[").append(paramBoolean).append("], relationId[").append(paramLong2).append("], mIsStartGAuio[").append(this.jdField_s_of_type_Boolean).append("], uinList[");
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
        l();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label192;
      }
      return -1;
      bool = false;
      break;
    }
    label192:
    l(false);
    f(false);
    this.jdField_n_of_type_Boolean = false;
    for (;;)
    {
      int i2;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        a().a("acceptGAudioChat", 8);
        a().jdField_g_of_type_Long = paramLong2;
        a().ag = true;
        a().aq = true;
        paramLong1 = mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        i2 = 2;
        if (paramInt != 2) {
          break label449;
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i2, i1, paramLong2, paramArrayOfLong, c(), paramLong1, a().jdField_N_of_type_Int);
          if (this.jdField_j_of_type_JavaLangRunnable == null) {
            this.jdField_j_of_type_JavaLangRunnable = new VideoController.22(this, paramInt, paramLong2);
          }
          this.jdField_s_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
          h();
          return 0;
        }
      }
      int i1 = 1;
      continue;
      label449:
      if (paramInt == 1)
      {
        i2 = a().C;
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo acceptRequest, peerUin[" + paramString + "], businessType[" + paramInt1 + "], relationType[" + paramInt2 + "], uiMode[" + this.jdField_h_of_type_Int + "], seq[" + paramLong + "]");
    if ((q()) && (this.jdField_h_of_type_Int != 3) && (!paramString.equals(a().jdField_d_of_type_JavaLangString)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,is nearby");
      return -1;
    }
    if (!bdee.d(BaseApplication.getContext()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,network not support");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    lid locallid = a(paramInt2, paramString);
    if (locallid == null) {
      locallid = a();
    }
    for (;;)
    {
      l(false);
      if ((locallid.jdField_i_of_type_Int == 1011) || (locallid.jdField_i_of_type_Int == 21)) {
        a(paramLong, 15000L);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (paramInt1 == 0) {
        paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 0, paramInt2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "acceptRequest, result[" + paramInt1 + "], peerUin[" + paramString + "], relationType[" + paramInt2 + "], session[" + locallid + "]");
        }
        if (paramInt1 == 0)
        {
          locallid.a("acceptRequest", 3);
          j();
        }
        if (this.jdField_a_of_type_Lnq != null) {
          aabm.a(null, "Usr_TV_Video", 4, 0, 0);
        }
        ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
        lkx.a(37);
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
      if (bdee.d(BaseApplication.getContext())) {
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
    if ((paramString1.i()) && (paramString1.jdField_d_of_type_JavaLangString != null) && (str.equals(paramString1.jdField_d_of_type_JavaLangString)))
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
      N();
      i1 = -1;
      l1 = 0L;
      if (paramString1.ah)
      {
        l1 = paramString1.jdField_i_of_type_Long;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "request, startTerminalSwitchTimeOutCheck, oldRoomId[" + l1 + "], seq[" + paramLong + "]");
        f();
      }
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request funcall buffer:" + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      lkx.a(28);
      lkx.a(11, str);
      lkx.a(12, 1L);
      if (!paramString1.R) {
        break label1020;
      }
      l2 = 1L;
      label610:
      lkx.a(13, l2);
      lkx.a(15, 1L);
      K();
      if ((paramString1.jdField_i_of_type_Int != 1011) && (paramString1.jdField_i_of_type_Int != 21)) {
        break label1034;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      paramString1.R = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label1028;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label738:
      AVReport.a().o = paramString1.R;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "request result = " + i1 + ", uinType = " + paramInt3 + ", accostType = " + i2);
      if (i1 == 0)
      {
        paramString1.a("request", 1);
        paramString1.jdField_i_of_type_Int = paramInt3;
        paramString1.jdField_j_of_type_Int = i2;
        if ((paramString1.jdField_d_of_type_Int != 3) && (paramString1.jdField_d_of_type_Int != 4)) {
          paramString1.a(paramLong, SystemClock.elapsedRealtime());
        }
        h();
        if (!paramString1.R) {
          break label1437;
        }
      }
    }
    label1028:
    label1034:
    label1437:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      for (;;)
      {
        a(paramString1.jdField_c_of_type_JavaLangString, paramInt1, false, false, true);
        paramString1.jdField_n_of_type_Int = -1;
        this.jdField_l_of_type_Boolean = false;
        a(paramLong, paramString1.jdField_d_of_type_JavaLangString);
        c();
        paramString1.af = false;
        a(str, 2, paramString1.jdField_a_of_type_Long);
        a(str, 1, 0L);
        a("deviceMemory", lkx.c() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.a(a()));
        if (this.jdField_a_of_type_Lfe != null) {
          this.jdField_a_of_type_Lfe.b();
        }
        this.jdField_a_of_type_Lfe = new lfe(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
        return i1;
        this.x = true;
        break;
        label1020:
        l2 = 2L;
        break label610;
        i1 = 0;
        break label738;
        if (paramInt3 == 9500)
        {
          paramInt4 = 4200;
          try
          {
            l1 = mto.a(str);
            if (!TextUtils.isEmpty(paramString6)) {
              paramInt4 = Integer.valueOf(paramString6).intValue();
            }
            if (QLog.isColorLevel()) {
              QLog.d("SDVideo", 2, "request smart tv " + paramInt4);
            }
            paramString1.R = false;
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
        paramString1.R = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = leo.a(paramString10);
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
        break label738;
      }
      if (1 != paramInt1) {
        break label738;
      }
      paramString1.R = false;
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      break label738;
    }
  }
  
  int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
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
      boolean bool2 = this.jdField_v_of_type_Boolean;
      localStartAudioSendRunnable = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
      if (paramBoolean1) {
        break label307;
      }
      if ((!paramBoolean2) && (!this.jdField_v_of_type_Boolean)) {
        break label301;
      }
      bool1 = true;
      this.jdField_v_of_type_Boolean = bool1;
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
      paramString = new StringBuilder().append("switchAudioSend[").append(paramString).append("], seq[").append(paramLong).append("], flag[").append(paramInt).append("], enable[").append(paramBoolean1).append("], notifySvr[").append(paramBoolean2).append("], mIsMicOffBySelf[").append(bool2).append("->").append(this.jdField_v_of_type_Boolean).append("], result[").append(i1).append("], mGAudioCtrl[");
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
      this.jdField_v_of_type_Boolean = false;
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
  
  int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(AudioHelper.b(), paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public int a(lid paramlid, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramlid, paramString);
    }
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("setAudioInputMute enable=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    lga locallga = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (locallga != null) {
      locallga.c();
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
    lid locallid = lfb.a().a(paramString);
    if ((locallid != null) && (locallid.b() != 0L)) {
      l1 = locallid.b();
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
    } while (locallid == null);
    locallid.d(l2);
    return l2;
  }
  
  public long a(lid paramlid)
  {
    if (paramlid == null) {
      return 0L;
    }
    long l1 = paramlid.b();
    switch (paramlid.jdField_d_of_type_Int)
    {
    default: 
      return l1;
    }
    return a(paramlid.jdField_d_of_type_JavaLangString);
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
    return bdda.a(paramBitmap, paramInt1, paramInt1, paramInt2);
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
      lfu locallfu;
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
          } while (a().jdField_a_of_type_Lie.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return a().jdField_a_of_type_Lie.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (a().jdField_a_of_type_Lie.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return a().jdField_a_of_type_Lie.jdField_b_of_type_AndroidGraphicsBitmap;
        if (a().jdField_a_of_type_Lie.jdField_a_of_type_Int != 3) {
          break;
        }
        locallfu = a(paramString);
      } while ((locallfu == null) || (locallfu.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + locallfu.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return locallfu.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((a().jdField_a_of_type_Lie.jdField_a_of_type_Int != 1) || (a().jdField_a_of_type_Lie.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return a().jdField_a_of_type_Lie.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_a_of_type_Lfb.b());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_Lfb.b()))
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(l1, paramString2, paramString3);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QuaReport --> updateProcessInfo peerUin = " + l1 + ",key = " + paramString2 + ",value = " + paramString3);
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
  
  public Pair<Integer, ArrayList<lfu>> a()
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
        lfu locallfu = (lfu)((Iterator)localObject4).next();
        locallfu.jdField_h_of_type_Boolean = true;
        localArrayList2.add(locallfu);
        localHashSet.add(Long.valueOf(locallfu.jdField_a_of_type_Long));
      }
    }
    int i1 = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (lfu)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((lfu)localObject4).jdField_a_of_type_Long)))
      {
        ((lfu)localObject4).jdField_h_of_type_Boolean = false;
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
  
  public String a(ArrayList<lqq> paramArrayList)
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
  
  public ArrayList<lfu> a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    lfu locallfu;
    while (localIterator.hasNext())
    {
      locallfu = (lfu)localIterator.next();
      localArrayList.add(locallfu);
      localHashSet.add(Long.valueOf(locallfu.jdField_a_of_type_Long));
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      locallfu = (lfu)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(locallfu.jdField_a_of_type_Long)))
      {
        locallfu.jdField_h_of_type_Boolean = false;
        localArrayList.add(locallfu);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<lfu> a(int paramInt, ArrayList<lfu> paramArrayList)
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
        localObject2 = (lfu)paramArrayList.get(i2);
        if (((lfu)localObject2).jdField_a_of_type_Long == l2) {
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
      localObject2 = (lfu)paramArrayList.get(i2);
      if (((lfu)localObject2).jdField_a_of_type_Long == l2) {
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
      long l3 = ((lfu)localArrayList1.get(i2)).jdField_a_of_type_Long;
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
      Collections.sort((List)localObject2, new lfm(this));
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
      l2 = ((lfu)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
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
      Collections.sort(localArrayList2, new lfn(this));
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
      lfu locallfu;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 >= i2) {
          break label152;
        }
        locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (locallfu == null) {
          break label158;
        }
        if (locallfu.jdField_a_of_type_Long == paramLong1)
        {
          if (!locallfu.jdField_e_of_type_Boolean)
          {
            locallfu.jdField_g_of_type_Boolean = paramBoolean;
            locallfu.jdField_b_of_type_Long = l1;
            locallfu.jdField_c_of_type_Long = paramLong2;
          }
        }
        else
        {
          if (!locallfu.jdField_g_of_type_Boolean) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(locallfu.jdField_a_of_type_Long));
        }
      }
      if (locallfu.jdField_g_of_type_Boolean)
      {
        locallfu.jdField_g_of_type_Boolean = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i1 += 1;
      }
    }
  }
  
  public lfu a(String paramString)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          lfu locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallfu == null) || (locallfu.jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = locallfu;
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
  
  public lid a()
  {
    return this.jdField_a_of_type_Lfb.a();
  }
  
  public lmy a()
  {
    return this.jdField_a_of_type_Lmy;
  }
  
  public lsa a(Context arg1)
  {
    if (!lsa.a()) {
      return null;
    }
    if ((this.jdField_a_of_type_Lsa == null) && (??? != null)) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Lsa == null)
      {
        this.jdField_a_of_type_Lsa = new lsa(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, null);
        this.jdField_a_of_type_Lsa.b();
      }
      return this.jdField_a_of_type_Lsa;
    }
  }
  
  @TargetApi(21)
  public mls a()
  {
    if (this.jdField_a_of_type_Mls == null) {
      this.jdField_a_of_type_Mls = new mls();
    }
    return this.jdField_a_of_type_Mls;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNetWorkTimer");
    }
    if (this.A) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.A = true;
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_j_of_type_Boolean + "], preSize[" + llz.jdField_k_of_type_Int + ", " + llz.jdField_l_of_type_Int + "], seq[" + l1 + "]");
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], use min previewSize[640,480]");
        i1 = 480;
        i2 = 640;
      }
      if ((llz.jdField_k_of_type_Int != i2) || (llz.jdField_l_of_type_Int != i1)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(i2), Integer.valueOf(i1), Long.valueOf(l1) });
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Long = paramInt3;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
    }
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
      if (((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
      {
        i3 = ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
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
              a((lfu)localObject, paramInt1);
              i1 = a().a(paramLong1, 0);
            }
            for (((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;; ((lqq)localObject).jdField_a_of_type_Int = paramInt1)
            {
              i1 = 1;
              break;
              localObject = (lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
              lqq locallqq = new lqq();
              locallqq.jdField_a_of_type_Long = ((lqq)localObject).jdField_a_of_type_Long;
              locallqq.jdField_a_of_type_Int = ((lqq)localObject).jdField_a_of_type_Int;
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(locallqq);
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
      ((lid)localObject).jdField_a_of_type_Lie.jdField_a_of_type_Int = paramInt2;
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
      ((Intent)localObject).putExtra("guild_group_id", a().jdField_a_of_type_Lif.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", h());
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_Lif.jdField_a_of_type_JavaLangString);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize dataTransfered: dirction = " + paramInt + ", size = " + paramLong);
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
    //   2: invokestatic 645	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 404	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 18
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 632	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 605	lfb:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 17
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +1946 -> 1974
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 632	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 605	lfb:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 17
    //   45: aload_0
    //   46: getfield 116	com/tencent/av/VideoController:jdField_a_of_type_Lfb	Llfb;
    //   49: aload 17
    //   51: invokevirtual 608	lfb:c	(Ljava/lang/String;)Llid;
    //   54: astore 19
    //   56: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 20
    //   67: new 310	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 2145
    //   77: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 656
    //   87: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2147
    //   97: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2149
    //   108: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 17
    //   113: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 678
    //   119: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2151
    //   130: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 21
    //   135: aload 18
    //   137: ifnull +47 -> 184
    //   140: iconst_1
    //   141: istore 16
    //   143: aload 20
    //   145: iconst_1
    //   146: aload 21
    //   148: iload 16
    //   150: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2153
    //   156: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 19
    //   161: invokevirtual 661	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 322
    //   167: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 464	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   195: aload 18
    //   197: invokevirtual 2156	com/tencent/av/app/VideoAppInterface:a	()Llmr;
    //   200: astore 20
    //   202: aload 20
    //   204: ifnull +10 -> 214
    //   207: aload 20
    //   209: aload 19
    //   211: invokevirtual 2161	lmr:a	(Llid;)V
    //   214: aload 18
    //   216: invokevirtual 475	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   219: aload_0
    //   220: getfield 242	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   223: invokevirtual 481	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 242	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   231: aload_0
    //   232: getfield 209	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   235: ifnull +20 -> 255
    //   238: aload 18
    //   240: invokevirtual 475	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   243: aload_0
    //   244: getfield 209	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   247: invokevirtual 481	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 209	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   255: aload_0
    //   256: getfield 223	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   259: ifnull -78 -> 181
    //   262: aload 18
    //   264: iconst_4
    //   265: anewarray 233	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: sipush 203
    //   273: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: lload_2
    //   280: invokestatic 632	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_0
    //   287: getfield 118	com/tencent/av/VideoController:jdField_a_of_type_Boolean	Z
    //   290: invokestatic 786	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: aastore
    //   294: dup
    //   295: iconst_3
    //   296: lload 12
    //   298: invokestatic 711	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: aastore
    //   302: invokevirtual 714	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   305: aload_0
    //   306: invokevirtual 417	com/tencent/av/VideoController:a	()Llid;
    //   309: getfield 2163	lid:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   312: invokevirtual 758	java/util/ArrayList:size	()I
    //   315: ifle +21 -> 336
    //   318: aload_0
    //   319: invokevirtual 417	com/tencent/av/VideoController:a	()Llid;
    //   322: getfield 696	lid:jdField_ac_of_type_Boolean	Z
    //   325: ifeq +11 -> 336
    //   328: aload_0
    //   329: iconst_2
    //   330: iconst_0
    //   331: iconst_0
    //   332: lconst_0
    //   333: invokevirtual 2165	com/tencent/av/VideoController:a	(IIIJ)V
    //   336: iload_1
    //   337: iconst_2
    //   338: if_icmpne +149 -> 487
    //   341: aload 19
    //   343: getfield 696	lid:jdField_ac_of_type_Boolean	Z
    //   346: ifne +141 -> 487
    //   349: aload 19
    //   351: getfield 2163	lid:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   354: ifnull +133 -> 487
    //   357: new 795	android/content/Intent
    //   360: dup
    //   361: invokespecial 796	android/content/Intent:<init>	()V
    //   364: astore 20
    //   366: aload 20
    //   368: ldc_w 798
    //   371: invokevirtual 802	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   374: pop
    //   375: aload 20
    //   377: ldc_w 804
    //   380: sipush 411
    //   383: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   386: pop
    //   387: aload 20
    //   389: ldc_w 2167
    //   392: aload_0
    //   393: invokevirtual 417	com/tencent/av/VideoController:a	()Llid;
    //   396: getfield 2163	lid:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   399: invokevirtual 2170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   402: pop
    //   403: aload 20
    //   405: ldc_w 807
    //   408: aload_0
    //   409: invokevirtual 417	com/tencent/av/VideoController:a	()Llid;
    //   412: getfield 1308	lid:E	I
    //   415: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   418: pop
    //   419: aload 20
    //   421: ldc_w 809
    //   424: aload_0
    //   425: invokevirtual 417	com/tencent/av/VideoController:a	()Llid;
    //   428: getfield 700	lid:jdField_g_of_type_Long	J
    //   431: invokevirtual 812	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   434: pop
    //   435: aload 20
    //   437: ldc_w 816
    //   440: aload_0
    //   441: invokevirtual 417	com/tencent/av/VideoController:a	()Llid;
    //   444: getfield 693	lid:C	I
    //   447: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   450: pop
    //   451: aload 20
    //   453: ldc_w 868
    //   456: ldc_w 2172
    //   459: invokevirtual 873	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   462: pop
    //   463: aload 20
    //   465: aload 18
    //   467: invokevirtual 820	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   470: invokevirtual 825	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   473: invokevirtual 828	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   476: pop
    //   477: aload 18
    //   479: invokevirtual 820	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   482: aload 20
    //   484: invokevirtual 832	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   487: iload_1
    //   488: bipush 7
    //   490: if_icmpne +10 -> 500
    //   493: aload_0
    //   494: iconst_0
    //   495: iconst_0
    //   496: aconst_null
    //   497: invokevirtual 745	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   500: iload_1
    //   501: bipush 9
    //   503: if_icmpne +29 -> 532
    //   506: aload 19
    //   508: getfield 724	lid:jdField_a_of_type_Lie	Llie;
    //   511: iconst_0
    //   512: putfield 728	lie:jdField_b_of_type_Int	I
    //   515: aload_0
    //   516: iconst_0
    //   517: iconst_0
    //   518: aconst_null
    //   519: invokevirtual 745	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   522: aload 19
    //   524: invokevirtual 2173	lid:b	()V
    //   527: aload 19
    //   529: invokevirtual 2174	lid:a	()V
    //   532: iload_1
    //   533: bipush 10
    //   535: if_icmpne +13 -> 548
    //   538: aload 19
    //   540: invokevirtual 2173	lid:b	()V
    //   543: aload 19
    //   545: invokevirtual 2174	lid:a	()V
    //   548: iload_1
    //   549: iconst_2
    //   550: if_icmpne +1038 -> 1588
    //   553: ldc_w 2176
    //   556: aload 19
    //   558: getfield 2178	lid:q	Ljava/lang/String;
    //   561: invokevirtual 1081	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   564: ifeq +30 -> 594
    //   567: aconst_null
    //   568: ldc_w 2180
    //   571: ldc 170
    //   573: ldc 170
    //   575: ldc_w 2182
    //   578: ldc_w 2182
    //   581: iconst_0
    //   582: iconst_0
    //   583: ldc 170
    //   585: ldc 170
    //   587: ldc 170
    //   589: ldc 170
    //   591: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_0
    //   595: invokevirtual 2184	com/tencent/av/VideoController:h	()Z
    //   598: ifeq +30 -> 628
    //   601: aconst_null
    //   602: ldc_w 2180
    //   605: ldc 170
    //   607: ldc 170
    //   609: ldc_w 2186
    //   612: ldc_w 2186
    //   615: iconst_0
    //   616: iconst_0
    //   617: ldc 170
    //   619: ldc 170
    //   621: ldc 170
    //   623: ldc 170
    //   625: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 19
    //   630: getfield 1317	lid:jdField_j_of_type_Boolean	Z
    //   633: ifeq +38 -> 671
    //   636: aconst_null
    //   637: ldc_w 2180
    //   640: ldc 170
    //   642: ldc 170
    //   644: ldc_w 2188
    //   647: ldc_w 2188
    //   650: iconst_0
    //   651: iconst_0
    //   652: ldc 170
    //   654: ldc 170
    //   656: ldc 170
    //   658: ldc 170
    //   660: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload 19
    //   665: getfield 2189	lid:jdField_m_of_type_Boolean	Z
    //   668: ifeq +890 -> 1558
    //   671: aload_0
    //   672: getfield 244	com/tencent/av/VideoController:jdField_t_of_type_Boolean	Z
    //   675: ifeq +44 -> 719
    //   678: aload_0
    //   679: invokevirtual 2191	com/tencent/av/VideoController:a	()J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifle +35 -> 719
    //   687: aconst_null
    //   688: ldc_w 2180
    //   691: ldc 170
    //   693: ldc 170
    //   695: ldc_w 2193
    //   698: ldc_w 2193
    //   701: iconst_0
    //   702: iconst_0
    //   703: ldc 170
    //   705: ldc 170
    //   707: aload_0
    //   708: invokevirtual 2191	com/tencent/av/VideoController:a	()J
    //   711: invokestatic 2197	mww:a	(J)Ljava/lang/String;
    //   714: ldc 170
    //   716: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   719: aload_0
    //   720: getfield 223	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   723: lload_2
    //   724: invokevirtual 2200	com/tencent/av/gaudio/QQGAudioCtrl:getNetTrafficSize	(J)J
    //   727: lstore 14
    //   729: iload 4
    //   731: bipush 7
    //   733: if_icmpeq +1244 -> 1977
    //   736: iload 4
    //   738: bipush 20
    //   740: if_icmpne +1228 -> 1968
    //   743: goto +1234 -> 1977
    //   746: getstatic 2203	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   749: ifeq +1170 -> 1919
    //   752: aload_0
    //   753: iconst_m1
    //   754: putfield 238	com/tencent/av/VideoController:jdField_v_of_type_Int	I
    //   757: new 2205	com/tencent/av/VideoController$23
    //   760: dup
    //   761: aload_0
    //   762: iload 5
    //   764: invokespecial 2208	com/tencent/av/VideoController$23:<init>	(Lcom/tencent/av/VideoController;I)V
    //   767: bipush 16
    //   769: aconst_null
    //   770: iconst_0
    //   771: invokestatic 2214	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   774: aload_0
    //   775: getfield 236	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   778: astore 20
    //   780: aload 20
    //   782: monitorenter
    //   783: aload_0
    //   784: getfield 236	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   787: sipush 2000
    //   790: i2l
    //   791: invokevirtual 2217	java/lang/Object:wait	(J)V
    //   794: aload 20
    //   796: monitorexit
    //   797: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   800: iconst_1
    //   801: ldc_w 2219
    //   804: invokestatic 338	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: aload_0
    //   808: getfield 2220	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   811: ifeq +1121 -> 1932
    //   814: aload 19
    //   816: getfield 757	lid:jdField_g_of_type_Int	I
    //   819: bipush 9
    //   821: if_icmpne +1111 -> 1932
    //   824: aload 19
    //   826: getfield 765	lid:ae	Z
    //   829: ifne +1103 -> 1932
    //   832: lconst_0
    //   833: lstore 8
    //   835: aload_0
    //   836: ldc_w 2222
    //   839: iconst_0
    //   840: invokevirtual 2224	com/tencent/av/VideoController:b	(Ljava/lang/String;Z)V
    //   843: aload_0
    //   844: getfield 253	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   847: astore 20
    //   849: aload 20
    //   851: monitorenter
    //   852: aload_0
    //   853: getfield 253	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   856: invokevirtual 758	java/util/ArrayList:size	()I
    //   859: ifne +1103 -> 1962
    //   862: aload_0
    //   863: getfield 2220	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   866: ifne +1096 -> 1962
    //   869: aload_0
    //   870: getfield 650	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   873: lconst_0
    //   874: lcmp
    //   875: ifne +1087 -> 1962
    //   878: iconst_1
    //   879: istore 6
    //   881: aload_0
    //   882: getfield 253	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   885: invokevirtual 758	java/util/ArrayList:size	()I
    //   888: istore 7
    //   890: aload_0
    //   891: getfield 253	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   894: invokevirtual 1412	java/util/ArrayList:clear	()V
    //   897: aload 20
    //   899: monitorexit
    //   900: aload_0
    //   901: ldc_w 2222
    //   904: iconst_0
    //   905: iconst_0
    //   906: lconst_0
    //   907: invokevirtual 683	com/tencent/av/VideoController:a	(Ljava/lang/String;ZIJ)V
    //   910: aload 19
    //   912: iconst_0
    //   913: putfield 686	lid:jdField_U_of_type_Boolean	Z
    //   916: aload_0
    //   917: getfield 223	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   920: iconst_0
    //   921: putfield 2227	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   924: aload 18
    //   926: invokevirtual 621	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   929: astore 20
    //   931: lconst_0
    //   932: lstore 10
    //   934: aload 20
    //   936: ifnull +10 -> 946
    //   939: aload 20
    //   941: invokestatic 626	mto:a	(Ljava/lang/String;)J
    //   944: lstore 10
    //   946: aload 20
    //   948: invokestatic 639	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   951: ifne +214 -> 1165
    //   954: new 795	android/content/Intent
    //   957: dup
    //   958: invokespecial 796	android/content/Intent:<init>	()V
    //   961: astore 21
    //   963: aload 21
    //   965: ldc_w 798
    //   968: invokevirtual 802	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   971: pop
    //   972: aload 21
    //   974: ldc_w 804
    //   977: bipush 23
    //   979: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   982: pop
    //   983: aload 21
    //   985: ldc_w 814
    //   988: lload 10
    //   990: invokevirtual 812	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   993: pop
    //   994: aload 21
    //   996: ldc_w 809
    //   999: lload_2
    //   1000: invokevirtual 812	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1003: pop
    //   1004: aload 21
    //   1006: ldc_w 807
    //   1009: iload_1
    //   1010: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1013: pop
    //   1014: aload 21
    //   1016: ldc_w 816
    //   1019: aload 19
    //   1021: getfield 693	lid:C	I
    //   1024: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1027: pop
    //   1028: aload 21
    //   1030: ldc_w 2229
    //   1033: lload 8
    //   1035: invokevirtual 812	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1038: pop
    //   1039: aload 21
    //   1041: ldc_w 861
    //   1044: aload_0
    //   1045: getfield 240	com/tencent/av/VideoController:jdField_s_of_type_Boolean	Z
    //   1048: invokevirtual 864	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1051: pop
    //   1052: aload 21
    //   1054: ldc_w 2231
    //   1057: iload 4
    //   1059: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1062: pop
    //   1063: aload 21
    //   1065: ldc_w 868
    //   1068: ldc_w 2233
    //   1071: invokevirtual 873	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1074: pop
    //   1075: iload 7
    //   1077: iconst_1
    //   1078: if_icmple +871 -> 1949
    //   1081: aload 21
    //   1083: ldc_w 866
    //   1086: iload 7
    //   1088: iconst_1
    //   1089: isub
    //   1090: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1093: pop
    //   1094: aload 21
    //   1096: aload 18
    //   1098: invokevirtual 820	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1101: invokevirtual 825	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1104: invokevirtual 828	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1107: pop
    //   1108: aload 21
    //   1110: lload 12
    //   1112: invokestatic 2238	mwd:a	(Landroid/content/Intent;J)V
    //   1115: aload 18
    //   1117: invokevirtual 820	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1120: aload 21
    //   1122: invokevirtual 832	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1125: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1128: ifeq +37 -> 1165
    //   1131: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1134: iconst_1
    //   1135: new 310	java/lang/StringBuilder
    //   1138: dup
    //   1139: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1142: ldc_w 2240
    //   1145: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: lload 12
    //   1150: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1153: ldc_w 322
    //   1156: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokestatic 464	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1165: aload 19
    //   1167: ldc_w 2222
    //   1170: aconst_null
    //   1171: invokevirtual 2241	lid:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1174: aload 19
    //   1176: aconst_null
    //   1177: putfield 2244	lid:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1180: aload_0
    //   1181: invokevirtual 2246	com/tencent/av/VideoController:i	()V
    //   1184: aload 19
    //   1186: getfield 885	lid:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1189: invokevirtual 758	java/util/ArrayList:size	()I
    //   1192: ifle +28 -> 1220
    //   1195: aload 18
    //   1197: iconst_2
    //   1198: anewarray 233	java/lang/Object
    //   1201: dup
    //   1202: iconst_0
    //   1203: bipush 104
    //   1205: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1208: aastore
    //   1209: dup
    //   1210: iconst_1
    //   1211: aload 19
    //   1213: getfield 885	lid:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1216: aastore
    //   1217: invokevirtual 714	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1220: aload 19
    //   1222: getfield 1308	lid:E	I
    //   1225: iconst_1
    //   1226: if_icmpne +28 -> 1254
    //   1229: aload 18
    //   1231: iconst_2
    //   1232: anewarray 233	java/lang/Object
    //   1235: dup
    //   1236: iconst_0
    //   1237: sipush 410
    //   1240: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1243: aastore
    //   1244: dup
    //   1245: iconst_1
    //   1246: lload_2
    //   1247: invokestatic 711	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1250: aastore
    //   1251: invokevirtual 714	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1254: aload 19
    //   1256: getfield 2248	lid:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   1259: astore 21
    //   1261: aload 19
    //   1263: getfield 1308	lid:E	I
    //   1266: iconst_1
    //   1267: if_icmpeq +12 -> 1279
    //   1270: aload 19
    //   1272: getfield 1308	lid:E	I
    //   1275: iconst_2
    //   1276: if_icmpne +44 -> 1320
    //   1279: aload 19
    //   1281: getfield 1317	lid:jdField_j_of_type_Boolean	Z
    //   1284: ifeq +28 -> 1312
    //   1287: aload 18
    //   1289: iconst_2
    //   1290: anewarray 233	java/lang/Object
    //   1293: dup
    //   1294: iconst_0
    //   1295: bipush 106
    //   1297: invokestatic 708	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1300: aastore
    //   1301: dup
    //   1302: iconst_1
    //   1303: lload 12
    //   1305: invokestatic 711	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1308: aastore
    //   1309: invokevirtual 714	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1312: aload 19
    //   1314: lload 12
    //   1316: iconst_0
    //   1317: invokevirtual 2251	lid:a	(JZ)V
    //   1320: aload 19
    //   1322: lload 12
    //   1324: invokevirtual 2253	lid:c	(J)V
    //   1327: aload_0
    //   1328: invokevirtual 2255	com/tencent/av/VideoController:g	()V
    //   1331: lload 12
    //   1333: aload 18
    //   1335: invokestatic 2258	mdd:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1338: iload 6
    //   1340: ifne +46 -> 1386
    //   1343: aload_0
    //   1344: new 310	java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1351: ldc_w 2260
    //   1354: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: iload 4
    //   1359: invokevirtual 589	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: aload 17
    //   1367: iload_1
    //   1368: invokestatic 2262	mww:c	(I)I
    //   1371: aload 20
    //   1373: lload_2
    //   1374: invokestatic 632	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1377: bipush 7
    //   1379: aload 21
    //   1381: iconst_0
    //   1382: iconst_0
    //   1383: invokevirtual 2265	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1386: aload 19
    //   1388: iconst_m1
    //   1389: putfield 458	lid:jdField_i_of_type_Int	I
    //   1392: aload 19
    //   1394: iconst_1
    //   1395: putfield 2267	lid:jdField_p_of_type_Boolean	Z
    //   1398: aload_0
    //   1399: lload 14
    //   1401: putfield 2130	com/tencent/av/VideoController:jdField_b_of_type_Long	J
    //   1404: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +31 -> 1438
    //   1410: getstatic 85	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1413: iconst_2
    //   1414: new 310	java/lang/StringBuilder
    //   1417: dup
    //   1418: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1421: ldc_w 2269
    //   1424: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: lload 14
    //   1429: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 326	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokestatic 338	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: new 795	android/content/Intent
    //   1441: dup
    //   1442: ldc_w 2136
    //   1445: invokespecial 2138	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1448: astore 19
    //   1450: aload 19
    //   1452: ldc_w 2141
    //   1455: lload 14
    //   1457: invokevirtual 812	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1460: pop
    //   1461: aload 19
    //   1463: aload 18
    //   1465: invokevirtual 820	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1468: invokevirtual 825	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1471: invokevirtual 828	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1474: pop
    //   1475: iload 6
    //   1477: ifne +13 -> 1490
    //   1480: aload 18
    //   1482: invokevirtual 820	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1485: aload 19
    //   1487: invokevirtual 832	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1490: aload_0
    //   1491: getfield 116	com/tencent/av/VideoController:jdField_a_of_type_Lfb	Llfb;
    //   1494: lload 12
    //   1496: aload 17
    //   1498: invokevirtual 2272	lfb:a	(JLjava/lang/String;)Z
    //   1501: istore 16
    //   1503: aload 18
    //   1505: invokestatic 750	mvj:a	(Lcom/tencent/av/app/VideoAppInterface;)Lmvj;
    //   1508: astore 18
    //   1510: aload 18
    //   1512: ifnull +27 -> 1539
    //   1515: aload 18
    //   1517: invokevirtual 751	mvj:a	()Z
    //   1520: ifeq +19 -> 1539
    //   1523: aload 18
    //   1525: aload 17
    //   1527: invokevirtual 839	mvj:a	(Ljava/lang/String;)V
    //   1530: iload 16
    //   1532: ifeq +7 -> 1539
    //   1535: aload_0
    //   1536: invokevirtual 753	com/tencent/av/VideoController:c	()V
    //   1539: invokestatic 2275	com/tencent/av/utils/PopupDialog:a	()V
    //   1542: aload_0
    //   1543: iload 5
    //   1545: invokevirtual 2277	com/tencent/av/VideoController:d	(I)V
    //   1548: goto -1367 -> 181
    //   1551: astore 17
    //   1553: aload_0
    //   1554: monitorexit
    //   1555: aload 17
    //   1557: athrow
    //   1558: aconst_null
    //   1559: ldc_w 2180
    //   1562: ldc 170
    //   1564: ldc 170
    //   1566: ldc_w 2279
    //   1569: ldc_w 2279
    //   1572: iconst_0
    //   1573: iconst_0
    //   1574: ldc 170
    //   1576: ldc 170
    //   1578: ldc 170
    //   1580: ldc 170
    //   1582: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1585: goto -914 -> 671
    //   1588: iload_1
    //   1589: iconst_1
    //   1590: if_icmpne -919 -> 671
    //   1593: ldc_w 2176
    //   1596: aload 19
    //   1598: getfield 2178	lid:q	Ljava/lang/String;
    //   1601: invokevirtual 1081	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1604: ifeq +40 -> 1644
    //   1607: aload 19
    //   1609: getfield 693	lid:C	I
    //   1612: bipush 10
    //   1614: if_icmpne +167 -> 1781
    //   1617: aconst_null
    //   1618: ldc_w 2180
    //   1621: ldc 170
    //   1623: ldc 170
    //   1625: ldc_w 2281
    //   1628: ldc_w 2281
    //   1631: iconst_0
    //   1632: iconst_0
    //   1633: ldc 170
    //   1635: ldc 170
    //   1637: ldc 170
    //   1639: ldc 170
    //   1641: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1644: aload_0
    //   1645: invokevirtual 2184	com/tencent/av/VideoController:h	()Z
    //   1648: ifeq +40 -> 1688
    //   1651: aload 19
    //   1653: getfield 693	lid:C	I
    //   1656: bipush 10
    //   1658: if_icmpne +153 -> 1811
    //   1661: aconst_null
    //   1662: ldc_w 2180
    //   1665: ldc 170
    //   1667: ldc 170
    //   1669: ldc_w 2283
    //   1672: ldc_w 2283
    //   1675: iconst_0
    //   1676: iconst_0
    //   1677: ldc 170
    //   1679: ldc 170
    //   1681: ldc 170
    //   1683: ldc 170
    //   1685: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1688: aload 19
    //   1690: getfield 1317	lid:jdField_j_of_type_Boolean	Z
    //   1693: ifeq -1022 -> 671
    //   1696: aload 19
    //   1698: getfield 693	lid:C	I
    //   1701: bipush 10
    //   1703: if_icmpne +138 -> 1841
    //   1706: aconst_null
    //   1707: ldc_w 2180
    //   1710: ldc 170
    //   1712: ldc 170
    //   1714: ldc_w 2285
    //   1717: ldc_w 2285
    //   1720: iconst_0
    //   1721: iconst_0
    //   1722: ldc 170
    //   1724: ldc 170
    //   1726: ldc 170
    //   1728: ldc 170
    //   1730: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1733: aload 19
    //   1735: getfield 2189	lid:jdField_m_of_type_Boolean	Z
    //   1738: ifne -1067 -> 671
    //   1741: aload 19
    //   1743: getfield 693	lid:C	I
    //   1746: bipush 10
    //   1748: if_icmpne +123 -> 1871
    //   1751: aconst_null
    //   1752: ldc_w 2180
    //   1755: ldc 170
    //   1757: ldc 170
    //   1759: ldc_w 2287
    //   1762: ldc_w 2287
    //   1765: iconst_0
    //   1766: iconst_0
    //   1767: ldc 170
    //   1769: ldc 170
    //   1771: ldc 170
    //   1773: ldc 170
    //   1775: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1778: goto -1107 -> 671
    //   1781: aconst_null
    //   1782: ldc_w 2180
    //   1785: ldc 170
    //   1787: ldc 170
    //   1789: ldc_w 2289
    //   1792: ldc_w 2289
    //   1795: iconst_0
    //   1796: iconst_0
    //   1797: ldc 170
    //   1799: ldc 170
    //   1801: ldc 170
    //   1803: ldc 170
    //   1805: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1808: goto -164 -> 1644
    //   1811: aconst_null
    //   1812: ldc_w 2180
    //   1815: ldc 170
    //   1817: ldc 170
    //   1819: ldc_w 2291
    //   1822: ldc_w 2291
    //   1825: iconst_0
    //   1826: iconst_0
    //   1827: ldc 170
    //   1829: ldc 170
    //   1831: ldc 170
    //   1833: ldc 170
    //   1835: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1838: goto -150 -> 1688
    //   1841: aconst_null
    //   1842: ldc_w 2180
    //   1845: ldc 170
    //   1847: ldc 170
    //   1849: ldc_w 2293
    //   1852: ldc_w 2293
    //   1855: iconst_0
    //   1856: iconst_0
    //   1857: ldc 170
    //   1859: ldc 170
    //   1861: ldc 170
    //   1863: ldc 170
    //   1865: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1868: goto -135 -> 1733
    //   1871: aconst_null
    //   1872: ldc_w 2180
    //   1875: ldc 170
    //   1877: ldc 170
    //   1879: ldc_w 2295
    //   1882: ldc_w 2295
    //   1885: iconst_0
    //   1886: iconst_0
    //   1887: ldc 170
    //   1889: ldc 170
    //   1891: ldc 170
    //   1893: ldc 170
    //   1895: invokestatic 1194	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1898: goto -1227 -> 671
    //   1901: astore 21
    //   1903: aload 21
    //   1905: invokevirtual 2296	java/lang/InterruptedException:printStackTrace	()V
    //   1908: goto -1114 -> 794
    //   1911: astore 17
    //   1913: aload 20
    //   1915: monitorexit
    //   1916: aload 17
    //   1918: athrow
    //   1919: aload_0
    //   1920: getfield 223	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1923: iload 5
    //   1925: invokevirtual 2299	com/tencent/av/gaudio/QQGAudioCtrl:quit	(I)I
    //   1928: pop
    //   1929: goto -1122 -> 807
    //   1932: aload_0
    //   1933: invokevirtual 2191	com/tencent/av/VideoController:a	()J
    //   1936: lstore 8
    //   1938: goto -1103 -> 835
    //   1941: astore 17
    //   1943: aload 20
    //   1945: monitorexit
    //   1946: aload 17
    //   1948: athrow
    //   1949: aload 21
    //   1951: ldc_w 866
    //   1954: iconst_0
    //   1955: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1958: pop
    //   1959: goto -865 -> 1094
    //   1962: iconst_0
    //   1963: istore 6
    //   1965: goto -1084 -> 881
    //   1968: iconst_0
    //   1969: istore 5
    //   1971: goto -1225 -> 746
    //   1974: goto -1929 -> 45
    //   1977: iload 4
    //   1979: istore 5
    //   1981: goto -1235 -> 746
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1984	0	this	VideoController
    //   0	1984	1	paramInt1	int
    //   0	1984	2	paramLong	long
    //   0	1984	4	paramInt2	int
    //   762	1218	5	i1	int
    //   879	1085	6	i2	int
    //   888	202	7	i3	int
    //   833	1104	8	l1	long
    //   932	57	10	l2	long
    //   5	1490	12	l3	long
    //   727	729	14	l4	long
    //   141	1390	16	bool	boolean
    //   24	1502	17	str	String
    //   1551	5	17	localObject1	Object
    //   1911	6	17	localObject2	Object
    //   1941	6	17	localObject3	Object
    //   11	1513	18	localObject4	Object
    //   54	1688	19	localObject5	Object
    //   133	1247	21	localObject7	Object
    //   1901	49	21	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	26	1551	finally
    //   31	45	1551	finally
    //   45	135	1551	finally
    //   143	176	1551	finally
    //   195	202	1551	finally
    //   207	214	1551	finally
    //   214	255	1551	finally
    //   255	336	1551	finally
    //   341	487	1551	finally
    //   493	500	1551	finally
    //   506	532	1551	finally
    //   538	548	1551	finally
    //   553	594	1551	finally
    //   594	628	1551	finally
    //   628	671	1551	finally
    //   671	719	1551	finally
    //   719	729	1551	finally
    //   746	783	1551	finally
    //   797	807	1551	finally
    //   807	832	1551	finally
    //   835	852	1551	finally
    //   900	931	1551	finally
    //   939	946	1551	finally
    //   946	1075	1551	finally
    //   1081	1094	1551	finally
    //   1094	1165	1551	finally
    //   1165	1220	1551	finally
    //   1220	1254	1551	finally
    //   1254	1279	1551	finally
    //   1279	1312	1551	finally
    //   1312	1320	1551	finally
    //   1320	1338	1551	finally
    //   1343	1386	1551	finally
    //   1386	1438	1551	finally
    //   1438	1475	1551	finally
    //   1480	1490	1551	finally
    //   1490	1510	1551	finally
    //   1515	1530	1551	finally
    //   1535	1539	1551	finally
    //   1539	1548	1551	finally
    //   1558	1585	1551	finally
    //   1593	1644	1551	finally
    //   1644	1688	1551	finally
    //   1688	1733	1551	finally
    //   1733	1778	1551	finally
    //   1781	1808	1551	finally
    //   1811	1838	1551	finally
    //   1841	1868	1551	finally
    //   1871	1898	1551	finally
    //   1916	1919	1551	finally
    //   1919	1929	1551	finally
    //   1932	1938	1551	finally
    //   1946	1949	1551	finally
    //   1949	1959	1551	finally
    //   783	794	1901	java/lang/InterruptedException
    //   783	794	1911	finally
    //   794	797	1911	finally
    //   1903	1908	1911	finally
    //   1913	1916	1911	finally
    //   852	878	1941	finally
    //   881	900	1941	finally
    //   1943	1946	1941	finally
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = lfb.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = lfb.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l1 = AudioHelper.b();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], seq[" + l1 + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((lid)localObject).jdField_j_of_type_Boolean)) {
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
      int i1 = mww.c(paramInt1);
      a(a().jdField_c_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        a("onGAudioSDKError_2");
        if (this.jdField_a_of_type_Mwk != null) {
          this.jdField_a_of_type_Mwk.a(l1);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_a_of_type_Lfb.a(l1, str);
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
    lid locallid = a();
    String str;
    if (paramInt2 == 3)
    {
      str = lfb.a(100, String.valueOf(paramLong2), new int[0]);
      boolean bool = TextUtils.equals(locallid.jdField_c_of_type_JavaLangString, str);
      if ((!bool) || (QLog.isDevelopLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + locallid.jdField_c_of_type_JavaLangString + "], seq[" + l1 + "]");
      }
      if (bool) {
        break label169;
      }
    }
    label169:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      str = lfb.a(paramInt2, String.valueOf(paramLong2), new int[0]);
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
    lek.a("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    f(false);
    Object localObject1 = a();
    long l2 = a(String.valueOf(paramLong2));
    long l3 = d();
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder().append("onGAudioInvite, friendUin[").append(paramLong2).append("], groupId[").append(paramLong1).append("], multiSubType[").append(paramInt3).append("], multiAVType[").append(paramInt2).append("], relationType[").append(paramInt1).append("], mGAudioInRoom[").append(this.jdField_e_of_type_Boolean).append("], mGAudioGroupId[").append(this.jdField_a_of_type_Long).append("], mCurrentInviteId[").append(this.jdField_d_of_type_Long).append("], mCurrentInviteRelationType[").append(this.jdField_n_of_type_Int).append("], offLineInvite[").append(paramBoolean).append("], roomId[").append(l2).append("], gRoomId[").append(l3).append("], seq[").append(l1).append("], main[").append(localObject1).append("], app[");
      if (localVideoAppInterface == null) {
        break label288;
      }
    }
    label288:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.w((String)localObject2, 2, paramBoolean + "], original[" + paramInt4 + "]");
      if (localVideoAppInterface != null) {
        break;
      }
      return;
    }
    paramBoolean = false;
    if ((paramInt3 == 6) || (paramInt3 == 5) || (paramInt3 == 4) || (paramInt3 == 3)) {
      paramBoolean = true;
    }
    if (!bdex.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
      return;
    }
    Object localObject3 = lfb.a(paramInt1, String.valueOf(paramLong1), new int[0]);
    if (this.jdField_a_of_type_Lfb.a((String)localObject3))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Lfb.a((String)localObject3, false);
    ((lid)localObject2).jdField_g_of_type_Long = paramLong1;
    ((lid)localObject2).E = paramInt1;
    ((lid)localObject2).C = paramInt2;
    ((lid)localObject2).ag = false;
    ((lid)localObject2).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    ((lid)localObject2).jdField_ac_of_type_Int = paramInt4;
    if (this.jdField_a_of_type_Lfb.a() >= 2)
    {
      a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    VideoConstants.jdField_b_of_type_Boolean = localVideoAppInterface.b();
    paramBoolean = false;
    if (!((lid)localObject1).e()) {
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
        ((lid)localObject2).a("onGAudioInvite.1", 0);
      }
      K();
      bool = a(localVideoAppInterface.getApp().getApplicationContext());
      if (!bool) {
        break label803;
      }
      if ((((lid)localObject1).jdField_g_of_type_Int <= 0) || (((lid)localObject1).jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
        break;
      }
      a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
      if (localVideoAppInterface.e()) {
        paramBoolean = true;
      }
    }
    if (7 == ((lid)localObject1).jdField_g_of_type_Int)
    {
      a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
    {
      a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((((lid)localObject1).jdField_g_of_type_Int == 14) || (((lid)localObject1).jdField_g_of_type_Int == 13))
    {
      a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((((lid)localObject1).jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) && (((lid)localObject1).jdField_a_of_type_Lie.jdField_a_of_type_Int == 1))
    {
      a(l1, "ScreenLocked_in_random", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((paramBoolean) && (paramInt3 != 3))
    {
      a(l1, "ScreenLocked_session_exist", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    label803:
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + ((lid)localObject1).jdField_a_of_type_Lie.jdField_b_of_type_Int + "], chatType[" + ((lid)localObject1).jdField_a_of_type_Lie.jdField_a_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
    }
    if (((lid)localObject2).jdField_d_of_type_Int == 0)
    {
      ((lid)localObject2).jdField_e_of_type_Boolean = true;
      ((lid)localObject2).a(l1, "onGAudioInvite.1", 3);
      ((lid)localObject2).jdField_i_of_type_Int = mww.c(paramInt1);
      ((lid)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong2);
      if (paramInt1 == 2) {
        ((lid)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong2);
      }
      ((lid)localObject2).jdField_e_of_type_Boolean = true;
      if ((paramInt3 != 3) && (paramInt3 != 4)) {
        a((String)localObject3, ((lid)localObject2).jdField_d_of_type_Int, false, false, false);
      }
    }
    this.jdField_d_of_type_Long = paramLong1;
    this.jdField_n_of_type_Int = paramInt1;
    if (((lid)localObject2).jdField_g_of_type_Int == 0) {
      ((lid)localObject2).a("onGAudioInvite", 7);
    }
    boolean bool = false;
    if ((paramInt3 == 3) && (((lid)localObject1).jdField_g_of_type_Long == 0L)) {
      bool = b((lid)localObject1, (lid)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite multiSubType[" + paramInt3 + "], hasDeal[" + bool + "]");
      }
      if (bool) {
        break;
      }
      if ((localVideoAppInterface == null) || (!localVideoAppInterface.c())) {
        break label1408;
      }
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
      paramArrayOfLong.putExtra("extraUin", ((lid)localObject1).jdField_f_of_type_JavaLangString);
      paramArrayOfLong.putExtra("discussId", paramLong1);
      paramArrayOfLong.putExtra("type", 13);
      paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("isSender", false);
      paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("realSenderUin", ((lid)localObject1).jdField_s_of_type_JavaLangString);
      localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
      a(l1, this.jdField_n_of_type_Int, paramLong1, true);
      new bhms(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      this.jdField_a_of_type_Lfb.a(l1, (String)localObject3);
      return;
      if (paramInt3 == 4) {
        bool = a((lid)localObject1, (lid)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
      }
    }
    label1408:
    ((lid)localObject1).jdField_s_of_type_JavaLangString = ("" + paramLong2);
    this.jdField_t_of_type_Boolean = b();
    if (((lid)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite msg blocked [" + ((lid)localObject2).jdField_c_of_type_JavaLangString + "]");
      }
      if (!localVideoAppInterface.jdField_c_of_type_Boolean) {
        break label1787;
      }
      localVideoAppInterface.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      localVideoAppInterface.jdField_d_of_type_Boolean = true;
      return;
      if ((paramBoolean) || (lge.a()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        bdfc.d();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", mww.c(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((lid)localObject2).jdField_c_of_type_JavaLangString);
        if ((!this.jdField_t_of_type_Boolean) || (!mbt.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1778;
        }
        if ((!paramBoolean) && (!lge.a())) {
          break label1746;
        }
        paramArrayOfLong = new mgv(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.d();
        paramArrayOfLong.a((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1746:
      paramArrayOfLong = new mnd(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.d();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1778:
      a((Intent)localObject1);
      break;
      label1787:
      lkx.a();
    }
  }
  
  public void a(int paramInt, long paramLong, lyh paramlyh)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt, paramLong, paramlyh);
    }
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    paramVarArgs = lfb.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_Lfb.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = lfb.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      lid locallid = this.jdField_a_of_type_Lfb.c(paramVarArgs);
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l1 + "], \nsession[" + locallid + "]");
      }
      int i1;
      if ((locallid != null) && ((locallid.jdField_g_of_type_Int == 7) || (locallid.jdField_g_of_type_Int == 2)))
      {
        locallid.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_Lfb.a(paramVarArgs))
        {
          locallid = this.jdField_a_of_type_Lfb.c(paramVarArgs);
          i1 = mww.c(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(locallid.jdField_c_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Lfb.a(l1, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, locallid.jdField_s_of_type_JavaLangString, true, false);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Lfb == null) || (a() == null) || (a().jdField_d_of_type_JavaLangString == null)) {}
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
      a().R = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "remote confirm switch to video");
    }
    a().R = false;
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
      Object localObject1 = this.jdField_a_of_type_Lfb;
      localObject1 = this.jdField_a_of_type_Lfb;
      localObject1 = lfb.a(lfb.a(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_a_of_type_Lfb.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((lid)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((lid)localObject1).jdField_d_of_type_JavaLangString)) && (((lid)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((lid)localObject1).z);
      ((Intent)localObject2).putExtra("bindId", ((lid)localObject1).jdField_p_of_type_JavaLangString);
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
    boolean bool3 = d(paramString1);
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
    O();
    K();
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i2 = mvn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i2 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
    }
    localObject = a();
    if (this.jdField_a_of_type_Lfb.a() >= 2)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->pending session exists");
      i1 = -1;
      str = null;
      if (localObject != null)
      {
        i1 = ((lid)localObject).jdField_i_of_type_Int;
        str = ((lid)localObject).jdField_d_of_type_JavaLangString;
      }
      if ((i2 == 1011) && (i1 == 1011) && (str != null) && (str.equals(paramString1))) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->pending session exists, equals to the current one.");
      }
    }
    else
    {
      str = lfb.a(3, paramString1, new int[0]);
      if ((!TextUtils.equals(str, ((lid)localObject).jdField_c_of_type_JavaLangString)) || (!((lid)localObject).jdField_d_of_type_Boolean)) {
        break label499;
      }
      ((lid)localObject).jdField_e_of_type_Boolean = true;
      paramInt1 = 1;
      if (((lid)localObject).R) {
        paramInt1 = 0;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((lid)localObject).E);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->pending session exists, just reject.");
    a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
    return;
    label499:
    boolean bool2 = false;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((i2 != 21) && (i2 != 1011) && ((((lid)localObject).jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (((lid)localObject).jdField_a_of_type_Lie.jdField_a_of_type_Int == 1))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in Random Double");
      if (bool4)
      {
        a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
        return;
      }
      bool2 = true;
      bool1 = bool2;
      if (!this.jdField_f_of_type_Boolean)
      {
        a(l2, 30000L);
        bool1 = bool2;
      }
      label650:
      this.jdField_a_of_type_Lfb.a(str, false);
      localObject = this.jdField_a_of_type_Lfb.c(str);
      ((lid)localObject).z = paramInt2;
      ((lid)localObject).jdField_p_of_type_JavaLangString = paramString3;
      ((lid)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((lid)localObject).A = i2;
      if (this.jdField_h_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_h_of_type_JavaLangRunnable = null;
        ((lid)localObject).a("onRequestVideo.1", 0);
      }
      if (this.jdField_a_of_type_Lnq == null) {
        break label1931;
      }
    }
    label770:
    label1931:
    for (int i1 = 9500;; i1 = i2)
    {
      this.jdField_a_of_type_Boolean = true;
      ((lid)localObject).R = paramBoolean;
      label889:
      long l3;
      if (paramBoolean)
      {
        ((lid)localObject).jdField_f_of_type_Int = 1;
        l1 = a(paramString1);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  ,roomId = " + l1);
        ((lid)localObject).d(l1);
        ((lid)localObject).jdField_i_of_type_Int = i1;
        ((lid)localObject).jdField_j_of_type_Int = paramInt1;
        ((lid)localObject).jdField_d_of_type_JavaLangString = paramString1;
        ((lid)localObject).jdField_f_of_type_JavaLangString = paramString2;
        ((lid)localObject).jdField_e_of_type_Boolean = true;
        ((lid)localObject).a("onRequestVideo.2", 2);
        ((lid)localObject).jdField_p_of_type_Int = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!paramBoolean) {
          break label1617;
        }
        paramInt1 = 1;
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        l3 = a(paramString1);
        lkx.a(l3, 36);
        lkx.a(l3, 9, ((lid)localObject).b());
        lkx.a(l3, 11, paramString1);
        lkx.a(l3, 12, 2L);
        if (!((lid)localObject).R) {
          break label1622;
        }
      }
      label1617:
      label1622:
      for (long l1 = 1L;; l1 = 2L)
      {
        lkx.a(l3, 13, l1);
        lkx.a(l3, 15, 1L);
        x(paramString1);
        if (!bool3) {
          break label1630;
        }
        ((lid)localObject).jdField_c_of_type_Boolean = true;
        b(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((lid)localObject).jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) && (((lid)localObject).jdField_a_of_type_Lie.jdField_a_of_type_Int == 3))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in Random mulit");
          if (bool4)
          {
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label650;
        }
        if (((lid)localObject).e())
        {
          if (i2 == -1)
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
            break label650;
          }
          bool1 = true;
          break label650;
        }
        if ((((lid)localObject).n()) || (((lid)localObject).o()))
        {
          b(((lid)localObject).jdField_d_of_type_JavaLangString, 2);
          bool1 = bool2;
          break label650;
        }
        if (((((lid)localObject).jdField_g_of_type_Int == 7) && (this.jdField_d_of_type_Long != 0L)) || (((lid)localObject).jdField_g_of_type_Int == 14) || (((lid)localObject).jdField_g_of_type_Int == 13))
        {
          if (bool4)
          {
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label650;
        }
        if (!this.jdField_e_of_type_Boolean)
        {
          if (((i2 == 21) || (i2 == 1011)) && (a().jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString != null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  auto Accept");
            if ((((lid)localObject).jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString != null) && (!((lid)localObject).jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString.equals(paramString1)))
            {
              a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            a(l2, 30000L);
            bool1 = bool2;
            break label650;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool4);
          bool1 = true;
          if ((((lid)localObject).jdField_d_of_type_JavaLangString != null) && (paramString1.equals(((lid)localObject).jdField_d_of_type_JavaLangString)))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when request: fromUin = " + paramString1);
            G();
            x(paramString1);
            return;
          }
          if (!bool4) {
            break label650;
          }
          a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.jdField_e_of_type_Boolean) || (((lid)localObject).jdField_g_of_type_Int == 8))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in group chat, fromUin = " + paramString1);
          if (bool4)
          {
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label650;
        }
        bool1 = bool2;
        if (((lid)localObject).jdField_g_of_type_Int != 1) {
          break label650;
        }
        bool1 = bool2;
        if (((lid)localObject).jdField_d_of_type_JavaLangString == null) {
          break label650;
        }
        bool1 = bool2;
        if (!paramString1.equals(((lid)localObject).jdField_d_of_type_JavaLangString)) {
          break label650;
        }
        return;
        ((lid)localObject).jdField_f_of_type_Int = 2;
        break label770;
        paramInt1 = 2;
        break label889;
      }
      label1630:
      if ((!this.jdField_e_of_type_Boolean) && (((lid)localObject).jdField_i_of_type_Int != 21) && (((lid)localObject).jdField_i_of_type_Int != 1011)) {
        a(str, ((lid)localObject).jdField_f_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_t_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
      }
      if ((this.y) && (this.jdField_t_of_type_Int == 0) && (!bool4) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.6(this, l2, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_Lfe != null) {
        this.jdField_a_of_type_Lfe.b();
      }
      this.jdField_a_of_type_Lfe = new lfe(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      a(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt, ArrayList<lps> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      lps locallps = (lps)paramArrayList.get(i1);
      a(locallps.jdField_a_of_type_Long, locallps.jdField_a_of_type_Int, locallps.jdField_b_of_type_Int, false);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void a(int paramInt, mqo parammqo)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + parammqo);
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMqo == null) {
      this.jdField_a_of_type_ArrayOfMqo = new mqo[2];
    }
    this.jdField_a_of_type_ArrayOfMqo[paramInt] = parammqo;
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
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    lid locallid = a();
    k();
    locallid.a("onSubState2", 4);
    locallid.a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!locallid.jdField_g_of_type_Boolean) {
        break label219;
      }
      a(true, locallid.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, paramLong), 50L);
      a(locallid.jdField_c_of_type_JavaLangString, locallid.jdField_d_of_type_Int, true, true, true);
      mtq.i(this);
      mtq.c(this, true);
      mtq.b(this, true);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        lmr locallmr = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (locallmr != null) {
          locallmr.a(locallid);
        }
      }
      return;
      c();
      break;
      label219:
      a(false, locallid.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioMicSetByAdmin, manager uin[" + paramLong + "], old micAuthByAdmin[" + a().G + "], new micAuthByAdmin[" + paramInt + "], mIsMicOffBySelf[" + this.jdField_v_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    a().d("onGAudioMicSetByAdmin", paramInt);
    if (paramInt == 2) {
      return;
    }
    long l1;
    boolean bool1;
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (paramInt != 0))
    {
      l1 = this.jdField_a_of_type_Long;
      if (paramInt != 0) {
        break label194;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() != paramLong) {
        break label200;
      }
    }
    label194:
    label200:
    for (boolean bool2 = true;; bool2 = false)
    {
      a("onGAudioMicSetByAdmin", l1, bool1, bool2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_Lfb.a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, inviteUin[" + paramLong + "], aliveSessionCount[" + i1 + "], multiAVType[" + paramInt1 + "], multiSubType[" + paramInt2 + "], seq[" + l1 + "], \nmainSession[" + a() + "]");
    if ((i1 >= 2) && (paramInt2 != 5)) {
      a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
    }
    Object localObject1;
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      localObject1 = lfb.a(100, String.valueOf(paramLong), new int[0]);
      this.jdField_a_of_type_Lfb.a((String)localObject1, false);
      VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
      bool1 = false;
      bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
      if ((!TextUtils.equals(a().jdField_d_of_type_JavaLangString, String.valueOf(paramLong))) || ((a().jdField_h_of_type_Int != 16) && (paramInt2 != 5))) {
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
    if ((TextUtils.equals(a().jdField_d_of_type_JavaLangString, String.valueOf(paramLong))) && (a().jdField_h_of_type_Int == 11))
    {
      if (this.jdField_d_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        this.jdField_d_of_type_JavaLangRunnable = null;
      }
      this.jdField_a_of_type_Lfb.c((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
      b(a().jdField_d_of_type_JavaLangString, 2);
    }
    if (a().e()) {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = this.jdField_a_of_type_Lfb.c((String)localObject1);
      if (localObject2 != null)
      {
        ((lid)localObject2).R = true;
        ((lid)localObject2).jdField_f_of_type_Int = 2;
        ((lid)localObject2).jdField_i_of_type_Int = 0;
        ((lid)localObject2).E = 3;
        ((lid)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        ((lid)localObject2).jdField_f_of_type_JavaLangString = null;
        ((lid)localObject2).jdField_e_of_type_Boolean = true;
        ((lid)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
        ((lid)localObject2).d("onDoubleVideoMeetingInvite", true);
        ((lid)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong);
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
      new bhms(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_Lfb.a(l1, (String)localObject1);
      return;
      if ((a().n()) || (a().o()) || (a().p()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_d_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_Lfb.c((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
          o(true);
          a(a().jdField_d_of_type_JavaLangString, 299);
          b(299);
          b(a().jdField_d_of_type_JavaLangString, 2);
        }
        else if ((a().n()) || (a().o()))
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.jdField_t_of_type_Int + "], isQQPaused[" + VideoConstants.jdField_b_of_type_Boolean + "], isVideoPaused[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(a()) + "], seq[" + l1 + "]");
    }
    if ((this.y) && (this.jdField_t_of_type_Int == 0) && (!bool2) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.24(this, l1, (String)localObject1, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l1, (String)localObject1, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
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
      this.jdField_a_of_type_Mwk.b(paramLong);
      if (!this.jdField_a_of_type_Mwk.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        lek.d(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_d_of_type_JavaLangString, 212);
        b(212);
        b(a().jdField_d_of_type_JavaLangString, a().y);
      }
    } while (!a().S);
    lek.d(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
    a(a().jdField_d_of_type_JavaLangString, 213);
    b(213);
    b(a().jdField_d_of_type_JavaLangString, a().y);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = a(paramLong, paramInt1, paramInt2, paramBoolean);
    long l1;
    if (paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "onGAudioMemberMicChanged, uin[" + paramLong + "], mGAudioMute[" + this.jdField_m_of_type_Boolean + "], isMicOff[" + paramBoolean + "], mIsMicOffBySelf[" + this.jdField_v_of_type_Boolean + "]");
      }
      if ((paramBoolean != this.jdField_m_of_type_Boolean) && (!this.jdField_v_of_type_Boolean))
      {
        l1 = this.jdField_a_of_type_Long;
        if (paramBoolean) {
          break label210;
        }
      }
    }
    label210:
    for (boolean bool1 = true;; bool1 = false)
    {
      a("onGAudioMemberMicChanged", l1, bool1, false);
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
    mwk.a().b();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = lfb.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_a_of_type_Lfb.c(str1);
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
      str1 = lfb.a(paramInt1, String.valueOf(paramLong2), new int[0]);
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
    ((lid)localObject).ag = true;
    int i1 = 4;
    label277:
    String str2;
    if (((lid)localObject).jdField_g_of_type_Int == 7)
    {
      ((lid)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        i();
        paramInt2 = mww.c(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((lid)localObject).jdField_c_of_type_JavaLangString, mww.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((lid)localObject).jdField_g_of_type_Long), 5, ((lid)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_Lfb.a(paramLong1, str1);
      localObject = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mvj)localObject).a())) {
        break;
      }
      ((mvj)localObject).a(str1);
      if (!paramBoolean) {
        break;
      }
      c();
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
        a("ignoreGAudioChat_2", str1, paramInt2, ((lid)localObject).jdField_d_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((lid)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i1, ((lid)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
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
        break label425;
      }
      i1 = 1;
      azmj.b(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i1, 0, "", "", "", "");
      if (paramArrayList == null) {
        break label615;
      }
      m(true);
      i1 = 1;
      i2 = 2;
      if (paramInt == 1)
      {
        i2 = 1;
        i1 = 10;
      }
      localObject2 = a();
      localObject1 = lfb.a(i2, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_a_of_type_Lfb.a((String)localObject1, false);
      i3 = ((lid)localObject2).jdField_d_of_type_Int;
      ((lid)localObject1).a(paramLong1, ((lid)localObject2).jdField_j_of_type_Boolean);
      ((lid)localObject1).jdField_g_of_type_Boolean = ((lid)localObject2).jdField_g_of_type_Boolean;
      ((lid)localObject1).a("switchToMultiAudio", ((lid)localObject2).jdField_O_of_type_Boolean);
      ((lid)localObject1).b("switchToMultiAudio", ((lid)localObject2).q);
      ((lid)localObject1).jdField_d_of_type_JavaLangString = ((lid)localObject2).jdField_d_of_type_JavaLangString;
      ((lid)localObject1).C = i1;
      ((lid)localObject1).aD = true;
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      if (!((lid)localObject2).jdField_J_of_type_Boolean) {
        break label431;
      }
      boolean bool = this.jdField_m_of_type_Boolean;
      a(paramLong1, Long.valueOf(((lid)localObject2).jdField_d_of_type_JavaLangString).longValue(), true, 0);
      b("switchToMultiAudio", bool);
    }
    for (this.jdField_f_of_type_Int = 2;; this.jdField_f_of_type_Int = 1)
    {
      if (!paramArrayList.contains(((lid)localObject2).jdField_d_of_type_JavaLangString)) {
        paramArrayList.add(((lid)localObject2).jdField_d_of_type_JavaLangString);
      }
      localObject2 = new long[paramArrayList.size()];
      paramArrayList = paramArrayList.iterator();
      i1 = 0;
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label477;
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
      label425:
      i1 = 2;
      break label92;
      label431:
      a(((lid)localObject2).jdField_d_of_type_JavaLangString, 1);
      b(214);
      b(((lid)localObject2).jdField_d_of_type_JavaLangString, 21);
    }
    label477:
    if (i1 == localObject2.length)
    {
      ((lid)localObject1).jdField_a_of_type_ArrayOfLong = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((lid)localObject1).y = -1;
      if (i3 != 1) {
        break label657;
      }
      ((lid)localObject1).a(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((lid)localObject1).jdField_i_of_type_Int = paramInt;
      ((lid)localObject1).jdField_g_of_type_Long = paramLong2;
      ((lid)localObject1).c("switchToMultiAudio", mti.a(paramInt));
      ((lid)localObject1).b("switchToMultiAudio", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label615:
      return;
      ((lid)localObject1).jdField_a_of_type_ArrayOfLong = new long[i1];
      i2 = 0;
      while (i2 < i1)
      {
        ((lid)localObject1).jdField_a_of_type_ArrayOfLong[i2] = localObject2[i2];
        i2 += 1;
      }
      break;
      label657:
      if (i3 == 2) {
        ((lid)localObject1).a(paramLong1, "switchToMultiAudio.2", 4);
      } else if (i3 == 3) {
        ((lid)localObject1).a(paramLong1, "switchToMultiAudio.3", 3);
      } else if (i3 == 4) {
        ((lid)localObject1).a(paramLong1, "switchToMultiAudio.4", 3);
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
        if (((paramInt == 2) || (paramInt == 1)) && (a().jdField_J_of_type_Boolean))
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
    String str = lfb.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_a_of_type_Lfb.c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((lid)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((lid)localObject).jdField_d_of_type_JavaLangString, ((lid)localObject).jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((lid)localObject).C);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_Lfb.a(paramLong1, str);
      localObject = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mvj)localObject).a())) {
        break;
      }
      ((mvj)localObject).a(str);
      if (!bool) {
        break;
      }
      c();
      return;
      a(str, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    lfu locallfu = a(String.valueOf(paramLong2));
    if (locallfu == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    locallfu.jdField_d_of_type_Boolean = false;
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
      a().ab = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
    a().ab = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramLong1);
    localNewIntent.putExtra("groupuin", paramLong2);
    localNewIntent.putExtra("groupcode", paramLong3);
    localNewIntent.putExtra("reqType", 12);
    a(localNewIntent);
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
  
  public void a(long paramLong1, long paramLong2, ArrayList<lqk> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.27(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramBoolean);
    localNewIntent.putExtra("groupuin", paramLong1);
    localNewIntent.putExtra("groupcode", paramLong2);
    localNewIntent.putExtra("reqType", 13);
    a(localNewIntent);
  }
  
  @TargetApi(21)
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, relationId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    Object localObject = this.jdField_a_of_type_Mls;
    if (localObject != null) {
      ((mls)localObject).a(5);
    }
    localObject = lfb.a(100, String.valueOf(paramLong2), new int[0]);
    lid locallid = this.jdField_a_of_type_Lfb.c((String)localObject);
    if (locallid == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", locallid.C);
    localIntent.putExtra("from", "VideoController6");
    mwd.a(localIntent, paramLong1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a((String)localObject, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (locallid.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      locallid.c("quitDoubleVideoMeeting", false);
      locallid.d("quitDoubleVideoMeeting", false);
    }
    for (;;)
    {
      localObject = a();
      if (localObject == null) {
        break;
      }
      ((ScreenShareCtrl)localObject).b(paramLong2);
      return;
      locallid.a("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230741, 1, this.jdField_c_of_type_Lfv);
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.31(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong1, paramLong2, paramArrayOfByte);
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
    P();
    String str = lfb.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_Lfb.a(str)) {}
    for (lid locallid = this.jdField_a_of_type_Lfb.c(str); locallid == null; locallid = this.jdField_a_of_type_Lfb.c(str))
    {
      lek.e(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = lfb.a(100, paramString, new int[0]);
    }
    locallid.jdField_d_of_type_Boolean = false;
    if ((q()) && (paramString != null) && (!paramString.equals(locallid.jdField_d_of_type_JavaLangString)))
    {
      lek.d(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + locallid.jdField_d_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Lfe != null)
    {
      this.jdField_a_of_type_Lfe.b();
      this.jdField_a_of_type_Lfe = null;
    }
    this.jdField_i_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    k();
    if ((locallid.jdField_d_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(paramLong, str, paramString, 3);
      label296:
      if (!locallid.i()) {
        break label440;
      }
      locallid.y = paramInt;
      if ((locallid.i()) && (paramInt == locallid.jdField_d_of_type_Int)) {
        locallid.a(paramLong, 0L);
      }
      locallid.a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(locallid.jdField_d_of_type_JavaLangString, locallid.y);
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
        if (locallid.g())
        {
          locallid.y = paramInt;
          locallid.a(paramLong, 0L);
          int i2 = 2131230741;
          switch (paramInt)
          {
          default: 
            i1 = 0;
            this.jdField_a_of_type_Lfv.jdField_a_of_type_Long = paramLong;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a(paramLong, i2, i1, this.jdField_a_of_type_Lfv);
            locallid.a("onCloseVideo.isInviting1", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            azmj.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            if (l()) {
              break;
            }
            if (locallid.jdField_d_of_type_Long != 2L)
            {
              azmj.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230740;
              break label531;
            }
            i2 = 2131230741;
            i1 = 1;
            break label531;
            this.jdField_b_of_type_Lfv.jdField_a_of_type_Long = paramLong;
            a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lfv);
            locallid.a("onCloseVideo.isInviting", 6);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (l()) {
              break;
            }
            azmj.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            i2 = 2131230740;
            i1 = 0;
            break label531;
          }
        }
        label531:
        if (!locallid.n())
        {
          locallid.y = paramInt;
          if (locallid.i()) {
            locallid.a(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (locallid.jdField_i_of_type_Int == 1011))
          {
            locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label1080;
            }
            a(6, 0, null);
            label950:
            mvj localmvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label1097;
            }
            if (localmvj != null) {
              localmvj.a();
            }
          }
          label976:
          locallid.a("onCloseVideo.isClosing1", 6);
          if ((!q()) && (!muz.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label1104;
          }
          a(locallid.jdField_d_of_type_JavaLangString, 209);
          b(209);
          b(locallid.jdField_d_of_type_JavaLangString, locallid.y);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1080:
      a(locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int, 0, null);
      break label950;
      label1097:
      c();
      break label976;
      label1104:
      this.jdField_b_of_type_Lfv.jdField_a_of_type_Long = paramLong;
      a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lfv);
      mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_t_of_type_Boolean = b();
    boolean bool3 = mbt.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.jdField_t_of_type_Boolean + "], isFloatWindowOpAllowedOnBackground[" + bool3 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l1 + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!lno.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
    {
      a(paramLong, paramString2, 0, paramBoolean2);
      b(paramString2, 0);
    }
    boolean bool1;
    Object localObject;
    label662:
    label705:
    do
    {
      return;
      lid locallid = this.jdField_a_of_type_Lfb.c(paramString1);
      if (locallid == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      locallid.jdField_e_of_type_Boolean = true;
      locallid.R = paramBoolean1;
      locallid.a("processVideoRequest.1", 2);
      locallid.af = false;
      locallid.jdField_k_of_type_Long = System.currentTimeMillis();
      AVReport.a().o = locallid.R;
      bool1 = false;
      if ((paramBoolean3) || (lge.a()))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("relationType", mww.b(paramInt1));
        ((Intent)localObject).putExtra("session_id", paramString1);
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.jdField_i_of_type_Int);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_Lif.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_Lif.jdField_a_of_type_Long > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label705;
        }
        h();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString)) {
          break label662;
        }
        locallid.jdField_d_of_type_JavaLangString = paramString2;
        a(paramLong, locallid.jdField_d_of_type_JavaLangString, 0, 4);
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
        if (bcys.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
        {
          localIntent.addFlags(262144);
          localObject = localIntent;
          bool1 = bool2;
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      locallid.jdField_a_of_type_Lie.jdField_b_of_type_Boolean = true;
      locallid.a("processVideoRequest.2", 0);
      locallid.jdField_i_of_type_Int = paramInt1;
      locallid.jdField_d_of_type_JavaLangString = paramString2;
      return;
      if (!locallid.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
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
      h();
      return;
      if ((this.jdField_t_of_type_Boolean) && (bool3))
      {
        if ((paramBoolean3) || (lge.a()))
        {
          paramString1 = new mgv(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
          paramString1.d();
          paramString1.a((Intent)localObject);
        }
        for (;;)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest startActivity when GameMode");
          a("mode", "1");
          b(paramString2);
          a(paramString2, "screenState", String.valueOf(1));
          break;
          paramString1 = new mnd(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
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
    this.jdField_a_of_type_Mwk.b(paramLong);
    localObject = this.jdField_a_of_type_Mwk;
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 10, 1L);
      if ((a().jdField_d_of_type_JavaLangString == null) || (!a().jdField_d_of_type_JavaLangString.equals(paramString))) {
        break label278;
      }
      lkx.a(a().b(), 38);
    }
    for (i1 = paramInt;; i1 = paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      i();
      k();
      if (this.jdField_a_of_type_Lnq == null) {
        break;
      }
      aabm.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label278:
      lkx.a(a(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    lid locallid = this.jdField_a_of_type_Lfb.c(paramString1);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + locallid + "]", new Throwable("打印调用栈"));
    int i1;
    String str;
    if ((locallid != null) && ((!locallid.af) || (locallid.jdField_c_of_type_Boolean)))
    {
      i1 = this.jdField_a_of_type_Lfb.c(paramString1).jdField_i_of_type_Int;
      str = locallid.jdField_f_of_type_JavaLangString;
      if ((TextUtils.isEmpty(locallid.jdField_d_of_type_JavaLangString)) || (!locallid.jdField_d_of_type_JavaLangString.contains(paramString2))) {
        break label430;
      }
      paramString2 = locallid.jdField_d_of_type_JavaLangString;
    }
    label430:
    for (;;)
    {
      if (this.jdField_a_of_type_Lnq != null)
      {
        i1 = 9500;
        if (((locallid.z != 1) || (TextUtils.isEmpty(locallid.jdField_p_of_type_JavaLangString))) || (this.x)) {
          i1 = 0;
        }
      }
      boolean bool = false;
      if (locallid.jdField_f_of_type_Int == 2) {
        bool = true;
      }
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())
      {
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        if ((paramInt == 12) && (!TextUtils.isEmpty(a().a()))) {
          a(paramString1, i1, 66, bool, paramString2, str, false);
        }
        if (!this.jdField_e_of_type_Boolean) {
          break label358;
        }
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, paramString2, str, 1, a().jdField_s_of_type_JavaLangString, false, true);
      }
      for (;;)
      {
        locallid.af = true;
        locallid.jdField_c_of_type_Boolean = false;
        return;
        if (!locallid.jdField_c_of_type_Boolean) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        label358:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_Lfb.c(paramString1).jdField_s_of_type_JavaLangString, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_Lfb.c(paramString1).jdField_s_of_type_JavaLangString, false, true);
        }
      }
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, mww.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_Lfb.a(paramLong, paramString2);
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
  
  public void a(long paramLong, ArrayList<lps> paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      lfu locallfu = new lfu();
      locallfu.jdField_a_of_type_Long = ((lps)paramArrayList.get(i1)).jdField_a_of_type_Long;
      locallfu.jdField_d_of_type_Int = ((lps)paramArrayList.get(i1)).jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(locallfu);
      if (((lps)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) {
        localArrayList.add(Long.valueOf(((lps)paramArrayList.get(i1)).jdField_a_of_type_Long));
      }
      i1 += 1;
    }
    if (localArrayList.size() > 0) {
      a(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate, size[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList<lqq> paramArrayList, int paramInt, boolean paramBoolean)
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
            if (((lqq)paramArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
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
          if (paramInt == ((lqq)paramArrayList.get(i1)).jdField_a_of_type_Int)
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
  
  public void a(long paramLong, ArrayList<lqq> paramArrayList1, ArrayList<lqq> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList1.size()) {
        if (((lqq)paramArrayList1.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((lqq)paramArrayList1.get(i1)).jdField_a_of_type_Int)
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
      localObject = (lfu)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((lfu)localObject).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((lfu)localObject).jdField_a_of_type_Long);
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
      str = lfb.a(100, paramString1, new int[0]);
      lid locallid2 = this.jdField_a_of_type_Lfb.c(str);
      lid locallid1 = locallid2;
      if (locallid2 == null) {
        locallid1 = this.jdField_a_of_type_Lfb.a(str, false);
      }
      locallid1.jdField_i_of_type_Int = paramInt1;
      locallid1.z = paramInt2;
      locallid1.jdField_p_of_type_JavaLangString = paramString3;
      locallid1.jdField_e_of_type_Boolean = true;
      paramInt1 = locallid1.jdField_i_of_type_Int;
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
        l1 = mto.a(paramString1);
        a(paramLong, 3, l1);
        lfb.a().a(paramLong, str);
        return;
        str = lfb.a(3, paramString1, new int[0]);
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
        azmj.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      azmj.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (paramBoolean2) {
      if (a().G == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomMicModeChanged, manager uin[" + paramLong + "], old isRoomMicOff[" + a().V + "], new isRoomMicOff[" + paramBoolean1 + "], mIsMicOffBySelf[" + this.jdField_v_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], micAuthByAdmin[" + a().G + "], isCreateRoomOrEnterRoom[" + paramBoolean2 + "], bNeedUpdateMic[" + bool + "]");
      a().b("onGAudioRoomMicModeChanged", paramBoolean1);
      long l1;
      if ((bool) && (!this.jdField_v_of_type_Boolean) && ((paramLong != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
      {
        l1 = this.jdField_a_of_type_Long;
        if (paramBoolean1) {
          break label259;
        }
      }
      label259:
      for (bool = true;; bool = false)
      {
        a("onGAudioRoomMicModeChanged", l1, bool, false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        return;
        bool = false;
        break;
      }
      bool = true;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lnq == null) {
      aabm.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    N();
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramArrayOfByte, null);
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (this.z)
    {
      if (this.jdField_a_of_type_Lft != null) {
        this.jdField_a_of_type_Lft.a();
      }
      this.z = false;
    }
    a(paramArrayOfByte);
    boolean bool = r();
    mtx localmtx;
    if (mtx.a())
    {
      localmtx = new mtx(this.jdField_a_of_type_Mtx, paramLong1);
      localmtx.a(paramArrayOfByte.length, paramInt1, paramInt2, llz.jdField_m_of_type_Int, paramInt3, paramInt4, paramLong2, paramBoolean, bool);
      localmtx.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Mtx = localmtx;
      if (bool)
      {
        paramArrayOfByte = new lrs(paramLong1, paramArrayOfByte, paramInt1, paramInt2, llz.jdField_m_of_type_Int, paramInt3, paramInt4, paramBoolean, paramLong2, System.currentTimeMillis());
        paramArrayOfByte.jdField_a_of_type_Mtx = localmtx;
        if (this.jdField_a_of_type_Lsa == null) {
          break;
        }
        this.jdField_a_of_type_Lsa.a(paramArrayOfByte);
        return;
      }
      if (localmtx != null) {
        localmtx.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramArrayOfByte, llz.jdField_m_of_type_Int, paramInt1, paramInt2, paramInt3, paramInt4, System.currentTimeMillis(), paramBoolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
      lmk.a().a(paramArrayOfByte, 0);
      luy.a().a(0);
      return;
      localmtx = null;
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
      lfu locallfu = new lfu();
      locallfu.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(locallfu);
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
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onRecvSharpOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    L();
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool = paramBundle.getBoolean("isRequest");
    e(paramBundle);
    long l1 = paramBundle.getLong("msf_timestamp");
    a(paramBundle.getString("fromUin"), l1);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "QuaReport --> onRecvSharpOfflineMsg msf_timestamp = " + l1);
    int i1 = a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveSharpVideoCall result: " + i1 + ", buf.length: " + arrayOfByte.length);
    }
    if ((bool) && (this.jdField_a_of_type_Int == -1)) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.getApp().getApplicationContext();
    VideoController.3 local3 = new VideoController.3(this);
    paramVideoAppInterface.a().post(local3);
    if (!bdee.d(a())) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      c();
      if ((this.jdField_o_of_type_Int == 0) && (mbt.e(paramVideoAppInterface.getApp()))) {
        this.jdField_o_of_type_Int = 1;
      }
      this.jdField_a_of_type_Mwk = mwk.a(this.jdField_a_of_type_AndroidContentContext, this);
      if (this.y) {
        J();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(0L, "qqVersion", AppSetting.a(a()));
      return;
      if (bdee.a(a())) {
        this.jdField_b_of_type_Int = 1;
      } else {
        this.jdField_b_of_type_Int = 2;
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
      ((Set)localObject1).add(Long.valueOf(((lfu)((Iterator)localObject2).next()).jdField_a_of_type_Long));
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
        lfu locallfu = new lfu();
        locallfu.jdField_d_of_type_Int = 0;
        locallfu.jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        locallfu.jdField_h_of_type_Boolean = false;
        locallfu.jdField_d_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.jdField_b_of_type_JavaUtilArrayList.add(locallfu);
        paramInt1 = 1;
        i2 = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver add member UIN:" + locallfu.jdField_a_of_type_Long);
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
        localObject2 = (lfu)((Iterator)localObject1).next();
      } while (((lfu)localObject2).jdField_a_of_type_Long != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i1 = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver remove member UIN:" + ((lfu)localObject2).jdField_a_of_type_Long);
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
      a().aa = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    a().aa = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelNetWorkTimer[" + paramString + "]");
    }
    this.A = false;
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
      } while ((!q()) && (this.jdField_a_of_type_Lfb.b()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mwf.a(a()).b();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if ((1 != c()) && (!e()))
    {
      a(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Lfe != null) {
      this.jdField_a_of_type_Lfe.b();
    }
    this.jdField_i_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    if ((q()) && (paramInt != 110)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((lga)localObject).a(paramInt);
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
        d(paramInt);
        mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
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
    if (paramString1.ai)
    {
      paramString1.ai = false;
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
      if (paramString1.ah) {
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
    a().ai = true;
    paramString = lfb.a().a(paramString);
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
    lid locallid = a();
    int i2 = locallid.E;
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
      locallid = a();
    }
    for (;;)
    {
      locallid.jdField_w_of_type_Int = paramInt1;
      locallid.x = paramInt2;
      locallid.jdField_n_of_type_JavaLangString = paramString2;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onChannelReady, fromUin[" + paramString1 + "], hdModeFreeUseStartTime[" + paramInt1 + "], hdModeFreeUseEndTime[" + paramInt2 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], session[" + locallid + "]");
      lkx.a(30);
      lkx.a(9, locallid.b());
      lkx.a(11, locallid.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mwf.a(a()).a();
      if (1L == locallid.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Mwk.b(l1);
        if ((locallid.R) && (locallid.jdField_e_of_type_Boolean) && (!l())) {
          this.jdField_a_of_type_Mwk.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        a(true, locallid.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Mwk.b(l1);
      if (locallid.jdField_i_of_type_Int != 1011) {
        mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
      }
      locallid.b(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
      locallid.c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
      locallid.d(paramLong);
      k();
      locallid.a("onChannelReady", 4);
      locallid.a(l1, SystemClock.elapsedRealtime());
      if ((locallid.jdField_e_of_type_Boolean) && (!l()))
      {
        if (locallid.R) {
          this.jdField_a_of_type_Mwk.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        label491:
        if ((locallid.jdField_d_of_type_Int == 1) && (locallid.jdField_i_of_type_Int == 1011))
        {
          locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int = 5;
          a(locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int, 1, null);
        }
        paramString2 = (lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!locallid.jdField_e_of_type_Boolean) {
          break label866;
        }
        paramInt1 = 11;
        label558:
        paramString2.a(locallid.b(), paramInt1, 1L);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
          break label871;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
        if (l()) {
          a(l1, 2131230736, 1, null);
        }
        c();
        label629:
        if (!locallid.jdField_g_of_type_Boolean) {
          break label878;
        }
        a(true, locallid.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l1), 50L);
        a(locallid.jdField_c_of_type_JavaLangString, locallid.jdField_d_of_type_Int, true, true, true);
        mtq.i(this);
        mtq.c(this, true);
        mtq.b(this, true);
        paramLong = f();
        paramString2 = bdiv.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        paramString2.edit().putLong("qav_roomid", paramLong).commit();
        paramLong = c(paramString1);
        paramString2.edit().putLong(VideoConstants.jdField_g_of_type_JavaLangString, paramLong).commit();
        p(false);
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a();
        }
        if (this.jdField_a_of_type_Lfe != null) {
          this.jdField_a_of_type_Lfe.a();
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
          break;
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 == null) {
          break;
        }
        paramString1.a(locallid);
        return;
        if (this.jdField_a_of_type_Mwk.a()) {
          break label491;
        }
        this.jdField_a_of_type_Mwk.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label491;
        label866:
        paramInt1 = 4;
        break label558;
        label871:
        c();
        break label629;
        label878:
        a(false, locallid.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", friendUin: " + paramString2 + ", selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", isReceiver = " + a().jdField_e_of_type_Boolean + ", isVideoMsg = " + paramBoolean1 + ", extraUin: " + paramString3 + ", forceUnread:" + paramBoolean2);
    if ((TextUtils.isEmpty(paramString2)) || ("0".equals(paramString2))) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast, invalid uin[" + paramString2 + "]");
    }
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.AddVideoMsg");
    lid locallid = this.jdField_a_of_type_Lfb.c(paramString1);
    if (locallid == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      return;
    }
    if (paramInt2 == 21) {
      if ((locallid.jdField_h_of_type_Int == 11) || (locallid.jdField_h_of_type_Int == 12))
      {
        paramInt2 = 47;
        locallid.a(1, 0);
        paramInt1 = 0;
      }
    }
    label905:
    label912:
    for (;;)
    {
      boolean bool = false;
      if ((locallid.i()) && (paramInt2 == 1)) {
        bool = true;
      }
      String str;
      label509:
      float f1;
      for (;;)
      {
        if (paramBoolean2) {
          bool = false;
        }
        localIntent.putExtra("uinType", paramInt1);
        localIntent.putExtra("msgType", paramInt2);
        localIntent.putExtra("isVideoMsg", paramBoolean1);
        localIntent.putExtra("isRead", bool);
        localIntent.putExtra("bindType", locallid.z);
        localIntent.putExtra("bindId", locallid.jdField_p_of_type_JavaLangString);
        localIntent.putExtra("MultiAVType", locallid.C);
        if (paramInt2 == 17) {
          localIntent.putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
          break label745;
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
          if (locallid.jdField_J_of_type_Boolean) {
            str = paramString2;
          }
        }
        localIntent.putExtra("friendUin", paramString2);
        localIntent.putExtra("senderUin", str);
        localIntent.putExtra("selfUin", paramString1);
        if (locallid.jdField_e_of_type_Boolean) {
          break label817;
        }
        paramBoolean1 = true;
        localIntent.putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label879;
        }
        if (this.jdField_b_of_type_Long <= 0L) {
          break label868;
        }
        f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
        if (f1 >= 1024.0F) {
          break label823;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
        label593:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getConnectedTime():" + a() + " extra:" + paramString1);
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
        return;
        paramInt2 = 48;
        break;
        if (paramInt2 != 72) {
          break label912;
        }
        if ((locallid.jdField_h_of_type_Int == 16) || (locallid.jdField_h_of_type_Int == 17)) {}
        for (paramInt2 = 47;; paramInt2 = 48)
        {
          locallid.a(1, 0);
          paramInt1 = 0;
          break;
        }
        if (locallid.k()) {
          bool = true;
        }
      }
      label745:
      if (paramInt1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label905;
        }
      }
      for (;;)
      {
        if (locallid.jdField_e_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          str = paramString3;
          paramString3 = paramString2;
          paramString2 = str;
          break;
        }
        if (locallid.jdField_e_of_type_Boolean) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        label817:
        paramBoolean1 = false;
        break label509;
        label823:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label593;
        label868:
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> return!  no to show net traffic tips msg in AIO");
        return;
        label879:
        if (locallid.jdField_e_of_type_Long > 0L)
        {
          paramString1 = mww.a(a());
          break label593;
        }
        paramString1 = null;
        break label593;
        paramString3 = paramString2;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.b();
    lid locallid = this.jdField_a_of_type_Lfb.b(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l1 + "], Main[" + this.jdField_a_of_type_Lfb.a() + "], come[" + locallid + "]");
    if (locallid == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], no session");
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lga)localObject).a(paramInt);
      }
      if (q()) {
        D();
      }
      if (((locallid.jdField_i_of_type_Int != 1011) && (locallid.jdField_i_of_type_Int != 21)) || (!locallid.jdField_a_of_type_Lie.jdField_b_of_type_Boolean)) {
        break;
      }
      lek.d(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + locallid.jdField_a_of_type_Lie.jdField_b_of_type_Boolean);
      locallid.jdField_a_of_type_Lie.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0, this);
    } while ((q()) && ((paramInt == 2) || (paramInt == 3)));
    d(paramInt);
    return;
    y(locallid.jdField_c_of_type_JavaLangString);
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
        if (locallid.jdField_d_of_type_Int != 2) {
          break label798;
        }
        azmj.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramInt == 49) {
          p(true);
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
          a(locallid.jdField_i_of_type_Int, locallid.jdField_d_of_type_JavaLangString, locallid.jdField_i_of_type_Long, 0);
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
          if (locallid.jdField_d_of_type_Int == 2)
          {
            azmj.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          azmj.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
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
          azmj.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
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
        azmj.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = lfb.a(3, paramString, new int[0]);
        locallid = null;
        if (this.jdField_a_of_type_Lfb.a((String)localObject)) {
          locallid = this.jdField_a_of_type_Lfb.c((String)localObject);
        }
        if ((locallid != null) && (locallid.jdField_g_of_type_Int == 1))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, set autoAcceptChat, seq[" + l1 + "]");
          locallid.jdField_d_of_type_Boolean = true;
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
        locallid.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 12);
        return;
      }
      if (paramLong == 61L)
      {
        locallid.jdField_s_of_type_Boolean = false;
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
      if ((a() == null) || (!a().k())) {
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
        if ((i1 <= 0) || (!this.jdField_l_of_type_Boolean)) {
          break label405;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :has get phone state");
      return;
      if (i1 == 0) {
        this.jdField_l_of_type_Boolean = true;
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
          else if (!a().ah) {
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
            a().jdField_n_of_type_Int = 2;
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
              a().jdField_n_of_type_Int = 3;
              azmj.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
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
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        }
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      q(true);
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
      if (AudioHelper.e()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStartVideoBroadcast, sessionId[" + paramString + "], sessionType[" + paramInt + "], updateTime[" + paramBoolean1 + "], showTime[" + paramBoolean2 + "], isDouble[" + paramBoolean3 + "]");
      }
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("sessionId", paramString);
      if (this.jdField_a_of_type_Lfb != null)
      {
        paramString = this.jdField_a_of_type_Lfb.c(paramString);
        if (paramString != null)
        {
          localIntent.putExtra("uinType", paramString.jdField_i_of_type_Int);
          if (paramString.jdField_i_of_type_Int != 26) {
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
        localIntent.putExtra("relationType", paramString.E);
        localIntent.putExtra("relationId", paramString.jdField_g_of_type_Long);
      }
      localIntent.putExtra("extraUin", paramString.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("bindType", paramString.z);
      localIntent.putExtra("bindId", paramString.jdField_p_of_type_JavaLangString);
      localIntent.putExtra("isReceiver", paramString.jdField_e_of_type_Boolean);
      localIntent.putExtra("isDoubleVideoMeeting", paramString.jdField_J_of_type_Boolean);
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
    paramString = lio.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    Object localObject = lfb.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_Lfb.c((String)localObject);
    if (localObject != null) {
      ((lid)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
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
      lgd.a();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    lgd.a(paramLong3);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "], seq[" + l1 + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", mto.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    mwd.a(localNewIntent, l1);
    a(localNewIntent);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramLong, paramBoolean, false);
  }
  
  public void a(String arg1, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      a(??? + "_" + paramLong, paramBoolean1, paramBoolean2);
      if (paramBoolean1) {
        break label120;
      }
      paramBoolean2 = true;
    }
    for (;;)
    {
      b("gAudioSetInput", paramBoolean2);
      paramLong = mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > 1)
        {
          i1 = 1;
          if ((!paramBoolean1) && (i1 != 0)) {
            a(this.jdField_a_of_type_Long, new long[] { paramLong }, paramBoolean1, 0);
          }
          return;
          label120:
          paramBoolean2 = false;
          continue;
        }
        int i1 = 0;
      }
    }
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + mto.a(paramLong) + ", uinType = " + a().jdField_i_of_type_Int);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    if (a().jdField_i_of_type_Int == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", mto.a(paramString));
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
            a().jdField_a_of_type_Lie.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          a().jdField_a_of_type_Lie.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (a().jdField_a_of_type_Lie.jdField_a_of_type_Int != 3) {
          break;
        }
        lfu locallfu = a(paramString);
        if (locallfu != null)
        {
          locallfu.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lie.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lie.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    lek.d(jdField_a_of_type_JavaLangString, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    lid locallid = null;
    if (this.jdField_a_of_type_Lfb != null) {
      locallid = this.jdField_a_of_type_Lfb.c(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (String str = "mApp is null";; str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + locallid + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (locallid != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", locallid.z);
    paramString1.putExtra("bindId", locallid.jdField_p_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", locallid.jdField_d_of_type_Int);
    paramString1.putExtra("isDoubleVideoMeeting", locallid.jdField_J_of_type_Boolean);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(VideoConstants.jdField_d_of_type_JavaLangString, locallid.jdField_e_of_type_Long);
    paramString1.putExtra(VideoConstants.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
    paramString1.putExtra(VideoConstants.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", a());
    long l1 = 0L;
    if ((locallid.jdField_d_of_type_Int == 1) || (locallid.jdField_d_of_type_Int == 2)) {
      l1 = 1L;
    }
    if ((locallid.jdField_d_of_type_Int == 3) || (locallid.jdField_d_of_type_Int == 4)) {
      l1 = 2L;
    }
    paramString1.putExtra(VideoConstants.i, l1);
    if ((locallid.jdField_d_of_type_Int == 1) || (locallid.jdField_d_of_type_Int == 3)) {}
    for (l1 = 1L;; l1 = 0L)
    {
      paramString1.putExtra(VideoConstants.j, l1);
      if (this.jdField_a_of_type_Lfb.c(paramString2).jdField_l_of_type_JavaLangString != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_Lfb.c(paramString2).jdField_l_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Lfb.c(paramString2).jdField_m_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_Lfb.c(paramString2).jdField_m_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_Lfb.c(paramString2).E);
        paramString1.putExtra("relationId", this.jdField_a_of_type_Lfb.c(paramString2).jdField_g_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label661;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        loc.a().a.a();
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
          a().jdField_a_of_type_Lie.jdField_g_of_type_JavaLangString = paramString2;
        }
        lfu locallfu;
        for (;;)
        {
          if (a().jdField_a_of_type_Lie.jdField_a_of_type_Int != 3) {
            break label195;
          }
          locallfu = a(paramString1);
          if (locallfu == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          locallfu.jdField_b_of_type_JavaLangString = paramString2;
          return;
          a().jdField_a_of_type_Lie.jdField_f_of_type_JavaLangString = paramString2;
        }
        locallfu.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lie.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", lfx.a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().S = paramBoolean;
    if (paramBoolean) {
      mtq.o(this);
    }
    if (muz.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      return;
    }
    a(false, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((this.jdField_e_of_type_Boolean != paramBoolean) || (this.jdField_c_of_type_Int != paramInt) || (this.jdField_a_of_type_Long != paramLong) || (QLog.isColorLevel())) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, String.format("updateCurJoinGRoomInfo, from[%s], [%s, %s, %s] --> [%s, %s, %s]", new Object[] { paramString, Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt;
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
  
  public void a(ArrayList<Long> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> tinyIDList is null Or size is 0");
      }
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  public void a(lft paramlft)
  {
    this.jdField_a_of_type_Lft = paramlft;
  }
  
  void a(lfu paramlfu, int paramInt)
  {
    paramlfu.jdField_b_of_type_Int = 0;
    paramlfu.jdField_b_of_type_Boolean = false;
    paramlfu.jdField_c_of_type_Boolean = false;
    paramlfu.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramlfu.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramlfu.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramlfu.jdField_b_of_type_Int = 1;
      return;
    }
    paramlfu.jdField_d_of_type_Boolean = true;
  }
  
  public void a(lps paramlps, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut--> UserInfo = " + paramlps.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramlps.jdField_a_of_type_Int == 1)
      {
        if (a().a(paramlps.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList) == null) {
          break label183;
        }
        localAVPhoneUserInfo = a().a(paramlps.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + localAVPhoneUserInfo);
        }
      }
      a(paramInt2, paramLong1, paramlps, true, paramLong2, paramVarArgs);
    }
    label183:
    do
    {
      return;
      localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramlps.jdField_a_of_type_Long;
      localAVPhoneUserInfo.accountType = 2;
      a().a(localAVPhoneUserInfo);
      d(paramlps.jdField_a_of_type_Long);
      break;
      if (paramInt1 == 71)
      {
        if (paramlps.jdField_a_of_type_Int == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramlps.jdField_a_of_type_Long;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramlps, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  void a(lps paramlps, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    if (paramBoolean) {}
    Object localObject1;
    try
    {
      if (a(paramlps.jdField_a_of_type_Long) != -1) {
        return;
      }
      localObject1 = new lfu();
      ((lfu)localObject1).jdField_a_of_type_Long = paramlps.jdField_a_of_type_Long;
      ((lfu)localObject1).jdField_d_of_type_Int = paramlps.jdField_a_of_type_Int;
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut, size[" + this.jdField_c_of_type_JavaUtilArrayList.size() + "], coming[" + paramlps + "]");
      return;
    }
    finally {}
    int i1 = a(paramlps.jdField_a_of_type_Long);
    Object localObject2 = null;
    if (i1 != -1) {
      localObject1 = (lfu)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
    }
    for (;;)
    {
      a(paramlps.jdField_a_of_type_Long, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      u();
      if ((localObject1 == null) || (((lfu)localObject1).jdField_e_of_type_Boolean) || (!((lfu)localObject1).jdField_g_of_type_Boolean)) {
        break;
      }
      a(0L, false, 0L);
      break;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramlps);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(NewIntent paramNewIntent)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendMsg, Exception", paramNewIntent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
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
        mvj localmvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localmvj != null) {
          localmvj.a(paramVarArgs.jdField_c_of_type_JavaLangString);
        }
        QLog.w(jdField_a_of_type_JavaLangString, 1, "closeMainSession, mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], isDoubleVideoMeeting[" + paramVarArgs.jdField_J_of_type_Boolean + "], \nsession[" + paramVarArgs + "], \nseq[" + l1 + "]");
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
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(paramVarArgs.jdField_g_of_type_Long), Boolean.valueOf(true) });
      }
      if (paramVarArgs.jdField_J_of_type_Boolean)
      {
        a(l1, this.jdField_a_of_type_Long, true, 0);
        return;
      }
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 30);
      return;
    } while ((paramVarArgs.jdField_d_of_type_Int != 1) && (paramVarArgs.jdField_d_of_type_Int != 2));
    if ((paramVarArgs.jdField_g_of_type_Int == 2) || (paramVarArgs.jdField_g_of_type_Int == 13))
    {
      if (paramVarArgs.jdField_J_of_type_Boolean)
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
    if (paramVarArgs.jdField_J_of_type_Boolean)
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
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(((lid)localObject).jdField_b_of_type_Boolean).append("->").append(paramBoolean2).append("], deviceName[").append(((lid)localObject).q).append("], audioStateBeforePhoneCall[").append(((lid)localObject).t).append("], mTraeHelper[");
    if (this.jdField_a_of_type_Mwk != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Mwk != null) {
        break;
      }
      return;
    }
    if ((((lid)localObject).jdField_i_of_type_Int == 0) && (((lid)localObject).jdField_g_of_type_Int != 0) && (((lid)localObject).jdField_g_of_type_Int != 5) && (((lid)localObject).jdField_g_of_type_Int != 6) && (((lid)localObject).jdField_b_of_type_Boolean != paramBoolean2))
    {
      ((lid)localObject).jdField_b_of_type_Boolean = paramBoolean2;
      if (!paramBoolean2) {
        break label233;
      }
      this.jdField_a_of_type_Mwk.b();
      ((lid)localObject).t = ((lid)localObject).q;
    }
    while (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label233:
      if ("DEVICE_SPEAKERPHONE".equals(((lid)localObject).t))
      {
        this.jdField_a_of_type_Mwk.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else if ("DEVICE_EARPHONE".equals(((lid)localObject).t))
      {
        this.jdField_a_of_type_Mwk.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (((lid)localObject).jdField_d_of_type_Int == 1) {}
        for (localObject = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; localObject = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
        {
          this.jdField_a_of_type_Mwk.a((String)localObject);
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  void a(byte[] paramArrayOfByte)
  {
    int i1;
    if ((this.jdField_e_of_type_Int <= 30) && (!this.jdField_g_of_type_Boolean)) {
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 > 10) || (paramArrayOfByte[((int)(Math.random() * paramArrayOfByte.length))] != 0))
      {
        if (i1 < 10) {
          this.jdField_g_of_type_Boolean = true;
        }
        this.jdField_e_of_type_Int += 1;
        if ((this.jdField_e_of_type_Int == 30) && (!this.jdField_g_of_type_Boolean))
        {
          long l1 = AudioHelper.b();
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "checkCamerahasImage, not image, seq[" + l1 + "]");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(1), Long.valueOf(l1) });
        }
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecordAudio=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
    if (paramInt1 == 100) {
      if ((this.jdField_a_of_type_ArrayOfMqo != null) && (this.jdField_a_of_type_ArrayOfMqo[0] != null)) {
        this.jdField_a_of_type_ArrayOfMqo[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    while (((paramInt1 != 3) && (paramInt1 != 0)) || (this.jdField_a_of_type_ArrayOfMqo == null) || (this.jdField_a_of_type_ArrayOfMqo[1] == null)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMqo[1].a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    lfx.a(paramArrayOfByte);
    if (this.jdField_a_of_type_Lnq == null)
    {
      azmj.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_Lnq.b(paramArrayOfByte, paramLong);
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
      long l1 = mto.a(str);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "inviteNewMemJoin, uinList[" + paramArrayOfLong + "], needNotifyUI[" + paramBoolean + "], mMultiInviteEntranceFlag[" + this.jdField_g_of_type_Int + "]");
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    do
    {
      return;
      if (this.jdField_g_of_type_Int == 1)
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
    return (this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_Int == paramInt) && (this.jdField_a_of_type_Long == paramLong);
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    int i2 = -999;
    int i1 = i2;
    if (paramLong > 0L)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_n_of_type_Boolean = true;
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
  
  public boolean a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo isRequestVideo uinType = " + paramInt1 + ", fromUin = " + paramString1 + ", extraUin = " + paramString2 + ", sig = " + paramArrayOfByte + ", onlyAudio = " + paramBoolean + ", bindID=" + paramString3 + " ,bindType=" + paramInt2);
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "isRequestVideo  faile,app is null, return false");
      return false;
    }
    paramBoolean = d(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
      }
      if (this.jdField_a_of_type_Lfb.a() < 2) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo->pending session exists");
      }
      paramInt1 = -1;
      paramString2 = null;
      if (a() != null)
      {
        paramInt1 = a().jdField_i_of_type_Int;
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
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((a().jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (a().jdField_a_of_type_Lie.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lie.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random mulit");
      }
      if (bool) {
        return false;
      }
    }
    else if (a().e())
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
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (a().jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo  auto Accept");
        }
        if ((a().jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString.equals(paramString1))) {
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
          lek.d(jdField_a_of_type_JavaLangString, "isRequestVideo when request: fromUin = " + paramString1);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo orientation: " + this.jdField_t_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
    }
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
        lfu locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((locallfu == null) || (locallfu.jdField_a_of_type_Long != paramLong)) {
          break label186;
        }
        locallfu.jdField_e_of_type_Boolean = paramBoolean;
        locallfu.jdField_d_of_type_Int = paramInt1;
        bool = locallfu.jdField_g_of_type_Boolean;
        if (paramBoolean)
        {
          locallfu.jdField_g_of_type_Boolean = false;
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
  
  boolean a(long paramLong, int paramInt, ArrayList<lqq> paramArrayList)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramArrayList.size())
      {
        if ((((lqq)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((lqq)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
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
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.QuaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
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
    QLog.d(jdField_a_of_type_JavaLangString, 1, "QuaReport --> report result = " + bool + " | node = " + paramInt + " | timestamp = " + paramLong);
    return bool;
  }
  
  public boolean a(String paramString, lid paramlid)
  {
    boolean bool2;
    if (paramlid == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i1 = paramlid.d();
    long l1 = paramlid.b();
    long l2 = paramlid.e();
    long l3;
    if (i1 == 2)
    {
      l3 = a(paramlid);
      if (l3 != paramlid.b()) {
        paramlid.d(l3);
      }
    }
    for (;;)
    {
      l3 = paramlid.b();
      long l4 = paramlid.e();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramlid, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i1 == 1)
      {
        l3 = b(paramlid);
        if (l3 != paramlid.b()) {
          paramlid.d(l3);
        }
      }
    }
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    lid locallid = a();
    String str;
    boolean bool;
    if (paramBoolean) {
      if (paramInt == 3)
      {
        str = lfb.a(100, paramString2, new int[0]);
        if (TextUtils.equals(locallid.jdField_c_of_type_JavaLangString, str)) {
          break label231;
        }
        bool = lfb.a().b(str);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkMainSession, need reset main session, from[" + paramString1 + "], cur" + locallid.jdField_c_of_type_JavaLangString + "], coming[" + str + "], ret[" + bool + "]");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMainSession, from[" + paramString1 + "], isFromMAVEngine[" + paramBoolean + "], relationType[" + paramInt + "], relationId[" + paramString2 + "], ret[" + bool + "]");
      }
      return bool;
      str = lfb.a(paramInt, paramString2, new int[0]);
      break;
      str = lfb.a(paramInt, paramString2, new int[0]);
      break;
      label231:
      bool = false;
    }
  }
  
  public boolean a(lid paramlid1, lid paramlid2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlid1.jdField_d_of_type_JavaLangString);
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
          paramlid2.a(paramLong1, paramlid1.jdField_j_of_type_Boolean);
          a(paramString, paramlid2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_e_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          }
          if (!paramlid1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          int i1 = paramlid1.jdField_d_of_type_Int;
          paramlid2.aD = true;
          paramlid2.jdField_d_of_type_JavaLangString = paramlid1.jdField_d_of_type_JavaLangString;
          if ((paramlid1.jdField_g_of_type_Int == 15) || (paramlid1.K)) {
            g(false);
          }
          paramlid1.a(3, 12);
          if (i1 == 1)
          {
            paramlid1.a(paramLong1, "onGAudioInvite.6", 3);
            paramlid1.jdField_i_of_type_Int = mww.c(paramInt);
            paramlid1.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlid1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlid1.b("onGAudioInvite.1", 1);
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.a() <= 0) {
                break label522;
              }
              paramlid1.c("onGAudioInvite3", mti.a(paramlid1.jdField_i_of_type_Int));
              localVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramlid2 = mvj.a(localVideoAppInterface);
            int i2 = 0;
            if (paramlid2 != null)
            {
              boolean bool2 = paramlid2.a();
              i2 = bool2;
              if (bool2)
              {
                paramlid2.a(paramlid1.jdField_c_of_type_JavaLangString);
                i2 = bool2;
              }
            }
            if (i2 != 0) {
              c();
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
            paramlid1.a(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i1 != 4) {
            break label510;
          }
        }
        catch (Exception paramlid1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramlid1.getMessage());
          }
          this.jdField_a_of_type_Lfb.a(paramLong1, paramString);
          return bool1;
        }
        paramlid1.a(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label510:
        paramlid1.a(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label522:
        if (localThrowable.isBackground_Stop)
        {
          paramlid1.c("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          n(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramlid1.L))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramlid1.L + "], ret[" + bool1 + "], main[" + paramlid1 + "], new[" + paramlid2 + "]");
      }
      paramlid1.L = false;
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
      if (((lqq)a().jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
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
          lfu locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(i3);
          if ((locallfu != null) && (locallfu.jdField_a_of_type_Long != mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
          {
            int i2 = i1;
            if (locallfu.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (locallfu.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            if (locallfu.jdField_c_of_type_Boolean) {
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
    lek.d(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
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
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterDAudioDataCallback(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    int i1 = -1;
    lid locallid = lfb.a().a(paramString);
    if ((locallid != null) && (locallid.c() != -1)) {
      i1 = locallid.c();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
  }
  
  public int b(lid paramlid, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramlid, paramString);
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
    if (!this.jdField_m_of_type_Boolean) {}
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
      long l1 = mto.a(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      lek.e(jdField_a_of_type_JavaLangString, paramString.getMessage());
    }
    return -1L;
  }
  
  public long b(lid paramlid)
  {
    if (paramlid == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramlid.jdField_d_of_type_Int == 3) || (paramlid.jdField_d_of_type_Int == 4)))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramlid.E, paramlid.C, paramlid.jdField_g_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramlid.d(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramlid.d(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramlid.b();
  }
  
  public ArrayList<lfu> b()
  {
    if ((AudioHelper.d()) && (mrz.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(mrz.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void b(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportCloseReasonBeacon,reason  = " + paramInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("closeReason", String.valueOf(paramInt));
    azmz.a(BaseApplicationImpl.getApplication()).a(null, "actAvideoCloseReasonB", true, 0L, 0L, localHashMap, "", true);
  }
  
  public void b(int paramInt, long paramLong)
  {
    String str = lfb.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = lfb.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_a_of_type_Lfb.a(str)) {}
    for (Object localObject = this.jdField_a_of_type_Lfb.c(str);; localObject = null)
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
          if (this.jdField_a_of_type_Mwk != null) {
            this.jdField_a_of_type_Mwk.b(l1);
          }
          mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          mwk.a().b();
          if ((AudioHelper.e()) || (((lid)localObject).aq)) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, \nmainsession[" + a() + "], \nstate[" + ((lid)localObject).jdField_g_of_type_Int + "], seq[" + l1 + "], isAcceptingMultiAV[" + ((lid)localObject).aq + "], isCurJoinedGRoom[" + a(paramInt, paramLong) + "]");
          }
        } while (((lid)localObject).aq);
        if (this.jdField_d_of_type_Long == paramLong)
        {
          this.jdField_d_of_type_Long = 0L;
          this.jdField_n_of_type_Int = 0;
        }
        if ((paramInt != 3) || (!((lid)localObject).jdField_J_of_type_Boolean) || ((((lid)localObject).jdField_d_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((lid)localObject).jdField_d_of_type_JavaLangString).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((lid)localObject).jdField_d_of_type_JavaLangString + " ,relationId = " + paramLong);
      return;
      if ((!((lid)localObject).ag) && (!((lid)localObject).jdField_J_of_type_Boolean))
      {
        int i1 = 6;
        if (((lid)localObject).jdField_g_of_type_Int == 7) {
          i1 = 5;
        }
        a("onGAudioRoomDestroy", str, mww.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((lid)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
      if (a(paramInt, paramLong)) {
        a(paramInt, paramLong, 69);
      }
      ((lid)localObject).a("onGAudioRoomDestroy", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_a_of_type_Lfb.a(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_Lfb.c(str);
          paramInt = mww.c(paramInt);
          a(((lid)localObject).jdField_c_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_a_of_type_Lfb.a(l1, str))
        {
          localObject = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject != null) && (((mvj)localObject).a()))
          {
            ((mvj)localObject).a(str);
            c();
          }
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      r();
      return;
    }
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    lid locallid = a();
    if (locallid.an) {}
    while (locallid.b(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < locallid.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((lqq)locallid.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((lqq)locallid.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((lqq)locallid.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupVideoClosed, relationId[" + paramLong + "], reason[" + paramInt2 + "], avtype[" + paramInt3 + "], bKickout[" + this.jdField_w_of_type_Boolean + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    if (this.jdField_w_of_type_Boolean) {
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
    if ((a().jdField_i_of_type_Int == 1011) || (a().jdField_i_of_type_Int == 21) || (q())) {}
    while (a().jdField_d_of_type_Long != 0L) {
      return;
    }
    long l1 = a().jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startReachedRing, peer colorRingId=" + l1);
    }
    String str = bdnv.a(l1, 3);
    if (new File(str).exists())
    {
      mwk.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_f_of_type_Boolean = true;
      int i1 = a().jdField_o_of_type_Int;
      azmj.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    mwk.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
    a().jdField_f_of_type_Boolean = true;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioKickOut, Groupid[" + paramLong + "], relationType[" + paramInt1 + "], seq[" + l1 + "]");
    paramInt2 = mww.c(paramInt1);
    if ((this.jdField_e_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.jdField_w_of_type_Boolean = true;
      if (paramInt1 != 3) {
        break label274;
      }
      a(a().jdField_c_of_type_JavaLangString, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      paramInt1 = 7;
      if (paramInt2 != 3000) {
        break label302;
      }
      azmj.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().jdField_J_of_type_Boolean) {
        azmj.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      lid locallid = a();
      if ((locallid != null) && (locallid.jdField_j_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, paramInt1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
      return;
      label274:
      a(a().jdField_c_of_type_JavaLangString, paramInt2, 20, false, String.valueOf(paramLong), null, false);
      paramInt1 = 20;
      break;
      label302:
      if (paramInt2 == 1) {
        if (a().C == 10) {
          azmj.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          azmj.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
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
      a().am = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRecvAudioReady uin = " + paramLong1 + ",roomid = " + paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    lid locallid = a();
    if ((locallid.jdField_d_of_type_Int != 2) || ((locallid.jdField_v_of_type_Int != 2) && (locallid.jdField_v_of_type_Int != 3))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInviteRespFail, groupId[" + paramLong1 + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], err[" + paramLong2 + "], msg[" + paramString + "]");
    if (paramLong1 == this.jdField_a_of_type_Long) {
      QQToast.a(a(), 2131696140, 1).a();
    }
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<lqk> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.28(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = lfb.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_Lfb.a(str)) {}
      for (lid locallid = this.jdField_a_of_type_Lfb.c(str); locallid == null; locallid = this.jdField_a_of_type_Lfb.c(str))
      {
        QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        lkx.a(0L, 33);
        lkx.b(0L);
        return;
        str = lfb.a(100, paramString, new int[0]);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lmr)localObject).a(locallid);
      }
      lkx.a(locallid.b(), 16, 0L);
      lkx.a(locallid.b(), 33);
      lkx.b(locallid.b());
      localObject = (lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (locallid.jdField_e_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((lkz)localObject).a(locallid.b(), i2, i1 + 500);
        ((lkz)localObject).a("NoCrash");
        ((lkz)localObject).a(locallid.b(), 29, 1L);
        ((lkz)localObject).a(36, 1L);
        ((lkz)localObject).b(locallid.b());
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + locallid.e() + "], sessionInfo.peerUin[" + locallid.jdField_d_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + locallid.R + "], sessionInfo.SessionType[" + locallid.jdField_d_of_type_Int + "], mNetTrafficAllSize[" + this.jdField_b_of_type_Long + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!locallid.e()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((locallid.jdField_d_of_type_Int == 2) && (!locallid.jdField_J_of_type_Boolean) && (locallid.jdField_g_of_type_Int >= 4) && (locallid.jdField_e_of_type_Long > 0L))
      {
        i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
        lek.d(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + locallid.jdField_e_of_type_Long + " | " + locallid.jdField_g_of_type_Int + " | " + locallid.jdField_u_of_type_Boolean);
        if ((locallid.jdField_u_of_type_Boolean) || (i2 > 0)) {
          azmj.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_t_of_type_Boolean) && (a() > 0L))
      {
        if (locallid.jdField_d_of_type_Int == 1) {
          azmj.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", mww.a(a()), "");
        }
      }
      else
      {
        label763:
        locallid.jdField_d_of_type_Long = 0L;
        locallid.jdField_o_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(locallid.jdField_d_of_type_JavaLangString))
        {
          localObject = paramString;
          if (locallid.jdField_d_of_type_JavaLangString.contains(paramString)) {
            localObject = locallid.jdField_d_of_type_JavaLangString;
          }
        }
        if ((locallid.n()) || (locallid.o())) {
          locallid.y = i1;
        }
        if ((locallid.g()) || ((locallid.i()) && (i1 == locallid.y))) {
          locallid.a(paramLong, 0L);
        }
        if ((locallid.ah) && (this.jdField_f_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1585;
        }
        paramBoolean = false;
        if (locallid.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(locallid.jdField_c_of_type_JavaLangString, locallid.jdField_i_of_type_Int, paramBoolean, locallid.jdField_d_of_type_JavaLangString, locallid.jdField_f_of_type_JavaLangString);
        label949:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_Lfb.a())
        {
          i();
          k();
          t();
        }
        locallid.jdField_a_of_type_Lie.jdField_b_of_type_Boolean = false;
        locallid.jdField_a_of_type_Lie.jdField_a_of_type_JavaLangString = null;
        locallid.jdField_a_of_type_Lie.jdField_b_of_type_JavaLangString = null;
        locallid.jdField_a_of_type_Lie.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          mtq.b(this, false);
          mtq.c(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            mtq.l(this);
          }
        }
        locallid.a("doCloseSession", 0);
        locallid.a(paramLong, "doCloseSession", 0);
        locallid.jdField_f_of_type_Int = 0;
        locallid.jdField_a_of_type_JavaUtilBitSet.clear();
        locallid.jdField_j_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        locallid.au = false;
        locallid.jdField_a_of_type_ArrayOfJavaLangString = null;
        locallid.b("doCloseSession", null);
        locallid.jdField_p_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + locallid.jdField_i_of_type_Int + " # matchStatus = " + locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (i1 != 72) && (locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          locallid.jdField_i_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1599;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1261:
        if ((locallid.jdField_i_of_type_Int != 1011) || ((locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int != 2) && (locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int != 6))) {
          break label1626;
        }
        if ((!this.jdField_f_of_type_Boolean) && (locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int != 6)) {
          break label1609;
        }
        a(6, 1, null);
        label1325:
        this.jdField_a_of_type_Boolean = false;
        label1330:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((locallid.jdField_a_of_type_Lie.jdField_a_of_type_Int == 1) || (locallid.jdField_a_of_type_Lie.jdField_a_of_type_Int == 2)))
        {
          locallid.a();
          a(0, 0, null);
        }
        locallid.a(paramLong, false);
        locallid.b(paramLong, false);
        locallid.a(paramLong, 0L);
        locallid.b(paramLong);
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1644;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_Lfb.a(paramLong, str);
      }
      for (;;)
      {
        paramString = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str);
        if (!paramBoolean) {
          break;
        }
        c();
        return;
        if (locallid.jdField_d_of_type_Int != 2) {
          break label763;
        }
        azmj.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", mww.a(a()), "");
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
        a(locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int, 1, null);
        break label1325;
        label1626:
        if (!this.jdField_f_of_type_Boolean) {
          break label1330;
        }
        a(6, 1, null);
        break label1330;
        label1644:
        this.jdField_a_of_type_Lfb.a(str, 3);
      }
    }
  }
  
  public void b(long paramLong, ArrayList<lps> paramArrayList) {}
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onRecvMultiVideoOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    L();
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      paramBundle = paramBundle.getByteArray("buffer");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
        l();
      }
    } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_l_of_type_Int, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((a().jdField_d_of_type_Int > 0) && (a().jdField_d_of_type_Int <= 2) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
      if (a().k()) {}
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
    mwk.a().b(l1);
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (c(paramString)) {
      mwk.a().b();
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
  
  public void b(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(41), paramString, Long.valueOf(paramLong), paramArrayOfByte });
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioMute, [" + this.jdField_m_of_type_Boolean + " --> " + paramBoolean + "], from[" + paramString + "]");
    }
    this.jdField_m_of_type_Boolean = paramBoolean;
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
  
  public void b(ArrayList<AVPhoneUserInfo> paramArrayList)
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
        localObject = (lfu)localIterator.next();
        if ((((lfu)localObject).jdField_d_of_type_Int == 1) && (((lfu)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((lfu)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
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
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_Boolean == paramBoolean) {}
    for (;;)
    {
      return;
      this.jdField_j_of_type_Boolean = paramBoolean;
      if (!a().S)
      {
        if (paramBoolean) {
          if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
          {
            if ((!a().R) && (a().jdField_j_of_type_Boolean)) {
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
          b(true);
          continue;
          if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
          {
            if ((!a().R) && (a().jdField_j_of_type_Boolean)) {
              c(a().jdField_d_of_type_JavaLangString);
            }
            if (!a().jdField_g_of_type_Boolean) {
              a(false, a().jdField_d_of_type_JavaLangString);
            }
            b(true, a().jdField_d_of_type_JavaLangString);
            A();
          }
          else
          {
            b(false);
            if (a().jdField_O_of_type_Boolean)
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
  
  public void b(byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), a().jdField_d_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    String str = null;
    if (paramLong == 0L) {
      a().P = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(27), str });
      return;
      if (paramLong == 1L)
      {
        a().P = true;
      }
      else if (paramLong == 100L)
      {
        a().Q = false;
      }
      else if (paramLong == 101L)
      {
        a().Q = true;
        if (paramArrayOfByte != null) {
          str = new String(paramArrayOfByte);
        }
      }
      else
      {
        a().P = false;
        a().Q = false;
      }
    }
  }
  
  public boolean b()
  {
    boolean bool1 = a(a());
    boolean bool2 = s();
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGameMode isQQPaused: " + bool3 + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isLandscape: " + bool2 + ", isScreenLocked: " + bool1);
    }
    return (!bool1) && (bool2) && (bool3) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
  }
  
  public boolean b(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public boolean b(lid paramlid1, lid paramlid2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlid1.jdField_d_of_type_JavaLangString);
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
          paramlid2.a(paramLong1, paramlid1.jdField_j_of_type_Boolean);
          a(paramString, paramlid2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramlid1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          i1 = paramlid1.jdField_d_of_type_Int;
          paramlid2.jdField_d_of_type_JavaLangString = paramlid1.jdField_d_of_type_JavaLangString;
          paramlid2.a(paramLong1, paramlid1.jdField_j_of_type_Boolean);
          paramlid2.jdField_g_of_type_Boolean = paramlid1.jdField_g_of_type_Boolean;
          paramlid2.a("onGAudioInvite", paramlid1.jdField_O_of_type_Boolean);
          paramlid2.b("onGAudioInvite", paramlid1.q);
          paramlid2.aD = true;
          paramlid2.a(3, 12);
          paramlid1.a(3, 12);
          b(paramlid1.jdField_d_of_type_JavaLangString, 21);
          if (i1 == 1)
          {
            paramlid2.a(paramLong1, "onGAudioInvite.2", 3);
            paramlid2.jdField_i_of_type_Int = mww.c(paramInt);
            paramlid2.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlid2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlid2.b("onGAudioInvite.2", 1);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
              break label547;
            }
            paramlid2.c("onGAudioInvite1", mti.a(paramlid2.jdField_i_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramlid1 = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            int i2 = 0;
            if (paramlid1 != null)
            {
              boolean bool2 = paramlid1.a();
              i2 = bool2;
              if (bool2)
              {
                paramlid1.a(paramString);
                i2 = bool2;
              }
            }
            if (i2 == 0) {
              break;
            }
            c();
            return bool1;
          }
        }
        catch (Exception paramlid1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramlid1);
          }
          this.jdField_a_of_type_Lfb.a(paramLong1, paramString);
          return bool1;
        }
        if (i1 == 2)
        {
          paramlid2.a(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i1 == 4)
        {
          paramlid2.a(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramlid2.a(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label547:
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop)
          {
            paramlid2.c("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            n(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramlid1 != paramlid2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramlid1 + "], new[" + paramlid2 + "]");
      }
      if (!bool1) {
        break label586;
      }
      if (paramlid1.y != 0) {
        break label164;
      }
      paramlid1.a("onGAudioInvite.2", 0);
      this.jdField_a_of_type_Lfb.a(paramLong1, paramString);
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
    int i2 = 1;
    int i1;
    if (AppNetConnInfo.isWifiConn()) {
      i1 = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getApn: " + i1 + " mobileType:" + i2);
      }
      return i1;
      if (AppNetConnInfo.isMobileConn())
      {
        i2 = AppNetConnInfo.getMobileInfo();
        switch (i2)
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
          break;
        case 4: 
          i1 = 14;
          break;
        }
      }
      else
      {
        i2 = -1;
        i1 = 0;
      }
    }
  }
  
  public int c(String paramString)
  {
    int i1 = -1;
    lid locallid = lfb.a().a(paramString);
    if ((locallid != null) && (locallid.b() != -1)) {
      i1 = locallid.b();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString);
  }
  
  public int c(boolean paramBoolean)
  {
    if ((a().k()) || (this.jdField_e_of_type_Boolean))
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
    return a(a());
  }
  
  public ArrayList<lfu> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.d()) && (mrz.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(mrz.jdField_a_of_type_JavaUtilArrayList);
        return localArrayList2;
      }
      ArrayList localArrayList2 = this.jdField_c_of_type_JavaUtilArrayList;
      return localArrayList2;
    }
  }
  
  public void c()
  {
    int i2 = 3;
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        mvj localmvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((lid)localObject2).jdField_e_of_type_Boolean) {
          break label306;
        }
        if (((lid)localObject2).i())
        {
          if ((((lid)localObject2).jdField_d_of_type_Int == 1) || (((lid)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((lid)localObject2).R) && (!((lid)localObject2).jdField_J_of_type_Boolean))
            {
              i1 = 56;
              if ((((lid)localObject2).jdField_i_of_type_Int != 1011) && (!l())) {
                break label372;
              }
              i1 = ((lid)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label665;
              }
              if (((lid)localObject2).E != 7) {
                break label695;
              }
              i1 = i2;
              if (((lid)localObject2).jdField_a_of_type_Lie.jdField_b_of_type_Int <= 4) {
                break label344;
              }
              i2 = 52;
              if (this.jdField_f_of_type_Boolean)
              {
                i2 = 60;
                t();
              }
              localmvj.a(((lid)localObject2).jdField_c_of_type_JavaLangString, "", null, null, i2, ((lid)localObject2).jdField_i_of_type_Int, i1);
              s();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((lid)localObject2).jdField_g_of_type_Long);
          localObject4 = ((lid)localObject2).jdField_d_of_type_JavaLangString;
          localObject2 = ((lid)localObject2).jdField_c_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localmvj.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.12(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((lid)localObject2).jdField_d_of_type_Int != 1) {
          break label671;
        }
      }
      finally {}
      int i1 = 47;
      label306:
      if (((lid)localObject2).k())
      {
        if (((lid)localObject2).jdField_d_of_type_Int != 1) {
          break label680;
        }
        i1 = 47;
      }
      else
      {
        if (((lid)localObject2).jdField_d_of_type_Int != 1) {
          break label689;
        }
        i1 = 46;
        break label686;
        label344:
        localObject1.a(((lid)localObject2).jdField_c_of_type_JavaLangString, "", null, null, 51, ((lid)localObject2).jdField_i_of_type_Int, i1);
        t();
        continue;
        label372:
        if ((((lid)localObject2).jdField_d_of_type_Int == 3) || (((lid)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((lid)localObject2).jdField_J_of_type_Boolean)
          {
            localObject3 = ((lid)localObject2).jdField_e_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((lid)localObject2).jdField_d_of_type_JavaLangString, null, true, true);
            localObject1.a(((lid)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lid)localObject2).jdField_g_of_type_Long), 48, 0, ((lid)localObject2).jdField_d_of_type_Int);
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a().jdField_i_of_type_Int, String.valueOf(a().jdField_g_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lid)localObject2).jdField_i_of_type_Int, String.valueOf(((lid)localObject2).jdField_g_of_type_Long), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((lid)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lid)localObject2).jdField_g_of_type_Long), 44, ((lid)localObject2).jdField_i_of_type_Int, ((lid)localObject2).jdField_d_of_type_Int);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this), 1000L);
          continue;
        }
        if (((lid)localObject2).jdField_e_of_type_JavaLangString == null) {
          ((lid)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(((lid)localObject2).jdField_i_of_type_Int, ((lid)localObject2).jdField_d_of_type_JavaLangString, ((lid)localObject2).jdField_f_of_type_JavaLangString);
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lid)localObject2).jdField_i_of_type_Int, ((lid)localObject2).jdField_d_of_type_JavaLangString, ((lid)localObject2).jdField_f_of_type_JavaLangString, true, true);
        localObject1.a(((lid)localObject2).jdField_c_of_type_JavaLangString, ((lid)localObject2).jdField_e_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((lid)localObject2).jdField_i_of_type_Int, ((lid)localObject2).jdField_d_of_type_Int);
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
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", a().jdField_i_of_type_Int);
      localIntent.putExtra("peerUin", a().jdField_d_of_type_JavaLangString);
      localIntent.putExtra("extraUin", a().jdField_f_of_type_JavaLangString);
      localIntent.putExtra("relationType", a().E);
      localIntent.putExtra("relationId", a().jdField_g_of_type_Long);
      localIntent.putExtra("isDoubleVideoMeeting", a().jdField_J_of_type_Boolean);
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
      a().X = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        a().X = false;
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
          localObject = (lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i2);
          int i1;
          if (a()) {
            if (((lqq)localObject).jdField_a_of_type_Int == 1)
            {
              i1 = 1;
              label178:
              if ((((lqq)localObject).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (i1 == 0)) {
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
            if (a(((lqq)localObject).jdField_a_of_type_Long, ((lqq)localObject).jdField_a_of_type_Int, a().jdField_e_of_type_JavaUtilArrayList)) {
              ((lqq)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((lqq)localObject).jdField_b_of_type_Boolean = false;
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
    lek.c(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
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
    switch (paramInt2)
    {
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      a().W = true;
      d(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      a().jdField_J_of_type_Int = paramInt2;
      d(paramInt1, paramLong, paramInt2);
      return;
    }
    c(paramInt1, paramLong, paramInt2);
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if ((!TextUtils.isEmpty(a().jdField_d_of_type_JavaLangString)) && ((!a().jdField_d_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (a().jdField_d_of_type_Int == 0)))
    {
      int i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo, result[" + i1 + "]");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo fail, mainSession[" + a() + "]");
  }
  
  public void c(long paramLong1, long paramLong2, long paramLong3)
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
  
  public void c(Bundle paramBundle)
  {
    L();
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    String str = paramBundle.getString("fromUin");
    boolean bool = paramBundle.getBoolean("isFriend");
    int i1 = a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoCallData: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", fromUin = " + str + ", result = " + i1 + ",isFriend:" + bool);
    }
    this.jdField_a_of_type_Int = 0;
    if ((a().jdField_i_of_type_Int == 1006) && (!a().jdField_e_of_type_Boolean) && (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      a().jdField_f_of_type_JavaLangString = str;
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
      if ((a().jdField_d_of_type_Int <= 0) || (a().jdField_d_of_type_Int > 2) || (!a().k())) {
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
  
  public void c(ArrayList<lph> paramArrayList)
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
          if ((((lph)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((lph)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((lph)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((lph)paramArrayList.get(i1)).jdField_a_of_type_Long));
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
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
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onRecvMultiVideoCallData buf=%s", new Object[] { paramArrayOfByte }));
    }
    L();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_j_of_type_Int, paramArrayOfByte);
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
          Object localObject2 = new DisplayMetrics();
          ((WindowManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
          localObject1 = String.valueOf(AppSetting.a());
          int i2 = ((DisplayMetrics)localObject2).widthPixels;
          int i3 = ((DisplayMetrics)localObject2).heightPixels;
          int i1 = c();
          String str3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          if (TextUtils.isEmpty(str3)) {
            continue;
          }
          localObject2 = new VcControllerImpl(a(), (String)localObject1, this, this, i2, i3, i1, str3);
          ClientLogReport.instance().setVideoAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          long l1 = mto.a(str3);
          String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = bhoi.a("62ad83");
          i2 = bdvr.a(str3);
          str3 = bdcb.b();
          String str4 = str3 + "," + i2;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(i2), str4 }));
          }
          ((VcControllerImpl)localObject2).init(a(), l1, "8.3.3", Build.MODEL, (String)localObject1, str1, AppSetting.d(), str2, lnz.b(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, lnz.d(), i1, str4, new lnu().a(), mvh.a(l1), mvh.b(l1));
          ((VcControllerImpl)localObject2).updateProcessInfo(0L, "manufacturer", Build.MANUFACTURER);
          localObject1 = ((VcControllerImpl)localObject2).postData(5L, null);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = "";
          QLog.w(jdField_a_of_type_JavaLangString, 1, "initVcController, SDK BuildNum[" + (String)localObject1 + "]");
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = ((VcControllerImpl)localObject2);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController fail.", localThrowable);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
        UpdateAvSo.b();
        continue;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController selfUin invalid.");
        UpdateAvSo.b();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break label452;
      }
      return true;
      localObject1 = new String((byte[])localObject1);
    }
    label452:
    return false;
  }
  
  public boolean c(boolean paramBoolean)
  {
    lek.d(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
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
        lfu locallfu = (lfu)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = String.valueOf(locallfu.jdField_a_of_type_Long);
        localArrayList2.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null)
    {
      this.jdField_d_of_type_JavaLangRunnable = new VideoController.15(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 20000L);
      }
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
    if ((q()) && ((this.jdField_h_of_type_Int == 2) || (this.jdField_h_of_type_Int == 3)))
    {
      lek.d(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_h_of_type_Int);
      return;
    }
    if (mwk.a() != null) {
      mwk.a().a(l1);
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    Object localObject = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((mvj)localObject).a();
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
        lek.e(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (paramInt2 == 108)
    {
      a().Z = true;
      lid locallid = a();
      if (!h())
      {
        bool = true;
        locallid.Y = bool;
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      break;
      if (a().Z)
      {
        a().Z = false;
        if (a().Y) {
          a("onMVSpeakModeChanged_2", this.jdField_a_of_type_Long, true, false);
        } else {
          a("onMVSpeakModeChanged_3", this.jdField_a_of_type_Long, false, false);
        }
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    lek.d(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), lgc.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void d(long paramLong, int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject = a();
    if (a("onEnterSuc", true, paramInt1, String.valueOf(paramLong))) {
      localObject = a();
    }
    QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "onEnterSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], MainSession[" + localObject + "], seq[" + l1 + "]");
    a("onEnterSuc");
    ((lid)localObject).aq = false;
    if (paramInt1 == 3)
    {
      ((lid)localObject).a("onEnterSuc.1", 14);
      ((lid)localObject).c("onEnterSuc", true);
      ((lid)localObject).a(l1, SystemClock.elapsedRealtime());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong), Long.valueOf(l1) });
      if (((paramInt1 == 2) || (paramInt1 == 1)) && ((paramInt2 == 10) || (paramInt2 == 1)))
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        a(paramLong, a(paramInt1, paramInt2, paramLong), false);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "InviteMemberList onEnterSuc, send request");
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lmr)localObject).a(a());
      }
      return;
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject = lfb.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = lfb.a().c((String)localObject);
      if (localObject != null)
      {
        ((lid)localObject).jdField_U_of_type_Boolean = true;
        ((lid)localObject).jdField_N_of_type_Boolean = false;
        ((lid)localObject).aC = true;
      }
      if ((mti.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
    }
  }
  
  public void d(Bundle paramBundle)
  {
    L();
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
    if (!a().ah)
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
    if (a().aj)
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
    n(true);
    if (!paramArrayOfByte.b()) {
      a(l1, 2131230736, 1, null);
    }
    paramArrayOfByte.c("onSwitchGroup", mti.a(paramArrayOfByte.jdField_i_of_type_Int));
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(2, 11);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
    d();
  }
  
  public void d(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRecvFirstAudioData, recvFirstAudio[" + paramBoolean + "], seq[" + l1 + "]");
    }
    if (paramBoolean)
    {
      if (!a().R) {
        break label144;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        if (-1 != this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(a().jdField_d_of_type_JavaLangString)) {
          break label136;
        }
        this.jdField_k_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean), Long.valueOf(l1) });
      return;
      label136:
      this.jdField_k_of_type_Boolean = true;
      continue;
      label144:
      this.jdField_k_of_type_Boolean = true;
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onRecvMultiVideoAck buf=%s", new Object[] { paramArrayOfByte }));
    }
    L();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_k_of_type_Int, paramArrayOfByte);
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lfb.a().jdField_e_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lfb.a().jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_Lfb.a().jdField_d_of_type_Int != 2)) {
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
      if (this.jdField_a_of_type_Lfb.a().jdField_d_of_type_Int == 0) {
        if (this.jdField_a_of_type_Lfb.a().jdField_f_of_type_Int != 1)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Lfb.a().jdField_f_of_type_Int != 2) {}
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
    return this.jdField_a_of_type_Int;
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
  
  public ArrayList<lfu> e()
  {
    if ((AudioHelper.d()) && (mrz.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(mrz.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void e()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new VideoController.16(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_e_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
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
      ((lid)localObject1).jdField_N_of_type_Boolean = true;
      ((lid)localObject1).jdField_a_of_type_JavaUtilArrayList.clear();
      if ((mti.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
      label773:
      for (;;)
      {
        a("onCreateRoomSuc");
        a("onCreateSuc", true, paramInt1, paramLong);
        ((lid)localObject1).aq = false;
        if (((lid)localObject1).jdField_J_of_type_Boolean) {
          ((lid)localObject1).c("onCreateRoomSuc", true);
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
        this.jdField_f_of_type_Int = 0;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localObject2 != null) {
          ((lmr)localObject2).a(a());
        }
        if ((!((lid)localObject1).jdField_J_of_type_Boolean) && (((lid)localObject1).E != 3)) {
          break;
        }
        localObject2 = a();
        if (localObject2 == null) {
          break;
        }
        ((ScreenShareCtrl)localObject2).a((lid)localObject1);
        return;
        int i1;
        int i2;
        if (((lid)localObject1).jdField_ac_of_type_Int == 5)
        {
          i1 = ((lid)localObject1).c();
          i2 = ((lid)localObject1).b();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onCreateRoomSuc, double meeting, terminalType[" + i1 + "], sdkVersion[" + i2 + "]");
          }
          long l2;
          if ((i1 == 2) || (i1 == 12) || ((i1 == 4) && (i2 >= 114)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lid)localObject1).jdField_g_of_type_Long;
            i1 = ((lid)localObject1).jdField_ac_of_type_Int;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lid)localObject1).jdField_g_of_type_Long;
            i1 = ((lid)localObject1).jdField_ac_of_type_Int;
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((lid)localObject1).jdField_ac_of_type_Int, 0);
        }
        else
        {
          if (AudioHelper.a(19) == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label773;
            }
            AudioHelper.a(alpo.a(2131716501));
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((lid)localObject1).jdField_ac_of_type_Int, 0);
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
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onSetMicBySelf uin = " + paramLong);
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lfu locallfu = (lfu)localIterator.next();
        if (locallfu.jdField_a_of_type_Long == paramLong) {
          if (!locallfu.jdField_f_of_type_Boolean)
          {
            locallfu.jdField_f_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
          }
        }
      }
      return;
    }
  }
  
  public void e(String paramString)
  {
    lid locallid = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallid.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallid.R + "], seq[" + l1 + "]");
    if (lux.a(BaseApplication.getContext()) == 1) {
      locallid.b(l1, false);
    }
    while ((locallid.jdField_d_of_type_Int != 2) || (!locallid.jdField_k_of_type_Boolean)) {
      return;
    }
    locallid.b(l1, false);
    if (!locallid.jdField_j_of_type_Boolean)
    {
      locallid.R = true;
      locallid.a(l1, "onPauseVideo", 1);
      c(locallid.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    mtq.n(this);
  }
  
  public void e(String paramString, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("SetNetIPAndPort ip=%s port=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_u_of_type_Int = paramInt;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetNetIPAndPort(paramString, paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
      }
      bdiv.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(VideoConstants.h, paramString).commit();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "SetNetIPAndPort fail.", paramString);
    }
  }
  
  public void e(boolean paramBoolean)
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
  
  public void e(byte[] paramArrayOfByte)
  {
    int i1 = loc.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().B)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
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
      lfu locallfu = (lfu)localIterator.next();
      if ((locallfu.jdField_d_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(locallfu.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(locallfu.jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  void f()
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
  
  public void f(long paramLong)
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
  
  public void f(String paramString)
  {
    lid locallid = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallid.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallid.R + "], seq[" + l1 + "]");
    if ((locallid.jdField_f_of_type_Int == 1) && (!f())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (locallid.jdField_k_of_type_Boolean);
      locallid.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      mtq.m(this);
    } while (locallid.jdField_d_of_type_Int != 1);
    locallid.a(l1, "onResumeVideo", 2);
    locallid.R = false;
  }
  
  public void f(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvIVRPush");
    }
  }
  
  public boolean f()
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
    String str2 = a().jdField_d_of_type_JavaLangString;
    String str1 = str2;
    if (a().jdField_i_of_type_Int == 1006)
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
        long l1 = mto.a(str1);
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
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
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
    GraphicRenderMgr.getInstance().decoderPtrRef = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
    }
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  void g(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    lid locallid = a();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + locallid + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(locallid.jdField_d_of_type_JavaLangString).longValue();
    int i1 = locallid.jdField_d_of_type_Int;
    long l3 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    int i2 = locallid.jdField_i_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      lqq locallqq1 = new lqq();
      lqq locallqq2 = new lqq();
      locallqq1.jdField_a_of_type_Long = l2;
      locallqq1.jdField_a_of_type_Int = 1;
      locallqq2.jdField_a_of_type_Long = l2;
      locallqq2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(locallqq2);
      localArrayList.add(locallqq1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (locallid.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
    }
    for (;;)
    {
      n(true);
      a(l1, l2, true, 0);
      a().jdField_d_of_type_JavaLangString = String.valueOf(l2);
      a().a(l1, "notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      a().d("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      a().c("notifyChangeDoubleVideoMeeting2MultiVideo", false);
      a().L = true;
      b("notifyChangeDoubleVideoMeeting2MultiVideo", bool);
      if (paramBoolean)
      {
        e();
        a().a(4, 11);
        a().c("notifyChangeDoubleVideoMeeting2MultiVideo", mti.a(i2));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.jdField_m_of_type_Boolean + "], session[" + locallid + "], seq[" + l1 + "]");
      }
      return;
      if (locallid.a(l3, 1) != -1) {
        locallid.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
      }
    }
  }
  
  public void g(byte[] paramArrayOfByte)
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
    if (a().M == 3)
    {
      i1 = 1;
      if (i1 != 0) {
        a(true);
      }
      return;
    }
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
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
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new lfl(this);
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
  
  public void h(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDetectAudioDataIssue, issueType[" + this.jdField_d_of_type_Int + "->" + paramInt + "], seq[" + l1 + "]");
    this.jdField_d_of_type_Int = paramInt;
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
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_Lie.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_Lie.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_c_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      lid locallid = a();
      if (paramBoolean)
      {
        a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (locallid != null)
        {
          locallid.jdField_a_of_type_Lie.jdField_f_of_type_Boolean = false;
          locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          locallid.a();
          locallid.b();
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
        if (a().jdField_a_of_type_Lie.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((a().jdField_a_of_type_Lie.jdField_a_of_type_Int == 1) || (a().jdField_a_of_type_Lie.jdField_a_of_type_Int == 2))
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
    return this.jdField_m_of_type_Boolean;
  }
  
  public int i()
  {
    if ((a().k()) || (this.jdField_e_of_type_Boolean)) {
      return 0;
    }
    return 255;
  }
  
  void i()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
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
    this.jdField_u_of_type_Boolean = paramBoolean;
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
          lfu locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (locallfu != null)
          {
            bool2 = bool1;
            if (!locallfu.jdField_g_of_type_Boolean) {
              break label231;
            }
            if ((locallfu.jdField_c_of_type_Long >= 2000L) && (locallfu.jdField_c_of_type_Long < this.jdField_c_of_type_Long))
            {
              l1 = locallfu.jdField_c_of_type_Long;
              bool2 = bool1;
              if (l2 - locallfu.jdField_b_of_type_Long <= l1) {
                break label231;
              }
              locallfu.jdField_g_of_type_Boolean = false;
              locallfu.jdField_b_of_type_Long = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + locallfu.jdField_a_of_type_Long + ",isSuspectNoisy = " + locallfu.jdField_g_of_type_Boolean);
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
    return this.jdField_s_of_type_Int;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 25000L);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "startConnectingTimer");
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
    p(true);
    a(paramString, 206);
    b(206);
    b(paramString, 7);
  }
  
  public void j(boolean paramBoolean)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setSelectMemberActivityIsResume, IsResume[" + paramBoolean + "], mSelectMemberActivityIsResume[" + this.jdField_o_of_type_Int + "]");
    if (paramBoolean) {
      this.jdField_o_of_type_Int += 1;
    }
    do
    {
      return;
      this.jdField_o_of_type_Int -= 1;
    } while (this.jdField_o_of_type_Int >= 0);
    this.jdField_o_of_type_Int = 0;
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
        break label146;
      }
      lfu locallfu = (lfu)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
      if ((locallfu == null) || (!locallfu.jdField_g_of_type_Boolean)) {
        break label139;
      }
      if (l1 == locallfu.jdField_a_of_type_Long) {
        a("setSuspectNoisyUserMicOff", this.jdField_a_of_type_Long, false, true);
      }
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(localObject.jdField_a_of_type_Long, true);
    for (;;)
    {
      label127:
      return bool;
      label139:
      label146:
      do
      {
        bool = false;
        break label127;
        i1 += 1;
        break;
      } while (i1 == i2);
      boolean bool = true;
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "stopConnectingTimer");
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
    if (paramBoolean) {}
    for (int i1 = jdField_q_of_type_Int;; i1 = jdField_r_of_type_Int)
    {
      if (this.jdField_s_of_type_Int != i1)
      {
        this.jdField_s_of_type_Int = i1;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "setLoadPTuSo, bloadSuc[" + paramBoolean + "]");
      }
      return;
    }
  }
  
  public boolean k()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().E == 2)
      {
        azmj.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
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
        if ((a().E == 1) && (a().C == 10)) {
          azmj.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public void l()
  {
    boolean bool1 = lnz.c();
    boolean bool2 = lnz.d();
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("initGAudioCtrl isSupportSharpAudio=%s isAvSoReady=%s mGAudioCtrl=%s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl }));
    if ((!bool1) || (!bool2)) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          long l1 = mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          int i1 = c();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1, "8.3.3");
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(this.jdField_e_of_type_JavaLangString, this.jdField_u_of_type_Int);
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
      lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallfz != null) {
        locallfz.b(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_Lie.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lie.jdField_b_of_type_Int < 6);
  }
  
  public void m()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 50);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    a().H = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallfz != null) {
        locallfz.c(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    lid locallid = a();
    boolean bool1 = bool2;
    if (locallid != null)
    {
      bool1 = bool2;
      if (locallid.jdField_a_of_type_Lif.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (locallid.jdField_a_of_type_Lif.jdField_a_of_type_Long > 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(307) });
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
      lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallfz != null) {
        locallfz.d(paramBoolean);
      }
    }
  }
  
  public boolean n()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
  }
  
  public void o()
  {
    if (!this.jdField_e_of_type_Boolean) {
      a().a("clearGAudioState", 0);
    }
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
      lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallfz != null) {
        locallfz.e(paramBoolean);
      }
    }
  }
  
  public boolean o()
  {
    return this.jdField_u_of_type_Boolean;
  }
  
  public void p()
  {
    long l1;
    if (this.jdField_e_of_type_Boolean) {
      l1 = mto.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1;
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (l1 == ((lfu)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long))
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
      lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallfz != null) {
        locallfz.f(paramBoolean);
      }
    }
  }
  
  public boolean p()
  {
    if (AudioHelper.e()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[" + this.jdField_o_of_type_Int + "]");
    }
    return this.jdField_o_of_type_Int > 0;
  }
  
  public void q()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStartTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_l_of_type_JavaLangRunnable, 3000L);
  }
  
  public void q(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lfz locallfz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallfz != null) {
        locallfz.g(paramBoolean);
      }
    }
  }
  
  public boolean q()
  {
    if ((a() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    while ((a().jdField_i_of_type_Int != 10003) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_b_of_type_Boolean)) {
      return false;
    }
    return true;
  }
  
  public void r()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStopTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
  }
  
  public void r(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public void r(boolean paramBoolean)
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
  
  public boolean r()
  {
    if (!lsa.a()) {}
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Lsa != null)
      {
        if ((lsl.b()) || (lsl.c())) {
          return true;
        }
        lid locallid = a();
        if ((locallid.jdField_d_of_type_Int == 2) || (locallid.jdField_d_of_type_Int == 4)) {}
        for (int i1 = 1; (i1 != 0) && ((!locallid.jdField_a_of_type_JavaUtilBitSet.isEmpty()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()) || (locallid.aw)); i1 = 0) {
          return true;
        }
      }
    }
  }
  
  public void s()
  {
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_Lie.jdField_b_of_type_Int >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void s(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void t()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void t(String paramString)
  {
    long l1 = AudioHelper.b();
    lid locallid = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + locallid.jdField_d_of_type_JavaLangString + "], extraUin[" + locallid.jdField_f_of_type_JavaLangString + "], remoteHasVideo[" + locallid.jdField_k_of_type_Boolean + "], mXiaoweiDevice[" + this.jdField_r_of_type_Boolean + "], seq[" + l1 + "]");
    if ((TextUtils.equals(locallid.jdField_d_of_type_JavaLangString, paramString)) || (TextUtils.equals(locallid.jdField_f_of_type_JavaLangString, paramString)) || (this.jdField_r_of_type_Boolean))
    {
      if ((locallid.jdField_f_of_type_Int != 1) || (f())) {
        break label165;
      }
      lek.d(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
    }
    for (;;)
    {
      return;
      label165:
      if (locallid.jdField_d_of_type_Int == 1) {
        c(2);
      }
      if (!locallid.jdField_k_of_type_Boolean)
      {
        locallid.b(l1, true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
        mtq.m(this);
        if (locallid.jdField_d_of_type_Int == 1)
        {
          locallid.a(l1, "onNeedShowPeerVideo", 2);
          locallid.R = false;
        }
      }
      while (!TextUtils.equals(locallid.jdField_d_of_type_JavaLangString, paramString))
      {
        GraphicRenderMgr.getInstance().onUinChanged(locallid.jdField_d_of_type_JavaLangString, paramString);
        return;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
      }
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
      i1 = a().a();
      if (i1 != -1) {
        break label71;
      }
      ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label71:
    do
    {
      for (;;)
      {
        return;
        lqq locallqq1 = (lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        locallqq1.jdField_a_of_type_Boolean = true;
        if (locallqq1.jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          if (i1 != 0)
          {
            locallqq2 = (lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0);
            locallqq2.jdField_a_of_type_Boolean = false;
            a().jdField_c_of_type_JavaUtilArrayList.set(0, locallqq1);
            a().jdField_c_of_type_JavaUtilArrayList.set(i1, locallqq2);
          }
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, locallqq1);
            a().jdField_d_of_type_JavaUtilArrayList.set(i1, locallqq2);
            a().c();
            if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1)
            {
              i1 = 0;
              if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
              {
                if (((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
                  ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    } while (i1 == 0);
    lqq locallqq2 = (lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0);
    locallqq2.jdField_a_of_type_Boolean = false;
    a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
    a().jdField_c_of_type_JavaUtilArrayList.set(i1, locallqq2);
    synchronized (a().jdField_d_of_type_JavaUtilArrayList)
    {
      a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
      a().jdField_d_of_type_JavaUtilArrayList.set(i1, locallqq2);
      a().c();
      return;
    }
    label420:
    ((lqq)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void u(String paramString)
  {
    a().al = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    v(paramString);
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().E == 2) {
        azmj.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
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
        if ((a().E == 1) && (a().C == 10)) {
          azmj.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
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
  
  public void w(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void x()
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.jdField_o_of_type_Int + "]");
    this.jdField_o_of_type_Int = 0;
  }
  
  public void x(String paramString)
  {
    a("deviceMemory", lkx.c() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (lno.b(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = h();
      if (!bool1)
      {
        a("onHowling", this.jdField_a_of_type_Long, false, false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().jdField_O_of_type_Boolean;
      if (bool2) {
        this.jdField_a_of_type_Mwk.d();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131696086), 2131690648, 2131694951, new lfo(this), new lfp(this, bool1, bool2));
      azmj.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
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
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696172, 1).a();
    }
    Object localObject = a();
    if (localObject != null) {
      if (((lid)localObject).E != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      log.a((String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */