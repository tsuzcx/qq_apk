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
    boolean bool2 = GdtVideoCommonView.C(this.a);
    boolean bool1 = true;
    if (bool2)
    {
      GdtVideoCommonView.c(this.a, false);
      QLog.i("GdtVideoCommonView", 1, "SilentModeReceiver first auto called! so skip!");
      return;
    }
    if ((GdtVideoCommonView.A(this.a) != null) && ("android.media.RINGER_MODE_CHANGED".equalsIgnoreCase(paramIntent.getAction())))
    {
      int i = GdtVideoCommonView.A(this.a).getRingerMode();
      int j = GdtVideoCommonView.A(this.a).getStreamVolume(3);
      paramContext = new StringBuilder();
      paramContext.append("system context mode: ");
      paramContext.append(i);
      QLog.i("GdtVideoCommonView", 1, paramContext.toString());
      if (i != 2)
      {
        paramContext = this.a;
        paramContext.c = true;
        GdtVideoCommonView.d(paramContext, false);
        GdtVideoCommonView.o(this.a).setOutputMute(true);
      }
      else
      {
        paramContext = this.a;
        paramContext.c = false;
        if (j > 0) {
          GdtVideoCommonView.d(paramContext, true);
        }
        GdtVideoCommonView.o(this.a).setOutputMute(GdtVideoCommonView.D(this.a) ^ true);
        bool1 = true ^ GdtVideoCommonView.D(this.a);
      }
      paramContext = this.a;
      GdtVideoCommonView.a(paramContext, j, paramContext.a, false, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.SilentModeReceiver
 * JD-Core Version:    0.7.0.1
 */