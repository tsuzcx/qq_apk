package com.tencent.av;

import achd;
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
import anzj;
import bdll;
import bdmc;
import bhhv;
import bhlo;
import bhmq;
import bhnv;
import bhoj;
import bhoo;
import bhsi;
import bhxi;
import bihq;
import blfn;
import blhc;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.AVSoUtils;
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
import lbj;
import lbn;
import lbz;
import lcb;
import lce;
import lch;
import lcl;
import lcm;
import lcn;
import lco;
import lcp;
import lcq;
import lcr;
import lcs;
import lct;
import lcv;
import lcw;
import lcy;
import lda;
import ldb;
import ldd;
import lde;
import ldf;
import lev;
import lff;
import lfg;
import lfh;
import lfr;
import lic;
import lie;
import lje;
import ljz;
import lkg;
import lkw;
import lla;
import llb;
import lld;
import llf;
import llg;
import llk;
import lln;
import llq;
import llr;
import lms;
import lnd;
import lnv;
import lnz;
import lob;
import lpm;
import lsv;
import lwf;
import lzq;
import mbb;
import mev;
import mjq;
import mlc;
import moq;
import mqb;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mrl;
import mrs;
import mru;
import msz;
import mta;
import mtd;
import mtl;
import mtn;
import mtr;
import muk;
import mum;
import mur;
import mvd;
import tencent.im.cs.net.echo.ReqEcho;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;

