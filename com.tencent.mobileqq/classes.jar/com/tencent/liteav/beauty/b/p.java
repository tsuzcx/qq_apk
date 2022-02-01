package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.a;
import com.tencent.liteav.basic.opengl.j;

public class p
  extends j
{
  private a r;
  
  public int b(int paramInt)
  {
    if (this.r == null)
    {
      this.r = new a();
      a locala = this.r;
      locala.a = 0;
      locala.b = 0;
      locala.c = this.e;
      this.r.d = this.f;
    }
    GLES20.glViewport(this.r.a, this.r.b, this.r.c, this.r.d);
    return super.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.p
 * JD-Core Version:    0.7.0.1
 */