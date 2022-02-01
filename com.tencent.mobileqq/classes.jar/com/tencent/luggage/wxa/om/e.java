package com.tencent.luggage.wxa.om;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public class e
  implements Closeable
{
  private final int a;
  private volatile RandomAccessFile b;
  private volatile RandomAccessFile c;
  private boolean d;
  private long e;
  private long f;
  private long g;
  
  public e(int paramInt)
  {
    this.a = paramInt;
  }
  
  private long b()
  {
    if (this.b == null) {
      this.b = k.b("/proc/stat", false);
    }
    this.b.seek(0L);
    Object localObject = this.b.readLine();
    if (af.c((String)localObject)) {
      return 0L;
    }
    localObject = ((String)localObject).split(" ");
    if (localObject.length < 9) {
      return 0L;
    }
    return af.f(localObject[2]) + af.f(localObject[3]) + af.f(localObject[4]) + af.f(localObject[5]) + af.f(localObject[6]) + af.f(localObject[7]) + af.f(localObject[8]) + af.f(localObject[9]);
  }
  
  public double a()
  {
    boolean bool = this.d;
    double d2 = 0.0D;
    if (bool) {
      return 0.0D;
    }
    double d3 = d2;
    try
    {
      if (this.c == null)
      {
        d3 = d2;
        localObject = new StringBuilder();
        d3 = d2;
        ((StringBuilder)localObject).append("/proc/");
        d3 = d2;
        ((StringBuilder)localObject).append(this.a);
        d3 = d2;
        ((StringBuilder)localObject).append("/stat");
        d3 = d2;
        this.c = k.b(((StringBuilder)localObject).toString(), false);
      }
      d3 = d2;
      this.c.seek(0L);
      d3 = d2;
      Object localObject = this.c.readLine();
      d3 = d2;
      if (af.c((String)localObject)) {
        return 0.0D;
      }
      d3 = d2;
      localObject = ((String)localObject).split(" ");
      d3 = d2;
      if (localObject.length < 17) {
        return 0.0D;
      }
      d3 = d2;
      long l1 = b();
      d3 = d2;
      long l2 = af.f(localObject[13]);
      d3 = d2;
      long l3 = af.f(localObject[14]);
      double d1 = d2;
      d3 = d2;
      if (this.e != 0L)
      {
        d3 = d2;
        d1 = (l2 - this.f) * 100L;
        d3 = d2;
        long l4 = this.e;
        d3 = l1 - l4;
        Double.isNaN(d1);
        Double.isNaN(d3);
        d1 /= d3;
        d3 = d2;
        double d4 = (l3 - this.g) * 100L;
        d3 = d2;
        l4 = this.e;
        d3 = l1 - l4;
        Double.isNaN(d4);
        Double.isNaN(d3);
        d4 /= d3;
        d3 = d2;
        d1 = Math.max(0.0D, d1) + Math.max(0.0D, d4);
      }
      d3 = d1;
      this.e = l1;
      d3 = d1;
      this.f = l2;
      d3 = d1;
      this.g = l3;
      return d1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read pid stat file error: ");
      localStringBuilder.append(localException);
      o.b(" MicroMsg.CpuSampler", localStringBuilder.toString());
      this.d = true;
    }
    return d3;
  }
  
  public void close()
  {
    try
    {
      if (this.c != null) {
        this.c.close();
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (this.b != null) {
            this.b.close();
          }
          return;
        }
        catch (IOException localIOException2) {}
        localIOException1 = localIOException1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.om.e
 * JD-Core Version:    0.7.0.1
 */