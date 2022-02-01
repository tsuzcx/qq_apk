package com.tencent.luggage.wxa.mk;

import android.content.Context;
import android.os.Handler;
import com.tencent.luggage.wxa.ad.j.a;
import com.tencent.luggage.wxa.ap.g;
import com.tencent.luggage.wxa.h.s;
import com.tencent.luggage.wxa.i.d;
import com.tencent.luggage.wxa.i.i;
import com.tencent.luggage.wxa.v.f.a;
import java.util.ArrayList;
import java.util.List;

public class a
  implements e
{
  protected Context a;
  protected Handler b;
  protected j.a c;
  protected f.a d;
  protected com.tencent.luggage.wxa.i.e e;
  protected g f;
  protected com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> g;
  protected int h = 50;
  protected int i = 5000;
  
  public a(Context paramContext, Handler paramHandler, j.a parama, f.a parama1, com.tencent.luggage.wxa.i.e parame, g paramg)
  {
    this.a = paramContext;
    this.b = paramHandler;
    this.c = parama;
    this.d = parama1;
    this.e = parame;
    this.f = paramg;
  }
  
  public List<s> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b());
    localArrayList.addAll(c());
    return localArrayList;
  }
  
  protected List<s> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i(com.tencent.luggage.wxa.u.c.a, this.g, true, this.b, this.e, com.tencent.luggage.wxa.i.c.a(this.a), new d[0]));
    return localArrayList;
  }
  
  protected List<s> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.luggage.wxa.ap.e(this.a, com.tencent.luggage.wxa.u.c.a, this.i, this.g, false, this.b, this.f, this.h));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.a
 * JD-Core Version:    0.7.0.1
 */