package com.tencent.ad.tangram.thread;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Keep
public enum AdThreadManager
{
  INSTANCE;
  
  public static final int FILE = 5;
  public static final int MAIN_THREAD = 0;
  public static final int NETWORK = 4;
  public static final int NORMAL = 3;
  private static final String TAG = "AdThreadManager";
  private WeakReference<AdThreadManagerAdapter> adapter;
  private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(0);
  
  private AdThreadManager() {}
  
  private AdThreadManagerAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdThreadManagerAdapter)this.adapter.get();
    }
    return null;
  }
  
  public boolean post(Runnable paramRunnable, int paramInt)
  {
    return postDelayed(paramRunnable, paramInt, 0L);
  }
  
  public boolean postDelayed(Runnable paramRunnable, int paramInt, long paramLong)
  {
    AdThreadManagerAdapter localAdThreadManagerAdapter = getAdapter();
    if (localAdThreadManagerAdapter != null) {
      return localAdThreadManagerAdapter.postDelayed(paramRunnable, paramInt, paramLong);
    }
    if (paramInt == 0) {
      return new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
    }
    try
    {
      this.executorService.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
      return true;
    }
    catch (Throwable paramRunnable)
    {
      AdLog.e("AdThreadManager", "postDelayedOnWorkerThread", paramRunnable);
    }
    return false;
  }
  
  public void setAdapter(WeakReference<AdThreadManagerAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.thread.AdThreadManager
 * JD-Core Version:    0.7.0.1
 */