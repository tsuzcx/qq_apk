package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class StoryMessage$1
  implements Parcelable.Creator<StoryMessage>
{
  public final StoryMessage createFromParcel(Parcel paramParcel)
  {
    return new StoryMessage(paramParcel);
  }
  
  public final StoryMessage[] newArray(int paramInt)
  {
    return new StoryMessage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.StoryMessage.1
 * JD-Core Version:    0.7.0.1
 */