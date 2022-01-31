package com.tencent.mobileqq.app;

import AvatarInfo.DestQQHeadInfo;
import ajxj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FriendListHandler$QQHeadDetails
  implements Parcelable
{
  public static final Parcelable.Creator<QQHeadDetails> CREATOR = new ajxj();
  public byte a;
  public int a;
  public long a;
  public String a;
  
  private FriendListHandler$QQHeadDetails() {}
  
  public FriendListHandler$QQHeadDetails(int paramInt, String paramString, long paramLong, byte paramByte)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Byte = paramByte;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.QQHeadDetails
 * JD-Core Version:    0.7.0.1
 */