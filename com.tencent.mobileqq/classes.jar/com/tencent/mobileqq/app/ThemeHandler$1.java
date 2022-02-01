package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ThemeHandler$1
  implements Runnable
{
  ThemeHandler$1(ThemeHandler paramThemeHandler) {}
  
  public void run()
  {
    QQToast.a(ThemeHandler.a(this.this$0).getApplication(), HardCodeUtil.a(2131714790), 4000).a();
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.1
 * JD-Core Version:    0.7.0.1
 */