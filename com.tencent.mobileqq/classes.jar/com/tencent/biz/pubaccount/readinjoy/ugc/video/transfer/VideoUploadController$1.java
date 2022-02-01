package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoUploadController$1
  implements Runnable
{
  VideoUploadController$1(VideoUploadController paramVideoUploadController) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(VideoUploadController.a(this.this$0))) && (!TextUtils.isEmpty(VideoUploadController.b(this.this$0))) && (!VideoUploadController.a(this.this$0).equals(VideoUploadController.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + VideoUploadController.a(this.this$0) + ", compress:" + VideoUploadController.b(this.this$0));
      }
      File localFile = new File(VideoUploadController.b(this.this$0));
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1
 * JD-Core Version:    0.7.0.1
 */