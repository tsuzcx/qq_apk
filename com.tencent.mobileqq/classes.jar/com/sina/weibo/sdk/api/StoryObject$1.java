package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class StoryObject$1
  implements Parcelable.Creator<StoryObject>
{
  public final StoryObject createFromParcel(Parcel paramParcel)
  {
    return new StoryObject(paramParcel);
  }
  
  public final StoryObject[] newArray(int paramInt)
  {
    return new StoryObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.StoryObject.1
 * JD-Core Version:    0.7.0.1
 */