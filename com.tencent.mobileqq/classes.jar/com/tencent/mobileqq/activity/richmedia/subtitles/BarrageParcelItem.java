package com.tencent.mobileqq.activity.richmedia.subtitles;

import almv;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BarrageParcelItem
  implements Parcelable
{
  public static final Parcelable.Creator<BarrageParcelItem> CREATOR = new almv();
  public float a;
  public int a;
  public int b;
  public int c;
  
  public BarrageParcelItem() {}
  
  public BarrageParcelItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
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
    paramParcel.writeInt(this.c);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.BarrageParcelItem
 * JD-Core Version:    0.7.0.1
 */