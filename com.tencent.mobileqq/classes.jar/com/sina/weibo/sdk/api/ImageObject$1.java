package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageObject$1
  implements Parcelable.Creator<ImageObject>
{
  public final ImageObject createFromParcel(Parcel paramParcel)
  {
    return new ImageObject(paramParcel);
  }
  
  public final ImageObject[] newArray(int paramInt)
  {
    return new ImageObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ImageObject.1
 * JD-Core Version:    0.7.0.1
 */