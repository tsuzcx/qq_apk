package com.tencent.gdtad.views.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class GdtVideoCommonView$SilentModeReceiver
  extends BroadcastReceiver
{
  private GdtVideoCommonView$SilentModeReceiver(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    if (GdtVideoCommonView.d(this.a))
    {
      GdtVideoCommonView.c(this.a, false);
      QLog.i("GdtVideoCommonView", 1, "SilentModeReceiver first auto called! so skip!");
    }
    while ((GdtVideoCommonView.a(this.a) == null) || (!"android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction()))) {
      return;
    }
    int i = GdtVideoCommonView.a(this.a).getRingerMode();
    int j = GdtVideoCommonView.a(this.a).getStreamVolume(3);
    QLog.i("GdtVideoCommonView", 1, "system context mode: " + i);
    switch (i)
    {
    default: 
      this.a.b = true;
      GdtVideoCommonView.d(this.a, false);
      GdtVideoCommonView.a(this.a).setOutputMute(true);
      bool1 = bool2;
      GdtVideoCommonView.a(this.a, j, this.a.a, false, bool1);
      return;
    }
    this.a.b = false;
    if (j > 0) {
      GdtVideoCommonView.d(this.a, true);
    }
    paramContext = GdtVideoCommonView.a(this.a);
    if (!GdtVideoCommonView.e(this.a)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramContext.setOutputMute(bool1);
      bool1 = bool2;
      if (!GdtVideoCommonView.e(this.a)) {
        break;
      }
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.SilentModeReceiver
 * JD-Core Version:    0.7.0.1
 */