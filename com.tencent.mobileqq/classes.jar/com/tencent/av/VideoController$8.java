package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.VcControllerImpl;

class VideoController$8
  implements Runnable
{
  VideoController$8(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.a();
    if ((localSessionInfo.e) && (localSessionInfo.n) && (localSessionInfo.jdField_d_of_type_Int == 2))
    {
      localSessionInfo.a(this.a, false);
      this.this$0.a.pauseVideo(localSessionInfo.jdField_d_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.8
 * JD-Core Version:    0.7.0.1
 */