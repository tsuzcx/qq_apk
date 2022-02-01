package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.g;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.ap;
import com.tencent.mobileqq.msf.core.ap.f;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.util.HashMap;

public class a
  extends c
  implements ap.f
{
  public static final boolean a = ;
  public static boolean b = false;
  public static int c = 0;
  private static final String d = "ConnQualityStat";
  private static final long e = 15000L;
  private static long f = 0L;
  
  private a()
  {
    if (a)
    {
      if (ap.a().b() != null)
      {
        ap.a().a(this);
        QLog.i("ConnQualityStat", 1, ap.a().b().toString());
      }
      return;
    }
    QLog.d("ConnQualityStat", 1, "WeaknetNew enable=" + a);
  }
  
  public static a a()
  {
    return a.a.a();
  }
  
  public static boolean b()
  {
    return (a) && (ap.a().c());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong, x paramx)
  {
    if (a) {}
    try
    {
      ap.a().a(paramInt, paramLong, paramx);
      a.c.a().a(false);
      return;
    }
    catch (Exception paramx)
    {
      for (;;)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpenFailed", paramx);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a) {}
    try
    {
      ap.a().a(paramLong1, paramLong2);
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
      ap.a().a(parama);
      a.c.a().a(false);
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
      ap.a().a(paramToServiceMsg);
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
      ap.a().a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.w("ConnQualityStat", 1, "onRecvRespPkg", paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, f paramf)
  {
    if (a) {}
    try
    {
      ap.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
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
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net_boot"))
    {
      long l = SystemClock.elapsedRealtime() - ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net_boot", Long.valueOf(0L))).longValue();
      if (l > 0L) {
        MsfCore.sCore.getStatReporter().a(l);
      }
    }
    if (a) {
      try
      {
        try
        {
          ap.a().a(paramToServiceMsg, paramFromServiceMsg, paramBoolean, 0);
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
      ap.a().a(paramToServiceMsg, paramBoolean);
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
        ap.a().a(paramSocket, paramInt2);
      }
      for (;;)
      {
        if (MsfService.serviceInitStart > 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConnQualityStat", 2, "onConnOpened netType: " + paramInt1 + " serviceInit: " + MsfService.serviceInitStart + " cost:" + (SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
          }
          paramSocket = new a.d(this);
          if (paramSocket != null)
          {
            paramSocket.a("netType", String.valueOf(paramInt1));
            paramSocket.a("cost", String.valueOf(SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
            paramSocket.a(SystemClock.elapsedRealtime() - MsfService.serviceInitStart);
          }
          MsfService.serviceInitStart = 0L;
        }
        return;
        ap.a().b(paramSocket, paramInt2);
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
      ap.a().a(paramBoolean);
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        if (l - f >= 15000L) {
          f = l;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          MsfCore.sCore.sender.g();
          MsfCore.sCore.screenOn();
          return;
        }
        catch (Throwable localThrowable) {}
        localException = localException;
        QLog.w("ConnQualityStat", 1, "onScreenOn", localException);
      }
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      ap.a().b(paramToServiceMsg);
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
      ap.a().d();
    }
    a.c.a().a(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (a) {}
    try
    {
      ap.a().c(paramToServiceMsg);
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
      ap.a().e();
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ConnQualityStat", 1, "onScreenOff", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a
 * JD-Core Version:    0.7.0.1
 */