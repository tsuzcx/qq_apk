package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

public class ListenTogetherStatus
  extends AbsRecentStatus
{
  private static int c = 20;
  
  public int a()
  {
    return c;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    Object localObject = (QQAppInterface)paramBaseQQAppInterface;
    paramBaseQQAppInterface = paramRecentBaseData.getRecentUserUin();
    paramRecentBaseData.mStatus = 0;
    localObject = (ListenTogetherManager)((QQAppInterface)localObject).getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
    if (((paramRecentBaseData.getRecentUserType() == 3000) || (paramRecentBaseData.getRecentUserType() == 1)) && (((ListenTogetherManager)localObject).c(1, paramBaseQQAppInterface)))
    {
      paramRecentBaseData.mStatus = 6;
      return false;
    }
    if ((paramRecentBaseData.getRecentUserType() == 0) && (((ListenTogetherManager)localObject).c(2, paramBaseQQAppInterface))) {
      paramRecentBaseData.mStatus = 6;
    }
    return false;
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.ListenTogetherStatus
 * JD-Core Version:    0.7.0.1
 */