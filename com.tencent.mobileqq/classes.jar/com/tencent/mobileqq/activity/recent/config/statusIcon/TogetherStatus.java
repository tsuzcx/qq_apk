package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.together.TogetherControlManager;

public class TogetherStatus
  extends AbsRecentStatus
{
  private static int c = 25;
  
  public int a()
  {
    return c;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    if (paramRecentBaseData.mStatus != 4)
    {
      int j = paramRecentBaseData.getRecentUserType();
      int i = 1;
      if ((j == 1) || (paramRecentBaseData.getRecentUserType() == 0))
      {
        String str = paramRecentBaseData.getRecentUserUin();
        if (paramRecentBaseData.getRecentUserType() != 1) {
          i = 2;
        }
        i = ((TogetherControlManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(i, str);
        if (((paramRecentBaseData.mStatus == 0) || (paramRecentBaseData.mStatus >= i)) && (i != 0)) {
          paramRecentBaseData.mStatus = i;
        }
      }
    }
    return false;
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.TogetherStatus
 * JD-Core Version:    0.7.0.1
 */