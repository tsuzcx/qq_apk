package com.tencent.av;

import com.tencent.av.core.VcControllerImpl;
import kvq;

class VideoController$7
  implements Runnable
{
  VideoController$7(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    kvq localkvq = this.this$0.a();
    if ((localkvq.e) && (localkvq.m) && (localkvq.jdField_d_of_type_Int == 2))
    {
      localkvq.a(this.a, false);
      this.this$0.a.pauseVideo(localkvq.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.7
 * JD-Core Version:    0.7.0.1
 */