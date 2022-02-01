package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActivateFriendView$1
  implements View.OnClickListener
{
  ActivateFriendView$1(ActivateFriendView paramActivateFriendView) {}
  
  public void onClick(View paramView)
  {
    ActivateFriendViewItem localActivateFriendViewItem = (ActivateFriendViewItem)paramView;
    if (localActivateFriendViewItem.f) {
      ActivateFriendView.a(this.a);
    } else {
      ActivateFriendView.b(this.a);
    }
    localActivateFriendViewItem.setChecked(localActivateFriendViewItem.f ^ true);
    if (ActivateFriendView.c(this.a) != null) {
      ActivateFriendView.c(this.a).a(ActivateFriendView.d(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView.1
 * JD-Core Version:    0.7.0.1
 */