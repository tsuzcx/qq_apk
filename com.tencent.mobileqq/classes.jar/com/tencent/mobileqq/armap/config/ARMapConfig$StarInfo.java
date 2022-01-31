package com.tencent.mobileqq.armap.config;

import aaxv;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ARMapConfig$StarInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new aaxv();
  public String ShareContent;
  public String ShareSummary;
  public String ShareTitle;
  public String StarName;
  public int starId;
  public ARMapConfig.ResInfo starResInfo;
  
  public ARMapConfig$StarInfo() {}
  
  public ARMapConfig$StarInfo(Parcel paramParcel)
  {
    this.starId = paramParcel.readInt();
    this.StarName = paramParcel.readString();
    this.ShareTitle = paramParcel.readString();
    this.ShareSummary = paramParcel.readString();
    this.ShareContent = paramParcel.readString();
    this.ShareTitle = paramParcel.readString();
    this.starResInfo = ((ARMapConfig.ResInfo)paramParcel.readParcelable(ARMapConfig.ResInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StarInfo::");
    localStringBuilder.append("starId = ").append(this.starId).append(", StarName = ").append(this.StarName).append(", ShareTitle = ").append(this.ShareTitle).append(", ShareSummary = ").append(this.ShareSummary).append(", ShareContent = ").append(this.ShareContent).append(", starResInfo = ").append(this.starResInfo);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.starId);
    paramParcel.writeString(this.StarName);
    paramParcel.writeString(this.ShareTitle);
    paramParcel.writeString(this.ShareSummary);
    paramParcel.writeString(this.ShareContent);
    paramParcel.writeString(this.ShareTitle);
    paramParcel.writeParcelable(this.starResInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapConfig.StarInfo
 * JD-Core Version:    0.7.0.1
 */