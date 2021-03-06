package com.tencent.component.network.downloader.impl.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class QzoneResumeTransfer$CacheFileAttribute
  implements Parcelable
{
  public static final Parcelable.Creator<CacheFileAttribute> CREATOR = new QzoneResumeTransfer.CacheFileAttribute.1();
  public String ContentEncoding;
  public String ContentType;
  public String LastModifyTime;
  
  public QzoneResumeTransfer$CacheFileAttribute(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.ContentType = paramParcel.readString();
    this.LastModifyTime = paramParcel.readString();
    this.ContentEncoding = paramParcel.readString();
  }
  
  public QzoneResumeTransfer$CacheFileAttribute(String paramString1, String paramString2, String paramString3)
  {
    this.ContentType = paramString1;
    this.LastModifyTime = paramString2;
    this.ContentEncoding = paramString3;
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
    if ((paramObject != null) && ((paramObject instanceof CacheFileAttribute)))
    {
      paramObject = (CacheFileAttribute)paramObject;
      return (TextUtils.equals(this.ContentType, paramObject.ContentType)) && (TextUtils.equals(this.LastModifyTime, paramObject.LastModifyTime)) && (TextUtils.equals(this.ContentEncoding, paramObject.ContentEncoding));
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CacheFileAttr --- ContentType:");
    localStringBuilder.append(this.ContentType);
    localStringBuilder.append(" LastModify:");
    localStringBuilder.append(this.LastModifyTime);
    localStringBuilder.append(" ContentEncoding:");
    localStringBuilder.append(this.ContentEncoding);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.ContentType);
    paramParcel.writeString(this.LastModifyTime);
    paramParcel.writeString(this.ContentEncoding);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer.CacheFileAttribute
 * JD-Core Version:    0.7.0.1
 */