package com.tencent.ilivesdk.charmservice_interface.model;

public class CharmInfoReq
{
  public int fromType;
  public long uin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(" fromType:");
    localStringBuilder.append(this.fromType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.charmservice_interface.model.CharmInfoReq
 * JD-Core Version:    0.7.0.1
 */