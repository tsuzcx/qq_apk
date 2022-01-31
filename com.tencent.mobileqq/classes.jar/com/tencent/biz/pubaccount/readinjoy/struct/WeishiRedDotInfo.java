package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qed;

public class WeishiRedDotInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiRedDotInfo> CREATOR = new qed();
  private String jdField_a_of_type_JavaLangString = "";
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  private String c = "";
  private String d = "";
  
  public WeishiRedDotInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = paramParcel.createStringArrayList();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public WeishiRedDotInfo(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg;
      if (paramMessageForStructing.mAlgorithmIds != null) {
        this.b = paramMessageForStructing.mAlgorithmIds;
      }
      if (paramMessageForStructing.mStrategyIds != null) {
        this.c = paramMessageForStructing.mStrategyIds;
      }
      if (paramMessageForStructing.mMsgBrief != null) {
        this.jdField_a_of_type_JavaLangString = paramMessageForStructing.mMsgBrief;
      }
      if (!TextUtils.isEmpty(paramMessageForStructing.mArticleIds)) {
        this.jdField_a_of_type_JavaUtilList.addAll(Arrays.asList(paramMessageForStructing.mArticleIds.split("\\|")));
      }
      if (paramMessageForStructing.mMsgActionData != null) {
        this.d = paramMessageForStructing.mMsgActionData;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo
 * JD-Core Version:    0.7.0.1
 */