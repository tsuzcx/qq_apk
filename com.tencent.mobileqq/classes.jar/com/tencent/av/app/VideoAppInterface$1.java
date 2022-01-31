package com.tencent.av.app;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class VideoAppInterface$1
  implements Runnable
{
  VideoAppInterface$1(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (!Build.MANUFACTURER.toLowerCase().equals("xiaomi")) {
      ImmersiveUtils.d = false;
    }
    boolean bool = ImmersiveUtils.a();
    long l2 = System.currentTimeMillis();
    VideoAppInterface.a(this.this$0, null);
    QLog.w(VideoAppInterface.c(), 1, "supportStatusBarDarkMode, support[" + bool + "], start[" + l1 + "], cost[" + (l2 - l1) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.1
 * JD-Core Version:    0.7.0.1
 */