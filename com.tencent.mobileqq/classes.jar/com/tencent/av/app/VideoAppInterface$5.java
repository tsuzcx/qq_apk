package com.tencent.av.app;

import com.tencent.av.opengl.effects.BeautyConfig;
import com.tencent.av.ui.BeautyConfigUtil;
import com.tencent.qphone.base.util.QLog;

class VideoAppInterface$5
  implements Runnable
{
  VideoAppInterface$5(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    if (VideoAppInterface.a(this.this$0).a())
    {
      String str = VideoAppInterface.a(this.this$0).a();
      BeautyConfigUtil.a(this.this$0.getCurrentAccountUin(), str);
      VideoAppInterface.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.i(VideoAppInterface.c(), 2, "saveBeautyConfig, config[" + str + "]");
      }
    }
    VideoAppInterface.b(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.5
 * JD-Core Version:    0.7.0.1
 */