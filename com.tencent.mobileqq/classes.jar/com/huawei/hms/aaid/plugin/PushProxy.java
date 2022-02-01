package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hmf.tasks.Task;

public abstract interface PushProxy
{
  public abstract void deleteToken(Context paramContext);
  
  public abstract int getProxyType();
  
  public abstract void getToken(Context paramContext);
  
  public abstract Task<Void> subscribe(Context paramContext, String paramString);
  
  public abstract Task<Void> turnOff(Context paramContext);
  
  public abstract Task<Void> turnOn(Context paramContext);
  
  public abstract Task<Void> unsubscribe(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.plugin.PushProxy
 * JD-Core Version:    0.7.0.1
 */