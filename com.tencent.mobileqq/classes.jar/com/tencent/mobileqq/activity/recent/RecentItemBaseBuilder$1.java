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
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {
      return;
    }
    if ((paramObject instanceof RecentBaseData)) {}
    label146:
    label407:
    label433:
    for (int k = ((RecentBaseData)paramObject).mMenuFlag;; k = 0)
    {
      if (((paramObject instanceof RecentBaseData)) && ((((RecentBaseData)paramObject).getRecentUserType() == 1008) || (((RecentBaseData)paramObject).getRecentUserType() == 7220)))
      {
        if ((!RecentPubAccHelper.a(((RecentBaseData)paramObject).getRecentUserUin())) || (!RecentPubAccManager.a().a()) || (RecentPubAccManager.a().a(((RecentBaseData)paramObject).getRecentUserUin()))) {
          break label473;
        }
        paramArrayOfSwipRightMenuItem[0].b = 6;
        paramArrayOfSwipRightMenuItem[0].a = 1;
      }
      label203:
      label467:
      label473:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfSwipRightMenuItem.length)
        {
          paramArrayOfSwipRightMenuItem[i].b = 0;
          paramArrayOfSwipRightMenuItem[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfSwipRightMenuItem.length)
        {
          paramArrayOfSwipRightMenuItem[paramInt].b = -1;
          paramArrayOfSwipRightMenuItem[paramInt].a = -1;
          paramInt += 1;
          continue;
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label407;
          }
          paramArrayOfSwipRightMenuItem[0].b = 2;
          paramArrayOfSwipRightMenuItem[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfSwipRightMenuItem.length)
          {
            paramInt = i;
            if ((paramObject instanceof RecentBaseData))
            {
              paramInt = i;
              if (((RecentBaseData)paramObject).isUnreadMsgNumInTabNum())
              {
                j = 0xF0000 & k;
                if (j != 65536) {
                  break label433;
                }
                paramArrayOfSwipRightMenuItem[i].b = 4;
                paramArrayOfSwipRightMenuItem[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfSwipRightMenuItem.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfSwipRightMenuItem[paramInt].b = 9;
                paramArrayOfSwipRightMenuItem[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfSwipRightMenuItem.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfSwipRightMenuItem[i].b = 0;
                paramArrayOfSwipRightMenuItem[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfSwipRightMenuItem.length) {
              break label146;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label146;
            }
            paramArrayOfSwipRightMenuItem[j].b = 6;
            paramArrayOfSwipRightMenuItem[j].a = 1;
            paramInt = j + 1;
            break label146;
            break;
            if (paramInt != 16) {
              break label467;
            }
            paramArrayOfSwipRightMenuItem[0].b = 3;
            paramArrayOfSwipRightMenuItem[0].a = 0;
            i = 1;
            break label203;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfSwipRightMenuItem[i].b = 5;
              paramArrayOfSwipRightMenuItem[i].a = 1;
              paramInt = i + 1;
            }
          }
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */