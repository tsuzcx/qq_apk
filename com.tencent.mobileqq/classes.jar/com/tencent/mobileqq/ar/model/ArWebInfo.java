package com.tencent.mobileqq.ar.model;

import aaky;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArWebInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aaky();
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public ArWebInfo() {}
  
  public ArWebInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArWebInfo{");
    localStringBuffer.append("isUrlAutoJump='").append(this.jdField_a_of_type_Boolean).append('\'');
    localStringBuffer.append(", isUrlTransparent=").append(this.jdField_b_of_type_Boolean).append('\'');
    localStringBuffer.append(", webJumpUrl=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", htmlOfflineBid=").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.jdField_b_of_type_Boolean) {
        break label54;
      }
    }
    label54:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArWebInfo
 * JD-Core Version:    0.7.0.1
 */