package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.log.TXCLog;

class g$3
  implements Runnable
{
  g$3(g paramg, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    try
    {
      g.a(this.j, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("surface-render: render texture error occurred!");
      localStringBuilder.append(localException.getMessage());
      TXCLog.e("TXGLSurfaceRenderThread", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.g.3
 * JD-Core Version:    0.7.0.1
 */