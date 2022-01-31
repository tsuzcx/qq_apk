package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class BrowserAppInterface$4
  implements Runnable
{
  BrowserAppInterface$4(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void run()
  {
    if ((this.this$0.isBackground_Stop) && (BaseActivity.sTopActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "no activity running, reboot for tbs now");
      }
      localIntent = new Intent();
      localIntent.putExtra("qq_mode_foreground", true);
      BrowserAppInterface.a(this.this$0, localIntent);
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
    }
    QLog.d("BrowserAppInterface", 2, "activity still running, cannot reboot");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface.4
 * JD-Core Version:    0.7.0.1
 */