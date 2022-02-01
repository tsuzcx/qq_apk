package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.annotation.NonNull;
import java.util.ArrayList;

class BaseSlider$SliderState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SliderState> CREATOR = new BaseSlider.SliderState.1();
  float a;
  float b;
  ArrayList<Float> c;
  float d;
  boolean e;
  
  private BaseSlider$SliderState(@NonNull Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
    this.c = new ArrayList();
    paramParcel.readList(this.c, Float.class.getClassLoader());
    this.d = paramParcel.readFloat();
    this.e = paramParcel.createBooleanArray()[0];
  }
  
  BaseSlider$SliderState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeList(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeBooleanArray(new boolean[] { this.e });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.SliderState
 * JD-Core Version:    0.7.0.1
 */