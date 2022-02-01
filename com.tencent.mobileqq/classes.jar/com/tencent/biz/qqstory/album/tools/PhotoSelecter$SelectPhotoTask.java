package com.tencent.biz.qqstory.album.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class PhotoSelecter$SelectPhotoTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  PhotoSelecter.SelectPhotoCallback jdField_a_of_type_ComTencentBizQqstoryAlbumToolsPhotoSelecter$SelectPhotoCallback;
  List<PhotoSelecter.SelectPhotoTask.PicInfoContainer> jdField_a_of_type_JavaUtilList;
  long b;
  
  public void run()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilList);
    Object localObject2 = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size() / this.jdField_a_of_type_Int;
    int i = 0;
    Object localObject1 = null;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i % j == 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
      }
      ((ArrayList)localObject1).add(this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    int[] arrayOfInt = new int[((ArrayList)localObject2).size()];
    i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    Object localObject3 = new ArrayList();
    i = 0;
    j = 1;
    while (((ArrayList)localObject3).size() < this.jdField_a_of_type_Int)
    {
      int k = 0;
      int m = 0;
      while (k < arrayOfInt.length)
      {
        m += arrayOfInt[k];
        k += 1;
      }
      if (m >= arrayOfInt.length) {
        break;
      }
      m = i;
      k = j;
      if (i >= ((ArrayList)localObject2).size())
      {
        localObject1 = PhotoSelecter.a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("round = ");
        ((StringBuilder)localObject4).append(j);
        SLog.b((String)localObject1, ((StringBuilder)localObject4).toString());
        k = j + 1;
        m = 0;
      }
      Object localObject4 = ((ArrayList)((ArrayList)localObject2).get(m)).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (PhotoSelecter.SelectPhotoTask.PicInfoContainer)((Iterator)localObject4).next();
        if (((PhotoSelecter.SelectPhotoTask.PicInfoContainer)localObject1).jdField_a_of_type_Int == 1) {
          break label314;
        }
      }
      localObject1 = null;
      label314:
      if (localObject1 == null)
      {
        arrayOfInt[m] = 1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("abandon cursor = ");
        ((StringBuilder)localObject1).append(m);
        Log.d("stevcao", ((StringBuilder)localObject1).toString());
        i = m + 1;
        j = k;
      }
      else
      {
        if (((ArrayList)localObject3).size() == 0)
        {
          ((PhotoSelecter.SelectPhotoTask.PicInfoContainer)localObject1).jdField_a_of_type_Int = 2;
          ((ArrayList)localObject3).add(localObject1);
        }
        else
        {
          localObject4 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Bitmap localBitmap1 = ((PhotoSelecter.SelectPhotoTask.PicInfoContainer)((Iterator)localObject4).next()).a(this.jdField_a_of_type_AndroidContentContext);
            Bitmap localBitmap2 = ((PhotoSelecter.SelectPhotoTask.PicInfoContainer)localObject1).a(this.jdField_a_of_type_AndroidContentContext);
            long l = System.currentTimeMillis();
            double d = PhotoSimilar.a(localBitmap1, localBitmap2);
            this.jdField_a_of_type_Long += System.currentTimeMillis() - l;
            this.b += 1L;
            if (d >= 0.7D)
            {
              ((PhotoSelecter.SelectPhotoTask.PicInfoContainer)localObject1).jdField_a_of_type_Int = 3;
              i = 1;
              break label507;
            }
          }
          i = 0;
          label507:
          if (i == 0)
          {
            ((PhotoSelecter.SelectPhotoTask.PicInfoContainer)localObject1).jdField_a_of_type_Int = 2;
            ((ArrayList)localObject3).add(localObject1);
          }
        }
        i = m + 1;
        j = k;
      }
    }
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((PhotoSelecter.SelectPhotoTask.PicInfoContainer)((Iterator)localObject2).next()).jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum$PicInfo);
    }
    localObject2 = PhotoSelecter.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("compare total time = ");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject3).append(" compareTimes = ");
    ((StringBuilder)localObject3).append(this.b);
    SLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = PhotoSelecter.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("single compare time = ");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long / this.b);
    SLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumToolsPhotoSelecter$SelectPhotoCallback.a((ArrayList)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.PhotoSelecter.SelectPhotoTask
 * JD-Core Version:    0.7.0.1
 */