package com.tencent.luggage.wxa.hu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class c
  implements Parcelable
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  public long a;
  
  public c() {}
  
  public c(long paramLong)
  {
    this.a = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      return this.a == paramObject.a;
    }
    if ((paramObject instanceof Long)) {
      return paramObject.equals(Long.valueOf(this.a));
    }
    return false;
  }
  
  public String toString()
  {
    return Long.toString(this.a);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hu.c
 * JD-Core Version:    0.7.0.1
 */