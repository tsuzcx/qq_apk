package com.tencent.mobileqq.app.automator.step;

import ajmm;
import ajrx;
import ajxt;
import android.os.Bundle;
import awqx;
import bffu;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class GetSig
  extends AsyncStep
{
  private ajmm a;
  
  private void b()
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
    if (this.jdField_a_of_type_Ajmm == null)
    {
      this.jdField_a_of_type_Ajmm = new ajxt(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Ajmm);
    }
    b();
    return 2;
  }
  
  public void a()
  {
    ((ajrx)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(18)).a();
    awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, true);
    bffu.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajmm != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_Ajmm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig
 * JD-Core Version:    0.7.0.1
 */