package com.tencent.liteav;

import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.videoencoder.b;

class d$21
  implements Runnable
{
  d$21(d paramd, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if ((this.a != 0) && (this.b != 0))
    {
      d.e(this.d).a = this.a;
      d.e(this.d).b = this.b;
      if (d.f(this.d) != null)
      {
        d.f(this.d).a(c.a);
        d.f(this.d).b(this.a, this.b);
      }
    }
    if ((this.c != 0) && (d.a(this.d) != null))
    {
      d.e(this.d).c = this.c;
      d.a(this.d).c(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.21
 * JD-Core Version:    0.7.0.1
 */