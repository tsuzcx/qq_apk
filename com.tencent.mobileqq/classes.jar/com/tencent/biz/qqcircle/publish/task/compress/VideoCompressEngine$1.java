package com.tencent.biz.qqcircle.publish.task.compress;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.service.video.RemoteVideoServiceHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCompressEngine$1
  implements Runnable
{
  VideoCompressEngine$1(VideoCompressEngine paramVideoCompressEngine, String paramString, int paramInt, VideoCompressTask paramVideoCompressTask) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a))
      {
        File localFile = new File(this.a);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
    catch (Exception localException)
    {
      QLog.w("[upload2_VideoCompressEngine]", 1, localException.getMessage());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoCompressTask error code=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", retryNum=");
      localStringBuilder.append(this.c.d);
      localStringBuilder.append(", retry4Dis=");
      localStringBuilder.append(this.this$0.b);
      localStringBuilder.append(", retry4Conn=");
      localStringBuilder.append(this.this$0.c);
      localStringBuilder.append(", retry4build=");
      localStringBuilder.append(this.this$0.d);
      QLog.d("[upload2_VideoCompressEngine]", 2, localStringBuilder.toString());
    }
    if ((1 == this.b) && (this.c.d <= this.this$0.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask retry for VIDEO_SERVICE_DISCONNECT");
      }
      this.c.B();
      return;
    }
    if ((2 == this.b) && (this.c.d <= this.this$0.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask retry for VIDEO_SERVICE_CONNECT_FAILED");
      }
      this.c.B();
      return;
    }
    if (this.c.d <= this.this$0.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask retry for VIDEO_SERVICE_ERROR_UNKNOWN");
      }
      this.c.B();
      return;
    }
    this.this$0.b(this.c);
    RemoteVideoServiceHandler.a().b(this.c.i());
    this.c.f.a(this.c, 100081);
    this.this$0.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.compress.VideoCompressEngine.1
 * JD-Core Version:    0.7.0.1
 */