package com.tencent.common.app;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
    if (Math.abs(l - this.mLastTrimTime) < 2000L) {
      return;
    }
    this.mLastTrimTime = l;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearCache, ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ToolRuntimeBase", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = GlobalImageCache.a;
    if (localObject == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          ((MQLruCache)localObject).evictAll();
          return;
        }
        ((MQLruCache)localObject).evictAll();
        return;
      }
      ((MQLruCache)localObject).releaseLargeCache();
    }
  }
  
  @TargetApi(14)
  protected void exitToolProc()
  {
    QIPCClientHelper.getInstance().disconnect();
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        if (this.componentCallbacks != null) {
          getApplication().unregisterComponentCallbacks(this.componentCallbacks);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ToolRuntimeBase", 2, "", localThrowable);
        }
      }
    }
    super.exitToolProc();
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTrimMemory, ");
      localStringBuilder.append(paramInt);
      QLog.d("ToolRuntimeBase", 2, localStringBuilder.toString());
    }
    if (paramInt != 5)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15)
        {
          if (paramInt != 20)
          {
            if ((paramInt != 40) && (paramInt != 60))
            {
              if (paramInt != 80) {
                return;
              }
              clearCache(3);
              return;
            }
            clearCache(2);
            return;
          }
          clearCache(1);
          return;
        }
        clearCache(0);
        return;
      }
      clearCache(0);
      return;
    }
    clearCache(0);
  }
  
  @TargetApi(14)
  public void setAsToolRuntime()
  {
    super.setAsToolRuntime();
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        if (this.componentCallbacks == null)
        {
          this.componentCallbacks = new ToolRuntimeBase.1(this);
          BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.componentCallbacks);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ToolRuntimeBase", 2, "", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.ToolRuntimeBase
 * JD-Core Version:    0.7.0.1
 */