package com.tencent.mobileqq.app;

import android.content.Context;
import android.hardware.SensorManager;

class QBaseActivity$4
  implements Runnable
{
  QBaseActivity$4(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    try
    {
      if (QBaseActivity.access$200() != null)
      {
        ((SensorManager)this.this$0.getApplicationContext().getSystemService("sensor")).unregisterListener(QBaseActivity.access$200());
        QBaseActivity.access$202(null);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */