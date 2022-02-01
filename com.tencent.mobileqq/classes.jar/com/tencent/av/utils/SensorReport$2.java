package com.tencent.av.utils;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;

final class SensorReport$2
  implements Runnable
{
  SensorReport$2(Context paramContext, IntentFilter paramIntentFilter) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(SensorReport.a(), this.jdField_a_of_type_AndroidContentIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registonUserActionReceiver e = ");
        localStringBuilder.append(localException);
        QLog.d("SensorReport", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SensorReport.2
 * JD-Core Version:    0.7.0.1
 */