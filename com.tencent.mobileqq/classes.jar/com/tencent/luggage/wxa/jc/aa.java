package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class aa
  extends a
{
  public static final Parcelable.Creator<aa> CREATOR = new aa.1();
  public float b;
  public float c;
  public float d;
  public int e;
  
  public aa() {}
  
  public aa(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readInt();
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
    if (!(paramObject instanceof aa)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (aa)paramObject;
    return (Float.compare(paramObject.b, this.b) == 0) && (Float.compare(paramObject.c, this.c) == 0) && (Float.compare(paramObject.d, this.d) == 0) && (this.e == paramObject.e);
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d), Integer.valueOf(this.e) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.aa
 * JD-Core Version:    0.7.0.1
 */