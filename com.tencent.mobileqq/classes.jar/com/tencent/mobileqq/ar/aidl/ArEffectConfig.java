package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import java.util.ArrayList;

public class ArEffectConfig
  implements Parcelable
{
  public static final Parcelable.Creator<ArEffectConfig> CREATOR = new ArEffectConfig.1();
  public int a;
  public ArrayList<String> a;
  public int b;
  public ArrayList<String> b;
  public int c;
  public ArrayList<String> c;
  public int d;
  public ArrayList<String> d;
  public int e;
  public ArrayList<ArDefaultSetting> e;
  public int f = 30;
  public int g = 30;
  public int h = 30;
  
  public ArEffectConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 80;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 80;
    this.jdField_e_of_type_Int = 30;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ArEffectConfig(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Int = 80;
    this.jdField_c_of_type_Int = 80;
    this.jdField_d_of_type_Int = 80;
    this.jdField_e_of_type_Int = 30;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_b_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_c_of_type_JavaUtilArrayList, String.class.getClassLoader());
    paramParcel.readList(this.jdField_d_of_type_JavaUtilArrayList, String.class.getClassLoader());
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    paramParcel.readList(this.jdField_e_of_type_JavaUtilArrayList, ArDefaultSetting.class.getClassLoader());
  }
  
  public static ArEffectConfig a()
  {
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArEffectConfig{");
    localStringBuffer.append("version=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", toplevelModel=");
    localStringBuffer.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuffer.append(", toplevelGPU=");
    localStringBuffer.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuffer.append(", blacklistModel=");
    localStringBuffer.append(this.jdField_c_of_type_JavaUtilArrayList);
    localStringBuffer.append(", blacklistGPU=");
    localStringBuffer.append(this.jdField_d_of_type_JavaUtilArrayList);
    localStringBuffer.append(", topModelStandard=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", removeShadowLevel=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", adjustBone=");
    localStringBuffer.append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", traceQuality2=");
    localStringBuffer.append(this.jdField_e_of_type_Int);
    localStringBuffer.append(", traceQuality3=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", traceQuality4=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", traceQuality5=");
    localStringBuffer.append(this.h);
    localStringBuffer.append(", defaultSettings=");
    localStringBuffer.append(this.jdField_e_of_type_JavaUtilArrayList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.writeList(this.jdField_d_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeList(this.jdField_e_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArEffectConfig
 * JD-Core Version:    0.7.0.1
 */