package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MediaObject$1
  implements Parcelable.Creator<MediaObject>
{
  public final MediaObject createFromParcel(Parcel paramParcel)
  {
    return new MediaObject(paramParcel);
  }
  
  public final MediaObject[] newArray(int paramInt)
  {
    return new MediaObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.MediaObject.1
 * JD-Core Version:    0.7.0.1
 */