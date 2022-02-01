package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;

class OnLinePushMessageProcessor$HandleShMsgTypeTroopSytemMessage
{
  private MsgInfo b;
  private int c;
  private int d;
  private int e;
  private long f;
  private long g;
  
  public OnLinePushMessageProcessor$HandleShMsgTypeTroopSytemMessage(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    this.b = paramMsgInfo;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramLong1;
    this.g = paramLong2;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public long c()
  {
    return this.g;
  }
  
  public HandleShMsgTypeTroopSytemMessage d()
  {
    ((QQAppInterface)this.a.q).getMsgHandler().B().a(3);
    if (this.c != 45)
    {
      ((QQAppInterface)this.a.q).getMsgHandler().B().a(this.c, this.b.vMsg, this.b.lFromUin, this.b.uMsgTime, null);
      this.g = 9998L;
      this.e = 32769;
      this.d = SystemMsg.getTroopSystemMsgType(this.c);
    }
    GroupSystemMsgController.a().a(this.f, this.b.uMsgTime, (QQAppInterface)this.a.q);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage
 * JD-Core Version:    0.7.0.1
 */