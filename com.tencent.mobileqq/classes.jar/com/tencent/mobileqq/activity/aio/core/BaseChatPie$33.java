package com.tencent.mobileqq.activity.aio.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$33
  extends BroadcastReceiver
{
  BaseChatPie$33(BaseChatPie paramBaseChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.tag, 2, "receive action_recv_video_request");
      }
      this.this$0.stopAudioRecord(2);
    }
    do
    {
      return;
      if ("android.intent.action.PHONE_STATE".equals(paramContext))
      {
        paramContext = (TelephonyManager)this.this$0.mContext.getSystemService("phone");
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.tag, 2, "receive action_phone_state_changed|call_state_ringing");
          }
          this.this$0.stopAudioRecord(2);
        }
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.tag, 2, "receive action_phone_state_changed|call_state_ringing");
          }
          paramIntent = MediaPlayerManager.a(this.this$0.app);
          if (paramIntent.a()) {
            paramIntent.a(false);
          }
        }
        this.this$0.onPhoneStateChange(paramContext.getCallState());
        return;
      }
      if ((BaseChatPie.access$1100() == 1) && ("vivo_smart_shot_enter".equals(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("vivo", 2, "receive action_vivo_smart_shot_enter");
        }
        BaseChatPie.access$1202(this.this$0, Boolean.valueOf(false));
        return;
      }
    } while (!"com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE".equals(paramContext));
    boolean bool = paramIntent.getBooleanExtra("mode", false);
    QLog.d("WindowsCastReceiver", 1, "onReceive mode = " + bool);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      bfsu.a = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.33
 * JD-Core Version:    0.7.0.1
 */