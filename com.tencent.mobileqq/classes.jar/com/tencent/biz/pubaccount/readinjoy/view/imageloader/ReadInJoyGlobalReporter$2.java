package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import rcx;

public class ReadInJoyGlobalReporter$2
  implements Runnable
{
  public ReadInJoyGlobalReporter$2(rcx paramrcx) {}
  
  public void run()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (rcx.b(this.this$0) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.this$0.a, localIntentFilter);
        rcx.a(this.this$0, 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "registerScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyGlobalReporter", 2, "registerScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.2
 * JD-Core Version:    0.7.0.1
 */