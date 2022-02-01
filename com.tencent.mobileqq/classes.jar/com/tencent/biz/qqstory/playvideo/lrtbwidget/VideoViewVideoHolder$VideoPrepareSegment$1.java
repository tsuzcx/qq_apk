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
    SLog.a(this.a.a.jdField_a_of_type_JavaLangString, "onInfo, [videoView=%d, what=%d, extra=%s]", Integer.valueOf(System.identityHashCode(paramIVideoView)), Integer.valueOf(paramInt), paramObject);
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
              SLog.d(this.a.a.jdField_a_of_type_JavaLangString, "PLAYER_INFO_HW_DECODE_FAILED. extra=%s", new Object[] { paramObject });
              break label288;
            }
            VideoViewVideoHolder.d(this.a.a, ((Integer)paramObject).intValue());
            break label288;
          }
        }
        else
        {
          VideoViewVideoHolder.f(this.a.a, (int)(VideoViewVideoHolder.d(this.a.a) + (SystemClock.uptimeMillis() - VideoViewVideoHolder.a(this.a.a))));
          SLog.d(this.a.a.jdField_a_of_type_JavaLangString, "end buffering, hide loading view");
          this.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
          break label288;
        }
      }
      else
      {
        SLog.d(this.a.a.jdField_a_of_type_JavaLangString, "start buffering, show loading view");
        VideoViewVideoHolder.e(this.a.a, VideoViewVideoHolder.c(this.a.a) + 1);
        VideoViewVideoHolder.a(this.a.a, SystemClock.uptimeMillis());
        VideoViewVideoHolder.a(this.a.a, 8);
        this.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
        break label288;
      }
    }
    VideoViewVideoHolder.a(this.a.a, 0L, "rendering-Start");
    label288:
    VideoViewVideoHolder.a(this.a.a).a(this.a.a, paramIVideoView, paramInt, paramObject);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.1
 * JD-Core Version:    0.7.0.1
 */