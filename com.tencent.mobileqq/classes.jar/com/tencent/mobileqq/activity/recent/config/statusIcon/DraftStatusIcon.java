package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class DraftStatusIcon
  extends AbsRecentStatus
{
  public int a()
  {
    return AbsRecentStatus.b;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade();
    if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.f(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType())))
    {
      paramRecentBaseData.mStatus = 4;
      return false;
    }
    paramRecentBaseData.mStatus = 0;
    return false;
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.DraftStatusIcon
 * JD-Core Version:    0.7.0.1
 */