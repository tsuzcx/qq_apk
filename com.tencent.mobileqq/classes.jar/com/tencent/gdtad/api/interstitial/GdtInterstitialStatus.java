package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class GdtInterstitialStatus
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
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label223;
      }
      bool1 = true;
      label108:
      this.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label228;
      }
      bool1 = true;
      label122:
      this.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label233;
      }
      bool1 = true;
      label136:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label238;
      }
      bool1 = true;
      label150:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label243;
      }
    }
    label223:
    label228:
    label233:
    label238:
    label243:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label108;
      bool1 = false;
      break label122;
      bool1 = false;
      break label136;
      bool1 = false;
      break label150;
    }
  }
  
  public long a()
  {
    long l = -2147483648L;
    if (this.jdField_a_of_type_Long != -2147483648L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label154;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label159;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_d_of_type_Boolean) {
        break label164;
      }
      paramInt = 1;
      label64:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label169;
      }
      paramInt = 1;
      label79:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label174;
      }
    }
    label154:
    label159:
    label164:
    label169:
    label174:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label34;
      paramInt = 0;
      break label49;
      paramInt = 0;
      break label64;
      paramInt = 0;
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialStatus
 * JD-Core Version:    0.7.0.1
 */