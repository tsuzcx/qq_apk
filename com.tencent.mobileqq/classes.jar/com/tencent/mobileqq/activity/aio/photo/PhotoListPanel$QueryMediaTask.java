package com.tencent.mobileqq.activity.aio.photo;

import ahbd;
import ahbp;
import ajpc;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PhotoListPanel$QueryMediaTask
  implements Runnable
{
  PhotoListPanel$QueryMediaTask(PhotoListPanel paramPhotoListPanel) {}
  
  private void a(List<LocalMediaInfo> paramList)
  {
    int j = paramList.size();
    this.this$0.jdField_b_of_type_JavaUtilArrayList = new ArrayList(paramList.size());
    this.this$0.jdField_a_of_type_JavaUtilMap = new HashMap(paramList.size());
    PhotoListPanel.jdField_b_of_type_Int = j;
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      for (;;)
      {
        int k;
        try
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(i);
          if (localLocalMediaInfo.path == null) {
            break label432;
          }
          localLocalMediaInfo.mMediaType = -1;
          k = AlbumUtil.getMediaType(localLocalMediaInfo);
          if (k != 0) {
            break label358;
          }
          localLocalMediaInfo.mMediaType = 0;
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
          if (this.this$0.jdField_b_of_type_JavaUtilArrayList != null) {
            this.this$0.jdField_b_of_type_JavaUtilArrayList.add(localLocalMediaInfo.path);
          }
          localLocalMediaInfo.position = Integer.valueOf(i);
          if ((localLocalMediaInfo.orientation != 90) && (localLocalMediaInfo.orientation != 270)) {
            break;
          }
          localLocalMediaInfo.thumbWidth = (this.this$0.f / 2);
          localLocalMediaInfo.thumbHeight = (this.this$0.f / 2);
          if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0)) {
            break label432;
          }
          FlowThumbDecoder.determineThumbSize(localLocalMediaInfo, localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight);
          k = localLocalMediaInfo.thumbWidth;
          localLocalMediaInfo.thumbWidth = localLocalMediaInfo.thumbHeight;
          localLocalMediaInfo.thumbHeight = k;
        }
        catch (Exception localException)
        {
          if ((QLog.isColorLevel()) && (this.this$0.jdField_b_of_type_JavaUtilArrayList != null)) {
            QLog.d("PhotoListPanel", 2, localException + "get album medias size : " + paramList.size() + "mPhotos size" + this.this$0.jdField_b_of_type_JavaUtilArrayList.size());
          }
        }
        ajpc.a(paramList, 0, this.this$0.jdField_b_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_JavaUtilHashMap);
        return;
        label358:
        if (k == 1) {
          localException.mMediaType = 1;
        }
      }
      localException.thumbWidth = (this.this$0.f / 2);
      localException.thumbHeight = (this.this$0.f / 2);
      if ((localException.mediaWidth > 0) && (localException.mediaHeight > 0)) {
        FlowThumbDecoder.determineThumbSize(localException, localException.mediaWidth, localException.mediaHeight);
      }
      label432:
      i += 1;
    }
  }
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "QueryMediaTask start" + l1 + "to qurey time=" + (this.this$0.jdField_a_of_type_Long - l1));
    }
    Object localObject1 = ahbd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = ((ahbd)localObject1).jdField_a_of_type_Int;
    int j = ((ahbd)localObject1).jdField_b_of_type_Int;
    localObject1 = ((ahbd)localObject1).jdField_a_of_type_JavaUtilSet;
    Object localObject3;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0))
    {
      localObject2 = new ArrayList(((Set)localObject1).size());
      localObject3 = ((Set)localObject1).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (String)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(AppConstants.SDCARD_ROOT + (String)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = AlbumUtil.getAlbumMedias(this.this$0.jdField_a_of_type_AndroidAppActivity, "$RecentAlbumId", null, 100, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, i, j, true, (ArrayList)localObject1, false, -1L);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder("get album medias cost: ").append(l2 - l1);
      ((StringBuilder)localObject3).append(" limitSize:").append(i).append(" limitWidth:").append(j).append(" blackLists:").append(localObject1);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject3).toString());
    }
    if ((localObject2 == null) || (((List)localObject2).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "QueryMediaTask getAlbumMedias is null");
      }
      PhotoListPanel.jdField_b_of_type_Int = 0;
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.QueryMediaTask.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "get album medias size : " + ((List)localObject2).size());
    }
    a((List)localObject2);
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.QueryMediaTask.2(this, (List)localObject2));
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "QueryMediaTask,mediaList.size :" + ((List)localObject2).size());
    }
    this.this$0.jdField_a_of_type_Ahbp.b((List)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask
 * JD-Core Version:    0.7.0.1
 */