package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.log.TXCLog;

public class f
{
  private final int a;
  private final int b;
  private int c = -1;
  private int d = -1;
  
  public f(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a()
  {
    this.c = TXCOpenGlUtils.a(null, this.a, this.b, -1);
    this.d = TXCOpenGlUtils.d();
    TXCOpenGlUtils.a(this.c, this.d);
    TXCLog.i("GLFrameBuffer", "create frameBufferId: %d, textureId: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c) });
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void e()
  {
    TXCLog.i("GLFrameBuffer", "destroy frameBufferId: %d, textureId: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c) });
    TXCOpenGlUtils.c(this.c);
    this.c = -1;
    TXCOpenGlUtils.b(this.d);
    this.d = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.f
 * JD-Core Version:    0.7.0.1
 */