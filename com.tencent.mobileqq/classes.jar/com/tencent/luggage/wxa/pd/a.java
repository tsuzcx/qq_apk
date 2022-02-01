package com.tencent.luggage.wxa.pd;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "androidOrientation2Orientation", "androidOrientation", "", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 1, 16})
public final class a
  implements j
{
  public static final a.a a = new a.a(null);
  private final Context b;
  
  public a(@NotNull Context paramContext)
  {
    this.b = paramContext;
  }
  
  private final s a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return s.a;
      }
      return s.c;
    }
    return s.b;
  }
  
  @NotNull
  public String a()
  {
    return "AndroidOrientationGetter";
  }
  
  @NotNull
  public s b()
  {
    Resources localResources = this.b.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "context.resources");
    return a(localResources.getConfiguration().orientation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.a
 * JD-Core Version:    0.7.0.1
 */