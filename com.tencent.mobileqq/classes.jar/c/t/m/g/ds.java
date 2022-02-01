package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

public final class ds
{
  private static ConcurrentHashMap<String, HandlerThread> a = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  
  public static HandlerThread a(@NonNull String paramString)
  {
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      boolean bool = b.containsKey(paramString);
      if (!bool) {
        return;
      }
      int i = ((Integer)b.get(paramString)).intValue() - 1;
      if (i == 0)
      {
        b.remove(paramString);
        HandlerThread localHandlerThread = (HandlerThread)a.remove(paramString);
        l = paramLong;
        if (c.containsKey(paramString)) {
          l = Math.max(paramLong, ((Long)c.remove(paramString)).longValue() - System.currentTimeMillis());
        }
        dt.a(localHandlerThread, null, l);
        return;
      }
      b.put(paramString, Integer.valueOf(i));
      long l = 0L;
      if (paramLong != 0L)
      {
        if (c.containsKey(paramString)) {
          l = ((Long)c.get(paramString)).longValue();
        }
        c.put(paramString, Long.valueOf(Math.max(System.currentTimeMillis() + paramLong, l)));
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, Runnable paramRunnable)
  {
    try
    {
      Handler localHandler = new Handler(a(paramString).getLooper());
      if (co.a(localHandler)) {
        localHandler.postDelayed(paramRunnable, 0L);
      }
      a(paramString, 0L);
      return;
    }
    finally {}
  }
  
  private static HandlerThread b(@NonNull String paramString)
  {
    try
    {
      HandlerThread localHandlerThread = (HandlerThread)a.get(paramString);
      if (localHandlerThread == null)
      {
        localHandlerThread = new HandlerThread(paramString, 0);
        localHandlerThread.start();
        a.put(paramString, localHandlerThread);
        b.put(paramString, Integer.valueOf(1));
        paramString = localHandlerThread;
      }
      else
      {
        b.put(paramString, Integer.valueOf(((Integer)b.get(paramString)).intValue() + 1));
        paramString = localHandlerThread;
      }
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ds
 * JD-Core Version:    0.7.0.1
 */