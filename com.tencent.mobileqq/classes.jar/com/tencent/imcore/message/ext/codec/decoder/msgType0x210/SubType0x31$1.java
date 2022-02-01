package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import mqq.observer.SubAccountObserver;

final class SubType0x31$1
  extends SubAccountObserver
{
  SubType0x31$1(QQAppInterface paramQQAppInterface, ISubAccountService paramISubAccountService) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 != null)
    {
      QQAppInterface localQQAppInterface = this.a;
      if (localQQAppInterface != null)
      {
        if (paramString1 == null) {
          return;
        }
        if (paramString1.equalsIgnoreCase(localQQAppInterface.getAccount()))
        {
          this.b.updateA2(paramString2, paramString3, true);
          ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(this.a, (byte)1, paramString2);
          ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).loadServerMessage(this.a, paramString2, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x31.1
 * JD-Core Version:    0.7.0.1
 */