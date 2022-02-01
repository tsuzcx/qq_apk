package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

final class FFmpegUtils$23
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$23(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, paramString);
    }
    this.val$endCallback.onFailure(paramString);
    QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 2, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " combine mix music and original failed " + paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 2, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " combine mix music and original start");
  }
  
  public void onSuccess(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startime;
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 2, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " combine mix music and original：" + String.valueOf(l1 - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.23
 * JD-Core Version:    0.7.0.1
 */