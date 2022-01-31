package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoSaveToAlbumHelper$SaveVideoTaskCallback
  implements FFmpegExecuteResponseCallback
{
  private VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo;
  
  public VideoSaveToAlbumHelper$SaveVideoTaskCallback(VideoSaveToAlbumHelper paramVideoSaveToAlbumHelper, VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo paramVideoSaveToAlbumTaskInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo = paramVideoSaveToAlbumTaskInfo;
  }
  
  public void a()
  {
    SLog.b(VideoSaveToAlbumHelper.a, "start executing ffmpeg commands.");
  }
  
  public void a(String paramString)
  {
    if (FileUtils.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo.d, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper$VideoSaveToAlbumTaskInfo.e))
    {
      SLog.b(VideoSaveToAlbumHelper.a, "save video to album success.");
      StoryReportor.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    SLog.e(VideoSaveToAlbumHelper.a, "save video to album failed.");
  }
  
  public void a(boolean paramBoolean)
  {
    VideoSaveToAlbumHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper);
    if (VideoSaveToAlbumHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper) == 0)
    {
      SLog.b(VideoSaveToAlbumHelper.a, "all ffmpeg commands have already finished. start clearing cache.");
      VideoSaveToAlbumHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper);
    }
  }
  
  public void b(String paramString)
  {
    SLog.e(VideoSaveToAlbumHelper.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.SaveVideoTaskCallback
 * JD-Core Version:    0.7.0.1
 */