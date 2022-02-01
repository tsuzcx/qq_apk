package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.QLog;

final class FFmpegUtils$7
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$7(ExecuteBinResponseCallback paramExecuteBinResponseCallback) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.val$endCallback.onFailure(paramString);
    StoryReportor.a("music_composite", "music_clip", 0, 1, new String[0]);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(System.currentTimeMillis() - this.startime);
    StoryReportor.a("music_composite", "music_clip", 0, 0, new String[] { paramString });
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 2, "音乐截取成功耗时：" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.7
 * JD-Core Version:    0.7.0.1
 */