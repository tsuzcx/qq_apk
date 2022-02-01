package com.tencent.luggage.wxa.f;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class q$1
  implements Parcelable.Creator<q>
{
  public q a(Parcel paramParcel)
  {
    return new q(paramParcel.readInt(), paramParcel.readInt());
  }
  
  public q[] a(int paramInt)
  {
    return new q[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.q.1
 * JD-Core Version:    0.7.0.1
 */