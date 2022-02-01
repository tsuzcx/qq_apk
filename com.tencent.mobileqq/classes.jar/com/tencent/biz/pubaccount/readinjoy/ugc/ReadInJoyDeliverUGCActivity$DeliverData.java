package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import rjw;

public class ReadInJoyDeliverUGCActivity$DeliverData
  implements Parcelable
{
  public static final Parcelable.Creator<DeliverData> CREATOR = new rjw();
  private static int jdField_a_of_type_Int = 9;
  private int[] jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[jdField_a_of_type_Int];
  private int[] jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
  private String[] jdField_b_of_type_ArrayOfJavaLangString = new String[jdField_a_of_type_Int];
  
  public ReadInJoyDeliverUGCActivity$DeliverData() {}
  
  public ReadInJoyDeliverUGCActivity$DeliverData(Parcel paramParcel)
  {
    if (paramParcel.readInt() > 0) {
      paramParcel.readIntArray(this.jdField_a_of_type_ArrayOfInt);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readIntArray(this.jdField_b_of_type_ArrayOfInt);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readStringArray(this.jdField_b_of_type_ArrayOfJavaLangString);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[jdField_a_of_type_Int];
  }
  
  public void a(int paramInt, Integer paramInteger)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    }
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b(int paramInt, Integer paramInteger)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_b_of_type_ArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (paramInt < jdField_a_of_type_Int) {
      this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    }
  }
  
  public int[] b()
  {
    return this.jdField_b_of_type_ArrayOfInt;
  }
  
  public String[] b()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      paramParcel.writeInt(this.jdField_a_of_type_ArrayOfInt.length);
      paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
      if ((this.jdField_b_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_ArrayOfInt.length <= 0)) {
        break label137;
      }
      paramParcel.writeInt(this.jdField_b_of_type_ArrayOfInt.length);
      paramParcel.writeIntArray(this.jdField_b_of_type_ArrayOfInt);
      label64:
      if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0)) {
        break label145;
      }
      paramParcel.writeInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      paramParcel.writeStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_ArrayOfJavaLangString == null) || (this.jdField_b_of_type_ArrayOfJavaLangString.length <= 0)) {
        break label153;
      }
      paramParcel.writeInt(this.jdField_b_of_type_ArrayOfJavaLangString.length);
      paramParcel.writeStringArray(this.jdField_b_of_type_ArrayOfJavaLangString);
      return;
      paramParcel.writeInt(0);
      break;
      label137:
      paramParcel.writeInt(0);
      break label64;
      label145:
      paramParcel.writeInt(0);
    }
    label153:
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.DeliverData
 * JD-Core Version:    0.7.0.1
 */