public class VideoController
  extends lla
  implements lld, llg, lnz
{
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  private static String jdField_f_of_type_JavaLangString;
  public static int o;
  public static int p;
  public static int q;
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
  ArrayList<lcv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  public lbz a;
  lcb jdField_a_of_type_Lcb = lcb.a();
  private volatile lce jdField_a_of_type_Lce;
  public final lch a;
  lcw jdField_a_of_type_Lcw = new lcl(this);
  public lkg a;
  public llb a;
  private lpm jdField_a_of_type_Lpm;
  private mjq jdField_a_of_type_Mjq;
  public msz a;
  mta jdField_a_of_type_Mta;
  public mur a;
  oidb_0x8dd.SelfInfo jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = new oidb_0x8dd.SelfInfo();
  boolean jdField_a_of_type_Boolean = true;
  private moq[] jdField_a_of_type_ArrayOfMoq;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoController.2(this);
  private ArrayList<lcv> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public lcw b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  public Runnable c;
  private final ArrayList<lcv> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  lcw jdField_c_of_type_Lcw = new lcn(this);
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
  boolean jdField_g_of_type_Boolean = true;
  int jdField_h_of_type_Int = 0;
  Runnable jdField_h_of_type_JavaLangRunnable = null;
  public volatile boolean h;
  int jdField_i_of_type_Int = 1;
  Runnable jdField_i_of_type_JavaLangRunnable = null;
  boolean jdField_i_of_type_Boolean = false;
  int jdField_j_of_type_Int = 2;
  Runnable jdField_j_of_type_JavaLangRunnable = null;
  boolean jdField_j_of_type_Boolean = false;
  int jdField_k_of_type_Int = 3;
  Runnable jdField_k_of_type_JavaLangRunnable = new VideoController.31(this);
  boolean jdField_k_of_type_Boolean = false;
  int jdField_l_of_type_Int = 4;
  private Runnable jdField_l_of_type_JavaLangRunnable = new VideoController.30(this);
  boolean jdField_l_of_type_Boolean = false;
  public int m;
  private Runnable m;
  public boolean m;
  int n;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  int jdField_r_of_type_Int = jdField_o_of_type_Int;
  boolean jdField_r_of_type_Boolean = false;
  private int jdField_s_of_type_Int = 0;
  boolean jdField_s_of_type_Boolean = false;
  private int jdField_t_of_type_Int;
  boolean jdField_t_of_type_Boolean = false;
  private int u;
  public boolean u;
  private int jdField_v_of_type_Int = -1;
  private boolean jdField_v_of_type_Boolean;
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
    jdField_o_of_type_Int = -1;
    jdField_p_of_type_Int = 1;
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Lch = new lch(this);
    this.jdField_c_of_type_Long = 6000L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Lcw = new lcm(this);
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_u_of_type_Int = 1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_n_of_type_Int = 0;
    this.jdField_g_of_type_Long = -1L;
    if (!mrl.a()) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_ComTencentAvCompatInviteUIChecker = new InviteUIChecker();
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoController create.");
      }
      return;
      this.jdField_a_of_type_Lkg = new lkg();
    }
  }
  
  private void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initOrientationListener");
    }
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new lct(this, a(), 3);
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
      lbj.c(jdField_a_of_type_JavaLangString, " ---setMicrophoneMute:" + bool + "|" + (l2 - l1));
    }
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processActive fail:mApp is null");
      }
    }
    lda locallda;
    do
    {
      return;
      locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } while (locallda == null);
    locallda.a();
  }
  
  private void M()
  {
    Object localObject = a();
    int i4;
    int i2;
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
    {
      int i3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
      long l1 = ((lff)localObject).jdField_h_of_type_Long;
      localObject = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
      int i1 = this.jdField_e_of_type_Int;
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
    if (this.jdField_a_of_type_Llb == null)
    {
      this.jdField_a_of_type_Llb = new llb(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a().jdField_j_of_type_Int = 9500;
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
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
      boolean bool2 = this.jdField_u_of_type_Boolean;
      localStartAudioSendRunnable = this.jdField_a_of_type_ComTencentAvVideoController$StartAudioSendRunnable;
      if (paramBoolean1) {
        break label307;
      }
      if ((!paramBoolean2) && (!this.jdField_u_of_type_Boolean)) {
        break label301;
      }
      bool1 = true;
      this.jdField_u_of_type_Boolean = bool1;
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
      paramString = new StringBuilder().append("switchAudioSend[").append(paramString).append("], seq[").append(paramLong).append("], flag[").append(paramInt).append("], enable[").append(paramBoolean1).append("], notifySvr[").append(paramBoolean2).append("], mIsMicOffBySelf[").append(bool2).append("->").append(this.jdField_u_of_type_Boolean).append("], result[").append(i1).append("], mGAudioCtrl[");
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
      this.jdField_u_of_type_Boolean = false;
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
  
  private lff a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = lcb.a(3, paramString, new int[0]);
      localObject2 = lcb.a().c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = lcb.a(100, paramString, new int[0]);
        localObject1 = lcb.a().c((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = lcb.a().b(paramString);
      }
      return localObject2;
      if (paramInt == 4)
      {
        localObject1 = lcb.a(4, paramString, new int[0]);
        localObject1 = lcb.a().c((String)localObject1);
      }
    }
  }
  
  private void a(int paramInt, long paramLong1, lnd paramlnd, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    if ((paramInt == 7) && (!paramBoolean) && (this.jdField_a_of_type_Lcb.a()))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
      return;
    }
    long l1 = paramlnd.jdField_a_of_type_Long;
    long l2 = mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    boolean bool1;
    if (l2 == l1)
    {
      bool1 = true;
      paramVarArgs = lcb.a(paramInt, String.valueOf(paramLong1), new int[0]);
      if (paramInt != 3) {
        break label1684;
      }
      paramVarArgs = lcb.a(100, String.valueOf(paramLong1), new int[0]);
    }
    label531:
    label1684:
    for (;;)
    {
      if (paramInt == 1) {}
      for (??? = a();; ??? = lcb.a().c(paramVarArgs))
      {
        if ((??? != null) && (!TextUtils.isEmpty(((lff)???).jdField_c_of_type_JavaLangString))) {
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioUserEnterOrLeave, mGAudioGroupId[" + this.jdField_a_of_type_Long + "], relationId[" + paramLong1 + "], mGAudioRelationType[" + this.jdField_c_of_type_Int + "], relationType[" + paramInt + "], UserInfo[" + paramlnd + "], isEnter[" + paramBoolean + "], bSelfIn[" + bool1 + "], selfUin[" + l2 + "], mGAudioMute[" + this.jdField_l_of_type_Boolean + "], switchToGAudioMode[" + ((lff)???).G + "], extroInfo = " + paramLong2 + "], seq[" + l3 + "]");
      }
      if ((paramBoolean) && (bool1))
      {
        a("onGAudioUserEnterOrLeave", true, paramInt, paramLong1);
        ((lff)???).jdField_V_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
        if (this.jdField_l_of_type_Boolean) {
          break label531;
        }
        bool2 = true;
        a("onGAudioUserEnterOrLeave", bool2, ((lff)???).a());
        if (((this.jdField_c_of_type_Int == 1) && (((lff)???).D == 10)) || (this.jdField_c_of_type_Int == 2)) {
          if (paramLong2 != 0L) {
            break label537;
          }
        }
      }
      label537:
      for (boolean bool2 = false;; bool2 = true)
      {
        ((lff)???).jdField_ad_of_type_Boolean = bool2;
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
      a(paramlnd, paramBoolean);
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
        paramVarArgs.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 4;
        label598:
        if ((!bool1) && ((m()) || (l())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c())) {
          this.jdField_a_of_type_Mur.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        a(paramVarArgs.jdField_a_of_type_Lfg.jdField_b_of_type_Int, 3, null);
        ??? = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((??? != null) && (((mtn)???).a())) {
          c();
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
            mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
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
          if (paramlnd.jdField_a_of_type_Int != 0) {
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
            paramlnd = a();
            if (paramlnd != null) {
              paramlnd.b(paramLong1);
            }
          }
          paramlnd = new Intent();
          paramlnd.setAction("tencent.av.v2q.MultiVideo");
          if (!paramBoolean) {
            break label1504;
          }
          paramlnd.putExtra("type", 401);
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramlnd.putExtra("relationType", 3);
          paramlnd.putExtra("relationId", paramLong1);
          paramlnd.putExtra("friendUin", l1);
          paramlnd.putExtra("MultiAVType", paramVarArgs.D);
          paramlnd.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramlnd);
          if (paramBoolean) {
            break;
          }
          if (paramVarArgs.jdField_K_of_type_Boolean)
          {
            paramlnd = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            t();
            if (paramlnd.a()) {
              paramlnd.a(paramVarArgs.jdField_c_of_type_JavaLangString);
            }
          }
          if (!paramVarArgs.ap) {
            break;
          }
          a(l3, paramLong1, false, 2);
          return;
          label1069:
          paramVarArgs.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 1;
          break label598;
          label1081:
          paramVarArgs.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 5;
          break label598;
          label1093:
          if (i() == 1) {
            paramVarArgs.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 4;
          }
          if ((bool1) || ((!m()) && (!l())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) || (!m())) {
            break label647;
          }
          this.jdField_a_of_type_Mur.a(l3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
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
            if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (((lcv)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
            {
              i1 = 1;
              if (i1 != 0)
              {
                paramVarArgs.a("onGAudioUserEnterOrLeave.3", 9);
                paramVarArgs.af = true;
                ??? = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                if ((??? != null) && (((mtn)???).a()))
                {
                  t();
                  c();
                }
              }
              mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
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
          if (paramlnd.jdField_a_of_type_Int == 0) {}
          for (bool2 = true;; bool2 = false)
          {
            ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
            break;
          }
        }
        ??? = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramlnd.jdField_a_of_type_Int == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          ((VideoAppInterface)???).a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool2) });
          break;
        }
        label1504:
        paramlnd.putExtra("type", 402);
      }
      label1519:
      paramlnd = new Intent();
      paramlnd.setAction("tencent.av.v2q.MultiVideo");
      if (paramBoolean)
      {
        paramlnd.putExtra("type", 22);
        paramlnd.putExtra("isStart", this.jdField_r_of_type_Boolean);
      }
      for (;;)
      {
        paramlnd.putExtra("roomUserNum", this.jdField_c_of_type_JavaUtilArrayList.size());
        paramlnd.putExtra("relationType", paramInt);
        paramlnd.putExtra("relationId", paramLong1);
        paramlnd.putExtra("friendUin", l1);
        paramlnd.putExtra("MultiAVType", a().D);
        paramlnd.putExtra("from", "VideoController5");
        paramlnd.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramlnd);
        return;
        paramlnd.putExtra("type", 23);
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
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
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
    long l1 = mrl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    if (paramInt1 == 3) {}
    for (Object localObject = lcb.a(100, String.valueOf(paramLong1), new int[0]);; localObject = lcb.a(paramInt1, String.valueOf(paramLong1), new int[0]))
    {
      localObject = this.jdField_a_of_type_Lcb.c((String)localObject);
      if (localObject != null) {
        ((lff)localObject).b(paramLong2, paramBoolean1, paramBoolean2);
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
    lcv locallcv = a(String.valueOf(paramLong1));
    if (locallcv == null) {
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
        locallcv.jdField_b_of_type_Boolean = paramBoolean;
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
      if (locallcv.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue()) {
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
      lob locallob1 = new lob();
      if (paramBoolean2) {
        ((lcv)???).jdField_b_of_type_Int = 2;
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
          ((lcv)???).jdField_b_of_type_Int = 1;
          continue;
          l1 = 5L;
        }
      }
      label489:
      a().a(0, locallob2);
      return;
    }
    ((lcv)???).jdField_b_of_type_Int = 0;
    a(paramLong, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 2, false);
    u();
  }
  
  private void a(Intent paramIntent)
  {
    lkg locallkg = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent);
    if (locallkg != null) {
      locallkg.a(paramIntent);
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
    lkg locallkg = a();
    ldf.b("Video:StartActivity", 5000L);
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 16))
    {
      ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), 2130772170, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().startActivity(paramIntent, localActivityOptions.toBundle());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "startInvite startActivity");
      if (locallkg != null) {
        locallkg.a(paramIntent);
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
    lcv locallcv = a(String.valueOf(paramLong));
    if (locallcv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
      }
      return false;
    }
    locallcv.jdField_a_of_type_Boolean = paramBoolean;
    locallcv.jdField_a_of_type_Int = paramInt;
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
    this.jdField_m_of_type_JavaLangRunnable = new VideoController.35(this, paramString1, paramLong, paramInt1, paramString2, paramString3, paramBoolean1, paramBoolean3, paramInt2);
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
    lff locallff;
    do
    {
      return false;
      locallff = lcb.a().a();
    } while ((locallff == null) || (locallff.jdField_d_of_type_JavaLangString == null) || (!paramString.equals(locallff.jdField_d_of_type_JavaLangString)));
    return true;
  }
  
  private void e(Bundle paramBundle)
  {
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("fromUin");
    this.jdField_w_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
  }
  
  private boolean e(String paramString)
  {
    int i1 = (int)(System.currentTimeMillis() / 1000L);
    int i2 = this.jdField_w_of_type_Int;
    return (this.jdField_g_of_type_JavaLangString != null) && (paramString != null) && (this.jdField_g_of_type_JavaLangString.equals(paramString)) && (i1 - i2 < 3);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isLandscape screenWidth: " + i1 + ", screenHeight: " + i2 + ", rotation: " + i3 + ", orientation: " + this.jdField_s_of_type_Int);
    }
    return (i1 > i2) || (i3 == 1) || (i3 == 3) || (this.jdField_s_of_type_Int == 4) || (this.jdField_s_of_type_Int == 2);
  }
  
  public void A()
  {
    lff locallff = a();
    if (locallff != null)
    {
      int i2 = locallff.jdField_V_of_type_Int;
      int i1 = i2;
      if (i2 == 0) {
        i1 = locallff.U;
      }
      b(i1);
      if ((i1 == 0) || (!locallff.aA)) {
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
    bdll.b(null, "dc00899", "grp_lbs", "", "video_chat", "app_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
    bdll.b(null, "dc00899", "grp_lbs", "", "video_chat", "visit_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", l1 + "", "");
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void D()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      return;
    }
    long l1 = (System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L;
    if (this.jdField_a_of_type_Lbz == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Lbz.jdField_a_of_type_JavaLangString)
    {
      bdll.b(null, "dc00899", "grp_lbs", str, "video_chat", "video_time", 0, 0, this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_charm_level.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_gender.get() + "", this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.uint32_age.get() + "", l1 + "");
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
    this.jdField_a_of_type_Mur.b(l1);
    this.jdField_a_of_type_Mur.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230738, null, 1, null);
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
    switch (bhnv.a(null))
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
    lff locallff = a();
    long l1 = AudioHelper.b();
    String str;
    int i1;
    if ((locallff.l()) || (locallff.m()) || (locallff.jdField_g_of_type_Int == 9) || (locallff.n()))
    {
      lzq.a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
      str = locallff.jdField_c_of_type_JavaLangString;
      i1 = locallff.jdField_d_of_type_Int;
      if (locallff.jdField_g_of_type_Int == 9) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      a(str, i1, false, bool, locallff.x());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reNotifyChatInfo2QQ, sessionInfo[" + locallff + "]");
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
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
    lbj.c(jdField_a_of_type_JavaLangString, "setGatewayTestResult networkType:" + paramInt1 + " | signalStrength:" + paramInt2 + " | pingResult:" + paramInt3);
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
      l();
    }
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    lbj.b("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + paramBoolean + "  getSessionInfo().multiAVType = " + a().D);
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
    localObject1 = lcb.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      localObject1 = lcb.a(100, String.valueOf(paramLong), new int[0]);
    }
    long l1;
    int i2;
    int i1;
    if (!this.jdField_a_of_type_Lcb.a((String)localObject1))
    {
      localObject2 = this.jdField_a_of_type_Lcb.a((String)localObject1, true);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((lff)localObject2).F = paramInt1;
        ((lff)localObject2).D = paramInt2;
        localObject1 = localObject2;
      }
      this.jdField_m_of_type_Boolean = false;
      l1 = mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
      if ((((lff)localObject1).J) && (((lff)localObject1).aF)) {
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
          this.jdField_j_of_type_JavaLangRunnable = new VideoController.22(this, paramInt1, paramLong);
        }
        this.jdField_r_of_type_Boolean = true;
        ((lff)localObject1).a("startGAudioChat.2", 8);
        ((lff)localObject1).jdField_g_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 30000L);
        h();
        a(((lff)localObject1).jdField_c_of_type_JavaLangString, 3, false, false, false);
        return 0;
        localObject1 = this.jdField_a_of_type_Lcb.c((String)localObject1);
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
          ((lff)localObject1).jdField_g_of_type_Long = paramLong;
          ((lff)localObject1).F = paramInt1;
          ((lff)localObject1).D = paramInt2;
          ((lff)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
          ((lff)localObject1).jdField_j_of_type_Int = 0;
          ((lff)localObject1).e("startGAudioChat", true);
          i2 = 1;
          i1 = paramInt2;
          paramInt2 = i2;
          break label372;
        }
        return -1;
        if (((lff)localObject1).b()) {
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
          lcv locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallcv != null) && (locallcv.jdField_a_of_type_Long == paramLong)) {
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
        paramLong1 = mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
          h();
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo acceptRequest, peerUin[" + paramString + "], businessType[" + paramInt1 + "], relationType[" + paramInt2 + "], uiMode[" + this.jdField_g_of_type_Int + "], seq[" + paramLong + "]");
    if ((q()) && (this.jdField_g_of_type_Int != 3) && (!paramString.equals(a().jdField_d_of_type_JavaLangString)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,is nearby");
      return -1;
    }
    if (!bhnv.d(BaseApplication.getContext()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,network not support");
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "acceptRequest fail,mVcCtrl is null");
      return -1;
    }
    lff locallff = a(paramInt2, paramString);
    if (locallff == null) {
      locallff = a();
    }
    for (;;)
    {
      k(false);
      if ((locallff.jdField_j_of_type_Int == 1011) || (locallff.jdField_j_of_type_Int == 21)) {
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
          QLog.i(jdField_a_of_type_JavaLangString, 2, "acceptRequest, result[" + paramInt1 + "], peerUin[" + paramString + "], relationType[" + paramInt2 + "], session[" + locallff + "]");
        }
        if (paramInt1 == 0)
        {
          locallff.a("acceptRequest", 3);
          j();
        }
        if (this.jdField_a_of_type_Llb != null) {
          achd.a(null, "Usr_TV_Video", 4, 0, 0);
        }
        ((lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 9, 1L);
        lic.a(37);
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
      if (bhnv.d(BaseApplication.getContext())) {
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
      N();
      i1 = -1;
      l1 = 0L;
      if (paramString1.ai)
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
      ((lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(-1L, 2, 1L);
      lic.a(28);
      lic.a(11, str);
      lic.a(12, 1L);
      if (!paramString1.S) {
        break label1027;
      }
      l2 = 1L;
      label617:
      lic.a(13, l2);
      lic.a(15, 1L);
      K();
      if ((paramString1.jdField_j_of_type_Int != 1011) && (paramString1.jdField_j_of_type_Int != 21)) {
        break label1041;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
      }
      paramString1.S = true;
      if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue() <= Long.valueOf(str).longValue()) {
        break label1035;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      label745:
      AVReport.a().o = paramString1.S;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "request result = " + i1 + ", uinType = " + paramInt3 + ", accostType = " + i2);
      if (i1 == 0)
      {
        paramString1.a("request", 1);
        paramString1.jdField_j_of_type_Int = paramInt3;
        paramString1.jdField_k_of_type_Int = i2;
        if ((paramString1.jdField_d_of_type_Int != 3) && (paramString1.jdField_d_of_type_Int != 4)) {
          paramString1.a(paramLong, SystemClock.elapsedRealtime());
        }
        h();
        if (!paramString1.S) {
          break label1444;
        }
      }
    }
    label1027:
    label1035:
    label1041:
    label1444:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      for (;;)
      {
        a(paramString1.jdField_c_of_type_JavaLangString, paramInt1, false, false, true);
        paramString1.jdField_o_of_type_Int = -1;
        this.jdField_k_of_type_Boolean = false;
        a(paramLong, paramString1.jdField_d_of_type_JavaLangString);
        c();
        paramString1.ag = false;
        a(str, 2, paramString1.jdField_a_of_type_Long);
        a(str, 1, 0L);
        a("deviceMemory", lic.c() + "");
        a("manufacturer", Build.MANUFACTURER);
        a("qqVersion", AppSetting.a(a()));
        if (this.jdField_a_of_type_Lce != null) {
          this.jdField_a_of_type_Lce.b();
        }
        this.jdField_a_of_type_Lce = new lce(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str);
        return i1;
        this.jdField_w_of_type_Boolean = true;
        break;
        l2 = 2L;
        break label617;
        i1 = 0;
        break label745;
        if (paramInt3 == 9500)
        {
          paramInt4 = 4200;
          try
          {
            l1 = mrs.a(str);
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
          paramString10 = lbn.a(paramString10);
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
        break label745;
      }
      if (1 != paramInt1) {
        break label745;
      }
      paramString1.S = false;
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(str, 0L, c(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i2, paramString5, paramString6, l1, paramArrayOfByte, (String)localObject, paramString7, paramString8, paramInt4, paramInt5, paramString9);
      break label745;
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
      h(paramString, 1);
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
      h(paramString, i1);
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
  
  public int a(lff paramlff, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserTerminalType(paramlff, paramString);
    }
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b();
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
    ldb localldb = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localldb != null) {
      localldb.c();
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
    lff locallff = lcb.a().a(paramString);
    if ((locallff != null) && (locallff.b() != 0L)) {
      l1 = locallff.b();
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
    } while (locallff == null);
    locallff.d(l2);
    return l2;
  }
  
  public long a(lff paramlff)
  {
    if (paramlff == null) {
      return 0L;
    }
    long l1 = paramlff.b();
    switch (paramlff.jdField_d_of_type_Int)
    {
    default: 
      return l1;
    }
    return a(paramlff.jdField_d_of_type_JavaLangString);
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
    return bhmq.a(paramBitmap, paramInt1, paramInt1, paramInt2);
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
      lcv locallcv;
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
          } while (a().jdField_a_of_type_Lfg.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return a().jdField_a_of_type_Lfg.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (a().jdField_a_of_type_Lfg.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return a().jdField_a_of_type_Lfg.jdField_b_of_type_AndroidGraphicsBitmap;
        if (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 3) {
          break;
        }
        locallcv = a(paramString);
      } while ((locallcv == null) || (locallcv.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + locallcv.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return locallcv.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 1) || (a().jdField_a_of_type_Lfg.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return a().jdField_a_of_type_Lfg.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }
  
  public VideoController a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo peerUin = " + paramString1 + ",key = " + paramString2 + ",value = " + paramString3 + ", isAllSessionIdle = " + this.jdField_a_of_type_Lcb.b());
    }
    long l2 = 0L;
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (!this.jdField_a_of_type_Lcb.b()))
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
  
  public Pair<Integer, ArrayList<lcv>> a()
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
        lcv locallcv = (lcv)((Iterator)localObject4).next();
        locallcv.jdField_h_of_type_Boolean = true;
        localArrayList2.add(locallcv);
        localHashSet.add(Long.valueOf(locallcv.jdField_a_of_type_Long));
      }
    }
    int i1 = localArrayList2.size();
    Object localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (lcv)((Iterator)localObject3).next();
      if (!localHashSet.contains(Long.valueOf(((lcv)localObject4).jdField_a_of_type_Long)))
      {
        ((lcv)localObject4).jdField_h_of_type_Boolean = false;
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
  
  public ArrayList<lcv> a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    lcv locallcv;
    while (localIterator.hasNext())
    {
      locallcv = (lcv)localIterator.next();
      localArrayList.add(locallcv);
      localHashSet.add(Long.valueOf(locallcv.jdField_a_of_type_Long));
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      locallcv = (lcv)localIterator.next();
      if (!localHashSet.contains(Long.valueOf(locallcv.jdField_a_of_type_Long)))
      {
        locallcv.jdField_h_of_type_Boolean = false;
        localArrayList.add(locallcv);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<lcv> a(int paramInt, ArrayList<lcv> paramArrayList)
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
        localObject2 = (lcv)paramArrayList.get(i2);
        if (((lcv)localObject2).jdField_a_of_type_Long == l2) {
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
      localObject2 = (lcv)paramArrayList.get(i2);
      if (((lcv)localObject2).jdField_a_of_type_Long == l2) {
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
      long l3 = ((lcv)localArrayList1.get(i2)).jdField_a_of_type_Long;
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
      Collections.sort((List)localObject2, new lcp(this));
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
      l2 = ((lcv)localArrayList1.get(paramInt)).jdField_a_of_type_Long;
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
      Collections.sort(localArrayList2, new lcq(this));
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
      lcv locallcv;
      synchronized (this.jdField_c_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 >= i2) {
          break label152;
        }
        locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
        if (locallcv == null) {
          break label158;
        }
        if (locallcv.jdField_a_of_type_Long == paramLong1)
        {
          if (!locallcv.jdField_e_of_type_Boolean)
          {
            locallcv.jdField_g_of_type_Boolean = paramBoolean;
            locallcv.jdField_b_of_type_Long = l1;
            locallcv.jdField_c_of_type_Long = paramLong2;
          }
        }
        else
        {
          if (!locallcv.jdField_g_of_type_Boolean) {
            break label158;
          }
          localArrayList2.add(Long.valueOf(locallcv.jdField_a_of_type_Long));
        }
      }
      if (locallcv.jdField_g_of_type_Boolean)
      {
        locallcv.jdField_g_of_type_Boolean = false;
        continue;
        label152:
        return localArrayList;
        label158:
        i1 += 1;
      }
    }
  }
  
  public lcv a(String paramString)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
        {
          lcv locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if ((locallcv == null) || (locallcv.jdField_a_of_type_Long != Long.valueOf(paramString).longValue())) {
            break label74;
          }
          paramString = locallcv;
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
  
  public lff a()
  {
    return this.jdField_a_of_type_Lcb.a();
  }
  
  public lkg a()
  {
    return this.jdField_a_of_type_Lkg;
  }
  
  public lpm a(Context arg1)
  {
    if (!lpm.b()) {
      return null;
    }
    if ((this.jdField_a_of_type_Lpm == null) && (??? != null)) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Lpm == null)
      {
        this.jdField_a_of_type_Lpm = new lpm(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        this.jdField_a_of_type_Lpm.c();
      }
      this.jdField_a_of_type_Lch.a(this.jdField_a_of_type_Lpm);
      return this.jdField_a_of_type_Lpm;
    }
  }
  
  @TargetApi(21)
  public mjq a()
  {
    if (this.jdField_a_of_type_Mjq == null) {
      this.jdField_a_of_type_Mjq = new mjq();
    }
    return this.jdField_a_of_type_Mjq;
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
    boolean bool = lje.a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onChangePreviewSize, size[" + paramInt1 + ", " + paramInt2 + "], localHasVideo[" + a().jdField_j_of_type_Boolean + "], preSize[" + lje.jdField_a_of_type_Int + ", " + lje.jdField_b_of_type_Int + "], seq[" + l1 + "], forbiddenReopenCamera[" + bool + "]");
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
    } while ((lje.jdField_a_of_type_Int == i2) && (lje.jdField_b_of_type_Int == i1));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32), Integer.valueOf(i2), Integer.valueOf(i1), Long.valueOf(l1) });
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
              a((lcv)localObject, paramInt1);
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
      ((lff)localObject).jdField_a_of_type_Lfg.jdField_a_of_type_Int = paramInt2;
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
      ((Intent)localObject).putExtra("guild_group_id", a().jdField_a_of_type_Lfh.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", i());
      ((Intent)localObject).putExtra("guild_business_type", a().jdField_a_of_type_Lfh.jdField_a_of_type_JavaLangString);
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
    //   2: invokestatic 694	com/tencent/mobileqq/utils/AudioHelper:b	()J
    //   5: lstore 12
    //   7: aload_0
    //   8: getfield 400	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   11: astore 18
    //   13: iload_1
    //   14: lload_2
    //   15: invokestatic 681	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   18: iconst_0
    //   19: newarray int
    //   21: invokestatic 654	lcb:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   24: astore 17
    //   26: iload_1
    //   27: iconst_3
    //   28: if_icmpne +1991 -> 2019
    //   31: bipush 100
    //   33: lload_2
    //   34: invokestatic 681	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: iconst_0
    //   38: newarray int
    //   40: invokestatic 654	lcb:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   43: astore 17
    //   45: aload_0
    //   46: getfield 112	com/tencent/av/VideoController:jdField_a_of_type_Lcb	Llcb;
    //   49: aload 17
    //   51: invokevirtual 657	lcb:c	(Ljava/lang/String;)Llff;
    //   54: astore 19
    //   56: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +117 -> 176
    //   62: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 20
    //   67: new 373	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 2170
    //   77: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: lload_2
    //   81: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc_w 705
    //   87: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_1
    //   91: invokevirtual 550	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc_w 2172
    //   97: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 550	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 2174
    //   108: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 17
    //   113: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 545
    //   119: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 12
    //   124: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: ldc_w 2176
    //   130: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: astore 21
    //   135: aload 18
    //   137: ifnull +47 -> 184
    //   140: iconst_1
    //   141: istore 16
    //   143: aload 20
    //   145: iconst_1
    //   146: aload 21
    //   148: iload 16
    //   150: invokevirtual 383	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: ldc_w 2178
    //   156: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 19
    //   161: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 571
    //   167: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 462	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   197: invokevirtual 2181	com/tencent/av/app/VideoAppInterface:a	()Lljz;
    //   200: astore 20
    //   202: aload 20
    //   204: ifnull +10 -> 214
    //   207: aload 20
    //   209: aload 19
    //   211: invokevirtual 2186	ljz:a	(Llff;)V
    //   214: aload 18
    //   216: invokevirtual 473	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   219: aload_0
    //   220: getfield 243	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   223: invokevirtual 479	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 243	com/tencent/av/VideoController:jdField_j_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   231: aload_0
    //   232: getfield 208	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   235: ifnull +20 -> 255
    //   238: aload 18
    //   240: invokevirtual 473	com/tencent/av/app/VideoAppInterface:a	()Landroid/os/Handler;
    //   243: aload_0
    //   244: getfield 208	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   247: invokevirtual 479	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 208	com/tencent/av/VideoController:jdField_g_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   255: aload_0
    //   256: getfield 222	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   259: ifnull -78 -> 181
    //   262: aload 18
    //   264: iconst_4
    //   265: anewarray 234	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: sipush 203
    //   273: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: lload_2
    //   280: invokestatic 681	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_0
    //   287: getfield 114	com/tencent/av/VideoController:jdField_a_of_type_Boolean	Z
    //   290: invokestatic 831	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: aastore
    //   294: dup
    //   295: iconst_3
    //   296: lload 12
    //   298: invokestatic 755	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: aastore
    //   302: invokevirtual 758	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   305: aload_0
    //   306: invokevirtual 415	com/tencent/av/VideoController:a	()Llff;
    //   309: getfield 2188	lff:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   312: invokevirtual 803	java/util/ArrayList:size	()I
    //   315: ifle +21 -> 336
    //   318: aload_0
    //   319: invokevirtual 415	com/tencent/av/VideoController:a	()Llff;
    //   322: getfield 740	lff:jdField_ad_of_type_Boolean	Z
    //   325: ifeq +11 -> 336
    //   328: aload_0
    //   329: iconst_2
    //   330: iconst_0
    //   331: iconst_0
    //   332: lconst_0
    //   333: invokevirtual 2190	com/tencent/av/VideoController:a	(IIIJ)V
    //   336: iload_1
    //   337: iconst_2
    //   338: if_icmpne +149 -> 487
    //   341: aload 19
    //   343: getfield 740	lff:jdField_ad_of_type_Boolean	Z
    //   346: ifne +141 -> 487
    //   349: aload 19
    //   351: getfield 2188	lff:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   354: ifnull +133 -> 487
    //   357: new 840	android/content/Intent
    //   360: dup
    //   361: invokespecial 841	android/content/Intent:<init>	()V
    //   364: astore 20
    //   366: aload 20
    //   368: ldc_w 843
    //   371: invokevirtual 847	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   374: pop
    //   375: aload 20
    //   377: ldc_w 849
    //   380: sipush 411
    //   383: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   386: pop
    //   387: aload 20
    //   389: ldc_w 2192
    //   392: aload_0
    //   393: invokevirtual 415	com/tencent/av/VideoController:a	()Llff;
    //   396: getfield 2188	lff:jdField_f_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   399: invokevirtual 2195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   402: pop
    //   403: aload 20
    //   405: ldc_w 852
    //   408: aload_0
    //   409: invokevirtual 415	com/tencent/av/VideoController:a	()Llff;
    //   412: getfield 1346	lff:F	I
    //   415: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   418: pop
    //   419: aload 20
    //   421: ldc_w 854
    //   424: aload_0
    //   425: invokevirtual 415	com/tencent/av/VideoController:a	()Llff;
    //   428: getfield 744	lff:jdField_g_of_type_Long	J
    //   431: invokevirtual 857	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   434: pop
    //   435: aload 20
    //   437: ldc_w 861
    //   440: aload_0
    //   441: invokevirtual 415	com/tencent/av/VideoController:a	()Llff;
    //   444: getfield 737	lff:D	I
    //   447: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   450: pop
    //   451: aload 20
    //   453: ldc_w 913
    //   456: ldc_w 2197
    //   459: invokevirtual 918	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   462: pop
    //   463: aload 20
    //   465: aload 18
    //   467: invokevirtual 865	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   470: invokevirtual 870	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   473: invokevirtual 873	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   476: pop
    //   477: aload 18
    //   479: invokevirtual 865	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   482: aload 20
    //   484: invokevirtual 877	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   487: iload_1
    //   488: bipush 7
    //   490: if_icmpne +10 -> 500
    //   493: aload_0
    //   494: iconst_0
    //   495: iconst_0
    //   496: aconst_null
    //   497: invokevirtual 789	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   500: iload_1
    //   501: bipush 9
    //   503: if_icmpne +29 -> 532
    //   506: aload 19
    //   508: getfield 768	lff:jdField_a_of_type_Lfg	Llfg;
    //   511: iconst_0
    //   512: putfield 772	lfg:jdField_b_of_type_Int	I
    //   515: aload_0
    //   516: iconst_0
    //   517: iconst_0
    //   518: aconst_null
    //   519: invokevirtual 789	com/tencent/av/VideoController:a	(IILjava/lang/String;)V
    //   522: aload 19
    //   524: invokevirtual 2198	lff:b	()V
    //   527: aload 19
    //   529: invokevirtual 2199	lff:a	()V
    //   532: iload_1
    //   533: bipush 10
    //   535: if_icmpne +13 -> 548
    //   538: aload 19
    //   540: invokevirtual 2198	lff:b	()V
    //   543: aload 19
    //   545: invokevirtual 2199	lff:a	()V
    //   548: iload_1
    //   549: iconst_2
    //   550: if_icmpne +1086 -> 1636
    //   553: ldc_w 2201
    //   556: aload 19
    //   558: getfield 2203	lff:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   561: invokevirtual 1149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   564: ifeq +30 -> 594
    //   567: aconst_null
    //   568: ldc_w 2205
    //   571: ldc 171
    //   573: ldc 171
    //   575: ldc_w 2207
    //   578: ldc_w 2207
    //   581: iconst_0
    //   582: iconst_0
    //   583: ldc 171
    //   585: ldc 171
    //   587: ldc 171
    //   589: ldc 171
    //   591: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_0
    //   595: invokevirtual 2209	com/tencent/av/VideoController:h	()Z
    //   598: ifeq +30 -> 628
    //   601: aconst_null
    //   602: ldc_w 2205
    //   605: ldc 171
    //   607: ldc 171
    //   609: ldc_w 2211
    //   612: ldc_w 2211
    //   615: iconst_0
    //   616: iconst_0
    //   617: ldc 171
    //   619: ldc 171
    //   621: ldc 171
    //   623: ldc 171
    //   625: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload 19
    //   630: getfield 1355	lff:jdField_j_of_type_Boolean	Z
    //   633: ifeq +38 -> 671
    //   636: aconst_null
    //   637: ldc_w 2205
    //   640: ldc 171
    //   642: ldc 171
    //   644: ldc_w 2213
    //   647: ldc_w 2213
    //   650: iconst_0
    //   651: iconst_0
    //   652: ldc 171
    //   654: ldc 171
    //   656: ldc 171
    //   658: ldc 171
    //   660: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload 19
    //   665: getfield 2214	lff:jdField_m_of_type_Boolean	Z
    //   668: ifeq +938 -> 1606
    //   671: aload_0
    //   672: getfield 245	com/tencent/av/VideoController:jdField_s_of_type_Boolean	Z
    //   675: ifeq +44 -> 719
    //   678: aload_0
    //   679: invokevirtual 2216	com/tencent/av/VideoController:a	()J
    //   682: lconst_0
    //   683: lcmp
    //   684: ifle +35 -> 719
    //   687: aconst_null
    //   688: ldc_w 2205
    //   691: ldc 171
    //   693: ldc 171
    //   695: ldc_w 2218
    //   698: ldc_w 2218
    //   701: iconst_0
    //   702: iconst_0
    //   703: ldc 171
    //   705: ldc 171
    //   707: aload_0
    //   708: invokevirtual 2216	com/tencent/av/VideoController:a	()J
    //   711: invokestatic 2222	mvd:a	(J)Ljava/lang/String;
    //   714: ldc 171
    //   716: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   719: aload_0
    //   720: getfield 222	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   723: lload_2
    //   724: invokevirtual 2225	com/tencent/av/gaudio/QQGAudioCtrl:getNetTrafficSize	(J)J
    //   727: lstore 14
    //   729: iconst_0
    //   730: istore 5
    //   732: iload 4
    //   734: bipush 7
    //   736: if_icmpeq +1286 -> 2022
    //   739: iload 4
    //   741: bipush 20
    //   743: if_icmpne +6 -> 749
    //   746: goto +1276 -> 2022
    //   749: getstatic 2228	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   752: ifeq +1215 -> 1967
    //   755: aload_0
    //   756: ldc_w 2229
    //   759: putfield 239	com/tencent/av/VideoController:jdField_v_of_type_Int	I
    //   762: new 2231	com/tencent/av/VideoController$24
    //   765: dup
    //   766: aload_0
    //   767: iload 5
    //   769: invokespecial 2234	com/tencent/av/VideoController$24:<init>	(Lcom/tencent/av/VideoController;I)V
    //   772: bipush 16
    //   774: aconst_null
    //   775: iconst_0
    //   776: invokestatic 2240	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   779: aload_0
    //   780: getfield 237	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   783: astore 20
    //   785: aload 20
    //   787: monitorenter
    //   788: aload_0
    //   789: getfield 237	com/tencent/av/VideoController:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   792: sipush 2000
    //   795: i2l
    //   796: invokevirtual 2243	java/lang/Object:wait	(J)V
    //   799: aload 20
    //   801: monitorexit
    //   802: aload_0
    //   803: getfield 239	com/tencent/av/VideoController:jdField_v_of_type_Int	I
    //   806: ldc_w 2229
    //   809: if_icmpne +1207 -> 2016
    //   812: sipush 261
    //   815: istore 5
    //   817: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   820: iconst_1
    //   821: new 373	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   828: ldc_w 2245
    //   831: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload_0
    //   835: getfield 239	com/tencent/av/VideoController:jdField_v_of_type_Int	I
    //   838: invokevirtual 550	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   841: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aload_0
    //   848: getfield 1730	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   851: ifeq +1129 -> 1980
    //   854: aload 19
    //   856: getfield 802	lff:jdField_g_of_type_Int	I
    //   859: bipush 9
    //   861: if_icmpne +1119 -> 1980
    //   864: aload 19
    //   866: getfield 810	lff:af	Z
    //   869: ifne +1111 -> 1980
    //   872: lconst_0
    //   873: lstore 8
    //   875: aload_0
    //   876: ldc_w 2247
    //   879: iconst_0
    //   880: invokevirtual 1739	com/tencent/av/VideoController:b	(Ljava/lang/String;Z)V
    //   883: aload_0
    //   884: ldc_w 2247
    //   887: iconst_1
    //   888: invokevirtual 1741	com/tencent/av/VideoController:h	(Ljava/lang/String;I)V
    //   891: aload_0
    //   892: getfield 254	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   895: astore 20
    //   897: aload 20
    //   899: monitorenter
    //   900: aload_0
    //   901: getfield 254	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   904: invokevirtual 803	java/util/ArrayList:size	()I
    //   907: ifne +1103 -> 2010
    //   910: aload_0
    //   911: getfield 1730	com/tencent/av/VideoController:jdField_e_of_type_Boolean	Z
    //   914: ifne +1096 -> 2010
    //   917: aload_0
    //   918: getfield 699	com/tencent/av/VideoController:jdField_a_of_type_Long	J
    //   921: lconst_0
    //   922: lcmp
    //   923: ifne +1087 -> 2010
    //   926: iconst_1
    //   927: istore 6
    //   929: aload_0
    //   930: getfield 254	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   933: invokevirtual 803	java/util/ArrayList:size	()I
    //   936: istore 7
    //   938: aload_0
    //   939: getfield 254	com/tencent/av/VideoController:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   942: invokevirtual 1452	java/util/ArrayList:clear	()V
    //   945: aload 20
    //   947: monitorexit
    //   948: aload_0
    //   949: ldc_w 2247
    //   952: iconst_0
    //   953: iconst_0
    //   954: lconst_0
    //   955: invokevirtual 727	com/tencent/av/VideoController:a	(Ljava/lang/String;ZIJ)V
    //   958: aload 19
    //   960: iconst_0
    //   961: putfield 730	lff:jdField_V_of_type_Boolean	Z
    //   964: aload_0
    //   965: getfield 222	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   968: iconst_0
    //   969: putfield 2250	com/tencent/av/gaudio/QQGAudioCtrl:mIsSwitchGroup	Z
    //   972: aload 18
    //   974: invokevirtual 670	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   977: astore 20
    //   979: lconst_0
    //   980: lstore 10
    //   982: aload 20
    //   984: ifnull +10 -> 994
    //   987: aload 20
    //   989: invokestatic 675	mrs:a	(Ljava/lang/String;)J
    //   992: lstore 10
    //   994: aload 20
    //   996: invokestatic 688	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   999: ifne +214 -> 1213
    //   1002: new 840	android/content/Intent
    //   1005: dup
    //   1006: invokespecial 841	android/content/Intent:<init>	()V
    //   1009: astore 21
    //   1011: aload 21
    //   1013: ldc_w 843
    //   1016: invokevirtual 847	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   1019: pop
    //   1020: aload 21
    //   1022: ldc_w 849
    //   1025: bipush 23
    //   1027: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1030: pop
    //   1031: aload 21
    //   1033: ldc_w 859
    //   1036: lload 10
    //   1038: invokevirtual 857	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1041: pop
    //   1042: aload 21
    //   1044: ldc_w 854
    //   1047: lload_2
    //   1048: invokevirtual 857	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1051: pop
    //   1052: aload 21
    //   1054: ldc_w 852
    //   1057: iload_1
    //   1058: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1061: pop
    //   1062: aload 21
    //   1064: ldc_w 861
    //   1067: aload 19
    //   1069: getfield 737	lff:D	I
    //   1072: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1075: pop
    //   1076: aload 21
    //   1078: ldc_w 2252
    //   1081: lload 8
    //   1083: invokevirtual 857	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1086: pop
    //   1087: aload 21
    //   1089: ldc_w 906
    //   1092: aload_0
    //   1093: getfield 241	com/tencent/av/VideoController:jdField_r_of_type_Boolean	Z
    //   1096: invokevirtual 909	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1099: pop
    //   1100: aload 21
    //   1102: ldc_w 2254
    //   1105: iload 4
    //   1107: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1110: pop
    //   1111: aload 21
    //   1113: ldc_w 913
    //   1116: ldc_w 2256
    //   1119: invokevirtual 918	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1122: pop
    //   1123: iload 7
    //   1125: iconst_1
    //   1126: if_icmple +871 -> 1997
    //   1129: aload 21
    //   1131: ldc_w 911
    //   1134: iload 7
    //   1136: iconst_1
    //   1137: isub
    //   1138: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1141: pop
    //   1142: aload 21
    //   1144: aload 18
    //   1146: invokevirtual 865	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1149: invokevirtual 870	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1152: invokevirtual 873	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1155: pop
    //   1156: aload 21
    //   1158: lload 12
    //   1160: invokestatic 2261	muk:a	(Landroid/content/Intent;J)V
    //   1163: aload 18
    //   1165: invokevirtual 865	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1168: aload 21
    //   1170: invokevirtual 877	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1173: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1176: ifeq +37 -> 1213
    //   1179: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1182: iconst_1
    //   1183: new 373	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   1190: ldc_w 2263
    //   1193: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: lload 12
    //   1198: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1201: ldc_w 571
    //   1204: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokestatic 462	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1213: aload 19
    //   1215: ldc_w 2247
    //   1218: aconst_null
    //   1219: invokevirtual 2264	lff:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1222: aload 19
    //   1224: aconst_null
    //   1225: putfield 2267	lff:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1228: aload_0
    //   1229: invokevirtual 2269	com/tencent/av/VideoController:i	()V
    //   1232: aload 19
    //   1234: getfield 930	lff:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1237: invokevirtual 803	java/util/ArrayList:size	()I
    //   1240: ifle +28 -> 1268
    //   1243: aload 18
    //   1245: iconst_2
    //   1246: anewarray 234	java/lang/Object
    //   1249: dup
    //   1250: iconst_0
    //   1251: bipush 104
    //   1253: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: aastore
    //   1257: dup
    //   1258: iconst_1
    //   1259: aload 19
    //   1261: getfield 930	lff:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1264: aastore
    //   1265: invokevirtual 758	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1268: aload 19
    //   1270: getfield 1346	lff:F	I
    //   1273: iconst_1
    //   1274: if_icmpne +28 -> 1302
    //   1277: aload 18
    //   1279: iconst_2
    //   1280: anewarray 234	java/lang/Object
    //   1283: dup
    //   1284: iconst_0
    //   1285: sipush 410
    //   1288: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_1
    //   1294: lload_2
    //   1295: invokestatic 755	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1298: aastore
    //   1299: invokevirtual 758	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1302: aload 19
    //   1304: getfield 2271	lff:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   1307: astore 21
    //   1309: aload 19
    //   1311: getfield 1346	lff:F	I
    //   1314: iconst_1
    //   1315: if_icmpeq +12 -> 1327
    //   1318: aload 19
    //   1320: getfield 1346	lff:F	I
    //   1323: iconst_2
    //   1324: if_icmpne +44 -> 1368
    //   1327: aload 19
    //   1329: getfield 1355	lff:jdField_j_of_type_Boolean	Z
    //   1332: ifeq +28 -> 1360
    //   1335: aload 18
    //   1337: iconst_2
    //   1338: anewarray 234	java/lang/Object
    //   1341: dup
    //   1342: iconst_0
    //   1343: bipush 106
    //   1345: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1348: aastore
    //   1349: dup
    //   1350: iconst_1
    //   1351: lload 12
    //   1353: invokestatic 755	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1356: aastore
    //   1357: invokevirtual 758	com/tencent/av/app/VideoAppInterface:a	([Ljava/lang/Object;)V
    //   1360: aload 19
    //   1362: lload 12
    //   1364: iconst_0
    //   1365: invokevirtual 2274	lff:a	(JZ)V
    //   1368: aload 19
    //   1370: lload 12
    //   1372: invokevirtual 2276	lff:c	(J)V
    //   1375: aload_0
    //   1376: invokevirtual 2278	com/tencent/av/VideoController:g	()V
    //   1379: lload 12
    //   1381: aload 18
    //   1383: invokestatic 2281	mbb:a	(JLcom/tencent/av/app/VideoAppInterface;)V
    //   1386: iload 6
    //   1388: ifne +46 -> 1434
    //   1391: aload_0
    //   1392: new 373	java/lang/StringBuilder
    //   1395: dup
    //   1396: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   1399: ldc_w 2283
    //   1402: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: iload 4
    //   1407: invokevirtual 550	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1410: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1413: aload 17
    //   1415: iload_1
    //   1416: invokestatic 2285	mvd:c	(I)I
    //   1419: aload 20
    //   1421: lload_2
    //   1422: invokestatic 681	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1425: bipush 7
    //   1427: aload 21
    //   1429: iconst_0
    //   1430: iconst_0
    //   1431: invokevirtual 2288	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZ)V
    //   1434: aload 19
    //   1436: iconst_m1
    //   1437: putfield 456	lff:jdField_j_of_type_Int	I
    //   1440: aload 19
    //   1442: iconst_1
    //   1443: putfield 2289	lff:jdField_p_of_type_Boolean	Z
    //   1446: aload_0
    //   1447: lload 14
    //   1449: putfield 2155	com/tencent/av/VideoController:jdField_b_of_type_Long	J
    //   1452: invokestatic 306	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1455: ifeq +31 -> 1486
    //   1458: getstatic 81	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1461: iconst_2
    //   1462: new 373	java/lang/StringBuilder
    //   1465: dup
    //   1466: invokespecial 374	java/lang/StringBuilder:<init>	()V
    //   1469: ldc_w 2291
    //   1472: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: lload 14
    //   1477: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1486: new 840	android/content/Intent
    //   1489: dup
    //   1490: ldc_w 2161
    //   1493: invokespecial 2163	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1496: astore 19
    //   1498: aload 19
    //   1500: ldc_w 2166
    //   1503: lload 14
    //   1505: invokevirtual 857	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1508: pop
    //   1509: aload 19
    //   1511: aload 18
    //   1513: invokevirtual 865	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1516: invokevirtual 870	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   1519: invokevirtual 873	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1522: pop
    //   1523: iload 6
    //   1525: ifne +13 -> 1538
    //   1528: aload 18
    //   1530: invokevirtual 865	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1533: aload 19
    //   1535: invokevirtual 877	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   1538: aload_0
    //   1539: getfield 112	com/tencent/av/VideoController:jdField_a_of_type_Lcb	Llcb;
    //   1542: lload 12
    //   1544: aload 17
    //   1546: invokevirtual 2294	lcb:a	(JLjava/lang/String;)Z
    //   1549: istore 16
    //   1551: aload 18
    //   1553: invokestatic 794	mtn:a	(Lcom/tencent/av/app/VideoAppInterface;)Lmtn;
    //   1556: astore 18
    //   1558: aload 18
    //   1560: ifnull +27 -> 1587
    //   1563: aload 18
    //   1565: invokevirtual 795	mtn:a	()Z
    //   1568: ifeq +19 -> 1587
    //   1571: aload 18
    //   1573: aload 17
    //   1575: invokevirtual 884	mtn:a	(Ljava/lang/String;)V
    //   1578: iload 16
    //   1580: ifeq +7 -> 1587
    //   1583: aload_0
    //   1584: invokevirtual 797	com/tencent/av/VideoController:c	()V
    //   1587: invokestatic 2297	com/tencent/av/utils/PopupDialog:a	()V
    //   1590: aload_0
    //   1591: iload 5
    //   1593: invokevirtual 2299	com/tencent/av/VideoController:d	(I)V
    //   1596: goto -1415 -> 181
    //   1599: astore 17
    //   1601: aload_0
    //   1602: monitorexit
    //   1603: aload 17
    //   1605: athrow
    //   1606: aconst_null
    //   1607: ldc_w 2205
    //   1610: ldc 171
    //   1612: ldc 171
    //   1614: ldc_w 2301
    //   1617: ldc_w 2301
    //   1620: iconst_0
    //   1621: iconst_0
    //   1622: ldc 171
    //   1624: ldc 171
    //   1626: ldc 171
    //   1628: ldc 171
    //   1630: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1633: goto -962 -> 671
    //   1636: iload_1
    //   1637: iconst_1
    //   1638: if_icmpne -967 -> 671
    //   1641: ldc_w 2201
    //   1644: aload 19
    //   1646: getfield 2203	lff:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   1649: invokevirtual 1149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1652: ifeq +40 -> 1692
    //   1655: aload 19
    //   1657: getfield 737	lff:D	I
    //   1660: bipush 10
    //   1662: if_icmpne +167 -> 1829
    //   1665: aconst_null
    //   1666: ldc_w 2205
    //   1669: ldc 171
    //   1671: ldc 171
    //   1673: ldc_w 2303
    //   1676: ldc_w 2303
    //   1679: iconst_0
    //   1680: iconst_0
    //   1681: ldc 171
    //   1683: ldc 171
    //   1685: ldc 171
    //   1687: ldc 171
    //   1689: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1692: aload_0
    //   1693: invokevirtual 2209	com/tencent/av/VideoController:h	()Z
    //   1696: ifeq +40 -> 1736
    //   1699: aload 19
    //   1701: getfield 737	lff:D	I
    //   1704: bipush 10
    //   1706: if_icmpne +153 -> 1859
    //   1709: aconst_null
    //   1710: ldc_w 2205
    //   1713: ldc 171
    //   1715: ldc 171
    //   1717: ldc_w 2305
    //   1720: ldc_w 2305
    //   1723: iconst_0
    //   1724: iconst_0
    //   1725: ldc 171
    //   1727: ldc 171
    //   1729: ldc 171
    //   1731: ldc 171
    //   1733: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1736: aload 19
    //   1738: getfield 1355	lff:jdField_j_of_type_Boolean	Z
    //   1741: ifeq -1070 -> 671
    //   1744: aload 19
    //   1746: getfield 737	lff:D	I
    //   1749: bipush 10
    //   1751: if_icmpne +138 -> 1889
    //   1754: aconst_null
    //   1755: ldc_w 2205
    //   1758: ldc 171
    //   1760: ldc 171
    //   1762: ldc_w 2307
    //   1765: ldc_w 2307
    //   1768: iconst_0
    //   1769: iconst_0
    //   1770: ldc 171
    //   1772: ldc 171
    //   1774: ldc 171
    //   1776: ldc 171
    //   1778: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1781: aload 19
    //   1783: getfield 2214	lff:jdField_m_of_type_Boolean	Z
    //   1786: ifne -1115 -> 671
    //   1789: aload 19
    //   1791: getfield 737	lff:D	I
    //   1794: bipush 10
    //   1796: if_icmpne +123 -> 1919
    //   1799: aconst_null
    //   1800: ldc_w 2205
    //   1803: ldc 171
    //   1805: ldc 171
    //   1807: ldc_w 2309
    //   1810: ldc_w 2309
    //   1813: iconst_0
    //   1814: iconst_0
    //   1815: ldc 171
    //   1817: ldc 171
    //   1819: ldc 171
    //   1821: ldc 171
    //   1823: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1826: goto -1155 -> 671
    //   1829: aconst_null
    //   1830: ldc_w 2205
    //   1833: ldc 171
    //   1835: ldc 171
    //   1837: ldc_w 2311
    //   1840: ldc_w 2311
    //   1843: iconst_0
    //   1844: iconst_0
    //   1845: ldc 171
    //   1847: ldc 171
    //   1849: ldc 171
    //   1851: ldc 171
    //   1853: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1856: goto -164 -> 1692
    //   1859: aconst_null
    //   1860: ldc_w 2205
    //   1863: ldc 171
    //   1865: ldc 171
    //   1867: ldc_w 2313
    //   1870: ldc_w 2313
    //   1873: iconst_0
    //   1874: iconst_0
    //   1875: ldc 171
    //   1877: ldc 171
    //   1879: ldc 171
    //   1881: ldc 171
    //   1883: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1886: goto -150 -> 1736
    //   1889: aconst_null
    //   1890: ldc_w 2205
    //   1893: ldc 171
    //   1895: ldc 171
    //   1897: ldc_w 2315
    //   1900: ldc_w 2315
    //   1903: iconst_0
    //   1904: iconst_0
    //   1905: ldc 171
    //   1907: ldc 171
    //   1909: ldc 171
    //   1911: ldc 171
    //   1913: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1916: goto -135 -> 1781
    //   1919: aconst_null
    //   1920: ldc_w 2205
    //   1923: ldc 171
    //   1925: ldc 171
    //   1927: ldc_w 2317
    //   1930: ldc_w 2317
    //   1933: iconst_0
    //   1934: iconst_0
    //   1935: ldc 171
    //   1937: ldc 171
    //   1939: ldc 171
    //   1941: ldc 171
    //   1943: invokestatic 1235	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1946: goto -1275 -> 671
    //   1949: astore 21
    //   1951: aload 21
    //   1953: invokevirtual 2318	java/lang/InterruptedException:printStackTrace	()V
    //   1956: goto -1157 -> 799
    //   1959: astore 17
    //   1961: aload 20
    //   1963: monitorexit
    //   1964: aload 17
    //   1966: athrow
    //   1967: aload_0
    //   1968: getfield 222	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl	Lcom/tencent/av/gaudio/QQGAudioCtrl;
    //   1971: iload 5
    //   1973: invokevirtual 2321	com/tencent/av/gaudio/QQGAudioCtrl:quitRoom	(I)I
    //   1976: pop
    //   1977: goto -1130 -> 847
    //   1980: aload_0
    //   1981: invokevirtual 2216	com/tencent/av/VideoController:a	()J
    //   1984: lstore 8
    //   1986: goto -1111 -> 875
    //   1989: astore 17
    //   1991: aload 20
    //   1993: monitorexit
    //   1994: aload 17
    //   1996: athrow
    //   1997: aload 21
    //   1999: ldc_w 911
    //   2002: iconst_0
    //   2003: invokevirtual 850	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2006: pop
    //   2007: goto -865 -> 1142
    //   2010: iconst_0
    //   2011: istore 6
    //   2013: goto -1084 -> 929
    //   2016: goto -1199 -> 817
    //   2019: goto -1974 -> 45
    //   2022: iload 4
    //   2024: istore 5
    //   2026: goto -1277 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2029	0	this	VideoController
    //   0	2029	1	paramInt1	int
    //   0	2029	2	paramLong	long
    //   0	2029	4	paramInt2	int
    //   730	1295	5	i1	int
    //   927	1085	6	i2	int
    //   936	202	7	i3	int
    //   873	1112	8	l1	long
    //   980	57	10	l2	long
    //   5	1538	12	l3	long
    //   727	777	14	l4	long
    //   141	1438	16	bool	boolean
    //   24	1550	17	str	String
    //   1599	5	17	localObject1	Object
    //   1959	6	17	localObject2	Object
    //   1989	6	17	localObject3	Object
    //   11	1561	18	localObject4	Object
    //   54	1736	19	localObject5	Object
    //   133	1295	21	localObject7	Object
    //   1949	49	21	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	26	1599	finally
    //   31	45	1599	finally
    //   45	135	1599	finally
    //   143	176	1599	finally
    //   195	202	1599	finally
    //   207	214	1599	finally
    //   214	255	1599	finally
    //   255	336	1599	finally
    //   341	487	1599	finally
    //   493	500	1599	finally
    //   506	532	1599	finally
    //   538	548	1599	finally
    //   553	594	1599	finally
    //   594	628	1599	finally
    //   628	671	1599	finally
    //   671	719	1599	finally
    //   719	729	1599	finally
    //   749	788	1599	finally
    //   802	812	1599	finally
    //   817	847	1599	finally
    //   847	872	1599	finally
    //   875	900	1599	finally
    //   948	979	1599	finally
    //   987	994	1599	finally
    //   994	1123	1599	finally
    //   1129	1142	1599	finally
    //   1142	1213	1599	finally
    //   1213	1268	1599	finally
    //   1268	1302	1599	finally
    //   1302	1327	1599	finally
    //   1327	1360	1599	finally
    //   1360	1368	1599	finally
    //   1368	1386	1599	finally
    //   1391	1434	1599	finally
    //   1434	1486	1599	finally
    //   1486	1523	1599	finally
    //   1528	1538	1599	finally
    //   1538	1558	1599	finally
    //   1563	1578	1599	finally
    //   1583	1587	1599	finally
    //   1587	1596	1599	finally
    //   1606	1633	1599	finally
    //   1641	1692	1599	finally
    //   1692	1736	1599	finally
    //   1736	1781	1599	finally
    //   1781	1826	1599	finally
    //   1829	1856	1599	finally
    //   1859	1886	1599	finally
    //   1889	1916	1599	finally
    //   1919	1946	1599	finally
    //   1964	1967	1599	finally
    //   1967	1977	1599	finally
    //   1980	1986	1599	finally
    //   1994	1997	1599	finally
    //   1997	2007	1599	finally
    //   788	799	1949	java/lang/InterruptedException
    //   788	799	1959	finally
    //   799	802	1959	finally
    //   1951	1956	1959	finally
    //   1961	1964	1959	finally
    //   900	926	1989	finally
    //   929	948	1989	finally
    //   1991	1994	1989	finally
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = lcb.a(paramInt1, String.valueOf(paramLong), new int[0]);
    if (paramInt1 == 3) {
      str = lcb.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      long l1 = AudioHelper.b();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioSDKError, relationType[" + paramInt1 + "], relationId[" + paramLong + "], reason[" + paramInt2 + "], detail[" + paramInt3 + "], type[" + paramInt4 + "], sessionId[" + str + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], seq[" + l1 + "]");
      if (paramLong == 0L) {
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((lff)localObject).jdField_j_of_type_Boolean)) {
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
      int i1 = mvd.c(paramInt1);
      a(a().jdField_c_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 71);
      }
      for (;;)
      {
        a("onGAudioSDKError_2");
        if (this.jdField_a_of_type_Mur != null) {
          this.jdField_a_of_type_Mur.a(l1);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        this.jdField_a_of_type_Lcb.a(l1, str);
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
    lff locallff = a();
    String str;
    if (paramInt2 == 3)
    {
      str = lcb.a(100, String.valueOf(paramLong2), new int[0]);
      boolean bool = TextUtils.equals(locallff.jdField_c_of_type_JavaLangString, str);
      if ((!bool) || (QLog.isDevelopLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGaGoOnStageResult, result[" + paramInt1 + "], info[" + paramLong1 + "], groupId[" + paramLong2 + "], relationType[" + paramInt2 + "], main[" + locallff.jdField_c_of_type_JavaLangString + "], seq[" + l1 + "]");
      }
      if (bool) {
        break label169;
      }
    }
    label169:
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      return;
      str = lcb.a(paramInt2, String.valueOf(paramLong2), new int[0]);
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
    lbj.a("VideoNodeManager", "-->VideoController onGAudioInvite()**************************");
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
      localObject3 = new StringBuilder().append("onGAudioInvite, friendUin[").append(paramLong2).append("], groupId[").append(paramLong1).append("], multiSubType[").append(paramInt3).append("], multiAVType[").append(paramInt2).append("], relationType[").append(paramInt1).append("], mGAudioInRoom[").append(this.jdField_e_of_type_Boolean).append("], mGAudioGroupId[").append(this.jdField_a_of_type_Long).append("], mCurrentInviteId[").append(this.jdField_d_of_type_Long).append("], mCurrentInviteRelationType[").append(this.jdField_m_of_type_Int).append("], offLineInvite[").append(paramBoolean).append("], roomId[").append(l2).append("], gRoomId[").append(l3).append("], seq[").append(l1).append("], main[").append(localObject1).append("], app[");
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
      if (!bhoj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong1, paramBoolean))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, forceDisableInviteBox");
        return;
      }
      localObject3 = lcb.a(paramInt1, String.valueOf(paramLong1), new int[0]);
      if (this.jdField_a_of_type_Lcb.a((String)localObject3))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, Session already exists");
        return;
      }
      localObject2 = this.jdField_a_of_type_Lcb.a((String)localObject3, false);
      ((lff)localObject2).jdField_g_of_type_Long = paramLong1;
      ((lff)localObject2).F = paramInt1;
      ((lff)localObject2).D = paramInt2;
      ((lff)localObject2).ah = false;
      ((lff)localObject2).jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
      ((lff)localObject2).jdField_ad_of_type_Int = paramInt4;
      if (b(paramInt1, paramLong1, paramInt3))
      {
        a(l1, "too_much_session", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      VideoConstants.jdField_b_of_type_Boolean = localVideoAppInterface.b();
      paramBoolean = false;
      if (!((lff)localObject1).f()) {
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
          ((lff)localObject2).a("onGAudioInvite.1", 0);
        }
        K();
        bool = a(localVideoAppInterface.getApp().getApplicationContext());
        if (!bool) {
          break label803;
        }
        if ((((lff)localObject1).jdField_g_of_type_Int <= 0) || (((lff)localObject1).jdField_g_of_type_Int > 4) || (paramInt3 == 3)) {
          break;
        }
        a(l1, "ScreenLocked_before_connect", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
        if (localVideoAppInterface.e()) {
          paramBoolean = true;
        }
      }
      if (7 == ((lff)localObject1).jdField_g_of_type_Int)
      {
        a(l1, "ScreenLocked_group_invite", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1))
      {
        a(l1, "ScreenLocked_group_in_room", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((lff)localObject1).jdField_g_of_type_Int == 14) || (((lff)localObject1).jdField_g_of_type_Int == 13))
      {
        a(l1, "ScreenLocked_double_meeting", (String)localObject3, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
        return;
      }
      if ((((lff)localObject1).jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) && (((lff)localObject1).jdField_a_of_type_Lfg.jdField_a_of_type_Int == 1))
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInvite, matchStatus[" + ((lff)localObject1).jdField_a_of_type_Lfg.jdField_b_of_type_Int + "], chatType[" + ((lff)localObject1).jdField_a_of_type_Lfg.jdField_a_of_type_Int + "], aSessionExists[" + paramBoolean + "], isScreenLocked[" + bool + "], \nmainSession[" + localObject1 + "], \nsessionInfo[" + localObject2 + "]");
      }
      if (((lff)localObject2).jdField_d_of_type_Int == 0)
      {
        ((lff)localObject2).jdField_e_of_type_Boolean = true;
        ((lff)localObject2).a(l1, "onGAudioInvite.1", 3);
        ((lff)localObject2).jdField_j_of_type_Int = mvd.c(paramInt1);
        ((lff)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong2);
        if (paramInt1 == 2) {
          ((lff)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong2);
        }
        ((lff)localObject2).jdField_e_of_type_Boolean = true;
        if ((paramInt3 != 3) && (paramInt3 != 4)) {
          a((String)localObject3, ((lff)localObject2).jdField_d_of_type_Int, false, false, false);
        }
      }
      this.jdField_d_of_type_Long = paramLong1;
      this.jdField_m_of_type_Int = paramInt1;
      if (((lff)localObject2).jdField_g_of_type_Int == 0) {
        ((lff)localObject2).a("onGAudioInvite", 7);
      }
      bool = false;
      if ((paramInt3 != 3) || (((lff)localObject1).jdField_g_of_type_Long != 0L)) {
        break label1377;
      }
      bool = b((lff)localObject1, (lff)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
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
        paramArrayOfLong.putExtra("extraUin", ((lff)localObject1).jdField_f_of_type_JavaLangString);
        paramArrayOfLong.putExtra("relationId", paramLong1);
        paramArrayOfLong.putExtra("type", 13);
        paramArrayOfLong.putExtra("senderUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("isSender", false);
        paramArrayOfLong.putExtra("peerUin", localVideoAppInterface.getCurrentAccountUin());
        paramArrayOfLong.putExtra("realSenderUin", ((lff)localObject1).jdField_s_of_type_JavaLangString);
        localVideoAppInterface.getApp().sendBroadcast(paramArrayOfLong);
        a(l1, this.jdField_m_of_type_Int, paramLong1, true);
        new blfn(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
        this.jdField_a_of_type_Lcb.a(l1, (String)localObject3);
        return;
        label1377:
        if (paramInt3 != 4) {
          break;
        }
        bool = a((lff)localObject1, (lff)localObject2, l1, paramLong2, (String)localObject3, paramInt1, paramLong1, paramArrayOfLong);
        break;
        if (paramInt1 == 2) {
          paramArrayOfLong.putExtra("uinType", 3000);
        }
      }
    }
    ((lff)localObject1).jdField_s_of_type_JavaLangString = ("" + paramLong2);
    this.jdField_s_of_type_Boolean = b();
    if (((lff)localObject2).a(localVideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite msg blocked [" + ((lff)localObject2).jdField_c_of_type_JavaLangString + "]");
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
      if ((paramBoolean) || (ldf.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
      {
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        bhoo.d();
      }
      for (;;)
      {
        BaseGaInvite.a((Intent)localObject1, "onGAudioInvite");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("uinType", mvd.c(paramInt1));
        ((Intent)localObject1).putExtra("peerUin", String.valueOf(paramLong2));
        ((Intent)localObject1).putExtra("friendUin", paramLong2);
        ((Intent)localObject1).putExtra("relationType", paramInt1);
        ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
        ((Intent)localObject1).putExtra("discussId", paramLong1);
        ((Intent)localObject1).putExtra("memberList", paramArrayOfLong);
        ((Intent)localObject1).putExtra("session_id", ((lff)localObject2).jdField_c_of_type_JavaLangString);
        if ((!this.jdField_s_of_type_Boolean) || (!lzq.d(localVideoAppInterface.getApplication().getApplicationContext()))) {
          break label1806;
        }
        if ((!paramBoolean) && (!ldf.a())) {
          break label1774;
        }
        paramArrayOfLong = new mev(this, localVideoAppInterface, (Intent)localObject1);
        paramArrayOfLong.d();
        paramArrayOfLong.a((Intent)localObject1);
        break;
        localObject1 = new Intent(localVideoAppInterface.getApp().getApplicationContext(), GaInviteLockActivity.class);
      }
      label1774:
      paramArrayOfLong = new mlc(this, localVideoAppInterface, (Intent)localObject1);
      paramArrayOfLong.d();
      paramArrayOfLong.a(l1, (Intent)localObject1);
      break;
      label1806:
      a((Intent)localObject1);
      break;
      label1815:
      lic.a();
    }
  }
  
  public void a(int paramInt, long paramLong, lwf paramlwf)
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl != null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a(paramInt, paramLong, paramlwf);
    }
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    paramVarArgs = lcb.a(paramInt, String.valueOf(paramLong), new int[0]);
    if ((!this.jdField_a_of_type_Lcb.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = lcb.a(100, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      lff locallff = this.jdField_a_of_type_Lcb.c(paramVarArgs);
      long l1 = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + paramVarArgs + "], seq[" + l1 + "], \nsession[" + locallff + "]");
      }
      int i1;
      if ((locallff != null) && ((locallff.jdField_g_of_type_Int == 7) || (locallff.jdField_g_of_type_Int == 2)))
      {
        locallff.a("onGAudioTerminalEnterRoom", 0);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_Lcb.a(paramVarArgs))
        {
          locallff = this.jdField_a_of_type_Lcb.c(paramVarArgs);
          i1 = mvd.c(paramInt);
          if (paramInt != 3) {
            break label255;
          }
          a(locallff.jdField_c_of_type_JavaLangString, i1, 7, true, String.valueOf(paramLong), null, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Lcb.a(l1, paramVarArgs);
        return;
        label255:
        if ((paramInt == 2) || (paramInt == 1)) {
          a("ignoreGAudioChat_4", paramVarArgs, i1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), 4, locallff.jdField_s_of_type_JavaLangString, true, false);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Lcb == null) || (a() == null) || (a().jdField_d_of_type_JavaLangString == null)) {}
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
      Object localObject1 = this.jdField_a_of_type_Lcb;
      localObject1 = this.jdField_a_of_type_Lcb;
      localObject1 = lcb.a(lcb.a(paramInt1), paramString, new int[0]);
      Object localObject2 = this.jdField_a_of_type_Lcb.c((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((lff)localObject1).jdField_f_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((lff)localObject1).jdField_d_of_type_JavaLangString)) && (((lff)localObject1).jdField_e_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((lff)localObject1).A);
      ((Intent)localObject2).putExtra("bindId", ((lff)localObject1).jdField_p_of_type_JavaLangString);
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
    boolean bool3 = e(paramString1);
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
    int i1 = mtr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, paramString1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + i1 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
    }
    if (a(i1, paramString1))
    {
      a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
      return;
    }
    localObject = a();
    str = lcb.a(3, paramString1, new int[0]);
    if ((TextUtils.equals(str, ((lff)localObject).jdField_c_of_type_JavaLangString)) && (((lff)localObject).jdField_d_of_type_Boolean))
    {
      ((lff)localObject).jdField_e_of_type_Boolean = true;
      paramInt1 = 1;
      if (((lff)localObject).S) {
        paramInt1 = 0;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo, autoAcceptChat, seq[" + l2 + "]");
      a(l2, paramString1, paramInt1, ((lff)localObject).F);
      return;
    }
    boolean bool2 = false;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo->isScreenLocked:" + bool4);
    if ((i1 != 21) && (i1 != 1011) && ((((lff)localObject).jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (((lff)localObject).jdField_a_of_type_Lfg.jdField_a_of_type_Int == 1))
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
      label564:
      this.jdField_a_of_type_Lcb.a(str, false);
      localObject = this.jdField_a_of_type_Lcb.c(str);
      ((lff)localObject).A = paramInt2;
      ((lff)localObject).jdField_p_of_type_JavaLangString = paramString3;
      ((lff)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((lff)localObject).jdField_B_of_type_Int = i1;
      if (this.jdField_h_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
        this.jdField_h_of_type_JavaLangRunnable = null;
        ((lff)localObject).a("onRequestVideo.1", 0);
      }
      if (this.jdField_a_of_type_Llb == null) {
        break label1845;
      }
      i1 = 9500;
    }
    label684:
    label1845:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      ((lff)localObject).S = paramBoolean;
      long l3;
      if (paramBoolean)
      {
        ((lff)localObject).jdField_f_of_type_Int = 1;
        l1 = a(paramString1);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  ,roomId = " + l1);
        ((lff)localObject).d(l1);
        ((lff)localObject).jdField_j_of_type_Int = i1;
        ((lff)localObject).jdField_k_of_type_Int = paramInt1;
        ((lff)localObject).jdField_d_of_type_JavaLangString = paramString1;
        ((lff)localObject).jdField_f_of_type_JavaLangString = paramString2;
        ((lff)localObject).jdField_e_of_type_Boolean = true;
        ((lff)localObject).a("onRequestVideo.2", 2);
        ((lff)localObject).jdField_q_of_type_Int = paramInt3;
        a(i1, paramString1, paramString2, paramArrayOfByte);
        paramArrayOfByte = (lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!paramBoolean) {
          break label1531;
        }
        paramInt1 = 1;
        paramArrayOfByte.a(l1, 20, paramInt1);
        paramArrayOfByte.a(l1, 6, 1L);
        l3 = a(paramString1);
        lic.a(l3, 36);
        lic.a(l3, 9, ((lff)localObject).b());
        lic.a(l3, 11, paramString1);
        lic.a(l3, 12, 2L);
        if (!((lff)localObject).S) {
          break label1536;
        }
      }
      for (long l1 = 1L;; l1 = 2L)
      {
        lic.a(l3, 13, l1);
        lic.a(l3, 15, 1L);
        x(paramString1);
        if (!bool3) {
          break label1544;
        }
        ((lff)localObject).jdField_c_of_type_Boolean = true;
        b(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
        return;
        if ((((lff)localObject).jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) && (((lff)localObject).jdField_a_of_type_Lfg.jdField_a_of_type_Int == 3))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in Random mulit");
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label564;
        }
        if (((lff)localObject).f())
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
            break label564;
          }
          bool1 = true;
          break label564;
        }
        if ((((lff)localObject).o()) || (((lff)localObject).p()))
        {
          b(((lff)localObject).jdField_d_of_type_JavaLangString, 2);
          bool1 = bool2;
          break label564;
        }
        if (((((lff)localObject).jdField_g_of_type_Int == 7) && (this.jdField_d_of_type_Long != 0L)) || (((lff)localObject).jdField_g_of_type_Int == 14) || (((lff)localObject).jdField_g_of_type_Int == 13))
        {
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label564;
        }
        if (!this.jdField_e_of_type_Boolean)
        {
          if (((i1 == 21) || (i1 == 1011)) && (a().jdField_a_of_type_Lfg.jdField_b_of_type_JavaLangString != null))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo  auto Accept");
            if ((((lff)localObject).jdField_a_of_type_Lfg.jdField_c_of_type_JavaLangString != null) && (!((lff)localObject).jdField_a_of_type_Lfg.jdField_c_of_type_JavaLangString.equals(paramString1)))
            {
              a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
              return;
            }
            a(l2, 30000L);
            bool1 = bool2;
            break label564;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when chatting: fromUin = " + paramString1 + "|" + bool4);
          bool1 = true;
          if ((((lff)localObject).jdField_d_of_type_JavaLangString != null) && (paramString1.equals(((lff)localObject).jdField_d_of_type_JavaLangString)))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when request: fromUin = " + paramString1);
            G();
            x(paramString1);
            return;
          }
          if (!bool4) {
            break label564;
          }
          a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
          return;
        }
        if ((this.jdField_e_of_type_Boolean) || (((lff)localObject).jdField_g_of_type_Int == 8))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "onRequestVideo when in group chat, fromUin = " + paramString1);
          if (bool4)
          {
            a(l2, false, i1, paramString1, paramString2, paramInt2, paramString3, paramBoolean);
            return;
          }
          bool1 = true;
          break label564;
        }
        bool1 = bool2;
        if (((lff)localObject).jdField_g_of_type_Int != 1) {
          break label564;
        }
        bool1 = bool2;
        if (((lff)localObject).jdField_d_of_type_JavaLangString == null) {
          break label564;
        }
        bool1 = bool2;
        if (!paramString1.equals(((lff)localObject).jdField_d_of_type_JavaLangString)) {
          break label564;
        }
        return;
        ((lff)localObject).jdField_f_of_type_Int = 2;
        break label684;
        label1531:
        paramInt1 = 2;
        break label803;
      }
      if ((!this.jdField_e_of_type_Boolean) && (((lff)localObject).jdField_j_of_type_Int != 21) && (((lff)localObject).jdField_j_of_type_Int != 1011)) {
        a(str, ((lff)localObject).jdField_f_of_type_Int, false, false, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo orientation: " + this.jdField_s_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool4 + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
      }
      if ((this.x) && (this.jdField_s_of_type_Int == 0) && (!bool4) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.7(this, l2, str, i1, paramString1, paramString2, paramBoolean, bool1, paramInt2), 100L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + paramString1);
      }
      a(paramString1, "inviteUIState", String.valueOf(0));
      if (this.jdField_a_of_type_Lce != null) {
        this.jdField_a_of_type_Lce.b();
      }
      this.jdField_a_of_type_Lce = new lce(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      a(l2, str, i1, paramString1, paramString2, paramBoolean, false, bool1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt, ArrayList<lnd> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      lnd locallnd = (lnd)paramArrayList.get(i1);
      a(locallnd.jdField_a_of_type_Long, locallnd.jdField_a_of_type_Int, locallnd.jdField_b_of_type_Int, false);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void a(int paramInt, moq parammoq)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "Record setAudioFrameCallback, type=" + paramInt + ", callback=" + parammoq);
    if (paramInt >= 2) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfMoq == null) {
      this.jdField_a_of_type_ArrayOfMoq = new moq[2];
    }
    this.jdField_a_of_type_ArrayOfMoq[paramInt] = parammoq;
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
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, paramLong);
    lff locallff = a();
    k();
    locallff.a("onSubState2", 4);
    locallff.a(paramLong, SystemClock.elapsedRealtime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(paramLong) });
      if (!locallff.jdField_g_of_type_Boolean) {
        break label219;
      }
      a(true, locallff.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.9(this, paramLong), 50L);
      a(locallff.jdField_c_of_type_JavaLangString, locallff.jdField_d_of_type_Int, true, true, true);
      mru.i(this);
      mru.c(this, true);
      mru.b(this, true);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        ljz localljz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localljz != null) {
          localljz.a(locallff);
        }
      }
      return;
      c();
      break;
      label219:
      a(false, locallff.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioMicSetByAdmin, manager uin[" + paramLong + "], old micAuthByAdmin[" + a().H + "], new micAuthByAdmin[" + paramInt + "], mIsMicOffBySelf[" + this.jdField_u_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
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
      this.jdField_a_of_type_Mur.b(paramLong);
      if (!this.jdField_a_of_type_Mur.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
      {
        lbj.d(jdField_a_of_type_JavaLangString, "exit !mTraeHelper.startRing");
        a(a().jdField_d_of_type_JavaLangString, 212);
        b(212);
        b(a().jdField_d_of_type_JavaLangString, a().z);
      }
    } while (!a().T);
    lbj.d(jdField_a_of_type_JavaLangString, "exit getSessionInfo().isPeerOnPhone");
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
        QLog.w(jdField_a_of_type_JavaLangString, 2, "onGAudioMemberMicChanged, uin[" + paramLong + "], mGAudioMute[" + this.jdField_l_of_type_Boolean + "], isMicOff[" + paramBoolean + "], mIsMicOffBySelf[" + this.jdField_u_of_type_Boolean + "]");
      }
      if ((paramBoolean != this.jdField_l_of_type_Boolean) && (!this.jdField_u_of_type_Boolean))
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
    mur.a().b();
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = lcb.a(100, String.valueOf(paramLong2), new int[0]);
      localObject = this.jdField_a_of_type_Lcb.c(str1);
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
      str1 = lcb.a(paramInt1, String.valueOf(paramLong2), new int[0]);
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
    ((lff)localObject).ah = true;
    int i1 = 4;
    label277:
    String str2;
    if (((lff)localObject).jdField_g_of_type_Int == 7)
    {
      ((lff)localObject).a("ignoreGAudioChat", 0);
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        i();
        paramInt2 = mvd.c(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if (i1 != 10) {
          break label412;
        }
        a("ignoreGAudioChat_1", ((lff)localObject).jdField_c_of_type_JavaLangString, mvd.c(paramInt1), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(((lff)localObject).jdField_g_of_type_Long), 5, ((lff)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_Lcb.a(paramLong1, str1);
      localObject = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mtn)localObject).a())) {
        break;
      }
      ((mtn)localObject).a(str1);
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
        a("ignoreGAudioChat_2", str1, paramInt2, ((lff)localObject).jdField_d_of_type_JavaLangString, String.valueOf(paramLong2), i1, ((lff)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
      } else {
        a("ignoreGAudioChat_3", str1, paramInt2, str2, String.valueOf(paramLong2), i1, ((lff)localObject).jdField_s_of_type_JavaLangString, paramBoolean, false);
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
      bdll.b(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i1, 0, "", "", "", "");
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
      localObject1 = lcb.a(i2, String.valueOf(paramLong2), new int[0]);
      localObject1 = this.jdField_a_of_type_Lcb.a((String)localObject1, false);
      i3 = ((lff)localObject2).jdField_d_of_type_Int;
      ((lff)localObject1).a(paramLong1, ((lff)localObject2).jdField_j_of_type_Boolean);
      ((lff)localObject1).jdField_g_of_type_Boolean = ((lff)localObject2).jdField_g_of_type_Boolean;
      ((lff)localObject1).b("switchToMultiAudio", ((lff)localObject2).jdField_P_of_type_Boolean);
      ((lff)localObject1).b("switchToMultiAudio", ((lff)localObject2).jdField_q_of_type_JavaLangString);
      ((lff)localObject1).jdField_d_of_type_JavaLangString = ((lff)localObject2).jdField_d_of_type_JavaLangString;
      ((lff)localObject1).D = i1;
      ((lff)localObject1).aE = true;
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      if (!((lff)localObject2).J) {
        break label454;
      }
      boolean bool = this.jdField_l_of_type_Boolean;
      a(paramLong1, Long.valueOf(((lff)localObject2).jdField_d_of_type_JavaLangString).longValue(), true, 0);
      b("switchToMultiAudio", bool);
      if (!bool) {
        break label448;
      }
      i1 = 1;
      label328:
      h("switchToMultiAudio", i1);
    }
    for (this.jdField_e_of_type_Int = 2;; this.jdField_e_of_type_Int = 1)
    {
      if (!paramArrayList.contains(((lff)localObject2).jdField_d_of_type_JavaLangString)) {
        paramArrayList.add(((lff)localObject2).jdField_d_of_type_JavaLangString);
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
      a(((lff)localObject2).jdField_d_of_type_JavaLangString, 1);
      b(214);
      b(((lff)localObject2).jdField_d_of_type_JavaLangString, 21);
    }
    label500:
    if (i1 == localObject2.length)
    {
      ((lff)localObject1).jdField_a_of_type_ArrayOfLong = ((long[])localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + localObject2.length + "]");
      }
      ((lff)localObject1).z = -1;
      if (i3 != 1) {
        break label680;
      }
      ((lff)localObject1).a(paramLong1, "switchToMultiAudio.1", 3);
    }
    for (;;)
    {
      ((lff)localObject1).jdField_j_of_type_Int = paramInt;
      ((lff)localObject1).jdField_g_of_type_Long = paramLong2;
      ((lff)localObject1).d("switchToMultiAudio", mrl.a(paramInt));
      ((lff)localObject1).c("switchToMultiAudio", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
      label638:
      return;
      ((lff)localObject1).jdField_a_of_type_ArrayOfLong = new long[i1];
      i2 = 0;
      while (i2 < i1)
      {
        ((lff)localObject1).jdField_a_of_type_ArrayOfLong[i2] = localObject2[i2];
        i2 += 1;
      }
      break;
      label680:
      if (i3 == 2) {
        ((lff)localObject1).a(paramLong1, "switchToMultiAudio.2", 4);
      } else if (i3 == 3) {
        ((lff)localObject1).a(paramLong1, "switchToMultiAudio.3", 3);
      } else if (i3 == 4) {
        ((lff)localObject1).a(paramLong1, "switchToMultiAudio.4", 3);
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
    String str = lcb.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject = this.jdField_a_of_type_Lcb.c(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong2);
      }
      return;
    }
    ((lff)localObject).a("closeDoubleVideoMeetingInvite", 0);
    if (paramInt == 23) {
      a(str, 0, true, ((lff)localObject).jdField_d_of_type_JavaLangString, ((lff)localObject).jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong2);
      localIntent.putExtra("friendUin", paramLong2);
      localIntent.putExtra("MultiAVType", ((lff)localObject).D);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_Lcb.a(paramLong1, str);
      localObject = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((mtn)localObject).a())) {
        break;
      }
      ((mtn)localObject).a(str);
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
    lcv locallcv = a(String.valueOf(paramLong2));
    if (locallcv == null) {}
    while ((paramInt2 == 1) || ((paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    locallcv.jdField_d_of_type_Boolean = false;
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
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
  
  public void a(long paramLong1, long paramLong2, ArrayList<lnv> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.28(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
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
    Object localObject = this.jdField_a_of_type_Mjq;
    if (localObject != null) {
      ((mjq)localObject).a(4);
    }
    localObject = lcb.a(100, String.valueOf(paramLong2), new int[0]);
    lff locallff = this.jdField_a_of_type_Lcb.c((String)localObject);
    if (locallff == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong2);
    localIntent.putExtra("friendUin", paramLong2);
    localIntent.putExtra("MultiAVType", locallff.D);
    localIntent.putExtra("from", "VideoController6");
    muk.a(localIntent, paramLong1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    a((String)localObject, 0, paramInt, true, "" + paramLong2, "" + paramLong2, false);
    if (locallff.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
    }
    if (paramBoolean)
    {
      a(3, paramLong2, 84);
      locallff.d("quitDoubleVideoMeeting", false);
      locallff.e("quitDoubleVideoMeeting", false);
    }
    for (;;)
    {
      localObject = a();
      if (localObject == null) {
        break;
      }
      ((ScreenShareCtrl)localObject).b(paramLong2);
      return;
      locallff.a("quitDoubleVideoMeeting", 15);
      a(paramLong1, 2131230741, 1, this.jdField_c_of_type_Lcw);
      this.jdField_c_of_type_JavaLangRunnable = new VideoController.32(this);
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
    String str = lcb.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_Lcb.a(str)) {}
    for (lff locallff = this.jdField_a_of_type_Lcb.c(str); locallff == null; locallff = this.jdField_a_of_type_Lcb.c(str))
    {
      lbj.e(jdField_a_of_type_JavaLangString, "onCloseVideo fail to find session");
      return;
      str = lcb.a(100, paramString, new int[0]);
    }
    locallff.jdField_d_of_type_Boolean = false;
    if ((q()) && (paramString != null) && (!paramString.equals(locallff.jdField_d_of_type_JavaLangString)))
    {
      lbj.d(jdField_a_of_type_JavaLangString, "NearbyVideoChat fromUin = " + paramString + ",peerUin = " + locallff.jdField_d_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Lce != null)
    {
      this.jdField_a_of_type_Lce.b();
      this.jdField_a_of_type_Lce = null;
    }
    this.jdField_h_of_type_Boolean = false;
    a(paramString, "inviteUIState", "");
    a(paramString, "screenState", "");
    k();
    if ((locallff.jdField_d_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a(paramLong, str, paramString, 3);
      label296:
      if (!locallff.j()) {
        break label440;
      }
      locallff.z = paramInt;
      if ((locallff.j()) && (paramInt == locallff.jdField_d_of_type_Int)) {
        locallff.a(paramLong, 0L);
      }
      locallff.a("onCloseVideo.isBeInviting", 6);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      b(locallff.jdField_d_of_type_JavaLangString, locallff.z);
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
        if (locallff.h())
        {
          locallff.z = paramInt;
          locallff.a(paramLong, 0L);
          int i2 = 2131230741;
          switch (paramInt)
          {
          default: 
            i1 = 0;
            this.jdField_a_of_type_Lcw.jdField_a_of_type_Long = paramLong;
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 3)
          {
            a(paramLong, i2, i1, this.jdField_a_of_type_Lcw);
            locallff.a("onCloseVideo.isInviting1", 5);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            break label398;
            bdll.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            if (l()) {
              break;
            }
            if (locallff.jdField_d_of_type_Long != 2L)
            {
              bdll.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131230740;
              break label531;
            }
            i2 = 2131230741;
            i1 = 1;
            break label531;
            this.jdField_b_of_type_Lcw.jdField_a_of_type_Long = paramLong;
            a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lcw);
            locallff.a("onCloseVideo.isInviting", 6);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
            return;
            if (l()) {
              break;
            }
            bdll.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131230740;
            break label531;
            i2 = 2131230740;
            i1 = 0;
            break label531;
          }
        }
        label531:
        if (!locallff.o())
        {
          locallff.z = paramInt;
          if (locallff.j()) {
            locallff.a(paramLong, 0L);
          }
          if (((paramInt == 2) || (paramInt == 24)) && (locallff.jdField_j_of_type_Int == 1011))
          {
            locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label1080;
            }
            a(6, 0, null);
            label950:
            mtn localmtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label1097;
            }
            if (localmtn != null) {
              localmtn.a();
            }
          }
          label976:
          locallff.a("onCloseVideo.isClosing1", 6);
          if ((!q()) && (!mtd.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()))) {
            break label1104;
          }
          a(locallff.jdField_d_of_type_JavaLangString, 209);
          b(209);
          b(locallff.jdField_d_of_type_JavaLangString, locallff.z);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) });
      break label398;
      break;
      label1080:
      a(locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int, 0, null);
      break label950;
      label1097:
      c();
      break label976;
      label1104:
      this.jdField_b_of_type_Lcw.jdField_a_of_type_Long = paramLong;
      a(paramLong, 2131230741, 1, this.jdField_b_of_type_Lcw);
      mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(str);
    }
  }
  
  void a(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this.jdField_s_of_type_Boolean = b();
    boolean bool3 = lzq.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
    long l1 = a(paramString2);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, uinType[" + paramInt1 + "], peerUin[" + paramString2 + "], extraUin[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], isDoubleVideoMeeting[" + paramBoolean2 + "], mIsGameMode[" + this.jdField_s_of_type_Boolean + "], isFloatWindowOpAllowedOnBackground[" + bool3 + "], aSessionExists[" + paramBoolean3 + "], roomId[" + l1 + "], sessionId[" + paramString1 + "], seq[" + paramLong + "]");
    if ((paramBoolean1) && (!lkw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())))
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
      lff locallff = this.jdField_a_of_type_Lcb.c(paramString1);
      if (locallff == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest, sessionInfo为空");
        return;
      }
      locallff.jdField_e_of_type_Boolean = true;
      locallff.S = paramBoolean1;
      locallff.a("processVideoRequest.1", 2);
      locallff.ag = false;
      locallff.jdField_k_of_type_Long = System.currentTimeMillis();
      AVReport.a().o = locallff.S;
      bool1 = false;
      if ((paramBoolean3) || (ldf.a()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext()));
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("relationType", mvd.b(paramInt1));
        ((Intent)localObject).putExtra("session_id", paramString1);
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.jdField_h_of_type_Int);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((a().jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) || ((a().jdField_a_of_type_Lfh.jdField_a_of_type_Int != 0) && (a().jdField_a_of_type_Lfh.jdField_a_of_type_Long > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label715;
        }
        h();
        if (!TextUtils.equals(paramString2, a().jdField_a_of_type_Lfg.jdField_c_of_type_JavaLangString)) {
          break label672;
        }
        locallff.jdField_d_of_type_JavaLangString = paramString2;
        a(paramLong, locallff.jdField_d_of_type_JavaLangString, 0, 4);
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
        if (bhhv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
        {
          localIntent.addFlags(262144);
          localObject = localIntent;
          bool1 = bool2;
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Boolean = true;
      locallff.a("processVideoRequest.2", 0);
      locallff.jdField_j_of_type_Int = paramInt1;
      locallff.jdField_d_of_type_JavaLangString = paramString2;
      return;
      if (!locallff.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
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
      if ((this.jdField_s_of_type_Boolean) && (bool3))
      {
        if ((paramBoolean3) || (ldf.a()))
        {
          paramString1 = new mev(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
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
          paramString1 = new mlc(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (Intent)localObject);
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
    this.jdField_a_of_type_Mur.b(paramLong);
    localObject = this.jdField_a_of_type_Mur;
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i1 = -99;
    if (!paramBoolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, c(), paramInt);
      ((lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(a().b(), 10, 1L);
      if ((a().jdField_d_of_type_JavaLangString == null) || (!a().jdField_d_of_type_JavaLangString.equals(paramString))) {
        break label278;
      }
      lic.a(a().b(), 38);
    }
    for (i1 = paramInt;; i1 = paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancelVideoChat, result[" + i1 + "]");
      i();
      k();
      if (this.jdField_a_of_type_Llb == null) {
        break;
      }
      achd.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
      label278:
      lic.a(a(paramString), 38);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean, Runnable paramRunnable)
  {
    new Thread(new VideoController.5(this, this, paramLong, paramString, paramInt, paramBoolean, paramRunnable)).start();
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    lff locallff = this.jdField_a_of_type_Lcb.c(paramString1);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "sendDoubleChatMsgToMQQ, sessionId[" + paramString1 + "], peerUin[" + paramString2 + "], type[" + paramInt + "], seq[" + paramLong + "], \nsession[" + locallff + "]", new Throwable("打印调用栈"));
    int i1;
    String str;
    if ((locallff != null) && ((!locallff.ag) || (locallff.jdField_c_of_type_Boolean)))
    {
      i1 = this.jdField_a_of_type_Lcb.c(paramString1).jdField_j_of_type_Int;
      str = locallff.jdField_f_of_type_JavaLangString;
      if ((TextUtils.isEmpty(locallff.jdField_d_of_type_JavaLangString)) || (!locallff.jdField_d_of_type_JavaLangString.contains(paramString2))) {
        break label430;
      }
      paramString2 = locallff.jdField_d_of_type_JavaLangString;
    }
    label430:
    for (;;)
    {
      if (this.jdField_a_of_type_Llb != null)
      {
        i1 = 9500;
        if (((locallff.A != 1) || (TextUtils.isEmpty(locallff.jdField_p_of_type_JavaLangString))) || (this.jdField_w_of_type_Boolean)) {
          i1 = 0;
        }
      }
      boolean bool = false;
      if (locallff.jdField_f_of_type_Int == 2) {
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
        locallff.ag = true;
        locallff.jdField_c_of_type_Boolean = false;
        return;
        if (!locallff.jdField_c_of_type_Boolean) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        label358:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()) {
          a("sendDoubleChatMsgToMQQ_2", paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_Lcb.c(paramString1).jdField_s_of_type_JavaLangString, true, true);
        } else {
          a("sendDoubleChatMsgToMQQ_3", paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_Lcb.c(paramString1).jdField_s_of_type_JavaLangString, false, true);
        }
      }
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "reject3rdMultiCall[" + paramString1 + "], sessionId[" + paramString2 + "], relationType[" + paramInt + "], senderUin[" + paramString3 + "], extraUin[" + paramString4 + "], seq[" + paramLong + "]");
    }
    a(paramString1, paramString2, mvd.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramString4, 5, paramString3, false, false);
    this.jdField_a_of_type_Lcb.a(paramLong, paramString2);
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
  
  public void a(long paramLong, ArrayList<lnd> paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      lcv locallcv = new lcv();
      locallcv.jdField_a_of_type_Long = ((lnd)paramArrayList.get(i1)).jdField_a_of_type_Long;
      locallcv.jdField_d_of_type_Int = ((lnd)paramArrayList.get(i1)).jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(locallcv);
      if (((lnd)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) {
        localArrayList.add(Long.valueOf(((lnd)paramArrayList.get(i1)).jdField_a_of_type_Long));
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
      localObject = (lcv)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (((lcv)localObject).jdField_a_of_type_Long == paramLong)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
        if (!QLog.isColorLevel()) {
          break label218;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + ((lcv)localObject).jdField_a_of_type_Long);
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
      str = lcb.a(100, paramString1, new int[0]);
      lff locallff2 = this.jdField_a_of_type_Lcb.c(str);
      lff locallff1 = locallff2;
      if (locallff2 == null) {
        locallff1 = this.jdField_a_of_type_Lcb.a(str, false);
      }
      locallff1.jdField_j_of_type_Int = paramInt1;
      locallff1.A = paramInt2;
      locallff1.jdField_p_of_type_JavaLangString = paramString3;
      locallff1.jdField_e_of_type_Boolean = true;
      paramInt1 = locallff1.jdField_j_of_type_Int;
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
        l1 = mrs.a(paramString1);
        a(paramLong, 3, l1);
        lcb.a().a(paramLong, str);
        return;
        str = lcb.a(3, paramString1, new int[0]);
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
        bdll.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      bdll.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomMicModeChanged, manager uin[" + paramLong + "], old isRoomMicOff[" + a().W + "], new isRoomMicOff[" + paramBoolean1 + "], mIsMicOffBySelf[" + this.jdField_u_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], micAuthByAdmin[" + a().H + "], isCreateRoomOrEnterRoom[" + paramBoolean2 + "], bNeedUpdateMic[" + bool + "]");
      a().c("onGAudioRoomMicModeChanged", paramBoolean1);
      int i1;
      long l1;
      if ((bool) && (!this.jdField_u_of_type_Boolean) && ((paramLong != this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) || (!paramBoolean1)) && (paramBoolean1))
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
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Llb == null) {
      achd.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    N();
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramArrayOfByte, null);
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
      lcv locallcv = new lcv();
      locallcv.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_a_of_type_JavaUtilArrayList.add(locallcv);
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
    if (!bhnv.d(a())) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      c();
      if ((this.jdField_n_of_type_Int == 0) && (lzq.e(paramVideoAppInterface.getApp()))) {
        this.jdField_n_of_type_Int = 1;
      }
      this.jdField_a_of_type_Mur = mur.a(this.jdField_a_of_type_AndroidContentContext, this);
      if (this.x) {
        J();
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateProcessInfo(0L, "qqVersion", AppSetting.a(a()));
      return;
      if (bhnv.a(a())) {
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
      ((Set)localObject1).add(Long.valueOf(((lcv)((Iterator)localObject2).next()).jdField_a_of_type_Long));
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
        lcv locallcv = new lcv();
        locallcv.jdField_d_of_type_Int = 0;
        locallcv.jdField_a_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
        locallcv.jdField_h_of_type_Boolean = false;
        locallcv.jdField_d_of_type_Long = ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get();
        this.jdField_b_of_type_JavaUtilArrayList.add(locallcv);
        paramInt1 = 1;
        i2 = paramInt1;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver add member UIN:" + locallcv.jdField_a_of_type_Long);
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
        localObject2 = (lcv)((Iterator)localObject1).next();
      } while (((lcv)localObject2).jdField_a_of_type_Long != paramPBRepeatMessageField1.uint64_member_uin.get());
      this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
      if (paramInt2 != 2) {
        paramInt1 = 1;
      }
      i1 = paramInt1;
      if (!QLog.isColorLevel()) {
        break label548;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mMemberChangeEventReceiver remove member UIN:" + ((lcv)localObject2).jdField_a_of_type_Long);
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
      } while ((!q()) && (this.jdField_a_of_type_Lcb.b()));
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mum.a(a()).b();
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
    if ((1 != c()) && (!e()))
    {
      a(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Lce != null) {
      this.jdField_a_of_type_Lce.b();
    }
    this.jdField_h_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt, this);
    if ((q()) && (paramInt != 110)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), a().jdField_d_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((ldb)localObject).a(paramInt);
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
        mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext());
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
      paramString2 = new VideoController.15(this, paramString1);
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
    paramString = lcb.a().a(paramString);
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
    lff locallff = a();
    int i2 = locallff.F;
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
      locallff = a();
    }
    for (;;)
    {
      locallff.x = paramInt1;
      locallff.y = paramInt2;
      locallff.jdField_n_of_type_JavaLangString = paramString2;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onChannelReady, fromUin[" + paramString1 + "], hdModeFreeUseStartTime[" + paramInt1 + "], hdModeFreeUseEndTime[" + paramInt2 + "], hdModeFreeUseTips[" + paramString2 + "], roomId[" + paramLong + "], session[" + locallff + "]");
      lic.a(30);
      lic.a(9, locallff.b());
      lic.a(11, locallff.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController$StartRingRunnable = null;
      }
      mum.a(a()).a();
      if (1L == locallff.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Mur.b(l1);
        if ((locallff.S) && (locallff.jdField_e_of_type_Boolean) && (!l())) {
          this.jdField_a_of_type_Mur.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
        a(true, locallff.jdField_d_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Mur.b(l1);
      if (locallff.jdField_j_of_type_Int != 1011) {
        mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true, l1);
      }
      locallff.b(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString1));
      locallff.c(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString1));
      locallff.d(paramLong);
      k();
      locallff.jdField_h_of_type_Int = locallff.jdField_g_of_type_Int;
      locallff.a("onChannelReady", 4);
      locallff.a(l1, SystemClock.elapsedRealtime());
      if ((locallff.jdField_e_of_type_Boolean) && (!l()))
      {
        if (locallff.S) {
          this.jdField_a_of_type_Mur.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        }
      }
      else
      {
        label501:
        if ((locallff.jdField_d_of_type_Int == 1) && (locallff.jdField_j_of_type_Int == 1011))
        {
          locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 5;
          a(locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int, 1, null);
        }
        paramString2 = (lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
        if (!locallff.jdField_e_of_type_Boolean) {
          break label876;
        }
        paramInt1 = 11;
        label568:
        paramString2.a(locallff.b(), paramInt1, 1L);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
          break label881;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13), Long.valueOf(l1) });
        if (l()) {
          a(l1, 2131230736, 1, null);
        }
        c();
        label639:
        if (!locallff.jdField_g_of_type_Boolean) {
          break label888;
        }
        a(true, locallff.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.8(this, l1), 50L);
        a(locallff.jdField_c_of_type_JavaLangString, locallff.jdField_d_of_type_Int, true, true, true);
        mru.i(this);
        mru.c(this, true);
        mru.b(this, true);
        paramLong = f();
        paramString2 = bhsi.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        paramString2.edit().putLong("qav_roomid", paramLong).commit();
        paramLong = c(paramString1);
        paramString2.edit().putLong(VideoConstants.jdField_g_of_type_JavaLangString, paramLong).commit();
        o(false);
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 != null) {
          paramString1.a();
        }
        if (this.jdField_a_of_type_Lce != null) {
          this.jdField_a_of_type_Lce.a();
        }
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
          break;
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramString1 == null) {
          break;
        }
        paramString1.a(locallff);
        return;
        if (this.jdField_a_of_type_Mur.a()) {
          break label501;
        }
        this.jdField_a_of_type_Mur.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        break label501;
        label876:
        paramInt1 = 4;
        break label568;
        label881:
        c();
        break label639;
        label888:
        a(false, locallff.jdField_d_of_type_JavaLangString);
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
    lff locallff = this.jdField_a_of_type_Lcb.c(paramString1);
    if (locallff == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> session == null, return!");
      return;
    }
    if (paramInt2 == 21) {
      if ((locallff.jdField_i_of_type_Int == 11) || (locallff.jdField_i_of_type_Int == 12))
      {
        paramInt2 = 47;
        locallff.a(1, 0);
        paramInt1 = 0;
      }
    }
    label898:
    label905:
    for (;;)
    {
      boolean bool = false;
      if ((locallff.j()) && (paramInt2 == 1)) {
        bool = true;
      }
      String str;
      label452:
      label495:
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
        localIntent.putExtra("bindType", locallff.A);
        localIntent.putExtra("bindId", locallff.jdField_p_of_type_JavaLangString);
        localIntent.putExtra("MultiAVType", locallff.D);
        if (paramInt2 == 17) {
          localIntent.putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
          break label731;
        }
        if (paramInt2 == 20) {
          paramString3 = paramString1;
        }
        str = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          str = paramString1;
        }
        if (locallff.J)
        {
          if (!locallff.M) {
            break label803;
          }
          str = paramString1;
        }
        localIntent.putExtra("friendUin", paramString2);
        localIntent.putExtra("senderUin", str);
        localIntent.putExtra("selfUin", paramString1);
        if (locallff.jdField_e_of_type_Boolean) {
          break label810;
        }
        paramBoolean1 = true;
        localIntent.putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label872;
        }
        if (this.jdField_b_of_type_Long <= 0L) {
          break label861;
        }
        f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
        if (f1 >= 1024.0F) {
          break label816;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
        label579:
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
          break label905;
        }
        if ((locallff.jdField_i_of_type_Int == 16) || (locallff.jdField_i_of_type_Int == 17)) {}
        for (paramInt2 = 47;; paramInt2 = 48)
        {
          locallff.a(1, 0);
          paramInt1 = 0;
          break;
        }
        if (locallff.l()) {
          bool = true;
        }
      }
      label731:
      if (paramInt1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label898;
        }
      }
      for (;;)
      {
        if (locallff.jdField_e_of_type_Boolean) {}
        for (paramString2 = paramString3;; paramString2 = paramString1)
        {
          str = paramString3;
          paramString3 = paramString2;
          paramString2 = str;
          break;
        }
        if (locallff.jdField_e_of_type_Boolean) {}
        for (paramString3 = paramString2;; paramString3 = paramString1) {
          break;
        }
        label803:
        str = paramString2;
        break label452;
        label810:
        paramBoolean1 = false;
        break label495;
        label816:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label579;
        label861:
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sendVideoMsgBroadcast() -> return!  no to show net traffic tips msg in AIO");
        return;
        label872:
        if (locallff.jdField_e_of_type_Long > 0L)
        {
          paramString1 = mvd.a(a());
          break label579;
        }
        paramString1 = null;
        break label579;
        paramString3 = paramString2;
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l1 = AudioHelper.b();
    lff locallff = this.jdField_a_of_type_Lcb.b(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], reason[" + paramInt + "], extraParam[" + paramLong + "], seq[" + l1 + "], Main[" + this.jdField_a_of_type_Lcb.a() + "], come[" + locallff + "]");
    if (locallff == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, fromUin[" + paramString + "], no session");
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ldb)localObject).a(paramInt);
      }
      if (q()) {
        D();
      }
      if (((locallff.jdField_j_of_type_Int != 1011) && (locallff.jdField_j_of_type_Int != 21)) || (!locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Boolean)) {
        break;
      }
      lbj.d(jdField_a_of_type_JavaLangString, "onCloseVideo fWaitAutoAnswer = " + locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Boolean);
      locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0, this);
    } while ((q()) && ((paramInt == 2) || (paramInt == 3)));
    d(paramInt);
    return;
    y(locallff.jdField_c_of_type_JavaLangString);
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
        if (locallff.jdField_d_of_type_Int != 2) {
          break label798;
        }
        bdll.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
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
          a(locallff.jdField_j_of_type_Int, locallff.jdField_d_of_type_JavaLangString, locallff.jdField_i_of_type_Long, 0);
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
          if (locallff.jdField_d_of_type_Int == 2)
          {
            bdll.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          bdll.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
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
          bdll.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
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
        bdll.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      if (paramLong == 100L)
      {
        localObject = lcb.a(3, paramString, new int[0]);
        locallff = null;
        if (this.jdField_a_of_type_Lcb.a((String)localObject)) {
          locallff = this.jdField_a_of_type_Lcb.c((String)localObject);
        }
        if ((locallff != null) && (locallff.jdField_g_of_type_Int == 1))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "onCloseVideo, set autoAcceptChat, seq[" + l1 + "]");
          locallff.jdField_d_of_type_Boolean = true;
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
        locallff.jdField_s_of_type_Boolean = false;
        a(l1, paramString, 12);
        return;
      }
      if (paramLong == 61L)
      {
        locallff.jdField_s_of_type_Boolean = false;
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
              bdll.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
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
      this.jdField_h_of_type_JavaLangRunnable = new VideoController.21(this, l1);
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
      if (this.jdField_a_of_type_Lcb != null)
      {
        paramString = this.jdField_a_of_type_Lcb.c(paramString);
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
    paramString = lfr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    Object localObject = lcb.a(3, paramString, new int[0]);
    localObject = this.jdField_a_of_type_Lcb.c((String)localObject);
    if (localObject != null) {
      ((lff)localObject).a(l1, "onOtherTerminalChatingStatus", paramInt);
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
      lde.a();
    }
    label69:
    while (paramLong2 != 2L) {
      return;
    }
    lde.a(paramLong3);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "], seq[" + l1 + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", mrs.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    muk.a(localNewIntent, l1);
    a(localNewIntent);
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
        h("gAudioSetInput", paramInt);
        paramLong = mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
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
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + mrs.a(paramLong) + ", uinType = " + a().jdField_j_of_type_Int);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
    if (a().jdField_j_of_type_Int == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", mrs.a(paramString));
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
            a().jdField_a_of_type_Lfg.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          a().jdField_a_of_type_Lfg.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 3) {
          break;
        }
        lcv locallcv = a(paramString);
        if (locallcv != null)
        {
          locallcv.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lfg.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    lbj.d(jdField_a_of_type_JavaLangString, String.format("onReceiveCreativeCopMsg|type=%d, id=%s", new Object[] { Long.valueOf(paramAVFunChatMessage.uint64_type.get()), paramAVFunChatMessage.str_msg.get() }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(173), paramString, paramAVFunChatMessage });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(162), paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    lff locallff = null;
    if (this.jdField_a_of_type_Lcb != null) {
      locallff = this.jdField_a_of_type_Lcb.c(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    for (String str = "mApp is null";; str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "sendStopVideoBroadcast[" + paramString1 + "], sessionId[" + paramString2 + "], uinType[" + paramInt1 + "], peerUin[" + paramString3 + "], extraUin[" + paramString4 + "], stopReason[" + paramInt2 + "], senderUin[" + paramString5 + "], isSystemCalling[" + paramBoolean1 + "], selfUin[" + str + "], isDouble[" + paramBoolean2 + "], session[" + locallff + "]");
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (locallff != null) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
        break;
      }
      return;
    }
    paramString1 = new Intent();
    paramString1.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    paramString1.setAction("tencent.av.v2q.StopVideoChat");
    paramString1.putExtra("sessionId", paramString2);
    paramString1.putExtra("uinType", paramInt1);
    paramString1.putExtra("bindType", locallff.A);
    paramString1.putExtra("bindId", locallff.jdField_p_of_type_JavaLangString);
    paramString1.putExtra("peerUin", paramString3);
    paramString1.putExtra("sessionType", locallff.jdField_d_of_type_Int);
    paramString1.putExtra("isDoubleVideoMeeting", locallff.J);
    paramString1.putExtra("extraUin", paramString4);
    paramString1.putExtra("stopReason", paramInt2);
    paramString1.putExtra("isSystemCalling", paramBoolean1);
    paramString1.putExtra("isDouble", paramBoolean2);
    paramString1.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramString1.putExtra(VideoConstants.jdField_d_of_type_JavaLangString, locallff.jdField_e_of_type_Long);
    paramString1.putExtra(VideoConstants.jdField_e_of_type_JavaLangString, SystemClock.elapsedRealtime());
    paramString1.putExtra(VideoConstants.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getSdkVersion());
    paramString1.putExtra("score_connect_duration", a());
    long l1 = 0L;
    if ((locallff.jdField_d_of_type_Int == 1) || (locallff.jdField_d_of_type_Int == 2)) {
      l1 = 1L;
    }
    if ((locallff.jdField_d_of_type_Int == 3) || (locallff.jdField_d_of_type_Int == 4)) {
      l1 = 2L;
    }
    paramString1.putExtra(VideoConstants.i, l1);
    if ((locallff.jdField_d_of_type_Int == 1) || (locallff.jdField_d_of_type_Int == 3)) {}
    for (l1 = 1L;; l1 = 0L)
    {
      paramString1.putExtra(VideoConstants.j, l1);
      if (this.jdField_a_of_type_Lcb.c(paramString2).l != null) {
        paramString1.putExtra("actId", this.jdField_a_of_type_Lcb.c(paramString2).l);
      }
      if (this.jdField_a_of_type_Lcb.c(paramString2).jdField_m_of_type_JavaLangString != null) {
        paramString1.putExtra("mp_ext_params", this.jdField_a_of_type_Lcb.c(paramString2).jdField_m_of_type_JavaLangString);
      }
      if (!paramBoolean2)
      {
        paramString1.putExtra("relationType", this.jdField_a_of_type_Lcb.c(paramString2).F);
        paramString1.putExtra("relationId", this.jdField_a_of_type_Lcb.c(paramString2).jdField_g_of_type_Long);
        if (!TextUtils.isEmpty(paramString5)) {
          break label661;
        }
        paramString1.putExtra("senderUin", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramString1);
        return;
        lln.a().a.a();
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
          a().jdField_a_of_type_Lfg.jdField_g_of_type_JavaLangString = paramString2;
        }
        lcv locallcv;
        for (;;)
        {
          if (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 3) {
            break label195;
          }
          locallcv = a(paramString1);
          if (locallcv == null) {
            break label155;
          }
          if (!paramBoolean) {
            break;
          }
          locallcv.jdField_b_of_type_JavaLangString = paramString2;
          return;
          a().jdField_a_of_type_Lfg.jdField_f_of_type_JavaLangString = paramString2;
        }
        locallcv.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int != 1);
    a().jdField_a_of_type_Lfg.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", lcy.a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    a().T = paramBoolean;
    if (paramBoolean) {
      mru.o(this);
    }
    if (mtd.d(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) {
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  void a(lcv paramlcv, int paramInt)
  {
    paramlcv.jdField_b_of_type_Int = 0;
    paramlcv.jdField_b_of_type_Boolean = false;
    paramlcv.jdField_c_of_type_Boolean = false;
    paramlcv.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramlcv.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramlcv.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramlcv.jdField_b_of_type_Int = 1;
      return;
    }
    paramlcv.jdField_d_of_type_Boolean = true;
  }
  
  public void a(lnd paramlnd, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut--> UserInfo = " + paramlnd.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramlnd.jdField_a_of_type_Int == 1)
      {
        if (a().a(paramlnd.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList) == null) {
          break label183;
        }
        localAVPhoneUserInfo = a().a(paramlnd.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + localAVPhoneUserInfo);
        }
      }
      a(paramInt2, paramLong1, paramlnd, true, paramLong2, paramVarArgs);
    }
    label183:
    do
    {
      return;
      localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramlnd.jdField_a_of_type_Long;
      localAVPhoneUserInfo.accountType = 2;
      a().a(localAVPhoneUserInfo);
      d(paramlnd.jdField_a_of_type_Long);
      break;
      if (paramInt1 == 71)
      {
        if (paramlnd.jdField_a_of_type_Int == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramlnd.jdField_a_of_type_Long;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramlnd, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  void a(lnd paramlnd, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    if (paramBoolean) {}
    Object localObject1;
    try
    {
      if (a(paramlnd.jdField_a_of_type_Long) != -1) {
        return;
      }
      localObject1 = new lcv();
      ((lcv)localObject1).jdField_a_of_type_Long = paramlnd.jdField_a_of_type_Long;
      ((lcv)localObject1).jdField_d_of_type_Int = paramlnd.jdField_a_of_type_Int;
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut, size[" + this.jdField_c_of_type_JavaUtilArrayList.size() + "], coming[" + paramlnd + "]");
      return;
    }
    finally {}
    int i1 = a(paramlnd.jdField_a_of_type_Long);
    Object localObject2 = null;
    if (i1 != -1) {
      localObject1 = (lcv)this.jdField_c_of_type_JavaUtilArrayList.remove(i1);
    }
    for (;;)
    {
      a(paramlnd.jdField_a_of_type_Long, a().jdField_c_of_type_JavaUtilArrayList, a().jdField_d_of_type_JavaUtilArrayList, 0, true);
      u();
      if ((localObject1 == null) || (((lcv)localObject1).jdField_e_of_type_Boolean) || (!((lcv)localObject1).jdField_g_of_type_Boolean)) {
        break;
      }
      a(0L, false, 0L);
      break;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramlnd);
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
            A();
          }
          else
          {
            a("notifyAnotherSelfIsRing", false);
            if (a().jdField_P_of_type_Boolean)
            {
              if (this.jdField_g_of_type_JavaLangRunnable == null) {
                this.jdField_g_of_type_JavaLangRunnable = new VideoController.20(this);
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
        mtn localmtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localmtn != null) {
          localmtn.a(paramVarArgs.jdField_c_of_type_JavaLangString);
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
      a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 30);
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
    lff locallff = a();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onPhoneCalling, isSelf[").append(paramBoolean1).append("], isCalling[").append(locallff.jdField_b_of_type_Boolean).append("->").append(paramBoolean2).append("], deviceName[").append(locallff.jdField_q_of_type_JavaLangString).append("], audioStateBeforePhoneCall[").append(locallff.t).append("], mTraeHelper[");
    if (this.jdField_a_of_type_Mur != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Mur != null) {
        break;
      }
      return;
    }
    if ((locallff.jdField_j_of_type_Int == 0) && (locallff.jdField_g_of_type_Int != 0) && (locallff.jdField_g_of_type_Int != 5) && (locallff.jdField_g_of_type_Int != 6) && (locallff.jdField_b_of_type_Boolean != paramBoolean2))
    {
      locallff.jdField_b_of_type_Boolean = paramBoolean2;
      if (!paramBoolean2) {
        break label266;
      }
      this.jdField_a_of_type_Mur.b();
      locallff.t = locallff.jdField_q_of_type_JavaLangString;
    }
    for (;;)
    {
      if (((locallff.jdField_d_of_type_Int == 3) || (locallff.jdField_d_of_type_Int == 4)) && (locallff.jdField_b_of_type_Boolean != paramBoolean2)) {
        locallff.jdField_b_of_type_Boolean = paramBoolean2;
      }
      if (!paramBoolean1) {
        break label357;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean2) });
      return;
      label266:
      if ("DEVICE_SPEAKERPHONE".equals(locallff.t))
      {
        this.jdField_a_of_type_Mur.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      else
      {
        if (!"DEVICE_EARPHONE".equals(locallff.t)) {
          break;
        }
        this.jdField_a_of_type_Mur.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
    }
    if (locallff.jdField_d_of_type_Int == 1) {}
    for (str = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";; str = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;")
    {
      this.jdField_a_of_type_Mur.a(str);
      break;
    }
    label357:
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean2) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), a().jdField_d_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecordAudio=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
    if (paramInt1 == 100) {
      if ((this.jdField_a_of_type_ArrayOfMoq != null) && (this.jdField_a_of_type_ArrayOfMoq[0] != null)) {
        this.jdField_a_of_type_ArrayOfMoq[0].a(paramArrayOfByte, paramInt1, paramInt2);
      }
    }
    while (((paramInt1 != 3) && (paramInt1 != 0)) || (this.jdField_a_of_type_ArrayOfMoq == null) || (this.jdField_a_of_type_ArrayOfMoq[1] == null)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMoq[1].a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    lcy.a(paramArrayOfByte);
    if (this.jdField_a_of_type_Llb == null)
    {
      bdll.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_Llb.b(paramArrayOfByte, paramLong);
  }
  
  public void a(long[] paramArrayOfLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    if (str != null)
    {
      long l1 = mrs.a(str);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "inviteNewMemJoin, uinList[" + paramArrayOfLong + "], needNotifyUI[" + paramBoolean + "], mMultiInviteEntranceFlag[" + this.jdField_f_of_type_Int + "]");
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    do
    {
      return;
      if (this.jdField_f_of_type_Int == 1)
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
    lff locallff = a();
    String str = lcb.a(3, paramString, new int[0]);
    if (TextUtils.equals(locallff.jdField_c_of_type_JavaLangString, str)) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt == 1011) && (locallff.jdField_j_of_type_Int == paramInt) && (TextUtils.equals(locallff.jdField_d_of_type_JavaLangString, paramString)));
      paramInt = this.jdField_a_of_type_Lcb.a();
      if (paramInt >= 2)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDAV, to many session, reject. [" + paramInt + "]");
        return true;
      }
    } while ((!locallff.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()));
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
    paramBoolean = e(paramString1);
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString1))) {}
    for (paramInt2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1);; paramInt2 = a(paramInt1, false, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo converted uinType = " + paramInt2 + ",sdkAVAccostType = " + paramInt1 + "|" + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      }
      if (this.jdField_a_of_type_Lcb.a() < 2) {
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
    if ((paramInt2 != 21) && (paramInt2 != 1011) && ((a().jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo when in Random Double");
      }
      if (bool) {
        return false;
      }
    }
    else if ((a().jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int == 3))
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
      if (((paramInt2 == 21) || (paramInt2 == 1011)) && (a().jdField_a_of_type_Lfg.jdField_b_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo  auto Accept");
        }
        if ((a().jdField_a_of_type_Lfg.jdField_c_of_type_JavaLangString != null) && (!a().jdField_a_of_type_Lfg.jdField_c_of_type_JavaLangString.equals(paramString1))) {
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
          lbj.d(jdField_a_of_type_JavaLangString, "isRequestVideo when request: fromUin = " + paramString1);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isRequestVideo orientation: " + this.jdField_s_of_type_Int + ", isQQPaused: " + VideoConstants.jdField_b_of_type_Boolean + ", isVideoPaused: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + ", isScreenLocked: " + bool + ", isAppOnForeground: " + GesturePWDUtils.isAppOnForegroundByTasks(a()));
    }
    return true;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {}
    lff locallff;
    do
    {
      String str;
      do
      {
        return false;
        str = lcb.a(100, String.valueOf(paramLong), new int[0]);
        locallff = a();
      } while (TextUtils.equals(str, locallff.jdField_c_of_type_JavaLangString));
      paramInt1 = this.jdField_a_of_type_Lcb.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectDM, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!locallff.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()));
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
        lcv locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        if ((locallcv == null) || (locallcv.jdField_a_of_type_Long != paramLong)) {
          break label186;
        }
        locallcv.jdField_e_of_type_Boolean = paramBoolean;
        locallcv.jdField_d_of_type_Int = paramInt1;
        bool = locallcv.jdField_g_of_type_Boolean;
        if (paramBoolean)
        {
          locallcv.jdField_g_of_type_Boolean = false;
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
  
  public boolean a(String paramString, lff paramlff)
  {
    boolean bool2;
    if (paramlff == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    int i1 = paramlff.e();
    long l1 = paramlff.b();
    long l2 = paramlff.f();
    long l3;
    if (i1 == 2)
    {
      l3 = a(paramlff);
      if (l3 != paramlff.b()) {
        paramlff.d(l3);
      }
    }
    for (;;)
    {
      l3 = paramlff.b();
      long l4 = paramlff.f();
      if ((l1 != l3) || (l2 != l4)) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", new Object[] { paramString, Boolean.valueOf(bool1), paramlff, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      return bool1;
      if (i1 == 1)
      {
        l3 = b(paramlff);
        if (l3 != paramlff.b()) {
          paramlff.d(l3);
        }
      }
    }
  }
  
  public boolean a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    lff locallff = a();
    String str;
    boolean bool;
    if (paramBoolean) {
      if (paramInt == 3)
      {
        str = lcb.a(100, paramString2, new int[0]);
        if (TextUtils.equals(locallff.jdField_c_of_type_JavaLangString, str)) {
          break label231;
        }
        bool = lcb.a().b(str);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkMainSession, need reset main session, from[" + paramString1 + "], cur" + locallff.jdField_c_of_type_JavaLangString + "], coming[" + str + "], ret[" + bool + "]");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "checkMainSession, from[" + paramString1 + "], isFromMAVEngine[" + paramBoolean + "], relationType[" + paramInt + "], relationId[" + paramString2 + "], ret[" + bool + "]");
      }
      return bool;
      str = lcb.a(paramInt, paramString2, new int[0]);
      break;
      str = lcb.a(paramInt, paramString2, new int[0]);
      break;
      label231:
      bool = false;
    }
  }
  
  public boolean a(lff paramlff1, lff paramlff2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlff1.jdField_d_of_type_JavaLangString);
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
          paramlff2.a(paramLong1, paramlff1.jdField_j_of_type_Boolean);
          a(paramString, paramlff2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_e_of_type_JavaLangRunnable != null) && (localVideoAppInterface != null)) {
            localVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
          }
          if (!paramlff1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          int i1 = paramlff1.jdField_d_of_type_Int;
          paramlff2.aE = true;
          paramlff2.jdField_d_of_type_JavaLangString = paramlff1.jdField_d_of_type_JavaLangString;
          if ((paramlff1.jdField_g_of_type_Int == 15) || (paramlff1.jdField_K_of_type_Boolean)) {
            f(false);
          }
          paramlff1.a(3, 12);
          if (i1 == 1)
          {
            paramlff1.a(paramLong1, "onGAudioInvite.6", 3);
            paramlff1.jdField_j_of_type_Int = mvd.c(paramInt);
            paramlff1.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlff1.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlff1.c("onGAudioInvite.1", 1);
            if (localVideoAppInterface != null)
            {
              if (localVideoAppInterface.a() <= 0) {
                break label522;
              }
              paramlff1.d("onGAudioInvite3", mrl.a(paramlff1.jdField_j_of_type_Int));
              localVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            }
            paramlff2 = mtn.a(localVideoAppInterface);
            int i2 = 0;
            if (paramlff2 != null)
            {
              boolean bool2 = paramlff2.a();
              i2 = bool2;
              if (bool2)
              {
                paramlff2.a(paramlff1.jdField_c_of_type_JavaLangString);
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
            paramlff1.a(paramLong1, "onGAudioInvite.7", 4);
            continue;
          }
          if (i1 != 4) {
            break label510;
          }
        }
        catch (Exception paramlff1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramlff1.getMessage());
          }
          this.jdField_a_of_type_Lcb.a(paramLong1, paramString);
          return bool1;
        }
        paramlff1.a(paramLong1, "onGAudioInvite.8", 4);
        continue;
        label510:
        paramlff1.a(paramLong1, "onGAudioInvite.9", 3);
        continue;
        label522:
        if (localThrowable.isBackgroundStop)
        {
          paramlff1.d("onGAudioInvite4", 0);
          a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
          m(false);
        }
      }
    }
    if ((l1 == paramLong2) && (paramlff1.L))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], isTurnDoubleVideoMeeting2Multi[" + paramlff1.L + "], ret[" + bool1 + "], main[" + paramlff1 + "], new[" + paramlff2 + "]");
      }
      paramlff1.L = false;
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
          lcv locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(i3);
          if ((locallcv != null) && (locallcv.jdField_a_of_type_Long != mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
          {
            int i2 = i1;
            if (locallcv.jdField_b_of_type_Boolean) {
              i2 = i1 + 1;
            }
            i1 = i2;
            if (locallcv.jdField_d_of_type_Boolean) {
              i1 = i2 + 1;
            }
            if (locallcv.jdField_c_of_type_Boolean) {
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
    lbj.d(jdField_a_of_type_JavaLangString, "setVoiceType| sessionType=" + a().jdField_d_of_type_Int + "type=" + paramInt);
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
    lff locallff = lcb.a().a(paramString);
    if ((locallff != null) && (locallff.d() != -1)) {
      i1 = locallff.d();
    }
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return i1;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
  }
  
  public int b(lff paramlff, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getRoomUserSdkVersion(paramlff, paramString);
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
      long l1 = mrs.a(paramString);
      return l1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      lbj.e(jdField_a_of_type_JavaLangString, paramString.getMessage());
    }
    return -1L;
  }
  
  public long b(lff paramlff)
  {
    if (paramlff == null) {
      return 0L;
    }
    if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) && ((paramlff.jdField_d_of_type_Int == 3) || (paramlff.jdField_d_of_type_Int == 4)))
    {
      qav_gvideo_sdk_transfer.RespInfo localRespInfo = a(paramlff.F, paramlff.D, paramlff.jdField_g_of_type_Long);
      if (localRespInfo.uint32_result.get() == 0)
      {
        paramlff.d(localRespInfo.gAudioInfo.uint64_roomId.get());
        paramlff.d(localRespInfo.gAudioInfo.uint32_roomCreateTime.get());
      }
    }
    return paramlff.b();
  }
  
  public ArrayList<lcv> b()
  {
    if ((AudioHelper.e()) && (mqb.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      localArrayList.addAll(mqb.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void b(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportCloseReasonBeacon,reason  = " + paramInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("closeReason", String.valueOf(paramInt));
    bdmc.a(BaseApplicationImpl.getApplication()).a(null, "actAvideoCloseReasonB", true, 0L, 0L, localHashMap, "", true);
  }
  
  public void b(int paramInt, long paramLong)
  {
    String str = lcb.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str = lcb.a(100, String.valueOf(paramLong), new int[0]);
    }
    if (this.jdField_a_of_type_Lcb.a(str)) {}
    for (Object localObject = this.jdField_a_of_type_Lcb.c(str);; localObject = null)
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
          if (this.jdField_a_of_type_Mur != null) {
            this.jdField_a_of_type_Mur.b(l1);
          }
          mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          mur.a().b();
          if ((AudioHelper.f()) || (((lff)localObject).ar)) {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioRoomDestroy, \nmainsession[" + a() + "], \nstate[" + ((lff)localObject).jdField_g_of_type_Int + "], seq[" + l1 + "], isAcceptingMultiAV[" + ((lff)localObject).ar + "], isCurJoinedGRoom[" + a(paramInt, paramLong) + "]");
          }
        } while (((lff)localObject).ar);
        if (this.jdField_d_of_type_Long == paramLong)
        {
          this.jdField_d_of_type_Long = 0L;
          this.jdField_m_of_type_Int = 0;
        }
        if ((paramInt != 3) || (!((lff)localObject).J) || ((((lff)localObject).jdField_d_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((lff)localObject).jdField_d_of_type_JavaLangString).longValue()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + ((lff)localObject).jdField_d_of_type_JavaLangString + " ,relationId = " + paramLong);
      return;
      if ((!((lff)localObject).ah) && (!((lff)localObject).J))
      {
        int i1 = 6;
        if (((lff)localObject).jdField_g_of_type_Int == 7) {
          i1 = 5;
        }
        a("onGAudioRoomDestroy", str, mvd.c(paramInt), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(paramLong), i1, ((lff)localObject).jdField_s_of_type_JavaLangString, false, false);
      }
      if (a(paramInt, paramLong)) {
        a(paramInt, paramLong, 69);
      }
      ((lff)localObject).a("onGAudioRoomDestroy", 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(2) });
      if (this.jdField_a_of_type_Lcb.a(str))
      {
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_Lcb.c(str);
          paramInt = mvd.c(paramInt);
          a(((lff)localObject).jdField_c_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
        if (this.jdField_a_of_type_Lcb.a(l1, str))
        {
          localObject = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject != null) && (((mtn)localObject).a()))
          {
            ((mtn)localObject).a(str);
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
    lff locallff = a();
    if (locallff.ao) {}
    while (locallff.b(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < locallff.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((lob)locallff.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((lob)locallff.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((lob)locallff.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGroupVideoClosed, relationId[" + paramLong + "], reason[" + paramInt2 + "], avtype[" + paramInt3 + "], bKickout[" + this.jdField_v_of_type_Boolean + "], mGAudioInRoom[" + this.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "]");
    if (this.jdField_v_of_type_Boolean) {
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
    String str = bhxi.a(l1, 3);
    if (new File(str).exists())
    {
      mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_f_of_type_Boolean = true;
      int i1 = a().jdField_p_of_type_Int;
      bdll.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230743, null, -1, null);
    a().jdField_f_of_type_Boolean = true;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_a_of_type_Lcb.a();
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
      localObject1 = lcb.a(100, String.valueOf(paramLong), new int[0]);
      this.jdField_a_of_type_Lcb.a((String)localObject1, false);
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
      this.jdField_a_of_type_Lcb.c((String)localObject1).a("onDoubleVideoMeetingInvite.1", 2);
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
      Object localObject2 = this.jdField_a_of_type_Lcb.c((String)localObject1);
      if (localObject2 != null)
      {
        ((lff)localObject2).S = true;
        ((lff)localObject2).jdField_f_of_type_Int = 2;
        ((lff)localObject2).jdField_j_of_type_Int = 0;
        ((lff)localObject2).F = 3;
        ((lff)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
        ((lff)localObject2).jdField_f_of_type_JavaLangString = null;
        ((lff)localObject2).jdField_e_of_type_Boolean = true;
        ((lff)localObject2).a("onDoubleVideoMeetingInvite.3", 2);
        ((lff)localObject2).e("onDoubleVideoMeetingInvite", true);
        ((lff)localObject2).jdField_s_of_type_JavaLangString = String.valueOf(paramLong);
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
      new blfn(this.jdField_a_of_type_AndroidContentContext, null).a(l1, 0, 2131230737, null, null, false, 1, false, true, 0);
      a(l1, 3, paramLong);
      a(l1, paramLong, 1);
      this.jdField_a_of_type_Lcb.a(l1, (String)localObject1);
      return;
      if ((a().o()) || (a().p()) || (a().q()))
      {
        if (String.valueOf(paramLong).equals(a().jdField_d_of_type_JavaLangString))
        {
          bool1 = true;
          this.jdField_a_of_type_Lcb.c((String)localObject1).a("onDoubleVideoMeetingInvite.2", 2);
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
      QLog.w(jdField_a_of_type_JavaLangString, 1, "onDoubleVideoMeetingInvite, mOrientation[" + this.jdField_s_of_type_Int + "], isQQPaused[" + VideoConstants.jdField_b_of_type_Boolean + "], isVideoPaused[" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause + "], isScreenLocked[" + bool2 + "], isAppOnForeground[" + GesturePWDUtils.isAppOnForegroundByTasks(a()) + "], seq[" + l1 + "]");
    }
    if ((this.x) && (this.jdField_s_of_type_Int == 0) && (!bool2) && (VideoConstants.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
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
    lff locallff = a();
    if ((locallff.jdField_d_of_type_Int != 2) || ((locallff.jdField_w_of_type_Int != 2) && (locallff.jdField_w_of_type_Int != 3))) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10001), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onGAudioInviteRespFail, groupId[" + paramLong1 + "], mGAudioGroupId[" + this.jdField_a_of_type_Long + "], err[" + paramLong2 + "], msg[" + paramString + "]");
    if (paramLong1 == this.jdField_a_of_type_Long) {
      QQToast.a(a(), 2131695065, 1).a();
    }
  }
  
  public void b(long paramLong1, long paramLong2, ArrayList<lnv> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoController.29(this, paramArrayList, paramLong1, paramLong2));
  }
  
  public void b(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str = lcb.a(3, paramString, new int[0]);
      if (this.jdField_a_of_type_Lcb.a(str)) {}
      for (lff locallff = this.jdField_a_of_type_Lcb.c(str); locallff == null; locallff = this.jdField_a_of_type_Lcb.c(str))
      {
        QLog.w(jdField_a_of_type_JavaLangString + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + paramString + "], type[" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], seq[" + paramLong + "]");
        lic.a(0L, 33);
        lic.b(0L);
        return;
        str = lcb.a(100, paramString, new int[0]);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ljz)localObject).a(locallff);
      }
      lic.a(locallff.b(), 16, 0L);
      lic.a(locallff.b(), 33);
      lic.b(locallff.b());
      localObject = (lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
      if (locallff.jdField_e_of_type_Boolean) {}
      for (int i2 = 12;; i2 = 5)
      {
        ((lie)localObject).a(locallff.b(), i2, i1 + 500);
        ((lie)localObject).a("NoCrash");
        ((lie)localObject).a(locallff.b(), 29, 1L);
        ((lie)localObject).a(36, 1L);
        ((lie)localObject).b(locallff.b());
        QLog.w(jdField_a_of_type_JavaLangString, 1, "avideo doCloseSession, peerUin[" + paramString + "], type[" + paramInt + "->" + i1 + "], fourceCloseIgnoreSessionState[" + paramBoolean + "], mIsQuit[" + this.jdField_a_of_type_Boolean + "], sessionId[" + str + "], sessionInfo.isIdling[" + locallff.f() + "], sessionInfo.peerUin[" + locallff.jdField_d_of_type_JavaLangString + "], sessionInfo.isOnlyAudio[" + locallff.S + "], sessionInfo.SessionType[" + locallff.jdField_d_of_type_Int + "], mNetTrafficAllSize[" + this.jdField_b_of_type_Long + "], mAnyChatCloseByFriend[" + this.jdField_f_of_type_Boolean + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        if (this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable);
          this.jdField_a_of_type_ComTencentAvVideoController$AnyChatReqTimeoutRunnable = null;
        }
        if ((!locallff.f()) || (paramBoolean)) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeSession state error!!!");
        return;
      }
      if ((locallff.jdField_d_of_type_Int == 2) && (!locallff.J) && (locallff.jdField_g_of_type_Int >= 4) && (locallff.jdField_e_of_type_Long > 0L))
      {
        i2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN");
        lbj.d(jdField_a_of_type_JavaLangString, "closeSession double video call end with beauty: " + i2 + " | " + locallff.jdField_e_of_type_Long + " | " + locallff.jdField_g_of_type_Int + " | " + locallff.jdField_u_of_type_Boolean);
        if ((locallff.jdField_u_of_type_Boolean) || (i2 > 0)) {
          bdll.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      if ((this.jdField_s_of_type_Boolean) && (a() > 0L))
      {
        if (locallff.jdField_d_of_type_Int == 1) {
          bdll.b(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", mvd.a(a()), "");
        }
      }
      else
      {
        label763:
        locallff.jdField_d_of_type_Long = 0L;
        locallff.jdField_o_of_type_JavaLangString = null;
        localObject = paramString;
        if (!TextUtils.isEmpty(locallff.jdField_d_of_type_JavaLangString))
        {
          localObject = paramString;
          if (locallff.jdField_d_of_type_JavaLangString.contains(paramString)) {
            localObject = locallff.jdField_d_of_type_JavaLangString;
          }
        }
        if ((locallff.o()) || (locallff.p())) {
          locallff.z = i1;
        }
        if ((locallff.h()) || ((locallff.j()) && (i1 == locallff.z))) {
          locallff.a(paramLong, 0L);
        }
        if ((locallff.ai) && (this.jdField_f_of_type_JavaLangRunnable != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (paramInt != 23) {
          break label1585;
        }
        paramBoolean = false;
        if (locallff.jdField_d_of_type_Int == 2) {
          paramBoolean = true;
        }
        a(locallff.jdField_c_of_type_JavaLangString, locallff.jdField_j_of_type_Int, paramBoolean, locallff.jdField_d_of_type_JavaLangString, locallff.jdField_f_of_type_JavaLangString);
        label949:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_Lcb.a())
        {
          i();
          k();
          t();
        }
        locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Boolean = false;
        locallff.jdField_a_of_type_Lfg.jdField_a_of_type_JavaLangString = null;
        locallff.jdField_a_of_type_Lfg.jdField_b_of_type_JavaLangString = null;
        locallff.jdField_a_of_type_Lfg.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          mru.b(this, false);
          mru.c(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            mru.l(this);
          }
        }
        locallff.a("doCloseSession", 0);
        locallff.a(paramLong, "doCloseSession", 0);
        locallff.jdField_f_of_type_Int = 0;
        locallff.jdField_a_of_type_JavaUtilBitSet.clear();
        locallff.jdField_j_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        locallff.av = false;
        locallff.jdField_a_of_type_ArrayOfJavaLangString = null;
        locallff.b("doCloseSession", null);
        locallff.jdField_p_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + locallff.jdField_j_of_type_Int + " # matchStatus = " + locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (i1 != 72) && (locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean) && (i1 != 110))
        {
          locallff.jdField_j_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
            break label1599;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1261:
        if ((locallff.jdField_j_of_type_Int != 1011) || ((locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int != 2) && (locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int != 6))) {
          break label1626;
        }
        if ((!this.jdField_f_of_type_Boolean) && (locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int != 6)) {
          break label1609;
        }
        a(6, 1, null);
        label1325:
        this.jdField_a_of_type_Boolean = false;
        label1330:
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), localObject, Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong) });
        if ((l()) && (this.jdField_a_of_type_Boolean) && ((locallff.jdField_a_of_type_Lfg.jdField_a_of_type_Int == 1) || (locallff.jdField_a_of_type_Lfg.jdField_a_of_type_Int == 2)))
        {
          locallff.a();
          a(0, 0, null);
        }
        locallff.a(paramLong, false);
        locallff.b(paramLong, false);
        locallff.a(paramLong, 0L);
        locallff.b(paramLong);
        paramBoolean = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1644;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str);
        paramBoolean = this.jdField_a_of_type_Lcb.a(paramLong, str);
      }
      for (;;)
      {
        paramString = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str);
        if (!paramBoolean) {
          break;
        }
        c();
        return;
        if (locallff.jdField_d_of_type_Int != 2) {
          break label763;
        }
        bdll.b(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", mvd.a(a()), "");
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
        a(locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int, 1, null);
        break label1325;
        label1626:
        if (!this.jdField_f_of_type_Boolean) {
          break label1330;
        }
        a(6, 1, null);
        break label1330;
        label1644:
        this.jdField_a_of_type_Lcb.a(str, 3);
      }
    }
  }
  
  public void b(long paramLong, ArrayList<lnd> paramArrayList) {}
  
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
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_k_of_type_Int, paramBundle);
  }
  
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
    mur.a().b(l1);
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (d(paramString)) {
      mur.a().b();
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
        localObject = (lcv)localIterator.next();
        if ((((lcv)localObject).jdField_d_of_type_Int == 1) && (((lcv)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((lcv)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onRecvMultiVideoCallData buf=%s", new Object[] { paramArrayOfByte }));
    }
    L();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(this.jdField_i_of_type_Int, paramArrayOfByte);
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
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
    lff locallff;
    do
    {
      do
      {
        return false;
        locallff = this.jdField_a_of_type_Lcb.a();
      } while ((locallff.F == paramInt1) && (locallff.jdField_g_of_type_Long == paramLong));
      paramInt1 = this.jdField_a_of_type_Lcb.a();
      if (paramInt1 >= 2)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, to many session, reject. [" + paramInt1 + "]");
        return true;
      }
    } while ((!locallff.j()) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i()));
    QLog.i(jdField_a_of_type_JavaLangString, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
    return true;
  }
  
  public boolean b(String paramString)
  {
    int i1 = b(paramString);
    return (i1 == 5) || (i1 == 14);
  }
  
  public boolean b(lff paramlff1, lff paramlff2, long paramLong1, long paramLong2, String paramString, int paramInt, long paramLong3, long[] paramArrayOfLong)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramlff1.jdField_d_of_type_JavaLangString);
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
          paramlff2.a(paramLong1, paramlff1.jdField_j_of_type_Boolean);
          a(paramString, paramlff2.jdField_d_of_type_Int, false, false, false);
          if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          }
          if (!paramlff1.b()) {
            a(paramLong1, 2131230736, 1, null);
          }
          i1 = paramlff1.jdField_d_of_type_Int;
          paramlff2.jdField_d_of_type_JavaLangString = paramlff1.jdField_d_of_type_JavaLangString;
          paramlff2.a(paramLong1, paramlff1.jdField_j_of_type_Boolean);
          paramlff2.jdField_g_of_type_Boolean = paramlff1.jdField_g_of_type_Boolean;
          paramlff2.b("onGAudioInvite", paramlff1.jdField_P_of_type_Boolean);
          paramlff2.b("onGAudioInvite", paramlff1.jdField_q_of_type_JavaLangString);
          paramlff2.aE = true;
          paramlff2.a(3, 12);
          paramlff1.a(3, 12);
          b(paramlff1.jdField_d_of_type_JavaLangString, 21);
          if (i1 == 1)
          {
            paramlff2.a(paramLong1, "onGAudioInvite.2", 3);
            paramlff2.jdField_j_of_type_Int = mvd.c(paramInt);
            paramlff2.jdField_g_of_type_Long = paramLong3;
            if (paramArrayOfLong != null) {
              paramlff2.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
            }
            paramlff2.c("onGAudioInvite.2", 1);
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() <= 0) {
              break label547;
            }
            paramlff2.d("onGAudioInvite1", mrl.a(paramlff2.jdField_j_of_type_Int));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(paramLong1) });
            paramlff1 = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            int i2 = 0;
            if (paramlff1 != null)
            {
              boolean bool2 = paramlff1.a();
              i2 = bool2;
              if (bool2)
              {
                paramlff1.a(paramString);
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
        catch (Exception paramlff1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite, Exception", paramlff1);
          }
          this.jdField_a_of_type_Lcb.a(paramLong1, paramString);
          return bool1;
        }
        if (i1 == 2)
        {
          paramlff2.a(paramLong1, "onGAudioInvite.3", 4);
        }
        else if (i1 == 4)
        {
          paramlff2.a(paramLong1, "onGAudioInvite.4", 4);
        }
        else
        {
          paramlff2.a(paramLong1, "onGAudioInvite.5", 3);
          continue;
          label547:
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop)
          {
            paramlff2.d("onGAudioInvite2", 0);
            a(paramLong1, paramInt, paramLong3, paramArrayOfLong, false);
            m(false);
          }
        }
      }
    }
    if ((l1 == paramLong2) && (paramlff1 != paramlff2))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + l1 + "], friendUin[" + paramLong2 + "], ret[" + bool1 + "], main[" + paramlff1 + "], new[" + paramlff2 + "]");
      }
      if (!bool1) {
        break label586;
      }
      if (paramlff1.z != 0) {
        break label164;
      }
      paramlff1.a("onGAudioInvite.2", 0);
      this.jdField_a_of_type_Lcb.a(paramLong1, paramString);
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
    return lev.a();
  }
  
  public int c(String paramString)
  {
    int i1 = -1;
    lff locallff = lcb.a().a(paramString);
    if ((locallff != null) && (locallff.c() != -1)) {
      i1 = locallff.c();
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
  
  public ArrayList<lcv> c()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if ((AudioHelper.e()) && (mqb.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localArrayList2 = new ArrayList();
        localArrayList2.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localArrayList2.addAll(mqb.jdField_a_of_type_JavaUtilArrayList);
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
        mtn localmtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = a();
        if (!((lff)localObject2).jdField_e_of_type_Boolean) {
          break label306;
        }
        if (((lff)localObject2).j())
        {
          if ((((lff)localObject2).jdField_d_of_type_Int == 1) || (((lff)localObject2).jdField_d_of_type_Int == 2))
          {
            if ((!((lff)localObject2).S) && (!((lff)localObject2).J))
            {
              i1 = 56;
              if ((((lff)localObject2).jdField_j_of_type_Int != 1011) && (!l())) {
                break label372;
              }
              i1 = ((lff)localObject2).jdField_d_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label665;
              }
              if (((lff)localObject2).F != 7) {
                break label695;
              }
              i1 = i2;
              if (((lff)localObject2).jdField_a_of_type_Lfg.jdField_b_of_type_Int <= 4) {
                break label344;
              }
              i2 = 52;
              if (this.jdField_f_of_type_Boolean)
              {
                i2 = 60;
                t();
              }
              localmtn.a(((lff)localObject2).jdField_c_of_type_JavaLangString, "", null, null, i2, ((lff)localObject2).jdField_j_of_type_Int, i1);
              s();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((lff)localObject2).jdField_g_of_type_Long);
          localObject4 = ((lff)localObject2).jdField_d_of_type_JavaLangString;
          localObject2 = ((lff)localObject2).jdField_c_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localmtn.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.13(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((lff)localObject2).jdField_d_of_type_Int != 1) {
          break label671;
        }
      }
      finally {}
      int i1 = 47;
      label306:
      if (((lff)localObject2).l())
      {
        if (((lff)localObject2).jdField_d_of_type_Int != 1) {
          break label680;
        }
        i1 = 47;
      }
      else
      {
        if (((lff)localObject2).jdField_d_of_type_Int != 1) {
          break label689;
        }
        i1 = 46;
        break label686;
        label344:
        localObject1.a(((lff)localObject2).jdField_c_of_type_JavaLangString, "", null, null, 51, ((lff)localObject2).jdField_j_of_type_Int, i1);
        t();
        continue;
        label372:
        if ((((lff)localObject2).jdField_d_of_type_Int == 3) || (((lff)localObject2).jdField_d_of_type_Int == 4))
        {
          if (((lff)localObject2).J)
          {
            localObject3 = ((lff)localObject2).jdField_e_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((lff)localObject2).jdField_d_of_type_JavaLangString, null, true, true);
            localObject1.a(((lff)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lff)localObject2).jdField_g_of_type_Long), 48, 0, ((lff)localObject2).jdField_d_of_type_Int);
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a().jdField_j_of_type_Int, String.valueOf(a().jdField_g_of_type_Long), null);
          localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lff)localObject2).jdField_j_of_type_Int, String.valueOf(((lff)localObject2).jdField_g_of_type_Long), null, true, true);
          if (localObject4 != null)
          {
            localObject1.a(((lff)localObject2).jdField_c_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, String.valueOf(((lff)localObject2).jdField_g_of_type_Long), 44, ((lff)localObject2).jdField_j_of_type_Int, ((lff)localObject2).jdField_d_of_type_Int);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoController.14(this), 1000L);
          continue;
        }
        if (((lff)localObject2).jdField_e_of_type_JavaLangString == null) {
          ((lff)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(((lff)localObject2).jdField_j_of_type_Int, ((lff)localObject2).jdField_d_of_type_JavaLangString, ((lff)localObject2).jdField_f_of_type_JavaLangString);
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((lff)localObject2).jdField_j_of_type_Int, ((lff)localObject2).jdField_d_of_type_JavaLangString, ((lff)localObject2).jdField_f_of_type_JavaLangString, true, true);
        localObject1.a(((lff)localObject2).jdField_c_of_type_JavaLangString, ((lff)localObject2).jdField_e_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((lff)localObject2).jdField_j_of_type_Int, ((lff)localObject2).jdField_d_of_type_Int);
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
    lbj.c(jdField_a_of_type_JavaLangString, "onReceiveSubtitleChanged:" + paramString);
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
    paramInt2 = mvd.c(paramInt1);
    if ((this.jdField_e_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.jdField_v_of_type_Boolean = true;
      if (paramInt1 != 3) {
        break label274;
      }
      a(a().jdField_c_of_type_JavaLangString, paramInt2, 7, false, String.valueOf(paramLong), null, false);
      paramInt1 = 7;
      if (paramInt2 != 3000) {
        break label302;
      }
      bdll.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().J) {
        bdll.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      lff locallff = a();
      if ((locallff != null) && (locallff.jdField_j_of_type_Boolean)) {
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
        if (a().D == 10) {
          bdll.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          bdll.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    lff locallff = a();
    int i1;
    if ((!TextUtils.isEmpty(locallff.jdField_d_of_type_JavaLangString)) && ((!locallff.jdField_d_of_type_JavaLangString.equals(String.valueOf(paramLong2))) || (locallff.jdField_d_of_type_Int == 0)))
    {
      i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo1, result[" + i1 + "]");
      return;
    }
    if ((this.jdField_a_of_type_Lcb.a() == 0) && (TextUtils.isEmpty(locallff.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(locallff.jdField_d_of_type_JavaLangString)))
    {
      i1 = a(paramLong1, paramLong2);
      QLog.w(jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo2, result[" + i1 + "]");
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
    if ((a().jdField_j_of_type_Int == 1006) && (!a().jdField_e_of_type_Boolean) && (!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())))
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
  
  public void c(ArrayList<lms> paramArrayList)
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
          if ((((lms)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((lms)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((lms)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((lms)paramArrayList.get(i1)).jdField_a_of_type_Long));
          }
          i1 += 1;
        }
      }
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
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("onRecvMultiVideoAck buf=%s", new Object[] { paramArrayOfByte }));
    }
    L();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      l();
    }
    ThreadManager.executeOnSubThread(new VideoController.6(this, paramArrayOfByte));
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
          long l1 = mrs.a(str3);
          String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName();
          String str2 = blhc.a("62ad83");
          i2 = bihq.a(str3);
          str3 = bhlo.b();
          String str4 = str3 + "," + i2;
          String str5 = Build.HARDWARE + "_" + llk.a();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("init, [%s], [%s], [%s], [%s], [%s]", new Object[] { str2, str3, Integer.valueOf(i2), str4, str5 }));
          }
          ((VcControllerImpl)localObject2).init(a(), l1, "8.4.5", Build.MODEL, (String)localObject1, str1, AppSetting.d(), str2, llk.b(), Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.MANUFACTURER, llk.d(), i1, str4, new llf().a(), mtl.a(l1), mtl.b(l1), str5);
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
        AVSoUtils.b();
        continue;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "initVcController selfUin invalid.");
        AVSoUtils.b();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
        break label489;
      }
      return true;
      localObject1 = new String((byte[])localObject1);
    }
    label489:
    return false;
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, 1, 0L);
  }
  
  public boolean c(boolean paramBoolean)
  {
    lbj.d(jdField_a_of_type_JavaLangString, "enableLoopback| sessionType=" + a().jdField_d_of_type_Int + "enable=" + paramBoolean);
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
        lcv locallcv = (lcv)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = String.valueOf(locallcv.jdField_a_of_type_Long);
        localArrayList2.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void d()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null)
    {
      this.jdField_d_of_type_JavaLangRunnable = new VideoController.16(this);
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
    if ((q()) && ((this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 3)))
    {
      lbj.d(jdField_a_of_type_JavaLangString, "exitProcess return,isNearbyVideoChat, uiMode: " + this.jdField_g_of_type_Int);
      return;
    }
    if (mur.a() != null) {
      mur.a().a(l1);
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    Object localObject = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      ((mtn)localObject).a();
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
        lbj.e(jdField_a_of_type_JavaLangString, "exception msg = " + localException.getMessage());
      }
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 == 108)
    {
      a().aa = true;
      locallff = a();
      if (!h())
      {
        bool = true;
        locallff.Z = bool;
        i1 = f();
        a("onMVSpeakModeChanged_1", this.jdField_a_of_type_Long, false, false, -1);
        a(-1L, i1, f());
      }
    }
    while (!a().aa) {
      for (;;)
      {
        lff locallff;
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
    lbj.d(jdField_a_of_type_JavaLangString, String.format("onReceiveMagicface|type=%d, id=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6103), Integer.valueOf(paramInt), paramString });
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), ldd.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
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
    paramArrayOfByte.d("onSwitchGroup", mrl.a(paramArrayOfByte.jdField_j_of_type_Int));
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(2, 11);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
    d();
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
  
  public void d(byte[] paramArrayOfByte)
  {
    int i1 = lln.a().a(paramArrayOfByte);
    if (i1 == 1) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
    }
    if ((i1 == 2) && (a().jdField_B_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(164), Integer.valueOf(1) });
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Lcb.a().jdField_e_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lcb.a().jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_Lcb.a().jdField_d_of_type_Int != 2)) {
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
      if (this.jdField_a_of_type_Lcb.a().jdField_d_of_type_Int == 0) {
        if (this.jdField_a_of_type_Lcb.a().jdField_f_of_type_Int != 1)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Lcb.a().jdField_f_of_type_Int != 2) {}
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
  
  public ArrayList<lcv> e()
  {
    if ((AudioHelper.e()) && (mqb.jdField_a_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      localArrayList.addAll(mqb.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void e()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null) {
      this.jdField_e_of_type_JavaLangRunnable = new VideoController.17(this);
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
      ((lff)localObject1).jdField_O_of_type_Boolean = true;
      ((lff)localObject1).jdField_a_of_type_JavaUtilArrayList.clear();
      if ((mrl.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
      label779:
      for (;;)
      {
        a("onCreateRoomSuc");
        a("onCreateSuc", true, paramInt1, paramLong);
        ((lff)localObject1).ar = false;
        if (((lff)localObject1).J)
        {
          ((lff)localObject1).d("onCreateRoomSuc", true);
          ((lff)localObject1).M = true;
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
        this.jdField_e_of_type_Int = 0;
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localObject2 != null) {
          ((ljz)localObject2).a(a());
        }
        if ((!((lff)localObject1).J) && (((lff)localObject1).F != 3)) {
          break;
        }
        localObject2 = a();
        if (localObject2 == null) {
          break;
        }
        ((ScreenShareCtrl)localObject2).a((lff)localObject1);
        return;
        int i1;
        int i2;
        if (((lff)localObject1).jdField_ad_of_type_Int == 5)
        {
          i1 = ((lff)localObject1).d();
          i2 = ((lff)localObject1).c();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onCreateRoomSuc, double meeting, terminalType[" + i1 + "], sdkVersion[" + i2 + "]");
          }
          long l2;
          if ((i1 == 2) || (i1 == 12) || ((i1 == 4) && (i2 >= 114)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lff)localObject1).jdField_g_of_type_Long;
            i1 = ((lff)localObject1).jdField_ad_of_type_Int;
            ((QQGAudioCtrl)localObject2).inviteUser(new long[] { l2 }, 3, i1, 0);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
            l2 = ((lff)localObject1).jdField_g_of_type_Long;
            i1 = ((lff)localObject1).jdField_ad_of_type_Int;
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
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser((long[])localObject2, 4, ((lff)localObject1).jdField_ad_of_type_Int, 0);
        }
        else
        {
          if (AudioHelper.a(19) == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            if (i1 == 0) {
              break label779;
            }
            AudioHelper.a(anzj.a(2131714899));
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 4, ((lff)localObject1).jdField_ad_of_type_Int, 0);
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
        lcv locallcv = (lcv)localIterator.next();
        if (locallcv.jdField_a_of_type_Long == paramLong) {
          if (!locallcv.jdField_f_of_type_Boolean)
          {
            locallcv.jdField_f_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(157), Long.valueOf(paramLong), Boolean.valueOf(true) });
          }
        }
      }
      return;
    }
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
    ((lff)localObject).ar = false;
    if (paramInt1 == 3)
    {
      ((lff)localObject).a("onEnterSuc.1", 14);
      ((lff)localObject).d("onEnterSuc", true);
      ((lff)localObject).a(l1, SystemClock.elapsedRealtime());
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
        ((ljz)localObject).a(a());
      }
      return;
      a("onEnterSuc", true, paramInt1, paramLong);
      localObject = lcb.a(paramInt1, String.valueOf(paramLong), new int[0]);
      localObject = lcb.a().c((String)localObject);
      if (localObject != null)
      {
        ((lff)localObject).jdField_V_of_type_Boolean = true;
        ((lff)localObject).jdField_O_of_type_Boolean = false;
        ((lff)localObject).aD = true;
      }
      if ((mrl.a(paramInt1)) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) {
        M();
      }
    }
  }
  
  public void e(String paramString)
  {
    lff locallff = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPauseVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallff.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallff.S + "], seq[" + l1 + "]");
    if (lsv.a(BaseApplication.getContext()) == 1) {
      locallff.b(l1, false);
    }
    while ((locallff.jdField_d_of_type_Int != 2) || (!locallff.jdField_k_of_type_Boolean)) {
      return;
    }
    locallff.b(l1, false);
    if (!locallff.jdField_j_of_type_Boolean)
    {
      locallff.S = true;
      locallff.a(l1, "onPauseVideo", 1);
      c(locallff.jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    mru.n(this);
  }
  
  public void e(String paramString, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("SetNetIPAndPort ip=%s port=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_t_of_type_Int = paramInt;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetNetIPAndPort(paramString, paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
      }
      bhsi.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).edit().putString(VideoConstants.h, paramString).commit();
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "SetNetIPAndPort fail.", paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvIVRPush");
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null;
  }
  
  public int f()
  {
    return this.jdField_u_of_type_Int;
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
      lcv locallcv = (lcv)localIterator.next();
      if ((locallcv.jdField_d_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(locallcv.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(locallcv.jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  void f()
  {
    long l1 = AudioHelper.b();
    if (this.jdField_f_of_type_JavaLangRunnable == null)
    {
      this.jdField_f_of_type_JavaLangRunnable = new VideoController.18(this, l1);
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
    lff locallff = a();
    long l1 = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onResumeVideo, fromUin[" + paramString + "], remoteHasVideo[" + locallff.jdField_k_of_type_Boolean + "], isOnlyAudio[" + locallff.S + "], seq[" + l1 + "]");
    if ((locallff.jdField_f_of_type_Int == 1) && (!f())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    do
    {
      do
      {
        return;
      } while (locallff.jdField_k_of_type_Boolean);
      locallff.b(l1, true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
      mru.m(this);
    } while (locallff.jdField_d_of_type_Int != 1);
    locallff.a(l1, "onResumeVideo", 2);
    locallff.S = false;
  }
  
  public void f(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), paramString, Integer.valueOf(paramInt) });
  }
  
  void f(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    lff locallff = a();
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + locallff + "], seq[" + l1 + "]");
    }
    long l2 = Long.valueOf(locallff.jdField_d_of_type_JavaLangString).longValue();
    int i1 = locallff.jdField_d_of_type_Int;
    long l3 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    boolean bool = h();
    int i2 = locallff.jdField_j_of_type_Int;
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
      if (locallff.jdField_j_of_type_Boolean) {
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
      h("notifyChangeDoubleVideoMeeting2MultiVideo", i1);
      if (paramBoolean)
      {
        e();
        a().a(4, 11);
        a().d("notifyChangeDoubleVideoMeeting2MultiVideo", mrl.a(i2));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101), Long.valueOf(l1) });
      }
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.jdField_l_of_type_Boolean + "], session[" + locallff + "], seq[" + l1 + "]");
      }
      return;
      if (locallff.a(l3, 1) == -1) {
        break;
      }
      locallff.a(l1, "DoubleVideoMeeting2MultiVideo", true, false);
      break;
    }
  }
  
  public void f(byte[] paramArrayOfByte)
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
        long l1 = mrs.a(str1);
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
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + a().jdField_a_of_type_Lfg.jdField_b_of_type_Int + " # chatType = " + a().jdField_a_of_type_Lfg.jdField_a_of_type_Int + " # state = " + a().jdField_g_of_type_Int + " # sessionId = " + a().jdField_c_of_type_JavaLangString);
    }
    if (m())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      lff locallff = a();
      if (paramBoolean)
      {
        a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long, 79);
        if (locallff != null)
        {
          locallff.jdField_a_of_type_Lfg.jdField_f_of_type_Boolean = false;
          locallff.jdField_a_of_type_Lfg.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          locallff.a();
          locallff.b();
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
        if (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(a().jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((a().jdField_a_of_type_Lfg.jdField_a_of_type_Int == 1) || (a().jdField_a_of_type_Lfg.jdField_a_of_type_Int == 2))
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
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestAudioFoucs");
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new lco(this);
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
  
  public void h(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setGAudioSpeakerMode, [" + this.jdField_u_of_type_Int + " --> " + paramInt + "], from[" + paramString + "]");
    }
    this.jdField_u_of_type_Int = paramInt;
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
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
    QLog.d(jdField_a_of_type_JavaLangString, 1, "abandonAudioFocus");
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "setSelectMemberActivityIsResume, IsResume[" + paramBoolean + "], mSelectMemberActivityIsResume[" + this.jdField_n_of_type_Int + "]");
    if (paramBoolean) {
      this.jdField_n_of_type_Int += 1;
    }
    do
    {
      return;
      this.jdField_n_of_type_Int -= 1;
    } while (this.jdField_n_of_type_Int >= 0);
    this.jdField_n_of_type_Int = 0;
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
          lcv locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (locallcv != null)
          {
            bool2 = bool1;
            if (!locallcv.jdField_g_of_type_Boolean) {
              break label231;
            }
            if ((locallcv.jdField_c_of_type_Long >= 2000L) && (locallcv.jdField_c_of_type_Long < this.jdField_c_of_type_Long))
            {
              l1 = locallcv.jdField_c_of_type_Long;
              bool2 = bool1;
              if (l2 - locallcv.jdField_b_of_type_Long <= l1) {
                break label231;
              }
              locallcv.jdField_g_of_type_Boolean = false;
              locallcv.jdField_b_of_type_Long = l2;
              bool1 = true;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label231;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + locallcv.jdField_a_of_type_Long + ",isSuspectNoisy = " + locallcv.jdField_g_of_type_Boolean);
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
    o(true);
    a(paramString, 206);
    b(206);
    b(paramString, 7);
  }
  
  public void j(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = jdField_p_of_type_Int;; i1 = jdField_q_of_type_Int)
    {
      if (this.jdField_r_of_type_Int != i1)
      {
        this.jdField_r_of_type_Int = i1;
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
      lcv locallcv = (lcv)this.jdField_c_of_type_JavaUtilArrayList.get(i1);
      if ((locallcv == null) || (!locallcv.jdField_g_of_type_Boolean)) {
        break label159;
      }
      if (l1 == locallcv.jdField_a_of_type_Long)
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
    return this.jdField_r_of_type_Int;
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
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallda != null) {
        locallda.b(paramBoolean);
      }
    }
  }
  
  public boolean k()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2)
      {
        bdll.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
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
          bdll.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public void l()
  {
    boolean bool = llk.c();
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
          long l1 = mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          int i1 = c();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setCallback(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAppid());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1, "8.4.5", new llf().a());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(this.jdField_e_of_type_JavaLangString, this.jdField_t_of_type_Int);
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
      lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallda != null) {
        locallda.c(paramBoolean);
      }
    }
  }
  
  public boolean l()
  {
    return (a().jdField_a_of_type_Lfg.jdField_b_of_type_Int > 0) && (a().jdField_a_of_type_Lfg.jdField_b_of_type_Int < 6);
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
    a().I = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallda != null) {
        locallda.d(paramBoolean);
      }
    }
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    lff locallff = a();
    boolean bool1 = bool2;
    if (locallff != null)
    {
      bool1 = bool2;
      if (locallff.jdField_a_of_type_Lfh.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (locallff.jdField_a_of_type_Lfh.jdField_a_of_type_Long > 0L) {
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
      lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallda != null) {
        locallda.e(paramBoolean);
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
      lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallda != null) {
        locallda.f(paramBoolean);
      }
    }
  }
  
  public boolean o()
  {
    return this.jdField_t_of_type_Boolean;
  }
  
  public void p()
  {
    long l1;
    if (this.jdField_e_of_type_Boolean) {
      l1 = mrs.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int i1;
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (this.jdField_c_of_type_JavaUtilArrayList.get(0) != null) && (l1 == ((lcv)this.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long))
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
      lda locallda = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (locallda != null) {
        locallda.g(paramBoolean);
      }
    }
  }
  
  public boolean p()
  {
    if (AudioHelper.f()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[" + this.jdField_n_of_type_Int + "]");
    }
    return this.jdField_n_of_type_Int > 0;
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
    QLog.d(jdField_a_of_type_JavaLangString, 1, "requestStopTimerOfMemberLists");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_l_of_type_JavaLangRunnable);
  }
  
  public void r(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(131), paramString });
  }
  
  public void s()
  {
    if ((a().jdField_g_of_type_Int == 4) || (a().jdField_g_of_type_Int == 10) || (a().jdField_g_of_type_Int == 14) || (a().jdField_a_of_type_Lfg.jdField_b_of_type_Int >= 4))
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
    lff locallff = a();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onNeedShowPeerVideo, fromUin[" + paramString + "], peerUin[" + locallff.jdField_d_of_type_JavaLangString + "], extraUin[" + locallff.jdField_f_of_type_JavaLangString + "], remoteHasVideo[" + locallff.jdField_k_of_type_Boolean + "], mXiaoweiDevice[" + this.jdField_q_of_type_Boolean + "], seq[" + l1 + "]");
    if ((TextUtils.equals(locallff.jdField_d_of_type_JavaLangString, paramString)) || (TextUtils.equals(locallff.jdField_f_of_type_JavaLangString, paramString)) || (this.jdField_q_of_type_Boolean))
    {
      if ((locallff.jdField_f_of_type_Int != 1) || (f())) {
        break label165;
      }
      lbj.d(jdField_a_of_type_JavaLangString, "onNeedShowPeerVideo, !canAVShift()");
    }
    for (;;)
    {
      return;
      label165:
      if (locallff.jdField_d_of_type_Int == 1) {
        c(2);
      }
      if (!locallff.jdField_k_of_type_Boolean)
      {
        locallff.b(l1, true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16), Long.valueOf(l1) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
        mru.m(this);
        if (locallff.jdField_d_of_type_Int == 1)
        {
          locallff.a(l1, "onNeedShowPeerVideo", 2);
          locallff.S = false;
        }
      }
      while (!TextUtils.equals(locallff.jdField_d_of_type_JavaLangString, paramString))
      {
        GraphicRenderMgr.getInstance().onUinChanged(locallff.jdField_d_of_type_JavaLangString, paramString);
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
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (a().F == 2) {
        bdll.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
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
          bdll.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
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
    QLog.w(jdField_a_of_type_JavaLangString, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.jdField_n_of_type_Int + "]");
    this.jdField_n_of_type_Int = 0;
  }
  
  public void x(String paramString)
  {
    a("deviceMemory", lic.c() + "");
    a("manufacturer", Build.MANUFACTURER);
    a("qqVersion", AppSetting.a(a()));
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (lkw.b(this.jdField_a_of_type_AndroidContentContext))
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
        this.jdField_a_of_type_Mur.d();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131695011), 2131690580, 2131694098, new lcr(this), new lcs(this, bool1, bool2));
      bdll.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695097, 1).a();
    }
    Object localObject = a();
    if (localObject != null) {
      if (((lff)localObject).F != 1) {
        break label64;
      }
    }
    label64:
    for (localObject = "0x8007CB5";; localObject = "0x8007CB6")
    {
      llr.a((String)localObject);
      return;
    }
  }
  
  public void z(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setupDeviceInfos(paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      QQGAudioCtrl.setandroidapppath(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController
 * JD-Core Version:    0.7.0.1
 */