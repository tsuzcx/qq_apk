package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.FileDownloadListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class VideoViewVideoHolder$VideoFileSegment
  extends JobSegment<StoryVideoItem, StoryVideoItem>
  implements StorySingleFileDownloader.FileDownloadListener
{
  private StoryVideoItem b;
  private VideoViewVideoHolder.SingleFileDownloaderHolder c;
  private boolean d;
  
  public VideoViewVideoHolder$VideoFileSegment(VideoViewVideoHolder paramVideoViewVideoHolder, VideoViewVideoHolder.SingleFileDownloaderHolder paramSingleFileDownloaderHolder, boolean paramBoolean)
  {
    this.c = paramSingleFileDownloaderHolder;
    this.d = paramBoolean;
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.a, 6);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.a, 5);
    this.b = paramStoryVideoItem;
    if (this.d)
    {
      a(paramStoryVideoItem);
      return;
    }
    SLog.d(this.a.a, "showVideo, start download video fully");
    VideoViewVideoHolder.a(this.a, 5);
    this.c.a().a(paramStoryVideoItem.mVid, 0, true, this);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      SLog.d(this.a.a, "showVideo, start download video fully, onSuccess");
      VideoViewVideoHolder.a(this.a, "VD", SystemClock.uptimeMillis());
      a(this.b);
      return;
    }
    SLog.d(this.a.a, "showVideo, start download video fully, onSuccess. stream canceled");
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    if (!isCanceled())
    {
      SLog.b(this.a.a, paramErrorMessage, "showVideo, start download video fully, onError", new Object[0]);
      VideoViewVideoHolder.c(this.a, 3);
      VideoViewVideoHolder.a(this.a, false);
      VideoViewVideoHolder.b(this.a, paramErrorMessage.errorCode);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), paramErrorMessage.getErrorMessage()));
      return;
    }
    SLog.b(this.a.a, paramErrorMessage, "showVideo, start download video fully, onError. stream canceled", new Object[0]);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!isCanceled())
    {
      SLog.d(this.a.a, "showVideo, start download video fully, onCancel");
      VideoViewVideoHolder.c(this.a, 3);
      VideoViewVideoHolder.a(this.a, false);
      VideoViewVideoHolder.b(this.a, 1234);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "Download video cancel"));
      return;
    }
    SLog.d(this.a.a, "showVideo, start download video fully, onCancel. stream canceled");
  }
  
  protected void onCancel()
  {
    super.onCancel();
    SLog.b(this.a.a, "VideoFileSegment onCancel");
    if (this.b != null) {
      this.c.a().a(this.b.mVid, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoFileSegment
 * JD-Core Version:    0.7.0.1
 */