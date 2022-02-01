package com.huawei.hms.support.api.push;

public class PushException
  extends RuntimeException
{
  public static final String EXCEPTION_SEND_FAILED = "send message failed";
  
  public PushException() {}
  
  public PushException(String paramString)
  {
    super(paramString);
  }
  
  public PushException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public PushException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushException
 * JD-Core Version:    0.7.0.1
 */