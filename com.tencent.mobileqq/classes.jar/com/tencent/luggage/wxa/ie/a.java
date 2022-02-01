package com.tencent.luggage.wxa.ie;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.jj.m;

public final class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public String a;
  public String b;
  public String c;
  public m d;
  
  public a() {}
  
  private a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.d = ((m)paramParcel.readParcelable(m.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.d, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ie.a
 * JD-Core Version:    0.7.0.1
 */