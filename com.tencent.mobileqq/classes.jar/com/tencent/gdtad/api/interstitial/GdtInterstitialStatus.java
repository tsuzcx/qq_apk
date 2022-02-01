package com.tencent.gdtad.api.interstitial;

import abmt;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class GdtInterstitialStatus
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialStatus> CREATOR = new abmt();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  long b;
  public boolean b;
  public int c;
  long c;
  public boolean c;
  public int d;
  long d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  
  public GdtInterstitialStatus()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = -2147483648;
    this.jdField_e_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Long = -2147483648L;
    this.jdField_c_of_type_Long = -2147483648L;
    this.jdField_d_of_type_Long = -2147483648L;
  }
  
  public GdtInterstitialStatus(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -2147483648;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = -2147483648;
    this.jdField_e_of_type_Int = -2147483648;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Long = -2147483648L;
    this.jdField_c_of_type_Long = -2147483648L;
    this.jdField_d_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label246;
      }
      bool1 = true;
      label107:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label251;
      }
      bool1 = true;
      label121:
      this.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label256;
      }
      bool1 = true;
      label135:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label261;
      }
      bool1 = true;
      label149:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label266;
      }
    }
    label256:
    label261:
    label266:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      return;
      bool1 = false;
      break;
      label246:
      bool1 = false;
      break label107;
      label251:
      bool1 = false;
      break label121;
      bool1 = false;
      break label135;
      bool1 = false;
      break label149;
    }
  }
  
  public long a()
  {
    long l = -2147483648L;
    if (this.jdField_b_of_type_Long != -2147483648L) {
      l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    }
    return l;
  }
  
  public long b()
  {
    long l2 = -2147483648L;
    long l1 = l2;
    if (this.jdField_c_of_type_Long != -2147483648L)
    {
      l1 = l2;
      if (this.jdField_d_of_type_Long != -2147483648L) {
        l1 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
      }
    }
    return l1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label186;
      }
      paramInt = 1;
      label42:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label191;
      }
      paramInt = 1;
      label57:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_d_of_type_Boolean) {
        break label196;
      }
      paramInt = 1;
      label72:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label201;
      }
      paramInt = 1;
      label87:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label206;
      }
    }
    label186:
    label191:
    label196:
    label201:
    label206:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label42;
      paramInt = 0;
      break label57;
      paramInt = 0;
      break label72;
      paramInt = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialStatus
 * JD-Core Version:    0.7.0.1
 */