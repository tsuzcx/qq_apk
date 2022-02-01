package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class GAccountMonitor$AccountReceiver
  extends BroadcastReceiver
{
  public static String a = "AccountReceiver";
  VideoAppInterface b;
  
  public GAccountMonitor$AccountReceiver(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      try
      {
        paramContext = this.b.b();
        if (QLog.isColorLevel())
        {
          str = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("recv account broadcast: ");
          localStringBuilder.append(paramIntent.getAction());
          QLog.d(str, 2, localStringBuilder.toString());
        }
        if (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_KICKED"))
        {
          this.b.b(1001);
          if (paramContext != null) {
            paramContext.an();
          }
          Process.killProcess(Process.myPid());
          return;
        }
        if (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))
        {
          this.b.b(1003);
          if (paramContext != null) {
            paramContext.an();
          }
          Process.killProcess(Process.myPid());
          return;
        }
        if (paramIntent.getAction().equals("mqq.intent.action.LOGOUT"))
        {
          this.b.b(1002);
          if (paramContext != null) {
            paramContext.an();
          }
          Process.killProcess(Process.myPid());
          return;
        }
        String str = paramIntent.getAction();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mqq.intent.action.EXIT_");
        localStringBuilder.append(this.b.getApp().getPackageName());
        if (str.equals(localStringBuilder.toString()))
        {
          this.b.b(1005);
          if (paramContext != null) {
            paramContext.an();
          }
          Process.killProcess(Process.myPid());
          return;
        }
        if ("mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction()))
        {
          if (paramContext == null) {
            return;
          }
          if (paramContext.j) {
            paramContext.a(paramContext.l, paramContext.k, 74);
          }
          if (QLog.isColorLevel()) {
            QLog.e(a, 2, "ACTION_ACCOUNT_CHANGED, video process exit!");
          }
          this.b.b(1004);
          paramContext.an();
          Process.killProcess(Process.myPid());
          return;
        }
        if ("tencent.video.q2v.membersChange".equals(paramIntent.getAction()))
        {
          long l = paramIntent.getLongExtra("relationId", -1L);
          int i = paramIntent.getIntExtra("relationType", 0);
          if (l == -1L)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(a, 2, "can not get the right value");
            return;
          }
          boolean bool = paramIntent.getBooleanExtra("Exit", false);
          int j = paramIntent.getIntExtra("avtype", 0);
          this.b.a(new Object[] { Integer.valueOf(79), Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(j) });
          if ((bool) && (j != 2))
          {
            paramContext.onGAudioRoomDestroy(i, l);
            return;
          }
        }
      }
      catch (RuntimeException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "RuntimeException", paramContext);
        }
      }
    }
    else {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAccountMonitor.AccountReceiver
 * JD-Core Version:    0.7.0.1
 */