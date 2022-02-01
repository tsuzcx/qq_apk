package com.tencent.aelight.camera.ae.camera.testpkg;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

class VideoDecodeHardWare$1
  implements Runnable
{
  boolean a = true;
  boolean b = false;
  long c = 0L;
  boolean d = true;
  boolean e = false;
  boolean f = false;
  MediaCodec.BufferInfo g = null;
  ByteBuffer[] h = null;
  int i = 0;
  long j = 0L;
  
  VideoDecodeHardWare$1(VideoDecodeHardWare paramVideoDecodeHardWare) {}
  
  private void a()
  {
    int k = VideoDecodeHardWare.b(this.this$0).dequeueOutputBuffer(this.g, 10000L);
    if (k != -3)
    {
      if (k != -2)
      {
        if (k != -1)
        {
          if (!this.b)
          {
            this.c = System.currentTimeMillis();
            this.b = true;
          }
          if ((this.e) && (this.d) && (this.j > this.g.presentationTimeUs) && (VideoDecodeHardWare.d(this.this$0) != null))
          {
            VideoDecodeHardWare.d(this.this$0).b();
            this.d = false;
          }
          this.j = this.g.presentationTimeUs;
          try
          {
            long l = this.g.presentationTimeUs / 1000L - (System.currentTimeMillis() - this.c);
            if (l > 0L) {
              Thread.sleep(l);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("InterruptedException : ");
            localStringBuilder2.append(localInterruptedException.getMessage());
            QLog.d("VideoDecoder", 4, localStringBuilder2.toString());
            localInterruptedException.printStackTrace();
          }
          VideoDecodeHardWare.b(this.this$0).releaseOutputBuffer(k, true);
          return;
        }
        QLog.d("VideoDecoder", 4, "INFO_TRY_AGAIN_LATER");
        this.this$0.c();
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("INFO_OUTPUT_FORMAT_CHANGED format : ");
      localStringBuilder1.append(VideoDecodeHardWare.b(this.this$0).getOutputFormat());
      QLog.d("VideoDecoder", 4, localStringBuilder1.toString());
      this.this$0.c();
      return;
    }
    QLog.d("VideoDecoder", 4, "INFO_OUTPUT_BUFFERS_CHANGED");
    VideoDecodeHardWare.b(this.this$0).getOutputBuffers();
    this.this$0.c();
  }
  
  public void run()
  {
    if (VideoDecodeHardWare.a(this.this$0)) {
      return;
    }
    if (!this.f)
    {
      this.g = new MediaCodec.BufferInfo();
      this.h = VideoDecodeHardWare.b(this.this$0).getInputBuffers();
      VideoDecodeHardWare.b(this.this$0).getOutputBuffers();
      this.f = true;
    }
    int k;
    for (;;)
    {
      k = VideoDecodeHardWare.b(this.this$0).dequeueInputBuffer(10000L);
      if (k < 0) {
        break;
      }
      this.i = 0;
      localObject = this.h[k];
      int m = VideoDecodeHardWare.c(this.this$0).readSampleData((ByteBuffer)localObject, 0);
      if ((VideoDecodeHardWare.c(this.this$0).advance()) && (m > 0))
      {
        VideoDecodeHardWare.b(this.this$0).queueInputBuffer(k, 0, m, VideoDecodeHardWare.c(this.this$0).getSampleTime(), 0);
        break label262;
      }
      if ((this.e) && (VideoDecodeHardWare.d(this.this$0) != null)) {
        VideoDecodeHardWare.d(this.this$0).a();
      }
      VideoDecodeHardWare.c(this.this$0).seekTo(0L, 2);
      this.e = true;
      QLog.d("VideoDecoder", 4, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
    }
    this.i += 1;
    if (this.i >= 4) {
      VideoDecodeHardWare.b(this.this$0).flush();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("InputBuffer inputIndex:");
    ((StringBuilder)localObject).append(k);
    QLog.d("VideoDecoder", 4, ((StringBuilder)localObject).toString());
    label262:
    a();
    if ((this.g.flags & 0x4) != 0) {
      QLog.d("VideoDecoder", 4, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.VideoDecodeHardWare.1
 * JD-Core Version:    0.7.0.1
 */