package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.pb.MessageMicro;

public class ResponseBean
{
  public long a = 0L;
  public String b = "";
  public MessageMicro c;
  public boolean d = false;
  
  public ResponseBean(long paramLong, String paramString, MessageMicro paramMessageMicro, boolean paramBoolean)
  {
    this.a = paramLong;
    this.b = paramString;
    this.c = paramMessageMicro;
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.ResponseBean
 * JD-Core Version:    0.7.0.1
 */