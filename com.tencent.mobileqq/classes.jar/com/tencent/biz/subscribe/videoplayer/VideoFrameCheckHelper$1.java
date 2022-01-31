package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import wey;
import wez;

public class VideoFrameCheckHelper$1
  implements Runnable
{
  public VideoFrameCheckHelper$1(wey paramwey, TextureView paramTextureView, wez paramwez) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    if (System.currentTimeMillis() - wey.a(this.this$0) >= 4000L) {}
    for (boolean bool = true; (wey.a(this.this$0, this.jdField_a_of_type_AndroidViewTextureView)) && (!bool); bool = false)
    {
      wey.a(this.this$0, this.jdField_a_of_type_AndroidViewTextureView, this.jdField_a_of_type_Wez);
      QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
      return;
    }
    this.jdField_a_of_type_Wez.a(bool);
    this.this$0.a().removeCallbacksAndMessages(null);
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */