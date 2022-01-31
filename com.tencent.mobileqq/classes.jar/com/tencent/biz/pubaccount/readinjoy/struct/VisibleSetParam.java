package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qdz;

public class VisibleSetParam
  implements Parcelable
{
  public static final Parcelable.Creator<VisibleSetParam> CREATOR = new qdz();
  public static VisibleSetParam a;
  public static VisibleSetParam b;
  private final int jdField_a_of_type_Int;
  private final List<Long> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam = new VisibleSetParam(0, Collections.emptyList());
    b = new VisibleSetParam(2, Collections.emptyList());
  }
  
  public VisibleSetParam(int paramInt, @NonNull List<Long> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public VisibleSetParam(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilList, Long.class.getClassLoader());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<Long> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VisibleSetParam{visible_type=" + this.jdField_a_of_type_Int + ", uinWhiteList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam
 * JD-Core Version:    0.7.0.1
 */