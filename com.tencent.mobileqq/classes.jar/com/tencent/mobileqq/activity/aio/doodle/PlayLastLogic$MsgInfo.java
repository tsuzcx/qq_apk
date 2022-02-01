package com.tencent.mobileqq.activity.aio.doodle;

import java.lang.ref.WeakReference;

class PlayLastLogic$MsgInfo
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  WeakReference<DoodleMsgLayout> jdField_a_of_type_JavaLangRefWeakReference;
  long b;
  
  public PlayLastLogic$MsgInfo(PlayLastLogic paramPlayLastLogic, long paramLong1, long paramLong2, int paramInt, DoodleMsgLayout paramDoodleMsgLayout)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramLong1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleMsgLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic.MsgInfo
 * JD-Core Version:    0.7.0.1
 */