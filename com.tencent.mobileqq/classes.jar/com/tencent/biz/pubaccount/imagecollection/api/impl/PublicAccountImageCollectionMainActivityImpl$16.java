package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;

class PublicAccountImageCollectionMainActivityImpl$16
  implements Runnable
{
  PublicAccountImageCollectionMainActivityImpl$16(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.puin)) {
      return;
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)PublicAccountImageCollectionMainActivityImpl.access$2800(this.this$0).getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      PublicAccountImageCollectionMainActivityImpl localPublicAccountImageCollectionMainActivityImpl = this.this$0;
      PublicAccountImageCollectionMainActivityImpl.access$2902(localPublicAccountImageCollectionMainActivityImpl, localIPublicAccountDataManager.isFollowedUin(Long.valueOf(localPublicAccountImageCollectionMainActivityImpl.puin)));
      PublicAccountImageCollectionMainActivityImpl.access$400(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivityImpl.16.1(this), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.16
 * JD-Core Version:    0.7.0.1
 */