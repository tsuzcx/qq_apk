package com.tencent.luggage.wxa.w;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.v.a.a;
import java.util.Arrays;

public final class a
  implements a.a
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public final String a;
  public final String b;
  public final long c;
  public final long d;
  public final byte[] e;
  private int f;
  
  a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.createByteArray();
  }
  
  public a(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramArrayOfByte;
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
      paramObject = (a)paramObject;
      return (this.c == paramObject.c) && (this.d == paramObject.d) && (x.a(this.a, paramObject.a)) && (x.a(this.b, paramObject.b)) && (Arrays.equals(this.e, paramObject.e));
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.f == 0)
    {
      String str = this.a;
      int j = 0;
      int i;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.b;
      if (str != null) {
        j = str.hashCode();
      }
      long l = this.c;
      int k = (int)(l ^ l >>> 32);
      l = this.d;
      this.f = (((((527 + i) * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32)) * 31 + Arrays.hashCode(this.e));
    }
    return this.f;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeByteArray(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.w.a
 * JD-Core Version:    0.7.0.1
 */