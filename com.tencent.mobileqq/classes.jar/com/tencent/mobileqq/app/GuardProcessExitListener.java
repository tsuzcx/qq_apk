package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;
import ymk;

public abstract class GuardProcessExitListener
  extends BroadcastReceiver
{
  private String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  private boolean a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return true;
    }
    return paramArrayList.contains(a());
  }
  
  protected String a()
  {
    return ymk.a();
  }
  
  public void a(boolean paramBoolean)
  {
    Process.killProcess(Process.myPid());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!"com.tencent.process.exit".equals(paramContext));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      paramContext = paramContext.getStringArrayList("procNameList");
    } while ((!a(paramIntent.getExtras().getString("verify"), paramContext)) || (!a(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.e("GuardProcessExitListener", 2, "***exitProcexx*** receive broacast action=" + paramIntent.getAction());
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GuardProcessExitListener
 * JD-Core Version:    0.7.0.1
 */