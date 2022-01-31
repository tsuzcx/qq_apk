package com.tencent.mobileqq.app.soso;

import akut;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.map.geolocation.TencentPoi;
import java.util.LinkedList;
import java.util.List;

public final class SosoInterface$SosoLocation
  implements Parcelable
{
  public static final Parcelable.Creator<SosoLocation> CREATOR = new akut();
  public double a;
  public float a;
  public int a;
  public long a;
  public String a;
  public List<TencentPoi> a;
  public double b;
  public float b;
  public String b;
  public double c;
  public String c;
  public double d;
  public String d;
  public double e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public SosoInterface$SosoLocation() {}
  
  public SosoInterface$SosoLocation(Parcel paramParcel)
  {
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.jdField_b_of_type_Double = paramParcel.readDouble();
    this.jdField_c_of_type_Double = paramParcel.readDouble();
    this.jdField_d_of_type_Double = paramParcel.readDouble();
    this.jdField_e_of_type_Double = paramParcel.readDouble();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
  }
  
  public SosoLocation a(int paramInt, boolean paramBoolean)
  {
    SosoLocation localSosoLocation = new SosoLocation();
    if (paramBoolean)
    {
      localSosoLocation.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
      localSosoLocation.jdField_b_of_type_Double = this.jdField_b_of_type_Double;
      localSosoLocation.jdField_c_of_type_Double = this.jdField_c_of_type_Double;
      localSosoLocation.jdField_d_of_type_Double = this.jdField_d_of_type_Double;
    }
    localSosoLocation.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    localSosoLocation.jdField_e_of_type_Double = this.jdField_e_of_type_Double;
    localSosoLocation.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    localSosoLocation.l = this.l;
    localSosoLocation.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localSosoLocation.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localSosoLocation.m = this.m;
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      localSosoLocation.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localSosoLocation.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
    if ((paramInt == 3) || (paramInt == 4))
    {
      localSosoLocation.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localSosoLocation.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localSosoLocation.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localSosoLocation.f = this.f;
      localSosoLocation.g = this.g;
      localSosoLocation.h = this.h;
      localSosoLocation.i = this.i;
      localSosoLocation.j = this.j;
      localSosoLocation.k = this.k;
    }
    if (paramInt == 4)
    {
      LinkedList localLinkedList = new LinkedList();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        localLinkedList.addAll(this.jdField_a_of_type_JavaUtilList);
      }
      localSosoLocation.jdField_a_of_type_JavaUtilList = localLinkedList;
    }
    return localSosoLocation;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeDouble(this.jdField_b_of_type_Double);
    paramParcel.writeDouble(this.jdField_c_of_type_Double);
    paramParcel.writeDouble(this.jdField_d_of_type_Double);
    paramParcel.writeDouble(this.jdField_e_of_type_Double);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation
 * JD-Core Version:    0.7.0.1
 */