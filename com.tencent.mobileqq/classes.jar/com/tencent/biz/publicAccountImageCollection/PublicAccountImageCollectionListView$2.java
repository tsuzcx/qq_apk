package com.tencent.biz.publicAccountImageCollection;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
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
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {}
    label25:
    LinkedList localLinkedList;
    label39:
    label82:
    do
    {
      Object localObject;
      do
      {
        return;
        int i;
        int j;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          localLinkedList = new LinkedList();
          j = this.jdField_a_of_type_Int;
          if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
            continue;
          }
          if ((j <= i) && (j >= 1)) {
            break label82;
          }
        }
        do
        {
          for (;;)
          {
            j += 1;
            break label39;
            i = this.jdField_a_of_type_JavaUtilList.size();
            break label25;
            if (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long) {
              break;
            }
            try
            {
              PublicAccountImageCollectionUtils.PhotoItemInfo localPhotoItemInfo = (PublicAccountImageCollectionUtils.PhotoItemInfo)this.jdField_a_of_type_JavaUtilList.get(j - 1);
              if (localPhotoItemInfo != null)
              {
                localObject = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).a(localPhotoItemInfo.a);
                if (localObject == null) {
                  break;
                }
                int k = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).a(localPhotoItemInfo)[0];
                int m = ((PublicAccountImageCollectionAdapter)this.this$0.getAdapter()).a(localPhotoItemInfo)[1];
                localLinkedList.add(PublicAccountImageCollectionListView.PreloadImgInfo.a((URL)localObject, k, m));
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg index:" + j + "  reqWidth = " + k + " reqHeight = " + m);
                }
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (PublicAccountImageCollectionListView.a(this.this$0) == this.jdField_a_of_type_Long);
        return;
      } while (PublicAccountImageCollectionListView.a(this.this$0) != this.jdField_a_of_type_Long);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (PublicAccountImageCollectionListView.PreloadImgInfo)localIterator.next();
        if ((localObject != null) && (((PublicAccountImageCollectionListView.PreloadImgInfo)localObject).jdField_a_of_type_JavaNetURL != null))
        {
          ImageRequest localImageRequest = new ImageRequest();
          localImageRequest.jdField_a_of_type_JavaNetURL = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject).jdField_a_of_type_JavaNetURL;
          localImageRequest.jdField_a_of_type_Int = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject).jdField_a_of_type_Int;
          localImageRequest.jdField_b_of_type_Int = ((PublicAccountImageCollectionListView.PreloadImgInfo)localObject).jdField_b_of_type_Int;
          ImageManager.a().a(localImageRequest, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.2
 * JD-Core Version:    0.7.0.1
 */