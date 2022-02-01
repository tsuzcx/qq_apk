package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class AVLoadingDialogActivity$1
  extends BroadcastReceiver
{
  AVLoadingDialogActivity$1(AVLoadingDialogActivity paramAVLoadingDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH")) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity.1
 * JD-Core Version:    0.7.0.1
 */