package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageInfo$1
  implements Parcelable.Creator<ImageInfo>
{
  public ImageInfo a(Parcel paramParcel)
  {
    return new ImageInfo(paramParcel, null);
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.file.ImageInfo.1
 * JD-Core Version:    0.7.0.1
 */