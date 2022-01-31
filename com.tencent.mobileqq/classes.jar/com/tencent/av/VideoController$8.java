package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import lid;

class VideoController$8
  implements Runnable
{
  VideoController$8(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    lid locallid = this.this$0.a();
    if ((locallid.e) && (locallid.n) && (locallid.jdField_d_of_type_Int == 2))
    {
      locallid.a(this.a, false);
      this.this$0.a.pauseVideo(locallid.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.8
 * JD-Core Version:    0.7.0.1
 */