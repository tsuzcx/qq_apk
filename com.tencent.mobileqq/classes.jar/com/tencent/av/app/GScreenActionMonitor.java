package com.tencent.av.app;

import android.content.Context;
import android.content.IntentFilter;
import mqq.app.MobileQQ;

public class GScreenActionMonitor
{
  private GScreenActionMonitor.ScreenActionReceiver jdField_a_of_type_ComTencentAvAppGScreenActionMonitor$ScreenActionReceiver;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public GScreenActionMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor$ScreenActionReceiver = new GScreenActionMonitor.ScreenActionReceiver();
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext().registerReceiver(this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor$ScreenActionReceiver, localIntentFilter);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor$ScreenActionReceiver != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext().unregisterReceiver(this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor$ScreenActionReceiver);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GScreenActionMonitor
 * JD-Core Version:    0.7.0.1
 */