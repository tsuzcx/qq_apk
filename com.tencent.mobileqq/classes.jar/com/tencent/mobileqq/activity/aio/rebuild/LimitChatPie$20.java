package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$20
  extends BroadcastReceiver
{
  LimitChatPie$20(LimitChatPie paramLimitChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("uinType", 0);
      if (QLog.isColorLevel()) {
        QLog.i("LimitChatPie", 2, "receiver action_recv_video_request. uinType = " + i);
      }
      if ((i == 1044) && (LimitChatPie.a(this.a) != null) && (LimitChatPie.a(this.a).isShowing()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("LimitChatPie", 2, "receiver dialog showing. dismiss");
        }
        LimitChatPie.a(this.a).dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.20
 * JD-Core Version:    0.7.0.1
 */