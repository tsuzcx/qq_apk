package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class WebpageObject
  extends MediaObject
{
  public static final Parcelable.Creator<WebpageObject> CREATOR = new WebpageObject.1();
  private static final long serialVersionUID = 7142128794153927442L;
  public String defaultText;
  
  public WebpageObject() {}
  
  public WebpageObject(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.api.WebpageObject
 * JD-Core Version:    0.7.0.1
 */