package com.tencent.av;

import ajjy;
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
import awqx;
import awrn;
import azyg;
import babp;
import bacm;
import badq;
import baei;
import baen;
import baig;
import bamr;
import bati;
import bbmy;
import bedr;
import befc;
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
import krx;
import ksa;
import ksl;
import ksn;
import ksq;
import kst;
import ksw;
import ksx;
import ksy;
import ksz;
import kta;
import ktb;
import ktc;
import ktd;
import kte;
import ktg;
import kth;
import kti;
import ktk;
import ktm;
import ktn;
import ktp;
import ktq;
import ktr;
import kvq;
import kvr;
import kvs;
import kwb;
import kyj;
import kyl;
import kzl;
import kzw;
import lad;
import lak;
import lba;
import lbb;
import lbc;
import lbe;
import lbg;
import lbk;
import lbn;
import lbq;
import lbr;
import lcs;
import ldd;
import ldv;
import ldz;
import leb;
import lfc;
import lfg;
import lfi;
import lft;
import lie;
import lif;
import lor;
import lqb;
import ltr;
import lzv;
import mcy;
import mej;
import mfs;
import mfy;
import mga;
import mgh;
import mhf;
import mhg;
import mhj;
import mhr;
import mht;
import mhx;
import min;
import mip;
import miu;
import mjg;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;
import yds;

