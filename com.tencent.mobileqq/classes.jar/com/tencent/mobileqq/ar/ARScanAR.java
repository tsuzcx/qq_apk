package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanAR
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanAR> CREATOR = new ARScanAR.1();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public ARScanAR() {}
  
  public ARScanAR(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ScanAR{");
    localStringBuffer.append("EntryType='");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRBegin=");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", aREnd=");
    localStringBuffer.append(this.jdField_b_of_type_Long);
    localStringBuffer.append(", userGuideBeginTime=");
    localStringBuffer.append(this.jdField_c_of_type_Long);
    localStringBuffer.append(", userGuideEndTime=");
    localStringBuffer.append(this.jdField_d_of_type_Long);
    localStringBuffer.append(", actType=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", userGuideShowCount=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", scanIconImg='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanIconPressed='");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanIconText='");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLine1='");
    localStringBuffer.append(this.f);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLine2='");
    localStringBuffer.append(this.g);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLineLink='");
    localStringBuffer.append(this.h);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLinkUrl='");
    localStringBuffer.append(this.i);
    localStringBuffer.append('\'');
    localStringBuffer.append(", what2scanUrl='");
    localStringBuffer.append(this.j);
    localStringBuffer.append('\'');
    localStringBuffer.append(", userGuideWording='");
    localStringBuffer.append(this.k);
    localStringBuffer.append('\'');
    localStringBuffer.append(", userGuideType='");
    localStringBuffer.append(this.l);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARScanAR
 * JD-Core Version:    0.7.0.1
 */