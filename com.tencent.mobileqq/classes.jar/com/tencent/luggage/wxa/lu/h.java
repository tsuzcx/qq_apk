package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.qz.o;

public class h
{
  private static boolean a = false;
  private static String b = "";
  private static String c = "";
  private static g d = new g();
  private static t.a e = t.a.a;
  private static t.a f = t.a.a;
  
  public static void a(c paramc)
  {
    b = paramc.getAppId();
    a = true;
    d.b(paramc);
    if ((f != t.a.a) && (c.equalsIgnoreCase(b))) {
      d.a(f);
    } else {
      f = t.a.a;
    }
    paramc = new StringBuilder();
    paramc.append("init mJsAppid:");
    paramc.append(b);
    paramc.append("; mEnable:");
    paramc.append(a);
    o.d("MicroMsg.OrientationConfigListenerHelper", paramc.toString());
  }
  
  public static void a(t.a parama)
  {
    e = parama;
    if ((a) && (f == t.a.c) && ((parama == t.a.e) || (parama == t.a.c)))
    {
      d.a(parama);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFourOrientationsChange mAppid:");
      localStringBuilder.append(b);
      localStringBuilder.append("; mOrientation:");
      localStringBuilder.append(parama.name());
      o.d("MicroMsg.OrientationConfigListenerHelper", localStringBuilder.toString());
    }
  }
  
  public static void b(c paramc)
  {
    if (paramc.getAppId().equalsIgnoreCase(b))
    {
      paramc = new StringBuilder();
      paramc.append("unInit mAppid:");
      paramc.append(b);
      o.d("MicroMsg.OrientationConfigListenerHelper", paramc.toString());
      b = "";
      a = false;
      f = t.a.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.h
 * JD-Core Version:    0.7.0.1
 */