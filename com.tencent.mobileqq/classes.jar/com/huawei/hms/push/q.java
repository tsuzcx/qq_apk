package com.huawei.hms.push;

import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.text.TextUtils;

public class q
{
  public static r a(o paramo)
  {
    r localr2 = r.a;
    r localr1 = localr2;
    if (paramo.o() >= 0)
    {
      localr1 = localr2;
      if (paramo.o() < r.values().length) {
        localr1 = r.values()[paramo.o()];
      }
    }
    return localr1;
  }
  
  public static void a(Notification.Builder paramBuilder, String paramString, o paramo)
  {
    Notification.BigTextStyle localBigTextStyle = new Notification.BigTextStyle();
    if (!TextUtils.isEmpty(paramo.q())) {
      localBigTextStyle.setBigContentTitle(paramo.q());
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {
        localBigTextStyle.bigText(paramString);
      }
      paramBuilder.setStyle(localBigTextStyle);
      return;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.q
 * JD-Core Version:    0.7.0.1
 */