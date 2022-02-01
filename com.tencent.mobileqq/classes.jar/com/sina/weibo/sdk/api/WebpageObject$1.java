package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WebpageObject$1
  implements Parcelable.Creator<WebpageObject>
{
  public final WebpageObject createFromParcel(Parcel paramParcel)
  {
    return new WebpageObject(paramParcel);
  }
  
  public final WebpageObject[] newArray(int paramInt)
  {
    return new WebpageObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.WebpageObject.1
 * JD-Core Version:    0.7.0.1
 */