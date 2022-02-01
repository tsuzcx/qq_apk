package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RecommendFollowInfoTitle$1
  implements Parcelable.Creator<RecommendFollowInfoTitle>
{
  public RecommendFollowInfoTitle a(Parcel paramParcel)
  {
    boolean bool = true;
    RecommendFollowInfoTitle localRecommendFollowInfoTitle = new RecommendFollowInfoTitle();
    localRecommendFollowInfoTitle.title = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localRecommendFollowInfoTitle.isAllFollowed = bool;
      return localRecommendFollowInfoTitle;
      bool = false;
    }
  }
  
  public RecommendFollowInfoTitle[] a(int paramInt)
  {
    return new RecommendFollowInfoTitle[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfoTitle.1
 * JD-Core Version:    0.7.0.1
 */