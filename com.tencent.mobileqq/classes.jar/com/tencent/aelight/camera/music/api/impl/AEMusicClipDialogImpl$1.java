package com.tencent.aelight.camera.music.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.log.AEQLog;

class AEMusicClipDialogImpl$1
  extends BroadcastReceiver
{
  AEMusicClipDialogImpl$1(AEMusicClipDialogImpl paramAEMusicClipDialogImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AEQLog.b("AEMusicClipDialogImpl", "[showMusicClipDialogOnWebView.BroadcastReceiver.onReceive]");
    paramContext = paramIntent.getAction();
    if (!"action_dispatch_music_event".equals(paramContext))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("[showMusicClipDialogOnWebView.BroadcastReceiver.onReceive], invalid action = ");
      paramIntent.append(paramContext);
      AEQLog.b("AEMusicClipDialogImpl", paramIntent.toString());
      return;
    }
    paramContext = paramIntent.getStringExtra("event");
    if (!"KTribeDownloadMusicSuccessWhenMediaPlay".equals(paramContext))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("[showMusicClipDialogOnWebView.BroadcastReceiver.onReceive], not cache event, event = ");
      paramIntent.append(paramContext);
      AEQLog.b("AEMusicClipDialogImpl", paramIntent.toString());
      return;
    }
    AEMusicClipDialogImpl.access$000(this.a);
    AEMusicClipDialogImpl.access$100(this.a);
    AEMusicClipDialogImpl.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.music.api.impl.AEMusicClipDialogImpl.1
 * JD-Core Version:    0.7.0.1
 */