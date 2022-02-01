package com.tencent.biz.pubaccount.imagecollection;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class PublicAccountImageCollectionAdapter$6
  implements IPublicAccountImageDownListener
{
  PublicAccountImageCollectionAdapter$6(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter, boolean paramBoolean, long paramLong, ImageProgressCircle paramImageProgressCircle) {}
  
  public void a(URL paramURL, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadProgressed");
    }
    PublicAccountImageCollectionAdapter.a(this.d, this.c, paramInt);
  }
  
  public void a(URL paramURL, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadSuccessed");
    }
    if (!this.a) {
      ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageTime(true, this.b);
    }
    PublicAccountImageCollectionAdapter.a(this.d, this.c);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadFailed");
    }
    if (!this.a) {
      ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageTime(false, this.b);
    }
    PublicAccountImageCollectionAdapter.a(this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.6
 * JD-Core Version:    0.7.0.1
 */