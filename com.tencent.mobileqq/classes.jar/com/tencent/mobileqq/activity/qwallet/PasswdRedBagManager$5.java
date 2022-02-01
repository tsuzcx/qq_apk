package com.tencent.mobileqq.activity.qwallet;

import Wallet.IdiomRedPackMatchReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.OnGetSkeyListener;
import com.tencent.mobileqq.app.QQAppInterface;

class PasswdRedBagManager$5
  implements VoiceRedPacketHelper.OnGetSkeyListener
{
  PasswdRedBagManager$5(PasswdRedBagManager paramPasswdRedBagManager, PasswdRedBagInfo paramPasswdRedBagInfo, String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt) {}
  
  public void a(String paramString)
  {
    int i = 1;
    IdiomRedPackMatchReq localIdiomRedPackMatchReq = new IdiomRedPackMatchReq();
    localIdiomRedPackMatchReq.grabUin = PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager).getLongAccountUin();
    localIdiomRedPackMatchReq.billno = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.inputIdiom = this.jdField_a_of_type_JavaLangString;
    localIdiomRedPackMatchReq.hbIdiom = PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagInfo);
    localIdiomRedPackMatchReq.makeUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagInfo.c);
    localIdiomRedPackMatchReq.sKey = paramString;
    localIdiomRedPackMatchReq.appid = AppSetting.a();
    localIdiomRedPackMatchReq.subchannel = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagInfo.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localIdiomRedPackMatchReq.fromType = i;
      localIdiomRedPackMatchReq.platform = 0;
      localIdiomRedPackMatchReq.qqVersion = "8.5.5";
      QWalletCommonServlet.a(localIdiomRedPackMatchReq, new PasswdRedBagManager.5.1(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.5
 * JD-Core Version:    0.7.0.1
 */