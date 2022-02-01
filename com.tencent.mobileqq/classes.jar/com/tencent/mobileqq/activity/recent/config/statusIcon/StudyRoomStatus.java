package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class StudyRoomStatus
  extends AbsRecentStatus
{
  public static int c = 16;
  
  public int a()
  {
    return c;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {}
    do
    {
      do
      {
        return false;
      } while ((paramRecentBaseData.getRecentUserType() != 3000) && (paramRecentBaseData.getRecentUserType() != 1));
      paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
      String str = paramRecentBaseData.getRecentUserUin();
      paramBaseQQAppInterface = ((TroopManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(str);
    } while ((paramBaseQQAppInterface == null) || (!paramBaseQQAppInterface.getStudyRoomOpen()));
    paramRecentBaseData.mStatus = 11;
    return false;
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.StudyRoomStatus
 * JD-Core Version:    0.7.0.1
 */