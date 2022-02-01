package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;

public final class k
  extends h
{
  public static final Parcelable.Creator<k> CREATOR = new k.1();
  public final String a;
  public final String b;
  
  k(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.a = paramString2;
    this.b = paramString3;
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
      paramObject = (k)paramObject;
      return (this.f.equals(paramObject.f)) && (x.a(this.a, paramObject.a)) && (x.a(this.b, paramObject.b));
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = this.f.hashCode();
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
    return ((527 + k) * 31 + i) * 31 + j;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.k
 * JD-Core Version:    0.7.0.1
 */