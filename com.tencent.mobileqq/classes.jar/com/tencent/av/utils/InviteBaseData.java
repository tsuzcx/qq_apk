package com.tencent.av.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InviteBaseData
  implements Parcelable
{
  public static final Parcelable.Creator<InviteBaseData> CREATOR = new InviteBaseData.1();
  public String a;
  public int b;
  public String c;
  public String d;
  public int e = 0;
  public String f = "-1";
  
  public InviteBaseData() {}
  
  protected InviteBaseData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",phone=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.InviteBaseData
 * JD-Core Version:    0.7.0.1
 */