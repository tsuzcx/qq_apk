package com.tencent.falco.base.libapi.channel.helper;

public class MsgExtInfo
{
  public MsgSpeed msgSpeed;
  public int msgType;
  public long msgUid;
  
  public String toString()
  {
    return "MsgExtInfo{msgType=" + this.msgType + ", msgUid=" + this.msgUid + ", msgSpeed=" + this.msgSpeed + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.channel.helper.MsgExtInfo
 * JD-Core Version:    0.7.0.1
 */