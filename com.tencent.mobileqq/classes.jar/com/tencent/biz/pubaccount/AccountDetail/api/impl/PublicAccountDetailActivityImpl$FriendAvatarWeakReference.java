package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class PublicAccountDetailActivityImpl$FriendAvatarWeakReference
{
  PublicAccountDetailActivityImpl.UpdateListener a;
  FriendProfileImageAvatar b;
  WeakReference<PublicAccountDetailActivityImpl> c;
  
  public PublicAccountDetailActivityImpl$FriendAvatarWeakReference(QQAppInterface paramQQAppInterface, PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl)
  {
    this.b = new FriendProfileImageAvatar(paramQQAppInterface);
    this.b.h = paramPublicAccountDetailActivityImpl.uin;
    this.c = new WeakReference(paramPublicAccountDetailActivityImpl);
    this.a = new PublicAccountDetailActivityImpl.UpdateListener(paramPublicAccountDetailActivityImpl);
  }
  
  public void a()
  {
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = new FriendProfileImageModel.ProfileImageInfo();
    localProfileImageInfo.g = this.b.h;
    localProfileImageInfo.a = null;
    if (this.c.get() == null) {
      return;
    }
    this.b.a((BaseActivity)this.c.get(), localProfileImageInfo);
    this.b.a(this.a);
    this.b.b((BaseActivity)this.c.get());
    new PublicAccountDetailActivityImpl.FriendAvatarWeakReference.1(this, localProfileImageInfo).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.c.get() != null)
    {
      this.b.a(null);
      this.b.a((BaseActivity)this.c.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.FriendAvatarWeakReference
 * JD-Core Version:    0.7.0.1
 */