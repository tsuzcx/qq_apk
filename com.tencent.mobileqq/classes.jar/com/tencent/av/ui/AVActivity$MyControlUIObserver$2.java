package com.tencent.av.ui;

import com.tencent.av.gaudio.VideoViewInfo;
import java.util.Comparator;

class AVActivity$MyControlUIObserver$2
  implements Comparator<VideoViewInfo>
{
  AVActivity$MyControlUIObserver$2(AVActivity.MyControlUIObserver paramMyControlUIObserver) {}
  
  public int a(VideoViewInfo paramVideoViewInfo1, VideoViewInfo paramVideoViewInfo2)
  {
    if (paramVideoViewInfo1.a) {
      return -1;
    }
    if (paramVideoViewInfo2.a) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver.2
 * JD-Core Version:    0.7.0.1
 */