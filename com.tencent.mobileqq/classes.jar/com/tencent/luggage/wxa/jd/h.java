package com.tencent.luggage.wxa.jd;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class h
  extends a
{
  public static final Parcelable.Creator<h> CREATOR = new h.1();
  public float b;
  public float c;
  
  public h() {}
  
  public h(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = super.equals(paramObject);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      bool1 = bool2;
      if (paramObject.b == this.b)
      {
        bool1 = bool2;
        if (paramObject.c == this.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jd.h
 * JD-Core Version:    0.7.0.1
 */