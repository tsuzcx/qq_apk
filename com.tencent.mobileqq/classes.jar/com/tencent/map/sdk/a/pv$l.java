package com.tencent.map.sdk.a;

import android.util.Log;
import java.io.Writer;

final class pv$l
  extends Writer
{
  private StringBuilder a = new StringBuilder();
  
  private void a()
  {
    if (this.a.length() > 0)
    {
      Log.v("GLSurfaceView", this.a.toString());
      this.a.delete(0, this.a.length());
    }
  }
  
  public final void close()
  {
    a();
  }
  
  public final void flush()
  {
    a();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      }
      for (;;)
      {
        i += 1;
        break;
        this.a.append(c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.l
 * JD-Core Version:    0.7.0.1
 */