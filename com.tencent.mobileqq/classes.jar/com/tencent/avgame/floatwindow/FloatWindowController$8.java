package com.tencent.avgame.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class FloatWindowController$8
  extends BroadcastReceiver
{
  FloatWindowController$8(FloatWindowController paramFloatWindowController) {}
  
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
      QLog.d("FloatWindowController", 2, localStringBuilder.toString());
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
    {
      if ((paramIntent != null) && (paramIntent.equals("com.tencent.mobileqq")))
      {
        this.a.a(false);
        paramContext = this.a;
        paramContext.a = false;
        FloatWindowController.a(paramContext, false);
      }
    }
    else if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      if (i == 0)
      {
        paramContext = this.a;
        paramContext.a = true;
        paramContext.a(true);
        FloatWindowController.a(this.a, false);
        return;
      }
      if (FloatWindowController.b(this.a))
      {
        FloatWindowController.a(this.a, true);
        return;
      }
      paramContext = this.a;
      paramContext.a = true;
      FloatWindowController.d(paramContext).a = true;
      FloatWindowController.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.8
 * JD-Core Version:    0.7.0.1
 */