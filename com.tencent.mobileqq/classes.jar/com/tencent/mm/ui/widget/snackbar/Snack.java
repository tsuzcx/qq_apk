package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR = new Snack.1();
  final String a;
  final String b;
  final int c;
  final Parcelable d;
  final short e;
  final int f;
  
  Snack(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.e = ((short)paramParcel.readInt());
    this.f = paramParcel.readInt();
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramParcelable;
    this.e = paramShort;
    this.f = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */