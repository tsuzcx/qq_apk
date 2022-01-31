package com.tencent.mobileqq.app.automator.step;

import ConfigPush.FileStoragePushFSSvcList;
import alox;
import amdn;
import awtw;
import ayxk;
import baoc;
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
  private alox a;
  
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
      if (this.jdField_a_of_type_Alox == null)
      {
        this.jdField_a_of_type_Alox = new amdn(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Alox, true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(bool)) {
        break;
      }
      return 2;
      Common.SetDPCStatus(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext(), true);
      Common.SetContext(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext());
      Common.SetSafeStatus(true);
    }
    synchronized (baoc.a().a)
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = baoc.a().a();
      if (localFileStoragePushFSSvcList != null)
      {
        ayxk.a(localFileStoragePushFSSvcList, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
        baoc.a().b(null);
      }
      awtw.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).a(true, true);
      return 7;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Alox != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_Alox = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */