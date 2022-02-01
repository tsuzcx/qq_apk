package com.tencent.luggage.wxa.f;

import java.util.ArrayList;
import java.util.Iterator;

class h$b
  implements i.a
{
  private final ArrayList<h.a> b = new ArrayList();
  private boolean c;
  
  h$b(h paramh) {}
  
  public void a()
  {
    if (this.c)
    {
      this.c = false;
      this.a.requestLayout();
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).a(this.a);
    }
  }
  
  public void a(h.a parama)
  {
    this.b.add(parama);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).a(this.a, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).a(this.a, paramArrayOfByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (h.b(this.a)) {
      return;
    }
    h.a(this.a, paramArrayOfByte);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).a(this.a, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).b(this.a);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).c(this.a);
    }
  }
  
  public void d()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.h.b
 * JD-Core Version:    0.7.0.1
 */