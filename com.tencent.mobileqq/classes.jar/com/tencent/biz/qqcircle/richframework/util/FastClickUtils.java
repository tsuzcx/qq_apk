package com.tencent.biz.qqcircle.richframework.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class FastClickUtils
{
  public static HashMap<String, Long> a = new HashMap();
  private static Pair<String, Long> b = null;
  
  public static boolean a(@NonNull String paramString)
  {
    Object localObject = b;
    if ((localObject != null) && (TextUtils.equals(paramString, (CharSequence)((Pair)localObject).first))) {
      localObject = (Long)b.second;
    } else {
      localObject = null;
    }
    long l = SystemClock.elapsedRealtime();
    if ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fast click ,tag  = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", intervalTime = ");
      localStringBuilder.append(l - ((Long)localObject).longValue());
      QLog.d("FastClickUtils", 4, localStringBuilder.toString());
      return true;
    }
    b = new Pair(paramString, Long.valueOf(l));
    return false;
  }
  
  public static boolean a(@NonNull String paramString, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (a == null) {
      a = new HashMap();
    }
    Long localLong = (Long)a.get(paramString);
    boolean bool = false;
    if (localLong != null)
    {
      if (a.size() > 10) {
        a.clear();
      }
      a.put(paramString, Long.valueOf(l));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fast click ,tag  = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", currentTime = ");
      localStringBuilder.append(l);
      localStringBuilder.append(" lastTime");
      localStringBuilder.append(localLong);
      localStringBuilder.append(" intervalTime = ");
      localStringBuilder.append(l - localLong.longValue());
      QLog.d("FastClickUtils", 4, localStringBuilder.toString());
      if (l - localLong.longValue() < paramLong) {
        bool = true;
      }
      return bool;
    }
    a.put(paramString, Long.valueOf(l));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.FastClickUtils
 * JD-Core Version:    0.7.0.1
 */