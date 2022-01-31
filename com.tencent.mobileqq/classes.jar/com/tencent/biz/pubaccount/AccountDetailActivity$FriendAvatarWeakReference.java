package com.tencent.biz.pubaccount;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import ksz;
import kta;
import mqq.util.WeakReference;

public class AccountDetailActivity$FriendAvatarWeakReference
{
  public FriendProfileImageAvatar a;
  kta jdField_a_of_type_Kta;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  
  public AccountDetailActivity$FriendAvatarWeakReference(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar = new FriendProfileImageAvatar(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b = paramAccountDetailActivity.d;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Kta = new kta(paramAccountDetailActivity);
  }
  
  public void a()
  {
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = new FriendProfileImageModel.ProfileImageInfo();
    localProfileImageInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b;
    localProfileImageInfo.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localProfileImageInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a(this.jdField_a_of_type_Kta);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new ksz(this, localProfileImageInfo).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.FriendAvatarWeakReference
 * JD-Core Version:    0.7.0.1
 */