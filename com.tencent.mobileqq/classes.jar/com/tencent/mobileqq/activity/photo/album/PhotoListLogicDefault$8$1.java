package com.tencent.mobileqq.activity.photo.album;

import aira;
import airf;
import android.os.Handler;
import android.os.Message;
import bdhb;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;

public class PhotoListLogicDefault$8$1
  implements Runnable
{
  public PhotoListLogicDefault$8$1(airf paramairf) {}
  
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
      PhotoListBaseData.newCaptureMediaInfo.put(this.a.jdField_a_of_type_JavaLangString, localLocalMediaInfo);
      ((NewPhotoListActivity)this.a.jdField_a_of_type_Aira.mActivity).a.sendMessage(localMessage);
      bdhb.a(this.a.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.8.1
 * JD-Core Version:    0.7.0.1
 */