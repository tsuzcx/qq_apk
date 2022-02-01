package com.tencent.luggage.wxa.jd;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class f
  extends a
{
  public static final Parcelable.Creator<f> CREATOR = new f.1();
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  
  public f() {}
  
  public f(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
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
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      bool1 = bool2;
      if (paramObject.b == this.b)
      {
        bool1 = bool2;
        if (paramObject.c == this.c)
        {
          bool1 = bool2;
          if (paramObject.d == this.d)
          {
            bool1 = bool2;
            if (paramObject.e == this.e)
            {
              bool1 = bool2;
              if (paramObject.f == this.f)
              {
                bool1 = bool2;
                if (paramObject.g == this.g) {
                  bool1 = true;
                }
              }
            }
          }
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
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jd.f
 * JD-Core Version:    0.7.0.1
 */