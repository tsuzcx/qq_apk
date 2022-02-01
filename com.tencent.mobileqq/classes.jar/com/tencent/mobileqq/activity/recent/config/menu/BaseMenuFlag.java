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
    switch (paramBaseQQAppInterface.mUser.getType())
    {
    default: 
      break;
    case 3000: 
      paramRecentBaseData.mMenuFlag |= 0x2000;
      break;
    case 0: 
    case 8: 
    case 1000: 
    case 1004: 
    case 1006: 
    case 1021: 
    case 10004: 
    case 10008: 
    case 10010: 
    case 10013: 
      paramRecentBaseData.mMenuFlag |= 0x1000;
    }
    paramBaseQQAppInterface.d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.menu.BaseMenuFlag
 * JD-Core Version:    0.7.0.1
 */