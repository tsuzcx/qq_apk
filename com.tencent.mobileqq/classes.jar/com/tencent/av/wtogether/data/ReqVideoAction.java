package com.tencent.av.wtogether.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import myp;
import myt;
import myv;

public class ReqVideoAction
  implements Parcelable
{
  public static final Parcelable.Creator<ReqVideoAction> CREATOR = new myp();
  public float a;
  public int a;
  public long a;
  public int b;
  public long b;
  
  public ReqVideoAction(long paramLong, int paramInt, myt parammyt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (parammyt != null)
    {
      this.jdField_b_of_type_Long = parammyt.a();
      this.jdField_a_of_type_Float = parammyt.a();
      this.jdField_b_of_type_Int = parammyt.a();
      return;
    }
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 0;
  }
  
  public ReqVideoAction(long paramLong, int paramInt, myv parammyv)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    if (parammyv != null)
    {
      this.jdField_b_of_type_Long = parammyv.jdField_a_of_type_Long;
      this.jdField_a_of_type_Float = parammyv.jdField_a_of_type_Float;
      this.jdField_b_of_type_Int = parammyv.jdField_a_of_type_Int;
      return;
    }
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 0;
  }
  
  public ReqVideoAction(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.data.ReqVideoAction
 * JD-Core Version:    0.7.0.1
 */