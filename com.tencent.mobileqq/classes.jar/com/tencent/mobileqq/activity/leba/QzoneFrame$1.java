package com.tencent.mobileqq.activity.leba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qzone.api.QzoneFragmentImpl;

class QzoneFrame$1
  extends BroadcastReceiver
{
  QzoneFrame$1(QzoneFrame paramQzoneFrame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QzoneFrame.a(this.a) != null) {
      ((QzoneFragmentImpl)QzoneFrame.a(this.a)).updatePublishBox(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame.1
 * JD-Core Version:    0.7.0.1
 */