package com.tencent.luggage.wxa.ml;

import android.view.Surface;
import com.tencent.luggage.wxa.qz.o;

class a$2
  implements Runnable
{
  a$2(a parama, Surface paramSurface) {}
  
  public void run()
  {
    try
    {
      if ((this.a != null) && (this.a.isValid()))
      {
        o.d("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.b.hashCode()), Integer.valueOf(this.a.hashCode()) });
        this.a.release();
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.2
 * JD-Core Version:    0.7.0.1
 */