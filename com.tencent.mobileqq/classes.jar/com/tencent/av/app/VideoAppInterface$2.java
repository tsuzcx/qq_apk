package com.tencent.av.app;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class VideoAppInterface$2
  implements Runnable
{
  VideoAppInterface$2(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (!Build.MANUFACTURER.toLowerCase().equals("xiaomi")) {
      ImmersiveUtils.enableStatusBarDarkModeForMIUI = false;
    }
    boolean bool = ImmersiveUtils.supportStatusBarDarkMode();
    long l2 = System.currentTimeMillis();
    VideoAppInterface.a(this.this$0, null);
    String str = VideoAppInterface.C();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supportStatusBarDarkMode, support[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], start[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], cost[");
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.2
 * JD-Core Version:    0.7.0.1
 */