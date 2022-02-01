package com.tencent.luggage.wxa.jc;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;

public class z
  extends a
{
  public static final Parcelable.Creator<z> CREATOR = new z.1();
  public int b;
  public int c;
  public int d;
  public int e;
  public Bitmap f = null;
  
  public z() {}
  
  public z(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = ((Bitmap)paramParcel.readParcelable(z.class.getClassLoader()));
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
    if (!(paramObject instanceof z)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (z)paramObject;
    return (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (Objects.equals(this.f, paramObject.f));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), this.f });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.z
 * JD-Core Version:    0.7.0.1
 */