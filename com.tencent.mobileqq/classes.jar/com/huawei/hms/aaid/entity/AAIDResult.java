package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

public class AAIDResult
  implements IMessageEntity
{
  private String id;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.AAIDResult
 * JD-Core Version:    0.7.0.1
 */