package com.tencent.biz.qqstory.utils.ffmpeg;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.MusicCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.util.CaptureFreqMonitorItem;
import java.io.File;

final class FFmpegUtils$15
  extends ExecuteBinResponseCallback
{
  FFmpegUtils$15(ExecuteBinResponseCallback paramExecuteBinResponseCallback, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {}
  
  public void onFailure(String paramString)
  {
    StoryReportor.a("music_composite", "video_music_composite", 0, 1, new String[0]);
    this.val$endCallback.onFailure(paramString);
    if ((this.val$endCallback instanceof VideoCompositeHelper.MusicCallBack)) {
      ((VideoCompositeHelper.MusicCallBack)this.val$endCallback).a(941007);
    }
    QLog.w("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " combineVideoAndAudio failed msg：" + paramString);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.val$outputClipAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$finalMixAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$finalNoneAudioVideoPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(this.val$localAudioPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    this.val$endCallback.onFinish(paramBoolean);
  }
  
  public void onStart()
  {
    super.onStart();
    this.val$endCallback.onStart();
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " combineVideoAndAudio start");
  }
  
  public void onSuccess(String paramString)
  {
    String str = String.valueOf(System.currentTimeMillis() - this.startime);
    StoryReportor.a("music_composite", "video_music_composite", 0, 0, new String[] { str });
    if (CaptureFreqMonitor.c) {
      CaptureFreqMonitor.g.a(1, System.currentTimeMillis() - this.val$mergeStartTime);
    }
    this.val$endCallback.onSuccess(paramString);
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " combineVideoAndAudio end cost time：" + str);
    QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " mergeMusic success end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.15
 * JD-Core Version:    0.7.0.1
 */