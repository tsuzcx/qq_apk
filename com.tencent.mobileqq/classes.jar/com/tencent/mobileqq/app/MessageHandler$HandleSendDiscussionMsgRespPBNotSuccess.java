package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;

class MessageHandler$HandleSendDiscussionMsgRespPBNotSuccess
{
  private boolean b;
  private ToServiceMsg c;
  private FromServiceMsg d;
  private msg_svc.PbSendMsgResp e;
  private int f;
  private boolean g;
  private long h;
  private long i;
  private String j;
  private int k;
  
  public MessageHandler$HandleSendDiscussionMsgRespPBNotSuccess(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, msg_svc.PbSendMsgResp paramPbSendMsgResp, int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    this.c = paramToServiceMsg;
    this.d = paramFromServiceMsg;
    this.e = paramPbSendMsgResp;
    this.f = paramInt1;
    this.g = paramBoolean;
    this.h = paramLong1;
    this.i = paramLong2;
    this.j = paramString;
    this.k = paramInt2;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public HandleSendDiscussionMsgRespPBNotSuccess c()
  {
    int m = this.f;
    if ((m == 10) || (m == 34))
    {
      this.g = true;
      localObject1 = this.a.n.getMessageFacade().b(this.j, this.k, this.h);
      localObject2 = this.a;
      if (((MessageHandler)localObject2).a((MessageRecord)localObject1, ((MessageHandler)localObject2).d(this.c)))
      {
        this.a.c(this.i);
        this.b = true;
        return this;
      }
    }
    this.a.a(this.c, this.e);
    Object localObject1 = this.c.extraData;
    Object localObject2 = new Object[6];
    localObject2[0] = ((Bundle)localObject1).getString("uToUin");
    localObject2[1] = Integer.valueOf(3000);
    localObject2[2] = Integer.valueOf(this.f);
    localObject2[3] = this.c.getAttribute("sendmsgHandler");
    localObject2[4] = Long.valueOf(this.c.extraData.getLong("timeOut"));
    localObject2[5] = Long.valueOf(this.h);
    this.a.a((Object[])localObject2, this.d.getUin(), this.f);
    this.a.a(3008, false, localObject2);
    localObject1 = this.e;
    if ((localObject1 != null) && (((msg_svc.PbSendMsgResp)localObject1).errmsg.has()) && (this.e.errmsg.get() != null) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send dicussion msg failed: ");
      ((StringBuilder)localObject1).append(this.e.errmsg.get());
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.HandleSendDiscussionMsgRespPBNotSuccess
 * JD-Core Version:    0.7.0.1
 */