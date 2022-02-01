package com.tencent.mm.hardcoder;

import android.util.Log;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class HCPerfManager$PerformanceTask
  extends RecyclablePool.Recyclable
{
  public long action = 0L;
  public long averageCoreFreq = 0L;
  public int[] bindCoreThreadIdArray = null;
  public int bindTid = 0;
  public int callerTid = 0;
  public int cpuLevel = 0;
  public int[] cpuLevelTimeArray = new int[HCPerfManager.access$000().length];
  public int delay = 0;
  public long initTime = 0L;
  public int ioLevel = 0;
  public int[] ioLevelTimeArray = new int[HCPerfManager.access$100().length];
  int lastCpuLevel = 0;
  int lastIoLevel = 0;
  long lastUpdateTime = 0L;
  public int scene = 0;
  public long sceneStartTime = 0L;
  public long sceneStopTime = 0L;
  public long[] startProcessJiffies = null;
  public long[] startThreadJiffies = null;
  public long startTime = 0L;
  public long stopTime = 0L;
  public long sumProcessJiffies = 0L;
  public int sumThreadJiffies = 0;
  public String tag;
  public int timeout = 0;
  
  public String toString(long paramLong)
  {
    return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.initTime - paramLong), Long.valueOf(this.startTime - paramLong), Long.valueOf(this.stopTime - paramLong), Integer.valueOf(this.delay), Integer.valueOf(this.timeout), Integer.valueOf(this.scene), Long.valueOf(this.action), Integer.valueOf(this.callerTid), Integer.valueOf(this.cpuLevel), Integer.valueOf(this.ioLevel), Integer.valueOf(this.bindTid), this.tag });
  }
  
  void update(long paramLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.averageCoreFreq = ((this.averageCoreFreq + paramLong) / 2L);
    if ((paramArrayOfLong1 != null) && (this.bindTid > 0))
    {
      paramLong = paramArrayOfLong1[0];
      paramArrayOfLong2 = this.startThreadJiffies;
      this.sumThreadJiffies = ((int)(paramLong - paramArrayOfLong2[0] + (paramArrayOfLong1[1] - paramArrayOfLong2[1])));
      if (HardCoderJNI.hcDebug)
      {
        paramArrayOfLong2 = new StringBuilder();
        paramArrayOfLong2.append("thread id:");
        paramArrayOfLong2.append(this.bindTid);
        paramArrayOfLong2.append(",start jiffies:[");
        paramArrayOfLong2.append(this.startThreadJiffies[0]);
        paramArrayOfLong2.append(",");
        paramArrayOfLong2.append(this.startThreadJiffies[1]);
        paramArrayOfLong2.append("], end jiffies:[");
        paramArrayOfLong2.append(paramArrayOfLong1[0]);
        paramArrayOfLong2.append(",");
        paramArrayOfLong2.append(paramArrayOfLong1[1]);
        paramArrayOfLong2.append("],sum thread jiffies:");
        paramArrayOfLong2.append(this.sumThreadJiffies);
        Log.d("HardCoder.HCPerfManager", paramArrayOfLong2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HCPerfManager.PerformanceTask
 * JD-Core Version:    0.7.0.1
 */