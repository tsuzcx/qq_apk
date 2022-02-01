package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import rrc;

public class SocializeFeedsInfo$JumpInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<JumpInfo> CREATOR = new rrc();
  private final long id;
  private final String jumpUrl;
  private final String wording;
  
  public SocializeFeedsInfo$JumpInfo(long paramLong, String paramString1, String paramString2)
  {
    this.id = paramLong;
    this.wording = paramString1;
    this.jumpUrl = paramString2;
  }
  
  public SocializeFeedsInfo$JumpInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.wording = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getJumpUrl()
  {
    if (this.jumpUrl != null) {
      return this.jumpUrl;
    }
    return "";
  }
  
  public String getWording()
  {
    if (this.wording != null) {
      return this.wording;
    }
    return "";
  }
  
  public String toString()
  {
    return "JumpInfo{id=" + this.id + ", wording='" + this.wording + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.wording);
    paramParcel.writeString(this.jumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo
 * JD-Core Version:    0.7.0.1
 */