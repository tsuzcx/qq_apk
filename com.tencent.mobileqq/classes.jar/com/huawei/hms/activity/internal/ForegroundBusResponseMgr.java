package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr
{
  private static final ForegroundBusResponseMgr a = new ForegroundBusResponseMgr();
  private final Map<String, BusResponseCallback> b = new HashMap();
  
  public static ForegroundBusResponseMgr getInstance()
  {
    return a;
  }
  
  public BusResponseCallback get(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.b)
    {
      paramString = (BusResponseCallback)this.b.get(paramString);
      return paramString;
    }
  }
  
  public void registerObserver(String paramString, BusResponseCallback paramBusResponseCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBusResponseCallback == null)) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.containsKey(paramString)) {
        this.b.put(paramString, paramBusResponseCallback);
      }
      return;
    }
  }
  
  public void unRegisterObserver(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.b)
    {
      this.b.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.activity.internal.ForegroundBusResponseMgr
 * JD-Core Version:    0.7.0.1
 */