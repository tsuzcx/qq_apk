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
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((List)localObject1).size();
    }
    localObject1 = new LinkedList();
    int j = this.jdField_a_of_type_Int;
    Object localObject4;
    while (j < this.jdField_a_of_type_Int + this.jdField_b_of_type_Int)
    {
      if ((j <= i) && (j >= 1))
      {
        if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {
          return;
        }
        try
        {
          Object localObject2 = (IPublicAccountImageCollectionUtils.PhotoItemInfo)this.jdField_a_of_type_JavaUtilList.get(j - 1);
          if (localObject2 != null)
          {
            localObject4 = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).a(((IPublicAccountImageCollectionUtils.PhotoItemInfo)localObject2).a);
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
          if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {
            return;
          }
        }
      }
      j += 1;
    }
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    Object localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (PublicAccountImageCollectionListView.PreloadImgInfo)((Iterator)localObject3).next();
      if ((localObject4 != null) && (((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).jdField_a_of_type_JavaNetURL != null))
      {
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.jdField_a_of_type_JavaNetURL = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).jdField_a_of_type_JavaNetURL;
        localImageRequest.jdField_a_of_type_Int = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).jdField_a_of_type_Int;
        localImageRequest.jdField_b_of_type_Int = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject4).jdField_b_of_type_Int;
        ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, null);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("preloadImg size:");
      ((StringBuilder)localObject3).append(((List)localObject1).size());
      ((StringBuilder)localObject3).append(" cost:");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      QLog.d("PublicAccountImageCollectionListView", 2, ((StringBuilder)localObject3).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView.2
 * JD-Core Version:    0.7.0.1
 */