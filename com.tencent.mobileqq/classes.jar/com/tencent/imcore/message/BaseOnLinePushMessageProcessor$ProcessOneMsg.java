package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.tencent.imcore.message.api.IOnLinePushMessageProcessorService;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class BaseOnLinePushMessageProcessor$ProcessOneMsg
{
  protected boolean a;
  protected FromServiceMsg b;
  protected SvcReqPushMsg c;
  protected String d;
  protected ArrayList<MessageRecord> e;
  protected ArrayList<MsgInfo> f;
  protected ArrayList<DelMsgInfo> g;
  protected long h;
  protected ArrayList<String> i;
  protected MsgInfo j;
  protected boolean k;
  
  public BaseOnLinePushMessageProcessor$ProcessOneMsg(BaseOnLinePushMessageProcessor paramBaseOnLinePushMessageProcessor, BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams paramProcessOneMsgBuildParams)
  {
    this.b = paramProcessOneMsgBuildParams.a;
    this.c = paramProcessOneMsgBuildParams.b;
    this.d = paramProcessOneMsgBuildParams.c;
    this.e = paramProcessOneMsgBuildParams.d;
    this.f = paramProcessOneMsgBuildParams.e;
    this.g = paramProcessOneMsgBuildParams.f;
    this.h = paramProcessOneMsgBuildParams.g;
    this.i = paramProcessOneMsgBuildParams.h;
    this.j = paramProcessOneMsgBuildParams.i;
    this.k = paramProcessOneMsgBuildParams.j;
  }
  
  private void a(int paramInt)
  {
    if ((42 != paramInt) && (83 != paramInt) && (127 != paramInt) && (QLog.isColorLevel())) {
      MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", this.d, this.j.shMsgSeq, String.valueOf(this.h), String.valueOf(this.j.lFromUin));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: ");
      localStringBuilder.append(this.j.lFromUin);
      localStringBuilder.append(" msgInfo.shMsgType: ");
      localStringBuilder.append(this.j.shMsgType);
      localStringBuilder.append(" msgInfo.uRealMsgTime: ");
      localStringBuilder.append(this.j.uRealMsgTime);
      localStringBuilder.append(" msgInfo.shMsgSeq: ");
      localStringBuilder.append(this.j.shMsgSeq);
      localStringBuilder.append(", msgInfo.lMsgUid");
      localStringBuilder.append(this.j.lMsgUid);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Exception paramException)
  {
    paramException.printStackTrace();
    if ((this.j.vMsg != null) && (QLog.isColorLevel()))
    {
      paramException = new StringBuilder();
      paramException.append("~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: ");
      paramException.append(HexUtil.bytes2HexStr(this.j.vMsg));
      QLog.w("Q.msg.BaseMessageProcessor", 2, paramException.toString());
    }
  }
  
  private boolean a(SvcReqPushMsg paramSvcReqPushMsg, ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, int paramInt)
  {
    paramSvcReqPushMsg = BaseOnLinePushMessageProcessor.a(this.l, paramInt, paramMsgInfo, paramSvcReqPushMsg);
    if (paramSvcReqPushMsg != null)
    {
      if (paramSvcReqPushMsg.a != null) {
        paramArrayList.add(paramSvcReqPushMsg.a);
      }
      if (paramSvcReqPushMsg.b) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if ((!this.k) && (this.j.uAppShareID > 0L)) {
      this.i.add(AppShareIDUtil.a(this.j.uAppShareID));
    }
  }
  
  protected void a(ArrayList<MessageRecord> paramArrayList, long paramLong1, MsgInfo paramMsgInfo, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, int paramInt3, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (paramString == null) {
        return;
      }
      MessageRecord localMessageRecord = ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(paramInt2);
      if (paramInt1 == 1006)
      {
        IOnLinePushMessageProcessorService localIOnLinePushMessageProcessorService = (IOnLinePushMessageProcessorService)QRoute.api(IOnLinePushMessageProcessorService.class);
        String str = localIOnLinePushMessageProcessorService.getPhoneNumByUin(this.l.q, String.valueOf(paramLong2));
        localMessageRecord.init(String.valueOf(paramLong1), localIOnLinePushMessageProcessorService.getPhoneNumByUin(this.l.q, String.valueOf(paramLong3)), str, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
      }
      else
      {
        localMessageRecord.init(paramLong1, paramLong3, paramLong2, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
      }
      localMessageRecord.shmsgseq = paramMsgInfo.shMsgSeq;
      localMessageRecord.isread = paramBoolean1;
      localMessageRecord.msgUid = paramMsgInfo.lMsgUid;
      localMessageRecord.msgData = paramArrayOfByte;
      if (paramInt3 > 0) {
        localMessageRecord.setExtraFlag(paramInt3);
      }
      if (!MessageHandlerUtils.a(this.l.q, localMessageRecord, true)) {
        paramArrayList.add(localMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("----------handleC2COnlinePushMsgResp after analysis friendUin: ");
        paramArrayList.append(paramLong3);
        paramArrayList.append(" msgType: ");
        paramArrayList.append(paramInt2);
        paramArrayList.append(" friendType: ");
        paramArrayList.append(paramInt1);
        paramArrayList.append(" shMsgSeq: ");
        paramArrayList.append(paramMsgInfo.shMsgSeq);
        paramArrayList.append(" msgContent: ");
        paramArrayList.append(MessageRecordUtil.a(paramString));
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramArrayList.toString());
      }
    }
  }
  
  boolean a()
  {
    return this.a;
  }
  
  protected boolean a(DelMsgInfo paramDelMsgInfo)
  {
    return true;
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public ProcessOneMsg c()
  {
    try
    {
      int m = this.j.shMsgType;
      long l1 = this.j.lFromUin;
      long l2 = this.j.lFromUin;
      DelMsgInfo localDelMsgInfo = new DelMsgInfo();
      ((IOnLinePushMessageProcessorService)QRoute.api(IOnLinePushMessageProcessorService.class)).changeBuddyOnline(this.l.q, this.j.lFromUin);
      localDelMsgInfo.lFromUin = this.j.lFromUin;
      localDelMsgInfo.shMsgSeq = this.j.shMsgSeq;
      localDelMsgInfo.uMsgTime = this.j.uMsgTime;
      localDelMsgInfo.vMsgCookies = this.j.vMsgCookies;
      this.g.add(localDelMsgInfo);
      a(m);
      boolean bool = OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(m));
      if (bool)
      {
        try
        {
          bool = a(this.c, this.e, this.j, m);
          if (bool)
          {
            this.a = true;
            return this;
          }
          a(this.e, this.h, this.j, 0, -1000, null, null, -1, l1, l2, false, this.k);
        }
        catch (Exception localException1)
        {
          break label240;
        }
      }
      else
      {
        ProcessOneMsg localProcessOneMsg1 = this;
        try
        {
          bool = localProcessOneMsg1.a(localDelMsgInfo);
          if (!bool) {
            break label246;
          }
          return localProcessOneMsg1;
        }
        catch (Exception localException2) {}
      }
      a(localException3);
    }
    catch (Exception localException3) {}
    label240:
    label246:
    ProcessOneMsg localProcessOneMsg2 = this;
    d();
    localProcessOneMsg2.a = false;
    return localProcessOneMsg2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseOnLinePushMessageProcessor.ProcessOneMsg
 * JD-Core Version:    0.7.0.1
 */