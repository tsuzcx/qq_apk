package com.tencent.biz.qqstory.takevideo.slideshow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bhkd;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.net.URL;
import wgg;
import zjw;

public class SlideItemInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SlideItemInfo> CREATOR = new zjw();
  public int a;
  public long a;
  public LocalMediaInfo a;
  public String a;
  public URL a;
  public wgg a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  public SlideItemInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "LinearBlur";
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label193;
      }
      bool1 = true;
      label168:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label198;
      }
    }
    label193:
    label198:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label168;
    }
  }
  
  public SlideItemInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "LinearBlur";
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = paramLocalMediaInfo.path;
      this.jdField_b_of_type_Int = bhkd.getMediaType(paramLocalMediaInfo);
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTransId)) {
        this.jdField_e_of_type_JavaLangString = paramLocalMediaInfo.mTransId;
      }
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTextStr)) {
        this.jdField_a_of_type_JavaLangString = paramLocalMediaInfo.mTextStr;
      }
      this.jdField_a_of_type_Int = paramLocalMediaInfo.mTextId;
      switch (this.jdField_b_of_type_Int)
      {
      case 0: 
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramLocalMediaInfo.path);
        this.jdField_a_of_type_JavaNetURL = bhkd.generateAlbumThumbURL(paramLocalMediaInfo);
        this.jdField_a_of_type_Long = 2000L;
        this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        return;
      }
    }
    catch (Exception paramLocalMediaInfo)
    {
      paramLocalMediaInfo.printStackTrace();
      return;
    }
    if (paramLocalMediaInfo.isSystemMeidaStore == true) {}
    for (this.jdField_a_of_type_JavaNetURL = bhkd.generateAlbumThumbURL(paramLocalMediaInfo, "VIDEO");; this.jdField_a_of_type_JavaNetURL = bhkd.generateAlbumThumbURL(paramLocalMediaInfo, "APP_VIDEO"))
    {
      this.jdField_a_of_type_Long = paramLocalMediaInfo.mDuration;
      if (this.jdField_c_of_type_Long != 0L) {
        break;
      }
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      return;
    }
  }
  
  public long a()
  {
    if (this.jdField_b_of_type_Long <= 0L) {
      this.jdField_b_of_type_Long = 0L;
    }
    if ((this.jdField_c_of_type_Long <= 0L) || (this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long)) {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    }
    if (this.jdField_c_of_type_Long <= this.jdField_b_of_type_Long) {
      return this.jdField_a_of_type_Long;
    }
    return this.jdField_c_of_type_Long - this.jdField_b_of_type_Long;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SlideItemInfo))
    {
      paramObject = (SlideItemInfo)paramObject;
      return TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.f);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label174;
      }
      paramInt = 1;
      label147:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label179;
      }
    }
    label174:
    label179:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo
 * JD-Core Version:    0.7.0.1
 */