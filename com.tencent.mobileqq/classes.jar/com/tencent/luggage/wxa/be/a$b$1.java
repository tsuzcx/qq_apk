package com.tencent.luggage.wxa.be;

import android.graphics.Bitmap;

class a$b$1
  implements d.e
{
  a$b$1(a.b paramb) {}
  
  public void a()
  {
    a.a(this.a.a, -1, null, "take picture error");
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      a.b localb = this.a;
      if (a.b.a(localb, paramBitmap, a.r(localb.a)))
      {
        paramBitmap = this.a.a;
        localb = this.a;
        a.a(paramBitmap, 0, a.b.a(localb, a.g(localb.a), a.r(this.a.a)), "");
        return;
      }
      a.a(this.a.a, -1, null, "save fail");
      return;
    }
    a.a(this.a.a, -1, null, "bitmap is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.b.1
 * JD-Core Version:    0.7.0.1
 */