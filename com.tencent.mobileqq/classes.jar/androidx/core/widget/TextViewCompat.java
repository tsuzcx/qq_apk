package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode.Callback;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat.Params;
import androidx.core.text.PrecomputedTextCompat.Params.Builder;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;

public final class TextViewCompat
{
  public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
  public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
  private static final int LINES = 1;
  private static final String LOG_TAG = "TextViewCompat";
  private static Field sMaxModeField;
  private static boolean sMaxModeFieldFetched;
  private static Field sMaximumField;
  private static boolean sMaximumFieldFetched;
  private static Field sMinModeField;
  private static boolean sMinModeFieldFetched;
  private static Field sMinimumField;
  private static boolean sMinimumFieldFetched;
  
  public static int getAutoSizeMaxTextSize(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMaxTextSize();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  public static int getAutoSizeMinTextSize(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMinTextSize();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  public static int getAutoSizeStepGranularity(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeStepGranularity();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  @NonNull
  public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextAvailableSizes();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  public static int getAutoSizeTextType(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextType();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextType();
    }
    return 0;
  }
  
  @Nullable
  public static ColorStateList getCompoundDrawableTintList(@NonNull TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      return paramTextView.getCompoundDrawableTintList();
    }
    if ((paramTextView instanceof TintableCompoundDrawablesView)) {
      return ((TintableCompoundDrawablesView)paramTextView).getSupportCompoundDrawablesTintList();
    }
    return null;
  }
  
  @Nullable
  public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      return paramTextView.getCompoundDrawableTintMode();
    }
    if ((paramTextView instanceof TintableCompoundDrawablesView)) {
      return ((TintableCompoundDrawablesView)paramTextView).getSupportCompoundDrawablesTintMode();
    }
    return null;
  }
  
  @NonNull
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 18) {
      return paramTextView.getCompoundDrawablesRelative();
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (paramTextView.getLayoutDirection() == 1) {}
      for (;;)
      {
        paramTextView = paramTextView.getCompoundDrawables();
        if (i != 0)
        {
          Object localObject1 = paramTextView[2];
          Object localObject2 = paramTextView[0];
          paramTextView[0] = localObject1;
          paramTextView[2] = localObject2;
        }
        return paramTextView;
        i = 0;
      }
    }
    return paramTextView.getCompoundDrawables();
  }
  
  public static int getFirstBaselineToTopHeight(@NonNull TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - paramTextView.getPaint().getFontMetricsInt().top;
  }
  
  public static int getLastBaselineToBottomHeight(@NonNull TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + paramTextView.getPaint().getFontMetricsInt().bottom;
  }
  
  public static int getMaxLines(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMaxLines();
    }
    if (!sMaxModeFieldFetched)
    {
      sMaxModeField = retrieveField("mMaxMode");
      sMaxModeFieldFetched = true;
    }
    if ((sMaxModeField != null) && (retrieveIntFromField(sMaxModeField, paramTextView) == 1))
    {
      if (!sMaximumFieldFetched)
      {
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
      }
      if (sMaximumField != null) {
        return retrieveIntFromField(sMaximumField, paramTextView);
      }
    }
    return -1;
  }
  
  public static int getMinLines(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMinLines();
    }
    if (!sMinModeFieldFetched)
    {
      sMinModeField = retrieveField("mMinMode");
      sMinModeFieldFetched = true;
    }
    if ((sMinModeField != null) && (retrieveIntFromField(sMinModeField, paramTextView) == 1))
    {
      if (!sMinimumFieldFetched)
      {
        sMinimumField = retrieveField("mMinimum");
        sMinimumFieldFetched = true;
      }
      if (sMinimumField != null) {
        return retrieveIntFromField(sMinimumField, paramTextView);
      }
    }
    return -1;
  }
  
  @RequiresApi(18)
  private static int getTextDirection(@NonNull TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {}
    do
    {
      do
      {
        return 1;
      } while (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR);
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
        return 2;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
        return 3;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
        return 4;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
        return 5;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
        return 6;
      }
    } while (paramTextDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL);
    return 7;
  }
  
  @RequiresApi(18)
  private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView paramTextView)
  {
    int i = 1;
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
      return TextDirectionHeuristics.LTR;
    }
    if ((Build.VERSION.SDK_INT >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i == 1) || (i == 2)) {
        return TextDirectionHeuristics.RTL;
      }
      return TextDirectionHeuristics.LTR;
    }
    if (paramTextView.getLayoutDirection() == 1) {}
    for (;;)
    {
      switch (paramTextView.getTextDirection())
      {
      default: 
        if (i == 0) {
          break label137;
        }
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        i = 0;
      }
    }
    label137:
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    return TextDirectionHeuristics.ANYRTL_LTR;
    return TextDirectionHeuristics.LTR;
    return TextDirectionHeuristics.RTL;
    return TextDirectionHeuristics.LOCALE;
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
  }
  
  @NonNull
  public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new PrecomputedTextCompat.Params(paramTextView.getTextMetricsParams());
    }
    PrecomputedTextCompat.Params.Builder localBuilder = new PrecomputedTextCompat.Params.Builder(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      localBuilder.setBreakStrategy(paramTextView.getBreakStrategy());
      localBuilder.setHyphenationFrequency(paramTextView.getHyphenationFrequency());
    }
    if (Build.VERSION.SDK_INT >= 18) {
      localBuilder.setTextDirection(getTextDirectionHeuristic(paramTextView));
    }
    return localBuilder.build();
  }
  
  private static Field retrieveField(String paramString)
  {
    Object localObject = null;
    try
    {
      Field localField = TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.e("TextViewCompat", "Could not retrieve " + paramString + " field.");
    }
    return localObject;
  }
  
  private static int retrieveIntFromField(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      Log.d("TextViewCompat", "Could not retrieve value of " + paramField.getName() + " field.");
    }
    return -1;
  }
  
  public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (!(paramTextView instanceof AutoSizeableTextView)) {
      return;
    }
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (!(paramTextView instanceof AutoSizeableTextView)) {
      return;
    }
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (!(paramTextView instanceof AutoSizeableTextView)) {
      return;
    }
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public static void setCompoundDrawableTintList(@NonNull TextView paramTextView, @Nullable ColorStateList paramColorStateList)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      paramTextView.setCompoundDrawableTintList(paramColorStateList);
    }
    while (!(paramTextView instanceof TintableCompoundDrawablesView)) {
      return;
    }
    ((TintableCompoundDrawablesView)paramTextView).setSupportCompoundDrawablesTintList(paramColorStateList);
  }
  
  public static void setCompoundDrawableTintMode(@NonNull TextView paramTextView, @Nullable PorterDuff.Mode paramMode)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      paramTextView.setCompoundDrawableTintMode(paramMode);
    }
    while (!(paramTextView instanceof TintableCompoundDrawablesView)) {
      return;
    }
    ((TintableCompoundDrawablesView)paramTextView).setSupportCompoundDrawablesTintMode(paramMode);
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        localDrawable = paramDrawable3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67:
        localDrawable = paramDrawable1;
        break label45;
        label73:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      int j;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        j = paramInt3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, paramInt2, paramInt1, paramInt4);
        return;
        i = 0;
        break;
        label67:
        j = paramInt1;
        break label45;
        label73:
        paramInt1 = paramInt3;
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        localDrawable = paramDrawable3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67:
        localDrawable = paramDrawable1;
        break label45;
        label73:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    paramTextView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(paramTextView, paramCallback));
  }
  
  public static void setFirstBaselineToTopHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    if (Build.VERSION.SDK_INT >= 28) {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
    }
    for (;;)
    {
      return;
      Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
      if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
      for (int i = localFontMetricsInt.top; paramInt > Math.abs(i); i = localFontMetricsInt.ascent)
      {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), i + paramInt, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
        return;
      }
    }
  }
  
  public static void setLastBaselineToBottomHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
      }
      return;
    }
  }
  
  public static void setLineHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  public static void setPrecomputedText(@NonNull TextView paramTextView, @NonNull PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramTextView.setText(paramPrecomputedTextCompat.getPrecomputedText());
      return;
    }
    if (!getTextMetricsParams(paramTextView).equalsWithoutTextDirection(paramPrecomputedTextCompat.getParams())) {
      throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }
    paramTextView.setText(paramPrecomputedTextCompat);
  }
  
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static void setTextMetricsParams(@NonNull TextView paramTextView, @NonNull PrecomputedTextCompat.Params paramParams)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramTextView.setTextDirection(getTextDirection(paramParams.getTextDirection()));
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      float f = paramParams.getTextPaint().getTextScaleX();
      paramTextView.getPaint().set(paramParams.getTextPaint());
      if (f == paramTextView.getTextScaleX()) {
        paramTextView.setTextScaleX(f / 2.0F + 1.0F);
      }
      paramTextView.setTextScaleX(f);
      return;
    }
    paramTextView.getPaint().set(paramParams.getTextPaint());
    paramTextView.setBreakStrategy(paramParams.getBreakStrategy());
    paramTextView.setHyphenationFrequency(paramParams.getHyphenationFrequency());
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT > 27) || ((paramCallback instanceof TextViewCompat.OreoCallback))) {
      return paramCallback;
    }
    return new TextViewCompat.OreoCallback(paramCallback, paramTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.TextViewCompat
 * JD-Core Version:    0.7.0.1
 */