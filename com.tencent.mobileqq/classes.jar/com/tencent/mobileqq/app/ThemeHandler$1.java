package com.tencent.mobileqq.app;

import alpo;
import alyu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ThemeHandler$1
  implements Runnable
{
  public ThemeHandler$1(alyu paramalyu) {}
  
  public void run()
  {
    QQToast.a(this.this$0.mApp.getApplication(), alpo.a(2131715296), 4000).a();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.1
 * JD-Core Version:    0.7.0.1
 */