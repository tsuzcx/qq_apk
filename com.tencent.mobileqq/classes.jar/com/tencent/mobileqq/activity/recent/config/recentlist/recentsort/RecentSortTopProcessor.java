package com.tencent.mobileqq.activity.recent.config.recentlist.recentsort;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortTopProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class RecentSortTopProcessor
  implements IRecentSortTopProcessor
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData)
  {
    return b(paramBaseQQAppInterface, paramRecentUserBaseData);
  }
  
  public boolean b(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    if ((paramRecentUserBaseData.mUser.getType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser((QQAppInterface)paramBaseQQAppInterface, paramRecentUserBaseData.mUser))) {
      return ((TroopManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramRecentUserBaseData.getRecentUserUin());
    }
    return FriendsStatusUtil.a((QQAppInterface)paramBaseQQAppInterface, paramRecentUserBaseData.mUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentsort.RecentSortTopProcessor
 * JD-Core Version:    0.7.0.1
 */