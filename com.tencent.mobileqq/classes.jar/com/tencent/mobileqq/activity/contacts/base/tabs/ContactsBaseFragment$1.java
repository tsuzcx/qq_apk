package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ContactsBaseFragment$1
  extends View.AccessibilityDelegate
{
  ContactsBaseFragment$1(ContactsBaseFragment paramContactsBaseFragment) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 8) {
      i = 32768;
    }
    super.sendAccessibilityEvent(paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */