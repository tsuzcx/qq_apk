package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class SmallScreenService$1
  extends BroadcastReceiver
{
  SmallScreenService$1(SmallScreenService paramSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = AudioHelper.c();
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, action[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenService", 1, localStringBuilder.toString());
    }
    if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      paramContext = paramIntent.getStringExtra("android.intent.extra.PHONE_NUMBER");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive NEW_OUTGOING_CALL phoneNumber = ");
        paramIntent.append(paramContext);
        QLog.d("SmallScreenService", 2, paramIntent.toString());
      }
    }
    else if ((paramContext.equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) && (this.a.s != null))
    {
      this.a.b().removeCallbacks(this.a.s);
      this.a.s.a = l;
      this.a.b().postDelayed(this.a.s, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService.1
 * JD-Core Version:    0.7.0.1
 */