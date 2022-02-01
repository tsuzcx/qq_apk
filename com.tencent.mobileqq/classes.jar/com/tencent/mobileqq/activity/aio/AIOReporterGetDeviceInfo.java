package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class AIOReporterGetDeviceInfo
{
  private static AIOReporterGetDeviceInfo b;
  public int a = 0;
  private int c = -1;
  
  public static AIOReporterGetDeviceInfo a()
  {
    try
    {
      if (b == null) {
        b = new AIOReporterGetDeviceInfo();
      } else {
        b.a = 1;
      }
      AIOReporterGetDeviceInfo localAIOReporterGetDeviceInfo = b;
      return localAIOReporterGetDeviceInfo;
    }
    finally {}
  }
  
  public int b()
  {
    if (-1 == this.c) {
      if ((DeviceInfoUtil.a() >>> 20 > 1390L) && (DeviceInfoUtil.h() > 3) && (DeviceInfoUtil.k() > 1433L)) {
        this.c = 1;
      } else if ((DeviceInfoUtil.a() >>> 20 > 926L) && (DeviceInfoUtil.h() > 1) && (DeviceInfoUtil.k() > 961L)) {
        this.c = 2;
      } else {
        this.c = 3;
      }
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo
 * JD-Core Version:    0.7.0.1
 */