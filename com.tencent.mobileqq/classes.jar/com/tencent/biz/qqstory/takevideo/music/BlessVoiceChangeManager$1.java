package com.tencent.biz.qqstory.takevideo.music;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Output;
import com.tencent.qphone.base.util.QLog;

class BlessVoiceChangeManager$1
  extends FileDownloadTask
{
  BlessVoiceChangeManager$1(BlessVoiceChangeManager paramBlessVoiceChangeManager, Downloader paramDownloader, long paramLong)
  {
    super(paramDownloader);
  }
  
  protected void a(FileDownloadTask.Output paramOutput)
  {
    if (paramOutput.jdField_a_of_type_Int == 0)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage success, cost:" + (l1 - l2));
      }
      BlessVoiceChangeManager.a().sendMessage(Message.obtain(BlessVoiceChangeManager.a(), 1, null));
    }
    for (;;)
    {
      BlessVoiceChangeManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileDownloadTask", 2, "startDownloadVCImage error:" + paramOutput.jdField_a_of_type_Int + ", errMsg:" + paramOutput.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.BlessVoiceChangeManager.1
 * JD-Core Version:    0.7.0.1
 */