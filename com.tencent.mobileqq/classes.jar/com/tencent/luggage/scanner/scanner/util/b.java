package com.tencent.luggage.scanner.scanner.util;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b.a a = new b.a(null);
  private w b;
  private long c;
  private long d = 5000L;
  private long e = 1000L;
  private float f = 2.0F;
  private boolean g;
  private int h;
  private boolean i;
  private boolean j;
  private float k = 0.8F;
  private long l;
  private long m;
  private long n;
  private boolean o;
  private boolean p;
  private boolean q;
  
  public b()
  {
    i();
    j();
  }
  
  private final void b(long paramLong)
  {
    o.d("Luggage.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    w localw = this.b;
    if (localw != null) {
      localw.putLong("scan_code_retry_timeout", paramLong);
    }
    localw = this.b;
    if (localw != null) {
      localw.apply();
    }
  }
  
  private final void i()
  {
    this.b = w.b(k());
  }
  
  private final void j()
  {
    this.c = l();
    this.h = 0;
    this.d = 5000L;
    this.e = 1000L;
    this.f = ('È' / 100.0F);
    this.c = Math.max(this.e, this.c);
    this.c = Math.min(this.d, this.c);
    this.k = (80 / 100.0F);
    this.k = Math.min(1.0F, this.k);
    int i1 = this.h;
    if (i1 == 1)
    {
      this.i = true;
      this.j = false;
    }
    else if (i1 == 2)
    {
      this.i = false;
      this.j = true;
    }
    o.d("Luggage.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.h), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.c), Integer.valueOf(200), Float.valueOf(this.f), Integer.valueOf(80), Float.valueOf(this.k), Boolean.valueOf(this.i), Boolean.valueOf(this.j) });
  }
  
  private final String k()
  {
    return "luggage_scan_code_retry";
  }
  
  private final long l()
  {
    w localw = this.b;
    long l1 = 5000L;
    if (localw != null) {
      l1 = localw.getLong("scan_code_retry_timeout", 5000L);
    }
    return l1;
  }
  
  public final void a()
  {
    this.l = System.currentTimeMillis();
  }
  
  public final void a(int paramInt)
  {
    o.d("Luggage.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      this.i = false;
      return;
    }
    if (paramInt == 2) {
      this.j = false;
    }
  }
  
  public final void a(long paramLong)
  {
    if (this.g) {
      return;
    }
    this.g = true;
    paramLong = ((float)paramLong * this.f);
    this.c = Math.max(this.e, Math.min(this.d, paramLong));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public final void b()
  {
    this.m = System.currentTimeMillis();
    this.n = (this.m - this.l);
    o.d("Luggage.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(this.n), Boolean.valueOf(this.g), Boolean.valueOf(this.o), Boolean.valueOf(this.q) });
    if (this.g)
    {
      b(this.c);
      return;
    }
    f();
  }
  
  public final boolean b(int paramInt)
  {
    if (paramInt == 1) {
      return this.i;
    }
    if (paramInt == 2) {
      return this.j;
    }
    return false;
  }
  
  public final void c()
  {
    this.o = true;
  }
  
  public final void d()
  {
    this.p = true;
  }
  
  public final long e()
  {
    return this.c;
  }
  
  public final void f()
  {
    if (!this.g)
    {
      this.c = this.d;
      b(this.c);
      o.d("Luggage.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(this.c) });
    }
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final float h()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */