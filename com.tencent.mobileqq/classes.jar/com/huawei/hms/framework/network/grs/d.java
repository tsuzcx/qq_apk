package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static Map<String, c> a = new ConcurrentHashMap(16);
  private static final Object b = new Object();
  
  public static c a(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    int i;
    synchronized (b)
    {
      i = paramGrsBaseInfo.uniqueCode();
      c localc = (c)a.get(paramContext.getPackageName() + i);
      if (localc != null)
      {
        if (localc.a(new c(paramGrsBaseInfo))) {
          return localc;
        }
        paramGrsBaseInfo = new c(paramContext, paramGrsBaseInfo);
        a.put(paramContext.getPackageName() + i, paramGrsBaseInfo);
        return paramGrsBaseInfo;
      }
    }
    paramGrsBaseInfo = new c(paramContext, paramGrsBaseInfo);
    a.put(paramContext.getPackageName() + i, paramGrsBaseInfo);
    return paramGrsBaseInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d
 * JD-Core Version:    0.7.0.1
 */