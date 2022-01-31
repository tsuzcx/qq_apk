package com.tencent.mobileqq.app.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import zwx;

public class DingdongPluginBizObserver$TempLiteMailIndexInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new zwx();
  public int a;
  public long a;
  public String a;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.TempLiteMailIndexInfo
 * JD-Core Version:    0.7.0.1
 */