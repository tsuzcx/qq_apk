package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

class PublicAccountImageCollectionPreloadManagerImpl$6
  extends Thread
{
  PublicAccountImageCollectionPreloadManagerImpl$6(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl) {}
  
  public void run()
  {
    if (this.this$0.photoCollectionInfoCache != null) {
      this.this$0.photoCollectionInfoCache.releaseLargeCache();
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */