package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.c.h;

class a$8
  implements Runnable
{
  a$8(a parama, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (a.b(this.c) != true)
    {
      if (a.c(this.c) == null) {
        return;
      }
      int k = this.a;
      long l = this.b;
      a.a(this.c, l);
      int m = (720 - this.c.mRotation) % 360;
      int i;
      if ((m != 90) && (m != 270)) {
        i = this.c.mOutputWidth;
      } else {
        i = this.c.mOutputHeight;
      }
      int j;
      if ((m != 90) && (m != 270)) {
        j = this.c.mOutputHeight;
      } else {
        j = this.c.mOutputWidth;
      }
      this.c.mEncodeFilter.a(this.c.mInputWidth, this.c.mInputHeight, m, null, i / j, this.c.mEnableXMirror, true);
      this.c.mEncodeFilter.a(k);
      if ((a.c(this.c) instanceof c))
      {
        ((c)a.c(this.c)).a(l * 1000000L);
        ((c)a.c(this.c)).d();
      }
      if ((a.c(this.c) instanceof b)) {
        ((b)a.c(this.c)).a();
      }
      if (this.c.mListener != null) {
        this.c.mListener.m(this.c.mStreamType);
      }
      do
      {
        i = a.c(this.c, 1);
      } while (i > 0);
      if ((i != -1) && (i != -2))
      {
        a.d(this.c);
        return;
      }
      if (i == -1) {
        this.c.callDelegate(10000005);
      }
      a.a(this.c, true);
      a.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.8
 * JD-Core Version:    0.7.0.1
 */