package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class SearchResultItem
  implements Parcelable
{
  public static final Parcelable.Creator<SearchResultItem> CREATOR = new SearchResultItem.1();
  public byte a;
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public byte b;
  public String b;
  public byte[] b;
  public byte c = 0;
  
  public SearchResultItem()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  protected SearchResultItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Byte = paramParcel.readByte();
    this.jdField_b_of_type_Byte = paramParcel.readByte();
    this.c = paramParcel.readByte();
    this.jdField_a_of_type_ArrayOfByte = paramParcel.createByteArray();
    this.jdField_b_of_type_ArrayOfByte = paramParcel.createByteArray();
  }
  
  public SearchResultItem(AccountSearchPb.record paramrecord)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Byte = 0;
    this.jdField_b_of_type_Byte = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    if (paramrecord != null)
    {
      this.jdField_a_of_type_Long = paramrecord.uin.get();
      this.jdField_a_of_type_Int = paramrecord.source.get();
      this.jdField_a_of_type_JavaLangString = paramrecord.name.get();
      this.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
      this.jdField_a_of_type_Byte = ((byte)(int)(paramrecord.relation.get() & 1L));
      this.jdField_b_of_type_Byte = ((byte)(int)(paramrecord.relation.get() & 0x2));
      this.jdField_b_of_type_ArrayOfByte = paramrecord.bytes_token.get().toByteArray();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
    paramParcel.writeByte(this.jdField_b_of_type_Byte);
    paramParcel.writeByte(this.c);
    paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    paramParcel.writeByteArray(this.jdField_b_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem
 * JD-Core Version:    0.7.0.1
 */