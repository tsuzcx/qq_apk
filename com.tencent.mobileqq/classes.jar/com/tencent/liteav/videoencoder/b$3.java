package com.tencent.liteav.videoencoder;

import com.tencent.liteav.beauty.b.k;
import java.util.LinkedList;

class b$3
  implements Runnable
{
  b$3(b paramb, com.tencent.liteav.basic.c.b paramb1) {}
  
  public void run()
  {
    b.c(this.b).clear();
    if (b.d(this.b) != null) {
      b.d(this.b).stop();
    }
    if (b.b(this.b) != null)
    {
      b.b(this.b).d();
      b.a(this.b, null);
    }
    com.tencent.liteav.basic.c.b localb = this.a;
    if (localb != null) {
      localb.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.3
 * JD-Core Version:    0.7.0.1
 */