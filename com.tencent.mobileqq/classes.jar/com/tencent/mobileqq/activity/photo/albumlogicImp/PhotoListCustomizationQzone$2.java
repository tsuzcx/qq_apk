package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

class PhotoListCustomizationQzone$2
  implements Runnable
{
  PhotoListCustomizationQzone$2(PhotoListCustomizationQzone paramPhotoListCustomizationQzone, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a);
    int i = 0;
    while (i < localArrayList.size())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localArrayList.get(i);
      if ((localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0)) {
        if ((localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight != 2.0F) && (localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight < 4.0F) && (localLocalMediaInfo.mediaHeight / localLocalMediaInfo.mediaWidth < 4.0F))
        {
          localLocalMediaInfo.panoramaPhotoType = 3;
        }
        else
        {
          QZLog.i("QQAlbum", "loadPanoramaPhotoList LoadPanoramaPhoto");
          PhotoListCustomizationQzone.a(this.this$0, localLocalMediaInfo);
        }
      }
      i += 1;
    }
    if ((PhotoListCustomizationQzone.c(this.this$0) != null) && (PhotoListCustomizationQzone.d(this.this$0).u != null))
    {
      QZLog.i("QQAlbum", "loadPanoramaPhotoList HandlerPost");
      PhotoListCustomizationQzone.f(this.this$0).u.post(new PhotoListCustomizationQzone.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.2
 * JD-Core Version:    0.7.0.1
 */