package com.tencent.common.app;

import android.content.Intent;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseApplicationImpl$1
  implements TeleScreenRunnable
{
  BaseApplicationImpl$1(BaseApplicationImpl paramBaseApplicationImpl, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      BaseApplicationImpl.access$001(this.this$0, this.val$intent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseApplicationImpl", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.1
 * JD-Core Version:    0.7.0.1
 */