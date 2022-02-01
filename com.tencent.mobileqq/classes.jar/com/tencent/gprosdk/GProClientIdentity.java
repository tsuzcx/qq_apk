package com.tencent.gprosdk;

public final class GProClientIdentity
{
  final int mClientId;
  final String mDesc;
  
  public GProClientIdentity(int paramInt, String paramString)
  {
    this.mClientId = paramInt;
    this.mDesc = paramString;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public String getDesc()
  {
    return this.mDesc;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientIdentity{mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mDesc=");
    localStringBuilder.append(this.mDesc);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProClientIdentity
 * JD-Core Version:    0.7.0.1
 */