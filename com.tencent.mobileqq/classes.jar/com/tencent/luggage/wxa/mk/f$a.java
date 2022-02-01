package com.tencent.luggage.wxa.mk;

import android.os.Handler;

class f$a
  implements Runnable
{
  private f$a(f paramf) {}
  
  void a()
  {
    f.e(this.a).postDelayed(f.c(this.a), f.d(this.a));
  }
  
  public void run()
  {
    if (f.a(this.a) != null) {
      f.a(this.a).a();
    }
    if (f.b(this.a)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.f.a
 * JD-Core Version:    0.7.0.1
 */