package com.tencent.biz.qqstory.playvideo.lrtbwidget;

class VideoViewVideoHolder$2
  extends VideoViewVideoHolder.ClearStreamObserver<String>
{
  VideoViewVideoHolder$2(VideoViewVideoHolder paramVideoViewVideoHolder)
  {
    super(paramVideoViewVideoHolder, null);
  }
  
  public void a(String paramString)
  {
    super.onNext(paramString);
    VideoViewVideoHolder.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.2
 * JD-Core Version:    0.7.0.1
 */