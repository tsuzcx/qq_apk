package com.tencent.mobileqq.activity.aio.photo;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
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
    this.this$0.v = new ArrayList(paramList.size());
    this.this$0.g = new HashMap(paramList.size());
    PhotoListPanel.b = j;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(i);
          if (localLocalMediaInfo.path != null)
          {
            localLocalMediaInfo.mMediaType = -1;
            int k = AlbumUtil.getMediaType(localLocalMediaInfo);
            if (k == 0) {
              localLocalMediaInfo.mMediaType = 0;
            } else if (k == 1) {
              localLocalMediaInfo.mMediaType = 1;
            }
            this.this$0.g.put(localLocalMediaInfo.path, localLocalMediaInfo);
            if (this.this$0.v != null) {
              this.this$0.v.add(localLocalMediaInfo.path);
            }
            localLocalMediaInfo.position = Integer.valueOf(i);
            if ((localLocalMediaInfo.orientation != 90) && (localLocalMediaInfo.orientation != 270))
            {
              localLocalMediaInfo.thumbWidth = (this.this$0.r / 2);
              localLocalMediaInfo.thumbHeight = (this.this$0.r / 2);
              if ((localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0)) {
                FlowThumbDecoder.determineThumbSize(localLocalMediaInfo, localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight);
              }
            }
            else
            {
              localLocalMediaInfo.thumbWidth = (this.this$0.r / 2);
              localLocalMediaInfo.thumbHeight = (this.this$0.r / 2);
              if ((localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0))
              {
                FlowThumbDecoder.determineThumbSize(localLocalMediaInfo, localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight);
                k = localLocalMediaInfo.thumbWidth;
                localLocalMediaInfo.thumbWidth = localLocalMediaInfo.thumbHeight;
                localLocalMediaInfo.thumbHeight = k;
              }
            }
          }
          i += 1;
        }
        catch (Exception localException)
        {
          if ((QLog.isColorLevel()) && (this.this$0.v != null))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localException);
            localStringBuilder.append("get album medias size : ");
            localStringBuilder.append(paramList.size());
            localStringBuilder.append("mPhotos size");
            localStringBuilder.append(this.this$0.v.size());
            QLog.d("PhotoListPanel", 2, localStringBuilder.toString());
          }
        }
      }
    }
    ReplacePhotoDataUtil.a(paramList, 0, this.this$0.v, this.this$0.w);
  }
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QueryMediaTask start");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("to qurey time=");
      ((StringBuilder)localObject1).append(this.this$0.h - l1);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = PhotoListConfigManager.a(this.this$0.i);
    int i = ((PhotoListConfigManager)localObject1).a;
    int j = ((PhotoListConfigManager)localObject1).b;
    Object localObject3 = ((PhotoListConfigManager)localObject1).c;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Set)localObject3).size() > 0)
      {
        localObject2 = new ArrayList(((Set)localObject3).size());
        localObject3 = ((Set)localObject3).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (String)((Iterator)localObject3).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(AppConstants.SDCARD_ROOT);
          localStringBuilder.append((String)localObject1);
          ((ArrayList)localObject2).add(localStringBuilder.toString());
        }
      }
    }
    localObject2 = AlbumUtil.getAlbumMedias(this.this$0.k, "$RecentAlbumId", null, 100, this.this$0.af, i, j, true, (ArrayList)localObject1, false, -1L);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder("get album medias cost: ");
      ((StringBuilder)localObject3).append(l2 - l1);
      ((StringBuilder)localObject3).append(" limitSize:");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(" limitWidth:");
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append(" blackLists:");
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject3).toString());
    }
    if ((localObject2 != null) && (((List)localObject2).size() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get album medias size : ");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject1).toString());
      }
      a((List)localObject2);
      this.this$0.aa.post(new PhotoListPanel.QueryMediaTask.2(this, (List)localObject2));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QueryMediaTask,mediaList.size :");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject1).toString());
      }
      this.this$0.f.b((List)localObject2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "QueryMediaTask getAlbumMedias is null");
    }
    PhotoListPanel.b = 0;
    this.this$0.aa.post(new PhotoListPanel.QueryMediaTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.QueryMediaTask
 * JD-Core Version:    0.7.0.1
 */