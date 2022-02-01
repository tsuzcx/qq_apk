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
  private float b;
  private int c;
  
  public RangeSlider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RangeSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.P);
  }
  
  public RangeSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.fN, paramInt, a, new int[0]);
    if (paramContext.hasValue(R.styleable.fP))
    {
      paramInt = paramContext.getResourceId(R.styleable.fP, 0);
      setValues(a(paramContext.getResources().obtainTypedArray(paramInt)));
    }
    this.b = paramContext.getDimension(R.styleable.fO, 0.0F);
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
  
  public float getMinSeparation()
  {
    return this.b;
  }
  
  @NonNull
  public List<Float> getValues()
  {
    return super.getValues();
  }
  
  protected void onRestoreInstanceState(@Nullable Parcelable paramParcelable)
  {
    paramParcelable = (RangeSlider.RangeSliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.b = RangeSlider.RangeSliderState.a(paramParcelable);
    this.c = RangeSlider.RangeSliderState.b(paramParcelable);
    setSeparationUnit(this.c);
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    RangeSlider.RangeSliderState localRangeSliderState = new RangeSlider.RangeSliderState(super.onSaveInstanceState());
    RangeSlider.RangeSliderState.a(localRangeSliderState, this.b);
    RangeSlider.RangeSliderState.a(localRangeSliderState, this.c);
    return localRangeSliderState;
  }
  
  public void setMinSeparation(@Dimension float paramFloat)
  {
    this.b = paramFloat;
    this.c = 0;
    setSeparationUnit(this.c);
  }
  
  public void setMinSeparationValue(float paramFloat)
  {
    this.b = paramFloat;
    this.c = 1;
    setSeparationUnit(this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.RangeSlider
 * JD-Core Version:    0.7.0.1
 */