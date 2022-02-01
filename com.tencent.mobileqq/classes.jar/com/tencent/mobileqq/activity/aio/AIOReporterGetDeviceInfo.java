package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class AIOReporterGetDeviceInfo
{
  private static AIOReporterGetDeviceInfo a;
  public int a;
  private int b = -1;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo = null;
  }
  
  private AIOReporterGetDeviceInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  public static AIOReporterGetDeviceInfo a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo
    //   12: dup
    //   13: invokespecial 22	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:<init>	()V
    //   16: putstatic 12	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   19: getstatic 12	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 12	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   31: iconst_1
    //   32: putfield 18	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_Int	I
    //   35: goto -16 -> 19
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localAIOReporterGetDeviceInfo	AIOReporterGetDeviceInfo
    //   38	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	38	finally
    //   19	23	38	finally
    //   28	35	38	finally
  }
  
  public int a()
  {
    if (-1 == this.b)
    {
      if ((DeviceInfoUtil.a() >>> 20 <= 1390L) || (DeviceInfoUtil.b() <= 3) || (DeviceInfoUtil.b() <= 1433L)) {
        break label48;
      }
      this.b = 1;
    }
    for (;;)
    {
      return this.b;
      label48:
      if ((DeviceInfoUtil.a() >>> 20 > 926L) && (DeviceInfoUtil.b() > 1) && (DeviceInfoUtil.b() > 961L)) {
        this.b = 2;
      } else {
        this.b = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo
 * JD-Core Version:    0.7.0.1
 */