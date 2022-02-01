package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class VideoViewVideoHolder$CheckDataSegment
  extends JobSegment<StoryPlayerVideoData, String>
{
  private VideoViewVideoHolder$CheckDataSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(JobContext paramJobContext, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    SLog.b(this.a.a, "CheckDataSegment runSegment");
    if (this.a.c.a())
    {
      SLog.b(this.a.a, "isLoadingData, show loading view");
      VideoViewVideoHolder.a(this.a, 2);
      this.a.s.setVisibility(0);
      this.a.t.setVisibility(8);
      this.a.p.a(8);
      this.a.q.setVisibility(8);
      this.a.r.setVisibility(8);
      notifyError(new ErrorMessage(0, "isLoadingData"));
      return;
    }
    if (this.a.c.b())
    {
      SLog.b(this.a.a, "showPage, show error view, because this is a error data = %s", this.a.c.c());
      paramJobContext = this.a;
      VideoViewVideoHolder.b(paramJobContext, paramJobContext.c.c().errorCode);
      VideoViewVideoHolder.a(this.a, false);
      SLog.d(this.a.a, "isErrorData, hide loading view. subErrorCode=%d", new Object[] { Integer.valueOf(VideoViewVideoHolder.b(this.a)) });
      if (VideoViewVideoHolder.b(this.a) == 97000000)
      {
        VideoViewVideoHolder.c(this.a, 4);
        notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "PLAY_DATA_NO_VID"));
        return;
      }
      VideoViewVideoHolder.c(this.a, 9);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "isErrorData"));
      return;
    }
    if (StoryVideoItem.isFakeVid(this.a.c.b))
    {
      paramJobContext = ((StoryManager)SuperManager.a(5)).b(this.a.c.b);
      if (paramJobContext != null)
      {
        VideoViewVideoHolder.a(this.a, paramJobContext);
        this.a.q.setVisibility(0);
        paramStoryPlayerVideoData = (String)this.a.q.getTag();
        if (!TextUtils.equals(this.a.c.b, paramStoryPlayerVideoData))
        {
          this.a.q.setTag(this.a.c.b);
          PlayModeUtils.a(this.a.q, paramJobContext.mVideoLocalThumbnailPath, paramJobContext.getThumbUrl(), VideoViewVideoHolder.d(this.a), this.a.x);
        }
        SLog.d(this.a.a, "showPage, show error view, because this is fake vid = %s", new Object[] { this.a.c.b });
        VideoViewVideoHolder.c(this.a, 5);
        VideoViewVideoHolder.a(this.a, false);
        notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "isFakeData"));
        return;
      }
      VideoViewVideoHolder.c(this.a, 11);
      VideoViewVideoHolder.a(this.a, false);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.a), "Fake Vid No Data"));
      return;
    }
    notifyResult(this.a.c.b);
  }
  
  protected void onCancel()
  {
    super.onCancel();
    SLog.b(this.a.a, "CheckDataSegment onCancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.CheckDataSegment
 * JD-Core Version:    0.7.0.1
 */