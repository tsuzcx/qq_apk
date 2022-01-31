package com.tencent.mobileqq.app.utils;

import alsh;
import ammo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class FriendsStatusUtil$UpdateFriendStatusItem
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateFriendStatusItem> CREATOR = new ammo();
  public int a;
  public long a;
  public String a;
  private byte[] a;
  public int b = -1;
  
  public FriendsStatusUtil$UpdateFriendStatusItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      paramParcel.readByteArray(this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  public FriendsStatusUtil$UpdateFriendStatusItem(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public FriendsStatusUtil$UpdateFriendStatusItem(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    do
    {
      return -1L;
      if (this.jdField_a_of_type_ArrayOfByte.length == 0) {
        return 0L;
      }
      if (this.jdField_a_of_type_ArrayOfByte.length == 4) {
        return alsh.a(this.jdField_a_of_type_ArrayOfByte);
      }
    } while (this.jdField_a_of_type_ArrayOfByte.length != 8);
    return alsh.a(Arrays.copyOfRange(this.jdField_a_of_type_ArrayOfByte, 0, 4));
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[4];
      this.jdField_a_of_type_ArrayOfByte[0] = ((byte)(int)(paramLong >> 24 & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[1] = ((byte)(int)(paramLong >> 16 & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[2] = ((byte)(int)(paramLong >> 8 & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[3] = ((byte)(int)(paramLong & 0xFF));
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
      this.jdField_a_of_type_ArrayOfByte[0] = ((byte)(int)(paramLong >> 24 & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[1] = ((byte)(int)(paramLong >> 16 & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[2] = ((byte)(int)(paramLong >> 8 & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[3] = ((byte)(int)(paramLong & 0xFF));
      this.jdField_a_of_type_ArrayOfByte[4] = -1;
      this.jdField_a_of_type_ArrayOfByte[5] = -1;
      this.jdField_a_of_type_ArrayOfByte[6] = -1;
      this.jdField_a_of_type_ArrayOfByte[7] = -1;
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
    return "item:serType=" + this.jdField_a_of_type_Int + " sns_type=" + this.b + " uin=" + this.jdField_a_of_type_JavaLangString + " serviceTime=" + this.jdField_a_of_type_ArrayOfByte + " identify=" + super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem
 * JD-Core Version:    0.7.0.1
 */