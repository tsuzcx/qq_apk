package com.tencent.liteav.basic.c;

import java.io.IOException;

public class d
  extends IOException
{
  private static final long serialVersionUID = 2723743254380545567L;
  private final int mErrorCode;
  private final String mErrorMessage;
  
  public d(int paramInt)
  {
    this(paramInt, null);
  }
  
  public d(int paramInt, String paramString)
  {
    this.mErrorCode = paramInt;
    this.mErrorMessage = paramString;
  }
  
  public String getMessage()
  {
    if (this.mErrorMessage != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("EGL error code: ");
      localStringBuilder.append(this.mErrorCode);
      localStringBuilder.append(this.mErrorMessage);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EGL error code: ");
    localStringBuilder.append(this.mErrorCode);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.d
 * JD-Core Version:    0.7.0.1
 */