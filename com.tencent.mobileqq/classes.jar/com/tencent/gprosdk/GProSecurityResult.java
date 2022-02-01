package com.tencent.gprosdk;

public final class GProSecurityResult
{
  final long mActionCode;
  final boolean mIsValidSecResult;
  final String mStrDetail;
  final String mStrPrompt;
  
  public GProSecurityResult(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    this.mIsValidSecResult = paramBoolean;
    this.mActionCode = paramLong;
    this.mStrPrompt = paramString1;
    this.mStrDetail = paramString2;
  }
  
  public long getActionCode()
  {
    return this.mActionCode;
  }
  
  public boolean getIsValidSecResult()
  {
    return this.mIsValidSecResult;
  }
  
  public String getStrDetail()
  {
    return this.mStrDetail;
  }
  
  public String getStrPrompt()
  {
    return this.mStrPrompt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProSecurityResult{mIsValidSecResult=");
    localStringBuilder.append(this.mIsValidSecResult);
    localStringBuilder.append(",mActionCode=");
    localStringBuilder.append(this.mActionCode);
    localStringBuilder.append(",mStrPrompt=");
    localStringBuilder.append(this.mStrPrompt);
    localStringBuilder.append(",mStrDetail=");
    localStringBuilder.append(this.mStrDetail);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProSecurityResult
 * JD-Core Version:    0.7.0.1
 */