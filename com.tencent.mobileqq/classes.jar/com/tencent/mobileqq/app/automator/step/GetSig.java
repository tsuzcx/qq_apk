package com.tencent.mobileqq.app.automator.step;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.qlink.QlinkReliableReport;
import znu;

public class GetSig
  extends AsyncStep
{
  private MessageObserver a;
  
  private void b()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a("TransService.ReqGetSign");
    localToServiceMsg.extraData.putInt("ssover", 1);
    localToServiceMsg.extraData.putInt("app_id", AppSetting.a);
    localToServiceMsg.extraData.putByte("a2type", (byte)4);
    localToServiceMsg.extraData.putByteArray("enkey", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getUinSign());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(localToServiceMsg);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new znu(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    b();
    return 2;
  }
  
  public void a()
  {
    ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(18)).b();
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, true);
    QlinkReliableReport.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig
 * JD-Core Version:    0.7.0.1
 */