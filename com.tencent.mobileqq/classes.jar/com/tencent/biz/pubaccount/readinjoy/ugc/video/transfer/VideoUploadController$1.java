package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import qix;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(qix paramqix) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(qix.a(this.this$0))) && (!TextUtils.isEmpty(qix.b(this.this$0))) && (!qix.a(this.this$0).equals(qix.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + qix.a(this.this$0) + ", compress:" + qix.b(this.this$0));
      }
      File localFile = new File(qix.b(this.this$0));
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1
 * JD-Core Version:    0.7.0.1
 */