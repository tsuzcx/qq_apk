package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.qz.o;

class a$1
  extends Thread
{
  a$1(a parama, b paramb) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        o.d("MicroMsg.Video.AbstractVideoTextureView", "%d another thread to release player[%s]", new Object[] { Integer.valueOf(this.b.hashCode()), this.a });
        this.a.n();
        this.a.b();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.1
 * JD-Core Version:    0.7.0.1
 */