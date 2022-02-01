package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import lez;

class VideoController$7
  implements Runnable
{
  VideoController$7(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    lez locallez = this.this$0.a();
    if ((locallez.e) && (locallez.n) && (locallez.jdField_d_of_type_Int == 2))
    {
      locallez.a(this.a, false);
      this.this$0.a.pauseVideo(locallez.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.7
 * JD-Core Version:    0.7.0.1
 */