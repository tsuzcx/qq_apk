package com.tencent.mobileqq.app.handler.receivesuccess;

import RegisterProxySvcPack.RegisterPushNotice;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgProxyEndResp
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg arg2, Object paramObject)
  {
    if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(???.getServiceCmd()))
    {
      if (!(paramObject instanceof RegisterPushNotice))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd ERROR");
        }
        return;
      }
      paramToServiceMsg = (RegisterPushNotice)paramObject;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("registerproxy->handleRegisterProxyEndResp RegPrxySvc.NoticeEnd endseq=");
        ???.append(paramToServiceMsg.uEndSeq);
        ???.append(",timeoutflag=");
        ???.append(paramToServiceMsg.ulTimeOutFlag);
        QLog.d("Q.msg.MessageHandler", 2, new Object[] { ???.toString(), ", uInterval_forbid_pulldown=", Long.valueOf(paramToServiceMsg.uInterval_forbid_pulldown) });
      }
      long l;
      if (paramToServiceMsg.uEndSeq == paramMessageHandler.e.j)
      {
        l = 0L;
        paramMessageHandler.e.g = new Pair(paramToServiceMsg, Long.valueOf(0L));
        paramMessageHandler.h = SystemClock.uptimeMillis();
        paramMessageHandler.e(paramToServiceMsg.uInterval_forbid_pulldown);
      }
      else
      {
        if (paramToServiceMsg.uEndSeq != paramMessageHandler.e.k) {
          return;
        }
        paramMessageHandler.e.g = new Pair(paramToServiceMsg, Long.valueOf(1L));
        l = 1L;
      }
      if ((paramMessageHandler.e.n != 0) && (paramToServiceMsg.uEndSeq == paramMessageHandler.e.n))
      {
        paramMessageHandler.n.getMsgCache().c(false);
        paramMessageHandler.e.n = 0;
      }
      if (((paramMessageHandler.e.c()) && (paramMessageHandler.e.d())) || (!RegisterProxyHandler.d)) {
        synchronized (paramMessageHandler.e.q)
        {
          if (paramMessageHandler.e.g != null)
          {
            paramMessageHandler.e.g = null;
            if ((l == 1L) || (!paramMessageHandler.g.y()) || (!paramMessageHandler.g.w()))
            {
              paramMessageHandler.f();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "registerproxy->handleMsgProxyEndResp RegPrxySvc.NoticeEnd notify");
              }
              paramMessageHandler.notifyUI(4013, true, new Long[] { Long.valueOf(paramToServiceMsg.ulTimeOutFlag), Long.valueOf(l) });
            }
            paramMessageHandler.e.q.set(true);
            paramMessageHandler.e.q.notifyAll();
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyEndResp
 * JD-Core Version:    0.7.0.1
 */