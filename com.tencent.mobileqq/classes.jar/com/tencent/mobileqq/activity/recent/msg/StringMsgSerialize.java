package com.tencent.mobileqq.activity.recent.msg;

public class StringMsgSerialize
  implements MsgSerialize
{
  public byte[] a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return ((String)paramObject).getBytes();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.StringMsgSerialize
 * JD-Core Version:    0.7.0.1
 */