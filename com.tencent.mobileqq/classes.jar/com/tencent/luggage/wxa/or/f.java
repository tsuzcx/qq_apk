package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class f
  implements b
{
  private static final SparseArray<f> a = new SparseArray();
  private f.b b;
  private f.b c;
  private boolean d = false;
  private WeakReference<Activity> e;
  private ContentObserver f = null;
  private e.b g = null;
  private int h;
  private g i = null;
  
  private f(Activity paramActivity)
  {
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.h = paramActivity.getResources().getConfiguration().orientation;
    this.e = new WeakReference(paramActivity);
    a(paramActivity, a(g()));
  }
  
  private e.b a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 2)
    {
      o.e("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        o.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        return e.b.d;
      }
      if (this.g == e.b.e) {
        return e.b.e;
      }
      if (this.g == e.b.f) {
        return e.b.f;
      }
      return e.b.c;
    }
    if (paramInt == 1)
    {
      o.e("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      return e.b.a;
    }
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  private e.b a(e.b paramb)
  {
    if (paramb == e.b.b) {
      return e.b.b;
    }
    if (paramb.a(e.b.c))
    {
      if (g()) {
        return e.b.d;
      }
      return e.b.c;
    }
    return e.b.a;
  }
  
  private e.b a(boolean paramBoolean)
  {
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    return a(this.h, paramBoolean);
  }
  
  @NonNull
  public static f a(@NonNull Activity paramActivity)
  {
    synchronized (a)
    {
      f localf2 = (f)a.get(paramActivity.hashCode());
      f localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = new f(paramActivity);
        a.put(paramActivity.hashCode(), localf1);
      }
      return localf1;
    }
  }
  
  private void a(@NonNull Activity paramActivity, e.b paramb)
  {
    paramActivity.setRequestedOrientation(paramb.g);
  }
  
  private void a(e.a parama, e.b paramb, boolean paramBoolean)
  {
    if (parama == null) {
      return;
    }
    parama.a(paramb, paramBoolean);
  }
  
  private void a(e.b paramb, @NonNull List<f.a> paramList)
  {
    if (paramb == f.b.b(this.c))
    {
      if (f.b.a(this.c) != null) {
        paramList.add(new f.a(f.b.a(this.c), paramb, true, "PendingRequest.Listener orientation equal direct", null));
      }
      this.c = null;
      return;
    }
    if ((Activity)this.e.get() == null)
    {
      o.b("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (f.b.a(this.c) != null) {
        paramList.add(new f.a(f.b.a(this.c), paramb, false, "PendingRequest.Listener activity == null", null));
      }
      return;
    }
    this.b = this.c;
    this.c = null;
    a(this.b);
  }
  
  private void a(f.b paramb)
  {
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramb });
    Activity localActivity = (Activity)this.e.get();
    if (localActivity == null)
    {
      o.c("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (f.b.a(paramb) != null) {
        f.b.a(paramb).a(f.b.b(paramb), false);
      }
      return;
    }
    a(localActivity, f.b.b(paramb));
    if (b(paramb))
    {
      b(f.b.b(paramb));
      return;
    }
    if (this.i == null) {
      this.i = new g();
    }
    this.i.a(new f.2(this, paramb, localActivity));
  }
  
  public static void a(f paramf)
  {
    synchronized (a)
    {
      int j = a.indexOfValue(paramf);
      if (j >= 0) {
        a.removeAt(j);
      }
      return;
    }
  }
  
  private void b(e.b paramb)
  {
    Object localObject1 = (Activity)this.e.get();
    if ((localObject1 == null) || (paramb == null))
    {
      localObject2 = new RuntimeException();
      if (localObject1 == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramb == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      o.a("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    }
    Object localObject2 = new LinkedList();
    try
    {
      if (this.d)
      {
        o.d("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
        return;
      }
      if (this.b == null)
      {
        o.e("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
        return;
      }
      if (paramb == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramb.name();
      }
      o.d("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
      if (f.b.a(this.b) == null) {
        break label227;
      }
      localObject1 = f.b.a(this.b);
      if ((paramb == null) || (!paramb.a(f.b.b(this.b)))) {
        break label292;
      }
      bool1 = true;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramb;
        }
        bool1 = false;
      }
    }
    ((List)localObject2).add(new f.a((e.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", null));
    label227:
    this.b = null;
    if (this.c != null) {
      a(paramb, (List)localObject2);
    }
    paramb = ((List)localObject2).iterator();
    while (paramb.hasNext()) {
      f.a.a((f.a)paramb.next());
    }
  }
  
  private boolean b(@NonNull f.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current orientation=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("  request orientation=");
    localStringBuilder.append(f.b.b(paramb));
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", localStringBuilder.toString());
    if ((this.h == 2) && ((f.b.b(paramb).a(e.b.c)) || (f.b.b(paramb).a(e.b.e)) || (f.b.b(paramb).a(e.b.f))))
    {
      o.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      return true;
    }
    if ((this.h == 1) && (f.b.b(paramb).a(e.b.a)))
    {
      o.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
      return true;
    }
    if (this.h == 0)
    {
      o.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
      return true;
    }
    if (f.b.b(paramb) == e.b.b)
    {
      o.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      return true;
    }
    return false;
  }
  
  private static boolean g()
  {
    int j = Settings.System.getInt(r.a().getContentResolver(), "accelerometer_rotation", 0);
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(j) });
    return j != 1;
  }
  
  private void h()
  {
    g localg = this.i;
    if (localg != null)
    {
      localg.a();
      this.i = null;
    }
  }
  
  public e.b a()
  {
    return a(g());
  }
  
  public void a(Configuration paramConfiguration)
  {
    h();
    this.h = paramConfiguration.orientation;
    paramConfiguration = new StringBuilder();
    paramConfiguration.append("onConfigurationChanged  ");
    paramConfiguration.append(this.h);
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", paramConfiguration.toString());
    b(a(this.h, g()));
  }
  
  public void a(e.b paramb, e.a parama)
  {
    Object localObject = (Activity)this.e.get();
    e.b localb = a(g());
    boolean bool = false;
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", new Object[] { paramb, parama, localb, this.g });
    if (localObject == null)
    {
      o.a("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
      a(parama, localb, false);
      this.g = paramb;
      return;
    }
    if (paramb == null)
    {
      o.c("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
      a(parama, localb, false);
      this.g = paramb;
      return;
    }
    if ((Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()))
    {
      o.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation, activity[%s] isInMultiWindowMode, req[%s], callback fail", new Object[] { ((Activity)localObject).getLocalClassName(), paramb });
      h();
      a((Activity)localObject, paramb);
      if (parama != null)
      {
        if (localb == paramb) {
          bool = true;
        }
        parama.a(localb, bool);
      }
      return;
    }
    if ((paramb == localb) && (this.g != e.b.b))
    {
      o.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", new Object[] { paramb });
      this.b = null;
      a(parama, paramb, true);
      this.g = paramb;
      h();
      a((Activity)localObject, paramb);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.d)
        {
          o.d("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
          this.g = paramb;
          return;
        }
        if (this.b == null)
        {
          this.b = new f.b(paramb, parama, null);
          a(this.b);
          localObject = null;
        }
        else
        {
          if (this.c == null) {
            break label381;
          }
          localObject = this.c;
          this.c = new f.b(paramb, parama, null);
        }
        if (localObject != null)
        {
          o.d("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
          a(f.b.a((f.b)localObject), localb, false);
        }
        this.g = paramb;
        return;
      }
      finally {}
      label381:
      localObject = null;
    }
  }
  
  public void b()
  {
    a(this.g, null);
    ContentResolver localContentResolver = r.a().getApplicationContext().getContentResolver();
    Uri localUri = Settings.System.getUriFor("accelerometer_rotation");
    this.f = new f.1(this, new Handler());
    try
    {
      localContentResolver.registerContentObserver(localUri, false, this.f);
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
    }
  }
  
  public void c()
  {
    if (this.f != null) {
      try
      {
        r.a().getContentResolver().unregisterContentObserver(this.f);
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("MicroMsg.AppBrandDeviceOrientationHandler", localThrowable, "unregisterContentObserver", new Object[0]);
      }
    }
  }
  
  public void d()
  {
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "release");
    a(this);
    try
    {
      if ((this.b == null) && (this.c == null))
      {
        o.d("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
        return;
      }
      o.d("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[] { this.b, this.c });
      this.b = null;
      this.c = null;
      this.d = true;
      return;
    }
    finally {}
  }
  
  public boolean e()
  {
    for (;;)
    {
      try
      {
        if (this.b != null) {
          break label33;
        }
        if (this.c == null) {
          break label28;
        }
      }
      finally {}
      return bool;
      label28:
      boolean bool = false;
      continue;
      label33:
      bool = true;
    }
  }
  
  public void f()
  {
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "init");
    try
    {
      this.d = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.f
 * JD-Core Version:    0.7.0.1
 */