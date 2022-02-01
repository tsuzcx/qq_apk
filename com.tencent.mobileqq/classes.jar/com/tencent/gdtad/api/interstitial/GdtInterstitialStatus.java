package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class GdtInterstitialStatus
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialStatus> CREATOR = new GdtInterstitialStatus.1();
  public int a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  long m;
  
  public GdtInterstitialStatus()
  {
    this.a = 0;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = -2147483648;
    this.i = -2147483648;
    this.j = -2147483648;
    this.k = -2147483648;
    this.l = 0;
    this.m = -2147483648L;
  }
  
  protected GdtInterstitialStatus(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.a = 0;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = -2147483648;
    this.i = -2147483648;
    this.j = -2147483648;
    this.k = -2147483648;
    this.l = 0;
    this.m = -2147483648L;
    this.a = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.g = bool1;
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readLong();
  }
  
  public long a()
  {
    long l2 = this.m;
    long l1 = -2147483648L;
    if (l2 != -2147483648L) {
      l1 = System.currentTimeMillis() - this.m;
    }
    return l1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeLong(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialStatus
 * JD-Core Version:    0.7.0.1
 */