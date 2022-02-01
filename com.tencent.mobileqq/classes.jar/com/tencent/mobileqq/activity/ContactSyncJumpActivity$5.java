package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class ContactSyncJumpActivity$5
  extends ContactBindObserver
{
  ContactSyncJumpActivity$5(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      int i = ContactSyncJumpActivity.a(this.a).d();
      if ((i == 1) || (i == 5))
      {
        this.a.startActivity(new Intent(this.a, PhoneFrameActivity.class));
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */