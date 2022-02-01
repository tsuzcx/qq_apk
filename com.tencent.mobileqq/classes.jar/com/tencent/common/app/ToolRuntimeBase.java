package com.tencent.common.app;

import abex;
import android.annotation.TargetApi;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import rbc;

public class ToolRuntimeBase
  extends PluginRuntime
{
  static final int ACTION_CLEAR_CACHE = 2;
  static final int ACTION_DEFAULT = 0;
  static final int ACTION_KILL_PROCESS = 3;
  static final int ACTION_RELEASE_LARGE_CACHE = 1;
  static final String TAG = "ToolRuntimeBase";
  ComponentCallbacks componentCallbacks;
  long mLastTrimTime;
  
  void clearCache(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.mLastTrimTime) < 2000L) {}
    MQLruCache localMQLruCache;
    do
    {
      return;
      this.mLastTrimTime = l;
      if (QLog.isColorLevel()) {
        QLog.d("ToolRuntimeBase", 2, "clearCache, " + paramInt);
      }
      localMQLruCache = BaseApplicationImpl.sImageCache;
    } while (localMQLruCache == null);
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      localMQLruCache.releaseLargeCache();
      return;
    case 2: 
      localMQLruCache.evictAll();
      return;
    }
    localMQLruCache.evictAll();
  }
  
  @TargetApi(14)
  public void exitToolProc()
  {
    QIPCClientHelper.getInstance().disconnect();
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.componentCallbacks != null) {
        getApplication().unregisterComponentCallbacks(this.componentCallbacks);
      }
      super.exitToolProc();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ToolRuntimeBase", 2, "", localThrowable);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    rbc.a().a(getApplication());
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ToolRuntimeBase", 2, "onTrimMemory, " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      clearCache(0);
      return;
    case 10: 
      clearCache(0);
      return;
    case 15: 
      clearCache(0);
      return;
    case 20: 
      clearCache(1);
      return;
    case 40: 
    case 60: 
      clearCache(2);
      return;
    }
    clearCache(3);
  }
  
  @TargetApi(14)
  public void setAsToolRuntime()
  {
    super.setAsToolRuntime();
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.componentCallbacks == null)
      {
        this.componentCallbacks = new abex(this);
        BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.componentCallbacks);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ToolRuntimeBase", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.ToolRuntimeBase
 * JD-Core Version:    0.7.0.1
 */