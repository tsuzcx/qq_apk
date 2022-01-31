package com.tencent.mobileqq.app;

import ajyc;
import akhf;
import bcpw;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class ThemeHandler$1
  implements Runnable
{
  public ThemeHandler$1(akhf paramakhf) {}
  
  public void run()
  {
    bcpw.a(this.this$0.mApp.getApplication(), ajyc.a(2131714913), 4000).a();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.1
 * JD-Core Version:    0.7.0.1
 */