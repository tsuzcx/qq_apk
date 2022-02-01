package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.AbsSavedState;

class RangeSlider$RangeSliderState
  extends AbsSavedState
{
  public static final Parcelable.Creator<RangeSliderState> CREATOR = new RangeSlider.RangeSliderState.1();
  private float a;
  private int b;
  
  private RangeSlider$RangeSliderState(Parcel paramParcel)
  {
    super(paramParcel.readParcelable(RangeSliderState.class.getClassLoader()));
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readInt();
  }
  
  RangeSlider$RangeSliderState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.RangeSlider.RangeSliderState
 * JD-Core Version:    0.7.0.1
 */