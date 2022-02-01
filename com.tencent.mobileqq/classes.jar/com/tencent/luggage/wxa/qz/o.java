package com.tencent.luggage.wxa.qz;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class o
{
  private static int a = 6;
  private static o.a b = new o.1();
  private static o.a c = b;
  private static final String d;
  private static Map<String, o.b> e = new HashMap();
  
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
      a("MicroMsg.SDK.Log", localThrowable, "", new Object[0]);
    }
    d = localStringBuilder1.toString();
  }
  
  public static void a()
  {
    Object localObject = c;
    if (localObject != null)
    {
      ((o.a)localObject).a();
      e.size();
      localObject = new ArrayList();
      Iterator localIterator = e.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((Map.Entry)localIterator.next()).getKey());
      }
      localObject = ((List)localObject).listIterator();
      while (((ListIterator)localObject).hasNext()) {
        a((String)((ListIterator)localObject).next());
      }
    }
  }
  
  public static void a(o.a parama)
  {
    c = parama;
  }
  
  public static void a(String paramString)
  {
    synchronized (e)
    {
      if ((c != null) && (e.containsKey(paramString)))
      {
        o.b localb = (o.b)e.remove(paramString);
        c.a(paramString);
        o.b.a(localb, -1L);
      }
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, (Object[])null);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 5))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      c.f(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 4))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramVarArgs);
      paramString2.append("  ");
      paramString2.append(Log.getStackTraceString(paramThrowable));
      paramThrowable = paramString2.toString();
      c.e(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
    }
  }
  
  public static void b()
  {
    o.a locala = c;
    if (locala != null) {
      locala.a(0L, true);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, (Object[])null);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 4))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      c.e(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static int c()
  {
    o.a locala = c;
    if (locala != null) {
      return locala.a(0L);
    }
    return 6;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, (Object[])null);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 3))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      c.d(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, (Object[])null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 2))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      c.b(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, (Object[])null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 1))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      c.c(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, (Object[])null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 0))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      c.a(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 1))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramVarArgs);
      paramString2.append("  ");
      paramString2.append(af.c());
      paramString2 = paramString2.toString();
      c.b(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static void h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    o.a locala = c;
    if ((locala != null) && (locala.a(0L) <= 2))
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramVarArgs);
      paramString2.append("  ");
      paramString2.append(af.c());
      paramString2 = paramString2.toString();
      c.b(0L, paramString1, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.o
 * JD-Core Version:    0.7.0.1
 */