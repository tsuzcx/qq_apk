package com.huawei.hms.stats;

import android.content.Context;
import java.util.LinkedHashMap;

public abstract class bs
{
  private static bq a = null;
  
  public static void a()
  {
    if ((c() != null) && (bd.a().b())) {
      a.a(-1);
    }
  }
  
  public static void a(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((c() != null) && (bd.a().b()))
    {
      if ((paramInt == 1) || (paramInt == 0)) {
        a.a(paramInt, paramString, paramLinkedHashMap);
      }
    }
    else {
      return;
    }
    af.b("hmsSdk", "Data type no longer collects range.type: " + paramInt);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (c() != null) {
      a.a(paramContext, paramString1, paramString2);
    }
  }
  
  public static boolean b()
  {
    return bv.a().c();
  }
  
  private static bq c()
  {
    try
    {
      if (a == null) {
        a = bv.a().b();
      }
      bq localbq = a;
      return localbq;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bs
 * JD-Core Version:    0.7.0.1
 */