package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public class PasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<PasterParcelData> CREATOR = new PasterParcelData.1();
  public static int a = 1;
  public static int b = 2;
  public float a;
  public PointF a;
  public RectF a;
  public SegmentKeeper a;
  public String a;
  public float b;
  public String b;
  public float c;
  public int c;
  public String c;
  public float d;
  public int d;
  public String d;
  public float e;
  public int e;
  public String e;
  public float f;
  public int f;
  public String f;
  public int g;
  
  protected PasterParcelData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_AndroidGraphicsPointF = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
    this.jdField_c_of_type_Float = paramParcel.readFloat();
    this.jdField_d_of_type_Float = paramParcel.readFloat();
    this.jdField_e_of_type_Float = paramParcel.readFloat();
    this.jdField_f_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @TargetApi(13)
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsPointF, 0);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    paramParcel.writeFloat(this.jdField_c_of_type_Float);
    paramParcel.writeFloat(this.jdField_d_of_type_Float);
    paramParcel.writeFloat(this.jdField_e_of_type_Float);
    paramParcel.writeFloat(this.jdField_f_of_type_Float);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRectF, 0);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData
 * JD-Core Version:    0.7.0.1
 */