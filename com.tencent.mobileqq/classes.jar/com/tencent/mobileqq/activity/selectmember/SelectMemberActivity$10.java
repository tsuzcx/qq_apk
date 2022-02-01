package com.tencent.mobileqq.activity.selectmember;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;

class SelectMemberActivity$10
  implements View.OnTouchListener
{
  float x = 0.0F;
  float y = 0.0F;
  
  SelectMemberActivity$10(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.x = paramMotionEvent.getRawX();
      this.y = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      return false;
      if ((i == 2) && ((paramMotionEvent.getRawX() - this.x > 10.0F) || (paramMotionEvent.getRawY() - this.y > 10.0F))) {
        this.this$0.mSelectedAndSearchBar.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.10
 * JD-Core Version:    0.7.0.1
 */