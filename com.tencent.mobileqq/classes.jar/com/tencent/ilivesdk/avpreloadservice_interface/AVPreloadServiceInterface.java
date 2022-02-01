package com.tencent.ilivesdk.avpreloadservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface AVPreloadServiceInterface
  extends ServiceBaseInterface
{
  public abstract void a(AVPreloadServiceAdapter paramAVPreloadServiceAdapter);
  
  public abstract void a(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener);
  
  public abstract void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes);
  
  public abstract boolean a(String paramString);
  
  public abstract void b();
  
  public abstract void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener);
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void c(String paramString);
  
  public abstract void d(String paramString);
  
  public abstract void e(String paramString);
  
  public abstract boolean f(String paramString);
  
  public abstract String g(String paramString);
  
  public abstract String h(String paramString);
  
  public abstract AVPreloadTaskInterface j(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface
 * JD-Core Version:    0.7.0.1
 */