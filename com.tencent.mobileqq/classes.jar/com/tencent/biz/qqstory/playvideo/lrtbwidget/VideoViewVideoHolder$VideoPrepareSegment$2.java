package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnDownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class VideoViewVideoHolder$VideoPrepareSegment$2
  implements IVideoView.OnDownloadListener
{
  VideoViewVideoHolder$VideoPrepareSegment$2(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment, String paramString, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(String paramString, File paramFile, int paramInt, JSONObject paramJSONObject) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.isCanceled()) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.2(this, paramInt));
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.isCanceled()) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1(this, paramString1, paramString2, paramFile));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2
 * JD-Core Version:    0.7.0.1
 */