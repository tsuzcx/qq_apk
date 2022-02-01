package com.tencent.mobileqq.activity.shortvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ShortVideoPreviewActivity$1
  extends BroadcastReceiver
{
  ShortVideoPreviewActivity$1(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "ACTION_SCREEN_OFF == >>");
      }
      this.a.d();
    }
    while (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "ACTION_START_VIDEO_CHAT == >>");
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */