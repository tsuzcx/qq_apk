package com.tencent.mobileqq.activity.contacts.publicaccount;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.qphone.base.util.QLog;

class PublicAccountFragment$2
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountFragment$2(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void onFollowPublicAccount(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onFollowPublicAccount errCode: ");
      paramObject.append(paramInt);
      QLog.d("Contacts.PublicAccountFragment", 2, paramObject.toString());
    }
    if (paramInt == 0) {
      this.a.k();
    }
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onUnfollowPublicAccount errCode: ");
      paramObject.append(paramInt);
      QLog.d("Contacts.PublicAccountFragment", 2, paramObject.toString());
    }
    if (paramInt == 0) {
      this.a.k();
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateUserFollowList errCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isFinish:");
      localStringBuilder.append(paramBoolean);
      QLog.d("Contacts.PublicAccountFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (PublicAccountFragment.a(this.a))
      {
        if (PublicAccountFragment.b(this.a) != null) {
          PublicAccountFragment.c(this.a).a(this.a.i(), true, null);
        }
        PublicAccountFragment.a(this.a, false);
      }
      this.a.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */