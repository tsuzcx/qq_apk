package com.tencent.luggage.wxa.ap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new b.1();
  public final int a;
  public final int b;
  public final int c;
  public final byte[] d;
  private int e;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramArrayOfByte;
  }
  
  b(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    int i;
    if (paramParcel.readInt() != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramParcel = paramParcel.createByteArray();
    } else {
      paramParcel = null;
    }
    this.d = paramParcel;
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
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c)) {
        return Arrays.equals(this.d, paramObject.d);
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.e == 0) {
      this.e = ((((527 + this.a) * 31 + this.b) * 31 + this.c) * 31 + Arrays.hashCode(this.d));
    }
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorInfo(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    if (this.d != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramParcel.writeInt(paramInt);
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.b
 * JD-Core Version:    0.7.0.1
 */