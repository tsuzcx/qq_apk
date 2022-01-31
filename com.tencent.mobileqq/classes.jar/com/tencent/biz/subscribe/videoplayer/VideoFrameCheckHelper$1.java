package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import wtq;
import wtr;

public class VideoFrameCheckHelper$1
  implements Runnable
{
  public VideoFrameCheckHelper$1(wtq paramwtq, TextureView paramTextureView, wtr paramwtr) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    if (System.currentTimeMillis() - wtq.a(this.this$0) >= 4000L) {}
    for (boolean bool = true; (wtq.a(this.this$0, this.jdField_a_of_type_AndroidViewTextureView)) && (!bool); bool = false)
    {
      wtq.a(this.this$0, this.jdField_a_of_type_AndroidViewTextureView, this.jdField_a_of_type_Wtr);
      QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
      return;
    }
    this.jdField_a_of_type_Wtr.a(bool);
    this.this$0.a().removeCallbacksAndMessages(null);
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */