package com.tencent.mobileqq.activity.qwallet;

import Wallet.GetBroadCastHbIdiomReq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.OnGetSkeyListener;
import java.util.ArrayList;

class PasswdRedBagManager$4
  implements VoiceRedPacketHelper.OnGetSkeyListener
{
  PasswdRedBagManager$4(PasswdRedBagManager paramPasswdRedBagManager, ArrayList paramArrayList, SessionInfo paramSessionInfo) {}
  
  public void a(String paramString)
  {
    int i = 1;
    GetBroadCastHbIdiomReq localGetBroadCastHbIdiomReq = new GetBroadCastHbIdiomReq();
    localGetBroadCastHbIdiomReq.billnos = this.jdField_a_of_type_JavaUtilArrayList;
    localGetBroadCastHbIdiomReq.sKey = paramString;
    localGetBroadCastHbIdiomReq.appid = AppSetting.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1) {}
    for (;;)
    {
      localGetBroadCastHbIdiomReq.fromType = i;
      localGetBroadCastHbIdiomReq.platform = 0;
      localGetBroadCastHbIdiomReq.qqVersion = "8.5.5";
      QWalletCommonServlet.a(localGetBroadCastHbIdiomReq, new PasswdRedBagManager.4.1(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.4
 * JD-Core Version:    0.7.0.1
 */