package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import ykv;

final class FFmpegUtils$13
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$13(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 1, paramString);
    this.val$endCallback.onFailure(paramString);
    ykv.a("music_composite", "music_clip", 0, 1, new String[0]);
    QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " clip audio failed  msg：" + paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " clip audio start");
  }
  
  public void onSuccess(String paramString)
  {
    paramString = String.valueOf(System.currentTimeMillis() - this.startime);
    ykv.a("music_composite", "music_clip", 0, 0, new String[] { paramString });
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " clip audio end cost：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.13
 * JD-Core Version:    0.7.0.1
 */