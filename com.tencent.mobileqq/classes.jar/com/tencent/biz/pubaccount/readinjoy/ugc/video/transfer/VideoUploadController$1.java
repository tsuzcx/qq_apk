package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import qyb;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(qyb paramqyb) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(qyb.a(this.this$0))) && (!TextUtils.isEmpty(qyb.b(this.this$0))) && (!qyb.a(this.this$0).equals(qyb.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + qyb.a(this.this$0) + ", compress:" + qyb.b(this.this$0));
      }
      File localFile = new File(qyb.b(this.this$0));
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