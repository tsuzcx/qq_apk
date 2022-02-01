package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;

public final class e
  extends h
{
  public static final Parcelable.Creator<e> CREATOR = new e.1();
  public final String a;
  public final String b;
  public final String c;
  
  e(Parcel paramParcel)
  {
    super("COMM");
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    super("COMM");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
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
      paramObject = (e)paramObject;
      return (x.a(this.b, paramObject.b)) && (x.a(this.a, paramObject.a)) && (x.a(this.c, paramObject.c));
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
    return ((527 + i) * 31 + j) * 31 + k;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.e
 * JD-Core Version:    0.7.0.1
 */