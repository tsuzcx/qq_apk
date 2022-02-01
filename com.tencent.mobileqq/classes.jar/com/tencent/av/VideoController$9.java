package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import ley;

class VideoController$9
  implements Runnable
{
  VideoController$9(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    ley localley = this.this$0.a();
    if ((localley.e) && (localley.n) && (localley.jdField_d_of_type_Int == 2))
    {
      localley.a(this.a, false);
      this.this$0.a.pauseVideo(localley.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.9
 * JD-Core Version:    0.7.0.1
 */