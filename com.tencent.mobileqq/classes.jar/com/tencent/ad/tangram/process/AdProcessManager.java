package com.tencent.ad.tangram.process;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@Keep
public enum AdProcessManager
{
  INSTANCE;
  
  private static final String TAG = "AdProcessManager";
  private WeakReference<AdProcessManagerAdapter> adapter;
  private volatile String currentProcessName;
  
  private AdProcessManager() {}
  
  private AdProcessManagerAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdProcessManagerAdapter)this.adapter.get();
    }
    return null;
  }
  
  private static String getCurrentProcessNameInternal(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getSystemService("activity");
      if ((paramContext == null) || (!(paramContext instanceof ActivityManager)))
      {
        AdLog.e("AdProcessManager", "getCurrentProcessNameInternal error");
        return null;
      }
      paramContext = ((ActivityManager)ActivityManager.class.cast(paramContext)).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        AdLog.e("AdProcessManager", "getCurrentProcessNameInternal error");
        return null;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == Process.myPid())
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdProcessManager", "getCurrentProcessNameInternal", paramContext);
    }
    return null;
  }
  
  public String getCurrentProcessName(Context paramContext)
  {
    if (TextUtils.isEmpty(this.currentProcessName)) {}
    try
    {
      if (TextUtils.isEmpty(this.currentProcessName)) {
        this.currentProcessName = getCurrentProcessNameInternal(paramContext);
      }
      return this.currentProcessName;
    }
    finally {}
  }
  
  public Boolean isOnMainProcess()
  {
    AdProcessManagerAdapter localAdProcessManagerAdapter = getAdapter();
    if (localAdProcessManagerAdapter != null) {
      return localAdProcessManagerAdapter.isOnMainProcess();
    }
    return null;
  }
  
  public Boolean isOnWebProcess()
  {
    AdProcessManagerAdapter localAdProcessManagerAdapter = getAdapter();
    if (localAdProcessManagerAdapter != null) {
      return localAdProcessManagerAdapter.isOnWebProcess();
    }
    return null;
  }
  
  public Boolean isWebProcessRunning()
  {
    AdProcessManagerAdapter localAdProcessManagerAdapter = getAdapter();
    if (localAdProcessManagerAdapter != null) {
      return localAdProcessManagerAdapter.isWebProcessRunning();
    }
    return null;
  }
  
  public Boolean isWebProcessRunningForPreloading()
  {
    AdProcessManagerAdapter localAdProcessManagerAdapter = getAdapter();
    if (localAdProcessManagerAdapter != null) {
      return localAdProcessManagerAdapter.isWebProcessRunningForPreloading();
    }
    return null;
  }
  
  public void setAdapter(WeakReference<AdProcessManagerAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.process.AdProcessManager
 * JD-Core Version:    0.7.0.1
 */