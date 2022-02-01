package com.tencent.biz.qrcode.activity;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import zjw;

public class QMiniResult
  implements Parcelable
{
  public static final Parcelable.Creator<QMiniResult> CREATOR = new zjw();
  public float a;
  public RectF a;
  public String a;
  
  public QMiniResult() {}
  
  public QMiniResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "QMiniResult{prob=" + this.jdField_a_of_type_Float + ", data='" + this.jdField_a_of_type_JavaLangString + '\'' + ", location=" + this.jdField_a_of_type_AndroidGraphicsRectF + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRectF, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QMiniResult
 * JD-Core Version:    0.7.0.1
 */