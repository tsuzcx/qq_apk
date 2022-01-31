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
        eb localeb = localea.b;
        PackageInfo localPackageInfo = localea.f();
        localeb.i = localPackageInfo.versionCode;
        localeb.h = localPackageInfo.versionName;
        localObject1 = localea.a.getApplicationInfo().loadLabel(localea.e);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((CharSequence)localObject1).toString();
        localeb.j = ((String)localObject1);
        Object localObject2 = localea.f;
        if (localObject2 != null)
        {
          localeb.a = ((TelephonyManager)localObject2).getPhoneType();
          localObject1 = fo.a(((TelephonyManager)localObject2).getDeviceId(), fo.a);
          localObject2 = fo.a(((TelephonyManager)localObject2).getSubscriberId(), fo.b);
          localea.k = ((String)localObject1);
          localeb.b = ((String)localObject1);
          localeb.c = ((String)localObject2);
          localeb.d = "";
        }
        localeb.e = fo.a(fq.a().replaceAll(":", "").toUpperCase(Locale.ENGLISH), fo.c);
        localObject1 = localea.e;
        boolean bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
        boolean bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
        boolean bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
        localeb.n = bool1;
        localeb.m = bool2;
        localeb.l = bool3;
        new StringBuilder("doInBg: hasGps=").append(bool1).append(",hasWifi=").append(bool2).append(",hasCell=").append(bool3);
        new StringBuilder("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localeb.a()).append(" net:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localeb.d()).append(" ").append(localeb.e());
        localeb.o = ea.b(localea.a);
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