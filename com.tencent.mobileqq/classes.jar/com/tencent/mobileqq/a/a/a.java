package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.f.a;
import com.tencent.mobileqq.msf.core.al;
import com.tencent.mobileqq.msf.core.al.f;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.j.a;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.i;
import com.tencent.mobileqq.msf.core.net.v;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends c
  implements al.f
{
  public static final boolean a = ;
  public static boolean b = false;
  public static int c = 0;
  private static final String d = "ConnQualityStat";
  
  private a()
  {
    if (a)
    {
      if (al.a().b() != null)
      {
        al.a().a(this);
        QLog.i("ConnQualityStat", 1, al.a().b().toString());
      }
      return;
    }
    QLog.d("ConnQualityStat", 1, "WeaknetNew enable=" + a);
  }
  
  public static a a()
  {
    return a.a();
  }
  
  public static boolean b()
  {
    return (a) && (al.a().c());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong, v paramv)
  {
    if (a) {}
    try
    {
      al.a().a(paramInt, paramLong, paramv);
      c.a().a(false);
      return;
    }
    catch (Exception paramv)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpenFailed", paramv);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a) {}
    try
    {
      al.a().a(paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ConnQualityStat", 1, "onPingRecved", localException);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (a) {}
    try
    {
      al.a().a(parama);
      c.a().a(false);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnClose", parama);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      al.a().a(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onPingSent", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (a) {}
    try
    {
      al.a().a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onRecvRespPkg", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, com.tencent.mobileqq.msf.core.quicksend.f paramf)
  {
    if (a) {}
    try
    {
      al.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onQuickSendResp", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, int paramInt)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      paramFromServiceMsg.getAttributes().put("conn_cross_oper_flag", Boolean.valueOf(b));
    }
    if (QLog.isColorLevel())
    {
      boolean bool = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      QLog.d("ConnQualityStat", 2, "onRecvSendChatMsgResp ssoReq=" + paramFromServiceMsg.getRequestSsoSeq() + " weaknet=" + b() + " cross=" + b + " xgSent=" + bool);
    }
    if (a) {
      try
      {
        try
        {
          al.a().a(paramToServiceMsg, paramFromServiceMsg, paramBoolean, 0);
          return;
        }
        finally {}
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onRecvSendChatMsgResp", paramToServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedCallback()) && (!"SSO.LoginMerge".equals(paramToServiceMsg.getServiceCmd()))) {
      c += 1;
    }
    if (a) {}
    try
    {
      al.a().a(paramToServiceMsg, paramBoolean);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onSendReqPkg", paramToServiceMsg);
    }
  }
  
  public void a(Socket paramSocket, int paramInt1, int paramInt2)
  {
    if (a) {}
    try
    {
      if (NetConnInfoCenter.isWifiConn()) {
        al.a().a(paramSocket, paramInt2);
      }
      for (;;)
      {
        if (MsfService.serviceInitStart > 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConnQualityStat", 2, "onConnOpened netType: " + paramInt1 + " serviceInit: " + MsfService.serviceInitStart + " cost:" + (SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
          }
          paramSocket = new d();
          if (paramSocket != null)
          {
            paramSocket.a("netType", String.valueOf(paramInt1));
            paramSocket.a("cost", String.valueOf(SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
            paramSocket.a(SystemClock.elapsedRealtime() - MsfService.serviceInitStart);
          }
          MsfService.serviceInitStart = 0L;
        }
        return;
        al.a().b(paramSocket, paramInt2);
      }
    }
    catch (Exception paramSocket)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpened", paramSocket);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a) {}
    try
    {
      al.a().a(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ConnQualityStat", 1, "onScreenOn", localException);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      al.a().b(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onSendChatMsg", paramToServiceMsg);
    }
  }
  
  public void c()
  {
    if (a) {
      al.a().d();
    }
    c.a().a(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      al.a().c(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onQuickSendReqBefore", paramToServiceMsg);
    }
  }
  
  public void d()
  {
    if (a) {}
    try
    {
      al.a().e();
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ConnQualityStat", 1, "onScreenOff", localException);
    }
  }
  
  private static class a
  {
    private static final a a = new a(null);
  }
  
  public static class b
    extends j.a
  {
    private static final String b = "freqCloseConn";
    private static final String c = "msf.event.freqCloseConn";
    volatile AtomicBoolean a = new AtomicBoolean(false);
    private long d;
    private int e;
    private HashMap f;
    
    public static b a()
    {
      return a.a();
    }
    
    private void b()
    {
      a("closeConnCount", String.valueOf(this.e));
      a("closeConnReason", String.valueOf(this.f.keySet()));
      a("msf.event.freqCloseConn", true, 0L, this.e);
    }
    
    public void a(com.tencent.qphone.base.a parama)
    {
      long l = System.currentTimeMillis();
      if (this.a.compareAndSet(false, true))
      {
        parama = parama.toString();
        if (this.f == null) {
          this.f = new HashMap();
        }
        if (l - this.d <= 300000L) {
          break label147;
        }
        if (this.e > 10)
        {
          b();
          QLog.d("freqCloseConn", 1, "closeConnCount:" + this.e + " ,reasonMap:" + this.f.keySet());
        }
        this.e = 1;
        this.d = l;
        this.f.clear();
        this.f.put(parama, Integer.valueOf(1));
      }
      for (;;)
      {
        this.a.set(false);
        return;
        label147:
        this.e += 1;
        if ((this.f.containsKey(parama)) && (this.f.get(parama) != null)) {
          this.f.put(parama, Integer.valueOf(((Integer)this.f.get(parama)).intValue() + 1));
        } else {
          this.f.put(parama, Integer.valueOf(1));
        }
      }
    }
    
    private static class a
    {
      private static final a.b a = new a.b();
    }
  }
  
  public static class c
    extends j.a
  {
    private static final String a = "msf.event.NetConnDontMatched";
    private boolean b;
    private d c;
    private boolean d;
    
    public static c a()
    {
      return a.a();
    }
    
    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
      if (!paramBoolean) {
        a.b = false;
      }
      if ((this.b) && (this.c != null) && (i.a(this.c))) {
        a.b = true;
      }
    }
    
    public void a(boolean paramBoolean, d paramd)
    {
      this.b = paramBoolean;
      this.c = paramd;
      this.d = false;
      a.b = false;
    }
    
    public void b()
    {
      if ((this.b) && (this.c != null)) {
        if (!"00000".equals(this.c.j)) {
          break label208;
        }
      }
      label208:
      for (int i = 2;; i = 1)
      {
        if (i.a(this.c))
        {
          a.b = true;
          QLog.i("ConnQualityStat", 1, "conn is cross oper!!! " + this.c.toString());
          a("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
          a("netType", String.valueOf(i));
          a("region", this.c.k);
          a("oper", this.c.l);
          a("vip", this.c.c());
          a("uintime", String.valueOf(MsfCore.sCore.getAccountCenter().i() + "_" + i + "_" + System.currentTimeMillis()));
          a("msf.event.NetConnDontMatched", true, 0L, 0L);
          h();
        }
        return;
      }
    }
    
    private static class a
    {
      private static final a.c a = new a.c();
    }
  }
  
  class d
    extends j.a
  {
    public static final String a = "dim.msf.ServiceInitToConnedCost";
    
    d() {}
    
    public void a(long paramLong)
    {
      if (paramLong > 0L) {
        a("dim.msf.ServiceInitToConnedCost", true, paramLong, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a
 * JD-Core Version:    0.7.0.1
 */