package com.tencent.biz.qqstory.utils.ffmpeg;

import java.io.File;
import java.util.ArrayList;

class FFmpeg$2
  extends ExecuteBinResponseCallback
{
  FFmpeg$2(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, File paramFile) {}
  
  public void onFailure(String paramString)
  {
    this.val$callback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (this.val$tempFile.exists()) {
      this.val$tempFile.delete();
    }
    int i = 0;
    while (i < this.this$0.tsFileList.size())
    {
      File localFile = new File((String)this.this$0.tsFileList.get(i));
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    this.this$0.tsFileList = new ArrayList();
    this.val$callback.onFinish(paramBoolean);
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
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.2
 * JD-Core Version:    0.7.0.1
 */