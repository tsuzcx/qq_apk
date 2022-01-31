package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import java.io.File;
import odu;

public class EditTakeVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator CREATOR = new odu();
  @NonNull
  public final LocalMediaInfo a;
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  
  public EditTakeVideoSource(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)paramParcel.readParcelable(MediaInfo.class.getClassLoader()));
  }
  
  public EditTakeVideoSource(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    paramString1 = b();
    if (paramString1 != null) {
      throw new IllegalArgumentException(paramString1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth;
  }
  
  @NonNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "sourcePath is empty";
    }
    if (!new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return "Can not find file by sourcePath = " + this.jdField_a_of_type_JavaLangString;
    }
    if (!new File(this.b).exists()) {
      return "Can not find file by audioSourcePath = " + this.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) {
      return "media info should not be null";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration <= 0L) {
      return "media info duration should be large than 0";
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "EditTakeVideoSource: sourcePath=" + this.jdField_a_of_type_JavaLangString + " audioSourcePath=" + this.b + " mediaInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditTakeVideoSource
 * JD-Core Version:    0.7.0.1
 */