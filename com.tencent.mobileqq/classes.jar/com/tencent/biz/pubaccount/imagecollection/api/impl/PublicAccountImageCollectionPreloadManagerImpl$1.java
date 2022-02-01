package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.qphone.base.util.QLog;

class PublicAccountImageCollectionPreloadManagerImpl$1
  implements Runnable
{
  PublicAccountImageCollectionPreloadManagerImpl$1(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl, IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = PublicAccountImageCollectionPreloadManagerImpl.access$400();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyUIToRefresh articleId=");
      localStringBuilder.append(this.a.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (PublicAccountImageCollectionPreloadManagerImpl.access$600(this.this$0) != null) {
      PublicAccountImageCollectionPreloadManagerImpl.access$600(this.this$0).onGetPhotoCollectionInfoRespond(this.a);
    }
    PublicAccountImageCollectionPreloadManagerImpl.access$602(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */