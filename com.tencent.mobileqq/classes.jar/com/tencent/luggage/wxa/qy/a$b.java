package com.tencent.luggage.wxa.qy;

import com.tencent.luggage.wxa.qz.o;
import java.util.Collections;
import java.util.LinkedList;

class a$b
  extends com.tencent.luggage.wxa.rk.a<c>
{
  public a$b(a parama)
  {
    super(a.a(parama));
  }
  
  public com.tencent.luggage.wxa.rk.b<c> a(c paramc)
  {
    return a(new com.tencent.luggage.wxa.rk.b(paramc, this));
  }
  
  public void a(com.tencent.luggage.wxa.rr.a parama)
  {
    LinkedList localLinkedList = a();
    int i = 0;
    parama = (b)parama.a(0);
    if (parama == null)
    {
      o.b("MicroMsg.EventCenter", "event is null! fatal!");
      return;
    }
    if (parama.d()) {
      Collections.sort(localLinkedList, new a.b.1(this));
    }
    com.tencent.luggage.wxa.rk.b[] arrayOfb = new com.tencent.luggage.wxa.rk.b[localLinkedList.size()];
    localLinkedList.toArray(arrayOfb);
    int j = arrayOfb.length;
    while ((i < j) && ((!((c)arrayOfb[i].b()).a(parama)) || (!parama.d()))) {
      i += 1;
    }
    if (parama.c != null) {
      parama.c.run();
    }
  }
  
  public void b(c paramc)
  {
    b(new com.tencent.luggage.wxa.rk.b(paramc, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qy.a.b
 * JD-Core Version:    0.7.0.1
 */