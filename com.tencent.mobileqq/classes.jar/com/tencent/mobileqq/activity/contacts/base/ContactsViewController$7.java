package com.tencent.mobileqq.activity.contacts.base;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ContactsViewController$7
  extends FriendListObserver
{
  ContactsViewController$7(ContactsViewController paramContactsViewController) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    ContactsViewController.c(this.a, paramInt);
  }
  
  public void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      ContactsViewController.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ContactsViewController.a(this.a) instanceof RecommendTroopEntryController)) {
      ((RecommendTroopEntryController)ContactsViewController.a(this.a)).a(paramString);
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + ContactsViewController.b(this.a));
    }
    if (ContactsViewController.b(this.a))
    {
      int i = ContactsViewController.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + ContactsViewController.b(this.a) + "  defaultPos:" + i);
      }
      if (ContactsViewController.b(this.a) != i)
      {
        ContactsViewController.c(this.a, true);
        ContactsViewController.b(this.a, i);
        ContactsViewController.c(this.a, false);
      }
      ContactsViewController.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController.7
 * JD-Core Version:    0.7.0.1
 */