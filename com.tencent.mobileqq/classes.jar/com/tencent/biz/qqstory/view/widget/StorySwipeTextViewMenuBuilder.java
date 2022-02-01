package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.Stack;

public abstract class StorySwipeTextViewMenuBuilder
  extends SwipTextViewMenuBuilder
{
  public StorySwipeTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramSwipRightMenuItem = new LinearLayout.LayoutParams(paramSwipRightMenuItem.menuWidth, paramSwipRightMenuItem.menuHeight);
      paramView.setLayoutParams(paramSwipRightMenuItem);
    }
    else
    {
      localLayoutParams.width = paramSwipRightMenuItem.menuWidth;
      localLayoutParams.height = paramSwipRightMenuItem.menuHeight;
      paramSwipRightMenuItem = localLayoutParams;
    }
    paramSwipRightMenuItem.gravity = 16;
    paramViewGroup.addView(paramView, paramInt);
  }
  
  public int updateRightMenuView(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (((paramView instanceof LinearLayout)) && (paramSwipItemBaseHolder != null) && (paramSwipItemBaseHolder.rightMenuItems != null) && (paramSwipItemBaseHolder.rightMenuItems.length != 0))
    {
      if (paramSwipItemBaseHolder.rightMenuItems.length > this.mMaxMenuCount) {
        return 0;
      }
      LinearLayout localLinearLayout = (LinearLayout)paramView;
      getRightMenuItemInfo(paramInt, paramObject, this.mTempMenus);
      int j = 0;
      int m = 0;
      int i;
      for (int k = 0; j < this.mMaxMenuCount; k = i)
      {
        i = this.mMenuViewCache.length;
        int i1 = 1;
        if ((i > 1) && (paramSwipItemBaseHolder.rightMenuItems[j].menuType != this.mTempMenus[j].menuType)) {
          recycleMenuView(paramSwipItemBaseHolder.rightMenuItems[j]);
        }
        paramSwipItemBaseHolder.rightMenuItems[j].menuType = this.mTempMenus[j].menuType;
        paramSwipItemBaseHolder.rightMenuItems[j].menuId = this.mTempMenus[j].menuId;
        paramSwipItemBaseHolder.rightMenuItems[j].menuWidth = 0;
        paramSwipItemBaseHolder.rightMenuItems[j].menuHeight = -1;
        i = paramSwipItemBaseHolder.rightMenuItems[j].menuType;
        View localView = paramSwipItemBaseHolder.rightMenuItems[j].menuView;
        label343:
        int n;
        if ((i >= 0) && (i < this.mMenuViewCache.length))
        {
          if (localView == null) {
            synchronized (this.mMenuViewCache)
            {
              if (!this.mMenuViewCache[i].isEmpty()) {
                localView = (View)this.mMenuViewCache[i].pop();
              }
              if (localView == null) {
                localView = createRightMenuItem(paramContext, i);
              }
              if (localView != null)
              {
                paramSwipItemBaseHolder.rightMenuItems[j].menuView = localView;
                break label343;
              }
              throw new NullPointerException("updateRightMenuView menuView is null");
            }
          }
          i1 = 0;
          updateRightMenuItem(paramInt, paramObject, paramSwipItemBaseHolder.rightMenuItems[j], paramOnClickListener);
          if (paramSwipItemBaseHolder.rightMenuItems[j].menuWidth >= 0)
          {
            m += paramSwipItemBaseHolder.rightMenuItems[j].menuWidth;
            k += 1;
            localView.setVisibility(0);
            n = m;
            i = k;
            if (i1 != 0)
            {
              a(localLinearLayout, localView, paramSwipItemBaseHolder.rightMenuItems[j], k);
              n = m;
              i = k;
            }
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append("updateRightMenuView, menuWidth = ");
            paramContext.append(paramSwipItemBaseHolder.rightMenuItems[j].menuWidth);
            throw new IllegalArgumentException(paramContext.toString());
          }
        }
        else
        {
          n = m;
          i = k;
          if (localView != null)
          {
            localView.setVisibility(8);
            i = k + 1;
            n = m;
          }
        }
        j += 1;
        m = n;
      }
      paramView.setTag(-3, Integer.valueOf(m));
      return m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StorySwipeTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */