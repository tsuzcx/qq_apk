package com.tencent.avgame.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ProcessExitReceiver;
import com.tencent.qphone.base.util.QLog;

public class ExitReceiver
  extends ProcessExitReceiver
{
  public ExitReceiver(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected void a(AVGameAppInterface paramAVGameAppInterface)
  {
    boolean bool = ProcessMonitor.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("ExitReceiver", 2, "checkAndExitAVGame, canExit[" + bool + "]");
    }
    if (bool)
    {
      if (paramAVGameAppInterface != null) {
        paramAVGameAppInterface.b(1005);
      }
      Process.killProcess(Process.myPid());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent == null)
    {
      paramContext = null;
      if ("com.tencent.process.exit".equals(paramContext))
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          break label89;
        }
        paramContext = null;
        label28:
        if (paramIntent != null) {
          break label99;
        }
      }
    }
    label89:
    label99:
    for (paramIntent = localObject;; paramIntent = paramIntent.getString("verify"))
    {
      if ((!a(paramIntent, paramContext)) || (!a(paramContext))) {
        break label109;
      }
      QLog.i("ExitReceiver", 1, "ACTION_PROCESS_EXIT");
      if ((this.a instanceof AVGameAppInterface)) {
        a((AVGameAppInterface)this.a);
      }
      return;
      paramContext = paramIntent.getAction();
      break;
      paramContext = paramIntent.getStringArrayList("procNameList");
      break label28;
    }
    label109:
    QLog.i("ExitReceiver", 1, "ACTION_PROCESS_EXIT, not legal or in process list.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ipc.ExitReceiver
 * JD-Core Version:    0.7.0.1
 */