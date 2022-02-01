package com.tencent.mobileqq.activity.recent.msg;

public class StringMsgDeserialize
  implements MsgDeserialize<String>
{
  public String b(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.StringMsgDeserialize
 * JD-Core Version:    0.7.0.1
 */