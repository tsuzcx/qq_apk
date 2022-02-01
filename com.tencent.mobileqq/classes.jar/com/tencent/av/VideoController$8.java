package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import lff;

class VideoController$8
  implements Runnable
{
  VideoController$8(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    lff locallff = this.this$0.a();
    if ((locallff.e) && (locallff.n) && (locallff.jdField_d_of_type_Int == 2))
    {
      locallff.a(this.a, false);
      this.this$0.a.pauseVideo(locallff.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.8
 * JD-Core Version:    0.7.0.1
 */