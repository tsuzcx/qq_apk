package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class b
  extends h
{
  public static final Parcelable.Creator<b> CREATOR = new b.1();
  public final byte[] a;
  
  b(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.a = paramParcel.createByteArray();
  }
  
  public b(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.a = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (b)paramObject;
      return (this.f.equals(paramObject.f)) && (Arrays.equals(this.a, paramObject.a));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.f.hashCode()) * 31 + Arrays.hashCode(this.a);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.f);
    paramParcel.writeByteArray(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.b
 * JD-Core Version:    0.7.0.1
 */