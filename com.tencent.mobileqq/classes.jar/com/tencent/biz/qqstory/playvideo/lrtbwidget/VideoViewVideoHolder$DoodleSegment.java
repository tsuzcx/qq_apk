package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.FileDownloadListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class VideoViewVideoHolder$DoodleSegment
  extends JobSegment<StoryVideoItem, StoryVideoItem>
  implements StorySingleFileDownloader.FileDownloadListener
{
  private StoryVideoItem b;
  private VideoViewVideoHolder.SingleFileDownloaderHolder c;
  
  public VideoViewVideoHolder$DoodleSegment(VideoViewVideoHolder paramVideoViewVideoHolder, VideoViewVideoHolder.SingleFileDownloaderHolder paramSingleFileDownloaderHolder)
  {
    this.c = paramSingleFileDownloaderHolder;
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.a, 4);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.a, 3);
    this.b = paramStoryVideoItem;
    int i = paramStoryVideoItem.isMaskDownloaded();
    if (i == 0)
    {
      VideoViewVideoHolder.a(this.a, 4);
      this.a.t.setVisibility(8);
      this.a.p.a(8);
      SLog.a(this.a.a, "wait doodle download and display ... %s", paramStoryVideoItem.getDownloadMaskUrl());
      VideoViewVideoHolder.a(this.a, HardCodeUtil.a(2131913622));
      this.c.a().a(paramStoryVideoItem.mVid, 1, true, this);
      return;
    }
    if (i == 1)
    {
      this.a.r.setVisibility(0);
      PlayModeUtils.a(this.a.r, paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.getDownloadMaskUrl(), VideoViewVideoHolder.d(this.a));
      VideoViewVideoHolder.a(this.a, HardCodeUtil.a(2131913617));
    }
    else
    {
      this.a.r.setVisibility(8);
    }
    a(paramStoryVideoItem);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      VideoViewVideoHolder.a(this.a, "DD", SystemClock.uptimeMillis());
      this.a.r.setVisibility(0);
      PlayModeUtils.a(this.a.r, this.b.mLocalMaskPath, this.b.getDownloadMaskUrl(), VideoViewVideoHolder.d(this.a));
      a(this.b);
      return;
    }
    SLog.d(this.a.a, "wait doodle download and display onSuccess. stream canceled.");
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    if (!isCanceled())
    {
      SLog.d(this.a.a, "wait doodle download and display error. vid :%s, error=%s", new Object[] { this.b.mVid, paramErrorMessage });
      VideoViewVideoHolder.c(this.a, 2);
      VideoViewVideoHolder.a(this.a, false);
      VideoViewVideoHolder.b(this.a, paramErrorMessage.errorCode);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "doodle download failed"));
      return;
    }
    SLog.d(this.a.a, "wait doodle download and display error. stream canceled.");
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      SLog.d(this.a.a, "wait doodle download and display cancel. vid :%s", new Object[] { this.b.mVid });
      VideoViewVideoHolder.c(this.a, 2);
      VideoViewVideoHolder.a(this.a, false);
      VideoViewVideoHolder.b(this.a, 1234);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "doodle download cancel"));
      return;
    }
    SLog.d(this.a.a, "wait doodle download and display cancel. stream canceled.");
  }
  
  protected void onCancel()
  {
    super.onCancel();
    SLog.b(this.a.a, "DoodleSegment onCancel");
    if (this.b != null) {
      this.c.a().a(this.b.mVid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.DoodleSegment
 * JD-Core Version:    0.7.0.1
 */