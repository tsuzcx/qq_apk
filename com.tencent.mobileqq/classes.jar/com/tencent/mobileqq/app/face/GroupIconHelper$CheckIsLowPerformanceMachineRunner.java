package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.utils.DeviceInfoUtil;

class GroupIconHelper$CheckIsLowPerformanceMachineRunner
  implements Runnable
{
  GroupIconHelper$CheckIsLowPerformanceMachineRunner(GroupIconHelper paramGroupIconHelper) {}
  
  public void run()
  {
    long l = DeviceInfoUtil.b();
    int i = DeviceInfoUtil.b();
    if ((l != 0L) && (l < 1024L) && (i <= 1)) {
      GroupIconHelper.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.CheckIsLowPerformanceMachineRunner
 * JD-Core Version:    0.7.0.1
 */