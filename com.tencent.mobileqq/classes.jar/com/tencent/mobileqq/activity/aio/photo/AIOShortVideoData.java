package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class AIOShortVideoData
  extends AIORichMediaData
  implements Parcelable
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public int h;
  private String h;
  public int i = 0;
  public int j;
  public int k = 0;
  
  public AIOShortVideoData()
  {
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_b_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = null;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        localObject = null;
      } else {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
    }
    else {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_h_of_type_JavaLangString;
  }
  
  public String a(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        str = null;
      } else {
        str = this.jdField_b_of_type_JavaLangString;
      }
    }
    else {
      str = this.jdField_a_of_type_JavaLangString;
    }
    if ((str != null) && (!str.equals("I:N")))
    {
      if (!str.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      if (str.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public void a(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return false;
      }
      return this.jdField_b_of_type_JavaLangString.equals("I:N") ^ true;
    }
    return this.jdField_a_of_type_JavaLangString.equals("I:N") ^ true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData
 * JD-Core Version:    0.7.0.1
 */