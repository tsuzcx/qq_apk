package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.io.File;

class VideoViewVideoHolder$VideoPrepareSegment
  extends JobSegment<StoryVideoItem, StoryVideoItem>
{
  StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  
  private VideoViewVideoHolder$VideoPrepareSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    if (VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 8))
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 8);
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
      super.notifyResult(paramStoryVideoItem);
      return;
    }
    SLog.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "STATE_PREPARE_ED ignore");
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 7);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    paramJobContext = null;
    File localFile = FileCacheUtils.a(paramStoryVideoItem.mVid, 0, false, false);
    if ((localFile != null) && (FileCacheUtils.a(localFile))) {
      paramJobContext = localFile.getAbsolutePath();
    }
    for (;;)
    {
      if (paramJobContext == null)
      {
        SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "finalFileName null, hide loading view");
        VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 8);
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
        SLog.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "setVideoPath, fileName is empty !!");
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, HardCodeUtil.a(2131716264));
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "fileName null"));
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.b())
        {
          if ((!TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) || (!TextUtils.isEmpty(paramStoryVideoItem.mTempVideoUrl)))
          {
            localFile = FileCacheUtils.a(paramStoryVideoItem.mVid, 0, true, true);
            if (localFile != null) {
              paramJobContext = localFile.getAbsolutePath();
            }
            for (;;)
            {
              break;
              SLog.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "showVideo, vid=%s, support stream, getLocalFile return null", new Object[] { paramStoryVideoItem.mVid });
            }
          }
        }
        else {
          notifyError(new ErrorMessage(-1, "not tvk videoView, and videoFile has not downloaded."));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(0);
        SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "set video view listeners ... and then setVideoPath");
        VideoViewVideoHolder.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(new VideoViewVideoHolder.VideoPrepareSegment.1(this));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(new VideoViewVideoHolder.VideoPrepareSegment.2(this, paramJobContext, paramStoryVideoItem));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(new VideoViewVideoHolder.VideoPrepareSegment.3(this, paramStoryVideoItem));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(new VideoViewVideoHolder.VideoPrepareSegment.4(this, paramStoryVideoItem));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(new VideoViewVideoHolder.VideoPrepareSegment.5(this, paramStoryVideoItem));
        ((DownloadUrlManager)SuperManager.a(28)).a(paramStoryVideoItem.mVid, 0, new VideoViewVideoHolder.VideoPrepareSegment.6(this, paramStoryVideoItem, paramJobContext));
        return;
      }
      paramJobContext = null;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "VideoPrepareSegment onCancel");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment
 * JD-Core Version:    0.7.0.1
 */