package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class UncommonlyUsedContactsActivity$2
  extends ContactBindObserver
{
  UncommonlyUsedContactsActivity$2(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  public void onHideContact(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.2
 * JD-Core Version:    0.7.0.1
 */