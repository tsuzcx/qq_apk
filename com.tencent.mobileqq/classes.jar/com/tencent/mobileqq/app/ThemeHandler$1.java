package com.tencent.mobileqq.app;

import ajya;
import akhe;
import bcql;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class ThemeHandler$1
  implements Runnable
{
  public ThemeHandler$1(akhe paramakhe) {}
  
  public void run()
  {
    bcql.a(this.this$0.mApp.getApplication(), ajya.a(2131714924), 4000).a();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.1
 * JD-Core Version:    0.7.0.1
 */