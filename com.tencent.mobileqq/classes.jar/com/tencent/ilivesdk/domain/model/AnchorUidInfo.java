package com.tencent.ilivesdk.domain.model;

public class AnchorUidInfo
{
  public String businessUid;
  public int clientType;
  public long uid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AnchorUidInfo:uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(";businessUid=");
    localStringBuilder.append(this.businessUid);
    localStringBuilder.append(":clientType=");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.model.AnchorUidInfo
 * JD-Core Version:    0.7.0.1
 */