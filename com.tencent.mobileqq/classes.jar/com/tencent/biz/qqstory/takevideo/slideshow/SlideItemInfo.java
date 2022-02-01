package com.tencent.biz.qqstory.takevideo.slideshow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import java.net.URL;

public class SlideItemInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SlideItemInfo> CREATOR = new SlideItemInfo.1();
  public int a;
  public long a;
  public StoryAlbum a;
  public LocalMediaInfo a;
  public String a;
  public URL a;
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
  
  protected SlideItemInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_JavaLangString = "LinearBlur";
    boolean bool2 = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
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
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_c_of_type_Boolean = bool1;
  }
  
  public SlideItemInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_JavaLangString = "LinearBlur";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      this.jdField_b_of_type_JavaLangString = paramLocalMediaInfo.path;
      this.jdField_b_of_type_Int = QAlbumUtil.getMediaType(paramLocalMediaInfo);
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTransId)) {
        this.jdField_e_of_type_JavaLangString = paramLocalMediaInfo.mTransId;
      }
      if (!TextUtils.isEmpty(paramLocalMediaInfo.mTextStr)) {
        this.jdField_a_of_type_JavaLangString = paramLocalMediaInfo.mTextStr;
      }
      this.jdField_a_of_type_Int = paramLocalMediaInfo.mTextId;
      int i = this.jdField_b_of_type_Int;
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        if (paramLocalMediaInfo.isSystemMeidaStore == true) {
          this.jdField_a_of_type_JavaNetURL = QAlbumUtil.generateAlbumThumbURL(paramLocalMediaInfo, "VIDEO");
        } else {
          this.jdField_a_of_type_JavaNetURL = QAlbumUtil.generateAlbumThumbURL(paramLocalMediaInfo, "APP_VIDEO");
        }
        this.jdField_a_of_type_Long = paramLocalMediaInfo.mDuration;
        if (this.jdField_c_of_type_Long == 0L) {
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder("albumthumb");
        localStringBuilder.append("://");
        localStringBuilder.append(paramLocalMediaInfo.path);
        this.jdField_a_of_type_JavaNetURL = QAlbumUtil.generateAlbumThumbURL(paramLocalMediaInfo);
        this.jdField_a_of_type_Long = 2000L;
        this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        return;
      }
    }
    catch (Exception paramLocalMediaInfo)
    {
      paramLocalMediaInfo.printStackTrace();
    }
  }
  
  public long a()
  {
    if (this.jdField_b_of_type_Long <= 0L) {
      this.jdField_b_of_type_Long = 0L;
    }
    long l1 = this.jdField_c_of_type_Long;
    if ((l1 <= 0L) || (l1 >= this.jdField_a_of_type_Long)) {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    }
    l1 = this.jdField_c_of_type_Long;
    long l2 = this.jdField_b_of_type_Long;
    if (l1 <= l2) {
      return this.jdField_a_of_type_Long;
    }
    return l1 - l2;
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
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo
 * JD-Core Version:    0.7.0.1
 */