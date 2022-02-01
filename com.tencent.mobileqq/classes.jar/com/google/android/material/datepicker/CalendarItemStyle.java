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
  private final int jdField_a_of_type_Int;
  private final ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private final ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final ColorStateList b;
  private final ColorStateList c;
  
  private CalendarItemStyle(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, ColorStateList paramColorStateList3, int paramInt, ShapeAppearanceModel paramShapeAppearanceModel, @NonNull Rect paramRect)
  {
    Preconditions.checkArgumentNonnegative(paramRect.left);
    Preconditions.checkArgumentNonnegative(paramRect.top);
    Preconditions.checkArgumentNonnegative(paramRect.right);
    Preconditions.checkArgumentNonnegative(paramRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList2;
    this.b = paramColorStateList1;
    this.c = paramColorStateList3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
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
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.S);
    Rect localRect = new Rect(localTypedArray.getDimensionPixelOffset(R.styleable.cL, 0), localTypedArray.getDimensionPixelOffset(R.styleable.cN, 0), localTypedArray.getDimensionPixelOffset(R.styleable.cM, 0), localTypedArray.getDimensionPixelOffset(R.styleable.cO, 0));
    ColorStateList localColorStateList1 = MaterialResources.a(paramContext, localTypedArray, R.styleable.cP);
    ColorStateList localColorStateList2 = MaterialResources.a(paramContext, localTypedArray, R.styleable.cU);
    ColorStateList localColorStateList3 = MaterialResources.a(paramContext, localTypedArray, R.styleable.cS);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.cT, 0);
    paramContext = ShapeAppearanceModel.a(paramContext, localTypedArray.getResourceId(R.styleable.cQ, 0), localTypedArray.getResourceId(R.styleable.cR, 0)).a();
    localTypedArray.recycle();
    return new CalendarItemStyle(localColorStateList1, localColorStateList2, localColorStateList3, paramInt, paramContext, localRect);
  }
  
  int a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
  
  void a(@NonNull TextView paramTextView)
  {
    Object localObject = new MaterialShapeDrawable();
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    ((MaterialShapeDrawable)localObject).setShapeAppearanceModel(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    localMaterialShapeDrawable.setShapeAppearanceModel(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    ((MaterialShapeDrawable)localObject).g(this.b);
    ((MaterialShapeDrawable)localObject).a(this.jdField_a_of_type_Int, this.c);
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = new RippleDrawable(this.jdField_a_of_type_AndroidContentResColorStateList.withAlpha(30), (Drawable)localObject, localMaterialShapeDrawable);
    }
    ViewCompat.setBackground(paramTextView, new InsetDrawable((Drawable)localObject, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom));
  }
  
  int b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarItemStyle
 * JD-Core Version:    0.7.0.1
 */