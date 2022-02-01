package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.message.ProcessorObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public abstract class BaseMessageProcessor
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  public static int e = 5;
  public static int f = 6;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  public static int j = 1;
  public static int k = 2;
  public static int l = 3;
  public static int m = -1;
  public static int n = -2;
  public static int o = 1;
  public static int p = 2;
  private static BaseMessageProcessor.Callback u;
  protected AppInterface q;
  protected BaseMessageHandler r;
  protected IMessageFacade s;
  private List<ProcessorObserver> t = new ArrayList();
  
  static {}
  
  public BaseMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    this.q = paramAppInterface;
    this.r = paramBaseMessageHandler;
    if (paramAppInterface.isLogin()) {
      this.s = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, ""));
    }
  }
  
  private Boolean a(List<msg_comm.Msg> paramList, Boolean paramBoolean, StringBuilder paramStringBuilder, Set<String> paramSet, msg_comm.Msg paramMsg)
  {
    if (!paramMsg.msg_head.has()) {
      return paramBoolean;
    }
    String str = a(paramMsg);
    if (paramSet.contains(str))
    {
      paramList = Boolean.valueOf(true);
      paramBoolean = paramList;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("< duplicatedMsg:");
        paramStringBuilder.append(str);
        paramStringBuilder.append(" >");
        return paramList;
      }
    }
    else
    {
      paramSet.add(str);
      paramList.add(paramMsg);
    }
    return paramBoolean;
  }
  
  public static void a(BaseMessageProcessor.Callback paramCallback)
  {
    u = paramCallback;
  }
  
  private void a(SendMessageHandler paramSendMessageHandler)
  {
    int i1 = 0;
    while (i1 < 3)
    {
      long l1;
      if (i1 == 0) {
        l1 = 480000L;
      } else {
        l1 = (3 - i1) * 480000 / 3 - i1 * 2000;
      }
      paramSendMessageHandler.a(480000 * i1 / 3, l1, "period");
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, BaseMessageProcessor.RequestBuilder paramRequestBuilder, long paramLong1, long paramLong2, SendMessageHandler paramSendMessageHandler)
  {
    int i1 = 0;
    while (i1 < 9)
    {
      paramSendMessageHandler.a(new BaseMessageProcessor.1(this, paramRequestBuilder, paramLong1, paramLong2, paramBoolean1, paramBoolean2));
      i1 += 1;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseMessageProcessor.RequestBuilder paramRequestBuilder, long paramLong)
  {
    if (!paramBoolean1)
    {
      paramRequestBuilder = paramRequestBuilder.a();
      if (paramRequestBuilder == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processRequest cmd=");
        localStringBuilder.append(paramRequestBuilder.getServiceCmd());
        localStringBuilder.append(",reqSeq=");
        localStringBuilder.append(paramLong);
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
      a(paramRequestBuilder, paramLong, paramBoolean2, paramBoolean3);
      return true;
    }
    return false;
  }
  
  private MessageCache b()
  {
    return u.a(this);
  }
  
  protected Pair<Boolean, StringBuilder> a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList1.iterator();
      for (paramList1 = localBoolean; localIterator.hasNext(); paramList1 = a(paramList2, paramList1, localStringBuilder, localHashSet, (msg_comm.Msg)localIterator.next())) {}
      return new Pair(paramList1, localStringBuilder);
    }
    return new Pair(localBoolean, null);
  }
  
  public AppInterface a()
  {
    return this.q;
  }
  
  public OnLinePushParamReturnMsg a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return null;
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    return String.valueOf(paramMsg.hashCode());
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.t)
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).b(paramInt, paramBoolean, paramObject);
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(ProcessorObserver paramProcessorObserver)
  {
    synchronized (this.t)
    {
      this.t.add(paramProcessorObserver);
      return;
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramToServiceMsg.extraData.putLong("msgSeq", paramLong);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramToServiceMsg.setNeedRemindSlowNetwork(true);
      }
      this.r.sendPbReq(paramToServiceMsg);
      return;
    }
    this.r.send(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  protected void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt, long paramLong) {}
  
  public void a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.t)
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, List<MessageRecord> arg3, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = MsgProxyUtils.a(???, b());
    synchronized (this.t)
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, i1, paramBoolean2, paramBoolean3);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected void a(List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (!a(localMessageRecord, paramBoolean)) {
          paramArrayList.add(localMessageRecord);
        }
      }
    }
  }
  
  public void a(msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "sendMsgReadConfirm");
    }
    a(true, true, false, 0L, new BaseMessageProcessor.3(this, paramPbMsgReadedReportReq));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, BaseMessageProcessor.RequestBuilder paramRequestBuilder)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      int i1 = MobileQQService.seq;
      MobileQQService.seq = i1 + 1;
      l1 = i1;
    }
    paramLong = System.currentTimeMillis();
    if (a(paramBoolean1, paramBoolean2, paramBoolean3, paramRequestBuilder, l1)) {
      return;
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    this.r.a(l1, localSendMessageHandler);
    a(paramBoolean2, paramBoolean3, paramRequestBuilder, l1, paramLong, localSendMessageHandler);
    a(localSendMessageHandler);
  }
  
  protected boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return u.a(this.q, paramMessageRecord, paramBoolean);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.t)
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).c(paramInt, paramBoolean, paramObject);
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessor
 * JD-Core Version:    0.7.0.1
 */