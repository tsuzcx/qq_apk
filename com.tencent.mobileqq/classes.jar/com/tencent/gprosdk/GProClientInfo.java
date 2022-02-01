package com.tencent.gprosdk;

public final class GProClientInfo
{
  final int mClientId;
  final String mClientName;
  final GProIdentityInstruction mIdentityInstruction;
  
  public GProClientInfo(int paramInt, String paramString, GProIdentityInstruction paramGProIdentityInstruction)
  {
    this.mClientId = paramInt;
    this.mClientName = paramString;
    this.mIdentityInstruction = paramGProIdentityInstruction;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public String getClientName()
  {
    return this.mClientName;
  }
  
  public GProIdentityInstruction getIdentityInstruction()
  {
    return this.mIdentityInstruction;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientInfo{mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mClientName=");
    localStringBuilder.append(this.mClientName);
    localStringBuilder.append(",mIdentityInstruction=");
    localStringBuilder.append(this.mIdentityInstruction);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProClientInfo
 * JD-Core Version:    0.7.0.1
 */