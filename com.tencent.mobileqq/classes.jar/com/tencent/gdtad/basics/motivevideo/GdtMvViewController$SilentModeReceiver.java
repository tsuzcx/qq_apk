package com.tencent.gdtad.basics.motivevideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.mobileqq.apollo.game.process.video.api.ICmGameVideoPlayer;
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
      return;
    }
    if ((GdtMvViewController.a(this.a) != null) && ("android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction())))
    {
      int i = GdtMvViewController.a(this.a).getRingerMode();
      int j = GdtMvViewController.a(this.a).getStreamVolume(3);
      paramContext = new StringBuilder();
      paramContext.append("system context mode: ");
      paramContext.append(i);
      paramContext.append(", streamVolume = ");
      paramContext.append(j);
      QLog.i("GdtMvViewController", 1, paramContext.toString());
      if (i != 2)
      {
        GdtMvViewController.c(this.a, true);
        paramContext = this.a;
        paramContext.a = true;
        GdtMvViewController.a(paramContext).setMute(true);
      }
      else
      {
        GdtMvViewController.c(this.a, false);
        if (j > 0) {
          this.a.a = false;
        }
        GdtMvViewController.a(this.a).setMute(this.a.a);
      }
      paramContext = this.a;
      GdtMvViewController.a(paramContext, j, GdtMvViewController.b(paramContext), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.SilentModeReceiver
 * JD-Core Version:    0.7.0.1
 */