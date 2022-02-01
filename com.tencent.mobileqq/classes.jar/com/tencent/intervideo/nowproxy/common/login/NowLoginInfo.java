package com.tencent.intervideo.nowproxy.common.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NowLoginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<NowLoginInfo> CREATOR = new NowLoginInfo.1();
  public String __client_type;
  public String appid;
  public String ilive_a2;
  public String ilive_tinyid;
  public long ilive_uin;
  public long lastLoginTime = 0L;
  public int loginType;
  
  public NowLoginInfo() {}
  
  public NowLoginInfo(Parcel paramParcel)
  {
    this.appid = paramParcel.readString();
    this.__client_type = paramParcel.readString();
    this.ilive_uin = paramParcel.readLong();
    this.ilive_a2 = paramParcel.readString();
    this.ilive_tinyid = paramParcel.readString();
    this.loginType = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appid);
    paramParcel.writeString(this.__client_type);
    paramParcel.writeLong(this.ilive_uin);
    paramParcel.writeString(this.ilive_a2);
    paramParcel.writeString(this.ilive_tinyid);
    paramParcel.writeInt(this.loginType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.login.NowLoginInfo
 * JD-Core Version:    0.7.0.1
 */