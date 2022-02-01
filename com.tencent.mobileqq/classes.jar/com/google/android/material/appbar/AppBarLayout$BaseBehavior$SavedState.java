package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

public class AppBarLayout$BaseBehavior$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new AppBarLayout.BaseBehavior.SavedState.1();
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public AppBarLayout$BaseBehavior$SavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public AppBarLayout$BaseBehavior$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState
 * JD-Core Version:    0.7.0.1
 */