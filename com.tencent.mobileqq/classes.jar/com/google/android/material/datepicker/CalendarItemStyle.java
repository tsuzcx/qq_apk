package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

final class CalendarItemStyle
{
  @NonNull
  private final Rect a;
  private final ColorStateList b;
  private final ColorStateList c;
  private final ColorStateList d;
  private final int e;
  private final ShapeAppearanceModel f;
  
  private CalendarItemStyle(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, ColorStateList paramColorStateList3, int paramInt, ShapeAppearanceModel paramShapeAppearanceModel, @NonNull Rect paramRect)
  {
    Preconditions.checkArgumentNonnegative(paramRect.left);
    Preconditions.checkArgumentNonnegative(paramRect.top);
    Preconditions.checkArgumentNonnegative(paramRect.right);
    Preconditions.checkArgumentNonnegative(paramRect.bottom);
    this.a = paramRect;
    this.b = paramColorStateList2;
    this.c = paramColorStateList1;
    this.d = paramColorStateList3;
    this.e = paramInt;
    this.f = paramShapeAppearanceModel;
  }
  
  @NonNull
  static CalendarItemStyle a(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Cannot create a CalendarItemStyle with a styleResId of 0");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.ek);
    Rect localRect = new Rect(localTypedArray.getDimensionPixelOffset(R.styleable.el, 0), localTypedArray.getDimensionPixelOffset(R.styleable.en, 0), localTypedArray.getDimensionPixelOffset(R.styleable.em, 0), localTypedArray.getDimensionPixelOffset(R.styleable.eo, 0));
    ColorStateList localColorStateList1 = MaterialResources.a(paramContext, localTypedArray, R.styleable.ep);
    ColorStateList localColorStateList2 = MaterialResources.a(paramContext, localTypedArray, R.styleable.eu);
    ColorStateList localColorStateList3 = MaterialResources.a(paramContext, localTypedArray, R.styleable.es);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.et, 0);
    paramContext = ShapeAppearanceModel.a(paramContext, localTypedArray.getResourceId(R.styleable.eq, 0), localTypedArray.getResourceId(R.styleable.er, 0)).a();
    localTypedArray.recycle();
    return new CalendarItemStyle(localColorStateList1, localColorStateList2, localColorStateList3, paramInt, paramContext, localRect);
  }
  
  int a()
  {
    return this.a.top;
  }
  
  void a(@NonNull TextView paramTextView)
  {
    Object localObject = new MaterialShapeDrawable();
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    ((MaterialShapeDrawable)localObject).setShapeAppearanceModel(this.f);
    localMaterialShapeDrawable.setShapeAppearanceModel(this.f);
    ((MaterialShapeDrawable)localObject).g(this.c);
    ((MaterialShapeDrawable)localObject).a(this.e, this.d);
    paramTextView.setTextColor(this.b);
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = new RippleDrawable(this.b.withAlpha(30), (Drawable)localObject, localMaterialShapeDrawable);
    }
    ViewCompat.setBackground(paramTextView, new InsetDrawable((Drawable)localObject, this.a.left, this.a.top, this.a.right, this.a.bottom));
  }
  
  int b()
  {
    return this.a.bottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarItemStyle
 * JD-Core Version:    0.7.0.1
 */