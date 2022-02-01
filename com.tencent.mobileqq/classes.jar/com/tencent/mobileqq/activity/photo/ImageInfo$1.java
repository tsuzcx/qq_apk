package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ImageInfo$1
  implements Parcelable.Creator<ImageInfo>
{
  public ImageInfo a(Parcel paramParcel)
  {
    ImageInfo localImageInfo = new ImageInfo();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_a_of_type_Boolean = bool1;
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_b_of_type_Boolean = bool1;
    localImageInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_c_of_type_Boolean = bool1;
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_d_of_type_Boolean = bool1;
    localImageInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_e_of_type_Boolean = bool1;
    localImageInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localImageInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localImageInfo.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_f_of_type_Boolean = bool1;
    localImageInfo.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_h_of_type_Boolean = bool1;
    if (paramParcel.readInt() == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localImageInfo.jdField_i_of_type_Boolean = bool1;
    localImageInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localImageInfo.g = paramParcel.readString();
    localImageInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localImageInfo.jdField_h_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localImageInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localImageInfo.jdField_h_of_type_Int = paramParcel.readInt();
    localImageInfo.jdField_i_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_k_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localImageInfo.o = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localImageInfo.n = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    localImageInfo.q = bool1;
    localImageInfo.jdField_d_of_type_Long = paramParcel.readLong();
    localImageInfo.j = paramParcel.readString();
    localImageInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_l_of_type_JavaLangString = paramParcel.readString();
    localImageInfo.jdField_l_of_type_Int = paramParcel.readInt();
    return localImageInfo;
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ImageInfo.1
 * JD-Core Version:    0.7.0.1
 */