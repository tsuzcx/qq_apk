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
    return "AdminReason {id=" + this.id + "\ndesc=" + this.desc + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.model.AdminReason
 * JD-Core Version:    0.7.0.1
 */