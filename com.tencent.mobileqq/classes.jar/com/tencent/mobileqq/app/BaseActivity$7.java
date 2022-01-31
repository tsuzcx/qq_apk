package com.tencent.mobileqq.app;

import android.content.Context;
import android.hardware.SensorManager;

class BaseActivity$7
  implements Runnable
{
  BaseActivity$7(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      if (BaseActivity.access$300() != null)
      {
        ((SensorManager)this.this$0.getApplicationContext().getSystemService("sensor")).unregisterListener(BaseActivity.access$300());
        BaseActivity.access$302(null);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.7
 * JD-Core Version:    0.7.0.1
 */