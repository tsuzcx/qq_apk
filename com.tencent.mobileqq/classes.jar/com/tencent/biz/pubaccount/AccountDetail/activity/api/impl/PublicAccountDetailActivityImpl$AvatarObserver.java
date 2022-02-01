package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import mqq.util.WeakReference;

class PublicAccountDetailActivityImpl$AvatarObserver
  extends AvatarObserver
{
  WeakReference<PublicAccountDetailActivityImpl> a;
  
  public PublicAccountDetailActivityImpl$AvatarObserver(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl)
  {
    this.a = new WeakReference(paramPublicAccountDetailActivityImpl);
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = (PublicAccountDetailActivityImpl)this.a.get();
    if (localPublicAccountDetailActivityImpl == null) {}
    while ((localPublicAccountDetailActivityImpl.isDestroy) || (!paramBoolean) || (!paramString.equals(localPublicAccountDetailActivityImpl.uin))) {
      return;
    }
    localPublicAccountDetailActivityImpl.setHDFace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.AvatarObserver
 * JD-Core Version:    0.7.0.1
 */