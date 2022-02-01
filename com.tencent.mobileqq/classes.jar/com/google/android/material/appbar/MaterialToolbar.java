package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialToolbar
  extends Toolbar
{
  private static final int a = R.style.M;
  @Nullable
  private Integer b;
  
  public MaterialToolbar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialToolbar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ad);
  }
  
  public MaterialToolbar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.eZ, paramInt, a, new int[0]);
    if (paramAttributeSet.hasValue(R.styleable.fa)) {
      setNavigationIconTint(paramAttributeSet.getColor(R.styleable.fa, -1));
    }
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  @Nullable
  private Drawable a(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.b != null)
      {
        localDrawable = DrawableCompat.wrap(paramDrawable);
        DrawableCompat.setTint(localDrawable, this.b.intValue());
      }
    }
    return localDrawable;
  }
  
  private void a(Context paramContext)
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable != null) && (!(localDrawable instanceof ColorDrawable))) {
      return;
    }
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    int i;
    if (localDrawable != null) {
      i = ((ColorDrawable)localDrawable).getColor();
    } else {
      i = 0;
    }
    localMaterialShapeDrawable.g(ColorStateList.valueOf(i));
    localMaterialShapeDrawable.a(paramContext);
    localMaterialShapeDrawable.r(ViewCompat.getElevation(this));
    ViewCompat.setBackground(this, localMaterialShapeDrawable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a(this, paramFloat);
  }
  
  public void setNavigationIcon(@Nullable Drawable paramDrawable)
  {
    super.setNavigationIcon(a(paramDrawable));
  }
  
  public void setNavigationIconTint(@ColorInt int paramInt)
  {
    this.b = Integer.valueOf(paramInt);
    Drawable localDrawable = getNavigationIcon();
    if (localDrawable != null) {
      setNavigationIcon(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.MaterialToolbar
 * JD-Core Version:    0.7.0.1
 */