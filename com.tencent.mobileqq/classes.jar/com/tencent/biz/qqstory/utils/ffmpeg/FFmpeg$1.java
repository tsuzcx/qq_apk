package com.tencent.biz.qqstory.utils.ffmpeg;

import java.util.ArrayList;

class FFmpeg$1
  extends ExecuteBinResponseCallback
{
  FFmpeg$1(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback) {}
  
  public void onFailure(String paramString)
  {
    this.val$callback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    FFmpeg localFFmpeg;
    if (this.this$0.mCmdQueue.size() == 0)
    {
      localFFmpeg = this.this$0;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = 1;; i = 0)
    {
      localFFmpeg.mLastTaskResult = i;
      FFmpeg.instance = null;
      this.val$callback.onFinish(paramBoolean);
      return;
    }
  }
  
  public void onProgress(String paramString)
  {
    this.val$callback.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.val$callback.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.val$callback.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.1
 * JD-Core Version:    0.7.0.1
 */