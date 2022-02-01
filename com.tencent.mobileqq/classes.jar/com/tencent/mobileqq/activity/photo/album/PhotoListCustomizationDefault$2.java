package com.tencent.mobileqq.activity.photo.album;

import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import java.util.Map;

class PhotoListCustomizationDefault$2
  implements Runnable
{
  PhotoListCustomizationDefault$2(PhotoListCustomizationDefault paramPhotoListCustomizationDefault, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = QQAlbumUtils.b(this.a);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    QQAlbumUtils.a(localLocalMediaInfo, str);
    PhotoListBaseData.a.put(str, localLocalMediaInfo);
    this.this$0.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.2
 * JD-Core Version:    0.7.0.1
 */