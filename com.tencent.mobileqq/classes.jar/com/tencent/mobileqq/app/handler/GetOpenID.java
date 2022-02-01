package com.tencent.mobileqq.app.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.AccountManager;

public class GetOpenID
{
  public static void a(BaseMessageHandler paramBaseMessageHandler, String paramString)
  {
    if (((MessageCache)paramBaseMessageHandler.b().getMsgCache()).T(paramString) != null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get openid key = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("openid", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AccountManager)paramBaseMessageHandler.b().getManager(0);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localHashMap.put("OpenAppid", paramString);
    ((AccountManager)localObject).changeToken(localHashMap, new GetOpenID.1(paramString, paramBaseMessageHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.GetOpenID
 * JD-Core Version:    0.7.0.1
 */