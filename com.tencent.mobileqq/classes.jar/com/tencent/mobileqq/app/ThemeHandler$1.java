package com.tencent.mobileqq.app;

import ajjy;
import ajsv;
import bbmy;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class ThemeHandler$1
  implements Runnable
{
  public ThemeHandler$1(ajsv paramajsv) {}
  
  public void run()
  {
    bbmy.a(this.this$0.mApp.getApplication(), ajjy.a(2131649124), 4000).a();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.1
 * JD-Core Version:    0.7.0.1
 */