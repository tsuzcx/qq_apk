package com.tencent.luggage.wxa.no;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.ja.d;
import com.tencent.luggage.wxa.ja.e.a;
import com.tencent.luggage.wxa.jl.a.b;

class c$1
  implements a.b
{
  c$1(c paramc, e.a parama, d paramd, String paramString) {}
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.a != null) && (paramBitmap != null))
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.a.a(this.b, this.c, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.no.c.1
 * JD-Core Version:    0.7.0.1
 */