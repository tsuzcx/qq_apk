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
    if (localActivateFriendGridItem.jdField_a_of_type_Boolean) {
      ActivateFriendGrid.a(this.a);
    } else {
      ActivateFriendGrid.b(this.a);
    }
    localActivateFriendGridItem.setChecked(localActivateFriendGridItem.jdField_a_of_type_Boolean ^ true);
    if (ActivateFriendGrid.a(this.a) != null) {
      ActivateFriendGrid.a(this.a).a(ActivateFriendGrid.c(this.a));
    }
    if (ActivateFriendGrid.a(this.a) != null) {
      ActivateFriendGrid.a(this.a).a(localActivateFriendGridItem.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.1
 * JD-Core Version:    0.7.0.1
 */