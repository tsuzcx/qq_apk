package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;

public final class AppBrandCapsuleHomeButton
  extends AppBrandOptionButton
{
  public AppBrandCapsuleHomeButton(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandCapsuleHomeButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandCapsuleHomeButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public AppBrandCapsuleHomeButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected String getDefaultAccessibilityLabel()
  {
    return getContext().getString(2131886747);
  }
  
  protected Drawable getDefaultImageDrawable()
  {
    return ContextCompat.getDrawable(getContext(), 2130838653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton
 * JD-Core Version:    0.7.0.1
 */