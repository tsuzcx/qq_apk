package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

final class VideoFeedsCPUMonitor$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoFeedsCPUMonitor.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((VideoFeedsCPUMonitor.a().get() == 0) && (VideoFeedsCPUMonitor.b().get() < VideoFeedsCPUMonitor.a()))
      {
        VideoFeedsCPUMonitor.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        VideoFeedsCPUMonitor.a().set(1);
        VideoFeedsCPUMonitor.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(VideoFeedsCPUMonitor.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (VideoFeedsCPUMonitor.a().get() != 1);
    if ((VideoFeedsCPUMonitor.a() != null) && (VideoFeedsCPUMonitor.a().isAlive())) {
      VideoFeedsCPUMonitor.a().interrupt();
    }
    VideoFeedsCPUMonitor.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1
 * JD-Core Version:    0.7.0.1
 */