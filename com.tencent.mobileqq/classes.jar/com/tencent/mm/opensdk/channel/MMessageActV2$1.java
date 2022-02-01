package com.tencent.mm.opensdk.channel;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

final class MMessageActV2$1
  implements PendingIntent.OnFinished
{
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    paramPendingIntent = new StringBuilder();
    paramPendingIntent.append("sendUsingPendingIntent onSendFinished resultCode: ");
    paramPendingIntent.append(paramInt);
    paramPendingIntent.append(", resultData: ");
    paramPendingIntent.append(paramString);
    Log.i("MicroMsg.SDK.MMessageAct", paramPendingIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2.1
 * JD-Core Version:    0.7.0.1
 */