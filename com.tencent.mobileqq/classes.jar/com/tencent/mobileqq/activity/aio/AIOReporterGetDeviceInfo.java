package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class AIOReporterGetDeviceInfo
{
  private static AIOReporterGetDeviceInfo a;
  public int a;
  private int b = -1;
  
  private AIOReporterGetDeviceInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static AIOReporterGetDeviceInfo a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo = new AIOReporterGetDeviceInfo();
      } else {
        jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo.jdField_a_of_type_Int = 1;
      }
      AIOReporterGetDeviceInfo localAIOReporterGetDeviceInfo = jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo;
      return localAIOReporterGetDeviceInfo;
    }
    finally {}
  }
  
  public int a()
  {
    if (-1 == this.b) {
      if ((DeviceInfoUtil.a() >>> 20 > 1390L) && (DeviceInfoUtil.b() > 3) && (DeviceInfoUtil.b() > 1433L)) {
        this.b = 1;
      } else if ((DeviceInfoUtil.a() >>> 20 > 926L) && (DeviceInfoUtil.b() > 1) && (DeviceInfoUtil.b() > 961L)) {
        this.b = 2;
      } else {
        this.b = 3;
      }
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo
 * JD-Core Version:    0.7.0.1
 */