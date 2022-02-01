package com.tencent.mobileqq.app.face;

import bgln;

class GroupIconHelper$CheckIsLowPerformanceMachineRunner
  implements Runnable
{
  GroupIconHelper$CheckIsLowPerformanceMachineRunner(GroupIconHelper paramGroupIconHelper) {}
  
  public void run()
  {
    long l = bgln.a();
    int i = bgln.b();
    if ((l != 0L) && (l < 1024L) && (i <= 1)) {
      GroupIconHelper.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.CheckIsLowPerformanceMachineRunner
 * JD-Core Version:    0.7.0.1
 */