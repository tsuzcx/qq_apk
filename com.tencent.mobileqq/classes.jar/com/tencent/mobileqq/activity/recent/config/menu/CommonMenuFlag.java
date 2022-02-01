package com.tencent.mobileqq.activity.recent.config.menu;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.HotChatUtil;

public class CommonMenuFlag
  extends AbsMenuFlag
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    paramRecentBaseData.mMenuFlag &= 0xFFFFFF0F;
    int i;
    if ((((RecentUserBaseData)paramRecentBaseData).mUser.getType() == 1) && (!HotChatUtil.a(paramBaseQQAppInterface, ((RecentUserBaseData)paramRecentBaseData).mUser)))
    {
      paramBaseQQAppInterface = (TroopManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      int j = paramRecentBaseData.mMenuFlag;
      if (paramBaseQQAppInterface.b(((RecentUserBaseData)paramRecentBaseData).mUser.uin))
      {
        i = 32;
        label91:
        paramRecentBaseData.mMenuFlag = (i | j);
      }
    }
    for (;;)
    {
      paramRecentBaseData.mMenuFlag &= 0xF0FFFFFF;
      if (((RecentUserBaseData)paramRecentBaseData).mUser.isHiddenChat != 1) {
        break;
      }
      paramRecentBaseData.mMenuFlag |= 0x1000000;
      return false;
      i = 16;
      break label91;
      if (!((TempMsgBoxManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType()))
      {
        FriendsStatusUtil.a(paramBaseQQAppInterface, ((RecentUserBaseData)paramRecentBaseData).mUser);
        if ((((RecentUserBaseData)paramRecentBaseData).mUser.showUpTime == 0L) && (9223372036854775807L - ((RecentUserBaseData)paramRecentBaseData).mUser.lastmsgtime > 4L)) {
          paramRecentBaseData.mMenuFlag |= 0x10;
        } else {
          paramRecentBaseData.mMenuFlag |= 0x20;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.menu.CommonMenuFlag
 * JD-Core Version:    0.7.0.1
 */