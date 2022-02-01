package com.tencent.gdtad.views.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class GdtVideoCommonView$HeadsetDetectReceiver
  extends BroadcastReceiver
{
  private GdtVideoCommonView$HeadsetDetectReceiver(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction())) && (paramIntent.hasExtra("state")))
    {
      int i = paramIntent.getIntExtra("state", 0);
      if (i == 1)
      {
        QLog.i("GdtVideoCommonView", 1, "ACTION_HEADSET_PLUG HEADSET on");
        return;
      }
      if (i == 0)
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_HEADSET_PLUG HEADSET off ");
        paramContext.append(this.a.a);
        QLog.i("GdtVideoCommonView", 1, paramContext.toString());
        if (this.a.a) {
          GdtVideoCommonView.y(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.HeadsetDetectReceiver
 * JD-Core Version:    0.7.0.1
 */