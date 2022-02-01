package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import java.util.List;

public class v
  extends u
{
  protected float u;
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    s();
  }
  
  public boolean b()
  {
    return (super.b()) && (GLES20.glGetError() == 0);
  }
  
  public float q()
  {
    return this.u;
  }
  
  public float r()
  {
    return this.u;
  }
  
  protected void s()
  {
    float f = r();
    h localh = (h)this.r.get(0);
    int i = GLES20.glGetUniformLocation(localh.p(), "texelWidthOffset");
    int j = GLES20.glGetUniformLocation(localh.p(), "texelHeightOffset");
    localh.a(i, f / this.e);
    localh.a(j, 0.0F);
    f = q();
    localh = (h)this.r.get(1);
    i = GLES20.glGetUniformLocation(localh.p(), "texelWidthOffset");
    j = GLES20.glGetUniformLocation(localh.p(), "texelHeightOffset");
    localh.a(i, 0.0F);
    localh.a(j, f / this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.v
 * JD-Core Version:    0.7.0.1
 */