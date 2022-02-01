package com.tencent.luggage.wxa.hu;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b$1
  implements Parcelable.Creator<b>
{
  public b a(Parcel paramParcel)
  {
    b localb = new b();
    localb.a = paramParcel.readInt();
    return localb;
  }
  
  public b[] a(int paramInt)
  {
    return new b[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hu.b.1
 * JD-Core Version:    0.7.0.1
 */