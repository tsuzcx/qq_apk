package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class VideoSourceObject
  extends MediaObject
{
  public static final Parcelable.Creator<VideoSourceObject> CREATOR = new VideoSourceObject.1();
  private static final long serialVersionUID = 2745594466460840583L;
  public Uri coverPath;
  public long during;
  public Uri videoPath;
  
  public VideoSourceObject() {}
  
  protected VideoSourceObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.coverPath = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.videoPath = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.during = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.coverPath, paramInt);
    paramParcel.writeParcelable(this.videoPath, paramInt);
    paramParcel.writeLong(this.during);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.VideoSourceObject
 * JD-Core Version:    0.7.0.1
 */