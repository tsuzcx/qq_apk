package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static Map<String, d> a = new ConcurrentHashMap(16);
  private static final Object b = new Object();
  
  public static d a(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    synchronized (b)
    {
      int i = paramGrsBaseInfo.uniqueCode();
      Object localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(i);
      localObject2 = (d)((Map)localObject2).get(localStringBuilder.toString());
      if (localObject2 != null)
      {
        if (((d)localObject2).a(new d(paramGrsBaseInfo))) {
          return localObject2;
        }
        paramGrsBaseInfo = new d(paramContext, paramGrsBaseInfo);
        localObject2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(i);
        ((Map)localObject2).put(localStringBuilder.toString(), paramGrsBaseInfo);
        return paramGrsBaseInfo;
      }
      paramGrsBaseInfo = new d(paramContext, paramGrsBaseInfo);
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(i);
      ((Map)localObject2).put(localStringBuilder.toString(), paramGrsBaseInfo);
      return paramGrsBaseInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.e
 * JD-Core Version:    0.7.0.1
 */