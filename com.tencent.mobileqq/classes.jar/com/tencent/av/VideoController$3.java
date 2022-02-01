package com.tencent.av;

import com.tencent.av.utils.PhoneStatusMonitor;

class VideoController$3
  implements Runnable
{
  VideoController$3(VideoController paramVideoController) {}
  
  public void run()
  {
    VideoController localVideoController = this.this$0;
    localVideoController.O = new VideoController.QQPhoneStatusListener(localVideoController);
    localVideoController = this.this$0;
    localVideoController.N = new PhoneStatusMonitor(localVideoController.f, this.this$0.O);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.3
 * JD-Core Version:    0.7.0.1
 */