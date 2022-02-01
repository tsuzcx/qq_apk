package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SendInfo> CREATOR = new SendInfo.1();
  private String a;
  private String b;
  private long c;
  private int d;
  
  private SendInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readInt();
  }
  
  private boolean a(SendInfo paramSendInfo)
  {
    return (this.a.equals(paramSendInfo.a)) && (this.b.equals(paramSendInfo.b)) && (this.c == paramSendInfo.c) && (this.d == paramSendInfo.d);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
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
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof SendInfo))) {
      return a((SendInfo)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    return localStringBuilder.toString().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.file.SendInfo
 * JD-Core Version:    0.7.0.1
 */