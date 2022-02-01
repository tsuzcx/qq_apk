package com.tencent.mobileqq.activity.contact.addfriendverifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AddFriendBlockedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AddFriendBlockedInfo> CREATOR = new AddFriendBlockedInfo.1();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public AddFriendBlockedInfo() {}
  
  protected AddFriendBlockedInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AddFriendBlockedInfo {, friendUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", friendNick='" + this.jdField_b_of_type_JavaLangString + '\'' + ", age='" + this.jdField_a_of_type_Int + '\'' + ", sex='" + this.jdField_b_of_type_Int + '\'' + ", sourceDsp='" + this.jdField_c_of_type_JavaLangString + '\'' + ", blockTime='" + this.jdField_a_of_type_Long + '\'' + ", isRead='" + this.jdField_a_of_type_Boolean + '\'' + ", commFriends='" + this.jdField_c_of_type_Int + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo
 * JD-Core Version:    0.7.0.1
 */