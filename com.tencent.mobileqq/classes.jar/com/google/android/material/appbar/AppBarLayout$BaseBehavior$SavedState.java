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
  int a;
  float b;
  boolean c;
  
  public AppBarLayout$BaseBehavior$SavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.a = paramParcel.readInt();
    this.b = paramParcel.readFloat();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
  }
  
  public AppBarLayout$BaseBehavior$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeByte((byte)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState
 * JD-Core Version:    0.7.0.1
 */