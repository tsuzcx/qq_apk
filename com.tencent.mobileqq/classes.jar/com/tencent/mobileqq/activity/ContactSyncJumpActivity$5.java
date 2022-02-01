package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class ContactSyncJumpActivity$5
  extends ContactBindObserver
{
  ContactSyncJumpActivity$5(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      int i = ContactSyncJumpActivity.i(this.a).getSelfBindState();
      if ((i == 1) || (i == 5))
      {
        ContactSyncJumpActivity localContactSyncJumpActivity = this.a;
        localContactSyncJumpActivity.startActivity(new Intent(localContactSyncJumpActivity, PhoneFrameActivity.class));
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */