package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class l
  extends a
{
  public static final Parcelable.Creator<l> CREATOR = new l.1();
  public float b;
  
  public l() {}
  
  public l(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readFloat();
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
    if (!(paramObject instanceof l)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    return Float.compare(((l)paramObject).b, this.b) == 0;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.b) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.l
 * JD-Core Version:    0.7.0.1
 */