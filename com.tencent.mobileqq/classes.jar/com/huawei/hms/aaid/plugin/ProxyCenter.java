package com.huawei.hms.aaid.plugin;

public class ProxyCenter
{
  public PushProxy proxy;
  
  public static ProxyCenter getInstance()
  {
    return ProxyCenter.a.a();
  }
  
  public static PushProxy getProxy()
  {
    return getInstance().proxy;
  }
  
  public static void register(PushProxy paramPushProxy)
  {
    getInstance().proxy = paramPushProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.aaid.plugin.ProxyCenter
 * JD-Core Version:    0.7.0.1
 */