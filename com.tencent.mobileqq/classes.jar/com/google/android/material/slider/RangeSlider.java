package com.google.android.material.slider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider
  extends BaseSlider<RangeSlider, RangeSlider.OnChangeListener, RangeSlider.OnSliderTouchListener>
{
  private float a;
  private int b;
  
  public RangeSlider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RangeSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.H);
  }
  
  public RangeSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.am, paramInt, jdField_a_of_type_Int, new int[0]);
    if (paramContext.hasValue(R.styleable.dQ))
    {
      paramInt = paramContext.getResourceId(R.styleable.dQ, 0);
      setValues(a(paramContext.getResources().obtainTypedArray(paramInt)));
    }
    this.jdField_a_of_type_Float = paramContext.getDimension(R.styleable.dP, 0.0F);
    paramContext.recycle();
  }
  
  private static List<Float> a(TypedArray paramTypedArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramTypedArray.length())
    {
      localArrayList.add(Float.valueOf(paramTypedArray.getFloat(i, -1.0F)));
      i += 1;
    }
    return localArrayList;
  }
  
  @NonNull
  public List<Float> a()
  {
    return super.a();
  }
  
  public float c()
  {
    return this.jdField_a_of_type_Float;
  }
  
  protected void onRestoreInstanceState(@Nullable Parcelable paramParcelable)
  {
    paramParcelable = (RangeSlider.RangeSliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.jdField_a_of_type_Float = RangeSlider.RangeSliderState.a(paramParcelable);
    this.b = RangeSlider.RangeSliderState.a(paramParcelable);
    b(this.b);
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    RangeSlider.RangeSliderState localRangeSliderState = new RangeSlider.RangeSliderState(super.onSaveInstanceState());
    RangeSlider.RangeSliderState.a(localRangeSliderState, this.jdField_a_of_type_Float);
    RangeSlider.RangeSliderState.a(localRangeSliderState, this.b);
    return localRangeSliderState;
  }
  
  public void setMinSeparation(@Dimension float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.b = 0;
    b(this.b);
  }
  
  public void setMinSeparationValue(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.b = 1;
    b(this.b);
  }
  
  public void setValues(@NonNull List<Float> paramList)
  {
    super.setValues(paramList);
  }
  
  public void setValues(@NonNull Float... paramVarArgs)
  {
    super.setValues(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.slider.RangeSlider
 * JD-Core Version:    0.7.0.1
 */