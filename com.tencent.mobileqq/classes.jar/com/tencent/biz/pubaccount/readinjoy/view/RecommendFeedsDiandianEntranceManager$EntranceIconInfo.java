package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import smj;
import tay;

public class RecommendFeedsDiandianEntranceManager$EntranceIconInfo
  implements Parcelable, tay
{
  public static final Parcelable.Creator<EntranceIconInfo> CREATOR = new smj();
  public int a;
  public RecommendFeedsDiandianEntranceManager.ExtraInfo a;
  public String a;
  public boolean a;
  public String b = "";
  public String c = "";
  
  public RecommendFeedsDiandianEntranceManager$EntranceIconInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public RecommendFeedsDiandianEntranceManager$EntranceIconInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo = ((RecommendFeedsDiandianEntranceManager.ExtraInfo)paramParcel.readParcelable(RecommendFeedsDiandianEntranceManager.ExtraInfo.class.getClassLoader()));
      return;
    }
  }
  
  public static EntranceIconInfo a(int paramInt)
  {
    EntranceIconInfo localEntranceIconInfo = new EntranceIconInfo();
    localEntranceIconInfo.jdField_a_of_type_Int = paramInt;
    localEntranceIconInfo.c = RecommendFeedsDiandianEntranceManager.a(paramInt);
    return localEntranceIconInfo;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return !TextUtils.isEmpty(this.b);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "RecommendFeedsDiandianEntranceManager EntranceIconInfo {feedsType : " + this.jdField_a_of_type_Int + "\nmsgIconUrl :" + this.jdField_a_of_type_JavaLangString + "\ndefaultIconUrl :" + this.b + "\njumpSchema :" + this.c + "\nextraInfo : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo + "\n}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecommendFeedsDiandianEntranceManager$ExtraInfo, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo
 * JD-Core Version:    0.7.0.1
 */