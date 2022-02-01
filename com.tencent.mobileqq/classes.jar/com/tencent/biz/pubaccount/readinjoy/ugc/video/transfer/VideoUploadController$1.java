package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import rua;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(rua paramrua) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(rua.a(this.this$0))) && (!TextUtils.isEmpty(rua.b(this.this$0))) && (!rua.a(this.this$0).equals(rua.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + rua.a(this.this$0) + ", compress:" + rua.b(this.this$0));
      }
      File localFile = new File(rua.b(this.this$0));
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