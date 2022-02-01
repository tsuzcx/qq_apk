package com.tencent.biz.pubaccount.weishi_new.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class WSLog
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("weishi");
    localStringBuilder.append("8.8.17".replaceAll("\\.", ""));
    a = localStringBuilder.toString();
  }
  
  public static String a(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public static void a(String paramString)
  {
    b(a, 4, paramString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    QLog.i((String)localObject, paramInt, paramString1);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, 4, paramString2);
  }
  
  public static void b(String paramString)
  {
    d(a, 1, paramString);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    QLog.d((String)localObject, paramInt, paramString1);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, 4, paramString2);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    QLog.w((String)localObject, paramInt, paramString1);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(paramString1, 4, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    QLog.e((String)localObject, paramInt, paramString1);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, 1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      a(paramString1, 2, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      b(paramString1, 2, paramString2);
    }
  }
  
  public static void g(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      c(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSLog
 * JD-Core Version:    0.7.0.1
 */