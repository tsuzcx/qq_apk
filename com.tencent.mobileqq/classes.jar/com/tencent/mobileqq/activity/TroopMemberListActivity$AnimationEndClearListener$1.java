package com.tencent.mobileqq.activity;

import acan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class TroopMemberListActivity$AnimationEndClearListener$1
  implements Runnable
{
  public TroopMemberListActivity$AnimationEndClearListener$1(acan paramacan) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    switch (this.a.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin += (int)(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a * 34.0F);
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.a.jdField_a_of_type_AndroidViewView.setTag("right");
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin -= (int)(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a * 34.0F);
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.a.jdField_a_of_type_AndroidViewView.setTag("left");
      continue;
      ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130848382);
      continue;
      ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130848381);
      continue;
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.AnimationEndClearListener.1
 * JD-Core Version:    0.7.0.1
 */