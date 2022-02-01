package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;

class VoiceChangeChooseDialog$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")) && (paramIntent.hasExtra("state")))
    {
      int i = paramIntent.getIntExtra("state", 0);
      paramContext = this.a;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramContext.g = bool;
      if ((this.a.g) && (VoiceChangeChooseDialog.a(this.a) == 2))
      {
        this.a.k.removeCallbacks(this.a.l);
        this.a.f.setText(2131893739);
        VoiceChangeChooseDialog.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.2
 * JD-Core Version:    0.7.0.1
 */