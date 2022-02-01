package com.tencent.device.msg.activities;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;

class DeviceTipActivity$BroadcastHandler
  extends BroadcastReceiver
{
  DeviceTipActivity$BroadcastHandler(DeviceTipActivity paramDeviceTipActivity) {}
  
  @TargetApi(12)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey"))) {
        this.a.finish();
      }
    }
    else
    {
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        AudioUtil.a();
        return;
      }
      if (paramContext.equals("android.intent.action.SCREEN_ON"))
      {
        AudioUtil.a(2131230746, -1, null);
        return;
      }
      if (paramContext.equals("SmartDevice_receiveDPMsg"))
      {
        if ((DataPoint)paramIntent.getExtras().getParcelable("dataPoint") != null) {}
      }
      else if (paramContext.equals("On_OccupyMicrophoneNotify_Push"))
      {
        if (QLog.isColorLevel())
        {
          paramContext = DeviceTipActivity.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DeviceTipActivity intent.getExtras() : ");
          localStringBuilder.append(paramIntent.getExtras());
          QLog.d(paramContext, 2, localStringBuilder.toString());
        }
        paramContext = paramIntent.getExtras();
        long l = paramContext.getLong("din", 0L);
        paramContext = paramContext.getString("uin", "");
        if ((this.a.b.equals(String.valueOf(Long.valueOf(l)))) && (!TextUtils.isEmpty(paramContext))) {
          this.a.finish();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity.BroadcastHandler
 * JD-Core Version:    0.7.0.1
 */