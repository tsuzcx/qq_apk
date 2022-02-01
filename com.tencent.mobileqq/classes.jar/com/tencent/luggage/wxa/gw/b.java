package com.tencent.luggage.wxa.gw;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.o;

public class b
{
  private static int a = 6;
  private static b.a b = new b.1();
  private static b.a c = b;
  private static final String d;
  
  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    try
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("VERSION.RELEASE:[");
      localStringBuilder2.append(Build.VERSION.RELEASE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] VERSION.CODENAME:[");
      localStringBuilder2.append(Build.VERSION.CODENAME);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] VERSION.INCREMENTAL:[");
      localStringBuilder2.append(Build.VERSION.INCREMENTAL);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] BOARD:[");
      localStringBuilder2.append(Build.BOARD);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] DEVICE:[");
      localStringBuilder2.append(Build.DEVICE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] DISPLAY:[");
      localStringBuilder2.append(Build.DISPLAY);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] FINGERPRINT:[");
      localStringBuilder2.append(Build.FINGERPRINT);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] HOST:[");
      localStringBuilder2.append(Build.HOST);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] MANUFACTURER:[");
      localStringBuilder2.append(Build.MANUFACTURER);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] MODEL:[");
      localStringBuilder2.append(Build.MODEL);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] PRODUCT:[");
      localStringBuilder2.append(Build.PRODUCT);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] TAGS:[");
      localStringBuilder2.append(Build.TAGS);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] TYPE:[");
      localStringBuilder2.append(Build.TYPE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] USER:[");
      localStringBuilder2.append(Build.USER);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    catch (Throwable localThrowable)
    {
      a("mix.Log", localThrowable, "", new Object[0]);
    }
    d = localStringBuilder1.toString();
  }
  
  public static void a(b.a parama)
  {
    c = parama;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, (Object[])null);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.b(paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    o.a(paramString1, paramThrowable, paramString2, paramVarArgs);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, (Object[])null);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.d(paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gw.b
 * JD-Core Version:    0.7.0.1
 */