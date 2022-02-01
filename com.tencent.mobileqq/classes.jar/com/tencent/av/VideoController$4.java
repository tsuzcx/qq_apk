package com.tencent.av;

import android.content.Context;
import android.view.OrientationEventListener;

class VideoController$4
  extends OrientationEventListener
{
  private long jdField_a_of_type_Long = 0L;
  
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
    if (l - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    if ((paramInt <= 315) && (paramInt > 45))
    {
      if ((paramInt > 45) && (paramInt <= 135))
      {
        VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 2);
        return;
      }
      if ((paramInt > 135) && (paramInt <= 225))
      {
        VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 3);
        return;
      }
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 4);
      return;
    }
    VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.4
 * JD-Core Version:    0.7.0.1
 */