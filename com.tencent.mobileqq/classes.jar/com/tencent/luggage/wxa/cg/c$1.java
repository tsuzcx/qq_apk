package com.tencent.luggage.wxa.cg;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

final class c$1
  implements Runnable
{
  public void run()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      boolean bool = TextUtils.equals(Environment.getExternalStorageState(), "mounted");
      if (!bool)
      {
        o.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
        c.a("");
        return;
      }
      b localb1 = new b("Tencent/ams/cache", "meta.dat");
      b localb2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
      if ((localb1.a()) && (localb2.a()))
      {
        Object localObject1 = localb1.a(10240);
        localObject2 = localb2.a(10240);
        if (!af.c((String)localObject1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ");
          ((StringBuilder)localObject2).append((String)localObject1);
          o.d("AdDeviceInfo.DeviceInfoUtils", ((StringBuilder)localObject2).toString());
        }
        else if (!af.c((String)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is ");
          ((StringBuilder)localObject1).append((String)localObject2);
          o.d("AdDeviceInfo.DeviceInfoUtils", ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
        else
        {
          o.d("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
          localObject1 = "";
        }
        c.a((String)localObject1);
        localb1.b();
        localb2.b();
        long l2 = System.currentTimeMillis();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getUUId, timeCost = ");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append(", len = ");
        ((StringBuilder)localObject2).append(((String)localObject1).length());
        ((StringBuilder)localObject2).append(", result = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        o.d("AdDeviceInfo.DeviceInfoUtils", ((StringBuilder)localObject2).toString());
        return;
      }
      o.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
      c.a("");
      localb1.b();
      localb2.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AdDeviceInfo.DeviceInfoUtils.getUUId: ");
      ((StringBuilder)localObject2).append(localThrowable.toString());
      o.b("AdDeviceInfo.DeviceInfoUtils", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.c.1
 * JD-Core Version:    0.7.0.1
 */