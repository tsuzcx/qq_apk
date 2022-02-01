package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import java.io.Writer;

class TXCGLSurfaceViewBase$l
  extends Writer
{
  private StringBuilder a = new StringBuilder();
  
  private void a()
  {
    if (this.a.length() > 0)
    {
      TXCLog.v("TXCGLSurfaceViewBase", this.a.toString());
      StringBuilder localStringBuilder = this.a;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void close()
  {
    a();
  }
  
  public void flush()
  {
    a();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      } else {
        this.a.append(c);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.l
 * JD-Core Version:    0.7.0.1
 */