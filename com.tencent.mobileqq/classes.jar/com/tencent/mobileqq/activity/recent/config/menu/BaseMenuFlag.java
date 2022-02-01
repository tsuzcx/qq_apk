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
    switch (((RecentUserBaseData)paramRecentBaseData).mUser.getType())
    {
    default: 
      label116:
      ((RecentUserBaseData)paramRecentBaseData).b();
      paramRecentBaseData.mMenuFlag &= 0xFFFFFF0F;
      if (((RecentUserBaseData)paramRecentBaseData).mUser.showUpTime != 0L) {
        break;
      }
    }
    for (paramRecentBaseData.mMenuFlag |= 0x10;; paramRecentBaseData.mMenuFlag |= 0x20)
    {
      paramRecentBaseData.mMenuFlag &= 0xF0FFFFFF;
      if (((RecentUserBaseData)paramRecentBaseData).mUser.isHiddenChat != 1) {
        break;
      }
      paramRecentBaseData.mMenuFlag |= 0x1000000;
      return false;
      paramRecentBaseData.mMenuFlag |= 0x1000;
      break label116;
      paramRecentBaseData.mMenuFlag |= 0x2000;
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.menu.BaseMenuFlag
 * JD-Core Version:    0.7.0.1
 */