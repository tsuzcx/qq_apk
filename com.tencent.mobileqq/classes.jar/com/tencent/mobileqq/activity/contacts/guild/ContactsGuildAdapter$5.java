package com.tencent.mobileqq.activity.contacts.guild;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class ContactsGuildAdapter$5
  implements View.OnTouchListener
{
  ContactsGuildAdapter$5(ContactsGuildAdapter paramContactsGuildAdapter, TextView paramTextView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 3) {
          this.a.setAlpha(1.0F);
        }
      }
      else {
        this.a.setAlpha(1.0F);
      }
    }
    else {
      this.a.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter.5
 * JD-Core Version:    0.7.0.1
 */