package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class VideoAppInterface$4
  extends BroadcastReceiver
{
  VideoAppInterface$4(VideoAppInterface paramVideoAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d(VideoAppInterface.c(), 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface.4
 * JD-Core Version:    0.7.0.1
 */