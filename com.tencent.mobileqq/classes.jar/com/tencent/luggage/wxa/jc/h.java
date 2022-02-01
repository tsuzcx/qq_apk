package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class h
  extends a
{
  public static final Parcelable.Creator<h> CREATOR = new h.1();
  public String b;
  public float c;
  public float d;
  public float e;
  
  public h() {}
  
  public h(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readString();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
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
    if (!(paramObject instanceof h)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (h)paramObject;
    return (Float.compare(paramObject.c, this.c) == 0) && (Float.compare(paramObject.d, this.d) == 0) && (Float.compare(paramObject.e, this.e) == 0) && (Objects.equals(this.b, paramObject.b));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.b, Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.h
 * JD-Core Version:    0.7.0.1
 */