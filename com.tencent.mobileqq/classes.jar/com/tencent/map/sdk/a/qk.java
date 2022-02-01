package com.tencent.map.sdk.a;

import java.io.IOException;

public class qk
  extends IOException
{
  public int errorCode;
  public int statusCode;
  
  public qk() {}
  
  public qk(String paramString)
  {
    super(paramString);
  }
  
  public qk(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.qk
 * JD-Core Version:    0.7.0.1
 */