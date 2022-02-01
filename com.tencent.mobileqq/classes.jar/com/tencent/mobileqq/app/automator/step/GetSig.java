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
    ToServiceMsg localToServiceMsg = this.mAutomator.createToServiceMsg("TransService.ReqGetSign");
    localToServiceMsg.extraData.putInt("ssover", 1);
    localToServiceMsg.extraData.putInt("app_id", AppSetting.d());
    localToServiceMsg.extraData.putByte("a2type", (byte)4);
    localToServiceMsg.extraData.putByteArray("enkey", this.mAutomator.k.getUinSign());
    this.mAutomator.send(localToServiceMsg);
  }
  
  protected int doStep()
  {
    if (this.a == null)
    {
      this.a = new GetSig.MyMessageObserver(this, null);
      this.mAutomator.k.addDefaultObservers(this.a);
    }
    a();
    return 2;
  }
  
  public void onCreate()
  {
    ((ShieldListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER)).a();
    ReportController.a(this.mAutomator.k, true);
    QlinkReliableReport.a();
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig
 * JD-Core Version:    0.7.0.1
 */