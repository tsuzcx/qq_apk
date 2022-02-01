package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bffk;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import ylp;

public class EditLocalVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalVideoSource> CREATOR = new ylp();
  public int a;
  @NonNull
  public final LocalMediaInfo a;
  @NonNull
  public final String a;
  public final int b;
  
  public EditLocalVideoSource(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)paramParcel.readParcelable(bffk.class.getClassLoader()));
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public EditLocalVideoSource(String paramString, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public String checkParam()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "sourcePath is empty";
    }
    if (!new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return "Can not find file by sourcePath = " + this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) {
      return "media info should not be null";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration <= 0L) {
      return "media info duration should be large than 0";
    }
    if ((this.jdField_a_of_type_Int < 0) || (this.b < 0) || (this.b < this.jdField_a_of_type_Int)) {
      return "startTime(" + this.jdField_a_of_type_Int + ") or endTime(" + this.b + ") is illegal";
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight;
  }
  
  @NonNull
  public String getSourcePath()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, 0);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditLocalVideoSource
 * JD-Core Version:    0.7.0.1
 */