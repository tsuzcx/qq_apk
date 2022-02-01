package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.IRecentBaseDataProcessor;

public abstract class AbsRecentStatus
  implements IRecentBaseDataProcessor
{
  public static int a = 5;
  public static int b = 10;
  
  public int a(IRecentBaseDataProcessor paramIRecentBaseDataProcessor)
  {
    if (a() == paramIRecentBaseDataProcessor.a()) {
      throw new RuntimeException("Duplication Priority! " + getClass().getName() + " ," + paramIRecentBaseDataProcessor.getClass().getName());
    }
    if (a() > paramIRecentBaseDataProcessor.a()) {
      return 1;
    }
    return -1;
  }
  
  public abstract boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus
 * JD-Core Version:    0.7.0.1
 */