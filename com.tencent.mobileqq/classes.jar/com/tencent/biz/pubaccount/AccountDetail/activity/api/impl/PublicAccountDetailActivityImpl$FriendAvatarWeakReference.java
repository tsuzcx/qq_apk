package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class PublicAccountDetailActivityImpl$FriendAvatarWeakReference
{
  PublicAccountDetailActivityImpl.UpdateListener jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$UpdateListener;
  FriendProfileImageAvatar jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar;
  WeakReference<PublicAccountDetailActivityImpl> jdField_a_of_type_MqqUtilWeakReference;
  
  public PublicAccountDetailActivityImpl$FriendAvatarWeakReference(QQAppInterface paramQQAppInterface, PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar = new FriendProfileImageAvatar(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b = paramPublicAccountDetailActivityImpl.uin;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramPublicAccountDetailActivityImpl);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$UpdateListener = new PublicAccountDetailActivityImpl.UpdateListener(paramPublicAccountDetailActivityImpl);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$UpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new PublicAccountDetailActivityImpl.FriendAvatarWeakReference.1(this, localProfileImageInfo).execute(new Void[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.FriendAvatarWeakReference
 * JD-Core Version:    0.7.0.1
 */