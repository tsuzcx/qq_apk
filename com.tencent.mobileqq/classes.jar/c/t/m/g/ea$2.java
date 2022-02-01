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
    for (;;)
    {
      try
      {
        du localdu = localea.b;
        PackageInfo localPackageInfo = localea.f();
        localdu.i = localPackageInfo.versionCode;
        localdu.h = localPackageInfo.versionName;
        localObject1 = localea.a.getApplicationInfo().loadLabel(localea.e);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((CharSequence)localObject1).toString();
        localdu.j = ((String)localObject1);
        Object localObject2 = localea.f;
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
        boolean bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
        boolean bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
        boolean bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
        localdu.n = bool1;
        localdu.m = bool2;
        localdu.l = bool3;
        new StringBuilder("doInBg: hasGps=").append(bool1).append(",hasWifi=").append(bool2).append(",hasCell=").append(bool3);
        new StringBuilder("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localdu.a()).append(" net:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localdu.d()).append(" ").append(localdu.e());
        localdu.o = ea.b(localea.a);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        continue;
      }
      ea.b(this.a).countDown();
      return;
      localObject1 = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ea.2
 * JD-Core Version:    0.7.0.1
 */