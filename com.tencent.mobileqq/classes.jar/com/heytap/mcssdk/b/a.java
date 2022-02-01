package com.heytap.mcssdk.b;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.heytap.mcssdk.f.f;

public class a
{
  @TargetApi(26)
  private boolean a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    if (paramContext == null) {
      return false;
    }
    paramContext.createNotificationChannel(new NotificationChannel(paramString1, paramString2, paramInt));
    return true;
  }
  
  public void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    f.a(new a.1(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.b.a
 * JD-Core Version:    0.7.0.1
 */