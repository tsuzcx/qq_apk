package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ChatObject$1
  implements Parcelable.Creator<ChatObject>
{
  public final ChatObject createFromParcel(Parcel paramParcel)
  {
    return new ChatObject(paramParcel);
  }
  
  public final ChatObject[] newArray(int paramInt)
  {
    return new ChatObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ChatObject.1
 * JD-Core Version:    0.7.0.1
 */