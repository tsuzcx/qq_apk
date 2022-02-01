package com.tencent.luggage.wxa.hd;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;

final class c$5
  extends c.b
{
  final c.a a = new c.c(258);
  
  c$5(c.a parama)
  {
    super(parama);
  }
  
  @RequiresPermission("android.permission.READ_PHONE_STATE")
  String a()
  {
    Object localObject = this.a.a("1234567890ABCDEF");
    if (!"1234567890ABCDEF".equals(localObject)) {
      return localObject;
    }
    localObject = r.a();
    TelephonyManager localTelephonyManager = (TelephonyManager)((Context)localObject).getSystemService("phone");
    int k = Build.VERSION.SDK_INT;
    int j = 1;
    int i = j;
    if (k >= 23) {
      if (((Context)localObject).checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i == 0)
    {
      o.c("MicroMsg.DeviceInfo", "telMgr.getDeviceId fail, no permission");
      return null;
    }
    try
    {
      localObject = PhoneInfoMonitor.getDeviceId(localTelephonyManager);
      TextUtils.isEmpty((CharSequence)localObject);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  void b() {}
  
  void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.5
 * JD-Core Version:    0.7.0.1
 */