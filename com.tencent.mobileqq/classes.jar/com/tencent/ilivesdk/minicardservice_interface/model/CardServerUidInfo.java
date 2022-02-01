package com.tencent.ilivesdk.minicardservice_interface.model;

public class CardServerUidInfo
{
  public String businessUid;
  public long uid;
  
  public CardServerUidInfo(long paramLong, String paramString)
  {
    this.uid = paramLong;
    this.businessUid = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniCardUidInfo:uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(";businessUid=");
    localStringBuilder.append(this.businessUid);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.CardServerUidInfo
 * JD-Core Version:    0.7.0.1
 */