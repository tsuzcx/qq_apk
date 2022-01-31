package com.tencent.biz.pubaccount.readinjoy.magic.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.util.Locale;
import ooc;

public class AndroidPs
  implements Parcelable
{
  public static final Parcelable.Creator<AndroidPs> CREATOR = new ooc();
  public final String a;
  public final int b;
  
  public AndroidPs(int paramInt)
  {
    this.b = paramInt;
    this.a = a(paramInt);
  }
  
  public AndroidPs(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  private String a(int paramInt)
  {
    try
    {
      String str = PFile.readFile(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) })).trim();
      return str;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public CgF a()
  {
    return CgF.get(this.b);
  }
  
  public Status a()
  {
    return Status.get(this.b);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AndroidPs)paramObject;
      if (this.a != null) {
        return this.a.equals(paramObject.a);
      }
    } while (paramObject.a == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidPs
 * JD-Core Version:    0.7.0.1
 */