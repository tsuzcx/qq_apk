package com.tencent.luggage.wxa.iu;

import android.app.Activity;
import android.view.View;
import com.tencent.luggage.wxa.oq.a;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.d.b;
import com.tencent.luggage.wxa.oq.e;
import com.tencent.luggage.wxa.oq.e.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "isFullScreen", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class ac
  extends a
{
  private e.b d;
  private int e;
  private boolean f;
  @NotNull
  private final c g;
  @Nullable
  private Activity h;
  
  public ac(@NotNull c paramc, @Nullable d.b paramb, @Nullable Activity paramActivity)
  {
    super(paramc, paramb);
    this.g = paramc;
    this.h = paramActivity;
    this.d = e.b.a;
    this.e = 1;
  }
  
  public void a(int paramInt)
  {
    this.c = true;
    Object localObject1;
    if ((paramInt != 90) && (paramInt != -90)) {
      localObject1 = "portrait";
    } else {
      localObject1 = "landscape";
    }
    Object localObject2 = this.g.getOrientationHandler();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "windowAndroid.orientationHandler");
    localObject2 = ((e)localObject2).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "windowAndroid.orientatio…andler.currentOrientation");
    this.d = ((e.b)localObject2);
    this.g.setSoftOrientation((String)localObject1);
    if ((this.h != null) && (Intrinsics.areEqual(localObject1, "landscape")))
    {
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (!e.b.b(e.b.a(((Activity)localObject1).getRequestedOrientation())))
      {
        localObject1 = this.h;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        this.e = ((Activity)localObject1).getRequestedOrientation();
        localObject1 = this.h;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((Activity)localObject1).setRequestedOrientation(6);
      }
    }
  }
  
  public void a(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.a(paramView, paramInt);
    a(paramInt);
    e();
    this.f = true;
  }
  
  public final boolean a()
  {
    return this.f;
  }
  
  public void b()
  {
    super.b();
    this.h = ((Activity)null);
  }
  
  public boolean c()
  {
    boolean bool = this.c;
    if (bool) {
      this.f = false;
    }
    if (super.c())
    {
      if (e.b.b(this.d)) {
        this.g.setSoftOrientation("landscape");
      } else {
        this.g.setSoftOrientation("portrait");
      }
      Activity localActivity = this.h;
      if (localActivity != null)
      {
        if (localActivity == null) {
          Intrinsics.throwNpe();
        }
        localActivity.setRequestedOrientation(this.e);
      }
      f();
      return true;
    }
    if (bool)
    {
      this.c = false;
      f();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.ac
 * JD-Core Version:    0.7.0.1
 */