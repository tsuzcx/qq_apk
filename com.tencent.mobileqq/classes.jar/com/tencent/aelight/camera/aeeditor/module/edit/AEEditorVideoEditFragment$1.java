package com.tencent.aelight.camera.aeeditor.module.edit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.log.AEQLog;

class AEEditorVideoEditFragment$1
  extends BroadcastReceiver
{
  AEEditorVideoEditFragment$1(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AEQLog.b(AEEditorVideoEditFragment.aj(), "[musicBroadcastReceiver.onReceive]");
    if (!"action_dispatch_music_event".equals(paramIntent.getAction())) {
      return;
    }
    paramContext = paramIntent.getStringExtra("event");
    AEEditorVideoEditFragment.a(this.a, AEEditorMusicHelper.a(paramIntent));
    AEEditorVideoEditFragment.a(this.a, paramIntent);
    if ("kTribeSelectMusic".equals(paramContext))
    {
      AEEditorVideoEditFragment.a(this.a);
      return;
    }
    if ("kTribeClipsMusic".equals(paramContext))
    {
      AEEditorVideoEditFragment.b(this.a);
      return;
    }
    if ("kTribeDownloadMusic".equals(paramContext))
    {
      AEEditorVideoEditFragment.c(this.a);
      return;
    }
    paramIntent = AEEditorVideoEditFragment.aj();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[musicBroadcastReceiver.onReceive],invalid event = ");
    localStringBuilder.append(paramContext);
    AEQLog.b(paramIntent, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.1
 * JD-Core Version:    0.7.0.1
 */