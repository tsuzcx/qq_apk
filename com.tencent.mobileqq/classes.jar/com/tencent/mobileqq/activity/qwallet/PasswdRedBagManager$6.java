package com.tencent.mobileqq.activity.qwallet;

import Wallet.GetRandomHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.OnGetSkeyListener;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

class PasswdRedBagManager$6
  implements VoiceRedPacketHelper.OnGetSkeyListener
{
  PasswdRedBagManager$6(PasswdRedBagManager paramPasswdRedBagManager, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver) {}
  
  public void a(String paramString)
  {
    if (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager) != null)
    {
      GetRandomHbIdiomReq localGetRandomHbIdiomReq = new GetRandomHbIdiomReq();
      localGetRandomHbIdiomReq.makeUin = PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager).getLongAccountUin();
      localGetRandomHbIdiomReq.subchannel = this.jdField_a_of_type_Int;
      localGetRandomHbIdiomReq.sKey = paramString;
      localGetRandomHbIdiomReq.appid = AppSetting.a();
      localGetRandomHbIdiomReq.fromType = this.b;
      localGetRandomHbIdiomReq.platform = 0;
      localGetRandomHbIdiomReq.qqVersion = "8.5.5";
      QWalletCommonServlet.a(localGetRandomHbIdiomReq, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.6
 * JD-Core Version:    0.7.0.1
 */