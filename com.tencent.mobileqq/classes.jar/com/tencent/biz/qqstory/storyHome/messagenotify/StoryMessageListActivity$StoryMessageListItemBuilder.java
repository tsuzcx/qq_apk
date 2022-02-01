package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.content.res.Resources;
import com.tencent.biz.qqstory.view.widget.StorySwipeTextViewMenuBuilder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

class StoryMessageListActivity$StoryMessageListItemBuilder
  extends StorySwipeTextViewMenuBuilder
{
  private static final int[] a = { 2131888438 };
  private static final int[] b = { 2131165945 };
  private static final int[] c = { 2131438111 };
  private static int[] d = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299786) };
  
  public StoryMessageListActivity$StoryMessageListItemBuilder()
  {
    super(1, 1, d, -1, c, a, b);
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramArrayOfSwipRightMenuItem[0].menuType = 0;
    paramArrayOfSwipRightMenuItem[0].menuId = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.StoryMessageListItemBuilder
 * JD-Core Version:    0.7.0.1
 */