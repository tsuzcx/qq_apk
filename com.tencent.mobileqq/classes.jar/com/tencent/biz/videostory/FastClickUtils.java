package com.tencent.biz.videostory;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;

public final class FastClickUtils
{
  private static Pair<String, Long> a;
  public static HashMap<String, Long> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_AndroidUtilPair = null;
  }
  
  public static boolean a(@NonNull String paramString)
  {
    if ((jdField_a_of_type_AndroidUtilPair != null) && (TextUtils.equals(paramString, (CharSequence)jdField_a_of_type_AndroidUtilPair.first))) {}
    long l;
    for (Long localLong = (Long)jdField_a_of_type_AndroidUtilPair.second;; localLong = null)
    {
      l = SystemClock.elapsedRealtime();
      if ((localLong == null) || (l - localLong.longValue() >= 1000L)) {
        break;
      }
      LogUtils.w("FastClickUtils", "fast click ,tag  = " + paramString + ", intervalTime = " + (l - localLong.longValue()));
      return true;
    }
    jdField_a_of_type_AndroidUtilPair = new Pair(paramString, Long.valueOf(l));
    return false;
  }
  
  public static boolean a(@NonNull String paramString, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    Long localLong = (Long)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localLong != null)
    {
      if (jdField_a_of_type_JavaUtilHashMap.size() > 10) {
        jdField_a_of_type_JavaUtilHashMap.clear();
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
      QLog.d("FastClickUtils", 4, "fast click ,tag  = " + paramString + ", currentTime = " + l + " lastTime" + localLong + " intervalTime = " + (l - localLong.longValue()));
      return l - localLong.longValue() < paramLong;
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.FastClickUtils
 * JD-Core Version:    0.7.0.1
 */