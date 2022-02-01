package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.qphone.base.util.QLog;

class PeakAppInterface$1
  extends BroadcastReceiver
{
  PeakAppInterface$1(PeakAppInterface paramPeakAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("tencent.peak.q2v.AudioTransPush".equals(paramIntent.getAction())))
    {
      int i = paramIntent.getIntExtra("rsptype", 0);
      paramContext = paramIntent.getByteArrayExtra("rspbody");
      paramIntent = new StringBuilder();
      paramIntent.append("ACTION_AUDIO_TRANS_PUSH rsptype=");
      paramIntent.append(i);
      paramIntent.append("|");
      paramIntent.append(paramContext.length);
      QLog.d("PeakAppInterface", 2, paramIntent.toString());
      ((PeakAudioTransHandler)this.a.getBusinessHandler(PeakAppInterface.b)).a(i, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface.1
 * JD-Core Version:    0.7.0.1
 */