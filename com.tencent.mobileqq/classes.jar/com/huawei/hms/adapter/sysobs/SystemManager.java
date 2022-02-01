package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public final class SystemManager
{
  private static SystemManager a = new SystemManager();
  private static final Object b = new Object();
  private static SystemNotifier c = new SystemManager.1();
  
  public static SystemManager getInstance()
  {
    return a;
  }
  
  public static SystemNotifier getSystemNotifier()
  {
    return c;
  }
  
  public void notifyResolutionResult(Intent paramIntent, String paramString)
  {
    c.notifyObservers(paramIntent, paramString);
  }
  
  public void notifyUpdateResult(int paramInt)
  {
    c.notifyObservers(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.sysobs.SystemManager
 * JD-Core Version:    0.7.0.1
 */