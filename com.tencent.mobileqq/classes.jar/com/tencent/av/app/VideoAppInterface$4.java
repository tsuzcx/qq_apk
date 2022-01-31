package com.tencent.av.app;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.qphone.base.util.QLog;
import lfa;

class VideoAppInterface$4
  implements Runnable
{
  VideoAppInterface$4(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    if (VideoAppInterface.a(this.this$0).a())
    {
      String str = VideoAppInterface.a(this.this$0).a();
      AVNotifyCenter.a(this.this$0.getCurrentAccountUin(), str);
      VideoAppInterface.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.i(VideoAppInterface.c(), 2, "saveBeautyConfig, config[" + str + "]");
      }
    }
    VideoAppInterface.b(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.4
 * JD-Core Version:    0.7.0.1
 */