package com.tencent.aelight.camera.ae.camera.testpkg;

import android.media.MediaCodec;
import android.media.MediaExtractor;

class VideoDecodeHardWare$2
  implements Runnable
{
  VideoDecodeHardWare$2(VideoDecodeHardWare paramVideoDecodeHardWare) {}
  
  public void run()
  {
    VideoDecodeHardWare.b(this.this$0).stop();
    VideoDecodeHardWare.b(this.this$0).release();
    VideoDecodeHardWare.c(this.this$0).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.VideoDecodeHardWare.2
 * JD-Core Version:    0.7.0.1
 */