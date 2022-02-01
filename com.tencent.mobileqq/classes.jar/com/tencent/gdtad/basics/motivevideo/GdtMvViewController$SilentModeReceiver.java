package com.tencent.gdtad.basics.motivevideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$SilentModeReceiver
  extends BroadcastReceiver
{
  private GdtMvViewController$SilentModeReceiver(GdtMvViewController paramGdtMvViewController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (GdtMvViewController.i(this.a))
    {
      GdtMvViewController.c(this.a, false);
      QLog.i("GdtMvViewController", 1, "SilentModeReceiver first auto called! so skip!");
      return;
    }
    if ((GdtMvViewController.j(this.a) != null) && ("android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction())))
    {
      int i = GdtMvViewController.j(this.a).getRingerMode();
      int j = GdtMvViewController.j(this.a).getStreamVolume(3);
      paramContext = new StringBuilder();
      paramContext.append("system context mode: ");
      paramContext.append(i);
      paramContext.append(", streamVolume = ");
      paramContext.append(j);
      QLog.i("GdtMvViewController", 1, paramContext.toString());
      if (i != 2)
      {
        GdtMvViewController.d(this.a, true);
        paramContext = this.a;
        paramContext.a = true;
        GdtMvViewController.k(paramContext).setMute(true);
      }
      else
      {
        GdtMvViewController.d(this.a, false);
        if (j > 0) {
          this.a.a = false;
        }
        GdtMvViewController.k(this.a).setMute(this.a.a);
      }
      paramContext = this.a;
      GdtMvViewController.a(paramContext, j, GdtMvViewController.l(paramContext), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.SilentModeReceiver
 * JD-Core Version:    0.7.0.1
 */