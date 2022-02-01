package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;

class OnLinePushMessageProcessor$HandleShMsgTypeSystemMessage
{
  private long b;
  private MsgInfo c;
  private int d;
  private int e;
  private long f;
  
  public OnLinePushMessageProcessor$HandleShMsgTypeSystemMessage(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, MsgInfo paramMsgInfo, int paramInt)
  {
    this.b = paramLong;
    this.c = paramMsgInfo;
    this.d = paramInt;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public long b()
  {
    return this.f;
  }
  
  public HandleShMsgTypeSystemMessage c()
  {
    ((QQAppInterface)this.a.q).getMsgHandler().B().a(2);
    this.f = 9998L;
    this.e = (-1006 - (this.d - 187));
    ((QQAppInterface)this.a.q).getMsgHandler().B().a(this.b, this.c.lFromUin, this.d, this.e, this.c.uMsgTime, this.c.shMsgSeq);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage
 * JD-Core Version:    0.7.0.1
 */