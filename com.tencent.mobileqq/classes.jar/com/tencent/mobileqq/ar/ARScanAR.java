package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apfj;

public class ARScanAR
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanAR> CREATOR = new apfj();
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
    localStringBuffer.append("EntryType='").append(this.jdField_a_of_type_Int).append('\'');
    localStringBuffer.append(", aRBegin=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", aREnd=").append(this.jdField_b_of_type_Long);
    localStringBuffer.append(", userGuideBeginTime=").append(this.jdField_c_of_type_Long);
    localStringBuffer.append(", userGuideEndTime=").append(this.jdField_d_of_type_Long);
    localStringBuffer.append(", actType=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", userGuideShowCount=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", scanIconImg='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", scanIconPressed='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", scanIconText='").append(this.e).append('\'');
    localStringBuffer.append(", scanLine1='").append(this.f).append('\'');
    localStringBuffer.append(", scanLine2='").append(this.g).append('\'');
    localStringBuffer.append(", scanLineLink='").append(this.h).append('\'');
    localStringBuffer.append(", scanLinkUrl='").append(this.i).append('\'');
    localStringBuffer.append(", what2scanUrl='").append(this.j).append('\'');
    localStringBuffer.append(", userGuideWording='").append(this.k).append('\'');
    localStringBuffer.append(", userGuideType='").append(this.l).append('\'');
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARScanAR
 * JD-Core Version:    0.7.0.1
 */