package com.tencent.luggage.wxa.az;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new b.1();
  private long a;
  private String b;
  private String c;
  
  public b(long paramLong, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  protected b(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public String a()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return ((b)paramObject).a().equalsIgnoreCase(a());
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.az.b
 * JD-Core Version:    0.7.0.1
 */