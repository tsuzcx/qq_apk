package com.tencent.luggage.wxa.ja;

import com.tencent.luggage.wxa.ji.b;
import java.lang.ref.WeakReference;

class b$a
  implements a
{
  private WeakReference<b> a;
  
  b$a(b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void a()
  {
    b localb = (b)this.a.get();
    if (localb == null) {
      return;
    }
    localb.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.b.a
 * JD-Core Version:    0.7.0.1
 */