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
    boolean bool2 = GdtVideoCommonView.d(this.a);
    boolean bool1 = true;
    if (bool2)
    {
      GdtVideoCommonView.c(this.a, false);
      QLog.i("GdtVideoCommonView", 1, "SilentModeReceiver first auto called! so skip!");
      return;
    }
    if ((GdtVideoCommonView.a(this.a) != null) && ("android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction())))
    {
      int i = GdtVideoCommonView.a(this.a).getRingerMode();
      int j = GdtVideoCommonView.a(this.a).getStreamVolume(3);
      paramContext = new StringBuilder();
      paramContext.append("system context mode: ");
      paramContext.append(i);
      QLog.i("GdtVideoCommonView", 1, paramContext.toString());
      if (i != 2)
      {
        paramContext = this.a;
        paramContext.b = true;
        GdtVideoCommonView.d(paramContext, false);
        GdtVideoCommonView.a(this.a).setOutputMute(true);
      }
      else
      {
        paramContext = this.a;
        paramContext.b = false;
        if (j > 0) {
          GdtVideoCommonView.d(paramContext, true);
        }
        GdtVideoCommonView.a(this.a).setOutputMute(GdtVideoCommonView.e(this.a) ^ true);
        bool1 = true ^ GdtVideoCommonView.e(this.a);
      }
      paramContext = this.a;
      GdtVideoCommonView.a(paramContext, j, paramContext.a, false, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.SilentModeReceiver
 * JD-Core Version:    0.7.0.1
 */