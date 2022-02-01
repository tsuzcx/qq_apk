package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MultiImageObject$1
  implements Parcelable.Creator<MultiImageObject>
{
  public final MultiImageObject createFromParcel(Parcel paramParcel)
  {
    return new MultiImageObject(paramParcel);
  }
  
  public final MultiImageObject[] newArray(int paramInt)
  {
    return new MultiImageObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.MultiImageObject.1
 * JD-Core Version:    0.7.0.1
 */