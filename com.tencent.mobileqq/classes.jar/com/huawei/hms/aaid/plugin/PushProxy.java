package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import org.json.JSONObject;

public abstract interface PushProxy
{
  public abstract void deleteAllToken(Context paramContext);
  
  public abstract void deleteToken(Context paramContext, String paramString1, String paramString2);
  
  public abstract JSONObject getPlatform();
  
  public abstract String getProxyType();
  
  public abstract void getToken(Context paramContext, String paramString1, String paramString2);
  
  public abstract Task<Void> subscribe(Context paramContext, String paramString1, String paramString2);
  
  public abstract Task<Void> turnOff(Context paramContext, String paramString);
  
  public abstract Task<Void> turnOn(Context paramContext, String paramString);
  
  public abstract Task<Void> unsubscribe(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.plugin.PushProxy
 * JD-Core Version:    0.7.0.1
 */