package com.tencent.falco.base.libapi.crash;

public abstract interface CrashInterface$CrashAdapter
{
  public abstract String crashAppId();
  
  public abstract String getDeviceId();
  
  public abstract String getVersion();
  
  public abstract String liveAppId();
  
  public abstract void onCrashHandleStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.crash.CrashInterface.CrashAdapter
 * JD-Core Version:    0.7.0.1
 */