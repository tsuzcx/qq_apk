package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;

public final class c
  extends h
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  public final String a;
  public final int b;
  public final int c;
  public final long d;
  public final long e;
  private final h[] g;
  
  c(Parcel paramParcel)
  {
    super("CHAP");
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.g = new h[j];
    int i = 0;
    while (i < j)
    {
      this.g[i] = ((h)paramParcel.readParcelable(h.class.getClassLoader()));
      i += 1;
    }
  }
  
  public c(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, h[] paramArrayOfh)
  {
    super("CHAP");
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong1;
    this.e = paramLong2;
    this.g = paramArrayOfh;
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
      paramObject = (c)paramObject;
      return (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (x.a(this.a, paramObject.a)) && (Arrays.equals(this.g, paramObject.g));
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.b;
    int k = this.c;
    int m = (int)this.d;
    int n = (int)this.e;
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return ((((527 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeInt(this.g.length);
    h[] arrayOfh = this.g;
    int i = arrayOfh.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfh[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.c
 * JD-Core Version:    0.7.0.1
 */