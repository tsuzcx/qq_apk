package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import java.util.concurrent.ConcurrentHashMap;

class VideoFramesFetcher$FrameFetchTask
  implements Comparable<FrameFetchTask>
{
  public long a;
  public int b;
  public int c;
  
  public VideoFramesFetcher$FrameFetchTask(VideoFramesFetcher paramVideoFramesFetcher, long paramLong, int paramInt1, int paramInt2)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = Math.min(paramInt2, VideoFramesFetcher.a(paramVideoFramesFetcher));
    VideoFramesFetcher.b(paramVideoFramesFetcher).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(FrameFetchTask paramFrameFetchTask)
  {
    return -(int)(this.a - paramFrameFetchTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher.FrameFetchTask
 * JD-Core Version:    0.7.0.1
 */