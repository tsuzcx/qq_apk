package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

class VideoController$27
  implements Runnable
{
  VideoController$27(VideoController paramVideoController, int paramInt, long paramLong) {}
  
  public void run()
  {
    this.this$0.j = null;
    this.this$0.a().a("acceptGAudioChat", 0);
    boolean bool = NetworkUtil.g(this.this$0.a.getApplication().getApplicationContext());
    VideoController localVideoController = this.this$0;
    int j = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (bool) {}
    for (int i = 69;; i = 68)
    {
      localVideoController.onGAudioSDKError(j, l, i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.27
 * JD-Core Version:    0.7.0.1
 */