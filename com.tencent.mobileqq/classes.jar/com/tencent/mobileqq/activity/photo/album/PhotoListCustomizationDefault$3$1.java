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
    localMessage.obj = this.a.jdField_a_of_type_JavaLangString;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localLocalMediaInfo.path = this.a.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = this.a.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath;
      localLocalMediaInfo.mDuration = this.a.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDuration;
      localLocalMediaInfo.fileSize = new File(this.a.jdField_a_of_type_JavaLangString).length();
      localLocalMediaInfo.isSystemMeidaStore = false;
    }
    catch (Exception localException)
    {
      QZLog.e("QQAlbum", 2, new Object[] { "get new video info exception", localException });
    }
    PhotoListBaseData.a.put(this.a.jdField_a_of_type_JavaLangString, localLocalMediaInfo);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListCustomizationDefault.a.a.sendMessage(localMessage);
    FileUtils.deleteDirectory(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.3.1
 * JD-Core Version:    0.7.0.1
 */