package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.i;
import com.tencent.liteav.basic.log.TXCLog;

public class j
{
  private static String j = "GPUGreenScreen";
  private int a;
  private int b;
  private boolean c;
  private w d;
  private boolean e;
  private i f;
  private e g;
  private p h;
  private boolean i;
  private b k;
  
  private void b()
  {
    TXCLog.i(j, "come into destroyPlayer");
    w localw = this.d;
    if (localw != null) {
      localw.a();
    }
    this.d = null;
    this.e = false;
    this.i = false;
    TXCLog.i(j, "come out destroyPlayer");
  }
  
  private void c()
  {
    int m = this.b;
    if ((m != -1) && (m != this.a))
    {
      GLES20.glDeleteTextures(1, new int[] { m }, 0);
      this.b = -1;
    }
    m = this.a;
    if (m != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { m }, 0);
      this.a = -1;
    }
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    TXCLog.i(j, "come into GreenScreen destroy");
    b();
    c();
    Object localObject = this.f;
    if (localObject != null)
    {
      ((i)localObject).d();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((e)localObject).d();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((p)localObject).d();
      this.h = null;
    }
    this.c = false;
    TXCLog.i(j, "come out GreenScreen destroy");
  }
  
  public void a(b paramb)
  {
    TXCLog.i(j, "set notify");
    this.k = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.j
 * JD-Core Version:    0.7.0.1
 */