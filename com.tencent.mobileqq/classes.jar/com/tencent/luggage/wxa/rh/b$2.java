package com.tencent.luggage.wxa.rh;

import android.content.Context;
import android.os.Looper;

class b$2
  implements b.a.a
{
  b$2(b paramb) {}
  
  public void a(Context paramContext)
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = this.a;
      paramContext.post(b.c(paramContext));
      return;
    }
    b.c(this.a).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rh.b.2
 * JD-Core Version:    0.7.0.1
 */