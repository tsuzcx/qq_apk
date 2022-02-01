package com.tencent.ilivesdk.minicardservice_interface.model;

public class QueryFollowRspModel
{
  public boolean isFans;
  public String msg;
  public int ret;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ret:");
    localStringBuilder.append(this.ret);
    localStringBuilder.append(" isFans:");
    localStringBuilder.append(this.isFans);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(this.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.QueryFollowRspModel
 * JD-Core Version:    0.7.0.1
 */