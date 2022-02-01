package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import rrt;

public class SocializeFeedsInfo$UGCVoiceInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<UGCVoiceInfo> CREATOR = new rrt();
  public int duration;
  public int fileSize;
  public boolean isPlaying;
  public String voiceUrl;
  
  public SocializeFeedsInfo$UGCVoiceInfo() {}
  
  public SocializeFeedsInfo$UGCVoiceInfo(Parcel paramParcel)
  {
    this.voiceUrl = paramParcel.readString();
    this.duration = paramParcel.readInt();
    this.fileSize = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.voiceUrl);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.fileSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo
 * JD-Core Version:    0.7.0.1
 */