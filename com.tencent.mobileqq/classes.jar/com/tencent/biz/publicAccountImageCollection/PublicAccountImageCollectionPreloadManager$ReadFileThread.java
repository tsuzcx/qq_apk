package com.tencent.biz.publicAccountImageCollection;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import vus;

class PublicAccountImageCollectionPreloadManager$ReadFileThread
  implements Runnable
{
  String a;
  
  public PublicAccountImageCollectionPreloadManager$ReadFileThread(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localFileInputStream = new FileInputStream(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + this.a);
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        FileInputStream localFileInputStream;
        Object localObject1;
        Object localObject2;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "read Exception " + localException1);
      }
      try
      {
        localObject2 = new byte[localFileInputStream.available()];
        localObject1 = localObject2;
        localFileInputStream.read((byte[])localObject2);
        localObject1 = localObject2;
        i = 1;
      }
      catch (Exception localException2)
      {
        i = 0;
      }
    }
    localFileInputStream.close();
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "preloadFileToCache");
      }
      localObject2 = new ArticleComment.GetPhotoCollectionInfoResponse();
      ((ArticleComment.GetPhotoCollectionInfoResponse)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = PublicAccountImageCollectionPreloadManager.a(this.this$0, (ArticleComment.GetPhotoCollectionInfoResponse)localObject2, this.a);
      this.this$0.a.put(this.a, localObject1);
      this.this$0.a((vus)localObject1);
      this.this$0.b((vus)localObject1);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.ReadFileThread
 * JD-Core Version:    0.7.0.1
 */