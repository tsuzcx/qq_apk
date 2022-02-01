package com.tencent.luggage.wxa.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.m;

public final class a
  extends b
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public final long a;
  public final long b;
  public final byte[] c;
  
  private a(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.a = paramLong2;
    this.b = paramLong1;
    this.c = paramArrayOfByte;
  }
  
  private a(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readLong();
    this.c = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.c);
  }
  
  static a a(m paramm, int paramInt, long paramLong)
  {
    long l = paramm.l();
    byte[] arrayOfByte = new byte[paramInt - 4];
    paramm.a(arrayOfByte, 0, arrayOfByte.length);
    return new a(l, arrayOfByte, paramLong);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeInt(this.c.length);
    paramParcel.writeByteArray(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.a
 * JD-Core Version:    0.7.0.1
 */