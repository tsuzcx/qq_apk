package com.tencent.mobileqq.activity.contacts.base;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ContactsViewController$6
  extends FriendListObserver
{
  ContactsViewController$6(ContactsViewController paramContactsViewController) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConversationRecommendTypeChange newType is: ");
      localStringBuilder.append(paramInt);
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, localStringBuilder.toString());
    }
    ContactsViewController.d(this.a, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onMayKnowEntryStateChanged isSuccess=");
      paramBundle.append(paramBoolean);
      QLog.d("ContactsViewController", 2, paramBundle.toString());
    }
    if (paramBoolean) {
      ContactsViewController.a(this.a, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((ContactsViewController.j(this.a) instanceof RecommendTroopEntryController)) {
      ((RecommendTroopEntryController)ContactsViewController.j(this.a)).a(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendList. mOccurSwitchAccountChangeTab:");
      localStringBuilder.append(ContactsViewController.g(this.a));
      QLog.i("ContactsViewController", 2, localStringBuilder.toString());
    }
    if (ContactsViewController.g(this.a))
    {
      int i = ContactsViewController.c(this.a, false);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateFriendList. mCurrentTabPos:");
        localStringBuilder.append(ContactsViewController.i(this.a));
        localStringBuilder.append("  defaultPos:");
        localStringBuilder.append(i);
        QLog.i("ContactsViewController", 2, localStringBuilder.toString());
      }
      if (ContactsViewController.i(this.a) != i)
      {
        ContactsViewController.d(this.a, true);
        ContactsViewController.c(this.a, i);
        ContactsViewController.d(this.a, false);
      }
      ContactsViewController.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController.6
 * JD-Core Version:    0.7.0.1
 */