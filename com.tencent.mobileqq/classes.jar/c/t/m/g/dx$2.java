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

final class dx$2
  implements Runnable
{
  dx$2(dx paramdx) {}
  
  public final void run()
  {
    dx.a(this.a);
    dx localdx = this.a;
    for (;;)
    {
      try
      {
        dr localdr = localdx.b;
        PackageInfo localPackageInfo = localdx.f();
        localdr.i = localPackageInfo.versionCode;
        localdr.h = localPackageInfo.versionName;
        localObject1 = localdx.a.getApplicationInfo().loadLabel(localdx.e);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((CharSequence)localObject1).toString();
        localdr.j = ((String)localObject1);
        Object localObject2 = localdx.f;
        if (localObject2 != null)
        {
          localdr.a = ((TelephonyManager)localObject2).getPhoneType();
          localObject1 = fl.a(((TelephonyManager)localObject2).getDeviceId(), fl.a);
          localObject2 = fl.a(((TelephonyManager)localObject2).getSubscriberId(), fl.b);
          localdx.k = ((String)localObject1);
          localdr.b = ((String)localObject1);
          localdr.c = ((String)localObject2);
          localdr.d = "";
        }
        localdr.e = fl.a(fn.a().replaceAll(":", "").toUpperCase(Locale.ENGLISH), fl.c);
        localObject1 = localdx.e;
        boolean bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
        boolean bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
        boolean bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
        localdr.n = bool1;
        localdr.m = bool2;
        localdr.l = bool3;
        new StringBuilder("doInBg: hasGps=").append(bool1).append(",hasWifi=").append(bool2).append(",hasCell=").append(bool3);
        new StringBuilder("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localdr.a()).append(" net:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localdr.d()).append(" ").append(localdr.e());
        localdr.o = dx.b(localdx.a);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        continue;
      }
      dx.b(this.a).countDown();
      return;
      localObject1 = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dx.2
 * JD-Core Version:    0.7.0.1
 */