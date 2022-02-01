package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class TraceCompat
{
  private static final String TAG = "TraceCompat";
  private static Method sAsyncTraceBeginMethod;
  private static Method sAsyncTraceEndMethod;
  private static Method sIsTagEnabledMethod;
  private static Method sTraceCounterMethod;
  private static long sTraceTagApp;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT < 29)) {
      try
      {
        sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
        sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[] { Long.TYPE });
        sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        sTraceCounterMethod = Trace.class.getMethod("traceCounter", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        return;
      }
      catch (Exception localException)
      {
        Log.i("TraceCompat", "Unable to initialize via reflection.", localException);
      }
    }
  }
  
  public static void beginAsyncSection(@NonNull String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      Trace.beginAsyncSection(paramString, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sAsyncTraceBeginMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp), paramString, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramString)
    {
      label55:
      break label55;
    }
    Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
  }
  
  public static void beginSection(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  public static void endAsyncSection(@NonNull String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      Trace.endAsyncSection(paramString, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sAsyncTraceEndMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp), paramString, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramString)
    {
      label55:
      break label55;
    }
    Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
  }
  
  public static void endSection()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
  
  public static boolean isEnabled()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return Trace.isEnabled();
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      boolean bool = ((Boolean)sIsTagEnabledMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp) })).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
    return false;
  }
  
  public static void setCounter(@NonNull String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      Trace.setCounter(paramString, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sTraceCounterMethod.invoke(null, new Object[] { Long.valueOf(sTraceTagApp), paramString, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramString)
    {
      label56:
      break label56;
    }
    Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.os.TraceCompat
 * JD-Core Version:    0.7.0.1
 */