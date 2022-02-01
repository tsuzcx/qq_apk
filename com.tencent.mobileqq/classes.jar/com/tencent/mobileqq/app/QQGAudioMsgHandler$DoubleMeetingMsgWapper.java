package com.tencent.mobileqq.app;

import java.util.concurrent.atomic.AtomicBoolean;
import msf.msgcomm.msg_comm.Msg;

class QQGAudioMsgHandler$DoubleMeetingMsgWapper
{
  public long a = 0L;
  public long b = 0L;
  public msg_comm.Msg c = null;
  public AtomicBoolean d = null;
  
  public QQGAudioMsgHandler$DoubleMeetingMsgWapper(msg_comm.Msg paramMsg, long paramLong1, long paramLong2)
  {
    this.c = paramMsg;
    this.a = paramLong1;
    this.b = paramLong2;
    this.d = new AtomicBoolean(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.DoubleMeetingMsgWapper
 * JD-Core Version:    0.7.0.1
 */