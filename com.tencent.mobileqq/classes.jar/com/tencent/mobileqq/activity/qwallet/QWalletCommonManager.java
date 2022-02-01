package com.tencent.mobileqq.activity.qwallet;

import Wallet.GetPasswordReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.PatternLockUtils;

public class QWalletCommonManager
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (PatternLockUtils.getSyncPatternLockState(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()))
    {
      GetPasswordReq localGetPasswordReq = new GetPasswordReq();
      localGetPasswordReq.MQOS = "Android";
      localGetPasswordReq.MQVersion = DeviceInfoUtil.a(paramQQAppInterface.getApp());
      ((QWalletAuthHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a(localGetPasswordReq);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong < 1L)) {
      return;
    }
    Intent localIntent = new Intent("com.tencent.qwallet.payer.notify");
    localIntent.putExtra("sendUin", paramLong);
    localIntent.putExtra("tokenId", paramString);
    paramQQAppInterface.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletCommonManager
 * JD-Core Version:    0.7.0.1
 */