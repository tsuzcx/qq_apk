package com.tencent.luggage.wxa.ed;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.iu.ac;
import com.tencent.luggage.wxa.jj.a.a;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.oq.d.b;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.oq.g;
import com.tencent.luggage.wxa.oq.j;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.page.u;
import junit.framework.AssertionFailedError;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "value", "", "_softOrientation", "set_softOrientation", "(Ljava/lang/String;)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "detector", "Lcom/tencent/luggage/sdk/runtime/LuggageFoldableDeviceDetector;", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "initConfig", "getInitConfig", "()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "setInitConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "isLastInMultiWindowMode", "", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "orientation", "resizable", "getResizable", "()Z", "setResizable", "(Z)V", "scale", "", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "getScale", "getVDisplayMetrics", "orientationChanged", "init", "", "isFoldableDevice", "isLargeScreenWindow", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetWindowOrientation", "setSoftOrientation", "name", "shouldInLargeScreenCompatMode", "tuningRtContentView", "waitViewMeasure", "forceWaitViewMeasure", "reason", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class a<C extends com.tencent.luggage.wxa.do.c>
  implements e<C>, g
{
  @NotNull
  public View a;
  private boolean b;
  private String c;
  @Nullable
  private C d;
  private float e;
  private final f f;
  private final DisplayMetrics g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private double q;
  private a.b r;
  private String s;
  private final com.tencent.luggage.wxa.iu.d t;
  private final Context u;
  private final com.tencent.luggage.wxa.oq.e v;
  
  public a(@NotNull com.tencent.luggage.wxa.iu.d paramd, @NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.oq.e parame)
  {
    this.t = paramd;
    this.u = paramContext;
    this.v = parame;
    this.c = "portrait";
    this.e = 1.0F;
    paramd = this.u;
    paramContext = this.t.W();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "rt.windowAndroid");
    this.f = new f(paramd, paramContext, (Function0)new a.d(this));
    this.g = new DisplayMetrics();
    this.q = -1.0D;
    paramd = this.u.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "ctx.resources");
    this.r = a(paramd.getConfiguration().orientation);
    paramd = this.u.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "ctx.resources");
    this.n = paramd.getConfiguration().orientation;
    paramd = this.u.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "ctx.resources");
    this.m = paramd.getConfiguration().screenWidthDp;
    paramd = this.u.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "ctx.resources");
    this.l = paramd.getConfiguration().screenHeightDp;
    h();
  }
  
  private final DisplayMetrics a(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.g);
    if ((!g()) || (this.q == -1.0D))
    {
      d1 = this.j;
      Double.isNaN(d1);
      d2 = this.k;
      Double.isNaN(d2);
      this.q = (d1 * 1.0D / (d2 * 1.0D));
    }
    int i3 = this.j;
    int i4 = this.k;
    int i1 = i3;
    int i2 = i4;
    if (((a)this).a != null)
    {
      View localView = this.a;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bgView");
      }
      i1 = i3;
      i2 = i4;
      if (localView.isLaidOut())
      {
        localView = this.a;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        i1 = localView.getMeasuredWidth();
        localView = this.a;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        i3 = RangesKt.coerceAtLeast(i1, localView.getMeasuredHeight());
        localView = this.a;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        i1 = localView.getMeasuredWidth();
        localView = this.a;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        i4 = RangesKt.coerceAtMost(i1, localView.getMeasuredHeight());
        if (g())
        {
          i1 = i3;
          i2 = i4;
          if (this.q != -1.0D) {}
        }
        else
        {
          d1 = i3;
          Double.isNaN(d1);
          d2 = i4;
          Double.isNaN(d2);
          this.q = (d1 * 1.0D / (d2 * 1.0D));
          i2 = i4;
          i1 = i3;
        }
      }
    }
    double d1 = this.q;
    if ((d1 <= 1.333333333333333D) || (d1 >= 2.666666666666667D)) {
      d1 = 1.777777777777778D;
    }
    localDisplayMetrics.setTo(this.g);
    double d2 = d1;
    if (this.r != a.b.b)
    {
      d2 = 1;
      Double.isNaN(d2);
      d2 /= d1;
    }
    float f2 = 1.0F;
    float f1 = f2;
    if (this.q >= 1.333333333333333D)
    {
      f1 = f2;
      if (!g()) {
        f1 = 0.75F;
      }
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b], ratio = [%f]", new Object[] { Double.valueOf(d2), Double.valueOf(this.q), Boolean.valueOf(g()), Float.valueOf(f1) });
    if (g())
    {
      i3 = this.p;
      if (i3 != 0)
      {
        i4 = this.o;
        if ((i4 != 0) && (!paramBoolean))
        {
          localDisplayMetrics.heightPixels = i3;
          localDisplayMetrics.widthPixels = i4;
          return localDisplayMetrics;
        }
      }
    }
    if (this.r == a.b.b)
    {
      localDisplayMetrics.heightPixels = ((int)(i1 * f1));
      d1 = localDisplayMetrics.heightPixels;
      Double.isNaN(d1);
      localDisplayMetrics.widthPixels = ((int)(d1 / d2));
    }
    else
    {
      localDisplayMetrics.heightPixels = ((int)(i2 * f1));
      d1 = localDisplayMetrics.heightPixels;
      Double.isNaN(d1);
      localDisplayMetrics.widthPixels = ((int)(d1 / d2));
    }
    this.p = localDisplayMetrics.heightPixels;
    this.o = localDisplayMetrics.widthPixels;
    return localDisplayMetrics;
  }
  
  private final a.b a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        com.tencent.luggage.wxa.qz.o.c("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", new Object[] { Integer.valueOf(paramInt) });
        return a.b.b;
      }
      return a.b.a;
    }
    return a.b.b;
  }
  
  private final void a(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", new Object[] { paramString });
    int i1;
    Object localObject1;
    if (paramString != null)
    {
      i1 = paramString.hashCode();
      if (i1 != 3005871)
      {
        if (i1 != 729267099)
        {
          if ((i1 == 1430647483) && (paramString.equals("landscape")))
          {
            this.r = a.b.a;
            break label151;
          }
        }
        else if (paramString.equals("portrait"))
        {
          this.r = a.b.b;
          break label151;
        }
      }
      else if (paramString.equals("auto"))
      {
        localObject1 = this.u.getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "ctx.resources");
        this.r = a(((Resources)localObject1).getConfiguration().orientation);
        break label151;
      }
    }
    com.tencent.luggage.wxa.qz.o.c("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", new Object[] { paramString });
    label151:
    localObject3 = null;
    try
    {
      Object localObject4 = this.t.C();
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.appbrand.page.o)localObject4).getPageView();
        localObject1 = localObject3;
        if (localObject4 != null) {
          localObject1 = ((u)localObject4).af();
        }
      }
    }
    catch (AssertionFailedError localAssertionFailedError)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
    if ((localObject1 != null) && ((localObject1 instanceof ac)) && (((ac)localObject1).a())) {
      return;
    }
    this.s = paramString;
    a("set softOrientation", true);
    if (((h_()) || (this.b)) && ((this.u instanceof Activity)))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
      i1 = ((Activity)this.u).getRequestedOrientation();
      if ((i1 != 14) && (i1 != -1)) {
        this.v.a(e.b.b, (e.a)new a.c(this));
      }
    }
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    a(true, false, paramString, paramBoolean);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    if (!h_()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = a(paramBoolean3);
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", new Object[] { paramString, this.r, Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    this.t.d(true);
    if (((a)this).a != null)
    {
      View localView = this.a;
      if (localView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("bgView");
      }
      if (((localView.isLaidOut()) || (!paramBoolean1)) && (!paramBoolean2))
      {
        localView = this.a;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        int i1 = localView.getMeasuredWidth();
        localView = this.a;
        if (localView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        int i2 = localView.getMeasuredHeight();
        com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: width [%d], height[%d]", new Object[] { paramString, Integer.valueOf(i1), Integer.valueOf(i2) });
        float f1 = i1 * 1.0F / localDisplayMetrics.widthPixels;
        float f2 = i2 * 1.0F / localDisplayMetrics.heightPixels;
        float f3 = Math.min(f1, f2);
        com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: scaleMin = [%f], scaleMax = [%f]", new Object[] { paramString, Float.valueOf(f3), Float.valueOf(Math.max(f1, f2)) });
        this.e = f3;
        paramString = new j(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
        paramString.gravity = 17;
        paramString.a(this.e);
        this.t.W().a(paramString, this.t);
        this.t.W().a(ContextCompat.getColor(this.u, 2131165191), this.t);
        this.t.ai().setBackgroundColor(ContextCompat.getColor(this.u, 2131165191));
        return;
      }
    }
    this.t.ai().post((Runnable)new a.f(this));
  }
  
  private final void h()
  {
    Point localPoint = new Point();
    Object localObject = this.u.getSystemService("window");
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if ((com.tencent.luggage.wxa.pd.o.a(this.u)) && (k.a.b()))
      {
        ((Display)localObject).getRealSize(localPoint);
        ((Display)localObject).getRealMetrics(this.g);
      }
      else
      {
        ((Display)localObject).getSize(localPoint);
        ((Display)localObject).getMetrics(this.g);
      }
      this.h = localPoint.x;
      this.i = localPoint.y;
      this.j = Math.max(this.h, this.i);
      this.k = Math.min(this.h, this.i);
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.h), Integer.valueOf(this.i) });
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  private final void i()
  {
    if (!this.t.aQ()) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)this.s))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.s });
      this.v.a(e.b.a(this.s), null);
      return;
    }
    e.b localb = this.v.a();
    Intrinsics.checkExpressionValueIsNotNull(localb, "activityOrientationHandler.currentOrientation");
    com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
    this.v.a(localb, null);
  }
  
  @NotNull
  public com.tencent.luggage.wxa.oq.d a(@Nullable d.b paramb)
  {
    Activity localActivity = (Activity)null;
    Object localObject = this.u;
    if ((localObject instanceof Activity)) {
      localActivity = (Activity)localObject;
    }
    localObject = this.t.W();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rt.windowAndroid");
    return (com.tencent.luggage.wxa.oq.d)new ac((com.tencent.luggage.wxa.oq.c)localObject, paramb, localActivity);
  }
  
  public void a(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
    this.f.a(paramConfiguration);
    Object localObject = this.t.ai();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rt.contentView");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.f)localObject).getParent();
    if (localObject != null)
    {
      this.a = ((View)localObject);
      if ((this.n != paramConfiguration.orientation) && (Intrinsics.areEqual(this.s, "auto")) && (h_()) && (!this.b)) {
        this.r = a(paramConfiguration.orientation);
      }
      if ((this.n != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != this.l) || (paramConfiguration.screenWidthDp != this.m))
      {
        h();
        if ((g()) && ((paramConfiguration.screenHeightDp != this.l) || (paramConfiguration.screenWidthDp != this.m))) {
          i();
        }
        localObject = this.a;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("bgView");
        }
        ((View)localObject).addOnLayoutChangeListener((View.OnLayoutChangeListener)new a.e(this));
      }
      this.n = paramConfiguration.orientation;
      this.l = paramConfiguration.screenHeightDp;
      this.m = paramConfiguration.screenWidthDp;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public void a(@NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramC, "initConfig");
    Object localObject = this.t.ai();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rt.contentView");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.f)localObject).getParent();
    if (localObject != null)
    {
      this.a = ((View)localObject);
      this.d = paramC;
      this.b = paramC.p.s;
      a(this, true, false, "init", false, 8, null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jj.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "appConfig");
    String str1 = "portrait";
    this.c = "portrait";
    Object localObject = parama.c().m;
    if (localObject == null)
    {
      String str2 = parama.f().a;
      localObject = str1;
      if (str2 != null)
      {
        int i1;
        if (((CharSequence)str2).length() == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          localObject = str1;
        } else {
          localObject = str2;
        }
      }
      this.c = ((String)localObject);
    }
    else
    {
      this.c = ((String)localObject);
    }
    boolean bool1 = parama.a;
    boolean bool2 = this.b;
    if (bool2 != bool1)
    {
      this.b = bool1;
      a(this, "redundancy field check fail", false, 2, null);
      com.tencent.luggage.wxa.qz.o.c("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    }
  }
  
  protected final boolean a()
  {
    return this.b;
  }
  
  @NotNull
  public final View b()
  {
    View localView = this.a;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bgView");
    }
    return localView;
  }
  
  public void b(@NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramC, "initConfig");
    Object localObject = this.t.ai();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rt.contentView");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.f)localObject).getParent();
    if (localObject != null)
    {
      this.a = ((View)localObject);
      this.d = paramC;
      this.b = paramC.p.s;
      if (h_())
      {
        paramC = this.u.getResources();
        Intrinsics.checkExpressionValueIsNotNull(paramC, "ctx.resources");
        paramC = paramC.getConfiguration();
        Intrinsics.checkExpressionValueIsNotNull(paramC, "ctx.resources.configuration");
        a(paramC);
      }
      a(this, true, true, "onInitConfigUpdated", false, 8, null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  @Nullable
  protected final C c()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return (com.tencent.luggage.wxa.pd.o.a(this.u)) && (!h_());
  }
  
  protected final boolean g()
  {
    return this.f.a();
  }
  
  @Nullable
  public com.tencent.luggage.wxa.oq.e getOrientationHandler()
  {
    com.tencent.luggage.wxa.oq.c localc = this.t.W();
    Intrinsics.checkExpressionValueIsNotNull(localc, "rt.windowAndroid");
    return (com.tencent.luggage.wxa.oq.e)new com.tencent.luggage.wxa.os.a(localc);
  }
  
  public float getScale()
  {
    return this.e;
  }
  
  @NotNull
  public DisplayMetrics getVDisplayMetrics()
  {
    return a(false);
  }
  
  public boolean h_()
  {
    Context localContext = r.a();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "MMApplicationContext.getContext()");
    return com.tencent.luggage.wxa.pd.o.a(localContext);
  }
  
  public boolean i_()
  {
    return false;
  }
  
  public void setSoftOrientation(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.a
 * JD-Core Version:    0.7.0.1
 */