package com.tencent.mobileqq.armap.config;

import aaxu;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ARMapConfig$ResInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new aaxu();
  public static final int POI_TYPE_LBS_DISABLE = 4;
  public static final int POI_TYPE_LBS_DOUBLE = 2;
  public static final int POI_TYPE_LBS_MULTY = 3;
  public static final int POI_TYPE_LBS_SINGLE = 1;
  public static final int POI_TYPE_LBS_TOP = 5;
  public static final int POI_TYPE_NONE = 0;
  public static final int TYPE_RES_COMMON = 1;
  public static final int TYPE_RES_POI = 3;
  public static final int TYPE_RES_SKIN = 2;
  public static final int TYPE_RES_STAR = 5;
  public static final int TYPE_RES_WORDING = 4;
  public int extra = -1;
  public int isPreload = 1;
  public String md5;
  public String url;
  
  public ARMapConfig$ResInfo() {}
  
  public ARMapConfig$ResInfo(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.extra = paramParcel.readInt();
    this.isPreload = paramParcel.readInt();
  }
  
  public ARMapConfig$ResInfo(String paramString1, String paramString2, int paramInt)
  {
    this.url = paramString1;
    this.md5 = paramString2;
    this.extra = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ResInfo::");
    localStringBuilder.append("extra:").append(this.extra).append(",url:").append(this.url).append(" md5:").append(this.md5).append(" isPreload:").append(this.isPreload).append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.extra);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapConfig.ResInfo
 * JD-Core Version:    0.7.0.1
 */