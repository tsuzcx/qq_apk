package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StoryMessage
  implements Parcelable
{
  public static final Parcelable.Creator<StoryMessage> CREATOR = new StoryMessage.1();
  private Uri imageUri;
  private Uri videoUri;
  
  public StoryMessage() {}
  
  protected StoryMessage(Parcel paramParcel)
  {
    this.imageUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.videoUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
  }
  
  public boolean checkResource()
  {
    if ((this.imageUri != null) && (this.videoUri != null)) {}
    while ((this.imageUri == null) && (this.videoUri == null)) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri getImageUri()
  {
    return this.imageUri;
  }
  
  public Uri getVideoUri()
  {
    return this.videoUri;
  }
  
  public void setImageUri(Uri paramUri)
  {
    this.imageUri = paramUri;
  }
  
  public void setVideoUri(Uri paramUri)
  {
    this.videoUri = paramUri;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.imageUri, paramInt);
    paramParcel.writeParcelable(this.videoUri, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.api.StoryMessage
 * JD-Core Version:    0.7.0.1
 */