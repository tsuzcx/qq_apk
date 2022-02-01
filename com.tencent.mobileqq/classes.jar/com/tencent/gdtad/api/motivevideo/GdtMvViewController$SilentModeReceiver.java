package com.tencent.gdtad.api.motivevideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.mobileqq.apollo.process.video.ICmGameVideoPlayer;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$SilentModeReceiver
  extends BroadcastReceiver
{
  private GdtMvViewController$SilentModeReceiver(GdtMvViewController paramGdtMvViewController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (GdtMvViewController.a(this.a))
    {
      GdtMvViewController.b(this.a, false);
      QLog.i("GdtMvViewController", 1, "SilentModeReceiver first auto called! so skip!");
    }
    while ((GdtMvViewController.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = GdtMvViewController.a(this.a).getRingerMode();
    int j = GdtMvViewController.a(this.a).getStreamVolume(3);
    QLog.i("GdtMvViewController", 1, "system context mode: " + i + ", streamVolume = " + j);
    switch (i)
    {
    default: 
      GdtMvViewController.c(this.a, true);
      this.a.a = true;
      GdtMvViewController.a(this.a).a(true);
    }
    for (;;)
    {
      GdtMvViewController.a(this.a, j, GdtMvViewController.b(this.a), false);
      return;
      GdtMvViewController.c(this.a, false);
      if (j > 0) {
        this.a.a = false;
      }
      GdtMvViewController.a(this.a).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.SilentModeReceiver
 * JD-Core Version:    0.7.0.1
 */