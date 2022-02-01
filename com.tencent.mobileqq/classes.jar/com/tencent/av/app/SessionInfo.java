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
  public static int n;
  public long A = 0L;
  public boolean B = false;
  public boolean C = false;
  public int D = 0;
  public boolean E = false;
  public boolean F = false;
  public boolean G = true;
  public boolean H = false;
  public boolean I = false;
  public boolean J = false;
  public int K = 3;
  public boolean L = true;
  public boolean M = false;
  public boolean N = true;
  public boolean O = true;
  public boolean P = true;
  public boolean Q = false;
  public boolean R = false;
  public boolean S = false;
  public boolean T = false;
  public int U = 0;
  public int V = 0;
  public int W = -1;
  public long X = 0L;
  public int Y = 0;
  public int Z = 0;
  public int aA = 0;
  public String aB = null;
  public int aC = 0;
  public String aD = null;
  public String aE = null;
  public String[] aF = null;
  public boolean aG = false;
  public byte[] aH = null;
  public boolean aI = false;
  public boolean aJ = false;
  public boolean aK = false;
  public boolean aL = false;
  public boolean aM = false;
  public long aN = 0L;
  public long[] aO = null;
  public int aP = -1;
  public int aQ = 0;
  public int aR = 0;
  public boolean aS = false;
  public boolean aT = false;
  public boolean aU = false;
  public int aV = 2;
  public String aW = null;
  public long aX = 0L;
  public int aY = 0;
  public int aZ = 1;
  public String aa = null;
  public String ab = null;
  public boolean ac = false;
  public int ad = 0;
  public int ae = 0;
  public boolean af = false;
  public boolean ag = false;
  public int ah = 0;
  public int ai = 0;
  public int aj = 0;
  public int ak = 0;
  public String al = "";
  public boolean am = false;
  public boolean an = false;
  public boolean ao = false;
  public boolean ap;
  public long aq = 0L;
  public String ar = null;
  public boolean as = false;
  public boolean at = false;
  public ArrayList<Long> au = new ArrayList();
  public ArrayList<String> av = new ArrayList();
  public long aw = 0L;
  public long ax = 0L;
  public int ay = -1;
  public int az = 0;
  public boolean bA = false;
  public int bB = 7;
  public boolean bC = false;
  public boolean bD = false;
  public boolean bE = false;
  public boolean bF = false;
  public BitSet bG = new BitSet();
  public String bH = "";
  public long bI = 0L;
  public boolean bJ = false;
  public boolean bK = true;
  public boolean bL = false;
  public int bM = 1;
  public boolean bN = false;
  public int bO = 0;
  public int bP = 0;
  public int bQ = -1;
  public boolean bR = false;
  public int bS = 0;
  public int bT = 0;
  public int bU = 1;
  public String bV = null;
  public boolean bW = false;
  public boolean bX = true;
  public int bY = -1;
  public int bZ = -1;
  @Deprecated
  public int ba = -1;
  @Deprecated
  public boolean bb = false;
  @Deprecated
  public boolean bc = false;
  @Deprecated
  public boolean bd = false;
  @Deprecated
  public boolean be = false;
  @Deprecated
  public boolean bf = false;
  public boolean bg = false;
  public boolean bh = false;
  public volatile ArrayList<VideoViewInfo> bi = new ArrayList();
  public volatile boolean bj = false;
  public ArrayList<VideoViewInfo> bk = new ArrayList();
  public ArrayList<VideoViewInfo> bl = new ArrayList();
  public ArrayList<AVPhoneUserInfo> bm = new ArrayList();
  public String bn = "DEVICE_NONE";
  public boolean bo = false;
  public boolean bp = false;
  public boolean bq = true;
  public boolean br = false;
  public boolean bs = false;
  public long bt = 0L;
  public boolean bu = false;
  public boolean bv = false;
  public boolean bw = false;
  public boolean bx = false;
  public boolean by = false;
  public boolean bz = false;
  public boolean cA = false;
  public boolean cB = false;
  public long cC = -1L;
  public boolean cD = false;
  public int cE = 0;
  public boolean cF = false;
  public boolean cG = false;
  public boolean cH = false;
  public boolean cI = true;
  public boolean cJ = false;
  public boolean cK = false;
  public HashSet<Integer> cL = new HashSet(8);
  private int cO = 0;
  private int cP = 0;
  public boolean ca = false;
  public int cb = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getEffectSettingQavNone();
  public long cc = 0L;
  public boolean cd = false;
  public boolean ce = false;
  public String cf = null;
  public int cg = 15000;
  public boolean ch = false;
  public int ci = 0;
  public int cj = 0;
  public int ck = 0;
  protected final ConcurrentHashMap<Long, Boolean> cl = new ConcurrentHashMap();
  public int cm = 0;
  public boolean cn = false;
  public int co = -1;
  public int cp = -1;
  public int cq = -1;
  public int cr = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
  public int cs = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
  public boolean ct = false;
  protected WeakReference<VideoMemberChangeListener> cu;
  public boolean cv = false;
  public boolean cw = false;
  public boolean cx = false;
  public boolean cy = false;
  public int cz = 0;
  public final String d;
  public int e = 0;
  public String f = null;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public boolean l = false;
  public boolean m = false;
  public int o = 0;
  public int p = -1;
  public boolean q = false;
  public int r = -1;
  public String s = null;
  public String t = null;
  public String u = null;
  public String v = null;
  public String w = null;
  public String x = null;
  public String y = null;
  public String z = null;
  
  public SessionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionInfo_");
    localStringBuilder.append(AudioHelper.c());
    this.d = localStringBuilder.toString();
    QLog.w(this.d, 1, "createSession");
  }
  
  private boolean a(VideoViewInfo paramVideoViewInfo)
  {
    Iterator localIterator = this.bk.iterator();
    while (localIterator.hasNext())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)localIterator.next();
      if ((paramVideoViewInfo.b == localVideoViewInfo.b) && (paramVideoViewInfo.a == localVideoViewInfo.a)) {
        return true;
      }
    }
    return false;
  }
  
  private void f(long paramLong)
  {
    a(paramLong, 0L);
    this.cc = 0L;
    a("clearSessionInfo", 0);
    this.p = -1;
    this.E = false;
    this.F = false;
    a(paramLong, "clearSessionInfo", 0);
    this.cr = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
    this.cs = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
    this.bW = false;
    this.bX = true;
    a(false);
    this.aq = 0L;
    this.aW = null;
    this.C = false;
    this.S = false;
    this.af = false;
    this.ag = false;
    this.cd = false;
    this.ay = -1;
    this.bK = true;
    this.bH = "";
    this.bI = 0L;
    this.bG.clear();
    b(paramLong, false);
    c(paramLong, false);
    this.bM = 1;
    this.aQ = 0;
    this.cb = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getEffectSettingQavNone();
    this.cA = false;
    this.cu = null;
    this.ai = 0;
    this.cl.clear();
    a("clearSessionInfo", 0, 0);
    this.cv = false;
    this.cw = false;
    this.cx = false;
    this.cy = false;
  }
  
  public String A()
  {
    long l1 = this.aN;
    if (l1 != 0L) {
      return String.valueOf(l1);
    }
    if (this.p == 0) {
      return this.s;
    }
    return null;
  }
  
  public int B()
  {
    int i1 = 0;
    while (i1 < this.bi.size())
    {
      if (((VideoViewInfo)this.bi.get(i1)).d) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void C()
  {
    WeakReference localWeakReference = this.cu;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((VideoMemberChangeListener)this.cu.get()).a();
    }
  }
  
  public AVPhoneUserInfo a(long paramLong)
  {
    Iterator localIterator = this.bm.iterator();
    while (localIterator.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)localIterator.next();
      if ((localAVPhoneUserInfo.accountType != 1) && (localAVPhoneUserInfo.account == paramLong)) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if ((this.e != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SessionStatus[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    this.e = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.cP != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateWatchTogetherState, [");
        localStringBuilder.append(this.cP);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogether", 2, localStringBuilder.toString());
      }
      this.cP = paramInt;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setConnectedTime, connectedTime[");
    localStringBuilder.append(this.aw);
    localStringBuilder.append("->");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.aw = paramLong2;
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if ((this.g != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSessionType[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], SessionType[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.g = paramInt;
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.d;
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
      int i1 = this.g;
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
      if ((this.g == 2) && (!this.I) && (!this.H) && (!this.J))
      {
        a(paramLong, "setVideoState.3", 1);
        return;
      }
      if ((this.g == 4) && (!this.I) && (!this.H) && (!this.J)) {
        a(paramLong, "setVideoState.4", 3);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.J != paramBoolean))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalHasScreenShare, localHasScreenShare[");
      localStringBuilder.append(this.J);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.J = paramBoolean;
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.cl.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1));
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
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhoneUserInfoInRoom info = ");
      localStringBuilder.append(paramAVPhoneUserInfo.toString());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.bm.add(paramAVPhoneUserInfo);
  }
  
  public void a(VideoViewInfo paramVideoViewInfo, boolean paramBoolean)
  {
    long l1 = paramVideoViewInfo.a;
    int i1 = paramVideoViewInfo.b;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      ??? = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoViewInfo-->Uin = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" ,VideoSrcType = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" ,insertHead = ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)???, 2, localStringBuilder.toString());
    }
    int i2 = b(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel()))
    {
      ??? = this.d;
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
      this.bi.add(0, paramVideoViewInfo);
    } else {
      this.bi.add(paramVideoViewInfo);
    }
    synchronized (this.bk)
    {
      if (!a(paramVideoViewInfo))
      {
        if (paramBoolean) {
          this.bk.add(0, paramVideoViewInfo);
        } else {
          this.bk.add(paramVideoViewInfo);
        }
        C();
        if (QLog.isColorLevel())
        {
          paramVideoViewInfo = this.d;
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
    WeakReference localWeakReference = this.cu;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.cu.get() == paramVideoMemberChangeListener)) {
      return;
    }
    this.cu = new WeakReference(paramVideoMemberChangeListener);
  }
  
  public void a(String paramString)
  {
    this.w = paramString;
    if (QLog.isDevelopLevel())
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPhoneNum, phoneNum[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.i != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setState[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], SessionState[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.i != paramInt)
    {
      ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).checkMemPerf(this.i, paramInt);
      this.i = paramInt;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (((this.cj != paramInt1) || (this.ck != paramInt2)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShareInfo, state[");
      localStringBuilder.append(this.cj);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], type[");
      localStringBuilder.append(this.ck);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    if (this.cj != paramInt1) {
      this.cj = paramInt1;
    }
    if (this.ck != paramInt2) {
      this.ck = paramInt2;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.equals(this.f, paramString2)) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSessionId[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], SessionId[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    this.f = paramString2;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.E != paramBoolean))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalMuteStatus, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mute[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.E = paramBoolean;
  }
  
  public void a(boolean paramBoolean)
  {
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHasChangeDoubleScreen, hasChangeDoubleScreen[");
    localStringBuilder.append(this.aM);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.aM = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAvatar2DUsingStatus ");
    String str1;
    if (paramBoolean1) {
      str1 = "local";
    } else {
      str1 = " remote";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(" isUsing=");
    localStringBuilder.append(paramBoolean2);
    QLog.d(str2, 1, localStringBuilder.toString(), new Throwable("打印堆栈"));
    if (paramBoolean1)
    {
      this.cv = paramBoolean2;
      return;
    }
    this.cw = paramBoolean2;
  }
  
  public boolean a()
  {
    return (b()) || (this.aT);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    int i1 = 0;
    while (i1 < this.bi.size())
    {
      if ((((VideoViewInfo)this.bi.get(i1)).a == paramLong) && (((VideoViewInfo)this.bi.get(i1)).b == paramInt)) {
        return ((VideoViewInfo)this.bi.get(i1)).f;
      }
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    if ((this.cO == 0) && (paramBaseVideoAppInterface != null))
    {
      String str = null;
      int i2 = this.p;
      int i1 = i2;
      if (i2 == -1) {
        i1 = UITools.c(this.aQ);
      }
      if (i1 == 0) {
        str = this.s;
      } else if (i1 == 1) {
        str = String.valueOf(this.aN);
      } else if (i1 == -1) {
        str = String.valueOf(this.aN);
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
        this.cO = i2;
      }
      else
      {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        paramBaseVideoAppInterface = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isVideoMsgBlocked ret[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], uin[");
        localStringBuilder.append(str);
        localStringBuilder.append("], type[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], flag[");
        localStringBuilder.append(this.cO);
        localStringBuilder.append("]");
        QLog.i(paramBaseVideoAppInterface, 2, localStringBuilder.toString());
      }
    }
    return this.cO == 1;
  }
  
  public int b(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.bi.size())
    {
      if ((((VideoViewInfo)this.bi.get(i1)).e) && (((VideoViewInfo)this.bi.get(i1)).a != paramLong)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int b(long paramLong, int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramInt != 0)
    {
      i1 = i2;
      while (i1 < this.bi.size())
      {
        if ((((VideoViewInfo)this.bi.get(i1)).a == paramLong) && (((VideoViewInfo)this.bi.get(i1)).b == paramInt)) {
          return i1;
        }
        i1 += 1;
      }
    }
    while (i1 < this.bi.size())
    {
      if (((VideoViewInfo)this.bi.get(i1)).a == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SessionInfo setAvType:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.o = paramInt;
    n = paramInt;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.H != paramBoolean))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalHasVideo, localHasVideo[");
      localStringBuilder.append(this.H);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (!paramBoolean) {
        QLog.w(this.d, 1, "why call not local hasVideo, str[1], isVisible[]", new Throwable("打印调用栈"));
      }
    }
    this.H = paramBoolean;
    if (this.H) {
      ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).tryLoadPtuSo();
    }
    ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).checkVoiceRecog(this.H, this.I);
  }
  
  public void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.d;
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
    while (i1 < this.bi.size())
    {
      if (((VideoViewInfo)this.bi.get(i1)).a != paramLong)
      {
        if (paramBoolean1) {
          ((VideoViewInfo)this.bi.get(i1)).d = false;
        }
        if (paramBoolean2) {
          ((VideoViewInfo)this.bi.get(i1)).f = false;
        }
      }
      i1 += 1;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.j != paramInt) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSwitchState[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], state[");
      localStringBuilder.append(this.j);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.j = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((AudioHelper.e()) || (!TextUtils.equals(paramString2, this.aD)))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDeviceName, from[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], deviceName[");
      localStringBuilder.append(this.aD);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.aD = paramString2;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.aG))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeakerOn, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isSpeakerOn[");
      localStringBuilder.append(this.aG);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.aG = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.bN = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNeedCloseViewForAvatar2D ");
    String str1;
    if (paramBoolean1) {
      str1 = "local";
    } else {
      str1 = " remote";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(" isNeed=");
    localStringBuilder.append(paramBoolean2);
    QLog.d(str2, 1, localStringBuilder.toString(), new Throwable("打印堆栈"));
    if (paramBoolean1)
    {
      this.cx = paramBoolean2;
      return;
    }
    this.cy = paramBoolean2;
  }
  
  public boolean b()
  {
    return this.aR != 0;
  }
  
  public boolean b(String paramString)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    long l2 = 0L;
    boolean bool1 = bool3;
    boolean bool2;
    long l1;
    try
    {
      long l3 = AVUtil.c(paramString);
      bool1 = bool3;
      paramString = this.cl.entrySet().iterator();
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
  
  public int c(long paramLong, int paramInt)
  {
    ArrayList localArrayList = this.bk;
    int i1 = 0;
    int i2 = 0;
    if (paramInt != 0) {
      i1 = i2;
    }
    for (;;)
    {
      try
      {
        if (i1 < this.bk.size())
        {
          if ((((VideoViewInfo)this.bk.get(i1)).a != paramLong) || (((VideoViewInfo)this.bk.get(i1)).b != paramInt)) {
            continue;
          }
          return i1;
          if (i1 < this.bk.size())
          {
            if (((VideoViewInfo)this.bk.get(i1)).a != paramLong) {
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
  
  public void c(int paramInt)
  {
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPeerSdkVersion [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i(str, 1, localStringBuilder.toString());
    this.cp = paramInt;
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearDoubleVideoSessionInfo, sessionId[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    f(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.I != paramBoolean))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRemoteHasVideo, remoteHasVideo[");
      localStringBuilder.append(this.I);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString(), new Throwable("打印堆栈"));
    }
    this.I = paramBoolean;
    ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).checkVoiceRecog(this.H, this.I);
  }
  
  public void c(String paramString, int paramInt)
  {
    if ((QLog.isDevelopLevel()) || (this.D != paramInt))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeakerMode, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.D = paramInt;
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.e()) || (paramBoolean != this.aU))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRoomMicOff[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isRoomMicOff[");
      localStringBuilder.append(this.aU);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.aU = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.ct = paramBoolean;
  }
  
  public boolean c()
  {
    return this.aR == 2;
  }
  
  public void d(int paramInt)
  {
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPeerTerminalType [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i(str, 1, localStringBuilder.toString());
    this.cq = paramInt;
  }
  
  public void d(long paramLong)
  {
    f(paramLong);
    c("clearMultiVideoSessionInfo", false);
    this.aX = 0L;
    this.ba = -1;
    this.bb = false;
    this.bc = false;
    this.bd = false;
    this.be = false;
    this.bf = false;
    this.bg = false;
    this.bi.clear();
    synchronized (this.bk)
    {
      this.bk.clear();
      C();
      this.cu = null;
      this.bl.clear();
      b(0);
      return;
    }
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
      if (this.aP == 2) {
        switch (this.i)
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
    if ((QLog.isColorLevel()) || (this.aP != paramInt))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGAudioStatusType, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isNeedUpdate[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], state[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(this.aP);
      localStringBuilder.append("], come[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (bool1) {
      this.aP = paramInt;
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
      localStringBuilder.append(this.aT);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("normal_2_meeting", 2, localStringBuilder.toString());
    }
    this.aT = paramBoolean;
  }
  
  public boolean d()
  {
    return this.aQ == 2;
  }
  
  public void e(String paramString, int paramInt)
  {
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSwitchToGAudioMode[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], switchToGAudioMode[");
    localStringBuilder.append(this.aR);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.aR = paramInt;
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    if ((this.an != paramBoolean) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateInMeetingRoom, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.an);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    if (this.an != paramBoolean) {
      this.an = paramBoolean;
    }
  }
  
  public boolean e()
  {
    return this.i == 0;
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((AudioHelper.e()) || (paramInt != this.aV))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMicAuthByAdmin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], micAuthByAdmin[");
      localStringBuilder.append(this.aV);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.aV = paramInt;
  }
  
  public void f(String paramString, boolean paramBoolean)
  {
    if ((this.am != paramBoolean) || (QLog.isColorLevel()))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDoubleMeeting, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], [");
      localStringBuilder.append(this.am);
      localStringBuilder.append("-->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
    if (this.am != paramBoolean) {
      this.am = paramBoolean;
    }
  }
  
  public boolean f()
  {
    return this.i == 1;
  }
  
  public boolean g()
  {
    return this.i == 2;
  }
  
  public boolean h()
  {
    int i1 = this.i;
    return (i1 == 2) || (i1 == 7);
  }
  
  public boolean i()
  {
    return this.i == 3;
  }
  
  public boolean j()
  {
    return this.i == 4;
  }
  
  public boolean k()
  {
    return this.i == 10;
  }
  
  public boolean l()
  {
    return this.i == 14;
  }
  
  public boolean m()
  {
    return this.i == 5;
  }
  
  public boolean n()
  {
    return this.i == 6;
  }
  
  public boolean o()
  {
    return this.i == 15;
  }
  
  public boolean p()
  {
    int i1 = this.g;
    return (i1 == 3) || (i1 == 4);
  }
  
  public boolean q()
  {
    int i1 = 0;
    while (i1 < this.bi.size())
    {
      if (((VideoViewInfo)this.bi.get(i1)).f) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean r()
  {
    return this.cP != 0;
  }
  
  public boolean s()
  {
    int i1 = this.bi.size();
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
    int i1 = this.g;
    return (i1 == 2) || (i1 == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], SessionType[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], sessionStatus[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], relationType[");
    localStringBuilder.append(this.aQ);
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(this.p);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(this.aN);
    localStringBuilder.append("], state[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("], switchState[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(this.s);
    localStringBuilder.append("], peerName[");
    localStringBuilder.append(this.t);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(this.u);
    localStringBuilder.append("], extraCode[");
    localStringBuilder.append(this.v);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(this.o);
    localStringBuilder.append("], localHasVideo[");
    localStringBuilder.append(this.H);
    localStringBuilder.append("], roomId[");
    localStringBuilder.append(this.cM);
    localStringBuilder.append("], isReceiver[");
    localStringBuilder.append(this.B);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public boolean u()
  {
    int i1 = this.g;
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
    int i1 = this.aQ;
    boolean bool2 = false;
    boolean bool1;
    if ((i1 != 1) && (i1 != 2))
    {
      if (i1 != 3)
      {
        bool1 = bool2;
        if (i1 != 0) {}
      }
      else if (this.am)
      {
        bool1 = this.an;
      }
      else
      {
        bool1 = bool2;
        if (this.i == 4) {
          bool1 = true;
        }
      }
    }
    else {
      bool1 = this.aS;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canStartScreenShare, relationType[");
      localStringBuilder.append(this.aQ);
      localStringBuilder.append("], isDoubleVideoMeeting[");
      localStringBuilder.append(this.am);
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
    while (i1 < this.bi.size())
    {
      if (((VideoViewInfo)this.bi.get(i1)).c) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public int x()
  {
    boolean bool = this.am;
    int i2 = 2;
    if (!bool)
    {
      int i3 = this.aQ;
      if (i3 != 100)
      {
        int i4 = this.g;
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
  
  public long y()
  {
    boolean bool = this.am;
    long l1 = 0L;
    if (!bool)
    {
      int i1 = this.aQ;
      if (i1 != 100)
      {
        int i2 = this.g;
        if ((i2 != 1) && (i2 != 2) && (i1 != 3))
        {
          if ((i2 != 3) && (i2 != 4) && (i1 != 1) && (i1 != 2)) {
            break label223;
          }
          l2 = this.aN;
          l1 = l2;
          if (l2 != 0L) {
            break label223;
          }
          try
          {
            l1 = Long.parseLong(this.u);
            return l1;
          }
          catch (Throwable localThrowable1)
          {
            l1 = l2;
            if (!QLog.isDevelopLevel()) {
              break label223;
            }
          }
          QLog.i(this.d, 4, "getChatRoomUin", localThrowable1);
          l1 = l2;
          break label223;
        }
        try
        {
          l2 = Long.parseLong(this.s);
          return l2;
        }
        catch (Throwable localThrowable2)
        {
          if (!QLog.isDevelopLevel()) {
            break label223;
          }
        }
        QLog.i(this.d, 4, "getChatRoomUin", localThrowable2);
        return 0L;
      }
    }
    long l2 = this.aN;
    l1 = l2;
    if (l2 == 0L) {
      try
      {
        l1 = Long.parseLong(this.s);
        return l1;
      }
      catch (Throwable localThrowable3)
      {
        l1 = l2;
        if (QLog.isDevelopLevel())
        {
          QLog.i(this.d, 4, "getChatRoomUin", localThrowable3);
          l1 = l2;
        }
      }
    }
    label223:
    return l1;
  }
  
  public int z()
  {
    int i1 = this.aQ;
    if (i1 != 0) {
      return i1;
    }
    i1 = this.p;
    if (i1 == 0)
    {
      if (this.am) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.SessionInfo
 * JD-Core Version:    0.7.0.1
 */