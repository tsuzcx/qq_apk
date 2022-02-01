package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class GdtInterstitialStatus
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialStatus> CREATOR = new GdtInterstitialStatus.1();
  public int a;
  long a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  
  public GdtInterstitialStatus()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = -2147483648;
    this.jdField_e_of_type_Int = -2147483648;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  protected GdtInterstitialStatus(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = -2147483648;
    this.jdField_e_of_type_Int = -2147483648;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_e_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_f_of_type_Boolean = bool1;
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
  }
  
  public long a()
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = -2147483648L;
    if (l2 != -2147483648L) {
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    return l1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_d_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_e_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_f_of_type_Boolean);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialStatus
 * JD-Core Version:    0.7.0.1
 */