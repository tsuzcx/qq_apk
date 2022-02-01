package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class h$a
{
  @JvmStatic
  @NotNull
  public final h a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    int i = paramActivity.hashCode();
    synchronized (h.c())
    {
      h localh = (h)h.c().get(i);
      if (localh != null)
      {
        paramActivity = localh;
      }
      else
      {
        paramActivity = new h(paramActivity);
        h.c().put(i, paramActivity);
      }
      return paramActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.h.a
 * JD-Core Version:    0.7.0.1
 */