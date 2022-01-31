package com.tencent.av;

import awrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$5
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    awrn.a(BaseApplication.getContext()).a("", "av_fullscreen_notification_result", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.5
 * JD-Core Version:    0.7.0.1
 */