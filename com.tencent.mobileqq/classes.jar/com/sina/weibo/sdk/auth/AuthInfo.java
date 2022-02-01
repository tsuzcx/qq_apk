package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.c.e;
import java.io.Serializable;

public final class AuthInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<AuthInfo> CREATOR = new AuthInfo.1();
  private static final long serialVersionUID = 6421253895937667193L;
  private String app_key;
  private String hash;
  private String package_name;
  private String redirect_url;
  private String scope;
  
  public AuthInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.app_key = paramString1;
    this.redirect_url = paramString2;
    this.scope = paramString3;
    this.package_name = paramContext.getPackageName();
    this.hash = e.e(paramContext, this.package_name);
  }
  
  protected AuthInfo(Parcel paramParcel)
  {
    this.app_key = paramParcel.readString();
    this.redirect_url = paramParcel.readString();
    this.scope = paramParcel.readString();
    this.package_name = paramParcel.readString();
    this.hash = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAppKey()
  {
    return this.app_key;
  }
  
  public final String getHash()
  {
    return this.hash;
  }
  
  public final String getPackageName()
  {
    return this.package_name;
  }
  
  public final String getRedirectUrl()
  {
    return this.redirect_url;
  }
  
  public final String getScope()
  {
    return this.scope;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.app_key);
    paramParcel.writeString(this.redirect_url);
    paramParcel.writeString(this.scope);
    paramParcel.writeString(this.package_name);
    paramParcel.writeString(this.hash);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.AuthInfo
 * JD-Core Version:    0.7.0.1
 */