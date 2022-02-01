package com.tencent.luggage.wxa.hd;

import android.os.Build;
import android.os.Build.VERSION;
import androidx.annotation.RequiresPermission;

final class c$6
  extends c.b
{
  c$6(c.a parama)
  {
    super(parama);
  }
  
  @RequiresPermission("android.permission.READ_PHONE_STATE")
  String a()
  {
    if (Build.VERSION.SDK_INT < 9) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 26) {
      return Build.SERIAL;
    }
    try
    {
      String str = Build.getSerial();
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.6
 * JD-Core Version:    0.7.0.1
 */