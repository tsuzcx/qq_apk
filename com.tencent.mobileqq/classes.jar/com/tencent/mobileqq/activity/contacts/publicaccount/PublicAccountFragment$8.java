package com.tencent.mobileqq.activity.contacts.publicaccount;

import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

class PublicAccountFragment$8
  extends PublicAccountObserver
{
  PublicAccountFragment$8(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onFollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.a.i();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUnfollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.a.i();
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUpdateUserFollowList errCode: " + paramInt + " isFinish:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (PublicAccountFragment.a(this.a))
      {
        if (PublicAccountFragment.a(this.a) != null) {
          PublicAccountFragment.b(this.a).a(this.a.b(), true, null);
        }
        PublicAccountFragment.a(this.a, false);
      }
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.8
 * JD-Core Version:    0.7.0.1
 */