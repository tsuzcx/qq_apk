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
      paramContext.jdField_a_of_type_Boolean = bool;
      if ((this.a.jdField_a_of_type_Boolean) && (VoiceChangeChooseDialog.a(this.a) == 2))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695977);
        VoiceChangeChooseDialog.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.2
 * JD-Core Version:    0.7.0.1
 */