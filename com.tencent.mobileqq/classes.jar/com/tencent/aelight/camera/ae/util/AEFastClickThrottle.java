package com.tencent.aelight.camera.ae.util;

import android.util.LruCache;
import android.view.View;
import androidx.annotation.NonNull;

public final class AEFastClickThrottle
{
  private static final LruCache<String, Long> a = new LruCache(10);
  
  public static boolean a(View paramView)
  {
    Object localObject = paramView.getTag(2064121924);
    long l = System.currentTimeMillis();
    paramView.setTag(2064121924, Long.valueOf(l));
    return ((localObject instanceof Long)) && (Math.abs(l - ((Long)localObject).longValue()) <= 500L);
  }
  
  public static boolean a(@NonNull String paramString)
  {
    Long localLong1 = (Long)a.get(paramString);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    if (localLong1 == null)
    {
      a.put(paramString, localLong2);
      return false;
    }
    if (Math.abs(localLong2.longValue() - localLong1.longValue()) >= 500L)
    {
      a.put(paramString, localLong2);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AEFastClickThrottle
 * JD-Core Version:    0.7.0.1
 */