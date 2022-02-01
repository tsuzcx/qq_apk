package com.tencent.avgame.gamelogic.globalmanage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class GlobalExitRoomDialog$1
  extends BroadcastReceiver
{
  GlobalExitRoomDialog$1(GlobalExitRoomDialog paramGlobalExitRoomDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive action: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("  process_name:");
      localStringBuilder.append(paramIntent);
      QLog.d("GlobalExitRoomManagement", 2, localStringBuilder.toString());
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
    {
      GlobalExitRoomDialog.a(this.a, false);
      return;
    }
    if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext)) {
      GlobalExitRoomDialog.a(this.a, i ^ 0x1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog.1
 * JD-Core Version:    0.7.0.1
 */