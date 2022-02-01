package com.tencent.mobileqq.app.automator.step;

import android.os.Bundle;
import aocj;
import aohh;
import aomp;
import bdll;
import bmja;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class GetSig
  extends AsyncStep
{
  private aocj a;
  
  private void a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.createToServiceMsg("TransService.ReqGetSign");
    localToServiceMsg.extraData.putInt("ssover", 1);
    localToServiceMsg.extraData.putInt("app_id", AppSetting.a());
    localToServiceMsg.extraData.putByte("a2type", (byte)4);
    localToServiceMsg.extraData.putByteArray("enkey", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getUinSign());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.send(localToServiceMsg);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aocj == null)
    {
      this.jdField_a_of_type_Aocj = new aomp(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Aocj);
    }
    a();
    return 2;
  }
  
  public void b()
  {
    ((aohh)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(18)).a();
    bdll.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, true);
    bmja.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aocj != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aocj);
      this.jdField_a_of_type_Aocj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig
 * JD-Core Version:    0.7.0.1
 */