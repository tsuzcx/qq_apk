package com.tencent.mobileqq.app.face.bean;

import AvatarInfo.DestQQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aokq;

public class QQHeadDetails
  implements Parcelable
{
  public static final Parcelable.Creator<QQHeadDetails> CREATOR = new aokq();
  public byte a;
  public int a;
  public long a;
  public String a;
  public int b;
  
  private QQHeadDetails() {}
  
  public QQHeadDetails(int paramInt1, String paramString, long paramLong, byte paramByte, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Byte = paramByte;
    this.b = paramInt2;
  }
  
  public DestQQHeadInfo a()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_Int == 11) {
      return new DestQQHeadInfo(0L, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label38:
      break label38;
    }
    return new DestQQHeadInfo(l1, this.jdField_a_of_type_Long, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uinOrMobile:").append(this.jdField_a_of_type_JavaLangString).append(",timestamp:").append(this.jdField_a_of_type_Long).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.bean.QQHeadDetails
 * JD-Core Version:    0.7.0.1
 */