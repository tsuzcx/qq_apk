package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.activity.FriendProfileImageModel.InfoUpdateListener;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import java.lang.ref.WeakReference;

class PublicAccountDetailActivityImpl$UpdateListener
  implements FriendProfileImageModel.InfoUpdateListener
{
  WeakReference<PublicAccountDetailActivityImpl> a;
  
  public PublicAccountDetailActivityImpl$UpdateListener(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl)
  {
    this.a = new WeakReference(paramPublicAccountDetailActivityImpl);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      ((PublicAccountDetailActivityImpl)this.a.get()).loadHDFace(paramProfileImageInfo);
      ((PublicAccountDetailActivityImpl)this.a.get()).setHDFace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.UpdateListener
 * JD-Core Version:    0.7.0.1
 */