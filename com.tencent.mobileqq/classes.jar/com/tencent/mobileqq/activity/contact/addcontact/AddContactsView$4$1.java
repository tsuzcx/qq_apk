package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.widget.SwipListView;

class AddContactsView$4$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AddContactsView$4$1(AddContactsView.4 param4) {}
  
  public void onGlobalLayout()
  {
    this.a.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.a.setListViewHeightBasedOnChildren(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.4.1
 * JD-Core Version:    0.7.0.1
 */