package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr
{
  private static final ForegroundBusResponseMgr instance = new ForegroundBusResponseMgr();
  private final Map<String, BusResponseCallback> callbackMap = new HashMap();
  
  public static ForegroundBusResponseMgr getInstance()
  {
    return instance;
  }
  
  public BusResponseCallback get(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.callbackMap)
    {
      paramString = (BusResponseCallback)this.callbackMap.get(paramString);
      return paramString;
    }
  }
  
  public void registerObserver(String paramString, BusResponseCallback paramBusResponseCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBusResponseCallback == null) {
        return;
      }
      synchronized (this.callbackMap)
      {
        if (!this.callbackMap.containsKey(paramString)) {
          this.callbackMap.put(paramString, paramBusResponseCallback);
        }
        return;
      }
    }
  }
  
  public void unRegisterObserver(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.callbackMap)
    {
      this.callbackMap.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.activity.internal.ForegroundBusResponseMgr
 * JD-Core Version:    0.7.0.1
 */