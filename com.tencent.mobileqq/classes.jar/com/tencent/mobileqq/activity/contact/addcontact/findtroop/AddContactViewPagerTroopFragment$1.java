package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AddContactViewPagerTroopFragment$1
  implements View.OnTouchListener
{
  float a = 0.0F;
  
  AddContactViewPagerTroopFragment$1(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = paramView.getAlpha();
      paramView.setAlpha(this.a * 0.5F);
    }
    else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      paramView.setAlpha(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.1
 * JD-Core Version:    0.7.0.1
 */