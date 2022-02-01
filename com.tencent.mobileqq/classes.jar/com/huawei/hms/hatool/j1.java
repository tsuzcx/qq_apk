package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

public abstract class j1
{
  public static h1 a;
  
  public static h1 a()
  {
    try
    {
      if (a == null) {
        a = m1.c().b();
      }
      h1 localh1 = a;
      return localh1;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((a() != null) && (u0.b().a()))
    {
      if ((paramInt != 1) && (paramInt != 0))
      {
        paramString = new StringBuilder();
        paramString.append("Data type no longer collects range.type: ");
        paramString.append(paramInt);
        y.d("hmsSdk", paramString.toString());
        return;
      }
      a.a(paramInt, paramString, paramLinkedHashMap);
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a() != null) {
      a.a(paramContext, paramString1, paramString2);
    }
  }
  
  public static boolean b()
  {
    return m1.c().a();
  }
  
  public static void c()
  {
    if ((a() != null) && (u0.b().a())) {
      a.a(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.j1
 * JD-Core Version:    0.7.0.1
 */