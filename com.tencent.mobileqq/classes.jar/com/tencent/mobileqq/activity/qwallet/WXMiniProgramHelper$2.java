package com.tencent.mobileqq.activity.qwallet;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class WXMiniProgramHelper$2
  implements PendingIntent.OnFinished
{
  WXMiniProgramHelper$2(WXMiniProgramHelper paramWXMiniProgramHelper) {}
  
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelper", 2, "onSendFinished resultCode: " + paramInt + ", resultData: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper.2
 * JD-Core Version:    0.7.0.1
 */