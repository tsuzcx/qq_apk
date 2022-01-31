package com.tencent.mobileqq.app.upgrade;

import android.os.Handler;
import azmj;
import bdee;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nbs;
import ncm;

class UpgradeTIMManager$DownloadTask
  implements Runnable, nbs
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public UpgradeTIMManager$DownloadTask(UpgradeTIMManager paramUpgradeTIMManager, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private void a()
  {
    UpgradeTIMManager.a(this.this$0).postDelayed(new UpgradeTIMManager.DownloadTask.1(this), 3000L);
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.post(new UpgradeTIMManager.DownloadTask.2(this), 8, null, false);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ThreadManager.post(this, 5, null, false);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("UpgradeTIMManager", 2, new Object[] { "on download result, code=", Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      UpgradeTIMManager.b(this.this$0);
      return;
    }
    if (paramInt == 10)
    {
      paramInt = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (paramInt + 1);
      if (paramInt < 3)
      {
        a();
        return;
      }
    }
    UpgradeTIMManager.a(this.this$0);
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeTIMManager", 4, new Object[] { "downloading,  progress = ", Integer.valueOf(paramInt) });
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "start download...");
    }
    if (!bdee.h(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "run download, wifi not connected...");
      }
      UpgradeTIMManager.a(this.this$0);
      return;
    }
    azmj.b(UpgradeTIMManager.a(this.this$0), "CliOper", "", "", "0X8008A47", "0X8008A47", 0, 0, "", "", "", "");
    UpgradeTIMManager.a(this.this$0).a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, this.b, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeTIMManager.DownloadTask
 * JD-Core Version:    0.7.0.1
 */