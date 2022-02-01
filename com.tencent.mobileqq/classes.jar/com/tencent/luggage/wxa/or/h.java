package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings.System;
import android.util.SparseArray;
import com.tencent.luggage.wxa.pd.t;
import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.pd.t.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h.a a = new h.a(null);
  private static final SparseArray<h> h = new SparseArray();
  private final String b;
  private final Context c;
  private t.a d;
  private t.a e;
  private final t f;
  private final List<i> g;
  
  public h(@NotNull Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.AppBrandOrientationObservable#");
    localStringBuilder.append(hashCode());
    this.b = localStringBuilder.toString();
    this.c = paramActivity.getApplicationContext();
    this.d = t.a.a;
    this.e = t.a.a;
    this.f = new t(this.c, (t.b)new h.b(this));
    this.g = ((List)new CopyOnWriteArrayList());
  }
  
  @JvmStatic
  @NotNull
  public static final h a(@NotNull Activity paramActivity)
  {
    return a.a(paramActivity);
  }
  
  private final boolean d()
  {
    Object localObject = this.c;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "appContext");
    localObject = ((Context)localObject).getContentResolver();
    boolean bool = false;
    if (Settings.System.getInt((ContentResolver)localObject, "accelerometer_rotation", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final void a()
  {
    o.e(this.b, "onResume");
    this.f.enable();
  }
  
  public final void a(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "orientationObserver");
    o.e(this.b, "addOrientationObserver");
    this.g.add(parami);
  }
  
  public final void b()
  {
    o.e(this.b, "onPause");
    this.f.disable();
  }
  
  public final void b(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "orientationObserver");
    o.e(this.b, "removeOrientationObserver");
    this.g.remove(parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.h
 * JD-Core Version:    0.7.0.1
 */