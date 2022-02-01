package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

public class WebData
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WebData> CREATOR = new WebData.1();
  private static final long serialVersionUID = -4038177938155795889L;
  protected AuthInfo aB;
  protected String aC;
  protected int type;
  protected String url;
  
  protected WebData(Parcel paramParcel)
  {
    this.aB = ((AuthInfo)paramParcel.readParcelable(AuthInfo.class.getClassLoader()));
    this.type = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.aC = paramParcel.readString();
  }
  
  public WebData(AuthInfo paramAuthInfo, int paramInt, String paramString1, String paramString2)
  {
    this.aB = paramAuthInfo;
    this.type = paramInt;
    this.url = paramString1;
    this.aC = paramString2;
  }
  
  public final AuthInfo a()
  {
    return this.aB;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public final String u()
  {
    return this.aC;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.aB, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.aC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.WebData
 * JD-Core Version:    0.7.0.1
 */