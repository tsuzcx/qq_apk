package com.tencent.biz.troop;

import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$FFmpegCallback
  implements FFmpegExecuteResponseCallback
{
  VideoCombineHelper$FFmpegCallback(VideoCombineHelper paramVideoCombineHelper) {}
  
  public void a(boolean paramBoolean) {}
  
  public void onFailure(String paramString)
  {
    a(false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ffmpeg onFailure");
      localStringBuilder.append(paramString);
      QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ffmpeg onProgress");
      localStringBuilder.append(paramString);
      QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onStart");
    }
  }
  
  public void onSuccess(String paramString)
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.FFmpegCallback
 * JD-Core Version:    0.7.0.1
 */