package com.tencent.mobileqq.activity.recent;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class RecentItemBaseBuilder$RecentSwipeTextViewMenuBuilder
  extends SwipTextViewMenuBuilder
{
  public RecentItemBaseBuilder$RecentSwipeTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  private int a(RecentBaseData paramRecentBaseData, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, int paramInt)
  {
    int i = paramInt;
    if (RecentPubAccHelper.a(paramRecentBaseData.getRecentUserUin()))
    {
      i = paramInt;
      if (RecentPubAccManager.a().b())
      {
        i = paramInt;
        if (!RecentPubAccManager.a().a(paramRecentBaseData.getRecentUserUin()))
        {
          paramArrayOfSwipRightMenuItem[paramInt].menuId = 6;
          paramArrayOfSwipRightMenuItem[paramInt].menuType = 1;
          i = paramInt + 1;
        }
      }
    }
    paramInt = i;
    if (i < paramArrayOfSwipRightMenuItem.length)
    {
      paramArrayOfSwipRightMenuItem[i].menuId = 0;
      paramArrayOfSwipRightMenuItem[i].menuType = 0;
      paramInt = i + 1;
    }
    return paramInt;
  }
  
  private int a(RecentBaseData paramRecentBaseData, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (RecentPubAccHelper.a())
    {
      paramInt1 &= 0xF0;
      if (paramInt1 == 32) {
        paramArrayOfSwipRightMenuItem[paramInt2].menuId = 2;
      }
      for (paramArrayOfSwipRightMenuItem[paramInt2].menuType = 1;; paramArrayOfSwipRightMenuItem[paramInt2].menuType = 0)
      {
        i = paramInt2 + 1;
        break;
        i = paramInt2;
        if (paramInt1 != 16) {
          break;
        }
        paramArrayOfSwipRightMenuItem[paramInt2].menuId = 3;
      }
    }
    paramInt1 = i;
    if (i < paramArrayOfSwipRightMenuItem.length)
    {
      paramInt1 = i;
      if (RecentPubAccHelper.a(paramRecentBaseData.getRecentUserUin()))
      {
        paramInt1 = i;
        if (RecentPubAccManager.a().b())
        {
          paramInt1 = i;
          if (!RecentPubAccManager.a().a(paramRecentBaseData.getRecentUserUin()))
          {
            paramRecentBaseData = paramArrayOfSwipRightMenuItem[i];
            if (RecentPubAccHelper.a()) {
              paramInt1 = 11;
            } else {
              paramInt1 = 6;
            }
            paramRecentBaseData.menuId = paramInt1;
            paramArrayOfSwipRightMenuItem[i].menuType = 1;
            paramInt1 = i + 1;
          }
        }
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 < paramArrayOfSwipRightMenuItem.length)
    {
      paramRecentBaseData = paramArrayOfSwipRightMenuItem[paramInt1];
      if (RecentPubAccHelper.a()) {
        paramInt2 = 10;
      } else {
        paramInt2 = 0;
      }
      paramRecentBaseData.menuId = paramInt2;
      paramArrayOfSwipRightMenuItem[paramInt1].menuType = 0;
      paramInt2 = paramInt1 + 1;
    }
    return paramInt2;
  }
  
  private int a(Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, int paramInt1, int paramInt2)
  {
    int j = paramInt1 & 0xF0;
    if (j == 32) {
      paramArrayOfSwipRightMenuItem[paramInt2].menuId = 2;
    }
    for (paramArrayOfSwipRightMenuItem[paramInt2].menuType = 1;; paramArrayOfSwipRightMenuItem[paramInt2].menuType = 0)
    {
      i = paramInt2 + 1;
      break;
      i = paramInt2;
      if (j != 16) {
        break;
      }
      paramArrayOfSwipRightMenuItem[paramInt2].menuId = 3;
    }
    paramInt2 = i;
    if (i < paramArrayOfSwipRightMenuItem.length)
    {
      paramInt2 = i;
      if ((paramObject instanceof RecentBaseData))
      {
        paramInt2 = i;
        if (((RecentBaseData)paramObject).isUnreadMsgNumInTabNum())
        {
          j = 0xF0000 & paramInt1;
          if (j == 65536) {
            paramArrayOfSwipRightMenuItem[i].menuId = 4;
          }
          for (paramArrayOfSwipRightMenuItem[i].menuType = 1;; paramArrayOfSwipRightMenuItem[i].menuType = 1)
          {
            paramInt2 = i + 1;
            break;
            paramInt2 = i;
            if (j != 131072) {
              break;
            }
            paramArrayOfSwipRightMenuItem[i].menuId = 5;
          }
        }
      }
    }
    int i = paramInt2;
    if (paramInt2 < paramArrayOfSwipRightMenuItem.length)
    {
      i = paramInt2;
      if ((0xF000000 & paramInt1) == 16777216)
      {
        paramArrayOfSwipRightMenuItem[paramInt2].menuId = 9;
        paramArrayOfSwipRightMenuItem[paramInt2].menuType = 1;
        i = paramInt2 + 1;
      }
    }
    paramInt2 = i;
    if (i < paramArrayOfSwipRightMenuItem.length)
    {
      paramInt2 = i;
      if ((paramInt1 & 0xF) == 1)
      {
        paramArrayOfSwipRightMenuItem[i].menuId = 0;
        paramArrayOfSwipRightMenuItem[i].menuType = 0;
        paramInt2 = i + 1;
      }
    }
    i = paramInt2;
    if (paramInt2 < paramArrayOfSwipRightMenuItem.length)
    {
      i = paramInt2;
      if ((0x300000 & paramInt1) == 2097152)
      {
        paramArrayOfSwipRightMenuItem[paramInt2].menuId = 6;
        paramArrayOfSwipRightMenuItem[paramInt2].menuType = 1;
        i = paramInt2 + 1;
      }
    }
    return i;
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      boolean bool = paramObject instanceof RecentBaseData;
      if (bool) {
        paramInt = ((RecentBaseData)paramObject).mMenuFlag;
      } else {
        paramInt = 0;
      }
      RecentBaseData localRecentBaseData;
      if (bool)
      {
        localRecentBaseData = (RecentBaseData)paramObject;
        if (localRecentBaseData.getRecentUserType() == 7220)
        {
          paramInt = a(localRecentBaseData, paramArrayOfSwipRightMenuItem, 0);
          break label112;
        }
      }
      if (bool)
      {
        localRecentBaseData = (RecentBaseData)paramObject;
        if (localRecentBaseData.getRecentUserType() == 1008)
        {
          paramInt = a(localRecentBaseData, paramArrayOfSwipRightMenuItem, paramInt, 0);
          break label112;
        }
      }
      paramInt = a(paramObject, paramArrayOfSwipRightMenuItem, paramInt, 0);
      label112:
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.RecentSwipeTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */