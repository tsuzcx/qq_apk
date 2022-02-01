package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class ae
  extends a
{
  public static final Parcelable.Creator<ae> CREATOR = new ae.1();
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  
  public ae() {}
  
  public ae(Parcel paramParcel)
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
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ae)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (ae)paramObject;
    return (Float.compare(paramObject.b, this.b) == 0) && (Float.compare(paramObject.c, this.c) == 0) && (Float.compare(paramObject.d, this.d) == 0) && (Float.compare(paramObject.e, this.e) == 0) && (Float.compare(paramObject.f, this.f) == 0) && (Float.compare(paramObject.g, this.g) == 0);
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e), Float.valueOf(this.f), Float.valueOf(this.g) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeFloat(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.ae
 * JD-Core Version:    0.7.0.1
 */