package com.qq.im.poi;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LbsPackActivity
  extends BaseActivity
{
  public ArMapInterface a;
  
  protected String getModuleId()
  {
    return "module_armap";
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof ArMapInterface)) {
      this.a = ((ArMapInterface)localAppRuntime);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("qqBaseActivity", 4, "updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackActivity
 * JD-Core Version:    0.7.0.1
 */