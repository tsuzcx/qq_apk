package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

class VideoVolumeController$VolumeReceiver
  extends BroadcastReceiver
{
  private VideoVolumeController$VolumeReceiver(VideoVolumeController paramVideoVolumeController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop) || (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause)) {}
    do
    {
      for (;;)
      {
        return;
        if (VideoVolumeController.a(this.a) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoVolumeController", 2, "VolumeReceiver onReceive null");
          }
        }
        else if (VideoVolumeController.b(this.a)) {
          if (VideoVolumeController.c(this.a))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoVolumeController", 2, "dynamicPauseReceive true");
            }
          }
          else
          {
            int i;
            try
            {
              if (!paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                break;
              }
              i = VideoVolumeController.a(this.a).getStreamVolume(3);
              if (QLog.isColorLevel()) {
                QLog.d("VideoVolumeController", 2, "volume change:" + i);
              }
              if (VideoVolumeController.d(this.a))
              {
                QLog.d("VideoVolumeController", 2, "volume change shield ");
                return;
              }
            }
            catch (Exception paramContext)
            {
              QLog.d("VideoVolumeController", 1, "VolumeReceiver", paramContext);
              return;
            }
            paramContext = VideoVolumeController.a(this.a).iterator();
            while (paramContext.hasNext()) {
              ((VideoVolumeController.EventListener)paramContext.next()).onSystemVolumeChanged(i);
            }
          }
        }
      }
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = VideoVolumeController.a(this.a).isWiredHeadsetOn();
    if (VideoVolumeController.e(this.a))
    {
      VideoVolumeController.a(this.a, false);
      return;
    }
    VideoVolumeController.b(this.a, true);
    paramContext = VideoVolumeController.a(this.a).iterator();
    while (paramContext.hasNext()) {
      ((VideoVolumeController.EventListener)paramContext.next()).onHeadsetStateChanged(bool);
    }
    VideoVolumeController.a(this.a).postDelayed(new VideoVolumeController.VolumeReceiver.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.VolumeReceiver
 * JD-Core Version:    0.7.0.1
 */