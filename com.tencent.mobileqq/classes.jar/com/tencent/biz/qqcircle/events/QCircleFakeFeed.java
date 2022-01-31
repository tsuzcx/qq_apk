package com.tencent.biz.qqcircle.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import twj;

public class QCircleFakeFeed
  implements Parcelable
{
  public static final Parcelable.Creator<QCircleFakeFeed> CREATOR = new twj();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private LbsDataV2.PoiInfo jdField_a_of_type_CooperationQzoneLbsDataV2$PoiInfo;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<LabelInfo> jdField_b_of_type_JavaUtilArrayList;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public QCircleFakeFeed() {}
  
  public QCircleFakeFeed(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    this.e = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)paramParcel.readSerializable());
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$PoiInfo = ((LbsDataV2.PoiInfo)paramParcel.readParcelable(LbsDataV2.PoiInfo.class.getClassLoader()));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public LbsDataV2.PoiInfo a()
  {
    return this.jdField_a_of_type_CooperationQzoneLbsDataV2$PoiInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<LabelInfo> b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeSerializable(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$PoiInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFakeFeed
 * JD-Core Version:    0.7.0.1
 */