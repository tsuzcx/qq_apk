package com.tencent.biz.qqstory.utils.ffmpeg;

import java.io.IOException;
import java.util.ArrayList;
import xvv;

class FFmpeg$6
  extends ExecuteBinResponseCallback
{
  FFmpeg$6(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, String[] paramArrayOfString, ArrayList paramArrayList) {}
  
  public void onFailure(String paramString)
  {
    xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", paramString);
    this.val$unitCallback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.val$cmd == null) {
      this.val$unitCallback.onFinish(paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      this.this$0.cmdFFmpegQueue(this.val$nextQueue);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      this.val$unitCallback.onFailure(localFFmpegCommandAlreadyRunningException.getMessage());
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", localFFmpegCommandAlreadyRunningException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      this.val$unitCallback.onFailure(localIOException.getMessage());
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", localIOException.getMessage());
    }
  }
  
  public void onProgress(String paramString)
  {
    this.val$unitCallback.onProgress(paramString);
  }
  
  public void onStart()
  {
    this.val$unitCallback.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    this.val$unitCallback.onSuccess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.6
 * JD-Core Version:    0.7.0.1
 */