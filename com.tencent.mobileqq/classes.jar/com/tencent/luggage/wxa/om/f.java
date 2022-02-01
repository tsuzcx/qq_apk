package com.tencent.luggage.wxa.om;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

@TargetApi(16)
public class f
  implements Choreographer.FrameCallback
{
  private Choreographer a = Choreographer.getInstance();
  private long b = 0L;
  private int c = 0;
  private long d = 200L;
  private boolean e = false;
  private f.a f;
  private volatile double g = 0.0D;
  
  public void a()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    o.d("FPSMetronome", "[start] stack:%s", new Object[] { af.c() });
    this.a.postFrameCallback(this);
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(f.a parama)
  {
    this.f = parama;
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    this.b = 0L;
    this.c = 0;
    o.d("FPSMetronome", "[stop] stack:%s", new Object[] { af.c() });
    this.a.removeFrameCallback(this);
  }
  
  public void doFrame(long paramLong)
  {
    if (this.e)
    {
      paramLong /= 1000000L;
      long l = this.b;
      if (l > 0L)
      {
        l = paramLong - l;
        this.c += 1;
        if (l > this.d)
        {
          double d1 = this.c * 1000;
          double d2 = l;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          d2 = 60.0D;
          if (d1 >= 60.0D) {
            d1 = d2;
          }
          this.b = paramLong;
          this.c = 0;
          this.g = d1;
          f.a locala = this.f;
          if (locala != null) {
            locala.a(d1);
          }
        }
      }
      else
      {
        this.b = paramLong;
      }
    }
    if (this.e) {
      this.a.postFrameCallback(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.om.f
 * JD-Core Version:    0.7.0.1
 */