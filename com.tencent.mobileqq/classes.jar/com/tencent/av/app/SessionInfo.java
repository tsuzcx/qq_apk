package com.tencent.av.app;

import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.JSInterfacePushData;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class SessionInfo
  extends SessionInfoBase
{
  public static int X;
  public int A;
  public boolean A;
  public int B;
  public boolean B;
  public int C;
  public boolean C;
  public int D;
  public boolean D;
  public int E = -1;
  public boolean E;
  public int F = 0;
  public boolean F;
  public int G = 0;
  public boolean G;
  public int H = 1;
  public boolean H;
  public int I = -1;
  public boolean I;
  public int J = 7;
  public boolean J;
  public int K;
  public boolean K;
  public int L = 1;
  public boolean L;
  public int M;
  public boolean M;
  public int N;
  public boolean N;
  public int O = -1;
  public boolean O;
  public int P;
  public boolean P;
  public int Q;
  public boolean Q;
  public int R = 1;
  public boolean R;
  public int S;
  public boolean S;
  public int T;
  public boolean T;
  public int U = -1;
  public boolean U;
  public int V = -1;
  public boolean V;
  public int W = -1;
  public boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  public int a;
  public long a;
  public SessionInfo.Anychat_Info a;
  public SessionInfo.GroupInfo a;
  public SessionInfo.GuildInfo a;
  public volatile JSInterfacePushData a;
  public PtvTemplateManager.PtvTemplateInfo a;
  public Object a;
  final String a;
  public ArrayList a;
  public BitSet a;
  public HashSet a;
  public boolean a;
  public byte[] a;
  public long[] a;
  public String[] a;
  public boolean aA;
  public boolean aB;
  public boolean aC = true;
  public boolean aD;
  public boolean aE;
  public boolean aa;
  public boolean ab;
  public boolean ac;
  public boolean ad;
  public boolean ae;
  public boolean af;
  public boolean ag;
  public boolean ah;
  public boolean ai;
  public boolean aj = true;
  public boolean ak;
  public boolean al;
  public boolean am;
  public boolean an;
  public boolean ao;
  public boolean ap;
  public boolean aq;
  public boolean ar;
  public boolean as;
  public boolean at;
  public boolean au;
  public boolean av;
  public boolean aw;
  public boolean ax;
  public boolean ay = true;
  public boolean az;
  public int b;
  public long b;
  public String b;
  public ArrayList b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public ArrayList e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public ArrayList f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public ArrayList g;
  public boolean g;
  public int h;
  public long h;
  public String h;
  public boolean h;
  public int i;
  public long i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m = true;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public String o;
  public boolean o;
  public int p;
  public String p;
  public boolean p;
  public int q;
  public String q;
  public boolean q;
  public int r;
  public String r;
  public boolean r;
  public int s;
  public String s;
  public boolean s;
  public int t;
  public String t;
  public boolean t;
  public int u;
  public String u;
  public boolean u;
  public int v;
  public String v;
  public boolean v;
  public int w;
  public boolean w;
  public int x;
  public boolean x;
  public int y = 0;
  public boolean y;
  public int z = -1;
  public boolean z;
  
  public SessionInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 15000;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_k_of_type_Int = -1;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_n_of_type_Int = -1;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_D_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(8);
    this.jdField_u_of_type_Int = 0;
    this.jdField_v_of_type_Int = 5;
    this.jdField_w_of_type_Int = 5;
    this.jdField_x_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_D_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_u_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_S_of_type_Int = 0;
    this.jdField_T_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info = new SessionInfo.Anychat_Info(this);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo = new SessionInfo.GuildInfo(this);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$GroupInfo = new SessionInfo.GroupInfo(this);
    this.jdField_a_of_type_JavaLangString = ("SessionInfo_" + AudioHelper.a());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createSession");
  }
  
  private boolean a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((AVPhoneUserInfo)localIterator.next()).telInfo.mobile.equalsIgnoreCase(paramAVPhoneUserInfo.telInfo.mobile)) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    int i1;
    if (paramInt != 0)
    {
      i1 = 0;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          return i1;
        }
        i1 += 1;
      }
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= this.jdField_c_of_type_JavaUtilArrayList.size()) {
        break label112;
      }
      i1 = paramInt;
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long == paramLong) {
        break;
      }
      paramInt += 1;
    }
    label112:
    return -1;
  }
  
  public SessionInfo.HeroDetail a(String paramString)
  {
    SessionInfo.HeroDetail localHeroDetail2 = (SessionInfo.HeroDetail)this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a.get(paramString);
    SessionInfo.HeroDetail localHeroDetail1 = localHeroDetail2;
    if (localHeroDetail2 == null)
    {
      localHeroDetail1 = new SessionInfo.HeroDetail(this);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a.put(paramString, localHeroDetail1);
    }
    return localHeroDetail1;
  }
  
  public AVPhoneUserInfo a(long paramLong, ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if ((localAVPhoneUserInfo.accountType != 1) && (localAVPhoneUserInfo.account == paramLong)) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_i_of_type_Int == 10003)
    {
      c();
      return;
    }
    this.jdField_d_of_type_Long = 0L;
    a("clearSessionInfo", 0);
    this.jdField_i_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_S_of_type_Int = 0;
    this.jdField_T_of_type_Int = 0;
    this.aB = false;
    this.aC = true;
    this.jdField_S_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.r = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    this.z = -1;
    this.ay = true;
    this.jdField_v_of_type_JavaLangString = "";
    this.jdField_i_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
    this.jdField_a_of_type_JavaUtilBitSet.clear();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.L = 1;
    this.F = 0;
    this.W = -1;
    this.jdField_x_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "SessionInfo setAvType:" + paramInt);
    }
    this.jdField_D_of_type_Int = paramInt;
    X = paramInt;
  }
  
  public void a(int paramInt, VideoViewInfo paramVideoViewInfo)
  {
    long l1 = paramVideoViewInfo.jdField_a_of_type_Long;
    int i1 = paramVideoViewInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = " + paramInt);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "ADD VideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramInt, paramVideoViewInfo);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "resetVideoDisplayListExceptTargetUin-->Uin = " + paramLong + " ,clearRenderFlag" + paramBoolean1 + " ,clearRecvDataFlag" + paramBoolean2);
    }
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)
      {
        if (paramBoolean1) {
          ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean = false;
        }
        if (paramBoolean2) {
          ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean = false;
        }
      }
      i1 += 1;
    }
  }
  
  public void a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPhoneUserInfoInRoom info = " + paramAVPhoneUserInfo.toString());
    }
    this.jdField_f_of_type_JavaUtilArrayList.add(paramAVPhoneUserInfo);
  }
  
  public void a(VideoViewInfo paramVideoViewInfo)
  {
    long l1 = paramVideoViewInfo.jdField_a_of_type_Long;
    int i1 = paramVideoViewInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "ADD VideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramVideoViewInfo);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_g_of_type_Int != paramInt) || (QLog.isColorLevel()))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setState[" + paramString + "], state[" + this.jdField_g_of_type_Int + "->" + paramInt + "]");
      this.jdField_g_of_type_Int = paramInt;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setSwitchToGaudio[" + paramString + "], switchToGaudio[" + this.jdField_T_of_type_Boolean + "->" + paramBoolean + "]");
    this.jdField_T_of_type_Boolean = paramBoolean;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addPhoneUserInfo --> Size = " + paramArrayList.size());
    }
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.get(i1);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addPhoneUserInfo --> Item Info = " + localAVPhoneUserInfo.toString());
      }
      if ((!a(localAVPhoneUserInfo)) && (this.jdField_e_of_type_JavaUtilArrayList.size() <= 10)) {
        this.jdField_e_of_type_JavaUtilArrayList.add(localAVPhoneUserInfo);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addPhoneUserInfo --> Item has exsit. Info = " + localAVPhoneUserInfo.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setVideoState,startOrStopVideo:" + paramBoolean1 + ",isRemote:" + paramBoolean2);
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        this.jdField_g_of_type_Boolean = true;
        if (this.jdField_d_of_type_Int != 1) {
          break label91;
        }
        this.jdField_d_of_type_Int = 2;
        label70:
        if ((this.jdField_d_of_type_Int != 4) || (!paramBoolean2)) {}
      }
    }
    label91:
    do
    {
      return;
      this.jdField_f_of_type_Boolean = true;
      break;
      if (this.jdField_d_of_type_Int != 3) {
        break label70;
      }
      this.jdField_d_of_type_Int = 4;
      break label70;
      if (paramBoolean2) {
        this.jdField_g_of_type_Boolean = false;
      }
      while (((this.jdField_d_of_type_Int != 4) || (!paramBoolean2)) || ((this.jdField_d_of_type_Int == 2) && (!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)))
      {
        this.jdField_d_of_type_Int = 1;
        return;
        this.jdField_f_of_type_Boolean = false;
      }
    } while ((this.jdField_d_of_type_Int != 4) || (this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean));
    this.jdField_d_of_type_Int = 3;
  }
  
  public boolean a()
  {
    return (this.jdField_g_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          bool1 = ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearDoubleVideoSessionInfo sessionId : " + this.jdField_b_of_type_JavaLangString);
    }
    a();
    e();
  }
  
  public boolean b()
  {
    return (this.jdField_g_of_type_Int == 0) && ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 2));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearNearbyVideoChatSessionInfo sessionId : " + this.jdField_b_of_type_JavaLangString);
    }
    a("clearNearbyVideoChatSessionInfo", 0);
    this.jdField_d_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_S_of_type_Int = 0;
    this.aB = false;
    this.aC = true;
    this.jdField_S_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.r = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    return this.jdField_g_of_type_Int == 1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearRandomSessionInfo sessionId = " + this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_Int = -1;
  }
  
  public boolean d()
  {
    return (this.jdField_g_of_type_Int == 2) || (this.jdField_g_of_type_Int == 7);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo = new SessionInfo.GuildInfo(this);
  }
  
  public boolean e()
  {
    return this.jdField_g_of_type_Int == 3;
  }
  
  public void f()
  {
    a();
    this.jdField_g_of_type_Long = 0L;
    this.I = -1;
    this.Z = false;
    this.aa = false;
    this.ab = false;
    this.ac = false;
    this.ad = false;
    this.ae = false;
    this.ag = false;
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_s_of_type_JavaLangString = null;
    this.t = null;
    g();
    a(0);
  }
  
  public boolean f()
  {
    return this.jdField_g_of_type_Int == 4;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clearPhoneUserInfo");
    }
    this.jdField_e_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean g()
  {
    return this.jdField_g_of_type_Int == 5;
  }
  
  public boolean h()
  {
    return this.jdField_g_of_type_Int == 6;
  }
  
  public boolean i()
  {
    return this.jdField_g_of_type_Int == 15;
  }
  
  public boolean j()
  {
    return (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4) || ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3));
  }
  
  public boolean k()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean l()
  {
    return (this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 4);
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean n()
  {
    return this.jdField_u_of_type_Int == 1;
  }
  
  public boolean o()
  {
    return (this.jdField_v_of_type_Int == 4) || (this.jdField_v_of_type_Int == 3);
  }
  
  public boolean p()
  {
    if (this.O == -1) {
      if (this.F != 2) {
        break label35;
      }
    }
    label35:
    for (this.O = QAVHrMeeting.b(this.jdField_f_of_type_Long);; this.O = 0) {
      return QAVHrMeeting.a(this.O);
    }
  }
  
  public boolean q()
  {
    return (this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2);
  }
  
  public String toString()
  {
    return "[" + this.jdField_a_of_type_JavaLangString + "], sessionId[" + this.jdField_b_of_type_JavaLangString + "], SessionType[" + this.jdField_d_of_type_Int + "], sessionStatus[" + this.jdField_c_of_type_Int + "], state[" + this.jdField_g_of_type_Int + "], switchState[" + this.jdField_h_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "], peerName[" + this.jdField_d_of_type_JavaLangString + "], extraUin[" + this.jdField_e_of_type_JavaLangString + "], extraCode[" + this.jdField_f_of_type_JavaLangString + "], multiAVType[" + this.jdField_D_of_type_Int + "], localHasVideo[" + this.jdField_f_of_type_Boolean + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.app.SessionInfo
 * JD-Core Version:    0.7.0.1
 */