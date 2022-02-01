package com.tencent.gprosdk;

public final class GProClientAccount
{
  final String mAccountName;
  final String mAccountSecret;
  final GProClientShowCfg mClientConfig;
  final int mClientId;
  final String mClientName;
  
  public GProClientAccount(int paramInt, String paramString1, String paramString2, String paramString3, GProClientShowCfg paramGProClientShowCfg)
  {
    this.mClientId = paramInt;
    this.mClientName = paramString1;
    this.mAccountSecret = paramString2;
    this.mAccountName = paramString3;
    this.mClientConfig = paramGProClientShowCfg;
  }
  
  public String getAccountName()
  {
    return this.mAccountName;
  }
  
  public String getAccountSecret()
  {
    return this.mAccountSecret;
  }
  
  public GProClientShowCfg getClientConfig()
  {
    return this.mClientConfig;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public String getClientName()
  {
    return this.mClientName;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientAccount{mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mClientName=");
    localStringBuilder.append(this.mClientName);
    localStringBuilder.append(",mAccountSecret=");
    localStringBuilder.append(this.mAccountSecret);
    localStringBuilder.append(",mAccountName=");
    localStringBuilder.append(this.mAccountName);
    localStringBuilder.append(",mClientConfig=");
    localStringBuilder.append(this.mClientConfig);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProClientAccount
 * JD-Core Version:    0.7.0.1
 */