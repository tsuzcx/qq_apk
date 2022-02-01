package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import tencent.im.oidb.ac.ArticleComment.GetPhotoCollectionInfoResponse;

class PublicAccountImageCollectionPreloadManagerImpl$ReadFileThread
  implements Runnable
{
  String a;
  
  public PublicAccountImageCollectionPreloadManagerImpl$ReadFileThread(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
      ((StringBuilder)localObject1).append(this.a);
      localObject3 = new FileInputStream(((StringBuilder)localObject1).toString());
      localObject1 = null;
      i = 1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      Object localObject3;
      int i;
      Object localObject2;
      label64:
      if (QLog.isColorLevel())
      {
        localObject2 = PublicAccountImageCollectionPreloadManagerImpl.access$400();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("read Exception ");
        ((StringBuilder)localObject3).append(localException1);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    try
    {
      localObject2 = new byte[((FileInputStream)localObject3).available()];
      localObject1 = localObject2;
      ((FileInputStream)localObject3).read((byte[])localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      break label64;
    }
    i = 0;
    ((FileInputStream)localObject3).close();
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountImageCollectionPreloadManagerImpl.access$400(), 2, "preloadFileToCache");
      }
      localObject2 = new ArticleComment.GetPhotoCollectionInfoResponse();
      ((ArticleComment.GetPhotoCollectionInfoResponse)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = PublicAccountImageCollectionPreloadManagerImpl.access$500(this.this$0, (ArticleComment.GetPhotoCollectionInfoResponse)localObject2, this.a);
      this.this$0.photoCollectionInfoCache.put(this.a, localObject1);
      this.this$0.notifyUIToRefresh((IPublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject1);
      this.this$0.preloadImage((IPublicAccountImageCollectionUtils.PhotoCollectionInfo)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.ReadFileThread
 * JD-Core Version:    0.7.0.1
 */