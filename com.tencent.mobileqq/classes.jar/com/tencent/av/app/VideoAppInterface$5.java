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
    if (VideoAppInterface.a(this.this$0).c())
    {
      String str1 = VideoAppInterface.a(this.this$0).a();
      BeautyConfigUtil.a(this.this$0.getCurrentAccountUin(), str1);
      VideoAppInterface.a(this.this$0).b();
      if (QLog.isColorLevel())
      {
        String str2 = VideoAppInterface.C();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveBeautyConfig, config[");
        localStringBuilder.append(str1);
        localStringBuilder.append("]");
        QLog.i(str2, 2, localStringBuilder.toString());
      }
    }
    VideoAppInterface.b(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.5
 * JD-Core Version:    0.7.0.1
 */