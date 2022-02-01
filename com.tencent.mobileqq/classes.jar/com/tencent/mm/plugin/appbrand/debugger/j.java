package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qw.jt;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j
{
  private static int a = -1;
  
  public static int a()
  {
    Context localContext = r.a();
    if (!x.a(localContext)) {
      return 0;
    }
    if (x.f(localContext)) {
      return 1;
    }
    if (x.i(localContext)) {
      return 2;
    }
    if (x.g(localContext)) {
      return 3;
    }
    if (x.j(localContext)) {
      return 4;
    }
    return 5;
  }
  
  public static String a(String paramString)
  {
    paramString = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return "";
  }
  
  public static void a(jt paramjt, d paramd)
  {
    if (paramd != null)
    {
      int i = (int)(System.currentTimeMillis() - paramd.b);
      ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramd.a), Integer.valueOf(paramjt.d()), Integer.valueOf(0), "", "", Integer.valueOf(b()), Integer.valueOf(a()) });
    }
  }
  
  public static void a(a parama, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() - parama.b);
    ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(parama.d), Integer.valueOf(paramInt), Integer.valueOf(1), "", af.b(parama.c), Integer.valueOf(b()), Integer.valueOf(a()) });
  }
  
  public static void a(String paramString, LinkedList<String> paramLinkedList, long paramLong, int paramInt1, int paramInt2)
  {
    if (((paramString.equals("invokeHandler")) || (paramString.equals("publishHandler"))) && (paramLinkedList.size() > 0)) {
      paramLinkedList = (String)paramLinkedList.get(0);
    } else {
      paramLinkedList = "";
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(2), paramString, paramLinkedList, Integer.valueOf(b()), Integer.valueOf(a()) });
  }
  
  private static int b()
  {
    int i = a;
    if (i >= 0) {
      return i;
    }
    a = x.e(r.a());
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.j
 * JD-Core Version:    0.7.0.1
 */