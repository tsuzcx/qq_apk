package com.tencent.avgame.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UserInfo> CREATOR = new UserInfo.1();
  public int a;
  public String b;
  public String c;
  public boolean d;
  public int e;
  public int f;
  public String g;
  
  protected UserInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
  }
  
  public UserInfo(String paramString)
  {
    this.a = 0;
    this.b = paramString;
    this.c = null;
    this.d = false;
    this.e = 0;
    this.f = 0;
    this.g = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isFriend: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", age: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", gender: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", head: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.UserInfo
 * JD-Core Version:    0.7.0.1
 */