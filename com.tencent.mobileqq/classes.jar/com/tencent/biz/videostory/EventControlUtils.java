package com.tencent.biz.videostory;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class EventControlUtils
{
  private static ConcurrentHashMap<String, Long> a;
  private static SimpleArrayMap<String, Long> b = new SimpleArrayMap();
  private static SimpleArrayMap<String, Timer> c = new SimpleArrayMap();
  
  public static void a(String paramString, long paramLong, EventControlUtils.OnDebounceListener paramOnDebounceListener)
  {
    try
    {
      Object localObject = (Long)b.get(paramString);
      long l = SystemClock.elapsedRealtime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("currentTime");
      localStringBuilder.append(l);
      QLog.i("EventControlUtils", 2, localStringBuilder.toString());
      if ((localObject != null) && (l - ((Long)localObject).longValue() < paramLong))
      {
        paramString = new StringBuilder();
        paramString.append("throttling in timeInterval");
        paramString.append(paramLong);
        LogUtils.w("EventControlUtils", paramString.toString());
        return;
      }
      b.put(paramString, Long.valueOf(l));
      localObject = (Timer)c.get(paramString);
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
      localObject = new Timer();
      ((Timer)localObject).schedule(new EventControlUtils.1(paramOnDebounceListener), paramLong);
      c.put(paramString, localObject);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.EventControlUtils
 * JD-Core Version:    0.7.0.1
 */