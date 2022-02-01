package com.tencent.common.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseApplicationImpl$2
  implements TeleScreenRunnable
{
  BaseApplicationImpl$2(BaseApplicationImpl paramBaseApplicationImpl, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      BaseApplicationImpl.access$101(this.this$0, this.val$intent, this.val$options);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseApplicationImpl", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.2
 * JD-Core Version:    0.7.0.1
 */