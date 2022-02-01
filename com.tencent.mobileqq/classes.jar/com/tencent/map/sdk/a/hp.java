package com.tencent.map.sdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

public final class hp
  implements Parcelable
{
  public static final Parcelable.Creator<hp> CREATOR = new hp.1();
  private double a;
  private double b;
  
  public hp(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  private hp(@NonNull Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof hp))
    {
      paramObject = (hp)paramObject;
      if ((this.b == paramObject.b) && (this.a == paramObject.a)) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = Double.doubleToLongBits(this.a);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.hp
 * JD-Core Version:    0.7.0.1
 */