package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;

public final class f
  extends h
{
  public static final Parcelable.Creator<f> CREATOR = new f.1();
  public final String a;
  public final String b;
  public final String c;
  public final byte[] d;
  
  f(Parcel paramParcel)
  {
    super("GEOB");
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.createByteArray();
  }
  
  public f(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super("GEOB");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
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
      paramObject = (f)paramObject;
      return (x.a(this.a, paramObject.a)) && (x.a(this.b, paramObject.b)) && (x.a(this.c, paramObject.c)) && (Arrays.equals(this.d, paramObject.d));
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.c;
    if (str != null) {
      k = str.hashCode();
    }
    return (((527 + i) * 31 + j) * 31 + k) * 31 + Arrays.hashCode(this.d);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByteArray(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.f
 * JD-Core Version:    0.7.0.1
 */