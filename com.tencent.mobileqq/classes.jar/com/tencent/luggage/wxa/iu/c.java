package com.tencent.luggage.wxa.iu;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pc.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  private static final Iterator<c.c> a = new c.1();
  private static final Map<String, c.b> b = new HashMap();
  private static final Map<String, c.d> c = new HashMap();
  private static final h<String, c.c> d = new h();
  private static final h<String, c.a> e = new h();
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = j(paramString);
    while (paramString.hasNext()) {
      ((c.c)paramString.next()).a();
    }
  }
  
  public static void a(String paramString, c.a parama)
  {
    e.a(paramString, parama);
  }
  
  public static void a(String paramString, c.b paramb)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b.put(paramString, paramb);
  }
  
  public static void a(String paramString, c.c paramc)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramc == null) {
        return;
      }
      d.a(paramString, paramc);
    }
  }
  
  public static void a(String paramString, c.d paramd)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    c.put(paramString, paramd);
  }
  
  public static boolean a(String paramString, Intent paramIntent)
  {
    paramString = e.a(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((c.a)paramString.next()).a(paramIntent)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = j(paramString);
    while (paramString.hasNext()) {
      ((c.c)paramString.next()).c();
    }
  }
  
  public static void b(String paramString, c.a parama)
  {
    e.b(paramString, parama);
  }
  
  public static void b(String paramString, c.c paramc)
  {
    if (paramc != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      d.b(paramString, paramc);
    }
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = j(paramString);
    while (paramString.hasNext()) {
      ((c.c)paramString.next()).e();
    }
  }
  
  public static void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = j(paramString);
    while (localIterator.hasNext()) {
      ((c.c)localIterator.next()).a(i(paramString));
    }
  }
  
  public static void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = j(paramString);
    while (paramString.hasNext()) {
      ((c.c)paramString.next()).b();
    }
  }
  
  public static void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = j(paramString);
    while (paramString.hasNext()) {
      ((c.c)paramString.next()).d();
    }
  }
  
  public static void g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    d.b(paramString);
    e.b(paramString);
  }
  
  public static void h(String paramString)
  {
    a(paramString, c.d.c);
  }
  
  public static c.d i(String paramString)
  {
    c.d locald = (c.d)c.get(paramString);
    paramString = locald;
    if (locald == null) {
      paramString = c.d.c;
    }
    return paramString;
  }
  
  @NonNull
  private static Iterator<c.c> j(@NonNull String paramString)
  {
    paramString = d.a(paramString);
    if (paramString != null) {
      return paramString.iterator();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.c
 * JD-Core Version:    0.7.0.1
 */