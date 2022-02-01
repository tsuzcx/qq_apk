package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReqVideoAction
  implements Parcelable
{
  public static final Parcelable.Creator<ReqVideoAction> CREATOR = new ReqVideoAction.1();
  public float a;
  public int a;
  public long a;
  public int b;
  public long b;
  
  public ReqVideoAction(long paramLong, int paramInt, WTSyncPlayInfo paramWTSyncPlayInfo)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (paramWTSyncPlayInfo != null)
    {
      this.jdField_b_of_type_Long = paramWTSyncPlayInfo.a();
      this.jdField_a_of_type_Float = paramWTSyncPlayInfo.a();
      this.jdField_b_of_type_Int = paramWTSyncPlayInfo.a();
      return;
    }
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 0;
  }
  
  public ReqVideoAction(long paramLong, int paramInt, WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (paramWTogetherPlayInfo != null)
    {
      this.jdField_b_of_type_Long = paramWTogetherPlayInfo.jdField_a_of_type_Long;
      this.jdField_a_of_type_Float = paramWTogetherPlayInfo.jdField_a_of_type_Float;
      this.jdField_b_of_type_Int = paramWTogetherPlayInfo.jdField_a_of_type_Int;
      return;
    }
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 0;
  }
  
  protected ReqVideoAction(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VideoAction{seq: " + this.jdField_a_of_type_Long + ", action: " + this.jdField_a_of_type_Int + ", curPlayTimeMs: " + this.jdField_b_of_type_Long + ", curPlayRate: " + this.jdField_a_of_type_Float + ", curPlayState: " + this.jdField_b_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ReqVideoAction
 * JD-Core Version:    0.7.0.1
 */