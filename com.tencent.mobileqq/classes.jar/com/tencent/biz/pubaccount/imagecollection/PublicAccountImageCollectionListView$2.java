package com.tencent.biz.pubaccount.imagecollection;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class PublicAccountImageCollectionListView$2
  implements Runnable
{
  PublicAccountImageCollectionListView$2(PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.a) {
      return;
    }
    Object localObject1 = this.b;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((List)localObject1).size();
    }
    localObject1 = new LinkedList();
    int j = this.c;
    Object localObject4;
    while (j < this.c + this.d)
    {
      if ((j <= i) && (j >= 1))
      {
        if (PublicAccountImageCollectionListView.a(this.this$0) != this.a) {
          return;
        }
        try
        {
          Object localObject2 = (IPublicAccountImageCollectionUtils.PhotoItemInfo)this.b.get(j - 1);
          if (localObject2 != null)
          {
            localObject4 = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).b(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject2).a);
            if (localObject4 == null) {
              return;
            }
            int k = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).a(localObject2)[0];
            int m = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).a(localObject2)[1];
            ((List)localObject1).add(PublicAccountImageCollectionListView.PreloadImgInfo.a((URL)localObject4, k, m));
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("preloadImg index:");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append("  reqWidth = ");
              ((StringBuilder)localObject2).append(k);
              ((StringBuilder)localObject2).append(" reqHeight = ");
              ((StringBuilder)localObject2).append(m);
              QLog.d("PublicAccountImageCollectionListView", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (PublicAccountImageCollectionListView.a(this.this$0) != this.a) {
            return;
          }
        }
      }
      j += 1;
    }
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.a) {
      return;
    }
    Object localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (PublicAccountImageCollectionListView.PreloadImgInfo)((Iterator)localObject3).next();
      if ((localObject4 != null) && (((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).a != null))
      {
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.a = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).a;
        localImageRequest.b = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).b;
        localImageRequest.c = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).c;
        ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, null);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("preloadImg size:");
      ((StringBuilder)localObject3).append(((List)localObject1).size());
      ((StringBuilder)localObject3).append(" cost:");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.e);
      QLog.d("PublicAccountImageCollectionListView", 2, ((StringBuilder)localObject3).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView.2
 * JD-Core Version:    0.7.0.1
 */