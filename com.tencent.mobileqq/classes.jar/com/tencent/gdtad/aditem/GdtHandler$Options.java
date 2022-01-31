package com.tencent.gdtad.aditem;

import aamy;
import aase;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class GdtHandler$Options
  implements Parcelable
{
  public static final Parcelable.Creator<Options> CREATOR = new aamy();
  public int a;
  public long a;
  public Rect a;
  public Bundle a;
  public GdtAd a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  private boolean g;
  
  public GdtHandler$Options()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
  }
  
  public GdtHandler$Options(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = -2147483648;
    if (paramParcel == null)
    {
      aase.d("GdtHandler", "Options(Parcel in) error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)paramParcel.readParcelable(GdtAd.class.getClassLoader()));
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label211;
      }
      bool1 = true;
      label90:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label216;
      }
      bool1 = true;
      label104:
      this.c = bool1;
      if (paramParcel.readByte() == 0) {
        break label221;
      }
      bool1 = true;
      label118:
      this.d = bool1;
      if (paramParcel.readByte() == 0) {
        break label226;
      }
      bool1 = true;
      label132:
      this.e = bool1;
      this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label231;
      }
      bool1 = true;
      label162:
      this.g = bool1;
      this.jdField_a_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label236;
      }
    }
    label211:
    label216:
    label221:
    label226:
    label231:
    label236:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.f = bool1;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label90;
      bool1 = false;
      break label104;
      bool1 = false;
      break label118;
      bool1 = false;
      break label132;
      bool1 = false;
      break label162;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isValid()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForClick())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForEffect())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    if (paramParcel == null)
    {
      aase.d("GdtHandler", "writeToParcel error");
      return;
    }
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramInt);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label185;
      }
      i = 1;
      label64:
      paramParcel.writeByte((byte)i);
      if (!this.c) {
        break label190;
      }
      i = 1;
      label79:
      paramParcel.writeByte((byte)i);
      if (!this.d) {
        break label195;
      }
      i = 1;
      label94:
      paramParcel.writeByte((byte)i);
      if (!this.e) {
        break label200;
      }
      i = 1;
      label109:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRect, paramInt);
      if (!this.g) {
        break label205;
      }
      paramInt = 1;
      label133:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      if (!this.f) {
        break label210;
      }
    }
    label185:
    label190:
    label195:
    label200:
    label205:
    label210:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      return;
      i = 0;
      break;
      i = 0;
      break label64;
      i = 0;
      break label79;
      i = 0;
      break label94;
      i = 0;
      break label109;
      paramInt = 0;
      break label133;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Options
 * JD-Core Version:    0.7.0.1
 */