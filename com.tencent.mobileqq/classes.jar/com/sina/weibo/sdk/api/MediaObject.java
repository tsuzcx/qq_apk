package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class MediaObject
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<MediaObject> CREATOR = new MediaObject.1();
  private static final long serialVersionUID = -5562495969515901397L;
  public String actionUrl;
  public String description;
  public String identify;
  public String schema;
  public byte[] thumbData;
  public String title;
  
  public MediaObject() {}
  
  protected MediaObject(Parcel paramParcel)
  {
    this.actionUrl = paramParcel.readString();
    this.schema = paramParcel.readString();
    this.identify = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.thumbData = paramParcel.createByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeString(this.schema);
    paramParcel.writeString(this.identify);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.thumbData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.MediaObject
 * JD-Core Version:    0.7.0.1
 */