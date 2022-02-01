package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnInfoListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

class VideoViewVideoHolder$VideoPrepareSegment$1
  implements IVideoView.OnInfoListener
{
  VideoViewVideoHolder$VideoPrepareSegment$1(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (this.a.isCanceled()) {
      return false;
    }
    SLog.a(this.a.b.a, "onInfo, [videoView=%d, what=%d, extra=%s]", Integer.valueOf(System.identityHashCode(paramIVideoView)), Integer.valueOf(paramInt), paramObject);
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 23)
          {
            if (paramInt != 24)
            {
              if (paramInt != 39) {
                break label288;
              }
              SLog.d(this.a.b.a, "PLAYER_INFO_HW_DECODE_FAILED. extra=%s", new Object[] { paramObject });
              break label288;
            }
            VideoViewVideoHolder.e(this.a.b, ((Integer)paramObject).intValue());
            break label288;
          }
        }
        else
        {
          VideoViewVideoHolder.g(this.a.b, (int)(VideoViewVideoHolder.g(this.a.b) + (SystemClock.uptimeMillis() - VideoViewVideoHolder.h(this.a.b))));
          SLog.d(this.a.b.a, "end buffering, hide loading view");
          this.a.b.s.setVisibility(8);
          break label288;
        }
      }
      else
      {
        SLog.d(this.a.b.a, "start buffering, show loading view");
        VideoViewVideoHolder.f(this.a.b, VideoViewVideoHolder.f(this.a.b) + 1);
        VideoViewVideoHolder.a(this.a.b, SystemClock.uptimeMillis());
        VideoViewVideoHolder.a(this.a.b, 8);
        this.a.b.s.setVisibility(0);
        break label288;
      }
    }
    VideoViewVideoHolder.a(this.a.b, 0L, "rendering-Start");
    label288:
    VideoViewVideoHolder.i(this.a.b).a(this.a.b, paramIVideoView, paramInt, paramObject);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.1
 * JD-Core Version:    0.7.0.1
 */