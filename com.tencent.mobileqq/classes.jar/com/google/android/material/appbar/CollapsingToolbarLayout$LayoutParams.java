package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.google.android.material.R.styleable;

public class CollapsingToolbarLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  float jdField_a_of_type_Float = 0.5F;
  int jdField_a_of_type_Int = 0;
  
  public CollapsingToolbarLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public CollapsingToolbarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.p);
    this.jdField_a_of_type_Int = paramContext.getInt(R.styleable.bx, 0);
    a(paramContext.getFloat(R.styleable.by, 0.5F));
    paramContext.recycle();
  }
  
  public CollapsingToolbarLayout$LayoutParams(@NonNull ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */