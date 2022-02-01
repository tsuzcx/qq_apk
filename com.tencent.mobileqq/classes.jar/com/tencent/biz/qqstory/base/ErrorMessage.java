package com.tencent.biz.qqstory.base;

import android.annotation.TargetApi;
import com.tencent.mobileqq.app.HardCodeUtil;

@TargetApi(14)
public class ErrorMessage
  extends Error
{
  public static final int NO_ERROR = 0;
  public static final int NO_ERROR_FROM_MSF = 1000;
  public int errorCode;
  public String errorMsg;
  public String extraMsg;
  
  public ErrorMessage()
  {
    this.errorCode = 0;
    this.errorMsg = "";
  }
  
  public ErrorMessage(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramInt == 1000) {
      i = 0;
    }
    this.errorCode = i;
    this.errorMsg = paramString;
  }
  
  public ErrorMessage(ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage != null)
    {
      this.errorCode = paramErrorMessage.errorCode;
      this.errorMsg = paramErrorMessage.errorMsg;
      this.extraMsg = paramErrorMessage.extraMsg;
      return;
    }
    throw new IllegalArgumentException("errorMessage should not be null");
  }
  
  public String getErrorMessage()
  {
    return String.format("%s(%d)", new Object[] { this.errorMsg, Integer.valueOf(this.errorCode) });
  }
  
  public String getErrorMessage(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = HardCodeUtil.a(2131902240);
    }
    return String.format("%s(%d)", new Object[] { str, Integer.valueOf(this.errorCode) });
  }
  
  public String getErrorMessageForReport()
  {
    String str = this.errorMsg;
    return String.format("%d:%s", new Object[] { Integer.valueOf(this.errorCode), str });
  }
  
  public boolean isFail()
  {
    return this.errorCode != 0;
  }
  
  public boolean isSuccess()
  {
    return this.errorCode == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ErrorMessage{errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.errorMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraMsg='");
    localStringBuilder.append(this.extraMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.ErrorMessage
 * JD-Core Version:    0.7.0.1
 */