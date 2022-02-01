package com.tencent.mobileqq.activity.recent.config.menu;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class CommonMenuFlag
  extends AbsMenuFlag
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    Object localObject = (QQAppInterface)paramBaseQQAppInterface;
    paramRecentBaseData.mMenuFlag &= 0xFFFFFF0F;
    paramBaseQQAppInterface = (RecentUserBaseData)paramRecentBaseData;
    int j = paramBaseQQAppInterface.mUser.getType();
    int i = 16;
    if ((j == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(localObject, paramBaseQQAppInterface.mUser)))
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      j = paramRecentBaseData.mMenuFlag;
      if (((TroopManager)localObject).a(paramBaseQQAppInterface.mUser.uin)) {
        i = 32;
      }
      paramRecentBaseData.mMenuFlag = (j | i);
    }
    else if (!((ITempMsgBoxManager)((QQAppInterface)localObject).getRuntimeService(ITempMsgBoxManager.class, "")).isBelongToFilterBox(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType()))
    {
      FriendsStatusUtil.a((QQAppInterface)localObject, paramBaseQQAppInterface.mUser);
      if ((paramBaseQQAppInterface.mUser.showUpTime == 0L) && (9223372036854775807L - paramBaseQQAppInterface.mUser.lastmsgtime > 4L)) {
        paramRecentBaseData.mMenuFlag |= 0x10;
      } else {
        paramRecentBaseData.mMenuFlag |= 0x20;
      }
    }
    paramRecentBaseData.mMenuFlag &= 0xF0FFFFFF;
    if (paramBaseQQAppInterface.mUser.isHiddenChat == 1) {
      paramRecentBaseData.mMenuFlag |= 0x1000000;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.menu.CommonMenuFlag
 * JD-Core Version:    0.7.0.1
 */