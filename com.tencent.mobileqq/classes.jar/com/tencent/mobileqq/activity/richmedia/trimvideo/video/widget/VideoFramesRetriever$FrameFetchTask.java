package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import java.util.concurrent.ConcurrentHashMap;

class VideoFramesRetriever$FrameFetchTask
  implements Comparable<FrameFetchTask>
{
  public long a;
  public int b;
  public int c;
  
  public VideoFramesRetriever$FrameFetchTask(VideoFramesRetriever paramVideoFramesRetriever, long paramLong, int paramInt1, int paramInt2)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = Math.min(paramInt2, VideoFramesRetriever.a(paramVideoFramesRetriever));
    VideoFramesRetriever.b(paramVideoFramesRetriever).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(FrameFetchTask paramFrameFetchTask)
  {
    return -(int)(this.a - paramFrameFetchTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever.FrameFetchTask
 * JD-Core Version:    0.7.0.1
 */