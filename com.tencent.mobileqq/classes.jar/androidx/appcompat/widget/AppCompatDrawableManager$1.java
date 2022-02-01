package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;

class AppCompatDrawableManager$1
  implements ResourceManagerInternal.ResourceManagerHooks
{
  private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
  private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
  private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
  private final int[] TINT_CHECKABLE_BUTTON_LIST = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim };
  private final int[] TINT_COLOR_CONTROL_NORMAL = { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
  private final int[] TINT_COLOR_CONTROL_STATE_LIST = { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
  
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
    int k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    paramContext = ThemeUtils.DISABLED_STATE_SET;
    int[] arrayOfInt1 = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  private ColorStateList createColoredButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
  }
  
  private ColorStateList createDefaultButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
  }
  
  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
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
    if (paramInt == R.drawable.abc_cab_background_top_material) {
      return new LayerDrawable(new Drawable[] { paramResourceManagerInternal.getDrawable(paramContext, R.drawable.abc_cab_background_internal_bg), paramResourceManagerInternal.getDrawable(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha) });
    }
    return null;
  }
  
  public ColorStateList getTintListForDrawableRes(@NonNull Context paramContext, int paramInt)
  {
    if (paramInt == R.drawable.abc_edit_text_material) {
      return AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_edittext);
    }
    if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
      return AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_switch_track);
    }
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      return createSwitchThumbColorStateList(paramContext);
    }
    if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
      return createDefaultButtonColorStateList(paramContext);
    }
    if (paramInt == R.drawable.abc_btn_borderless_material) {
      return createBorderlessButtonColorStateList(paramContext);
    }
    if (paramInt == R.drawable.abc_btn_colored_material) {
      return createColoredButtonColorStateList(paramContext);
    }
    if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
    {
      if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, paramInt)) {
        return ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
      }
      if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        return AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_default);
      }
      if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
        return AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_btn_checkable);
      }
      if (paramInt == R.drawable.abc_seekbar_thumb_material) {
        return AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_seek_thumb);
      }
      return null;
    }
    return AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_spinner);
  }
  
  public PorterDuff.Mode getTintModeForDrawableRes(int paramInt)
  {
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      return PorterDuff.Mode.MULTIPLY;
    }
    return null;
  }
  
  public boolean tintDrawable(@NonNull Context paramContext, int paramInt, @NonNull Drawable paramDrawable)
  {
    if (paramInt == R.drawable.abc_seekbar_track_material)
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
      return true;
    }
    if ((paramInt != R.drawable.abc_ratingbar_material) && (paramInt != R.drawable.abc_ratingbar_indicator_material) && (paramInt != R.drawable.abc_ratingbar_small_material)) {
      return false;
    }
    paramDrawable = (LayerDrawable)paramDrawable;
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
    setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
    return true;
  }
  
  public boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, int paramInt, @NonNull Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = AppCompatDrawableManager.access$000();
    boolean bool = arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt);
    int i = 16842801;
    if (bool) {
      paramInt = R.attr.colorControlNormal;
    }
    for (;;)
    {
      j = 1;
      i = -1;
      break label127;
      if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
      {
        paramInt = R.attr.colorControlActivated;
      }
      else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
      {
        localMode = PorterDuff.Mode.MULTIPLY;
        paramInt = i;
      }
      else
      {
        if (paramInt == R.drawable.abc_list_divider_mtrl_alpha)
        {
          paramInt = 16842800;
          i = Math.round(40.799999F);
          j = 1;
          break label127;
        }
        if (paramInt != R.drawable.abc_dialog_material_background) {
          break;
        }
        paramInt = i;
      }
    }
    int j = 0;
    i = -1;
    paramInt = 0;
    label127:
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