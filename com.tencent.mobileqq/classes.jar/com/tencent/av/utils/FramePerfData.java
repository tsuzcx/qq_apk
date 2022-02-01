package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

@TargetApi(17)
public class FramePerfData
{
  private static long p;
  private boolean A = false;
  private final long B;
  private float C = 0.0F;
  private float D = 0.0F;
  public FramePerfData a;
  boolean b = false;
  boolean c = false;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  private long n = 0L;
  private long o = 0L;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private long y = 0L;
  private boolean z = true;
  
  public FramePerfData(FramePerfData paramFramePerfData, long paramLong)
  {
    this.B = paramLong;
    this.a = paramFramePerfData;
  }
  
  static float a(float paramFloat, long paramLong)
  {
    if (paramFloat == 0.0F) {
      return (float)paramLong;
    }
    if (paramLong == 0L) {
      return paramFloat;
    }
    return paramFloat * 0.98F + (float)paramLong * 0.02F;
  }
  
  static int a(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(1000000.0F / paramFloat * 100.0F);
  }
  
  static long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return 0L;
    }
    if (paramLong2 == 0L) {
      return 0L;
    }
    return paramLong1 - paramLong2;
  }
  
  private void a(String paramString)
  {
    c();
    b(paramString);
    this.a = null;
  }
  
  public static boolean a()
  {
    return true;
  }
  
  private void b(String paramString)
  {
    boolean bool = h();
    if (bool)
    {
      int i1 = a(this.C);
      int i2 = a(this.D);
      paramString = new StringBuilder();
      paramString.append("frameIndex[");
      paramString.append(this.a);
      paramString.append("->");
      paramString.append(this.B);
      paramString.append("], dataLen[");
      paramString.append(this.r);
      paramString.append("], width[");
      paramString.append(this.s);
      paramString.append("], height[");
      paramString.append(this.t);
      paramString.append("], format[");
      paramString.append(this.u);
      paramString.append("], CamAngle[");
      paramString.append(this.v);
      paramString.append("], FinalAngle[");
      paramString.append(this.x);
      paramString.append("], CamFPS[");
      paramString.append(this.y);
      paramString.append("], PreviewDataFPS[");
      paramString.append(i1);
      paramString.append("], SendFPS[");
      paramString.append(i2);
      paramString.append("], isFront[");
      paramString.append(this.z);
      paramString.append("], effect[");
      paramString.append(this.A);
      paramString.append("], business[");
      paramString.append(String.format("%08x", new Object[] { Integer.valueOf(this.q) }));
      paramString.append("]");
      Object localObject = paramString.toString();
      paramString = null;
      if (b())
      {
        paramString = new StringBuilder();
        paramString.append(", intervalPreviewData[");
        paramString.append(this.e);
        paramString.append("], intervalSendCameraFrame2Native[");
        paramString.append(this.o);
        paramString.append("], render[");
        paramString.append(a(this.m, this.f));
        paramString.append("], CheckLowligh[");
        paramString.append(a(this.g, this.f));
        paramString.append("], Beauty2[");
        paramString.append(a(this.h, this.g));
        paramString.append("], DenoiseRender[");
        paramString.append(a(this.i, this.h));
        paramString.append("], LowLightRender[");
        paramString.append(a(this.j, this.i));
        paramString.append("], Beauty3[");
        paramString.append(a(this.k, this.j));
        paramString.append("], RenderChain[");
        paramString.append(a(this.l, this.k));
        paramString.append("], post[");
        paramString.append(a(this.m, this.l));
        paramString.append("], buildExtInfo[");
        paramString.append(a(this.n, this.m));
        paramString.append("]");
        paramString = paramString.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PerfLog, ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", onPreviewData[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("], renderBegin[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("], afterCheckLowligh[");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("], afterDenoiseRender[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("], afterLowLightRender[");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append("], afterBeautyRender[");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append("], afterRenderChain[");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append("], renderEnd[");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append("], sendCameraFrame2Native[");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append("]");
      paramString = ((StringBuilder)localObject).toString();
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FramePerfDataK_");
        ((StringBuilder)localObject).append(this.c);
        QLog.w(((StringBuilder)localObject).toString(), 1, paramString);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FramePerfData_");
      ((StringBuilder)localObject).append(this.c);
      QLog.w(((StringBuilder)localObject).toString(), 1, paramString);
    }
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public void a(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.r = paramInt1;
    this.s = paramInt2;
    this.t = paramInt3;
    this.u = paramInt4;
    this.v = paramInt5;
    this.w = paramInt6;
    this.y = paramLong;
    this.z = paramBoolean1;
    this.A = paramBoolean2;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (b())
    {
      this.l = SystemClock.elapsedRealtimeNanos();
      if (paramBoolean1) {
        this.q |= 0x20;
      }
      if (paramBoolean2) {
        this.q |= 0x10;
      }
      if (paramBoolean3) {
        this.q |= 0x40;
      }
      if (paramBoolean4) {
        this.q |= 0x80;
      }
    }
  }
  
  void c()
  {
    for (FramePerfData localFramePerfData = this.a; (localFramePerfData != null) && (!localFramePerfData.b); localFramePerfData = localFramePerfData.a) {
      localFramePerfData.c = true;
    }
    this.a = localFramePerfData;
    if (localFramePerfData != null)
    {
      long l1 = localFramePerfData.d;
      if (l1 != 0L) {
        this.e = (this.d - l1);
      }
      l1 = localFramePerfData.n;
      if (l1 != 0L) {
        this.o = (this.n - l1);
      }
    }
    float f2 = 0.0F;
    float f1;
    if (localFramePerfData == null) {
      f1 = 0.0F;
    } else {
      f1 = localFramePerfData.C;
    }
    this.C = a(f1, this.e / 1000L);
    if (localFramePerfData == null) {
      f1 = f2;
    } else {
      f1 = localFramePerfData.D;
    }
    this.D = a(f1, this.o / 1000L);
  }
  
  public void d()
  {
    if (b()) {
      this.d = SystemClock.elapsedRealtimeNanos();
    }
  }
  
  public void e()
  {
    if (b()) {
      this.f = SystemClock.elapsedRealtimeNanos();
    }
  }
  
  public void f()
  {
    if (b()) {
      this.m = SystemClock.elapsedRealtimeNanos();
    }
  }
  
  public void g()
  {
    this.b = true;
    if (b()) {
      this.n = SystemClock.elapsedRealtimeNanos();
    }
    a("finish");
  }
  
  boolean h()
  {
    if (System.currentTimeMillis() - p >= 4000L)
    {
      p = System.currentTimeMillis();
      return true;
    }
    FramePerfData localFramePerfData = this.a;
    if (localFramePerfData != null)
    {
      if ((localFramePerfData.r == this.r) && (localFramePerfData.s == this.s) && (localFramePerfData.t == this.t) && (localFramePerfData.u == this.u) && (localFramePerfData.v == this.v) && (localFramePerfData.w == this.w) && (localFramePerfData.y == this.y) && (localFramePerfData.z == this.z) && (localFramePerfData.A == this.A) && (localFramePerfData.x == this.x) && (localFramePerfData.q == this.q) && (localFramePerfData.B + 1L == this.B)) {
        return false;
      }
      p = System.currentTimeMillis();
      return true;
    }
    p = System.currentTimeMillis();
    return true;
  }
  
  public boolean i()
  {
    if (this.b) {
      return true;
    }
    this.b = true;
    a("clear");
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.B);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.FramePerfData
 * JD-Core Version:    0.7.0.1
 */