package com.tencent;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QCircleCollection
{
  private static volatile HashMap<String, Long> a = new HashMap();
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    a.put(paramString, Long.valueOf(l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" start :");
    localStringBuilder.append(l);
    QLog.d("qcircle_collection", 1, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a.containsKey(paramString1))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)a.get(paramString1)).longValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" cost:");
      localStringBuilder.append(l1 - l2);
      QLog.d("qcircle_collection", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.QCircleCollection
 * JD-Core Version:    0.7.0.1
 */