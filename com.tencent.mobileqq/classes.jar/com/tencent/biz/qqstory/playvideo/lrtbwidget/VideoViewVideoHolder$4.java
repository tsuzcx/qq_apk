package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoViewVideoHolder$4
  extends VideoViewVideoHolder.ClearStreamObserver<StoryVideoItem>
{
  VideoViewVideoHolder$4(VideoViewVideoHolder paramVideoViewVideoHolder)
  {
    super(paramVideoViewVideoHolder, null);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    super.onNext(paramStoryVideoItem);
    VideoViewVideoHolder.a(this.a);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    String str = this.a.a;
    paramError = (ErrorMessage)paramError;
    SLog.d(str, "VideoFileSegment error=%s", new Object[] { paramError.getErrorMessage() });
    VideoViewVideoHolder.a(this.a, paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.4
 * JD-Core Version:    0.7.0.1
 */