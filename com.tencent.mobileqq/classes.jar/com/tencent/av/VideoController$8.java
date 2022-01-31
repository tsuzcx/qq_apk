package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import lgf;

class VideoController$8
  implements Runnable
{
  VideoController$8(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    lgf locallgf = this.this$0.a();
    if ((locallgf.e) && (locallgf.m) && (locallgf.jdField_d_of_type_Int == 2))
    {
      locallgf.a(this.a, false);
      this.this$0.a.pauseVideo(locallgf.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.8
 * JD-Core Version:    0.7.0.1
 */