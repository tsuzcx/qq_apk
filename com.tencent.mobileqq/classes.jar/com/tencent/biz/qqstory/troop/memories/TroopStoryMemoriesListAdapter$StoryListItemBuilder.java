package com.tencent.biz.qqstory.troop.memories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.view.widget.StorySwipeTextViewMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

class TroopStoryMemoriesListAdapter$StoryListItemBuilder
  extends StorySwipeTextViewMenuBuilder
{
  protected void a(ViewGroup paramViewGroup, View paramView, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(paramSwipRightMenuItem.menuWidth, paramSwipRightMenuItem.menuHeight));
    }
    else
    {
      localLayoutParams.width = paramSwipRightMenuItem.menuWidth;
      localLayoutParams.height = paramSwipRightMenuItem.menuHeight;
    }
    paramViewGroup.addView(paramView, paramInt);
  }
  
  public View createView(Context paramContext, View paramView, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, int paramInt)
  {
    paramSwipItemBaseHolder.rightMenuItems = new SwipRightMenuBuilder.SwipRightMenuItem[this.mMaxMenuCount];
    paramInt = 0;
    while (paramInt < this.mMaxMenuCount)
    {
      paramSwipItemBaseHolder.rightMenuItems[paramInt] = new SwipRightMenuBuilder.SwipRightMenuItem();
      paramSwipItemBaseHolder.rightMenuItems[paramInt].menuType = -1;
      paramSwipItemBaseHolder.rightMenuItems[paramInt].menuWidth = 0;
      paramSwipItemBaseHolder.rightMenuItems[paramInt].menuView = null;
      paramInt += 1;
    }
    paramSwipItemBaseHolder.leftView = paramView.findViewById(2131369736);
    return paramView;
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramArrayOfSwipRightMenuItem[0].menuType = 0;
    paramArrayOfSwipRightMenuItem[0].menuId = 0;
    paramArrayOfSwipRightMenuItem[1].menuType = -1;
    paramArrayOfSwipRightMenuItem[1].menuId = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfSwipRightMenuItem[1].menuType = 1;
      paramArrayOfSwipRightMenuItem[1].menuId = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.StoryListItemBuilder
 * JD-Core Version:    0.7.0.1
 */