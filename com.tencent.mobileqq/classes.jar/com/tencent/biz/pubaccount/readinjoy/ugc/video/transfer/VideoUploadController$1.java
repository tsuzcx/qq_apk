package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import rkw;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(rkw paramrkw) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(rkw.a(this.this$0))) && (!TextUtils.isEmpty(rkw.b(this.this$0))) && (!rkw.a(this.this$0).equals(rkw.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + rkw.a(this.this$0) + ", compress:" + rkw.b(this.this$0));
      }
      File localFile = new File(rkw.b(this.this$0));
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1
 * JD-Core Version:    0.7.0.1
 */