package com.tencent.av.utils.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class AudioHelperApiImpl$1
  extends BroadcastReceiver
{
  AudioHelperApiImpl$1(AudioHelperApiImpl paramAudioHelperApiImpl, BaseApplication paramBaseApplication) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if ("tencent.video.q2v.debug".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("_debug_Event_index", -1);
        int j = paramIntent.getIntExtra("_debug_Event_value", -1);
        if ((i >= 0) && (i < 39))
        {
          AudioHelperApiImpl._debugValue[i] = j;
          paramContext = new StringBuilder();
          paramContext.append("ReceiverDebugValue, [");
          paramContext.append(i);
          paramContext.append("]=[");
          paramContext.append(j);
          paramContext.append("]");
          QLog.w("AudioHelper", 1, paramContext.toString());
        }
        if (i == 2) {
          this.b.setBeaconDebug(this.a.getApplicationContext());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.AudioHelperApiImpl.1
 * JD-Core Version:    0.7.0.1
 */