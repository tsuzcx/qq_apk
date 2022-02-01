package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class f
  extends a
{
  public static final Parcelable.Creator<f> CREATOR = new f.1();
  public int b;
  public String c;
  public float d;
  public float e;
  public float f;
  public float g;
  public int h;
  public int i;
  public int j;
  public int k;
  
  public f() {}
  
  public f(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
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
    if (!(paramObject instanceof f)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (f)paramObject;
    return (this.b == paramObject.b) && (Float.compare(paramObject.d, this.d) == 0) && (Float.compare(paramObject.e, this.e) == 0) && (Float.compare(paramObject.f, this.f) == 0) && (Float.compare(paramObject.g, this.g) == 0) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (this.k == paramObject.k) && (Objects.equals(this.c, paramObject.c));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.b), this.c, Float.valueOf(this.d), Float.valueOf(this.e), Float.valueOf(this.f), Float.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeFloat(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.f
 * JD-Core Version:    0.7.0.1
 */