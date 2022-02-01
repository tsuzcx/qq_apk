package com.tencent.mobileqq.activity.recent;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class RecentMayKnowFriendVerticalListItemBuilder$1
  implements View.OnTouchListener
{
  RecentMayKnowFriendVerticalListItemBuilder$1(RecentMayKnowFriendVerticalListItemBuilder paramRecentMayKnowFriendVerticalListItemBuilder) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentMayKnowFriendVerticalListItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */