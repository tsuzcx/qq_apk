package com.tencent.luggage.wxa.ed;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.re.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/LuggageFoldableDeviceDetector;", "", "ctx", "Landroid/content/Context;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "onDetected", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/runtime/OnNewFoldableDeviceDetected;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lkotlin/jvm/functions/Function0;)V", "initialized", "", "isFoldableByDetector", "isLastIsMultiWindowMode", "lastDisplayMaxEdge", "", "Ljava/lang/Integer;", "lastDisplayMinEdge", "lastHeightDp", "lastOrientation", "lastWidthDp", "getRealDisplaySize", "point", "Landroid/graphics/Point;", "isFoldableDevice", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refreshWindowSpec", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f.a a = new f.a(null);
  private boolean b;
  private Integer c;
  private Integer d;
  private Integer e;
  private Integer f;
  private Integer g;
  private boolean h;
  private boolean i;
  private final Context j;
  private final com.tencent.luggage.wxa.oq.c k;
  private final Function0<Unit> l;
  
  public f(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.oq.c paramc, @NotNull Function0<Unit> paramFunction0)
  {
    this.j = paramContext;
    this.k = paramc;
    this.l = paramFunction0;
    if (b()) {
      this.b = true;
    }
  }
  
  private final boolean a(Context paramContext, Point paramPoint)
  {
    paramContext = (DisplayManager)paramContext.getSystemService("display");
    if (paramContext == null)
    {
      o.c("Luggage.LuggageFoldableDeviceDetector", "getRealDisplaySize: no display manager");
      return false;
    }
    paramContext = paramContext.getDisplays();
    if (paramContext.length != 1)
    {
      o.c("Luggage.LuggageFoldableDeviceDetector", "getRealDisplaySize: no display or multi displays");
      return false;
    }
    paramContext[0].getRealSize(paramPoint);
    return true;
  }
  
  private final boolean b()
  {
    if (this.k.i()) {
      return false;
    }
    Object localObject = this.j.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ctx.resources");
    localObject = ((Resources)localObject).getConfiguration();
    this.c = Integer.valueOf(((Configuration)localObject).orientation);
    this.d = Integer.valueOf(((Configuration)localObject).screenWidthDp);
    this.e = Integer.valueOf(((Configuration)localObject).screenHeightDp);
    localObject = new Point();
    if (a(this.j, (Point)localObject))
    {
      this.f = Integer.valueOf(Math.max(((Point)localObject).x, ((Point)localObject).y));
      this.g = Integer.valueOf(Math.min(((Point)localObject).x, ((Point)localObject).y));
      return true;
    }
    return false;
  }
  
  public final void a(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
    boolean bool = this.b;
    int m = 1;
    if (!bool)
    {
      if (b()) {
        this.b = true;
      }
      return;
    }
    if (this.h)
    {
      b();
      return;
    }
    bool = this.i;
    this.i = this.k.i();
    if (bool) {
      return;
    }
    if (this.k.i()) {
      return;
    }
    int i2 = paramConfiguration.orientation;
    int n = paramConfiguration.screenWidthDp;
    int i1 = paramConfiguration.screenHeightDp;
    paramConfiguration = this.e;
    if ((paramConfiguration == null) || (paramConfiguration.intValue() != 0))
    {
      paramConfiguration = this.d;
      if (((paramConfiguration == null) || (paramConfiguration.intValue() != 0)) && (n != 0) && (i1 != 0)) {}
    }
    else
    {
      m = 0;
    }
    if (m != 0)
    {
      paramConfiguration = this.c;
      if ((paramConfiguration != null) && (paramConfiguration.intValue() == i2))
      {
        paramConfiguration = this.d;
        if ((paramConfiguration != null) && (paramConfiguration.intValue() == n))
        {
          paramConfiguration = this.e;
          if ((paramConfiguration != null) && (paramConfiguration.intValue() == i1)) {}
        }
        else
        {
          o.d("Luggage.LuggageFoldableDeviceDetector", "onConfigurationChanged: start foldable device detector");
          paramConfiguration = new Point();
          if (a(this.j, paramConfiguration))
          {
            m = Math.max(paramConfiguration.x, paramConfiguration.y);
            i2 = Math.min(paramConfiguration.x, paramConfiguration.y);
            paramConfiguration = this.f;
            if ((paramConfiguration != null) && (m == paramConfiguration.intValue()))
            {
              paramConfiguration = this.g;
              if ((paramConfiguration != null) && (i2 == paramConfiguration.intValue()))
              {
                o.d("Luggage.LuggageFoldableDeviceDetector", "onConfigurationChanged: not foldable device");
                break label473;
              }
            }
            paramConfiguration = new StringBuilder();
            paramConfiguration.append("onConfigurationChanged:find foldable device! dp:[");
            paramConfiguration.append(this.d);
            paramConfiguration.append(',');
            paramConfiguration.append(this.e);
            paramConfiguration.append("]=>[");
            paramConfiguration.append(n);
            paramConfiguration.append(',');
            paramConfiguration.append(i1);
            paramConfiguration.append("] ");
            paramConfiguration.append("realSize:[");
            paramConfiguration.append(this.f);
            paramConfiguration.append(',');
            paramConfiguration.append(this.g);
            paramConfiguration.append("]=>[");
            paramConfiguration.append(m);
            paramConfiguration.append(',');
            paramConfiguration.append(i2);
            paramConfiguration.append(']');
            o.d("Luggage.LuggageFoldableDeviceDetector", paramConfiguration.toString());
          }
        }
      }
    }
    label473:
    b();
  }
  
  public final boolean a()
  {
    if (this.k.i()) {
      return false;
    }
    if (this.h) {
      return true;
    }
    if (com.tencent.luggage.wxa.re.c.d()) {
      this.h = true;
    } else if (a.c()) {
      this.h = true;
    }
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.f
 * JD-Core Version:    0.7.0.1
 */