package com.tencent.biz.expand.utils;

import android.net.TrafficStats;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/NetSpeedChecker;", "", "()V", "computeDownloadLeftTime", "", "interval", "bytes", "", "startSize", "", "computeNetworkData", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NetSpeedChecker
{
  public static final NetSpeedChecker.Companion a = new NetSpeedChecker.Companion(null);
  
  private final double a(long paramLong)
  {
    return (TrafficStats.getTotalRxBytes() - paramLong) / 1024 * 1.0D;
  }
  
  public final double a(double paramDouble, int paramInt, long paramLong)
  {
    double d = a(paramLong);
    paramDouble = d / paramDouble;
    QLog.d("NetSpeedChecker", 4, "downloadData " + d + " speed " + paramDouble + " kb/s bytes " + paramInt);
    return paramInt / 1024 / paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.NetSpeedChecker
 * JD-Core Version:    0.7.0.1
 */