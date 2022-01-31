package com.tencent.biz.qqstory.notification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ngl;

public class StoryPushMsg
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ngl();
  public int a;
  public long a;
  public Bundle a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public StoryPushMsg(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramString4;
    this.e = paramString5;
    this.g = paramString6;
    this.h = paramString7;
  }
  
  public StoryPushMsg(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    this(paramInt, paramString1, paramString2, paramLong, paramString3, paramString4, 1, null, paramString5, null);
  }
  
  public StoryPushMsg(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this(paramInt1, paramString1, paramString2, paramLong, paramString3, paramString4, 1, null, paramString6, paramString7);
    this.jdField_c_of_type_Int = paramInt2;
    this.f = paramString5;
    this.e = paramString8;
  }
  
  public StoryPushMsg(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramInt, paramString1, paramString2, paramLong, paramString3, paramString4, 1, paramString5, paramString6, null);
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "StoryPushMsg{mCommentId=" + this.jdField_c_of_type_Int + ", type=" + this.jdField_a_of_type_Int + ", subType='" + this.jdField_a_of_type_JavaLangString + '\'' + ", msgInfo='" + this.jdField_b_of_type_JavaLangString + '\'' + ", uin=" + this.jdField_a_of_type_Long + ", unionId='" + this.jdField_c_of_type_JavaLangString + '\'' + ", feedId='" + this.d + '\'' + ", mUnreadNum=" + this.jdField_b_of_type_Int + ", mVid='" + this.e + '\'' + ", mThumbUrl='" + this.g + '\'' + ", mFeedLikeUserUnionId='" + this.f + '\'' + ", reserveBundle=" + this.jdField_a_of_type_AndroidOsBundle + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.g);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryPushMsg
 * JD-Core Version:    0.7.0.1
 */