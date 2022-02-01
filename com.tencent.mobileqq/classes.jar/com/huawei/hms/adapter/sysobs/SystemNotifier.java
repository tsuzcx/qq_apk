package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public abstract interface SystemNotifier
{
  public abstract void notifyObservers(int paramInt);
  
  public abstract void notifyObservers(Intent paramIntent, String paramString);
  
  public abstract void registerObserver(SystemObserver paramSystemObserver);
  
  public abstract void unRegisterObserver(SystemObserver paramSystemObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.sysobs.SystemNotifier
 * JD-Core Version:    0.7.0.1
 */