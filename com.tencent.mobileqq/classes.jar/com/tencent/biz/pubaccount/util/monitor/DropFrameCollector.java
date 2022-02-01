package com.tencent.biz.pubaccount.util.monitor;

import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;

@RequiresApi(api=16)
class DropFrameCollector
  implements Choreographer.FrameCallback
{
  private static float a;
  private static float b;
  private static float c;
  private static float d;
  private static float e;
  private static float f;
  private static float[] g;
  private static float h;
  private static float i;
  private static float j;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  private float n = 0.0F;
  private float o = 0.0F;
  private float p = 0.0F;
  private long q = 0L;
  private long r = 0L;
  private boolean s;
  private int t = 1;
  private DropFrameData u;
  private Choreographer v;
  private DropFrameCollector.DropFrameCallback w;
  private StackSampler x;
  
  @RequiresApi(api=16)
  public DropFrameCollector(DropFrameCollector.DropFrameCallback paramDropFrameCallback, WindowManager paramWindowManager)
  {
    this.w = paramDropFrameCallback;
    this.v = Choreographer.getInstance();
    this.x = new StackSampler();
    a(paramWindowManager);
  }
  
  private final float a(double paramDouble, int paramInt)
  {
    double d1 = paramInt;
    Double.isNaN(d1);
    return (float)Math.round(paramDouble * d1) / paramInt;
  }
  
  private static final int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt <= 4) {
      return 2;
    }
    if (paramInt <= 8) {
      return 3;
    }
    if (paramInt <= 15) {
      return 4;
    }
    return 5;
  }
  
  private void a(long paramLong, DropFrameData paramDropFrameData)
  {
    if ((paramDropFrameData != null) && (!TextUtils.isEmpty(paramDropFrameData.a)))
    {
      if (paramDropFrameData.c == 0L)
      {
        paramDropFrameData.c = paramLong;
      }
      else
      {
        float f1 = (float)(paramLong - this.l);
        float f2 = i;
        int i1 = (int)((f1 - f2) / f2);
        int i2 = a(i1);
        paramDropFrameData.b += 1L;
        long[] arrayOfLong = paramDropFrameData.e;
        arrayOfLong[i2] += 1L;
        paramDropFrameData.d = paramLong;
        if (i1 >= 2)
        {
          if (QLog.isColorLevel())
          {
            paramDropFrameData = new StringBuilder();
            paramDropFrameData.append("catch drop frame: dropCount=");
            paramDropFrameData.append(i1);
            QLog.d("FPSMonitor", 2, paramDropFrameData.toString());
          }
          this.x.a(this.l, paramLong);
        }
      }
      this.l = paramLong;
    }
  }
  
  private final void a(WindowManager paramWindowManager)
  {
    if (i <= 0.0F)
    {
      h = paramWindowManager.getDefaultDisplay().getRefreshRate();
      float f1 = h;
      if (f1 > 0.0F)
      {
        j = 1000.0F / f1;
        i = 1.0E+009F / f1;
      }
      f1 = j;
      if (f1 > 0.0F)
      {
        a = f1;
        b = 1.5F * f1;
        c = 3.0F * f1;
        d = 6.0F * f1;
        e = 11.5F * f1;
        f = f1 * 15.0F;
      }
      g = new float[] { a, b, c, d, e, f };
    }
    if (QLog.isColorLevel())
    {
      paramWindowManager = new StringBuilder();
      paramWindowManager.append("init: sVsyncIntervalMs=");
      paramWindowManager.append(j);
      QLog.d("FPSMonitor", 2, paramWindowManager.toString());
    }
  }
  
  @RequiresApi(api=16)
  public void a()
  {
    this.s = true;
    this.v.postFrameCallback(this);
  }
  
  @RequiresApi(api=16)
  public void b()
  {
    this.s = false;
    this.v.removeFrameCallback(this);
  }
  
  public void doFrame(long paramLong)
  {
    a(paramLong, this.u);
    if (this.k <= 0L)
    {
      this.k = paramLong;
    }
    else
    {
      long l1 = TimeUnit.NANOSECONDS.toMillis(paramLong - this.k);
      this.m += 1L;
      if (l1 > 500L)
      {
        float f1 = (float)(this.m * 1000L) / (float)l1;
        this.m = 0L;
        this.n = a(f1, 100);
        this.k = paramLong;
        this.w.a(this.n, this.o, this.p);
      }
    }
    this.v.postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.DropFrameCollector
 * JD-Core Version:    0.7.0.1
 */