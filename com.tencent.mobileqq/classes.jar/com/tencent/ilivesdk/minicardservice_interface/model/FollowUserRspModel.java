package com.tencent.ilivesdk.minicardservice_interface.model;

public class FollowUserRspModel
{
  public boolean isFans;
  public String msg;
  public long ret;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ret:");
    localStringBuilder.append(this.ret);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(this.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.model.FollowUserRspModel
 * JD-Core Version:    0.7.0.1
 */