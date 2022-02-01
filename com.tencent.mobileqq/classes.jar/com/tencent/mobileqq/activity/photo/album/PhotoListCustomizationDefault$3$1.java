package com.tencent.mobileqq.activity.photo.album;

import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;

class PhotoListCustomizationDefault$3$1
  implements Runnable
{
  PhotoListCustomizationDefault$3$1(PhotoListCustomizationDefault.3 param3) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = this.a.b;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localLocalMediaInfo.path = this.a.b;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = this.a.c.thumbPath;
      localLocalMediaInfo.mDuration = this.a.c.videoDuration;
      localLocalMediaInfo.fileSize = new File(this.a.b).length();
      localLocalMediaInfo.isSystemMeidaStore = false;
    }
    catch (Exception localException)
    {
      QZLog.e("QQAlbum", 2, new Object[] { "get new video info exception", localException });
    }
    PhotoListBaseData.x.put(this.a.b, localLocalMediaInfo);
    this.a.e.b.u.sendMessage(localMessage);
    FileUtils.deleteDirectory(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.3.1
 * JD-Core Version:    0.7.0.1
 */