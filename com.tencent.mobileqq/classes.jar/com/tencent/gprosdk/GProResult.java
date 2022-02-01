package com.tencent.gprosdk;

public final class GProResult
{
  final String mErrMsg;
  final long mMemberTid;
  final int mResult;
  
  public GProResult(long paramLong, int paramInt, String paramString)
  {
    this.mMemberTid = paramLong;
    this.mResult = paramInt;
    this.mErrMsg = paramString;
  }
  
  public String getErrMsg()
  {
    return this.mErrMsg;
  }
  
  public long getMemberTid()
  {
    return this.mMemberTid;
  }
  
  public int getResult()
  {
    return this.mResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProResult{mMemberTid=");
    localStringBuilder.append(this.mMemberTid);
    localStringBuilder.append(",mResult=");
    localStringBuilder.append(this.mResult);
    localStringBuilder.append(",mErrMsg=");
    localStringBuilder.append(this.mErrMsg);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProResult
 * JD-Core Version:    0.7.0.1
 */