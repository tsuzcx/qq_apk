package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ProfileParams
  implements Parcelable
{
  public static final Parcelable.Creator<ProfileParams> CREATOR = new ProfileParams.1();
  String a;
  int b;
  String c;
  String d;
  String e;
  ProfileParams.CurLoginUsr f;
  
  public String a()
  {
    return this.d;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public ProfileParams.CurLoginUsr d()
  {
    return this.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    ProfileParams.CurLoginUsr localCurLoginUsr = this.f;
    if (localCurLoginUsr != null) {
      return localCurLoginUsr.a;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams
 * JD-Core Version:    0.7.0.1
 */