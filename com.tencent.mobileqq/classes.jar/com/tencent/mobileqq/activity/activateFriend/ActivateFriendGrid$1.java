package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActivateFriendGrid$1
  implements View.OnClickListener
{
  ActivateFriendGrid$1(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void onClick(View paramView)
  {
    ActivateFriendGridItem localActivateFriendGridItem = (ActivateFriendGridItem)paramView;
    if (localActivateFriendGridItem.f) {
      ActivateFriendGrid.a(this.a);
    } else {
      ActivateFriendGrid.b(this.a);
    }
    localActivateFriendGridItem.setChecked(localActivateFriendGridItem.f ^ true);
    if (ActivateFriendGrid.c(this.a) != null) {
      ActivateFriendGrid.c(this.a).a(ActivateFriendGrid.d(this.a));
    }
    if (ActivateFriendGrid.e(this.a) != null) {
      ActivateFriendGrid.e(this.a).a(localActivateFriendGridItem.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.1
 * JD-Core Version:    0.7.0.1
 */