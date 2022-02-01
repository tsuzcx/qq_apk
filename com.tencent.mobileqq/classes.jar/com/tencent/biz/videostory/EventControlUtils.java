package com.tencent.biz.videostory;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class EventControlUtils
{
  private static SimpleArrayMap<String, Long> jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap = new SimpleArrayMap();
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private static SimpleArrayMap<String, Timer> b = new SimpleArrayMap();
  
  public static void a(String paramString, long paramLong, EventControlUtils.OnDebounceListener paramOnDebounceListener)
  {
    try
    {
      Object localObject = (Long)jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap.get(paramString);
      long l = SystemClock.elapsedRealtime();
      QLog.i("EventControlUtils", 2, "currentTime" + l);
      if ((localObject != null) && (l - ((Long)localObject).longValue() < paramLong))
      {
        LogUtils.w("EventControlUtils", "throttling in timeInterval" + paramLong);
        return;
      }
      jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap.put(paramString, Long.valueOf(l));
      localObject = (Timer)b.get(paramString);
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
      localObject = new Timer();
      ((Timer)localObject).schedule(new EventControlUtils.1(paramOnDebounceListener), paramLong);
      b.put(paramString, localObject);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.EventControlUtils
 * JD-Core Version:    0.7.0.1
 */