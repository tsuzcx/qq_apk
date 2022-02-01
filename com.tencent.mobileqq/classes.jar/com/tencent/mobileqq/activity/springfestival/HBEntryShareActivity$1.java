package com.tencent.mobileqq.activity.springfestival;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class HBEntryShareActivity$1
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  
  HBEntryShareActivity$1(HBEntryShareActivity paramHBEntryShareActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramView.getAlpha();
      paramView.setAlpha(this.jdField_a_of_type_Float * 0.5F);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setAlpha(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity.1
 * JD-Core Version:    0.7.0.1
 */