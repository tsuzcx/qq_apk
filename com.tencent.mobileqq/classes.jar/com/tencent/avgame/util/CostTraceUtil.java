package com.tencent.avgame.util;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class CostTraceUtil
{
  private static CostTraceUtil a;
  private String b = null;
  private ConcurrentHashMap<String, Long> c = null;
  
  public static CostTraceUtil a()
  {
    if (a == null) {
      try
      {
        a = new CostTraceUtil();
      }
      finally {}
    }
    return a;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
    paramString = this.c;
    if (paramString == null)
    {
      this.c = new ConcurrentHashMap(5);
      return;
    }
    paramString.clear();
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(this.b)))
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = paramIntent.getLongExtra("key_start_time", 0L);
      if (l2 != 0L)
      {
        paramIntent = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append("]");
        QLog.i(paramIntent, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((this.c != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = SystemClock.elapsedRealtime();
      this.c.put(paramString, Long.valueOf(l));
    }
  }
  
  public void c(String paramString)
  {
    if ((this.c != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l1 = SystemClock.elapsedRealtime();
      Object localObject = (Long)this.c.get(paramString);
      if (localObject != null)
      {
        long l2 = ((Long)localObject).longValue();
        localObject = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(l1 - l2);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      this.c.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.CostTraceUtil
 * JD-Core Version:    0.7.0.1
 */