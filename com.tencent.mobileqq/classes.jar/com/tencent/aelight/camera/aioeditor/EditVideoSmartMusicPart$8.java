package com.tencent.aelight.camera.aioeditor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class EditVideoSmartMusicPart$8
  extends BroadcastReceiver
{
  EditVideoSmartMusicPart$8(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      EditVideoSmartMusicPart.a(this.a, paramIntent);
      EditVideoSmartMusicPart.p(this.a);
      EditVideoSmartMusicPart.l(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.8
 * JD-Core Version:    0.7.0.1
 */