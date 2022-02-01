package com.tencent.av.ui;

import com.tencent.av.gaudio.VideoViewInfo;
import java.util.Comparator;

class AVActivity$15
  implements Comparator<VideoViewInfo>
{
  AVActivity$15(AVActivity paramAVActivity) {}
  
  public int a(VideoViewInfo paramVideoViewInfo1, VideoViewInfo paramVideoViewInfo2)
  {
    if (paramVideoViewInfo1.c) {
      return 1;
    }
    if (paramVideoViewInfo2.c) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.15
 * JD-Core Version:    0.7.0.1
 */