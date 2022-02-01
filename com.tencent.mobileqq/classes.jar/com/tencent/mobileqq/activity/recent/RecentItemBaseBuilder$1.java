package com.tencent.mobileqq.activity.recent;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class RecentItemBaseBuilder$1
  extends SwipTextViewMenuBuilder
{
  RecentItemBaseBuilder$1(RecentItemBaseBuilder paramRecentItemBaseBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      boolean bool = paramObject instanceof RecentBaseData;
      int j;
      if (bool) {
        j = ((RecentBaseData)paramObject).mMenuFlag;
      } else {
        j = 0;
      }
      int i = 1;
      if (bool)
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        if ((localRecentBaseData.getRecentUserType() == 1008) || (localRecentBaseData.getRecentUserType() == 7220))
        {
          if ((RecentPubAccHelper.a(localRecentBaseData.getRecentUserUin())) && (RecentPubAccManager.a().a()) && (!RecentPubAccManager.a().a(localRecentBaseData.getRecentUserUin())))
          {
            paramArrayOfSwipRightMenuItem[0].menuId = 6;
            paramArrayOfSwipRightMenuItem[0].menuType = 1;
          }
          else
          {
            i = 0;
          }
          paramInt = i;
          if (i >= paramArrayOfSwipRightMenuItem.length) {
            break label443;
          }
          paramArrayOfSwipRightMenuItem[i].menuId = 0;
          paramArrayOfSwipRightMenuItem[i].menuType = 0;
          paramInt = i;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break label443;
        paramInt = j & 0xF0;
        if (paramInt == 32) {
          paramArrayOfSwipRightMenuItem[0].menuId = 2;
        }
        for (paramArrayOfSwipRightMenuItem[0].menuType = 1;; paramArrayOfSwipRightMenuItem[0].menuType = 0)
        {
          i = 1;
          break label222;
          if (paramInt != 16) {
            break;
          }
          paramArrayOfSwipRightMenuItem[0].menuId = 3;
        }
        i = 0;
        label222:
        paramInt = i;
        if (i < paramArrayOfSwipRightMenuItem.length)
        {
          paramInt = i;
          if (bool)
          {
            paramInt = i;
            if (((RecentBaseData)paramObject).isUnreadMsgNumInTabNum())
            {
              int k = 0xF0000 & j;
              if (k == 65536) {
                paramArrayOfSwipRightMenuItem[i].menuId = 4;
              }
              for (paramArrayOfSwipRightMenuItem[i].menuType = 1;; paramArrayOfSwipRightMenuItem[i].menuType = 1)
              {
                paramInt = i + 1;
                break;
                paramInt = i;
                if (k != 131072) {
                  break;
                }
                paramArrayOfSwipRightMenuItem[i].menuId = 5;
              }
            }
          }
        }
        i = paramInt;
        if (paramInt < paramArrayOfSwipRightMenuItem.length)
        {
          i = paramInt;
          if ((0xF000000 & j) == 16777216)
          {
            paramArrayOfSwipRightMenuItem[paramInt].menuId = 9;
            paramArrayOfSwipRightMenuItem[paramInt].menuType = 1;
            i = paramInt + 1;
          }
        }
        paramInt = i;
        if (i < paramArrayOfSwipRightMenuItem.length)
        {
          paramInt = i;
          if ((j & 0xF) == 1)
          {
            paramArrayOfSwipRightMenuItem[i].menuId = 0;
            paramArrayOfSwipRightMenuItem[i].menuType = 0;
            paramInt = i + 1;
          }
        }
        if ((paramInt < paramArrayOfSwipRightMenuItem.length) && ((0x300000 & j) == 2097152))
        {
          paramArrayOfSwipRightMenuItem[paramInt].menuId = 6;
          paramArrayOfSwipRightMenuItem[paramInt].menuType = 1;
          paramInt += 1;
        }
        label443:
        if (paramInt >= paramArrayOfSwipRightMenuItem.length) {
          break;
        }
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */