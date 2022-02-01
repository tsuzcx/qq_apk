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
    return "[MiniCardUidInfo:uid=" + this.uid + ";businessUid=" + this.businessUid + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.CardServerUidInfo
 * JD-Core Version:    0.7.0.1
 */