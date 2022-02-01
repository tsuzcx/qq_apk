package com.huawei.hms.framework.network.grs.c.b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.c.f;
import java.util.concurrent.Future;

public class b
{
  private Future<f> a;
  private long b;
  
  public b(Future<f> paramFuture)
  {
    this.a = paramFuture;
    this.b = SystemClock.elapsedRealtime();
  }
  
  public Future<f> a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return SystemClock.elapsedRealtime() - this.b <= 300000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b.b
 * JD-Core Version:    0.7.0.1
 */