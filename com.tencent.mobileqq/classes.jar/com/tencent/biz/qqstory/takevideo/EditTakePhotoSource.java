package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import ocb;

public class EditTakePhotoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator CREATOR = new ocb();
  public final double a;
  public final int a;
  @NonNull
  public final String a;
  public final double b;
  public final int b;
  public final int c;
  
  public EditTakePhotoSource(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.jdField_b_of_type_Double = paramParcel.readDouble();
  }
  
  public EditTakePhotoSource(String paramString)
  {
    this(paramString, 2, 0, 0);
  }
  
  public EditTakePhotoSource(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString, paramInt1, paramInt2, paramInt3, 4.9E-324D, 4.9E-324D);
  }
  
  public EditTakePhotoSource(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    paramString = b();
    if (paramString != null) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NonNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "sourcePath is empty";
    }
    if (!new File(this.jdField_a_of_type_JavaLangString).exists()) {
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
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeDouble(this.jdField_b_of_type_Double);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditTakePhotoSource
 * JD-Core Version:    0.7.0.1
 */