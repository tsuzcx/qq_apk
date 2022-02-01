package com.tencent.mm.ui.widget.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class MMProgressWheel$WheelSavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<WheelSavedState> CREATOR = new MMProgressWheel.WheelSavedState.1();
  float a;
  float b;
  boolean c;
  float d;
  int e;
  int f;
  int g;
  int h;
  int i;
  boolean j;
  boolean k;
  
  private MMProgressWheel$WheelSavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
    int m = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (m != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.k = bool1;
  }
  
  MMProgressWheel$WheelSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeByte((byte)this.j);
    paramParcel.writeByte((byte)this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel.WheelSavedState
 * JD-Core Version:    0.7.0.1
 */