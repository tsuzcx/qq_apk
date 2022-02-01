package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class SensorHelper$ScreenActionReceiver
  extends BroadcastReceiver
{
  SensorHelper$ScreenActionReceiver(SensorHelper paramSensorHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    boolean bool1 = ((String)localObject).equals("android.intent.action.SCREEN_ON");
    boolean bool2 = false;
    int i;
    if (bool1)
    {
      i = 2;
      boolean bool4 = VideoController.a(paramContext);
      if (Build.VERSION.SDK_INT >= 20)
      {
        boolean bool3 = ((PowerManager)((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("power")).isInteractive();
        paramContext = ((WindowManager)((Context)this.a.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("window")).getDefaultDisplay();
        bool1 = bool3;
        if (paramContext != null)
        {
          i = paramContext.getState();
          bool1 = bool3;
        }
      }
      else
      {
        bool1 = true;
      }
      paramContext = this.a.jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder();
      paramIntent.append("ACTION_SCREEN_ON, mVideoController[");
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
        bool2 = true;
      }
      paramIntent.append(bool2);
      paramIntent.append("], isInteractive[");
      paramIntent.append(bool1);
      paramIntent.append("], nState[");
      paramIntent.append(i);
      paramIntent.append("], inKeyguardRestrictedInputMode[");
      paramIntent.append(bool4);
      paramIntent.append("], mIsStarted[");
      paramIntent.append(this.a.d);
      paramIntent.append("]");
      QLog.d(paramContext, 1, paramIntent.toString());
      if (this.a.d)
      {
        paramContext = this.a;
        paramContext.jdField_a_of_type_Int = 1;
        SensorHelper.a(paramContext, SensorHelper.a(paramContext));
      }
    }
    else if (((String)localObject).equals("android.intent.action.SCREEN_OFF"))
    {
      i = paramIntent.getIntExtra("why", 0);
      paramContext = this.a.jdField_a_of_type_JavaLangString;
      paramIntent = new StringBuilder();
      paramIntent.append("ACTION_SCREEN_OFF, why[");
      paramIntent.append(i);
      paramIntent.append("]");
      QLog.d(paramContext, 1, paramIntent.toString());
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "4");
        com.tencent.av.VideoConstants.ProcessInfo.jdField_a_of_type_JavaLangString = "4";
      }
    }
    else
    {
      if (((String)localObject).equals("android.intent.action.USER_PRESENT"))
      {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 1, "ACTION_USER_PRESENT");
        return;
      }
      if (((String)localObject).equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        paramIntent = this.a.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ACTION_CLOSE_SYSTEM_DIALOGS, reason[");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("]");
        QLog.d(paramIntent, 1, ((StringBuilder)localObject).toString());
        if (("homekey".equalsIgnoreCase(paramContext)) && (this.a.d))
        {
          paramContext = this.a;
          paramContext.jdField_a_of_type_Int = 1;
          SensorHelper.a(paramContext, SensorHelper.a(paramContext));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorHelper.ScreenActionReceiver
 * JD-Core Version:    0.7.0.1
 */