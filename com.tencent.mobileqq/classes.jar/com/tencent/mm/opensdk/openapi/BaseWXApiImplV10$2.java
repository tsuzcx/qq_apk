package com.tencent.mm.opensdk.openapi;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

class BaseWXApiImplV10$2
  implements PendingIntent.OnFinished
{
  BaseWXApiImplV10$2(BaseWXApiImplV10 paramBaseWXApiImplV10) {}
  
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    paramPendingIntent = new StringBuilder();
    paramPendingIntent.append("onSendFinished resultCode: ");
    paramPendingIntent.append(paramInt);
    paramPendingIntent.append(", resultData: ");
    paramPendingIntent.append(paramString);
    Log.d("MicroMsg.SDK.WXApiImplV10", paramPendingIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.2
 * JD-Core Version:    0.7.0.1
 */