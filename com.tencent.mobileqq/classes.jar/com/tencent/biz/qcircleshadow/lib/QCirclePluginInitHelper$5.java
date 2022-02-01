package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.content.Intent;
import blig;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.qphone.base.util.QLog;

final class QCirclePluginInitHelper$5
  implements Runnable
{
  QCirclePluginInitHelper$5(Context paramContext) {}
  
  public void run()
  {
    if (blig.a(this.val$context)) {}
    do
    {
      return;
      Intent localIntent = new Intent(this.val$context, PeakService.class);
      localIntent.putExtra("ServiceAction", 5);
      localIntent.putExtra("key_alive", false);
      try
      {
        this.val$context.startService(localIntent);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("QCirclePluginInitHelper", 2, "preload peak fail ", localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper.5
 * JD-Core Version:    0.7.0.1
 */