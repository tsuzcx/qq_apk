package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import pph;
import tencent.im.oidb.articlesummary.articlesummary.FusionBiuInfo;

public class FusionBiuInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<FusionBiuInfo> CREATOR = new pph();
  public int a;
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public FusionBiuInfo() {}
  
  public FusionBiuInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      this.jdField_a_of_type_Long = paramParcel.readLong();
      return;
      bool1 = false;
      break;
    }
  }
  
  public static FusionBiuInfo a(articlesummary.FusionBiuInfo paramFusionBiuInfo)
  {
    FusionBiuInfo localFusionBiuInfo = new FusionBiuInfo();
    localFusionBiuInfo.jdField_a_of_type_Boolean = paramFusionBiuInfo.bool_is_gray.get();
    localFusionBiuInfo.b = paramFusionBiuInfo.bool_is_biu.get();
    localFusionBiuInfo.jdField_a_of_type_Long = paramFusionBiuInfo.uint64_feeds_id.get();
    localFusionBiuInfo.jdField_a_of_type_Int = paramFusionBiuInfo.uint32_biu_count.get();
    return localFusionBiuInfo;
  }
  
  public FusionBiuInfo a()
  {
    try
    {
      super.clone();
      FusionBiuInfo localFusionBiuInfo = new FusionBiuInfo();
      localFusionBiuInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localFusionBiuInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localFusionBiuInfo.b = this.b;
      localFusionBiuInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      return localFusionBiuInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FusionBiuInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
        }
      }
    }
  }
  
  public byte[] a()
  {
    articlesummary.FusionBiuInfo localFusionBiuInfo = new articlesummary.FusionBiuInfo();
    localFusionBiuInfo.bool_is_gray.set(this.jdField_a_of_type_Boolean);
    localFusionBiuInfo.bool_is_biu.set(this.b);
    localFusionBiuInfo.uint32_biu_count.set(this.jdField_a_of_type_Int);
    localFusionBiuInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    return ((articlesummary.FusionBiuInfo)localFusionBiuInfo.get()).toByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      if (!this.b) {
        break label54;
      }
    }
    label54:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo
 * JD-Core Version:    0.7.0.1
 */