package com.tencent.biz.qqcircle.publish.task.compress;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.service.video.RemoteVideoServiceHandler;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

class VideoCompressTask$HandleVideoTimeoutRunnable
  implements Runnable
{
  public String a;
  
  private VideoCompressTask$HandleVideoTimeoutRunnable(VideoCompressTask paramVideoCompressTask) {}
  
  public void run()
  {
    if (!this.this$0.c) {
      return;
    }
    if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals(this.this$0.i()))) {
      return;
    }
    Object localObject = this.this$0;
    ((VideoCompressTask)localObject).c = false;
    ((VideoCompressTask)localObject).d += 1;
    RemoteVideoServiceHandler.a().b(this.this$0.i());
    QLog.w("[upload2_VideoCompressTask]", 1, "VideoCompressTask video handle timeout");
    int i = QCircleConfigHelper.a("MiniVideo", "videoTaskRetryForTimeout", Integer.valueOf(1)).intValue();
    if (this.this$0.d <= i)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VideoCompressTask retry for TIME_OUT, maxRetryNum:");
        ((StringBuilder)localObject).append(VideoCompressEngine.a().d);
        ((StringBuilder)localObject).append(", currentTryNum:");
        ((StringBuilder)localObject).append(this.this$0.d);
        QLog.d("[upload2_VideoCompressTask]", 2, ((StringBuilder)localObject).toString());
      }
      VideoCompressEngine.a().c(this.this$0);
      return;
    }
    localObject = this.this$0;
    ((VideoCompressTask)localObject).ao = ((VideoCompressTask)localObject).j;
    this.this$0.f.a(this.this$0, 100081);
    VideoCompressEngine.a().a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.compress.VideoCompressTask.HandleVideoTimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */