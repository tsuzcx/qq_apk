package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.joor.Reflect;
import org.joor.ReflectException;

public class AppBrandMainProcessService
  extends Service
{
  private static a e;
  private static ServiceConnection f;
  private static final LinkedList<Parcel> g = new LinkedList();
  private static Map<String, WeakReference<b>> h = new ConcurrentHashMap();
  private static final Handler i = new AppBrandMainProcessService.3(Looper.getMainLooper());
  private static Messenger j = new Messenger(i);
  private static final Set<Runnable> k = new HashSet();
  private static final Set<AppBrandMainProcessService.a> l = Collections.newSetFromMap(new ConcurrentHashMap());
  private final HashMap<String, IBinder.DeathRecipient> a = new HashMap();
  private final Handler b = new AppBrandMainProcessService.1(this, Looper.getMainLooper());
  private final Messenger c = new Messenger(this.b);
  private final a.a d = new AppBrandMainProcessService.2(this);
  
  private static Bundle a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(b.class.getClassLoader());
    paramParcel.setDataPosition(0);
    localBundle.readFromParcel(paramParcel);
    return localBundle;
  }
  
  public static Bundle a(b paramb, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramb);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", j);
    }
    localBundle.putString("task_id", paramb.d());
    return localBundle;
  }
  
  @Nullable
  public static b a(Bundle paramBundle, boolean paramBoolean)
  {
    paramBundle.setClassLoader(b.class.getClassLoader());
    b localb2;
    try
    {
      b localb1 = (b)paramBundle.getParcelable("task_object");
    }
    catch (ClassCastException localClassCastException)
    {
      o.b("MicroMsg.AppBrandMainProcessService", "convertBundleToTask e=%s", new Object[] { localClassCastException });
      localb2 = null;
    }
    if (localb2 == null) {
      return null;
    }
    if (paramBoolean) {
      localb2.a((Messenger)paramBundle.getParcelable("task_client"));
    }
    localb2.b(paramBundle.getString("task_id"));
    return localb2;
  }
  
  public static void a()
  {
    a(r.a(), null);
  }
  
  public static void a(@NonNull Context paramContext, @Nullable Runnable paramRunnable)
  {
    if ((paramRunnable != null) && (e != null))
    {
      paramRunnable.run();
      return;
    }
    if (paramRunnable != null) {
      synchronized (k)
      {
        k.add(paramRunnable);
      }
    }
    if (f == null) {
      f = new AppBrandMainProcessService.4();
    }
    o.d("MicroMsg.AppBrandMainProcessService", "tryBindService");
    paramRunnable = new Intent(paramContext, AppBrandMainProcessService.class);
    try
    {
      paramContext.bindService(paramRunnable, f, 1);
      return;
    }
    catch (Exception paramContext)
    {
      o.b("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { paramContext.getMessage() });
    }
  }
  
  public static void a(AppBrandMainProcessService.a parama)
  {
    l.add(parama);
  }
  
  static void a(b paramb)
  {
    c(paramb);
    b(a(paramb, true));
  }
  
  private static boolean a(Bundle paramBundle)
  {
    try
    {
      e.b(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      o.b("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
    }
    return false;
  }
  
  private static void b(Bundle paramBundle)
  {
    ??? = e;
    if (??? == null)
    {
      a();
      synchronized (g)
      {
        g.add(c(paramBundle));
        return;
      }
    }
    try
    {
      ((a)???).a(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      o.b("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
    }
  }
  
  public static void b(AppBrandMainProcessService.a parama)
  {
    l.remove(parama);
  }
  
  private static void b(b paramb1, b paramb2)
  {
    Parcel localParcel = Parcel.obtain();
    paramb1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramb2.a(localParcel);
    localParcel.recycle();
  }
  
  static boolean b(b paramb)
  {
    Bundle localBundle = a(paramb, false);
    if (a(localBundle)) {}
    try
    {
      b(a(localBundle, false), paramb);
      paramb.b();
      return true;
    }
    catch (NullPointerException paramb) {}
    return false;
    return false;
  }
  
  private static Parcel c(Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    return localParcel;
  }
  
  private static void c(b paramb)
  {
    h.put(paramb.d(), new WeakReference(paramb));
  }
  
  private static b d(String paramString)
  {
    paramString = (WeakReference)h.get(paramString);
    if (paramString == null) {
      return null;
    }
    return (b)paramString.get();
  }
  
  private static void e()
  {
    if (e == null) {
      return;
    }
    synchronized (g)
    {
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext())
      {
        Parcel localParcel = (Parcel)localIterator.next();
        b(a(localParcel));
        localParcel.recycle();
      }
      g.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private static void e(String paramString)
  {
    Iterator localIterator = l.iterator();
    while (localIterator.hasNext()) {
      ((AppBrandMainProcessService.a)localIterator.next()).a(paramString);
    }
  }
  
  private static void f(String paramString)
  {
    Iterator localIterator = l.iterator();
    while (localIterator.hasNext()) {
      ((AppBrandMainProcessService.a)localIterator.next()).b(paramString);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    try
    {
      Reflect.on("com.tencent.luggage.wxa.service.ServiceGuard").call("guard", new Object[] { getApplicationContext() });
    }
    catch (ReflectException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */