package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;

public class WadlResult
  implements Parcelable
{
  public static final Parcelable.Creator<WadlResult> CREATOR = new WadlResult.1();
  public int a;
  public long a;
  public WadlParams a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public int d;
  public long d;
  
  protected WadlResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams = ((WadlParams)paramParcel.readParcelable(WadlParams.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
  }
  
  public WadlResult(WadlParams paramWadlParams)
  {
    this.jdField_a_of_type_JavaLangString = "";
    if (paramWadlParams != null) {
      this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams = paramWadlParams;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.a;; bool1 = false)
    {
      if ((!bool1) && (this.jdField_b_of_type_Int == 9)) {
        this.jdField_b_of_type_Int = 6;
      }
      if ((this.jdField_b_of_type_Int == 6) && (!GameCenterUtil.a(this.jdField_b_of_type_JavaLangString))) {
        this.jdField_b_of_type_Int = 0;
      }
      bool1 = bool2;
      if (this.jdField_b_of_type_Int != 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WadlResult{wadlParams=" + this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams + ", event=" + this.jdField_a_of_type_Int + ", taskId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", taskStatus=" + this.jdField_b_of_type_Int + ", fileSize=" + this.jdField_a_of_type_Long + ", downloadFileSize=" + this.jdField_b_of_type_Long + ", downloadFilePath='" + this.jdField_b_of_type_JavaLangString + '\'' + ", createTime=" + this.jdField_c_of_type_Long + ", lastUpdateTime=" + this.jdField_d_of_type_Long + ", errCode=" + this.jdField_c_of_type_Int + ", progress=" + this.jdField_d_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlResult
 * JD-Core Version:    0.7.0.1
 */