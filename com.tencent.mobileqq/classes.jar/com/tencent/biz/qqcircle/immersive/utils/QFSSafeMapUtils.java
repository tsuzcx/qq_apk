package com.tencent.biz.qqcircle.immersive.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QFSSafeMapUtils
{
  public static <K, V> V a(Map<K, V> paramMap, K paramK)
  {
    if (paramMap == null)
    {
      QLog.d("SafeMapOption", 1, "[getVal] map should not be null.");
      return null;
    }
    if (paramK == null)
    {
      QLog.d("SafeMapOption", 1, "[getVal] map key not is null.");
      return null;
    }
    return paramMap.get(paramK);
  }
  
  public static <K, V> void a(Map<K, V> paramMap, K paramK, V paramV)
  {
    if (paramMap == null)
    {
      QLog.d("SafeMapOption", 1, "[put] map should not be null.");
      return;
    }
    if (paramK == null)
    {
      QLog.d("SafeMapOption", 1, "[put] map key not is null.");
      return;
    }
    if (paramV == null)
    {
      QLog.d("SafeMapOption", 1, "[put] map val not is null.");
      return;
    }
    paramMap.put(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSSafeMapUtils
 * JD-Core Version:    0.7.0.1
 */