package com.tencent.luggage.ui;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaPreRenderCustomWindowAndroid;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;", "displayId", "", "originalContext", "Landroid/content/Context;", "(ILandroid/content/Context;)V", "getDisplayId", "()I", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends n
{
  private final int b;
  
  public b()
  {
    this(0, null, 3, null);
  }
  
  public b(int paramInt, @Nullable Context paramContext)
  {
    this.b = paramInt;
    Context localContext = paramContext;
    if (paramContext == null) {
      if (this.b != 0)
      {
        paramContext = (DisplayManager)ContextCompat.getSystemService(r.a(), DisplayManager.class);
        if (paramContext != null) {
          paramContext = paramContext.getDisplay(this.b);
        } else {
          paramContext = null;
        }
        if (paramContext != null) {
          localContext = (Context)new k(r.a(), (k.a)new b.1(paramContext));
        } else {
          localContext = r.a();
        }
      }
      else
      {
        localContext = r.a();
      }
    }
    paramContext = (com.tencent.mm.ui.base.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.mm.ui.base.e.class);
    if (paramContext != null)
    {
      if (localContext == null) {
        Intrinsics.throwNpe();
      }
      paramContext = paramContext.a(localContext);
      if (paramContext != null) {
        localContext = paramContext;
      }
    }
    a((Context)d.a(localContext));
  }
  
  @NotNull
  public DisplayMetrics getVDisplayMetrics()
  {
    if (this.b != 0)
    {
      localObject = r.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getContext()");
      localObject = (DisplayManager)ContextCompat.getSystemService((Context)localObject, DisplayManager.class);
      if (localObject != null) {
        localObject = ((DisplayManager)localObject).getDisplay(this.b);
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Display)localObject).getMetrics(localDisplayMetrics);
        return localDisplayMetrics;
      }
      localObject = super.getVDisplayMetrics();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "super.getVDisplayMetrics()");
      return localObject;
    }
    Object localObject = super.getVDisplayMetrics();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "super.getVDisplayMetrics()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.b
 * JD-Core Version:    0.7.0.1
 */