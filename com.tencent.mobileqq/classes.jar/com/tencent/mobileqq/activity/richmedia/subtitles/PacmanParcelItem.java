package com.tencent.mobileqq.activity.richmedia.subtitles;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import xst;

public class PacmanParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new xst();
  public float a;
  public int a;
  public int b;
  
  public PacmanParcelItem() {}
  
  public PacmanParcelItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.PacmanParcelItem
 * JD-Core Version:    0.7.0.1
 */