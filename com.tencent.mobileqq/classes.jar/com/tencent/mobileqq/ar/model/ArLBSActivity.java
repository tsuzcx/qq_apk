package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anfp;

public class ArLBSActivity
  implements Parcelable
{
  public static final Parcelable.Creator<ArLBSActivity> CREATOR = new anfp();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  
  public ArLBSActivity() {}
  
  public ArLBSActivity(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArLBSActivity{");
    localStringBuffer.append("activityName = ").append(this.a);
    localStringBuffer.append(", logoUrl = ").append(this.b);
    localStringBuffer.append(", mapBackgroundUrl = ").append(this.c);
    localStringBuffer.append(", prizeImageUrl = ").append(this.d);
    localStringBuffer.append(", prizeName = ").append(this.e);
    localStringBuffer.append(", tipsForOutsideLBSLocation = ").append(this.f);
    localStringBuffer.append(", tipsTitleForNoLBSLocation = ").append(this.g);
    localStringBuffer.append(", tipsContentForNoLBSLocation = ").append(this.h);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArLBSActivity
 * JD-Core Version:    0.7.0.1
 */