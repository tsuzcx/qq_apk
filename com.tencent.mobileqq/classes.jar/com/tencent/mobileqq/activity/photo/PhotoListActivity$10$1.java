package com.tencent.mobileqq.activity.photo;

import agna;
import android.os.Handler;
import android.os.Message;
import bbdx;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;

public class PhotoListActivity$10$1
  implements Runnable
{
  public PhotoListActivity$10$1(agna paramagna) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = this.a.jdField_a_of_type_JavaLangString;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localLocalMediaInfo.path = this.a.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
      localLocalMediaInfo.mDuration = this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration;
      localLocalMediaInfo.fileSize = new File(this.a.jdField_a_of_type_JavaLangString).length();
      localLocalMediaInfo.isSystemMeidaStore = false;
      PhotoListActivity.a().put(this.a.jdField_a_of_type_JavaLangString, localLocalMediaInfo);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a.sendMessage(localMessage);
      bbdx.a(this.a.b);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("PhotoListActivity", 2, new Object[] { "get new video info exception", localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.10.1
 * JD-Core Version:    0.7.0.1
 */