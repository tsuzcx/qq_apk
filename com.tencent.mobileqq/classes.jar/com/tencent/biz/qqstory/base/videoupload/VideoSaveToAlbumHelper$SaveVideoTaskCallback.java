package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoSaveToAlbumHelper$SaveVideoTaskCallback
  implements FFmpegExecuteResponseCallback
{
  private VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo b;
  
  public VideoSaveToAlbumHelper$SaveVideoTaskCallback(VideoSaveToAlbumHelper paramVideoSaveToAlbumHelper, VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo paramVideoSaveToAlbumTaskInfo)
  {
    this.b = paramVideoSaveToAlbumTaskInfo;
  }
  
  public void onFailure(String paramString)
  {
    SLog.e(VideoSaveToAlbumHelper.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    VideoSaveToAlbumHelper.a(this.a);
    if (VideoSaveToAlbumHelper.b(this.a) == 0)
    {
      SLog.b(VideoSaveToAlbumHelper.a, "all ffmpeg commands have already finished. start clearing cache.");
      VideoSaveToAlbumHelper.c(this.a);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    SLog.b(VideoSaveToAlbumHelper.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (FileUtils.a(BaseApplication.getContext(), this.b.f, this.b.g))
    {
      SLog.b(VideoSaveToAlbumHelper.a, "save video to album success.");
      StoryReportor.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    SLog.e(VideoSaveToAlbumHelper.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.SaveVideoTaskCallback
 * JD-Core Version:    0.7.0.1
 */