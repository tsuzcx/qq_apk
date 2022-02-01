package com.tencent.luggage.wxa.y;

import android.os.Parcel;

public final class f$a
{
  public final int a;
  public final long b;
  
  private f$a(int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.b = paramLong;
  }
  
  private static a b(Parcel paramParcel)
  {
    return new a(paramParcel.readInt(), paramParcel.readLong());
  }
  
  private void c(Parcel paramParcel)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.f.a
 * JD-Core Version:    0.7.0.1
 */