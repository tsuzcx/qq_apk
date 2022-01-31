package com.tencent.ad.tangram.log;

import android.support.annotation.Keep;
import android.util.Log;
import java.lang.ref.WeakReference;

@Keep
public enum AdLog
{
  INSTANCE;
  
  private WeakReference<AdLogAdapter> adapter;
  
  private AdLog() {}
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AdLogAdapter localAdLogAdapter = getAdapter();
    if (localAdLogAdapter != null)
    {
      localAdLogAdapter.d(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AdLogAdapter localAdLogAdapter = getAdapter();
    if (localAdLogAdapter != null)
    {
      localAdLogAdapter.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  private static AdLogAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdLogAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AdLogAdapter localAdLogAdapter = getAdapter();
    if (localAdLogAdapter != null)
    {
      localAdLogAdapter.i(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void setAdapter(WeakReference<AdLogAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AdLogAdapter localAdLogAdapter = getAdapter();
    if (localAdLogAdapter != null)
    {
      localAdLogAdapter.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.log.AdLog
 * JD-Core Version:    0.7.0.1
 */