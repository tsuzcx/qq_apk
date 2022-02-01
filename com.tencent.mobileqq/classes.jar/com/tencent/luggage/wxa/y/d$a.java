package com.tencent.luggage.wxa.y;

import android.os.Parcel;

public final class d$a
{
  public final int a;
  public final long b;
  public final long c;
  
  private d$a(int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public static a b(Parcel paramParcel)
  {
    return new a(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong());
  }
  
  public void a(Parcel paramParcel)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.d.a
 * JD-Core Version:    0.7.0.1
 */