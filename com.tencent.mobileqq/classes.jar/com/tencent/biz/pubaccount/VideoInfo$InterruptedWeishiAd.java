package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import lbs;

public class VideoInfo$InterruptedWeishiAd
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new lbs();
  public int a;
  public String a;
  public boolean a;
  public int[] a;
  public boolean b;
  
  public VideoInfo$InterruptedWeishiAd()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public VideoInfo$InterruptedWeishiAd(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = paramParcel.createIntArray();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "InterruptedWeishiAd{showPositon=" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ", isShowInSwitch=" + this.jdField_a_of_type_Boolean + ", isShowInPlayEnd=" + this.b + ", showAfterPlayTime=" + this.jdField_a_of_type_Int + ", adUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.b) {
        break label62;
      }
    }
    label62:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd
 * JD-Core Version:    0.7.0.1
 */