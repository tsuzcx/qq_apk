package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class m
  implements Parcelable
{
  public static final Parcelable.Creator<m> CREATOR = new m.1();
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public m() {}
  
  public m(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public void a(m paramm)
  {
    if (paramm == null) {
      return;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramm.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    a(localParcel);
    localParcel.recycle();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandWeishiParams{fromOpenSdk=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", thumbUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbFullPath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgImgPath='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sourceUserName='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.m
 * JD-Core Version:    0.7.0.1
 */