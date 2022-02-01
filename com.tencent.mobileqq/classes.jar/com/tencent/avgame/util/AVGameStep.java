package com.tencent.avgame.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AVGameStep
  implements Parcelable
{
  public static final Parcelable.Creator<AVGameStep> CREATOR = new AVGameStep.1();
  public String a;
  public long b;
  public long c;
  public int d;
  
  protected AVGameStep(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readInt();
  }
  
  public AVGameStep(String paramString)
  {
    this.a = paramString;
    c();
  }
  
  public boolean a()
  {
    return this.b != 0L;
  }
  
  public boolean b()
  {
    return (this.b != 0L) && (this.c != 0L);
  }
  
  public void c()
  {
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVGameStep{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameStep
 * JD-Core Version:    0.7.0.1
 */