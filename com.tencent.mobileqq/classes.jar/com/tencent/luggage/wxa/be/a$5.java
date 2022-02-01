package com.tencent.luggage.wxa.be;

import android.graphics.Point;
import java.util.Locale;

class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public void run()
  {
    int i = a.h(this.a).f().x;
    int j = a.h(this.a).f().y;
    int k = this.a.a_.a(a.h(this.a), i, j);
    if (k < 0)
    {
      a.k(this.a).a(String.format(Locale.US, "illegal state:%d", new Object[] { Integer.valueOf(k) }), -1, -1, -1);
      return;
    }
    a.k(this.a).a(null, k, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.5
 * JD-Core Version:    0.7.0.1
 */