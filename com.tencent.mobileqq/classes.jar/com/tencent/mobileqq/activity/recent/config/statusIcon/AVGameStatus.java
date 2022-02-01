package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.avgame.business.AvGameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class AVGameStatus
  extends AbsRecentStatus
{
  private static int c = 8;
  
  public int a()
  {
    return c;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {}
    for (paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;; paramBaseQQAppInterface = null)
    {
      if ((paramBaseQQAppInterface == null) || (paramRecentBaseData == null)) {}
      String str;
      do
      {
        int i;
        do
        {
          return false;
          i = paramRecentBaseData.getRecentUserType();
          str = paramRecentBaseData.getRecentUserUin();
        } while ((i != 1) || ((paramRecentBaseData.mStatus != 0) && (paramRecentBaseData.mStatus != 10)));
        paramRecentBaseData.mStatus = 0;
        paramBaseQQAppInterface = (AvGameManager)paramBaseQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
      } while ((paramBaseQQAppInterface == null) || (!paramBaseQQAppInterface.b(str)));
      paramRecentBaseData.mStatus = 10;
      return false;
    }
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramRecentBaseData.getRecentUserType() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.AVGameStatus
 * JD-Core Version:    0.7.0.1
 */