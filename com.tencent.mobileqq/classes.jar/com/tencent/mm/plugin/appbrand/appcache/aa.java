package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ny.c;

public class aa
  implements Parcelable, c
{
  public static final Parcelable.Creator<aa> CREATOR = new aa.1();
  public int a = 0;
  public long b = -1L;
  public long c = -1L;
  
  public aa() {}
  
  public aa(int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  protected aa(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaPkgLoadProgress{progress=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", writtenLength=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", totalLength=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */