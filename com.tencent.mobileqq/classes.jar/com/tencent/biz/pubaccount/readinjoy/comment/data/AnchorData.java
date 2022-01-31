package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import oid;

public class AnchorData
  implements Parcelable
{
  public static final Parcelable.Creator<AnchorData> CREATOR = new oid();
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public AnchorData()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label54;
      }
    }
    label54:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
 * JD-Core Version:    0.7.0.1
 */