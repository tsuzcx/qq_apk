package com.tencent.mobileqq.activity.aio.doodle;

import java.lang.ref.WeakReference;

public class MsgInfo
{
  long a;
  int b;
  long c;
  WeakReference<BaseDoodleMsgLayout> d;
  
  public MsgInfo(long paramLong1, long paramLong2, int paramInt, BaseDoodleMsgLayout paramBaseDoodleMsgLayout)
  {
    this.a = paramLong2;
    this.b = paramInt;
    this.c = paramLong1;
    this.d = new WeakReference(paramBaseDoodleMsgLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.MsgInfo
 * JD-Core Version:    0.7.0.1
 */