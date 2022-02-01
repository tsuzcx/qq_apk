package com.huawei.hms.support.api.client;

public class SubAppInfo
{
  private String a;
  
  public SubAppInfo(SubAppInfo paramSubAppInfo)
  {
    if (paramSubAppInfo != null) {
      this.a = paramSubAppInfo.getSubAppID();
    }
  }
  
  public SubAppInfo(String paramString)
  {
    this.a = paramString;
  }
  
  public String getSubAppID()
  {
    return this.a;
  }
  
  public void setSubAppID(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.SubAppInfo
 * JD-Core Version:    0.7.0.1
 */