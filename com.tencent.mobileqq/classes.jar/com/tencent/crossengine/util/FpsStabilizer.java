package com.tencent.crossengine.util;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/crossengine/util/FpsStabilizer;", "", "()V", "accumulateStartTimeNanos", "", "accumulatedFrames", "", "fpsIntervalNanos", "", "setTargetFps", "", "fps", "", "shouldDoFrame", "", "drawingTimeNanos", "library_release"}, k=1, mv={1, 1, 16})
public final class FpsStabilizer
{
  private volatile double a;
  private volatile long b = -1000L;
  private int c;
  
  public final void a(float paramFloat)
  {
    double d1;
    if (paramFloat <= 0)
    {
      d1 = 0.0D;
    }
    else
    {
      d1 = TimeUnit.SECONDS.toNanos(1L);
      double d2 = paramFloat;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
    }
    this.a = d1;
    this.b = 0L;
  }
  
  public final boolean a(long paramLong)
  {
    double d1 = this.a;
    boolean bool2 = true;
    boolean bool1 = true;
    if (d1 != 0.0D)
    {
      if (paramLong <= 0L) {
        return true;
      }
      long l = paramLong - this.b;
      d1 = l;
      double d2 = this.a;
      Double.isNaN(d1);
      d1 /= d2;
      int i = this.c;
      if (d1 >= i) {
        this.c = (i + 1);
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (l > TimeUnit.SECONDS.toNanos(1L))
      {
        this.b = paramLong;
        this.c = 0;
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.util.FpsStabilizer
 * JD-Core Version:    0.7.0.1
 */