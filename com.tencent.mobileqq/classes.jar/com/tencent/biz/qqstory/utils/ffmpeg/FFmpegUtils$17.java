package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.MusicCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class FFmpegUtils$17
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$17(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.val$endCallback.onFailure(paramString);
    if ((this.val$endCallback instanceof VideoCompositeHelper.MusicCallBack)) {
      ((VideoCompositeHelper.MusicCallBack)this.val$endCallback).a(941006);
    }
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " getVideoFromMp4 failed msg：" + paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " getVideoFromMp4 start");
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startime;
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " getVideoFromMp4 success cost：" + String.valueOf(l1 - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.17
 * JD-Core Version:    0.7.0.1
 */