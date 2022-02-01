package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.g;
import com.tencent.mobileqq.msf.core.a.g.a;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.ak.f;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.core.net.x;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.util.HashMap;

public class a
  extends c
  implements ak.f
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
      if (ak.a().b() != null)
      {
        ak.a().a(this);
        QLog.i("ConnQualityStat", 1, ak.a().b().toString());
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeaknetNew enable=");
      localStringBuilder.append(a);
      QLog.d("ConnQualityStat", 1, localStringBuilder.toString());
    }
  }
  
  public static a a()
  {
    return a.a.a();
  }
  
  public static boolean b()
  {
    return (a) && (ak.a().c());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong, x paramx)
  {
    if (a) {
      try
      {
        ak.a().a(paramInt, paramLong, paramx);
      }
      catch (Exception paramx)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpenFailed", paramx);
      }
    }
    a.c.a().a(false);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a) {
      try
      {
        ak.a().a(paramLong1, paramLong2);
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ConnQualityStat", 1, "onPingRecved", localException);
      }
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (a) {
      try
      {
        ak.a().a(parama);
      }
      catch (Exception parama)
      {
        QLog.w("ConnQualityStat", 1, "onConnClose", parama);
      }
    }
    a.c.a().a(false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (a) {
      try
      {
        ak.a().a(paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onPingSent", paramToServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (a) {
      try
      {
        ak.a().a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onRecvRespPkg", paramToServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, f paramf)
  {
    if (a) {
      try
      {
        ak.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onQuickSendResp", paramToServiceMsg);
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvSendChatMsgResp ssoReq=");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" weaknet=");
      localStringBuilder.append(b());
      localStringBuilder.append(" cross=");
      localStringBuilder.append(b);
      localStringBuilder.append(" xgSent=");
      localStringBuilder.append(bool);
      QLog.d("ConnQualityStat", 2, localStringBuilder.toString());
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
          ak.a().a(paramToServiceMsg, paramFromServiceMsg, paramBoolean, 0);
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
    if (a) {
      try
      {
        ak.a().a(paramToServiceMsg, paramBoolean);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onSendReqPkg", paramToServiceMsg);
      }
    }
  }
  
  public void a(Socket paramSocket, int paramInt1, int paramInt2)
  {
    if (a) {
      try
      {
        if (NetConnInfoCenter.isWifiConn()) {
          ak.a().a(paramSocket, paramInt2);
        } else {
          ak.a().b(paramSocket, paramInt2);
        }
      }
      catch (Exception paramSocket)
      {
        QLog.w("ConnQualityStat", 1, "onConnOpened", paramSocket);
      }
    }
    if (MsfService.serviceInitStart > 0L)
    {
      if (QLog.isColorLevel())
      {
        paramSocket = new StringBuilder();
        paramSocket.append("onConnOpened netType: ");
        paramSocket.append(paramInt1);
        paramSocket.append(" serviceInit: ");
        paramSocket.append(MsfService.serviceInitStart);
        paramSocket.append(" cost:");
        paramSocket.append(SystemClock.elapsedRealtime() - MsfService.serviceInitStart);
        QLog.d("ConnQualityStat", 2, paramSocket.toString());
      }
      paramSocket = new a.d(this);
      paramSocket.a("netType", String.valueOf(paramInt1));
      paramSocket.a("cost", String.valueOf(SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
      paramSocket.a(SystemClock.elapsedRealtime() - MsfService.serviceInitStart);
      MsfService.serviceInitStart = 0L;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a) {
      try
      {
        ak.a().a(paramBoolean);
      }
      catch (Exception localException)
      {
        QLog.w("ConnQualityStat", 1, "onScreenOn", localException);
      }
    }
    if (paramBoolean)
    {
      long l = SystemClock.uptimeMillis();
      if (l - f >= 15000L) {
        f = l;
      }
    }
    try
    {
      if ((i.a().e()) && (MsfCore.sCore.quicksender != null)) {
        MsfCore.sCore.quicksender.a(2000L);
      } else {
        MsfCore.sCore.sender.g();
      }
      MsfCore.sCore.screenOn();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b(int paramInt) {}
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (a) {
      try
      {
        ak.a().b(paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onSendChatMsg", paramToServiceMsg);
      }
    }
  }
  
  public void c()
  {
    if (a) {
      ak.a().d();
    }
    a.c.a().a(false);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (a) {
      try
      {
        ak.a().c(paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("ConnQualityStat", 1, "onQuickSendReqBefore", paramToServiceMsg);
      }
    }
  }
  
  public void d()
  {
    if (a) {
      try
      {
        ak.a().e();
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ConnQualityStat", 1, "onScreenOff", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a
 * JD-Core Version:    0.7.0.1
 */