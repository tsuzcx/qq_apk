package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import rrw;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(rrw paramrrw) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(rrw.a(this.this$0))) && (!TextUtils.isEmpty(rrw.b(this.this$0))) && (!rrw.a(this.this$0).equals(rrw.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + rrw.a(this.this$0) + ", compress:" + rrw.b(this.this$0));
      }
      File localFile = new File(rrw.b(this.this$0));
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