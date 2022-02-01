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
  private static final View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new BaseTransientBottomBar.SnackbarBaseLayout.1();
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
  private BaseTransientBottomBar.OnAttachStateChangeListener jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnAttachStateChangeListener;
  private BaseTransientBottomBar.OnLayoutChangeListener jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnLayoutChangeListener;
  private final float b;
  
  protected BaseTransientBottomBar$SnackbarBaseLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  protected BaseTransientBottomBar$SnackbarBaseLayout(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, 0, 0), paramAttributeSet);
    paramContext = getContext();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.at);
    if (paramAttributeSet.hasValue(R.styleable.eN)) {
      ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.eN, 0));
    }
    this.jdField_a_of_type_Int = paramAttributeSet.getInt(R.styleable.eJ, 0);
    this.jdField_a_of_type_Float = paramAttributeSet.getFloat(R.styleable.eK, 1.0F);
    setBackgroundTintList(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.eL));
    setBackgroundTintMode(ViewUtils.a(paramAttributeSet.getInt(R.styleable.eM, -1), PorterDuff.Mode.SRC_IN));
    this.b = paramAttributeSet.getFloat(R.styleable.eI, 1.0F);
    paramAttributeSet.recycle();
    setOnTouchListener(jdField_a_of_type_AndroidViewView$OnTouchListener);
    setFocusable(true);
    if (getBackground() == null) {
      ViewCompat.setBackground(this, a());
    }
  }
  
  @NonNull
  private Drawable a()
  {
    float f = getResources().getDimension(R.dimen.ap);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setShape(0);
    ((GradientDrawable)localObject).setCornerRadius(f);
    ((GradientDrawable)localObject).setColor(MaterialColors.a(this, R.attr.n, R.attr.l, a()));
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
    {
      localObject = DrawableCompat.wrap((Drawable)localObject);
      DrawableCompat.setTintList((Drawable)localObject, this.jdField_a_of_type_AndroidContentResColorStateList);
      return localObject;
    }
    return DrawableCompat.wrap((Drawable)localObject);
  }
  
  float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void a(BaseTransientBottomBar.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnAttachStateChangeListener = paramOnAttachStateChangeListener;
  }
  
  void a(BaseTransientBottomBar.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnLayoutChangeListener = paramOnLayoutChangeListener;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnAttachStateChangeListener;
    if (localOnAttachStateChangeListener != null) {
      localOnAttachStateChangeListener.a(this);
    }
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnAttachStateChangeListener;
    if (localOnAttachStateChangeListener != null) {
      localOnAttachStateChangeListener.b(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    BaseTransientBottomBar.OnLayoutChangeListener localOnLayoutChangeListener = this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar$OnLayoutChangeListener;
    if (localOnLayoutChangeListener != null) {
      localOnLayoutChangeListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
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
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        localDrawable = DrawableCompat.wrap(paramDrawable.mutate());
        DrawableCompat.setTintList(localDrawable, this.jdField_a_of_type_AndroidContentResColorStateList);
        DrawableCompat.setTintMode(localDrawable, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
      }
    }
    super.setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    if (getBackground() != null)
    {
      Drawable localDrawable = DrawableCompat.wrap(getBackground().mutate());
      DrawableCompat.setTintList(localDrawable, paramColorStateList);
      DrawableCompat.setTintMode(localDrawable, this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
      if (localDrawable != getBackground()) {
        super.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
    if (getBackground() != null)
    {
      Drawable localDrawable = DrawableCompat.wrap(getBackground().mutate());
      DrawableCompat.setTintMode(localDrawable, paramMode);
      if (localDrawable != getBackground()) {
        super.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    View.OnTouchListener localOnTouchListener;
    if (paramOnClickListener != null) {
      localOnTouchListener = null;
    } else {
      localOnTouchListener = jdField_a_of_type_AndroidViewView$OnTouchListener;
    }
    setOnTouchListener(localOnTouchListener);
    super.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout
 * JD-Core Version:    0.7.0.1
 */