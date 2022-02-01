package com.tencent.liteav.basic.util;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class b
{
  private static final long a = TimeUnit.SECONDS.toMillis(2L);
  private final long b = TXCTimeUtil.getClockTickInHz();
  private final int c = Runtime.getRuntime().availableProcessors();
  private RandomAccessFile d;
  private RandomAccessFile e;
  private long f = 0L;
  private float g = 0.0F;
  private float h = 0.0F;
  private long i = 0L;
  private long j = 0L;
  private float k = 0.0F;
  
  public b()
  {
    String str = String.format(Locale.ENGLISH, "/proc/%d/stat", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      this.d = new RandomAccessFile(str, "r");
    }
    catch (IOException localIOException1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open /proc/[PID]/stat failed. ");
      localStringBuilder.append(localIOException1.getMessage());
      TXCLog.e("CpuUsageMeasurer", localStringBuilder.toString());
    }
    try
    {
      this.e = new RandomAccessFile("/proc/stat", "r");
      return;
    }
    catch (IOException localIOException2) {}
  }
  
  private static String[] a(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile == null) {
      return null;
    }
    try
    {
      paramRandomAccessFile.seek(0L);
      paramRandomAccessFile = paramRandomAccessFile.readLine();
    }
    catch (IOException paramRandomAccessFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read line failed. ");
      localStringBuilder.append(paramRandomAccessFile.getMessage());
      TXCLog.e("CpuUsageMeasurer", localStringBuilder.toString());
      paramRandomAccessFile = null;
    }
    if (TextUtils.isEmpty(paramRandomAccessFile)) {
      return null;
    }
    return paramRandomAccessFile.split("\\s+");
  }
  
  private void b()
  {
    String[] arrayOfString = a(this.d);
    if (arrayOfString != null)
    {
      if (arrayOfString.length < 52) {
        return;
      }
      long l3 = ((float)(Long.parseLong(arrayOfString[13]) + Long.parseLong(arrayOfString[14]) + Long.parseLong(arrayOfString[15]) + Long.parseLong(arrayOfString[16])) * 1000.0F / (float)this.b);
      arrayOfString = a(this.e);
      long l2;
      long l1;
      if ((arrayOfString != null) && (arrayOfString.length >= 8))
      {
        l2 = Long.parseLong(arrayOfString[1]);
        long l5 = Long.parseLong(arrayOfString[2]);
        long l6 = Long.parseLong(arrayOfString[3]);
        long l7 = Long.parseLong(arrayOfString[4]);
        long l8 = Long.parseLong(arrayOfString[5]);
        long l9 = Long.parseLong(arrayOfString[6]);
        long l10 = Long.parseLong(arrayOfString[7]);
        l1 = Long.parseLong(arrayOfString[4]);
        l4 = Long.parseLong(arrayOfString[5]);
        f1 = (float)(l2 + l5 + l6 + l7 + l8 + l9 + l10);
        l5 = this.b;
        l2 = (f1 * 1000.0F / (float)l5);
        l1 = ((float)(l1 + l4) * 1000.0F / (float)l5);
      }
      else
      {
        l2 = TXCTimeUtil.getTimeTick() * this.c;
        l1 = l2;
      }
      long l4 = l2 - this.i;
      float f1 = (float)l3;
      float f2 = this.g;
      float f3 = (float)l4;
      this.h = ((f1 - f2) * 100.0F / f3);
      this.k = ((float)(l4 - (l1 - this.j)) * 100.0F / f3);
      this.g = f1;
      this.j = l1;
      this.i = l2;
      this.f = TXCTimeUtil.getTimeTick();
    }
  }
  
  public int[] a()
  {
    try
    {
      if (TXCTimeUtil.getTimeTick() - this.f >= a) {
        b();
      }
      int m = (int)(this.h * 10.0F);
      int n = (int)(this.k * 10.0F);
      return new int[] { m, n };
    }
    finally {}
  }
  
  protected void finalize()
  {
    super.finalize();
    c.a(this.d);
    c.a(this.e);
    TXCLog.i("CpuUsageMeasurer", "measurer is released");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.b
 * JD-Core Version:    0.7.0.1
 */