public class VideoController
  extends lbb
  implements lbe, ldz
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
  Object jdField_a_of_type_JavaLangObject = new Object();
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoController.1(this);
  ArrayList<kth> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ksl a;
  ksn jdField_a_of_type_Ksn = ksn.a();
  private volatile ksq jdField_a_of_type_Ksq;
  private ktg jdField_a_of_type_Ktg;
  kti jdField_a_of_type_Kti = new kte(this);
  public lak a;
  public lbc a;
  lfg jdField_a_of_type_Lfg = null;
  private lfi jdField_a_of_type_Lfi;
  public mgh a;
  public mhf a;
  mhg jdField_a_of_type_Mhg;
  public miu a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  boolean jdField_a_of_type_Boolean = true;
  public float[] a;
  private mcy[] jdField_a_of_type_ArrayOfMcy;
  public int b;
  public long b;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoController.2(this);
  private ArrayList<kth> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public kti b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  private final ArrayList<kth> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  kti jdField_c_of_type_Kti = new ksx(this);
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
  Runnable jdField_j_of_type_JavaLangRunnable = new VideoController.29(this);
  boolean jdField_j_of_type_Boolean = false;
  int jdField_k_of_type_Int = 2;
  private Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.28(this);
  boolean jdField_k_of_type_Boolean = false;
  int jdField_l_of_type_Int = 3;
  private Runnable jdField_l_of_type_JavaLangRunnable;
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int = 4;
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
    this.jdField_b_of_type_Kti = new ksw(this);
    this.jdField_n_of_type_Int = 0;
    this.jdField_q_of_type_Boolean = true;
    this.jdField_o_of_type_Int = 0;
    this.jdField_g_of_type_Long = -1L;
    if (!mfs.a()) {}
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
      this.jdField_a_of_type_Lak = new lak();
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new ktd(this, a(), 3);
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
      krx.c(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void L()
  {
    ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localktm != null) {
      localktm.a();
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
      long l1 = ((kvq)localObject).jdField_h_of_type_Long;
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
    if (this.jdField_a_of_type_Lbc == null)
    {
      this.jdField_a_of_type_Lbc = new lbc(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a().jdField_i_of_type_Int = 9500;
      if (QLog.isColorLevel()) {
        QLog.w("BaseIMSharp", 2, "init device sharp");
      }
    }
  }
  
  private void O()
  {
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_v_of_type_Int = 0;
  }
  
  private void P()
  {
    if (this.jdField_l_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
    }
    this.jdField_l_of_type_JavaLangRunnable = null;
  }
  
  private void Q()
  {
    if ((this.jdField_g_of_type_Long != -1L) && (System.currentTimeMillis() - this.jdField_g_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    echo.ReqEcho localReqEcho = new echo.ReqEcho();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
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
  
  private kvq a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = ksn.a(3, paramString, new int[0]);
      localObject2 = ksn.a().b((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = ksn.a(100, paramString, new int[0]);
        localObject1 = ksn.a().b((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ksn.a().a(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = ksn.a(4, paramString, new int[0]);
        localObject1 = ksn.a().b((String)localObject1);
      }
    }
  }
  
  private void a(int paramInt, long paramLong1, ldd paramldd, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_Ksn.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramldd.jdField_a_of_type_Long;
    long l2 = mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    label62:
    label105:
    long l3;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = ksn.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt == 3) {
        paramVarArgs = ksn.a(100, String.valueOf(paramLong1), new int[0]);
      }
      if (paramInt != 1) {
        break label482;
      }
      paramVarArgs = a();
      if (paramVarArgs == null) {
        break label493;
      }
      l3 = AudioHelper.b();
      if (AudioHelper.e()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_c_of_type_Int + "], relationType[" + paramInt + "], UserInfo[" + paramldd + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_m_of_type_Boolean + "], switchToGAudioMode[" + paramVarArgs.D + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_Long = paramLong1;
        this.jdField_c_of_type_Int = paramInt;
        if (paramVarArgs != null) {
          paramVarArgs.T = true;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
        if (this.jdField_m_of_type_Boolean) {
          break label495;
        }
        bool2 = true;
        label343:
        a("onGAudioUserEnterOrLeave", bool2, paramVarArgs.a());
        if (((this.jdField_c_of_type_Int == 1) && (paramVarArgs.jdField_A_of_type_Int == 10)) || (this.jdField_c_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label501;
          }
        }
      }
    }
    label482:
    label493:
    label495:
    label501:
    for (boolean bool2 = false;; bool2 = true)
    {
      paramVarArgs.ab = bool2;
      paramVarArgs = a();
      if ((paramBoolean) || (l1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) || (paramLong1 != paramVarArgs.jdField_g_of_type_Long)) {
        break label507;
      }
      a(paramInt, paramLong1, 72);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      bool1 = false;
      break label62;
      paramVarArgs = ksn.a().b(paramVarArgs);
      break label105;
      break;
      bool2 = false;
      break label343;
    }
    label507:
    a(paramldd, paramBoolean);
    if ((paramVarArgs.jdField_d_of_type_Int == 3) && (paramVarArgs.jdField_i_of_type_Int == 1011))
    {
      if (!paramBoolean) {
        break label918;
      }
      if (h() != 1) {
        break label906;
      }
      if (!bool1) {
        break label894;
      }
      paramVarArgs.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 4;
      label562:
      if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
        this.jdField_a_of_type_Miu.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      }
      label611:
      a(paramVarArgs.jdField_a_of_type_Kvr.jdField_b_of_type_Int, 3, null);
      ??? = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((??? != null) && (((mht)???).a())) {
        c();
      }
    }
    if (paramBoolean) {
      if (paramVarArgs.jdField_g_of_type_Int < 10)
      {
        if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (bool1))
        {
          paramVarArgs.a("onGAudioUserEnterOrLeave.1", 9);
          paramVarArgs.ad = false;
        }
      }
      else
      {
        label698:
        if ((paramVarArgs.jdField_h_of_type_Long != l1) && (l1 != l2)) {
          lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
        }
        if (paramVarArgs.jdField_e_of_type_Long == 0L) {
          paramVarArgs.a(l3, SystemClock.elapsedRealtime());
        }
        label747:
        if (!paramBoolean) {
          break label1152;
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramldd.jdField_a_of_type_Int != 0) {
          break label1146;
        }
        bool1 = true;
        label769:
        paramVarArgs.a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool1) });
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (!a().I) {
          break label1306;
        }
        if (paramBoolean) {
          break;
        }
        if (a().J)
        {
          paramldd = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          t();
          if (paramldd.a()) {
            paramldd.a(a().jdField_c_of_type_JavaLangString);
          }
        }
        if (!a().an) {
          break;
        }
        a(l3, paramLong1, false, 2);
        return;
        label894:
        paramVarArgs.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 1;
        break label562;
        label906:
        paramVarArgs.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 5;
        break label562;
        label918:
        if (h() == 1) {
          paramVarArgs.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 4;
        }
        if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) || (!m())) {
          break label611;
        }
        this.jdField_a_of_type_Miu.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
        break label611;
        paramVarArgs.a("onGAudioUserEnterOrLeave.2", 10);
        s();
        break label698;
        synchronized (this.jdField_c_of_type_JavaUtilArrayList)
        {
          if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (((kth)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
          {
            i1 = 1;
            if (i1 != 0)
            {
              paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
              paramVarArgs.ad = true;
              paramVarArgs = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
              if ((paramVarArgs != null) && (paramVarArgs.a()))
              {
                t();
                c();
              }
            }
            lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
            break label747;
          }
          int i1 = 0;
        }
      }
      label1146:
      bool1 = false;
      break label769;
      label1152:
      if (paramLong2 == 1L)
      {
        g(true);
      }
      else
      {
        if (paramLong2 == 0L)
        {
          paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (paramldd.jdField_a_of_type_Int == 0) {}
          for (bool1 = true;; bool1 = false)
          {
            paramVarArgs.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
            break;
          }
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramldd.jdField_a_of_type_Int == 0) {}
        for (bool1 = true;; bool1 = false)
        {
          paramVarArgs.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
          break;
        }
      }
    }
    label1306:
    paramldd = new Intent();
    paramldd.setAction("tencent.av.v2q.MultiVideo");
    if (paramBoolean)
    {
      paramldd.putExtra("type", 22);
      paramldd.putExtra("isStart", this.jdField_s_of_type_Boolean);
    }
    for (;;)
    {
      paramldd.putExtra("roomUserNum", this.jdField_c_of_type_JavaUtilArrayList.size());
      paramldd.putExtra("relationType", paramInt);
      paramldd.putExtra("relationId", paramLong1);
      paramldd.putExtra("friendUin", l1);
      paramldd.putExtra("MultiAVType", a().jdField_A_of_type_Int);
      paramldd.putExtra("from", "VideoController5");
      paramldd.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramldd);
      return;
      paramldd.putExtra("type", 23);
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
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
    {
      i1 = 0;
      label185:
      if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size()) {
        if (((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong2) {}
      }
    }
    for (int i1 = ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;; i1 = 1)
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
    kth localkth = a(String.valueOf(paramLong1));
    if (localkth == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
      }
    }
    leb localleb;
    do
    {
      do
      {
        return;
        localkth.jdField_b_of_type_Boolean = paramBoolean;
      } while ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) && (a().a(paramLong1, 1) != -1));
      if (!paramBoolean) {
        break;
      }
      localleb = new leb();
      localleb.jdField_a_of_type_Long = paramLong1;
      localleb.jdField_a_of_type_Int = 1;
    } while (a().a(paramLong1, localleb.jdField_a_of_type_Int) != -1);
    localleb.jdField_b_of_type_Long = paramLong2;
    if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
      localleb.jdField_b_of_type_Long = 5L;
    }
    if (!a().t())
    {
      localleb.jdField_a_of_type_Boolean = true;
      if ((g() == 4) || (paramInt == 3)) {
        break label320;
      }
      if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) != -1) {
        break label311;
      }
      localleb.jdField_c_of_type_Boolean = true;
      label236:
      if (localkth.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
        break label338;
      }
      localleb.jdField_b_of_type_Boolean = true;
      localleb.jdField_d_of_type_Boolean = true;
      localleb.jdField_c_of_type_Boolean = true;
      if (a().t()) {
        break label329;
      }
    }
    label311:
    label320:
    label329:
    for (localleb.jdField_a_of_type_Boolean = true;; localleb.jdField_a_of_type_Boolean = false)
    {
      a().a(localleb);
      return;
      localleb.jdField_a_of_type_Boolean = false;
      break;
      localleb.jdField_c_of_type_Boolean = false;
      break label236;
      localleb.jdField_c_of_type_Boolean = true;
      break label236;
    }
    label338:
    localleb.jdField_b_of_type_Boolean = false;
    a().a(localleb);
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
        if (a().jdField_A_of_type_Int == 10) {
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
    do
    {
      return;
      ??? = a(String.valueOf(paramLong));
      if (??? != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
    return;
    if (paramBoolean1)
    {
      leb localleb1 = new leb();
      if (paramBoolean2) {
        ((kth)???).jdField_a_of_type_Int = 2;
      }
      for (;;)
      {
        localleb1.jdField_a_of_type_Long = paramLong;
        localleb1.jdField_a_of_type_Int = 2;
        localleb1.jdField_a_of_type_Boolean = true;
        localleb1.jdField_b_of_type_Boolean = false;
        localleb1.jdField_b_of_type_Long = 5L;
        if (a().a(paramLong, localleb1.jdField_a_of_type_Int) != -1) {
          break;
        }
        if (a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = false;
          if (g() != 4)
          {
            paramInt1 = a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue());
            if (paramInt1 != -1) {
              ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_c_of_type_Boolean = false;
            }
          }
        }
        localleb1.jdField_c_of_type_Boolean = true;
        if (a().jdField_c_of_type_JavaUtilArrayList.size() > 1)
        {
          leb localleb3 = (leb)a().jdField_c_of_type_JavaUtilArrayList.get(0);
          a().jdField_c_of_type_JavaUtilArrayList.set(0, localleb1);
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, localleb1);
            a().a(localleb3);
            return;
            ((kth)???).jdField_a_of_type_Int = 1;
          }
        }
      }
      a().a(0, localleb2);
      return;
    }
    ((kth)???).jdField_a_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    u();
  }
  
  private void a(Intent paramIntent)
  {
    lak locallak = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (locallak != null) {
      locallak.a(paramIntent);
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
    lak locallak = a();
    ktr.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772164, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
      if (locallak != null) {
        locallak.a(paramIntent);
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
  
  private void a(ArrayList<leb> paramArrayList, int paramInt)
  {
    int i4 = 0;
    int i1;
    if (a().jdField_K_of_type_Int == 3)
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
              leb localleb = (leb)paramArrayList.get(paramInt);
              paramArrayList.set(paramInt, paramArrayList.get(i1));
              paramArrayList.set(i1, localleb);
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
  
  public static boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  private void b(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    if (this.jdField_l_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
    }
    this.jdField_l_of_type_JavaLangRunnable = new VideoController.32(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_l_of_type_JavaLangRunnable, 1000L);
  }
  
  private boolean b(long paramLong, boolean paramBoolean)
  {
    kth localkth = a(String.valueOf(paramLong));
    if (localkth == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    localkth.jdField_a_of_type_Boolean = paramBoolean;
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {}
    kvq localkvq;
    do
    {
      return false;
      localkvq = ksn.a().a();
    } while ((localkvq == null) || (localkvq.jdField_d_of_type_JavaLangString == null) || (!paramString.equals(localkvq.jdField_d_of_type_JavaLangString)));
    return true;
  }
  
  private boolean c(String paramString)
  {
    int i1 = (int)(System.currentTimeMillis() / 1000L);
    int i2 = this.jdField_v_of_type_Int;
    return (this.jdField_g_of_type_JavaLangString != null) && (paramString != null) && (this.jdField_g_of_type_JavaLangString.equals(paramString)) && (i1 - i2 < 3);
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
  
  private void e(Bundle paramBundle)
  {
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("fromUin");
    this.jdField_v_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
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
    kvq localkvq = a();
    if (localkvq != null)
    {
      int i2 = localkvq.S;
      int i1 = i2;
      if (i2 == 0) {
        i1 = localkvq.jdField_R_of_type_Int;
      }
      b(i1);
      if ((i1 == 0) || (!localkvq.ay)) {
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
  
  public void A(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker != null) {
      this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker.b(paramString);
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
    awqx.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    awqx.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void D()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_Ksl == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Ksl.jdField_a_of_type_JavaLangString)
    {
      awqx.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
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
    this.jdField_a_of_type_Miu.b(l1);
    this.jdField_a_of_type_Miu.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230738, null, 1, null);
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
    switch (badq.a(null))
    {
    default: 
      h(0);
      return;
    case 0: 
      h(3);
      return;
    }
    Q();
  }
  
  public void I()
  {
    kvq localkvq = a();
    long l1 = AudioHelper.b();
    String str;
    int i1;
    if ((localkvq.j()) || (localkvq.k()) || (localkvq.jdField_g_of_type_Int == 9) || (localkvq.l()))
    {
      lor.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = localkvq.jdField_c_of_type_JavaLangString;
      i1 = localkvq.jdField_d_of_type_Int;
      if (localkvq.jdField_g_of_type_Int == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i1, false, bool, localkvq.v());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reNotifyChatInfo2QQ, sessionInfo[" + localkvq + "]");
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!a().j()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setGroundGlassSwitch(a().jdField_d_of_type_JavaLangString, paramInt);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    krx.c(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
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
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    krx.b("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().jdField_A_of_type_Int);
    AudioHelper.b("startGAudioChat ");
    f(false);
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("startGAudioChat, relationType[").append(paramInt1).append("], relationId[").append(paramLong).append("], businessId[").append(paramInt2).append("], uinList[").append(paramArrayOfLong).append("], isVideo[").append(paramBoolean).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label217;
      }
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break label223;
      }
      return -1;
      bool = false;
      break;
    }
    label223:
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return -1;
    }
    if (!this.jdField_a_of_type_Ksn.a(ksn.a(paramInt1, String.valueOf(paramLong), new int[0]))) {
      this.jdField_a_of_type_Ksn.a(ksn.a(paramInt1, String.valueOf(paramLong), new int[0]), true);
    }
    this.jdField_n_of_type_Boolean = false;
    long l1 = mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
      localObject = this.jdField_a_of_type_Ksn.b(ksn.a(paramInt1, String.valueOf(paramLong), new int[0]));
      if ((localObject == null) || (!((kvq)localObject).a())) {
        break label627;
      }
      paramInt2 = 3;
    }
    label627:
    for (;;)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_j_of_type_Boolean);
      }
      K();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, c(), l1, a().a(), a().jdField_M_of_type_Int, a().L);
      if (this.jdField_i_of_type_JavaLangRunnable == null) {
        this.jdField_i_of_type_JavaLangRunnable = new VideoController.21(this, paramInt1, paramLong);
      }
      this.jdField_s_of_type_Boolean = true;
      a().a("startGAudioChat.2", 8);
      a().jdField_g_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 30000L);
      h();
      a(a().jdField_c_of_type_JavaLangString, 3, false, false, false);
      return 0;
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
        i1 = a().jdField_A_of_type_Int;
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
        break;
      }
      return -1;
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
    boolean bool = a().j();
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
    boolean bool = a().j();
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
          kth localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((localkth != null) && (localkth.jdField_a_of_type_Long == paramLong)) {
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
        a().af = true;
        a().ap = true;
        paramLong1 = mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i2, i1, paramLong2, paramArrayOfLong, c(), paramLong1, a().L);
          if (this.jdField_i_of_type_JavaLangRunnable == null) {
            this.jdField_i_of_type_JavaLangRunnable = new VideoController.22(this, paramInt, paramLong2);
          }
          this.jdField_s_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 30000L);
          h();
          return 0;
        }
      }
      int i1 = 1;
      continue;
      label449:
      if (paramInt == 1)
      {
        i2 = a().jdField_A_of_type_Int;
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
    if (!badq.d(BaseApplication.getContext()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,network not support");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    kvq localkvq = a(paramInt2, paramString);
    if (localkvq == null) {
      localkvq = a();
    }
    for (;;)
    {
      l(false);
      if ((localkvq.jdField_i_of_type_Int == 1011) || (localkvq.jdField_i_of_type_Int == 21)) {
        a(paramLong, 15000L);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (paramInt1 == 0) {
        paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, c(), 0, paramInt2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "acceptRequest, result[" + paramInt1 + "], peerUin[" + paramString + "], relationType[" + paramInt2 + "], session[" + localkvq + "]");
        }
        if (paramInt1 == 0)
        {
          localkvq.a("acceptRequest", 3);
          j();
        }
        if (this.jdField_a_of_type_Lbc != null) {
          yds.a(null, "Usr_TV_Video", 4, 0, 0);
        }
        ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
        kyj.a(37);
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
      if (badq.d(BaseApplication.getContext())) {
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
    if ((paramString1.h()) && (paramString1.jdField_d_of_type_JavaLangString != null) && (str.equals(paramString1.jdField_d_of_type_JavaLangString)))
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
      if (paramString1.ag)
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
      ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      kyj.a(28);
      kyj.a(11, str);
      kyj.a(12, 1L);
      if (!paramString1.Q) {
        break label1020;
      }
      l2 = 1L;
      label610:
      kyj.a(13, l2);
      kyj.a(15, 1L);
      K();
      if ((paramString1.jdField_i_of_type_Int != 1011) && (paramString1.jdField_i_of_type_Int != 21)) {
        break label1034;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      paramString1.Q = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label1028;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label738:
      AVReport.a().jdField_o_of_type_Boolean = paramString1.Q;
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
        if (!paramString1.Q) {
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
        paramString1.ae = false;
        a(str, 2, paramString1.jdField_a_of_type_Long);
        a(str, 1, 0L);
        a("deviceMemory", kyj.c() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.a(a()));
        if (this.jdField_a_of_type_Ksq != null) {
          this.jdField_a_of_type_Ksq.b();
        }
        this.jdField_a_of_type_Ksq = new ksq(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
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
            l1 = mfy.a(str);
            if (!TextUtils.isEmpty(paramString6)) {
              paramInt4 = Integer.valueOf(paramString6).intValue();
            }
            if (QLog.isColorLevel()) {
              QLog.d("SDVideo", 2, "request smart tv " + paramInt4);
            }
            paramString1.Q = false;
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
        paramString1.Q = true;
        if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
        {
          paramString10 = ksa.a(paramString10);
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
      paramString1.Q = false;
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
  
  public int a(kvq paramkvq, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramkvq, paramString);
    }
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
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
    ktn localktn = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localktn != null) {
      localktn.c();
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
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getChatRoomID(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getChatRoomId --> VcCtrl is null. PeerUin = " + paramString);
    }
    return 0L;
  }
  
  public long a(kvq paramkvq)
  {
    if (paramkvq == null) {
      return 0L;
    }
    long l1 = paramkvq.b();
    switch (paramkvq.jdField_d_of_type_Int)
    {
    default: 
      return l1;
    }
    return a(paramkvq.jdField_d_of_type_JavaLangString);
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
    return bacm.a(paramBitmap, paramInt1, paramInt1, paramInt2);
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
      kth localkth;
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
          } while (a().jdField_a_of_type_Kvr.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return a().jdField_a_of_type_Kvr.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (a().jdField_a_of_type_Kvr.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return a().jdField_a_of_type_Kvr.jdField_b_of_type_AndroidGraphicsBitmap;
        if (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int != 3) {
          break;
        }
        localkth = a(paramString);
      } while ((localkth == null) || (localkth.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + localkth.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localkth.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((a().jdField_a_of_type_Kvr.jdField_a_of_type_Int != 1) || (a().jdField_a_of_type_Kvr.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return a().jdField_a_of_type_Kvr.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_a_of_type_Ksn.b());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_Ksn.b()))
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
  
  public Pair<Integer, ArrayList<kth>> a()
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
        kth localkth = (kth)((Iterator)localObject4).next();
        localkth.jdField_h_of_type_Boolean = true;
        localArrayList2.add(localkth);
        localHashSet.add(Long.valueOf(localkth.jdField_a_of_type_Long));
      }
    }
    int i1 = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (kth)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((kth)localObject4).jdField_a_of_type_Long)))
      {
        ((kth)localObject4).jdField_h_of_type_Boolean = false;
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
  
  public String a(ArrayList<leb> paramArrayList)
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
  
  public ArrayList<kth> a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    kth localkth;
    while (localIterator.hasNext())
    {
      localkth = (kth)localIterator.next();
      localArrayList.add(localkth);
      localHashSet.add(Long.valueOf(localkth.jdField_a_of_type_Long));
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      localkth = (kth)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(localkth.jdField_a_of_type_Long)))
      {
        localkth.jdField_h_of_type_Boolean = false;
        localArrayList.add(localkth);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<kth> a(int paramInt, ArrayList<kth> paramArrayList)
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
        localObject2 = (kth)paramArrayList.get(i2);
        if (((kth)localObject2).jdField_a_of_type_Long == l2) {
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
      localObject2 = (kth)paramArrayList.get(i2);
      if (((kth)localObject2).jdField_a_of_type_Long == l2) {
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
      long l3 = ((kth)localArrayList1.get(i2)).jdField_a_of_type_Long;
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
      Collections.sort((List)localObject2, new ksz(this));
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
      l2 = ((kth)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
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
      Collections.sort(localArrayList2, new kta(this));
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
      kth localkth;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 >= i2) {
          break label152;
        }
        localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (localkth == null) {
          break label158;
        }
        if (localkth.jdField_a_of_type_Long == paramLong1)
        {
          if (!localkth.jdField_e_of_type_Boolean)
          {
            localkth.jdField_g_of_type_Boolean = paramBoolean;
            localkth.jdField_b_of_type_Long = l1;
            localkth.jdField_c_of_type_Long = paramLong2;
          }
        }
        else
        {
          if (!localkth.jdField_g_of_type_Boolean) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(localkth.jdField_a_of_type_Long));
        }
      }
      if (localkth.jdField_g_of_type_Boolean)
      {
        localkth.jdField_g_of_type_Boolean = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i1 += 1;
      }
    }
  }
  
  public kth a(String paramString)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          kth localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((localkth == null) || (localkth.jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = localkth;
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
  
  public kvq a()
  {
    return this.jdField_a_of_type_Ksn.a();
  }
  
  public lak a()
  {
    return this.jdField_a_of_type_Lak;
  }
  
  public lfi a(Context arg1)
  {
    if (!lfi.a()) {
      return null;
    }
    if ((this.jdField_a_of_type_Lfi == null) && (??? != null)) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Lfi == null)
      {
        this.jdField_a_of_type_Lfi = new lfi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, null);
        this.jdField_a_of_type_Lfi.b();
      }
      return this.jdField_a_of_type_Lfi;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNetWorkTimer");
    }
    if (this.jdField_A_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_A_of_type_Boolean = true;
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_j_of_type_Boolean + "], preSize[" + kzl.jdField_k_of_type_Int + ", " + kzl.jdField_l_of_type_Int + "], seq[" + l1 + "]");
    if (a().jdField_j_of_type_Boolean)
    {
      if ((paramInt1 >= 640) && (paramInt2 >= 480)) {
        break label165;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], w < 640 || h < 480 return.");
    }
    label165:
    while ((kzl.jdField_k_of_type_Int == paramInt1) && (kzl.jdField_l_of_type_Int == paramInt2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1) });
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
      if (((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
      {
        i3 = ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
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
              a((kth)localObject, paramInt1);
              i1 = a().a(paramLong1, 0);
            }
            for (((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;; ((leb)localObject).jdField_a_of_type_Int = paramInt1)
            {
              i1 = 1;
              break;
              localObject = (leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
              leb localleb = new leb();
              localleb.jdField_a_of_type_Long = ((leb)localObject).jdField_a_of_type_Long;
              localleb.jdField_a_of_type_Int = ((leb)localObject).jdField_a_of_type_Int;
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localleb);
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
      ((kvq)localObject).jdField_a_of_type_Kvr.jdField_a_of_type_Int = paramInt2;
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
      ((Intent)localObject).putExtra("guild_group_id", a().jdField_a_of_type_Kvs.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", h());
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_Kvs.jdField_a_of_type_JavaLangString);
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
    //   2: invokestatic 624	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 394	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 18
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 620	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 593	ksn:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 17
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +1867 -> 1895
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 620	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 593	ksn:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 17
    //   45: aload_0
    //   46: getfield 112	com/tencent/av/VideoController:jdField_a_of_type_Ksn	Lksn;
    //   49: aload 17
    //   51: invokevirtual 596	ksn:b	(Ljava/lang/String;)Lkvq;
    //   54: astore 19
    //   56: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 20
    //   67: new 300	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 2079
    //   77: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 386	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 635
    //   87: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 578	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2081
    //   97: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 578	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2083
    //   108: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 17
    //   113: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 657
    //   119: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 386	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2085
    //   130: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 21
    //   135: aload 18
    //   137: ifnull +47 -> 184
    //   140: iconst_1
    //   141: istore 16
    //   143: aload 20
    //   145: iconst_1
    //   146: aload 21
    //   148: iload 16
    //   150: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2087
    //   156: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 19
    //   161: invokevirtual 640	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 312
    //   167: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   197: invokevirtual 2090	com/tencent/av/app/VideoAppInterface:a	()Llad;
    //   200: astore 20
    //   202: aload 20
    //   204: ifnull +10 -> 214
    //   207: aload 20
    //   209: aload 19
    //   211: invokevirtual 2095	lad:a	(Lkvq;)V
    //   214: aload 18
    //   216: invokevirtual 465	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   219: aload_0
    //   220: getfield 229	com/tencent/av/VideoController:jdField_i_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   223: invokevirtual 471	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 229	com/tencent/av/VideoController:jdField_i_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   231: aload_0
    //   232: getfield 203	com/tencent/av/VideoController:jdField_f_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   235: ifnull +20 -> 255
    //   238: aload 18
    //   240: invokevirtual 465	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   243: aload_0
    //   244: getfield 203	com/tencent/av/VideoController:jdField_f_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   247: invokevirtual 471	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 203	com/tencent/av/VideoController:jdField_f_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   255: aload_0
    //   256: getfield 217	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   259: ifnull -78 -> 181
    //   262: aload 18
    //   264: iconst_4
    //   265: anewarray 266	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: sipush 203
    //   273: invokestatic 685	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: lload_2
    //   280: invokestatic 620	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_0
    //   287: getfield 114	com/tencent/av/VideoController:jdField_a_of_type_Boolean	Z
    //   290: invokestatic 760	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: aastore
    //   294: dup
    //   295: iconst_3
    //   296: lload 12
    //   298: invokestatic 688	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: aastore
    //   302: invokevirtual 691	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   305: aload_0
    //   306: invokevirtual 407	com/tencent/av/VideoController:a	()Lkvq;
    //   309: getfield 2097	kvq:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   312: invokevirtual 732	java/util/ArrayList:size	()I
    //   315: ifle +21 -> 336
    //   318: aload_0
    //   319: invokevirtual 407	com/tencent/av/VideoController:a	()Lkvq;
    //   322: getfield 673	kvq:ab	Z
    //   325: ifeq +11 -> 336
    //   328: aload_0
    //   329: iconst_2
    //   330: iconst_0
    //   331: iconst_0
    //   332: lconst_0
    //   333: invokevirtual 2099	com/tencent/av/VideoController:a	(IIIJ)V
    //   336: iload_1
    //   337: iconst_2
    //   338: if_icmpne +149 -> 487
    //   341: aload 19
    //   343: getfield 673	kvq:ab	Z
    //   346: ifne +141 -> 487
    //   349: aload 19
    //   351: getfield 2097	kvq:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   354: ifnull +133 -> 487
    //   357: new 791	android/content/Intent
    //   360: dup
    //   361: invokespecial 792	android/content/Intent:<init>	()V
    //   364: astore 20
    //   366: aload 20
    //   368: ldc_w 794
    //   371: invokevirtual 798	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   374: pop
    //   375: aload 20
    //   377: ldc_w 800
    //   380: sipush 411
    //   383: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   386: pop
    //   387: aload 20
    //   389: ldc_w 2101
    //   392: aload_0
    //   393: invokevirtual 407	com/tencent/av/VideoController:a	()Lkvq;
    //   396: getfield 2097	kvq:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   399: invokevirtual 2104	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   402: pop
    //   403: aload 20
    //   405: ldc_w 810
    //   408: aload_0
    //   409: invokevirtual 407	com/tencent/av/VideoController:a	()Lkvq;
    //   412: getfield 2106	kvq:C	I
    //   415: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   418: pop
    //   419: aload 20
    //   421: ldc_w 812
    //   424: aload_0
    //   425: invokevirtual 407	com/tencent/av/VideoController:a	()Lkvq;
    //   428: getfield 677	kvq:jdField_g_of_type_Long	J
    //   431: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   434: pop
    //   435: aload 20
    //   437: ldc_w 819
    //   440: aload_0
    //   441: invokevirtual 407	com/tencent/av/VideoController:a	()Lkvq;
    //   444: getfield 670	kvq:jdField_A_of_type_Int	I
    //   447: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   450: pop
    //   451: aload 20
    //   453: ldc_w 821
    //   456: ldc_w 2108
    //   459: invokevirtual 826	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   462: pop
    //   463: aload 20
    //   465: aload 18
    //   467: invokevirtual 830	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   470: invokevirtual 835	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   473: invokevirtual 838	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   476: pop
    //   477: aload 18
    //   479: invokevirtual 830	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   482: aload 20
    //   484: invokevirtual 842	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   487: iload_1
    //   488: bipush 7
    //   490: if_icmpne +10 -> 500
    //   493: aload_0
    //   494: iconst_0
    //   495: iconst_0
    //   496: aconst_null
    //   497: invokevirtual 722	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   500: iload_1
    //   501: bipush 9
    //   503: if_icmpne +29 -> 532
    //   506: aload 19
    //   508: getfield 701	kvq:jdField_a_of_type_Kvr	Lkvr;
    //   511: iconst_0
    //   512: putfield 705	kvr:jdField_b_of_type_Int	I
    //   515: aload_0
    //   516: iconst_0
    //   517: iconst_0
    //   518: aconst_null
    //   519: invokevirtual 722	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   522: aload 19
    //   524: invokevirtual 2109	kvq:b	()V
    //   527: aload 19
    //   529: invokevirtual 2110	kvq:a	()V
    //   532: iload_1
    //   533: bipush 10
    //   535: if_icmpne +13 -> 548
    //   538: aload 19
    //   540: invokevirtual 2109	kvq:b	()V
    //   543: aload 19
    //   545: invokevirtual 2110	kvq:a	()V
    //   548: iload_1
    //   549: iconst_2
    //   550: if_icmpne +990 -> 1540
    //   553: ldc_w 2112
    //   556: aload 19
    //   558: getfield 2114	kvq:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   561: invokevirtual 1042	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   564: ifeq +30 -> 594
    //   567: aconst_null
    //   568: ldc_w 2116
    //   571: ldc 166
    //   573: ldc 166
    //   575: ldc_w 2118
    //   578: ldc_w 2118
    //   581: iconst_0
    //   582: iconst_0
    //   583: ldc 166
    //   585: ldc 166
    //   587: ldc 166
    //   589: ldc 166
    //   591: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_0
    //   595: invokevirtual 2119	com/tencent/av/VideoController:h	()Z
    //   598: ifeq +30 -> 628
    //   601: aconst_null
    //   602: ldc_w 2116
    //   605: ldc 166
    //   607: ldc 166
    //   609: ldc_w 2121
    //   612: ldc_w 2121
    //   615: iconst_0
    //   616: iconst_0
    //   617: ldc 166
    //   619: ldc 166
    //   621: ldc 166
    //   623: ldc 166
    //   625: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 19
    //   630: getfield 1276	kvq:jdField_j_of_type_Boolean	Z
    //   633: ifeq +38 -> 671
    //   636: aconst_null
    //   637: ldc_w 2116
    //   640: ldc 166
    //   642: ldc 166
    //   644: ldc_w 2123
    //   647: ldc_w 2123
    //   650: iconst_0
    //   651: iconst_0
    //   652: ldc 166
    //   654: ldc 166
    //   656: ldc 166
    //   658: ldc 166
    //   660: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload 19
    //   665: getfield 2124	kvq:jdField_l_of_type_Boolean	Z
    //   668: ifeq +842 -> 1510
    //   671: aload_0
    //   672: getfield 231	com/tencent/av/VideoController:jdField_t_of_type_Boolean	Z
    //   675: ifeq +44 -> 719
    //   678: aload_0
    //   679: invokevirtual 2126	com/tencent/av/VideoController:a	()J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifle +35 -> 719
    //   687: aconst_null
    //   688: ldc_w 2116
    //   691: ldc 166
    //   693: ldc 166
    //   695: ldc_w 2128
    //   698: ldc_w 2128
    //   701: iconst_0
    //   702: iconst_0
    //   703: ldc 166
    //   705: ldc 166
    //   707: aload_0
    //   708: invokevirtual 2126	com/tencent/av/VideoController:a	()J
    //   711: invokestatic 2132	mjg:a	(J)Ljava/lang/String;
    //   714: ldc 166
    //   716: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   719: aload_0
    //   720: getfield 217	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   723: lload_2
    //   724: invokevirtual 2135	com/tencent/av/gaudio/QQGAudioCtrl:getNetTrafficSize	(J)J
    //   727: lstore 14
    //   729: iload 4
    //   731: bipush 7
    //   733: if_icmpeq +1165 -> 1898
    //   736: iload 4
    //   738: bipush 20
    //   740: if_icmpne +1149 -> 1889
    //   743: goto +1155 -> 1898
    //   746: aload_0
    //   747: getfield 217	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   750: iload 5
    //   752: invokevirtual 2138	com/tencent/av/gaudio/QQGAudioCtrl:quit	(I)I
    //   755: pop
    //   756: aload_0
    //   757: getfield 659	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   760: ifeq +1093 -> 1853
    //   763: aload 19
    //   765: getfield 731	kvq:jdField_g_of_type_Int	I
    //   768: bipush 9
    //   770: if_icmpne +1083 -> 1853
    //   773: aload 19
    //   775: getfield 740	kvq:ad	Z
    //   778: ifne +1075 -> 1853
    //   781: lconst_0
    //   782: lstore 8
    //   784: aload_0
    //   785: iconst_0
    //   786: putfield 219	com/tencent/av/VideoController:jdField_m_of_type_Boolean	Z
    //   789: aload_0
    //   790: getfield 240	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   793: astore 20
    //   795: aload 20
    //   797: monitorenter
    //   798: aload_0
    //   799: getfield 240	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   802: invokevirtual 732	java/util/ArrayList:size	()I
    //   805: ifne +1078 -> 1883
    //   808: aload_0
    //   809: getfield 659	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   812: ifne +1071 -> 1883
    //   815: aload_0
    //   816: getfield 629	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   819: lconst_0
    //   820: lcmp
    //   821: ifne +1062 -> 1883
    //   824: iconst_1
    //   825: istore 6
    //   827: aload_0
    //   828: getfield 240	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   831: invokevirtual 732	java/util/ArrayList:size	()I
    //   834: istore 7
    //   836: aload_0
    //   837: getfield 240	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   840: invokevirtual 1364	java/util/ArrayList:clear	()V
    //   843: aload 20
    //   845: monitorexit
    //   846: aload_0
    //   847: iconst_0
    //   848: putfield 659	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   851: aload 19
    //   853: iconst_0
    //   854: putfield 662	kvq:T	Z
    //   857: aload_0
    //   858: lconst_0
    //   859: putfield 629	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   862: aload_0
    //   863: getfield 217	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   866: iconst_0
    //   867: putfield 2141	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   870: aload 18
    //   872: invokevirtual 609	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   875: astore 20
    //   877: lconst_0
    //   878: lstore 10
    //   880: aload 20
    //   882: ifnull +10 -> 892
    //   885: aload 20
    //   887: invokestatic 614	mfy:a	(Ljava/lang/String;)J
    //   890: lstore 10
    //   892: aload 20
    //   894: invokestatic 1589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   897: ifne +214 -> 1111
    //   900: new 791	android/content/Intent
    //   903: dup
    //   904: invokespecial 792	android/content/Intent:<init>	()V
    //   907: astore 21
    //   909: aload 21
    //   911: ldc_w 794
    //   914: invokevirtual 798	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   917: pop
    //   918: aload 21
    //   920: ldc_w 800
    //   923: bipush 23
    //   925: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   928: pop
    //   929: aload 21
    //   931: ldc_w 817
    //   934: lload 10
    //   936: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   939: pop
    //   940: aload 21
    //   942: ldc_w 812
    //   945: lload_2
    //   946: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   949: pop
    //   950: aload 21
    //   952: ldc_w 810
    //   955: iload_1
    //   956: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   959: pop
    //   960: aload 21
    //   962: ldc_w 819
    //   965: aload 19
    //   967: getfield 670	kvq:jdField_A_of_type_Int	I
    //   970: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   973: pop
    //   974: aload 21
    //   976: ldc_w 2143
    //   979: lload 8
    //   981: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   984: pop
    //   985: aload 21
    //   987: ldc_w 803
    //   990: aload_0
    //   991: getfield 227	com/tencent/av/VideoController:jdField_s_of_type_Boolean	Z
    //   994: invokevirtual 806	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   997: pop
    //   998: aload 21
    //   1000: ldc_w 2145
    //   1003: iload 4
    //   1005: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1008: pop
    //   1009: aload 21
    //   1011: ldc_w 821
    //   1014: ldc_w 2147
    //   1017: invokevirtual 826	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1020: pop
    //   1021: iload 7
    //   1023: iconst_1
    //   1024: if_icmple +846 -> 1870
    //   1027: aload 21
    //   1029: ldc_w 808
    //   1032: iload 7
    //   1034: iconst_1
    //   1035: isub
    //   1036: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1039: pop
    //   1040: aload 21
    //   1042: aload 18
    //   1044: invokevirtual 830	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1047: invokevirtual 835	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1050: invokevirtual 838	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1053: pop
    //   1054: aload 21
    //   1056: lload 12
    //   1058: invokestatic 2152	min:a	(Landroid/content/Intent;J)V
    //   1061: aload 18
    //   1063: invokevirtual 830	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1066: aload 21
    //   1068: invokevirtual 842	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1071: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq +37 -> 1111
    //   1077: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1080: iconst_1
    //   1081: new 300	java/lang/StringBuilder
    //   1084: dup
    //   1085: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1088: ldc_w 2154
    //   1091: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: lload 12
    //   1096: invokevirtual 386	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1099: ldc_w 312
    //   1102: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokestatic 454	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1111: aload 19
    //   1113: ldc_w 2156
    //   1116: aconst_null
    //   1117: invokevirtual 2158	kvq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: aload 19
    //   1122: aconst_null
    //   1123: putfield 2161	kvq:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1126: aload_0
    //   1127: invokevirtual 2163	com/tencent/av/VideoController:i	()V
    //   1130: aload 19
    //   1132: getfield 854	kvq:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1135: invokevirtual 732	java/util/ArrayList:size	()I
    //   1138: ifle +28 -> 1166
    //   1141: aload 18
    //   1143: iconst_2
    //   1144: anewarray 266	java/lang/Object
    //   1147: dup
    //   1148: iconst_0
    //   1149: bipush 104
    //   1151: invokestatic 685	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1154: aastore
    //   1155: dup
    //   1156: iconst_1
    //   1157: aload 19
    //   1159: getfield 854	kvq:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1162: aastore
    //   1163: invokevirtual 691	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1166: aload 19
    //   1168: getfield 2106	kvq:C	I
    //   1171: iconst_1
    //   1172: if_icmpne +28 -> 1200
    //   1175: aload 18
    //   1177: iconst_2
    //   1178: anewarray 266	java/lang/Object
    //   1181: dup
    //   1182: iconst_0
    //   1183: sipush 410
    //   1186: invokestatic 685	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1189: aastore
    //   1190: dup
    //   1191: iconst_1
    //   1192: lload_2
    //   1193: invokestatic 688	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1196: aastore
    //   1197: invokevirtual 691	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1200: aload 19
    //   1202: getfield 2165	kvq:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   1205: astore 21
    //   1207: aload 19
    //   1209: getfield 2106	kvq:C	I
    //   1212: iconst_1
    //   1213: if_icmpeq +12 -> 1225
    //   1216: aload 19
    //   1218: getfield 2106	kvq:C	I
    //   1221: iconst_2
    //   1222: if_icmpne +44 -> 1266
    //   1225: aload 19
    //   1227: getfield 1276	kvq:jdField_j_of_type_Boolean	Z
    //   1230: ifeq +28 -> 1258
    //   1233: aload 18
    //   1235: iconst_2
    //   1236: anewarray 266	java/lang/Object
    //   1239: dup
    //   1240: iconst_0
    //   1241: bipush 106
    //   1243: invokestatic 685	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1246: aastore
    //   1247: dup
    //   1248: iconst_1
    //   1249: lload 12
    //   1251: invokestatic 688	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1254: aastore
    //   1255: invokevirtual 691	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1258: aload 19
    //   1260: lload 12
    //   1262: iconst_0
    //   1263: invokevirtual 2168	kvq:a	(JZ)V
    //   1266: aload 19
    //   1268: lload 12
    //   1270: invokevirtual 2170	kvq:c	(J)V
    //   1273: aload_0
    //   1274: invokevirtual 2172	com/tencent/av/VideoController:g	()V
    //   1277: lload 12
    //   1279: aload 18
    //   1281: invokestatic 2175	lqb:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1284: iload 6
    //   1286: ifne +46 -> 1332
    //   1289: aload_0
    //   1290: new 300	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1297: ldc_w 2177
    //   1300: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: iload 4
    //   1305: invokevirtual 578	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1308: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1311: aload 17
    //   1313: iload_1
    //   1314: invokestatic 2179	mjg:c	(I)I
    //   1317: aload 20
    //   1319: lload_2
    //   1320: invokestatic 620	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1323: bipush 7
    //   1325: aload 21
    //   1327: iconst_0
    //   1328: iconst_0
    //   1329: invokevirtual 2182	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1332: aload 19
    //   1334: iconst_m1
    //   1335: putfield 448	kvq:jdField_i_of_type_Int	I
    //   1338: aload 19
    //   1340: iconst_m1
    //   1341: putfield 448	kvq:jdField_i_of_type_Int	I
    //   1344: aload 19
    //   1346: iconst_1
    //   1347: putfield 2183	kvq:jdField_o_of_type_Boolean	Z
    //   1350: aload_0
    //   1351: lload 14
    //   1353: putfield 2066	com/tencent/av/VideoController:jdField_b_of_type_Long	J
    //   1356: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1359: ifeq +31 -> 1390
    //   1362: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1365: iconst_2
    //   1366: new 300	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   1373: ldc_w 2185
    //   1376: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: lload 14
    //   1381: invokevirtual 386	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: invokestatic 328	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1390: new 791	android/content/Intent
    //   1393: dup
    //   1394: ldc_w 2072
    //   1397: invokespecial 2074	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1400: astore 19
    //   1402: aload 19
    //   1404: ldc_w 2077
    //   1407: lload 14
    //   1409: invokevirtual 815	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1412: pop
    //   1413: aload 19
    //   1415: aload 18
    //   1417: invokevirtual 830	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1420: invokevirtual 835	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1423: invokevirtual 838	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1426: pop
    //   1427: iload 6
    //   1429: ifne +13 -> 1442
    //   1432: aload 18
    //   1434: invokevirtual 830	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1437: aload 19
    //   1439: invokevirtual 842	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1442: aload_0
    //   1443: getfield 112	com/tencent/av/VideoController:jdField_a_of_type_Ksn	Lksn;
    //   1446: lload 12
    //   1448: aload 17
    //   1450: invokevirtual 2188	ksn:a	(JLjava/lang/String;)Z
    //   1453: istore 16
    //   1455: aload 18
    //   1457: invokestatic 727	mht:a	(Lcom/tencent/av/app/VideoAppInterface;)Lmht;
    //   1460: astore 18
    //   1462: aload 18
    //   1464: ifnull +27 -> 1491
    //   1467: aload 18
    //   1469: invokevirtual 728	mht:a	()Z
    //   1472: ifeq +19 -> 1491
    //   1475: aload 18
    //   1477: aload 17
    //   1479: invokevirtual 770	mht:a	(Ljava/lang/String;)V
    //   1482: iload 16
    //   1484: ifeq +7 -> 1491
    //   1487: aload_0
    //   1488: invokevirtual 730	com/tencent/av/VideoController:c	()V
    //   1491: invokestatic 2191	com/tencent/av/utils/PopupDialog:a	()V
    //   1494: aload_0
    //   1495: iload 5
    //   1497: invokevirtual 2193	com/tencent/av/VideoController:d	(I)V
    //   1500: goto -1319 -> 181
    //   1503: astore 17
    //   1505: aload_0
    //   1506: monitorexit
    //   1507: aload 17
    //   1509: athrow
    //   1510: aconst_null
    //   1511: ldc_w 2116
    //   1514: ldc 166
    //   1516: ldc 166
    //   1518: ldc_w 2195
    //   1521: ldc_w 2195
    //   1524: iconst_0
    //   1525: iconst_0
    //   1526: ldc 166
    //   1528: ldc 166
    //   1530: ldc 166
    //   1532: ldc 166
    //   1534: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1537: goto -866 -> 671
    //   1540: iload_1
    //   1541: iconst_1
    //   1542: if_icmpne -871 -> 671
    //   1545: ldc_w 2112
    //   1548: aload 19
    //   1550: getfield 2114	kvq:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   1553: invokevirtual 1042	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1556: ifeq +40 -> 1596
    //   1559: aload 19
    //   1561: getfield 670	kvq:jdField_A_of_type_Int	I
    //   1564: bipush 10
    //   1566: if_icmpne +167 -> 1733
    //   1569: aconst_null
    //   1570: ldc_w 2116
    //   1573: ldc 166
    //   1575: ldc 166
    //   1577: ldc_w 2197
    //   1580: ldc_w 2197
    //   1583: iconst_0
    //   1584: iconst_0
    //   1585: ldc 166
    //   1587: ldc 166
    //   1589: ldc 166
    //   1591: ldc 166
    //   1593: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1596: aload_0
    //   1597: invokevirtual 2119	com/tencent/av/VideoController:h	()Z
    //   1600: ifeq +40 -> 1640
    //   1603: aload 19
    //   1605: getfield 670	kvq:jdField_A_of_type_Int	I
    //   1608: bipush 10
    //   1610: if_icmpne +153 -> 1763
    //   1613: aconst_null
    //   1614: ldc_w 2116
    //   1617: ldc 166
    //   1619: ldc 166
    //   1621: ldc_w 2199
    //   1624: ldc_w 2199
    //   1627: iconst_0
    //   1628: iconst_0
    //   1629: ldc 166
    //   1631: ldc 166
    //   1633: ldc 166
    //   1635: ldc 166
    //   1637: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1640: aload 19
    //   1642: getfield 1276	kvq:jdField_j_of_type_Boolean	Z
    //   1645: ifeq -974 -> 671
    //   1648: aload 19
    //   1650: getfield 670	kvq:jdField_A_of_type_Int	I
    //   1653: bipush 10
    //   1655: if_icmpne +138 -> 1793
    //   1658: aconst_null
    //   1659: ldc_w 2116
    //   1662: ldc 166
    //   1664: ldc 166
    //   1666: ldc_w 2201
    //   1669: ldc_w 2201
    //   1672: iconst_0
    //   1673: iconst_0
    //   1674: ldc 166
    //   1676: ldc 166
    //   1678: ldc 166
    //   1680: ldc 166
    //   1682: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1685: aload 19
    //   1687: getfield 2124	kvq:jdField_l_of_type_Boolean	Z
    //   1690: ifne -1019 -> 671
    //   1693: aload 19
    //   1695: getfield 670	kvq:jdField_A_of_type_Int	I
    //   1698: bipush 10
    //   1700: if_icmpne +123 -> 1823
    //   1703: aconst_null
    //   1704: ldc_w 2116
    //   1707: ldc 166
    //   1709: ldc 166
    //   1711: ldc_w 2203
    //   1714: ldc_w 2203
    //   1717: iconst_0
    //   1718: iconst_0
    //   1719: ldc 166
    //   1721: ldc 166
    //   1723: ldc 166
    //   1725: ldc 166
    //   1727: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1730: goto -1059 -> 671
    //   1733: aconst_null
    //   1734: ldc_w 2116
    //   1737: ldc 166
    //   1739: ldc 166
    //   1741: ldc_w 2205
    //   1744: ldc_w 2205
    //   1747: iconst_0
    //   1748: iconst_0
    //   1749: ldc 166
    //   1751: ldc 166
    //   1753: ldc 166
    //   1755: ldc 166
    //   1757: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1760: goto -164 -> 1596
    //   1763: aconst_null
    //   1764: ldc_w 2116
    //   1767: ldc 166
    //   1769: ldc 166
    //   1771: ldc_w 2207
    //   1774: ldc_w 2207
    //   1777: iconst_0
    //   1778: iconst_0
    //   1779: ldc 166
    //   1781: ldc 166
    //   1783: ldc 166
    //   1785: ldc 166
    //   1787: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1790: goto -150 -> 1640
    //   1793: aconst_null
    //   1794: ldc_w 2116
    //   1797: ldc 166
    //   1799: ldc 166
    //   1801: ldc_w 2209
    //   1804: ldc_w 2209
    //   1807: iconst_0
    //   1808: iconst_0
    //   1809: ldc 166
    //   1811: ldc 166
    //   1813: ldc 166
    //   1815: ldc 166
    //   1817: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1820: goto -135 -> 1685
    //   1823: aconst_null
    //   1824: ldc_w 2116
    //   1827: ldc 166
    //   1829: ldc 166
    //   1831: ldc_w 2211
    //   1834: ldc_w 2211
    //   1837: iconst_0
    //   1838: iconst_0
    //   1839: ldc 166
    //   1841: ldc 166
    //   1843: ldc 166
    //   1845: ldc 166
    //   1847: invokestatic 1159	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1850: goto -1179 -> 671
    //   1853: aload_0
    //   1854: invokevirtual 2126	com/tencent/av/VideoController:a	()J
    //   1857: lstore 8
    //   1859: goto -1075 -> 784
    //   1862: astore 17
    //   1864: aload 20
    //   1866: monitorexit
    //   1867: aload 17
    //   1869: athrow
    //   1870: aload 21
    //   1872: ldc_w 808
    //   1875: iconst_0
    //   1876: invokevirtual 801	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1879: pop
    //   1880: goto -840 -> 1040
    //   1883: iconst_0
    //   1884: istore 6
    //   1886: goto -1059 -> 827
    //   1889: iconst_0
    //   1890: istore 5
    //   1892: goto -1146 -> 746
    //   1895: goto -1850 -> 45
    //   1898: iload 4
    //   1900: istore 5
    //   1902: goto -1156 -> 746
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1905	0	this	VideoController
    //   0	1905	1	paramInt1	int
    //   0	1905	2	paramLong	long
    //   0	1905	4	paramInt2	int
    //   750	1151	5	i1	int
    //   825	1060	6	i2	int
    //   834	202	7	i3	int
    //   782	1076	8	l1	long
    //   878	57	10	l2	long
    //   5	1442	12	l3	long
    //   727	681	14	l4	long
    //   141	1342	16	bool	boolean
    //   24	1454	17	str	String
    //   1503	5	17	localObject1	Object
    //   1862	6	17	localObject2	Object
    //   11	1465	18	localObject3	Object
    //   54	1640	19	localObject4	Object
    //   133	1738	21	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	1503	finally
    //   31	45	1503	finally
    //   45	135	1503	finally
    //   143	176	1503	finally
    //   195	202	1503	finally
    //   207	214	1503	finally
    //   214	255	1503	finally
    //   255	336	1503	finally
    //   341	487	1503	finally
    //   493	500	1503	finally
    //   506	532	1503	finally
    //   538	548	1503	finally
    //   553	594	1503	finally
    //   594	628	1503	finally
    //   628	671	1503	finally
    //   671	719	1503	finally
    //   719	729	1503	finally
    //   746	781	1503	finally
    //   784	798	1503	finally
    //   846	877	1503	finally
    //   885	892	1503	finally
    //   892	1021	1503	finally
    //   1027	1040	1503	finally
    //   1040	1111	1503	finally
    //   1111	1166	1503	finally
    //   1166	1200	1503	finally
    //   1200	1225	1503	finally
    //   1225	1258	1503	finally
    //   1258	1266	1503	finally
    //   1266	1284	1503	finally
    //   1289	1332	1503	finally
    //   1332	1390	1503	finally
    //   1390	1427	1503	finally
    //   1432	1442	1503	finally
    //   1442	1462	1503	finally
    //   1467	1482	1503	finally
    //   1487	1491	1503	finally
    //   1491	1500	1503	finally
    //   1510	1537	1503	finally
    //   1545	1596	1503	finally
    //   1596	1640	1503	finally
    //   1640	1685	1503	finally
    //   1685	1730	1503	finally
    //   1733	1760	1503	finally
    //   1763	1790	1503	finally
    //   1793	1820	1503	finally
    //   1823	1850	1503	finally
    //   1853	1859	1503	finally
    //   1867	1870	1503	finally
    //   1870	1880	1503	finally
    //   798	824	1862	finally
    //   827	846	1862	finally
    //   1864	1867	1862	finally
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = ksn.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = ksn.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l1 = AudioHelper.b();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], seq[" + l1 + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((kvq)localObject).jdField_j_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
      if ((l()) && ((paramInt2 == 16) || (paramInt2 == 17)))
      {
        if (this.jdField_e_of_type_Boolean) {
          a(paramInt1, paramLong, 70);
        }
        a("onGAudioSDKError_1");
        if ((-19 == paramInt3) || (19 == paramInt3))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
          this.jdField_i_of_type_JavaLangRunnable = null;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(200), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        return;
      }
      int i1 = mjg.c(paramInt1);
      a(a().jdField_c_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        a("onGAudioSDKError_2");
        if (this.jdField_a_of_type_Miu != null) {
          this.jdField_a_of_type_Miu.a(l1);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_a_of_type_Ksn.a(l1, str);
        return;
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        a("onGAudioSDKError", str, i1, (String)localObject, String.valueOf(paramLong), 7, (String)localObject, false, false);
        if (this.jdField_i_of_type_JavaLangRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
          this.jdField_i_of_type_JavaLangRunnable = null;
        }
      }
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    kvq localkvq = a();
    String str = ksn.a(paramInt2, String.valueOf(paramLong2), new int[0]);
    boolean bool = TextUtils.equals(localkvq.jdField_c_of_type_JavaLangString, str);
    long l1 = AudioHelper.b();
    if ((!bool) || (QLog.isDevelopLevel())) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + localkvq.jdField_c_of_type_JavaLangString + "], seq[" + l1 + "]");
    }
    if (!bool) {}
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
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
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    long l1 = AudioHelper.b();
    krx.a("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
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
        break label277;
      }
    }
    label277:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.w((String)localObject2, 2, paramBoolean + "]");
      if (localVideoAppInterface != null) {
        break;
      }
      return;
    }
    paramBoolean = false;
    if ((paramInt3 == 6) || (paramInt3 == 5) || (paramInt3 == 4) || (paramInt3 == 3)) {
      paramBoolean = true;
    }
    if (!baei.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
      return;
    }
    Object localObject3 = ksn.a(paramInt1, String.valueOf(paramLong1), new int[0]);
    if (this.jdField_a_of_type_Ksn.a((String)localObject3))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Ksn.a((String)localObject3, false);
    ((kvq)localObject2).jdField_g_of_type_Long = paramLong1;
    ((kvq)localObject2).C = paramInt1;
    ((kvq)localObject2).jdField_A_of_type_Int = paramInt2;
    ((kvq)localObject2).af = false;
    ((kvq)localObject2).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    if (this.jdField_a_of_type_Ksn.a() >= 2)
    {
      a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    kst.jdField_b_of_type_Boolean = localVideoAppInterface.b();
    paramBoolean = false;
    if (!((kvq)localObject1).d()) {
      paramBoolean = true;
    }
    for (;;)
    {
      if (this.jdField_g_of_type_JavaLangRunnable != null)
      {
        if (localVideoAppInterface.a() != null) {
          localVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
        }
        this.jdField_g_of_type_JavaLangRunnable = null;
        ((kvq)localObject2).a("onGAudioInvite.1", 0);
      }
      K();
      bool = a(localVideoAppInterface.getApp().getApplicationContext());
      if (!bool) {
        break label785;
      }
      if ((((kvq)localObject1).jdField_g_of_type_Int <= 0) || (((kvq)localObject1).jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
        break;
      }
      a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
      if (localVideoAppInterface.e()) {
        paramBoolean = true;
      }
    }
    if (7 == ((kvq)localObject1).jdField_g_of_type_Int)
    {
      a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
    {
      a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((((kvq)localObject1).jdField_g_of_type_Int == 14) || (((kvq)localObject1).jdField_g_of_type_Int == 13))
    {
      a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((((kvq)localObject1).jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) && (((kvq)localObject1).jdField_a_of_type_Kvr.jdField_a_of_type_Int == 1))
    {
      a(l1, "ScreenLocked_in_random", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    if ((paramBoolean) && (paramInt3 != 3))
    {
      a(l1, "ScreenLocked_session_exist", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
    }
    label785:
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + ((kvq)localObject1).jdField_a_of_type_Kvr.jdField_b_of_type_Int + "], chatType[" + ((kvq)localObject1).jdField_a_of_type_Kvr.jdField_a_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
    }
    if (((kvq)localObject2).jdField_d_of_type_Int == 0)
    {
      ((kvq)localObject2).jdField_e_of_type_Boolean = true;
      ((kvq)localObject2).a(l1, "onGAudioInvite.1", 3);
      ((kvq)localObject2).jdField_i_of_type_Int = mjg.c(paramInt1);
      ((kvq)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong2);
      if (paramInt1 == 2) {
        ((kvq)localObject2).jdField_r_of_type_JavaLangString = String.valueOf(paramLong2);
      }
      ((kvq)localObject2).jdField_e_of_type_Boolean = true;
      if ((paramInt3 != 3) && (paramInt3 != 4)) {
        a((String)localObject3, ((kvq)localObject2).jdField_d_of_type_Int, false, false, false);
      }
    }
    this.jdField_d_of_type_Long = paramLong1;
    this.jdField_n_of_type_Int = paramInt1;
    if (((kvq)localObject2).jdField_g_of_type_Int == 0) {
      ((kvq)localObject2).a("onGAudioInvite", 7);
    }
    boolean bool = false;
    if ((paramInt3 == 3) && (((kvq)localObject1).jdField_g_of_type_Long == 0L)) {
      bool = a((kvq)localObject1, (kvq)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
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
        break label1390;
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
      paramArrayOfLong.putExtra("extraUin", ((kvq)localObject1).jdField_f_of_type_JavaLangString);
      paramArrayOfLong.putExtra("discussId", paramLong1);
      paramArrayOfLong.putExtra("type", 13);
      paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("isSender", false);
      paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
      paramArrayOfLong.putExtra("realSenderUin", ((kvq)localObject1).jdField_r_of_type_JavaLangString);
      localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
      a(l1, this.jdField_n_of_type_Int, paramLong1, true);
      new bedr(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      this.jdField_a_of_type_Ksn.a(l1, (String)localObject3);
      return;
      if (paramInt3 == 4) {
        bool = b((kvq)localObject1, (kvq)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
      }
    }
    label1390:
    ((kvq)localObject1).jdField_r_of_type_JavaLangString = ("" + paramLong2);
    this.jdField_t_of_type_Boolean = a();
    if (((kvq)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite msg blocked [" + ((kvq)localObject2).jdField_c_of_type_JavaLangString + "]");
      }
      if (!localVideoAppInterface.jdField_c_of_type_Boolean) {
        break label1769;
      }
      localVideoAppInterface.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      localVideoAppInterface.jdField_d_of_type_Boolean = true;
      return;
      if ((paramBoolean) || (ktr.a()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        baen.d();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", mjg.c(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((kvq)localObject2).jdField_c_of_type_JavaLangString);
        if ((!this.jdField_t_of_type_Boolean) || (!lor.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1760;
        }
        if ((!paramBoolean) && (!ktr.a())) {
          break label1728;
        }
        paramArrayOfLong = new ltr(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.d();
        paramArrayOfLong.a((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1728:
      paramArrayOfLong = new lzv(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.d();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1760:
      a((Intent)localObject1);
      break;
      label1769:
      kyj.a();
    }
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    paramVarArgs = ksn.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_Ksn.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = ksn.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      kvq localkvq = this.jdField_a_of_type_Ksn.b(paramVarArgs);
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l1 + "], \nsession[" + localkvq + "]");
      }
      int i1;
      if ((localkvq != null) && ((localkvq.jdField_g_of_type_Int == 7) || (localkvq.jdField_g_of_type_Int == 2)))
      {
        localkvq.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_Ksn.a(paramVarArgs))
        {
          localkvq = this.jdField_a_of_type_Ksn.b(paramVarArgs);
          i1 = mjg.c(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(localkvq.jdField_c_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Ksn.a(l1, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, localkvq.jdField_r_of_type_JavaLangString, true, false);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Ksn == null) || (a() == null) || (a().jdField_d_of_type_JavaLangString == null)) {}
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
      Object localObject1 = this.jdField_a_of_type_Ksn;
      localObject1 = this.jdField_a_of_type_Ksn;
      localObject1 = ksn.a(ksn.a(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_a_of_type_Ksn.b((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((kvq)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((kvq)localObject1).jdField_d_of_type_JavaLangString)) && (((kvq)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((kvq)localObject1).x);
      ((Intent)localObject2).putExtra("bindId", ((kvq)localObject1).jdField_o_of_type_JavaLangString);
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
    boolean bool3 = c(paramString1);
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
    kst.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i2 = mhx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i2 + ",sdkAVAccostType = " + paramInt1 + "|" + kst.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
    }
    localObject = a();
    if (this.jdField_a_of_type_Ksn.a() >= 2)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->pending session exists");
      i1 = -1;
      str = null;
      if (localObject != null)
      {
        i1 = ((kvq)localObject).jdField_i_of_type_Int;
        str = ((kvq)localObject).jdField_d_of_type_JavaLangString;
      }
      if ((i2 == 1011) && (i1 == 1011) && (str != null) && (str.equals(paramString1))) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->pending session exists, equals to the current one.");
      }
    }
    else
    {
      str = ksn.a(3, paramString1, new int[0]);
      if ((!TextUtils.equals(str, ((kvq)localObject).jdField_c_of_type_JavaLangString)) || (!((kvq)localObject).jdField_d_of_type_Boolean)) {
        break label499;
      }
      ((kvq)localObject).jdField_e_of_type_Boolean = true;
      paramInt1 = 1;
      if (((kvq)localObject).Q) {
        paramInt1 = 0;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((kvq)localObject).C);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->pending session exists, just reject.");
    a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
    return;
    label499:
    boolean bool2 = false;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((i2 != 21) && (i2 != 1011) && ((((kvq)localObject).jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (((kvq)localObject).jdField_a_of_type_Kvr.jdField_a_of_type_Int == 1))
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
      this.jdField_a_of_type_Ksn.a(str, false);
      localObject = this.jdField_a_of_type_Ksn.b(str);
      ((kvq)localObject).x = paramInt2;
      ((kvq)localObject).jdField_o_of_type_JavaLangString = paramString3;
      ((kvq)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((kvq)localObject).y = i2;
      if (this.jdField_g_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
        this.jdField_g_of_type_JavaLangRunnable = null;
        ((kvq)localObject).a("onRequestVideo.1", 0);
      }
      if (this.jdField_a_of_type_Lbc == null) {
        break label1913;
      }
    }
    label770:
    label1599:
    label1604:
    label1612:
    label1913:
    for (int i1 = 9500;; i1 = i2)
    {
      this.jdField_a_of_type_Boolean = true;
      ((kvq)localObject).Q = paramBoolean;
      label889:
      long l3;
      if (paramBoolean)
      {
        ((kvq)localObject).jdField_f_of_type_Int = 1;
        l1 = a(paramString1);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  ,roomId = " + l1);
        ((kvq)localObject).d(l1);
        ((kvq)localObject).jdField_i_of_type_Int = i1;
        ((kvq)localObject).jdField_j_of_type_Int = paramInt1;
        ((kvq)localObject).jdField_d_of_type_JavaLangString = paramString1;
        ((kvq)localObject).jdField_f_of_type_JavaLangString = paramString2;
        ((kvq)localObject).jdField_e_of_type_Boolean = true;
        ((kvq)localObject).a("onRequestVideo.2", 2);
        ((kvq)localObject).jdField_p_of_type_Int = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!paramBoolean) {
          break label1599;
        }
        paramInt1 = 1;
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        l3 = a(paramString1);
        kyj.a(l3, 36);
        kyj.a(l3, 9, ((kvq)localObject).b());
        kyj.a(l3, 11, paramString1);
        kyj.a(l3, 12, 2L);
        if (!((kvq)localObject).Q) {
          break label1604;
        }
      }
      for (long l1 = 1L;; l1 = 2L)
      {
        kyj.a(l3, 13, l1);
        kyj.a(l3, 15, 1L);
        z(paramString1);
        if (!bool3) {
          break label1612;
        }
        ((kvq)localObject).jdField_c_of_type_Boolean = true;
        b(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((kvq)localObject).jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) && (((kvq)localObject).jdField_a_of_type_Kvr.jdField_a_of_type_Int == 3))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in Random mulit");
          if (bool4)
          {
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break;
        }
        if (((kvq)localObject).d())
        {
          if (i2 == -1)
          {
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString1, c());
            QLog.w(jdField_a_of_type_JavaLangString, 1, "closeVideo uinType == -1");
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString1, 0);
            return;
          }
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
            break;
          }
          bool1 = true;
          break;
        }
        if ((((kvq)localObject).m()) || (((kvq)localObject).n()))
        {
          b(((kvq)localObject).jdField_d_of_type_JavaLangString, 2);
          bool1 = bool2;
          break;
        }
        if (((((kvq)localObject).jdField_g_of_type_Int == 7) && (this.jdField_d_of_type_Long != 0L)) || (((kvq)localObject).jdField_g_of_type_Int == 14) || (((kvq)localObject).jdField_g_of_type_Int == 13))
        {
          if (bool4)
          {
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break;
        }
        if (!this.jdField_e_of_type_Boolean)
        {
          if (((i2 == 21) || (i2 == 1011)) && (a().jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString != null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  auto Accept");
            if ((((kvq)localObject).jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString != null) && (!((kvq)localObject).jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString.equals(paramString1)))
            {
              a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            a(l2, 30000L);
            bool1 = bool2;
            break;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool4);
          bool1 = true;
          if ((((kvq)localObject).jdField_d_of_type_JavaLangString != null) && (paramString1.equals(((kvq)localObject).jdField_d_of_type_JavaLangString)))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when request: fromUin = " + paramString1);
            G();
            z(paramString1);
            return;
          }
          if (!bool4) {
            break;
          }
          a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.jdField_e_of_type_Boolean) || (((kvq)localObject).jdField_g_of_type_Int == 8))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in group chat, fromUin = " + paramString1);
          if (bool4)
          {
            a(l2, false, i2, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break;
        }
        bool1 = bool2;
        if (((kvq)localObject).jdField_g_of_type_Int != 1) {
          break;
        }
        bool1 = bool2;
        if (((kvq)localObject).jdField_d_of_type_JavaLangString == null) {
          break;
        }
        bool1 = bool2;
        if (!paramString1.equals(((kvq)localObject).jdField_d_of_type_JavaLangString)) {
          break;
        }
        return;
        ((kvq)localObject).jdField_f_of_type_Int = 2;
        break label770;
        paramInt1 = 2;
        break label889;
      }
      if ((!this.jdField_e_of_type_Boolean) && (((kvq)localObject).jdField_i_of_type_Int != 21) && (((kvq)localObject).jdField_i_of_type_Int != 1011)) {
        a(str, ((kvq)localObject).jdField_f_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_t_of_type_Int + ", isQQPaused: " + kst.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
      }
      if ((this.y) && (this.jdField_t_of_type_Int == 0) && (!bool4) && (kst.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.6(this, l2, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_Ksq != null) {
        this.jdField_a_of_type_Ksq.b();
      }
      this.jdField_a_of_type_Ksq = new ksq(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      a(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt, ArrayList<ldd> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      ldd localldd = (ldd)paramArrayList.get(i1);
      a(localldd.jdField_a_of_type_Long, localldd.jdField_a_of_type_Int, localldd.jdField_b_of_type_Int, false);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void a(int paramInt, mcy parammcy)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + parammcy);
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMcy == null) {
      this.jdField_a_of_type_ArrayOfMcy = new mcy[2];
    }
    this.jdField_a_of_type_ArrayOfMcy[paramInt] = parammcy;
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
    miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    kvq localkvq = a();
    k();
    localkvq.a("onSubState2", 4);
    localkvq.a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!localkvq.jdField_g_of_type_Boolean) {
        break label219;
      }
      a(true, localkvq.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, paramLong), 50L);
      a(localkvq.jdField_c_of_type_JavaLangString, localkvq.jdField_d_of_type_Int, true, true, true);
      mga.i(this);
      mga.c(this, true);
      mga.b(this, true);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        lad locallad = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (locallad != null) {
          locallad.a(localkvq);
        }
      }
      return;
      c();
      break;
      label219:
      a(false, localkvq.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioMicSetByAdmin, manager uin[" + paramLong + "], old micAuthByAdmin[" + a().E + "], new micAuthByAdmin[" + paramInt + "], mIsMicOffBySelf[" + this.jdField_v_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    a().c("onGAudioMicSetByAdmin", paramInt);
    if (paramInt == 2) {
      return;
    }
    long l1;
    boolean bool1;
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (paramInt != 0) || (paramLong == 0L))
    {
      l1 = this.jdField_a_of_type_Long;
      if (paramInt != 0) {
        break label200;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() != paramLong) {
        break label206;
      }
    }
    label200:
    label206:
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
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioKickOut, Groupid[" + paramLong + "], relationType[" + paramInt1 + "], seq[" + l1 + "]");
    paramInt2 = mjg.c(paramInt1);
    if ((this.jdField_e_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.w = true;
      if (paramInt1 != 3) {
        break label274;
      }
      a(a().jdField_c_of_type_JavaLangString, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      paramInt1 = 7;
      if (paramInt2 != 3000) {
        break label302;
      }
      awqx.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().I) {
        awqx.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      kvq localkvq = a();
      if ((localkvq != null) && (localkvq.jdField_j_of_type_Boolean)) {
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
        if (a().jdField_A_of_type_Int == 10) {
          awqx.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          awqx.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
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
      this.jdField_a_of_type_Miu.b(paramLong);
      if (!this.jdField_a_of_type_Miu.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        krx.d(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_d_of_type_JavaLangString, 212);
        b(212);
        b(a().jdField_d_of_type_JavaLangString, a().w);
      }
    } while (!a().jdField_R_of_type_Boolean);
    krx.d(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
    a(a().jdField_d_of_type_JavaLangString, 213);
    b(213);
    b(a().jdField_d_of_type_JavaLangString, a().w);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = a(paramLong, paramInt1, paramInt2, paramBoolean);
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (this.jdField_m_of_type_Boolean != paramBoolean) && (QLog.isColorLevel())) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "uin = " + paramLong + "mGAudioMute = " + this.jdField_m_of_type_Boolean + "  isMicOff = " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (bool)) {
      a(0L, false, 0L);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, -1, false);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    miu.a().b();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = ksn.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_a_of_type_Ksn.b(str1);
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
      str1 = ksn.a(paramInt1, String.valueOf(paramLong2), new int[0]);
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
    ((kvq)localObject).af = true;
    int i1 = 4;
    label277:
    String str2;
    if (((kvq)localObject).jdField_g_of_type_Int == 7)
    {
      ((kvq)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        i();
        paramInt2 = mjg.c(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((kvq)localObject).jdField_c_of_type_JavaLangString, mjg.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((kvq)localObject).jdField_g_of_type_Long), 5, ((kvq)localObject).jdField_r_of_type_JavaLangString, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_Ksn.a(paramLong1, str1);
      localObject = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mht)localObject).a())) {
        break;
      }
      ((mht)localObject).a(str1);
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
        a("ignoreGAudioChat_2", str1, paramInt2, ((kvq)localObject).jdField_d_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((kvq)localObject).jdField_r_of_type_JavaLangString, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i1, ((kvq)localObject).jdField_r_of_type_JavaLangString, paramBoolean, false);
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
        break label422;
      }
      i1 = 1;
      awqx.b(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i1, 0, "", "", "", "");
      if (paramArrayList == null) {
        break label609;
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
      localObject1 = ksn.a(i2, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_a_of_type_Ksn.a((String)localObject1, false);
      i3 = ((kvq)localObject2).jdField_d_of_type_Int;
      ((kvq)localObject1).a(paramLong1, ((kvq)localObject2).jdField_j_of_type_Boolean);
      ((kvq)localObject1).jdField_g_of_type_Boolean = ((kvq)localObject2).jdField_g_of_type_Boolean;
      ((kvq)localObject1).a("switchToMultiAudio", ((kvq)localObject2).N);
      ((kvq)localObject1).a("switchToMultiAudio", ((kvq)localObject2).jdField_p_of_type_JavaLangString);
      ((kvq)localObject1).jdField_d_of_type_JavaLangString = ((kvq)localObject2).jdField_d_of_type_JavaLangString;
      ((kvq)localObject1).jdField_A_of_type_Int = i1;
      ((kvq)localObject1).aA = true;
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      if (!((kvq)localObject2).I) {
        break label428;
      }
      boolean bool = this.jdField_m_of_type_Boolean;
      a(paramLong1, Long.valueOf(((kvq)localObject2).jdField_d_of_type_JavaLangString).longValue(), true, 0);
      this.jdField_m_of_type_Boolean = bool;
    }
    for (this.jdField_f_of_type_Int = 2;; this.jdField_f_of_type_Int = 1)
    {
      if (!paramArrayList.contains(((kvq)localObject2).jdField_d_of_type_JavaLangString)) {
        paramArrayList.add(((kvq)localObject2).jdField_d_of_type_JavaLangString);
      }
      localObject2 = new long[paramArrayList.size()];
      paramArrayList = paramArrayList.iterator();
      i1 = 0;
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label474;
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
      label422:
      i1 = 2;
      break label92;
      label428:
      a(((kvq)localObject2).jdField_d_of_type_JavaLangString, 1);
      b(214);
      b(((kvq)localObject2).jdField_d_of_type_JavaLangString, 21);
    }
    label474:
    if (i1 == localObject2.length)
    {
      ((kvq)localObject1).jdField_a_of_type_ArrayOfLong = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((kvq)localObject1).w = -1;
      if (i3 != 1) {
        break label651;
      }
      ((kvq)localObject1).a(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((kvq)localObject1).jdField_i_of_type_Int = paramInt;
      ((kvq)localObject1).jdField_g_of_type_Long = paramLong2;
      ((kvq)localObject1).b("switchToMultiAudio", mfs.a(paramInt));
      ((kvq)localObject1).B = 0;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label609:
      return;
      ((kvq)localObject1).jdField_a_of_type_ArrayOfLong = new long[i1];
      i2 = 0;
      while (i2 < i1)
      {
        ((kvq)localObject1).jdField_a_of_type_ArrayOfLong[i2] = localObject2[i2];
        i2 += 1;
      }
      break;
      label651:
      if (i3 == 2) {
        ((kvq)localObject1).a(paramLong1, "switchToMultiAudio.2", 4);
      } else if (i3 == 3) {
        ((kvq)localObject1).a(paramLong1, "switchToMultiAudio.3", 3);
      } else if (i3 == 4) {
        ((kvq)localObject1).a(paramLong1, "switchToMultiAudio.4", 3);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    a(paramLong1, paramInt, paramLong2, -1, paramBoolean);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    boolean bool;
    GraphicRenderMgr localGraphicRenderMgr;
    if ((paramInt == 4) || (paramInt == 3))
    {
      bool = true;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "setEncodeDecodePtr, sessionType[" + paramInt + "], clean[" + paramBoolean1 + "], isRemote[" + paramBoolean2 + "], isMultiEngine[" + bool + "], seq[" + paramLong + "]");
      localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      if (!bool) {
        break label256;
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (!paramBoolean2) {
          break label230;
        }
        if (!paramBoolean1) {
          break label194;
        }
        if (localGraphicRenderMgr.decoderPtrRef > 0) {
          localGraphicRenderMgr.decoderPtrRef -= 1;
        }
        if (localGraphicRenderMgr.decoderPtrRef == 0) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0);
        }
      }
    }
    label194:
    label230:
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      do
      {
        return;
        if (((paramInt == 2) || (paramInt == 1)) && (a().I))
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
    label256:
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
    String str = ksn.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_a_of_type_Ksn.b(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((kvq)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((kvq)localObject).jdField_d_of_type_JavaLangString, ((kvq)localObject).jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((kvq)localObject).jdField_A_of_type_Int);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_Ksn.a(paramLong1, str);
      localObject = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mht)localObject).a())) {
        break;
      }
      ((mht)localObject).a(str);
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
    kth localkth = a(String.valueOf(paramLong2));
    if (localkth == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    localkth.jdField_d_of_type_Boolean = false;
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
      a().aa = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
    a().aa = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      this.jdField_i_of_type_JavaLangRunnable = null;
      a().a("onGroupSecurityLimit", 0);
      a(1, paramLong1, 17, 0);
    }
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<ldv> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.26(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramBoolean);
    localNewIntent.putExtra("groupuin", paramLong1);
    localNewIntent.putExtra("groupcode", paramLong2);
    localNewIntent.putExtra("reqType", 13);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, relationId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    String str = ksn.a(100, String.valueOf(paramLong2), new int[0]);
    kvq localkvq = this.jdField_a_of_type_Ksn.b(str);
    if (localkvq == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", localkvq.jdField_A_of_type_Int);
    localIntent.putExtra("from", "VideoController6");
    min.a(localIntent, paramLong1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a(str, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (localkvq.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      localkvq.J = false;
      localkvq.I = false;
      return;
    }
    localkvq.a("quitDoubleVideoMeeting", 15);
    a(paramLong1, 2131230741, 1, this.jdField_c_of_type_Kti);
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
    String str = ksn.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_Ksn.a(str)) {}
    for (kvq localkvq = this.jdField_a_of_type_Ksn.b(str); localkvq == null; localkvq = this.jdField_a_of_type_Ksn.b(str))
    {
      krx.e(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = ksn.a(100, paramString, new int[0]);
    }
    localkvq.jdField_d_of_type_Boolean = false;
    if ((q()) && (paramString != null) && (!paramString.equals(localkvq.jdField_d_of_type_JavaLangString)))
    {
      krx.d(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + localkvq.jdField_d_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Ksq != null)
    {
      this.jdField_a_of_type_Ksq.b();
      this.jdField_a_of_type_Ksq = null;
    }
    this.jdField_i_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    k();
    if ((localkvq.jdField_d_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(paramLong, str, paramString, 3);
      label296:
      if (!localkvq.h()) {
        break label440;
      }
      localkvq.w = paramInt;
      if ((localkvq.h()) && (paramInt == localkvq.jdField_d_of_type_Int)) {
        localkvq.a(paramLong, 0L);
      }
      localkvq.a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(localkvq.jdField_d_of_type_JavaLangString, localkvq.w);
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
        if (localkvq.f())
        {
          localkvq.w = paramInt;
          localkvq.a(paramLong, 0L);
          int i2 = 2131230741;
          switch (paramInt)
          {
          default: 
            i1 = 0;
            this.jdField_a_of_type_Kti.jdField_a_of_type_Long = paramLong;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a(paramLong, i2, i1, this.jdField_a_of_type_Kti);
            localkvq.a("onCloseVideo.isInviting1", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            awqx.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            if (l()) {
              break;
            }
            if (localkvq.jdField_d_of_type_Long != 2L)
            {
              awqx.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230740;
              break label531;
            }
            i2 = 2131230741;
            i1 = 1;
            break label531;
            this.jdField_b_of_type_Kti.jdField_a_of_type_Long = paramLong;
            a(paramLong, 2131230741, 1, this.jdField_b_of_type_Kti);
            localkvq.a("onCloseVideo.isInviting", 6);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (l()) {
              break;
            }
            awqx.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            i2 = 2131230740;
            i1 = 0;
            break label531;
          }
        }
        label531:
        if (!localkvq.m())
        {
          localkvq.w = paramInt;
          if (localkvq.h()) {
            localkvq.a(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (localkvq.jdField_i_of_type_Int == 1011))
          {
            localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label1080;
            }
            a(6, 0, null);
            label950:
            mht localmht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label1097;
            }
            if (localmht != null) {
              localmht.a();
            }
          }
          label976:
          localkvq.a("onCloseVideo.isClosing1", 6);
          if ((!q()) && (!mhj.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label1104;
          }
          a(localkvq.jdField_d_of_type_JavaLangString, 209);
          b(209);
          b(localkvq.jdField_d_of_type_JavaLangString, localkvq.w);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1080:
      a(localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int, 0, null);
      break label950;
      label1097:
      c();
      break label976;
      label1104:
      this.jdField_b_of_type_Kti.jdField_a_of_type_Long = paramLong;
      a(paramLong, 2131230741, 1, this.jdField_b_of_type_Kti);
      mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_t_of_type_Boolean = a();
    boolean bool3 = lor.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.jdField_t_of_type_Boolean + "], isFloatWindowOpAllowedOnBackground[" + bool3 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l1 + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!lba.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
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
      kvq localkvq = this.jdField_a_of_type_Ksn.b(paramString1);
      if (localkvq == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      localkvq.jdField_e_of_type_Boolean = true;
      localkvq.Q = paramBoolean1;
      localkvq.a("processVideoRequest.1", 2);
      localkvq.ae = false;
      localkvq.jdField_k_of_type_Long = System.currentTimeMillis();
      AVReport.a().jdField_o_of_type_Boolean = localkvq.Q;
      bool1 = false;
      if ((paramBoolean3) || (ktr.a()))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("relationType", mjg.b(paramInt1));
        ((Intent)localObject).putExtra("session_id", paramString1);
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.jdField_i_of_type_Int);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_Kvs.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_Kvs.jdField_a_of_type_Long > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label705;
        }
        h();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString)) {
          break label662;
        }
        localkvq.jdField_d_of_type_JavaLangString = paramString2;
        a(paramLong, localkvq.jdField_d_of_type_JavaLangString, 0, 4);
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
        if (azyg.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
        {
          localIntent.addFlags(262144);
          localObject = localIntent;
          bool1 = bool2;
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean = true;
      localkvq.a("processVideoRequest.2", 0);
      localkvq.jdField_i_of_type_Int = paramInt1;
      localkvq.jdField_d_of_type_JavaLangString = paramString2;
      return;
      if (!localkvq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
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
        if ((paramBoolean3) || (ktr.a()))
        {
          paramString1 = new ltr(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
          paramString1.d();
          paramString1.a((Intent)localObject);
        }
        for (;;)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest startActivity when GameMode");
          a("mode", "1");
          a(paramString2);
          a(paramString2, "screenState", String.valueOf(1));
          break;
          paramString1 = new lzv(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
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
    this.jdField_a_of_type_Miu.b(paramLong);
    localObject = this.jdField_a_of_type_Miu;
    miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 10, 1L);
      if ((a().jdField_d_of_type_JavaLangString == null) || (!a().jdField_d_of_type_JavaLangString.equals(paramString))) {
        break label278;
      }
      kyj.a(a().b(), 38);
    }
    for (i1 = paramInt;; i1 = paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      i();
      k();
      if (this.jdField_a_of_type_Lbc == null) {
        break;
      }
      yds.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label278:
      kyj.a(a(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    kvq localkvq = this.jdField_a_of_type_Ksn.b(paramString1);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + localkvq + "]", new Throwable("打印调用栈"));
    int i1;
    String str;
    if ((localkvq != null) && ((!localkvq.ae) || (localkvq.jdField_c_of_type_Boolean)))
    {
      i1 = this.jdField_a_of_type_Ksn.b(paramString1).jdField_i_of_type_Int;
      str = localkvq.jdField_f_of_type_JavaLangString;
      if ((TextUtils.isEmpty(localkvq.jdField_d_of_type_JavaLangString)) || (!localkvq.jdField_d_of_type_JavaLangString.contains(paramString2))) {
        break label430;
      }
      paramString2 = localkvq.jdField_d_of_type_JavaLangString;
    }
    label430:
    for (;;)
    {
      if (this.jdField_a_of_type_Lbc != null)
      {
        i1 = 9500;
        if (((localkvq.x != 1) || (TextUtils.isEmpty(localkvq.jdField_o_of_type_JavaLangString))) || (this.x)) {
          i1 = 0;
        }
      }
      boolean bool = false;
      if (localkvq.jdField_f_of_type_Int == 2) {
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
        a("sendDoubleChatMsgToMQQ_1", paramString1, i1, paramString2, str, 1, a().jdField_r_of_type_JavaLangString, false, true);
      }
      for (;;)
      {
        localkvq.ae = true;
        localkvq.jdField_c_of_type_Boolean = false;
        return;
        if (!localkvq.jdField_c_of_type_Boolean) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        label358:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_Ksn.b(paramString1).jdField_r_of_type_JavaLangString, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_Ksn.b(paramString1).jdField_r_of_type_JavaLangString, false, true);
        }
      }
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, mjg.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_Ksn.a(paramLong, paramString2);
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
  
  public void a(long paramLong, ArrayList<ldd> paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      kth localkth = new kth();
      localkth.jdField_a_of_type_Long = ((ldd)paramArrayList.get(i1)).jdField_a_of_type_Long;
      localkth.jdField_c_of_type_Int = ((ldd)paramArrayList.get(i1)).jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(localkth);
      if (((ldd)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) {
        localArrayList.add(Long.valueOf(((ldd)paramArrayList.get(i1)).jdField_a_of_type_Long));
      }
      i1 += 1;
    }
    if (localArrayList.size() > 0) {
      a(localArrayList);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList<leb> paramArrayList, int paramInt, boolean paramBoolean)
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
            if (((leb)paramArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
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
          if (paramInt == ((leb)paramArrayList.get(i1)).jdField_a_of_type_Int)
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
  
  public void a(long paramLong, ArrayList<leb> paramArrayList1, ArrayList<leb> paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList1.size()) {
        if (((leb)paramArrayList1.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            a(paramArrayList1, i1);
            a(paramLong, paramArrayList2, paramInt, paramBoolean);
            return;
          }
          if (paramInt == ((leb)paramArrayList1.get(i1)).jdField_a_of_type_Int)
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
      localObject = (kth)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((kth)localObject).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((kth)localObject).jdField_a_of_type_Long);
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
      str = ksn.a(100, paramString1, new int[0]);
      kvq localkvq2 = this.jdField_a_of_type_Ksn.b(str);
      kvq localkvq1 = localkvq2;
      if (localkvq2 == null) {
        localkvq1 = this.jdField_a_of_type_Ksn.a(str, false);
      }
      localkvq1.jdField_i_of_type_Int = paramInt1;
      localkvq1.x = paramInt2;
      localkvq1.jdField_o_of_type_JavaLangString = paramString3;
      localkvq1.jdField_e_of_type_Boolean = true;
      paramInt1 = localkvq1.jdField_i_of_type_Int;
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
        l1 = mfy.a(paramString1);
        a(paramLong, 3, l1);
        ksn.a().a(paramLong, str);
        return;
        str = ksn.a(3, paramString1, new int[0]);
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
        awqx.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      awqx.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomMicModeChanged, manager uin[" + paramLong + "], old isRoomMicOff[" + a().U + "], new isRoomMicOff[" + paramBoolean1 + "], mIsMicOffBySelf[" + this.jdField_v_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], isCreateRoomOrEnterRoom[" + paramBoolean2 + "]");
    a().b("onGAudioRoomMicModeChanged", paramBoolean1);
    long l1;
    if (((!this.jdField_v_of_type_Boolean) && ((paramLong != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1)) || (paramLong == 0L))
    {
      l1 = this.jdField_a_of_type_Long;
      if (paramBoolean1) {
        break label208;
      }
    }
    label208:
    for (boolean bool = true;; bool = false)
    {
      a("onGAudioRoomMicModeChanged", l1, bool, false);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lbc == null) {
      yds.a(null, "Usr_TV_Video", 2, 0, 0);
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
      if (this.jdField_a_of_type_Ktg != null) {
        this.jdField_a_of_type_Ktg.a();
      }
      this.z = false;
    }
    a(paramArrayOfByte);
    boolean bool = r();
    mgh localmgh;
    if (mgh.a())
    {
      localmgh = new mgh(this.jdField_a_of_type_Mgh, paramLong1);
      localmgh.a(paramArrayOfByte.length, paramInt1, paramInt2, kzl.jdField_m_of_type_Int, paramInt3, paramInt4, paramLong2, paramBoolean, bool);
      localmgh.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Mgh = localmgh;
      if (bool)
      {
        paramArrayOfByte = new lfc(paramLong1, paramArrayOfByte, paramInt1, paramInt2, kzl.jdField_m_of_type_Int, paramInt3, paramInt4, paramBoolean, paramLong2, System.currentTimeMillis());
        paramArrayOfByte.jdField_a_of_type_Mgh = localmgh;
        if (this.jdField_a_of_type_Lfi == null) {
          break;
        }
        this.jdField_a_of_type_Lfi.a(paramArrayOfByte);
        return;
      }
      if (localmgh != null) {
        localmgh.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramArrayOfByte, kzl.jdField_m_of_type_Int, paramInt1, paramInt2, paramInt3, paramInt4, System.currentTimeMillis(), paramBoolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
      kzw.a().a(paramArrayOfByte, 0);
      lif.a().a(0);
      return;
      localmgh = null;
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
      kth localkth = new kth();
      localkth.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(localkth);
      paramInt2 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), e(), Integer.valueOf(paramInt1) });
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
  
  void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    long l1 = paramArrayOfLong[0];
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->setSpeakingUin,uin=" + l1 + "isSpeaking" + paramBoolean);
    }
    boolean bool = b(l1, paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), Long.valueOf(l1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    Intent localIntent = new Intent("tencent.video.v2q.memberSpeaking");
    localIntent.putExtra("groupId", paramLong);
    localIntent.putExtra("uinList", paramArrayOfLong);
    localIntent.putExtra("isSpeaking", paramBoolean);
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
    if (!badq.d(a())) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      b();
      if ((this.jdField_o_of_type_Int == 0) && (lor.e(paramVideoAppInterface.getApp()))) {
        this.jdField_o_of_type_Int = 1;
      }
      this.jdField_a_of_type_Miu = miu.a(this.jdField_a_of_type_AndroidContentContext, this);
      if (this.y) {
        J();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(0L, "qqVersion", AppSetting.a(a()));
      return;
      if (badq.a(a())) {
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
      ((Set)localObject1).add(Long.valueOf(((kth)((Iterator)localObject2).next()).jdField_a_of_type_Long));
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
        kth localkth = new kth();
        localkth.jdField_c_of_type_Int = 0;
        localkth.jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        localkth.jdField_h_of_type_Boolean = false;
        localkth.jdField_d_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.jdField_b_of_type_JavaUtilArrayList.add(localkth);
        paramInt1 = 1;
        i2 = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver add member UIN:" + localkth.jdField_a_of_type_Long);
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
        localObject2 = (kth)((Iterator)localObject1).next();
      } while (((kth)localObject2).jdField_a_of_type_Long != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i1 = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver remove member UIN:" + ((kth)localObject2).jdField_a_of_type_Long);
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
      a().Z = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    a().Z = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelNetWorkTimer[" + paramString + "]");
    }
    this.jdField_A_of_type_Boolean = false;
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
      } while ((!q()) && (this.jdField_a_of_type_Ksn.b()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mip.a(a()).b();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if ((1 != c()) && (!d()))
    {
      a(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Ksq != null) {
      this.jdField_a_of_type_Ksq.b();
    }
    this.jdField_i_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt);
    if ((q()) && (paramInt != 110)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((ktn)localObject).a(paramInt);
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
        mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
        bool1 = true;
      }
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo closeVideo end, result[" + i1 + "], cancelNotificationForce[" + bool1 + "], seq[" + l1 + "]");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", friendUin: " + paramString2 + ", selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", isReceiver = " + a().jdField_e_of_type_Boolean + ", isVideoMsg = " + paramBoolean1 + ", extraUin: " + paramString3 + ", forceUnread:" + paramBoolean2);
    Intent localIntent;
    kvq localkvq;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AddVideoMsg");
      localkvq = this.jdField_a_of_type_Ksn.b(paramString1);
      if (localkvq == null) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      }
    }
    else
    {
      return;
    }
    int i1;
    if (paramInt2 == 21) {
      if ((localkvq.jdField_h_of_type_Int == 11) || (localkvq.jdField_h_of_type_Int == 12))
      {
        paramInt1 = 47;
        localkvq.a(1, 0);
        i1 = 0;
        paramInt2 = paramInt1;
      }
    }
    for (;;)
    {
      boolean bool = false;
      if ((localkvq.h()) && (paramInt2 == 1)) {
        bool = true;
      }
      String str;
      label461:
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
        localIntent.putExtra("bindType", localkvq.x);
        localIntent.putExtra("bindId", localkvq.jdField_o_of_type_JavaLangString);
        localIntent.putExtra("MultiAVType", localkvq.jdField_A_of_type_Int);
        if (paramInt2 == 17) {
          localIntent.putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if ((i1 != 1004) && (i1 != 1000)) {
          break label650;
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
          if (localkvq.I) {
            str = paramString2;
          }
        }
        localIntent.putExtra("friendUin", paramString2);
        localIntent.putExtra("senderUin", str);
        localIntent.putExtra("selfUin", paramString1);
        if (localkvq.jdField_e_of_type_Boolean) {
          break label723;
        }
        paramBoolean1 = true;
        localIntent.putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label785;
        }
        if (this.jdField_b_of_type_Long <= 0L) {
          break label774;
        }
        f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
        if (f1 >= 1024.0F) {
          break label729;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
        label545:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getConnectedTime():" + a() + " extra:" + paramString1);
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
        return;
        paramInt1 = 48;
        break;
        if (localkvq.j()) {
          bool = true;
        }
      }
      label650:
      if (i1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label811;
        }
      }
      for (;;)
      {
        if (localkvq.jdField_e_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          str = paramString3;
          paramString3 = paramString2;
          paramString2 = str;
          break;
        }
        if (localkvq.jdField_e_of_type_Boolean) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        label723:
        paramBoolean1 = false;
        break label461;
        label729:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label545;
        label774:
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> return!  no to show net traffic tips msg in AIO");
        return;
        label785:
        if (localkvq.jdField_e_of_type_Long > 0L)
        {
          paramString1 = mjg.a(a());
          break label545;
        }
        paramString1 = null;
        break label545;
        label811:
        paramString3 = paramString2;
      }
      i1 = paramInt1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.b();
    kvq localkvq = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l1 + "], Main[" + localkvq + "]");
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((ktn)localObject).a(paramInt);
    }
    if (q()) {
      D();
    }
    if (((localkvq.jdField_i_of_type_Int == 1011) || (localkvq.jdField_i_of_type_Int == 21)) && (localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean))
    {
      krx.d(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean);
      localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0);
      if ((q()) && ((paramInt == 2) || (paramInt == 3))) {
        return;
      }
      d(paramInt);
      return;
    }
    A(localkvq.jdField_c_of_type_JavaLangString);
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
        if (localkvq.jdField_d_of_type_Int != 2) {
          break label738;
        }
        awqx.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
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
          a(localkvq.jdField_i_of_type_Int, localkvq.jdField_d_of_type_JavaLangString, localkvq.jdField_i_of_type_Long, 0);
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
          if (localkvq.jdField_d_of_type_Int == 2)
          {
            awqx.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          awqx.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
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
          awqx.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong == 6L)
        {
          paramInt = 64;
          break;
        }
        if (paramLong == 7L)
        {
          paramInt = 24;
          break;
        }
        if (paramLong != 983055L) {
          break label995;
        }
        paramInt = 63;
        break;
        label738:
        awqx.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = ksn.a(3, paramString, new int[0]);
        localkvq = null;
        if (this.jdField_a_of_type_Ksn.a((String)localObject)) {
          localkvq = this.jdField_a_of_type_Ksn.b((String)localObject);
        }
        if ((localkvq != null) && (localkvq.jdField_g_of_type_Int == 1))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, set autoAcceptChat, seq[" + l1 + "]");
          localkvq.jdField_d_of_type_Boolean = true;
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
      paramInt = 64;
      break;
      paramInt = 62;
      a(l1, paramString, 62);
      break;
      label995:
      paramInt = 2;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo onInviteReached, peerUin[" + paramString + "], friend_state[" + paramInt + "], extraParam0[" + paramLong + "], subState[" + a().jdField_d_of_type_Long + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l1 + "]");
    a().jdField_n_of_type_JavaLangString = null;
    if (a() != null)
    {
      if (0L != a().jdField_d_of_type_Long) {
        break label313;
      }
      if (0L != paramLong) {}
    }
    else
    {
      if ((a() == null) || (!a().j())) {
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
              a().jdField_n_of_type_JavaLangString = new String(paramArrayOfByte);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :" + a().jdField_n_of_type_JavaLangString);
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(400), a().jdField_n_of_type_JavaLangString });
              break;
            }
            if (2L != paramLong) {
              break;
            }
            a().jdField_d_of_type_Long = 2L;
          } while (paramArrayOfByte == null);
          a().jdField_n_of_type_JavaLangString = new String(paramArrayOfByte);
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
            if ((a() != null) && (a().jdField_d_of_type_Long == 1L) && (!TextUtils.isEmpty(a().jdField_n_of_type_JavaLangString))) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString, a().jdField_n_of_type_JavaLangString });
            }
          }
          else if (!a().ag) {
            b(l1);
          }
        }
        for (;;)
        {
          a().jdField_r_of_type_Boolean = true;
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
              awqx.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
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
      a().jdField_r_of_type_Boolean = false;
      a(a().jdField_d_of_type_JavaLangString, 210);
      b(210);
      this.jdField_g_of_type_JavaLangRunnable = new VideoController.20(this, l1);
    } while ((this.jdField_g_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    label405:
    label817:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 2000L);
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
      if (this.jdField_a_of_type_Ksn != null)
      {
        paramString = this.jdField_a_of_type_Ksn.b(paramString);
        if (paramString != null)
        {
          localIntent.putExtra("uinType", paramString.jdField_i_of_type_Int);
          if (paramString.jdField_i_of_type_Int != 26) {
            break label363;
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
        localIntent.putExtra("relationType", paramString.C);
        localIntent.putExtra("relationId", paramString.jdField_g_of_type_Long);
      }
      localIntent.putExtra("extraUin", paramString.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("bindType", paramString.x);
      localIntent.putExtra("bindId", paramString.jdField_o_of_type_JavaLangString);
      localIntent.putExtra("isReceiver", paramString.jdField_e_of_type_Boolean);
      if (q()) {
        localIntent.putExtra("isNearbyVideoChat", true);
      }
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("isDouble", paramBoolean3);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      return;
      label363:
      localIntent.putExtra("peerUin", paramString.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    Object localObject = ksn.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_Ksn.b((String)localObject);
    if (localObject != null) {
      ((kvq)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
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
      ktq.a();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    ktq.a(paramLong3);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "], seq[" + l1 + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", mfy.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    min.a(localNewIntent, l1);
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
        break label116;
      }
      paramBoolean2 = true;
    }
    for (;;)
    {
      this.jdField_m_of_type_Boolean = paramBoolean2;
      paramLong = mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > 1)
        {
          i1 = 1;
          if ((!paramBoolean1) && (i1 != 0)) {
            a(this.jdField_a_of_type_Long, new long[] { paramLong }, paramBoolean1);
          }
          return;
          label116:
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + mfy.a(paramLong) + ", uinType = " + a().jdField_i_of_type_Int);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    if (a().jdField_i_of_type_Int == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", mfy.a(paramString));
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
            a().jdField_a_of_type_Kvr.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          a().jdField_a_of_type_Kvr.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int != 3) {
          break;
        }
        kth localkth = a(paramString);
        if (localkth != null)
        {
          localkth.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Kvr.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    krx.d(jdField_a_of_type_JavaLangString, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    kvq localkvq = null;
    if (this.jdField_a_of_type_Ksn != null) {
      localkvq = this.jdField_a_of_type_Ksn.b(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (String str = "mApp is null";; str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + localkvq + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (localkvq != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", localkvq.x);
    paramString1.putExtra("bindId", localkvq.jdField_o_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", localkvq.jdField_d_of_type_Int);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(kst.jdField_d_of_type_JavaLangString, localkvq.jdField_e_of_type_Long);
    paramString1.putExtra(kst.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
    paramString1.putExtra(kst.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", a());
    long l1 = 0L;
    if ((localkvq.jdField_d_of_type_Int == 1) || (localkvq.jdField_d_of_type_Int == 2)) {
      l1 = 1L;
    }
    if ((localkvq.jdField_d_of_type_Int == 3) || (localkvq.jdField_d_of_type_Int == 4)) {
      l1 = 2L;
    }
    paramString1.putExtra(kst.i, l1);
    if ((localkvq.jdField_d_of_type_Int == 1) || (localkvq.jdField_d_of_type_Int == 3)) {}
    for (l1 = 1L;; l1 = 0L)
    {
      paramString1.putExtra(kst.j, l1);
      if (this.jdField_a_of_type_Ksn.b(paramString2).jdField_l_of_type_JavaLangString != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_Ksn.b(paramString2).jdField_l_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Ksn.b(paramString2).jdField_m_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_Ksn.b(paramString2).jdField_m_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_Ksn.b(paramString2).C);
        paramString1.putExtra("relationId", this.jdField_a_of_type_Ksn.b(paramString2).jdField_g_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label648;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        lbn.a().a.a();
        break;
        label648:
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
          a().jdField_a_of_type_Kvr.jdField_g_of_type_JavaLangString = paramString2;
        }
        kth localkth;
        for (;;)
        {
          if (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int != 3) {
            break label195;
          }
          localkth = a(paramString1);
          if (localkth == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          localkth.jdField_b_of_type_JavaLangString = paramString2;
          return;
          a().jdField_a_of_type_Kvr.jdField_f_of_type_JavaLangString = paramString2;
        }
        localkth.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", ktk.a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().jdField_R_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      mga.o(this);
    }
    if (mhj.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
      return;
    }
    a(false, paramBoolean);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  public void a(ktg paramktg)
  {
    this.jdField_a_of_type_Ktg = paramktg;
  }
  
  void a(kth paramkth, int paramInt)
  {
    paramkth.jdField_a_of_type_Int = 0;
    paramkth.jdField_b_of_type_Boolean = false;
    paramkth.jdField_c_of_type_Boolean = false;
    paramkth.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramkth.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramkth.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramkth.jdField_a_of_type_Int = 1;
      return;
    }
    paramkth.jdField_d_of_type_Boolean = true;
  }
  
  public void a(ldd paramldd, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut--> UserInfo = " + paramldd.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramldd.jdField_a_of_type_Int == 1)
      {
        if (a().a(paramldd.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList) == null) {
          break label183;
        }
        localAVPhoneUserInfo = a().a(paramldd.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + localAVPhoneUserInfo);
        }
      }
      a(paramInt2, paramLong1, paramldd, true, paramLong2, paramVarArgs);
    }
    label183:
    do
    {
      return;
      localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramldd.jdField_a_of_type_Long;
      localAVPhoneUserInfo.accountType = 2;
      a().a(localAVPhoneUserInfo);
      e(paramldd.jdField_a_of_type_Long);
      break;
      if (paramInt1 == 71)
      {
        if (paramldd.jdField_a_of_type_Int == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramldd.jdField_a_of_type_Long;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramldd, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  void a(ldd paramldd, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    Object localObject1;
    if (paramBoolean) {
      try
      {
        if (a(paramldd.jdField_a_of_type_Long) != -1) {
          return;
        }
        localObject1 = new kth();
        ((kth)localObject1).jdField_a_of_type_Long = paramldd.jdField_a_of_type_Long;
        ((kth)localObject1).jdField_c_of_type_Int = paramldd.jdField_a_of_type_Int;
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
        return;
      }
      finally {}
    }
    int i1 = a(paramldd.jdField_a_of_type_Long);
    Object localObject2 = null;
    if (i1 != -1) {
      localObject1 = (kth)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
    }
    for (;;)
    {
      a(paramldd.jdField_a_of_type_Long, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      u();
      if ((localObject1 == null) || (((kth)localObject1).jdField_e_of_type_Boolean) || (!((kth)localObject1).jdField_g_of_type_Boolean)) {
        break;
      }
      a(0L, false, 0L);
      break;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramldd);
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
        mht localmht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localmht != null) {
          localmht.a(paramVarArgs.jdField_c_of_type_JavaLangString);
        }
        QLog.w(jdField_a_of_type_JavaLangString, 1, "closeMainSession, mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], isDoubleVideoMeeting[" + paramVarArgs.I + "], \nsession[" + paramVarArgs + "], \nseq[" + l1 + "]");
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
      if (paramVarArgs.I)
      {
        a(l1, this.jdField_a_of_type_Long, true, 0);
        return;
      }
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 30);
      return;
    } while ((paramVarArgs.jdField_d_of_type_Int != 1) && (paramVarArgs.jdField_d_of_type_Int != 2));
    if ((paramVarArgs.jdField_g_of_type_Int == 2) || (paramVarArgs.jdField_g_of_type_Int == 13))
    {
      if (paramVarArgs.I)
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
    if (paramVarArgs.I)
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
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(((kvq)localObject).jdField_b_of_type_Boolean).append("->").append(paramBoolean2).append("], deviceName[").append(((kvq)localObject).jdField_p_of_type_JavaLangString).append("], audioStateBeforePhoneCall[").append(((kvq)localObject).s).append("], mTraeHelper[");
    if (this.jdField_a_of_type_Miu != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Miu != null) {
        break;
      }
      return;
    }
    if ((((kvq)localObject).jdField_i_of_type_Int == 0) && (((kvq)localObject).jdField_g_of_type_Int != 0) && (((kvq)localObject).jdField_g_of_type_Int != 5) && (((kvq)localObject).jdField_g_of_type_Int != 6) && (((kvq)localObject).jdField_b_of_type_Boolean != paramBoolean2))
    {
      ((kvq)localObject).jdField_b_of_type_Boolean = paramBoolean2;
      if (!paramBoolean2) {
        break label233;
      }
      this.jdField_a_of_type_Miu.b();
      ((kvq)localObject).s = ((kvq)localObject).jdField_p_of_type_JavaLangString;
    }
    while (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label233:
      if ("DEVICE_SPEAKERPHONE".equals(((kvq)localObject).s))
      {
        this.jdField_a_of_type_Miu.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else if ("DEVICE_EARPHONE".equals(((kvq)localObject).s))
      {
        this.jdField_a_of_type_Miu.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (((kvq)localObject).jdField_d_of_type_Int == 1) {}
        for (localObject = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; localObject = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
        {
          this.jdField_a_of_type_Miu.a((String)localObject);
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
      if ((this.jdField_a_of_type_ArrayOfMcy != null) && (this.jdField_a_of_type_ArrayOfMcy[0] != null)) {
        this.jdField_a_of_type_ArrayOfMcy[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    while (((paramInt1 != 3) && (paramInt1 != 0)) || (this.jdField_a_of_type_ArrayOfMcy == null) || (this.jdField_a_of_type_ArrayOfMcy[1] == null)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMcy[1].a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    ktk.a(paramArrayOfByte);
    if (this.jdField_a_of_type_Lbc == null)
    {
      awqx.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_Lbc.b(paramArrayOfByte, paramLong);
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
      long l1 = mfy.a(str);
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
  
  public boolean a()
  {
    boolean bool1 = a(a());
    boolean bool2 = s();
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isGameMode isQQPaused: " + bool3 + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isLandscape: " + bool2 + ", isScreenLocked: " + bool1);
    }
    return (!bool1) && (bool2) && (bool3) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
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
    paramBoolean = c(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + kst.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
      }
      if (this.jdField_a_of_type_Ksn.a() < 2) {
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
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((a().jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random mulit");
      }
      if (bool) {
        return false;
      }
    }
    else if (a().d())
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
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (a().jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo  auto Accept");
        }
        if ((a().jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString.equals(paramString1))) {
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
          krx.d(jdField_a_of_type_JavaLangString, "isRequestVideo when request: fromUin = " + paramString1);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo orientation: " + this.jdField_t_of_type_Int + ", isQQPaused: " + kst.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
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
        kth localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((localkth == null) || (localkth.jdField_a_of_type_Long != paramLong)) {
          break label186;
        }
        localkth.jdField_e_of_type_Boolean = paramBoolean;
        localkth.jdField_c_of_type_Int = paramInt1;
        bool = localkth.jdField_g_of_type_Boolean;
        if (paramBoolean)
        {
          localkth.jdField_g_of_type_Boolean = false;
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
  
  boolean a(long paramLong, int paramInt, ArrayList<leb> paramArrayList)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramArrayList.size())
      {
        if ((((leb)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((leb)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
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
    return a(paramString, 1, 0L);
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    long l1 = a(paramString);
    boolean bool = a(b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()), b(paramString), l1, paramInt, paramLong);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "QuaReport --> report result = " + bool + " | node = " + paramInt + " | timestamp = " + paramLong);
    return bool;
  }
  
  public boolean a(String paramString, kvq paramkvq)
  {
    boolean bool2;
    if (paramkvq == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i1 = paramkvq.b();
    long l1 = paramkvq.b();
    long l2 = paramkvq.c();
    long l3;
    if (i1 == 2)
    {
      l3 = a(paramkvq);
      if (l3 != paramkvq.b()) {
        paramkvq.d(l3);
      }
    }
    for (;;)
    {
      l3 = paramkvq.b();
      long l4 = paramkvq.c();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramkvq, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i1 == 1)
      {
        l3 = b(paramkvq);
        if (l3 != paramkvq.b()) {
          paramkvq.d(l3);
        }
      }
    }
  }
  
  public boolean a(kvq paramkvq1, kvq paramkvq2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramkvq1.jdField_d_of_type_JavaLangString);
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
          paramkvq2.a(paramLong1, paramkvq1.jdField_j_of_type_Boolean);
          a(paramString, paramkvq2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_c_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          }
          if (!paramkvq1.a()) {
            a(paramLong1, 2131230736, 1, null);
          }
          i1 = paramkvq1.jdField_d_of_type_Int;
          paramkvq2.jdField_d_of_type_JavaLangString = paramkvq1.jdField_d_of_type_JavaLangString;
          paramkvq2.a(paramLong1, paramkvq1.jdField_j_of_type_Boolean);
          paramkvq2.jdField_g_of_type_Boolean = paramkvq1.jdField_g_of_type_Boolean;
          paramkvq2.a("onGAudioInvite", paramkvq1.N);
          paramkvq2.a("onGAudioInvite", paramkvq1.jdField_p_of_type_JavaLangString);
          paramkvq2.aA = true;
          paramkvq2.a(3, 12);
          paramkvq1.a(3, 12);
          b(paramkvq1.jdField_d_of_type_JavaLangString, 21);
          if (i1 == 1)
          {
            paramkvq2.a(paramLong1, "onGAudioInvite.2", 3);
            paramkvq2.jdField_i_of_type_Int = mjg.c(paramInt);
            paramkvq2.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramkvq2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramkvq2.B = 1;
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
              break label544;
            }
            paramkvq2.b("onGAudioInvite1", mfs.a(paramkvq2.jdField_i_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramkvq1 = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            int i2 = 0;
            if (paramkvq1 != null)
            {
              boolean bool2 = paramkvq1.a();
              i2 = bool2;
              if (bool2)
              {
                paramkvq1.a(paramString);
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
        catch (Exception paramkvq1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramkvq1);
          }
          this.jdField_a_of_type_Ksn.a(paramLong1, paramString);
          return bool1;
        }
        if (i1 == 2)
        {
          paramkvq2.a(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i1 == 4)
        {
          paramkvq2.a(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramkvq2.a(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label544:
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop)
          {
            paramkvq2.b("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            n(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramkvq1 != paramkvq2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramkvq1 + "], new[" + paramkvq2 + "]");
      }
      if (!bool1) {
        break label583;
      }
      if (paramkvq1.w != 0) {
        break label164;
      }
      paramkvq1.a("onGAudioInvite.2", 0);
      this.jdField_a_of_type_Ksn.a(paramLong1, paramString);
      return bool1;
    }
    label583:
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
      if (((leb)a().jdField_e_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
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
          kth localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(i3);
          if ((localkth != null) && (localkth.jdField_a_of_type_Long != mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
          {
            int i2 = i1;
            if (localkth.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (localkth.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            if (localkth.jdField_c_of_type_Boolean) {
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
    krx.d(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
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
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
    }
    return -1;
  }
  
  public int b(kvq paramkvq, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramkvq, paramString);
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
      long l1 = mfy.a(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e(jdField_a_of_type_JavaLangString, paramString.getMessage());
    }
    return -1L;
  }
  
  public long b(kvq paramkvq)
  {
    if (paramkvq == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramkvq.jdField_d_of_type_Int == 3) || (paramkvq.jdField_d_of_type_Int == 4)))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramkvq.C, paramkvq.jdField_A_of_type_Int, paramkvq.jdField_g_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramkvq.d(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramkvq.d(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramkvq.b();
  }
  
  public ArrayList<kth> b()
  {
    if ((AudioHelper.d()) && (mej.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(mej.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void b(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportCloseReasonBeacon,reason  = " + paramInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("closeReason", String.valueOf(paramInt));
    awrn.a(BaseApplicationImpl.getApplication()).a(null, "actAvideoCloseReasonB", true, 0L, 0L, localHashMap, "", true);
  }
  
  public void b(int paramInt, long paramLong)
  {
    String str = ksn.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = ksn.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_a_of_type_Ksn.a(str)) {}
    for (Object localObject = this.jdField_a_of_type_Ksn.b(str);; localObject = null)
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
          if (this.jdField_a_of_type_Miu != null) {
            this.jdField_a_of_type_Miu.b(l1);
          }
          miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          miu.a().b();
          if ((AudioHelper.e()) || (((kvq)localObject).ap)) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, \nmainsession[" + a() + "], \nstate[" + ((kvq)localObject).jdField_g_of_type_Int + "], seq[" + l1 + "], isAcceptingMultiAV[" + ((kvq)localObject).ap + "]");
          }
        } while (((kvq)localObject).ap);
        if (this.jdField_d_of_type_Long == paramLong)
        {
          this.jdField_d_of_type_Long = 0L;
          this.jdField_n_of_type_Int = 0;
        }
        if ((paramInt != 3) || (!((kvq)localObject).I) || ((((kvq)localObject).jdField_d_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((kvq)localObject).jdField_d_of_type_JavaLangString).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((kvq)localObject).jdField_d_of_type_JavaLangString + " ,relationId = " + paramLong);
      return;
      if ((!((kvq)localObject).af) && (!((kvq)localObject).I))
      {
        int i1 = 6;
        if (((kvq)localObject).jdField_g_of_type_Int == 7) {
          i1 = 5;
        }
        a("onGAudioRoomDestroy", str, mjg.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((kvq)localObject).jdField_r_of_type_JavaLangString, false, false);
      }
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt, paramLong, 69);
      }
      ((kvq)localObject).a("onGAudioRoomDestroy", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_a_of_type_Ksn.a(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_Ksn.b(str);
          paramInt = mjg.c(paramInt);
          a(((kvq)localObject).jdField_c_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_a_of_type_Ksn.a(l1, str))
        {
          localObject = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject != null) && (((mht)localObject).a()))
          {
            ((mht)localObject).a(str);
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
    kvq localkvq = a();
    if (localkvq.am) {}
    while (localkvq.b(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < localkvq.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((leb)localkvq.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((leb)localkvq.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((leb)localkvq.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupVideoClosed, relationId[" + paramLong + "], reason[" + paramInt2 + "], avtype[" + paramInt3 + "], bKickout[" + this.w + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    if (this.w) {
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {
      a(1, paramLong, 83);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      this.jdField_i_of_type_JavaLangRunnable = null;
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
    String str = bamr.a(l1, 3);
    if (new File(str).exists())
    {
      miu.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_f_of_type_Boolean = true;
      int i1 = a().jdField_o_of_type_Int;
      awqx.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    miu.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
    a().jdField_f_of_type_Boolean = true;
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
      a().V = true;
      d(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      a().H = paramInt2;
      d(paramInt1, paramLong, paramInt2);
      return;
    }
    c(paramInt1, paramLong, paramInt2);
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
      a().al = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onRecvAudioReady uin = " + paramLong1 + ",roomid = " + paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    kvq localkvq = a();
    if ((localkvq.jdField_d_of_type_Int != 2) || (localkvq.jdField_v_of_type_Int != 2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInviteRespFail, groupId[" + paramLong1 + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], err[" + paramLong2 + "], msg[" + paramString + "]");
    if (paramLong1 == this.jdField_a_of_type_Long) {
      bbmy.a(a(), 2131630283, 1).a();
    }
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<ldv> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.27(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceiveSharpnessMsg,selfRequest=" + paramLong1 + ", errorCode=" + paramLong2 + ", detailInfo=" + paramArrayOfByte);
    }
    if (a().jdField_d_of_type_Int != 2) {
      return;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10002), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramArrayOfByte });
      return;
    }
    catch (NullPointerException paramArrayOfByte) {}catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = ksn.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_Ksn.a(str)) {}
      for (kvq localkvq = this.jdField_a_of_type_Ksn.b(str); localkvq == null; localkvq = this.jdField_a_of_type_Ksn.b(str))
      {
        QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        kyj.a(0L, 33);
        kyj.b(0L);
        return;
        str = ksn.a(100, paramString, new int[0]);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((lad)localObject).a(localkvq);
      }
      kyj.a(localkvq.b(), 16, 0L);
      kyj.a(localkvq.b(), 33);
      kyj.b(localkvq.b());
      localObject = (kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (localkvq.jdField_e_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((kyl)localObject).a(localkvq.b(), i2, i1 + 500);
        ((kyl)localObject).a("NoCrash");
        ((kyl)localObject).a(localkvq.b(), 29, 1L);
        ((kyl)localObject).a(36, 1L);
        ((kyl)localObject).b(localkvq.b());
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + localkvq.d() + "], sessionInfo.peerUin[" + localkvq.jdField_d_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + localkvq.Q + "], sessionInfo.SessionType[" + localkvq.jdField_d_of_type_Int + "], mNetTrafficAllSize[" + this.jdField_b_of_type_Long + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!localkvq.d()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((localkvq.jdField_d_of_type_Int == 2) && (!localkvq.I) && (localkvq.jdField_g_of_type_Int >= 4) && (localkvq.jdField_e_of_type_Long > 0L))
      {
        i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
        krx.d(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + localkvq.jdField_e_of_type_Long + " | " + localkvq.jdField_g_of_type_Int + " | " + localkvq.jdField_t_of_type_Boolean);
        if ((localkvq.jdField_t_of_type_Boolean) || (i2 > 0)) {
          awqx.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_t_of_type_Boolean) && (a() > 0L))
      {
        if (localkvq.jdField_d_of_type_Int == 1) {
          awqx.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", mjg.a(a()), "");
        }
      }
      else
      {
        label763:
        localkvq.jdField_d_of_type_Long = 0L;
        localkvq.jdField_n_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(localkvq.jdField_d_of_type_JavaLangString))
        {
          localObject = paramString;
          if (localkvq.jdField_d_of_type_JavaLangString.contains(paramString)) {
            localObject = localkvq.jdField_d_of_type_JavaLangString;
          }
        }
        if ((localkvq.m()) || (localkvq.n())) {
          localkvq.w = i1;
        }
        if ((localkvq.f()) || ((localkvq.h()) && (i1 == localkvq.w))) {
          localkvq.a(paramLong, 0L);
        }
        if ((localkvq.ag) && (this.jdField_e_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          this.jdField_e_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1578;
        }
        paramBoolean = false;
        if (localkvq.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(localkvq.jdField_c_of_type_JavaLangString, localkvq.jdField_i_of_type_Int, paramBoolean, localkvq.jdField_d_of_type_JavaLangString, localkvq.jdField_f_of_type_JavaLangString);
        label949:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_Ksn.a())
        {
          i();
          k();
          t();
        }
        localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Boolean = false;
        localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_JavaLangString = null;
        localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_JavaLangString = null;
        localkvq.jdField_a_of_type_Kvr.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          mga.b(this, false);
          mga.c(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            mga.l(this);
          }
        }
        localkvq.a("doCloseSession", 0);
        localkvq.a(paramLong, "doCloseSession", 0);
        localkvq.jdField_f_of_type_Int = 0;
        localkvq.jdField_a_of_type_JavaUtilBitSet.clear();
        localkvq.jdField_j_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        localkvq.at = false;
        localkvq.jdField_a_of_type_ArrayOfJavaLangString = null;
        localkvq.a("doCloseSession", null);
        localkvq.jdField_o_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + localkvq.jdField_i_of_type_Int + " # matchStatus = " + localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          localkvq.jdField_i_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1592;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1254:
        if ((localkvq.jdField_i_of_type_Int != 1011) || ((localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int != 2) && (localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int != 6))) {
          break label1619;
        }
        if ((!this.jdField_f_of_type_Boolean) && (localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int != 6)) {
          break label1602;
        }
        a(6, 1, null);
        label1318:
        this.jdField_a_of_type_Boolean = false;
        label1323:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_Int == 1) || (localkvq.jdField_a_of_type_Kvr.jdField_a_of_type_Int == 2)))
        {
          localkvq.a();
          a(0, 0, null);
        }
        localkvq.a(paramLong, false);
        localkvq.b(paramLong, false);
        localkvq.a(paramLong, 0L);
        localkvq.b(paramLong);
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1637;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_Ksn.a(paramLong, str);
      }
      for (;;)
      {
        paramString = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str);
        if (!paramBoolean) {
          break;
        }
        c();
        return;
        if (localkvq.jdField_d_of_type_Int != 2) {
          break label763;
        }
        awqx.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", mjg.a(a()), "");
        break label763;
        label1578:
        a(paramLong, str, (String)localObject, i1);
        break label949;
        label1592:
        if (!this.jdField_a_of_type_Boolean) {
          break label1254;
        }
        break label1254;
        label1602:
        a(localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int, 1, null);
        break label1318;
        label1619:
        if (!this.jdField_f_of_type_Boolean) {
          break label1323;
        }
        a(6, 1, null);
        break label1323;
        label1637:
        this.jdField_a_of_type_Ksn.a(str, 3);
      }
    }
  }
  
  public void b(long paramLong, ArrayList<ldd> paramArrayList) {}
  
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
      if (a().j()) {}
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
    miu.a().b(l1);
    miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (b(paramString)) {
      miu.a().b();
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
        localObject = (kth)localIterator.next();
        if ((((kth)localObject).jdField_c_of_type_Int == 1) && (((kth)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((kth)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
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
      if (!a().jdField_R_of_type_Boolean)
      {
        if (paramBoolean) {
          if ((a().jdField_g_of_type_Int > 0) && (a().jdField_g_of_type_Int <= 4))
          {
            if ((!a().Q) && (a().jdField_j_of_type_Boolean)) {
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
            if ((!a().Q) && (a().jdField_j_of_type_Boolean)) {
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
            if (a().N)
            {
              if (this.jdField_f_of_type_JavaLangRunnable == null) {
                this.jdField_f_of_type_JavaLangRunnable = new VideoController.19(this);
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 2000L);
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
          long l1 = mfy.a(str3);
          String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = befc.a("62ad83");
          i2 = bati.a(str3);
          str3 = babp.b();
          String str4 = str3 + "," + i2;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(i2), str4 }));
          }
          ((VcControllerImpl)localObject2).init(a(), l1, "8.2.6", Build.MODEL, (String)localObject1, str1, AppSetting.d(), str2, lbk.b(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, lbk.d(), i1, str4, new lbg().a(), mhr.a(l1), mhr.b(l1));
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
  
  public boolean b(kvq paramkvq1, kvq paramkvq2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramkvq1.jdField_d_of_type_JavaLangString);
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
          paramkvq2.a(paramLong1, paramkvq1.jdField_j_of_type_Boolean);
          a(paramString, paramkvq2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramkvq1.a()) {
            a(paramLong1, 2131230736, 1, null);
          }
          int i1 = paramkvq1.jdField_d_of_type_Int;
          paramkvq2.aA = true;
          paramkvq2.jdField_d_of_type_JavaLangString = paramkvq1.jdField_d_of_type_JavaLangString;
          if ((paramkvq1.jdField_g_of_type_Int == 15) || (paramkvq1.J)) {
            g(false);
          }
          paramkvq1.a(3, 12);
          if (i1 == 1)
          {
            paramkvq1.a(paramLong1, "onGAudioInvite.6", 3);
            paramkvq1.jdField_i_of_type_Int = mjg.c(paramInt);
            paramkvq1.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramkvq1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramkvq1.B = 1;
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.a() <= 0) {
                break label519;
              }
              paramkvq1.b("onGAudioInvite3", mfs.a(paramkvq1.jdField_i_of_type_Int));
              localVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramkvq2 = mht.a(localVideoAppInterface);
            int i2 = 0;
            if (paramkvq2 != null)
            {
              boolean bool2 = paramkvq2.a();
              i2 = bool2;
              if (bool2)
              {
                paramkvq2.a(paramkvq1.jdField_c_of_type_JavaLangString);
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
            paramkvq1.a(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i1 != 4) {
            break label507;
          }
        }
        catch (Exception paramkvq1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramkvq1.getMessage());
          }
          this.jdField_a_of_type_Ksn.a(paramLong1, paramString);
          return bool1;
        }
        paramkvq1.a(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label507:
        paramkvq1.a(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label519:
        if (localThrowable.isBackground_Stop)
        {
          paramkvq1.b("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          n(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramkvq1.jdField_K_of_type_Boolean))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramkvq1.jdField_K_of_type_Boolean + "], ret[" + bool1 + "], main[" + paramkvq1 + "], new[" + paramkvq2 + "]");
      }
      paramkvq1.jdField_K_of_type_Boolean = false;
      if (!bool1) {
        break label556;
      }
    }
    label556:
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
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString);
    }
    return -1;
  }
  
  public int c(boolean paramBoolean)
  {
    if ((a().j()) || (this.jdField_e_of_type_Boolean))
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
  
  public long c(String paramString)
  {
    long l1 = -1L;
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      l1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getChatRoomID(paramString);
    }
    return l1;
  }
  
  public ArrayList<kth> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.d()) && (mej.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(mej.jdField_a_of_type_JavaUtilArrayList);
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
        mht localmht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((kvq)localObject2).jdField_e_of_type_Boolean) {
          break label306;
        }
        if (((kvq)localObject2).h())
        {
          if ((((kvq)localObject2).jdField_d_of_type_Int == 1) || (((kvq)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((kvq)localObject2).Q) && (!((kvq)localObject2).I))
            {
              i1 = 56;
              if ((((kvq)localObject2).jdField_i_of_type_Int != 1011) && (!l())) {
                break label372;
              }
              i1 = ((kvq)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label665;
              }
              if (((kvq)localObject2).C != 7) {
                break label695;
              }
              i1 = i2;
              if (((kvq)localObject2).jdField_a_of_type_Kvr.jdField_b_of_type_Int <= 4) {
                break label344;
              }
              i2 = 52;
              if (this.jdField_f_of_type_Boolean)
              {
                i2 = 60;
                t();
              }
              localmht.a(((kvq)localObject2).jdField_c_of_type_JavaLangString, "", null, null, i2, ((kvq)localObject2).jdField_i_of_type_Int, i1);
              s();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((kvq)localObject2).jdField_g_of_type_Long);
          localObject4 = ((kvq)localObject2).jdField_d_of_type_JavaLangString;
          localObject2 = ((kvq)localObject2).jdField_c_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localmht.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.12(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((kvq)localObject2).jdField_d_of_type_Int != 1) {
          break label671;
        }
      }
      finally {}
      int i1 = 47;
      label306:
      if (((kvq)localObject2).j())
      {
        if (((kvq)localObject2).jdField_d_of_type_Int != 1) {
          break label680;
        }
        i1 = 47;
      }
      else
      {
        if (((kvq)localObject2).jdField_d_of_type_Int != 1) {
          break label689;
        }
        i1 = 46;
        break label686;
        label344:
        localObject1.a(((kvq)localObject2).jdField_c_of_type_JavaLangString, "", null, null, 51, ((kvq)localObject2).jdField_i_of_type_Int, i1);
        t();
        continue;
        label372:
        if ((((kvq)localObject2).jdField_d_of_type_Int == 3) || (((kvq)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((kvq)localObject2).I)
          {
            localObject3 = ((kvq)localObject2).jdField_e_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((kvq)localObject2).jdField_d_of_type_JavaLangString, null, true, true);
            localObject1.a(((kvq)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((kvq)localObject2).jdField_g_of_type_Long), 48, 0, ((kvq)localObject2).jdField_d_of_type_Int);
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a().jdField_i_of_type_Int, String.valueOf(a().jdField_g_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((kvq)localObject2).jdField_i_of_type_Int, String.valueOf(((kvq)localObject2).jdField_g_of_type_Long), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((kvq)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((kvq)localObject2).jdField_g_of_type_Long), 44, ((kvq)localObject2).jdField_i_of_type_Int, ((kvq)localObject2).jdField_d_of_type_Int);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this), 1000L);
          continue;
        }
        if (((kvq)localObject2).jdField_e_of_type_JavaLangString == null) {
          ((kvq)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(((kvq)localObject2).jdField_i_of_type_Int, ((kvq)localObject2).jdField_d_of_type_JavaLangString, ((kvq)localObject2).jdField_f_of_type_JavaLangString);
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((kvq)localObject2).jdField_i_of_type_Int, ((kvq)localObject2).jdField_d_of_type_JavaLangString, ((kvq)localObject2).jdField_f_of_type_JavaLangString, true, true);
        localObject1.a(((kvq)localObject2).jdField_c_of_type_JavaLangString, ((kvq)localObject2).jdField_e_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((kvq)localObject2).jdField_i_of_type_Int, ((kvq)localObject2).jdField_d_of_type_Int);
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
      a().W = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        a().W = false;
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
        int i1 = 0;
        if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject = (leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (((leb)localObject).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (a(((leb)localObject).jdField_a_of_type_Long, ((leb)localObject).jdField_a_of_type_Int, a().jdField_e_of_type_JavaUtilArrayList)) {
              ((leb)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((leb)localObject).jdField_b_of_type_Boolean = false;
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
    krx.c(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
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
    Object localObject = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "onEnterSuc, groupId[" + paramLong + "], relationType[" + paramInt1 + "], multiAVType[" + paramInt2 + "], MainSession[" + localObject + "], seq[" + l1 + "]");
    a("onEnterSuc");
    ((kvq)localObject).ap = false;
    if (paramInt1 == 3)
    {
      ((kvq)localObject).a("onEnterSuc.1", 14);
      ((kvq)localObject).J = true;
      ((kvq)localObject).a(l1, SystemClock.elapsedRealtime());
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
        ((lad)localObject).a(a());
      }
      return;
      this.jdField_e_of_type_Boolean = true;
      localObject = ksn.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = ksn.a().b((String)localObject);
      if (localObject != null)
      {
        ((kvq)localObject).T = true;
        ((kvq)localObject).jdField_M_of_type_Boolean = false;
      }
      if ((mfs.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
    }
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
      if ((a().jdField_d_of_type_Int <= 0) || (a().jdField_d_of_type_Int > 2) || (!a().j())) {
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
    boolean bool1 = true;
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchTerminalSuccess, fromUin[" + paramString + "], info[" + paramInt + "], seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.jdField_e_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
      this.jdField_e_of_type_JavaLangRunnable = null;
    }
    paramString = a();
    if (paramString.ah)
    {
      paramString.ah = false;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString.jdField_d_of_type_JavaLangString, Boolean.valueOf(false) });
        label161:
        c(l1);
        paramInt = (int)a();
        boolean bool2 = paramString.jdField_k_of_type_Boolean;
        if (paramString.jdField_h_of_type_Boolean) {
          break label242;
        }
        label186:
        a(paramInt, bool2, bool1);
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject == null) {
        break;
      }
      ((lad)localObject).a(this, paramString);
      return;
      localObject = new VideoController.14(this, paramString);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      break label161;
      label242:
      bool1 = false;
      break label186;
      if (paramString.ag) {
        e(paramString.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = AudioHelper.b();
    paramArrayOfByte = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onSwitchGroup, fromUin[" + paramString + "], flag[" + paramLong + "], seq[" + l1 + "]");
    if ((paramArrayOfByte.jdField_d_of_type_Int == 3) || (paramArrayOfByte.jdField_d_of_type_Int == 4)) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.jdField_d_of_type_JavaLangString))) {
      return;
    }
    n(true);
    if (!paramArrayOfByte.a()) {
      a(l1, 2131230736, 1, null);
    }
    paramArrayOfByte.b("onSwitchGroup", mfs.a(paramArrayOfByte.jdField_i_of_type_Int));
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(2, 11);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
    d();
  }
  
  public void c(ArrayList<lcs> paramArrayList)
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
          if ((((lcs)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((lcs)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((lcs)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((lcs)paramArrayList.get(i1)).jdField_a_of_type_Long));
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Ksn.a().jdField_e_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Ksn.a().jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_Ksn.a().jdField_d_of_type_Int != 2)) {
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
      if (this.jdField_a_of_type_Ksn.a().jdField_d_of_type_Int == 0) {
        if (this.jdField_a_of_type_Ksn.a().jdField_f_of_type_Int != 1)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Ksn.a().jdField_f_of_type_Int != 2) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public boolean c(boolean paramBoolean)
  {
    krx.d(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
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
        kth localkth = (kth)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = String.valueOf(localkth.jdField_a_of_type_Long);
        localArrayList2.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null)
    {
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.15(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_c_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 20000L);
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
      krx.d(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_h_of_type_Int);
      return;
    }
    if (miu.a() != null) {
      miu.a().a(l1);
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    Object localObject = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((mht)localObject).a();
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
        krx.e(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (paramInt2 == 108)
    {
      a().Y = true;
      kvq localkvq = a();
      if (!h())
      {
        bool = true;
        localkvq.X = bool;
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      break;
      if (a().Y)
      {
        a().Y = false;
        if (a().X) {
          a("onMVSpeakModeChanged_2", this.jdField_a_of_type_Long, true, false);
        } else {
          a("onMVSpeakModeChanged_3", this.jdField_a_of_type_Long, false, false);
        }
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    krx.d(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void d(long paramLong)
  {
    int i1 = this.jdField_a_of_type_Ksn.a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, inviteUin[" + paramLong + "], aliveSessionCount[" + i1 + "], seq[" + l1 + "], \nmainSession[" + a() + "]");
    if (i1 >= 2)
    {
      a(l1, true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
      return;
    }
    String str = ksn.a(100, String.valueOf(paramLong), new int[0]);
    this.jdField_a_of_type_Ksn.a(str, false);
    kst.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    boolean bool1 = false;
    boolean bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    if ((TextUtils.equals(a().jdField_d_of_type_JavaLangString, String.valueOf(paramLong))) && (a().jdField_h_of_type_Int == 11))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Ksn.b(str).a("onDoubleVideoMeetingInvite.1", 2);
      b(a().jdField_d_of_type_JavaLangString, 2);
    }
    if (a().d()) {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ksn.b(str).Q = true;
      this.jdField_a_of_type_Ksn.b(str).jdField_f_of_type_Int = 2;
      this.jdField_a_of_type_Ksn.b(str).jdField_i_of_type_Int = 0;
      this.jdField_a_of_type_Ksn.b(str).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
      this.jdField_a_of_type_Ksn.b(str).jdField_f_of_type_JavaLangString = null;
      this.jdField_a_of_type_Ksn.b(str).jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Ksn.b(str).a("onDoubleVideoMeetingInvite.3", 2);
      this.jdField_a_of_type_Ksn.b(str).I = true;
      this.jdField_a_of_type_Ksn.b(str).jdField_r_of_type_JavaLangString = String.valueOf(paramLong);
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
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
      new bedr(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_Ksn.a(l1, str);
      return;
      if ((a().m()) || (a().n()) || (a().o()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_d_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_Ksn.b(str).a("onDoubleVideoMeetingInvite.2", 2);
          o(true);
          a(a().jdField_d_of_type_JavaLangString, 299);
          b(299);
          b(a().jdField_d_of_type_JavaLangString, 2);
        }
        else if ((a().m()) || (a().n()))
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.jdField_t_of_type_Int + "], isQQPaused[" + kst.jdField_b_of_type_Boolean + "], isVideoPaused[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(a()) + "], seq[" + l1 + "]");
    }
    if ((this.y) && (this.jdField_t_of_type_Int == 0) && (!bool2) && (kst.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.23(this, l1, str, 0, String.valueOf(paramLong), true, bool1), 100L);
      return;
    }
    a(l1, str, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTerminalFail fromUin = " + paramString + ", info :" + paramInt);
    }
    a("onPeerSwitchTerminalFail", a());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void d(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRecvFirstAudioData, recvFirstAudio[" + paramBoolean + "], seq[" + l1 + "]");
    }
    if (paramBoolean)
    {
      if (!a().Q) {
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
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
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
  
  public ArrayList<kth> e()
  {
    if ((AudioHelper.d()) && (mej.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(mej.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void e()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null) {
      this.jdField_d_of_type_JavaLangRunnable = new VideoController.16(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 5000L);
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void e(int paramInt1, long paramLong, int paramInt2)
  {
    long l1 = AudioHelper.b();
    Object localObject = jdField_a_of_type_JavaLangString + "|VideoNodeManager";
    StringBuilder localStringBuilder = new StringBuilder().append("onCreateRoomSuc, relationType[").append(paramInt1).append("], groupId[").append(paramLong).append("], mGAudioCtrl[");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "], mutiAvType[" + paramInt2 + "], seq[" + l1 + "]");
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        break;
      }
      return;
    }
    a().jdField_M_of_type_Boolean = true;
    a().jdField_a_of_type_JavaUtilArrayList.clear();
    if ((mfs.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
      M();
    }
    label500:
    for (;;)
    {
      a("onCreateRoomSuc");
      this.jdField_e_of_type_Boolean = true;
      a().ap = false;
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
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject == null) {
        break;
      }
      ((lad)localObject).a(a());
      return;
      int i1;
      if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
      {
        int i2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
        localObject = new long[i2];
        i1 = 0;
        while (i1 < i2)
        {
          localObject[i1] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject, 4);
      }
      else
      {
        if (AudioHelper.a(19) == 1) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label500;
          }
          AudioHelper.a(ajjy.a(2131650327));
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4);
          break;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ktp.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void e(String paramString)
  {
    int i1 = 4;
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "onChannelReady, fromUin[" + paramString + "], mStartRing[" + this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable + "], seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    kvq localkvq = ksn.a().a(paramString);
    if (localkvq == null) {
      localkvq = a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onChannelReady, fromUin[" + paramString + "], session[" + localkvq + "]");
      }
      kyj.a(30);
      kyj.a(9, localkvq.b());
      kyj.a(11, localkvq.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mip.a(a()).a();
      if (1L == localkvq.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Miu.b(l1);
        if ((localkvq.Q) && (localkvq.jdField_e_of_type_Boolean) && (!l())) {
          this.jdField_a_of_type_Miu.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        a(true, localkvq.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Miu.b(l1);
      if (localkvq.jdField_i_of_type_Int != 1011) {
        miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
      }
      localkvq.b(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString));
      localkvq.c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString));
      k();
      localkvq.a("onChannelReady", 4);
      localkvq.a(l1, SystemClock.elapsedRealtime());
      label381:
      Object localObject;
      if ((localkvq.jdField_e_of_type_Boolean) && (!l()))
      {
        if (localkvq.Q) {
          this.jdField_a_of_type_Miu.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        if ((localkvq.jdField_d_of_type_Int == 1) && (localkvq.jdField_i_of_type_Int == 1011))
        {
          localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 5;
          a(localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int, 1, null);
        }
        localObject = (kyl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (localkvq.jdField_e_of_type_Boolean) {
          i1 = 11;
        }
        ((kyl)localObject).a(localkvq.b(), i1, 1L);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
          break label749;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
        if (l()) {
          a(l1, 2131230736, 1, null);
        }
        c();
        label517:
        if (!localkvq.jdField_g_of_type_Boolean) {
          break label756;
        }
        a(true, localkvq.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l1), 50L);
        a(localkvq.jdField_c_of_type_JavaLangString, localkvq.jdField_d_of_type_Int, true, true, true);
        mga.i(this);
        mga.c(this, true);
        mga.b(this, true);
        l1 = f();
        localObject = baig.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putLong("qav_roomid", l1).commit();
        l1 = c(paramString);
        ((SharedPreferences)localObject).edit().putLong(kst.jdField_g_of_type_JavaLangString, l1).commit();
        p(false);
        paramString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString != null) {
          paramString.a();
        }
        if (this.jdField_a_of_type_Ksq != null) {
          this.jdField_a_of_type_Ksq.a();
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString == null) {
          break;
        }
        paramString.a(localkvq);
        return;
        if (this.jdField_a_of_type_Miu.a()) {
          break label381;
        }
        this.jdField_a_of_type_Miu.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label381;
        label749:
        c();
        break label517;
        label756:
        a(false, localkvq.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    if (!a().ag)
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
    if (a().ai)
    {
      paramInt = i1;
      if (a().jdField_d_of_type_Int == 1)
      {
        paramInt = i1;
        if (e())
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
    int i1 = lbn.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().jdField_A_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public boolean e()
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
        long l1 = mfy.a(str1);
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
      kth localkth = (kth)localIterator.next();
      if ((localkth.jdField_c_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(localkth.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(localkth.jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  void f()
  {
    long l1 = AudioHelper.b();
    if (this.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.jdField_e_of_type_JavaLangRunnable = new VideoController.17(this, l1);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_e_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 15000L);
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
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onSetMicBySelf uin = " + paramLong);
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        kth localkth = (kth)localIterator.next();
        if (localkth.jdField_a_of_type_Long == paramLong) {
          if (!localkth.jdField_f_of_type_Boolean)
          {
            localkth.jdField_f_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
          }
        }
      }
      return;
    }
  }
  
  public void f(String paramString)
  {
    kvq localkvq = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + localkvq.jdField_k_of_type_Boolean + "], isOnlyAudio[" + localkvq.Q + "], seq[" + l1 + "]");
    if (lie.a(BaseApplication.getContext()) == 1) {
      localkvq.b(l1, false);
    }
    while ((localkvq.jdField_d_of_type_Int != 2) || (!localkvq.jdField_k_of_type_Boolean)) {
      return;
    }
    localkvq.b(l1, false);
    if (!localkvq.jdField_j_of_type_Boolean)
    {
      localkvq.Q = true;
      localkvq.a(l1, "onPauseVideo", 1);
      c(localkvq.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    mga.n(this);
  }
  
  public void f(String paramString, int paramInt)
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
      baig.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(kst.h, paramString).commit();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "SetNetIPAndPort fail.", paramString);
    }
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
    boolean bool = false;
    long l1 = AudioHelper.b();
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
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
  }
  
  void g()
  {
    GraphicRenderMgr.getInstance().decoderPtrRef = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0);
    }
  }
  
  public void g(int paramInt)
  {
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDetectAudioDataIssue, issueType[" + this.jdField_d_of_type_Int + "->" + paramInt + "], seq[" + l1 + "]");
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt), Long.valueOf(l1) });
  }
  
  public void g(String paramString)
  {
    kvq localkvq = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + localkvq.jdField_k_of_type_Boolean + "], isOnlyAudio[" + localkvq.Q + "], seq[" + l1 + "]");
    if ((localkvq.jdField_f_of_type_Int == 1) && (!e())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (localkvq.jdField_k_of_type_Boolean);
      localkvq.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      mga.m(this);
    } while (localkvq.jdField_d_of_type_Int != 1);
    localkvq.a(l1, "onResumeVideo", 2);
    localkvq.Q = false;
  }
  
  public void g(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  void g(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    kvq localkvq = a();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + localkvq + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(localkvq.jdField_d_of_type_JavaLangString).longValue();
    int i1 = localkvq.jdField_d_of_type_Int;
    long l3 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    int i2 = localkvq.jdField_i_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      leb localleb1 = new leb();
      leb localleb2 = new leb();
      localleb1.jdField_a_of_type_Long = l2;
      localleb1.jdField_a_of_type_Int = 1;
      localleb2.jdField_a_of_type_Long = l2;
      localleb2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localleb2);
      localArrayList.add(localleb1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (localkvq.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
      }
    }
    for (;;)
    {
      n(true);
      a(l1, l2, true, 0);
      a().jdField_d_of_type_JavaLangString = String.valueOf(l2);
      a().a(l1, "notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      a().I = false;
      a().J = false;
      a().jdField_K_of_type_Boolean = true;
      this.jdField_m_of_type_Boolean = bool;
      if (paramBoolean)
      {
        e();
        a().a(4, 11);
        a().b("notifyChangeDoubleVideoMeeting2MultiVideo", mfs.a(i2));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.jdField_m_of_type_Boolean + "], session[" + localkvq + "], seq[" + l1 + "]");
      }
      return;
      if (localkvq.a(l3, 1) != -1) {
        localkvq.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
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
    if (a().jdField_K_of_type_Int == 3)
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
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ksy(this);
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
  
  public void h(String paramString)
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
  
  public void h(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(43), paramString, Integer.valueOf(paramInt) });
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_Kvr.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_Kvr.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_c_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      kvq localkvq = a();
      if (paramBoolean)
      {
        a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (localkvq != null)
        {
          localkvq.jdField_a_of_type_Kvr.jdField_f_of_type_Boolean = false;
          localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          localkvq.a();
          localkvq.b();
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
        if (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((a().jdField_a_of_type_Kvr.jdField_a_of_type_Int == 1) || (a().jdField_a_of_type_Kvr.jdField_a_of_type_Int == 2))
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
    if ((a().j()) || (this.jdField_e_of_type_Boolean)) {
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
  
  public void i(String paramString)
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
          kth localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (localkth != null)
          {
            bool2 = bool1;
            if (!localkth.jdField_g_of_type_Boolean) {
              break label231;
            }
            if ((localkth.jdField_c_of_type_Long >= 2000L) && (localkth.jdField_c_of_type_Long < this.jdField_c_of_type_Long))
            {
              l1 = localkth.jdField_c_of_type_Long;
              bool2 = bool1;
              if (l2 - localkth.jdField_b_of_type_Long <= l1) {
                break label231;
              }
              localkth.jdField_g_of_type_Boolean = false;
              localkth.jdField_b_of_type_Long = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + localkth.jdField_a_of_type_Long + ",isSuspectNoisy = " + localkth.jdField_g_of_type_Boolean);
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
  
  public void j(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
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
      kth localkth = (kth)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
      if ((localkth == null) || (!localkth.jdField_g_of_type_Boolean)) {
        break label139;
      }
      if (l1 == localkth.jdField_a_of_type_Long) {
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
  
  public int k()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getOnPeerFrameRenderEndFunctionPtr();
    }
    return 0;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    p(true);
    a(paramString, 206);
    b(206);
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
      if (a().C == 2)
      {
        awqx.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
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
        if ((a().C == 1) && (a().jdField_A_of_type_Int == 10)) {
          awqx.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public void l()
  {
    boolean bool1 = lbk.c();
    boolean bool2 = lbk.d();
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
          long l1 = mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          int i1 = c();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1, "8.2.6");
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTerninal fromUin = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    a().ah = true;
    a("onPeerSwitchTerninal", a());
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localktm != null) {
        localktm.a(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Kvr.jdField_b_of_type_Int < 6);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    a(paramString, 207);
    b(207);
    b(paramString, 7);
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localktm != null) {
        localktm.b(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    kvq localkvq = a();
    boolean bool1 = bool2;
    if (localkvq != null)
    {
      bool1 = bool2;
      if (localkvq.jdField_a_of_type_Kvs.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (localkvq.jdField_a_of_type_Kvs.jdField_a_of_type_Long > 0L) {
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localktm != null) {
        localktm.c(paramBoolean);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    a().F = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void o(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localktm != null) {
        localktm.d(paramBoolean);
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
      l1 = mfy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1;
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (l1 == ((kth)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long))
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localktm != null) {
        localktm.e(paramBoolean);
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_k_of_type_JavaLangRunnable, 3000L);
  }
  
  public void q(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      ktm localktm = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localktm != null) {
        localktm.f(paramBoolean);
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_k_of_type_JavaLangRunnable);
  }
  
  public void r(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void r(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "callBackNetStatus <--receiveEcho Cost = " + l1);
      if (l1 < 3000L) {
        h(1);
      }
    }
    for (;;)
    {
      this.jdField_g_of_type_Long = -1L;
      return;
      h(2);
      continue;
      h(4);
    }
  }
  
  public boolean r()
  {
    if (!lfi.a()) {}
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Lfi != null)
      {
        if ((lft.b()) || (lft.c())) {
          return true;
        }
        kvq localkvq = a();
        if ((localkvq.jdField_d_of_type_Int == 2) || (localkvq.jdField_d_of_type_Int == 4)) {}
        for (int i1 = 1; (i1 != 0) && ((!localkvq.jdField_a_of_type_JavaUtilBitSet.isEmpty()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()) || (localkvq.av)); i1 = 0) {
          return true;
        }
      }
    }
  }
  
  public void s()
  {
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_Kvr.jdField_b_of_type_Int >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void s(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(129), paramString });
  }
  
  public void t()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
  
  public void t(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
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
      ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label71:
    do
    {
      for (;;)
      {
        return;
        leb localleb1 = (leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        localleb1.jdField_a_of_type_Boolean = true;
        if (localleb1.jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue())
        {
          if (i1 != 0)
          {
            localleb2 = (leb)a().jdField_c_of_type_JavaUtilArrayList.get(0);
            localleb2.jdField_a_of_type_Boolean = false;
            a().jdField_c_of_type_JavaUtilArrayList.set(0, localleb1);
            a().jdField_c_of_type_JavaUtilArrayList.set(i1, localleb2);
          }
          synchronized (a().jdField_d_of_type_JavaUtilArrayList)
          {
            a().jdField_d_of_type_JavaUtilArrayList.set(0, localleb1);
            a().jdField_d_of_type_JavaUtilArrayList.set(i1, localleb2);
            a().c();
            if (a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) == -1)
            {
              i1 = 0;
              if (i1 < a().jdField_c_of_type_JavaUtilArrayList.size())
              {
                if (((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
                  ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
                }
                i1 += 1;
              }
            }
          }
        }
      }
    } while (i1 == 0);
    leb localleb2 = (leb)a().jdField_c_of_type_JavaUtilArrayList.get(0);
    localleb2.jdField_a_of_type_Boolean = false;
    a().jdField_c_of_type_JavaUtilArrayList.set(0, localObject1);
    a().jdField_c_of_type_JavaUtilArrayList.set(i1, localleb2);
    synchronized (a().jdField_d_of_type_JavaUtilArrayList)
    {
      a().jdField_d_of_type_JavaUtilArrayList.set(0, localObject1);
      a().jdField_d_of_type_JavaUtilArrayList.set(i1, localleb2);
      a().c();
      return;
    }
    label420:
    ((leb)a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void u(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(132), paramString });
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().C == 2) {
        awqx.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
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
        if ((a().C == 1) && (a().jdField_A_of_type_Int == 10)) {
          awqx.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void v(String paramString)
  {
    long l1 = AudioHelper.b();
    kvq localkvq = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + localkvq.jdField_d_of_type_JavaLangString + "], extraUin[" + localkvq.jdField_f_of_type_JavaLangString + "], remoteHasVideo[" + localkvq.jdField_k_of_type_Boolean + "], mXiaoweiDevice[" + this.jdField_r_of_type_Boolean + "], seq[" + l1 + "]");
    if ((TextUtils.equals(localkvq.jdField_d_of_type_JavaLangString, paramString)) || (TextUtils.equals(localkvq.jdField_f_of_type_JavaLangString, paramString)) || (this.jdField_r_of_type_Boolean))
    {
      if ((localkvq.jdField_f_of_type_Int != 1) || (e())) {
        break label165;
      }
      krx.d(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
    }
    for (;;)
    {
      return;
      label165:
      if (localkvq.jdField_d_of_type_Int == 1) {
        c(2);
      }
      if (!localkvq.jdField_k_of_type_Boolean)
      {
        localkvq.b(l1, true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
        mga.m(this);
        if (localkvq.jdField_d_of_type_Int == 1)
        {
          localkvq.a(l1, "onNeedShowPeerVideo", 2);
          localkvq.Q = false;
        }
      }
      while (!TextUtils.equals(localkvq.jdField_d_of_type_JavaLangString, paramString))
      {
        GraphicRenderMgr.getInstance().onUinChanged(localkvq.jdField_d_of_type_JavaLangString, paramString);
        return;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
      }
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
    a().ak = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    x(paramString);
  }
  
  public void x()
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.jdField_o_of_type_Int + "]");
    this.jdField_o_of_type_Int = 0;
  }
  
  public void x(String paramString)
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
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (lba.b(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = h();
      if (!bool1)
      {
        a("onHowling", this.jdField_a_of_type_Long, false, false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().N;
      if (bool2) {
        this.jdField_a_of_type_Miu.d();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131630231), 2131625035, 2131629116, new ktb(this), new ktc(this, bool1, bool2));
      awqx.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public void y(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void z()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onOpenMicFail");
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131630315, 1).a();
    }
    Object localObject = a();
    if (localObject != null) {
      if (((kvq)localObject).C != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      lbr.a((String)localObject);
      return;
    }
  }
  
  public void z(String paramString)
  {
    a("deviceMemory", kyj.c() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */