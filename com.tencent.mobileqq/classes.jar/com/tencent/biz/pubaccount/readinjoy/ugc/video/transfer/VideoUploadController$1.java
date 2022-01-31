package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import pwz;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(pwz parampwz) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(pwz.a(this.this$0))) && (!TextUtils.isEmpty(pwz.b(this.this$0))) && (!pwz.a(this.this$0).equals(pwz.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + pwz.a(this.this$0) + ", compress:" + pwz.b(this.this$0));
      }
      File localFile = new File(pwz.b(this.this$0));
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