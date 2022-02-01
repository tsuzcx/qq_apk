package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.opengl.g;

class e$3
  implements Runnable
{
  e$3(e parame, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.c;
    ((e)localObject).m = this.a;
    ((e)localObject).n = this.b;
    if (e.a((e)localObject) != null)
    {
      localObject = e.a(this.c);
      int i = e.b(this.c)[0];
      boolean bool;
      if (e.b(this.c)[3] == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((g)localObject).a(i, bool, e.b(this.c)[4], this.c.m, this.c.n, e.b(this.c)[1], e.b(this.c)[2], true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.e.3
 * JD-Core Version:    0.7.0.1
 */