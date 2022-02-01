package com.tencent.luggage.wxa.hu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new b.1();
  public int a;
  
  public b() {}
  
  public b(int paramInt)
  {
    this.a = paramInt;
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
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      return this.a == paramObject.a;
    }
    if ((paramObject instanceof Integer)) {
      return paramObject.equals(Integer.valueOf(this.a));
    }
    return false;
  }
  
  public String toString()
  {
    return Integer.toString(this.a);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hu.b
 * JD-Core Version:    0.7.0.1
 */