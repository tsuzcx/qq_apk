package com.tencent.av.chatroom;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ChatRoomInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChatRoomInfo> CREATOR = new ChatRoomInfo.1();
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d;
  public long d;
  private int e = 0;
  
  public ChatRoomInfo(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = paramLong3;
  }
  
  protected ChatRoomInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
  }
  
  public void a()
  {
    this.e += 1;
  }
  
  public boolean a()
  {
    return this.e <= 3;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_Long == paramLong1) && (this.jdField_b_of_type_Long == paramLong2) && (this.jdField_c_of_type_Long == paramLong3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChatRoomInfo)) {}
    do
    {
      return false;
      paramObject = (ChatRoomInfo)paramObject;
    } while ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long != paramObject.jdField_b_of_type_Long) || (this.jdField_c_of_type_Long != paramObject.jdField_c_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ChatRoomInfo{");
    localStringBuilder.append("type: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", roomID: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", id: ").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", createTime: ").append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", isFromSwitchTerminal: ").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", preRoomId: ").append(this.jdField_d_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomInfo
 * JD-Core Version:    0.7.0.1
 */