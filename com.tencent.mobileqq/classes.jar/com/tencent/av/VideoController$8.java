package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import lga;

class VideoController$8
  implements Runnable
{
  VideoController$8(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    lga locallga = this.this$0.a();
    if ((locallga.e) && (locallga.m) && (locallga.jdField_d_of_type_Int == 2))
    {
      locallga.a(this.a, false);
      this.this$0.a.pauseVideo(locallga.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.8
 * JD-Core Version:    0.7.0.1
 */