package com.tencent.mobileqq.activity.aio.doodle;

import java.lang.ref.WeakReference;

public class MsgInfo
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  WeakReference<BaseDoodleMsgLayout> jdField_a_of_type_JavaLangRefWeakReference;
  long b;
  
  public MsgInfo(long paramLong1, long paramLong2, int paramInt, BaseDoodleMsgLayout paramBaseDoodleMsgLayout)
  {
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramLong1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseDoodleMsgLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.MsgInfo
 * JD-Core Version:    0.7.0.1
 */