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
    VideoController localVideoController = this.this$0;
    localVideoController.af = null;
    localVideoController.k().a("acceptGAudioChat", 0);
    boolean bool = NetworkUtil.isNetworkAvailable(this.this$0.e.getApplication().getApplicationContext());
    localVideoController = this.this$0;
    int j = this.a;
    long l = this.b;
    int i;
    if (bool) {
      i = 69;
    } else {
      i = 68;
    }
    localVideoController.onGAudioSDKError(j, l, i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.27
 * JD-Core Version:    0.7.0.1
 */