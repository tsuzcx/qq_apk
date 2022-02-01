package com.tencent.biz.qqstory.utils.ffmpeg;

public class ExecuteBinResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public long startime;
  
  public void onFailure(String paramString) {}
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.startime = System.currentTimeMillis();
  }
  
  public void onSuccess(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback
 * JD-Core Version:    0.7.0.1
 */