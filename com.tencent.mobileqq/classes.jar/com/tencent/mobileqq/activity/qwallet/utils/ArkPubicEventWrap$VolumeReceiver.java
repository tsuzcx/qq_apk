package com.tencent.mobileqq.activity.qwallet.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ArkPubicEventWrap$VolumeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkPubicEventWrap", 2, "--VolumeReceiver---" + paramIntent.getAction());
    }
    ArkPubicEventWrap.b(ArkPubicEventWrap.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap.VolumeReceiver
 * JD-Core Version:    0.7.0.1
 */