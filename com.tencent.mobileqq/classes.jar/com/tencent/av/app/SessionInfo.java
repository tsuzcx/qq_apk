package com.tencent.av.app;

import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.ui.VideoMemberChangeListener;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SessionInfo
  extends SessionInfoBase
{
  public static int i;
  public int A;
  public boolean A;
  public int B = 0;
  public boolean B;
  public int C;
  public boolean C;
  public int D;
  public boolean D;
  public int E;
  public boolean E;
  public int F;
  public boolean F;
  public int G;
  public boolean G;
  public int H;
  public boolean H;
  public int I;
  public boolean I;
  @Deprecated
  public int J;
  public boolean J;
  public int K;
  public boolean K;
  public int L;
  public boolean L;
  public int M;
  public boolean M;
  public int N;
  @Deprecated
  public boolean N;
  public int O;
  @Deprecated
  public boolean O;
  public int P;
  @Deprecated
  public boolean P;
  public int Q;
  @Deprecated
  public boolean Q;
  public int R;
  @Deprecated
  public boolean R;
  public int S;
  public boolean S;
  public int T;
  public boolean T;
  public int U;
  public volatile boolean U;
  public int V;
  public boolean V;
  public int W;
  public boolean W;
  public int X;
  public boolean X;
  public int Y;
  public boolean Y;
  public int Z;
  public boolean Z;
  public long a;
  public final String a;
  protected WeakReference<VideoMemberChangeListener> a;
  public ArrayList<Long> a;
  public BitSet a;
  public HashSet<Integer> a;
  protected final ConcurrentHashMap<Long, Boolean> a;
  public byte[] a;
  public long[] a;
  public String[] a;
  public boolean aA = false;
  public boolean aB = false;
  public boolean aC = false;
  public boolean aD = false;
  public boolean aE = true;
  public boolean aF = false;
  public boolean aG = false;
  public int aa;
  public boolean aa;
  public int ab;
  public boolean ab;
  public int ac;
  public boolean ac;
  public int ad;
  public boolean ad;
  public int ae;
  public boolean ae;
  public int af;
  public boolean af;
  public int ag;
  public boolean ag;
  public boolean ah = false;
  private int ai;
  public boolean ai;
  private int aj;
  public boolean aj;
  public boolean ak = false;
  public boolean al = false;
  public boolean am = true;
  public boolean an = false;
  public boolean ao = false;
  public boolean ap = false;
  public boolean aq = false;
  public boolean ar = true;
  public boolean as = false;
  public boolean at = false;
  public boolean au = false;
  public boolean av = false;
  public boolean aw = false;
  public boolean ax = false;
  public boolean ay = false;
  public boolean az = false;
  public long b;
  public String b;
  public ArrayList<String> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public volatile ArrayList<VideoViewInfo> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<VideoViewInfo> d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public ArrayList<VideoViewInfo> e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public ArrayList<AVPhoneUserInfo> f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public boolean g;
  public int h;
  public long h;
  public String h;
  public boolean h;
  public long i;
  public String i;
  public boolean i;
  public int j;
  public long j;
  public String j;
  public boolean j;
  public int k;
  public long k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
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
  public int y;
  public boolean y;
  public int z;
  public boolean z;
  
  public SessionInfo()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_l_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 3;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_q_of_type_Boolean = true;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    this.jdField_q_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_t_of_type_Int = 0;
    this.jdField_u_of_type_Int = 0;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_v_of_type_Int = 0;
    this.jdField_w_of_type_Int = 0;
    this.jdField_x_of_type_Int = 0;
    this.jdField_y_of_type_Int = 0;
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_y_of_type_Boolean = false;
    this.jdField_z_of_type_Boolean = false;
    this.jdField_A_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_n_of_type_JavaLangString = null;
    this.jdField_C_of_type_Boolean = false;
    this.jdField_D_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_z_of_type_Int = -1;
    this.jdField_A_of_type_Int = 0;
    this.jdField_o_of_type_JavaLangString = null;
    this.jdField_C_of_type_Int = 0;
    this.jdField_p_of_type_JavaLangString = null;
    this.jdField_q_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_E_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_F_of_type_Boolean = false;
    this.jdField_G_of_type_Boolean = false;
    this.jdField_H_of_type_Boolean = false;
    this.jdField_I_of_type_Boolean = false;
    this.jdField_J_of_type_Boolean = false;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_D_of_type_Int = -1;
    this.jdField_E_of_type_Int = 0;
    this.jdField_F_of_type_Int = 0;
    this.jdField_K_of_type_Boolean = false;
    this.jdField_L_of_type_Boolean = false;
    this.jdField_M_of_type_Boolean = false;
    this.jdField_G_of_type_Int = 2;
    this.jdField_r_of_type_JavaLangString = null;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_H_of_type_Int = 0;
    this.jdField_I_of_type_Int = 1;
    this.jdField_J_of_type_Int = -1;
    this.jdField_N_of_type_Boolean = false;
    this.jdField_O_of_type_Boolean = false;
    this.jdField_P_of_type_Boolean = false;
    this.jdField_Q_of_type_Boolean = false;
    this.jdField_R_of_type_Boolean = false;
    this.jdField_S_of_type_Boolean = false;
    this.jdField_T_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_U_of_type_Boolean = false;
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_s_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_V_of_type_Boolean = false;
    this.jdField_W_of_type_Boolean = false;
    this.jdField_X_of_type_Boolean = true;
    this.jdField_Y_of_type_Boolean = false;
    this.jdField_Z_of_type_Boolean = false;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_aa_of_type_Boolean = false;
    this.jdField_ab_of_type_Boolean = false;
    this.jdField_ac_of_type_Boolean = false;
    this.jdField_ad_of_type_Boolean = false;
    this.jdField_ae_of_type_Boolean = false;
    this.jdField_af_of_type_Boolean = false;
    this.jdField_ag_of_type_Boolean = false;
    this.jdField_K_of_type_Int = 7;
    this.jdField_ai_of_type_Boolean = false;
    this.jdField_aj_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_i_of_type_Long = 0L;
    this.jdField_L_of_type_Int = 1;
    this.jdField_M_of_type_Int = 0;
    this.jdField_N_of_type_Int = 0;
    this.jdField_O_of_type_Int = -1;
    this.jdField_P_of_type_Int = 0;
    this.jdField_Q_of_type_Int = 0;
    this.jdField_R_of_type_Int = 1;
    this.jdField_u_of_type_JavaLangString = null;
    this.jdField_S_of_type_Int = -1;
    this.jdField_T_of_type_Int = -1;
    this.jdField_U_of_type_Int = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getEffectSettingQavNone();
    this.jdField_j_of_type_Long = 0L;
    this.jdField_v_of_type_JavaLangString = null;
    this.jdField_V_of_type_Int = 15000;
    this.jdField_W_of_type_Int = 0;
    this.jdField_X_of_type_Int = 0;
    this.jdField_Y_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_Z_of_type_Int = 0;
    this.jdField_aa_of_type_Int = -1;
    this.jdField_ab_of_type_Int = -1;
    this.jdField_ac_of_type_Int = -1;
    this.jdField_ad_of_type_Int = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
    this.jdField_ae_of_type_Int = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
    this.jdField_ai_of_type_Int = 0;
    this.jdField_aj_of_type_Int = 0;
    this.jdField_af_of_type_Int = 0;
    this.jdField_k_of_type_Long = -1L;
    this.jdField_ag_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(8);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionInfo_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createSession");
  }
  
  private boolean a(VideoViewInfo paramVideoViewInfo)
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)localIterator.next();
      if ((paramVideoViewInfo.jdField_a_of_type_Int == localVideoViewInfo.jdField_a_of_type_Int) && (paramVideoViewInfo.jdField_a_of_type_Long == localVideoViewInfo.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  private void d(long paramLong)
  {
    a(paramLong, 0L);
    this.jdField_j_of_type_Long = 0L;
    a("clearSessionInfo", 0);
    this.jdField_k_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    a(paramLong, "clearSessionInfo", 0);
    this.jdField_ad_of_type_Int = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
    this.jdField_ae_of_type_Int = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
    this.aq = false;
    this.ar = true;
    a(false);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_r_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.at = false;
    this.jdField_z_of_type_Int = -1;
    this.am = true;
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_i_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilBitSet.clear();
    b(paramLong, false);
    c(paramLong, false);
    this.jdField_L_of_type_Int = 1;
    this.jdField_E_of_type_Int = 0;
    this.jdField_U_of_type_Int = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getEffectSettingQavNone();
    this.ay = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_w_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a("clearSessionInfo", 0, 0);
  }
  
  public int a()
  {
    boolean bool = this.jdField_y_of_type_Boolean;
    int i2 = 2;
    if (!bool)
    {
      int i3 = this.jdField_E_of_type_Int;
      if (i3 != 100)
      {
        int i4 = this.jdField_d_of_type_Int;
        i1 = i2;
        if (i4 == 1) {
          return i1;
        }
        i1 = i2;
        if (i4 == 2) {
          return i1;
        }
        if (i3 == 3) {
          return 2;
        }
        if ((i4 != 3) && (i4 != 4) && (i3 != 1) && (i3 != 2)) {
          return 0;
        }
      }
    }
    int i1 = 1;
    return i1;
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
    int i1 = 0;
    int i2 = 0;
    if (paramInt != 0)
    {
      i1 = i2;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          return i1;
        }
        i1 += 1;
      }
    }
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public long a()
  {
    boolean bool = this.jdField_y_of_type_Boolean;
    long l1 = 0L;
    if (!bool)
    {
      int i1 = this.jdField_E_of_type_Int;
      if (i1 != 100)
      {
        int i2 = this.jdField_d_of_type_Int;
        if ((i2 != 1) && (i2 != 2) && (i1 != 3))
        {
          if ((i2 != 3) && (i2 != 4) && (i1 != 1) && (i1 != 2)) {
            break label223;
          }
          l2 = this.jdField_f_of_type_Long;
          l1 = l2;
          if (l2 != 0L) {
            break label223;
          }
          try
          {
            l1 = Long.parseLong(this.jdField_e_of_type_JavaLangString);
            return l1;
          }
          catch (Throwable localThrowable1)
          {
            l1 = l2;
            if (!QLog.isDevelopLevel()) {
              break label223;
            }
          }
          QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getChatRoomUin", localThrowable1);
          l1 = l2;
          break label223;
        }
        try
        {
          l2 = Long.parseLong(this.jdField_c_of_type_JavaLangString);
          return l2;
        }
        catch (Throwable localThrowable2)
        {
          if (!QLog.isDevelopLevel()) {
            break label223;
          }
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getChatRoomUin", localThrowable2);
        return 0L;
      }
    }
    long l2 = this.jdField_f_of_type_Long;
    l1 = l2;
    if (l2 == 0L) {
      try
      {
        l1 = Long.parseLong(this.jdField_c_of_type_JavaLangString);
        return l1;
      }
      catch (Throwable localThrowable3)
      {
        l1 = l2;
        if (QLog.isDevelopLevel())
        {
          QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getChatRoomUin", localThrowable3);
          l1 = l2;
        }
      }
    }
    label223:
    return l1;
  }
  
  public AVPhoneUserInfo a(long paramLong)
  {
    Iterator localIterator = this.jdField_f_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)localIterator.next();
      if ((localAVPhoneUserInfo.accountType != 1) && (localAVPhoneUserInfo.account == paramLong)) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public String a()
  {
    long l1 = this.jdField_f_of_type_Long;
    if (l1 != 0L) {
      return String.valueOf(l1);
    }
    if (this.jdField_k_of_type_Int == 0) {
      return this.jdField_c_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((VideoMemberChangeListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_Int != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SessionStatus[");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_aj_of_type_Int != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateWatchTogetherState, [");
        localStringBuilder.append(this.jdField_aj_of_type_Int);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogether", 2, localStringBuilder.toString());
      }
      this.jdField_aj_of_type_Int = paramInt;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearDoubleVideoSessionInfo, sessionId[");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    d(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setConnectedTime, connectedTime[");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append("->");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_d_of_type_Long = paramLong2;
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if ((this.jdField_d_of_type_Int != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSessionType[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], SessionType[");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoState[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], startOrStopVideo[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], isRemote[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        c(paramLong, true);
      } else {
        b(paramLong, true);
      }
      int i1 = this.jdField_d_of_type_Int;
      if (i1 == 1)
      {
        a(paramLong, "setVideoState.1", 2);
        return;
      }
      if (i1 == 3) {
        a(paramLong, "setVideoState.2", 4);
      }
    }
    else
    {
      if (paramBoolean2) {
        c(paramLong, false);
      } else {
        b(paramLong, false);
      }
      if ((this.jdField_d_of_type_Int == 2) && (!this.jdField_k_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
      {
        a(paramLong, "setVideoState.3", 1);
        return;
      }
      if ((this.jdField_d_of_type_Int == 4) && (!this.jdField_k_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && (!this.jdField_l_of_type_Boolean)) {
        a(paramLong, "setVideoState.4", 3);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_l_of_type_Boolean != paramBoolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalHasScreenShare, localHasScreenShare[");
      localStringBuilder.append(this.jdField_l_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhoneUserInfoInRoom info = ");
      localStringBuilder.append(paramAVPhoneUserInfo.toString());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_f_of_type_JavaUtilArrayList.add(paramAVPhoneUserInfo);
  }
  
  public void a(VideoViewInfo paramVideoViewInfo, boolean paramBoolean)
  {
    long l1 = paramVideoViewInfo.jdField_a_of_type_Long;
    int i1 = paramVideoViewInfo.jdField_a_of_type_Int;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      ??? = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoViewInfo-->Uin = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" ,VideoSrcType = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" ,insertHead = ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)???, 2, localStringBuilder.toString());
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel()))
    {
      ??? = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoViewInfo Error,The View Info Is Exsit.Uin = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" ,VideoSrcType = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" ,Index = ");
      localStringBuilder.append(i2);
      QLog.e((String)???, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.jdField_c_of_type_JavaUtilArrayList.add(0, paramVideoViewInfo);
    } else {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramVideoViewInfo);
    }
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (!a(paramVideoViewInfo))
      {
        if (paramBoolean) {
          this.jdField_d_of_type_JavaUtilArrayList.add(0, paramVideoViewInfo);
        } else {
          this.jdField_d_of_type_JavaUtilArrayList.add(paramVideoViewInfo);
        }
        a();
        if (QLog.isColorLevel())
        {
          paramVideoViewInfo = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addVideoViewInfo mMultiVideoTalkList-->Uin = ");
          localStringBuilder.append(l1);
          localStringBuilder.append(" ,VideoSrcType = ");
          localStringBuilder.append(i1);
          localStringBuilder.append(" ,insertHead = ");
          localStringBuilder.append(paramBoolean);
          QLog.d(paramVideoViewInfo, 2, localStringBuilder.toString());
        }
      }
      return;
    }
  }
  
  public void a(VideoMemberChangeListener paramVideoMemberChangeListener)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == paramVideoMemberChangeListener)) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoMemberChangeListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_g_of_type_JavaLangString = paramString;
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPhoneNum, phoneNum[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_f_of_type_Int != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setState[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], SessionState[");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_f_of_type_Int != paramInt)
    {
      ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).checkMemPerf(this.jdField_f_of_type_Int, paramInt);
      this.jdField_f_of_type_Int = paramInt;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (((this.jdField_X_of_type_Int != paramInt1) || (this.jdField_Y_of_type_Int != paramInt2)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShareInfo, state[");
      localStringBuilder.append(this.jdField_X_of_type_Int);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], type[");
      localStringBuilder.append(this.jdField_Y_of_type_Int);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    if (this.jdField_X_of_type_Int != paramInt1) {
      this.jdField_X_of_type_Int = paramInt1;
    }
    if (this.jdField_Y_of_type_Int != paramInt2) {
      this.jdField_Y_of_type_Int = paramInt2;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString2)) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSessionId[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], SessionId[");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_g_of_type_Boolean != paramBoolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalMuteStatus, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mute[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHasChangeDoubleScreen, hasChangeDoubleScreen[");
    localStringBuilder.append(this.jdField_J_of_type_Boolean);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_J_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (b()) || (this.jdField_L_of_type_Boolean);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
        return ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    if ((this.jdField_ai_of_type_Int == 0) && (paramBaseVideoAppInterface != null))
    {
      String str = null;
      int i2 = this.jdField_k_of_type_Int;
      int i1 = i2;
      if (i2 == -1) {
        i1 = UITools.c(this.jdField_E_of_type_Int);
      }
      if (i1 == 0) {
        str = this.jdField_c_of_type_JavaLangString;
      } else if (i1 == 1) {
        str = String.valueOf(this.jdField_f_of_type_Long);
      } else if (i1 == -1) {
        str = String.valueOf(this.jdField_f_of_type_Long);
      }
      boolean bool;
      if (i1 != -1)
      {
        bool = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).isShowVideoMsg(paramBaseVideoAppInterface.getApplicationContext(), paramBaseVideoAppInterface.getAccount(), str, i1);
        if (bool) {
          i2 = 2;
        } else {
          i2 = 1;
        }
        this.jdField_ai_of_type_Int = i2;
      }
      else
      {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        paramBaseVideoAppInterface = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isVideoMsgBlocked ret[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], uin[");
        localStringBuilder.append(str);
        localStringBuilder.append("], type[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], flag[");
        localStringBuilder.append(this.jdField_ai_of_type_Int);
        localStringBuilder.append("]");
        QLog.i(paramBaseVideoAppInterface, 2, localStringBuilder.toString());
      }
    }
    return this.jdField_ai_of_type_Int == 1;
  }
  
  public boolean a(String paramString)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    long l2 = 0L;
    boolean bool1 = bool3;
    boolean bool2;
    long l1;
    try
    {
      long l3 = AVUtil.a(paramString);
      bool1 = bool3;
      paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        do
        {
          do
          {
            do
            {
              bool1 = bool3;
              bool2 = bool4;
              l1 = l2;
              if (!paramString.hasNext()) {
                break;
              }
              bool1 = bool3;
              localEntry = (Map.Entry)paramString.next();
              bool1 = bool3;
            } while (localEntry.getValue() == null);
            bool1 = bool3;
          } while (!((Boolean)localEntry.getValue()).booleanValue());
          bool1 = bool3;
        } while (localEntry.getKey() == null);
        bool1 = bool3;
      } while (((Long)localEntry.getKey()).longValue() == l3);
      bool2 = true;
      bool1 = true;
      l1 = ((Long)localEntry.getKey()).longValue();
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      l1 = l2;
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isOtherUserShareScreenNow, [");
      paramString.append(l1);
      paramString.append(",");
      paramString.append(bool2);
      paramString.append("]");
      QLog.i("AVShare", 2, paramString.toString());
    }
    return bool2;
  }
  
  public int b()
  {
    int i1 = this.jdField_E_of_type_Int;
    if (i1 != 0) {
      return i1;
    }
    i1 = this.jdField_k_of_type_Int;
    if (i1 == 0)
    {
      if (this.jdField_y_of_type_Boolean) {
        return 100;
      }
      return 3;
    }
    if (i1 == 1) {
      return 1;
    }
    if (i1 == 3000) {
      return 2;
    }
    return 0;
  }
  
  public int b(long paramLong, int paramInt)
  {
    ArrayList localArrayList = this.jdField_d_of_type_JavaUtilArrayList;
    int i1 = 0;
    int i2 = 0;
    if (paramInt != 0) {
      i1 = i2;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.jdField_d_of_type_JavaUtilArrayList.size())
        {
          if ((((VideoViewInfo)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) || (((VideoViewInfo)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int != paramInt)) {
            continue;
          }
          return i1;
          if (i1 < this.jdField_d_of_type_JavaUtilArrayList.size())
          {
            if (((VideoViewInfo)this.jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
              break label146;
            }
            return i1;
          }
        }
        return -1;
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i1 += 1;
      }
      continue;
      label146:
      i1 += 1;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SessionInfo setAvType:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_j_of_type_Int = paramInt;
    jdField_i_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    d(paramLong);
    c("clearMultiVideoSessionInfo", false);
    this.jdField_g_of_type_Long = 0L;
    this.jdField_J_of_type_Int = -1;
    this.jdField_N_of_type_Boolean = false;
    this.jdField_O_of_type_Boolean = false;
    this.jdField_P_of_type_Boolean = false;
    this.jdField_Q_of_type_Boolean = false;
    this.jdField_R_of_type_Boolean = false;
    this.jdField_S_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      a();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_e_of_type_JavaUtilArrayList.clear();
      b(0);
      return;
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_j_of_type_Boolean != paramBoolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalHasVideo, localHasVideo[");
      localStringBuilder.append(this.jdField_j_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (!paramBoolean) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "why call not local hasVideo, str[1], isVisible[]", new Throwable("打印调用栈"));
      }
    }
    this.jdField_j_of_type_Boolean = paramBoolean;
    if (this.jdField_j_of_type_Boolean) {
      ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).tryLoadPtuSo();
    }
    ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).checkVoiceRecog(this.jdField_j_of_type_Boolean, this.jdField_k_of_type_Boolean);
  }
  
  public void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetVideoDisplayListExceptTargetUin-->Uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ,clearRenderFlag");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" ,clearRecvDataFlag");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
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
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_g_of_type_Int != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSwitchState[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], state[");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((AudioHelper.b()) || (!TextUtils.equals(paramString2, this.jdField_p_of_type_JavaLangString)))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDeviceName, from[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], deviceName[");
      localStringBuilder.append(this.jdField_p_of_type_JavaLangString);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_p_of_type_JavaLangString = paramString2;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.b()) || (paramBoolean != this.jdField_E_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeakerOn, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isSpeakerOn[");
      localStringBuilder.append(this.jdField_E_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_E_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.ao = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_F_of_type_Int != 0;
  }
  
  public int c()
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
  
  public void c(int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPeerSdkVersion [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i(str, 1, localStringBuilder.toString());
    this.jdField_ab_of_type_Int = paramInt;
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_k_of_type_Boolean != paramBoolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRemoteHasVideo, remoteHasVideo[");
      localStringBuilder.append(this.jdField_k_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_k_of_type_Boolean = paramBoolean;
    ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).checkVoiceRecog(this.jdField_j_of_type_Boolean, this.jdField_k_of_type_Boolean);
  }
  
  public void c(String paramString, int paramInt)
  {
    if ((QLog.isDevelopLevel()) || (this.jdField_m_of_type_Int != paramInt))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeakerMode, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_m_of_type_Int = paramInt;
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.b()) || (paramBoolean != this.jdField_M_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRoomMicOff[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isRoomMicOff[");
      localStringBuilder.append(this.jdField_M_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_M_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.ax = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_F_of_type_Int == 2;
  }
  
  public void d(int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPeerTerminalType [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i(str, 1, localStringBuilder.toString());
    this.jdField_ac_of_type_Int = paramInt;
  }
  
  public void d(String paramString, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1) {}
    }
    else
    {
      bool1 = bool2;
      if (this.jdField_D_of_type_Int == 2) {
        switch (this.jdField_f_of_type_Int)
        {
        default: 
          bool1 = bool2;
          break;
        case 8: 
        case 9: 
        case 10: 
          bool1 = false;
        }
      }
    }
    if ((QLog.isColorLevel()) || (this.jdField_D_of_type_Int != paramInt))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGAudioStatusType, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isNeedUpdate[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], state[");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(this.jdField_D_of_type_Int);
      localStringBuilder.append("], come[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (bool1) {
      this.jdField_D_of_type_Int = paramInt;
    }
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSwitch2DoubleMeeting, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.jdField_L_of_type_Boolean);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("normal_2_meeting", 2, localStringBuilder.toString());
    }
    this.jdField_L_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_E_of_type_Int == 2;
  }
  
  public void e(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSwitchToGAudioMode[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], switchToGAudioMode[");
    localStringBuilder.append(this.jdField_F_of_type_Int);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_F_of_type_Int = paramInt;
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_z_of_type_Boolean != paramBoolean) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateInMeetingRoom, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.jdField_z_of_type_Boolean);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_z_of_type_Boolean != paramBoolean) {
      this.jdField_z_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Int == 0;
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((AudioHelper.b()) || (paramInt != this.jdField_G_of_type_Int))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMicAuthByAdmin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], micAuthByAdmin[");
      localStringBuilder.append(this.jdField_G_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_G_of_type_Int = paramInt;
  }
  
  public void f(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_y_of_type_Boolean != paramBoolean) || (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDoubleMeeting, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.jdField_y_of_type_Boolean);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_y_of_type_Boolean != paramBoolean) {
      this.jdField_y_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean f()
  {
    return this.jdField_f_of_type_Int == 1;
  }
  
  public boolean g()
  {
    return this.jdField_f_of_type_Int == 2;
  }
  
  public boolean h()
  {
    int i1 = this.jdField_f_of_type_Int;
    return (i1 == 2) || (i1 == 7);
  }
  
  public boolean i()
  {
    return this.jdField_f_of_type_Int == 3;
  }
  
  public boolean j()
  {
    return this.jdField_f_of_type_Int == 4;
  }
  
  public boolean k()
  {
    return this.jdField_f_of_type_Int == 10;
  }
  
  public boolean l()
  {
    return this.jdField_f_of_type_Int == 14;
  }
  
  public boolean m()
  {
    return this.jdField_f_of_type_Int == 5;
  }
  
  public boolean n()
  {
    return this.jdField_f_of_type_Int == 6;
  }
  
  public boolean o()
  {
    return this.jdField_f_of_type_Int == 15;
  }
  
  public boolean p()
  {
    int i1 = this.jdField_d_of_type_Int;
    return (i1 == 3) || (i1 == 4);
  }
  
  public boolean q()
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
  
  public boolean r()
  {
    return this.jdField_aj_of_type_Int != 0;
  }
  
  public boolean s()
  {
    int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isVideoNumReachMaxNow, size[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    return i1 >= 16;
  }
  
  public boolean t()
  {
    int i1 = this.jdField_d_of_type_Int;
    return (i1 == 2) || (i1 == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], SessionType[");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("], sessionStatus[");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("], relationType[");
    localStringBuilder.append(this.jdField_E_of_type_Int);
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(this.jdField_k_of_type_Int);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append("], state[");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("], switchState[");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], peerName[");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("], extraCode[");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    localStringBuilder.append("], localHasVideo[");
    localStringBuilder.append(this.jdField_j_of_type_Boolean);
    localStringBuilder.append("], roomId[");
    localStringBuilder.append(this.jdField_l_of_type_Long);
    localStringBuilder.append("], isReceiver[");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public boolean u()
  {
    int i1 = this.jdField_d_of_type_Int;
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean v()
  {
    int i1 = this.jdField_E_of_type_Int;
    boolean bool2 = false;
    boolean bool1;
    if ((i1 != 1) && (i1 != 2))
    {
      if (i1 != 3)
      {
        bool1 = bool2;
        if (i1 != 0) {}
      }
      else if (this.jdField_y_of_type_Boolean)
      {
        bool1 = this.jdField_z_of_type_Boolean;
      }
      else
      {
        bool1 = bool2;
        if (this.jdField_f_of_type_Int == 4) {
          bool1 = true;
        }
      }
    }
    else {
      bool1 = this.jdField_K_of_type_Boolean;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canStartScreenShare, relationType[");
      localStringBuilder.append(this.jdField_E_of_type_Int);
      localStringBuilder.append("], isDoubleVideoMeeting[");
      localStringBuilder.append(this.jdField_y_of_type_Boolean);
      localStringBuilder.append("], ret[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean w()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.SessionInfo
 * JD-Core Version:    0.7.0.1
 */