package com.tencent.mobileqq.ark.API;

import anfv;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ArkAppModuleReg$ModuleQQ$21
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$21(anfv paramanfv, String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null) {
      QQToast.a(BaseActivity.sTopActivity, this.a, 0).a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ArkApp", 2, "IsMute() activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.21
 * JD-Core Version:    0.7.0.1
 */