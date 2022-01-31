package com.tencent.mobileqq.armap;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.olympic.ScannerResultReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class ArMapReceiver
  extends QQBroadcastReceiver
{
  public String getModuleId()
  {
    return "module_armap";
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent.setExtrasClassLoader(ScannerResultReceiver.class.getClassLoader());
    } while ((paramAppRuntime == null) || (!(paramAppRuntime instanceof ArMapInterface)) || (!QLog.isColorLevel()));
    QLog.i("ArMapReceiver", 2, "onReceive");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapReceiver
 * JD-Core Version:    0.7.0.1
 */