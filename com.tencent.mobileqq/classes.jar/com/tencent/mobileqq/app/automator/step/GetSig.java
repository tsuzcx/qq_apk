package com.tencent.mobileqq.app.automator.step;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.qlink.QlinkReliableReport;

public class GetSig
  extends AsyncStep
{
  private MessageObserver a;
  
  private void a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.createToServiceMsg("TransService.ReqGetSign");
    localToServiceMsg.extraData.putInt("ssover", 1);
    localToServiceMsg.extraData.putInt("app_id", AppSetting.a());
    localToServiceMsg.extraData.putByte("a2type", (byte)4);
    localToServiceMsg.extraData.putByteArray("enkey", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getUinSign());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.send(localToServiceMsg);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new GetSig.MyMessageObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    a();
    return 2;
  }
  
  public void b()
  {
    ((ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER)).a();
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a, true);
    QlinkReliableReport.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig
 * JD-Core Version:    0.7.0.1
 */