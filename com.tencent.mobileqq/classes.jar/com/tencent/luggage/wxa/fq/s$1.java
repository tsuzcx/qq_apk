package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o.a;
import com.tencent.luggage.xlog.Xlog;

final class s$1
  implements o.a
{
  private final Xlog b = this.a;
  
  s$1(Xlog paramXlog) {}
  
  public int a(long paramLong)
  {
    return this.b.getLogLevel(paramLong);
  }
  
  public void a()
  {
    this.b.appenderClose();
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    this.b.logV(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.b.appenderFlush(paramLong, paramBoolean);
  }
  
  public void a(String paramString) {}
  
  public void b(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    this.b.logI(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void c(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    this.b.logD(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void d(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    this.b.logW(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void e(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    this.b.logE(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void f(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    this.b.logF(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.s.1
 * JD-Core Version:    0.7.0.1
 */