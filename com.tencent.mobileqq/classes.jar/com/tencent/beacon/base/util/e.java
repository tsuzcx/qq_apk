package com.tencent.beacon.base.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.c.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(Context paramContext)
  {
    if ((a.get()) && ((!b.b(paramContext, "android.permission.INTERNET")) || (!b.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")))) {
      a("当前无网络相关权限！");
    }
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[strict]  ");
    localStringBuilder.append(paramString);
    c.b(localStringBuilder.toString(), new Object[0]);
    if (!a.get()) {
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[strict] ");
    localStringBuilder.append(paramString);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static void a(Map paramMap)
  {
    if ((a.get()) && (paramMap != null))
    {
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
      }
    }
  }
  
  public static boolean a(String paramString, Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof String)) {
      bool = TextUtils.isEmpty((String)paramObject);
    } else if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    if (paramObject == null) {
      paramObject = "=";
    } else {
      paramObject = "!";
    }
    localStringBuilder.append(paramObject);
    localStringBuilder.append("= null!");
    c.a(localStringBuilder.toString(), new Object[0]);
    if (bool)
    {
      if (!a.get()) {
        return bool;
      }
      paramObject = new StringBuilder();
      paramObject.append(paramString);
      paramObject.append(" == null!");
      throw new NullPointerException(paramObject.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.util.e
 * JD-Core Version:    0.7.0.1
 */