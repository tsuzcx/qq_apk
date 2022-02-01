package com.tencent.luggage.wxa.hc;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.hg.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public class a
{
  @TargetApi(26)
  private static void a()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((NotificationManager)r.a().getSystemService("notification")).isNotificationPolicyAccessGranted();
      o.d("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        try
        {
          Intent localIntent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
          localIntent.putExtra("android.provider.extra.APP_PACKAGE", r.b());
          r.a().startActivity(localIntent);
          return;
        }
        catch (Exception localException)
        {
          o.b("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public static void a(AudioManager paramAudioManager, int paramInt1, int paramInt2, int paramInt3)
  {
    if (c.a(24))
    {
      o.d("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
      try
      {
        paramAudioManager.setStreamVolume(paramInt1, paramInt2, paramInt3);
        return;
      }
      catch (Exception paramAudioManager)
      {
        o.b("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", new Object[] { paramAudioManager.getMessage() });
        a();
        return;
      }
    }
    paramAudioManager.setStreamVolume(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hc.a
 * JD-Core Version:    0.7.0.1
 */