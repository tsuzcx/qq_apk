package com.tencent.luggage.wxa.x;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;

public final class i
  extends h
{
  public static final Parcelable.Creator<i> CREATOR = new i.1();
  public final String a;
  public final byte[] b;
  
  i(Parcel paramParcel)
  {
    super("PRIV");
    this.a = paramParcel.readString();
    this.b = paramParcel.createByteArray();
  }
  
  public i(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.a = paramString;
    this.b = paramArrayOfByte;
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
      paramObject = (i)paramObject;
      return (x.a(this.a, paramObject.a)) && (Arrays.equals(this.b, paramObject.b));
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (527 + i) * 31 + Arrays.hashCode(this.b);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeByteArray(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.x.i
 * JD-Core Version:    0.7.0.1
 */