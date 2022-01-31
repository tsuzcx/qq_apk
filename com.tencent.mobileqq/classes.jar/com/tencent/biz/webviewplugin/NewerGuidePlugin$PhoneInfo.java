package com.tencent.biz.webviewplugin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import xcc;

public final class NewerGuidePlugin$PhoneInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PhoneInfo> CREATOR = new xcc();
  public String a;
  public String b;
  public String c;
  public String d;
  
  public NewerGuidePlugin$PhoneInfo() {}
  
  public NewerGuidePlugin$PhoneInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.PhoneInfo
 * JD-Core Version:    0.7.0.1
 */