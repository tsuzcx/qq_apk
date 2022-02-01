package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ChatObject
  extends MediaObject
{
  public static final Parcelable.Creator<ChatObject> CREATOR = new ChatObject.1();
  public String content;
  public String image_url;
  public String summary;
  public String url;
  
  public ChatObject() {}
  
  protected ChatObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.url = paramParcel.readString();
    this.content = paramParcel.readString();
    this.image_url = paramParcel.readString();
    this.summary = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.image_url);
    paramParcel.writeString(this.summary);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ChatObject
 * JD-Core Version:    0.7.0.1
 */