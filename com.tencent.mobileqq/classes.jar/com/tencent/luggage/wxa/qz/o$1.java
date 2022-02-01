package com.tencent.luggage.wxa.qz;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

final class o$1
  implements o.a
{
  private Handler a = new Handler(Looper.getMainLooper());
  
  public int a(long paramLong)
  {
    return o.d();
  }
  
  public void a() {}
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    if (o.d() <= 0) {
      Log.v(paramString1, paramString4);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(String paramString) {}
  
  public void b(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    if (o.d() <= 2) {
      Log.i(paramString1, paramString4);
    }
  }
  
  public void c(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    if (o.d() <= 1) {
      Log.d(paramString1, paramString4);
    }
  }
  
  public void d(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    if (o.d() <= 3) {
      Log.w(paramString1, paramString4);
    }
  }
  
  public void e(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    if (o.d() <= 4) {
      Log.e(paramString1, paramString4);
    }
  }
  
  public void f(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    if (o.d() > 5) {
      return;
    }
    Log.e(paramString1, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.o.1
 * JD-Core Version:    0.7.0.1
 */