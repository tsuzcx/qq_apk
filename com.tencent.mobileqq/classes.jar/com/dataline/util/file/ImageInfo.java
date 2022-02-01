package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ImageInfo> CREATOR = new ImageInfo.1();
  private String a;
  private String b;
  private long c;
  private long d;
  private String e;
  
  private ImageInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readString();
  }
  
  private boolean a(ImageInfo paramImageInfo)
  {
    return (this.b.equals(paramImageInfo.b)) && (this.c == paramImageInfo.c) && (this.d == paramImageInfo.d) && (this.a.equals(paramImageInfo.a));
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
    if ((paramObject != null) && ((paramObject instanceof ImageInfo))) {
      return a((ImageInfo)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.d);
    return localStringBuilder.toString().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.file.ImageInfo
 * JD-Core Version:    0.7.0.1
 */