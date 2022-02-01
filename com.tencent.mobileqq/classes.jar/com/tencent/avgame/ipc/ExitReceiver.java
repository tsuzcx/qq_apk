package com.tencent.avgame.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ExitReceiver
  extends ProcessExitReceiver
{
  public ExitReceiver(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected void a(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    boolean bool = ProcessMonitor.a().a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndExitAVGame, canExit[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("ExitReceiver", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      if (paramBaseAVGameAppInterface != null) {
        ((AccountReceiver.AccountListener)paramBaseAVGameAppInterface).b(1005);
      }
      Process.killProcess(Process.myPid());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent == null) {
      paramContext = null;
    } else {
      paramContext = paramIntent.getAction();
    }
    if ("com.tencent.process.exit".equals(paramContext))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent == null) {
        paramContext = null;
      } else {
        paramContext = paramIntent.getStringArrayList("procNameList");
      }
      if (paramIntent == null) {
        paramIntent = localObject;
      } else {
        paramIntent = paramIntent.getString("verify");
      }
      if ((a(paramIntent, paramContext)) && (a(paramContext)))
      {
        QLog.i("ExitReceiver", 1, "ACTION_PROCESS_EXIT");
        if ((this.a instanceof BaseAVGameAppInterface)) {
          a((BaseAVGameAppInterface)this.a);
        }
      }
      else
      {
        QLog.i("ExitReceiver", 1, "ACTION_PROCESS_EXIT, not legal or in process list.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.ExitReceiver
 * JD-Core Version:    0.7.0.1
 */