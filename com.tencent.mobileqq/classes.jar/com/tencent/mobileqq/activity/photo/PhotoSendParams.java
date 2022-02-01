package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class PhotoSendParams
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PhotoSendParams> CREATOR = new PhotoSendParams.1();
  public static final int SEND_PIC_NORMAL = 0;
  public static final int SEND_PIC_QZONE = 1;
  public long fileSize;
  public int picType = 0;
  public String rawDownloadUrl;
  public int rawHeight;
  public String rawMd5;
  public String rawPicPath;
  public int rawWidth;
  public String thumbPath;
  
  public PhotoSendParams(Parcel paramParcel)
  {
    this.thumbPath = paramParcel.readString();
    this.rawMd5 = paramParcel.readString();
    this.rawPicPath = paramParcel.readString();
    this.fileSize = paramParcel.readLong();
    this.rawHeight = paramParcel.readInt();
    this.rawWidth = paramParcel.readInt();
    this.rawDownloadUrl = paramParcel.readString();
    this.picType = paramParcel.readInt();
  }
  
  public PhotoSendParams(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    this.thumbPath = paramString1;
    this.rawMd5 = paramString2;
    this.rawPicPath = paramString3;
    this.fileSize = paramLong;
    this.rawHeight = paramInt1;
    this.rawWidth = paramInt2;
    this.rawDownloadUrl = paramString4;
    this.picType = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoSendParams:");
    localStringBuilder.append("&thumbPath:");
    localStringBuilder.append(this.thumbPath);
    localStringBuilder.append(" &rawMd5:");
    localStringBuilder.append(this.rawMd5);
    localStringBuilder.append(" &rawPicPath:");
    localStringBuilder.append(this.rawPicPath);
    localStringBuilder.append(" &rawHeight:");
    localStringBuilder.append(this.rawHeight);
    localStringBuilder.append(" &rawWidth:");
    localStringBuilder.append(this.rawWidth);
    localStringBuilder.append(" &rawDownloadUrl:");
    localStringBuilder.append(this.rawDownloadUrl);
    localStringBuilder.append(" &picType:");
    localStringBuilder.append(this.picType);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeString(this.rawMd5);
    paramParcel.writeString(this.rawPicPath);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeInt(this.rawHeight);
    paramParcel.writeInt(this.rawWidth);
    paramParcel.writeString(this.rawDownloadUrl);
    paramParcel.writeInt(this.picType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoSendParams
 * JD-Core Version:    0.7.0.1
 */