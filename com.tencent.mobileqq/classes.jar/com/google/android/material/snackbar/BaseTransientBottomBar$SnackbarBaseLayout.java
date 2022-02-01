package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BaseTransientBottomBar$SnackbarBaseLayout
  extends FrameLayout
{
  private static final View.OnTouchListener a = new BaseTransientBottomBar.SnackbarBaseLayout.1();
  private BaseTransientBottomBar.OnLayoutChangeListener b;
  private BaseTransientBottomBar.OnAttachStateChangeListener c;
  private int d;
  private final float e;
  private final float f;
  private ColorStateList g;
  private PorterDuff.Mode h;
  
  protected BaseTransientBottomBar$SnackbarBaseLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  protected BaseTransientBottomBar$SnackbarBaseLayout(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, 0, 0), paramAttributeSet);
    paramContext = getContext();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.gP);
    if (paramAttributeSet.hasValue(R.styleable.gW)) {
      ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.gW, 0));
    }
    this.d = paramAttributeSet.getInt(R.styleable.gS, 0);
    this.e = paramAttributeSet.getFloat(R.styleable.gT, 1.0F);
    setBackgroundTintList(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.gU));
    setBackgroundTintMode(ViewUtils.a(paramAttributeSet.getInt(R.styleable.gV, -1), PorterDuff.Mode.SRC_IN));
    this.f = paramAttributeSet.getFloat(R.styleable.gR, 1.0F);
    paramAttributeSet.recycle();
    setOnTouchListener(a);
    setFocusable(true);
    if (getBackground() == null) {
      ViewCompat.setBackground(this, a());
    }
  }
  
  @NonNull
  private Drawable a()
  {
    float f1 = getResources().getDimension(R.dimen.ap);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setShape(0);
    ((GradientDrawable)localObject).setCornerRadius(f1);
    ((GradientDrawable)localObject).setColor(MaterialColors.a(this, R.attr.t, R.attr.q, getBackgroundOverlayColorAlpha()));
    if (this.g != null)
    {
      localObject = DrawableCompat.wrap((Drawable)localObject);
      DrawableCompat.setTintList((Drawable)localObject, this.g);
      return localObject;
    }
    return DrawableCompat.wrap((Drawable)localObject);
  }
  
  float getActionTextColorAlpha()
  {
    return this.f;
  }
  
  int getAnimationMode()
  {
    return this.d;
  }
  
  float getBackgroundOverlayColorAlpha()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = this.c;
    if (localOnAttachStateChangeListener != null) {
      localOnAttachStateChangeListener.a(this);
    }
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = this.c;
    if (localOnAttachStateChangeListener != null) {
      localOnAttachStateChangeListener.b(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    BaseTransientBottomBar.OnLayoutChangeListener localOnLayoutChangeListener = this.b;
    if (localOnLayoutChangeListener != null) {
      localOnLayoutChangeListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  void setAnimationMode(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setBackground(@Nullable Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.g != null)
      {
        localDrawable = DrawableCompat.wrap(paramDrawable.mutate());
        DrawableCompat.setTintList(localDrawable, this.g);
        DrawableCompat.setTintMode(localDrawable, this.h);
      }
    }
    super.setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.g = paramColorStateList;
    if (getBackground() != null)
    {
      Drawable localDrawable = DrawableCompat.wrap(getBackground().mutate());
      DrawableCompat.setTintList(localDrawable, paramColorStateList);
      DrawableCompat.setTintMode(localDrawable, this.h);
      if (localDrawable != getBackground()) {
        super.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.h = paramMode;
    if (getBackground() != null)
    {
      Drawable localDrawable = DrawableCompat.wrap(getBackground().mutate());
      DrawableCompat.setTintMode(localDrawable, paramMode);
      if (localDrawable != getBackground()) {
        super.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.c = paramOnAttachStateChangeListener;
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    View.OnTouchListener localOnTouchListener;
    if (paramOnClickListener != null) {
      localOnTouchListener = null;
    } else {
      localOnTouchListener = a;
    }
    setOnTouchListener(localOnTouchListener);
    super.setOnClickListener(paramOnClickListener);
  }
  
  void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    this.b = paramOnLayoutChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout
 * JD-Core Version:    0.7.0.1
 */