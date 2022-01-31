package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ARMapBaseTitleActivity
  extends IphoneTitleBarActivity
{
  public ArMapInterface a;
  
  protected String getModuleId()
  {
    return "module_armap";
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof ArMapInterface)) {
      this.a = ((ArMapInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 4, "ARMapBaseTitleActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapBaseTitleActivity
 * JD-Core Version:    0.7.0.1
 */