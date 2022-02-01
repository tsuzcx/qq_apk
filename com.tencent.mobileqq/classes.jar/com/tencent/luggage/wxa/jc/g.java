package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class g
  extends a
{
  public static final Parcelable.Creator<g> CREATOR = new g.1();
  public float b;
  public float c;
  public float d;
  public float e;
  
  public g() {}
  
  public g(Parcel paramParcel)
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
    if (!(paramObject instanceof g)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (g)paramObject;
    return (Float.compare(paramObject.b, this.b) == 0) && (Float.compare(paramObject.c, this.c) == 0) && (Float.compare(paramObject.d, this.d) == 0) && (Float.compare(paramObject.e, this.e) == 0);
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.g
 * JD-Core Version:    0.7.0.1
 */