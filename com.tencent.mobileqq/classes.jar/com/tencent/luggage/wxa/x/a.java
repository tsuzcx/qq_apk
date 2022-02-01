package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;

public final class a
  extends h
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public final String a;
  public final String b;
  public final int c;
  public final byte[] d;
  
  a(Parcel paramParcel)
  {
    super("APIC");
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.createByteArray();
  }
  
  public a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramArrayOfByte;
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
      return (this.c == paramObject.c) && (x.a(this.a, paramObject.a)) && (x.a(this.b, paramObject.b)) && (Arrays.equals(this.d, paramObject.d));
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = this.c;
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
    return (((527 + k) * 31 + i) * 31 + j) * 31 + Arrays.hashCode(this.d);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeByteArray(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.a
 * JD-Core Version:    0.7.0.1
 */