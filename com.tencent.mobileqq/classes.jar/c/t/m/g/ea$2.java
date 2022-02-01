package c.t.m.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

final class ea$2
  implements Runnable
{
  ea$2(ea paramea) {}
  
  public final void run()
  {
    ea.a(this.a);
    ea localea = this.a;
    try
    {
      localdu = localea.b;
      localPackageInfo = localea.f();
      localdu.i = localPackageInfo.versionCode;
      localdu.h = localPackageInfo.versionName;
      localObject1 = localea.a.getApplicationInfo().loadLabel(localea.e);
      if (localObject1 == null) {
        break label450;
      }
      localObject1 = ((CharSequence)localObject1).toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        du localdu;
        PackageInfo localPackageInfo;
        Object localObject1;
        Object localObject2;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        continue;
        String str = "unknown";
      }
    }
    localdu.j = ((String)localObject1);
    localObject2 = localea.f;
    if (localObject2 != null)
    {
      localdu.a = ((TelephonyManager)localObject2).getPhoneType();
      localObject1 = fo.a(((TelephonyManager)localObject2).getDeviceId(), fo.a);
      localObject2 = fo.a(((TelephonyManager)localObject2).getSubscriberId(), fo.b);
      localea.k = ((String)localObject1);
      localdu.b = ((String)localObject1);
      localdu.c = ((String)localObject2);
      localdu.d = "";
    }
    localdu.e = fo.a(fq.a().replaceAll(":", "").toUpperCase(Locale.ENGLISH), fo.c);
    localObject1 = localea.e;
    bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
    bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
    bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
    localdu.n = bool1;
    localdu.m = bool2;
    localdu.l = bool3;
    localObject1 = new StringBuilder("doInBg: hasGps=");
    ((StringBuilder)localObject1).append(bool1);
    ((StringBuilder)localObject1).append(",hasWifi=");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append(",hasCell=");
    ((StringBuilder)localObject1).append(bool3);
    localObject1 = new StringBuilder("os:");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(localdu.a());
    ((StringBuilder)localObject1).append(" net:");
    ((StringBuilder)localObject1).append(localPackageInfo.versionCode);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(localPackageInfo.versionName);
    ((StringBuilder)localObject1).append(" sdk: ");
    ((StringBuilder)localObject1).append(localdu.d());
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(localdu.e());
    localdu.o = ea.b(localea.a);
    ea.b(this.a).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ea.2
 * JD-Core Version:    0.7.0.1
 */