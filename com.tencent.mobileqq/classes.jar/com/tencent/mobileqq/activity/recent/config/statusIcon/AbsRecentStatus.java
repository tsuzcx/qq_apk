package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.IRecentProcessor;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public abstract class AbsRecentStatus
  implements IRecentProcessor
{
  public static int PRIORITY_DRAFT = 10;
  public static int PRIORITY_VIDEO = 5;
  
  public int compareTo(IRecentProcessor paramIRecentProcessor)
  {
    if (priority() == paramIRecentProcessor.priority()) {
      throw new RuntimeException("Duplication Priority! " + getClass().getName() + " ," + paramIRecentProcessor.getClass().getName());
    }
    if (priority() > paramIRecentProcessor.priority()) {
      return 1;
    }
    return -1;
  }
  
  public abstract int[] declareStatus();
  
  public abstract boolean focusUINType(RecentBaseData paramRecentBaseData, IMCoreAppRuntime paramIMCoreAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus
 * JD-Core Version:    0.7.0.1
 */