package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.widget.SwipListView;

class AddContactsView$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AddContactsView$5(AddContactsView paramAddContactsView) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.setListViewHeightBasedOnChildren(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.5
 * JD-Core Version:    0.7.0.1
 */