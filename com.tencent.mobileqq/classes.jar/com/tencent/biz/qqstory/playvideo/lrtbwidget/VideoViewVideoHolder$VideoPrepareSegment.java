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
  StoryVideoItem a;
  
  private VideoViewVideoHolder$VideoPrepareSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    if (VideoViewVideoHolder.h(this.b, 8))
    {
      VideoViewVideoHolder.d(this.b, 8);
      VideoViewVideoHolder.VideoViewListener localVideoViewListener = VideoViewVideoHolder.i(this.b);
      VideoViewVideoHolder localVideoViewVideoHolder = this.b;
      localVideoViewListener.a(localVideoViewVideoHolder, localVideoViewVideoHolder.p);
      super.notifyResult(paramStoryVideoItem);
      return;
    }
    SLog.e(this.b.a, "STATE_PREPARE_ED ignore");
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.b, 7);
    this.a = paramStoryVideoItem;
    paramJobContext = FileCacheUtils.a(paramStoryVideoItem.mVid, 0, false, false);
    Object localObject = null;
    if ((paramJobContext != null) && (FileCacheUtils.a(paramJobContext)))
    {
      paramJobContext = paramJobContext.getAbsolutePath();
    }
    else
    {
      if (!this.b.l()) {
        break label385;
      }
      if (TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl))
      {
        paramJobContext = localObject;
        if (TextUtils.isEmpty(paramStoryVideoItem.mTempVideoUrl)) {}
      }
      else
      {
        paramJobContext = FileCacheUtils.a(paramStoryVideoItem.mVid, 0, true, true);
        if (paramJobContext != null)
        {
          paramJobContext = paramJobContext.getAbsolutePath();
        }
        else
        {
          SLog.e(this.b.a, "showVideo, vid=%s, support stream, getLocalFile return null", new Object[] { paramStoryVideoItem.mVid });
          paramJobContext = localObject;
        }
      }
    }
    if (paramJobContext == null)
    {
      SLog.d(this.b.a, "finalFileName null, hide loading view");
      VideoViewVideoHolder.c(this.b, 8);
      VideoViewVideoHolder.a(this.b, false);
      SLog.e(this.b.a, "setVideoPath, fileName is empty !!");
      VideoViewVideoHolder.a(this.b, HardCodeUtil.a(2131913618));
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.b), "fileName null"));
      return;
    }
    this.b.t.setVisibility(8);
    this.b.p.a(0);
    SLog.b(this.b.a, "set video view listeners ... and then setVideoPath");
    VideoViewVideoHolder.e(this.b, 0);
    this.b.p.a(new VideoViewVideoHolder.VideoPrepareSegment.1(this));
    this.b.p.a(new VideoViewVideoHolder.VideoPrepareSegment.2(this, paramJobContext, paramStoryVideoItem));
    this.b.p.a(new VideoViewVideoHolder.VideoPrepareSegment.3(this, paramStoryVideoItem));
    this.b.p.a(new VideoViewVideoHolder.VideoPrepareSegment.4(this, paramStoryVideoItem));
    this.b.p.a(new VideoViewVideoHolder.VideoPrepareSegment.5(this, paramStoryVideoItem));
    ((DownloadUrlManager)SuperManager.a(28)).a(paramStoryVideoItem.mVid, 0, new VideoViewVideoHolder.VideoPrepareSegment.6(this, paramStoryVideoItem, paramJobContext));
    return;
    label385:
    notifyError(new ErrorMessage(-1, "not tvk videoView, and videoFile has not downloaded."));
  }
  
  protected void onCancel()
  {
    super.onCancel();
    SLog.b(this.b.a, "VideoPrepareSegment onCancel");
    this.b.p.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment
 * JD-Core Version:    0.7.0.1
 */