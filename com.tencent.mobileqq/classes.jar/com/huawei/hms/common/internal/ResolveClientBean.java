package com.huawei.hms.common.internal;

public class ResolveClientBean
{
  private final int clientKey;
  private final AnyClient mClient;
  private int minSdkVersion;
  
  public ResolveClientBean(AnyClient paramAnyClient, int paramInt)
  {
    this.mClient = paramAnyClient;
    this.clientKey = Objects.hashCode(new Object[] { paramAnyClient });
    this.minSdkVersion = paramInt;
  }
  
  public void clientReconnect()
  {
    this.mClient.connect(this.minSdkVersion, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof ResolveClientBean)))
    {
      paramObject = (ResolveClientBean)paramObject;
      return this.mClient.equals(paramObject.mClient);
    }
    return false;
  }
  
  public AnyClient getClient()
  {
    return this.mClient;
  }
  
  public int hashCode()
  {
    return this.clientKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.ResolveClientBean
 * JD-Core Version:    0.7.0.1
 */