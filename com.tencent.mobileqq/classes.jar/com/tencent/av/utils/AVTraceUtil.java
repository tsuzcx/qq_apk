package com.tencent.av.utils;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class AVTraceUtil
{
  private static final Map<String, Long> a = new HashMap(5);
  private static final Map<String, Long> b = new HashMap(5);
  
  public static void a(String paramString1, String paramString2, int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      long l2 = SystemClock.elapsedRealtime();
      long l1 = 0L;
      Object localObject1 = (Long)b.get(paramString1);
      if ((paramInt != 1) && (localObject1 != null))
      {
        l1 = l2 - ((Long)localObject1).longValue();
        b.put(paramString1, Long.valueOf(l2));
      }
      else
      {
        a.put(paramString1, Long.valueOf(l2));
        b.put(paramString1, Long.valueOf(l2));
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject1 = new StringBuilder(100);
        ((StringBuilder)localObject1).append("[");
        int k = paramVarArgs.length;
        int i = 0;
        int j = 0;
        while (i < k)
        {
          Object localObject2 = paramVarArgs[i];
          if (j > 0) {
            ((StringBuilder)localObject1).append(",");
          }
          ((StringBuilder)localObject1).append(localObject2);
          j += 1;
          i += 1;
        }
        ((StringBuilder)localObject1).append("]");
        paramVarArgs = ((StringBuilder)localObject1).toString();
      }
      else
      {
        paramVarArgs = "[]";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("--");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("--");
      ((StringBuilder)localObject1).append(paramVarArgs);
      ((StringBuilder)localObject1).append("--");
      ((StringBuilder)localObject1).append(l1);
      QLog.i("AVTraceUtil", 2, ((StringBuilder)localObject1).toString());
      if (paramInt == 2)
      {
        paramVarArgs = (Long)a.get(paramString1);
        paramString2 = paramVarArgs;
        if (paramVarArgs == null) {
          paramString2 = Long.valueOf(l2);
        }
        l1 = paramString2.longValue();
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(": ");
        paramString2.append(l2 - l1);
        QLog.i("AVTraceUtil", 2, paramString2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVTraceUtil
 * JD-Core Version:    0.7.0.1
 */