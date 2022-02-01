package com.tencent.mobileqq.app.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import java.util.Arrays;

public class FriendsStatusUtil$UpdateFriendStatusItem
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateFriendStatusItem> CREATOR = new FriendsStatusUtil.UpdateFriendStatusItem.1();
  public int a;
  public long a;
  public String a;
  private byte[] a;
  public int b = -1;
  
  protected FriendsStatusUtil$UpdateFriendStatusItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {
      paramParcel.readByteArray(arrayOfByte);
    }
  }
  
  public FriendsStatusUtil$UpdateFriendStatusItem(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public FriendsStatusUtil$UpdateFriendStatusItem(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    long l = -1L;
    if (arrayOfByte == null) {
      return -1L;
    }
    if (arrayOfByte.length == 0) {
      return 0L;
    }
    if (arrayOfByte.length == 4) {
      return MessageHandlerUtils.a(arrayOfByte);
    }
    if (arrayOfByte.length == 8) {
      l = MessageHandlerUtils.a(Arrays.copyOfRange(arrayOfByte, 0, 4));
    }
    return l;
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[4];
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      arrayOfByte[0] = ((byte)(int)(paramLong >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(int)(paramLong >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(int)(paramLong >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(int)(paramLong & 0xFF));
      return;
    }
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[0];
      return;
    }
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[8];
    if (paramLong > 0L)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      arrayOfByte[0] = ((byte)(int)(paramLong >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(int)(paramLong >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(int)(paramLong >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(int)(paramLong & 0xFF));
      arrayOfByte[4] = -1;
      arrayOfByte[5] = -1;
      arrayOfByte[6] = -1;
      arrayOfByte[7] = -1;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = new byte[8];
    }
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("item:serType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" sns_type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" serviceTime=");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
    localStringBuilder.append(" identify=");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem
 * JD-Core Version:    0.7.0.1
 */