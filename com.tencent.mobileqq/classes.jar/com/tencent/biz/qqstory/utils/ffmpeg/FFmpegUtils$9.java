package com.tencent.biz.qqstory.utils.ffmpeg;

import bomw;
import bomx;
import java.io.File;
import ykq;
import ykv;

final class FFmpegUtils$9
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$9(ExecuteBinResponseCallback paramExecuteBinResponseCallback, String paramString, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    ykv.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.val$endCallback.onFailure(paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.val$outputClipAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.val$endCallback.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.val$endCallback.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    ykv.a("music_composite", "video_music_composite", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.startime) });
    if (bomw.c) {
      bomw.g.a(1, System.currentTimeMillis() - this.val$mergeStartTime);
    }
    this.val$endCallback.onSuccess(paramString);
    ykq.c("Q.qqstory.ffmpeg.FFmpegCmd", "[vs_publish_flow]   recordVideo combinBackgroundMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.9
 * JD-Core Version:    0.7.0.1
 */