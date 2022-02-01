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
    AEQLog.b(AEEditorVideoEditFragment.h(), "[musicBroadcastReceiver.onReceive]");
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) {
      return;
    }
    AEEditorVideoEditFragment.a(this.a, AEEditorMusicHelper.a(paramIntent));
    if (AEEditorVideoEditFragment.a(this.a) == null) {
      return;
    }
    if (!this.a.a)
    {
      paramContext = this.a;
      AEEditorVideoEditFragment.a(paramContext, AEEditorVideoEditFragment.a(paramContext));
      return;
    }
    AEQLog.b(AEEditorVideoEditFragment.h(), "[musicBroadcastReceiver.onReceive], fragment not resumed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.1
 * JD-Core Version:    0.7.0.1
 */