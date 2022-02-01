package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import smk;

public class RecommendFeedsDiandianEntranceManager$ExtraInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ExtraInfo> CREATOR = new smk();
  public String a;
  
  public RecommendFeedsDiandianEntranceManager$ExtraInfo() {}
  
  public RecommendFeedsDiandianEntranceManager$ExtraInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "RecommendFeedsDiandianEntranceManager ExtraInfo {reportStr : " + this.a + "\n}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */