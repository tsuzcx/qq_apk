package com.tencent.mobileqq.activity.recent.config.statusIcon;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.ILocationShareService;
import mqq.app.AppRuntime;

public class ShareLocationStatus
  extends AbsRecentStatus
{
  private static int c = 15;
  
  public int a()
  {
    return c;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = (QQAppInterface)paramBaseQQAppInterface;
        paramBaseQQAppInterface = paramRecentBaseData.getRecentUserUin();
        localObject = LocationShareServiceHolder.a((AppRuntime)localObject);
        paramRecentBaseData.mStatus = 0;
        if (paramRecentBaseData.getRecentUserType() != 1) {
          break;
        }
      } while (!((ILocationShareService)localObject).isSessionSharingLocation(1, paramBaseQQAppInterface));
      paramRecentBaseData.mStatus = 8;
      return false;
    } while ((paramRecentBaseData.getRecentUserType() != 0) || (!((ILocationShareService)localObject).isSessionSharingLocation(0, paramBaseQQAppInterface)));
    paramRecentBaseData.mStatus = 8;
    return false;
  }
  
  public boolean a(RecentBaseData paramRecentBaseData, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.statusIcon.ShareLocationStatus
 * JD-Core Version:    0.7.0.1
 */