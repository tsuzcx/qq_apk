package com.tencent.av;

import com.tencent.qphone.base.util.QLog;
import lid;

class VideoController$2
  implements Runnable
{
  VideoController$2(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "connectingRunnable");
    }
    if (!this.this$0.a().k())
    {
      this.this$0.a(this.this$0.a().d, 216);
      this.this$0.b(216);
      this.this$0.b(this.this$0.a().d, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.2
 * JD-Core Version:    0.7.0.1
 */