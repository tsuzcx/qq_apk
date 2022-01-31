package com.tencent.aekit.plugin.core;

public class AIData
{
  private Object attr;
  private Object lastAttr;
  private Object lock;
  private String moduleName;
  
  public AIData(String paramString, Object paramObject)
  {
    this.moduleName = paramString;
    this.lastAttr = paramObject;
    this.attr = null;
    this.lock = new Object();
  }
  
  public Object getAttr()
  {
    return this.attr;
  }
  
  public Object getLastAttr()
  {
    return this.lastAttr;
  }
  
  public Object getLock()
  {
    return this.lock;
  }
  
  public String getModuleName()
  {
    return this.moduleName;
  }
  
  public void setAttr(Object paramObject)
  {
    this.attr = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIData
 * JD-Core Version:    0.7.0.1
 */