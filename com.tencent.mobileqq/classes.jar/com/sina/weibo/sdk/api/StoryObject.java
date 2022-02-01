package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StoryObject
  implements Parcelable
{
  public static final Parcelable.Creator<StoryObject> CREATOR = new StoryObject.1();
  public String appId;
  public String appPackage;
  public String callbackAction;
  public String sourcePath;
  public int sourceType;
  
  public StoryObject() {}
  
  protected StoryObject(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    this.sourceType = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.appPackage = paramParcel.readString();
    this.callbackAction = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeInt(this.sourceType);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.appPackage);
    paramParcel.writeString(this.callbackAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.StoryObject
 * JD-Core Version:    0.7.0.1
 */