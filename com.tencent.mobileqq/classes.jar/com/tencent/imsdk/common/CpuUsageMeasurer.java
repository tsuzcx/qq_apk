package com.tencent.imsdk.common;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.imsdk.manager.BaseManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CpuUsageMeasurer
{
  private static final String TAG = "CpuUsageMeasurer";
  private static final long UPDATE_INTERVAL = TimeUnit.SECONDS.toMillis(2L);
  private final long mClockClkInHz = BaseManager.getInstance().getClockTickInHz();
  private long mIdleCpuTime = 0L;
  private float mLastAppCpuTimeUsed = 0.0F;
  private float mLastAppCpuUsage = 0.0F;
  private float mLastSysCpuUsage = 0.0F;
  private long mLastUpdateTime = 0L;
  private RandomAccessFile mProcessStatFile;
  private final int mProcessorCount = Runtime.getRuntime().availableProcessors();
  private RandomAccessFile mSystemStatFile;
  private long mTotalCpuTime = 0L;
  
  public CpuUsageMeasurer()
  {
    String str = String.format(Locale.ENGLISH, "/proc/%d/stat", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      this.mProcessStatFile = new RandomAccessFile(str, "r");
    }
    catch (IOException localIOException1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open /proc/[PID]/stat failed. ");
      localStringBuilder.append(localIOException1.getMessage());
      IMLog.e("CpuUsageMeasurer", localStringBuilder.toString());
    }
    try
    {
      this.mSystemStatFile = new RandomAccessFile("/proc/stat", "r");
      return;
    }
    catch (IOException localIOException2) {}
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static String[] readFirstLineAndSplit(RandomAccessFile paramRandomAccessFile)
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
      IMLog.e("CpuUsageMeasurer", localStringBuilder.toString());
      paramRandomAccessFile = null;
    }
    if (TextUtils.isEmpty(paramRandomAccessFile)) {
      return null;
    }
    return paramRandomAccessFile.split("\\s+");
  }
  
  private void updateCpuUsage()
  {
    String[] arrayOfString = readFirstLineAndSplit(this.mProcessStatFile);
    if (arrayOfString != null)
    {
      if (arrayOfString.length < 52) {
        return;
      }
      long l3 = ((float)(Long.parseLong(arrayOfString[13]) + Long.parseLong(arrayOfString[14]) + Long.parseLong(arrayOfString[15]) + Long.parseLong(arrayOfString[16])) * 1000.0F / (float)this.mClockClkInHz);
      arrayOfString = readFirstLineAndSplit(this.mSystemStatFile);
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
        l5 = this.mClockClkInHz;
        l2 = (f1 * 1000.0F / (float)l5);
        l1 = ((float)(l1 + l4) * 1000.0F / (float)l5);
      }
      else
      {
        l2 = BaseManager.getInstance().getTimeTick() * this.mProcessorCount;
        l1 = l2;
      }
      long l4 = l2 - this.mTotalCpuTime;
      float f1 = (float)l3;
      float f2 = this.mLastAppCpuTimeUsed;
      float f3 = (float)l4;
      this.mLastAppCpuUsage = ((f1 - f2) * 100.0F / f3);
      this.mLastSysCpuUsage = ((float)(l4 - (l1 - this.mIdleCpuTime)) * 100.0F / f3);
      this.mLastAppCpuTimeUsed = f1;
      this.mIdleCpuTime = l1;
      this.mTotalCpuTime = l2;
      this.mLastUpdateTime = BaseManager.getInstance().getTimeTick();
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    closeQuietly(this.mProcessStatFile);
    closeQuietly(this.mSystemStatFile);
    IMLog.i("CpuUsageMeasurer", "measurer is released");
  }
  
  int[] getCpuUsage()
  {
    try
    {
      if (BaseManager.getInstance().getTimeTick() - this.mLastUpdateTime >= UPDATE_INTERVAL) {
        updateCpuUsage();
      }
      int i = (int)(this.mLastAppCpuUsage * 10.0F);
      int j = (int)(this.mLastSysCpuUsage * 10.0F);
      return new int[] { i, j };
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.CpuUsageMeasurer
 * JD-Core Version:    0.7.0.1
 */