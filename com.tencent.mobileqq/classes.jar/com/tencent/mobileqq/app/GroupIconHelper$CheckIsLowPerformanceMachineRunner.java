package com.tencent.mobileqq.app;

import bdgk;

class GroupIconHelper$CheckIsLowPerformanceMachineRunner
  implements Runnable
{
  GroupIconHelper$CheckIsLowPerformanceMachineRunner(GroupIconHelper paramGroupIconHelper) {}
  
  public void run()
  {
    long l = bdgk.a();
    int i = bdgk.b();
    if ((l != 0L) && (l < 1024L) && (i <= 1)) {
      GroupIconHelper.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GroupIconHelper.CheckIsLowPerformanceMachineRunner
 * JD-Core Version:    0.7.0.1
 */