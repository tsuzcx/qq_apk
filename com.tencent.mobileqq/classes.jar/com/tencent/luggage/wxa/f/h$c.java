package com.tencent.luggage.wxa.f;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.core.os.ParcelableCompat;

public class h$c
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<c> CREATOR = ParcelableCompat.newCreator(new h.c.1());
  int a;
  a b;
  boolean c;
  int d;
  float e;
  float f;
  int g;
  boolean h;
  q i;
  int j;
  float k;
  
  public h$c(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
    this.b = ((a)paramParcel.readParcelable(paramClassLoader));
    int m = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (m != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    this.i = ((q)paramParcel.readParcelable(paramClassLoader));
    this.j = paramParcel.readInt();
    this.k = paramParcel.readFloat();
  }
  
  public h$c(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, 0);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeParcelable(this.i, paramInt);
    paramParcel.writeInt(this.j);
    paramParcel.writeFloat(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.h.c
 * JD-Core Version:    0.7.0.1
 */