package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgResp;

class MessageHandler$HandleSendTroopMessageRespPBFail
{
  private boolean b;
  private ToServiceMsg c;
  private FromServiceMsg d;
  private String e;
  private msg_svc.PbSendMsgResp f;
  private int g;
  private long h;
  private long i;
  private boolean j;
  private Object[] k;
  private int l;
  
  public MessageHandler$HandleSendTroopMessageRespPBFail(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, msg_svc.PbSendMsgResp paramPbSendMsgResp, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean, Object[] paramArrayOfObject, int paramInt2)
  {
    this.c = paramToServiceMsg;
    this.d = paramFromServiceMsg;
    this.e = paramString;
    this.f = paramPbSendMsgResp;
    this.g = paramInt1;
    this.h = paramLong1;
    this.i = paramLong2;
    this.j = paramBoolean;
    this.k = paramArrayOfObject;
    this.l = paramInt2;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public HandleSendTroopMessageRespPBFail c()
  {
    int m = this.g;
    Object localObject1;
    Object localObject2;
    if ((m == 10) || (m == 34))
    {
      this.j = true;
      localObject1 = this.a.n.getMessageFacade().b(this.e, this.l, this.i);
      localObject2 = this.a;
      if (((MessageHandler)localObject2).a((MessageRecord)localObject1, ((MessageHandler)localObject2).d(this.c)))
      {
        this.a.c(this.h);
        this.b = true;
        return this;
      }
    }
    if (this.g == 299)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<---handleSendTroopMessageRespPB MessageRecord send fail uinseq = ");
        ((StringBuilder)localObject1).append(this.i);
        ((StringBuilder)localObject1).append(", msgseq = ");
        ((StringBuilder)localObject1).append(this.h);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.a.n.getMessageFacade().b(this.e, this.l, this.i);
      this.a.c(this.h);
      this.a.n.getMsgCache().b(this.e, 1, this.i);
      long l2 = 0L;
      long l1;
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<---handleSendTroopMessageRespPB MessageRecord send fail, MessageRecord=");
          ((StringBuilder)localObject2).append(((MessageRecord)localObject1).toString());
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
        }
        l2 = ((MessageRecord)localObject1).shmsgseq;
        l1 = ((MessageRecord)localObject1).time;
      }
      for (;;)
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---handleSendTroopMessageRespPB MessageRecord send fail, uniseq not match !");
        }
        localObject1 = this.a.n.getMessageFacade().h(this.e, 1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()) && (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq > 0L))
        {
          l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
          l1 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
        }
        else
        {
          l1 = MessageCache.c();
        }
      }
      localObject1 = new MessageForUniteGrayTip();
      localObject2 = this.e;
      localObject2 = new UniteGrayTipParam((String)localObject2, (String)localObject2, this.k[6].toString(), 1, -5040, 131082, l1);
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.a.n, (UniteGrayTipParam)localObject2);
      ((MessageForUniteGrayTip)localObject1).isread = true;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = l2;
      UniteGrayTipMsgUtil.a(this.a.n, (MessageForUniteGrayTip)localObject1);
    }
    this.a.a(this.c, this.f);
    this.a.a(this.k, this.d.getUin(), this.g);
    this.a.a(3002, false, this.k);
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.HandleSendTroopMessageRespPBFail
 * JD-Core Version:    0.7.0.1
 */