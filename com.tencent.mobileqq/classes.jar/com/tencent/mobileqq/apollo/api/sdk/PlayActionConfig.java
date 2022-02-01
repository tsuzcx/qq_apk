package com.tencent.mobileqq.apollo.api.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PlayActionConfig
  implements Parcelable
{
  public static final Parcelable.Creator<PlayActionConfig> CREATOR = new PlayActionConfig.1();
  public int a;
  public Bundle a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public PlayActionConfig() {}
  
  protected PlayActionConfig(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label72;
      }
    }
    label72:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      this.c = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Int + "_" + this.jdField_a_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PlayActionConfig{");
    localStringBuffer.append("mUin='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mActionId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mActionSeqId=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mLoop=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", mNeedRestore=").append(this.jdField_b_of_type_Boolean);
    localStringBuffer.append(", mPlayFragment=").append(this.c);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label70;
      }
    }
    label70:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.c);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig
 * JD-Core Version:    0.7.0.1
 */