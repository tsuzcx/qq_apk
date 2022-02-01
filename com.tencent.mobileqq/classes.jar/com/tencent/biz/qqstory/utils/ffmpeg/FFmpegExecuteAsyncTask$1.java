package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.qphone.base.util.QLog;

class FFmpegExecuteAsyncTask$1
  implements Runnable
{
  FFmpegExecuteAsyncTask$1(FFmpegExecuteAsyncTask paramFFmpegExecuteAsyncTask) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.this$0.ffmpegExecuteResponseHandler.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */