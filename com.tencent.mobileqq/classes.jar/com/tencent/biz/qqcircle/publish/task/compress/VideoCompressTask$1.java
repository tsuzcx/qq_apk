package com.tencent.biz.qqcircle.publish.task.compress;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;

class VideoCompressTask$1
  implements Runnable
{
  VideoCompressTask$1(VideoCompressTask paramVideoCompressTask) {}
  
  public void run()
  {
    if (!this.this$0.c) {
      return;
    }
    VideoCompressTask.a(this.this$0);
    QCircleHostQzoneThreadHelper.postRealTimeThreadDelayed(this.this$0.h, VideoCompressTask.b(this.this$0));
    VideoCompressTask.VideoCompressListener localVideoCompressListener = this.this$0.f;
    VideoCompressTask localVideoCompressTask = this.this$0;
    localVideoCompressListener.a(localVideoCompressTask, localVideoCompressTask.z());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.compress.VideoCompressTask.1
 * JD-Core Version:    0.7.0.1
 */