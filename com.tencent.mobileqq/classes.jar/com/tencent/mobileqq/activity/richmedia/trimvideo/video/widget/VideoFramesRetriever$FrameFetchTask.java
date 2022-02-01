package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import java.util.concurrent.ConcurrentHashMap;

class VideoFramesRetriever$FrameFetchTask
  implements Comparable<FrameFetchTask>
{
  public int a;
  public long a;
  public int b;
  
  public VideoFramesRetriever$FrameFetchTask(VideoFramesRetriever paramVideoFramesRetriever, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = Math.min(paramInt2, VideoFramesRetriever.a(paramVideoFramesRetriever));
    VideoFramesRetriever.a(paramVideoFramesRetriever).put(Integer.valueOf(paramInt1), this);
  }
  
  public int a(FrameFetchTask paramFrameFetchTask)
  {
    return -(int)(this.jdField_a_of_type_Long - paramFrameFetchTask.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever.FrameFetchTask
 * JD-Core Version:    0.7.0.1
 */