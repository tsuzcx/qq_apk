package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnErrorListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoViewVideoHolder$VideoPrepareSegment$5
  implements IVideoView.OnErrorListener
{
  VideoViewVideoHolder$VideoPrepareSegment$5(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment, StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.b.isCanceled()) {
      return true;
    }
    SLog.e(this.b.b.a, "onError, setOnErrorListener [videoView, model=%d, what=%d, position=%d, extra=%s, Info=%s] = ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (paramInt2 == 102)
    {
      paramIVideoView.g();
      return true;
    }
    VideoViewVideoHolder.c(this.b.b, 7);
    VideoViewVideoHolder.a(this.b.b, false);
    VideoViewVideoHolder.b(this.b.b, paramInt2);
    paramIVideoView = this.b;
    paramInt3 = VideoViewVideoHolder.c(paramIVideoView.b);
    paramString = new StringBuilder();
    paramString.append("wht=");
    paramString.append(paramInt2);
    paramString.append(", mod=");
    paramString.append(paramInt1);
    paramString.append(", ");
    paramString.append(this.a.mVid);
    VideoViewVideoHolder.VideoPrepareSegment.b(paramIVideoView, new ErrorMessage(paramInt3, paramString.toString()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.5
 * JD-Core Version:    0.7.0.1
 */