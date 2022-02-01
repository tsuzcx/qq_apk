package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.format.Time;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;

public abstract class GuardProcessExitListener
  extends BroadcastReceiver
{
  private String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    int i = Foreground.getActivityCount();
    boolean bool2 = false;
    if (i > 0) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (!paramString.equals(a(paramArrayList, false)))
      {
        bool1 = bool2;
        if (!paramString.equals(a(paramArrayList, true))) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      return paramArrayList.contains(a());
    }
    return true;
  }
  
  protected String a()
  {
    return TroopMemberApiClient.a();
  }
  
  public void a(boolean paramBoolean)
  {
    Process.killProcess(Process.myPid());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if ("com.tencent.process.exit".equals(paramContext))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext != null)
      {
        paramContext = paramContext.getStringArrayList("procNameList");
        if ((a(paramIntent.getExtras().getString("verify"), paramContext)) && (a(paramContext)))
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("***exitProcexx*** receive broacast action=");
            paramContext.append(paramIntent.getAction());
            QLog.e("GuardProcessExitListener", 2, paramContext.toString());
          }
          a(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardProcessExitListener
 * JD-Core Version:    0.7.0.1
 */