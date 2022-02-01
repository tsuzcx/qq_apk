package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.AbsSavedState;

class RangeSlider$RangeSliderState
  extends AbsSavedState
{
  public static final Parcelable.Creator<RangeSliderState> CREATOR = new RangeSlider.RangeSliderState.1();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  private RangeSlider$RangeSliderState(Parcel paramParcel)
  {
    super(paramParcel.readParcelable(RangeSliderState.class.getClassLoader()));
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  RangeSlider$RangeSliderState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.slider.RangeSlider.RangeSliderState
 * JD-Core Version:    0.7.0.1
 */