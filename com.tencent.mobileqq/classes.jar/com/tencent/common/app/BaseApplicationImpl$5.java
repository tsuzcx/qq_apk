package com.tencent.common.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseApplicationImpl$5
  implements TeleScreenRunnable
{
  BaseApplicationImpl$5(BaseApplicationImpl paramBaseApplicationImpl, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      BaseApplicationImpl.access$101(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseApplicationImpl", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.5
 * JD-Core Version:    0.7.0.1
 */