package com.tencent.component.media.image;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageUrl$1
  implements Parcelable.Creator<ImageUrl>
{
  public ImageUrl createFromParcel(Parcel paramParcel)
  {
    ImageUrl localImageUrl = new ImageUrl();
    localImageUrl.url = paramParcel.readString();
    localImageUrl.urlKey = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localImageUrl.isSuperResolutionUrl = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localImageUrl.isHighScaleUrl = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localImageUrl.isNetWorkUrl = bool1;
    localImageUrl.urlKeyHashCode = Integer.valueOf(paramParcel.readInt());
    localImageUrl.bigUrl = paramParcel.readString();
    return localImageUrl;
  }
  
  public ImageUrl[] newArray(int paramInt)
  {
    return new ImageUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageUrl.1
 * JD-Core Version:    0.7.0.1
 */