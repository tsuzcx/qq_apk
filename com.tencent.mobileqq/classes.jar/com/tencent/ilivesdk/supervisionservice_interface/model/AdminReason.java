package com.tencent.ilivesdk.supervisionservice_interface.model;

public class AdminReason
{
  public String desc;
  public int id;
  
  public AdminReason(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.desc = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdminReason {id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append("\ndesc=");
    localStringBuilder.append(this.desc);
    localStringBuilder.append("\n}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.AdminReason
 * JD-Core Version:    0.7.0.1
 */