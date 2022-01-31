package com.tencent.mobileqq.activity.aio.photo;

import aejs;
import aeke;
import agls;
import agpm;
import ajsf;
import android.os.Handler;
import android.os.SystemClock;
import bbbj;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
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
  
  public void run()
  {
    int k = 0;
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "QueryMediaTask start" + l1 + "to qurey time=" + (this.this$0.jdField_b_of_type_Long - l1));
    }
    Object localObject1 = aejs.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = ((aejs)localObject1).jdField_a_of_type_Int;
    int j = ((aejs)localObject1).b;
    localObject1 = ((aejs)localObject1).jdField_a_of_type_JavaUtilSet;
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
        ((ArrayList)localObject2).add(ajsf.aV + (String)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = bbbj.a(this.this$0.jdField_a_of_type_AndroidAppActivity, "$RecentAlbumId", null, 100, this.this$0.jdField_a_of_type_Aglx, i, j, true, (ArrayList)localObject1, false, -1L);
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
      PhotoListPanel.h = 0;
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.QueryMediaTask.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "get album medias size : " + ((List)localObject2).size());
    }
    int m = ((List)localObject2).size();
    this.this$0.jdField_b_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
    this.this$0.jdField_a_of_type_JavaUtilMap = new HashMap(((List)localObject2).size());
    PhotoListPanel.h = m;
    i = 0;
    for (;;)
    {
      if (k < m)
      {
        try
        {
          localObject1 = (LocalMediaInfo)((List)localObject2).get(k);
          if (((LocalMediaInfo)localObject1).path == null) {
            break label905;
          }
          ((LocalMediaInfo)localObject1).mMediaType = -1;
          int n = bbbj.a((LocalMediaInfo)localObject1);
          if (n == 0)
          {
            ((LocalMediaInfo)localObject1).mMediaType = 0;
            j = i;
          }
          for (;;)
          {
            this.this$0.jdField_a_of_type_JavaUtilMap.put(((LocalMediaInfo)localObject1).path, localObject1);
            if (this.this$0.jdField_b_of_type_JavaUtilArrayList != null) {
              this.this$0.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).path);
            }
            ((LocalMediaInfo)localObject1).position = Integer.valueOf(k);
            if ((((LocalMediaInfo)localObject1).orientation != 90) && (((LocalMediaInfo)localObject1).orientation != 270)) {
              break;
            }
            ((LocalMediaInfo)localObject1).thumbWidth = (this.this$0.d / 2);
            ((LocalMediaInfo)localObject1).thumbHeight = (this.this$0.d / 2);
            if ((((LocalMediaInfo)localObject1).mediaWidth <= 0) || (((LocalMediaInfo)localObject1).mediaHeight <= 0)) {
              break label738;
            }
            agls.a((LocalMediaInfo)localObject1, ((LocalMediaInfo)localObject1).mediaWidth, ((LocalMediaInfo)localObject1).mediaHeight);
            i = ((LocalMediaInfo)localObject1).thumbWidth;
            ((LocalMediaInfo)localObject1).thumbWidth = ((LocalMediaInfo)localObject1).thumbHeight;
            ((LocalMediaInfo)localObject1).thumbHeight = i;
            i = j;
            break label905;
            j = i;
            if (n == 1)
            {
              ((LocalMediaInfo)localObject1).mMediaType = 1;
              j = i + 1;
            }
          }
          ((LocalMediaInfo)localObject1).thumbWidth = (this.this$0.d / 2);
          ((LocalMediaInfo)localObject1).thumbHeight = (this.this$0.d / 2);
          if ((((LocalMediaInfo)localObject1).mediaWidth > 0) && (((LocalMediaInfo)localObject1).mediaHeight > 0)) {
            agls.a((LocalMediaInfo)localObject1, ((LocalMediaInfo)localObject1).mediaWidth, ((LocalMediaInfo)localObject1).mediaHeight);
          }
          label738:
          i = j;
        }
        catch (Exception localException)
        {
          if ((QLog.isColorLevel()) && (this.this$0.jdField_b_of_type_JavaUtilArrayList != null)) {
            QLog.d("PhotoListPanel", 2, localException + "get album medias size : " + ((List)localObject2).size() + "mPhotos size" + this.this$0.jdField_b_of_type_JavaUtilArrayList.size());
          }
        }
      }
      else
      {
        agpm.a((List)localObject2, this.this$0.jdField_b_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_JavaUtilHashMap);
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.QueryMediaTask.2(this, (List)localObject2));
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "QueryMediaTask,mediaList.size :" + ((List)localObject2).size());
        }
        this.this$0.jdField_a_of_type_Aeke.b((List)localObject2);
        return;
      }
      label905:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask
 * JD-Core Version:    0.7.0.1
 */