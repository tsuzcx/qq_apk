package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;

final class AppCompatDrawableManager$1
  implements ResourceManagerInternal.ResourceManagerHooks
{
  private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = { 2130837560, 2130837520, 2130837559 };
  private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = { 2130837585, 2130837587, 2130837522, 2130837578, 2130837579, 2130837581, 2130837583, 2130837580, 2130837582, 2130837584 };
  private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = { 2130837588, 2130837586, 2130837505 };
  private final int[] TINT_CHECKABLE_BUTTON_LIST = { 2130837508, 2130837514, 2130837509, 2130837515 };
  private final int[] TINT_COLOR_CONTROL_NORMAL = { 2130837529, 2130837570, 2130837536, 2130837531, 2130837532, 2130837535, 2130837534 };
  private final int[] TINT_COLOR_CONTROL_STATE_LIST = { 2130837576, 2130837589 };
  
  private boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private ColorStateList createBorderlessButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, 0);
  }
  
  private ColorStateList createButtonColorStateList(@NonNull Context paramContext, @ColorInt int paramInt)
  {
    int k = ThemeUtils.getThemeAttrColor(paramContext, 2131034357);
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, 2131034355);
    paramContext = ThemeUtils.DISABLED_STATE_SET;
    int[] arrayOfInt1 = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  private ColorStateList createColoredButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, 2131034353));
  }
  
  private ColorStateList createDefaultButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, 2131034355));
  }
  
  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, 2131034369);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, 2131034356);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, 2131034369);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, 2131034356);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, 2131034369);
    }
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = AppCompatDrawableManager.access$000();
    }
    localDrawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(paramInt, paramDrawable));
  }
  
  public Drawable createDrawableFor(@NonNull ResourceManagerInternal paramResourceManagerInternal, @NonNull Context paramContext, int paramInt)
  {
    if (paramInt == 2130837521) {
      return new LayerDrawable(new Drawable[] { paramResourceManagerInternal.getDrawable(paramContext, 2130837520), paramResourceManagerInternal.getDrawable(paramContext, 2130837522) });
    }
    return null;
  }
  
  public ColorStateList getTintListForDrawableRes(@NonNull Context paramContext, int paramInt)
  {
    if (paramInt == 2130837525) {
      return AppCompatResources.getColorStateList(paramContext, 2131165219);
    }
    if (paramInt == 2130837575) {
      return AppCompatResources.getColorStateList(paramContext, 2131165222);
    }
    if (paramInt == 2130837574) {
      return createSwitchThumbColorStateList(paramContext);
    }
    if (paramInt == 2130837513) {
      return createDefaultButtonColorStateList(paramContext);
    }
    if (paramInt == 2130837507) {
      return createBorderlessButtonColorStateList(paramContext);
    }
    if (paramInt == 2130837512) {
      return createColoredButtonColorStateList(paramContext);
    }
    if ((paramInt != 2130837572) && (paramInt != 2130837573))
    {
      if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, paramInt)) {
        return ThemeUtils.getThemeAttrColorStateList(paramContext, 2131034358);
      }
      if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        return AppCompatResources.getColorStateList(paramContext, 2131165218);
      }
      if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
        return AppCompatResources.getColorStateList(paramContext, 2131165217);
      }
      if (paramInt == 2130837569) {
        return AppCompatResources.getColorStateList(paramContext, 2131165220);
      }
      return null;
    }
    return AppCompatResources.getColorStateList(paramContext, 2131165221);
  }
  
  public PorterDuff.Mode getTintModeForDrawableRes(int paramInt)
  {
    if (paramInt == 2130837574) {
      return PorterDuff.Mode.MULTIPLY;
    }
    return null;
  }
  
  public boolean tintDrawable(@NonNull Context paramContext, int paramInt, @NonNull Drawable paramDrawable)
  {
    if (paramInt == 2130837571)
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(paramContext, 2131034358), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, 2131034358), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, 2131034356), AppCompatDrawableManager.access$000());
      return true;
    }
    if ((paramInt != 2130837562) && (paramInt != 2130837561) && (paramInt != 2130837563)) {
      return false;
    }
    paramDrawable = (LayerDrawable)paramDrawable;
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, 2131034358), AppCompatDrawableManager.access$000());
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, 2131034356), AppCompatDrawableManager.access$000());
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, 2131034356), AppCompatDrawableManager.access$000());
    return true;
  }
  
  public boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, int paramInt, @NonNull Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = AppCompatDrawableManager.access$000();
    boolean bool = arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt);
    int i = 16842801;
    if (bool) {
      paramInt = 2131034358;
    }
    for (;;)
    {
      j = 1;
      i = -1;
      break label120;
      if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
      {
        paramInt = 2131034356;
      }
      else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
      {
        localMode = PorterDuff.Mode.MULTIPLY;
        paramInt = i;
      }
      else
      {
        if (paramInt == 2130837548)
        {
          paramInt = 16842800;
          i = Math.round(40.799999F);
          j = 1;
          break label120;
        }
        if (paramInt != 2130837524) {
          break;
        }
        paramInt = i;
      }
    }
    int j = 0;
    i = -1;
    paramInt = 0;
    label120:
    if (j != 0)
    {
      Drawable localDrawable = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      localDrawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(paramContext, paramInt), localMode));
      if (i != -1) {
        localDrawable.setAlpha(i);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatDrawableManager.1
 * JD-Core Version:    0.7.0.1
 */