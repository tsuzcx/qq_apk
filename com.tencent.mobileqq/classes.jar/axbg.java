import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getColorCompat", "", "Landroid/content/res/Resources;", "id", "getColorStateListCompat", "Landroid/content/res/ColorStateList;", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class axbg
{
  public static final int a(@NotNull Resources paramResources, @ColorRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "$this$getColorCompat");
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColor(paramInt, null);
    }
    return paramResources.getColor(paramInt);
  }
  
  @NotNull
  public static final ColorStateList a(@NotNull Resources paramResources, @ColorRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "$this$getColorStateListCompat");
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramResources = paramResources.getColorStateList(paramInt, null);
      Intrinsics.checkExpressionValueIsNotNull(paramResources, "getColorStateList(id, null)");
      return paramResources;
    }
    paramResources = paramResources.getColorStateList(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramResources, "getColorStateList(id)");
    return paramResources;
  }
  
  @NotNull
  public static final Drawable a(@NotNull Resources paramResources, @DrawableRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "$this$getDrawableCompat");
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = paramResources.getDrawable(paramInt, null);
      Intrinsics.checkExpressionValueIsNotNull(paramResources, "getDrawable(id, null)");
      return paramResources;
    }
    paramResources = paramResources.getDrawable(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramResources, "getDrawable(id)");
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbg
 * JD-Core Version:    0.7.0.1
 */