package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.qphone.base.util.QLog;
import xtj;
import xtk;

public class FFmpegExecuteAsyncTask$1
  implements Runnable
{
  public FFmpegExecuteAsyncTask$1(xtj paramxtj) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.this$0.a.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */