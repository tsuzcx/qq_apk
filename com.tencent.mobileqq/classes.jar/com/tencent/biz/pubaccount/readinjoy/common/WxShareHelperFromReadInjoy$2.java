package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class WxShareHelperFromReadInjoy$2
  implements PendingIntent.OnFinished
{
  WxShareHelperFromReadInjoy$2(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy) {}
  
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WxShareHelperFromReadInjoy", 2, "onSendFinished resultCode: " + paramInt + ", resultData: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.2
 * JD-Core Version:    0.7.0.1
 */