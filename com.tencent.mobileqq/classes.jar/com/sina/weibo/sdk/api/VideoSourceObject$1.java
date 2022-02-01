package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoSourceObject$1
  implements Parcelable.Creator<VideoSourceObject>
{
  public final VideoSourceObject createFromParcel(Parcel paramParcel)
  {
    return new VideoSourceObject(paramParcel);
  }
  
  public final VideoSourceObject[] newArray(int paramInt)
  {
    return new VideoSourceObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.api.VideoSourceObject.1
 * JD-Core Version:    0.7.0.1
 */