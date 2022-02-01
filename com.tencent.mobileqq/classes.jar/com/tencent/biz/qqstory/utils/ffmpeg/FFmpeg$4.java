package com.tencent.biz.qqstory.utils.ffmpeg;

import ykq;

class FFmpeg$4
  extends ExecuteBinResponseCallback
{
  FFmpeg$4(FFmpeg paramFFmpeg, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback) {}
  
  public void onFailure(String paramString)
  {
    ykq.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.val$endCallback.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    ykq.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.4
 * JD-Core Version:    0.7.0.1
 */