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
  float jdField_a_of_type_Float;
  ArrayList<Float> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  float b;
  float c;
  
  private BaseSlider$SliderState(@NonNull Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, Float.class.getClassLoader());
    this.c = paramParcel.readFloat();
    this.jdField_a_of_type_Boolean = paramParcel.createBooleanArray()[0];
  }
  
  BaseSlider$SliderState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.b);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeFloat(this.c);
    paramParcel.writeBooleanArray(new boolean[] { this.jdField_a_of_type_Boolean });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.SliderState
 * JD-Core Version:    0.7.0.1
 */