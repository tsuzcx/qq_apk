package com.tencent.mobileqq.ark.config.bean;

public abstract class ArkConfBean
{
  protected String a = "";
  
  public ArkConfBean() {}
  
  public ArkConfBean(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public abstract int a();
  
  public String d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.bean.ArkConfBean
 * JD-Core Version:    0.7.0.1
 */