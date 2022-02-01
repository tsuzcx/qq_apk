package com.tencent.mobileqq.app.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MessageObject
{
  public int a;
  public ToServiceMsg b;
  public FromServiceMsg c;
  public Object d;
  public boolean e;
  
  public MessageObject(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this(paramInt, paramToServiceMsg, paramFromServiceMsg, paramObject, false);
  }
  
  public MessageObject(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramToServiceMsg;
    this.c = paramFromServiceMsg;
    this.d = paramObject;
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.MessageObject
 * JD-Core Version:    0.7.0.1
 */