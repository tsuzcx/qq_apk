package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.qphone.base.util.QLog;

class VideoEncoderCore$VideoEncodeThread
  extends Thread
{
  public VideoEncoderCore$VideoEncodeThread(VideoEncoderCore paramVideoEncoderCore)
  {
    super("VideoEncodeThread");
  }
  
  public void run()
  {
    synchronized ()
    {
      do
      {
        if (VideoEncoderCore.b(this.this$0))
        {
          QLog.d("VideoEncoderCore", 1, "VideoEncodeThread thread exit.");
          return;
        }
        long l = VideoEncoderCore.c(this.this$0);
        if (l == 0L) {
          try
          {
            VideoEncoderCore.c().wait();
          }
          catch (Exception localException2)
          {
            QLog.e("VideoEncoderCore", 1, "VideoEncodeThread wait exception?", localException2);
          }
        }
      } while (VideoEncoderCore.c(this.this$0) == 0L);
      try
      {
        VideoEncoderCore.a(this.this$0, VideoEncoderCore.c(this.this$0), false);
      }
      catch (Exception localException1)
      {
        QLog.e("VideoEncoderCore", 1, "VideoEncodeThread encode video fail.", localException1);
        if (VideoEncoderCore.a(this.this$0) != null) {
          VideoEncoderCore.a(this.this$0).a(4);
        }
      }
      VideoEncoderCore.a(this.this$0, 0L);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore.VideoEncodeThread
 * JD-Core Version:    0.7.0.1
 */