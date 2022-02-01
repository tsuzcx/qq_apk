package com.tencent.luggage.wxa.ev;

import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.xweb.af;

public class c
{
  private static boolean a = false;
  private static String b = "XWebEnvironmentInitHelper";
  
  public static void a()
  {
    if (a) {
      return;
    }
    Context localContext = r.a();
    o.d(b, "initXWebEnvironment", new Object[] { localContext });
    af.a(new c.1(localContext, localContext), b.a, b.c, b.b, null);
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ev.c
 * JD-Core Version:    0.7.0.1
 */