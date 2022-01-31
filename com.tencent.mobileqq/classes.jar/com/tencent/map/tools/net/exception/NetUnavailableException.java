package com.tencent.map.tools.net.exception;

import com.tencent.map.sdk.a.qk;

public class NetUnavailableException
  extends qk
{
  public NetUnavailableException() {}
  
  public NetUnavailableException(String paramString)
  {
    super(paramString);
  }
  
  public NetUnavailableException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetUnavailableException
 * JD-Core Version:    0.7.0.1
 */