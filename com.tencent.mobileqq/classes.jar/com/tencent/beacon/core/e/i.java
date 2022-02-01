package com.tencent.beacon.core.e;

import android.content.Context;
import com.tencent.beacon.core.info.a;
import com.tencent.beacon.core.info.b;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(Context paramContext)
  {
    b localb;
    if (a.get())
    {
      if (d.a()) {
        break label109;
      }
      localb = b.b(paramContext);
      if (localb.a().equals(localb.b())) {
        break label79;
      }
      if (j.c(localb.b(null))) {
        break label69;
      }
      if ((!a.b(paramContext, "android.permission.INTERNET")) || (!a.b(paramContext, "android.permission.ACCESS_NETWORK_STATE"))) {
        a("当前无网络相关权限！");
      }
    }
    return;
    label69:
    throw new IllegalStateException("[strict] Channel未设置！");
    label79:
    throw new IllegalStateException("[strict] AppKey未设置，当前AppKey为默认：" + localb.a());
    label109:
    throw new IllegalStateException("[strict] 实时联调未关闭!正式发布后必须关闭实时联调！");
  }
  
  public static void a(String paramString)
  {
    d.b("[strict] " + paramString, new Object[0]);
    if (!a.get()) {
      return;
    }
    throw new RuntimeException("[strict] " + paramString);
  }
  
  public static void a(Map paramMap)
  {
    if ((a.get()) && (paramMap != null))
    {
      paramMap = new HashMap(paramMap);
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof String)) {
          a("Key必须为String类型!");
        }
        if (!(paramMap.get(localObject) instanceof String)) {
          a("Value必须为String类型!");
        }
        if (((String)paramMap.get(localObject)).getBytes(Charset.forName("UTF-8")).length >= 10240) {
          a("key: " + localObject + "的Value长度超过10K,将被截断!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.i
 * JD-Core Version:    0.7.0.1
 */