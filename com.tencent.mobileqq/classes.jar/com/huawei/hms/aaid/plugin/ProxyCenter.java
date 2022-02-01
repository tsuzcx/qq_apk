package com.huawei.hms.aaid.plugin;

public class ProxyCenter
{
  private PushProxy proxy;
  
  public static ProxyCenter getInstance()
  {
    return ProxyCenter.a.a();
  }
  
  public PushProxy getProxy()
  {
    return this.proxy;
  }
  
  public void register(PushProxy paramPushProxy)
  {
    this.proxy = paramPushProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.plugin.ProxyCenter
 * JD-Core Version:    0.7.0.1
 */