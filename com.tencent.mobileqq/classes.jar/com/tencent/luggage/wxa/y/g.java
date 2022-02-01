package com.tencent.luggage.wxa.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;

public final class g
  extends b
{
  public static final Parcelable.Creator<g> CREATOR = new g.1();
  public final long a;
  public final long b;
  
  private g(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  static long a(m paramm, long paramLong)
  {
    long l = paramm.g();
    if ((0x80 & l) != 0L) {
      return 0xFFFFFFFF & ((l & 1L) << 32 | paramm.l()) + paramLong;
    }
    return -9223372036854775807L;
  }
  
  static g a(m paramm, long paramLong, u paramu)
  {
    paramLong = a(paramm, paramLong);
    return new g(paramLong, paramu.b(paramLong));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.g
 * JD-Core Version:    0.7.0.1
 */