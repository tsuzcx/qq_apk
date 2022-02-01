package com.tencent.biz.qqstory.utils.ffmpeg;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import xwa;

public class FFmpegUtils$ExecuteFhlipResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public FFmpegExecuteResponseCallback endCallback;
  public long mStartTime;
  
  public FFmpegUtils$ExecuteFhlipResponseCallback(FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.endCallback = paramFFmpegExecuteResponseCallback;
  }
  
  public void onFailure(String paramString)
  {
    if (this.endCallback != null) {
      this.endCallback.onFailure(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video hflip video Error:" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.mStartTime = SystemClock.uptimeMillis();
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(SystemClock.uptimeMillis() - this.mStartTime);
    xwa.a("play_video", "down_watermark_hfliptime", 0, 0, new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video down_watermark_hfliptime:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExecuteFhlipResponseCallback
 * JD-Core Version:    0.7.0.1
 */