package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$33
  extends BroadcastReceiver
{
  LimitChatPie$33(LimitChatPie paramLimitChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("uinType", 0);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("receiver action_recv_video_request. uinType = ");
        paramContext.append(i);
        QLog.i("LimitChatPie", 2, paramContext.toString());
      }
      if (i == 1044) {
        LimitChatPie.b(this.a, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.33
 * JD-Core Version:    0.7.0.1
 */