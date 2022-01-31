package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import rsj;

public class ProfileParams$CurLoginUsr
  implements Parcelable
{
  public static final Parcelable.Creator<CurLoginUsr> CREATOR = new rsj();
  public final String a;
  public final String b;
  
  public ProfileParams$CurLoginUsr(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr
 * JD-Core Version:    0.7.0.1
 */