package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class TroopMemberListActivity$AnimationEndClearListener$1
  implements Runnable
{
  TroopMemberListActivity$AnimationEndClearListener$1(TroopMemberListActivity.AnimationEndClearListener paramAnimationEndClearListener) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = this.a.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
            }
            else
            {
              this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
            }
          }
          else {
            ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130850005);
          }
        }
        else {
          ((ImageView)this.a.jdField_a_of_type_AndroidViewView).setImageResource(2130850006);
        }
      }
      else
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.leftMargin -= (int)(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mDensity * 34.0F);
        this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.a.jdField_a_of_type_AndroidViewView.setTag("left");
      }
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin += (int)(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mDensity * 34.0F);
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.a.jdField_a_of_type_AndroidViewView.setTag("right");
    }
    this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.AnimationEndClearListener.1
 * JD-Core Version:    0.7.0.1
 */