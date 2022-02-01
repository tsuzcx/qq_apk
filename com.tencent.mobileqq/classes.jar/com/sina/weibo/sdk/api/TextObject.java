package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class TextObject
  extends MediaObject
{
  public static final Parcelable.Creator<TextObject> CREATOR = new TextObject.1();
  private static final long serialVersionUID = -5610314414793811821L;
  public String text;
  
  public TextObject() {}
  
  protected TextObject(Parcel paramParcel)
  {
    this.text = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.TextObject
 * JD-Core Version:    0.7.0.1
 */