package com.tencent.luggage.wxa.jm;

import android.util.Log;

public class a
{
  private static b a = new a.1();
  private static String b;
  
  public static void a(String paramString, b paramb)
  {
    b = paramString;
    a = paramb;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramString1);
    ((b)localObject).a(localStringBuilder.toString(), paramString2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(paramString1);
    Log.i(((StringBuilder)localObject).toString(), paramString2);
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    a.a(paramString1, paramThrowable, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramString1);
    Log.e(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(paramString1);
    ((b)localObject).b(localStringBuilder.toString(), paramString2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(paramString1);
    Log.e(((StringBuilder)localObject).toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jm.a
 * JD-Core Version:    0.7.0.1
 */