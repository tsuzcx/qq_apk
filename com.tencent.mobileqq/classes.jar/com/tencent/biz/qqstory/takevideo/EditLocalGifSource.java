package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.util.gifCoderWnsConfig;
import java.io.File;
import java.util.ArrayList;

public class EditLocalGifSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalGifSource> CREATOR = new EditLocalGifSource.1();
  @NonNull
  public int a;
  @NonNull
  public long a;
  @NonNull
  public final LocalMediaInfo a;
  @NonNull
  public String a;
  @NonNull
  public ArrayList<String> a;
  @NonNull
  public boolean a;
  @NonNull
  public ArrayList<String> b = new ArrayList();
  
  protected EditLocalGifSource(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    paramParcel.readStringList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.jdField_a_of_type_Long = paramParcel.readLong();
  }
  
  public EditLocalGifSource(String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    paramString = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null) {
      paramString = new LocalMediaInfo();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramString;
    this.jdField_a_of_type_Long = gifCoderWnsConfig.DEFAULT_DELAY;
  }
  
  public EditLocalGifSource(String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    paramString = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null) {
      paramString = new LocalMediaInfo();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramString;
    this.jdField_a_of_type_Long = paramLong;
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
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))) {
      return "sourcePath is empty";
    }
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!new File(this.jdField_a_of_type_JavaLangString).exists()) {
        return "Can not find file by sourcePath = " + this.jdField_a_of_type_JavaLangString;
      }
    }
    else if (!new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(0)).exists()) {
      return "Can not find file by sourcePath = " + this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, 1);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditLocalGifSource
 * JD-Core Version:    0.7.0.1
 */