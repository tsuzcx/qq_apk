package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import qiu;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(qiu paramqiu) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(qiu.a(this.this$0))) && (!TextUtils.isEmpty(qiu.b(this.this$0))) && (!qiu.a(this.this$0).equals(qiu.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + qiu.a(this.this$0) + ", compress:" + qiu.b(this.this$0));
      }
      File localFile = new File(qiu.b(this.this$0));
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