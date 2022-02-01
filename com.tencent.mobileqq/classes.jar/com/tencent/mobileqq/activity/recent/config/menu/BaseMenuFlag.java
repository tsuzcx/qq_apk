package com.tencent.mobileqq.activity.recent.config.menu;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.data.RecentUser;

public class BaseMenuFlag
  extends AbsMenuFlag
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    if (!(paramRecentBaseData instanceof RecentUserBaseData)) {
      return false;
    }
    paramBaseQQAppInterface = (RecentUserBaseData)paramRecentBaseData;
    int i = paramBaseQQAppInterface.mUser.getType();
    if ((i != 0) && (i != 8) && (i != 1000) && (i != 1004) && (i != 1006) && (i != 1021)) {
      if (i != 3000)
      {
        if (i == 10004) {}
      }
      else {
        switch (i)
        {
        default: 
          break;
          paramRecentBaseData.mMenuFlag |= 0x2000;
          break;
        }
      }
    }
    paramRecentBaseData.mMenuFlag |= 0x1000;
    paramBaseQQAppInterface.b();
    paramRecentBaseData.mMenuFlag &= 0xFFFFFF0F;
    if (paramBaseQQAppInterface.mUser.showUpTime == 0L) {
      paramRecentBaseData.mMenuFlag |= 0x10;
    } else {
      paramRecentBaseData.mMenuFlag |= 0x20;
    }
    paramRecentBaseData.mMenuFlag &= 0xF0FFFFFF;
    if (paramBaseQQAppInterface.mUser.isHiddenChat == 1) {
      paramRecentBaseData.mMenuFlag |= 0x1000000;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.menu.BaseMenuFlag
 * JD-Core Version:    0.7.0.1
 */