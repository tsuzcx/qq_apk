package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

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
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    } else {
      paramBaseQQAppInterface = null;
    }
    if (paramBaseQQAppInterface != null)
    {
      if (paramRecentBaseData == null) {
        return false;
      }
      int i = paramRecentBaseData.getRecentUserType();
      String str = paramRecentBaseData.getRecentUserUin();
      if ((i == 1) && ((paramRecentBaseData.mStatus == 0) || (paramRecentBaseData.mStatus == 10)))
      {
        paramRecentBaseData.mStatus = 0;
        paramBaseQQAppInterface = (IAvGameManager)paramBaseQQAppInterface.getRuntimeService(IAvGameManager.class);
        if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.isAVGameOpen(str))) {
          paramRecentBaseData.mStatus = 10;
        }
      }
    }
    return false;
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