package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TextObject$1
  implements Parcelable.Creator<TextObject>
{
  public final TextObject createFromParcel(Parcel paramParcel)
  {
    return new TextObject(paramParcel);
  }
  
  public final TextObject[] newArray(int paramInt)
  {
    return new TextObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.TextObject.1
 * JD-Core Version:    0.7.0.1
 */