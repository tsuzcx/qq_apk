package com.tencent.av;

import android.content.Context;
import android.view.OrientationEventListener;

class VideoController$4
  extends OrientationEventListener
{
  private long b = 0L;
  
  VideoController$4(VideoController paramVideoController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.b < 50L) {
      return;
    }
    this.b = l;
    if ((paramInt <= 315) && (paramInt > 45))
    {
      if ((paramInt > 45) && (paramInt <= 135))
      {
        VideoController.a(this.a, 2);
        return;
      }
      if ((paramInt > 135) && (paramInt <= 225))
      {
        VideoController.a(this.a, 3);
        return;
      }
      VideoController.a(this.a, 4);
      return;
    }
    VideoController.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.4
 * JD-Core Version:    0.7.0.1
 */