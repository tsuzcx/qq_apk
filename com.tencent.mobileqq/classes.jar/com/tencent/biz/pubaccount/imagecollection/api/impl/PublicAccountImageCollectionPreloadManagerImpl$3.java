package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;

class PublicAccountImageCollectionPreloadManagerImpl$3
  implements Runnable
{
  PublicAccountImageCollectionPreloadManagerImpl$3(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl, IPublicAccountArticleHandler paramIPublicAccountArticleHandler, String paramString) {}
  
  public void run()
  {
    this.a.getPhotoCollectionInfo(this.b, "", 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */