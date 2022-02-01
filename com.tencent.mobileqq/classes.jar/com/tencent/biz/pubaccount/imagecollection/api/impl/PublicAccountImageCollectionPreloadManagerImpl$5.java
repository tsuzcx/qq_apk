package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

class PublicAccountImageCollectionPreloadManagerImpl$5
  implements Runnable
{
  PublicAccountImageCollectionPreloadManagerImpl$5(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      if (localObject1 != null)
      {
        Object localObject3;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localObject3 = PublicAccountImageCollectionPreloadManagerImpl.access$400();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("preloadImage url= ");
          localStringBuilder.append((String)localObject1);
          QLog.d((String)localObject3, 2, localStringBuilder.toString());
        }
        Object localObject2;
        try
        {
          localObject1 = new URL((String)localObject1);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = PublicAccountImageCollectionPreloadManagerImpl.access$400();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getURLPath ERROR e = ");
            localStringBuilder.append(localMalformedURLException.getMessage());
            QLog.d((String)localObject3, 2, localStringBuilder.toString());
          }
          localObject2 = null;
        }
        if (localObject2 != null)
        {
          localObject3 = new ImageRequest();
          ((ImageRequest)localObject3).a = localObject2;
          ((IImageManager)QRoute.api(IImageManager.class)).loadImage((ImageRequest)localObject3, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */