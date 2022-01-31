package com.tencent.mobileqq.app.automator.step;

import ConfigPush.FileStoragePushFSSvcList;
import ajjh;
import ajxo;
import audb;
import awcw;
import axpy;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.MobileQQ;

public class GetGeneralSettings
  extends AsyncStep
{
  private ajjh a;
  
  public int a()
  {
    boolean bool = false;
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin();
    if (??? != null)
    {
      Common.SetContext(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp());
      Common.SetQQUni((String)???);
    }
    if ("0".endsWith(DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.KKFixerConfig.name(), "0"))) {
      Common.SetDPCStatus(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext(), false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a == 1) {
        bool = true;
      }
      if (!bool) {
        break;
      }
      if (this.jdField_a_of_type_Ajjh == null)
      {
        this.jdField_a_of_type_Ajjh = new ajxo(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajjh, true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(bool)) {
        break;
      }
      return 2;
      Common.SetDPCStatus(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext(), true);
      Common.SetContext(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext());
      Common.SetSafeStatus(true);
    }
    synchronized (axpy.a().a)
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = axpy.a().a();
      if (localFileStoragePushFSSvcList != null)
      {
        awcw.a(localFileStoragePushFSSvcList, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
        axpy.a().b(null);
      }
      audb.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).a(true, true);
      return 7;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajjh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_Ajjh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */