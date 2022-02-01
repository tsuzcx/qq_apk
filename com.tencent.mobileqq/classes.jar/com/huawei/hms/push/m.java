package com.huawei.hms.push;

import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.text.TextUtils;

public class m
{
  public static n a(k paramk)
  {
    n localn2 = n.a;
    n localn1 = localn2;
    if (paramk.w() >= 0)
    {
      localn1 = localn2;
      if (paramk.w() < n.values().length) {
        localn1 = n.values()[paramk.w()];
      }
    }
    return localn1;
  }
  
  public static void a(Notification.Builder paramBuilder, String paramString, k paramk)
  {
    Notification.BigTextStyle localBigTextStyle = new Notification.BigTextStyle();
    if (!TextUtils.isEmpty(paramk.h())) {
      localBigTextStyle.setBigContentTitle(paramk.h());
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBigTextStyle.bigText(paramString);
    }
    paramBuilder.setStyle(localBigTextStyle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.m
 * JD-Core Version:    0.7.0.1
 */